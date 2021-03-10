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
public class PlayReviewServiceImple implements PlayReviewService{
	private static final Logger LOGGER =
			LoggerFactory.getLogger(PlayReviewServiceImple.class);
	
	@Autowired
	private PlayReviewDAO playReviewDao;
	@Autowired
	private PlayPageDAO playDao;
	
	@Transactional
	@Override
	public int create(PlayReviewVO vo) throws Exception {
		LOGGER.info("create() ȣ��");
		playReviewDao.insert(vo);
		LOGGER.info("먹거리 댓글 입력");
		
		playDao.updateByplayReviewCnt(1, vo.getPlayNo());
		LOGGER.info("먹거리 댓글 추가");
		return 1;
	}

	@Override
	public List<PlayReviewVO> read(int playNo) {
		LOGGER.info("play 댓글 list");
		return playReviewDao.select(playNo);
	}

	@Override
	public int update(PlayReviewVO vo) {
		LOGGER.info("playReview 수정");
		return playReviewDao.update(vo);
	}

	@Override
	public int delete(int playReviewNo, int playNo) throws Exception {
		playReviewDao.delete(playReviewNo);
		LOGGER.info("먹거리 댓글 삭제");
		
		playDao.updateByplayReviewCnt(-1, playNo);
		LOGGER.info("음식 게시글의 댓글 수 감소");
		return 1;
	}

	@Override
	public PlayReviewVO readByReviewNo(int playReviewNo) {
		LOGGER.info("select: ");
		return playReviewDao.selectByReviewNo(playReviewNo);
	}

	@Override
	public List<PlayReviewVO> readbyUser(String userNickname) {
		LOGGER.info("NickName list : ");
		return playReviewDao.select(userNickname);
	}

	@Override
	public int updateNickName(String newNickname, PlayReviewVO review) {
		LOGGER.info("변경할 닉네임 : ");
		return playReviewDao.updateByNickname(newNickname, review);
	}

	@Override
	public List<PlayReviewVO> getReviewPaging(int playNo, PageCriteria criteria) throws Exception {
		LOGGER.info("댓글 페이징 처리");
	      return playReviewDao.listPaging(playNo, criteria);
	}

	@Override
	public int countReviews(int playNo) throws Exception {
		LOGGER.info("댓글 갯수");
	      return playReviewDao.countReviews(playNo);
	}
	
	
}
