package edu.spring.travel06.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import edu.spring.travel06.domain.*;
import edu.spring.travel06.pageutil.*;
import edu.spring.travel06.persistance.*;


@Service
public class ThemeReviewServiceImple implements ThemeReviewService
{
	private static final Logger LOGGER =
			LoggerFactory.getLogger(ThemeReviewServiceImple.class);
	
	@Autowired
	private ThemeReviewDAO themeReviewDao;
	@Autowired
	private ThemePageDAO themeDao;
	
	@Transactional
	@Override
	public int create(ThemeReviewVO vo) throws Exception 
	{
		LOGGER.info("create() ȣ��");
		themeReviewDao.insert(vo);
		LOGGER.info("먹거리 댓글 입력");
		
		themeDao.updateBythemeReviewCnt(1, vo.getThemaNo());
		LOGGER.info("먹거리 댓글 추가");
		return 1;
	}
	@Override
	public List<ThemeReviewVO> read(int themeNo) 
	{
		LOGGER.info("theme 댓글 list");
		return themeReviewDao.select(themeNo);
	}
	
	
	@Override
	public int update(ThemeReviewVO vo) 
	{
		LOGGER.info("themeReview 수정");
		return themeReviewDao.update(vo);
	}
	
	@Override
	public int delete(int themeReviewNo, int themeNo) throws Exception 
	{
		themeReviewDao.delete(themeReviewNo);
		LOGGER.info("먹거리 댓글 삭제");
		
		themeDao.updateBythemeReviewCnt(-1, themeNo);
		LOGGER.info("음식 게시글의 댓글 수 감소");
		return 1;
	}
	
	@Override
	public ThemeReviewVO readByReviewNo(int themeReviewNo) 
	{
		LOGGER.info("select: ");
		return themeReviewDao.selectByReviewNo(themeReviewNo);
	}
	
	@Override
	public List<ThemeReviewVO> readbyUser(String userNickname) 
	{
		LOGGER.info("NickName list : ");
		return themeReviewDao.select(userNickname);
	}
	
	@Override
	public int updateNickName(String newNickname, ThemeReviewVO review) 
	{
		LOGGER.info("변경할 닉네임 : ");
		return themeReviewDao.updateByNickname(newNickname, review);
	}
	
	@Override
	public List<ThemeReviewVO> getReviewPaging(int themeNo, PageCriteria criteria) throws Exception 
	{
		LOGGER.info("댓글 페이징 처리");
	      return themeReviewDao.listPaging(themeNo, criteria);
	}
	
	@Override
	public int countReviews(int themeNo) throws Exception 
	{
		LOGGER.info("댓글 갯수");
	      return themeReviewDao.countReviews(themeNo);
	}
	
	
}
