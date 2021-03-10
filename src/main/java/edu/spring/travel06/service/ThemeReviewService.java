package edu.spring.travel06.service;

import java.util.List;

import edu.spring.travel06.domain.*;
import edu.spring.travel06.pageutil.*;

public interface ThemeReviewService {
	public abstract int create(ThemeReviewVO vo) throws Exception;
	public abstract List<ThemeReviewVO> read(int themeNo);
	public abstract int update(ThemeReviewVO vo);
	public abstract int delete(int themeReviewNo, int themeNo) throws Exception;
	
	public abstract ThemeReviewVO readByReviewNo(int themeReviewNo);
	
	public abstract List<ThemeReviewVO> readbyUser(String userNickname);
	public abstract int updateNickName(String newNickname, ThemeReviewVO review);
	
	
	public abstract List<ThemeReviewVO> getReviewPaging(int themeNo, PageCriteria criteria) throws Exception; // 댓글 페이징
	public abstract int countReviews(int themeNo) throws Exception; // 댓글 수
}
