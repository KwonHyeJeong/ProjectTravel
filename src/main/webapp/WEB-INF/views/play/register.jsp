<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<style type="text/css">
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
<meta charset="UTF-8">
<title>PLAY 글 작성 페이지</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
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
    <h2>PLAY 게시판 등록</h2>
    <hr>
	<form action="register" method="POST" enctype="multipart/form-data">
		
	    <div>
	      <p>제목 : 
	      <input type="text" name="playTitle" placeholder="제목 입력" required="required">
	      </p>
	    </div>
	    
	    <div>
	    	<c:if test="${not empty custom.uvo }">
			   <p>작성자 : 
			   <input type="text" name="userNickname" value="${custom.uvo.userNickName}" readonly="readonly">
			   </p>
	      	</c:if>
	      	
	      	<c:if test="${not empty custom.avo }">
		    	<p>작성자 : 
			     <input type="text" name="userNickname" value="${custom.avo.adminID}" readonly="readonly">
			    </p>
    		</c:if>
	      	
	      	
	    </div>
	    
	    
	    <div>
	      <textarea rows="20" cols="120" name="playContent"
	      placeholder="내용 입력" required="required"></textarea>
	    </div>
	
	    
	    <div class="inputArea">
	 		<label for="img">이미지</label>
	 		<input type="file" id="img" name="file" />
	 		<div class="select_img"><img src="" /></div>
	 		
	 		
	 		
	 		<script>
	  		$("#img").change(function(){
	   		if(this.files && this.files[0]) {
	    	var reader = new FileReader;
	    	reader.onload = function(data) {
	     	 $(".select_img img").attr("src", data.target.result).width(500);        
	    	 }
	    	 reader.readAsDataURL(this.files[0]);
	   		}
	 		 });
 			</script>
 			
	 		<%=request.getRealPath("/") %>
	 		
	 	
	
		</div>
	    
	    <div>
	    	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	    	<input style="background-color:#4CAF50;" type="submit" value="등록">
	    </div>
	    
	   
	    
	    
  	</form>
	
	
	          <br>
       <div class="footer">
            <br>
          여행커뮤니티 방콕속 여행<br>

        </div> 
  
	
	
	
</body>
</html>

