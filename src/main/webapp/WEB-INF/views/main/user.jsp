<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>


<!DOCTYPE html>
<html>
	<head>
		<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
	  	<link href='https://fonts.googleapis.com/css?family=Anton' rel='stylesheet' type='text/css'>
	  	<link href='https://fonts.googleapis.com/css?family=Neucha' rel='stylesheet' type='text/css'>
	
	<style>
        h2{color:#4CAF50;
            text-align:center;}
		h1{
		  display: inline-block;
		  vertical-align: middle;
		  margin: 0.5rem;
		  padding: 0;
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
		
		/*로그인 버튼*/
		#login{
		  float:right;
		  position:absolute;
		}
		
		/* 메뉴바 디자인*/
		ul {
		    list-style-type: none;
		    margin: 0 auto;
		    padding: 0;
		    overflow:hidden;
		    text-align: center;
		    display:flex;
		}
		ul:after{
		    content:'';
		    display: block;
		    clear:both;
		    
		}
		li {
		    float: none;
		    display:inline;
		}
		li a {
		    display:inline-block;
		    color: white;
		    text-align: center;
		    padding: 14px 20px;
		    text-decoration: none;
		    background-color: #4CAF50;
		}
		ul.main-menu{
		  display:center;
		}
		ul.main-menu > li ul.sub-menu{
		    display:none;
		    position:absolute;
		    float:none;
		    background-color: #4CAF50;
		}
		ul.main-menu > li:hover ul.sub-menu {
		    display:block;
		    float:none;
		}
		ul.main-menu > li ul.sub-menu > li {
		    display:inline-block;
		    text-align:center;
		}
		
		.active {
		    background-color:#2b5fca;
		}
		a:hover{color:#333;}
		
		
		
		
		.footer{
		  background-color: #333;
		  text-align: center;
		  height: 100px;
		  color: white;
		}
	</style>
	
	
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
	</head>
	<body>
		
		<h2>마이페이지</h2>
		
		<c:set var="user" value="${custom.uvo }"></c:set>
		
		<p>${user.userNickName }</p>
		
			<div id="menubar">
				<ul class="sub-menu">
					<li><a href="../user/myInfo"> 내 정보 </a></li>
					<li><a href="../user/myPageList"> 내가 작성한 게시판들 </a></li>
					<li><a href="../user/myReviewList">내가 작성한 댓글들 </a></li>
				</ul>
				
			</div>
			
			
			
			<div>
				
				<a href="../user/likeList"><button type="button" class="btn btn-outline-info }" style="float: left;"> 좋아요 목록</button></a>
			</div>
			<br><br>
			
			<div>
				<a href="../user/wishList"><button type="button" class="btn btn-outline-info }" style="float: left;">찜 목록</button></a>
			</div>
			<br><br>
			
			<div>
				<a href="../main/all"> 메인으로</a>
			</div>
		
		
		<form action="../customLogout" method="POST">
			<input type="hidden" name="${_csrf.parameterName }" 
											value="${_csrf.token }"/>
			
			<button style="background-color:#4CAF50;">로그아웃</button>
			
		</form>
		
		
		<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.6.0/dist/umd/popper.min.js" integrity="sha384-KsvD1yqQ1/1+IA7gi3P0tyJcT3vR+NdBTt13hSJ2lnve8agRGXTTyNaBYmCR/Nwi" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.min.js" integrity="sha384-nsg8ua9HAw1y0W1btsyWgBklPnCUAFLuTMS2G72MMONqmOymq585AcH49TLBQObG" crossorigin="anonymous"></script>
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
		
        <br><br><br><br><br><br><br><br><br><br><br><br><br><br>
       <div class="footer">
            <br>
          여행커뮤니티 방콕속 여행<br>

        </div>
		
	</body>
</html>