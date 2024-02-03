<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <style>
        table {
            border-collapse: collapse;
            width: 50%;
            margin: auto;
        }
        th, td {
            border: 1px solid #dddddd;
            text-align: center;
            padding: 8px;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        a{
        text-align: center;
        }
    </style>
</head>
<body>
     <h1 style="text-align: center;">各項數據</h1>
     <table border="1">
        <tr>
            <td>訂單商品總金額</td>
            <td>${quantity}</td>
        </tr>
        <tr>
            <td>類別3的商品金額</td>
            <td>${UnitpriceStock}</td>
        </tr>
        <tr>
            <td>目前員工數</td>
            <td>${countEmployee}</td>
        </tr>
        <tr>
            <td>
			<form id="form1" action="DataAnalysis" method="post">
        	<label for="numberInput">請輸入商品類別：</label>
        	<input type="number" id="numberInput" name="number" min="1" max="5" value="${param.number}">
        	<button type="submit" onclick="saveValue('numberInput')">送出</button>
    		</form>
            </td>
            <td>${countEmployee2}</td>
        </tr>
<!--         <tr> -->
<!--             <td> -->
<!-- 			<form id="form2" action="DataAnalysis" method="post"> -->
<!--         	<label for="numberInput2">請選擇一個商品類別：</label> -->
<!--         	<select id="numberInput2" name="number2" onchange="submitForm()"> -->
<!--             <option value="1">類別1</option> -->
<!--             <option value="2">類別2</option> -->
<!--             <option value="3">類別3</option> -->
<!--             <option value="4">類別4</option> -->
<!--             <option value="5">類別5</option> -->
<!--         	</select> -->
<!--     		</form> -->
<!--             </td> -->
<%--             <td>${countEmployee3}</td> --%>
<!--         </tr> -->

    </table>
<div style="text-align: center;">
    <a href="MarketingMainPage.jsp" class="btn btn-primary">返回前頁</a>
</div>    
   
<script>
function submitForm() {
	var selectedValue = document.getElementById("numberInput2").value;
    document.getElementById("form2").submit();
}

function saveValue(inputId) {
    var inputValue = document.getElementById(inputId).value;
    localStorage.setItem(inputId, inputValue); // 將值保存到 localStorage
}

window.onload = function() {
    var savedValue = localStorage.getItem('numberInput2'); // 注意這裡的 'numberInput2'
    if (savedValue) {
        document.getElementById('numberInput2').value = savedValue; // 將保存的值設置回下拉列表
    }
};
</script>
      
</body>
</html>