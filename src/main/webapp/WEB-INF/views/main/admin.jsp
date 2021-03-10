<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
    
    
<!DOCTYPE html>
<html>
	<head>
  <style>
        h2{color:#4CAF50;
            text-align:center;}
    h1{
      display: inline-block;
      vertical-align: middle;
      margin: 0.5rem;
      padding: 0;
    }
    
    nav{
      display:inline-block;
      vertical-align: middle;
    }
    header{
      display: flex;
      justify-content: space-between;
    }
    /* 로고 */
    .logo-box {
      font-size:2em; 
      border-radius:0.5em; 
      float:left;
    }
     
    .logo {
        width: 100px;
        height: 50px;
    }

    
    
    
    
    .footer{
      background-color: #333;
      text-align: center;
      height: 100px;
      color: white;
    }
  </style>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	</head>
	<body>
		
		<h2>관리자 페이지</h2>
		
		<c:set var="admin" value="${custom.avo }"></c:set>
		
		
		<p>${admin.adminID }</p>
		
		
		<div>
			<a href="../main/all"> 메인으로</a>
		</div>
		
		<div>
			<a href="../user/list">회원 리스트 보기</a>
		</div>
		
		<div>
			<a href="../admin/myInfo">내 정보</a>
		</div>
		
		
		<div>
			<a href="../admin/myPageList"> 내가 작성한 게시판들</a>
		</div>
			
		<div>
			<a href="../admin/myReviewList"> 내가 작성한 댓글들</a>
		</div>
		
		
		
		<form action="../customLogout" method="POST">
			<input type="hidden" name="${_csrf.parameterName }" 
											value="${_csrf.token }"/>
			
			<button style="background-color:#4CAF50;">로그아웃</button>
			
		</form>
		
		   <br><br><br><br><br><br><br><br><br><br><br><br><br><br>
       <div class="footer">
            <br>
          여행커뮤니티 방콕속 여행<br>

        </div>
		
	</body>
</html>