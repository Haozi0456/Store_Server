package com.zwh.system.entity;

import java.io.Serializable;
import java.util.List;

public class PageResult<E> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int total;
	
	private List<E> rows;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<? extends E> getRows() {
		return rows;
	}

	public void setRows(List<E> rows) {
		this.rows = rows;
	}

	
}
