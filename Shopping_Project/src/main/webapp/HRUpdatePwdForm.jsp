<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 引用函式庫 核心函式庫 c -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.entity.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改密碼</title>
<link rel="stylesheet"
 href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
 integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
 crossorigin="anonymous">
</head>
<body>
	<c:set var="hrSystemPass" value="${sessionScope.HRsystemPass}" />
	
	<a href="HRSystemMainPage.do" class="btn btn-outline-secondary">返回主頁</a>
	<h2>更改密碼表單</h2>
	
	<form action="HRUpdatePwdPage.do" method="post" class="row g-3">
		<!-- 姓氏 -->
				<div class="col-md-5">
					<label for="username" class="form-label"> 姓名</label>
						
						<input type="text" value="${hrSystemPass.lastName} ${hrSystemPass.firstName}" name="empName" id="empName"
						class="form-control" autocomplete="off" required readonly > 
				</div>		
		<!-- id -->
				<div class="col-md-5">	
					<label for="staticEmail" class="form-label">員工ID</label>
						
						<input type="text" value="${hrSystemPass.employeeId}" name="empid" id="empid"
						class="form-control" autocomplete="off" required readonly> 
						
 			 	</div>
 		<!-- 密碼 -->
				<div class="col-md-5">
					<label for="staticEmail" class="form-label">重設密碼</label>
						
						<input type="password" name="empPwd" id="pwd" class="form-control" autocomplete="off"
						 required> <span id="warn_pwd"></span>
						
 			 	</div>
 			 	
 		<!-- 再次密碼 -->	 	
 			 	<div class="col-md-5">
					<label for="staticEmail" class="form-label">再次輸入密碼</label>
						
						<input type="password" id="checkPassword" name="checkPassword"
						class="form-control" autocomplete="off"
						onblur="doubleCheckPwd()" required> <span id="warn_pwd"></span>
						
 			 	</div>	
 			 	
 			 	
 			 	
 			 	<div class="d-grid gap-2 d-md-flex justify-content-md-end">
					
                        <button type="submit"  id="submitButton" class="btn btn-outline-primary" onclick="if (!(confirm('確認好要修改了嗎?'))) return false">儲存密碼</button>
                   
                </div> 
      
	</form>
	<script type="text/javascript">
	 ////---------------pwd check-----------------
    document.getElementById("pwd").addEventListener("blur", function () {
        let pwdObject = document.getElementById("pwd")
        let pwdValue = pwdObject.value;
        let pwdCount = pwdValue.length;
        console.log(`使用者所輸入的密碼為: ${pwdValue}，長度為: ${pwdCount}`)
        let printPwdWarn = document.getElementById("warn_pwd")
        let ch;
        let flag1 = false, flag2 = false,  flag4 = true;

        if (pwdValue == "") //當未輸入
            printPwdWarn.innerHTML = "<img src='images/error.png'>不可空白";
        else if (pwdCount >= 6 && pwdCount <= 20) {
            for (let i = 0; i < pwdCount; i++) { //將密碼中的字符一個個抓出來比對
                ch = pwdValue.charAt(i).toUpperCase();
                // console.log(ch);
                if (ch >= "A" && ch <= "Z")
                    flag1 = true;
                else if (ch >= "0" && ch <= "9")
                    flag2 = true;
                else if (ch = " ")
                    flag4 = false;
                if (flag1 && flag2) break;
            }//for end
            if (flag4 == true) {
                if (flag1 && flag2)
                    printPwdWarn.innerHTML = "<img src='images/correct.png'>成功"
                else if (flag1)
                    printPwdWarn.innerHTML = "<img src='images/error.png'>必須包含數字"
                else if (flag2)
                    printPwdWarn.innerHTML = "<img src='images/error.png'>必須包含英文字母"
                else
                    printPwdWarn.innerHTML = "<img src='images/error.png'>失敗"

            } else {
                printPwdWarn.innerHTML = "<img src='images/error.png'>密碼中不可有空白"
            }
        } else {
            printPwdWarn.innerHTML = "<img src='images/error.png'>密碼長度必須>=6或<=20";
        }
    }
    );

	
	///-----------再次輸入密碼驗證---------------------
    function doubleCheckPwd() {
        var pwdInput = document.getElementById('pwd').value;
        var pwdValidation = document.getElementById('checkPassword').value;
        var submitButton = document.getElementById('submitButton');

        if (pwdInput === pwdValidation) {
            submitButton.disabled = false;
        } else {
            submitButton.disabled = true;
            alert("密碼不一致，请重新输入。");
        }
    }
	
	
	</script>
</body>
</html>