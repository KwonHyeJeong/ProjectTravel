package edu.spring.travel06.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.spring.travel06.domain.*;
import edu.spring.travel06.service.*;



@Controller
@RequestMapping(value="/")
public class CommonController
{
	private static final Logger logger = 
			LoggerFactory.getLogger(CommonController.class);
	
	
	
	
	@GetMapping("main/accessError")
	public void accessDenied(Authentication auth, Model model)
	{
		logger.info("접근 거부 : " + auth);
		model.addAttribute("msg", "Access Denied");
		
	}
	
	@GetMapping("/customLogin")
	public void loginInput(Model model, String logout, String error,
			HttpServletRequest request) 
	{
		logger.info("customLoginGET() 호출");
		if(logout != null)
		{
			model.addAttribute("logout", "로그아웃 되었습니다.");
		}
		
		if(error != null)
		{
			model.addAttribute("error", "아이디와 비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
		}
		
		
		// 요청 시점의 사용자 URI 정보를 Session의 Attribute에 담아서 전달(잘 지워줘야 함)
		// 로그인이 틀려서 다시 하면 요청 시점의 URI가 로그인 페이지가 되므로 조건문 설정
		String uri = request.getHeader("Referer");
		logger.info(uri);
		if (!uri.contains("/customLogin")) 
		{
			request.getSession().setAttribute("prevPage",
					request.getHeader("Referer"));
		}
		
		
			
		
	}
	
	@PostMapping("/login")
	public void loginPOST()
	{
		logger.info("loginPOST");
		
		
	}
	
	@GetMapping("/customLogout")
	public void logoutGET()
	{
		logger.info("로그아웃");
		
	}
	@PostMapping("/customLogout")
	public void logoutPOST()
	{
		logger.info("logout POST()");
	}
	
	
	
	
	
}
