<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib  prefix="spring" uri="http://www.springframework.org/tags" %>


<!DOCTYPE html>
<html>
<head>
<style type="text/css">
h1 {color:CornflowerBlue;}

ul {
  list-style-type: none;
}

li {
  display: inline-block;
}

</style>

<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<meta charset="UTF-8">
<title>찜목록</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
</head>
<body>
	<h1 class="text-center" >${AdminVO.userNickName }님이 찜한 목록</h1>
  <script type="text/javascript">
  </script>
  
  
  
  <a href="../main/admin"><input type="button" class="btn btn-outline-info }" style="float: left;" value="뒤로가기"></a>
  

  <br>
   <table class="table table-hover table-striped table-condensed" style="border: 1px solid;">
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
	      <c:forEach var="free" items="${freeList }">
	        <tr>
	          <td>${free.freeNo }</td>
	          <td><a href="../free/free_page_detail?freeNo=${free.freeNo }&page=${pageMaker.criteria.page}">${free.freeTitle }</a></td>
	          <td>${free.userNickname }</td>
	          <fmt:formatDate value="${free.freeCdate }"
	            pattern="yyyy-MM-dd HH:mm:ss"
	            var="freeCdate"/>
	          <td>${freeCdate }</td>
	          <td>${free.freeViewCnt }</td>
	          <td>${free.freeReplyCnt }</td>
	          <td>${free.freeGoodCnt }</td>
	          <td>${free.freeWishCnt }</td>
	        </tr>
	      </c:forEach>
    	</tbody>
    
    
    
	    <tbody>
		      <c:forEach var="vo" items="${foodList }">
		        <tr>
		          <td>${vo.foodNo }</td>
		          <td style="width: 100px; height: 100px;"><img src="../food/display?fileName=${vo.img }"><br><a href="../food/detail?foodNo=${vo.foodNo }&page=${pageMaker.criteria.page}">${vo.foodTitle }</a></td>
		          <td>${vo.userNickname }</td>
		          <fmt:formatDate value="${vo.foodCdate }"
		            pattern="yyyy-MM-dd HH:mm:ss"
		            var="foodCdate"/>
		          <td>${foodCdate }</td>
		          <td>${vo.foodViewCnt }</td>
		          <td>${vo.foodReplyCnt }</td>
		          <td>${vo.foodGoodCnt }</td>
		          <td>${vo.foodWishCnt }</td>
		        </tr>
		      </c:forEach>
	    </tbody>
    
    
	    <tbody>
	      <c:forEach var="play" items="${playPageList }">
	        <tr>
	          <td>${play.playNo }</td>
	          <td style="width: 100px; height: 100px;"><img src="../play/display?fileName=${play.img }"><br><a href="../play/detail?playNo=${play.playNo }&page=${pageMaker.criteria.page}">
	          		${play.playTitle }</a></td>
	          <td>${play.userNickname }</td>
	          <fmt:formatDate value="${play.playCdate }"
	            pattern="yyyy-MM-dd HH:mm:ss"
	            var="playCdate"/>
	          <td>${playCdate }</td>
	          <td>${play.playViewCnt }</td>
	          <td>${play.playReplyCnt }</td>
	          <td>${play.playGoodCnt }</td>
	          <td>${play.playWishCnt }</td>
	        </tr>
	      </c:forEach>
	    </tbody>
    
    
	    <tbody>
	      <c:forEach var="theme" items="${themePageList }">
	        <tr>
	          <td>${theme.themaNo }</td>
	          <td style="width: 100px; height: 100px;"><img src="../theme/display?fileName=${theme.img }"><br><a href="../theme/detail?themeNo=${theme.themaNo }&page=${pageMaker.criteria.page}">
	          		${theme.themaTitle }</a></td>
	          <td>${theme.userNickname }</td>
	          <fmt:formatDate value="${theme.themaCdate }"
	            pattern="yyyy-MM-dd HH:mm:ss"
	            var="themaCdate"/>
	          <td>${themaCdate }</td>
	          <td>${theme.themaViewCnt }</td>
	          <td>${theme.themaReplyCnt }</td>
	          <td>${theme.themaGoodCnt }</td>
	          <td>${theme.themaWishCnt }</td>
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
  	    frm.attr('action', 'wishList'); // form에 action 속성-값 추가
  	    frm.attr('method', 'get'); // form에 method 속성 추가
  	    frm.submit(); // form 데이터 전송
  	  }); // end click()
  	  
  	  
  	  
  	}); // end document
  </script>
  
  
  
  
  
  
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.6.0/dist/umd/popper.min.js" integrity="sha384-KsvD1yqQ1/1+IA7gi3P0tyJcT3vR+NdBTt13hSJ2lnve8agRGXTTyNaBYmCR/Nwi" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.min.js" integrity="sha384-nsg8ua9HAw1y0W1btsyWgBklPnCUAFLuTMS2G72MMONqmOymq585AcH49TLBQObG" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
  
</body>
</html>
























