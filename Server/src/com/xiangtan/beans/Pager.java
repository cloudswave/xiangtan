package com.xiangtan.beans;

public class Pager {
	private int currentPage=1;//��ǰҳ��
	private int pageSize=15;// ÿҳ��ʾ����
    //private int pageNo ;// ҳ��
    private int totalCount;// �ܼ�¼��
    private int totalPage;// ��ҳ��
    
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
        return "��ǰ��"+currentPage+"ҳ��ÿҳ��ʾ"+this.pageSize+"������"+this.totalCount+"����¼��һ��"+this.totalPage+"ҳ��";
    }
}
