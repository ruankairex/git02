<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.daoImpl.*"%>
<%@ page import="com.entity.*"%>

<!-- 引用函式庫 核心函式庫 c -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>網站首頁</title>
</head>
<body>
   
	<c:set var="userSystemPass" value="${sessionScope.UsersystemPass}" />
		<c:out
			value="${userSystemPass.userId} ${userSystemPass.lastName} ${userSystemPass.firstName} ${userSystemPass.userEmail} 您好!" />
			
			<table>
			<tr>
				<th>商品id</th>
				<th>商品名稱</th>
				<th>賣家id</th>
				<th>審核人員id</th>
			</tr>
				<%
				List<Product> Product = (List<Product>) request.getAttribute("Product");
				if (Product != null && !Product.isEmpty()) {
					for (Product product : Product) {
				%>
				<tr>
					<td><%=product.getProductId()%></td>
					<td><%=product.getProductName()%></td>
					<td><%=product.getSellerId()%></td>
					<td><%=product.getEmployeeId()%></td>
				</tr>
				<%
					}}
				%>
			</table>
</body>
</html>
