package com.ihk.utils.xls;

import java.io.Serializable;

import jxl.Cell;

/**
 * 输出xls异常数据pojo
 * @author dtc
 * 2013-12-5,上午11:49:26
 */
public class WriteExceptionDataPojo implements Serializable{

	private static final long serialVersionUID = 5409360297561194553L;
	
	/**
	 * 对应的数据行
	 */
	private Cell[] cell;
	
	/**
	 * 异常信息
	 */
	private String exceptionData;

	public Cell[] getCell() {
		return cell;
	}

	public void setCell(Cell[] cell) {
		this.cell = cell;
	}

	public String getExceptionData() {
		return exceptionData;
	}

	public void setExceptionData(String exceptionData) {
		this.exceptionData = exceptionData;
	}

	public WriteExceptionDataPojo(Cell[] cell, String exceptionData) {
		super();
		this.cell = cell;
		this.exceptionData = exceptionData;
	}
	
	public WriteExceptionDataPojo() {
		super();
	}

}
