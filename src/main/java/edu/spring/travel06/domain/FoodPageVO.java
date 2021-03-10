package edu.spring.travel06.domain;

import java.util.Date;

public class FoodPageVO {
	private int foodNo;
	private String foodTitle;
	private String foodContent;
	private String userNickname;
	private int foodViewCnt;
	private int foodReplyCnt;
	private int foodGoodCnt;
	private int foodWishCnt;
	private Date foodCdate;
	
	private String img;
	
	public FoodPageVO() {
	}

	public FoodPageVO(int foodNo, String foodTitle, String foodContent, String userNickname, int foodViewCnt,
			int foodReplyCnt, int foodGoodCnt, int foodWishCnt, Date foodCdate, String img) {
		super();
		this.foodNo = foodNo;
		this.foodTitle = foodTitle;
		this.foodContent = foodContent;
		this.userNickname = userNickname;
		this.foodViewCnt = foodViewCnt;
		this.foodReplyCnt = foodReplyCnt;
		this.foodGoodCnt = foodGoodCnt;
		this.foodWishCnt = foodWishCnt;
		this.foodCdate = foodCdate;
		this.img = img;
	}

	public int getFoodNo() {
		return foodNo;
	}

	public void setFoodNo(int foodNo) {
		this.foodNo = foodNo;
	}

	public String getFoodTitle() {
		return foodTitle;
	}

	public void setFoodTitle(String foodTitle) {
		this.foodTitle = foodTitle;
	}

	public String getFoodContent() {
		return foodContent;
	}

	public void setFoodContent(String foodContent) {
		this.foodContent = foodContent;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public int getFoodViewCnt() {
		return foodViewCnt;
	}

	public void setFoodViewCnt(int foodViewCnt) {
		this.foodViewCnt = foodViewCnt;
	}

	public int getFoodReplyCnt() {
		return foodReplyCnt;
	}

	public void setFoodReplyCnt(int foodReplyCnt) {
		this.foodReplyCnt = foodReplyCnt;
	}

	public int getFoodGoodCnt() {
		return foodGoodCnt;
	}

	public void setFoodGoodCnt(int foodGoodCnt) {
		this.foodGoodCnt = foodGoodCnt;
	}

	public int getFoodWishCnt() {
		return foodWishCnt;
	}

	public void setFoodWishCnt(int foodWishCnt) {
		this.foodWishCnt = foodWishCnt;
	}

	public Date getFoodCdate() {
		return foodCdate;
	}

	public void setFoodCdate(Date foodCdate) {
		this.foodCdate = foodCdate;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}


	@Override
	public String toString() {
		return "FoodPageVO [foodNo=" + foodNo + ", foodTitle=" + foodTitle + ", foodContent=" + foodContent
				+ ", userNickname=" + userNickname + ", foodViewCnt=" + foodViewCnt + ", foodReplyCnt=" + foodReplyCnt
				+ ", foodGoodCnt=" + foodGoodCnt + ", foodWishCnt=" + foodWishCnt + ", foodCdate=" + foodCdate
				+ ", img=" + img + "]";
	}
	
	

	
	
} // end FoodPageVO









