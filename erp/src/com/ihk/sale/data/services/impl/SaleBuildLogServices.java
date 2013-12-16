package com.ihk.sale.data.services.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.sale.data.ISaleBuildLogMapper;
import com.ihk.sale.data.pojo.SaleBuildLog;
import com.ihk.sale.data.pojo.SaleBuildLogCond;
import com.ihk.sale.data.services.ISaleBuildLogServices;

/**
 * SaleBuildLog的Services实现(业务实现)
 * @author 
 *
 */
@Service("saleBuildLogServices")
@SuppressWarnings("unchecked")
public class SaleBuildLogServices implements ISaleBuildLogServices {

	/**
	 * saleBuildLog数据访问接口
	 */
	@Autowired	 ISaleBuildLogMapper saleBuildLogMapper;

	/**
	 * 删除一条SaleBuildLog
	 * @param id
	 */
	public void deleteSaleBuildLog(int id) throws RuntimeException {
		saleBuildLogMapper.deleteSaleBuildLog(id);
	}

	/**
	 * 新增SaleBuildLog
	 * @param saleBuildLog
	 */
	public void addSaleBuildLog(SaleBuildLog saleBuildLog) throws RuntimeException {		
		saleBuildLogMapper.addSaleBuildLog(saleBuildLog);
	}

	/**
	 * 查找一条SaleBuildLog
	 * @return SaleBuildLog
	 * @param id 主键id
	 */
	@Override
	public SaleBuildLog findSaleBuildLogById(int id) throws RuntimeException {
		return saleBuildLogMapper.findSaleBuildLogById(id);
	}

	/**
	 * 修改SaleBuildLog
	 * @param saleBuildLog
	 */
	@Override
	public void updateSaleBuildLog(SaleBuildLog saleBuildLog) throws RuntimeException {
		saleBuildLogMapper.updateSaleBuildLog(saleBuildLog);		
	}

	/**
	 * 分页查找SaleBuildLog
	 * @param cond 查询条件
	 * @return SaleBuildLog列表
	 */
	public List<SaleBuildLog> findSaleBuildLogPage(SaleBuildLogCond cond) throws RuntimeException {
		int recordCount = saleBuildLogMapper.findSaleBuildLogCount(cond);
		
		cond.recordCount = recordCount;
				
		return saleBuildLogMapper.findSaleBuildLogPage(cond);
	}

	/**
	 * 查找全部SaleBuildLog
	 * @param cond 查询条件
	 * @return SaleBuildLog列表
	 */
	public List<SaleBuildLog> findSaleBuildLog(SaleBuildLogCond cond) throws RuntimeException {
    	return saleBuildLogMapper.findSaleBuildLog(cond);
	}
}
