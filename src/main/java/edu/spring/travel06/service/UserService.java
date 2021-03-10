package edu.spring.travel06.service;

import java.util.Date;
import java.util.List;

import edu.spring.travel06.domain.*;
import edu.spring.travel06.pageutil.PageCriteria;


public interface UserService 
{
	// 사용자List 전체 검색
	public abstract List<UserVO> read();

	public abstract int create(UserVO uvo);
	public abstract int update(UserVO uvo);
	public abstract int delete(String userID);
	
	public abstract UserVO read(String userID) throws NullPointerException;
	
	// 신고하기
	public abstract int updateUserWarning(int amount, int userNo);
	public abstract List<UserVO> read(PageCriteria criteria);
	
	public abstract int getTotalNumsOfRecords();
	
	
}
