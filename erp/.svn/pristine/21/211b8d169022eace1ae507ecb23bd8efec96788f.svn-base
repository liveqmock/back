package com.ihk.utils.useraccount;

import java.util.List;
import java.util.Map;

import com.ihk.utils.CommonUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.MyTransationTemplate;
import com.ihk.utils.saleunit.MyPropertyUtils;

/**
 * 关于用户的帮助类
 * @author dtc
 * 2012-9-22
 */
public class UserAccountUtils {
	
	/**
	 * 根据ids(格式:id1,id2...)获取对应的realName(格式:name1,name2...)
	 * 出异常返回null
	 * @param ids
	 * @return
	 */
	public static String getRealNameByIds(final String ids){
		
		final StringBuffer sb = new StringBuffer();
		
		try{
			
			new MyTransationTemplate() {
				
				@Override
				protected void doExecuteCallback() throws Exception {
					
					String[] idArr = ids.split(",");
					
					for(String id : idArr){
						
						if(CommonUtils.isStrZeroEmpty(id))
							continue;
						
						sb.append(DescUtils.getUserAccountServices().findUserAccountById(Integer.parseInt(id.trim())).getRealName()).append(",");
					}
					
				}
			}.execute();
			
			String ret = sb.toString();
			
			return CommonUtils.removeLastChar(ret);
			
		}catch (Exception e) {
			
			return null;			
		}
		
	}
	
	/**
	 * 是否合法密码
	 * @param pwd
	 * @return
	 */
	public static boolean rightfulPwd(String pwd){
		
		if(CommonUtils.isStrEmpty(pwd)){
			
			return false;
		}
		
		if(minSize(pwd) && complexity(pwd)){
			
			return true;
		}
		
		return false;
		
	}

	/**
	 * 根据用户id获取对应的项目角色list
	 * @param userId
	 * @return
	 */
	public static List<Map<String, String>> getUserProjectRoleList(int userId){
		
		return MyPropertyUtils.getUserAccountServices().findProjectAndRoleByUserAccountId(userId);
	}
	
	/**
	 * 根据用户id获取对应的项目角色String
	 * @param userId
	 * @return
	 */
	public static String getUserProjectRoleString(int userId){
		
		List<Map<String, String>> roleList = getUserProjectRoleList(userId);
		if(CommonUtils.isCollectionEmpty(roleList)){
			
			return "";
		}

		StringBuffer sb = new StringBuffer();
		
		for(Map<String, String> role : roleList){
			
			sb.append(CommonUtils.isStrEmpty(role.get("roleName")) ? "" : role.get("roleName"));
			
			String projectName = role.get("projectName");
			if(!CommonUtils.isStrEmpty(projectName)){
				
				sb.append("(")
				.append(CommonUtils.isStrEmpty(role.get("projectName")) ? "" : role.get("projectName"))
				.append(")")
				;
				
			}
			
			sb.append(",");
		}
		
		return CommonUtils.removeLastChar(sb.toString());
	}
	
	////
	
	/**
	 * 是否超过六个长度
	 * @param pwd
	 * @return
	 */
	private static boolean minSize(String pwd){
		
		if(CommonUtils.isStrEmpty(pwd) || pwd.trim().length() < 6){
			
			return false;
		}
		
		return true;
	}
	
	/**
	 * 复杂度
	 * @param pwd
	 * @return
	 */
	private static boolean complexity(String pwd){
		
		boolean havem = false;
		boolean havee = false;
		for (int  i= 0;  i < pwd.length() ; i++) {
			if((pwd.charAt(i) >= 'a' && pwd.charAt(i) <= 'z') || (pwd.charAt(i) >= 'A' && pwd.charAt(i) <= 'Z')){
				havem = true;
			}
			if(pwd.charAt(i) >= '0' && pwd.charAt(i) <= '9'){
				havee = true;
			}
		} 
		if(havem && havee){
			return true;
		}else{
			return false;
		}
	}
	
}
