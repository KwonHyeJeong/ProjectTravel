package edu.spring.travel06.domain;

public class BoardLikeVO {
	private int boardlikeno;
	private int boardno;
	private int mno;
	
	public BoardLikeVO() {}
	
	public BoardLikeVO(int boardlikeno, int boardno, int mno) {
		super();
		this.boardlikeno = boardlikeno;
		this.boardno = boardno;
		this.mno = mno;
	}
	
	public int getBoardlikeno() {
		return boardlikeno;
	}
	public void setBoardlikeno(int boardlikeno) {
		this.boardlikeno = boardlikeno;
	}
	public int getBoardno() {
		return boardno;
	}
	public void setBoardno(int boardno) {
		this.boardno = boardno;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}

	@Override
	public String toString() {
		return "BoardLikeVO [boardlikeno=" + boardlikeno + ", boardno=" + boardno + ", mno=" + mno + "]";
	}
	
	
	

}
