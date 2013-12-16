package com.ihk.utils.common.setup;

/**
 * 关于role id的设置,在配置文件applicationContext-setup.xml中设置的对应值
 * @author dtc
 * 2012-10-16,上午10:26:02
 */
public class RoleSetUpUtils {
	
	/**
	 * 销控中心role id
	 */
	private static int xkzxRoleId;
	
	public void setXkzxRoleId(int xkzxRoleId) {
		RoleSetUpUtils.xkzxRoleId = xkzxRoleId;
	}
	
	/**
	 * 获取销控中心role id
	 * @return
	 */
	public static int getXkzxRoleId() {
		return xkzxRoleId;
	}
	

}
