package com.example.demo.mapper;

import java.io.IOException;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.example.demo.model.dto.ChatDto;
import com.example.demo.model.dto.RoomDto;
import com.example.demo.service.Impl.ChatServiceImpl;
import com.example.demo.service.Impl.RoomServiceImpl;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnError;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;


@ServerEndpoint(value = "/websocket/{userId}/{roomId}")
@Component
public class Ws2 {
	
  
	private ChatServiceImpl chatServiceImpl;
	private RoomServiceImpl roomServiceImpl;
	
	public Ws2() {
        this.roomServiceImpl = SpringContextHolder.getBean(RoomServiceImpl.class);
        this.chatServiceImpl = SpringContextHolder.getBean(ChatServiceImpl.class);
    }
	
	//記錄當前在線連線數量
	private static int onlineCount = 0;
	
	//利用 房號和使用者 雙重key來找尋session
	private static Table<Integer, Integer, Ws2> webSocketMap = HashBasedTable.create();
	
	private Integer userId;
	
	private Integer roomId;
	
	private Session session;
	
	//獲得在線人數方法
	public static synchronized int getOnlineCount() {
		return onlineCount;
	}
	
	//增加在線人數方法
	public static synchronized void addOnlineCount() {
		Ws2.onlineCount++;
	}
	
	//減少在線人數方法
	public static synchronized void subOnlineCount() {
		Ws2.onlineCount--;
	}
	
	//房間內發送消息
	public void sendMessage(Integer buyUserId, Integer saleUserId, Integer roomId, String message) throws IOException{
		//建構對象，保存到數據庫
		Optional<Ws2> optBuy= Optional.ofNullable(webSocketMap.get(roomId, buyUserId));
		Optional<Ws2> optSale= Optional.ofNullable(webSocketMap.get(roomId, saleUserId));
		if(optBuy.isPresent()) {
			optBuy.get().session.getBasicRemote().sendText(message);
		}
		if(optSale.isPresent()) {
			optSale.get().session.getBasicRemote().sendText(message);
		}
	}
	//廣播發送訊息
//	public void sendMessage(String message) throws IOException{
//		//建構對象，保存到數據庫
//		Set <String> keys = webSocketMap.keySet();
//		
//		//群發消息
//		for(String key : keys) {
//			Ws ws = webSocketMap.get(key);
//			//返回數據
//			ws.sendMessage(key, this.username + "說:  " + message);
//		}
//	}
	
	
	//建立連線成功的方法
	@OnOpen
	public void onOpen(@PathParam("userId") Integer userId,@PathParam("roomId") Integer roomId, Session session) {
		this.userId = userId;
		this.session = session;
		this.roomId = roomId;
		//map key 是唯一的

			addOnlineCount();
			//用戶名和當前用戶的websocktet 放進map
			webSocketMap.put(this.roomId, this.userId, this);
			System.out.println("有新的連線加入！！！，當前人數為" + getOnlineCount() + webSocketMap + "-------" +userId);
		
	}
	
	//關閉連線成功的方法
	@OnClose
	public void onClose(@PathParam("userId") Integer userId, @PathParam("roomId") Integer roomId, Session session) {
		webSocketMap.remove(roomId, userId);
		subOnlineCount();	
		System.out.println("有人取消連線！！！，當前人數為" + getOnlineCount() + webSocketMap + "-------" +userId);
	}
	//@param message 客戶端發過來的訊息
	@OnMessage
	public void onMessage(@PathParam("roomId") Integer roomId, String message, Session session) throws IOException{
		RoomDto roomDto= roomServiceImpl.findRoomById(roomId);
		Integer buyUserId = roomDto.getBuyUserId();
		Integer saleUserId = roomDto.getSaleUserId();
		ChatDto chatDto = new ChatDto(message, roomId);
		chatServiceImpl.addChat(chatDto);
		sendMessage(buyUserId, saleUserId, roomId, message);
	}
	@OnError
	public void onError(Session session, Throwable error) {
		System.out.println("發生錯誤");
		error.printStackTrace();
		
	}
	
	
}
