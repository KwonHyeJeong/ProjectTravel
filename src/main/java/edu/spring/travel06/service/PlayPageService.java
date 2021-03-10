package edu.spring.travel06.service;

import java.util.List;

import edu.spring.travel06.domain.*;
import edu.spring.travel06.pageutil.*;


// CRUD(CREATE, READ, UPDATE, DELETE)
public interface PlayPageService 
{
	public abstract List<PlayPageVO> read();
	public abstract PlayPageVO read(int playNo);
	public abstract PlayPageVO readNickname(String userNickname);
	public abstract int create(PlayPageVO vo);
	public abstract int update(PlayPageVO vo);
	public abstract int delete(int playNo);
	public abstract int getTotalNumsOfRecords();

	public abstract List<PlayPageVO> read(PageCriteria criteria);
	
	
	public abstract int updatePlayViewCnt(int playNo);
	public abstract int updatePlayReviewCnt(int amount, int playNo);
	public abstract int updateNickname(String userNickname, PlayPageVO playVO);
	public abstract List<PlayPageVO> readByUserNickname(String userNickname);
	
	
	// 좋아요 기능
	public abstract void insertPlayLike(PlayLikeVO vo);
	public abstract void deletePlayLike(PlayLikeVO vo);
	public abstract int getPlayLike(PlayLikeVO vo);
	
	public abstract List<PlayLikeVO> selectLike(int mno);
	public abstract List<PlayPageVO> selectPlayLike(int playNo);
	
	
	// 찜하기 기능
	public abstract void insertPlayWish(PlayWishVO vo);
	public abstract void deletePlayWish(PlayWishVO vo);
	public abstract int getPlayWish(PlayWishVO vo);
	public abstract List<PlayWishVO> selectWish(int mno);
	public abstract List<PlayPageVO> selectPlayWish(int playNo);
	
	
	public abstract List<PlayPageVO> bestListAll();
	public abstract List<PlayPageVO> bestReviewAll();
	public abstract List<PlayPageVO> bestGoodAll();
	public abstract List<PlayPageVO> bestWishAll();
	
	
}
















