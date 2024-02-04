<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-TW">

<head>
    <meta charset="UTF-8">
    <title>促銷商品列表</title>
    <style>
        body {
            font-family: '微軟正黑體', Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
            text-align: center;
        }

        h2 {
            color: #333;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #4caf50;
            color: #fff;
        }

        tbody tr:hover {
            background-color: #f5f5f5;
        }

        p {
            color: #555;
            font-size: 16px;
        }
    </style>
</head>

<body>

    <h2>促銷商品列表</h2>
    
    <form action="PromotionBatchRemoveProductsServlet" method="post">
    <input type="hidden" name="promotionId" value="${promotionId}">
        <c:if test="${not empty Products}">
            <table border="1">
                <thead>
                    <tr>
                        <th>選擇</th>
                        <th>商品編號</th>
                        <th>商品名稱</th>
                        <th>商品種類</th>
                        <th>賣家編號</th>
                        <th>員工編號</th>
                        <th>單價</th>
                        <th>審核</th>
                        <!-- 根據需要添加其他欄位 -->
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="product" items="${Products}">
                        <tr>
                            <td><input type="checkbox" name="selectedProducts" value="${product.productId}"></td>
                            <td>${product.productId}</td>
                            <td>${product.productName}</td>
                            <td>${product.categoryId}</td>
                            <td>${product.sellerId}</td>
                            <td>${product.employeeId}</td>
                            <td>${product.unitPrice}</td>
                            <td><a href="PromotionProductDeleteServlet?id=${product.productId}&promotionId=${promotionId}">移除商品資格</a></td>
                            <!-- 根據需要添加其他儲存格 -->
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <button type="submit">批量移除選中商品資格</button>
        </c:if>
    </form>

    <c:if test="${empty Products}">
        <p>此促銷活動無相關商品。</p>
    </c:if>
    <a href="PromotionFindAllServlet">回活動主頁</a>

</body>

</html>