package com.ihk.junit.out;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import org.junit.Test;

import com.ihk.junit.SupperJunit;
import com.ihk.user.data.pojo.UserAccount;
import com.ihk.user.data.pojo.UserAccountCond;
import com.ihk.user.data.services.IUserAccountServices;
import com.ihk.utils.CustomerUtils;

/**
 * 导出用户
 * @author dtc
 * 2013-9-30,下午02:45:59
 */
public class DownloadUserAccount extends SupperJunit{
	
	IUserAccountServices userAccountServices = (IUserAccountServices) factory.getBean("userAccountServices");
	
	@Test
	public void _test() throws Exception{
		
		int companyId = 0;
		
		UserAccountCond cond = new UserAccountCond();
		
		cond.setCompanyId(companyId);
		
		//cond.setProId(280);
		cond.setUserRoleProjectId("" + 298);
		
		cond.startLine = -1;
		
		List<UserAccount> list = userAccountServices.findUserAccountPage(cond);
		
		writerXls(list, "c:\\useraccount\\useraccount.xls");
		
	}
	
	private static String listToContent(List<UserAccount> userList) throws Exception{
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("<table border='1'>");
		
		for(UserAccount user : userList){
			
			sb.append("<tr>")
			
				.append("<td>").append(user.getUserName()).append("</td>")
				.append("<td>").append(user.getRealName()).append("</td>")
				.append("<td>").append(user.getDescCompanyId()).append("</td>")
				.append("<td>").append(user.getDescProjectId()).append("</td>")
				.append("<td>").append(user.getMobilePhone()).append("</td>")
				.append("<td>").append(user.getCreatedTimeStr()).append("</td>")
				.append("<td>").append(user.getRemark()).append("</td>")
				
				.append("</tr>")
				;
		}
		
		sb.append("</table>");
		
		return sb.toString();
	}
	
	private static void writerXls(List<UserAccount> userList, String fileName) throws Exception{
		
		OutputStream out = null;
		
		try{
			
			long start = System.currentTimeMillis();
			
			File file = new File(fileName);
			out = new FileOutputStream(file);
	        fileName = new String(fileName.getBytes("utf-8"), "ISO8859-1");
	        
	        String content = listToContent(userList);
	        byte[] b = content.getBytes("utf-8");
	        
	        out.write(b);
			
			out.flush();
			
			long end = System.currentTimeMillis();
			
			System.out.println(CustomerUtils.getNowForString() + " " + CustomerUtils.getNowTimeForString() + " '" + 
					fileName + "'下载所花的时间为: " + (end - start)/1000 + "s");
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			if(out != null){
				out.close();
			}
		}
		
	}

}
