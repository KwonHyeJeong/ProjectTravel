package edu.spring.travel06.persistance;

import java.util.List;

import edu.spring.travel06.domain.*;

import edu.spring.travel06.pageutil.*;
import net.sf.json.JSONString;


public interface PlayPageDAO 
{
	public abstract List<PlayPageVO> select();
	public abstract PlayPageVO select(int playNo);
	public abstract PlayPageVO selectNickname(String userNickname);
	public abstract int insert(PlayPageVO vo);
	public abstract int update(PlayPageVO vo);
	public abstract int delete(int playNo);
	public abstract int getTotalNumsOfRecords(); // 전체 게시판 개수

	
	public abstract List<PlayPageVO> select(PageCriteria criteria);
	public abstract List<PlayPageVO> select(String userNickname);
	public abstract List<PlayPageVO> selectByTitleOrContent(String keyword);
	
	public abstract int updateByplayViewCnt(int playNo); // �Խ��� ��ȸ��
	public abstract int updateByplayReviewCnt(int amount, int playNo); // ��� ��
//	public abstract List<PlayPageVO> listSearch(PageCriteria criteria); // �˻� ���
//	public abstract int countSearch(PageCriteria criteria); // �˻� ����� ��
	
	
	public abstract int updateByNickname(String newNickname, PlayPageVO vo); 
	public abstract List<PlayPageVO> selectByUserNickname(String userNickname);
	
	
	// 좋아요 기능
	public abstract void insertPlayLike(PlayLikeVO vo);
	public abstract void deletePlayLike(PlayLikeVO vo);
	public abstract void updatePlayLike(int boardId);
	public abstract int getPlayLike(PlayLikeVO vo);
	public abstract List<PlayLikeVO> selectLike(int mno);
	public abstract List<PlayPageVO> selectPlayLike(int playNo);
	
	
	// 찜하기 기능
	public abstract void insertPlayWish(PlayWishVO vo);
	public abstract void deletePlayWish(PlayWishVO vo);
	public abstract void updatePlayWish(int boardId);
	public abstract int getPlayWish(PlayWishVO vo);
	public abstract List<PlayWishVO> selectWish(int mno);
	public abstract List<PlayPageVO> selectPlayWish(int playNo);
	
	
	public abstract List<PlayPageVO> bestListAll();
	public abstract List<PlayPageVO> bestReviewAll();
	public abstract List<PlayPageVO> bestGoodAll();
	public abstract List<PlayPageVO> bestWishAll();
	
	
	
}
