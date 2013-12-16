package com.ihk.utils.log;

import org.apache.log4j.Logger;

/**
 * clazz 参数传入调用类的this.getClass()
 * @author logger日志工具类,YZJ,
 * 简化log4j调用，不需要每个类都声明一次Logger
 */

public class LoggerUtils {
	
	public static Logger logger;
	
	private static void getClazz(Class<?> clazz){
		logger = Logger.getLogger(clazz);
	}
	
	public static void debug(String loggerContent , Class<?> clazz){
		getClazz(clazz);
		logger.debug(loggerContent);
	}
	
	public static void info(String loggerContent , Class<?> clazz){
		getClazz(clazz);
		logger.info(loggerContent);
	}
	
	public static void error(String loggerContent , Class<?> clazz){
		getClazz(clazz);
		logger.error(loggerContent);
	}
	
	public static void trace(String loggerContent , Class<?> clazz){
		getClazz(clazz);
		logger.trace(loggerContent);
	}
}
