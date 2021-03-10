package edu.spring.travel06.service;

import java.util.List;

import edu.spring.travel06.pageutil.*;
import edu.spring.travel06.domain.*;


public interface FreePageService 
{
	public abstract List<FreePageVO> read();
	public abstract FreePageVO read(int freeNo);
	public abstract FreePageVO readNickname(String userNickname);
	public abstract int create(FreePageVO vo);
	public abstract int update(FreePageVO vo);
	public abstract int delete(int freeNo);
	public abstract int getTotalNumsOfRecords();
	public abstract List<FreePageVO> read(PageCriteria criteria);
	
	public abstract int updateFreeViewCnt(int amount, int freeNo);
	public abstract int updateFreeReviewCnt(int amount, int freeNo);
	public abstract int updateNickname(String userNickname, FreePageVO fvo);
	public abstract List<FreePageVO> NickNameList(String userNickname, PageCriteria criteria) throws Exception;
	public abstract List<FreePageVO> readByUserNickname(String userNickname);
	
	
	// 좋아요 기능
	public abstract void insertBoardLike(BoardLikeVO likeVO);
	public abstract void deleteBoardLike(BoardLikeVO likeVO);
	public abstract int getBoardLike(BoardLikeVO likeVO);
	public abstract List<BoardLikeVO> selectLike(int mno);
	public abstract List<FreePageVO> selectBoardLike(int boardno);
	
	
	// 찜하기 기능
	public abstract void insertFreeWish(FreeWishVO vo);
	public abstract void deleteFreeWish(FreeWishVO vo);
	public abstract int getFreeWish(FreeWishVO vo);
	public abstract List<FreeWishVO> selectWish(int mno);
	public abstract List<FreePageVO> selectFreeWish(int freeNo);
	
	
	// 공지사항 기능
	public abstract List<NoticeVO> select();
	public abstract NoticeVO select(int noticeNo);
	public abstract int createNotice(NoticeVO vo);
	public abstract int updateNotice(NoticeVO vo);
	public abstract int deleteNotice(int noticeNo);
	
	
	public abstract List<FreePageVO> bestListAll();
	public abstract List<FreePageVO> bestReviewAll();
	public abstract List<FreePageVO> bestGoodAll();
	public abstract List<FreePageVO> bestWishAll();
	
	
	
}
