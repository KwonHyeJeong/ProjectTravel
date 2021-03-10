<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page import="java.util.*" %>
    
<!DOCTYPE html>
<html>
	<head>
	<style>
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
		   width:800px;
		}
		ul.main-menu > li ul.sub-menu{
		    display:none;
		    position:absolute;
		    float:none;
		    background-color: #4CAF50 ;
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
		
		
		/*사진 슬라이더*/
		#wrapper{
		  width:1500px;
		  margin:50px auto;
		  height:400px;
		  position:relative;
		  color:#fff;
		  text-shadow:rgba(0,0,0,0.1) 2px 2px 0px;  
		}
		
		#slider-wrap{
		  width:1500px;
		  height:400px;
		  position:relative;
		  overflow:hidden;
		}
		
		#slider-wrap ul#slider{
		  width:100%;
		  height:100%;
		  
		  position:absolute;
		  top:0;
		  left:0;   
		}
		
		#slider-wrap ul#slider li{
		  float:left;
		  position:relative;
		  width:1500px;
		  height:400px; 
		}
		
		#slider-wrap ul#slider li > div{
		  position:absolute;
		  top:20px;
		  left:35px;  
		}
		
		#slider-wrap ul#slider li > div h3{
		  font-size:36px;
		  text-transform:uppercase; 
		}
		
		#slider-wrap ul#slider li > div span{
		  font-family: Neucha, Arial, sans serif;
		  font-size:21px;
		}
		
		#slider-wrap ul#slider li img{
		  display:block;
		  width:100%;
		  height: 100%;
		}
		
		
		/*btns*/
		.btns{
		  position:absolute;
		  width:50px;
		  height:60px;
		  top:50%;
		  margin-top:-25px;
		  line-height:57px;
		  text-align:center;
		  cursor:pointer; 
		  background:rgba(0,0,0,0.1);
		  z-index:100;
		  
		  
		  -webkit-user-select: none;  
		  -moz-user-select: none; 
		  -khtml-user-select: none; 
		  -ms-user-select: none;
		  
		  -webkit-transition: all 0.1s ease;
		  -moz-transition: all 0.1s ease;
		  -o-transition: all 0.1s ease;
		  -ms-transition: all 0.1s ease;
		  transition: all 0.1s ease;
		}
		
		.btns:hover{
		  background:rgba(0,0,0,0.3); 
		}
		
		#next{right:-50px; border-radius:7px 0px 0px 7px;}
		#previous{left:-50px; border-radius:0px 7px 7px 7px;}
		#counter{
		  top: 30px; 
		  right:35px; 
		  width:auto;
		  position:absolute;
		}
		
		#slider-wrap.active #next{right:0px;}
		#slider-wrap.active #previous{left:0px;}
		
		
		/*bar*/
		#pagination-wrap{
		  min-width:20px;
		  margin-top:350px;
		  margin-left: auto; 
		  margin-right: auto;
		  height:15px;
		  position:relative;
		  text-align:center;
		}
		
		#pagination-wrap ul {
		  width:100%;
		}
		
		#pagination-wrap ul li{
		  margin: 0 4px;
		  display: inline-block;
		  width:5px;
		  height:5px;
		  border-radius:50%;
		  background:#fff;
		  opacity:0.5;
		  position:relative;
		  top:0;
		}
		
		#pagination-wrap ul li.active{
		  width:12px;
		  height:12px;
		  top:3px;
		  opacity:1;
		  box-shadow:rgba(0,0,0,0.1) 1px 1px 0px;
		}
		
		
		
		/*ANIMATION*/
		#slider-wrap ul, #pagination-wrap ul li{
		  -webkit-transition: all 0.3s cubic-bezier(1,.01,.32,1);
		  -moz-transition: all 0.3s cubic-bezier(1,.01,.32,1);
		  -o-transition: all 0.3s cubic-bezier(1,.01,.32,1);
		  -ms-transition: all 0.3s cubic-bezier(1,.01,.32,1);
		  transition: all 0.3s cubic-bezier(1,.01,.32,1); 
		}
    
    /* counter */
    .counter {font-family:'Roboto', tahoma, 'Noto Sans', sans-serif; font-size:0.688em; text-align:center; letter-spacing:1px}
    .counter .total {display:block}
    .counter .today {color:#999}
    .counter .today strong {font-weight:normal; color:#333}
    .counter .pipe {display:inline-block; margin:0 4px; color:#eee}


		
		.footer{
		  background-color: #333;
		  text-align: center;
		  height: 200px;
		  color: white;
		}
	</style>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	</head>
	<body>
		
		<h2>Access Denied Page</h2>
		
		<h3><c:out value="${SPRING_SECURITY_403_EXCEPTION.getMessage() }"/></h3>
		<h3><c:out value="${msg }"/></h3>
		
		<div id="menubar">
				<ul class="main-menu">
                    <li><a href="../main/all">메인화면</a>
				</ul>
		</div>
		
		
		
	</body>
</html>