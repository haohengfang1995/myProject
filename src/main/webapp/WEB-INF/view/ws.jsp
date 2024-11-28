<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script type="text/javascript">
			let userId = "${ userId }";
			let roomId = "${ roomId }";
			let websocket = new WebSocket("ws://localhost:9090/websocket/" + roomId);
			
			websocket.onerror = function(){
				setMessageInnerHTML("error");
			}
			
		
			
			websocket.onmessage = function(event){
				setMessageInnerHTML(event.data);
			}
			
			websocket.onclose = function(){
				setMessageInnerHTML("斷開連結");
			}
			
			window.closeWebSocket = function(){
				if(confirm('確定關閉窗口嗎')){
					websocket.close();
				}
			}
			
			function setMessageInnerHTML(innerHTML){
				console.log(innerHTML.indexOf(userId) + "------kk");
				if(innerHTML.indexOf(userId)){
					document.getElementById("message").innerHTML+="<div style = 'text-align: left;width:100%;'>" + innerHTML + "</div>";
				}else{
					document.getElementById("message").innerHTML+="<div style = 'text-align: right;width:100%;'>" + innerHTML + "</div>";
				}
			}
			
			function send(){
				let message = document.getElementById("text").value;
				websocket.send(message);
				document.getElementById("text").value="";
			}
			
		</script>
	</head>
	<body>
		<input type="text" id="text"/>
		<button onclick="send()">發送</button>
		<button onclick="closeWebSocket()"> 關閉連結</button>
		<div id="message"></div>
	</body>
</html>