package edu.spring.travel06.persistance;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import edu.spring.travel06.domain.*;

import edu.spring.travel06.pageutil.*;


@Repository
public class PlayPageDAOImple implements PlayPageDAO{
	private static final Logger LOGGER = 
			LoggerFactory.getLogger(PlayPageDAOImple.class);
	private static final String NAMESPACE = 
			"edu.spring.travel06.PlayMapper";
	

	@Autowired
	private SqlSession sqlSession;


	@Override
	public List<PlayPageVO> select() {
		LOGGER.info("select() 호출");
		return sqlSession.selectList(NAMESPACE + ".select_all");
	}
	@Override
	public PlayPageVO select(int playNo) {
		LOGGER.info("select() 호출 : playNo = " + playNo);
		return sqlSession.selectOne(NAMESPACE + ".select_by_playNo", playNo);
	}
	@Override
	public int insert(PlayPageVO vo) {
		LOGGER.info("insert() 호출");
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	}
	@Override
	public int update(PlayPageVO vo) {
		LOGGER.info("update() 호출");
		return sqlSession.update(NAMESPACE + ".update", vo);
	}
	@Override
	public int delete(int playNo) {
		LOGGER.info("delete() 호출");
		return sqlSession.delete(NAMESPACE + ".delete", playNo);
	}
	@Override
	public int getTotalNumsOfRecords() {
		LOGGER.info("getTotalNumsOfRecords() 호출");
		return sqlSession.selectOne(NAMESPACE + ".total_count");
	}
	@Override
	public List<PlayPageVO> select(PageCriteria criteria) {
		LOGGER.info("select() 호출 : page = " + criteria.getPage());
		return sqlSession.selectList(NAMESPACE + ".paging", criteria);
	}
	@Override
	public List<PlayPageVO> select(String userNickname) {
		LOGGER.info("select() 호출 : userNickname = " + userNickname);
		userNickname = "%" + userNickname + "%";
		return sqlSession.selectList(NAMESPACE + ".select_by_userNickname", userNickname);
	}
	@Override
	public List<PlayPageVO> selectByTitleOrContent(String keyword) {
		LOGGER.info("selectByTitleOrContent() : keyword = " + keyword);
		keyword = "%" + keyword + "%";
		return sqlSession.
				selectList(NAMESPACE + ".select_by_title_content", keyword);
	}
	
	@Override
	public int updateByplayViewCnt(int playNo) {
		LOGGER.info("update() 호출 : playNo = " + playNo);
		return sqlSession.update(NAMESPACE + ".update_playViewCnt", playNo);
	}

	@Override
	public int updateByplayReviewCnt(int amount, int playNo) {
		Map<String, Integer> args = new HashMap<String, Integer>();
		args.put("amount", amount);
		args.put("playNo", playNo);
		
		return sqlSession.update(NAMESPACE + ".update_playReviewCnt", args);
	}
	
	
	
	@Override
	public void insertPlayLike(PlayLikeVO vo) {
		LOGGER.info("insertBoardLike() 호출");
		sqlSession.insert(NAMESPACE + ".createBoardLike", vo);
		
	}
	@Override
	public void deletePlayLike(PlayLikeVO vo) {
		LOGGER.info("deleteBoardLike() 호출");
		sqlSession.delete(NAMESPACE + ".deleteBoardLike", vo);
		
	}
	@Override
	public void updatePlayLike(int boardId) {
		LOGGER.info("updateBoardLike() 호출");
		sqlSession.update(NAMESPACE + ".updateBoardLike", boardId);
		
	}
	@Override
	public int getPlayLike(PlayLikeVO vo) {
		LOGGER.info("getBoardLike() 호출");
		return sqlSession.selectOne(NAMESPACE + ".getBoardLike", vo);
	}
	
	@Override
	public List<PlayLikeVO> selectLike(int mno) 
	{
		LOGGER.info("selectLike() 호출");
		return sqlSession.selectList(NAMESPACE + ".selectLike",mno);
	}
	
	@Override
	public List<PlayPageVO> selectPlayLike(int playNo) 
	{
		LOGGER.info("selectPlayLike() 호출");
		return sqlSession.selectList(NAMESPACE + ".selectPlayLike", playNo);
	}
	
	
	@Override
	public int updateByNickname(String newNickname, PlayPageVO playPage) 
	{
		LOGGER.info("닉네임 변경 : " + newNickname);
		Map<String, String> NicknameMap = new HashMap<String, String>();
		NicknameMap.put("userNickname", playPage.getUserNickname());
		NicknameMap.put("newNickname", newNickname);
		return sqlSession.update(NAMESPACE + ".update_by_userNickname", NicknameMap);
	}
	
	
	@Override
	public List<PlayPageVO> selectByUserNickname(String userNickname) 
	{
		LOGGER.info("selectByPlayNickname() 호출");
		userNickname = "%" + userNickname + "%";
		return sqlSession.selectList(NAMESPACE + ".select_by_user_nickname", userNickname);
	}
	
	
	@Override
	public PlayPageVO selectNickname(String userNickname) 
	{
		LOGGER.info("vo의 닉네임 조회");
		
		return sqlSession.selectOne(NAMESPACE + ".select_by_user_nickname", userNickname);
	}
	
	
	@Override
	public void insertPlayWish(PlayWishVO vo) 
	{
		LOGGER.info("insertPlayWish() 호출");
		sqlSession.insert(NAMESPACE + ".createPlayWish", vo);
		
	}
	
	
	@Override
	public void deletePlayWish(PlayWishVO vo) 
	{
		LOGGER.info("deletePlayWish() 호출");
		sqlSession.delete(NAMESPACE + ".deletePlayWish", vo);		
	}
	
	
	@Override
	public void updatePlayWish(int boardId) 
	{
		LOGGER.info("updatePlayWish() 호출");
		sqlSession.update(NAMESPACE + ".updatePlayWish", boardId);		
	}
	
	
	@Override
	public int getPlayWish(PlayWishVO vo) 
	{
		LOGGER.info("getPlayWish() 호출");
		return sqlSession.selectOne(NAMESPACE + ".getPlayWish", vo);
	}
	
	
	@Override
	public List<PlayWishVO> selectWish(int mno) 
	{
		LOGGER.info("selectWish() 호출");
		return sqlSession.selectList(NAMESPACE + ".selectWish",mno);
	}
	
	
	@Override
	public List<PlayPageVO> selectPlayWish(int playNo) 
	{
		LOGGER.info("selectPlayWish() 호출");
		return sqlSession.selectList(NAMESPACE + ".selectPlayWish", playNo);
	}
	
	@Override
	public List<PlayPageVO> bestListAll()
	{
		return sqlSession.selectList(NAMESPACE + ".bestListAll");
	}
	
	@Override
	public List<PlayPageVO> bestReviewAll() 
	{
		return sqlSession.selectList(NAMESPACE + ".bestReviewAll");
	}
	
	@Override
	public List<PlayPageVO> bestGoodAll() 
	{
		return sqlSession.selectList(NAMESPACE + ".bestGoodAll");
	}
	
	@Override
	public List<PlayPageVO> bestWishAll()
	{
		return sqlSession.selectList(NAMESPACE + ".bestWishAll");
	}
	
}






