<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改商品</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
<link rel="stylesheet" href="/css/buttons.css">
</head>
<body>
	<div>
		<h2>商品資料</h2>
		<form:form class="pure-form" modelAttribute="productDto" method="post" action="/product/update">
			<fieldset>

				<form:input path="productId" id="productId" type="hidden" />
				<p />

				<label for="productName">商品名稱:</label>
				<form:input path="productName" id="productName"  />
				<p />

				<label for="productNarrate">商品敘述:</label>
				<form:textarea path="productNarrate" id="productNarrate" rows="5" cols="50"/>
				<p />

				<label for="productNum">數量:</label>
				<form:input path="productNum" id="productNum" />
				<p />

				<label for="productPrice">價格:</label>
				<form:input path="productPrice" id="productPrice" />
				<p />

				<label for="productPlace">地點:</label>
				<form:input path="productPlace" id="productPlace" />
				<p />
				
				<label for="idolName">偶像名稱:</label>
				<form:input path="idolName" id="idolName" />
				<p />
				
				<label for="productType">商品種類:</label>
				<form:input path="productType" id="productType" />
				<p />
				
				<label for="tag">標籤:</label>
				<form:input path="tag" id="tag" />
				<p />

				<button type="submit" class="pure-button pure-button-primary">修改</button>
			</fieldset>
		</form:form>
	</div>
</body>


</body>
</html>