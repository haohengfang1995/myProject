<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>變更密碼</title>
	</head>
	<body>
		<div>
			<form class="pure-form" method="post" action="/user/update/password">
				<fieldset>
					<legend>變更密碼</legend>
					舊密碼: <input type="text" name="userPassword" />
					<p /> 
					密碼:
					<input type="text" name="newPassword" />
					<p />
					<button type="submit" class="pure-button pure-button-primary">送出</button>
				</fieldset>
			</form>
		</div>
	</body>
</html>