package edu.spring.travel06.pageutil;

//브라우저에서 보여질 페이지 번호와
//한 페이지에서 보여질 게시글의 개수를 저장하는 클래스
//-> paging 처리에 필요한 start와 end 번호를 알 수 있음
public class PageCriteria {
	private int page; // 현재 페이지 번호
	private int numsPerPage; // 한 페이지의 게시글 개수
	
	private String type;
	private String keyword;
	
	public PageCriteria() {
		this.page = 1;
		this.numsPerPage = 10;
		this.type = null;
		this.keyword = null;
	}
	
	public PageCriteria(int page, int numsPerPage) {
		this.page = page;
		this.numsPerPage = numsPerPage;
	}

	// getter/setter
	public int getPage() {
		return page;
	}
	
	public void setPage(int page) {
		this.page = page;
	}
	
	public int getNumsPerPage() {
		return numsPerPage;
	}
	
	public void setNumsPerPage(int numsPerPage) {
		this.numsPerPage = numsPerPage;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	// 현재 보여지는 페이지의 시작 글 일련번호(rn)
	public int getStart() {
		return (this.page - 1) * this.numsPerPage + 1;
	}


	// 현재 보여지는 페이지의 마지막 글 일련번호(rn)
	public int getEnd() {
		return this.page * this.numsPerPage;
	}

	@Override
	public String toString() {
		return "PageCriteria [page=" + page + ", numsPerPage=" + numsPerPage + ", type=" + type + ", keyword=" + keyword
				+ "]";
	}
	
//	// 검색조건을 배열로 만들어 한번에 처리
//	public String[] getTypeArr() {
//		return type == null? new String[] {}: type.split("");
//	}
	
}



