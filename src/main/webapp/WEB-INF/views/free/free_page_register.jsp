<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판 글 작성 페이지</title>
</head>
<body>
  <h2>자유게시판 글 작성 페이지</h2>
  
  <form action="free_page_register" method="POST">
    
    <div>
      <p>제목 : 
      <input type="text" name="freeTitle" placeholder="제목 입력" required="required">
      </p>
    </div>
    
    <div>
    	<c:if test="${not empty custom.uvo }">
	    	<p>작성자 : 
		     <input type="text" name="userNickname" value="${custom.uvo.userNickName}" readonly="readonly">
		    </p>
    	</c:if>
    	
    	<c:if test="${not empty custom.avo }">
	    	<p>작성자 : 
		     <input type="text" name="userNickname" value="${custom.avo.adminID}" readonly="readonly">
		    </p>
    	</c:if>
    	
	</div>
    
    
    <div>
      <textarea rows="20" cols="120" name="freeContent"
      placeholder="내용 입력" required="required"></textarea>
    </div>
    <div>
      <input  style="background-color:#4CAF50;" type="submit" value="등록">
    </div>
    <div>
    	<a href="free_page_list"><input  style="background-color:#4CAF50;" type="button" value="취소"></a>
    </div>
    <div>
    	<input type="hidden" name="${_csrf.parameterName }" 
    						value="${_csrf.token }"/>
    </div>
    
  </form>
  
  
  
  
</body>
</html>
