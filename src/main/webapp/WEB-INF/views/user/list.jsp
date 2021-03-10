<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
  
<!DOCTYPE html>
<html>
	<head>
		<style type="text/css">
			  table, th, td
			  {
			    border-style: solid;
			    border-width: 1px;
			    text-align: center;
			    
			  }
			  
			  ul
			  {
			    list-style-type: none;
			  }
			  
			  li
			  {
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
		<title>회원 리스트</title>
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
		<c:if test="${not empty custom.avo}">
			<p>관리자 이름 :  ${custom.avo.adminName }</p>
			<div>
				<a href="../main/admin"><input type="button" value="되돌아가기"></a>
			</div>
			
		</c:if>
		
		
		<table>
	      <thead>
	        <tr>
	          <th style="width: 60px;">번호</th>
	          <th style="width: 80px;">이름</th>
	          <th style="width: 80px;">id</th>
	          <th style="width: 100px;">이메일</th>
	          <th style="width: 80px;">휴대폰</th>
	          <th style="width: 90px;">생일</th>
	          <th style="width: 100px;">닉네임</th>
	          <th style="width: 80px;">신고 개수</th>
	          
	        </tr>
	      </thead>
	      
	      
	      <tbody>
	        <c:forEach var="vo" items="${userList}">
	          <tr>
	            <td>${vo.userNo }</td>
	            <td>${vo.userName }</td>
	            <td>${vo.userID }</td>
	            <td>${vo.userEmail }</td>
	            <td>${vo.userPhone }</td>
	            
	            <fmt:formatDate value="${vo.userBirth }"
              	pattern="yyyy-MM-dd"
              	var ="birthDay"
            	/>
	            <td>${birthDay }</td>
	            <td>${vo.userNickName }</td>
	            <td>${vo.userWarning }</td>
	          </tr>
	          
	          <c:if test="${not empty custom.avo}">
	          	<c:if test="${vo.userWarning >=5 }">
		          	<p>${vo.userID }님께 경고<a href="../admin/user_delete_confirm?userID=${vo.userID }"><input type="button" value="강제탈퇴"></a>
		          	
		          	</p>
	          </c:if>
	          	
	          </c:if>
	          
	          
	        </c:forEach>
	      </tbody>
        
      
    </table>
    
		
	
	<hr>
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
	        frm.attr('action', 'list'); // form에 action 속성-값 추가
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