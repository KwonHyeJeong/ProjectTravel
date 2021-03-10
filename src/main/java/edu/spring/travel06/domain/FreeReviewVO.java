package edu.spring.travel06.domain;

import java.util.Date;

public class FreeReviewVO {
	private int freeReviewNo;
	private int freeNo;
	private String userNickname;
	private String freeReviewContent;
	private Date freeReviewCdate;
	
	public FreeReviewVO() {}
	public FreeReviewVO(int freeReviewNo, int freeNo, String userNickname, String freeReviewContent,
			Date freeReviewCdate) {
		super();
		this.freeReviewNo = freeReviewNo;
		this.freeNo = freeNo;
		this.userNickname = userNickname;
		this.freeReviewContent = freeReviewContent;
		this.freeReviewCdate = freeReviewCdate;
	}


	public int getFreeReviewNo() {
		return freeReviewNo;
	}


	public void setFreeReviewNo(int freeReviewNo) {
		this.freeReviewNo = freeReviewNo;
	}


	public int getFreeNo() {
		return freeNo;
	}


	public void setFreeNo(int freeNo) {
		this.freeNo = freeNo;
	}


	public String getUserNickname() {
		return userNickname;
	}


	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}


	public String getFreeReviewContent() {
		return freeReviewContent;
	}


	public void setFreeReviewContent(String freeReviewContent) {
		this.freeReviewContent = freeReviewContent;
	}


	public Date getFreeReviewCdate() {
		return freeReviewCdate;
	}


	public void setFreeReviewCdate(Date freeReviewCdate) {
		this.freeReviewCdate = freeReviewCdate;
	}


	@Override
	public String toString() {
		return "FreeReplyVO [freeReviewNo=" + freeReviewNo + ", freeNo=" + freeNo + ", userNickname=" + userNickname
				+ ", freeReviewContent=" + freeReviewContent + ", freeReviewCdate=" + freeReviewCdate + "]";
	}

	
	
	
}
