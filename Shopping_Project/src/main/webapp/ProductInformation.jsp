<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.service.ProductBeanService"%>
<%@ page import="com.entity.Product" %>
<%@ page import="com.util.HibernateUtil" %>
<%@ page import="java.util.List" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="org.hibernate.SessionFactory" %>

<%@ page import="com.daoImpl.UserDaoImpl" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
	SessionFactory factry = HibernateUtil.getSessionFactory();
	Session se = factry.getCurrentSession();
    ProductBeanService productService = new ProductBeanService(se);
    List<Product> productList = productService.selectAll();
    request.setAttribute("productList", productList);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>管理商品後台系統</title>
<style>
	body {
  margin: 0;
  overflow: hidden;
}

.draggable-container {
  width: 100%;
  height: 100vh;
  display: flex;
  overflow-x: auto; 
  overflow-y: hidden; 
}

.draggable-content {
  flex: 0 0 auto;
  width: 100%;
  height: 100%;
  padding: 20px;
  background-color: #f0f0f0;
}
.draggable-table {
  border-collapse: collapse;
  width: auto;
}

.draggable-table th, .draggable-table td {
  border: 1px solid #ddd;
  padding: 8px;
  text-align: left;
}

</style>
</head>
<body>
<div class="scrollable-table-container">
	<div class="horizontal-scroll-bar"></div>
	<div class="table-container">
		<c:if test="${not empty productList}">
	    <table class="draggable-table">
	    	<tr class="">
	        	<th>商品編號</th>
	            <th>商品名稱</th>
	            <th>賣家會員號碼</th>
	            <th>審核員工編號</th>
	            <th>單價</th>
	            <th>商品種類</th>
	            <th>庫存量</th>
	            <th>預定商品數量</th>
	            <th>上架日</th>
	            <th>最後修改日期</th>
	            <th>商品說明</th>
	            <th>商品狀態</th>
	        </tr>
	        <c:forEach var="ub" items="${productList}">
	            <tr>
	           		<td>${ub.productId}</td>
					<td>${ub.productName}</td>
					<td>${ub.sellerId}</td>
	       			<td>${ub.employeeId}</td>
	       			<td>${ub.unitPrice}</td>
	       			<td>${ub.categoryId}</td>
	       			<td>${ub.stock}</td>
	       			<td>${ub.reservedQuantity}</td>
	       			<td>${ub.listingDate}</td>
	       			<td>${ub.modifiedDate}</td>
	       			<td>${ub.description}</td>
	       			<td>${ub.productStatus}</td>
	            </tr>
	         </c:forEach>
	    </table>
		</c:if>
	</div>
</div>	
</body>
</html>