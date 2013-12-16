package com.ihk.saleunit.data.services;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.saleunit.data.pojo.Appoint;
import com.ihk.saleunit.data.pojo.AppointCond;

/**
 * Appoint的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
public interface IAppointServices {
	/**
	 * 新增Appoint
	 * @param appoint
	 */
	public void addAppoint(Appoint appoint) throws RuntimeException;

	/**
	 * 删除一条Appoint
	 * @param id
	 */
	public void deleteAppoint(int id) throws RuntimeException;

	/**
	 * 修改Appoint
	 * @param appoint
	 */
	public void updateAppoint(Appoint appoint) throws RuntimeException;

	/**
	 * 查找一条Appoint
	 * @return Appoint
	 * @param id 主键id
	 */
	public Appoint findAppointById(int id) throws RuntimeException;
	
	/**
	 * 根据detailId查找
	 * @param detailId
	 * @return
	 * @throws RuntimeException
	 */
	public Appoint findAppointByDetailId(int detailId) throws RuntimeException;
	
	/**
	 * 根据unitId查找
	 * @param unitId
	 * @return
	 * @throws RuntimeException
	 */
	public List<Appoint> findAppointByUnitId(int unitId) throws RuntimeException;

	/**
	 * 分页查找Appoint
	 * @param cond 查询条件
	 * @return Appoint列表
	 */
	public List<Appoint> findAppointPage(AppointCond cond) throws RuntimeException;

	/**
	 * 查找全部Appoint
	 * @param cond 查询条件
	 * @return Appoint列表
	 */
	public List<Appoint> findAppoint(AppointCond cond) throws RuntimeException;
	
	/**
	 * 修改confirmId
	 * @param appointId
	 * @param confirmId
	 * @throws RuntimeException
	 */
	public void updateAppointSetConfirmId(int appointId, int confirmId) throws RuntimeException;
	
	/**
	 * 查找公司报表
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public List<Map<String, Object>> findCompanyReport(AppointCond cond) throws RuntimeException;
	
	/**
	 * 查找楼盘报表
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public List<Map<String, Object>> findPropertyReport(AppointCond cond) throws RuntimeException;
	
}