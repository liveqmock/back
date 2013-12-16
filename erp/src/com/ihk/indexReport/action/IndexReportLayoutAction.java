package com.ihk.indexReport.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.article.data.services.IArticleServices;
import com.ihk.permission.PermissionUtils;
import com.ihk.report.data.pojo.unitamount.ReportUnitAmountCompany;
import com.ihk.report.data.pojo.unitamount.ReportUnitAmountCompanyCond;
import com.ihk.report.data.services.IReportUnitAmountServices;
import com.ihk.report.data.services.impl.ReportUnitAmountServices;
import com.ihk.utils.SupperAction;

public class IndexReportLayoutAction extends SupperAction{

	@Autowired
	IReportUnitAmountServices allUnitServices;
	
	/**
	 * 多公司管理   多项目管理   单项目管理    销售人员
	 * 1_          2_         3_        4_
	 * 
	 * report11Action 指的就是多公司管理的第一个报表 
	 * */
	public String layout(){
		System.out.println(PermissionUtils.isReportMultiCompany());
		System.out.println(PermissionUtils.isReportMultiProject());
		System.out.println(PermissionUtils.isReportOneProject());
		System.out.println(PermissionUtils.isReportOnlySale());
		
		ReportUnitAmountCompanyCond cond = new ReportUnitAmountCompanyCond();
		List<ReportUnitAmountCompany> list = allUnitServices.groupByCompany(cond);
		
		return "multiCompany";//多公司管理
		
//		return "multiProject"; //多项目管理
//		return "singleProject"; //单项目管理
//		return "sales"; //销售
	}
	
}
