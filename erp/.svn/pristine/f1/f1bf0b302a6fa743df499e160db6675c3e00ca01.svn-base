package com.ihk.report.data;

import java.math.BigDecimal;
import java.util.List;

import com.ihk.demo.data.pojo.DemoTable;
import com.ihk.demo.data.pojo.DemoTableCond;
import com.ihk.report.data.pojo.unitamount.ReportUnitAmountCompany;
import com.ihk.report.data.pojo.unitamount.ReportUnitAmountCompanyCond;
import com.ihk.report.data.pojo.unitamount.ReportUnitAmountCond;
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
import com.ihk.utils.base.PojoDeleteCond;
 

/**
 * 销量数据访问接口Mapper
 * 销量定义:在起止日期的单元销量(认购)
 * @author 
 *
 */ 
public interface IReportUnitSaleMapper {

	/**
	 * 取得总销量，前几名公司的货量
	 * @param cond
	 * @return
	 */
	public List<ReportUnitSaleCompany> groupByCompany(ReportUnitSaleCompanyCond cond) ;

	/**
	 * 取得总销量的总和
	 * @param cond
	 * @return
	 */
	public BigDecimal getSumMoney(ReportUnitSaleCond cond);

	/**
	 * 取得销量，前几名项目的销量
	 * @param cond
	 * @return
	 */
	public List<ReportUnitSaleProject> groupByProject(ReportUnitSaleProjectCond cond) throws RuntimeException;

	/**
	 * 取得销量，前几名项目的销量
	 * @param cond
	 * @return
	 */
	public List<ReportUnitSaleSalesman> groupBySalesman(ReportUnitSaleSalesmanCond cond) throws RuntimeException;

	/**
	 * 销售分析:公司,临定
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public List<ReportPojoXSFXByCompany> findXSFXByCompany_ConfirmBook(ReportPojoXSFXByCompanyCond cond) throws RuntimeException;

	/**
	 * 销售分析:公司,认购
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public List<ReportPojoXSFXByCompany> findXSFXByCompany_Confirm(ReportPojoXSFXByCompanyCond cond) throws RuntimeException;


	/**
	 * 销售分析:公司,签约
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public List<ReportPojoXSFXByCompany> findXSFXByCompany_Contract(ReportPojoXSFXByCompanyCond cond) throws RuntimeException;
	
	/**
	 * 销售分析:项目,临定
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public List<ReportPojoXSFXByProject> findXSFXByProject_ConfirmBook(ReportPojoXSFXByProjectCond cond) throws RuntimeException;

	/**
	 * 销售分析:项目,认购
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public List<ReportPojoXSFXByProject> findXSFXByProject_Confirm(ReportPojoXSFXByProjectCond cond) throws RuntimeException;


	/**
	 * 销售分析:项目,签约
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public List<ReportPojoXSFXByProject> findXSFXByProject_Contract(ReportPojoXSFXByProjectCond cond) throws RuntimeException;
	
	/**
	 * 销售分析:销售,临定
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public List<ReportPojoXSFXBySalesman> findXSFXBySalesman_ConfirmBook(ReportPojoXSFXBySalesmanCond cond) throws RuntimeException;
	
	/**
	 * 销售分析:销售,认购
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public List<ReportPojoXSFXBySalesman> findXSFXBySalesman_Confirm(ReportPojoXSFXBySalesmanCond cond) throws RuntimeException;
	
	/**
	 * 销售分析:销售,签约
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public List<ReportPojoXSFXBySalesman> findXSFXBySalesman_Contract(ReportPojoXSFXBySalesmanCond cond) throws RuntimeException;

	/**
	 * 销售分析:销售明细,临定
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public List<ReportPojoXSFXByUnit> findXSFXByUnit_ConfirmBook(ReportPojoXSFXByUnitCond cond) throws RuntimeException;
	
	/**
	 * 销售分析:销售明细,认购
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public List<ReportPojoXSFXByUnit> findXSFXByUnit_Confirm(ReportPojoXSFXByUnitCond cond) throws RuntimeException;
	
	/**
	 * 销售分析:销售明细,签约
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public List<ReportPojoXSFXByUnit> findXSFXByUnit_Contract(ReportPojoXSFXByUnitCond cond) throws RuntimeException;

}
