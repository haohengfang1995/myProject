<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>會員資訊</title>
    <!-- 引入 Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
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
        <div class="card mx-auto shadow-sm" style="max-width: 600px;">
            <div class="card-header bg-primary text-white text-center">
                <h3>會員資訊</h3>
            </div>
            <div class="card-body">
                <form:form modelAttribute="userDto">
                    <!-- 隱藏欄位 -->
                    <form:input path="userId" id="userId" type="hidden" />

                    <div class="mb-3">
                        <label for="userName" class="form-label">暱稱:</label>
                        <form:input path="userName" id="userName" class="form-control" readonly="true" />
                    </div>

                    <div class="mb-3">
                        <label for="userAccountNumber" class="form-label">帳號:</label>
                        <form:input path="userAccountNumber" id="userAccountNumber" class="form-control" readonly="true" />
                    </div>

                    <div class="mb-3">
                        <label for="userDate" class="form-label">生日:</label>
                        <form:input path="userDate" id="userDate" class="form-control" readonly="true" />
                    </div>

                    <div class="mb-3">
                        <label for="userEmail" class="form-label">信箱:</label>
                        <form:input path="userEmail" id="userEmail" type="email" class="form-control" />
                    </div>

                    <div class="mb-3">
                        <label for="userPhone" class="form-label">電話號碼:</label>
                        <form:input path="userPhone" id="userPhone" class="form-control" />
                    </div>

                    <div class="text-center">
                        <button type="submit" class="btn btn-primary w-100">修改</button>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
    <!-- 引入 Bootstrap JS (可選) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>