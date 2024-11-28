<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>登入會員</title>
	</head>
	<body>
		<div>
			<form class="pure-form" method="post" action="/login/userlogin">
				<fieldset>
					<legend>登入會員</legend>
					帳號: <input type="text" name="userAccountNumber" />
					<p /> 
					密碼:
					<input type="text" name="userPassword" />
					<p />
					<button type="submit" class="pure-button pure-button-primary">登入</button>
				</fieldset>
	
			</form>
	
		</div>
	</body>
</html>