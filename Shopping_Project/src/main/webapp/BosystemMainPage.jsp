<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.Date"%>
<%@ page import="com.dao.*"%>
<%@ page import="com.entity.*"%>

<!-- 引用函式庫 核心函式庫 c -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>營業部系統頁面</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
</head>
<body>
<c:set var="hrSystemPass" value="${sessionScope.HRsystemPass}" />
	<div class="d-grid gap-2 d-md-flex justify-content-md-end">
		<c:out
			value="${hrSystemPass.employeeId} ${hrSystemPass.department} ${hrSystemPass.title} ${hrSystemPass.firstName} 您好!" />
	
		<a href="LogOutServlet.do" class="btn btn-outline-dark">
			LogOut </a>
	</div>

<a href="UserInformation.do" class="btn btn-primary btn-sm mb-3">會員資訊列表</a>
<a href="ProductInformation.do" class="btn btn-primary btn-sm mb-3">產品審核列表</a>
<a href="OrderInformation.jsp" class="btn btn-primary btn-sm mb-3">訂單資訊列表</a>

</body>
</html>