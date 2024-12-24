<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>商品列表</title>
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
        <h1 class="text-center text-primary mb-4">個人商品列表</h1>
        <div class="card">
            <div class="card-body">
                <table class="table table-bordered table-hover align-middle">
                    <thead class="table-primary">
                        <tr class="text-center">
                            <th>ID</th>
                            <th>名稱</th>
                            <th>價格</th>
                            <th>數量</th>
                            <th>上架日期</th>
                            <th>地點</th>
                            <th>修改</th>
                            <th>刪除</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="productDto" items="${productDtos}">
                            <tr class="text-center">
                                <td>${productDto.productId}</td>
                                <td>${productDto.productName}</td>
                                <td>${productDto.productPrice}</td>
                                <td>${productDto.productNum}</td>
                                <td>
                                    <fmt:formatDate value="${productDto.productDate}" pattern="yyyy-MM-dd" />
                                </td>
                                <td>${productDto.productPlace}</td>
                                <td>
                                    <a class="btn btn-primary btn-sm" href="/product/detail/${productDto.productId}">查看</a>
                                </td>
                                <td>
                                    <a class="btn btn-danger btn-sm" href="/product/delete/${productDto.productId}">刪除</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>