package edu.spring.travel06.persistance;

import java.util.List;

import edu.spring.travel06.domain.*;
import edu.spring.travel06.pageutil.PageCriteria;



public interface UserDAO 
{
	public abstract int insert(UserVO uvo);
	public abstract List<UserVO> select();
	public abstract int update(UserVO uvo);
	public abstract int delete(String userID);
	public abstract List<UserVO> select(PageCriteria criteria);
	
	public abstract UserVO select(String userID);
	
	public abstract int updateWarnCount(int amount, int userNo);
	public abstract int getTotalNumsOfRecords();
	
	
	
}
