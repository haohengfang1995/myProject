<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增商品</title>
<!-- 引入 Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
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
		<div class="card shadow-sm mx-auto" style="max-width: 600px;">
			<div class="card-header bg-primary text-white text-center">
				<h3>新增商品</h3>
			</div>
			<div class="card-body">
				<form method="post" action="/product/addproduct"
					enctype="multipart/form-data">
					<div class="mb-3">
						<label for="productName" class="form-label">商品名稱</label> <input
							type="text" id="productName" name="productName"
							class="form-control" placeholder="輸入商品名稱" required>
					</div>
					<div class="mb-3">
						<label for="productNarrate" class="form-label">商品敘述</label>
						<textarea id="productNarrate" name="productNarrate"
							class="form-control" rows="3" placeholder="輸入商品敘述"></textarea>
					</div>
					<div class="mb-3">
						<label for="productPhoto" class="form-label">商品照片</label> <input
							type="file" id="productPhoto" name="productPhoto"
							class="form-control">
					</div>
					<div class="mb-3">
    <div class="mt-3">
        <img id="photoPreview" src="" alt="預覽圖片" class="img-thumbnail" style="max-width: 100%; display: none;">
    </div>
</div>

<script>
    document.getElementById('productPhoto').addEventListener('change', function (event) {
        const fileInput = event.target;
        const previewImage = document.getElementById('photoPreview');

        // 確保文件被選擇
        if (fileInput.files && fileInput.files[0]) {
            const reader = new FileReader();
            reader.onload = function (e) {
                previewImage.src = e.target.result; // 設置圖片來源
                previewImage.style.display = 'block'; // 顯示圖片
            };
            reader.readAsDataURL(fileInput.files[0]); // 加載選中的文件
        } else {
            previewImage.style.display = 'none'; // 如果未選擇文件，隱藏圖片
        }
    });
</script>
					<div class="mb-3">
						<label for="productNum" class="form-label">數量</label> <input
							type="number" id="productNum" name="productNum"
							class="form-control" placeholder="輸入數量" required>
					</div>
					<div class="mb-3">
						<label for="productPrice" class="form-label">價格</label> <input
							type="text" id="productPrice" name="productPrice"
							class="form-control" placeholder="輸入價格" required>
					</div>
					<div class="mb-3">
						<label for="productPlace" class="form-label">地點</label> <input
							type="text" id="productPlace" name="productPlace"
							class="form-control" placeholder="輸入地點">
					</div>
					<div class="mb-3">
						<label for="gender" class="form-label">團別</label> <select
							id="gender" name="gender" class="form-select">
							<option value="男團">男團</option>
							<option value="女團">女團</option>
						</select>
					</div>
					<div class="mb-3">
						<label for="idolName" class="form-label">偶像名稱</label> <input
							type="text" id="idolName" name="idolName" class="form-control"
							placeholder="輸入偶像名稱">
					</div>
					<div class="mb-3">
						<label for="productType" class="form-label">商品種類</label> <input
							type="text" id="productType" name="productType"
							class="form-control" placeholder="輸入商品種類">
					</div>
					<div class="mb-3">
						<label for="tag" class="form-label">標籤</label> <input type="text"
							id="tag" name="tag" class="form-control" placeholder="輸入標籤">
					</div>
					<div class="text-center">
						<button type="submit" class="btn btn-primary w-100">新增</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- 引入 Bootstrap JS (可選) -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>