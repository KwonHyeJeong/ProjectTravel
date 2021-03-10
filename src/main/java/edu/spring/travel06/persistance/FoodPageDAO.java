package edu.spring.travel06.persistance;

import java.util.List;

import edu.spring.travel06.domain.*;

import edu.spring.travel06.pageutil.*;
import net.sf.json.JSONString;


public interface FoodPageDAO {
	public abstract List<FoodPageVO> select();
	public abstract FoodPageVO select(int foodNo);
	public abstract FoodPageVO selectNickname(String userNickname);
	public abstract int insert(FoodPageVO vo);
	public abstract int update(FoodPageVO vo);
	public abstract int delete(int foodNo);
	public abstract int getTotalNumsOfRecords(); // 전체 게시판 개수

	
	public abstract List<FoodPageVO> select(PageCriteria criteria);
	public abstract List<FoodPageVO> select(String userNickname);
	public abstract List<FoodPageVO> selectByTitleOrContent(String keyword);
	
	public abstract int updateByfoodViewCnt(int foodNo); // �Խ��� ��ȸ��
	public abstract int updateByfoodReviewCnt(int amount, int foodNo); // ��� ��

	
	
	public abstract int updateByNickname(String newNickname, FoodPageVO vo); 
	public abstract List<FoodPageVO> selectByUserNickname(String userNickname);
	
	
	// 좋아요 기능
	public abstract void insertBoardLike(FoodLikeVO vo);
	public abstract void deleteBoardLike(FoodLikeVO vo);
	public abstract void updateBoardLike(int boardId);
	public abstract int getBoardLike(FoodLikeVO vo);
	public abstract List<FoodLikeVO> selectLike(int mno);
	public abstract List<FoodPageVO> selectFoodLike(int foodNo);
	
	
	// 찜하기 기능
	public abstract void insertFoodWish(FoodWishVO vo);
	public abstract void deleteFoodWish(FoodWishVO vo);
	public abstract void updateFoodWish(int boardId);
	public abstract int getFoodWish(FoodWishVO vo);
	public abstract List<FoodWishVO> selectWish(int mno);
	public abstract List<FoodPageVO> selectFoodWish(int foodNo);
	
	
	public abstract List<FoodPageVO> bestListAll();
	public abstract List<FoodPageVO> bestReviewAll();
	public abstract List<FoodPageVO> bestGoodAll();
	public abstract List<FoodPageVO> bestWishAll();
	
	
	
}













