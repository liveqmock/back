package com.ihk.sale.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.sale.data.pojo.SaleBuildLog;
import com.ihk.sale.data.pojo.SaleBuildLogCond;

/**
 * SaleBuildLog的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
@SuppressWarnings("unchecked")
public interface ISaleBuildLogServices {

	/**
	 * 新增SaleBuildLog
	 * @param saleBuildLog
	 */
	public void addSaleBuildLog(SaleBuildLog saleBuildLog) throws RuntimeException;

	/**
	 * 删除一条SaleBuildLog
	 * @param id
	 */
	public void deleteSaleBuildLog(int id) throws RuntimeException;

	/**
	 * 修改SaleBuildLog
	 * @param saleBuildLog
	 */
	public void updateSaleBuildLog(SaleBuildLog saleBuildLog) throws RuntimeException;

	/**
	 * 查找一条SaleBuildLog
	 * @return SaleBuildLog
	 * @param id 主键id
	 */
	public SaleBuildLog findSaleBuildLogById(int id) throws RuntimeException;

	/**
	 * 分页查找SaleBuildLog
	 * @param cond 查询条件
	 * @return SaleBuildLog列表
	 */
	public List<SaleBuildLog> findSaleBuildLogPage(SaleBuildLogCond cond) throws RuntimeException;

	/**
	 * 查找全部SaleBuildLog
	 * @param cond 查询条件
	 * @return SaleBuildLog列表
	 */
	public List<SaleBuildLog> findSaleBuildLog(SaleBuildLogCond cond) throws RuntimeException;
}