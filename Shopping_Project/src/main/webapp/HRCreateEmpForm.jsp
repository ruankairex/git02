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

	<a href="HRSystemMainPage.do" class="btn btn-outline-secondary">返回主頁</a>

	<div class="container mt-4">

		
			<form action="HRCreateNewEmp.do" method="post" class="row g-3">
					<!-- 姓氏 -->
				<div class="col-md-5">
					<label for="staticEmail" class="form-label"> 姓氏</label>
						
						<input type="text" value="" name="empLastName" id="empLastName"
						class="form-control" placeholder="(exp. 王)"
						onblur="validateName()" required> <span id="LastNameValidation"
						class="error"></span>
				</div>		
					<!-- 名字 -->
				<div class="col-md-5">	
					<label for="staticEmail" class="form-label">名字</label>
						
						<input type="text" value="" name="empFirstName" id="empFirstName"
						class="form-control" placeholder="(exp. 小明)"
						onblur="validateName()" required> <span id="FirstNameValidation"
						class="error"></span>
						
 			 	</div>	
					<!-- 生日 -->
				<div class="col-md-5">
					<label for="staticEmail" class="form-label">生日</label>
						
						<input type="text" value="" name="empBirth" id="empBirth"
						class="form-control" placeholder="2000/01/01"
						 required> <span id="warn_Birthdate"
						class="error"></span>
						
 			 	</div>	
						 <!-- 電話 -->
				<div class="col-md-5">
					<label for="staticEmail" class="form-label">聯絡電話</label>
						
						<input type="text" value="" name="empPhone" id="empPhone"
						class="form-control" placeholder="員工聯絡電話"
						onblur="validatePhone()" required> <span id="PhoneValidation"
						class="error"></span>
						
 			 	</div>	
					<!-- 入職日 -->
				<div class="col-md-5">
					<label for="staticEmail" class="form-label">入職日</label>
						
						<input type="text" value="" name="empHire" id="empHire"
						class="form-control" placeholder="2000/01/01"
						 required> <span id="warn_Hiredate"
						class="error"></span>
						
 			 	</div>
					 <!-- 密碼 -->
				<div class="col-md-5">
					<label for="staticEmail" class="form-label">預設密碼</label>
						
						<input type="text" value="" name="empPwd" id="empPwd"
						class="form-control" placeholder="員工初始密碼"
						onblur="validatePwd()" required> <span id="PwdValidation"
						class="error"></span>
						
 			 	</div>
					<!-- 信箱 -->
				<div class="col-md-10">
					
					<label for="staticEmail" class="form-label">信箱</label>
						
						<input type="text" value="" name="empMail" id="empMail"
						class="form-control" placeholder="員工信箱"
						onblur="validateMail()" required> <span id="MailValidation"
						class="error"></span>
						
 			 	</div>	
					<!-- 居住城市 -->
				<div class="col-md-5">
					<label for="staticEmail" class="form-label">居住縣市</label>
						
						<input type="text" value="" name="empCity" id="empCity"
						class="form-control" placeholder="台北市"
						 required> 
						
 			 	</div>	
					<!-- 居住區別 -->
				<div class="col-md-5">
					<label for="staticEmail" class="form-label">居住區別</label>
						
						<input type="text" value="" name="empDistrict" id="empDistrict"
						class="form-control" placeholder="中正區"
						 required>
						 
 			 	</div> 	
					<!-- 居住詳細 -->
				<div class="col-md-10">
					<label for="staticEmail" class="form-label">地址</label>
						
						<input type="text" value="" name="empAddress" id="empAddress"
						class="form-control" placeholder="凱達格蘭大道"
						 required>
						 
 			 	</div> 	 
					<!-- 部門 -->
				<div class="col-md-4">
					<label for="staticEmail" class="form-label">所屬部門</label>
						
						<select name="EmpDept" id="EmpDept" class="form-control" >
						    <option value=""selected>請選擇新進員工部門</option>
						    <option value="人事部">人事部</option>
						    <option value="貨運部" >貨運部</option>
						    <option value="營銷部">營銷部</option>
						    <option value="營業部">營業部</option>
						    <option value="客服部" >客服部</option>
						</select>
						
 			 	</div>  
					 <!-- 職稱 -->
				<div class="col-md-4">
					<label for="staticEmail" class="form-label">職位</label>
						
						<select name="EmpTitle" id="EmpTitle" class="form-control" >
						
						    <option value="員工">請選擇新進員工職位</option>
						    <option value="員工"selected>員工</option>
						    <option value="主管" >主管</option>
						</select>
						
 			 	</div>  
					 <!-- 權限 -->
				<div class="col-md-2">
					<label for="staticEmail" class="form-label">權限</label>
						
						<select name="EmpAuth" id="EmpAuth" class="form-control" >
						    <option value="2">預設員工權限</option>
						    <option value="1">1</option>
						    <option value="2"selected>2</option>
						</select>
						
 			 	</div>  
 			 	<hr>
					
					<div class="d-grid gap-2 d-md-flex justify-content-md-end">
					
                        <button type="submit" class="btn btn-outline-primary" onclick="if (!(confirm('確認好資料無誤 要新增了嗎?'))) return false">儲存資料</button>
                   
                    </div> 
                        
                    </form>



	</div>
	
	
</body>
</html>