package com.ihk.utils.company.project;

import java.util.Comparator;

import com.ihk.user.data.pojo.CompanyProject;

/**
 * CompanyProject按order_index排序
 * @author dtc
 * 2013-5-30,上午11:18:26
 */
public class MyComparatorProject implements Comparator<CompanyProject>{
	
	@Override
	public int compare(CompanyProject pro1, CompanyProject pro2) {
		
		return pro1.getOrderIndex() - pro2.getOrderIndex();
	}

}
