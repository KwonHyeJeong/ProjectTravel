package edu.spring.travel06.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.spring.travel06.domain.*;
import edu.spring.travel06.service.*;


@RestController
@RequestMapping(value="/free")
public class FreePageRESTController 
{
	private static final Logger logger = 
			LoggerFactory.getLogger(FreePageRESTController.class);
	
	@Autowired
	private FreePageService freeService;
	
	
	
	// 닉네임 변경
	@PutMapping("/updateNickName/{userNickname}")
	public ResponseEntity<String> updateNickNames(
							@PathVariable("userNickname") String userNickname,
							@RequestBody FreePageVO fvo,
							RedirectAttributes reAttr
							)
	{
		
		logger.info("새로운 닉네임 : "+userNickname);
		logger.info(fvo.toString());
		int result;
		ResponseEntity<String> entity = null;
		List<FreePageVO> fList = freeService.readByUserNickname(userNickname);
		for(FreePageVO vo : fList)
		{
			logger.info(vo.toString());
			result = freeService.updateNickname(fvo.getUserNickname(), vo);
			logger.info("결과 : " + result);
			if(result == 0)
			{
				entity = new ResponseEntity<String>("good", HttpStatus.OK);
			}
			else
			{
				entity = new ResponseEntity<String>("bad", HttpStatus.OK);
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
		
		List<FreePageVO> fList = freeService.readByUserNickname(userNickname);
		for(FreePageVO free : fList)
		{
			logger.info(free.toString());
			
		}
		
		
		return new ResponseEntity<String>("getNickname", HttpStatus.OK);
	}
	
	
	
}
