<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.daoImpl.*"%>
<%@ page import="com.entity.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
<title>商品審核系統</title>
</head>
<body>

    <h2>商品審核</h2>
	<c:set var="hrSystemPass" value="${sessionScope.HRsystemPass}" />
	<div class="d-grid gap-2 d-md-flex justify-content-md-end">
		<c:out
			value="${hrSystemPass.employeeId} ${hrSystemPass.department} ${hrSystemPass.title} ${hrSystemPass.firstName} 您好!" />
	
		<a href="LogOutServlet.do" class="btn btn-outline-dark">
			LogOut </a>
	</div>
    <p>
            <a class="btn btn-primary" data-bs-toggle="collapse" href="#multiCollapseExample1" role="button" aria-expanded="false" aria-controls="multiCollapseExample1">未審核商品</a>

            <a class="btn btn-primary" data-bs-toggle="collapse" href="#multiCollapseExample2" role="button" aria-expanded="false" aria-controls="multiCollapseExample2">已審核商品</a>

      	<a class="btn btn-outline-danger" role="button" href="LogOutServlet.do">LogOut</a>
    </p>

    <div class="row">
        <div class="col">
            <div class="collapse multi-collapse" id="multiCollapseExample1">
                <div class="card card-body">
                    <table class="table">
                        <thead>
                            <tr>
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
                        </thead>
                        <tbody>
                            <c:forEach var="product" items="${Productlist}">
                            <c:if test="${'未審核' eq product.productStatus}">
					            <tr>
					           		<td>${product.productId}</td>
									<td>${product.productName}</td>
									<td>${product.sellerId}</td>
					       			<td>${product.employeeId}</td>
					       			<td>${product.unitPrice}</td>
					       			<td>${product.categoryId}</td>
					       			<td>${product.stock}</td>
					       			<td>${product.reservedQuantity}</td>
					       			<td>${product.listingDate}</td>
					       			<td>${product.modifiedDate}</td>
					       			<td>${product.description}</td>
					       			<td>${product.productStatus}</td>
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
                        </thead>
                        <tbody>
                            <c:forEach var="product" items="${Productlist}">
                            <c:if test="${'已審核' eq product.productStatus}">
					            <tr>
					           		<td>${product.productId}</td>
									<td>${product.productName}</td>
									<td>${product.sellerId}</td>
					       			<td>${product.employeeId}</td>
					       			<td>${product.unitPrice}</td>
					       			<td>${product.categoryId}</td>
					       			<td>${product.stock}</td>
					       			<td>${product.reservedQuantity}</td>
					       			<td>${product.listingDate}</td>
					       			<td>${product.modifiedDate}</td>
					       			<td>${product.description}</td>
					       			<td>${product.productStatus}</td>
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