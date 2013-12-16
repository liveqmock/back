package com.ihk.saleunit.data;

import java.util.List;

import com.ihk.saleunit.data.pojo.AppointBill;
import com.ihk.saleunit.data.pojo.AppointBillCond;

/**
 * AppointBill数据访问接口Mapper
 * @author 
 *
 */ 
public interface IAppointBillMapper {

	/**
	 * 新增AppointBill
	 * @param appointBill
	 */
	public void addAppointBill(AppointBill appointBill) ;

	/**
	 * 根据条件删除AppointBill
	 * @param cond 删除条件
	 */
	public void deleteAppointBill(int id) throws RuntimeException;

	/**
	 * 修改AppointBill
	 * @param appointBill
	 */
	public void updateAppointBill(AppointBill appointBill) throws RuntimeException;

	/**
	 * 查找一条AppointBill
	 * @return AppointBill
	 * @param id 主键id
	 */
	public AppointBill findAppointBillById(int id) throws RuntimeException;
	  
	/**
	 * 分页查找AppointBill
	 * @param cond 查询条件
	 * @return AppointBill列表
	 */
	public List<AppointBill> findAppointBillPage(AppointBillCond cond) ;

	/**
	 * 查找全部AppointBill
	 * @param cond 查询条件
	 * @return AppointBill列表
	 */
	public List<AppointBill> findAppointBill(AppointBillCond cond) ;

	/**
	 * 查找符合条件的记录条数AppointBill
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findAppointBillCount(AppointBillCond cond) ;
	
	/**
	 * 根据appointId查找
	 * @param appointId
	 * @return
	 * @throws RuntimeException
	 */
	public List<AppointBill> findAppointBillByAppointId(int appointId) throws RuntimeException;
	
}
