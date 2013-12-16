package com.ihk.saleunit.log;

import java.util.List;

import com.ihk.saleunit.log.pojo.Log;
import com.ihk.saleunit.log.pojo.LogCond;

/**
 * UnitOperRecord数据访问接口Mapper
 * 
 * @author
 * 
 */
public interface ILogMapper {

	/**
	 * 新增log
	 * 
	 * @param log
	 */
	public void addLog(Log log);

	/**
	 * 根据id删除
	 * 
	 * @param cond
	 *            删除条件
	 */
	public void deleteLog(int id) throws RuntimeException;

	/**
	 * 修改log
	 * 
	 * @param log
	 */
	public void updateLog(Log log) throws RuntimeException;

	/**
	 * 根据单元ID得到操作日志列表
	 * 
	 * @param unitId
	 * @return
	 * @throws RuntimeException
	 */
	public List<Log> findLogByUnitId(LogCond cond) throws RuntimeException;

	/**
	 * 根据公司项目id得到日志列表
	 * 
	 * @param companyProjectId
	 * @return
	 * @throws RuntimeException
	 */
	public List<Log> findLogByCompanyProjectId(LogCond cond)
			throws RuntimeException;

	public List<Log> findLogByCreatedTime(LogCond cond) throws RuntimeException;

}
