package edu.spring.travel06.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import edu.spring.travel06.domain.*;
import edu.spring.travel06.pageutil.*;
import edu.spring.travel06.persistance.*;


@Service
public class FoodReviewServiceImple implements FoodReviewService{
	private static final Logger LOGGER =
			LoggerFactory.getLogger(FoodReviewServiceImple.class);
	
	@Autowired
	private FoodReviewDAO foodReviewDao;
	@Autowired
	private FoodPageDAO foodDao;
	
	@Transactional
	@Override
	public int create(FoodReviewVO vo)
	{
		LOGGER.info("create() ȣ��");
		foodReviewDao.insert(vo);
		LOGGER.info("먹거리 댓글 입력");
		
		foodDao.updateByfoodReviewCnt(1, vo.getFoodNo());
		LOGGER.info("먹거리 댓글 추가");
		return 1;
	}

	@Override
	public List<FoodReviewVO> read(int foodNo) {
		LOGGER.info("food 댓글 list");
		return foodReviewDao.select(foodNo);
	}

	@Override
	public int update(FoodReviewVO vo) {
		LOGGER.info("foodReview 수정");
		return foodReviewDao.update(vo);
	}
	
	@Transactional
	@Override
	public int delete(int foodReviewNo, int foodNo)
	{
		
		foodReviewDao.delete(foodReviewNo);
		LOGGER.info("먹거리 댓글 삭제");
		
		foodDao.updateByfoodReviewCnt(-1, foodNo);
		LOGGER.info("음식 게시글의 댓글 수 감소");
		return 1;
	}
	
	@Override
	   public List<FoodReviewVO> getReviewPaging(int foodNo, PageCriteria criteria) throws Exception {
	      LOGGER.info("댓글 페이징 처리");
	      return foodReviewDao.listPaging(foodNo, criteria);
	   }

	   @Override
	   public int countReviews(int foodNo) throws Exception {
	      LOGGER.info("댓글 갯수");
	      return foodReviewDao.countReviews(foodNo);
	   }

	@Override
	public FoodReviewVO readByReviewNo(int foodReviewNo) 
	{
		LOGGER.info("select: ");
		return foodReviewDao.selectByReviewNo(foodReviewNo);
	}

	@Override
	public List<FoodReviewVO> readbyUser(String userNickname) 
	{
		LOGGER.info("NickName list : ");
		return foodReviewDao.select(userNickname);
	}

	@Override
	public int updateNickName(String newNickname, FoodReviewVO review) 
	{
		LOGGER.info("변경할 닉네임 : ");
		return foodReviewDao.updateByNickname(newNickname, review);
	}

}
