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
<title>人事系統主畫面</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
</head>
<style type="text/css">
body {
	background-image: url('images/888.jpg');
	/* 設定背景圖片的URL */
	background-size: cover;
	/* 調整背景圖片大小以覆蓋整個頁面 */
	background-position: 80%;
	/* 將背景圖片置中 */
	background-repeat: no-repeat;
	/* 避免背景圖片重複 */
	height: 100vh;
	/* 使body元素充滿整個視窗高度 */
	margin: 0;
}

h2 {
	text-align: center;
	/* 將文字置中 */
	padding-top: 30px;
	font-family: '標楷體', sans-serif;
}

hr {
	border: 3px solid #FF9224;
}

table {
	display: flex;
	justify-content: center;
}

td {
	padding: 1rem;
	background-color: #C9EBB6;
}

tr:nth-child(1) {
	background-color: #63EB6C;
}
</style>
<body>


	<h2>xx公司 人事管理系統</h2>
	<hr>

	<div>
		<c:set var="hrSystemPass" value="${sessionScope.HRsystemPass}" />
		<c:out
			value="${hrSystemPass.employeeId} ${hrSystemPass.department} ${hrSystemPass.title} ${hrSystemPass.firstName} 您好!" />
	</div>
	<div>
		<a href="LogOutServlet.do" class="btn btn-primary btn-sm mb-3">
			LogOut </a>
	</div>
	<c:set var="deptAllow" value="人事部" />
	<c:set var="titleAllow" value="主管" />

	<div>

		<!-- <h3>${hrSystemPass.employeeId}&nbsp;${title}</h3>也可以這樣寫 -->
		<hr>
		<c:set var="request" value="${dept}" />

		<c:choose>
			<c:when test="${dept.equals('人事部') or title.equals('主管')}">
				<a href="HRUpdateEmpPage.do" class="btn btn-primary btn-sm mb-3">部門員工權限管理</a>
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