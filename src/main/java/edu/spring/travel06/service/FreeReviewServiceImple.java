package edu.spring.travel06.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.spring.travel06.domain.FreeReviewVO;
import edu.spring.travel06.pageutil.PageCriteria;

import edu.spring.travel06.persistance.*;


@Service
public class FreeReviewServiceImple implements FreeReviewService{
	private static final Logger LOGGER =
			LoggerFactory.getLogger(FreeReviewServiceImple.class);
	
	@Autowired
	private FreeReviewDAO reviewDao;
	
	@Autowired
	private FreePageDAO freeDao;
	
	
	@Transactional
	@Override
	public int create(FreeReviewVO vo)
	{
		LOGGER.info("create() 호출");
		reviewDao.insert(vo);
		LOGGER.info("댓글 입력 성공");
		
		freeDao.updateByfreeReviewCnt(1, vo.getFreeNo());
		LOGGER.info("게시판 댓글 개수 업데이트 성공");
		return 1;
	}

	@Override
	public List<FreeReviewVO> read(int freeNo) {
		LOGGER.info("댓글 list");
		return reviewDao.select(freeNo);
	}

	@Override
	public int update(FreeReviewVO vo) {
		LOGGER.info("댓글 수정");
		return reviewDao.update(vo);
	}
	
	

	@Transactional
	@Override
	public int delete(int freeReviewNo, int freeNo) 
	{
		LOGGER.info("자유게시판 댓글 삭제");
		reviewDao.delete(freeReviewNo);
		LOGGER.info("��� ���� ����");
		
		freeDao.updateByfreeReviewCnt(-1, freeNo);
		LOGGER.info("�Խ��� ��� ���� ������Ʈ ����");
		return 1;
	}

	@Override
	public FreeReviewVO readByReviewNo(int freeReviewNo) 
	{
		LOGGER.info("select: ");
		return reviewDao.selectByReviewNo(freeReviewNo);
	}

	@Override
	public List<FreeReviewVO> readbyUser(String userNickname)
	{
		LOGGER.info("댓글 list : ");
		return reviewDao.select(userNickname);
	}

	@Override
	public int updateNickName(String newNickname, FreeReviewVO review) 
	{
		LOGGER.info("변경할 닉네임 : ");
		return reviewDao.updateByNickname(newNickname, review);
	}
	
	
	@Override
	public List<FreeReviewVO> getReviewPaging(int freeNo, 
						PageCriteria criteria) throws Exception 
	{
		LOGGER.info("댓글 페이징 처리");
		return reviewDao.listPaging(freeNo, criteria);
	}

	@Override
	public int countReviews(int freeNo) throws Exception 
	{
		LOGGER.info("댓글 갯수");
		return reviewDao.countReviews(freeNo);
	}
	

}
