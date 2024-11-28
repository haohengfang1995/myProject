<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Kpop</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
<link rel="stylesheet" href="/css/buttons.css">
</head>
<body>
	<div>
		<a href="/product/new">最新商品</a>
		<a href="/product/old">最舊商品</a>
		<a href="/product/high">價格高排序</a>
		<a href="/product/low">價格低排序</a>
		<a href="/room/buyorder">查看購買訂單</a>
		<a href="/room/saleorder">查看銷售訂單</a>
	</div>
	<div>
		<table class="pure-table pure-table-bordered">
			<thead>
				<tr>
					<!-- <th>圖片</th> -->
					<th>名稱</th>
					<th>價格</th>
					<th>數量</th>
					<th>上架日期</th>
					<th>地點</th>
					<th>偶像名稱</th>
					<th>團體</th>
					<th>種類</th>
					<th>標籤</th>
					<th>查看</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach var="productDto" items="${ productDtos }">
					<tr>
						<%-- <td data-label="商品圖片">${ user.userId }</td> --%>
						<td>${ productDto.productName }</td>
						<td>${ productDto.productPrice }</td>
						<td>${ productDto.productNum }</td>
						<td><fmt:formatDate value="${ productDto.productDate }"
								pattern="yyyy-MM-dd" /></td>
						<td><a href="/product/place/${ productDto.productPlace }">${ productDto.productPlace }</a></td>
						<td><a href="/product/idolname/${ productDto.idolName }">${ productDto.idolName }</a></td>
						<td><a href="/product/gender/${ productDto.gender }">${ productDto.gender }</a></td>
						<td><a href="/product/type/${ productDto.productType }">${ productDto.productType }</a></td>
						<td><a href="/product/tag/${ productDto.tag }">${ productDto.tag }</a></td>
						<td><a class="button-error pure-button"
							href="/product/productsolo/${ productDto.productId }">瞭解更多</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>