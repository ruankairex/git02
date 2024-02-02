<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="zh-TW">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>營銷部門選單</title>
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

        form {
            margin-bottom: 15px;
        }

        button {
            padding: 10px;
            font-size: 16px;
            background-color: #4caf50;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        button:hover {
            background-color: #45a049;
        }
    </style>
</head>

<body>

    <h2>選單</h2>

    <form action="<%=request.getContextPath()%>/CouponFindAllServlet" method="post">
        <button type="submit">優惠券列表</button>
    </form>

    <form action="PromotionFindAllServlet" method="post">
        <button type="submit">促銷活動列表</button>
    </form>

    <form action="<%=request.getContextPath()%>/HRSystemMainPage.do" method="post">
        <button type="submit">人力資源系統</button>
    </form>

    <form action="<%=request.getContextPath()%>/LogOutServlet.do" method="get">
        <button type="submit">登出</button>
    </form>

</body>

</html>