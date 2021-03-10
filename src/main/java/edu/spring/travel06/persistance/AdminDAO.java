package edu.spring.travel06.persistance;

import java.util.List;

import edu.spring.travel06.domain.*;

public interface AdminDAO 
{
	public abstract int insert(AdminVO avo);
	public abstract int update(AdminVO avo);
	public abstract List<AdminVO> select();
	public abstract int delete(String adminID);
	
	
	public abstract AdminVO select(String adminID);
	
	
}
