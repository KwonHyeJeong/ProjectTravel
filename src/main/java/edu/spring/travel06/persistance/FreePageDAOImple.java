package edu.spring.travel06.persistance;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.travel06.pageutil.*;
import edu.spring.travel06.domain.*;


@Repository
public class FreePageDAOImple implements FreePageDAO{
	private static final Logger LOGGER = 
			LoggerFactory.getLogger(FreePageDAOImple.class);
	
	private static final String NAMESPACE = 
			"edu.spring.travel06.FreeMapper";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<FreePageVO> select() {
		LOGGER.info("select() ȣ��");
		return sqlSession.selectList(NAMESPACE+ ".select_all");
	}

	@Override
	public FreePageVO select(int freeNo) {
		LOGGER.info("select() ȣ�� : free_no = " + freeNo);
		return sqlSession.selectOne(NAMESPACE + ".select_by_free_no", freeNo); 
	}

	@Override
	public int insert(FreePageVO vo) {
		LOGGER.info("insert() ȣ��");
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	}

	@Override
	public int update(FreePageVO vo) {
		LOGGER.info("update() ȣ��");
		return sqlSession.update(NAMESPACE + ".update", vo);
	}
	
	
	@Override
	public int updateByNickname(String newNickname, FreePageVO vo) 
	{
		LOGGER.info("닉네임 변경 : " + newNickname);
		Map<String, String> NicknameMap = new HashMap<String, String>();
		NicknameMap.put("userNickname", vo.getUserNickname());
		NicknameMap.put("newNickname", newNickname);
		return sqlSession.update(NAMESPACE + ".update_by_userNickname", NicknameMap);
	}
	

	@Override
	public int delete(int freeNo) {
		LOGGER.info("delete() ȣ��");
		return sqlSession.delete(NAMESPACE + ".delete", freeNo);
	}

	@Override
	public int getTotalNumsOfRecords() {
		LOGGER.info("getTotalNumsOfRecords() ȣ��");
		return sqlSession.selectOne(NAMESPACE + ".total_count");
	}

	@Override
	public List<FreePageVO> select(PageCriteria criteria) {
		LOGGER.info("select() ȣ�� : page = " + criteria.getPage());
		return sqlSession.selectList(NAMESPACE + ".paging", criteria);
	}



//	@Override
//	public int updateByFreeViewCnt(int freeNo) {
//		return sqlSession.update(NAMESPACE + ".update_FreeviewCnt", freeNo);
//	}
	
	@Override
	public int updateByFreeViewCnt(int amount, int freeNo) {
		Map<String, Integer> args = new HashMap<String, Integer>();
		args.put("amount", amount);
		args.put("freeNo", freeNo);
		
		return sqlSession.update(NAMESPACE + ".update_freeViewCnt", args);
	}

	@Override
	public List<FreePageVO> NicknamePaging(String userNickname, PageCriteria criteria) 
	{
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("userNickname", userNickname);
		paramMap.put("criteria", criteria);
		return sqlSession.selectList(NAMESPACE + ".NicknameList", paramMap);
	}

	@Override
	public FreePageVO selectNickname(String userNickname) 
	{
		LOGGER.info("vo의 닉네임 조회");
		
		return sqlSession.selectOne(NAMESPACE + ".select_by_user_nickname", userNickname);
	}
	
	
	@Override
	public int updateByfreeReviewCnt(int amount, int freeNo) 
	{
		Map<String, Integer> args = new HashMap<String, Integer>();
		args.put("amount", amount);
		args.put("freeNo", freeNo);
		
		return sqlSession.update(NAMESPACE + ".update_freeReviewCnt", args);
	}

	
	@Override
	public void insertBoardLike(BoardLikeVO likeVO) 
	{
		LOGGER.info("insertBoardLike() 호출");
		sqlSession.insert(NAMESPACE + ".createBoardLike", likeVO);
		
	}

	@Override
	public void deleteBoardLike(BoardLikeVO likeVO) 
	{
		LOGGER.info("deleteBoardLike() 호출");
		sqlSession.delete(NAMESPACE + ".deleteBoardLike", likeVO);
		
	}

