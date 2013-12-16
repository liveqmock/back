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
import com.ihk.report.data.IReportCommissionMapper;
import com.ihk.report.data.pojo.commission.ReportCommissionCompany;
import com.ihk.report.data.pojo.commission.ReportCommissionCompanyCond;
import com.ihk.report.data.pojo.commission.ReportCommissionCond;
import com.ihk.report.data.pojo.commission.ReportCommissionProject;
import com.ihk.report.data.pojo.commission.ReportCommissionProjectCond;
import com.ihk.report.data.pojo.unitamount.ReportUnitAmountCompany;
import com.ihk.report.data.pojo.unitamount.ReportUnitAmountCompanyCond;
import com.ihk.report.data.pojo.unitamount.ReportUnitAmountCond;
import com.ihk.report.data.services.IReportUnitAmountServices;
import com.ihk.report.data.services.IReportCommissionServices;
import com.ihk.utils.base.PojoDeleteCond;

/**
 * @author 
 *
 */
@Service("reportCommissionServices")
public class ReportCommssionServices implements IReportCommissionServices {

	@Autowired	 IReportCommissionMapper commissionMapper;

	public List<ReportCommissionCompany> groupByCompany(ReportCommissionCompanyCond cond) throws RuntimeException {
		cond.addPermissionCompanyProjectIds(PermissionUtils.getProjectIdListByXKZX());
    	return commissionMapper.groupByCompany(cond);
	}


	@Override
	public BigDecimal getSumMoney(ReportCommissionCond cond) {
		cond.addPermissionCompanyProjectIds(PermissionUtils.getProjectIdListByXKZX());
		return commissionMapper.getSumMoney(cond);
	}


	@Override
	public List<ReportCommissionProject> groupByProject(
			ReportCommissionProjectCond cond) throws RuntimeException {
		cond.addPermissionCompanyProjectIds(PermissionUtils.getProjectIdListByXKZX());
		return commissionMapper.groupByProject(cond);
	}

}
