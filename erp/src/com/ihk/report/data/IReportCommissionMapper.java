package com.ihk.report.data;

import java.math.BigDecimal;
import java.util.List;

import com.ihk.demo.data.pojo.DemoTable;
import com.ihk.demo.data.pojo.DemoTableCond;
import com.ihk.report.data.pojo.commission.ReportCommissionCompany;
import com.ihk.report.data.pojo.commission.ReportCommissionCompanyCond;
import com.ihk.report.data.pojo.commission.ReportCommissionCond;
import com.ihk.report.data.pojo.commission.ReportCommissionProject;
import com.ihk.report.data.pojo.commission.ReportCommissionProjectCond;
import com.ihk.report.data.pojo.unitamount.ReportUnitAmountCompany;
import com.ihk.report.data.pojo.unitamount.ReportUnitAmountCompanyCond;
import com.ihk.report.data.pojo.unitsale.ReportUnitSaleCompany;
import com.ihk.report.data.pojo.unitsale.ReportUnitSaleCompanyCond;
import com.ihk.utils.base.PojoDeleteCond;
 

/**
 * 佣金数据访问接口Mapper
 * 佣金定义:在起止日期的单元销量(认购)
 * @author 
 *
 */ 
public interface IReportCommissionMapper {

	/**
	 * 取得应收佣金，前几名公司的应收佣金
	 * @param cond
	 * @return
	 */
	public List<ReportCommissionCompany> groupByCompany(ReportCommissionCompanyCond cond) ;

	/**
	 * 取得应收佣金的总和
	 * @param cond
	 * @return
	 */
	public BigDecimal getSumMoney(ReportCommissionCond cond);

	/**
	 * 取得总货量，前几名项目的应收佣金
	 * @param cond
	 * @return
	 */
	public List<ReportCommissionProject> groupByProject(ReportCommissionProjectCond cond) throws RuntimeException;
	

}
