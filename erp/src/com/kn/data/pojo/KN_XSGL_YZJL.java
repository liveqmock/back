package com.kn.data.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class KN_XSGL_YZJL implements Serializable{
	private static final long serialVersionUID = 1L;
	private BigDecimal 认购书ID;
	private Date 业主实际交楼日期;
	private String 备注;
	private String 经办人;
	 
	public KN_XSGL_YZJL() {
	}
	
	public KN_XSGL_YZJL( BigDecimal 认购书ID,
						  Date 业主实际交楼日期,
						  String 备注,
						  String 经办人) {
		super();
		this.认购书ID = 认购书ID;
		this.业主实际交楼日期 = 业主实际交楼日期;
		this.备注 = 备注;
		this.经办人 = 经办人;
	}
	 
	 
	public BigDecimal get认购书ID() {
		return 认购书ID;
	}
	public void set认购书ID(BigDecimal 认购书id) {
		认购书ID = 认购书id;
	}
	public Date get业主实际交楼日期() {
		return 业主实际交楼日期;
	}
	public void set业主实际交楼日期(Date 业主实际交楼日期) {
		this.业主实际交楼日期 = 业主实际交楼日期;
	}
	public String get备注() {
		return 备注;
	}
	public void set备注(String 备注) {
		this.备注 = 备注;
	}
	public String get经办人() {
		return 经办人;
	}
	public void set经办人(String 经办人) {
		this.经办人 = 经办人;
	}
	 
	 
}
