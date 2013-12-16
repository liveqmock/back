package com.ihk.saleunit.data.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.saleunit.data.IAppointBillMapper;
import com.ihk.saleunit.data.pojo.AppointBill;
import com.ihk.saleunit.data.pojo.AppointBillCond;
import com.ihk.saleunit.data.services.IAppointBillServices;

/**
 * AppointBill的Services实现(业务实现)
 * @author 
 *
 */
@Service("appointBillServices")
public class AppointBillServices implements IAppointBillServices {
	/**
	 * appointBill数据访问接口
	 */
	@Autowired	 IAppointBillMapper appointBillMapper;

	/**
	 * 删除一条AppointBill
	 * @param id
	 */
	public void deleteAppointBill(int id) throws RuntimeException {
		appointBillMapper.deleteAppointBill(id);
	}

	/**
	 * 新增AppointBill
	 * @param appointBill
	 */
	public void addAppointBill(AppointBill appointBill) throws RuntimeException {		
		appointBillMapper.addAppointBill(appointBill);
	}

	/**
	 * 查找一条AppointBill
	 * @return AppointBill
	 * @param id 主键id
	 */
	@Override
	public AppointBill findAppointBillById(int id) throws RuntimeException {
		return appointBillMapper.findAppointBillById(id);
	}

	/**
	 * 修改AppointBill
	 * @param appointBill
	 */
	@Override
	public void updateAppointBill(AppointBill appointBill) throws RuntimeException {
		appointBillMapper.updateAppointBill(appointBill);		
	}

	/**
	 * 分页查找AppointBill
	 * @param cond 查询条件
	 * @return AppointBill列表
	 */
	public List<AppointBill> findAppointBillPage(AppointBillCond cond) throws RuntimeException {
		int recordCount = appointBillMapper.findAppointBillCount(cond);
		
		cond.recordCount = recordCount;
				
		return appointBillMapper.findAppointBillPage(cond);
	}

	/**
	 * 查找全部AppointBill
	 * @param cond 查询条件
	 * @return AppointBill列表
	 */
	public List<AppointBill> findAppointBill(AppointBillCond cond) throws RuntimeException {
    	return appointBillMapper.findAppointBill(cond);
	}

	/**
	 * 根据appointId查找
	 */
	@Override
	public List<AppointBill> findAppointBillByAppointId(int appointId)
			throws RuntimeException {
		
		return appointBillMapper.findAppointBillByAppointId(appointId);
	}

}
