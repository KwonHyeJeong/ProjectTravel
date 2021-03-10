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
@RequestMapping(value = "/food/replies")
public class FoodReviewRESTController {
	private static final Logger LOGGER = 
			LoggerFactory.getLogger(FoodReviewRESTController.class);
	
	@Autowired
	private FoodReviewService foodReview;
	
	
	@PostMapping("/new")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<Integer> createReview(@RequestBody FoodReviewVO vo)
	{
		LOGGER.info(vo.toString());
		int result;
		try {
			result = foodReview.create(vo);
			return new ResponseEntity<Integer>(result, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Integer>(0, HttpStatus.OK);
		}
	}
	
	@GetMapping("/all/{foodNo}") // GET: ��� ����(all)
	public ResponseEntity<List<FoodReviewVO>> readReviews(
			@PathVariable("foodNo") int foodNo)
	{

		List<FoodReviewVO> list = foodReview.read(foodNo);
		return new ResponseEntity<List<FoodReviewVO>>(list, HttpStatus.OK);
	}
	
	@PutMapping("/{foodReviewNo}") // PUT : ��� ����
	public ResponseEntity<String> updateReview(
				@PathVariable("foodReviewNo") int foodReviewNo, 
				@RequestBody FoodReviewVO reviewVO)
	{
		
		FoodReviewVO FVO = foodReview.readByReviewNo(foodReviewNo);
		FVO.setFoodReviewContent(reviewVO.getFoodReviewContent());
		LOGGER.info(FVO.toString());
		
		ResponseEntity<String> entity = null;
		
		int result = foodReview.update(reviewVO);
		
		if(result == 1) {
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
		} else {
			entity = new ResponseEntity<String>("fail", HttpStatus.OK);
		}
		
		return entity;
	}
	
	@DeleteMapping("/{foodReviewNo}")
	public ResponseEntity<String> deleteReview(
			@PathVariable("foodReviewNo") int foodReviewNO)
	{
		FoodReviewVO reviewVO = foodReview.readByReviewNo(foodReviewNO);
		LOGGER.info("foodNo = " + reviewVO.getFoodNo());
		
		LOGGER.info(reviewVO.toString());
		
		try {
			int result = foodReview.delete(foodReviewNO, reviewVO.getFoodNo());
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
		List<FoodReviewVO> rList = foodReview.readbyUser(userNickname);
		for(FoodReviewVO review : rList)
		{
			LOGGER.info(review.toString());
			result = foodReview.updateNickName(review.getUserNickname(), review);
			LOGGER.info("댓글 결과 : " + result);
			
			if(result >= 1)
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
					@RequestBody FoodReviewVO rvo,
					RedirectAttributes reAttr
								)
	{
		
		LOGGER.info("새로운 닉네임 : "+userNickname);
		LOGGER.info(rvo.toString());
		int result;
		ResponseEntity<String> entity = null;
		List<FoodReviewVO> fList = foodReview.readbyUser(userNickname);
		for(FoodReviewVO review : fList)
		{
			LOGGER.info(review.toString());
			result = foodReview.updateNickName(rvo.getUserNickname(), review);
			LOGGER.info("결과 : " + result);
			if(result == 0)
			{
				
				entity = new ResponseEntity<String>("good4", HttpStatus.OK);
				
			}
			else
			{
				entity = new ResponseEntity<String>("bad4", HttpStatus.OK);
			}
			
		}
		
		
		return entity;
	}
	
	
	
	
	

}

