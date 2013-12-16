package com.ihk.utils.exception;

/**
 * 单元状态改变日志exception
 * @author dtc
 * 2013-5-2,下午05:13:34
 */
public class UnitOperRecordException extends BaseException{

	private static final long serialVersionUID = 8258487460636363303L;
	
	public UnitOperRecordException() {
		super("单元状态改变日志记录出现异常");
	}

	public UnitOperRecordException(String message) {
		super(message);
	}

	public UnitOperRecordException(String message, Throwable cause) {
		super(message, cause);
	}

	public UnitOperRecordException(Throwable cause) {
		super(cause);
	}

}
