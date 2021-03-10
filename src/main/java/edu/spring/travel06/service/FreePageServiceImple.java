package edu.spring.travel06.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.spring.travel06.pageutil.*;
import edu.spring.travel06.domain.*;
import edu.spring.travel06.persistance.*;


@Service
public class FreePageServiceImple implements FreePageService{
	private static final Logger LOGGER = 
			LoggerFactory.getLogger(FreePageServiceImple.class);
	
	@Autowired
	private FreePageDAO freeDao;
	
	@Autowired
	private FreeReviewDAO freeReviewDao;
	

	@Override
	public List<FreePageVO> read() {
		LOGGER.info("read() ȣ��");
		return freeDao.select();
	}

	@Override
	public FreePageVO read(int freeNo) {
		LOGGER.info("read() ȣ�� : freeNo = " + freeNo);
		return freeDao.select(freeNo);
	}

	@Override
	public int create(FreePageVO vo) {
		LOGGER.info("create() ȣ��");
		return freeDao.insert(vo);
	}

	@Override
	public int update(FreePageVO vo) {
		LOGGER.info("update() ȣ��");
		return freeDao.update(vo);
	}
	
	
	
	@Override
	public int delete(int freeNo) 
	{
		
		LOGGER.info("delete() ȣ��");
		return freeDao.delete(freeNo);
	}

	@Override
	public int getTotalNumsOfRecords() {
		LOGGER.info("getTotalNumsOfRecords() ȣ��");
		return freeDao.getTotalNumsOfRecords();
	}

	@Override
	public List<FreePageVO> read(PageCriteria criteria) {
		LOGGER.info("read() ȣ�� : free_page = " + criteria.getPage());
		return freeDao.select(criteria);
	}

	@Override
	public int updateFreeViewCnt(int amount, int freeNo) {
		LOGGER.info("amount : " + amount);
		
		return freeDao.updateByFreeViewCnt(amount, freeNo);
	}
	
	
	@Override
	public List<FreePageVO> NickNameList(String userNickname, 
						PageCriteria criteria) throws Exception
	{
		LOGGER.info("작성자의 글 paging");
		return freeDao.NicknamePaging(userNickname, criteria);
	}

	@Override
	public FreePageVO readNickname(String userNickname) 
	{
		LOGGER.info("pageVO의 닉네임 : " + userNickname);
		return freeDao.selectNickname(userNickname);
	}

	@Override
	public int updateNickname(String newNickname, FreePageVO fvo) 
	{
		LOGGER.info("변경할 닉네임:");
		return freeDao.updateByNickname(newNickname, fvo);
	}

	@Override
	public int updateFreeReviewCnt(int amount, int freeNo) 
	{
		LOGGER.info("댓글 수 : " + amount);
		return freeDao.updateByfreeReviewCnt(amount, freeNo);
	}
	
	
	
//
//	@Override
//	public List<FreePageVO> readByFreeTitle(String freeTitle) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<FreePageVO> readByFreeContent(String freeContent) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	
	@Override
	public void insertBoardLike(BoardLikeVO vo) 
	{
		LOGGER.info("Service insertBoardLike() 호출");
		freeDao.insertBoardLike(vo);
		freeDao.updateBoardLike(vo.getBoardno());
	}

	@Override
	public void deleteBoardLike(BoardLikeVO vo) 
	{
		LOGGER.info("Service deleteBoardLike() 호출");
		freeDao.deleteBoardLike(vo);
		freeDao.updateBoardLike(vo.getBoardno());
	}

	@Override
	public int getBoardLike(BoardLikeVO vo)
	{
		LOGGER.info("Service getBoardLike() 호출");
		return freeDao.getBoardLike(vo);
	}

	@Override
	public List<BoardLikeVO> selectLike(int mno) 
	{
		LOGGER.info("Service selectLike 호출");
		return freeDao.selectLike(mno);
	}

	@Override
	public List<FreePageVO> selectBoardLike(int boardno) 
	{
		LOGGER.info("Service selectBoardLike() 호출");
		return freeDao.selectBoardLike(boardno);
	}

	@Override
	public List<FreePageVO> readByUserNickname(String userNickname) 
	{
		LOGGER.info("작성자 list");
		return freeDao.selectByUserNickname(userNickname);
	}
	
	
	@Override
	public void insertFreeWish(FreeWishVO vo) 
	{
		LOGGER.info("Service insertFreeWish() 호출");
		freeDao.insertFreeWish(vo);
		freeDao.updateFreeWish(vo.getFreeNo());
	}

	@Override
	public void deleteFreeWish(FreeWishVO vo) 
	{
		LOGGER.info("Service deleteFreeWish() 호출");
		freeDao.deleteFreeWish(vo);
		freeDao.updateFreeWish(vo.getFreeNo());
	}

	@Override
	public int getFreeWish(FreeWishVO vo) 
	{
		LOGGER.info("Service getFreeWish() 호출");
		return freeDao.getFreeWish(vo);
	}

	@Override
	public List<FreeWishVO> selectWish(int mno)
	{
		LOGGER.info("Service selectWish 호출");
		return freeDao.selectWish(mno);
	}

	@Override
	public List<FreePageVO> selectFreeWish(int freeNo) 
	{
		LOGGER.info("Service selectFreeWish 호출");
		return freeDao.selectFreeWish(freeNo);
	}
	
	
	
	
	@Override
	public List<NoticeVO> select() 
	{
		LOGGER.info("service select() 호출");
		return freeDao.noticeSelect();
	}
	
	
	@Override
	public NoticeVO select(int noticeNo) 
	{
		LOGGER.info("service select() 호출 noticeNo = " + noticeNo);
		return freeDao.selectByNoticeNo(noticeNo);
	}
	
	
	@Override
	public int createNotice(NoticeVO vo) 
	{
		LOGGER.info("createNotice() 호출");
		return freeDao.insertNotice(vo);
	}
	
	
	@Override
	public int updateNotice(NoticeVO vo) 
	{
		LOGGER.info("updateNotice() 호출");
		return freeDao.updateNotice(vo);
	}
	
	
	@Override
	public int deleteNotice(int noticeNo) 
	{
		LOGGER.info("deleteNotice() 호출");
		return freeDao.deleteNotice(noticeNo);
	}

	@Override
	public List<FreePageVO> bestListAll() 
	{
		LOGGER.info("Service bestListAll() ");
		return freeDao.bestListAll();
	}
	

	@Override
	public List<FreePageVO> bestReviewAll()
	{
		LOGGER.info("Service bestReviewAll()");
		return freeDao.bestReviewAll();
	}

	@Override
	public List<FreePageVO> bestGoodAll() 
	{
		LOGGER.info("Service bestGoodAll()");
		return freeDao.bestGoodAll();
	}

	@Override
	public List<FreePageVO> bestWishAll() 
	{
		LOGGER.info("Service bestWishAll()");
		return freeDao.bestWishAll();
	}

	
	
}
