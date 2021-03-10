package edu.spring.travel06.persistance;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.travel06.domain.*;


@Repository
public class AdminDAOImple implements AdminDAO
{
	private static final Logger logger = 
			LoggerFactory.getLogger(AdminDAOImple.class);
	
	private static final String NAMESPACE = 
			"edu.spring.travel06.AdminMapper";
	
	@Autowired
	private SqlSession sqlSession;
	
	
	@Override
	public int insert(AdminVO avo) 
	{
		logger.info("AdminVO : " + avo);
		return sqlSession.insert(NAMESPACE + ".insert", avo);
	}

	
	@Override
	public List<AdminVO> select() 
	{
		logger.info("admin selectAll() 호출");
		return sqlSession.selectList(NAMESPACE + ".select_all");
	}
	
	@Override
	public int update(AdminVO avo) 
	{
		logger.info("수정 AdminVO : " + avo);
		return sqlSession.update(NAMESPACE + ".update", avo);
	}
	

	@Override
	public int delete(String adminID) 
	{
		logger.info("delete adminID = " + adminID);
		return sqlSession.delete(NAMESPACE + ".delete", adminID);
	}

	@Override
	public AdminVO select(String adminID) 
	{
		logger.info("adminID: " + adminID);
		try
		{
			return sqlSession.selectOne(NAMESPACE + ".select_by_adminID", adminID);
		}
		catch(NullPointerException ne)
		{
			return new AdminVO();
		}
		
		
	}



	
	
}
