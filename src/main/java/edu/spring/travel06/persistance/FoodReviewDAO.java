package edu.spring.travel06.persistance;

import java.util.List;

import edu.spring.travel06.domain.*;
import edu.spring.travel06.pageutil.*;


public interface FoodReviewDAO {
	public abstract int insert(FoodReviewVO vo);
	public abstract List<FoodReviewVO> select(int foodNo);
	public abstract int update(FoodReviewVO vo);
	public abstract int delete(int foodReviewNo);
	
	
	public abstract FoodReviewVO selectByReviewNo(int foodReviewNo);
	public abstract List<FoodReviewVO> select(String userNickname);
	public abstract int updateByNickname(String newNickname, FoodReviewVO review);
	
	
	List<FoodReviewVO> listPaging(int foodNo, PageCriteria criteria); // 페이징 처리된 댓글 목록
	public abstract int countReviews(int freeNo); // 댓글 수 계산
}
