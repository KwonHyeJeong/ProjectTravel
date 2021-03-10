package edu.spring.travel06.domain;

import java.util.Date;
import java.util.List;

public class FreePageVO {
	private int freeNo;
	private String freeTitle;
	private String freeContent;
	private String userNickname;
	private int freeViewCnt;
	private int freeReplyCnt;
	private int freeGoodCnt;
	private int freeWishCnt;
	private Date freeCdate;
	
	public FreePageVO() {}
	


	public FreePageVO(int freeNo, String freeTitle, String freeContent, String userNickname, int freeViewCnt,
			int freeReplyCnt, int freeGoodCnt, int freeWishCnt, Date freeCdate) {
		super();
		this.freeNo = freeNo;
		this.freeTitle = freeTitle;
		this.freeContent = freeContent;
		this.userNickname = userNickname;
		this.freeViewCnt = freeViewCnt;
		this.freeReplyCnt = freeReplyCnt;
		this.freeGoodCnt = freeGoodCnt;
		this.freeWishCnt = freeWishCnt;
		this.freeCdate = freeCdate;
	}

	public int getFreeNo() {
		return freeNo;
	}

	public void setFreeNo(int freeNo) {
		this.freeNo = freeNo;
	}

	public String getFreeTitle() {
		return freeTitle;
	}

	public void setFreeTitle(String freeTitle) {
		this.freeTitle = freeTitle;
	}

	public String getFreeContent() {
		return freeContent;
	}

	public void setFreeContent(String freeContent) {
		this.freeContent = freeContent;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public int getFreeViewCnt() {
		return freeViewCnt;
	}

	public void setFreeViewCnt(int freeViewCnt) {
		this.freeViewCnt = freeViewCnt;
	}

	public int getFreeReplyCnt() {
		return freeReplyCnt;
	}

	public void setFreeReplyCnt(int freeReplyCnt) {
		this.freeReplyCnt = freeReplyCnt;
	}

	public int getFreeGoodCnt() {
		return freeGoodCnt;
	}

	public void setFreeGoodCnt(int freeGoodCnt) {
		this.freeGoodCnt = freeGoodCnt;
	}

	public int getFreeWishCnt() {
		return freeWishCnt;
	}

	public void setFreeWishCnt(int freeWishCnt) {
		this.freeWishCnt = freeWishCnt;
	}

	public Date getFreeCdate() {
		return freeCdate;
	}

	public void setFreeCdate(Date freeCdate) {
		this.freeCdate = freeCdate;
	}
	
	

	@Override
	public String toString() {
		return "FreePageVO [freeNo=" + freeNo + ", freeTitle=" + freeTitle + ", freeContent=" + freeContent
				+ ", userNickname=" + userNickname + ", freeViewCnt=" + freeViewCnt + ", freeReplyCnt=" + freeReplyCnt
				+ ", freeGoodCnt=" + freeGoodCnt + ", freeWishCnt=" + freeWishCnt + ", freeCdate=" + freeCdate + "]";
	}

	
	
	
	
	
	
}
