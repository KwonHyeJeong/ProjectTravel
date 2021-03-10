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

import edu.spring.travel06.domain.PlayPageVO;
import edu.spring.travel06.service.PlayPageService;


@RestController
@RequestMapping(value="/play")
public class PlayPageRESTController 
{
	
	private static final Logger logger = 
			LoggerFactory.getLogger(PlayPageRESTController.class);
	
	
	@Autowired
	private PlayPageService playService;
	
	
	// 닉네임 변경
	@PutMapping("/updateNickName/{userNickname}")
	public ResponseEntity<String> updateNickNames(
					@PathVariable("userNickname") String userNickname,
					@RequestBody PlayPageVO playVO,
					RedirectAttributes reAttr
							)
	{
		
		logger.info("새로운 닉네임 : "+userNickname);
		logger.info(playVO.toString());
		int result;
		ResponseEntity<String> entity = null;
		List<PlayPageVO> fList = playService.readByUserNickname(userNickname);
		for(PlayPageVO vo : fList)
		{
			logger.info(vo.toString());
			result = playService.updateNickname(playVO.getUserNickname(), vo);
			logger.info("결과 : " + result);
			if(result == 0)
			{
				entity = new ResponseEntity<String>("good5", HttpStatus.OK);
			}
			else
			{
				entity = new ResponseEntity<String>("bad5", HttpStatus.OK);
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
		
		List<PlayPageVO> fList = playService.readByUserNickname(userNickname);
		for(PlayPageVO play : fList)
		{
			logger.info(play.toString());
			
		}
		
		
		return new ResponseEntity<String>("getNickname", HttpStatus.OK);
	}
	
	
	
	
}
