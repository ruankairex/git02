<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Promotion Product List</title>
</head>
<body>

    <h2>Promotion Product List</h2>

    <c:if test="${not empty Products}">
        <table border="1">
            <thead>
                <tr>
                    <th>Product ID</th>
                    <th>Product Name</th>
                    <th>Seller ID</th>
                    <th>Employee ID</th>
                    <th>Unit Price</th>
                    <!-- Add other columns as needed -->
                </tr>
            </thead>
            <tbody>
                <c:forEach var="product" items="${Products}">
                    <tr>
                        <td>${product.productId}</td>
                        <td>${product.productName}</td>
                        <td>${product.sellerId}</td>
                        <td>${product.employeeId}</td>
                        <td>${product.unitPrice}</td>
                        <!-- Add other cells as needed -->
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>

    <c:if test="${empty Products}">
        <p>No products found for the promotion.</p>
    </c:if>

</body>
</html>