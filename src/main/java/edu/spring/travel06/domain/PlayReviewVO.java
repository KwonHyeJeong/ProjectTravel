package edu.spring.travel06.domain;

import java.util.Date;

public class PlayReviewVO {
	private int playReviewNo;
	private int playNo;
	private String userNickname;
	private String playReviewContent;
	private Date playReviewCdate;
	
	public PlayReviewVO() {}

	public PlayReviewVO(int playReviewNo, int playNo, String userNickname, String playReviewContent,
			Date playReviewCdate) {
		super();
		this.playReviewNo = playReviewNo;
		this.playNo = playNo;
		this.userNickname = userNickname;
		this.playReviewContent = playReviewContent;
		this.playReviewCdate = playReviewCdate;
	}

	public int getPlayReviewNo() {
		return playReviewNo;
	}

	public void setPlayReviewNo(int playReviewNo) {
		this.playReviewNo = playReviewNo;
	}

	public int getPlayNo() {
		return playNo;
	}

	public void setPlayNo(int playNo) {
		this.playNo = playNo;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public String getPlayReviewContent() {
		return playReviewContent;
	}

	public void setPlayReviewContent(String playReviewContent) {
		this.playReviewContent = playReviewContent;
	}

	public Date getPlayReviewCdate() {
		return playReviewCdate;
	}

	public void setPlayReviewCdate(Date playReviewCdate) {
		this.playReviewCdate = playReviewCdate;
	}

	@Override
	public String toString() {
		return "PlayReviewVO [playReviewNo=" + playReviewNo + ", playNo=" + playNo + ", userNickname=" + userNickname
				+ ", playReviewContent=" + playReviewContent + ", playReviewCdate=" + playReviewCdate + "]";
	}

	
	
}
