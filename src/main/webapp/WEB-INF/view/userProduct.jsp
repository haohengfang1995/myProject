<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
<link rel="stylesheet" href="/css/buttons.css">
</head>
<body>
	<div class="pure-form">
		<fieldset>
			<legend>商品列表</legend>
			<table class="pure-table pure-table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>名稱</th>
						<th>價格</th>
						<th>數量</th>
						<th>上架日期</th>
						<th>地點</th>
						<th>查看</th>
						<th>刪除</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="productDto" items="${ productDtos }">
						<tr>
							<td>${ productDto.productId }</td>
							<td>${ productDto.productName }</td>
							<td>${ productDto.productPrice}</td>
							<td>${ productDto.productNum }</td>
							<td><fmt:formatDate value="${ productDto.productDate }"
									pattern="yyyy-MM-dd" /></td>
							<td>${ productDto.productPlace}</td>
							<td><a class="button-error pure-button"
								href="/product/detail/${ productDto.productId }">查看</a></td>
							<td><a class="button-error pure-button"
								href="/product/delete/${ productDto.productId }">刪除</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</fieldset>
	</div>
</body>
</html>