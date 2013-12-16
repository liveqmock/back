package com.ihk.report.data.services.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.demo.data.IDemoTableMapper;
import com.ihk.demo.data.pojo.DemoTable;
import com.ihk.demo.data.pojo.DemoTableCond;
import com.ihk.demo.data.services.IDemoTableServices;
import com.ihk.permission.PermissionUtils;
import com.ihk.report.data.IReportUnitAmountMapper;
import com.ihk.report.data.pojo.unitamount.ReportUnitAmountCompany;
import com.ihk.report.data.pojo.unitamount.ReportUnitAmountCompanyCond;
import com.ihk.report.data.pojo.unitamount.ReportUnitAmountCond;
import com.ihk.report.data.pojo.unitamount.ReportUnitAmountProject;
import com.ihk.report.data.pojo.unitamount.ReportUnitAmountProjectCond;
import com.ihk.report.data.services.IReportUnitAmountServices;
import com.ihk.utils.base.PojoDeleteCond;

/**
 * @author 
 *
 */
@Service("reportAllUnitServices")
public class ReportUnitAmountServices implements IReportUnitAmountServices {

	@Autowired	 IReportUnitAmountMapper allUnitMapper;


	public List<ReportUnitAmountCompany> groupByCompany(ReportUnitAmountCompanyCond cond) throws RuntimeException {
		cond.addPermissionCompanyProjectIds(PermissionUtils.getProjectIdListByXKZX());
    	return allUnitMapper.groupByCompany(cond);
	}


	@Override
	public BigDecimal getSumMoney(ReportUnitAmountCond cond)
			throws RuntimeException {
		cond.addPermissionCompanyProjectIds(PermissionUtils.getProjectIdListByXKZX());
    	return allUnitMapper.getSumMoney(cond);
	}


	@Override
	public List<ReportUnitAmountProject> groupByProject(
			ReportUnitAmountProjectCond cond) throws RuntimeException {
		cond.addPermissionCompanyProjectIds(PermissionUtils.getProjectIdListByXKZX());
    	return allUnitMapper.groupByProject(cond);
	}
	
	
}
