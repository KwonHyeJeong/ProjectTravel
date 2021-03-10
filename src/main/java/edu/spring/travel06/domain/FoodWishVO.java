package edu.spring.travel06.domain;

public class FoodWishVO 
{
	private int foodWishNo;
	private int foodNo;
	private int mno;
	
	
	public FoodWishVO() 
	{
		super();
	}
	
	public FoodWishVO(int foodWishNo, int foodNo, int mno) 
	{
		super();
		this.foodWishNo = foodWishNo;
		this.foodNo = foodNo;
		this.mno = mno;
	}
	
	public int getFoodWishNo() {
		return foodWishNo;
	}
	public void setFoodWishNo(int foodWishNo) {
		this.foodWishNo = foodWishNo;
	}
	public int getFoodNo() {
		return foodNo;
	}
	public void setFoodNo(int foodNo) {
		this.foodNo = foodNo;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	
	
	@Override
	public String toString() {
		return "FoodWishVO [foodWishNo=" + foodWishNo + ", foodNo=" + foodNo + ", mno=" + mno + "]";
	}
	
	
	
}
