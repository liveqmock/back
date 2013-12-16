package com.ihk.saleunit.data;

import java.util.List;
import java.util.Map;

import com.ihk.saleunit.data.pojo.ReportDefineColumn;
import com.ihk.saleunit.data.pojo.ReportDefineColumnCond;

import com.ihk.utils.base.PojoDeleteCond;

/**
 * ReportDefineColumn数据访问接口Mapper
 * @author 
 *
 */ 
public interface IReportDefineColumnMapper {

	/**
	 * 新增ReportDefineColumn
	 * @param reportDefineColumn
	 */
	public void addReportDefineColumn(ReportDefineColumn reportDefineColumn) ;

	/**
	 * 根据条件删除ReportDefineColumn
	 * @param cond 删除条件
	 */
	public void deleteReportDefineColumn(PojoDeleteCond cond) throws RuntimeException;

	/**
	 * 修改ReportDefineColumn
	 * @param reportDefineColumn
	 */
	public void updateReportDefineColumn(ReportDefineColumn reportDefineColumn) throws RuntimeException;

	/**
	 * 查找一条ReportDefineColumn
	 * @return ReportDefineColumn
	 * @param id 主键id
	 */
	public ReportDefineColumn findReportDefineColumnById(int id) throws RuntimeException;

	/**
	 * 分页查找ReportDefineColumn
	 * @param cond 查询条件
	 * @return ReportDefineColumn列表
	 */
	public List<ReportDefineColumn> findReportDefineColumnPage(ReportDefineColumnCond cond) ;

	/**
	 * 查找全部ReportDefineColumn
	 * @param cond 查询条件
	 * @return ReportDefineColumn列表
	 */
	public List<ReportDefineColumn> findReportDefineColumn(ReportDefineColumnCond cond) ;

	/**
	 * 查找全部ReportDefineColumn用于Y轴(table中左边一列)
	 * @param cond 查询条件
	 * @return ReportDefineColumn列表
	 */
	public List<ReportDefineColumn> findReportDefineColumnForY(ReportDefineColumnCond cond) ;//用于表格Y轴，需要显示report_define_type.type_name
    
	/**
	 * 查找记录数
	 * @param cond
	 * @return
	 */
	public int findReportDefineColumnCount(ReportDefineColumnCond cond) ;
	
	public List<Map> findReportDefineColumnAndType(ReportDefineColumnCond cond);
}
