<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.service.UserBeanService"%>
<%@ page import="com.entity.User" %>
<%@ page import="com.util.HibernateUtil" %>
<%@ page import="java.util.List" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="org.hibernate.SessionFactory" %>

<%@ page import="com.daoImpl.UserDaoImpl" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
	SessionFactory factry = HibernateUtil.getSessionFactory();
	Session se = factry.getCurrentSession();
    UserBeanService userService = new UserBeanService(se);
    List<User> userList = userService.selectAll();
    request.setAttribute("userList", userList);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>管理客戶後台系統</title>
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
		<c:if test="${not empty userList}">
	    <table class="draggable-table">
	    	<tr class="">
	        	<th>會員號碼</th>
	            <th>名字</th>
	            <th>姓氏</th>
	            <th>電子信箱</th>
	            <th>密碼</th>
	            <th>註冊時間</th>
	            <th>買家是否違規</th>
	            <th>上次登入時間</th>
	            <th>會員身分</th>
	            <th>信用卡號碼</th>
	            <th>信用卡安全碼</th>
	            <th>信用卡有效日期</th>
	            <th>信用卡持有者名字</th>
	            <th>居住縣市</th>
	            <th>區</th>
	            <th>地址</th>
	            <th>銀行帳號</th>
	            <th>成為賣家</th>
	            <th>賣家是否違規</th>
	            <th>會員帳號狀態</th>
	            <th>優惠券</th>
	        </tr>
	        <c:forEach var="ub" items="${userList}">
	            <tr>
	           		<td>${ub.userId}</td>
					<td>${ub.lastName}</td>
					<td>${ub.firstName}</td>
	       			<td>${ub.userEmail}</td>
	       			<td>${ub.userPassword}</td>
	       			<td>${ub.hireDate}</td>
	       			<td>${ub.buyerViolationCount}</td>
	       			<td>${ub.lastLoginTime}</td>
	       			<td>${ub.sellerQualified}</td>
	       			<td>${ub.cardNumber}</td>
	       			<td>${ub.cardCVCCode}</td>
	       			<td>${ub.cardExpiryDate}</td>
	       			<td>${ub.cardHolderName}</td>
	       			<td>${ub.city}</td>
	       			<td>${ub.district}</td>
	       			<td>${ub.address}</td>
	       			<td>${ub.bankAccount}</td>
	       			<td>${ub.sellerDate}</td>
	       			<td>${ub.sellerViolationCount}</td>
	       			<td>${ub.userStatus}</td>
	       			<td>${ub.coupons}</td>
	            </tr>
	         </c:forEach>
	    </table>
		</c:if>
	</div>
</div>	
</body>
</html>