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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.spring.travel06.domain.FreeReviewVO;
import edu.spring.travel06.pageutil.*;
import edu.spring.travel06.pageutil.PageMaker;
import edu.spring.travel06.service.*;

@RestController
@RequestMapping(value = "/free/replies")
public class FreeReviewRESTController {
	private static final Logger LOGGER = 
			LoggerFactory.getLogger(FreeReviewRESTController.class);
	
	@Autowired
	private FreeReviewService reviewService;
	
	
	
	@PostMapping("/new")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<Integer> createReview(@RequestBody FreeReviewVO vo)
	{
		LOGGER.info(vo.toString());
		int result;
		
		try {
			result = reviewService.create(vo);
			
			
			return new ResponseEntity<Integer>(result, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Integer>(0, HttpStatus.OK);
		}
	}
	
	@GetMapping("/all/{freeNo}") // GET: ��� ����(all)
	public ResponseEntity<List<FreeReviewVO>> readReviews(
			@PathVariable("freeNo") int freeNo 
			)
	{
		
		List<FreeReviewVO> list = reviewService.read(freeNo);
		return new ResponseEntity<List<FreeReviewVO>>(list, HttpStatus.OK);
	}
	
	
	// 댓글 수정
	@PutMapping("/{freeReviewNo}") // PUT : ��� ����
	public ResponseEntity<String> updateReview(
			@PathVariable("freeReviewNo") int freeReviewNo, 
			@RequestBody FreeReviewVO vo)
	{
		
		
		FreeReviewVO RVO = reviewService.readByReviewNo(freeReviewNo);
		RVO.setFreeReviewContent(vo.getFreeReviewContent());
		LOGGER.info(RVO.toString());
		ResponseEntity<String> entity = null;
		
		int result = reviewService.update(RVO);
		
		LOGGER.info("result : " + result);
		if(result == 1) {
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
		} else {
			entity = new ResponseEntity<String>("fail", HttpStatus.OK);
		}
		
		return entity;
	}
	
	@DeleteMapping("/{freeReviewNo}")
	public ResponseEntity<String> deleteReview(
			@PathVariable("freeReviewNo") int freeReviewNo)
	{
		FreeReviewVO vo = reviewService.readByReviewNo(freeReviewNo);
		LOGGER.info("freeNo = " + vo.getFreeNo());
		
		LOGGER.info(vo.toString());
		
		try {
			int result = reviewService.delete(freeReviewNo, vo.getFreeNo());
			LOGGER.info("delete result : " + result);
			
			return new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
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
		List<FreeReviewVO> rList = reviewService.readbyUser(userNickname);
		for(FreeReviewVO review : rList)
		{
			LOGGER.info(review.toString());
			result = reviewService.updateNickName(review.getUserNickname(), review);
			LOGGER.info("댓글 결과 : " + result);
			
			if(result == 0)
			{
				entity = new ResponseEntity<String>("good2", HttpStatus.OK);
			}
			else
			{
				entity = new ResponseEntity<String>("bad2", HttpStatus.OK);
				
			}
			
		}

		
		return entity;
		
	}
	
	// 닉네임 변경
	@PutMapping("/updateNickName/{userNickname}")
	public ResponseEntity<String> updateNickNames(
					@PathVariable("userNickname") String userNickname,
					@RequestBody FreeReviewVO rvo,
					RedirectAttributes reAttr
								)
	{
		
		LOGGER.info("새로운 닉네임 : "+userNickname);
		LOGGER.info(rvo.toString());
		int result;
		ResponseEntity<String> entity = null;
		List<FreeReviewVO> fList = reviewService.readbyUser(userNickname);
		for(FreeReviewVO review : fList)
		{
			LOGGER.info(review.toString());
			result = reviewService.updateNickName(rvo.getUserNickname(), review);
			LOGGER.info("결과 : " + result);
			if(result == 0)
			{
				
				entity = new ResponseEntity<String>("good2", HttpStatus.OK);
				
			}
			else
			{
				entity = new ResponseEntity<String>("bad2", HttpStatus.OK);
			}
			
		}
		
		
		return entity;
	}
	
	
	
	

}

