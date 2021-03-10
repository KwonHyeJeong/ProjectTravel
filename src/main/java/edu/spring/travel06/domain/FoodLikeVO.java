package edu.spring.travel06.domain;

public class FoodLikeVO {
	private int foodLikeNo;
	private int foodNo;
	private int mno;
	
	public FoodLikeVO() {
		super();
	}

	public FoodLikeVO(int foodLikeNo, int foodNo, int mno) {
		super();
		this.foodLikeNo = foodLikeNo;
		this.foodNo = foodNo;
		this.mno = mno;
	}

	public int getFoodLikeNo() {
		return foodLikeNo;
	}

	public void setFoodLikeNo(int foodLikeNo) {
		this.foodLikeNo = foodLikeNo;
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
		return "FoodLikeVO [foodLikeNo=" + foodLikeNo + ", foodNo=" + foodNo + ", mno=" + mno + "]";
	}
	
	
	
	
	
}
