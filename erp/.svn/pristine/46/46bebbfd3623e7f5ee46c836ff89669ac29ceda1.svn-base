package com.ihk.sale.data.services.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.sale.data.IPresaleMonitorAllMapper;
import com.ihk.sale.data.pojo.PresaleMonitorAll;
import com.ihk.sale.data.pojo.PresaleMonitorAllCond;
import com.ihk.sale.data.services.IPresaleMonitorAllServices;

/**
 * PresaleMonitorAll的Services实现(业务实现)
 * @author 
 *
 */
@Service("presaleMonitorAllServices")
@SuppressWarnings("unchecked")
public class PresaleMonitorAllServices implements IPresaleMonitorAllServices {

	/**
	 * presaleMonitorAll数据访问接口
	 */
	@Autowired	 IPresaleMonitorAllMapper presaleMonitorAllMapper;

	/**
	 * 删除一条PresaleMonitorAll
	 * @param id
	 */
	public void deletePresaleMonitorAll(int id) throws RuntimeException {
		presaleMonitorAllMapper.deletePresaleMonitorAll(id);
	}

	/**
	 * 新增PresaleMonitorAll
	 * @param presaleMonitorAll
	 */
	public void addPresaleMonitorAll(PresaleMonitorAll presaleMonitorAll) throws RuntimeException {		
		presaleMonitorAllMapper.addPresaleMonitorAll(presaleMonitorAll);
	}

	/**
	 * 查找一条PresaleMonitorAll
	 * @return PresaleMonitorAll
	 * @param id 主键id
	 */
	@Override
	public PresaleMonitorAll findPresaleMonitorAllById(int id) throws RuntimeException {
		return presaleMonitorAllMapper.findPresaleMonitorAllById(id);
	}


	/**
	 * 修改PresaleMonitorAll
	 * @param presaleMonitorAll
	 */
	@Override
	public void updatePresaleMonitorAll(PresaleMonitorAll presaleMonitorAll) throws RuntimeException {
		presaleMonitorAllMapper.updatePresaleMonitorAll(presaleMonitorAll);		
	}

	/**
	 * 分页查找PresaleMonitorAll
	 * @param cond 查询条件
	 * @return PresaleMonitorAll列表
	 */
	public List findPresaleMonitorAllPage(PresaleMonitorAllCond cond) throws RuntimeException {
		int recordCount = presaleMonitorAllMapper.findPresaleMonitorAllCount(cond);
		
		cond.recordCount = recordCount;
				
		return presaleMonitorAllMapper.findPresaleMonitorAllPage(cond);
	}
}
