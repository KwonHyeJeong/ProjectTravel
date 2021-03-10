package edu.spring.travel06;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import edu.spring.travel06.domain.FreePageVO;
import edu.spring.travel06.domain.*;

import edu.spring.travel06.persistance.*;

@RunWith(SpringJUnit4ClassRunner.class) 
@WebAppConfiguration
@ContextConfiguration(locations = 
		{ "file:src/main/webapp/WEB-INF/spring/**/*.xml"}) 


public class UserDAOTest 
{
	private static final Logger logger =
			LoggerFactory.getLogger(UserDAOTest.class);
	
	
	@Autowired
	private UserDAO userDao;
	
	
	
	@Autowired
	private FreePageDAO freeDao;
	
	@Test
	public void testDAO()
	{
//		testInsert();
		testSelectAll();
//		testUpdate();

	}
	
	private void testUpdate()
	{
		
		
		FreePageVO fvo = new FreePageVO();
		List<FreePageVO> fList = freeDao.selectByUserNickname("power");
		for(FreePageVO vo : fList)
		{
			
			logger.info(vo.toString());
			fvo = vo;
			
		}
		int result = freeDao.updateByNickname("you", fvo);
		if(result == 1)
		{
			logger.info("수정 성공");
		}
		else
		{
			logger.info("수정 실패 ㅠㅠ");
		}
		
		
	}
	
	private void testSelectAll()
	{
//		List<UserVO> bList = userDao.select();
//		
//		for(UserVO uvo : bList)
//		{
//			logger.info(uvo.toString());
//			
//		}
		
		
		
		
		
		
	}

	private void testInsert()
	{
		Date birth = new Date("1983/10/04");
		SimpleDateFormat birthDay = new SimpleDateFormat("yyyy/MM/dd");
		String birthStr = birthDay.format(birth);
		
		UserVO uvo = new UserVO(0,"김OO", "user12", "user1234", "user@test.com", "010-3262-1111", birth, "mine5", 0);
		
		int result = userDao.insert(uvo);
		if(result == 1)
		{
			logger.info("insert 성공");
			
		}
		else
		{
			logger.info("insert 실패");
			
		}
		
		
	}
	
	
	
	
	
}
