package com.ihk.utils.exception;

public class RepeatTitleException extends BaseException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1394342835596637923L;

	public RepeatTitleException(){
		this("题目已存在,请更改题目");
	}
	
	public RepeatTitleException(String message){
		super(message);
	}
}
