<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>註冊會員</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
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
		<div class="card shadow-sm mx-auto" style="max-width: 600px;">
			<div class="card-header bg-primary text-white text-center">
				<h3>註冊會員</h3>
			</div>
			<div class="card-body">
				<form:form method="post" modelAttribute="userDto" action="/add/user">
					<div class="mb-3">
						<label for="userName" class="form-label">姓名</label>
						<form:input type="text" path="userName" id="userName" class="form-control" placeholder="輸入姓名" required="true" />
					</div>
					<div class="mb-3">
						<label for="userAccountNumber" class="form-label">帳號</label>
						<form:input type="text" path="userAccountNumber" id="userAccountNumber" class="form-control" placeholder="輸入帳號" required="true" />
					</div>
					<div class="mb-3">
						<label for="userPassword" class="form-label">密碼</label>
						<form:input type="password" path="userPassword" id="userPassword" class="form-control" placeholder="輸入密碼" required="true" />
					</div>
					<div class="mb-3">
						<label for="userPhone" class="form-label">電話</label>
						<form:input type="text" path="userPhone" id="userPhone" class="form-control" placeholder="輸入電話" required="true" />
					</div>
					<div class="mb-3">
						<label for="userDate" class="form-label">生日</label>
						<form:input type="date" path="userDate" id="userDate" class="form-control" required="true" />
					</div>

					<!-- 信箱欄位 -->
					<div class="mb-3">
						<label for="userEmail" class="form-label">信箱</label>
						<div class="input-group">
							<form:input type="email" path="userEmail" id="userEmail" name="userEmail" class="form-control" placeholder="輸入信箱" required="true" />
							<button type="button" class="btn btn-primary" id="sendEmailBtn">傳送驗證碼</button>
						</div>
					</div>

					<!-- 驗證碼欄位 -->
					<div class="mb-3">
						<label for="verificationCode" class="form-label">驗證碼</label>
						<input type="text" class="form-control" id="randomPassword" name = "randomPassword"placeholder="輸入驗證碼" required />
					</div>

					<div class="text-center">
						<button type="submit" class="btn btn-primary w-100">新增</button>
					</div>
				</form:form>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		function sendEmail() {
			// 獲取用戶輸入的信箱
			const email = document.getElementById('userEmail').value;

			// 簡單檢查信箱是否輸入
			if (!email) {
				alert("請輸入信箱！");
				return;
			}

			// 發送信箱到後端
			fetch('/mail', {
				method: 'POST',
				headers: {
					'Content-Type': 'application/json'
				},
				body: JSON.stringify({ userEmail: email })
			})
			.then(response => {
				if (response.ok) {
					alert("驗證碼已發送！");
				} else {
					alert("發送失敗，請稍後再試！");
				}
			})
			.catch(error => {
				console.error('Error:', error);
				alert("發送失敗，請稍後再試！");
			});
		}

		document.getElementById('sendEmailBtn').addEventListener('click', sendEmail);
	</script>
</body>
</html>
