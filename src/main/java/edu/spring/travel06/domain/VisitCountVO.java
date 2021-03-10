package edu.spring.travel06.domain;

public class VisitCountVO {
	private int visitId;
    private int visitTime;

    
    
	public VisitCountVO() {
		super();
	}



	public VisitCountVO(int visitId, int visitTime) {
		super();
		this.visitId = visitId;
		this.visitTime = visitTime;
	}



	public int getVisitId() {
		return visitId;
	}



	public void setVisitId(int visitId) {
		this.visitId = visitId;
	}



	public int getVisitTime() {
		return visitTime;
	}



	public void setVisitTime(int visitTime) {
		this.visitTime = visitTime;
	}



	@Override
	public String toString() {
		return "VisitCountVO [visitId=" + visitId + ", visitTime=" + visitTime + "]";
	}
	
	



}
