package com.ihk.saleunit.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.saleunit.data.pojo.ReportDefineType;
import com.ihk.saleunit.data.pojo.ReportDefineTypeCond;

/**
 * ReportDefineType的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
@SuppressWarnings("unchecked")
public interface IReportDefineTypeServices {
	/**
	 * 新增ReportDefineType
	 * @param reportDefineType
	 */
	public void addReportDefineType(ReportDefineType reportDefineType) throws RuntimeException;

	/**
	 * 删除一条ReportDefineType
	 * @param id
	 */
	public void deleteReportDefineType(int id) throws RuntimeException;

	/**
	 * 修改ReportDefineType
	 * @param reportDefineType
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
	public List<ReportDefineType> findReportDefineTypePage(ReportDefineTypeCond cond) throws RuntimeException;

	/**
	 * 查找全部ReportDefineType
	 * @param cond 查询条件
	 * @return ReportDefineType列表
	 */
	public List<ReportDefineType> findReportDefineType(ReportDefineTypeCond cond) throws RuntimeException;
}