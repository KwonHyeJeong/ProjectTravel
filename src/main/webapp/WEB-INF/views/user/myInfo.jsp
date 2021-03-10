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
		
        		<c:set var="user" value="${custom.uvo }"></c:set>
        		
        		<div>
        			<p>회원번호 : <input type="hidden" id="userNo" name="userNo" value="${user.userNo }">${user.userNo }</p>
        			<p>이름 : <input type="hidden" id="userName" name="userName" value="${user.userName }" readonly="readonly">${user.userName }</p>
        			<p>아이디 : <input type="hidden" id="userID" name="userID" value="${user.userID }" readonly="readonly">${user.userID }</p>
        	
        			<p>비밀번호  <input type="password" id="userPWD" name="userPWD" value="${user.userPWD }" placeholder="비밀번호를 입력하세요." required onblur="regularExpression();"></p>
        			<p>비밀번호 재확인 <input type="password" id="PWDcheck" name="PWDcheck" placeholder="비밀번호를 입력하세요."></p>
        		</div>
        		
        			<div id="passwordCheck">
        				
        			</div>
        		
        		
        		<div>
        			<p>이메일 <input type="email" id="userEmail" name="userEmail" value="${user.userEmail }"></p>
        		</div>
        		
        		<div>
        			<p>전화번호  <input type="text" id="userPhone" name="userPhone" value="${user.userPhone }"></p>
        		</div>
        		
        		<div id="checkPhone"></div>
        		
        		<div>	
        			<fmt:formatDate value="${user.userBirth }"
        	              pattern="yyyy-MM-dd"
        	              var ="birthDay"
        	            />
        			
        			<p>생일  <input type="date" id="userBirth" name="userBirth" value="${birthDay }"></p>
        		</div>	
        			
        			
        			
        		<div>	
        			
        			<c:forEach var="freevo" items="${freePageList }">
        				<input type="hidden" id="beforeNickName1" value="${freevo.userNickname }">
        				<input type="hidden" id="freeNo" value="${freevo.freeNo }">
        				<input type="hidden" id="freeTitle" value="${freevo.freeTitle }">
        				<input type="hidden" id="freeContent" value="${freevo.freeContent }">
        				
        			</c:forEach>
        			
        			
        			<c:forEach var="freeReviewVO" items="${freeReviewList }">
        				<input type="hidden" id="beforeNickName2" value="${freeReviewVO.userNickname }">
        				<input type="hidden" id="freeReviewNo" value="${freeReviewVO.freeReviewNo }">
        				<input type="hidden" id="freeNo2" value="${freeReviewVO.freeNo }">
        				<input type="hidden" id="freeReviewContent" value="${freeReviewVO.freeReviewContent }">
        				
        			</c:forEach>
        			
        			
        			<c:forEach var="foodvo" items="${foodPageList }">
        				<input type="hidden" id="beforeNickName3" value="${foodvo.userNickname }">
        				<input type="hidden" id="foodNo1" value="${foodvo.foodNo }">
        				<input type="hidden" id="foodTitle" value="${foodvo.foodTitle }">
        				<input type="hidden" id="foodContent" value="${foodvo.foodContent }">
        				
        			</c:forEach>
        			
        			
        			<c:forEach var="foodReviewVO" items="${foodReviewList }">
        				<input type="hidden" id="beforeNickName4" value="${foodReviewVO.userNickname }">
        				<input type="hidden" id="foodReviewNo" value="${foodReviewVO.foodReviewNo }">
        				<input type="hidden" id="foodNo2" value="${foodReviewVO.foodNo }">
        				<input type="hidden" id="foodReviewContent" value="${foodReviewVO.foodReviewContent }">
        				
        			</c:forEach>
        			
        			
        			<c:forEach var="playvo" items="${playPageList }">
        				<input type="hidden" id="beforeNickName5" value="${playvo.userNickname }">
        				<input type="hidden" id="playNo1" value="${playvo.playNo }">
        				<input type="hidden" id="playTitle" value="${playvo.playTitle }">
        				<input type="hidden" id="playContent" value="${playvo.playContent }">
        				
        			</c:forEach>
        			
        			
        			<c:forEach var="playReviewVO" items="${playReviewList }">
        				<input type="hidden" id="beforeNickName6" value="${playReviewVO.userNickname }">
        				<input type="hidden" id="playReviewNo" value="${playReviewVO.playReviewNo }">
        				<input type="hidden" id="playNo2" value="${playReviewVO.playNo }">
        				<input type="hidden" id="playReviewContent" value="${playReviewVO.playReviewContent }">
        				
        			</c:forEach>
        			
        			
        			
        			
        			<c:forEach var="thema" items="${themaPageList }">
        				<input type="hidden" id="beforeNickName7" value="${thema.userNickname }">
        				<input type="hidden" id="themaNo1" value="${thema.themaNo }">
        				<input type="hidden" id="themaTitle" value="${thema.themaTitle }">
        				<input type="hidden" id="themaContent" value="${thema.themaContent }">
        				
        			</c:forEach>
        			
        			
        			<c:forEach var="themaReviewVO" items="${themaReviewList }">
        				<input type="hidden" id="beforeNickName8" value="${themaReviewVO.userNickname }">
        				<input type="hidden" id="themaReviewNo" value="${themaReviewVO.themaReviewNo }">
        				<input type="hidden" id="themaNo2" value="${themaReviewVO.themaNo }">
        				<input type="hidden" id="themaReviewContent" value="${themaReviewVO.themaReviewContent }">
        				
        			</c:forEach>
        			
        			
        			
        			
        
        			<p>닉네임  <input type="text" id="afterNickName" name="userNickName" value="${user.userNickName }"> </p>
        			
        		</div>
        			
        		
        			<div>
        				<button type="button" id="update_member">정보 수정</button>
        			</div>
        			<br>
        			<div>
        				<a href="../main/user"><button type="button">취소</button></a>
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
	         var pwd = $('#userPWD').val();
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
			
			
			
			$('#PWDcheck').on('blur', function(){
				
				var pwd = $('#userPWD').val();
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
			
			$('#userPhone').on('blur', function(){
				
				
				var phone = $('#userPhone').val();
				console.log(phone);
				
				
				var phoneStr = /^\d{3}-\d{3,4}-\d{4}$/;

				
				if(!phoneStr.test(phone))
				{
					$('#checkPhone').html('<p class="check_error"> 휴대폰 번호 형식이 틀렸습니다. 올바른 형식으로 입력해주세요.</p>');
					$('#userPhone').val('');
					
				}
				else
				{
					$('#checkPhone').html('');
				}
				
				
				
			});	// end userPhone blur
			
			
			
			$('#afterNickName').on('blur', function(){
				
				// 변경할 별명 변수
				var after = $('#afterNickName').val();
				
				// freeObj의 번수
				var before1 = $('#beforeNickName1').val();
				var title = $('#freeTitle').val();
				var content = $('#freeContent').val();
				var no = $('#freeNo').val();
				
				
				// freeReviewObj의 변수
				var before2 = $('#beforeNickName2').val();
				var reviewContent = $('#freeReviewContent').val();
				var freeReviewNo = $('#freeReviewNo').val();
				var freeno2 = $('#freeNo2').val();
				
				
				// foodObj의 변수
				var before3 = $('#beforeNickName3').val();
				var foodTitle = $('#foodTitle').val();
				var foodContent = $('#foodContent').val();
				var foodNo1 = $('#foodNo1').val();
				
				
				// foodReivewObj의 변수
				var before4 = $('#beforeNickName4').val();
				var foodReviewContent = $('#foodReviewContent').val();
				var foodReviewNo = $('#foodReviewNo').val();
				var foodNo2 = $('#foodNo2').val();
				
				
				// playObj의 변수
				var before5 = $('#beforeNickName5').val();
				var playTitle = $('#playTitle').val();
				var playContent = $('#playContent').val();
				var playNo1 = $('#playNo1').val();
				
				
				// playReivewObj의 변수
				var before6 = $('#beforeNickName6').val();
				var playReviewContent = $('#playReviewContent').val();
				var playReviewNo = $('#playReviewNo').val();
				var playNo2 = $('#playNo2').val();
				
				
				
				// themaObj의 변수
				var before7 = $('#beforeNickName7').val();
				var themaTitle = $('#themaTitle').val();
				var themaContent = $('#themaContent').val();
				var themaNo1 = $('#themaNo1').val();
				
				
				// themeReivewObj의 변수
				var before8 = $('#beforeNickName8').val();
				var themaReviewContent = $('#themaReviewContent').val();
				var themaReviewNo = $('#themaReviewNo').val();
				var themaNo2 = $('#themaNo2').val();
				
				
				
				
				var freeObj = {
						
						'freeNo' : no,
						'freeTitle' : title,
						'freeContent' : content,
						'beforeNickName' : before1,
						'userNickname' : after
						
				};
				console.log(freeObj);
				
				var freeReviewObj = {
					
					'freeReviewNo' : freeReviewNo,
					'freeNo' : freeno2,
					'freeReviewContent' : reviewContent,
					'beforeNickName' : before2,
					'userNickname' : after
						
				};
				
				console.log(freeReviewObj);
				
				
				var foodObj = {
						
						'foodNo' : foodNo1,
						'foodTitle' : foodTitle,
						'foodContent' : foodContent,
						'beforeNickName' : before3,
						'userNickname' : after
						
				};
				console.log(foodObj);
				
				var foodReviewObj = {
					
					'foodReviewNo' : foodReviewNo,
					'foodNo' : foodNo2,
					'foodReviewContent' : foodReviewContent,
					'beforeNickName' : before4,
					'userNickname' : after
						
				};
				
				console.log(foodReviewObj);
				
				
				var playObj = {
						
						'playNo' : playNo1,
						'playTitle' : playTitle,
						'playContent' : playContent,
						'beforeNickName' : before5,
						'userNickname' : after
						
				};
				console.log(playObj);
				
				var playReviewObj = {
					
					'playReviewNo' : playReviewNo,
					'playNo' : playNo2,
					'playReviewContent' : playReviewContent,
					'beforeNickName' : before4,
					'userNickname' : after
						
				};
				
				console.log(playReviewObj);
				
				
				var themaObj = {
						
						'themaNo' : themaNo1,
						'themaTitle' : themaTitle,
						'themaContent' : themaContent,
						'beforeNickName' : before3,
						'userNickname' : after
						
				};
				console.log(themaObj);
				
				var themaReviewObj = {
					
					'themaReviewNo' : themaReviewNo,
					'themaNo' : themaNo2,
					'themaReviewContent' : themaReviewContent,
					'beforeNickName' : before4,
					'userNickname' : after
						
				};
				
				console.log(themaReviewObj);
				
				
				
				// 자유게시판 닉네임 변경 ajax 요청
				$.ajax({
					type : 'put',
					url : '../free/updateNickName/' + before1,
					headers:{
						 'Content-Type' : 'application/json',
			      	      'X-HTTP-Method-Override' : 'PUT'
						
					},
					data : JSON.stringify({
						
						'freeNo' : no,
						'freeTitle' : title,
						'freeContent' : content,
						'userNickname' : after
						
						
					}),
					success : function(result, status)
					{
						console.log(result);
						console.log(status);
						if(result == 'good')
						{
							alert('정보 수정버튼 누르세요.');
						}
						else if(result == 'bad')
						{
							console.log('닉네임 변경 안함');
						}
							
						
					}	// end success
					
					
				});	// end ajax
				
				
			
	            
				// 자유게시판 댓글 닉네임 변경
				$.ajax({
					type : 'put',
					url : '../free/replies/updateNickName/' + before2,
					headers:{
						 'Content-Type' : 'application/json',
			      	      'X-HTTP-Method-Override' : 'PUT'
						
					},
					data : JSON.stringify({
						
						'freeReviewNo' : freeReviewNo,
						'freeNo' : freeno2,
						'freeReviewContent' : reviewContent,
						'userNickname' : after
						
						
					}),
					success : function(result, status)
					{
						console.log(result);
						console.log(status);
						if(result == 'good2')
						{
							alert('정보 수정버튼 누르세요.');
						}
						else if(result == 'bad2')
						{
							console.log('닉네임 변경 안함');
						}
						
					}	// end success
					
					
				});	// end ajax
				
				
				
				// 음식게시판 닉네임 변경 ajax 요청
				$.ajax({
					type : 'put',
					url : '../food/updateNickName/' + before3,
					headers:{
						 'Content-Type' : 'application/json',
			      	      'X-HTTP-Method-Override' : 'PUT'
						
					},
					data : JSON.stringify({
						
						'foodNo' : foodNo1,
						'foodTitle' : foodTitle,
						'foodContent' : foodContent,
						'userNickname' : after
						
						
					}),
					success : function(result, status)
					{
						console.log(result);
						console.log(status);
						
						if(result == 'bad3')
						{
							console.log('닉네임 변경 안함');
						}
						
						
					}	// end success
					
					
				});	// end ajax
				
				
			
	            
				// 음식게시판 댓글 닉네임 변경
				$.ajax({
					type : 'put',
					url : '../food/replies/updateNickName/' + before4,
					headers:{
						 'Content-Type' : 'application/json',
			      	      'X-HTTP-Method-Override' : 'PUT'
						
					},
					data : JSON.stringify({
						
						'foodReviewNo' : foodReviewNo,
						'foodNo' : foodNo2,
						'foodReviewContent' : foodReviewContent,
						'userNickname' : after
						
						
					}),
					success : function(result, status)
					{
						console.log(result);
						console.log(status);
						if(result == 'bad4')
						{
							console.log('닉네임 변경 안함');
						}
						
					}	// end success
					
					
				});	// end ajax
				
				
				
				// 놀거리게시판 닉네임 변경 ajax 요청
				$.ajax({
					type : 'put',
					url : '../play/updateNickName/' + before5,
					headers:{
						 'Content-Type' : 'application/json',
			      	      'X-HTTP-Method-Override' : 'PUT'
						
					},
					data : JSON.stringify({
						
						'playNo' : playNo1,
						'playTitle' : playTitle,
						'playContent' : playContent,
						'userNickname' : after
						
						
					}),
					success : function(result, status)
					{
						console.log(result);
						console.log(status);
						
						if(result == 'bad5')
						{
							console.log('닉네임 변경 안함');
						}
						
						
					}	// end success
					
					
				});	// end ajax
				
				
			
	            
				// 놀거리 게시판 댓글 닉네임 변경
				$.ajax({
					type : 'put',
					url : '../play/replies/updateNickName/' + before6,
					headers:{
						 'Content-Type' : 'application/json',
			      	      'X-HTTP-Method-Override' : 'PUT'
						
					},
					data : JSON.stringify({
						
						'playReviewNo' : playReviewNo,
						'playNo' : playNo2,
						'playReviewContent' : foodReviewContent,
						'userNickname' : after
						
						
					}),
					success : function(result, status)
					{
						console.log(result);
						console.log(status);
						if(result == 'bad6')
						{
							console.log('닉네임 변경 안함');
						}
						
					}	// end success
					
					
				});	// end ajax
				
				
				// 테마 게시판 닉네임 변경 ajax 요청
				$.ajax({
					type : 'put',
					url : '../theme/updateNickName/' + before7,
					headers:{
						 'Content-Type' : 'application/json',
			      	      'X-HTTP-Method-Override' : 'PUT'
						
					},
					data : JSON.stringify({
						
						'themaNo' : themaNo1,
						'themaTitle' : themaTitle,
						'themaContent' : themaContent,
						'userNickname' : after
						
						
					}),
					success : function(result, status)
					{
						console.log(result);
						console.log(status);
						
						if(result == 'bad7')
						{
							console.log('닉네임 변경 안함');
						}
						
						
					}	// end success
					
					
				});	// end ajax
				
				
			
	            
				// 음식게시판 댓글 닉네임 변경
				$.ajax({
					type : 'put',
					url : '../theme/replies/updateNickName/' + before8,
					headers:{
						 'Content-Type' : 'application/json',
			      	      'X-HTTP-Method-Override' : 'PUT'
						
					},
					data : JSON.stringify({
						
						'themaReviewNo' : themaReviewNo,
						'themaNo' : themaNo2,
						'themaReviewContent' : themaReviewContent,
						'userNickname' : after
						
						
					}),
					success : function(result, status)
					{
						console.log(result);
						console.log(status);
						if(result == 'bad4')
						{
							console.log('닉네임 변경 안함');
						}
						
					}	// end success
					
					
				});	// end ajax
				
				
				
				
				
				
				
			});	// end afterNickName blur
			
			
			 
			
			
			$('#update_member').click(function(){
				console.log("start update");
				
				var userNo = $('#userNo').val();
				var userName = $('#userName').val();
				var userID = $('#userID').val();
				var userPWD = $('#userPWD').val();
				var userEmail = $('#userEmail').val();
				var userPhone = $('#userPhone').val();
				var userBirth = $('#userBirth').val();
				var userNickName = $('#afterNickName').val();
				
				
				
				
				console.log('생일' + userBirth);
				
				
				var obj = {
					
					'userNo' : userNo,
					'userName' : userName,
					'userID' : userID,
					'userPWD' : userPWD,
					'userEmail' : userEmail,
					'userPhone' : userPhone,
					'userBirth' : userBirth,
					'userNickName' : userNickName
						
				};
				console.log(obj);
				
				
				
				
				
                
				
				// ajax 요청
				$.ajax({
					type : 'put',
					url : '../user/UserUpdate/' + userID,
					headers:{
						 'Content-Type' : 'application/json',
			      	      'X-HTTP-Method-Override' : 'PUT'
						
					},
					data : JSON.stringify({
						
						'userNo' : userNo,
						'userName' : userName,
						'userID' : userID,
						'userPWD' : userPWD,
						'userEmail' : userEmail,
						'userPhone' : userPhone,
						'userBirth' : userBirth,
						'userNickName' : userNickName
						
					}),
					success : function(result, status)
					{
						console.log(result);
						console.log(status);
						
						if(result === 'success')
						{
							
							location.href="/travel06/main/user";
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
				
				
				var userNo = $('#userNo').val();
				var userName = $('#userName').val();
				var userID = $('#userID').val();
				var userPWD = $('#userPWD').val();
				var userEmail = $('#userEmail').val();
				var userPhone = $('#userPhone').val();
				var userBirth = $('#userBirth').val();
				var userNickName = $('#afterNickName').val();
			
				
				var obj = {
						'userNo' : userNo,
						'userName' : userName,
						'userID' : userID,
						'userPWD' : userPWD,
						'userEmail' : userEmail,
						'userPhone' : userPhone,
						'userBirth' : userBirth,
						'userNickName' : userNickName
						
				};
				console.log(obj);
				
				
				
				
				
				$.ajax({
					type : 'get',
					url : 'UserDeleteConfirm/' + userID,
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
							location.href="/travel06/user/delete-confirm";
						}
						else if(result == 'fail')
						{
							alert('회원 탈퇴 여부 묻기 실패ㅠㅠ');
							location.href="/travel06/user/myInfo";
						}
							
						
					}	// end success
					
					
				});	// end ajax
				
				
				
			});	// end delete_member click
			
			
			
			
			
		});	// end document
		
		
		
		</script>
		
		
		
	</body>
</html>