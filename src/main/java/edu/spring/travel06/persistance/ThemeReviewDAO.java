package edu.spring.travel06.persistance;

import java.util.List;

import edu.spring.travel06.domain.*;
import edu.spring.travel06.pageutil.*;


public interface ThemeReviewDAO {
	public abstract int insert(ThemeReviewVO vo);
	public abstract List<ThemeReviewVO> select(int themeNo);
	public abstract int update(ThemeReviewVO vo);
	public abstract int delete(int themeReviewNo);
	
	
	public abstract ThemeReviewVO selectByReviewNo(int themeReviewNo);
	public abstract List<ThemeReviewVO> select(String userNickname);
	public abstract int updateByNickname(String newNickname, ThemeReviewVO review);
	
	
	List<ThemeReviewVO> listPaging(int themeNo, PageCriteria criteria); // 페이징 처리된 댓글 목록
	public abstract int countReviews(int themeNo); // 댓글 수 계산
}
