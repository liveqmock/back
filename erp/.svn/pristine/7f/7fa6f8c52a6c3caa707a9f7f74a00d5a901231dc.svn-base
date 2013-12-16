package com.ihk.saleunit.data.services;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.saleunit.data.pojo.ReportDefineColumn;
import com.ihk.saleunit.data.pojo.ReportDefineColumnCond;

/**
 * ReportDefineColumn的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
@SuppressWarnings("unchecked")
public interface IReportDefineColumnServices {
	/**
	 * 新增ReportDefineColumn
	 * @param reportDefineColumn
	 */
	public void addReportDefineColumn(ReportDefineColumn reportDefineColumn) throws RuntimeException;

	/**
	 * 删除一条ReportDefineColumn
	 * @param id
	 */
	public void deleteReportDefineColumn(int id) throws RuntimeException;

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
	public List<ReportDefineColumn> findReportDefineColumnPage(ReportDefineColumnCond cond) throws RuntimeException;

	/**
	 * 查找全部ReportDefineColumn
	 * @param cond 查询条件
	 * @return ReportDefineColumn列表
	 */
	public List<ReportDefineColumn> findReportDefineColumn(ReportDefineColumnCond cond) throws RuntimeException;
	
	/**
	 * 查找
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public List<ReportDefineColumn> findReportDefineColumnForY(ReportDefineColumnCond cond) throws RuntimeException;
	
	/**
	 * 查询map
	 */
	public List<Map> findReportDefineColumnAndType(ReportDefineColumnCond cond) throws RuntimeException;
}