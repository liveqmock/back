package com.ihk.saleunit.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.saleunit.data.pojo.AppointBillDetail;
import com.ihk.saleunit.data.pojo.AppointBillDetailCond;

/**
 * AppointBillDetail的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
public interface IAppointBillDetailServices {
	/**
	 * 新增AppointBillDetail
	 * @param appointBillDetail
	 */
	public void addAppointBillDetail(AppointBillDetail appointBillDetail) throws RuntimeException;

	/**
	 * 删除一条AppointBillDetail
	 * @param id
	 */
	public void deleteAppointBillDetail(int id) throws RuntimeException;

	/**
	 * 修改AppointBillDetail
	 * @param appointBillDetail
	 */
	public void updateAppointBillDetail(AppointBillDetail appointBillDetail) throws RuntimeException;

	/**
	 * 查找一条AppointBillDetail
	 * @return AppointBillDetail
	 * @param id 主键id
	 */
	public AppointBillDetail findAppointBillDetailById(int id) throws RuntimeException;

	/**
	 * 分页查找AppointBillDetail
	 * @param cond 查询条件
	 * @return AppointBillDetail列表
	 */
	public List<AppointBillDetail> findAppointBillDetailPage(AppointBillDetailCond cond) throws RuntimeException;

	/**
	 * 查找全部AppointBillDetail
	 * @param cond 查询条件
	 * @return AppointBillDetail列表
	 */
	public List<AppointBillDetail> findAppointBillDetail(AppointBillDetailCond cond) throws RuntimeException;
	
	/**
	 * 根据billId查找
	 * @param billId
	 * @return
	 * @throws RuntimeException
	 */
	public List<AppointBillDetail> findDetailByAppointBillId(int billId) throws RuntimeException;
}