<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>新增通知</title>
</head>
<body>
    <h2>新增推播</h2>
    
    <!-- 新增通知表单 -->
    <form action="<%=request.getContextPath()%>/NotificationAddServlet" method="post">
        
        <br/>

        <label for="message">推播標題:</label>
        <input type="text" id="message" name="message" required>
        <br/>

        <label for="productLink">推播資訊:</label>
        <input type="text" id="productLink" name="productLink" required>
        <br/>

        <!-- 其他通知相关字段 -->

        <button type="submit">新增</button>
    </form>
</body>
</html>