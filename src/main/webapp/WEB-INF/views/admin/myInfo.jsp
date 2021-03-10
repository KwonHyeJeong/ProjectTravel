<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>


<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>내 정보</title>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<style type="text/css">
		table, th, td 
		{
		  border-style : solid;
		  border-width : 1px;
		  text-align : center;
		}
			
		ul 
		{
		  list-style-type: none;
		}
		
		li 
		{
		  display: inline-block;
		}
	
	
		.check_ok
		{
		  color: green;
		  font-family: 고딕체;
		  font-size: 20px;
		}
		
		.check_error
		{
			color:red;
			font-family: 고딕체;
			font-size: 20px;
		}
	.myInfo-page {
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
    .myInfo {
            color: #4CAF50;
            font-family: 'Ubuntu', sans-serif;
            font-weight: bold;
            font-size: 23px;
    }
	
	</style>
	
	
	</head>
	<body>
		 <div class="myInfo-page">
            <div class="form">
              <form class="myInfo-form">
                  
		
		<c:set var="admin" value="${custom.avo }"></c:set>
		
		<div>
			<p>회원번호 : <input type="hidden" id="adminNo" name="adminNo" value="${admin.adminNo }">${admin.adminNo }</p>
			<p>이름 : <input type="hidden" id="adminName" name="adminName" value="${admin.adminName }" readonly="readonly">${admin.adminName }</p>
			<p>아이디 : <input type="hidden" id="adminID" name="adminID" value="${admin.adminID }" readonly="readonly">${admin.adminID }</p>
	
			<p>비밀번호  <input type="password" id="adminPWD" name="adminPWD" value="${admin.adminPWD }" placeholder="비밀번호를 입력하세요." required onblur="regularExpression()"></p>
			<p>비밀번호 재확인 <input type="password" id="PWDcheck" name="PWDcheck" placeholder="비밀번호를 입력하세요."></p>
		</div>
		
		<div id="passwordCheck">
			
		</div>
		
		
		<div>
			<p>이메일  <input type="email" id="adminEmail" name="adminEmail" value="${admin.adminEmail }"></p>
		</div>
		
		
		<div>
			<p>전화번호  <input type="text" id="adminPhone" name="adminPhone" value="${admin.adminPhone }"></p>
		</div>
		<div id="checkPhone"></div>
		
		<div>
			<p>회사 전화번호  <input type="text" id="adminCompany" name="adminCompany" value="${admin.adminCompany }"></p>
		</div>
		<div id="checkCompany"></div>
			
		<div>
			<fmt:formatDate value="${admin.adminBirth }"
	              pattern="yyyy-MM-dd"
	              var ="birthDay"
	            />
			
			<p>생일  <input type="date" id="adminBirth" name="adminBirth" value="${birthDay }"></p>
		</div>	
		
		
		<div>
			<button type="button" id="update_member">정보 수정</button>
			
		</div>
		<br>
		<div>
			<a href="../main/admin"><button type="button">취소</button></a>
			
		</div>	
		<br>
		
		<div>
			<button type="button" id="delete_member">회원 탈퇴</button>	
		</div>
		
		
		
		
		<div id="showInfo">
		
		</div>
		
		<input type="hidden" name="${_csrf.parameterName }" 
												value="${_csrf.token }"/>
			
			
	 </form>
    </div>
  </div>
		
		<script type="text/javascript">
		
		function regularExpression(){
	         var pwd = $('#adminPWD').val();
	         var num = pwd.search(/[0-9]/g);
	         var eng = pwd.search(/[a-z]/ig);
	         var spe = pwd.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);
	         var list = '';
	         
	         if(pwd.length < 8 || pwd.length > 20){
	            list += '<p class=check_error>'
	               + '8자리 ~ 20자리 이내로 입력해주세요.</p>';
	            $('#passwordRegular').html(list);
	            console.log("자리수 맞춰서 pwd : " + pwd);
	         
	         }else if(pwd.search(/\s/) != -1){
	            list += '<p class=check_error>'
	               + '비밀번호는 공백 없이 입력해주세요.</p>';
	            $('#passwordRegular').html(list);
	            console.log("공백 없이 pwd : " + pwd);
	            
	         }else if(num < 0 || eng < 0 || spe < 0 ){
	            list += '<p class=check_error>'
	               + '영문, 숫자, 특수문자를 혼합하여 입력해주세요.</p>';
	            $('#passwordRegular').html(list);
	            console.log("영대문자, 특수문자 pwd : " + pwd);
	            
	         }else {
	            list += '<p class=check_ok>'
	               + '입력에 성공 하셨습니다.</p>';
	            $('#passwordRegular').html(list);
	               console.log("통과"); 
	                return true;
	             }
	      }
		
		
		
		$(document).ready(function(){
			
			
			var title1 = $('#freeTitle').val();
			var content1 = $('#freeContent').val();
			
			var no = $('#freeNo').val();
			
			
			$('#PWDcheck').on('blur', function(){
				
				var pwd = $('#adminPWD').val();
				var checkPWD = $('#PWDcheck').val();
				
				console.log(pwd);
				console.log(checkPWD);
				var list = '';
				
				if(checkPWD === pwd)
				{
					list += '<p class=check_ok>'
							+ '비밀번호가 일치합니다.</p>';
				
					$('#passwordCheck').html(list);
					
				}
				else
				{
					
					list += '<p class=check_error>'
						+ '비밀번호가 일치하지 않습니다. 다시 입력해주세요.</p>';
					$('#passwordCheck').html(list);
					
				}
				
			});	// end PWDcheck blur
			
			
			$('#adminPhone').on('blur', function(){
				
				
				var phone = $('#adminPhone').val();
				console.log(phone);
				
				
				var phoneStr = /^\d{3}-\d{3,4}-\d{4}$/;

				
				if(!phoneStr.test(phone))
				{
					$('#checkPhone').html('<p class="check_error"> 휴대폰 번호 형식이 틀렸습니다. 올바른 형식으로 입력해주세요.</p>');
					$('#adminPhone').val('');
					
				}
				else
				{
					$('#checkPhone').html('');
				}
				
				
				
			});	// end adminPhone blur
			
			
			$('#adminCompany').on('blur', function(){
				
				
				var company = $('#adminCompany').val();
				console.log(company);
				
				
				var phoneStr = /^\d{2,3}-\d{3,4}-\d{4}$/;
				
				if(!phoneStr.test(company))
				{
					$('#checkCompany').html('<p class="check_error"> 휴대폰 번호 형식이 틀렸습니다. 올바른 형식으로 입력해주세요.</p>');
					$('#adminCompany').val('');
					
				}
				else
				{
					$('#checkCompany').html('');
				}
				
				
				
			});	// end adminCompany blur
			
			
			$('#update_member').click(function(){
				console.log("start update");
				
				var adminNo = $('#adminNo').val();
				var adminName = $('#adminName').val();
				var adminID = $('#adminID').val();
				var adminPWD = $('#adminPWD').val();
				var adminEmail = $('#adminEmail').val();
				var adminPhone = $('#adminPhone').val();
				var adminCompany = $('#adminCompany').val();
				var adminBirth = $('#adminBirth').val();
				
				
				var csrfHeaderName = "${_csrf.headerName}";
				var csrfTokenValue = "${_csrf.token}";
				
				
				console.log('생일' + adminBirth);
				console.log(csrfHeaderName);
				console.log(csrfTokenValue);
				
				var adminObj = {
					
					'adminNo' : adminNo,
					'adminName' : adminName,
					'adminID' : adminID,
					'adminPWD' : adminPWD,
					'adminPhone' : adminPhone,
					'adminCompany' : adminCompany,
					'adminEmail' : adminEmail,
					'adminBirth' : adminBirth
					
						
				};
				console.log(adminObj);
				
	            
                
				
				// ajax 요청
				$.ajax({
					type : 'put',
					url : '../admin/adminUpdate/' + adminID,
					headers:{
						 'Content-Type' : 'application/json',
			      	      'X-HTTP-Method-Override' : 'PUT'
						
					},
					data : JSON.stringify({
						
						'adminNo' : adminNo,
						'adminName' : adminName,
						'adminID' : adminID,
						'adminPWD' : adminPWD,
						'adminPhone' : adminPhone,
						'adminCompany' : adminCompany,
						'adminEmail' : adminEmail,
						'adminBirth' : adminBirth
						
					}),
					success : function(result, status)
					{
						console.log(result);
						console.log(status);
						
						if(result === 'success')
						{
							
							location.href="/travel06/main/admin";
							alert('회원정보 수정 성공!');
						}
						else if(result === 'fail')
						{
							alert('회원정보 수정 실패 ㅠㅠ');
						}
						
							
						
					}	// end success
					
					
				});	// end ajax
				
				
				
			});	// end update_member click
			
			
			
			$('#delete_member').click(function(){
				console.log('회원 탈퇴 과정 시작');
				
				
				var adminNo = $('#adminNo').val();
				var adminName = $('#adminName').val();
				var adminID = $('#adminID').val();
				var adminPWD = $('#adminPWD').val();
				var adminEmail = $('#adminEmail').val();
				var adminPhone = $('#adminPhone').val();
				var adminCompany = $('#adminCompany').val();
				var adminBirth = $('#adminBirth').val();
			
				
				var obj = {
					'adminNo' : adminNo,
					'adminName' : adminName,
					'adminID' : adminID,
					'adminPWD' : adminPWD,
					'adminEmail' : adminEmail,
					'adminPhone' : adminPhone,
					'adminCompany' : adminCompany,
					'adminBirth' : adminBirth
						
				};
				console.log(obj);
				
				
				
				
				$.ajax({
					type : 'get',
					url : 'AdminDeleteConfirm/' + adminID,
					headers:{
						 'Content-Type' : 'application/json',
			      	      'X-HTTP-Method-Override' : 'GET'
						
					},
					success : function(result, status)
					{
						console.log(result);
						console.log(status);
						if(result == 'confirm')
						{
							
							console.log('회원 탈퇴 이유 적기');
							location.href="/travel06/admin/delete-confirm";
						}
						else if(result == 'fail')
						{
							alert('회원 탈퇴 여부 묻기 실패ㅠㅠ');
							location.href="/travel06/admin/myInfo";
						}
							
						
					}	// end success
					
					
				});	// end ajax
				
				
				
			});	// end delete_member click
			
			
			
			
			
		});	// end document
		
		
		
		</script>
		
		
		
	</body>
</html>