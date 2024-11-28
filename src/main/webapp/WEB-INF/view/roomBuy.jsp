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
		<table class="pure-table pure-table-bordered">
			<thead>
				<tr>
					<!-- <th>圖片</th> -->
					<th>產品名稱</th>
					<th>金額</th>
					<th>地點</th>
					<th>訂單日期</th>
					<th>聊天</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="roomDto" items="${ roomDtos }">
					<tr>
						<%-- <td data-label="商品圖片">${ user.userId }</td> --%>
						<td>${ roomDto.productName }</td>
						<td>${ roomDto.productPrice }</td>
						<td>${ roomDto.productPlace }</td>
						<td><fmt:formatDate value="${ roomDto.roomDate }"
								pattern="yyyy-MM-dd" /></td>
						<td><a class="button-error pure-button"
							href="/room/order/${ roomDto.roomId }">開始聊天</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>