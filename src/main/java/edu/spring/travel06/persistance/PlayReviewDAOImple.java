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
public class PlayReviewDAOImple implements PlayReviewDAO{

	private static final Logger LOGGER = 
			LoggerFactory.getLogger(PlayReviewDAOImple.class);
	private static final String NAMESPACE = 
			"edu.spring.travel06.PlayReviewMapper";
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insert(PlayReviewVO vo) {
		LOGGER.info("insert() ȣ��");
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	}

	@Override
	public List<PlayReviewVO> select(int playNo) {
		LOGGER.info("select() ȣ�� : playNo = " + playNo);
		return sqlSession.selectList(NAMESPACE + ".select_all", playNo);
	}

	@Override
	public int update(PlayReviewVO vo) {
		LOGGER.info("update() ȣ��");
		return sqlSession.update(NAMESPACE + ".update", vo);
	}

	@Override
	public int delete(int playReviewNo) {
		LOGGER.info("delete() ȣ�� : freeReviewNo = " + playReviewNo);
		return sqlSession.delete(NAMESPACE + ".delete", playReviewNo);
	}

	@Override
	public PlayReviewVO selectByReviewNo(int playReviewNo) {
		LOGGER.info("playReviewNo = " + playReviewNo);
		return sqlSession.selectOne(NAMESPACE + ".select_by_reviewNo", playReviewNo);
	}

	@Override
	public List<PlayReviewVO> select(String userNickname) {
		LOGGER.info("작성자 : " + userNickname);
		return sqlSession.selectList(NAMESPACE + ".select_by_userNickName", userNickname);
	}

	@Override
	public int updateByNickname(String newNickname, PlayReviewVO review) {
		LOGGER.info("닉네임 변경 : " + newNickname);
		Map<String, String> NicknameMap = new HashMap<String, String>();
		NicknameMap.put("userNickname", review.getUserNickname());
		NicknameMap.put("newNickname", newNickname);
		return sqlSession.update(NAMESPACE + ".update_by_userNickName", NicknameMap);
	}

	@Override
	public List<PlayReviewVO> listPaging(int playNo, PageCriteria criteria) {
		Map<String, Object> paramMap = new HashMap<>();
	      paramMap.put("playNo", playNo);
	      paramMap.put("criteria", criteria);
	      return sqlSession.selectList(NAMESPACE + ".listPaging", paramMap);
	}

	@Override
	public int countReviews(int playNo) {
		return sqlSession.selectOne(NAMESPACE + ".countReviews", playNo);
	}
	
	

}
