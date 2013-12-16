package com.ihk.report.data;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.type.BigDecimalTypeHandler;

import com.ihk.demo.data.pojo.DemoTable;
import com.ihk.demo.data.pojo.DemoTableCond;
import com.ihk.report.data.pojo.unitamount.ReportUnitAmountCompany;
import com.ihk.report.data.pojo.unitamount.ReportUnitAmountCompanyCond;
import com.ihk.report.data.pojo.unitamount.ReportUnitAmountCond;
import com.ihk.report.data.pojo.unitamount.ReportUnitAmountProject;
import com.ihk.report.data.pojo.unitamount.ReportUnitAmountProjectCond;
import com.ihk.utils.base.PojoDeleteCond;
 

/**
 * 货量数据访问接口Mapper
 * 单元总体货量定义:单元的推货日期小于指定日期(在制定日期之前)，就归入总体货量
 * @author 
 *
 */ 
public interface IReportUnitAmountMapper {

	/**
	 * 取得总货量，前几名公司的货量
	 * @param cond
	 * @return
	 */
	public List<ReportUnitAmountCompany> groupByCompany(ReportUnitAmountCompanyCond cond) ;
	
	/**
	 * 取得总货量的总和
	 * @param cond
	 * @return
	 */
	public BigDecimal getSumMoney(ReportUnitAmountCond cond);

	/**
	 * 取得总货量，前几名项目的货量
	 * @param cond
	 * @return
	 */
	public List<ReportUnitAmountProject> groupByProject(ReportUnitAmountProjectCond cond) throws RuntimeException;

}
