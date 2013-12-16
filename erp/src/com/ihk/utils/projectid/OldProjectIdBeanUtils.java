package com.ihk.utils.projectid;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.InitializingBean;

import com.ihk.utils.CommonUtils;

/**
 * 迁移到新的框架中的客户模块要根据是否来自旧的项目进行相关的操作,为了避免硬代码的问题,把相关的内容放到配置文件中
 * 而使用InitializingBean只是为了尝试多种方法(可以不使用的)
 * 初始化顺序,先setOldIds(),再afterPropertiesSet()
 * @author dtc
 * 2012-10-13,上午10:19:09
 */
public class OldProjectIdBeanUtils implements InitializingBean{
	
	/**
	 * 用,相连
	 */
	private String oldIds;
	
	/**
	 * 只是该类内部使用
	 */
	private static Set<Integer> idSet;
	
	public void setOldIds(String oldIds) {
		this.oldIds = oldIds;
	}
	
	public String getOldIds() {
		return oldIds;
	}
	
	public static boolean isOldProjectId(int projectId){
		
		if(CommonUtils.isCollectionEmpty(idSet)){
			
			return false;
		}
		
		if(idSet.contains(projectId))
			
			return true;
		
		return false;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		
		if(!CommonUtils.isStrEmpty(oldIds)){
			
			idSet = new HashSet<Integer>();
			
			String[] ids = oldIds.split(",");
			for(String id : ids){
				
				if(!CommonUtils.isStrEmpty(id)){
					idSet.add(Integer.parseInt(id));
				}
			}
		}
		
	}

}
