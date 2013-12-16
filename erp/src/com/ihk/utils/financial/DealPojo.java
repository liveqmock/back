package com.ihk.utils.financial;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 临时处理跳bar的类
 * @author dtc
 * 2013-4-19,上午10:59:03
 */
public class DealPojo implements Serializable{

	private static final long serialVersionUID = -5422669257528931937L;

	private String oprF;
	
	private int dataF;
	
	private String oprB;
	
	private int dataB;
	
	private BigDecimal val;

	public String getOprF() {
		return oprF;
	}

	public void setOprF(String oprF) {
		this.oprF = oprF;
	}

	public int getDataF() {
		return dataF;
	}

	public void setDataF(int dataF) {
		this.dataF = dataF;
	}

	public String getOprB() {
		return oprB;
	}

	public void setOprB(String oprB) {
		this.oprB = oprB;
	}

	public int getDataB() {
		return dataB;
	}

	public void setDataB(int dataB) {
		this.dataB = dataB;
	}

	public BigDecimal getVal() {
		return val;
	}

	public void setVal(BigDecimal val) {
		this.val = val;
	}

	public DealPojo(String oprF, int dataF, String oprB, int dataB,
			BigDecimal val) {
		super();
		this.oprF = oprF;
		this.dataF = dataF;
		this.oprB = oprB;
		this.dataB = dataB;
		this.val = val;
	}
	
}
