<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增新進員工資訊表單</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

</head>
<body>

	<a href="HRSystemMainPage.do" class="btn btn-primary">返回主頁</a>

	<div class="container mt-4">

		
					<form action="xxxServlet" method="post">
					<!-- 姓氏 -->
					<input type="text" value="" name="empLastName" id="empLastName"
					class="form-control mb-4 w-25" placeholder="姓氏 (exp. 王)"
					onblur="validateName()" required> <span id="LastNameValidation"
					class="error"></span>
					<!-- 名字 -->
					<input type="text" value="" name="empFirstName" id="empFirstName"
					class="form-control mb-4 w-25" placeholder="名字 (exp. 小明)"
					onblur="validateName()" required> <span id="FirstNameValidation"
					class="error"></span>
					<!-- 信箱 -->
					<input type="text" value="" name="empMail" id="empMail"
					class="form-control mb-4 w-25" placeholder="員工信箱"
					onblur="validateMail()" required> <span id="MailValidation"
					class="error"></span>
					 <!-- 密碼 -->
					<input type="text" value="" name="empPwd" id="empPwd"
					class="form-control mb-4 w-25" placeholder="員工初始密碼"
					onblur="validatePwd()" required> <span id="PwdValidation"
					class="error"></span>
					 <!-- 電話 -->
					<input type="text" value="" name="empPhone" id="empPhone"
					class="form-control mb-4 w-25" placeholder="員工聯絡電話"
					onblur="validatePhone()" required> <span id="PhoneValidation"
					class="error"></span>
					<!-- 入職日 -->
					<input type="text" value="" name="empHire" id="empHire"
					class="form-control mb-4 w-25" placeholder="員工入職日"
					 required> <span id="warn_Hiredate"
					class="error"></span>
					<!-- 生日 -->
					<input type="text" value="" name="empBirth" id="empBirth"
					class="form-control mb-4 w-25" placeholder="員工出生年月日"
					 required> <span id="warn_Birthdate"
					class="error"></span>
					<!-- 居住城市 -->
					<input type="text" value="" name="empCity" id="empCity"
					class="form-control mb-4 w-25" placeholder="員工居住縣市"
					 required> 
					<!-- 居住區別 -->
					<input type="text" value="" name="empDistrict" id="empDistrict"
					class="form-control mb-4 w-25" placeholder="員工居住區別"
					 required> 
					<!-- 居住詳細 -->
					<input type="text" value="" name="empAddress" id="empAddress"
					class="form-control mb-4 w-25" placeholder="員工居住區別"
					 required> 
					<!-- 部門 -->
					<select name="EmpDept" id="EmpDept" class="form-control mb-4 w-25">
					    <option value=""selected>請選擇新進員工部門</option>
					    <option value="人事部">人事部</option>
					    <option value="貨運部" >貨運部</option>
					    <option value="營銷部">營銷部</option>
					    <option value="營業部">營業部</option>
					    <option value="客服部" >客服部</option>
					</select>
					 <!-- 職稱 -->
					<select name="EmpDept" id="EmpTitle" class="form-control mb-4 w-25">
					    <option value="">請選擇新進員工職位</option>
					    <option value="員工"selected>員工</option>
					    <option value="主管" >主管</option>
					</select>
					 <!-- 權限 -->
					<select name="EmpDept" id="EmpAuth" class="form-control mb-4 w-25">
					    <option value="">預設員工權限</option>
					    <option value="2"selected>2</option>
					</select>
					
                        <button type="submit" class="btn btn-info col-2">儲存資料</button>
                        
                    </form>



	</div>
	
	
</body>
</html>