package com.ihk.junit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.ihk.setting.data.pojo.ProjectCode;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.base.MySqlSessionFactory;

/**
 * 操作表project_code
 * @author dtc
 * 2013-4-19,上午10:45:06
 */
public class ModifyProjectCode {
	
	//private static FileSystemXmlApplicationContext factory;
	
	@BeforeClass
	public static void init(){
		
		new FileSystemXmlApplicationContext("src/Junit-applicationContext.xml");
		
		//mySqlSessionFactory = (MySqlSessionFactory) factory.getBean("mySqlSessionFactory");
		
	}
	
	@Test
	public void modifyProjectCode() throws Exception{
		
		//projectCodeServices.findProjectCodeByProjectIdAndTypeName(projectId, typeName);
		
		List<ProjectCode> codeList = new ArrayList<ProjectCode>();
		
		String sql = "select project_id, max(code_order) as m from project_code where type_name = 'CUSTOMER_SOURCE' and is_deleted ='0' group by project_id";
		
		Connection conn = MySqlSessionFactory.newConnectionInstance();
		
		PreparedStatement stat = conn.prepareStatement(sql);
		
		ResultSet rs = stat.executeQuery();
		
		while(rs.next()){
			
			ProjectCode code = new ProjectCode();
			
			int projectId = rs.getInt("project_id");
			int codeVal = rs.getInt("m") + 1;
		
			code.setProjectId(projectId);
			code.setTypeName("CUSTOMER_SOURCE");
			code.setCodeVal(codeVal + "");
			
			code.setCodeDesc("中介公司");
			code.setCodeOrder(codeVal);
			code.setIsDeleted("0");
			
			codeList.add(code);
			
		}
		
		/**
		 * private int projectId;
			private String typeName;
			private String codeVal;
			
			private String codeDesc;
			private int codeOrder;
			private String isDeleted;
		 */
		String insertSql = "insert into project_code values(?, ?, ?, ?, ?, ?)";
		
		if(!CommonUtils.isCollectionEmpty(codeList)){
			
			for(ProjectCode code : codeList){
				
				PreparedStatement insertStat = conn.prepareStatement(insertSql);
				
				insertStat.setInt(1, code.getProjectId());
				insertStat.setString(2, code.getTypeName());
				insertStat.setString(3, code.getCodeVal());
				
				insertStat.setString(4, code.getCodeDesc());
				insertStat.setInt(5, code.getCodeOrder());
				insertStat.setString(6, code.getIsDeleted());
				
				insertStat.execute();
				
			}
		}
		
		rs.close();
		stat.close();
		conn.close();
		
	}

}
