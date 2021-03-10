package edu.spring.travel06.domain;

public class PlayLikeVO {
	private int playLikeNo;
	private int playNo;
	private int mno;
	
	public PlayLikeVO() {
		super();
	}

	public PlayLikeVO(int playLikeNo, int playNo, int mno) {
		super();
		this.playLikeNo = playLikeNo;
		this.playNo = playNo;
		this.mno = mno;
	}

	public int getPlayLikeNo() {
		return playLikeNo;
	}

	public void setPlayLikeNo(int playLikeNo) {
		this.playLikeNo = playLikeNo;
	}

	public int getPlayNo() {
		return playNo;
	}

	public void setPlayNo(int playNo) {
		this.playNo = playNo;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	@Override
	public String toString() {
		return "PlayLikeVO [playLikeNo=" + playLikeNo + ", playNo=" + playNo + ", mno=" + mno + "]";
	}

	
	
	
}
