package edu.spring.travel06.controller;

import java.io.IOException;
import java.security.Principal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.spring.travel06.domain.*;
import edu.spring.travel06.service.*;




@RestController
@RequestMapping(value = "/user")
public class UserRESTController 
{
	private static final Logger LOGGER = 
			LoggerFactory.getLogger(UserRESTController.class);
	
	@Autowired
	private UserService serviceUser;
	
	@Autowired
	private FreePageService freeService;
	
	
	
	@GetMapping("/doubleCheck/all/{userID}") // GET : id check
	public ResponseEntity<String> readUsers(
			@PathVariable("userID") String userID,
			RedirectAttributes reAttr
			) throws IOException
	{
		// @PathVariable(name) : {name}값을 설정된 변수에 적용
		
		List<UserVO> list = serviceUser.read();
		for(UserVO uvo : list)
		{
			if(uvo.getUserID().equals(userID) == true)
			{
				LOGGER.info("아이디가 존재합니다.");
				return new ResponseEntity<String>("Exist",HttpStatus.OK);
			}
			
		}
		LOGGER.info("사용가능한 아이디 입니다.");

		return new ResponseEntity<String>("notExist", HttpStatus.OK);
	}
	
	
	
	
	@PutMapping("/UserUpdate/{userID}")
	public ResponseEntity<String> updateUsers(
						@PathVariable("userID") String userID,
						@RequestBody UserVO uvo,
						RedirectAttributes reAttr
						) throws ParseException
	{
		LOGGER.info("number = " + userID);
		
		// 날짜 형식을 yyyy-MM-dd로 바꿈
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date getDate = uvo.getUserBirth();
		String birthday = sdf.format(getDate);
		
		uvo.setUserBirth(sdf.parse(birthday));
		
		
		LOGGER.info("vo : " + uvo.toString());
		
		
		int result = serviceUser.update(uvo);
		
		
		ResponseEntity<String> entity = null;
		
		if(result == 1)
		{
			
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
			LOGGER.info("update된 vo : " + uvo.toString());
			
		}
		else
		{
			entity = new ResponseEntity<String>("fail", HttpStatus.OK);
			
		}
		
		return entity;
	}
	
	
	
	@GetMapping("/UserDeleteConfirm/{userID}")
	public ResponseEntity<String> deleteUsers(
				@PathVariable("userID") String userID,
				RedirectAttributes reAttr
							)
	{
		LOGGER.info("삭제할 id = " + userID);
		
		return new ResponseEntity<String>("confirm", HttpStatus.OK);
		
		
	}
	
	
	
}
