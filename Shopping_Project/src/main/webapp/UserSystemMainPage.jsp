<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.daoImpl.*"%>
<%@ page import="com.entity.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>網站首頁</title>
</head>
<body>
<%
	ProductDaoImpl dao = new ProductDaoImpl();
 	List<Product> product = dao.selectAll();
 	if (product != null && !product.isEmpty()) {
		for (Product pro : product) {
%>

		<%=pro.getProductId()%>
		<%=pro.getProductName()%>
		<%=pro.getSellerId()%>
		<%=pro.getEmployeeId()%>
		
<%
		}
	}
%>
</body>
</html>
