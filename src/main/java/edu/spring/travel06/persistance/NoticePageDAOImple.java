package edu.spring.travel06.persistance;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.travel06.domain.NoticeVO;
import edu.spring.travel06.pageutil.PageCriteria;

@Repository
public class NoticePageDAOImple implements NoticePageDAO
{
	private static final Logger LOGGER = 
			LoggerFactory.getLogger(NoticePageDAOImple.class);
	
	private static final String NAMESPACE = 
			"edu.spring.travel06.NoticeMapper";
	
	@Autowired
	private SqlSession sqlSession;
	
	
	@Override
	public List<NoticeVO> noticeSelect() 
	{
		LOGGER.info("noticeSelect() 호출");
		return sqlSession.selectList(NAMESPACE + ".notice_select_all");
	}
	
	
	@Override
	public NoticeVO selectByNoticeNo(int noticeNo) 
	{
		LOGGER.info("selectByNoticeNo() 호출 noticeNo = " + noticeNo);
		return sqlSession.selectOne(NAMESPACE + ".select_by_noticeNo", noticeNo);
	}
	
	
	@Override
	public int insertNotice(NoticeVO vo) 
	{
		LOGGER.info("insertNotice() 호출");
		return sqlSession.insert(NAMESPACE + ".insertNotice", vo);
	}
	
	
	@Override
	public int updateNotice(NoticeVO vo) 
	{
		LOGGER.info("updateNotice() 호출");
		return sqlSession.update(NAMESPACE + ".updateNotice", vo);
	}
	
	
	@Override
	public int deleteNotice(int noticeNo) 
	{
		LOGGER.info("deleteNotice() 호출");
		return sqlSession.delete(NAMESPACE + ".deleteNotice", noticeNo);
	}


	@Override
	public List<NoticeVO> selectNickName(String nickName) 
	{
		LOGGER.info("select() 호출 : userNickname = " + nickName);
		nickName = "%" + nickName + "%";
		return sqlSession.selectList(NAMESPACE + ".select_by_nickname", nickName);
	}


	@Override
	public List<NoticeVO> select(PageCriteria criteria) 
	{
		LOGGER.info("Notice select() page = " + criteria.getPage());
		return sqlSession.selectList(NAMESPACE + ".paging", criteria);
	}


	@Override
	public int getTotalNumsOfRecords() 
	{
		LOGGER.info("getTotalNumsOfRecords() 호출");
		return sqlSession.selectOne(NAMESPACE + ".total_count");
	}


	@Override
	public int updateBynoticeViewCnt(int noticeNo) 
	{
		LOGGER.info("update() 호출: noticeNo = " + noticeNo);
		return sqlSession.update(NAMESPACE + ".update_noticeViewCnt", noticeNo);
	}
	
	
	
	
}
