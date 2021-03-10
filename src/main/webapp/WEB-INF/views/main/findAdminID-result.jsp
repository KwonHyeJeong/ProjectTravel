<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    
<!DOCTYPE html>
	<html>
	<head>
    <style>
    .findAdminIdResult-page {
      width: 360px;
      padding: 8% 0 0;
      margin: auto;
    }
    .form {
      position: relative;
      z-index: 1;
      background: #FFFFFF;
      max-width: 360px;
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
    .findAdminIdResult {
        color: #4CAF50;
        font-family: 'Ubuntu', sans-serif;
        font-weight: bold;
        font-size: 23px;
    }
    </style>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	</head>
	<body>
  	   <div class="findAdminIDResult-page">
          <div class="form">
            <form class="findAdminIdResult-form">
              <p class="findAdminIdResult" align="center">관리자 id 찾기 결과</p>
  	
		
        		<c:if test="${empty findOK or findOK eq ''}">
        			<div>
        				<p>해당 아이디가 존재하지 않습니다.</p>
        				<a href="../main/all">메인으로</a>
        			</div>
        			
        		</c:if>
        		
        		
        		<c:if test="${not empty findOK }">
        			<div>
        				<p> 아이디는 ${findOK }입니다.</p>
        				<a href="../main/findAdminPWD">관리자 비밀번호 찾기</a>
        				<a href="../customLogin">로그인</a>
        				<a href="../main/all">메인으로</a>
        			</div>
        			
        		</c:if>
		    </form>
        </div>
      </div>
		
	</body>
</html>