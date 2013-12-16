package com.ihk.junit;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.ihk.user.data.pojo.CompanyProject;
import com.ihk.user.data.services.ICompanyProjectServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.pinyin.PinyinBaseUtils;

/**
 * 公司项目拼音
 * @author dtc
 * 2013-4-19,上午10:44:45
 */
public class CompanyProjectPinyin {
	
	private static FileSystemXmlApplicationContext factory;
	private static ICompanyProjectServices companyProjectServices;
	
	@BeforeClass
	public static void init(){
		
		factory = new FileSystemXmlApplicationContext("src/Junit-applicationContext.xml");
		
		companyProjectServices = (ICompanyProjectServices) factory.getBean("companyProjectServices");
	}
	
	@Test
	public void addPinyinToCompanyProject() throws Exception{
		
		List<CompanyProject> list = companyProjectServices.findCompanyProject();
		
		if(!CommonUtils.isCollectionEmpty(list)){
			
			for(CompanyProject project : list){
				
				String name = project.getProjectName().trim();
				String pinyin = PinyinBaseUtils.getPinYinHeadChar(name);
				
				project.setProjectName(name);
				project.setPinyin(pinyin);
				
				companyProjectServices.updateCompanyProjectPinyin(project);
				
			}
			
		}
		
	}
	
	/**
	 * 
		SELECT 
		ELT(
		    INTERVAL(
		    CONV(HEX(CONVERT('创' USING gbk)),16,10)
		    ,
		    0xB0A1,0xB0C5,0xB2C1,0xB4EE,0xB6EA,0xB7A2,0xB8C1,0xB9FE,0xBBF7,
		    0xBFA6,0xC0AC,0xC2E8,0xC4C3,0xC5B6,0xC5BE,0xC6DA,0xC8BB,0xC8F6,
		    0xCBFA,0xCDDA,0xCEF4,0xD1B9,0xD4D1)
		    ,
		    'A','B','C','D','E','F','G','H','J','K','L','M','N','O','P',
		    'Q','R','S','T','W','X','Y','Z'
		) 
		AS PY 
	 */

}
