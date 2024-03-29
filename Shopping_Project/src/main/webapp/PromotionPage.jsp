<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.entity.Promotion" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Promotion List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<style type="text/css">
    body {
        
        background-size: cover;
        background-position: 80%;
        background-repeat: no-repeat;
        height: 100vh;
        margin: 0;
    }

    h2 {
        text-align: center;
        padding-top: 30px;
        font-family: '標楷體', sans-serif;
        color: white;
    }

    hr {
        border: 3px solid #FF9224;
    }

    table {
        display: flex;
        justify-content: center;
    }

    td {
        padding: 1rem;
        background-color: #C9EBB6;
        color: #000000;
    }

    tr:nth-child(1) {
        background-color: #63EB6C;
    }
</style>
<body>

<h2>Promotion List</h2>
<hr>

<div>
    <a href="MarketingMainPage.jsp" class="btn btn-primary btn-sm mb-3">
        返回營銷部主頁
    </a>
</div>
<div>
    <!-- 添加促销的链接 -->
    <a href="PromotionForm.jsp" class="btn btn-primary btn-sm mb-3">新增活動</a>
</div>

<table class="table table-bordered table-striped">
    <tr>
        <td>Promotion ID</td>
        <td>Name</td>
        <td>Description</td>
        <td>Role</td>
        <td>Category</td>
        <td>Start Date</td>
        <td>End Date</td>
        <td>Action</td>
    </tr>
    <%
  
    List<Promotion> promotions = (List<Promotion>) request.getAttribute("promotions");

    if (promotions != null && !promotions.isEmpty()) {

        for (Promotion promotion : promotions) {
%>
        <tr>
            <td><%= promotion.getPromotionId() %></td>
            <td><%= promotion.getPromotionName() %></td>
            <td><%= promotion.getDescription() %></td>
            <td><%= promotion.getPromotionRole() %></td>
            <td><%= promotion.getPromotionPCategory() %></td>
            <td><%= promotion.getStartDate() %></td>
            <td><%= promotion.getEndDate() %></td>
            <td>
                <!-- 更新和删除链接中使用 promotion.getPromotionId() 获取ID -->
                <a href="PromotionDataCarrierServlet?id=<%= promotion.getPromotionId() %>"
                   class="btn btn-info btn-sm">
                    更新
                </a>
                <a href="PromotionProductServlet?promotionId=<%= promotion.getPromotionId() %>"
   					class="btn btn-info btn-sm">
    				活動商品
				</a>
                <c:if test="${sessionScope.HRsystemPass.title == '主管'}">
    				<a href="PromotionDeleteServlet?id=<%= promotion.getPromotionId() %>"
       				class="btn btn-danger btn-sm"
       				onclick="if (!(confirm('確定要刪除嗎？'))) return false">
        			删除
    				</a>
				</c:if>
            </td>
        </tr>
    <%
        }
    } else {
    %>
        <tr>
            <td colspan="8">沒有活動。</td>
        </tr>
    <%
    }
    %>
</table>

</body>
</html>