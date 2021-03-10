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
public class FoodReviewDAOImple implements FoodReviewDAO{

	private static final Logger LOGGER = 
			LoggerFactory.getLogger(FoodReviewDAOImple.class);
	private static final String NAMESPACE = 
			"edu.spring.travel06.FoodReviewMapper";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insert(FoodReviewVO vo) {
		LOGGER.info("insert() ȣ��");
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	}

	@Override
	public List<FoodReviewVO> select(int foodNo) {
		LOGGER.info("select() ȣ�� : freeNo = " + foodNo);
		return sqlSession.selectList(NAMESPACE + ".select_all", foodNo);
	}

	@Override
	public int update(FoodReviewVO vo) {
		LOGGER.info("update() ȣ��");
		return sqlSession.update(NAMESPACE + ".update", vo);
	}

	@Override
	public int delete(int foodReviewNo) {
		LOGGER.info("delete() ȣ�� : freeReviewNo = " + foodReviewNo);
		return sqlSession.delete(NAMESPACE + ".delete", foodReviewNo);
	}
	
	@Override
	   public List<FoodReviewVO> listPaging(int foodNo, PageCriteria criteria) {
	      Map<String, Object> paramMap = new HashMap<>();
	      paramMap.put("foodNo", foodNo);
	      paramMap.put("criteria", criteria);
	      return sqlSession.selectList(NAMESPACE + ".listPaging", paramMap);
	   }

	   @Override
	   public int countReviews(int foodNo) {
	      return sqlSession.selectOne(NAMESPACE + ".countReviews", foodNo);
	   }

	@Override
	public FoodReviewVO selectByReviewNo(int foodReviewNo) 
	{
		LOGGER.info("foodReviewNo = " + foodReviewNo);
		return sqlSession.selectOne(NAMESPACE + ".select_by_reviewNo", foodReviewNo);
	}

	@Override
	public List<FoodReviewVO> select(String userNickname) 
	{
		LOGGER.info("작성자 : " + userNickname);
		return sqlSession.selectList(NAMESPACE + ".select_by_userNickName", userNickname);
	}

	@Override
	public int updateByNickname(String newNickname, FoodReviewVO review) 
	{
		LOGGER.info("닉네임 변경 : " + newNickname);
		Map<String, String> NicknameMap = new HashMap<String, String>();
		NicknameMap.put("userNickname", review.getUserNickname());
		NicknameMap.put("newNickname", newNickname);
		return sqlSession.update(NAMESPACE + ".update_by_userNickName", NicknameMap);
	}

}
