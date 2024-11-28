package com.example.demo.mapper;

import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnError;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;


@ServerEndpoint(value = "/websocket/{username}")
@Component
public class MyWebSocket {
	
	//記錄當前在線連線數量
	private static int onlineCount = 0;
	
	private static Map<String, MyWebSocket> webSocketMap = new ConcurrentHashMap<>();
	
	private String username;
	
	private Session session;
	
	//獲得在線人數方法
	public static synchronized int getOnlineCount() {
		return onlineCount;
	}
	
	//增加在線人數方法
	public static synchronized void addOnlineCount() {
		MyWebSocket.onlineCount++;
	}
	
	//減少在線人數方法
	public static synchronized void subOnlineCount() {
		MyWebSocket.onlineCount--;
	}
	
	//點對點發送訊息
	public void sendMessage(String username, String message) throws IOException{
		//建構對象，保存到數據庫
		MyWebSocket webSocket = webSocketMap.get(username);
		webSocket.session.getBasicRemote().sendText(message);
	}
	//廣播發送訊息
	public void sendMessage(String message) throws IOException{
		//建構對象，保存到數據庫
		Set <String> keys = webSocketMap.keySet();
		
		//群發消息
		for(String key : keys) {
			MyWebSocket ws = webSocketMap.get(key);
			//返回數據
			ws.sendMessage(key, this.username + "說:  " + message);
		}
	}
	
	
	//建立連線成功的方法
	@OnOpen
	public void onOpen(@PathParam("username") String username, Session session) {
		this.session = session;
		this.username = username;
		//map key 是唯一的
		if(!webSocketMap.containsKey(username)) {
			addOnlineCount();
			//用戶名和當前用戶的websocktet 放進map
			webSocketMap.put(this.username,this);
			System.out.println("有新的連線加入！！！，當前人數為" + getOnlineCount() + webSocketMap + "-------" +username);
		}
	}
	
	//關閉連線成功的方法
	@OnClose
	public void onClose(@PathParam("username") String username, Session session) {
		webSocketMap.remove(username);
		subOnlineCount();	
		System.out.println("有人取消連線！！！，當前人數為" + getOnlineCount() + webSocketMap + "-------" +username);
	}
	//@param message 客戶端發過來的訊息
	@OnMessage
	public void onMessage(@PathParam("username") String username, String message, Session session) throws IOException{
//		sendMessage(username, message);
		sendMessage(message);
	}
	@OnError
	public void onError(Session session, Throwable error) {
		System.out.println("發生錯誤");
		error.printStackTrace();
		
	}
	
	
}
