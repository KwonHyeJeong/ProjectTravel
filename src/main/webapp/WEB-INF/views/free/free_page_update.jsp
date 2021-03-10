<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${FreePageVO.freeTitle }</title>
</head>
<body>
  <h2>자유게시판 글 수정</h2>
  <form action="free_page_update" method="post">
    <input type="hidden" name="page" value="${page }">
    <div>
      <p>글 번호 : ${FreePageVO.freeNo }</p>
      <input type="hidden" name="freeNo" value="${FreePageVO.freeNo }">
    </div>
    <div>
      <p>
        제목 : <input type="text" name="freeTitle" value="${FreePageVO.freeTitle }" required>
      </p>
    </div>
    <div>
      <p>작성자 : ${FreePageVO.userNickname }</p>
      
      
      <p>작성일 : ${FreePageVO.freeCdate }</p>
    </div>
    <div>
      <textarea rows="20" cols="120" name="freeContent" required>${FreePageVO.freeContent }</textarea>
    </div>
    <div>
    	<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"/>
      <input type="submit" value="제출">
    </div>
  </form>

</body>
</html>







