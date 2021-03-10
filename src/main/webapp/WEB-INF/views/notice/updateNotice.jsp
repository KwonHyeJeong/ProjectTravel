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
	<title>${FoodPageVO.foodTitle }</title>
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
    <h2>FOOD 공지사항 게시판 수정</h2>
    <hr>
	
	<form action="updateNotice" method="post">
		<input type="hidden" name="page" value="${page }">
		<div>
			<p>FOOD 게시판 글 번호 : ${NoticeVO.noticeNo }</p>
			<input type="hidden" name="noticeNo" value="${NoticeVO.noticeNo }">
		</div>
		
		<div>
			<p>
			  제목 : <input type="text" name="noticeTitle" value="${NoticeVO.noticeTitle }" required>
			</p>
		</div>
		
		<div>
			<p>작성자 : ${NoticeVO.noticeUserNickname }</p>
			<p>작성일 : ${NoticeVO.noticeCdate }</p>
		</div>
		
		<div>
			<textarea rows="20" cols="120" name="noticeContent" required>${NoticeVO.noticeContent }</textarea>
		</div>
		 
		<div>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
			<input type="submit" value="제출">
		</div>
	</form>
           <br>
       <div class="footer">
            <br>
          여행커뮤니티 방콕속 여행<br>

        </div> 
</body>
</html>







