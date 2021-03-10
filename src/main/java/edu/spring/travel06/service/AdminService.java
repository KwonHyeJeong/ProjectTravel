package edu.spring.travel06.service;

import java.util.List;

import edu.spring.travel06.domain.*;


public interface AdminService 
{
	public abstract List<AdminVO> read();

	public abstract int create(AdminVO avo);
	public abstract int update(AdminVO avo);
	public abstract int delete(String adminID);
	
	
	public abstract AdminVO read(String adminID) throws NullPointerException;
	
	
}
