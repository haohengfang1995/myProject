<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${ userDto.userName }</title>
</head>
<body>
	<h2>${ userDto.userName }</h2>
	<ol>
		<li>
			<strong>商品名稱:</strong> ${ productDto.productName }
		</li>
		<li>
			<strong>商品敘述:</strong> ${ productDto.productNarrate }
		</li>
		<li>
			<strong>數量:</strong> ${ productDto.productNum }
		</li>
		<li>
			<strong>地點:</strong> ${ productDto.productNarrate }
		</li>
		<li>
			<strong>種類:</strong> ${ productDto.productType }
		</li>
		<li><a href="/room/add/${ productDto.productId }">建立訂單</a> </li> 
	</ol>

</body>
</html>