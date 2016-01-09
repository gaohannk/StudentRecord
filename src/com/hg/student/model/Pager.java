package com.hg.student.model;

import java.util.List;

public class Pager<T> {
	private int pagesize; // record size in one page

	private int currentPage; // current page number

	private int totalRecord; // total record

	private int totalPage;

	private List<T> datalist;

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<T> getDatalist() {
		return datalist;
	}

	public void setDatalist(List<T> datalist) {
		this.datalist = datalist;
	}

	public Pager(List<T> sourceList, int pageSize, int pageNum) {
		if (sourceList != null) {
			this.totalRecord = sourceList.size();
			this.totalPage = this.totalRecord % pageSize == 0 ? this.totalRecord / pageSize
					: this.totalRecord / pageSize + 1;
			this.currentPage = this.totalPage < pageNum ? pageNum : this.totalPage;
			int from = pageSize * (this.currentPage - 1);
			int to = currentPage * pageSize > totalRecord ? totalRecord : currentPage * pageSize;
			this.datalist = sourceList.subList(from, to);
		}
	}

}
