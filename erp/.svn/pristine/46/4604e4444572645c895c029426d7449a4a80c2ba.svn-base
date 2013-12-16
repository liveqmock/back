package com.ihk.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.ihk.customer.action.CustomerAction;

/**
 * junit测试类
 * @author dtc
 * 2012-9-29
 */
public class JUnitTest {
	
	private static FileSystemXmlApplicationContext factory;
	private static CustomerAction customerAction;
	
	@BeforeClass
	public static void init(){
		
		factory = new FileSystemXmlApplicationContext(
				"src/Junit-applicationContext.xml");
		
		customerAction = (CustomerAction) factory.getBean("customerAction");
	}
	
	@Test
	public void queryCustomers(){
		
		try {
			//customerAction.queryCustomer();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	

}
