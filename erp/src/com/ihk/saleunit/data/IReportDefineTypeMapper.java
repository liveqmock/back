package com.ihk.saleunit.data;

import java.util.List;
import java.util.Map;

import com.ihk.saleunit.data.pojo.ReportDefineType;
import com.ihk.saleunit.data.pojo.ReportDefineTypeCond;

import com.ihk.utils.base.PojoDeleteCond;

/**
 * ReportDefineType数据访问接口Mapper
 * @author 
 *
 */  
public interface IReportDefineTypeMapper {

	/**
	 * 新增ReportDefineType
	 * @param reportDefineType
	 */
	public void addReportDefineType(ReportDefineType reportDefineType) ;

	/**
	 * 根据条件删除ReportDefineType
	 * @param cond 删除条件
	 */
	public void deleteReportDefineType(PojoDeleteCond cond) throws RuntimeException;

	/**
	 * 根据条件删除ReportDefineType
	 * @param cond 删除条件
	 */
	public void updateReportDefineType(ReportDefineType reportDefineType) throws RuntimeException;

	/**
	 * 查找一条ReportDefineType
	 * @return ReportDefineType
	 * @param id 主键id
	 */
	public ReportDefineType findReportDefineTypeById(int id) throws RuntimeException;

	/**
	 * 分页查找ReportDefineType
	 * @param cond 查询条件
	 * @return ReportDefineType列表
	 */
	public List<ReportDefineType> findReportDefineTypePage(ReportDefineTypeCond cond) ;

	/**
	 * 查找全部ReportDefineType
	 * @param cond 查询条件
	 * @return ReportDefineType列表
	 */
	public List<ReportDefineType> findReportDefineType(ReportDefineTypeCond cond) ;

	/**
	 * 查找符合条件的记录条数ReportDefineType
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findReportDefineTypeCount(ReportDefineTypeCond cond) ;
}
