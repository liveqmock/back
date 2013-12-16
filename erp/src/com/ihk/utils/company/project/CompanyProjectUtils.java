package com.ihk.utils.company.project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.ihk.user.data.pojo.CompanyProject;
import com.ihk.utils.CommonUtils;

/**
 * 公司,公司项目的帮助类
 * @author dtc
 * 2013-5-30,上午11:22:32
 */
public class CompanyProjectUtils {
	
	/**
	 * 根据公司id,获取对应权限项目的list,按order_index排序
	 * @param projects
	 * @param comId
	 * @return
	 */
	public static List<CompanyProject> getProjectListByCompanyId(List<CompanyProject> projects, int comId){
		
		if(CommonUtils.isCollectionEmpty(projects) || comId <= 0)
			return null;
		
		List<CompanyProject> retList = new ArrayList<CompanyProject>();
		
		for(CompanyProject pro : projects){
			
			int getComId = pro.getCompanyId();
			if(comId == getComId){
				retList.add(pro);
			}
			
		}
		
		//按order_index排序
		Collections.sort(retList, new MyComparatorProject());
		
		return retList;
	}

}
