package com.ihk.utils;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * DataSourceTransactionManager 的工厂类
 * @author dtc
 * 2012-9-29
 */
public class DataSourceTransactionManagerFactory {
	
	private static final Logger LOG = LoggerFactory.getLogger(DataSourceTransactionManagerFactory.class);
	
	private static DataSourceTransactionManager transactionManager;
	private static DataSource dataSource;
	
	public DataSource getDataSource() {
		return dataSource;
	}
	
	public void setDataSource(DataSource dataSource) {
		DataSourceTransactionManagerFactory.dataSource = dataSource;
	}

	public DataSourceTransactionManager getTransactionManager() {
		return transactionManager;
	}

	public void setTransactionManager(
			DataSourceTransactionManager transactionManager) {
		DataSourceTransactionManagerFactory.transactionManager = transactionManager;
	}
	
	private DataSourceTransactionManagerFactory(){
		//单例
	}

	/**
	 * 保证事务的正确执行,如果为空(表示初始化有问题)就新建一个,可以通过dataSourceId去指定事务的dataSource
	 * @return
	 */
	public static DataSourceTransactionManager newInstance() {
		
		if(transactionManager != null){
			
			return transactionManager;
		}
		
		synchronized(DataSourceTransactionManagerFactory.class){

			LOG.error("transactionManager 初始化有问题");
			
			transactionManager = new DataSourceTransactionManager(dataSource);
			
			LOG.info("手工新建一个 transactionManager : " + transactionManager + ", dataSource 为: " + dataSource.toString());
			
			return transactionManager;
			
		}
		
	}

}
