package com.kn.action;

import java.math.BigDecimal;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.ihk.customer.action.CustomerAction;
import com.ihk.kn.data.pojo.OlddbIdlog;
import com.ihk.saleunit.data.pojo.Chip;
import com.ihk.utils.DateTimeUtils;
import com.ihk.utils.saleunit.MyPropertyUtils;
import com.kn.data.pojo.KN_App_User;
import com.kn.data.pojo.KN_LPCS_DY;

/**
 * junit测试类
 * @author peter
 * 2012-9-29
 */
public class OldDataToSqlByPeter {
	
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
//			List<KN_App_User> list = OldDataToSqlUtils.getOldDataServices().findKN_App_User(null);
//			
//			for(KN_App_User d : list){
//				System.out.println(d.getLoginName());
//			}
//			
			List<KN_LPCS_DY> listdy = OldDataToSqlUtils.getOldDataServices().findKN_LPCS_DY(null);

//			System.out.println("test:输出单元");
//			for(KN_LPCS_DY d : listdy){
//				System.out.println(d.getPrice());
//				System.out.println(d.get单元编号());
//				System.out.println(d.get状态());
//				System.out.println(d.get单元id());
//			}
			
//			System.out.println("test:写入peter的crm数据库");
//			for(KN_LPCS_DY d : listdy){
//				Chip chip = new Chip();
//			    chip.setChipNo("0");    
//			    chip.setChipType("0");    
//			    chip.setChipMoney(BigDecimal.valueOf(0));    
//			    chip.setCustomerId(0);    
//			    chip.setCompanyProjectId(0);    
//			    chip.setPropertyProjectId(0);    
//			    chip.setUnitId1(0);    
//			    chip.setUnitId2(0);    
//			    chip.setUnitId3(0);    
//			    chip.setUnitId4(0);    
//			    chip.setUnitId5(0);    
//			    chip.setIsVoid("0");    
//			    chip.setVoidTime(DateTimeUtils.getDate("2013-01-01"));    
//			    chip.setUserId(0);    
//			    chip.setSalesId("0");    
//			    chip.setIsDeleted("0");    
//			    chip.setCreatedId(0);    
//			    chip.setCreatedTime(DateTimeUtils.getDate("2013-01-01"));    
//			    chip.setModId(0);    
//			    chip.setModTime(DateTimeUtils.getDate("2013-01-01"));    
//				MyPropertyUtils.getChipServices().addChip(chip);
//			}
			

			System.out.println("test:写入peter的crm数据库olddb_idlog");
			for(KN_LPCS_DY d : listdy){
				OlddbIdlog olddbIdlog = new OlddbIdlog();
				olddbIdlog.setMyTable("test");
				olddbIdlog.setMyId("1");
				olddbIdlog.setOlddbId(d.get单元id().toString());
				
				OldDataToSqlUtils.getOlddbIdlogServices().addOlddbIdlog(olddbIdlog);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	

}
