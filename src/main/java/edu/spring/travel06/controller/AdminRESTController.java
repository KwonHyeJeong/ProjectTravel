package edu.spring.travel06.controller;

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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.spring.travel06.domain.*;
import edu.spring.travel06.service.*;



@RestController
@RequestMapping("/admin")
public class AdminRESTController 
{
	private static final Logger logger = 
			LoggerFactory.getLogger(AdminRESTController.class);
	
	
	@Autowired
	private AdminService serviceAdmin;
	
	
	
	
	@GetMapping("/doubleCheck/all/{adminID}")
	public ResponseEntity<String> readAdmin(
							@PathVariable("adminID") String adminID,
							RedirectAttributes reAttr
							)
	{
		
		List<AdminVO> adminList = serviceAdmin.read();
		for(AdminVO avo : adminList)
		{
			if(avo.getAdminID().equals(adminID) == true)
			{
				logger.info("아이디가 존재합니다.");
				return new ResponseEntity<String>("Exist",HttpStatus.OK);
			}
			
		}
		
		logger.info("사용가능한 아이디입니다.");
		return new ResponseEntity<String>("notExist", HttpStatus.OK);
	}
	
	
	@PutMapping("/adminUpdate/{adminID}")
	public ResponseEntity<String> updateAdminister(
						@PathVariable("adminID") String adminID,
						@RequestBody AdminVO avo,
						RedirectAttributes reAttr
						) throws ParseException
	{
		logger.info("number = " + adminID);
		
		// 날짜 형식을 yyyy-MM-dd로 바꿈
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date getDate = avo.getAdminBirth();
		String birthday = sdf.format(getDate);
		
		avo.setAdminBirth(sdf.parse(birthday));
		
		
		logger.info("vo : " + avo.toString());
		
		
		int result = serviceAdmin.update(avo);
		
		
		ResponseEntity<String> entity = null;
		
		if(result == 1)
		{
			
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
			logger.info("update된 vo : " + avo.toString());
			
		}
		else
		{
			entity = new ResponseEntity<String>("fail", HttpStatus.OK);
			
		}
		
		return entity;
	}
	
	
	
	@GetMapping("/AdminDeleteConfirm/{adminID}")
	public ResponseEntity<String> deleteAdminister(
				@PathVariable("adminID") String adminID,
				RedirectAttributes reAttr
							)
	{
		logger.info("삭제할 id = " + adminID);
		
		return new ResponseEntity<String>("confirm", HttpStatus.OK);
		
		
	}
	
	
	
	
	
}
