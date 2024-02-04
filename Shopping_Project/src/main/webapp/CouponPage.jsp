<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>優惠券列表</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
    <script src="scripts.js"></script>
</head>
<body>

    <h1>優惠券列表</h1>

    <c:if test="${not empty couponList}">
        <table border="1">
            <thead>
                <tr>
                    <th>優惠券代號</th>
                    <th>優惠券類別</th>
                    <th>領券的使用者</th>
                    <!-- 其他优惠券属性 -->
                </tr>
            </thead>
            <tbody>
                <c:forEach var="coupon" items="${couponList}">
                    <tr>
                        <td>${coupon.couponCode}</td>
                        <td>${coupon.couponCategory}</td>
                        <td>
<%--                             <c:forEach var="user" items="${coupon.users}"> --%>
<%--                                 ${user.userId} <!-- 假设 User 类有一个 userName 属性 --> --%>
<!--                                 <br/> -->
<%--                             </c:forEach> --%>
							<c:out value="${fn:length(coupon.users)}" />
                        </td>
                        <!-- 其他优惠券属性 -->
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>

    <div>
    <a href="MarketingMainPage.jsp" class="btn btn-primary btn-sm mb-3">
        返回營銷部主頁
    </a>
</div>

</body>
</html>