<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib  prefix="spring" uri="http://www.springframework.org/tags" %>
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
   <title>${NoticeVO.noticeTitle }</title>
   <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
   <style>
      .oriImg{ width: 500px; height: auto;}
      .thumbImg{}
   </style>
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
    <h2>공지사항 글 보기</h2>
    <hr>
   
   
   <div>
      <p>FOOD 게시판 글 번호 : ${NoticeVO.noticeNo }</p>
   </div>
   
   <div>
      <p>
        제목 : <input type="text" value="${NoticeVO.noticeTitle }"
          readonly="readonly">
      </p>
   </div>
   
   <div>
      <p>작성자 : ${NoticeVO.noticeUserNickname }</p>
   </div>   
   
   <div>
      <fmt:formatDate value="${NoticeVO.noticeCdate }" 
      pattern="yyyy-MM-dd HH:mm:ss" var="noticeCdate" />
      <p>작성일 : ${noticeCdate }</p>
      <p>조회수 : ${NoticeVO.noticeViewCnt }</p>
      <br>
   </div>
   
   <div>
      <textarea rows="20" cols="120" readonly="readonly">${NoticeVO.noticeContent }</textarea>
   </div>
   
   
   <c:if test="${not empty custom.username }">
      <c:if test="${custom.username == custom.avo.adminID }">
         <c:if test="${custom.avo.adminID == NoticeVO.noticeUserNickname}">
            <a href="listNotice?page=${page }"><input  style="background-color:#4CAF50;" type="button" value="글 목록"></a>
             <a href="updateNotice?noticeNo=${NoticeVO.noticeNo }&page=${page}"><input  style="background-color:#4CAF50;" type="button" value="글 수정"></a> 
             <a href="deleteNotice?noticeNo=${NoticeVO.noticeNo }"><input  style="background-color:#4CAF50;" type="button" value="글 삭제"></a>
            
         </c:if>
         
         
         <c:if test="${custom.avo.adminID != NoticeVO.noticeUserNickname}">
            <a href="listNotice?page=${page }"><input  style="background-color:#4CAF50;" type="button" value="글 목록"></a>
            
         </c:if>
      
      </c:if>
   
      <c:if test="${custom.username == custom.uvo.userID }">
         <a href="listNotice?page=${page }"><input  style="background-color:#4CAF50;" type="button" value="글 목록"></a>
      </c:if>
      
      
   </c:if>
   
   <c:if test="${empty custom.username }">
      <a href="listNotice?page=${page }"><input style="background-color:#4CAF50;" type="button" value="글 목록"></a>
   </c:if>
   
   <div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
   </div>
   
             <br>
       <div class="footer">
            <br>
          여행커뮤니티 방콕속 여행<br>

        </div> 
</body>
</html>