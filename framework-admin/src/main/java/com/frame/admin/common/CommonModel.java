package com.frame.admin.common;

/**
 * 
 * 公共实体类
 *
 */
public class CommonModel {
	private int pageStart=0; // mysql分页参数 起始数
	private int pageSize=20; // 每页大小
	public int getPageStart() {
		return pageStart;
	}
	public void setPageStart(int pageStart) {
		this.pageStart = pageStart;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	
}
