package com.ihk.report.data.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.report.data.pojo.commission.ReportCommissionCompany;
import com.ihk.report.data.pojo.commission.ReportCommissionCompanyCond;
import com.ihk.report.data.pojo.commission.ReportCommissionCond;
import com.ihk.report.data.pojo.commission.ReportCommissionProject;
import com.ihk.report.data.pojo.commission.ReportCommissionProjectCond;


/**
 * 佣金数据访问接口Mapper
 * 佣金定义:在起止日期的单元销量(认购)
 * @author peter
 *
 */
@Transactional 
@SuppressWarnings("unchecked")
public interface IReportCommissionServices {

	/**
	 * 取得总货量，前几名公司的应收佣金
	 * @param cond
	 * @return
	 */
	public List<ReportCommissionCompany> groupByCompany(ReportCommissionCompanyCond cond) throws RuntimeException;


	/**
	 * 取得总货量，前几名项目的应收佣金
	 * @param cond
	 * @return
	 */
	public List<ReportCommissionProject> groupByProject(ReportCommissionProjectCond cond) throws RuntimeException;
	

	/**
	 * 取得应收佣金的总和
	 * @param cond
	 * @return
	 */
	public BigDecimal getSumMoney(ReportCommissionCond cond);
}