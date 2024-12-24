<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品列表</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
<link rel="stylesheet" href="/css/buttons.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
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
					<input class="form-control me-2" type="search" placeholder="輸入關聯字"
						aria-label="Search" name="search">
					<button class="btn btn-outline-success" type="submit">搜尋</button>
				</form>
			</div>
		</div>
	</nav>
	<div class="container text-center mt-4">
		<div class="row mb-3">
			<div class="col-6">
				<button onclick="window.location.href='/room/buyorder'"
					class="btn btn-outline-secondary btn-lg">查看購買訂單</button>
			</div>
			<div class="col-6">
				<button onclick="window.location.href='/room/saleorder'"
					class="btn btn-outline-secondary btn-lg">查看銷售訂單</button>
			</div>
		</div>
		<div class="row mb-3">
			<div class="col-6">
				<button onclick="window.location.href='/product/self'"
					class="btn btn-outline-secondary btn-lg">管理個人商品</button>
			</div>
			<div class="col-6">
				<button onclick="window.location.href='/product/add'"
					class="btn btn-outline-secondary btn-lg">新增商品</button>
			</div>
		</div>
		<div class="row mb-3">
			<div class="col-6">
				<button onclick="window.location.href='/user'"
					class="btn btn-outline-secondary btn-lg">個人資訊</button>
			</div>
			<div class="col-6">
				<button onclick="window.location.href='/user/update'"
					class="btn btn-outline-secondary btn-lg">變更密碼</button>
			</div>
		</div>
	</div>
	<div>


		<div style="display: flex; flex-wrap: wrap; gap: 1rem;">
			<c:forEach var="productDto" items="${productDtos}">
				<div class="card" style="width: 16rem;">
					<img src="/uploads/${productDto.productPhoto}" class="card-img-top"
						alt="photo" style="height: 150px; object-fit: cover;">
					<div class="card-body list-group" style="padding: 0.5rem;">
						<h5 class="card-title">${productDto.productName}</h5>
						<div class="d-flex justify-content-between">
							<span>價格: ${productDto.productPrice}</span> <span>數量:
								${productDto.productNum}</span>
						</div>
						<div class="d-flex justify-content-between">
							<span>地點: ${productDto.productPlace}</span> <span>團體:
								${productDto.idolName}</span>
						</div>
						<div class="d-flex justify-content-between">
							<span>類型: ${productDto.productType}</span> <span>標籤: <a
								href="/product/tag/${productDto.tag}" class="card-link">${productDto.tag}</a></span>
						</div>
					</div>
					<div class="card-body">
						上架時間:
						<fmt:formatDate value="${productDto.productDate}"
							pattern="yyyy/MM/dd" />
						<br> <a href="/product/productsolo/${productDto.productId}" class="btn btn-primary btn-sm">瞭解更多</a>
					</div>
				</div>
			</c:forEach>
		</div>
</body>
</html>