package com.ihk.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.ihk.sale.data.pojo.SaleMonitor;
import com.ihk.sale.data.pojo.SaleMonitorCond;
import com.ihk.sale.data.services.ISaleMonitorServices;
import com.ihk.sale.data.services.impl.SaleMonitorServices;
import com.ihk.utils.SpringUtils;

/**
 * 代理测试类
 * @author dtc
 * 2012-9-29
 */
public class ProxyTest {
	
	public static void main(String[] args) throws Exception{
		
		/*CustomerImpl cImpl = new CustomerImpl();
		CustomerProcessorHandler handler = new CustomerProcessorHandler(cImpl);
		
		CustomerIf cIf = (CustomerIf) Proxy.newProxyInstance(cImpl.getClass().getClassLoader(), 
				cImpl.getClass().getInterfaces(), handler);
		
		String getRet = cIf.processorBusiness();
		
		System.out.println(getRet);
		
		Class clazz = null;
		clazz.getConstructor(new Class[]{InvocationHandler.class}).newInstance(new Object[]{handler});
		*/
		
		
		
		//ISaleMonitorServices serviceIf = (ISaleMonitorServices) getBean("methodServiceProxy");
		SaleMonitorCond cond = new SaleMonitorCond();
		
		//SaleMonitor sale = serviceIf.findSaleMonitorForSearchTime(cond);
		//System.out.println(sale.getPhoneNum());
		//serviceIf.findMonitorDateIsExists(cond);
		//serviceIf.deleteSaleMonitor(0);
		
		ISaleMonitorServices serviceIf = (ISaleMonitorServices) getBean("saleMonitorServices");
		serviceIf.findMonitorDateIsExists(cond);
		
		SaleMonitor sale = serviceIf.findSaleMonitorForSearchTime(cond);
		System.out.println(sale.getPhoneNum());
		serviceIf.findMonitorDateIsExists(cond);
		serviceIf.deleteSaleMonitor(0);
		
	}
	
	private static ApplicationContext context = null;
	
	static{
		context = new FileSystemXmlApplicationContext("src/Junit-applicationContext.xml");
		 
	}
	
	public static Object getBean(String name){
		return context.getBean(name);
	}

}
