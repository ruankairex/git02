<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Menu</title>
</head>
<body>

    <h2>Menu</h2>

    <form action="<%=request.getContextPath()%>/CouponFindAllServlet" method="post">
        <button type="submit">Coupon List</button>
    </form>

    <form action="PromotionFindAllServlet" method="post">
        <button type="submit">Promotion List</button>
    </form>

    <form action="<%=request.getContextPath()%>/LogoutServlet" method="post">
        <button type="submit">Logout</button>
    </form>

</body>
</html>