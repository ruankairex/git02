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
    <title>客服部員工</title>
</head>
<body>

    <h2>客服部員工</h2>

    <p>
        <a class="btn btn-primary" data-bs-toggle="collapse" href="#multiCollapseExample1" role="button" aria-expanded="false" aria-controls="multiCollapseExample1">未審核</a>
        <a class="btn btn-primary" data-bs-toggle="collapse" href="#multiCollapseExample2" role="button" aria-expanded="false" aria-controls="multiCollapseExample2">已審核</a>
    </p>

    <div class="row">
        <div class="col">
            <div class="collapse multi-collapse" id="multiCollapseExample1">
                <div class="card card-body">
                    <table>
                        <tr>
                            <th>Id</th>
                            <th>使用者名稱</th>
                            <th>使用者郵件</th>
                            <th>賣家資格</th>
                            <th>使用者狀態</th>
                        </tr>
                        <%
                        List<User> users = (List<User>) request.getAttribute("Userslist");
                        if (users != null && !users.isEmpty()) {
                            for (User user : users) {
                        %>
                        <tr>
                            <td><%=user.getUserId()%></td>
                            <td><%=user.getLastName() + " " + user.getFirstName()%></td>
                            <td><%=user.getUserEmail()%></td>
                            <td><%=user.getSellerQualified()%></td>
                            <td><%=user.getUserStatus()%></td>
                            <td>
                            	<form action="CSUpdate.jsp" method="post">
                               <input type="hidden" name="userId" value="<%=user.getUserId()%>">
							   <input type="hidden" name="lastName" value="<%=user.getLastName()%>">
							   <input type="hidden" name="firstName" value="<%=user.getFirstName()%>">
							   <input type="hidden" name="userEmail" value="<%=user.getUserEmail()%>">
							   <input type="hidden" name="hireDate" value="<%=user.getHireDate()%>">
							   <input type="hidden" name="buyerViolationCount" value="<%=user.getBuyerViolationCount()%>">
							   <input type="hidden" name="sellerViolationCount" value="<%=user.getSellerViolationCount()%>">
							   <input type="hidden" name="userSellerQualified" value="<%=user.getSellerQualified()%>">
							   <input type="hidden" name="userStatus" value="<%=user.getUserStatus()%>">
                                    <button type="submit">審核</button>
                                </form>
                            </td>
                        </tr>
                        <%
                                }
                            }else {
                            	System.out.println("null");
                            }
                        
                        %>
                    </table>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col">
            <div class="collapse multi-collapse" id="multiCollapseExample2">
                <div class="card card-body">
                    <table>
                        <tr>
                            <th>Id</th>
                            <th>使用者名稱</th>
                            <th>使用者郵件</th>
                            <th>賣家資格</th>
                            <th>使用者狀態</th>
                        </tr>
                        <!-- Add content for already verified users if needed -->
                    </table>
                </div>
            </div>
        </div>
    </div>

</body>
</html>
