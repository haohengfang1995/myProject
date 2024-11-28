<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
	<div>
		<form:form class="pure-form" method="post" modelAttribute="userDto"
			action="/add/user">
			<fieldset>
				<legend>註冊會員</legend>
				姓名:
				<form:input type="text" path="userName" />
				<p />
				帳號:
				<form:input type="text" path="userAccountNumber" />
				<p />
				密碼:
				<form:input type="text" path="userPassword" />
				<p />
				電話:
				<form:input type="text" path="userPhone" />
				<p />
				生日:
				<form:input type="date" path="userDate" />
				<p />
				信箱:
				<form:input type="email" path="userEmail" />
				<p />
				<button type="submit" class="pure-button pure-button-primary">新增</button>
			</fieldset>
		</form:form>
	</div>
</body>
</html>