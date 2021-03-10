<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib  prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>



<!DOCTYPE html>
<html>
	
<head>
	<style>
		.oriImg{ width: 500px; height: auto;}
		.thumbImg{}
    
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
	<meta charset="UTF-8">
	<title>${PlayPageVO.playTitle }</title>
	<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
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
    <h2>PLAY 게시판 등록</h2>
    <hr>
  
  	<div>
  		<a href="warning?userNickname=${PlayPageVO.userNickname }">
  			<input style="background-color:#4CAF50;" type="button" value="신고하기"></a>
  	</div>
  	
  <div>
    <p>PLAY 게시판 글 번호 : ${PlayPageVO.playNo }</p>
  </div>
  <div>
    <p>
      제목 <input type="text" value="${PlayPageVO.playTitle }"
        readonly="readonly">
    </p>
  </div>
  <div>
    <p>작성자 : ${PlayPageVO.userNickname }</p>
    <fmt:formatDate value="${PlayPageVO.playCdate }" pattern="yyyy-MM-dd HH:mm:ss"
      var="playCdate" />
    <p>작성일 : ${playCdate }</p>
    <p>조회수 : ${PlayPageVO.playViewCnt }</p>
    
    <div id="like">
	   <p>좋아요 : ${PlayPageVO.playGoodCnt }</p>
	</div>
	    
	<a class="btn btn-outline-dark heart">
	    <img id="heart" src="">
    </a>
    
    <div id="wish">
		<p>찜 : ${PlayPageVO.playWishCnt }</p>
	</div>
   	<a class="btn btn-outline-dark basket">
       <img id="basket" src="">
   	</a>
    
    
    <br>
  </div>
  
  
  
  
  <div class="inputArea">
 		<label for="img"></label>
		 <img src="display?fileName=${PlayPageVO.img}" class="oriImg"/>
		 
	</div>
	
	<div>
    	<textarea rows="20" cols="120" readonly="readonly">${PlayPageVO.playContent }</textarea>
  	</div>
  	
  	
  	
  	<c:if test="${not empty custom.username }">
  	
  		<c:if test="${custom.username == custom.uvo.userID }">
  		
  		<c:if test="${custom.uvo.userNickName != PlayPageVO.userNickname}">
			<div>
				 <a href="list?page=${page }"><input style="background-color:#4CAF50;" type="button" value="글 목록"></a>
				 <p>사용자 닉네임 : ${custom.uvo.userNickName }</p>
				 <p>글쓴이 닉네임 : ${PlayPageVO.userNickname }</p>
			</div>
			
  		</c:if>
  	
  	
	  	<c:if test="${custom.uvo.userNickName == PlayPageVO.userNickname}">
			<div>
				<a href="list?page=${page }"><input style="background-color:#4CAF50;" type="button" value="글 목록"></a>
			    <a href="update?playNo=${PlayPageVO.playNo }&page=${page}"><input style="background-color:#4CAF50;" type="button" value="글 수정"></a> 
			    <a href="delete?playNo=${PlayPageVO.playNo }"><input style="background-color:#4CAF50;" type="button" value="글 삭제"></a>
			</div>
			  
		</c:if>
		
	</c:if>
	
	
	
	<c:if test="${custom.username == custom.avo.adminID}">
		<div>
			<a href="list?page=${page }"><input style="background-color:#4CAF50;" type="button" value="글 목록"></a>
		    <a href="update?playNo=${PlayPageVO.playNo }&page=${page}"><input style="background-color:#4CAF50;" type="button" value="글 수정"></a> 
		    <a href="delete?playNo=${PlayPageVO.playNo }"><input style="background-color:#4CAF50;" type="button" value="글 삭제"></a>
			    
		 </div>
  		
  	</c:if>
	
	
		
	<div style="text-align: left;">
      <div>
        <input type="hidden" id="playNo" name="playNo" value="${PlayPageVO.playNo }">
        <c:if test="${custom.username == custom.uvo.userID}">
        	 <p>작성자 : <input type="text" id="userNickname" name="userNickname" value="${custom.uvo.userNickName }" required></p>
        </c:if>
       	
       	<c:if test="${custom.username == custom.avo.adminID}">
        	 <p>작성자 : <input type="text" id="userNickname" name="userNickname" value="${custom.avo.adminID }" required></p>
        </c:if>
       	
        
        <input type="text" id="playReviewContent" name="playReviewContent" placeholder="댓글 입력" required>
        
        <button style="background-color:#4CAF50;" type="button" id="btn_add">작성</button>
       </div>
		       
	</div>
	
	 <div style="text-align: left;">
		<div id="replies">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		</div>
		
	</div>
  		
  </c:if>
  	
  	
  	
 
  
  
  
  <c:if test="${empty custom.username }">
	  	<div>
		  	<a href="../main/all?page=${page }"><input style="background-color:#4CAF50;" type="button" value="글 목록"></a>
		  	
		    <p>글쓴이 닉네임 : ${PlayPageVO.userNickname }</p>
		   
		</div>
		
		
  	</c:if>
  
  
  
  
  
  
  
  <div>
  	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

  </div>
  
  
  
 <script type="text/javascript">
    $(document).ready(function () {
    	var playNo = $('#playNo').val();
    	console.log(playNo);
    	
    	
    	getAllReplies();
    	
        var heartval = ${heart};
        var basketVal = ${basket};
        
        var goodCnt = ${PlayPageVO.playGoodCnt };
        var wishCnt = ${PlayPageVO.playWishCnt };
        

        if(heartval > 0) 
        {
            console.log(heartval);
            $("#heart").prop("src", "<spring:url value='/resources/images/like.png'/>");
            $(".heart").prop('name',heartval);
            $("#like").css("color","red");
        }
        else {
            console.log(heartval);
            $("#heart").prop("src", "<spring:url value='/resources/images/dislike.png'/>");
            $(".heart").prop('name',heartval);
            $("#like").css("color","black");
        }
        
        
        if(basketVal > 0)
        {
        	console.log(basketVal);
            $("#basket").prop("src", "<spring:url value='/resources/images/wish.png'/>");
            $(".basket").prop('name',basketVal);
            $("#wish").css("color","red");
        	
        }
        else
        {
        	 console.log(basketVal);
             $("#basket").prop("src", "<spring:url value='/resources/images/diswish.png'/>");
             $(".basket").prop('name',basketVal);
             $("#wish").css("color","black");
        	
        }
        

        $(".heart").on("click", function () {

            var that = $(".heart");
            var playNo = $('#playNo').val();
            var nickName = $('#userNickname').val();
            console.log(nickName);
            

            var sendData = {'playNo' : playNo,'heart' : that.prop('name'), 'nickName' : nickName};
            var csrfHeaderName = "${_csrf.headerName}";
    		var csrfTokenValue = "${_csrf.token}";
    		console.log(sendData);
    		
    		
			// ajaxSetup
			/*
			$.ajaxSetup({
				beforeSend: function(xhr) {
                    xhr.setRequestHeader(csrfHeaderName, csrfTokenValue);
                }  
            })
    		*/
            
    		
            $.ajax({
                url :'/travel06/play/heart',
                type :'POST',
                data : sendData,
                success : function(data){
                    that.prop('name',data);
                    if(data==1) {
                    	goodCnt = goodCnt +1;
                        $('#heart').prop("src","<spring:url value='/resources/images/like.png'/>");
                        $("#like").css("color","red");
                        $('#like').html("<p>좋아요 : " + goodCnt + "</p>");
                    }
                    else{
                    	goodCnt = goodCnt - 1;
                        $('#heart').prop("src","<spring:url value='/resources/images/dislike.png'/>");
                        $("#like").css("color","black");
                        $('#like').html("<p>좋아요 : " + goodCnt + "</p>");
                    }


                }
            });	// end ajax 
			
			
			
        });	// end heart click
        
        
        $(".basket").on("click", function () {

            var that = $(".basket");
            var playNo = $('#playNo').val();
            var nickName = $('#userNickname').val();
            console.log(nickName);
            
            
            var sendData = {'playNo' : playNo,'basket' : that.prop('name'), 'nickName' : nickName};
            var csrfHeaderName = "${_csrf.headerName}";
    		var csrfTokenValue = "${_csrf.token}";
    		console.log(sendData);
    		
            
            $.ajax({
                url :'/travel06/play/basket',
                type :'POST',
                data : sendData,
                success : function(data){
                    that.prop('name',data);
                    if(data==1) {
                        $('#basket').prop("src","<spring:url value='/resources/images/wish.png'/>");
                        $("#wish").css("color","red");
                        wishCnt = wishCnt+1;
                        $('#wish').html("<p>찜 : " + wishCnt + "</p>");
                    }
                    else{
                        $('#basket').prop("src","<spring:url value='/resources/images/diswish.png'/>");
                        $("#wish").css("color","black");
                        wishCnt = wishCnt-1;
                        $('#wish').html("<p>찜 : " + wishCnt + "</p>");
                    }


                }
            
            });	// end ajax
            
            
        });	// end basket click
        
        
        
        
        $('#btn_add').click(function(){
     		var userNickname = $('#userNickname').val();
     		var playNo = $('#playNo').val();
     		var playReviewContent = $('#playReviewContent').val();
     		
     		var csrfHeaderName = "${_csrf.headerName}";
    		var csrfTokenValue = "${_csrf.token}";
     		
     		console.log(csrfHeaderName);
			console.log(csrfTokenValue);
     		
     		var object = {
     			
     			'playNo': playNo,
     			'userNickname' : userNickname,
     			'playReviewContent' : playReviewContent
     			
     		};
     		console.log(object);
     		
     		
     		
     		$.ajax({
         	    type : 'post',
         	    url : '../play/replies/new',
         	    headers:{
         	      'Content-Type' : 'application/json',
         	      'X-HTTP-Method-Override' : 'POST'
         	    },
         	    data : JSON.stringify(object),
         	    success : function(result, status)
         	    {
         	      console.log(result);
         	      console.log(status);
         	      if(result == 1){
         	        alert('댓글 입력 성공');
         	       
         	        $('#playReviewContent').val('');
         	        
         	      }
         	      
         	    }	// end success
         	    
         	    
         	  });	// end ajax()
     		
     		
     		
     	});	// end btn_add
     	
     	
	     // 게시판의 댓글 전체 가져오기
	  	 function getAllReplies()
	  	  {
	  	    var url = '../play/replies/all/' + playNo ;
	  	    $.getJSON(
	  	    	url,
	  	    	function(jsonData){
	  	    	  console.log(jsonData);
	  	    	  var list = '';	// JSON 데이터를 표현할 변수
	  	    	  
	  	    	  // jsonData를 사용하는 each 반복문
	  	    	  $(jsonData).each(function()
	  	    	  {
	  	    	    var playReviewCdate = new Date(this.playReviewCdate);
	  	    	   
	  	    	    var writer = $('#userNickname').val();
	  	    	    var nameRule = 'admin';
	  	    	   
	  	    	    
	  	    	    // this : jsonData
	  	          	console.log(this.userNickname);
	  	          	
	  	          	var disabled = 'disabled';
		          	if(writer == this.userNickname
		          			|| writer.search(nameRule) != -1) 
		          	{
		          	  disabled = '';
		          	}
	  	    	    
		          	
		          	console.log(writer.search(nameRule));
		          	
		          	console.log(disabled);
	  	    	    
	  	          	list += '<div class="reply_item">'
	                       + '<pre>'
	                       + '<input type="hidden" id="playReviewNO" value="' + this.playReviewNO + '" />'
	                       + '<input type="hidden" id="userNickname" value="' + this.userNickname + '" />'
	                       + this.userNickname
	                       + '&nbsp;&nbsp;' // 공백
	                       + '<input type="hidden" id="playReviewContent" value="' + this.playReviewContent + '" />'
	                       + this.playReviewContent
	                       + '&nbsp;&nbsp;' // 공백
	                       + playReviewCdate
	                       + '&nbsp;&nbsp;' // 공백
	                       + '<input type="text" id="updateContent" '+ disabled + '/>'
	                       + '<button class="btn_update" type="button" '+ disabled+ '>수정</button>'
	                       + '<button class="btn_delete" type="button" '+ disabled+ '>삭제</button>'
	                       + '\n\n'
	                       +'<a href="warning?userNickname='+this.userNickname+'"> 신고 </a>'
	                       + '</pre>' + '</div>';
	                 		}); // end each()
	         			$('#replies').html(list);
	                 	
	  	    	  
	  	    	}	// end callback
	  	    
	  	    );	// end getJSON()
	  	    
	  	    
	  	  }	// end getAllReplies()
	  	  
	  	  
	  	  
	  	  
	  		// 수정 버튼을 클릭하면 선택된 댓글 수정
	      	$('#replies').on('click', '.reply_item .btn_update',
	              function() {
	                console.log(this);
	                
	                var csrfHeaderName = "${_csrf.headerName}";
	        		var csrfTokenValue = "${_csrf.token}";
	        		
	         		

	                // 선택된 댓글 replyNo, replyContent 값을 저장
	                var reviewNo = $(this).prevAll('#playReviewNO').val();
	                var reviewContent = $(this).prevAll('#playReviewContent').val();
	              	var updateContent = $(this).prevAll('#updateContent').val();
	                var userNickName = $('#userNickname').val();
	                var playNo = $('#playNo').val();
	                
	                
	                console.log("선택된 댓글 번호 : " + reviewNo + 
	                				", 댓글 내용 : " + reviewContent
	                				+", 수정된 댓글 내용 : " + updateContent
	                				+", 게시글 번호 : " + playNo
	                				+ ", 작성자 : " + userNickName);
	                
	            	
	             // ajaxSetup
	               
	                
	                
	                // ajax 요청
	                $.ajax({
	                  type : 'put',
	                  url : '../play/replies/' + reviewNo,
	                  headers : {
	                    'Content-Type' : 'application/json',
	                    'X-HTTP-Method-Override' : 'PUT'
	                  },
	                  data : JSON.stringify({
	                	
	                    'playReviewContent' : updateContent,
	                    'playNo' : playNo,
	                    'userNickname' : userNickName,
	                    'playReviewNO' : reviewNo
	                   
	                  }),
	                  success : function(result) 
	                  {
	                    if(result == 'success') 
	                    {
	                      alert('댓글 수정성공');
	                      getAllReplies();
	                      
	                    }
	                    
	                  } // end success
	                  
	                  
	           	}); // end ajax()
	             
	             
	     }); // end btn_update()
	     
	     
	     // 삭제 버튼을 클릭하면 선택된 댓글 삭제
         $('#replies').on('click', '.reply_item .btn_delete',
             function() {
               console.log(this);
               
               var csrfHeaderName = "${_csrf.headerName}";
               var csrfTokenValue = "${_csrf.token}";

               // 선택된 댓글 replyNo
               var playReviewNo = $(this).prevAll('#playReviewNo').val();
               var playNo = $('#playNo').val();
               console.log("선택된 댓글 번호 : " + playReviewNo);
               
               
            
               // ajax 요청
               $.ajax({
                 type : 'delete',
                 url : '../play/replies/' + playReviewNo,
                 headers : {
                   'Content-Type' : 'application/json',
                   'X-HTTP-Method-Override' : 'DELETE'
                 },
                 data : JSON.stringify({
                   'playReviewNo' : playReviewNo
                 }),
                 success : function(result) {
                   if (result == 'success') {
                     alert('댓글 삭제성공');

                     getAllReplies();
                   }
                   
                 } // end success
                 
                 
               }); // end ajax()
               
               
             }); // end btn_delete()
        
        
        
    });	// end document
</script> 



           <br>
       <div class="footer">
            <br>
          여행커뮤니티 방콕속 여행<br>

        </div> 
  



</body>
</html>