package edu.spring.travel06.security;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;





public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler
{
	private static final Logger logger = 
			LoggerFactory.getLogger(CustomLoginSuccessHandler.class);

	
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, 
				HttpServletResponse response,
				Authentication auth) throws IOException, ServletException 
	{
		logger.info("로그인 성공");
		
		
		
		
		
		
		// 디폴트 URI
		String uri = "/";

		/* 강제 인터셉트 당했을 경우의 데이터 get */
		RequestCache requestCache = new HttpSessionRequestCache();
		SavedRequest savedRequest = requestCache.getRequest(request, response);
		
		/* 로그인 버튼 눌러 접속했을 경우의 데이터 get */
		
		String prevPage = (String) request.getSession().getAttribute("prevPage");
		
		if (prevPage != null) {
			request.getSession().removeAttribute("prevPage");
		}

		// null이 아니라면 강제 인터셉트 당했다는 것
		if (savedRequest != null) {
			uri = savedRequest.getRedirectUrl();

		// ""가 아니라면 직접 로그인 페이지로 접속한 것
		} else if (prevPage != null && !prevPage.equals("")) {
			uri = prevPage;
		}

		
		
		
//		List<String> roleNames = new ArrayList<>();
//		auth.getAuthorities().forEach(authority -> 
//		{
//			roleNames.add(authority.getAuthority());
//		});
//		
//		logger.info("권한 : " + roleNames);
//		
//		if(roleNames.contains("ROLE_ADMIN"))
//		{
//			response.sendRedirect("/travel06/main/admin");
//			return;
//		}
//		
//		if(roleNames.contains("ROLE_USER"))
//		{
//			
//			response.sendRedirect("/travel06/main/user");
//			
//			return;
//		}
//		if(roleNames.isEmpty())
//		{
//			response.sendRedirect("/travel06/main/all");
//			return;
//		}
		
		
		// 세 가지 케이스에 따른 URI 주소로 리다이렉트
		response.sendRedirect(uri);
		
	}
	
	
	
	
}
