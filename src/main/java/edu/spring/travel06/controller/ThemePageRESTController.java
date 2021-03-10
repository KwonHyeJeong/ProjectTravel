package edu.spring.travel06.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import edu.spring.travel06.domain.ThemePageVO;
import edu.spring.travel06.service.ThemePageService;


@RestController
@RequestMapping(value="/theme")
public class ThemePageRESTController 
{
	
	private static final Logger logger = 
			LoggerFactory.getLogger(ThemePageRESTController.class);
	
	
	@Autowired
	private ThemePageService themeService;
	
	
	// 닉네임 변경
	@PutMapping("/updateNickName/{userNickname}")
	public ResponseEntity<String> updateNickNames(
					@PathVariable("userNickname") String userNickname,
					@RequestBody ThemePageVO themeVO,
					RedirectAttributes reAttr
							)
	{
		
		logger.info("새로운 닉네임 : "+userNickname);
		logger.info(themeVO.toString());
		int result;
		ResponseEntity<String> entity = null;
		List<ThemePageVO> fList = themeService.readByUserNickname(userNickname);
		for(ThemePageVO vo : fList)
		{
			logger.info(vo.toString());
			result = themeService.updateNickname(themeVO.getUserNickname(), vo);
			logger.info("결과 : " + result);
			if(result == 0)
			{
				entity = new ResponseEntity<String>("good7", HttpStatus.OK);
			}
			else
			{
				entity = new ResponseEntity<String>("bad7", HttpStatus.OK);
			}
			
		}
		
		
		return entity;
	}
		
		
	@GetMapping("/getNickName/{userNickname}")
	public ResponseEntity<String> getNickNames(
				@PathVariable("userNickname") String userNickname,
				RedirectAttributes reAttr)
	{
		logger.info("닉네임 : "+userNickname);
	
		int result;
		
		List<ThemePageVO> fList = themeService.readByUserNickname(userNickname);
		for(ThemePageVO theme : fList)
		{
			logger.info(theme.toString());
			
		}
		
		
		return new ResponseEntity<String>("getNickname", HttpStatus.OK);
	}
	
	
	
	
}
