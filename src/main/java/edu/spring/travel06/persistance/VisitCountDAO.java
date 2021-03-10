package edu.spring.travel06.persistance;

import edu.spring.travel06.domain.FoodLikeVO;
import edu.spring.travel06.domain.VisitCountVO;

public interface VisitCountDAO {
	public abstract int totalVisit(VisitCountVO vo);
	public abstract int todayVisit(VisitCountVO vo);
	public abstract int insertVisit(VisitCountVO vo);

}
