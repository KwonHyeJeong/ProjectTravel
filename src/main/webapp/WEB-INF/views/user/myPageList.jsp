<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>


<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
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
		
		<h2>${custom.uvo.userNickName}님이 작성한 게시판들</h2>
		
		<div>
	  		<a href="../main/user"><input  style="background-color:#4CAF50;" type="button" value="뒤로가기"></a>
	  	</div>
		
		<table>
			    <thead>
			      <tr>
			        <th style="width: 60px;">번호</th>
			        <th style="width: 700px;">제목</th>
			        <th style="width: 60px;">작성자</th>
			        <th style="width: 100px;">작성일</th>
			        <th style="width: 60px;">조회수</th>
			        <th style="width: 60px;">댓글수</th>
			        <th style="width: 80px;">좋아요수</th>
			        <th style="width: 80px;">찜하기수</th>
			      </tr>
			    </thead>
			    
			    <tbody>
			      <c:forEach var="free" items="${freePageList }">
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
			      <c:forEach var="food" items="${foodPageList }">
			        <tr>
			          <td>${food.foodNo }</td>
			          <td style="width: 100px; height: 100px;"><img src="../food/display?fileName=${food.img }"><br>
			          <a href="../food/detail?foodNo=${food.foodNo }&page=${pageMaker.criteria.page}">${food.foodTitle }</a></td>
			          <td>${food.userNickname }</td>
			          <fmt:formatDate value="${food.foodCdate }"
			            pattern="yyyy-MM-dd HH:mm:ss"
			            var="foodCdate"/>
			          <td>${foodCdate }</td>
			          <td>${food.foodViewCnt }</td>
			          <td>${food.foodReplyCnt }</td>
			          <td>${food.foodGoodCnt }</td>
			          <td>${food.foodWishCnt }</td>
			        </tr>
			      </c:forEach>
			     </tbody>
			      
			      
			      <tbody>
			      <c:forEach var="play" items="${playPageList }">
			        <tr>
			          <td>${play.playNo }</td>
			          <td style="width: 100px; height: 100px;"><img src="../play/display?fileName=${play.img }"><br>
			          <a href="../play/detail?playNo=${play.playNo }&page=${pageMaker.criteria.page}">${play.playTitle }</a></td>
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
				      <c:forEach var="tvo" items="${themePageList }">
				        <tr>
				          <td>${tvo.themaNo }</td>
				          <td td style="width: 100px; height: 100px;"><img src="../theme/display?fileName=${tvo.img }"><br><a href="../theme/detail?themeNo=${tvo.themaNo }&page=${pageMaker.criteria.page}">${tvo.themaTitle }</a></td>
				          <td>${tvo.userNickname }</td>
				          <fmt:formatDate value="${tvo.themaCdate }"
				            pattern="yyyy-MM-dd HH:mm:ss"
				            var="themaCdate"/>
				          <td>${themaCdate }</td>
				          <td>${tvo.themaViewCnt }</td>
				          <td>${tvo.themaReplyCnt }</td>
				          <td>${tvo.themaGoodCnt }</td>
				          <td>${tvo.themaWishCnt }</td>
				        </tr>
				      </c:forEach>
	    			</tbody>
			     
			      
			      
			      
			    
	  </table>
	  
	  
	  
	  <ul class="pager">
	    <c:if test="${pageMaker.hasPrev }">
	      <li><a href="${pageMaker.startPageNo - 1}">이전</a></li>
	    </c:if>
	    <c:forEach begin="${pageMaker.startPageNo }" 
	      end="${pageMaker.endPageNo }" var="num">
	      <li><a href="${num }">${num }</a></li>
	    </c:forEach>
	    <c:if test="${pageMaker.hasNext }">
	      <li><a href="${pageMaker.endPageNo + 1}">다음</a></li>
	    </c:if>
	  </ul>
	  
	  
	  
	 <div>
	    <form id="pagingForm" style="display: none;">
	      <input type="text" name="page">
	    </form>
  	</div>
	 
	  
	  <input type="hidden" name="${_csrf.parameterName }" 
										value="${_csrf.token }"/>
	  
	  
	  
	  <script type="text/javascript">
	  $(document).ready(function(){
		  $('.pager li a').click(function(){
			  
		        // pager 클래스의 하위 li 요소의 a 요소를 찾아감
		        event.preventDefault(); // a 태그의 기본 동작(페이지 이동)을 금지
		        var targetPage = $(this).attr('href'); // a 태그 href 속성의 값을 저장
		        console.log(targetPage);
		        
		        var frm = $('#pagingForm'); // form의 정보를 frm에 저장
		        frm.find('[name="page"]').val(targetPage);
		        // name="page"인 요소를 찾아서 value값을 저장
		        frm.attr('action', 'myPageList'); // form에 action 속성-값 추가
		        frm.attr('method', 'get'); // form에 method 속성 추가
		        frm.submit(); // form 데이터 전송
		        
		      }); // end click()
		      
	  	});	// end document
	
	
	
		</script>
	  
	  
	                <br>
       <div class="footer">
            <br>
          여행커뮤니티 방콕속 여행<br>

        </div> 
	 
		
		
	</body>
</html>