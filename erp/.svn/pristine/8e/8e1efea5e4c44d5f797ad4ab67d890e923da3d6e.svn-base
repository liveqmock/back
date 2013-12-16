package com.kn.action;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.ihk.customer.action.CustomerAction;
import com.kn.data.pojo.KN_App_User;
import com.kn.data.pojo.KN_LPCS_DY;

/**
 * junit测试类
 * @author peter
 * 2012-9-29
 */
public class OldDataToSqlTest {
	
	private static FileSystemXmlApplicationContext factory;
	
	@BeforeClass
	public static void init(){		
		factory = new FileSystemXmlApplicationContext(
				"src/Junit-olddata.xml");		
		
	}
	
	@Test
	public void test1(){
		
		try {
			//customerAction.queryCustomer();
			List<KN_App_User> list = OldDataToSqlUtils.getOldDataServices().findKN_App_User(null);
			
			for(KN_App_User d : list){
				System.out.println(d.getLoginName());
			}
			
			List<KN_LPCS_DY> listdy = OldDataToSqlUtils.getOldDataServices().findKN_LPCS_DY(null);

			System.out.println("test:输出单元");
			for(KN_LPCS_DY d : listdy){
				System.out.println(d.getPrice());
				System.out.println(d.get单元编号());
				System.out.println(d.get状态());
				System.out.println(d.get单元id());
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	

}
