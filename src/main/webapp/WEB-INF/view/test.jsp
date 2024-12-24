<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<meta charset="UTF-8">

<title>商品列表</title>
<link rel="stylesheet" href="styles.css">
<style type="text/css">
/* styles.css */
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
	background-color: #f0f0f0;
}

.container {
	max-width: 1200px;
	margin: 0 auto;
	padding: 20px;
	background-color: #fff;
}

h1 {
	text-align: center;
	margin-bottom: 20px;
	color: #333;
}

.product-grid {
	display: grid;
	grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
	gap: 20px;
}

.product-card {
	border: 1px solid #ddd;
	border-radius: 8px;
	overflow: hidden;
	background-color: #fff;
	text-align: center;
	box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
}

.product-card img {
	width: 100%;
	height: 150px;
	object-fit: cover;
}

.product-card h2 {
	font-size: 18px;
	color: #555;
	margin: 10px 0;
}

.product-card p {
	margin: 5px 0;
	color: #777;
}

.button-container {
	display: grid;
	grid-template-columns: repeat(2, auto); /* 每排 2 個按鈕 */
	gap: 20px; /* 按鈕之間的間距 */
	justify-content: center; /* 水平置中 */
}

.button-container button {
	width: 100px;
	height: 40px;
	font-size: 16px;
	border: none;
	border-radius: 5px;
	background-color: #007bff;
	color: white;
	cursor: pointer;
	transition: background-color 0.3s ease;
}

.button-container button:hover {
	background-color: #0056b3;
}
</style>
</head>
<body>
	<div class="container">
		<h1>現在可拍的甜點</h1>
		<div class="product-grid">
			<div class="product-card">
				<img src="cake1.jpg" alt="千層蛋糕">
				<h2>千層蛋糕</h2>
				<p>售價：120元</p>
				<p>熱度：79</p>
				<p>地區：台北市</p>
			</div>
			<div class="button-container">
				<button>按鈕 1</button>
				<button>按鈕 2</button>
				<button>按鈕 3</button>
				<button>按鈕 4</button>
				<button>按鈕 5</button>
				<button>按鈕 6</button>
			</div>
		</div>
		<%-- 		<div class="product-grid">
			<!-- 使用 c:forEach 從後端傳來的列表渲染商品 -->
			<c:forEach var="productDto" items="${productDtos}">
				<div>
					<img src="/uploads/${ productDto.productPhoto }" alt="productPhoto"
						width="100" height="100">
					<h2>${productDto.productName}</h2>
					<p>售價：${productDto.productPrice}元</p>
					<p>地區：${productDto.productPrice}</p>
					<p>數量：${productDto.productPrice}</p>
					<p>團體：${productDto.productPrice}</p>
					<p>類型：${productDto.productPrice}</p>
					<p>標籤：${productDto.productPrice}</p>
					<p>男/女團：${productDto.productPrice}</p>
					<p>上架日期：${productDto.productPrice}</p>
					<p>瞭解更多：${productDto.productPrice}</p>
				</div>
			</c:forEach>
		</div> --%>

		<div class="card" style="width: 18rem;">
			<img src="..." class="card-img-top" alt="...">
			<div class="card-body">
				<h5 class="card-title">Card title</h5>
				<p class="card-text">Some quick example text to build on the
					card title and make up the bulk of the card's content.</p>
			</div>
			<!-- 改用 div 代替 ul 和 li -->
<div id="loco" class="list-group list-group-flush container text-center mt-4">
  <div class="row mb-3">
    <div class="col-6 list-group-item">A</div>
    <div class="col-6 list-group-item">B</div>
  </div>
  <div class="row mb-3">
    <div class="col-6 list-group-item">C</div>
    <div class="col-6 list-group-item">D</div>
  </div>
  <div class="row mb-3">
    <div class="col-6 list-group-item">E</div>
    <div class="col-6 list-group-item">F</div>
  </div>
</div>
			<div class="card-body">
				<a href="#" class="card-link">Card link</a> <a href="#"
					class="card-link">Another link</a>
			</div>
		</div>
</body>
</html>
