package edu.spring.travel06.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.spring.travel06.domain.*;
import edu.spring.travel06.pageutil.*;
import edu.spring.travel06.service.*;



@RestController
@RequestMapping(value = "/theme/replies")
public class ThemeReviewRESTController {
	private static final Logger LOGGER = 
			LoggerFactory.getLogger(ThemeReviewRESTController.class);
	
	@Autowired
	private ThemeReviewService themeReview;
	
	
	@PostMapping("/new")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<Integer> createReview(@RequestBody ThemeReviewVO vo)
	{
		LOGGER.info(vo.toString());
		int result;
		try {
			result = themeReview.create(vo);
			return new ResponseEntity<Integer>(result, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Integer>(0, HttpStatus.OK);
		}
	}
	
	@GetMapping("/all/{themaNo}") // GET: ��� ����(all)
	public ResponseEntity<List<ThemeReviewVO>> readReviews(
				@PathVariable("themaNo") int themaNo)
	{

		List<ThemeReviewVO> list = themeReview.read(themaNo);
		return new ResponseEntity<List<ThemeReviewVO>>(list, HttpStatus.OK);
	}
	
	@PutMapping("/{themaReviewNo}") // PUT : ��� ����
	public ResponseEntity<String> updateReview(
				@PathVariable("themaReviewNo") int themaReviewNo, 
				@RequestBody ThemeReviewVO reviewVO)
	{
		
		ThemeReviewVO FVO = themeReview.readByReviewNo(themaReviewNo);
		FVO.setThemaReviewContent(reviewVO.getThemaReviewContent());
		LOGGER.info(FVO.toString());
		
		ResponseEntity<String> entity = null;
		
		int result = themeReview.update(reviewVO);
		
		if(result == 1) {
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
		} else {
			entity = new ResponseEntity<String>("fail", HttpStatus.OK);
		}
		
		return entity;
	}
	
	@DeleteMapping("/{themaReviewNo}")
	public ResponseEntity<String> deleteReview(
			@PathVariable("themaReviewNo") int themaReviewNo)
	{
		ThemeReviewVO reviewVO = themeReview.readByReviewNo(themaReviewNo);
		LOGGER.info("themeNo = " + reviewVO.getThemaNo());
		
		LOGGER.info(reviewVO.toString());
		
		try {
			int result = themeReview.delete(themaReviewNo, reviewVO.getThemaNo());
			LOGGER.info("delete result : " + result);
			return new ResponseEntity<String>("success", HttpStatus.OK);
		} 
		catch (Exception e) 
		{
			return new ResponseEntity<String>("fail", HttpStatus.OK);
		}
	}
	
	
	// 댓글 닉네임 변경
	@GetMapping("/getNickName/{userNickname}")
	public ResponseEntity<String> updateNickNames(
				@PathVariable("userNickname") String userNickname,
				RedirectAttributes reAttr)
	{
		LOGGER.info("새로운 댓글 닉네임 : "+userNickname);
		
		ResponseEntity<String> entity = null;
		int result;
		List<ThemeReviewVO> rList = themeReview.readbyUser(userNickname);
		for(ThemeReviewVO review : rList)
		{
			LOGGER.info(review.toString());
			result = themeReview.updateNickName(review.getUserNickname(), review);
			LOGGER.info("댓글 결과 : " + result);
			
			if(result >= 1)
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
	
	
	// 닉네임 변경
	@PutMapping("/updateNickName/{userNickname}")
	public ResponseEntity<String> updateNickNames(
					@PathVariable("userNickname") String userNickname,
					@RequestBody ThemeReviewVO rvo,
					RedirectAttributes reAttr
								)
	{
		
		LOGGER.info("새로운 닉네임 : "+userNickname);
		LOGGER.info(rvo.toString());
		int result;
		ResponseEntity<String> entity = null;
		List<ThemeReviewVO> fList = themeReview.readbyUser(userNickname);
		for(ThemeReviewVO review : fList)
		{
			LOGGER.info(review.toString());
			result = themeReview.updateNickName(rvo.getUserNickname(), review);
			LOGGER.info("결과 : " + result);
			if(result == 0)
			{
				
				entity = new ResponseEntity<String>("good8", HttpStatus.OK);
				
			}
			else
			{
				entity = new ResponseEntity<String>("bad8", HttpStatus.OK);
			}
			
		}
		
		
		return entity;
	}
	
	
	
	
	

}

