package edu.spring.travel06.domain;

import java.util.Date;

public class PlayPageVO {
	private int playNo;
	private String playTitle;
	private String playContent;
	private String userNickname;
	private int playViewCnt;
	private int playReplyCnt;
	private int playGoodCnt;
	private int playWishCnt;
	private Date playCdate;
	
	private String img;
	
	public PlayPageVO() {
	}

	public PlayPageVO(int playNo, String playTitle, String playContent, String userNickname, int playViewCnt,
			int playReplyCnt, int playGoodCnt, int playWishCnt, Date playCdate, String img) {
		super();
		this.playNo = playNo;
		this.playTitle = playTitle;
		this.playContent = playContent;
		this.userNickname = userNickname;
		this.playViewCnt = playViewCnt;
		this.playReplyCnt = playReplyCnt;
		this.playGoodCnt = playGoodCnt;
		this.playWishCnt = playWishCnt;
		this.playCdate = playCdate;
		this.img = img;

	}

	public int getPlayNo() {
		return playNo;
	}

	public void setPlayNo(int playNo) {
		this.playNo = playNo;
	}

	public String getPlayTitle() {
		return playTitle;
	}

	public void setPlayTitle(String playTitle) {
		this.playTitle = playTitle;
	}

	public String getPlayContent() {
		return playContent;
	}

	public void setPlayContent(String playContent) {
		this.playContent = playContent;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public int getPlayViewCnt() {
		return playViewCnt;
	}

	public void setPlayViewCnt(int playViewCnt) {
		this.playViewCnt = playViewCnt;
	}

	public int getPlayReplyCnt() {
		return playReplyCnt;
	}

	public void setPlayReplyCnt(int playReplyCnt) {
		this.playReplyCnt = playReplyCnt;
	}

	public int getPlayGoodCnt() {
		return playGoodCnt;
	}

	public void setPlayGoodCnt(int playGoodCnt) {
		this.playGoodCnt = playGoodCnt;
	}

	public int getPlayWishCnt() {
		return playWishCnt;
	}

	public void setPlayWishCnt(int playWishCnt) {
		this.playWishCnt = playWishCnt;
	}

	public Date getPlayCdate() {
		return playCdate;
	}

	public void setPlayCdate(Date playCdate) {
		this.playCdate = playCdate;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}



	@Override
	public String toString() {
		return "PlayPageVO [playNo=" + playNo + ", playTitle=" + playTitle + ", playContent=" + playContent
				+ ", userNickname=" + userNickname + ", playViewCnt=" + playViewCnt + ", playReplyCnt=" + playReplyCnt
				+ ", playGoodCnt=" + playGoodCnt + ", playWishCnt=" + playWishCnt + ", playCdate=" + playCdate
				+ ", img=" + img +"]";
	}
	
	

	
	

	
	
} // end FoodPageVO









