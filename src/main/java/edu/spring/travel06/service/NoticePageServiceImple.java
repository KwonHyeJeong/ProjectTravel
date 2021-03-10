package edu.spring.travel06.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.travel06.domain.NoticeVO;
import edu.spring.travel06.pageutil.PageCriteria;
import edu.spring.travel06.persistance.NoticePageDAO;

@Service // @Component
//스프링 프레임워크에게 서비스 계층(Service/Business layer)의
//컴퍼넌트임을 알려주는 어노테이션
public class NoticePageServiceImple implements NoticePageService
{
	private static final Logger logger = 
			LoggerFactory.getLogger(NoticePageServiceImple.class);
	
	
	@Autowired
	private NoticePageDAO noticeDao;
	
	
	@Override
	public List<NoticeVO> select() 
	{
		logger.info("service select() 호출");
		return noticeDao.noticeSelect();
	}
	
	
	@Override
	public NoticeVO select(int noticeNo) 
	{
		logger.info("service select() 호출 noticeNo = " + noticeNo);
		return noticeDao.selectByNoticeNo(noticeNo);
	}
	
	
	@Override
	public int createNotice(NoticeVO vo) 
	{
		logger.info("createNotice() 호출");
		return noticeDao.insertNotice(vo);
	}
	
	
	@Override
	public int updateNotice(NoticeVO vo) 
	{
		logger.info("updateNotice() 호출");
		return noticeDao.updateNotice(vo);
	}
	
	
	@Override
	public int deleteNotice(int noticeNo) 
	{
		logger.info("deleteNotice() 호출");
		return noticeDao.deleteNotice(noticeNo);
	}


	@Override
	public List<NoticeVO> read(PageCriteria criteria) 
	{
		logger.info("notice read() 호출 : page = " + criteria.getPage());
		return noticeDao.select(criteria);
	}


	@Override
	public int updateNoticeViewCnt(int noticeNo) 
	{
		logger.info("notice Service 조회수 증가");
		return noticeDao.updateBynoticeViewCnt(noticeNo);
	}


	@Override
	public int getTotalNumsOfRecords() 
	{
		logger.info("getTotalNumsOfRecords() ȣ��");
		return noticeDao.getTotalNumsOfRecords();
	}


	@Override
	public List<NoticeVO> readByNickName(String nickName) 
	{
		logger.info("Service Notice NickName : ");
		return noticeDao.selectNickName(nickName);
	}
	
	
	
}
