package com.ihk.utils;

import java.io.Serializable;

/**
 * 查询分页条件的基础类
 * @author dtc
 * 2012-9-29
 */
public class SearchCond implements Serializable{
	
	private static final long serialVersionUID = -2983555498503732819L;
	
	public int topNum;	//前几条
	public int startLine;
	public int pageSize;
	public int recordCount;
	public int operUserId;//操作人员id
	public int recordId;//数据库记录id
	
	/**
	 * 非easyui异步版本的排序，这里写的太死板，例如写的是11,12之类的代码
	 * 修改为order,sort的组合使用
	 * @deprecated
	 */
	private String orderByFiled; //排序的字段和方式

	/**
	 * 升序或降序
	 */
	private String order;
	
	/**
	 * 排序字段
	 */
	private String sort;
	
	public SearchCond(){}
	
	public int getOperUserId() {
		if(operUserId<=0){
			try{
				operUserId=SessionUser.getUserId();
			}
			catch (Exception e) {
			}
		}
		return operUserId;
	}

	public void setOperUserId(int operUserId) {
		this.operUserId = operUserId;
	}

	public int getRecordId() {
		return recordId;
	}

	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}

	public String getOrderByFiled() {
		return orderByFiled;
	}

	public void setOrderByFiled(String orderByFiled) {
		this.orderByFiled = orderByFiled;
	}
	
	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getSupperString(){
		String cacheKey = String.valueOf(startLine)+String.valueOf(pageSize)+orderByFiled+order+sort;	
			
		return cacheKey;
	}
	
}
