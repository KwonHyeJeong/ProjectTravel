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
		h1 {color:CornflowerBlue;}
		
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
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">

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
  
  
  
  <hr>
  <br>
  <a href="list"><input type="button" class="btn btn-outline-info }" style="float: left;" value="글목록"></a>
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
      <c:forEach var="vo" items="${foodList }">
        <tr>
          <td>${vo.foodNo }</td>
          <td style="width: 100px; height: 100px;"><img src="display?fileName=${vo.img }"><br><a href="detail?foodNo=${vo.foodNo }&page=${pageMaker.criteria.page}">${vo.foodTitle }</a></td>
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
  </table>
  <hr>
 
  <div>
    <form id="pagingForm" style="display: none;">
      <input type="text" name="page">
    </form>
  </div>
  
 
  
  
  <input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"/>
  
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.6.0/dist/umd/popper.min.js" integrity="sha384-KsvD1yqQ1/1+IA7gi3P0tyJcT3vR+NdBTt13hSJ2lnve8agRGXTTyNaBYmCR/Nwi" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.min.js" integrity="sha384-nsg8ua9HAw1y0W1btsyWgBklPnCUAFLuTMS2G72MMONqmOymq585AcH49TLBQObG" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
  
             <br>
       <div class="footer">
            <br>
          여행커뮤니티 방콕속 여행<br>

        </div> 
  
</body>
</html>
























