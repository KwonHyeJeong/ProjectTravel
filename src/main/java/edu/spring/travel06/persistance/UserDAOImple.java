package edu.spring.travel06.persistance;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.travel06.domain.*;
import edu.spring.travel06.pageutil.PageCriteria;


@Repository
public class UserDAOImple implements UserDAO
{
	private static final Logger logger = 
			LoggerFactory.getLogger(UserDAOImple.class);
	
	private static final String NAMESPACE = 
			"edu.spring.travel06.UserMapper";
	
	
	@Autowired
	private SqlSession sqlSession;
	
	
	@Override
	public int insert(UserVO uvo) 
	{
		logger.info("UserVO : " + uvo.toString());
		return sqlSession.insert(NAMESPACE + ".insert", uvo);
	}

	@Override
	public List<UserVO> select() 
	{
		logger.info("selectAll() 호출");
		return sqlSession.selectList(NAMESPACE + ".select_all");
	}

	

	@Override
	public int update(UserVO uvo) 
	{
		logger.info("수정 UserVO: " + uvo);
		return sqlSession.update(NAMESPACE + ".update", uvo);
	}

	@Override
	public int delete(String userID) 
	{
		logger.info("delete userID = " + userID);
		return sqlSession.delete(NAMESPACE + ".delete", userID);
	}

	

	@Override
	public UserVO select(String userID)
	{
		logger.info("userID select() 호출 : 아이디 = " + userID);
		try
		{
			return sqlSession.selectOne(NAMESPACE + ".select_by_userID", userID);
		}
		catch(NullPointerException ne)
		{
			
			return new UserVO();
		}
		
		
		
	}

	@Override
	public int updateWarnCount(int amount, int userNo) 
	{
		logger.info(userNo + "님의 경고 : ");
		HashMap<String, Integer> args = new HashMap<String, Integer>();
		args.put("amount", amount);
		args.put("userNo", userNo);
		
		return sqlSession.update(NAMESPACE + ".update_user_warning", args);
	}

	@Override
	public List<UserVO> select(PageCriteria criteria)
	{
		logger.info("select() ȣ�� : page = " + criteria.getPage());
		return sqlSession.selectList(NAMESPACE + ".paging", criteria);
	}

	@Override
	public int getTotalNumsOfRecords() 
	{
		logger.info("getTotalNumsOfRecords() ȣ��");
		return sqlSession.selectOne(NAMESPACE + ".total_count");
	}

	
	
}
