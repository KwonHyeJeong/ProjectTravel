package edu.spring.travel06.service;

import java.util.List;

import edu.spring.travel06.domain.FreeReviewVO;
import edu.spring.travel06.pageutil.*;

public interface FreeReviewService {
	int create(FreeReviewVO vo) throws Exception;
	List<FreeReviewVO> read(int freeNo);
	int update(FreeReviewVO vo);
	int delete(int freeReviewNo, int freeNo)  throws Exception;
	FreeReviewVO readByReviewNo(int freeReviewNo);
	
	List<FreeReviewVO> readbyUser(String userNickname);
	public abstract int updateNickName(String newNickname, FreeReviewVO review);
	
	
	List<FreeReviewVO> getReviewPaging(int freeNo, PageCriteria criteria) throws Exception; // 댓글 페이징
	int countReviews(int freeNo) throws Exception; // 댓글 수
	
	
	
	
	
}
