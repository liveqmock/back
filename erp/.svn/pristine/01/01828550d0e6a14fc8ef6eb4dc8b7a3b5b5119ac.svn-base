package com.ihk.saleunit.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.saleunit.data.pojo.AppointBill;
import com.ihk.saleunit.data.pojo.AppointBillCond;

/**
 * AppointBill的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
public interface IAppointBillServices {
	/**
	 * 新增AppointBill
	 * @param appointBill
	 */
	public void addAppointBill(AppointBill appointBill) throws RuntimeException;

	/**
	 * 删除一条AppointBill
	 * @param id
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
	public List<AppointBill> findAppointBillPage(AppointBillCond cond) throws RuntimeException;

	/**
	 * 查找全部AppointBill
	 * @param cond 查询条件
	 * @return AppointBill列表
	 */
	public List<AppointBill> findAppointBill(AppointBillCond cond) throws RuntimeException;
	
	/**
	 * 根据appointId查找
	 * @param appointId
	 * @return
	 * @throws RuntimeException
	 */
	public List<AppointBill> findAppointBillByAppointId(int appointId) throws RuntimeException;
	
}