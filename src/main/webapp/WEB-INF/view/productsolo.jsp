<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<title>${ userDto.userName }</title>
<style>
  body {
    font-family: Arial, sans-serif;
    background-color: #f9f9f9;
    color: #333;
    margin: 20px;
  }
  h2 {
    text-align: center;
    color: #007BFF;
  }
  img {
    display: block;
    margin: 20px auto;
    border-radius: 10px;
  }
  .product-details {
    max-width: 400px;
    margin: auto;
    padding: 20px;
    background-color: #fff;
    border: 1px solid #ddd;
    border-radius: 5px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  }
  .product-details ul {
    list-style: none;
    padding: 0;
  }
  .product-details li {
    margin-bottom: 15px;
  }
  .product-details a {
    text-decoration: none;
    color: white;
    background-color: #007BFF;
    padding: 10px 15px;
    border-radius: 5px;
    display: inline-block;
    text-align: center;
  }
  .product-details a:hover {
    background-color: #0056b3;
  }
</style>
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
		<h2 class="text-center text-primary">${userDto.userName}</h2>
		<div class="text-center my-3">
			<img alt="photo" src="/uploads/${productDto.productPhoto}" class="img-thumbnail" style="width: 200px; height: auto;">
		</div>
		<div class="card mx-auto" style="max-width: 400px;">
			<div class="card-body">
				<ul class="list-unstyled">
					<li><strong>商品名稱:</strong> ${productDto.productName}</li>
					<li><strong>商品敘述:</strong> ${productDto.productNarrate}</li>
					<li><strong>數量:</strong> ${productDto.productNum}</li>
					<li><strong>地點:</strong> ${productDto.productPlace}</li>
					<li><strong>種類:</strong> ${productDto.productType}</li>
				</ul>
				<button class="btn btn-primary w-100" 
					onclick="if(confirm('確定建立訂單嗎?')) location.href='/room/add/${productDto.productId}'">
					建立訂單
				</button>
			</div>
		</div>
	</div>
</body>
</html>