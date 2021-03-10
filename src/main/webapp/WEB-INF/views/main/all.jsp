<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>


<!DOCTYPE html>
<html>
   <head>
      <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
        <link href='https://fonts.googleapis.com/css?family=Anton' rel='stylesheet' type='text/css'>
        <link href='https://fonts.googleapis.com/css?family=Neucha' rel='stylesheet' type='text/css'>
   
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
   <title>Travel</title>
   <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
   
   
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
      
      
      <sec:authorize access="isAnonymous()">
         
      
         <div id="menubar">
            <ul class="main-menu">
                    <li><a href="../main/all">메인화면</a>
               <li><a href="../theme/list"> THEME 추천 </a></li>
               <li><a href="../food/list"> FOOD 게시판</a></li>
               <li><a href="../play/list"> PLAY 게시판</a></li>
               <li><a href="../free/free_page_list">자유게시판</a></li>
               <li><a href="../notice/listNotice"> 공지사항 </a></li>
            </ul>
         </div>
         
         <hr>
   
         <div id="menubar">
            <ul class="sub-menu">
               <li><a href="../customLogin"> 로그인 </a></li>
               
            </ul>
         </div>
         <hr>
         <div id="menubar">
            <ul class="sub-menu">
               <li><a href="../user/register"> 회원가입</a></li>
               <li><a href="../main/finduserID"> 회원 ID 찾기</a></li>
               <li><a href="../main/finduserPWD"> 회원 비밀번호 찾기</a></li>
               
            </ul>
         </div>
         <hr>
         <div id="menubar">
            <ul class="sub-menu">
               <li><a href="../admin/register">관리자 회원가입</a></li>
               <li><a href="../main/findAdminID"> 관리자 ID 찾기</a></li>
               <li><a href="../main/findAdminPWD"> 관리자 비밀번호 찾기</a></li>
               
            </ul>
         </div>
      
            <s_sidebar_element>
                <!-- 방문자수 -->
                <div class="counter">
                    <h1 class="sr-only" >Counter</h1>
                    <p class="total" >Total : ${visit1 }</p>
                    <br>
                    <p class="today" >
                        Today : <strong>${visit2 }</strong>
                    </p>
                </div>
            </s_sidebar_element>


         
         
         <br>
         <hr>
         
         <!-- 슬라이더 쇼 -->
          <div id="wrapper">
              <div id="slider-wrap">
                  <ul id="slider">
                     <li>
                        <div>
                            <span>서울 경복궁</span>
                        </div>                
                    <img src="../resources/images/gyeongbok.jpg">
                     </li>
                     
                     <li>
                        <div>
                            <span>창덕궁</span>
                        </div>
                       <img src="../resources/images/changdeokgung.jpg">
                     </li>
                     
                     <li>
                        <div>
                            <span>담양</span>
                        </div>
                       <img src="../resources/images/damyang.jpg">
                     </li>
                     
                     <li>
                        <div>
                            <span>독도</span>
                        </div>
                       <img src="../resources/images/dokdo.jpg">
                     </li>
                     
                     <li>
                        <div>
                            <span>제주도</span>
                        </div>
                       <img src="../resources/images/jejudo.jpg">
                     </li>
                     
                     
                  </ul>
                  
                   <!--controls-->
                  <div class="btns" id="next"><i class="fa fa-arrow-right"></i></div>
                  <div class="btns" id="previous"><i class="fa fa-arrow-left"></i></div>
                  <div id="counter"></div>
                  
                  <div id="pagination-wrap" >
                    <ul style="display:block;">
                    </ul>
                  </div>
                  <!--controls-->  
                         
              </div>
          
           </div>
         
         
         
      </sec:authorize>
      
      <sec:authorize access="isAuthenticated()">
         <c:if test="${not empty custom.uvo }">
         
         
            <div class="login">
               <p>${custom.uvo.userNickName}님 환영합니다!</p>
               <form action="../customLogout" method="POST">
                  <input type="hidden" name="${_csrf.parameterName }" 
                                          value="${_csrf.token }"/>
               
               <button id="btn_logout" style="background-color:#4CAF50;">로그아웃</button>
            <br>
               </form>
               
            </div>
            
            
            <div id="menubar">
               <ul class="sub-menu">
                  <li><a href="../main/user">마이페이지</a></li>
               </ul>
            </div>
            
         </c:if>
         
         <c:if test="${not empty custom.avo }">
         
            <div class="login">
               <p>${custom.avo.adminID}님 환영합니다!</p>
               <form action="../customLogout" method="POST">
                  <input type="hidden" name="${_csrf.parameterName }" 
                                          value="${_csrf.token }"/>
               
               <button id="btn_logout" style="background-color:#4CAF50;">로그아웃</button>
          <br>
            
               </form>
               
            </div>
            
            <div id="menubar">
               <ul class="sub-menu">
                  <li><a href="../main/admin">마이페이지</a></li>
               </ul>
            </div>
            
         </c:if>
         
         <div id="menubar">
            <ul class="main-menu">
                    <li><a href="../main/all">메인화면</a>
               <li><a href="../theme/list"> THEME 추천 </a></li>
               <li><a href="../food/list"> FOOD 게시판</a></li>
               <li><a href="../play/list"> PLAY 게시판</a></li>
               <li><a href="../free/free_page_list">자유게시판</a></li>
               <li><a href="../notice/listNotice"> 공지사항 </a></li>
            </ul>
         </div>
         
         
             <s_sidebar_element>
                <!-- 방문자수 -->
                <div class="counter">
                    <h1 class="sr-only" >Counter</h1>
                    <p class="total" >Total : ${visit1 }</p>
                    <br>
                    <p class="today" >
                        Today : <strong>${visit2 }</strong>
                    </p>
                </div>
            </s_sidebar_element>
         
         <!-- 슬라이더 쇼 -->
          <div id="wrapper">
              <div id="slider-wrap">
                  <ul id="slider">
                     <li>
                        <div>
                            <span>서울 경복궁</span>
                        </div>                
                    <img src="../resources/images/gyeongbok.jpg">
                     </li>
                     
                     <li>
                        <div>
                            <span>창덕궁</span>
                        </div>
                       <img src="../resources/images/changdeokgung.jpg">
                     </li>
                     
                     <li>
                        <div>
                            <span>담양</span>
                        </div>
                       <img src="../resources/images/damyang.jpg">
                     </li>
                     
                     <li>
                        <div>
                            <span>독도</span>
                        </div>
                       <img src="../resources/images/dokdo.jpg">
                     </li>
                     
                     <li>
                        <div>
                            <span>제주도</span>
                        </div>
                       <img src="../resources/images/jejudo.jpg">
                     </li>
                     
                     
                  </ul>
                  
                   <!--controls-->
                  <div class="btns" id="next"><i class="fa fa-arrow-right"></i></div>
                  <div class="btns" id="previous"><i class="fa fa-arrow-left"></i></div>
                  <div id="counter"></div>
                  
                  <div id="pagination-wrap" >
                    <ul style="display:block;">
                    </ul>
                  </div>
                  <!--controls-->  
                         
              </div>
          
           </div>
         
         
         
         
      </sec:authorize>
      
      
      
      <br>
     
       
        <hr>
        
        
        
        
        <input id="userAlert" type="hidden" value="${user_result}">
        <input id="adminAlert" type="hidden" value="${admin_result}">
        <input id="userDeleteAlert" type="hidden" value="${userDeleteResult }">
        <input id="adminDeleteAlert" type="hidden" value="${adminDeleteResult }">
        
        
      <script type="text/javascript">
      $(document).ready(function(){
         
         
         //current position
            var pos = 0;
            //number of slides
            var totalSlides = $('#slider-wrap ul li').length;
            //get the slide width
            var sliderWidth = $('#slider-wrap').width();
         
         
            confirmUserResult();
            confirmAdminResult();
            userDeleteResult()
            
            
            
            function confirmUserResult() 
            {
              var result = $('#userAlert').val();
              if (result === 'success') 
              {
                alert('사용자 회원가입 성공! 로그인 하세요.');
                location.href="/travel06/customLogin";
              } 
              else if(result === 'fail')
              {
                alert('사용자 회원가입 실패');
              }
              
            } // end confirmUserResult
            
            
            
            function confirmAdminResult() 
            {
              var result = $('#adminAlert').val();
              if (result === 'success') 
              {
                 alert('관리자 회원가입 성공! 로그인 하세요.');
                 location.href="/travel06/customLogin";
              } 
              else if(result === 'fail')
              {
                alert('관리자 회원가입 실패');
              }
              
            } // end confirmAdminResult
            
            
            function userDeleteResult()
            {
               
               var result = $('#userDeleteAlert').val();
               console.log("결과 : " + result);
               if(result === "success"){
                  
                  alert('탈퇴 성공 !!');
               }
               else if(result === 'fail')
               {
                  alert('탈퇴 실패 ㅠㅠ');
               }
               
            } // end confirmdeleteResult
            
            
            
            /*****************
               BUILD THE SLIDER
              *****************/
              //set width to be 'x' times the number of slides
              $('#slider-wrap ul#slider').width(sliderWidth*totalSlides);
              
                //next slide  
              $('#next').click(function(){
                slideRight();
              });
              
              //previous slide
              $('#previous').click(function(){
                slideLeft();
              });
              
              
              
              /*************************
               //*> OPTIONAL SETTINGS
              ************************/
              //automatic slider
              var autoSlider = setInterval(slideRight, 3000);
              
              //for each slide 
              $.each($('#slider-wrap ul li'), function() { 

                 //create a pagination
                 var li = document.createElement('li');
                 $('#pagination-wrap ul').append(li);    
              });
              
              //counter
              countSlides();
              
              //pagination
              pagination();
              
              //hide/show controls/btns when hover
              //pause automatic slide when hover
              $('#slider-wrap').hover(
                function(){ $(this).addClass('active'); clearInterval(autoSlider); }, 
                function(){ $(this).removeClass('active'); autoSlider = setInterval(slideRight, 3000); }
              );
              
              
              /***********
              SLIDE LEFT
             ************/
             function slideLeft(){
               pos--;
               if(pos==-1){ pos = totalSlides-1; }
               $('#slider-wrap ul#slider').css('left', -(sliderWidth*pos));  
               
               //*> optional
               countSlides();
               pagination();
             }


             /************
              SLIDE RIGHT
             *************/
             function slideRight(){
               pos++;
               if(pos==totalSlides){ pos = 0; }
               $('#slider-wrap ul#slider').css('left', -(sliderWidth*pos)); 
               
               //*> optional 
               countSlides();
               pagination();
             }



               
             /************************
              //*> OPTIONAL SETTINGS
             ************************/
             function countSlides(){
               $('#counter').html();
             }

             function pagination(){
               $('#pagination-wrap ul li').removeClass('active');
               $('#pagination-wrap ul li:eq('+pos+')').addClass('active');
             }
           
         
         
      });   // end document
      
      
      </script>  
        
      
      <div class="footer">
          여행커뮤니티 방콕속 여행<br>
        Image by <a href="https://pixabay.com/users/usagi_post-1232252/?utm_source=link-attribution&amp;utm_medium=referral&amp;utm_campaign=image&amp;utm_content=1214975">이룬 봉</a> from <a href="https://pixabay.com/?utm_source=link-attribution&amp;utm_medium=referral&amp;utm_campaign=image&amp;utm_content=1214975">Pixabay</a>
        <br>
        Image by <a href="https://pixabay.com/users/tampigns-211600/?utm_source=link-attribution&amp;utm_medium=referral&amp;utm_campaign=image&amp;utm_content=786592">Stephane Tampigny</a> from <a href="https://pixabay.com/?utm_source=link-attribution&amp;utm_medium=referral&amp;utm_campaign=image&amp;utm_content=786592">Pixabay</a>
        <br>
        Image by <a href="https://pixabay.com/users/changui-mun-5130894/?utm_source=link-attribution&amp;utm_medium=referral&amp;utm_campaign=image&amp;utm_content=2237701">Changui Mun</a> from <a href="https://pixabay.com/?utm_source=link-attribution&amp;utm_medium=referral&amp;utm_campaign=image&amp;utm_content=2237701">Pixabay</a>
        <br>
        Image by <a href="https://pixabay.com/users/kmmirr0-1450391/?utm_source=link-attribution&amp;utm_medium=referral&amp;utm_campaign=image&amp;utm_content=1790320">kyejung kim</a> from <a href="https://pixabay.com/?utm_source=link-attribution&amp;utm_medium=referral&amp;utm_campaign=image&amp;utm_content=1790320">Pixabay</a>
        <br>
        Image by <a href="https://pixabay.com/users/kevinyi-18324/?utm_source=link-attribution&amp;utm_medium=referral&amp;utm_campaign=image&amp;utm_content=74956">Kevin Yi</a> from <a href="https://pixabay.com/?utm_source=link-attribution&amp;utm_medium=referral&amp;utm_campaign=image&amp;utm_content=74956">Pixabay</a>
        
        </div>
      
      
   </body>
</html>