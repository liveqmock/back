package com.ihk.setting.data.services.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.setting.data.IOperLogMapper;
import com.ihk.setting.data.pojo.OperLog;
import com.ihk.setting.data.pojo.OperLogCond;
import com.ihk.setting.data.services.IOperLogServices;

/**
 * OperLog的Services实现(业务实现)
 * @author 
 *
 */
@Service("operLogServices")
public class OperLogServices implements IOperLogServices {
	/**
	 * operLog数据访问接口
	 */
	@Autowired	 IOperLogMapper operLogMapper;

	/**
	 * 删除一条OperLog
	 * @param id
	 */
	public void deleteOperLog(int id) throws RuntimeException {
		operLogMapper.deleteOperLog(id);
	}

	/**
	 * 新增OperLog
	 * @param operLog
	 */
	public void addOperLog(OperLog operLog) throws RuntimeException {		
		operLog.setLogTime(new Date());
		operLogMapper.addOperLog(operLog);
	}

	/**
	 * 查找一条OperLog
	 * @return OperLog
	 * @param id 主键id
	 */
	@Override
	public OperLog findOperLogById(int id) throws RuntimeException {
		return operLogMapper.findOperLogById(id);
	}

	/**
	 * 修改OperLog
	 * @param operLog
	 */
	@Override
	public void updateOperLog(OperLog operLog) throws RuntimeException {
		operLogMapper.updateOperLog(operLog);		
	}

	/**
	 * 分页查找OperLog
	 * @param cond 查询条件
	 * @return OperLog列表
	 */
	public List<OperLog> findOperLogPage(OperLogCond cond) throws RuntimeException {
		int recordCount = operLogMapper.findOperLogCount(cond);
		
		cond.recordCount = recordCount;
				
		return operLogMapper.findOperLogPage(cond);
	}

	/**
	 * 查找全部OperLog
	 * @param cond 查询条件
	 * @return OperLog列表
	 */
	public List<OperLog> findOperLog(OperLogCond cond) throws RuntimeException {
    	return operLogMapper.findOperLog(cond);
	}

	/**
	 * 查找记录数
	 */
	@Override
	public int findOperLogCount(OperLogCond operCond) throws RuntimeException {
		return operLogMapper.findOperLogCount(operCond);
	}

	/**
	 * 查找根据userId与日志数
	 */
	@Override
	public List<Map> findByUserIdAndLogCount(OperLogCond operCond)
			throws RuntimeException {
		return operLogMapper.findByUserIdAndLogCount(operCond);
	}

	/**
	 * 根据项目查找
	 */
	@Override
	public List<Map> findByProjectId(OperLogCond operCond)
			throws RuntimeException {
		return operLogMapper.findByProjectId(operCond);
	}
}
