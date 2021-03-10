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

public class ThemePageServiceImple implements ThemePageService
{
	private static final Logger LOGGER = 
			LoggerFactory.getLogger(ThemePageServiceImple.class);
	
	@Autowired
	private ThemePageDAO themeDao;

	@Override
	public List<ThemePageVO> read() {
		LOGGER.info("read() 호출");
		return themeDao.select();
	}

	@Override
	public ThemePageVO read(int themeNo) {
		LOGGER.info("read() 호출 : themeNo = " + themeNo);
		
		return themeDao.select(themeNo);
	}

	@Override
	public ThemePageVO readNickname(String userNickname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int create(ThemePageVO vo) {
		LOGGER.info("create() 호출");
		return themeDao.insert(vo);
	}

	@Override
	public int update(ThemePageVO vo) {
		LOGGER.info("update() 호출");
		return themeDao.update(vo);
	}

	@Override
	public int delete(int themeNo) {
		LOGGER.info("delete() 호출");
		return themeDao.delete(themeNo);
	}

	@Override
	public int getTotalNumsOfRecords() {
		LOGGER.info("getTotalNumsOfRecords() 호출");
		return themeDao.getTotalNumsOfRecords();
	}

	@Override
	public List<ThemePageVO> read(PageCriteria criteria) {
		LOGGER.info("read() 호출 : page = " + criteria.getPage());
		return themeDao.select(criteria);
	}

	@Override
	public int updateThemeViewCnt(int themeNo) {
		LOGGER.info("조회수 + 1");
		return themeDao.updateBythemeViewCnt(themeNo);
	}

	@Override
	public int updateThemeReviewCnt(int amount, int themeNo) {
		LOGGER.info("음식 댓글 수 : " + amount);
		return themeDao.updateBythemeReviewCnt(amount, themeNo);
	}

	@Override
	public int updateNickname(String userNickname, ThemePageVO themeVO) {
		LOGGER.info("닉네임 변경 : ");
		return themeDao.updateByNickname(userNickname, themeVO);
	}

	@Override
	public List<ThemePageVO> readByUserNickname(String userNickname) {
		LOGGER.info("작성자의 글 보기 : " + userNickname);
		return themeDao.selectByUserNickname(userNickname);
	}

	@Override
	public void insertThemeLike(ThemeLikeVO vo) {
		LOGGER.info("Service insertThemeLike() 호출");
		themeDao.insertThemeLike(vo);
		themeDao.updateThemeLike(vo.getThemaNo());
		
	}

	@Override
	public void deleteThemeLike(ThemeLikeVO vo) {
		LOGGER.info("Service deleteThemeLike() 호출");
		themeDao.deleteThemeLike(vo);
		themeDao.updateThemeLike(vo.getThemaNo());
		
	}

	@Override
	public int getThemeLike(ThemeLikeVO vo) {
		LOGGER.info("Service getThemeLike() 호출");
		return themeDao.getThemeLike(vo);
	}

	@Override
	public List<ThemeLikeVO> selectLike(int mno) {
		LOGGER.info("Service selectLike 호출");
		return themeDao.selectLike(mno);
	}

	@Override
	public List<ThemePageVO> selectThemeLike(int themeNo) 
	{
		LOGGER.info("Service selectThemeLike() 호출");
		return themeDao.selectThemeLike(themeNo);
	}

	@Override
	public void insertThemeWish(ThemeWishVO vo) 
	{
		LOGGER.info("insertThemeWish() ");
		themeDao.insertThemeWish(vo);
		themeDao.updateThemeWish(vo.getThemaNo());
	}

	@Override
	public void deleteThemeWish(ThemeWishVO vo) 
	{
		LOGGER.info("deleteThemeWish() ");
		themeDao.deleteThemeWish(vo);
		themeDao.updateThemeWish(vo.getThemaNo());
		
	}

	@Override
	public int getThemeWish(ThemeWishVO vo) 
	{
		LOGGER.info("Service getThemeWish() 호출");
		return themeDao.getThemeWish(vo);
	}

	@Override
	public List<ThemeWishVO> selectWish(int mno) 
	{
		LOGGER.info("Service selectWish() 호출");
		return themeDao.selectWish(mno);
	}

	@Override
	public List<ThemePageVO> selectThemeWish(int themeNo) 
	{
		LOGGER.info("Service selectThemeWish() 호출");
		return themeDao.selectThemeWish(themeNo);
	}

	@Override
	public List<ThemePageVO> bestListAll() 
	{
		LOGGER.info("Service bestListAll");
		return themeDao.bestListAll();
	}

	@Override
	public List<ThemePageVO> bestReviewAll() 
	{
		LOGGER.info("Service bestReviewAll");
		return themeDao.bestReviewAll();
	}

	@Override
	public List<ThemePageVO> bestGoodAll() 
	{
		LOGGER.info("Service bestGoodAll");
		return themeDao.bestGoodAll();
	}

	@Override
	public List<ThemePageVO> bestWishAll() 
	{
		LOGGER.info("Service bestWishAll");
		return themeDao.bestWishAll();
	}

	
}



