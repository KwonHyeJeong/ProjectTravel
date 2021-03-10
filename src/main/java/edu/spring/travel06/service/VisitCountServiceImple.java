package edu.spring.travel06.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.travel06.domain.*;
import edu.spring.travel06.pageutil.*;
import edu.spring.travel06.persistance.*;


@Service // @Component
//스프링 프레임워크에게 서비스 계층(Service/Business layer)의
//컴퍼넌트임을 알려주는 어노테이션

public class VisitCountServiceImple implements VisitCountService{
	private static final Logger LOGGER = 
			LoggerFactory.getLogger(VisitCountServiceImple.class);
	
	@Autowired
	private VisitCountDAO visitDao;

	@Override
	public int totalVisit(VisitCountVO vo) {
		LOGGER.info("totalVisit() 호출");
		return visitDao.totalVisit(vo);
	}

	@Override
	public int todayVisit(VisitCountVO vo) {
		LOGGER.info("totalVisit() 호출");
		return visitDao.todayVisit(vo);
	}

	@Override
	public int insertVisit(VisitCountVO vo) {
		LOGGER.info("insertVisit() 호출");
		return visitDao.insertVisit(vo);
	}
	

	

}



