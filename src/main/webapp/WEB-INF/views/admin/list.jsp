<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
  
<!DOCTYPE html>
<html>
	<head>
		<style type="text/css">
			  table, th, td
			  {
			    border-style: solid;
			    border-width: 1px;
			    text-align: center;
			    
			  }
			  
			  ul
			  {
			    list-style-type: none;
			  }
			  
			  li
			  {
			    display: inline-block;
			  }
        h1{
            display: inline-block;
            vertical-align: middle;
            margin: 0.5rem;
            padding: 0;
                text-align:center;
                width:1200px;
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
          
    h2 {color:#4CAF50;
            text-align:center;}
    
    ul {
      list-style-type: none;
    }
    
    li {
      display: inline-block;
    }
    
    .footer{
          background-color: #333;
          text-align: center;
          height: 180px;
          color: white;
        }
			  
		  
		</style>
	  
		<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	
		<meta charset="UTF-8">
		<title>관리자 리스트</title>
	</head>
	<body>
		    <header>
        <nav>
        <!-- 로고 -->
        <div class="logo-box">
          <img alt="logo" class="logo" src="../resources/images/carmera.png">
        </div>
        
        <h1> 방콕속 여행 </h1>  
        </nav>
        
        
      </header>
      <hr>
		
		<table>
	      <thead>
	        <tr>
	          <th style="width: 60px;">번호</th>
	          <th style="width: 80px;">이름</th>
	          <th style="width: 80px;">id</th>
	          <th style="width: 100px;">이메일</th>
	          <th style="width: 80px;">휴대폰</th>
	          <th style="width: 80px;">회사전화번호</th>
	          <th style="width: 90px;">생일</th>
	 
	          
	        </tr>
	      </thead>
	      
	      
	      <tbody>
	        <c:forEach var="avo" items="${adminList}">
	          <tr>
	            <td>${avo.adminNo }</td>
	            <td>${avo.adminName }</td>
	            <td>${avo.adminID }</td>
	            <td>${avo.adminEmail }</td>
	            <td>${avo.adminPhone }</td>
	            <td>${avo.adminCompany }</td>
	            
	            <fmt:formatDate value="${avo.adminBirth }"
              	pattern="yyyy-MM-dd"
              	var ="birthDay"
            	/>
	            <td>${birthDay }</td>
	    
	          </tr>
	        </c:forEach>
	      </tbody>
        
      
    </table>
		
		<div>
		<a href="../main/all">메인화면</a>
		</div>
		
	<hr>
	
	<input id="insertAlert" type="hidden" value="${insert_result}">
	
	
	<script type="text/javascript">
	
	$(document).ready(function(){
		
		
		confirmInsertResult();
		function confirmInsertResult()
		{
			var result = $('#insertAlert').val();
			console.log("결과 : " + result);
			if(result === "success")
			{
				alert('관리자용 회원가입 성공!!');
				
			}
			else if(result === 'fail')
			{
				alert('관리자용 회원가입 실패 ㅠㅠ');
				
			}
			
			
		}
		
		
		
		
		
	});	// end document
	
	
	
	</script>
	
	           <br>
       <div class="footer">
            <br>
          여행커뮤니티 방콕속 여행<br>

        </div> 
		
		
	</body>
</html>