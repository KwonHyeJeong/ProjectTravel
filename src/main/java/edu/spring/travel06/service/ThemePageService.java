package edu.spring.travel06.service;

import java.util.List;

import edu.spring.travel06.domain.*;
import edu.spring.travel06.pageutil.*;


// CRUD(CREATE, READ, UPDATE, DELETE)
public interface ThemePageService 
{
	public abstract List<ThemePageVO> read();
	public abstract ThemePageVO read(int themeNo);
	public abstract ThemePageVO readNickname(String userNickname);
	public abstract int create(ThemePageVO vo);
	public abstract int update(ThemePageVO vo);
	public abstract int delete(int themeNo);
	public abstract int getTotalNumsOfRecords();

	public abstract List<ThemePageVO> read(PageCriteria criteria);
	
	
	public abstract int updateThemeViewCnt(int themeNo);
	public abstract int updateThemeReviewCnt(int amount, int themeNo);
	public abstract int updateNickname(String userNickname, ThemePageVO themeVO);
	public abstract List<ThemePageVO> readByUserNickname(String userNickname);
	
	
	// 좋아요 기능
	public abstract void insertThemeLike(ThemeLikeVO vo);
	public abstract void deleteThemeLike(ThemeLikeVO vo);
	public abstract int getThemeLike(ThemeLikeVO vo);
	
	public abstract List<ThemeLikeVO> selectLike(int mno);
	public abstract List<ThemePageVO> selectThemeLike(int themeNo);
	
	
	// 찜하기 기능
	public abstract void insertThemeWish(ThemeWishVO vo);
	public abstract void deleteThemeWish(ThemeWishVO vo);
	public abstract int getThemeWish(ThemeWishVO vo);
	public abstract List<ThemeWishVO> selectWish(int mno);
	public abstract List<ThemePageVO> selectThemeWish(int playNo);
	
	
	public abstract List<ThemePageVO> bestListAll();
	public abstract List<ThemePageVO> bestReviewAll();
	public abstract List<ThemePageVO> bestGoodAll();
	public abstract List<ThemePageVO> bestWishAll();
	
	

}
















