package edu.spring.travel06.persistance;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.travel06.domain.*;


@Repository
public class VisitCountDAOImple implements VisitCountDAO
{
	private static final Logger logger = 
			LoggerFactory.getLogger(VisitCountDAOImple.class);
	
	private static final String NAMESPACE = 
			"edu.spring.travel06.VisitMapper";
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int totalVisit(VisitCountVO vo) {
		logger.info("totalVisit() 호출");
		return sqlSession.selectOne(NAMESPACE + ".totalVisit", vo);
	}

	@Override
	public int todayVisit(VisitCountVO vo) {
		logger.info("todayVisit() 호출");
		return sqlSession.selectOne(NAMESPACE + ".todayVisit", vo);
	}

	@Override
	public int insertVisit(VisitCountVO vo) {
		logger.info("insertVisit() 호출");
		return sqlSession.insert(NAMESPACE + ".insertVisit", vo);

		
	}

	
	
	



	
	
}
