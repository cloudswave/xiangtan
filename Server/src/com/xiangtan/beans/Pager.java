package com.xiangtan.beans;

public class Pager {
	private int currentPage=1;//当前页码
	private int pageSize=15;// 每页显示多少
    //private int pageNo ;// 页码
    private int totalCount;// 总记录数
    private int totalPage;// 总页数
    
    public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
    
    public int getCurrentPage() {
		return currentPage;
	}
    
	public int getPageSize() {
		return pageSize;
	}
//	public int getPageNo() {
//		return pageNo;
//	}
	public int getTotalCount() {
		return totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
//	public void setPageNo(int pageNo) {
//		this.pageNo = pageNo;
//	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public String toString() {
        return "当前第"+currentPage+"页，每页显示"+this.pageSize+"条。共"+this.totalCount+"条记录，一共"+this.totalPage+"页。";
    }
}
