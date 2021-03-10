package edu.spring.travel06.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.spring.travel06.domain.*;
import edu.spring.travel06.pageutil.PageCriteria;
import edu.spring.travel06.persistance.*;



//@Transactional
// - 두 개의 데이터베이스 변경이 생길 때
//   위의 내용이 실행되었고, 아래 내용이 에러가 발생하면
//   위의 내용은 rollback 되어야 한다.
//   이러한 기능을 해주는 어노테이션이 Transactional이다.



@Service
public class UserServiceImple implements UserService
{
	
	private static final Logger logger = 
			LoggerFactory.getLogger(UserServiceImple.class);
	
	@Autowired
	private UserDAO userDao;
	

	
	@Override
	public List<UserVO> read() 
	{
		logger.info("read() 호출");
		return userDao.select();
	}

	

	@Override
	public int create(UserVO uvo) 
	{
		logger.info("create() 호출");
		return userDao.insert(uvo);
	}

	@Override
	public int update(UserVO uvo) 
	{
		logger.info("userService update : " + uvo.toString());
		return userDao.update(uvo);
	}
	
	
	
	@Override
	public int delete(String userID)
	{

		logger.info("userService delete : " + userID);
		userDao.delete(userID);
		return 1;
	}

	@Override
	public UserVO read(String userID) 
	{
		logger.info("아이디 = " + userID);
		return userDao.select(userID);
		
		
	}



	@Override
	public int updateUserWarning(int amount, int userNo) 
	{
		logger.info("신고하기 버튼 클릭");
		return userDao.updateWarnCount(amount, userNo);
	}



	@Override
	public List<UserVO> read(PageCriteria criteria) 
	{
		logger.info("read() ȣ�� : userPage = " + criteria.getPage());
		return userDao.select(criteria);
	}



	@Override
	public int getTotalNumsOfRecords() 
	{
		logger.info("getTotalNumsOfRecords() ȣ��");
		return userDao.getTotalNumsOfRecords();
	}




	
}
