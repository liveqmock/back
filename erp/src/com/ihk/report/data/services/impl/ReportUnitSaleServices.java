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
import com.ihk.report.data.IReportUnitSaleMapper;
import com.ihk.report.data.pojo.unitamount.ReportUnitAmountCompany;
import com.ihk.report.data.pojo.unitamount.ReportUnitAmountCompanyCond;
import com.ihk.report.data.pojo.unitsale.ReportPojoXSFXByCompany;
import com.ihk.report.data.pojo.unitsale.ReportPojoXSFXByCompanyCond;
import com.ihk.report.data.pojo.unitsale.ReportPojoXSFXByProject;
import com.ihk.report.data.pojo.unitsale.ReportPojoXSFXByProjectCond;
import com.ihk.report.data.pojo.unitsale.ReportPojoXSFXBySalesman;
import com.ihk.report.data.pojo.unitsale.ReportPojoXSFXBySalesmanCond;
import com.ihk.report.data.pojo.unitsale.ReportPojoXSFXByUnit;
import com.ihk.report.data.pojo.unitsale.ReportPojoXSFXByUnitCond;
import com.ihk.report.data.pojo.unitsale.ReportUnitSaleCompany;
import com.ihk.report.data.pojo.unitsale.ReportUnitSaleCompanyCond;
import com.ihk.report.data.pojo.unitsale.ReportUnitSaleCond;
import com.ihk.report.data.pojo.unitsale.ReportUnitSaleProject;
import com.ihk.report.data.pojo.unitsale.ReportUnitSaleProjectCond;
import com.ihk.report.data.pojo.unitsale.ReportUnitSaleSalesman;
import com.ihk.report.data.pojo.unitsale.ReportUnitSaleSalesmanCond;
import com.ihk.report.data.services.IReportUnitAmountServices;
import com.ihk.report.data.services.IReportUnitSaleServices;
import com.ihk.utils.SessionUser;
import com.ihk.utils.base.PojoDeleteCond;

/**
 * @author 
 *
 */
@Service("reportMonthSaleServices")
public class ReportUnitSaleServices implements IReportUnitSaleServices {

	@Autowired	 IReportUnitSaleMapper unitSaleMapper;


	public List<ReportUnitSaleCompany> groupByCompany(ReportUnitSaleCompanyCond cond) throws RuntimeException {
		cond.addPermissionCompanyProjectIds(PermissionUtils.getProjectIdListByXKZX());
    	return unitSaleMapper.groupByCompany(cond);
	}


	@Override
	public BigDecimal getSumMoney(ReportUnitSaleCond cond) {
		
		//销售人员的权限(只看到他自己的认购单元)
		if(PermissionUtils.isReportOnlySale()){
			cond.setSalesId(SessionUser.getUserId());
		}
		else{
			//一般的人员权限增加
			cond.addPermissionCompanyProjectIds(PermissionUtils.getProjectIdListByXKZX());			
		}
		
		return unitSaleMapper.getSumMoney(cond);
	}


	@Override
	public List<ReportUnitSaleProject> groupByProject(
			ReportUnitSaleProjectCond cond) throws RuntimeException {
		cond.addPermissionCompanyProjectIds(PermissionUtils.getProjectIdListByXKZX());
    	return unitSaleMapper.groupByProject(cond);
	}


	@Override
	public List<ReportUnitSaleSalesman> groupBySalesman(
			ReportUnitSaleSalesmanCond cond) throws RuntimeException {
		cond.addPermissionCompanyProjectIds(PermissionUtils.getProjectIdListByXKZX());
    	return unitSaleMapper.groupBySalesman(cond);
	}

	@Override
	public List<ReportPojoXSFXByCompany> findXSFXByCompany_ConfirmBook(ReportPojoXSFXByCompanyCond cond) throws RuntimeException {
		cond.addPermissionCompanyProjectIds(PermissionUtils.getProjectIdListByXKZX());
    	return unitSaleMapper.findXSFXByCompany_ConfirmBook(cond);
	}

