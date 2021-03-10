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
public class FoodPageDAOImple implements FoodPageDAO
{
	private static final Logger LOGGER = 
			LoggerFactory.getLogger(FoodPageDAOImple.class);
	
	private static final String NAMESPACE = 
			"edu.spring.travel06.FoodMapper";
	
	
	@Autowired
	private SqlSession sqlSession;
	
	
	
	@Override
	public List<FoodPageVO> select() 
	{
		LOGGER.info("select() 호출");
		return sqlSession.selectList(NAMESPACE + ".select_all");
	}
	
	
	@Override
	public FoodPageVO select(int foodNo) 
	{
		LOGGER.info("select() 호출 : foodNo = " + foodNo);
		return sqlSession.selectOne(NAMESPACE + ".select_by_foodNo", foodNo);
	}
	
	
	@Override
	public int insert(FoodPageVO vo) 
	{
		LOGGER.info("insert() 호출");
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	}
	
	
	@Override
	public int update(FoodPageVO vo) 
	{
		LOGGER.info("update() 호출");
		return sqlSession.update(NAMESPACE + ".update", vo);
	}
	
	
	@Override
	public int delete(int foodNo) 
	{
		LOGGER.info("delete() 호출");
		return sqlSession.delete(NAMESPACE + ".delete", foodNo);
	}
	@Override
	public int getTotalNumsOfRecords() 
	{
		LOGGER.info("getTotalNumsOfRecords() 호출");
		return sqlSession.selectOne(NAMESPACE + ".total_count");
	}
	
	
	@Override
	public List<FoodPageVO> select(PageCriteria criteria) 
	{
		LOGGER.info("select() 호출 : page = " + criteria.getPage());
		return sqlSession.selectList(NAMESPACE + ".paging", criteria);
	}
	
	
	@Override
	public List<FoodPageVO> select(String userNickname) 
	{
		LOGGER.info("select() 호출 : userNickname = " + userNickname);
		userNickname = "%" + userNickname + "%";
		return sqlSession.selectList(NAMESPACE + ".select_by_userNickname", userNickname);
	}
	
	
	@Override
	public List<FoodPageVO> selectByTitleOrContent(String keyword) {
		LOGGER.info("selectByTitleOrContent() : keyword = " + keyword);
		keyword = "%" + keyword + "%";
		return sqlSession.
				selectList(NAMESPACE + ".select_by_title_content", keyword);
	}
	
	
	@Override
	public int updateByfoodViewCnt(int foodNo) 
	{
		LOGGER.info("update() 호출 : foodNo = " + foodNo);
		return sqlSession.update(NAMESPACE + ".update_foodViewCnt", foodNo);
	}

	@Override
	public int updateByfoodReviewCnt(int amount, int foodNo) 
	{
		Map<String, Integer> args = new HashMap<String, Integer>();
		args.put("amount", amount);
		args.put("foodNo", foodNo);
		
		return sqlSession.update(NAMESPACE + ".update_foodReviewCnt", args);
	}
	
	
	
	@Override
	public void insertBoardLike(FoodLikeVO vo) 
	{
		LOGGER.info("insertBoardLike() 호출");
		sqlSession.insert(NAMESPACE + ".createBoardLike", vo);
		
	}
	
	@Override
	public void deleteBoardLike(FoodLikeVO vo) 
	{
		LOGGER.info("deleteBoardLike() 호출");
		sqlSession.delete(NAMESPACE + ".deleteBoardLike", vo);
		
	}
	
	
	@Override
	public void updateBoardLike(int boardId) 
	{
		LOGGER.info("updateBoardLike() 호출");
		sqlSession.update(NAMESPACE + ".updateBoardLike", boardId);
		
	}
	
	
	@Override
	public int getBoardLike(FoodLikeVO vo) 
	{
		LOGGER.info("getBoardLike() 호출");
		return sqlSession.selectOne(NAMESPACE + ".getBoardLike", vo);
	}
	
	
	@Override
	public List<FoodLikeVO> selectLike(int mno) 
	{
		LOGGER.info("selectLike() 호출");
		return sqlSession.selectList(NAMESPACE + ".selectLike",mno);
	}
	
	
	@Override
	public List<FoodPageVO> selectFoodLike(int foodNo)
	{
		LOGGER.info("selectFoodLike() 호출");
		return sqlSession.selectList(NAMESPACE + ".selectFoodLike", foodNo);
	}
	
	
	@Override
	public int updateByNickname(String newNickname, FoodPageVO foodPage) 
	{
		LOGGER.info("닉네임 변경 : " + newNickname);
		Map<String, String> NicknameMap = new HashMap<String, String>();
		NicknameMap.put("userNickname", foodPage.getUserNickname());
		NicknameMap.put("newNickname", newNickname);
		return sqlSession.update(NAMESPACE + ".update_by_userNickname", NicknameMap);
	}
	
	
	@Override
	public List<FoodPageVO> selectByUserNickname(String userNickname) 
	{
		LOGGER.info("selectByFoodNickname() 호출");
		userNickname = "%" + userNickname + "%";
		return sqlSession.selectList(NAMESPACE + ".select_by_user_nickname", userNickname);
	}
	
	
	@Override
	public FoodPageVO selectNickname(String userNickname) 
	{
		LOGGER.info("vo의 닉네임 조회");
		
		return sqlSession.selectOne(NAMESPACE + ".select_by_user_nickname", userNickname);
	}
	
	
	@Override
	public void insertFoodWish(FoodWishVO vo) 
	{
		LOGGER.info("insertFoodWish() 호출");
		sqlSession.insert(NAMESPACE + ".createFoodWish", vo);
		
	}
	
	
	@Override
	public void deleteFoodWish(FoodWishVO vo) 
	{
		LOGGER.info("deleteFoodWish() 호출");
		sqlSession.delete(NAMESPACE + ".deleteFoodWish", vo);		
	}
	
	
	@Override
	public void updateFoodWish(int boardId) 
	{
		LOGGER.info("updateFoodWish() 호출");
		sqlSession.update(NAMESPACE + ".updateFoodWish", boardId);		
	}
	
	
	@Override
	public int getFoodWish(FoodWishVO vo) 
	{
		LOGGER.info("getFoodWish() 호출");
		return sqlSession.selectOne(NAMESPACE + ".getFoodWish", vo);
	}
	
	
	@Override
	public List<FoodWishVO> selectWish(int mno) 
	{
		LOGGER.info("selectWish() 호출");
		return sqlSession.selectList(NAMESPACE + ".selectWish",mno);
	}
	
	
	@Override
	public List<FoodPageVO> selectFoodWish(int foodNo) 
	{
		LOGGER.info("selectFoodWish() 호출");
		return sqlSession.selectList(NAMESPACE + ".selectFoodWish", foodNo);
	}
	
	
	@Override
	public List<FoodPageVO> bestListAll() 
	{
		return sqlSession.selectList(NAMESPACE + ".bestListAll");
	}
	
	@Override
	public List<FoodPageVO> bestReviewAll() 
	{
		return sqlSession.selectList(NAMESPACE + ".bestReviewAll");
	}
	
	@Override
	public List<FoodPageVO> bestGoodAll() 
	{
		return sqlSession.selectList(NAMESPACE + ".bestGoodAll");
	}
	
	@Override
	public List<FoodPageVO> bestWishAll() 
	{
		return sqlSession.selectList(NAMESPACE + ".bestWishAll");
	}
	
	
	
	
}






