package com.ihk.utils.left;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.ihk.user.data.pojo.CompanyProject;
import com.ihk.user.data.pojo.UserRole;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.PermissionCacheName;
import com.ihk.utils.SessionUser;
import com.ihk.utils.cache.MyCacheTemplate;
import com.ihk.utils.cache.MyCacheTemplateCallback;

/**
 * 左边ajax导航树的缓存排序bean list utils
 * @author dtc
 * 2013-4-10,下午03:14:05
 */
public class OrderTreeBeanListCacheUtils {
	
	/**
	 * 左边ajax导航树的缓存排序bean list
	 * @param urList
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static List<OrderTreeBean> getOrderTreeBeanList(final List<UserRole> urList){
		
		List<OrderTreeBean> orderList = new ArrayList<OrderTreeBean>();
		
		if(CommonUtils.isCollectionEmpty(urList)){
			
			return orderList;
		}
		
		Object retObj = MyCacheTemplate.cache(PermissionCacheName.ORDERBEAN_LIST_FOR_AJAXLEFT, SessionUser.getUserIdStr(), new MyCacheTemplateCallback() {
			
			@Override
			public Object doCache() throws Exception {
				
				List<OrderTreeBean> retList = new ArrayList<OrderTreeBean>();
				
				OrderTreeBean order = null;
				
				for(UserRole ur : urList){
					
					order = new OrderTreeBean();
					
					order.setProjectName(ur.getProjectName());
					order.setProjectNameAndPinyin(ur.getProjectNameAndPinyin());
					order.setProjectId(ur.getProjectId());
					
					retList.add(order);
				}
				
				Collections.sort(retList, new OrderTreeComparatorBean());
				
				return retList;
			}
			
		});
		
		if(retObj != null){
			
			orderList = (List<OrderTreeBean>) retObj;
		}
		
		return orderList;
	}
	
	/**
	 * 根据公司项目返回左边ajax导航树的缓存排序bean list
	 * @param proList
	 * @return
	 */
	public static List<OrderTreeBean> getOrderTreeBeanListForProList(List<CompanyProject> proList){
		
		List<OrderTreeBean> retList = new ArrayList<OrderTreeBean>();
		
		OrderTreeBean order = null;
		
		for(CompanyProject pro : proList){
			
			order = new OrderTreeBean();
			
			order.setProjectName(pro.getProjectName());
			order.setProjectNameAndPinyin(pro.getProjectName() + pro.getPinyin());
			order.setProjectId(pro.getId());
			
			retList.add(order);
		}
		
		Collections.sort(retList, new OrderTreeComparatorBean());
		
		return retList;
	}

}
