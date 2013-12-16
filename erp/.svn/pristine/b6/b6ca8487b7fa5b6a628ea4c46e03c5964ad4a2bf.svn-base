package com.ihk.setting.data;

import java.util.List;
import java.util.Map;

import com.ihk.setting.data.pojo.OperLog;
import com.ihk.setting.data.pojo.OperLogCond;

/**
 * OperLog数据访问接口Mapper
 * @author 
 *
 */ 
public interface IOperLogMapper {

	/**
	 * 新增OperLog
	 * @param operLog
	 */
	public void addOperLog(OperLog operLog) ;

	/**
	 * 根据条件删除OperLog
	 * @param cond 删除条件
	 */
	public void deleteOperLog(int id) throws RuntimeException;

	/**
	 * 修改OperLog
	 * @param operLog
	 */
	public void updateOperLog(OperLog operLog) throws RuntimeException;

	/**
	 * 查找一条OperLog
	 * @return OperLog
	 * @param id 主键id
	 */
	public OperLog findOperLogById(int id) throws RuntimeException;

	/**
	 * 分页查找OperLog
	 * @param cond 查询条件
	 * @return OperLog列表
	 */
	public List<OperLog> findOperLogPage(OperLogCond cond) ;

	/**
	 * 查找全部OperLog
	 * @param cond 查询条件
	 * @return OperLog列表
	 */
	public List<OperLog> findOperLog(OperLogCond cond) ;

	/**
	 * 查找符合条件的记录条数OperLog
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findOperLogCount(OperLogCond cond) ;
	
	/**
	 * 
	 * @param operCond
	 * @return
	 * @throws RuntimeException
	 */
	public List<Map> findByUserIdAndLogCount (OperLogCond operCond)  throws RuntimeException;
	
	/**
	 * 
	 * @param operCond
	 * @return
	 * @throws RuntimeException
	 */
	public List<Map> findByProjectId (OperLogCond operCond)  throws RuntimeException;
}
