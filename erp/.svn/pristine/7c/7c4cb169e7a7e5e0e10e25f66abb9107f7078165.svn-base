package com.ihk.saleunit.data.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.saleunit.data.IAppointCustomerMapper;
import com.ihk.saleunit.data.pojo.AppointCustomer;
import com.ihk.saleunit.data.pojo.AppointCustomerCond;
import com.ihk.saleunit.data.services.IAppointCustomerServices;

/**
 * AppointCustomer的Services实现(业务实现)
 * @author 
 *
 */
@Service("appointCustomerServices")
public class AppointCustomerServices implements IAppointCustomerServices {
	/**
	 * appointCustomer数据访问接口
	 */
	@Autowired	 IAppointCustomerMapper appointCustomerMapper;

	/**
	 * 删除一条AppointCustomer
	 * @param id
	 */
	public void deleteAppointCustomer(int id) throws RuntimeException {
		appointCustomerMapper.deleteAppointCustomer(id);
	}

	/**
	 * 新增AppointCustomer
	 * @param appointCustomer
	 */
	public void addAppointCustomer(AppointCustomer appointCustomer) throws RuntimeException {		
		appointCustomerMapper.addAppointCustomer(appointCustomer);
	}

	/**
	 * 查找一条AppointCustomer
	 * @return AppointCustomer
	 * @param id 主键id
	 */
	@Override
	public AppointCustomer findAppointCustomerById(int id) throws RuntimeException {
		return appointCustomerMapper.findAppointCustomerById(id);
	}

	/**
	 * 修改AppointCustomer
	 * @param appointCustomer
	 */
	@Override
	public void updateAppointCustomer(AppointCustomer appointCustomer) throws RuntimeException {
		appointCustomerMapper.updateAppointCustomer(appointCustomer);		
	}

	/**
	 * 分页查找AppointCustomer
	 * @param cond 查询条件
	 * @return AppointCustomer列表
	 */
	public List<AppointCustomer> findAppointCustomerPage(AppointCustomerCond cond) throws RuntimeException {
		int recordCount = appointCustomerMapper.findAppointCustomerCount(cond);
		
		cond.recordCount = recordCount;
				
		return appointCustomerMapper.findAppointCustomerPage(cond);
	}

	/**
	 * 查找全部AppointCustomer
	 * @param cond 查询条件
	 * @return AppointCustomer列表
	 */
	public List<AppointCustomer> findAppointCustomer(AppointCustomerCond cond) throws RuntimeException {
    	return appointCustomerMapper.findAppointCustomer(cond);
	}

	/**
	 * 根据名称查找
	 */
	@Override
	public List<AppointCustomer> findAppointCustomerLikeName(String cusotmerName)
			throws RuntimeException {
		
		return appointCustomerMapper.findAppointCustomerLikeName(cusotmerName);
	}
}
