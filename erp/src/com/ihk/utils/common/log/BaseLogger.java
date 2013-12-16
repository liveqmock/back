package com.ihk.utils.common.log;

import org.apache.log4j.Logger;

/**
 * 基础日志类,可以利用该类监听一些指定的异常,及时通知开发人员...
 * @author dtc
 * 2013-4-27,下午06:03:14
 */
public class BaseLogger {
	
	/**
	 * info
	 * @param clazz
	 * @param message
	 */
	public static void info(Class<?> clazz, Object message){
		
		Logger.getLogger(clazz).info(message);
	}
	
	/**
	 * info
	 * @param clazz
	 * @param message
	 * @param t
	 */
	public static void info(Class<?> clazz, Object message, Throwable t){
		
		Logger.getLogger(clazz).info(message, t);
	}

	/**
	 * debug
	 * @param clazz
	 * @param message
	 */
	public static void debug(Class<?> clazz, Object message){
		
		Logger.getLogger(clazz).debug(message);
	}
	
	/**
	 * debug
	 * @param clazz
	 * @param message
	 * @param t
	 */
	public static void debug(Class<?> clazz, Object message, Throwable t){
		
		Logger.getLogger(clazz).debug(message, t);
	}
	
	/**
	 * warn
	 * @param clazz
	 * @param message
	 */
	public static void warn(Class<?> clazz, Object message){
		
		Logger.getLogger(clazz).warn(message);
	}
	
	/**
	 * warn
	 * @param clazz
	 * @param message
	 * @param t
	 */
	public static void warn(Class<?> clazz, Object message, Throwable t){
		
		Logger.getLogger(clazz).warn(message, t);
	}
	
	/**
	 * error
	 * @param clazz
	 * @param message
	 */
	public static void error(Class<?> clazz, Object message){
		
		Logger.getLogger(clazz).error(message);
	}
	
	/**
	 * error
	 * @param clazz
	 * @param message
	 * @param t
	 */
	public static void error(Class<?> clazz, Object message, Throwable t){
		
		Logger.getLogger(clazz).error(message, t);
	}

}
