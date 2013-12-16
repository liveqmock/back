package com.ihk.utils.exception;

/**
 * 新建成交或合同的时候,单元应收款部分的异常
 * @author dtc
 * 2013-1-23,下午03:40:03
 */
public class UnitPayBillException extends BaseException{

	private static final long serialVersionUID = 1L;
	
	public UnitPayBillException() {
		this("请先在付款方式中添加明细");
	}
	
	public UnitPayBillException(String message){
		super(message);
	}

}
