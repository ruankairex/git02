<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>客服部後臺管理</title>
</head>
<body>
        <form action="S2Update.do" method="post" >
	      <label for="userId" class="t1">用戶編號 : </label>
	      <input type="text" value="${param.userId}" name="userId" autocomplete="off" required readonly/>
	      <br>
	      <hr>
	      <label for="lastName" class="t1">用戶lastName : </label>
	      <input type="text" value="${param.lastName}" name="lastName" autocomplete="off" required readonly/>
	      <br>
	      <hr>
	      <label for="firstName" class="t1">用戶firstName : </label>
	      <input type="text" value="${param.firstName}" name="firstName" autocomplete="off" required readonly/>
	      <br>
	      <hr>
	      <label for="userEmail" class="t1">用戶信箱 : </label>
	      <input type="text" value="${param.userEmail}" name="userEmail" autocomplete="off" required readonly/>
	      <br>
	      <hr>
	      <label for="hireDate" class="t1">加入時間 : </label>
	      <input type="text" value="${param.hireDate}" name="hireDate" autocomplete="off" required readonly/>
	      <br>
	      <hr>
	      <label for="buyerViolationCount" class="t1">買方違規次數 : </label>
	      <input type="text" value="${param.buyerViolationCount}" name="buyerViolationCount" autocomplete="off" required />
	      <br>
	      <hr>
	      <label for="sellerViolationCount" class="t1">賣方違規次數 : </label>
	      <input type="text" value="${param.sellerViolationCount}" name="sellerViolationCount" autocomplete="off" required />
	      <br>
	      <hr>
	      <label for="userSellerQualified" class="t1">賣家資格 : </label>
	      <input type="text" value="${param.userSellerQualified}" name="userSellerQualified" autocomplete="off" required />
	      <br>
	      <hr>
      	  <label for="userStatus" class="t1">用戶狀態 : </label>
                <select name="userStatus">
                        <option value="未審核">未審核</option>
                        <option value="未通過">未通過</option>
                        <option value="審核中">已審核</option>
                </select>
          <br>
	      <hr>
          <button type="submit">Update</button>
	</form>

</body>
</html>
