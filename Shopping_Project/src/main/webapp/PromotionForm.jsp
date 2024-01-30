<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Promotion</title>
</head>
<body>

<h2>Create Promotion</h2>

<form action="ProcessPromotionServlet" method="post">

    <label for="promotionId">Promotion ID:</label>
    <input type="text" id="promotionId" name="promotionId" value="${promotion.promotionId}" readonly><br>

    <label for="promotionName">Promotion Name:</label>
    <input type="text" id="promotionName" name="promotionName" value="${promotion.promotionName}" required><br>

    <label for="description">Description:</label>
    <textarea id="description" name="description" rows="4" cols="50">${promotion.description}</textarea><br>

    <label for="promotionRole">Promotion Role:</label>
    <select id="promotionRole" name="promotionRole" required>
        <option value="0" ${promotion.promotionRole == 0 ? 'selected' : ''}>All Products</option>
        <option value="1" ${promotion.promotionRole == 1 ? 'selected' : ''}>Limited Products (Refer to Promotion Category)</option>
    </select><br>

    <label for="promotionPCategory">Promotion Category:</label>
    <input type="text" id="promotionPCategory" name="promotionPCategory" value="${promotion.promotionPCategory}"><br>

    <label for="startDate">Start Date:</label>
    <input type="datetime-local" id="startDate" name="startDate" value="${promotion.startDate}" required><br>

    <label for="endDate">End Date:</label>
    <input type="datetime-local" id="endDate" name="endDate" value="${promotion.endDate}" required><br>

    <input type="submit" value="Update Promotion">
</form>

</body>
</html>