	@Override
	public List<ReportPojoXSFXByCompany> findXSFXByCompany_Confirm(ReportPojoXSFXByCompanyCond cond) throws RuntimeException {
		cond.addPermissionCompanyProjectIds(PermissionUtils.getProjectIdListByXKZX());
    	return unitSaleMapper.findXSFXByCompany_Confirm(cond);
	}

	@Override
	public List<ReportPojoXSFXByCompany> findXSFXByCompany_Contract(ReportPojoXSFXByCompanyCond cond) throws RuntimeException {
		cond.addPermissionCompanyProjectIds(PermissionUtils.getProjectIdListByXKZX());
    	return unitSaleMapper.findXSFXByCompany_Contract(cond);
	}

	@Override
	public List<ReportPojoXSFXByProject> findXSFXByProject_ConfirmBook(ReportPojoXSFXByProjectCond cond) throws RuntimeException {
		cond.addPermissionCompanyProjectIds(PermissionUtils.getProjectIdListByXKZX());
    	return unitSaleMapper.findXSFXByProject_ConfirmBook(cond);
	}

	@Override
	public List<ReportPojoXSFXByProject> findXSFXByProject_Confirm(ReportPojoXSFXByProjectCond cond) throws RuntimeException {
		cond.addPermissionCompanyProjectIds(PermissionUtils.getProjectIdListByXKZX());
    	return unitSaleMapper.findXSFXByProject_Confirm(cond);
	}

	@Override
	public List<ReportPojoXSFXByProject> findXSFXByProject_Contract(ReportPojoXSFXByProjectCond cond) throws RuntimeException {
		cond.addPermissionCompanyProjectIds(PermissionUtils.getProjectIdListByXKZX());
    	return unitSaleMapper.findXSFXByProject_Contract(cond);
	}
	
	@Override
	public List<ReportPojoXSFXBySalesman> findXSFXBySalesman_ConfirmBook(ReportPojoXSFXBySalesmanCond cond) throws RuntimeException {
		cond.addPermissionCompanyProjectIds(PermissionUtils.getProjectIdListByXKZX());
    	return unitSaleMapper.findXSFXBySalesman_ConfirmBook(cond);
	}

	@Override
	public List<ReportPojoXSFXBySalesman> findXSFXBySalesman_Confirm(ReportPojoXSFXBySalesmanCond cond) throws RuntimeException {
		cond.addPermissionCompanyProjectIds(PermissionUtils.getProjectIdListByXKZX());
    	return unitSaleMapper.findXSFXBySalesman_Confirm(cond);
	}

	@Override
	public List<ReportPojoXSFXBySalesman> findXSFXBySalesman_Contract(ReportPojoXSFXBySalesmanCond cond) throws RuntimeException {
		cond.addPermissionCompanyProjectIds(PermissionUtils.getProjectIdListByXKZX());
    	return unitSaleMapper.findXSFXBySalesman_Contract(cond);
	}
	
	@Override
	public List<ReportPojoXSFXByUnit> findXSFXByUnit_ConfirmBook(ReportPojoXSFXByUnitCond cond) throws RuntimeException {
		cond.addPermissionCompanyProjectIds(PermissionUtils.getProjectIdListByXKZX());
    	return unitSaleMapper.findXSFXByUnit_ConfirmBook(cond);
	}

	@Override
	public List<ReportPojoXSFXByUnit> findXSFXByUnit_Confirm(ReportPojoXSFXByUnitCond cond) throws RuntimeException {
		cond.addPermissionCompanyProjectIds(PermissionUtils.getProjectIdListByXKZX());
    	return unitSaleMapper.findXSFXByUnit_Confirm(cond);
	}

	@Override
	public List<ReportPojoXSFXByUnit> findXSFXByUnit_Contract(ReportPojoXSFXByUnitCond cond) throws RuntimeException {
		cond.addPermissionCompanyProjectIds(PermissionUtils.getProjectIdListByXKZX());
    	return unitSaleMapper.findXSFXByUnit_Contract(cond);
	}
}
