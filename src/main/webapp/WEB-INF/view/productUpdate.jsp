<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>修改商品</title>
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
        <h2 class="text-center text-primary mb-4">修改商品資料</h2>
        <div class="card shadow">
            <div class="card-body">
                <form:form class="row g-3" modelAttribute="productDto" method="post" action="/product/update">
                    <!-- 隱藏欄位 -->
                    <form:input path="productId" id="productId" type="hidden" />
                    
                    <!-- 商品圖片 -->
                    <div class="text-center mb-3">
                        <img alt="photo" src="/uploads/${productDto.productPhoto}" class="img-thumbnail" style="max-width: 200px;">
                    </div>

                    <!-- 商品名稱 -->
                    <div class="col-md-6">
                        <label for="productName" class="form-label">商品名稱:</label>
                        <form:input path="productName" id="productName" class="form-control" />
                    </div>

                    <!-- 商品敘述 -->
                    <div class="col-md-12">
                        <label for="productNarrate" class="form-label">商品敘述:</label>
                        <form:textarea path="productNarrate" id="productNarrate" class="form-control" rows="4" />
                    </div>

                    <!-- 數量 -->
                    <div class="col-md-4">
                        <label for="productNum" class="form-label">數量:</label>
                        <form:input path="productNum" id="productNum" class="form-control" />
                    </div>

                    <!-- 價格 -->
                    <div class="col-md-4">
                        <label for="productPrice" class="form-label">價格:</label>
                        <form:input path="productPrice" id="productPrice" class="form-control" />
                    </div>

                    <!-- 地點 -->
                    <div class="col-md-4">
                        <label for="productPlace" class="form-label">地點:</label>
                        <form:input path="productPlace" id="productPlace" class="form-control" />
                    </div>

                    <!-- 偶像名稱 -->
                    <div class="col-md-6">
                        <label for="idolName" class="form-label">偶像名稱:</label>
                        <form:input path="idolName" id="idolName" class="form-control" />
                    </div>

                    <!-- 商品種類 -->
                    <div class="col-md-6">
                        <label for="productType" class="form-label">商品種類:</label>
                        <form:input path="productType" id="productType" class="form-control" />
                    </div>

                    <!-- 標籤 -->
                    <div class="col-md-6">
                        <label for="tag" class="form-label">標籤:</label>
                        <form:input path="tag" id="tag" class="form-control" />
                    </div>

                    <!-- 修改按鈕 -->
                    <div class="col-12 text-center">
                        <button type="submit" class="btn btn-primary w-50">修改</button>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>