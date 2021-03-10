package edu.spring.travel06.domain;

import java.util.Date;

public class ThemeReviewVO {
	private int themaReviewNo;
	private int themaNo;
	private String userNickname;
	private String themaReviewContent;
	private Date themaReviewCdate;
	
	public ThemeReviewVO() {}

	public ThemeReviewVO(int themaReviewNo, int themaNo, String userNickname, String themaReviewContent,
			Date themaReviewCdate) {
		super();
		this.themaReviewNo = themaReviewNo;
		this.themaNo = themaNo;
		this.userNickname = userNickname;
		this.themaReviewContent = themaReviewContent;
		this.themaReviewCdate = themaReviewCdate;
	}

	public int getThemaReviewNo() {
		return themaReviewNo;
	}

	public void setThemaReviewNo(int themaReviewNo) {
		this.themaReviewNo = themaReviewNo;
	}

	public int getThemaNo() {
		return themaNo;
	}

	public void setThemaNo(int themaNo) {
		this.themaNo = themaNo;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public String getThemaReviewContent() {
		return themaReviewContent;
	}

	public void setThemaReviewContent(String themaReviewContent) {
		this.themaReviewContent = themaReviewContent;
	}

	public Date getThemaReviewCdate() {
		return themaReviewCdate;
	}

	public void setThemaReviewCdate(Date themaReviewCdate) {
		this.themaReviewCdate = themaReviewCdate;
	}

	@Override
	public String toString() {
		return "ThemeReviewVO [themaReviewNo=" + themaReviewNo + ", themaNo=" + themaNo + ", userNickname="
				+ userNickname + ", themaReviewContent=" + themaReviewContent + ", themaReviewCdate=" + themaReviewCdate
				+ "]";
	}

	
	
	
}
