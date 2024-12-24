<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>聊天室</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script type="text/javascript">
        let userName = "${userName}";
        console.log(userName);
        let userId = "${userId}";
        let roomId = "${roomId}";
        let passKey = "${passKey}";
        console.log(passKey);
        console.log("PassKey length:", passKey.length);

        let websocket = new WebSocket("wss://localhost:9090/websocket/" + userId + "/" + roomId);

        websocket.onerror = function () {
            setMessageInnerHTML("連結發生錯誤");
        };

        websocket.onmessage = function (event) {
            setMessageInnerHTML(event.data);
        };

        websocket.onclose = function () {
            setMessageInnerHTML("已斷開連結");
        };

        window.closeWebSocket = function () {
            if (confirm('確定要關閉窗口嗎？')) {
                websocket.close();
            }
        };
        
        async function generateKey(passkey) {
            // 将 passkey 转换为字节数组
            const encoder = new TextEncoder();
            const keyData = encoder.encode(passkey);  // passkey 应为一个 256 位的字符串

            // 使用 Web Crypto API 导入密钥
            return await crypto.subtle.importKey(
                "raw",  // 原始密钥格式
                keyData,
                { name: "AES-CBC" }, // 使用 AES-CBC 模式
                false, // 不进行密钥导出
                ["encrypt", "decrypt"] // 密钥用于加密和解密
            );
        }
        //產生128位的iv
        function generateIV() {
            return crypto.getRandomValues(new Uint8Array(16));  // 128-bit IV
        }
        
        async function encryptData(passkey, plaintext) {
            // 生成 AES 密钥
            const key = await generateKey(passkey);

            // 生成随机的 IV
            const iv = generateIV();

            // 将明文转换为字节数组
            const encoder = new TextEncoder();
            const encodedMessage = encoder.encode(plaintext);

            // 使用 AES-CBC 模式加密数据
            const encryptedData = await crypto.subtle.encrypt(
                {
                    name: "AES-CBC",
                    iv: iv,  // 使用生成的 IV
                },
                key,  // 後端傳遞的aes金鑰
                encodedMessage  // 明文
            );

            // 返回加密後訊息 和 iv
            return { encryptedData, iv };
        }
        
        function arrayBufferToBase64(buffer) {
            const uint8Array = new Uint8Array(buffer);
            let binary = '';
            uint8Array.forEach(byte => {
                binary += String.fromCharCode(byte);
            });
            return btoa(binary);  // 使用 btoa 函数将二进制数据转换为 Base64 字符串
        }

        
        async function encryptAndConvertToJSON(passkey, plaintext) {
            const { encryptedData, iv } = await encryptData(passkey, plaintext);

            // 将 encryptedData 和 iv 转换为 Base64 字符串
            const encryptedBase64 = arrayBufferToBase64(encryptedData);
            const ivBase64 = arrayBufferToBase64(iv);

            // 封装成 JSON 对象
            const jsonData = JSON.stringify({
                encryptedData: encryptedBase64,
                iv: ivBase64
            });

            console.log(ivBase64);
            console.log(encryptedBase64);
            return jsonData;
        }
        
        function setMessageInnerHTML(innerHTML) {
            document.getElementById("message").innerHTML +=
                "<div style='text-align: left;'>" + innerHTML + "</div>";
        }

        async function send() {
            let message = document.getElementById("text").value;
            let formattedMessage = userName + ": " + message;

            try {
                // 等待加密并获取 jsonData
                const jsonData = await encryptAndConvertToJSON(passKey, formattedMessage);

                // 发送加密后的数据
                websocket.send(jsonData);
            } catch (error) {
                console.error("Encryption failed:", error); // 处理加密过程中的错误
            }

            document.getElementById("text").value = "";
        }
        
        
    </script>
</head>
<body class="bg-light">
	<nav class="navbar navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="/product">FanBuy</a>
			<div class="d-flex justify-content-end align-items-center"
				style="gap: 10px;">
				<div class="dropdown">
					<button class="btn btn-sm btn-outline-secondary dropdown-toggle"
						type="button" id="dropdownMenuButton" data-bs-toggle="dropdown"
						aria-expanded="false">價格高低排序</button>
					<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
						<li><a class="dropdown-item" href="/product/high">價格高到低</a></li>
						<li><a class="dropdown-item" href="/product/low">價格低到高</a></li>
					</ul>
				</div>
				<div class="dropdown">
					<button class="btn btn-sm btn-outline-secondary dropdown-toggle"
						type="button" id="dropdownMenuButton" data-bs-toggle="dropdown"
						aria-expanded="false">上架時間排序</button>
					<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
						<li><a class="dropdown-item" href="/product/new">上架時間新到舊</a></li>
						<li><a class="dropdown-item" href="/product/old">上架時間舊到新</a></li>
					</ul>
				</div>
				<button class="btn btn-sm btn-outline-secondary" type="button"
					onclick="window.location.href='/add'">註冊會員</button>
				<a class="btn btn-sm btn-outline-secondary" href="/login"
					role="button">登入</a>
				<button class="btn btn-sm btn-outline-secondary" type="button"
					onclick="if(confirm('確定要登出嗎?')) location.href='/singout'">登出</button>
				<form class="d-flex" action="/product/search" method="get">
					<input class="form-control me-2" type="search" placeholder="輸入關鍵字"
						aria-label="Search" name="search">
					<button class="btn btn-outline-success" type="submit">搜尋</button>
				</form>
			</div>
		</div>
	</nav>
	<div class="container mt-5">
		<h2 class="text-center text-primary mb-4">聊天室</h2>
		<div>
			商品名稱:${roomDto.productName}<br> 價格:${roomDto.productPrice}元<br>
			地點:${roomDto.productPlace}
		</div>
		<div class="card shadow">
			<div class="card-body">
				<!-- 聊天歷史訊息 -->
				<div id="message" class="mb-3"
					style="height: 300px; overflow-y: auto; border: 1px solid #ddd; padding: 10px; background: #f8f9fa;">
					<c:forEach items="${messages}" var="message">
						<p>${message}</p>
					</c:forEach>
				</div>

				<!-- 輸入區域 -->
				<div class="input-group">
					<input type="text" id="text" class="form-control"
						placeholder="輸入訊息...">
					<button class="btn btn-primary" onclick="send()">發送</button>
				</div>
			</div>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>