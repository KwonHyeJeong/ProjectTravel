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
@RequestMapping(value = "/play/replies")
public class PlayReviewRESTController {
	private static final Logger LOGGER = 
			LoggerFactory.getLogger(PlayReviewRESTController.class);
	
	@Autowired
	private PlayReviewService playReview;
	
	
	@PostMapping("/new")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<Integer> createReview(@RequestBody PlayReviewVO vo)
	{
		LOGGER.info(vo.toString());
		int result;
		try {
			result = playReview.create(vo);
			return new ResponseEntity<Integer>(result, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Integer>(0, HttpStatus.OK);
		}
	}
	
	@GetMapping("/all/{playNo}") // GET: ��� ����(all)
	public ResponseEntity<List<PlayReviewVO>> readReviews(
			@PathVariable("playNo") int playNo)
	{

		List<PlayReviewVO> list = playReview.read(playNo);
		return new ResponseEntity<List<PlayReviewVO>>(list, HttpStatus.OK);
	}
	
	@PutMapping("/{playReviewNo}") // PUT : ��� ����
	public ResponseEntity<String> updateReview(
				@PathVariable("playReviewNo") int playReviewNo, 
				@RequestBody PlayReviewVO reviewVO)
	{
		
		PlayReviewVO FVO = playReview.readByReviewNo(playReviewNo);
		FVO.setPlayReviewContent(reviewVO.getPlayReviewContent());
		LOGGER.info(FVO.toString());
		
		ResponseEntity<String> entity = null;
		
		int result = playReview.update(reviewVO);
		
		if(result == 1) {
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
		} else {
			entity = new ResponseEntity<String>("fail", HttpStatus.OK);
		}
		
		return entity;
	}
	
	@DeleteMapping("/{playReviewNo}")
	public ResponseEntity<String> deleteReview(
			@PathVariable("playReviewNo") int playReviewNo)
	{
		PlayReviewVO reviewVO = playReview.readByReviewNo(playReviewNo);
		LOGGER.info("playNo = " + reviewVO.getPlayNo());
		
		LOGGER.info(reviewVO.toString());
		
		try {
			int result = playReview.delete(playReviewNo, reviewVO.getPlayNo());
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
		List<PlayReviewVO> rList = playReview.readbyUser(userNickname);
		for(PlayReviewVO review : rList)
		{
			LOGGER.info(review.toString());
			result = playReview.updateNickName(review.getUserNickname(), review);
			LOGGER.info("댓글 결과 : " + result);
			
			if(result >= 1)
			{
				entity = new ResponseEntity<String>("good6", HttpStatus.OK);
			}
			else
			{
				entity = new ResponseEntity<String>("bad6", HttpStatus.OK);
				
			}
			
		}

		
		return entity;
		
	}
	
	
	// 닉네임 변경
	@PutMapping("/updateNickName/{userNickname}")
	public ResponseEntity<String> updateNickNames(
					@PathVariable("userNickname") String userNickname,
					@RequestBody PlayReviewVO rvo,
					RedirectAttributes reAttr
								)
	{
		
		LOGGER.info("새로운 닉네임 : "+userNickname);
		LOGGER.info(rvo.toString());
		int result;
		ResponseEntity<String> entity = null;
		List<PlayReviewVO> fList = playReview.readbyUser(userNickname);
		for(PlayReviewVO review : fList)
		{
			LOGGER.info(review.toString());
			result = playReview.updateNickName(rvo.getUserNickname(), review);
			LOGGER.info("결과 : " + result);
			if(result == 0)
			{
				
				entity = new ResponseEntity<String>("good6", HttpStatus.OK);
				
			}
			else
			{
				entity = new ResponseEntity<String>("bad6", HttpStatus.OK);
			}
			
		}
		
		
		return entity;
	}
	
	
	
	
	

}

