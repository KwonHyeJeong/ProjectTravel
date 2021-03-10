package edu.spring.travel06.domain;

import java.util.Date;

public class FoodReviewVO {
	private int foodReviewNo;
	private int foodNo;
	private String userNickname;
	private String foodReviewContent;
	private Date foodReviewCdate;
	
	public FoodReviewVO() {}

	public FoodReviewVO(int foodReviewNo, int foodNo, String userNickname, String foodReviewContent,
			Date foodReviewCdate) {
		super();
		this.foodReviewNo = foodReviewNo;
		this.foodNo = foodNo;
		this.userNickname = userNickname;
		this.foodReviewContent = foodReviewContent;
		this.foodReviewCdate = foodReviewCdate;
	}

	public int getFoodReviewNo() {
		return foodReviewNo;
	}

	public void setFoodReviewNo(int foodReviewNo) {
		this.foodReviewNo = foodReviewNo;
	}

	public int getFoodNo() {
		return foodNo;
	}

	public void setFoodNo(int foodNo) {
		this.foodNo = foodNo;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public String getFoodReviewContent() {
		return foodReviewContent;
	}

	public void setFoodReviewContent(String foodReviewContent) {
		this.foodReviewContent = foodReviewContent;
	}

	public Date getFoodReviewCdate() {
		return foodReviewCdate;
	}

	public void setFoodReviewCdate(Date foodReviewCdate) {
		this.foodReviewCdate = foodReviewCdate;
	}

	@Override
	public String toString() {
		return "FoodReviewVO [foodReviewNo=" + foodReviewNo + ", foodNo=" + foodNo + ", userNickname=" + userNickname
				+ ", foodReviewContent=" + foodReviewContent + ", foodReviewCdate=" + foodReviewCdate + "]";
	}
	
	
	
}
