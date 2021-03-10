package edu.spring.travel06.domain;

public class FreeWishVO 
{
	private int freeWishNo;
	private int freeNo;
	private int mno;
	
	
	public FreeWishVO() 
	{
		super();
	}
	
	
	
	public FreeWishVO(int freeWishNo, int freeNo, int mno) 
	{
		super();
		this.freeWishNo = freeWishNo;
		this.freeNo = freeNo;
		this.mno = mno;
	}



	public int getFreeWishNo() 
	{
		return freeWishNo;
	}


	public void setFreeWishNo(int freeWishNo) 
	{
		this.freeWishNo = freeWishNo;
	}


	public int getFreeNo() 
	{
		return freeNo;
	}


	public void setFreeNo(int freeNo) 
	{
		this.freeNo = freeNo;
	}


	public int getMno() {
		return mno;
	}


	public void setMno(int mno) 
	{
		this.mno = mno;
	}
	
	
	
	@Override
	public String toString() 
	{
		return "FreeWishVO [freeWishNo=" + freeWishNo + ", freeNo=" + freeNo + ", mno=" + mno + "]";
	}
	
	
	
	
}
