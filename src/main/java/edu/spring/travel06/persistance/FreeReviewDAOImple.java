package edu.spring.travel06.persistance;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.travel06.domain.FreeReviewVO;
import edu.spring.travel06.pageutil.PageCriteria;

@Repository
public class FreeReviewDAOImple implements FreeReviewDAO{

	private static final Logger LOGGER = 
			LoggerFactory.getLogger(FreeReviewDAOImple.class);
	private static final String NAMESPACE = 
			"edu.spring.travel06.FreeReviewMapper";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insert(FreeReviewVO vo) {
		LOGGER.info("insert() ȣ��");
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	}

	@Override
	public List<FreeReviewVO> select(int freeNo) {
		LOGGER.info("select() ȣ�� : freeNo = " + freeNo);
		return sqlSession.selectList(NAMESPACE + ".select_all", freeNo);
	}

	@Override
	public int update(FreeReviewVO vo) {
		LOGGER.info("update() ȣ��");
		return sqlSession.update(NAMESPACE + ".update", vo);
	}

	@Override
	public int delete(int freeReviewNo) {
		LOGGER.info("delete() ȣ�� : freeReviewNo = " + freeReviewNo);
		return sqlSession.delete(NAMESPACE + ".delete", freeReviewNo);
	}

	@Override
	public FreeReviewVO selectByReviewNo(int freeReviewNo) 
	{
		LOGGER.info("freeReviewNo = " + freeReviewNo);
		return sqlSession.selectOne(NAMESPACE + ".select_by_reviewNo", freeReviewNo);
	}

	@Override
	public List<FreeReviewVO> select(String userNickname) 
	{
		LOGGER.info("작성자 : " + userNickname);
		return sqlSession.selectList(NAMESPACE + ".select_by_userNickName", userNickname);
	}

	@Override
	public int updateByNickname(String newNickname, FreeReviewVO review) 
	{
		LOGGER.info("닉네임 변경 : " + newNickname);
		Map<String, String> NicknameMap = new HashMap<String, String>();
		NicknameMap.put("userNickname", review.getUserNickname());
		NicknameMap.put("newNickname", newNickname);
		return sqlSession.update(NAMESPACE + ".update_by_userNickName", NicknameMap);
	}
	
	@Override
	public List<FreeReviewVO> listPaging(int freeNo, PageCriteria criteria) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("freeNo", freeNo);
		paramMap.put("criteria", criteria);
		return sqlSession.selectList(NAMESPACE + ".listPaging", paramMap);
	}

	@Override
	public int countReviews(int freeNo) {
		return sqlSession.selectOne(NAMESPACE + ".countReviews", freeNo);
	}
	
	
	

}
