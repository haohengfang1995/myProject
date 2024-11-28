<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<!-- menu bar include -->
<%-- 		<%@include file="/WEB-INF/view/menu.jspf" %> --%>
		<!-- body content -->
		<div style="padding: 15px">
	<h1>
		錯誤: <c:out value="${message}"/>
	</h1>
		</div>
</body>
</html>