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

public class PlayPageServiceImple implements PlayPageService
{
	private static final Logger logger = 
			LoggerFactory.getLogger(PlayPageServiceImple.class);
	
	@Autowired
	private PlayPageDAO playDao;

	@Override
	public List<PlayPageVO> read() 
	{
		logger.info("read() 호출");
		return playDao.select();
	}

	@Override
	public PlayPageVO read(int playNo) 
	{
		logger.info("read() 호출 : playNo = " + playNo);
		
		return playDao.select(playNo);
	}

	@Override
	public PlayPageVO readNickname(String userNickname) 
	{
		logger.info("pageVO의 닉네임 : " + userNickname);
		return playDao.selectNickname(userNickname);
	}

	@Override
	public int create(PlayPageVO vo) 
	{
		logger.info("create() 호출");
		return playDao.insert(vo);
	}

	@Override
	public int update(PlayPageVO vo) 
	{
		logger.info("update() 호출");
		return playDao.update(vo);
	}

	@Override
	public int delete(int playNo) 
	{
		logger.info("delete() 호출");
		return playDao.delete(playNo);
	}

	@Override
	public int getTotalNumsOfRecords() 
	{
		logger.info("getTotalNumsOfRecords() 호출");
		return playDao.getTotalNumsOfRecords();
	}

	@Override
	public List<PlayPageVO> read(PageCriteria criteria) 
	{
		logger.info("read() 호출 : page = " + criteria.getPage());
		return playDao.select(criteria);
	}

	@Override
	public int updatePlayViewCnt(int playNo) 
	{
		logger.info("조회수 + 1");
		return playDao.updateByplayViewCnt(playNo);
	}

	@Override
	public int updatePlayReviewCnt(int amount, int playNo) 
	{
		logger.info("음식 댓글 수 : " + amount);
		return playDao.updateByplayReviewCnt(amount, playNo);
	}

	@Override
	public int updateNickname(String userNickname, PlayPageVO playVO) 
	{
		logger.info("닉네임 변경 : ");
		return playDao.updateByNickname(userNickname, playVO);
	}

	@Override
	public List<PlayPageVO> readByUserNickname(String userNickname) 
	{
		logger.info("작성자의 글 보기 : " + userNickname);
		return playDao.selectByUserNickname(userNickname);
	}

	@Override
	public void insertPlayLike(PlayLikeVO vo) 
	{
		logger.info("Service insertPlayLike() 호출");
		playDao.insertPlayLike(vo);
		playDao.updatePlayLike(vo.getPlayNo());
		
	}

	@Override
	public void deletePlayLike(PlayLikeVO vo) 
	{
		logger.info("Service deletePlayLike() 호출");
		playDao.deletePlayLike(vo);
		playDao.updatePlayLike(vo.getPlayNo());
		
	}

	@Override
	public int getPlayLike(PlayLikeVO vo) 
	{
		logger.info("Service getPlayLike() 호출");
		return playDao.getPlayLike(vo);
	}

	@Override
	public List<PlayLikeVO> selectLike(int mno) 
	{
		logger.info("Service selectLike 호출");
		return playDao.selectLike(mno);
	}

	@Override
	public List<PlayPageVO> selectPlayLike(int playNo) 
	{
		logger.info("Service selectPlayLike() 호출");
		return playDao.selectPlayLike(playNo);
	}

	@Override
	public void insertPlayWish(PlayWishVO vo) 
	{
		logger.info("Service insertPlayWish() 호출");
		playDao.insertPlayWish(vo);
		playDao.updatePlayWish(vo.getPlayNo());
	}

	@Override
	public void deletePlayWish(PlayWishVO vo) 
	{
		logger.info("Service deletePlayWish() 호출");
		playDao.deletePlayWish(vo);
		playDao.updatePlayWish(vo.getPlayNo());
	}

	@Override
	public int getPlayWish(PlayWishVO vo) 
	{
		logger.info("Service getPlayWish() 호출");
		return playDao.getPlayWish(vo);
	}

	@Override
	public List<PlayWishVO> selectWish(int mno) 
	{
		logger.info("Service selectWish 호출");
		return playDao.selectWish(mno);
	}

	@Override
	public List<PlayPageVO> selectPlayWish(int playNo) 
	{
		logger.info("Service selectPlayWish() 호출");
		return playDao.selectPlayWish(playNo);
	}

	@Override
	public List<PlayPageVO> bestListAll() 
	{
		logger.info("Service bestListAll()");
		return playDao.bestListAll();
	}

	@Override
	public List<PlayPageVO> bestReviewAll()
	{
		logger.info("Service bestReviewAll()");
		return playDao.bestReviewAll();
	}

	@Override
	public List<PlayPageVO> bestGoodAll() 
	{
		logger.info("Service bestGoodAll()");
		return playDao.bestGoodAll();
	}

	@Override
	public List<PlayPageVO> bestWishAll() 
	{
		logger.info("Service bestWishAll()");
		return playDao.bestWishAll();
	}
	

	
	

}



