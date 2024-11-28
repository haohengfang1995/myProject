<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script type="text/javascript">
			let userName = "${ userName }";
			console.log(userName);
			let userId = "${ userId }";
			let roomId = "${ roomId }";
			let websocket = new WebSocket("ws://localhost:9090/websocket/" + userId + "/" + roomId);
			
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
					document.getElementById("message").innerHTML+="<div style = 'text-align: left;width:100%;'>" + innerHTML + "</div>";
			}
			
			function send(){
				let message = document.getElementById("text").value;
				let num = userName;
				let sum = userName + ": " + message; 
				websocket.send(sum);
				document.getElementById("text").value="";
			}
			
		</script>
	</head>
	<body>
		<input type="text" id="text"/>
		<button onclick="send()">發送</button>
		<button onclick="closeWebSocket()"> 關閉連結</button>
		<div id="message">
			<c:forEach items="${messages}" var="message">
            <p>${message}</p>
        </c:forEach>
		</div>
	</body>
</html>