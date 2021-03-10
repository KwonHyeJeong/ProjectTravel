package edu.spring.travel06.domain;

public class PlayWishVO 
{
	private int playWishNo;
	private int playNo;
	private int mno;
	
	
	public PlayWishVO(){}
	
	public PlayWishVO(int playWishNo, int playNo, int mno) 
	{
		super();
		this.playWishNo = playWishNo;
		this.playNo = playNo;
		this.mno = mno;
	}
	
	

	public int getPlayWishNo() 
	{
		return playWishNo;
	}

	public void setPlayWishNo(int playWishNo)
	{
		this.playWishNo = playWishNo;
	}

	public int getPlayNo() 
	{
		return playNo;
	}

	public void setPlayNo(int playNo) 
	{
		this.playNo = playNo;
	}

	public int getMno() 
	{
		return mno;
	}

	public void setMno(int mno) 
	{
		this.mno = mno;
	}

	@Override
	public String toString() 
	{
		return "PlayWishVO [playWishNo=" + playWishNo + ", playNo=" + playNo + ", mno=" + mno + "]";
	}
	
	
	
	
	
}
