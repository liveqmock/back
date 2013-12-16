package com.ihk.utils.base;

import java.sql.Connection;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionUtils;

/**
 * SqlSession工厂类,主要用来获取Connection
 * @author dtc
 * 2012-9-10
 */
public class MySqlSessionFactory {
	
	private static SqlSessionFactory sqlSessionFactory;
	
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		MySqlSessionFactory.sqlSessionFactory = sqlSessionFactory;
	}
	
	private static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
	
	private MySqlSessionFactory() {
	}
	
	/**
	 * 返回SqlSessionFactory,可以利用该方法来获取Connection
	 * @return
	 * @throws Exception
	 */
	public static SqlSessionFactory newFactoryInstance() throws Exception {
		
	    return getSqlSessionFactory();
	}
	
	/**
	 * 返回SqlSession
	 * @return
	 * @throws Exception
	 */
	public static SqlSession newSessionInstance() throws Exception{
		
		return SqlSessionUtils.getSqlSession(sqlSessionFactory);
		
		//return newFactoryInstance().openSession(); //这种方式会有问题
	}
	
	/**
	 * 返回Connection
	 * @return
	 * @throws Exception
	 */
	public static Connection newConnectionInstance() throws Exception{
		
		return newSessionInstance().getConnection();
	}
	
}
