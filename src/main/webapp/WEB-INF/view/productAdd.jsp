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
</head>
<body>
	<div>
		<form:form class="pure-form" method="post" modelAttribute="productDto"
			action="/product/addproduct" enctype="multipart/form-data">
			<fieldset>
				<legend>新增商品</legend>
				商品名稱:
				<form:input type="text" path="productName" />
				<p />
				商品敘述:
				<form:textarea path="productNarrate"/>
				<p />
<%-- 				商品照片:
				<form:input type = "file" path="productPhoto"/>
				<p /> --%>
				數量:
				<form:input type="number" path="productNum" />
				<p />
				價格:
				<form:input type="text" path="productPrice" />
				<p />
				地點:
				<form:input type="text" path="productPlace" />
				<p />
				團別:
				<form:select path="gender">
					<form:option value="男團" label="男團" />
					<form:option value="女團" label="女團" />
				</form:select>
				<p />
				偶像名稱:
				<form:input type="text" path="idolName" />
				<p />
				商品種類:
				<form:input type="text" path="productType" />
				<p />
				標籤:
				<form:input type="text" path="tag" />
				<p />
				<button type="submit" class="pure-button pure-button-primary">新增</button>
			</fieldset>
		</form:form>
	</div>
</body>
</html>