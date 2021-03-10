package edu.spring.travel06.persistance;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.travel06.domain.*;
import edu.spring.travel06.pageutil.*;

@Repository
public class ThemeReviewDAOImple implements ThemeReviewDAO{

	private static final Logger LOGGER = 
			LoggerFactory.getLogger(ThemeReviewDAOImple.class);
	private static final String NAMESPACE = 
			"edu.spring.travel06.ThemeReviewMapper";
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insert(ThemeReviewVO vo) {
		LOGGER.info("insert() ȣ��");
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	}

	@Override
	public List<ThemeReviewVO> select(int themeNo) {
		LOGGER.info("select() ȣ�� : freeNo = " + themeNo);
		return sqlSession.selectList(NAMESPACE + ".select_all", themeNo);
	}

	@Override
	public int update(ThemeReviewVO vo) {
		LOGGER.info("update() ȣ��");
		return sqlSession.update(NAMESPACE + ".update", vo);
	}

	@Override
	public int delete(int themeReviewNo) {
		LOGGER.info("delete() ȣ�� : themeReviewNo = " + themeReviewNo);
		return sqlSession.delete(NAMESPACE + ".delete", themeReviewNo);
	}

	@Override
	public ThemeReviewVO selectByReviewNo(int themeReviewNo) {
		LOGGER.info("themeReviewNo = " + themeReviewNo);
		return sqlSession.selectOne(NAMESPACE + ".select_by_reviewNo", themeReviewNo);
	}

	@Override
	public List<ThemeReviewVO> select(String userNickname) {
		LOGGER.info("작성자 : " + userNickname);
		return sqlSession.selectList(NAMESPACE + ".select_by_userNickName", userNickname);
	}

	@Override
	public int updateByNickname(String newNickname, ThemeReviewVO review) 
	{
		LOGGER.info("닉네임 변경 : " + newNickname);
		Map<String, String> NicknameMap = new HashMap<String, String>();
		NicknameMap.put("userNickname", review.getUserNickname());
		NicknameMap.put("newNickname", newNickname);
		return sqlSession.update(NAMESPACE + ".update_by_userNickName", NicknameMap);
	}

	@Override
	public List<ThemeReviewVO> listPaging(int themeNo, PageCriteria criteria) 
	{
		Map<String, Object> paramMap = new HashMap<>();
	      paramMap.put("themeNo", themeNo);
	      paramMap.put("criteria", criteria);
	      return sqlSession.selectList(NAMESPACE + ".listPaging", paramMap);
	}

	@Override
	public int countReviews(int themeNo) 
	{
		return sqlSession.selectOne(NAMESPACE + ".countReviews", themeNo);
	}
	
	

}
