<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    
<!DOCTYPE html>
<html>
	<head>
    <style>
      .findAdminPWD-page {
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
      .findAdminPWD {
              color: #4CAF50;
              font-family: 'Ubuntu', sans-serif;
              font-weight: bold;
              font-size: 23px;
      }
    
    </style>
	<meta charset="UTF-8">
	<title>가입정보로 관리자 password 찾기</title>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	</head>
	<body>
       
		
		<form name="Find_AdminPWD_Form" action="findAdminPWD" method="POST">
    		<div class="findAdminPWD-page">
             <div class="form">
               <form class="findAdminPWD-form">
                  <p class="findAdminPWD" align="center">관리자 password 찾기</p>
        
        			<div id="nameDiv">
        				
        				<label>이름</label> <br>
        				<input type="text" id="name" name="adminName" required="required"><br><br>
        			</div>
        			
        				
        			<div id="idDiv">
        				<label>아이디</label><br>
        				
        				<input type="text" id="setID" name="adminID" required="required">
        				
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
		
	</body>
</html>