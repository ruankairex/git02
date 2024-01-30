<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.*"%>
<%@ page import="com.daoImpl.*"%>
<%@ page import="com.entity.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-TW">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
    <title>客服部</title>
</head>
<body>

    <h2>客服部</h2>
	<%
		//取得通行證屬性
		empPass pass = (empPass) request.getAttribute("loginPass");
		if (pass != null) {
			String dept = pass.getDepartment();
			String title = pass.getTitle();
			String name = pass.getFirstName();
			out.write(dept + " " + title + " : " + name + " 您好!");
		
	%>
    <p>
        <% if("員工".equals(title)) { %>
            <a class="btn btn-primary" data-bs-toggle="collapse" href="#multiCollapseExample1" role="button" aria-expanded="false" aria-controls="multiCollapseExample1">未審核賣家</a>
     	<%
        	}else if("主管".equals(title)) {
     	%>
            <a class="btn btn-primary" data-bs-toggle="collapse" href="#multiCollapseExample2" role="button" aria-expanded="false" aria-controls="multiCollapseExample2">已審核賣家</a>
            <a class="btn btn-primary" role="button" href="HRSystemMainPage.do">人事管理系統</a>
      	<% 
        	}
      	%>
      	<a class="btn btn-outline-danger" role="button" href="LogOutServlet.do">LogOut</a>
    </p>
	
	<%
		} else {
			out.write("<p>No result</p>");
		}
	%>

    <div class="row">
        <div class="col">
            <div class="collapse multi-collapse" id="multiCollapseExample1">
                <div class="card card-body">
                    <table class="table">
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>使用者名稱</th>
                                <th>使用者郵件</th>
                                <th>賣家資格</th>
                                <th>使用者狀態</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="user" items="${Userslist}">
                                <c:if test="${'未審核' eq user.userStatus}">
                                    <tr>
                                        <td>${user.userId}</td>
                                        <td>${user.lastName} ${user.firstName}</td>
                                        <td>${user.userEmail}</td>
                                        <td>${user.sellerQualified}</td>
                                        <td>${user.userStatus}</td>
                                        <td>
                                            <form action="CSUpdate.jsp" method="post">
                                                <input type="hidden" name="userId" value="${user.userId}">
                                                <input type="hidden" name="lastName" value="${user.lastName}">
                                                <input type="hidden" name="firstName" value="${user.firstName}">
                                                <input type="hidden" name="userEmail" value="${user.userEmail}">
                                                <input type="hidden" name="hireDate" value="${user.hireDate}">
                                                <input type="hidden" name="buyerViolationCount" value="${user.buyerViolationCount}">
                                                <input type="hidden" name="sellerViolationCount" value="${user.sellerViolationCount}">
                                                <input type="hidden" name="userSellerQualified" value="${user.sellerQualified}">
                                                <input type="hidden" name="userStatus" value="${user.userStatus}">
                                                <button type="submit" class="btn btn-primary">審核</button>
                                            </form>
                                        </td>
                                    </tr>
                                </c:if>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col">
            <div class="collapse multi-collapse" id="multiCollapseExample2">
                <div class="card card-body">
                    <table class="table">
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>使用者名稱</th>
                                <th>使用者郵件</th>
                                <th>賣家資格</th>
                                <th>使用者狀態</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="user" items="${Userslist}">
                                <c:if test="${'審核中' eq user.userStatus or '未通過' eq user.userStatus}">
                                    <tr>
                                        <td>${user.userId}</td>
                                        <td>${user.lastName} ${user.firstName}</td>
                                        <td>${user.userEmail}</td>
                                        <td>${user.sellerQualified}</td>
                                        <td>${user.userStatus}</td>
                                        <td>
                                            <form action="CSUpdate.jsp" method="post">
                                                <input type="hidden" name="userId" value="${user.userId}">
                                                <input type="hidden" name="lastName" value="${user.lastName}">
                                                <input type="hidden" name="firstName" value="${user.firstName}">
                                                <input type="hidden" name="userEmail" value="${user.userEmail}">
                                                <input type="hidden" name="hireDate" value="${user.hireDate}">
                                                <input type="hidden" name="buyerViolationCount" value="${user.buyerViolationCount}">
                                                <input type="hidden" name="sellerViolationCount" value="${user.sellerViolationCount}">
                                                <input type="hidden" name="userSellerQualified" value="${user.sellerQualified}">
                                                <input type="hidden" name="userStatus" value="${user.userStatus}">
                                                <button type="submit" class="btn btn-primary">審核</button>
                                            </form>
                                        </td>
                                    </tr>
                                </c:if>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

</body>
</html>
