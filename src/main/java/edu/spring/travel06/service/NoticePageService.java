package edu.spring.travel06.service;

import java.util.List;

import edu.spring.travel06.domain.NoticeVO;
import edu.spring.travel06.pageutil.PageCriteria;

public interface NoticePageService
{
	// 공지사항 기능
	public abstract List<NoticeVO> select();
	public abstract NoticeVO select(int noticeNo);
	public abstract int createNotice(NoticeVO vo);
	public abstract int updateNotice(NoticeVO vo);
	public abstract int deleteNotice(int noticeNo);
	
	public abstract List<NoticeVO> read(PageCriteria criteria);
	public abstract int updateNoticeViewCnt(int noticeNo);
	public abstract int getTotalNumsOfRecords();
	public abstract List<NoticeVO> readByNickName(String nickName);
	
	
}
