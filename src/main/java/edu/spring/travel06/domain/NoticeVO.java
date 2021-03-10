package edu.spring.travel06.domain;

import java.util.Date;

public class NoticeVO 
{
	private int noticeNo;
	private String noticeTitle;
	private String noticeContent;
	private String noticeUserNickname;
	private int noticeViewCnt;
	private int noticeReplyCnt;
	private Date noticeCdate;
	
	
	
	public NoticeVO() {}



	public NoticeVO(int noticeNo, String noticeTitle, String noticeContent, String noticeUserNickname, int noticeViewCnt,
			int noticeReplyCnt, Date noticeCdate) 
	{
		super();
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.noticeUserNickname = noticeUserNickname;
		this.noticeViewCnt = noticeViewCnt;
		this.noticeReplyCnt = noticeReplyCnt;
		this.noticeCdate = noticeCdate;
	}






	public int getNoticeNo() 
	{
		return noticeNo;
	}



	public void setNoticeNo(int noticeNo) 
	{
		this.noticeNo = noticeNo;
	}



	public String getNoticeTitle() 
	{
		return noticeTitle;
	}



	public void setNoticeTitle(String noticeTitle) 
	{
		this.noticeTitle = noticeTitle;
	}



	public String getNoticeContent() {
		return noticeContent;
	}



	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}



	public String getNoticeUserNickname() {
		return noticeUserNickname;
	}



	public void setNoticeUserNickname(String noticeUserNickname) {
		this.noticeUserNickname = noticeUserNickname;
	}



	public int getNoticeViewCnt() {
		return noticeViewCnt;
	}



	public void setNoticeViewCnt(int noticeViewCnt) {
		this.noticeViewCnt = noticeViewCnt;
	}



	public int getNoticeReplyCnt() {
		return noticeReplyCnt;
	}



	public void setNoticeReplyCnt(int noticeReplyCnt) {
		this.noticeReplyCnt = noticeReplyCnt;
	}



	public Date getNoticeCdate() {
		return noticeCdate;
	}



	public void setNoticeCdate(Date noticeCdate) {
		this.noticeCdate = noticeCdate;
	}


	
}
