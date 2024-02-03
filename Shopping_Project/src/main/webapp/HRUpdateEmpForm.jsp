<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.*"%>
<%@ page import="com.dao.*"%>
<%@ page import="java.sql.Date"%>
<%@ page import="com.entity.*"%>

<!-- 引用函式庫 核心函式庫 c -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>部門員工權限管理表單</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

</head>
<body>
<a href="HRSystemMainPage.do" class="btn btn-outline-secondary">返回主頁</a>
<c:set var="hrSystemPass" value="${sessionScope.HRsystemPass}" />
<div>

		<hr>
		<c:set var="request" value="${dept}" />

		
	</div>
	<div></div>
	<div>
		<table class="table table-bordered table-striped">
			<tr>
				<th>部門</th>
				<th>職稱</th>
				<th>權限</th>
				<th>ID</th>
				<th>姓名</th>
				<th>信箱</th>
				<th>電話</th>
				<th>生日</th>
				<th>住址</th>
				<th>入職日</th>
				<th>Action</th>
			</tr>
		<c:if test="${not empty allEmp and dept.equals('人事部')}">
    			<c:forEach var="emp" items="${allEmp}">
			<tr>
				<td>${emp.department}</td>
				<td>${emp.title}</td>
				<td>${emp.dbAuthority}</td>
				<td>${emp.employeeId}</td>
				<td>${emp.lastName} ${emp.firstName}</td>
        		<td>${emp.email}</td>
        		<td>${emp.phone}</td>
				<td>${emp.birthDate}</td>
				<td>${emp.city} ${emp.district} ${emp.address}</td>
				<td>${emp.hireDate}</td>
				<td><span> <c:choose>
							<c:when test="${dept.equals('人事部') or title.equals('主管')}">
								<c:if test="${ !title.equals('員工')and !hrSystemPass.employeeId.equals(emp.employeeId)}">
									<a href="HRUpdateAuth.do?id=${emp.employeeId}"
									class="btn btn-info btn-sm"> Update </a>
								</c:if>
							</c:when>
						</c:choose>
				</span> <c:choose>
						<c:when
							test="${dept.equals('人事部')}">
							<c:if test="${ !title.equals('員工')and !hrSystemPass.employeeId.equals(emp.employeeId)}">
							<span> <a href="DeleteEmp.do?id=${emp.employeeId}"
								class="btn btn-danger btn-sm"
								onclick="if (!(confirm('Are you sure to delete this employee?'))) return false">
									Delete </a>
							</span>
							</c:if>
						</c:when>
					</c:choose></td>
			</tr>
			</c:forEach>
			</c:if>
			<c:if test="${empty allEmp}">
				<p>No data can be shown.</p>
			</c:if>
		</table>
	
</body>
</html>