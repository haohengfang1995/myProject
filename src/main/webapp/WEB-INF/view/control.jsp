<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<!DOCTYPE html>
<html lang="zh-Hant">
<head>
<meta charset="UTF-8">
<title>控制台</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
<link rel="stylesheet" href="/css/buttons.css">
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	margin: 20px;
}

.pure-table {
	width: 100%;
	margin: 20px 0;
	border-collapse: collapse;
}

.pure-table th, .pure-table td {
	padding: 12px;
	text-align: left;
	border-bottom: 1px solid #ddd;
	word-wrap: break-word; /* 允许换行 */
}

.pure-table th {
	background-color: #f2f2f2;
}

.button-success, .button-error {
	margin: 5px;
}

@media ( max-width : 600px) {
	.pure-table thead {
		display: none; /* 隐藏表头 */
	}
	.pure-table tr {
		display: block;
		margin-bottom: 15px;
		border: 1px solid #ddd;
	}
	.pure-table td {
		display: flex;
		justify-content: space-between;
		padding-left: 50%;
		position: relative;
		text-align: right;
	}
	.pure-table td::before {
		content: attr(data-label); /* 使用data-label属性显示名称 */
		position: absolute;
		left: 10px;
		text-align: left;
		font-weight: bold;
	}
}
</style>
</head>
<body>
	<div class="pure-form">
		<fieldset>
			<legend>使用者列表</legend>
			<table class="pure-table pure-table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>姓名</th>
						<th>帳號</th>
						<th>手機</th>
						<th>生日</th>
						<th>信箱</th>
						<th>密碼</th>
						<th>鹽巴</th>
						<th>鹽密碼</th>
						<th>等級</th>
						<th>啟動</th>
						<th>刪除</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="user" items="${ users }">
						<tr>
							<td data-label="使用者ID">${ user.userId }</td>
							<td data-label="姓名">${ user.userName }</td>
							<td data-label="帳號">${user.userAccountNumber}</td>
							<td data-label="手機">${ user.userPhone }</td>
							<td data-label="生日"><fmt:formatDate
									value="${ user.userDate }" pattern="yyyy-MM-dd" /></td>
							<td data-label="信箱">${ user.userEmail }</td>
							<td data-label="密碼">${user.userPassword}</td>
							<td data-label="Salt">${user.userSalt}</td>
							<td data-label="PasswordHash">${user.userPasswordHash}</td>
							<td data-label="使用者等級">${ user.userRole }</td>
							<td data-label="帳號認證">${ user.userActive }</td>
							<td><a class="button-error pure-button"
								href="/customer/delete/${ user.userId }">刪除</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</fieldset>
	</div>
<!-- 	<td valign="top"> -->
<%-- 	<%@ include file="/WEB-INF/view/useradd.jspf"%> --%>
<!-- 	</td> -->
	</div>
</body>
</html>