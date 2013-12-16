package com.ihk.sale.data;

import java.util.List;
import java.util.Map;

import com.ihk.sale.data.pojo.SaleBuildLog;
import com.ihk.sale.data.pojo.SaleBuildLogCond;

/**
 * SaleBuildLog数据访问接口Mapper
 * @author 
 *
 */ 
public interface ISaleBuildLogMapper {

	/**
	 * 新增SaleBuildLog
	 * @param saleBuildLog
	 */
	public void addSaleBuildLog(SaleBuildLog saleBuildLog) ;

	/**
	 * 根据条件删除SaleBuildLog
	 * @param cond 删除条件
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
	public List<SaleBuildLog> findSaleBuildLogPage(SaleBuildLogCond cond) ;

	/**
	 * 查找全部SaleBuildLog
	 * @param cond 查询条件
	 * @return SaleBuildLog列表
	 */
	public List<SaleBuildLog> findSaleBuildLog(SaleBuildLogCond cond) ;

	/**
	 * 查找符合条件的记录条数SaleBuildLog
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findSaleBuildLogCount(SaleBuildLogCond cond) ;
}
