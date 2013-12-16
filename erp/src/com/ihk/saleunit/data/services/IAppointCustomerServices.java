package com.ihk.saleunit.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.saleunit.data.pojo.AppointCustomer;
import com.ihk.saleunit.data.pojo.AppointCustomerCond;

/**
 * AppointCustomer的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
public interface IAppointCustomerServices {
	/**
	 * 新增AppointCustomer
	 * @param appointCustomer
	 */
	public void addAppointCustomer(AppointCustomer appointCustomer) throws RuntimeException;

	/**
	 * 删除一条AppointCustomer
	 * @param id
	 */
	public void deleteAppointCustomer(int id) throws RuntimeException;

	/**
	 * 修改AppointCustomer
	 * @param appointCustomer
	 */
	public void updateAppointCustomer(AppointCustomer appointCustomer) throws RuntimeException;

	/**
	 * 查找一条AppointCustomer
	 * @return AppointCustomer
	 * @param id 主键id
	 */
	public AppointCustomer findAppointCustomerById(int id) throws RuntimeException;

	/**
	 * 分页查找AppointCustomer
	 * @param cond 查询条件
	 * @return AppointCustomer列表
	 */
	public List<AppointCustomer> findAppointCustomerPage(AppointCustomerCond cond) throws RuntimeException;

	/**
	 * 查找全部AppointCustomer
	 * @param cond 查询条件
	 * @return AppointCustomer列表
	 */
	public List<AppointCustomer> findAppointCustomer(AppointCustomerCond cond) throws RuntimeException;
	
	/**
	 * 根据cusotmerName模糊查询
	 * @param cusotmerName
	 * @return
	 * @throws RuntimeException
	 */
	public List<AppointCustomer> findAppointCustomerLikeName(String cusotmerName) throws RuntimeException;
	
}