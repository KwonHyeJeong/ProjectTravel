<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib  prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>


<!DOCTYPE html>
<html>
<head>
<style type="text/css">
table, th, td {
  border-style : solid;
  border-width : 1px;
  text-align : center;
}

ul {
  list-style-type: none;
}

li {
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
<title>좋아요목록</title>
</head>
<body>

  <script type="text/javascript">
  </script>
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
  
  <c:if test="${custom.username == custom.uvo.userID }">
  	<h3>${custom.uvo.userNickName }님이 선택한 좋아요 목록</h3>
  </c:if>
  
  <c:if test="${custom.username == custom.avo.adminID }">
  	<h3>${custom.avo.adminID }님이 선택한 좋아요 목록</h3>
  </c:if>
  
            <div>
            <a href="../main/all">메인화면</a>  
            <a href="../theme/list">THEME 게시판</a>         
            <a href="../food/list">FOOD 게시판</a>
            <a href="../play/list">PLAY 게시판</a>
            <a href="../free/free_page_list">자유게시판 </a>
            <a href="../notice/listNotice">공지사항</a>
            <a href="../main/user">마이페이지</a>
        </div>
        
  
  <hr>
  <br>
  <a href="list"><input style="background-color:#4CAF50;" type="button" value="글목록"></a>
  <br>
   <table>
    <thead>
      <tr>
        <th style="width: 60px;">번호</th>
        <th style="width: 100px;">제목</th>
        <th style="width: 60px;">작성자</th>
        <th style="width: 100px;">작성일</th>
        <th style="width: 60px;">조회수</th>
        <th style="width: 60px;">댓글수</th>
        <th style="width: 80px;">좋아요수</th>
        <th style="width: 80px;">찜하기수</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="vo" items="${playList }">
        <tr>
          <td>${vo.playNo }</td>
          <td style="width: 100px; height: 100px;"><img src="display?fileName=${vo.img }"><br><a href="detail?playNo=${vo.playNo }&page=${pageMaker.criteria.page}">${vo.playTitle }</a></td>
          <td>${vo.userNickname }</td>
          <fmt:formatDate value="${vo.playCdate }"
            pattern="yyyy-MM-dd HH:mm:ss"
            var="playCdate"/>
          <td>${playCdate }</td>
          <td>${vo.playViewCnt }</td>
          <td>${vo.playReplyCnt }</td>
          <td>${vo.playGoodCnt }</td>
          <td>${vo.playWishCnt }</td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
  <hr>
 
  <div>
    <form id="pagingForm" style="display: none;">
      <input type="text" name="page">
    </form>
  </div>
  
 
  
  
  <input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"/>
  
             <br>
       <div class="footer">
            <br>
          여행커뮤니티 방콕속 여행<br>

        </div> 
  
</body>
</html>
























