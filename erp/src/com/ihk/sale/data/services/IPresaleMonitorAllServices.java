package com.ihk.sale.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.sale.data.pojo.PresaleMonitorAll;
import com.ihk.sale.data.pojo.PresaleMonitorAllCond;

/**
 * PresaleMonitorAll的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
@SuppressWarnings("unchecked")
public interface IPresaleMonitorAllServices {

	/**
	 * 新增PresaleMonitorAll
	 * @param presaleMonitorAll
	 */
	public void addPresaleMonitorAll(PresaleMonitorAll presaleMonitorAll) throws RuntimeException;

	/**
	 * 删除一条PresaleMonitorAll
	 * @param id
	 */
	public void deletePresaleMonitorAll(int id) throws RuntimeException;

	/**
	 * 修改PresaleMonitorAll
	 * @param presaleMonitorAll
	 */
	public void updatePresaleMonitorAll(PresaleMonitorAll presaleMonitorAll) throws RuntimeException;

	/**
	 * 查找一条PresaleMonitorAll
	 * @return PresaleMonitorAll
	 * @param id 主键id
	 */
	public PresaleMonitorAll findPresaleMonitorAllById(int id) throws RuntimeException;

	/**
	 * 分页查找PresaleMonitorAll
	 * @param cond 查询条件
	 * @return PresaleMonitorAll列表
	 */
	public List findPresaleMonitorAllPage(PresaleMonitorAllCond cond) throws RuntimeException;
}