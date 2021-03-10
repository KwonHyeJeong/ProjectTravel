package edu.spring.travel06.persistance;

import java.util.List;

import edu.spring.travel06.domain.*;
import edu.spring.travel06.pageutil.*;


public interface PlayReviewDAO 
{
	public abstract int insert(PlayReviewVO vo);
	public abstract List<PlayReviewVO> select(int playNo);
	public abstract int update(PlayReviewVO vo);
	public abstract int delete(int playReviewNo);
	
	public abstract PlayReviewVO selectByReviewNo(int playReviewNo);
	public abstract List<PlayReviewVO> select(String userNickname);
	public abstract int updateByNickname(String newNickname, PlayReviewVO review);
	
	
	List<PlayReviewVO> listPaging(int playNo, PageCriteria criteria); // 페이징 처리된 댓글 목록
	public abstract int countReviews(int playNo); // 댓글 수 계산
	
	
	
}
