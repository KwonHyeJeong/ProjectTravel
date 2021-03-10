<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>가입정보로 관리자 ID 찾기</title>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<style>
	.check_ok{
	  color: green;
	  font-family: 고딕체;
	  font-size: 20px;
	}
	
	.check_error{
		color:red;
		font-family: 고딕체;
		font-size: 20px;
	}
    .findAdminID-page {
    width: 600px;
    padding: 8% 0 0;
    margin: auto;
    }
    .form {
      position: relative;
      z-index: 1;
      background: #FFFFFF;
      max-width: 5000px;
      margin: 0 auto 100px;
      padding: 45px;
      text-align: center;
      box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
    }
    .form input {
      font-family: "Roboto", sans-serif;
      outline: 0;
      background: #f2f2f2;
      width: 100%;
      border: 0;
      margin: 0 0 15px;
      padding: 15px;
      box-sizing: border-box;
      font-size: 14px;
    }
    body {
      background: #76b852; /* fallback for old browsers */
      background: -webkit-linear-gradient(right, #76b852, #8DC26F);
      background: -moz-linear-gradient(right, #76b852, #8DC26F);
      background: -o-linear-gradient(right, #76b852, #8DC26F);
      background: linear-gradient(to left, #76b852, #8DC26F);
      font-family: "Roboto", sans-serif;
      -webkit-font-smoothing: antialiased;
      -moz-osx-font-smoothing: grayscale;      
    }
    .form button {
      font-family: "Roboto", sans-serif;
      text-transform: uppercase;
      outline: 0;
      background: #4CAF50;
      width: 100%;
      border: 0;
      padding: 15px;
      color: #FFFFFF;
      font-size: 14px;
      -webkit-transition: all 0.3 ease;
      transition: all 0.3 ease;
      cursor: pointer;
    }
    .form button:hover,.form button:active,.form button:focus {
      background: #43A047;
    }
    .findAdminID {
            color: #4CAF50;
            font-family: 'Ubuntu', sans-serif;
            font-weight: bold;
            font-size: 23px;
    }
	
	</style>
	</head>
	<body>
		
		<form name="Find_adminID_Form" action="findAdminID" 
										method="POST">
		  <div class="findAdminID-page">
            <div class="form">
              <form class="findAdminID-form">
                <p class="findAdminID" align="center">가입정보로 관리자 ID 찾기</p>

			<div id="nameDiv">
				<label>이름</label> <br>
				<input type="text" id="name" name="adminName" 
								required="required"><br><br>
			</div>
			
			
			<div id="phoneDiv">
				<label>휴대폰</label><br>
				
				<input type="hidden" id="phone1">
				<select name="phoneSelect" id="phoneSelect" onchange="phoneChange(this);">
					<option>선택하세요</option>
					<option value="010">010</option>
					<option value="011">011</option>
					<option value="016">016</option>
					<option value="017">017</option>
					<option value="018">018</option>
					<option value="019">019</option>
				</select>
				- <input style="width:150px;" type="text" id="phone2" size="5" required> - <input style="width:150px;" type="text" id="phone3" size="5" required>
				
				<br>
				<input type="hidden" id="phone" name="adminPhone">
				
				
				<div id="checkPhone"></div>
				
			</div>
			
			
			
			<div id="companyDiv">
				<label>회사 전화번호</label> <br>
				
				<input type="hidden" id="com1">
				<select name="companySelect" id="companySelect" 
								onchange="companyChange(this);">
				<option>선택하세요</option>
				<option value="02">02</option>
				<option value="031">031</option>
				<option value="032">032</option>
				<option value="033">033</option>
				<option value="041">041</option>
				<option value="042">042</option>
				<option value="043">043</option>
				<option value="051">051</option>
				<option value="052">052</option>
				<option value="053">053</option>
				<option value="054">054</option>
				<option value="055">055</option>
				<option value="061">061</option>
				<option value="062">062</option>
				<option value="063">063</option>
				<option value="064">064</option>
				
				</select>
				- <input style="width:150px;" type="text" id="com2" size="5"> 
				- <input style="width:150px;" type="text" id="com3" size="5"><br>
		
		
				<input type="hidden" id="adminCompany" 
										name="adminCompany" required>
			
				<div id="checkCompany"></div>
				
			</div>
			
			
			
			
			<input type="hidden" name="${_csrf.parameterName }" 
											value="${_csrf.token }"/>
			
			<input type="submit" value="찾기">
			
			<br>
    		
    		
    		<div>
    			<a href="../main/all"><button type="button">취소</button></a>
    		</div>
			</form>
		                   
            </div>
          </div>
          </form>
		
		<script type="text/javascript">
			
		function phoneChange(cellPhone)
		{
			var phoneText = cellPhone[cellPhone.selectedIndex].value;
			console.log(phoneText);
			$('#phone1').val(phoneText);
			
		}
		
		function companyChange(com)
		{
			var companyText = com[com.selectedIndex].value;
			console.log(companyText);
			$('#com1').val(companyText);
			
		}
		
		
		
		$(document).ready(function(){
			
			
			$('#phone3').on('blur', function(){
				
				var phone1 = $('#phone1').val();
				var phone2 = $('#phone2').val();
				var phone3 = $('#phone3').val();
				
				var str = phone1 + "-" + phone2 + "-" + phone3;
				$('#phone').val(str);
				var phone = $('#phone').val();
				console.log(phone);
				
				
				var phoneStr = /^\d{3}-\d{3,4}-\d{4}$/;
				
				if(!phoneStr.test(phone))
				{
					$('#checkPhone').html('<p class="check_error"> 휴대폰 번호 형식이 틀렸습니다. 올바른 형식으로 입력해주세요.</p>');
					$('#phone2').val('');
					$('#phone3').val('');
				}
				else
				{
					$('#checkPhone').html('');
				}
				
				
				
			});	// end phone3 blur
			
			
			
			$('#com3').on('blur', function(){
				
				var com1 = $('#com1').val();
				var com2 = $('#com2').val();
				var com3 = $('#com3').val();
				
				var str = com1 + "-" + com2 + "-" + com3;
				$('#adminCompany').val(str);
				var phone = $('#adminCompany').val();
				console.log(phone);
				
				
				var phoneStr = /^\d{2,3}-\d{3,4}-\d{4}$/;
				
				if(!phoneStr.test(phone))
				{
					$('#checkCompany').html('<p class="check_error"> 휴대폰 번호 형식이 틀렸습니다. 올바른 형식으로 입력해주세요.</p>');
					$('#com2').val('');
					$('#com3').val('');
				}
				else
				{
					$('#checkCompany').html('');
				}
				
				
				
			});	// end com3 blur
			
			
			
			
			
		});	// end document
		
		
		
		
		
		
		
		</script>
		
		
		
		
	</body>
	
</html>