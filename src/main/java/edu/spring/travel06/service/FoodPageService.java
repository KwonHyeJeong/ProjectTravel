package edu.spring.travel06.service;

import java.util.List;

import edu.spring.travel06.domain.*;
import edu.spring.travel06.pageutil.*;


// CRUD(CREATE, READ, UPDATE, DELETE)
public interface FoodPageService 
{
	public abstract List<FoodPageVO> read();
	public abstract FoodPageVO read(int foodNo);
	public abstract FoodPageVO readNickname(String userNickname);
	public abstract int create(FoodPageVO vo);
	public abstract int update(FoodPageVO vo);
	public abstract int delete(int foodNo);
	public abstract int getTotalNumsOfRecords();

	public abstract List<FoodPageVO> read(PageCriteria criteria);
	
	
	public abstract int updateFoodViewCnt(int foodNo);
	public abstract int updateFoodReviewCnt(int amount, int foodNo);
	public abstract int updateNickname(String userNickname, FoodPageVO foodVO);
	public abstract List<FoodPageVO> readByUserNickname(String userNickname);
	
	
	
	// 좋아요 기능
	public abstract void insertBoardLike(FoodLikeVO vo);
	public abstract void deleteBoardLike(FoodLikeVO vo);
	public abstract int getBoardLike(FoodLikeVO vo);
	public abstract List<FoodLikeVO> selectLike(int mno);
	public abstract List<FoodPageVO> selectFoodLike(int foodNo);
	
	
	// 찜하기 기능
	public abstract void insertFoodWish(FoodWishVO vo);
	public abstract void deleteFoodWish(FoodWishVO vo);
	public abstract int getFoodWish(FoodWishVO vo);
	public abstract List<FoodWishVO> selectWish(int mno);
	public abstract List<FoodPageVO> selectFoodWish(int foodNo);
	
	
	public abstract List<FoodPageVO> bestListAll();
	public abstract List<FoodPageVO> bestReviewAll();
	public abstract List<FoodPageVO> bestGoodAll();
	public abstract List<FoodPageVO> bestWishAll();
	
	
}
















