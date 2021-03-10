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
public class ThemePageDAOImple implements ThemePageDAO{
	private static final Logger LOGGER = 
			LoggerFactory.getLogger(ThemePageDAOImple.class);
	private static final String NAMESPACE = 
			"edu.spring.travel06.ThemeMapper";
	

	@Autowired
	private SqlSession sqlSession;


	@Override
	public List<ThemePageVO> select() {
		LOGGER.info("select() 호출");
		return sqlSession.selectList(NAMESPACE + ".select_all");
	}


	@Override
	public ThemePageVO select(int themeNo) {
		LOGGER.info("select() 호출 : themeNo = " + themeNo);
		return sqlSession.selectOne(NAMESPACE + ".select_by_themaNo", themeNo);
	}


	@Override
	public ThemePageVO selectNickname(String userNickname) {
		LOGGER.info("vo의 닉네임 조회");
		
		return sqlSession.selectOne(NAMESPACE + ".select_by_user_nickname", userNickname);
	}


	@Override
	public int insert(ThemePageVO vo) {
		LOGGER.info("insert() 호출");
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	}


	@Override
	public int update(ThemePageVO vo) {
		LOGGER.info("update() 호출");
		return sqlSession.update(NAMESPACE + ".update", vo);
	}


	@Override
	public int delete(int themeNo) {
		LOGGER.info("delete() 호출");
		return sqlSession.delete(NAMESPACE + ".delete", themeNo);
	}


	@Override
	public int getTotalNumsOfRecords() {
		LOGGER.info("getTotalNumsOfRecords() 호출");
		return sqlSession.selectOne(NAMESPACE + ".total_count");
	}


	@Override
	public List<ThemePageVO> select(PageCriteria criteria) {
		LOGGER.info("select() 호출 : page = " + criteria.getPage());
		return sqlSession.selectList(NAMESPACE + ".paging", criteria);
	}


	@Override
	public List<ThemePageVO> select(String userNickname) {
		LOGGER.info("select() 호출 : userNickname = " + userNickname);
		userNickname = "%" + userNickname + "%";
		return sqlSession.selectList(NAMESPACE + ".select_by_userNickname", userNickname);
	}


	@Override
	public List<ThemePageVO> selectByTitleOrContent(String keyword) {
		LOGGER.info("selectByTitleOrContent() : keyword = " + keyword);
		keyword = "%" + keyword + "%";
		return sqlSession.
				selectList(NAMESPACE + ".select_by_title_content", keyword);
	}


	@Override
	public int updateBythemeViewCnt(int themeNo) {
		LOGGER.info("update() 호출 : themeNo = " + themeNo);
		return sqlSession.update(NAMESPACE + ".update_themaViewCnt", themeNo);
	}


	@Override
	public int updateBythemeReviewCnt(int amount, int themeNo) {
		Map<String, Integer> args = new HashMap<String, Integer>();
		args.put("amount", amount);
		args.put("themaNo", themeNo);
		
		return sqlSession.update(NAMESPACE + ".update_themaReviewCnt", args);
	}


	@Override
	public int updateByNickname(String newNickname, ThemePageVO themePage) {
		LOGGER.info("닉네임 변경 : " + newNickname);
		Map<String, String> NicknameMap = new HashMap<String, String>();
		NicknameMap.put("userNickname", themePage.getUserNickname());
		NicknameMap.put("newNickname", newNickname);
		return sqlSession.update(NAMESPACE + ".update_by_userNickname", NicknameMap);
	}


	@Override
	public List<ThemePageVO> selectByUserNickname(String userNickname) {
		LOGGER.info("selectByThemeNickname() 호출");
		userNickname = "%" + userNickname + "%";
		return sqlSession.selectList(NAMESPACE + ".select_by_user_nickname", userNickname);
	}


	@Override
	public void insertThemeLike(ThemeLikeVO vo) {
		LOGGER.info("insertBoardLike() 호출");
		sqlSession.insert(NAMESPACE + ".createBoardLike", vo);
		
	}


	@Override
	public void deleteThemeLike(ThemeLikeVO vo) {
		LOGGER.info("deleteBoardLike() 호출");
		sqlSession.delete(NAMESPACE + ".deleteBoardLike", vo);
		
	}


	@Override
	public void updateThemeLike(int boardId) {
		LOGGER.info("updateBoardLike() 호출");
		sqlSession.update(NAMESPACE + ".updateBoardLike", boardId);
		
	}


	@Override
	public int getThemeLike(ThemeLikeVO vo) {
		LOGGER.info("getBoardLike() 호출");
		return sqlSession.selectOne(NAMESPACE + ".getBoardLike", vo);
	}


	@Override
	public List<ThemeLikeVO> selectLike(int mno) {
		LOGGER.info("selectLike() 호출");
		return sqlSession.selectList(NAMESPACE + ".selectLike",mno);
	}


	@Override
	public List<ThemePageVO> selectThemeLike(int themeNo) {
		LOGGER.info("selectThemeLike() 호출");
		return sqlSession.selectList(NAMESPACE + ".selectThemeLike", themeNo);
	}
	
	
	@Override
	public void insertThemeWish(ThemeWishVO vo) 
	{
		LOGGER.info("insertThemeWish() 호출");
		sqlSession.insert(NAMESPACE + ".createThemeWish", vo);
		
	}
	
	
	@Override
	public void deleteThemeWish(ThemeWishVO vo) 
	{
		LOGGER.info("deleteThemeWish() 호출");
		sqlSession.delete(NAMESPACE + ".deleteThemeWish", vo);		
	}
	
	
	@Override
	public void updateThemeWish(int boardId) 
	{
		LOGGER.info("updateThemeWish() 호출");
		sqlSession.update(NAMESPACE + ".updateThemeWish", boardId);		
	}
	
	
	@Override
	public int getThemeWish(ThemeWishVO vo) 
	{
		LOGGER.info("getThemeWish() 호출");
		return sqlSession.selectOne(NAMESPACE + ".getThemeWish", vo);
	}
	
	
	@Override
	public List<ThemeWishVO> selectWish(int mno) 
	{
		LOGGER.info("selectWish() 호출");
		return sqlSession.selectList(NAMESPACE + ".selectWish",mno);
	}
	
	
	@Override
	public List<ThemePageVO> selectThemeWish(int themeNo) 
	{
		LOGGER.info("selectThemeWish() 호출");
		return sqlSession.selectList(NAMESPACE + ".selectThemeWish", themeNo);
	}
	
	@Override
	public List<ThemePageVO> bestListAll() 
	{
		return sqlSession.selectList(NAMESPACE + ".bestListAll");
	}
	
	
	@Override
	public List<ThemePageVO> bestReviewAll() 
	{
		return sqlSession.selectList(NAMESPACE + ".bestReviewAll");
	}
	
	
	@Override
	public List<ThemePageVO> bestGoodAll() 
	{
		return sqlSession.selectList(NAMESPACE + ".bestGoodAll");
	}
	
	
	@Override
	public List<ThemePageVO> bestWishAll() 
	{
		return sqlSession.selectList(NAMESPACE + ".bestWishAll");
	}
	
	


	
}






