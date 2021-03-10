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
<title>댓글수별 인기글</title>
</head>
<body>

  <script type="text/javascript">
  </script>
  <hr>
  
  <h3>댓글수별 best순위</h3>
 
  <br>
  <a href="free_page_list"><input type="button" value="글목록"></a>
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
      <c:forEach var="vo" items="${freeList }">
	        <tr>
	          <td>${vo.freeNo }</td>
	          <td><a href="free_page_detail?freeNo=${vo.freeNo }&page=${pageMaker.criteria.page}">${vo.freeTitle }</a></td>
	          <td>${vo.userNickname }</td>
	          <fmt:formatDate value="${vo.freeCdate }"
	            pattern="yyyy-MM-dd HH:mm:ss"
	            var="freeCdate"/>
	          <td>${freeCdate }</td>
	          <td>${vo.freeViewCnt }</td>
	          <td>${vo.freeReplyCnt }</td>
	          <td>${vo.freeGoodCnt }</td>
	          <td>${vo.freeWishCnt }</td>
	        </tr>
      	</c:forEach>
    </tbody>
  </table>
  <hr>
 
  

  
  <input id="insertAlert" type="hidden" value="${insert_result}">

  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.6.0/dist/umd/popper.min.js" integrity="sha384-KsvD1yqQ1/1+IA7gi3P0tyJcT3vR+NdBTt13hSJ2lnve8agRGXTTyNaBYmCR/Nwi" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.min.js" integrity="sha384-nsg8ua9HAw1y0W1btsyWgBklPnCUAFLuTMS2G72MMONqmOymq585AcH49TLBQObG" crossorigin="anonymous"></script>
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
  
  
  
</body>
</html>