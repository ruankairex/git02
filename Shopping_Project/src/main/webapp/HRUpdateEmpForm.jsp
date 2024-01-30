<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.*"%>
<%@ page import="com.dao.*"%>
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

<div>

		<!-- <h3>${hrSystemPass.employeeId}&nbsp;${title}</h3>也可以這樣寫 -->
		<hr>
		<c:set var="request" value="${dept}" />

		<c:choose>
			<c:when test="${dept.equals('人事部') or title.equals('主管')}">
				<a href="HRUpdateEmpForm.jsp" class="btn btn-primary btn-sm mb-3">部門員工權限管理</a>
			</c:when>
		</c:choose>
		<c:choose>
			<c:when test="${dept.equals('人事部')}">
				<a href="MemberDataCarrier" class="btn btn-primary btn-sm mb-3">新進員工資料登入</a>
			</c:when>
		</c:choose>
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
			<%
			List<Employee> allEmp = (List<Employee>) request.getAttribute("allEmp");
			if (allEmp != null && !allEmp.isEmpty()) {
				for (Employee emp : allEmp) {
			%>
			<tr>
				<td><%=emp.getDepartment()%></td>
				<td><%=emp.getTitle()%></td>
				<td><%=emp.getDbAuthority()%></td>
				<td><%=emp.getEmployeeId()%></td>
				<td><%=emp.getLastName() + " " + emp.getFirstName()%></td>
				<td><%=emp.getEmail()%></td>
				<td><%=emp.getPhone()%></td>
				<td><%=emp.getBirthDate()%></td>
				<td><%=emp.getCity() + "" + emp.getDistrict() + "" + emp.getAddress()%></td>
				<td><%=emp.getHireDate()%></td>
				<td><span> <c:choose>
							<c:when test="${dept.equals('人事部') or title.equals('主管')}">
								<a href="HRUpdateAuth.do?id=<%=emp.getEmployeeId()%>"
									class="btn btn-info btn-sm"> Update </a>
							</c:when>
						</c:choose>
				</span> <c:choose>
						<c:when
							test="${dept.equals(deptAllow)}">
							<span> <a href="DeleteEmp.do?id=<%=emp.getEmployeeId()%>"
								class="btn btn-danger btn-sm"
								onclick="if (!(confirm('Are you sure to delete this employee?'))) return false">
									Delete </a>
							</span>
						</c:when>
					</c:choose></td>
			</tr>
			<%
			}
			} else {
			%>
			<p>No data can be shown.</p>
			<%
			}
			%>
		</table>
	
</body>
</html>