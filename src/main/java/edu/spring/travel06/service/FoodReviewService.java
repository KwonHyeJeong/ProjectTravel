package edu.spring.travel06.service;

import java.util.List;

import edu.spring.travel06.domain.*;
import edu.spring.travel06.pageutil.*;

public interface FoodReviewService {
	public abstract int create(FoodReviewVO vo) throws Exception;
	public abstract List<FoodReviewVO> read(int foodNo);
	public abstract int update(FoodReviewVO vo);
	public abstract int delete(int foodReviewNo, int foodNo) throws Exception;
	
	public abstract FoodReviewVO readByReviewNo(int foodReviewNo);
	
	public abstract List<FoodReviewVO> readbyUser(String userNickname);
	public abstract int updateNickName(String newNickname, FoodReviewVO review);
	
	
	public abstract List<FoodReviewVO> getReviewPaging(int foodNo, PageCriteria criteria) throws Exception; // 댓글 페이징
	public abstract int countReviews(int freeNo) throws Exception; // 댓글 수
}
