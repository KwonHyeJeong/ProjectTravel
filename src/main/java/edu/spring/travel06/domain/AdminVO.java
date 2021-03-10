package edu.spring.travel06.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class AdminVO
{
	private int adminNo;
	private String adminName;
	private String adminID;
	private String adminPWD;
	private String adminPhone;
	private String adminCompany;
	private String adminEmail;
	private Date adminBirth;

	
	public AdminVO() {}

	public AdminVO(int adminNo, String adminName, String adminID, String adminPWD, String adminPhone,
			String adminCompany, String adminEmail, Date adminBirth) {
		super();
		this.adminNo = adminNo;
		this.adminName = adminName;
		this.adminID = adminID;
		this.adminPWD = adminPWD;
		this.adminPhone = adminPhone;
		this.adminCompany = adminCompany;
		this.adminEmail = adminEmail;
		this.adminBirth = adminBirth;
		
	}

	public int getAdminNo() {
		return adminNo;
	}

	public void setAdminNo(int adminNo) {
		this.adminNo = adminNo;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminID() {
		return adminID;
	}

	public void setAdminID(String adminID) {
		this.adminID = adminID;
	}

	public String getAdminPWD() {
		return adminPWD;
	}

	public void setAdminPWD(String adminPWD) {
		this.adminPWD = adminPWD;
	}

	public String getAdminPhone() {
		return adminPhone;
	}

	public void setAdminPhone(String adminPhone) {
		this.adminPhone = adminPhone;
	}

	public String getAdminCompany() {
		return adminCompany;
	}

	public void setAdminCompany(String adminCompany) {
		this.adminCompany = adminCompany;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public Date getAdminBirth() {
		return adminBirth;
	}

	public void setAdminBirth(Date adminBirth) {
		this.adminBirth = adminBirth;
	}

	@Override
	public String toString() {
		return "AdminVO [adminNo=" + adminNo + ", adminName=" + adminName + ", adminID=" + adminID + ", adminPWD="
				+ adminPWD + ", adminPhone=" + adminPhone + ", adminCompany=" + adminCompany + ", adminEmail="
				+ adminEmail + ", adminBirth=" + adminBirth + "]";
	}

	
	

	
	
	
	
	
}
