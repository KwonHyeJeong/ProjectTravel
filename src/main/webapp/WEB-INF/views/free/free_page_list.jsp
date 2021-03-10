<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib  prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
		
		
	
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<meta charset="UTF-8">
	<title>자유 게시판 페이지</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" 
	rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
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
		<h2>자유게시판</h2>
		<hr>
		
		
		<sec:authorize access="isAnonymous()">
			<div>
				<a href="../customLogin">로그인</a>
				<a href="../main/all">메인화면</a>
			</div>
			
			<div>
				<a href="bestList"><button type="button" class="btn btn-outline-info }" style="float: right;"> 조회수 best </button></a>
				<a href="bestReview"><button type="button" class="btn btn-outline-info }" style="float: right;"> 댓글 best </button></a>
				<a href="bestGood"><button type="button" class="btn btn-outline-info }" style="float: right;"> 좋아요 best </button></a>
				<a href="bestWish"><button type="button" class="btn btn-outline-info }" style="float: right;"> 찜 best </button></a>
			</div>
			
		</sec:authorize>
		
		<sec:authorize access="isAuthenticated()">
			
			<c:if test="${not empty custom.uvo }">
				<div>
					<p>${custom.uvo.userNickName}님 환영합니다!</p>
				</div>
				
				<form action="../customLogout" method="POST">
					<input type="hidden" name="${_csrf.parameterName }" 
													value="${_csrf.token }"/>
					
					<button  style="background-color:#4CAF50;">로그아웃</button>
			
				</form>
			
			
				<div>
					<a href="../main/all">메인화면</a>
					<a href="../theme/list">THEME 추천 </a>
					<a href="../food/list">FOOD 게시판</a>
					<a href="../play/list">PLAY 게시판</a>
					<a href="../notice/listNotice">공지사항</a>
					<a href="../main/user">마이페이지</a>
				</div>
				
				
				
				<hr>
				<div>
					<a href="free_page_register"><input type="button" value="글작성" class="btn btn-outline-info }" style="float: left;"></a>
				</div>
				<hr>
				
				<div>
					<a href="bestList"><button type="button" class="btn btn-outline-info }" style="float: right;"> 조회수 best </button></a>
					<a href="bestReview"><button type="button" class="btn btn-outline-info }" style="float: right;"> 댓글 best </button></a>
					<a href="bestGood"><button type="button" class="btn btn-outline-info }" style="float: right;"> 좋아요 best </button></a>
					<a href="bestWish"><button type="button" class="btn btn-outline-info }" style="float: right;"> 찜 best </button></a>
				</div>
					
			</c:if>
				
			<c:if test="${not empty custom.avo }">
				<div>
					<p>${custom.avo.adminID}님 환영합니다!</p>
				</div>
				
				<form action="../customLogout" method="POST">
					<input type="hidden" name="${_csrf.parameterName }" 
													value="${_csrf.token }"/>
					
					<button  style="background-color:#4CAF50;">로그아웃</button>
			
				</form>
				
				<div>
					<a href="../main/all">메인화면</a>
					<a href="../main/admin">마이페이지</a>
					<a href="../food/list">음식 게시판</a>
					<a href="../notice/listNotice">공지사항</a>
					<a href="../play/list">놀거리 게시판</a>
					<a href="../theme/list">테마 추천 </a>
				</div>
				
				<hr>
				<div>
					<a href="../notice/insertNotice"><button id="insertNoticeBtn" type="button" class="btn btn-outline-info }" style="float: left; display : block;" >공지사항 작성</button></a>
				</div>
				
				<div>
					<a href="free_page_register"><input type="button" value="글작성" class="btn btn-outline-info }" style="float: left;"></a>
				</div>
				
				
				<div>
					<a href="bestList"><button type="button" class="btn btn-outline-info }" style="float: right;"> 조회수 best </button></a>
					<a href="bestReview"><button type="button" class="btn btn-outline-info }" style="float: right;"> 댓글 best </button></a>
					<a href="bestGood"><button type="button" class="btn btn-outline-info }" style="float: right;"> 좋아요 best </button></a>
					<a href="bestWish"><button type="button" class="btn btn-outline-info }" style="float: right;"> 찜 best </button></a>
				</div>
				
				
			</c:if>
			
			
		</sec:authorize>
		
		
		
			
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
			   		
			    	<c:forEach var="nvo" items="${noticeList }">
				    <tr>
					    <td><img src="<spring:url value='/resources/images/notice.png'/>"></td>
					    <td><a href="../notice/detailNotice?noticeNo=${nvo.noticeNo }&page=${pageMaker.criteria.page}">${nvo.noticeTitle }</a></td>
					    <td>${nvo.noticeUserNickname }</td>
					    <fmt:formatDate value="${nvo.noticeCdate }"
					      pattern="yyyy-MM-dd HH:mm:ss"
					      var="noticeCdate"/>
					    <td>${noticeCdate}</td> 
					    <td>${nvo.noticeViewCnt }</td>
					    <td>${nvo.noticeReplyCnt }</td>
					    <td>해당없음</td>
					    <td>해당없음</td>
				    <tr>
			    	</c:forEach>
		    	</tbody>
			    
			    
			    
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
	  
	  
	  <!-- 검색 창  -->
	  <div style="clear: right; width: 500px; margin: auto">
	    <select id="search" name="type">
	      <option value="all">전체</option>
	      <option value="title">제목</option>
	      <option value="content">내용</option>
	      <option value="user">작성자</option>
	    </select> 
	    <input id="keyword" type="text" name="keyword" placeholder="Search" />
         
	    <button id="searchBtn" type="button" style="background-color:#4CAF50;"><img style = "width:20px;" src="../resources/images/search.png"></button>
	  
	  </div>
	  
	  
	  
		
		
		
	<script type="text/javascript">
    $(document).ready(function(){
    	$('.pagination li a').click(function(){
	        // pager 클래스의 하위 li 요소의 a 요소를 찾아감
	        event.preventDefault(); // a 태그의 기본 동작(페이지 이동)을 금지
	        var targetPage = $(this).attr('href'); // a 태그 href 속성의 값을 저장
	        console.log(targetPage);
	        
	        var frm = $('#pagingForm'); // form의 정보를 frm에 저장
	        frm.find('[name="page"]').val(targetPage);
	        // name="page"인 요소를 찾아서 value값을 저장
	        frm.attr('action', 'free_page_list'); // form에 action 속성-값 추가
	        frm.attr('method', 'get'); // form에 method 속성 추가
	        frm.submit(); // form 데이터 전송
	      }); // end click()
	      
	      
	      confirmInsertResult();
	      function confirmInsertResult() {
	        var result = $('#insertAlert').val();
	        if (result === 'success') 
	        {
	          alert('자유게시판 작성 성공');
	          
	        } 
	        else if(result === 'fail')
	        {
	          alert('자유게시판 작성 실패')
	        }
	      }
	      
	      
	      setSearchTypeSelect();
	      function setSearchTypeSelect()
	      {
	    		// search.val('${pageMaker.criteria.type}').prop("selected",true);
	    		//검색 버튼이 눌리면
	    		$('#searchBtn').on('click',function(){
	    			var type = $('#search option:selected').val();
	      			var keyword = $('#keyword').val();
	        		console.log(type);
	        		console.log(keyword);
	    			//검색 조건 입력 안했으면 경고창 
	    			if(!type){
	    				alert("검색 조건을 선택해야합니다.");
	    				return;
	    			//검색어 입력 안했으면 검색창
	    			}else if(!keyword){
	    				alert("검색어를 입력하세요");
	    				return;
	    			}
	    			var url = "free_page_list?page=1"
	    				+ "&perPage=" + "${pageMaker.criteria.numsPerPage}"
	    				+ "&type=" + type
	    				+ "&keyword=" + encodeURIComponent(keyword);
	    			window.location.href = url;
	    		});
	    		
	    		
	      }// end setSearchTypeSelect()
	      
	      
	   
	      
	      
    }); // end document
	  </script>
		
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.6.0/dist/umd/popper.min.js" integrity="sha384-KsvD1yqQ1/1+IA7gi3P0tyJcT3vR+NdBTt13hSJ2lnve8agRGXTTyNaBYmCR/Nwi" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.min.js" integrity="sha384-nsg8ua9HAw1y0W1btsyWgBklPnCUAFLuTMS2G72MMONqmOymq585AcH49TLBQObG" crossorigin="anonymous"></script>
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
		
	 
	</body>
</html>
