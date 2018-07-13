package com.zwh.system.entity;

import java.io.Serializable;

/**
 *分页
 */
public class PageVO implements Serializable {


	private int page=1;//页码
	
	private int rows=10;//每页显示条数
	
	private int startIndex;//�??始索�??
	
	private int endIndex;//结束索引
	
	private int total;//总记录数
	
	private int pageNumber=1;
	
	private int pageSize=10;
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getStartIndex() {
		return startIndex=(page-1)*rows+0;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	public int getEndIndex() {
//		return total==0?page*rows:(page*rows>total?total:page*rows);
		return rows;
	}
	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
		this.page = pageNumber;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
		this.rows = pageSize;
	}
	
}
