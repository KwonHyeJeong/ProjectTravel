package edu.spring.travel06.persistance;

import java.util.List;

import edu.spring.travel06.domain.FreeReviewVO;
import edu.spring.travel06.pageutil.*;

public interface FreeReviewDAO {
	int insert(FreeReviewVO vo);
	List<FreeReviewVO> select(int freeNo);
	int update(FreeReviewVO vo);
	int delete(int freeReviewNo);
	FreeReviewVO selectByReviewNo(int freeReviewNo);
	
	List<FreeReviewVO> select(String userNickname);
	public abstract int updateByNickname(String newNickname, FreeReviewVO review); 
	
	List<FreeReviewVO> listPaging(int freeNo, PageCriteria criteria); // 페이징 처리된 댓글 목록
	int countReviews(int freeNo); // 댓글 수 계산
	
	
}
