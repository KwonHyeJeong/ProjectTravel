package edu.spring.travel06.persistance;

import java.util.List;

import edu.spring.travel06.pageutil.*;
import edu.spring.travel06.domain.*;



public interface FreePageDAO {
	public abstract List<FreePageVO> select();
	public abstract FreePageVO select(int freeNo);
	public abstract FreePageVO selectNickname(String userNickname);
	public abstract int insert(FreePageVO vo);
	public abstract int update(FreePageVO vo);
	public abstract int delete(int freeNo);
	public abstract int getTotalNumsOfRecords(); // �����Ͱ� ����� Ȯ��
	public abstract List<FreePageVO> select(PageCriteria criteria); // ����¡ ó��
	
	public abstract int updateByFreeViewCnt(int amount, int freeNo); // 조회수
	
	public abstract int updateByfreeReviewCnt(int amount, int freeNo); // 댓글 수
	
	public abstract int updateByNickname(String newNickname, FreePageVO vo); 
	public abstract List<FreePageVO> NicknamePaging(String userNickname, PageCriteria criteria);
	public abstract List<FreePageVO> selectByUserNickname(String userNickname);
	
	
	// 좋아요 기능
	public abstract void insertBoardLike(BoardLikeVO vo);
	public abstract void deleteBoardLike(BoardLikeVO vo);
	public abstract void updateBoardLike(int boardId);
	public abstract int getBoardLike(BoardLikeVO vo);
	public abstract List<BoardLikeVO> selectLike(int mno);
	public abstract List<FreePageVO> selectBoardLike(int boardno);
	
	
	// 찜하기 기능
	public abstract void insertFreeWish(FreeWishVO vo);
	public abstract void deleteFreeWish(FreeWishVO vo);
	public abstract void updateFreeWish(int boardId);
	public abstract int getFreeWish(FreeWishVO vo);
	public abstract List<FreeWishVO> selectWish(int mno);
	public abstract List<FreePageVO> selectFreeWish(int freeNo);
	
	
	
	// 공지사항 기능
	public abstract List<NoticeVO> noticeSelect();
	public abstract NoticeVO selectByNoticeNo(int noticeNo);
	public abstract int insertNotice(NoticeVO vo);
	public abstract int updateNotice(NoticeVO vo);
	public abstract int deleteNotice(int noticeNo);
	
	public abstract List<FreePageVO> bestListAll();
	public abstract List<FreePageVO> bestReviewAll();
	public abstract List<FreePageVO> bestGoodAll();
	public abstract List<FreePageVO> bestWishAll();
	
	
	
}
