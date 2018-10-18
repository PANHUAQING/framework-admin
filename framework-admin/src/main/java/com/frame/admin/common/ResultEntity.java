package com.frame.admin.common;

import java.io.Serializable;
import java.util.List;

/**
 * 结果集方法实体类 
 * @author panhuqing
 *
 */
public class ResultEntity implements Serializable {
	
	private String  resultCode; //返回编码
	private String  resultMsg;  //返回信息
	private List    resultRows; //返回集合数据
	private  int   resultRowsTotal;//总数
	
	
	
	public ResultEntity() {
		super();
	}
	public ResultEntity(String resultCode, String resultMsg, List resultRows, int resultRowsTotal) {
		super();
		this.resultCode = resultCode;
		this.resultMsg = resultMsg;
		this.resultRows = resultRows;
		this.resultRowsTotal = resultRowsTotal;
	}
	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	public String getResultMsg() {
		return resultMsg;
	}
	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}
	public List getResultRows() {
		return resultRows;
	}
	public void setResultRows(List resultRows) {
		this.resultRows = resultRows;
	}
	public int getResultRowsTotal() {
		return resultRowsTotal;
	}
	public void setResultRowsTotal(int resultRowsTotal) {
		this.resultRowsTotal = resultRowsTotal;
	}
	
	
	
	
}
