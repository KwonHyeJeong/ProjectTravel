package edu.spring.travel06.persistance;

import java.util.List;

import edu.spring.travel06.domain.*;

import edu.spring.travel06.pageutil.*;
import net.sf.json.JSONString;


public interface ThemePageDAO 
{
	public abstract List<ThemePageVO> select();
	public abstract ThemePageVO select(int themeNo);
	public abstract ThemePageVO selectNickname(String userNickname);
	public abstract int insert(ThemePageVO vo);
	public abstract int update(ThemePageVO vo);
	public abstract int delete(int themeNo);
	public abstract int getTotalNumsOfRecords(); // 전체 게시판 개수

	
	public abstract List<ThemePageVO> select(PageCriteria criteria);
	public abstract List<ThemePageVO> select(String userNickname);
	public abstract List<ThemePageVO> selectByTitleOrContent(String keyword);
	
	public abstract int updateBythemeViewCnt(int themeNo); // �Խ��� ��ȸ��
	public abstract int updateBythemeReviewCnt(int amount, int themeNo); // ��� ��
//	public abstract List<ThemePageVO> listSearch(PageCriteria criteria); // �˻� ���
//	public abstract int countSearch(PageCriteria criteria); // �˻� ����� ��
	
	
	public abstract int updateByNickname(String newNickname, ThemePageVO vo); 
	public abstract List<ThemePageVO> selectByUserNickname(String userNickname);
	
	
	// 좋아요 기능
	public abstract void insertThemeLike(ThemeLikeVO vo);
	public abstract void deleteThemeLike(ThemeLikeVO vo);
	public abstract void updateThemeLike(int boardId);
	public abstract int getThemeLike(ThemeLikeVO vo);
	public abstract List<ThemeLikeVO> selectLike(int mno);
	public abstract List<ThemePageVO> selectThemeLike(int themeNo);
	
	
	// 찜하기 기능
	public abstract void insertThemeWish(ThemeWishVO vo);
	public abstract void deleteThemeWish(ThemeWishVO vo);
	public abstract void updateThemeWish(int boardId);
	public abstract int getThemeWish(ThemeWishVO vo);
	public abstract List<ThemeWishVO> selectWish(int mno);
	public abstract List<ThemePageVO> selectThemeWish(int themeNo);
	
	public abstract List<ThemePageVO> bestListAll();
	public abstract List<ThemePageVO> bestReviewAll();
	public abstract List<ThemePageVO> bestGoodAll();
	public abstract List<ThemePageVO> bestWishAll();
	
	
	
}













