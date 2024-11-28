<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>會員資訊</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
<link rel="stylesheet" href="/css/buttons.css">
</head>
<body>
	<div>
		<h1>會員資訊</h1>
		<form:form class="pure-form" modelAttribute="userDto">
			<fieldset>
				
				<form:input path="userId" id="userId" type = "hidden" />
				<p />
	
				<label for="userName">暱稱:</label>
				<form:input path="userName" id="userName" readonly="true" />
				<p />

				<label for="userAccountNumber">帳號:</label>
				<form:input path="userAccountNumber" id="userAccountNumber"
					readonly="true" />
				<p />

				<label for="userDate">生日:</label>
				<form:input path="userDate" id="userDate" readonly="true" />
				<p />

				<label for="userEmail">信箱:</label>
				<form:input path="userEmail" id="userEmail" type="email"/>
				<p />
				
				<label for="userPhone">電話號碼:</label>
				<form:input path="userPhone" id="userPhone"/>
				<p/>

				<button type="submit" class="pure-button pure-button-primary">修改</button>
	            </fieldset>
	        </form:form>
	    </div>
	</body>
</html>