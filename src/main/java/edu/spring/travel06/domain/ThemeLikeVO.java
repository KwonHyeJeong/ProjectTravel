package edu.spring.travel06.domain;

public class ThemeLikeVO {
	private int themaLikeNo;
	private int themaNo;
	private int mno;
	
	public ThemeLikeVO() {
		super();
	}

	public ThemeLikeVO(int themaLikeNo, int themaNo, int mno) {
		super();
		this.themaLikeNo = themaLikeNo;
		this.themaNo = themaNo;
		this.mno = mno;
	}

	

	public int getThemaLikeNo() {
		return themaLikeNo;
	}

	public void setThemaLikeNo(int themaLikeNo) {
		this.themaLikeNo = themaLikeNo;
	}

	public int getThemaNo() {
		return themaNo;
	}

	public void setThemaNo(int themaNo) {
		this.themaNo = themaNo;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	@Override
	public String toString() {
		return "ThemeLikeVO [themaLikeNo=" + themaLikeNo + ", themaNo=" + themaNo + ", mno=" + mno + "]";
	}

	

	
}
