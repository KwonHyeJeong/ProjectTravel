<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
  
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
<title>${PlayPageVO.playTitle }</title>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
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
    <h2>PLAY 게시판 글 수정</h2>
    <hr>
  <form action="update" method="post">
    <input type="hidden" name="page" value="${page }">
    <div>
      <p>PLAY 게시판 글 번호 : ${PlayPageVO.playNo }</p>
      <input type="hidden" name="playNo" value="${PlayPageVO.playNo }">
    </div>
    <div>
      <p>
        제목 : <input type="text" name="playTitle" value="${PlayPageVO.playTitle }" required>
      </p>
    </div>
    <div>
      <p>작성자 : ${PlayPageVO.userNickname }</p>
      <p>작성일 : ${PlayPageVO.playCdate }</p>
    </div>
    <div>
      <textarea rows="20" cols="120" name="playContent" required>${PlayPageVO.playContent }</textarea>
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
 		<%=request.getRealPath("..") %><!-- 현재 페이지 소속된 경로 표시 -->
 		
 		<%=request.getRealPath("/") %><!-- 실제 경로 표시 -->
	</div>
    
    
    <div>
    	<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"/>
      <input style="background-color:#4CAF50;" type="submit" value="제출">
    </div>
  </form>
             <br>
       <div class="footer">
            <br>
          여행커뮤니티 방콕속 여행<br>

        </div> 
  

</body>
</html>