	@Override
	public void updateBoardLike(int boardId) 
	{
		LOGGER.info("updateBoardLike() 호출");
		sqlSession.update(NAMESPACE + ".updateBoardLike", boardId);
		
	}

	@Override
	public int getBoardLike(BoardLikeVO vo) 
	{
		LOGGER.info("getBoardLike() 호출");
		return sqlSession.selectOne(NAMESPACE + ".getBoardLike", vo);
	}

	@Override
	public List<BoardLikeVO> selectLike(int mno) {
		LOGGER.info("selectLike() 호출");
		return sqlSession.selectList(NAMESPACE + ".selectLike",mno);
	}

	@Override
	public List<FreePageVO> selectBoardLike(int boardno) {
		LOGGER.info("selectFreeLike() 호출");
		return sqlSession.selectList(NAMESPACE + ".selectFreeLike", boardno);
	}

	@Override
	public List<FreePageVO> selectByUserNickname(String userNickname) 
	{
		LOGGER.info("작성자 : " + userNickname);
		return sqlSession.selectList(NAMESPACE + ".select_by_user_nickname", userNickname);
	}

	@Override
	public void insertFreeWish(FreeWishVO vo)
	{
		LOGGER.info("insertFreeWish() 호출");
		sqlSession.insert(NAMESPACE + ".createFreeWish", vo);
		
	}

	@Override
	public void deleteFreeWish(FreeWishVO vo) 
	{
		LOGGER.info("deleteFreeWish() 호출");
		sqlSession.delete(NAMESPACE + ".deleteFreeWish", vo);
	}

	@Override
	public void updateFreeWish(int boardId) 
	{
		LOGGER.info("updateFreeWish() 호출");
		sqlSession.update(NAMESPACE + ".updateFreeWish", boardId);
	}

	@Override
	public int getFreeWish(FreeWishVO vo) 
	{
		LOGGER.info("getFreeWish() 호출");
		return sqlSession.selectOne(NAMESPACE + ".getFreeWish", vo);
	}

	@Override
	public List<FreeWishVO> selectWish(int mno) 
	{
		LOGGER.info("selectWish() 호출");
		return sqlSession.selectList(NAMESPACE + ".selectWish",mno);
	}

	@Override
	public List<FreePageVO> selectFreeWish(int freeNo) 
	{
		LOGGER.info("selectFreeWish() 호출");
		return sqlSession.selectList(NAMESPACE + ".selectFreeWish", freeNo);
	}
	
	
	
	@Override
	public List<NoticeVO> noticeSelect() 
	{
		LOGGER.info("noticeSelect() 호출");
		return sqlSession.selectList(NAMESPACE + ".notice_select_all");
	}
	
	
	@Override
	public NoticeVO selectByNoticeNo(int noticeNo) 
	{
		LOGGER.info("selectByNoticeNo() 호출 noticeNo = " + noticeNo);
		return sqlSession.selectOne(NAMESPACE + ".select_by_noticeNo", noticeNo);
	}
	
	
	@Override
	public int insertNotice(NoticeVO vo) 
	{
		LOGGER.info("insertNotice() 호출");
		return sqlSession.insert(NAMESPACE + ".insertNotice", vo);
	}
	
	
	@Override
	public int updateNotice(NoticeVO vo) 
	{
		LOGGER.info("updateNotice() 호출");
		return sqlSession.update(NAMESPACE + ".updateNotice", vo);
	}
	
	
	@Override
	public int deleteNotice(int noticeNo) 
	{
		LOGGER.info("deleteNotice() 호출");
		return sqlSession.delete(NAMESPACE + ".deleteNotice", noticeNo);
	}
	
	
	@Override
	public List<FreePageVO> bestListAll() 
	{
		return sqlSession.selectList(NAMESPACE + ".bestListAll");
	}

	@Override
	public List<FreePageVO> bestReviewAll() 
	{
		return sqlSession.selectList(NAMESPACE + ".bestReviewAll");
	}

	@Override
	public List<FreePageVO> bestGoodAll() 
	{
		return sqlSession.selectList(NAMESPACE + ".bestGoodAll");
	}

	@Override
	public List<FreePageVO> bestWishAll() 
	{
		return sqlSession.selectList(NAMESPACE + ".bestWishAll");
	}
	
	


}
