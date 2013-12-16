package com.ihk.saleunit.data;

import java.util.List;

import com.ihk.saleunit.data.pojo.AppointCustomer;
import com.ihk.saleunit.data.pojo.AppointCustomerCond;

/**
 * AppointCustomer数据访问接口Mapper
 * @author 
 *
 */ 
public interface IAppointCustomerMapper {

	/**
	 * 新增AppointCustomer
	 * @param appointCustomer
	 */
	public void addAppointCustomer(AppointCustomer appointCustomer) ;

	/**
	 * 根据条件删除AppointCustomer
	 * @param cond 删除条件
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
	public List<AppointCustomer> findAppointCustomerPage(AppointCustomerCond cond) ;

	/**
	 * 查找全部AppointCustomer
	 * @param cond 查询条件
	 * @return AppointCustomer列表
	 */
	public List<AppointCustomer> findAppointCustomer(AppointCustomerCond cond) ;

	/**
	 * 查找符合条件的记录条数AppointCustomer
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findAppointCustomerCount(AppointCustomerCond cond) ;
	
	/**
	 * 根据cusotmerName模糊查找
	 * @param cusotmerName
	 * @return
	 * @throws RuntimeException
	 */
	public List<AppointCustomer> findAppointCustomerLikeName(String cusotmerName) throws RuntimeException;
}
