package edu.spring.travel06.service;

import java.util.List;

import edu.spring.travel06.domain.*;
import edu.spring.travel06.pageutil.*;


// CRUD(CREATE, READ, UPDATE, DELETE)
public interface VisitCountService {
	
	public abstract int insertVisit(VisitCountVO vo);
	public abstract int totalVisit(VisitCountVO vo);
	public abstract int todayVisit(VisitCountVO vo);
	

}
















