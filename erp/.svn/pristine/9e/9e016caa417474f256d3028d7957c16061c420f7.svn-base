package com.ihk.setting.data.services;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.setting.data.pojo.OperLog;
import com.ihk.setting.data.pojo.OperLogCond;

/**
 * OperLog的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
public interface IOperLogServices {
	/**
	 * 新增OperLog
	 * @param operLog
	 */
	public void addOperLog(OperLog operLog) throws RuntimeException;

	/**
	 * 删除一条OperLog
	 * @param id
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
	public List<OperLog> findOperLogPage(OperLogCond cond) throws RuntimeException;

	/**
	 * 查找全部OperLog
	 * @param cond 查询条件
	 * @return OperLog列表
	 */
	public List<OperLog> findOperLog(OperLogCond cond) throws RuntimeException;
	
	/**
	 * 符合要求的记录数
	 * @param operCond
	 * @return
	 * @throws RuntimeException
	 */
	public int findOperLogCount(OperLogCond operCond)  throws RuntimeException;
	
	/**
	 * 查找
	 * @param operCond
	 * @return
	 * @throws RuntimeException
	 */
	public List<Map> findByUserIdAndLogCount (OperLogCond operCond)  throws RuntimeException;
	
	/**
	 * 查找
	 * @param operCond
	 * @return
	 * @throws RuntimeException
	 */
	public List<Map> findByProjectId (OperLogCond operCond)  throws RuntimeException;
}