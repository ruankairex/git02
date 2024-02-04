<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>訊息推播表</title>
</head>
<body>
    <h2>訊息推播表</h2>
    
    <table border="1">
        <thead>
            <tr>
                <th>通知 ID</th>
                <th>接收使用者 ID</th>
                <th>推播標題</th>
                <th>推播內容</th>
                <th>通知推播時間</th>
                <th>操作</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="notification" items="${notificList}">
                <tr>
                    <td>${notification.notificationId}</td>
                    <td>${notification.userId}</td>
                    <td>${notification.message}</td>
                    <td>${notification.productLink}</td>
                    <td>${notification.createdAt}</td>
                    <td>
                        <form action="<%=request.getContextPath()%>/NotificationPushServlet" method="get">
                            <input type="hidden" name="notificationId" value="${notification.notificationId}">
                            <button type="submit">推播</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    <!-- 新增通知按钮 -->
    <form action="<%=request.getContextPath()%>/NewNotificationPage.jsp" method="get">
        <button type="submit">新增通知</button>
    </form>
    
</body>
</html>