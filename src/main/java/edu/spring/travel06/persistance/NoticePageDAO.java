package edu.spring.travel06.persistance;

import java.util.List;

import edu.spring.travel06.domain.FoodPageVO;
import edu.spring.travel06.domain.NoticeVO;
import edu.spring.travel06.pageutil.PageCriteria;

public interface NoticePageDAO 
{
	// 공지사항 기능
	public abstract List<NoticeVO> noticeSelect();
	public abstract NoticeVO selectByNoticeNo(int noticeNo);
	public abstract int insertNotice(NoticeVO vo);
	public abstract int updateNotice(NoticeVO vo);
	public abstract int deleteNotice(int noticeNo);
	public abstract List<NoticeVO> selectNickName(String nickName);
	public abstract List<NoticeVO> select(PageCriteria criteria);
	
	
	public abstract int getTotalNumsOfRecords();
	public abstract int updateBynoticeViewCnt(int noticeNo);
	
	
	
	
}
