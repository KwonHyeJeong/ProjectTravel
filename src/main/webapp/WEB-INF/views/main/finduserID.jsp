<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     

    
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>가입정보로 ID 찾기</title>
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
    .findId-page {
    width: 800px;
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
    .findId {
            color: #4CAF50;
            font-family: 'Ubuntu', sans-serif;
            font-weight: bold;
            font-size: 23px;
    }
	
	</style>
	
	
	</head>
	<body>
		
		
		<form name="Find_ID_Form" action="finduserID" method="POST">
		  <div class="findId-page">
            <div class="form">
              <form class="findId-form">
                      <p class="findId" align="center">회원 ID 찾기</p>
            			<div id="nameDiv">
            				<label>이름</label> <br>
            				<input type="text" id="name" name="userName" required="required"><br><br>
            			</div>
            	
            			<div id="birthDiv" class="joinBirth">
            				<label>생년월일</label><br>
            				<p>
            				월과 일은 2자리로 입력해주세요. <br>
            				ex) 6월 4일 -> 06월 04일		
            				</p>
            				<br>
            				<input style="width:150px;" type="text" id="birthYear" maxlength="4" size="4"> 년
            				<input style="width:150px;" type="text" id="birthMonth" maxlength="2" size="3"> 월
            				<input style="width:150px;" type="text" id="birthDay" maxlength="2" size="3"> 일<br>
            			
            				<input type="hidden" id="resultBirth" name="userBirth"><br>
            				
            			</div>
            			<div id="phoneDiv">
            				<label>휴대폰</label><br>
            				<p>휴대폰 번호 형식 : 010-XXXX-XXXX(띄어쓰기 하지마세요...)</p><br>
            				
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
            				<input type="hidden" id="phone" name="userPhone">
            				
            				
            				<div id="checkPhone">
            				</div>
            				<br>
            				
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
		
		
		
		$(document).ready(function(){
			
			
			var year = $('#birthYear').val();
			var month = $('#birthMonth').val();
			var day = $('#birthDay').val();
			
			var joinResult = '';
			
			
			
			// 생년월일 중 연도 형식 check
			$('#birthYear').on('blur', function(){
				
				var yearRule = /^\d{4}$/g;
				var year = $('#birthYear').val();
				console.log(year);
				
				if(!yearRule.test(year))
				{
					$('#birthYear').val('');
					
				}
				
				
			});	// end birthYear blur
			
			// 생년월일 중 월 형식 check
			$('#birthMonth').on('blur', function(){
				
				var monthRule = /^\d{2}$/g;
				var month = $('#birthMonth').val();
				console.log(month);
				
				if(!monthRule.test(month))
				{
					$('#birthMonth').val('');
					
				}
				
				
			});	// end birthMonth blur
			
			
			// 생년월일 중 일 형식 check
			$('#birthDay').on('blur', function(){
				
				var dayRule = /^\d{2}$/g;
				var day = $('#birthDay').val();
				console.log(day);
				
				if(!dayRule.test(day))
				{
					$('#birthDay').val('');
					
				}
				
				// 생년월일 check 끝난 후 DB에 들어갈수 있는 형식으로 바꿈
				var joinStr = $('#birthYear').val() +'/'+ $('#birthMonth').val() +'/'+ $('#birthDay').val();
				
				$('#resultBirth').val(joinStr);
				
				console.log($('#resultBirth').val());
				
				// $('#resultBirth').attr("type", "text");
				
				
			
			
			});	// end birthDay blur
			
			
			
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
			
			
			
			
			
			
			
		});	// end document
		
		
		
		</script>
		
		
	</body>
</html>