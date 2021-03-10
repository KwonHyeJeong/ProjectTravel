package edu.spring.travel06.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.travel06.domain.*;
import edu.spring.travel06.pageutil.*;
import edu.spring.travel06.persistance.*;


@Service // @Component
//스프링 프레임워크에게 서비스 계층(Service/Business layer)의
//컴퍼넌트임을 알려주는 어노테이션
public class FoodPageServiceImple implements FoodPageService
{
	private static final Logger LOGGER = 
			LoggerFactory.getLogger(FoodPageServiceImple.class);
	
	@Autowired
	private FoodPageDAO foodDao;
	

	@Override
	public List<FoodPageVO> read() 
	{
		LOGGER.info("read() 호출");
		return foodDao.select();
	}
 
	@Override
	public FoodPageVO read(int foodNo) {
		LOGGER.info("read() 호출 : foodNo = " + foodNo);
		
		return foodDao.select(foodNo);
	}

	@Override
	public int create(FoodPageVO vo) {
		LOGGER.info("create() 호출");
		return foodDao.insert(vo);
	}

	@Override
	public int update(FoodPageVO vo) {
		LOGGER.info("update() 호출");
		return foodDao.update(vo);
	}

	@Override
	public int delete(int foodNo) 
	{
		LOGGER.info("delete() 호출");
		return foodDao.delete(foodNo);
	}

	@Override
	public int getTotalNumsOfRecords() 
	{
		LOGGER.info("getTotalNumsOfRecords() 호출");
		return foodDao.getTotalNumsOfRecords();
	}
	
	@Override
	public List<FoodPageVO> bestListAll() 
	{
		return foodDao.bestListAll();
	}

	@Override
	public List<FoodPageVO> bestReviewAll() 
	{
		return foodDao.bestReviewAll();
	}

	@Override
	public List<FoodPageVO> bestGoodAll() 
	{
		return foodDao.bestGoodAll();
	}

	@Override
	public List<FoodPageVO> bestWishAll() 
	{
		return foodDao.bestWishAll();
	}
	
	
	

	@Override
	public List<FoodPageVO> read(PageCriteria criteria) 
	{
		LOGGER.info("read() 호출 : page = " + criteria.getPage());
		return foodDao.select(criteria);
	}

	@Override
	public void insertBoardLike(FoodLikeVO vo) 
	{
		LOGGER.info("Service insertBoardLike() 호출");
		foodDao.insertBoardLike(vo);
		foodDao.updateBoardLike(vo.getFoodNo());
		
	}

	@Override
	public void deleteBoardLike(FoodLikeVO vo) 
	{
		LOGGER.info("Service deleteBoardLike() 호출");
		foodDao.deleteBoardLike(vo);
		foodDao.updateBoardLike(vo.getFoodNo());
		
	}

	@Override
	public int getBoardLike(FoodLikeVO vo) 
	{
		LOGGER.info("Service getBoardLike() 호출");
		return foodDao.getBoardLike(vo);
	}

	@Override
	public List<FoodLikeVO> selectLike(int mno) {
		LOGGER.info("Service selectLike 호출");
		return foodDao.selectLike(mno);
	}

	@Override
	public List<FoodPageVO> selectFoodLike(int foodNo) {
		LOGGER.info("Service selectFoodLike() 호출");
		return foodDao.selectFoodLike(foodNo);
	}

	@Override
	public int updateFoodViewCnt(int foodNo) 
	{
		LOGGER.info("조회수 + 1");
		return foodDao.updateByfoodViewCnt(foodNo);
	}

	@Override
	public int updateFoodReviewCnt(int amount, int foodNo) 
	{
		LOGGER.info("음식 댓글 수 : " + amount);
		return foodDao.updateByfoodReviewCnt(amount, foodNo);
	}

	@Override
	public int updateNickname(String userNickname, FoodPageVO foodVO) 
	{
		LOGGER.info("닉네임 변경 : ");
		return foodDao.updateByNickname(userNickname, foodVO);
	}

	@Override
	public List<FoodPageVO> readByUserNickname(String userNickname) 
	{
		LOGGER.info("작성자의 글 보기 : " + userNickname);
		return foodDao.selectByUserNickname(userNickname);
	}

	@Override
	public FoodPageVO readNickname(String userNickname) 
	{
		LOGGER.info("pageVO의 닉네임 : " + userNickname);
		return foodDao.selectNickname(userNickname);
	}

	
	@Override
	public void insertFoodWish(FoodWishVO vo) 
	{
		LOGGER.info("Service insertFoodWish() 호출");
		foodDao.insertFoodWish(vo);
		foodDao.updateFoodWish(vo.getFoodNo());
		
	}

	@Override
	public void deleteFoodWish(FoodWishVO vo)
	{
		LOGGER.info("Service deleteFoodWish() 호출");
		foodDao.deleteFoodWish(vo);
		foodDao.updateFoodWish(vo.getFoodNo());
		
	}
	
	
	@Override
	public int getFoodWish(FoodWishVO vo) 
	{
		LOGGER.info("Service getFoodWish() 호출");
		return foodDao.getFoodWish(vo);
	}
	
	
	@Override
	public List<FoodWishVO> selectWish(int mno) 
	{
		LOGGER.info("Service selectWish 호출");
		return foodDao.selectWish(mno);
	}
	
	
	@Override
	public List<FoodPageVO> selectFoodWish(int foodNo) 
	{
		LOGGER.info("Service selectFoodWish() 호출");
		return foodDao.selectFoodWish(foodNo);

	}
	
	
	

}



