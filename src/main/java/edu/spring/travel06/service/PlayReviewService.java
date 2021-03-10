package edu.spring.travel06.service;

import java.util.List;

import edu.spring.travel06.domain.*;
import edu.spring.travel06.pageutil.*;

public interface PlayReviewService {
	public abstract int create(PlayReviewVO vo) throws Exception;
	public abstract List<PlayReviewVO> read(int playNo);
	public abstract int update(PlayReviewVO vo);
	public abstract int delete(int foodReviewNo, int playNo) throws Exception;
	
	public abstract PlayReviewVO readByReviewNo(int playReviewNo);
	
	public abstract List<PlayReviewVO> readbyUser(String userNickname);
	public abstract int updateNickName(String newNickname, PlayReviewVO review);
	
	
	public abstract List<PlayReviewVO> getReviewPaging(int playNo, PageCriteria criteria) throws Exception; // 댓글 페이징
	public abstract int countReviews(int playNo) throws Exception; // 댓글 수
}
