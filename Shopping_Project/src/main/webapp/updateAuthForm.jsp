<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<title>update employee authority</title>
</head>
<body>
	<div class="container">

		<form action="HRSaveAuth.do" method="post">
			<h3>更改權限表單</h3>
			<hr>
			<div>
				<h5>員工ID:&nbsp;${requestScope.updateEmp.employeeId}</h5>
				<h5>員工姓名:&nbsp;${requestScope.updateEmp.lastName}&nbsp;${requestScope.updateEmp.firstName}</h5>
				<h5>員工職稱:&nbsp;${requestScope.updateEmp.department}&nbsp;${requestScope.updateEmp.title}</h5>

			</div>
			<input type="hidden" value="${requestScope.updateEmp.employeeId}"
				name="employeeId" readonly="readonly" /> 
				<input type="hidden" value="${requestScope.updateEmp.dbAuthority}" name="dbAuthorityOriginal"
				readonly="readonly" />
			<div>
				<h6>2員工權限;1主管/最高權限</h6>
				<input type="text" value="" name="dbAuthority" id="dbAuthority"
					class="form-control mb-4 w-25" placeholder="請給予權限值"
					onblur="validateAuth()" required> <span id="AuthValidation"
					class="error"></span>
			</div>

			<button type="submit" class="btn btn-info col-2"
				onclick="submitForm()" id="button">Save</button>

		</form>

	</div>
	<script type="text/javascript">
		function validateAuth() {
			var inputField = document.getElementById('dbAuthority');
			var inputValue = inputField.value;

			var authWarn = document.getElementById('AuthValidation');
			var submitButton = document.getElementById('button');
			// 檢查是否只包含1到2之間的數字
			var regex = /^[1-2]$/;

			if (regex.test(inputValue)) {
				authWarn.innerHTML = ('正確');
				submitButton.disabled = false; // 啟用按鈕
			} else {
				authWarn.innerHTML = ('輸入錯誤，權限範圍僅1-2');
				submitButton.disabled = true; // 禁用按鈕
			}
		}
		function submitForm() {
			alert('權限更新表單已提交');
		}
	</script>
</body>
</html>