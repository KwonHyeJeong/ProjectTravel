<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib  prefix="spring" uri="http://www.springframework.org/tags" %>
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
</style>

<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<meta charset="UTF-8">
<title>찜하기별 인기글</title>
</head>
<body>

  <script type="text/javascript">
  </script>
  <hr>
  
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
		<h2>조회수 별 BEST 순위</h2>
		<hr>
    
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
  <ul class="pagination justify-content-center">
    <c:if test="${pageMaker.hasPrev }">
      <li><a href="${pageMaker.startPageNo - 1}" style="margin-right:5px;" class="text-secondary">이전</a></li>
    </c:if>
    <c:forEach begin="${pageMaker.startPageNo }" 
      end="${pageMaker.endPageNo }" var="num">
      <li><a href="${num }" style="margin-right:5px;" class="text-secondary">${num }</a></li>
    </c:forEach>
    <c:if test="${pageMaker.hasNext }">
      <li><a href="${pageMaker.endPageNo + 1}" style="margin-right:5px;" class="text-secondary">다음</a></li>
    </c:if>
  </ul>
    
  
  
	<div>
    	<form id="pagingForm" style="display: none;">
      	<input type="text" name="page">
    	</form>
 	 </div>

  
  <input id="insertAlert" type="hidden" value="${insert_result}">

  
  <script type="text/javascript">
  	$(document).ready(function(){
  	  $('.pagination li a').click(function(){
  	    // pagination 클래스의 하위 li 요소의 a 요소를 찾아감
  	    event.preventDefault(); // a 태그의 기본 동작(페이지 이동)을 금지
  	    var targetPage = $(this).attr('href'); // a 태그 href 속성의 값을 저장
  	    console.log(targetPage);
  	    
  	    var frm = $('#pagingForm'); // form의 정보를 frm에 저장
  	    frm.find('[name="page"]').val(targetPage);
  	    // name="page"인 요소를 찾아서 value값을 저장
  	    frm.attr('action', 'bestWish'); // form에 action 속성-값 추가
  	    frm.attr('method', 'get'); // form에 method 속성 추가
  	    frm.submit(); // form 데이터 전송
  	  }); // end click()
  	}); // end document
  </script>
           <br>
       <div class="footer">
            <br>
          여행커뮤니티 방콕속 여행<br>

        </div> 
  
  
</body>
</html>