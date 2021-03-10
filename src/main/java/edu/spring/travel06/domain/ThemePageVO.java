package edu.spring.travel06.domain;

import java.util.Date;

public class ThemePageVO {
	private int themaNo;
	private String themaTitle;
	private String themaContent;
	private String userNickname;
	private int themaViewCnt;
	private int themaReplyCnt;
	private int themaGoodCnt;
	private int themaWishCnt;
	private Date themaCdate;
	
	private String img;

	
	public ThemePageVO() {
	}

	public int getThemaNo() {
		return themaNo;
	}

	public void setThemaNo(int themaNo) {
		this.themaNo = themaNo;
	}

	public String getThemaTitle() {
		return themaTitle;
	}

	public void setThemaTitle(String themaTitle) {
		this.themaTitle = themaTitle;
	}

	public String getThemaContent() {
		return themaContent;
	}

	public void setThemaContent(String themaContent) {
		this.themaContent = themaContent;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public int getThemaViewCnt() {
		return themaViewCnt;
	}

	public void setThemaViewCnt(int themaViewCnt) {
		this.themaViewCnt = themaViewCnt;
	}

	public int getThemaReplyCnt() {
		return themaReplyCnt;
	}

	public void setThemaReplyCnt(int themaReplyCnt) {
		this.themaReplyCnt = themaReplyCnt;
	}

	public int getThemaGoodCnt() {
		return themaGoodCnt;
	}

	public void setThemaGoodCnt(int themaGoodCnt) {
		this.themaGoodCnt = themaGoodCnt;
	}

	public int getThemaWishCnt() {
		return themaWishCnt;
	}

	public void setThemaWishCnt(int themaWishCnt) {
		this.themaWishCnt = themaWishCnt;
	}

	public Date getThemaCdate() {
		return themaCdate;
	}

	public void setThemaCdate(Date themaCdate) {
		this.themaCdate = themaCdate;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}


	
	@Override
	public String toString() {
		return "ThemePageVO [themaNo=" + themaNo + ", themaTitle=" + themaTitle + ", themaContent=" + themaContent
				+ ", userNickname=" + userNickname + ", themaViewCnt=" + themaViewCnt + ", themaReplyCnt="
				+ themaReplyCnt + ", themaGoodCnt=" + themaGoodCnt + ", themaWishCnt=" + themaWishCnt + ", themaCdate="
				+ themaCdate + ", img=" + img + "]";
	}

	
	
	

	
	
} // end themaPageVO









