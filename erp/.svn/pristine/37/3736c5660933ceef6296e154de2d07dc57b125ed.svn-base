package com.ihk.utils;

import org.apache.log4j.Logger;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * 事务控制类
 * @author dtc
 * 2012-8-30
 */
public abstract class MyTransationTemplate {
	
	private static final Logger logger = Logger.getLogger(MyTransationTemplate.class);
	
	private DataSourceTransactionManager transactionManager;
	private TransactionStatus status;
	
	/**
	 * 事务方法的调用
	 * @throws Exception
	 */
	public final void execute() throws Exception{ //声明为final表示其中的方法执行顺序不能改变
		initTransaction();
		try{
			doExecuteCallback();
			commit();
		}catch(Exception e){
			rollback();
			throw e;
		}
		
	}
	
	/**
	 * 
	 * 声明为synchronized,参照jdk6.0中java db的代码
	 * 
	 */
	private synchronized void initTransaction(){
		//transactionManager = (DataSourceTransactionManager) SpringUtils.getBean("transactionManager"); //获取DataSourceTransactionManager
		transactionManager = DataSourceTransactionManagerFactory.newInstance();
		
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);  //支持当前事务，如果当前没有事务，就新建一个事务
		status = transactionManager.getTransaction(def);
		
	}
	
	/**
	 * 
	 * 声明为synchronized,参照jdk6.0中java db的代码
	 * 
	 */
	private synchronized void commit() throws TransactionException{
		transactionManager.commit(status);  //抛出异常
	}
	
	/**
	 * 
	 * 声明为synchronized,参照jdk6.0中java db的代码
	 * 
	 */
	private synchronized void rollback(){
		try{
			
			transactionManager.rollback(status);
		}catch(NullPointerException ne){
			
			logger.error("事务初始化出现异常", ne);
			
		}catch(TransactionException te){
			
			logger.error("事务回滚出现异常", te);
			
		}catch(Exception e){
			
			logger.error("事务出现未知异常", e);
		}
	}
	
	/**
	 * 业务真正的执行方法
	 * @throws Exception
	 */
	protected abstract void doExecuteCallback() throws Exception;

}
