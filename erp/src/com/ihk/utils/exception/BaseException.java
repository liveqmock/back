package com.ihk.utils.exception;

import java.util.Date;

import com.ihk.utils.CommonUtils;

/**
 * 自定义异常基础类,可以在对应的构造函数中增加log等等
 * @author dtc 
 * 2012-9-13
 */
public class BaseException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BaseException() {
		super();
	}

	public BaseException(String message) {
		super(CommonUtils.getDateLocalString(new Date()) + message);
	}

	public BaseException(String message, Throwable cause) {
		super(new Date() + message, cause);
	}

	public BaseException(Throwable cause) {
		super(cause);
	}

}
