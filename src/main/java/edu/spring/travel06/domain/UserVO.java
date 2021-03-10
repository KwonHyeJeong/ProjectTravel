package edu.spring.travel06.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserVO
{
	private int userNo;
	private String userName;
	private String userID;
	private String userPWD;
	private String userEmail;
	private String userPhone;
	private Date userBirth;
	private String userNickName;
	private int userWarning;
	
	


	public UserVO() {}
	
	
	public UserVO(int userNo, String userName, String userID, String userPWD, String userEmail, String userPhone,
			Date userBirth, String userNickName, int userWarning) {
		super();
		this.userNo = userNo;
		this.userName = userName;
		this.userID = userID;
		this.userPWD = userPWD;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.userBirth = userBirth;
		this.userNickName = userNickName;
		this.userWarning = userWarning;
	
		
	}
	public UserVO(String userName, Date userBirth, String userPhone)
	{
		this.userName = userName;
		this.userBirth = userBirth;
		this.userPhone = userPhone;
		
	}


	public int getUserNo() 
	{
		return userNo;
	}


	public void setUserNo(int userNo) 
	{
		this.userNo = userNo;
	}


	public String getUserName() 
	{
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserID() {
		return userID;
	}


	public void setUserID(String userID) {
		this.userID = userID;
	}


	public String getUserPWD() {
		return userPWD;
	}


	public void setUserPWD(String userPWD) {
		this.userPWD = userPWD;
	}


	public String getUserEmail() {
		return userEmail;
	}


	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}


	public String getUserPhone() {
		return userPhone;
	}


	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}


	public Date getUserBirth() {
		return userBirth;
	}


	public void setUserBirth(Date userBirth) {
		this.userBirth = userBirth;
	}


	public String getUserNickName() {
		return userNickName;
	}


	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}


	public int getUserWarning() {
		return userWarning;
	}


	public void setUserWarning(int userWarning) {
		this.userWarning = userWarning;
	}
	
	

	@Override
	public String toString() {
		return "UserVO [userNo=" + userNo + ", userName=" + userName + ", userID=" + userID + ", userPWD=" + userPWD
				+ ", userEmail=" + userEmail + ", userPhone=" + userPhone + ", userBirth=" + userBirth
				+ ", userNickName=" + userNickName + ", userWarning=" + userWarning + "]";
	}


	
	
	
	
}
