package edu.spring.travel06.domain;

public class ThemeWishVO 
{
	private int themaWishNo;
	private int themaNo;
	private int mno;
	
	
	public ThemeWishVO() {}
	
	public ThemeWishVO(int themaWishNo, int themaNo, int mno) 
	{
		super();
		this.themaWishNo = themaWishNo;
		this.themaNo = themaNo;
		this.mno = mno;
	}
	
	

	
	public int getThemaWishNo() {
		return themaWishNo;
	}

	public void setThemaWishNo(int themaWishNo) {
		this.themaWishNo = themaWishNo;
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
	public String toString() 
	{
		return "ThemeWishVO [themaWishNo=" + themaWishNo + ", themaNo=" + themaNo + ", mno=" + mno + "]";
	}
	
	
	
	
}
