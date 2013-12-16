package com.ihk.saleunit.data;

import java.util.List;
import java.util.Map;

import com.ihk.saleunit.data.pojo.Appoint;
import com.ihk.saleunit.data.pojo.AppointCond;

/**
 * Appoint数据访问接口Mapper
 * @author 
 *
 */ 
public interface IAppointMapper {

	/**
	 * 新增Appoint
	 * @param appoint
	 */
	public void addAppoint(Appoint appoint) ;

	/**
	 * 根据条件删除Appoint
	 * @param cond 删除条件
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
	 * 查找,根据detailId
	 * @param detailId
	 * @return
	 * @throws RuntimeException
	 */
	public Appoint findAppointByDetailId(int detailId) throws RuntimeException;
	
	/**
	 * 查找,根据unitId
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
	public List<Appoint> findAppointPage(AppointCond cond) ;

	/**
	 * 查找全部Appoint
	 * @param cond 查询条件
	 * @return Appoint列表
	 */
	public List<Appoint> findAppoint(AppointCond cond) ;

	/**
	 * 查找符合条件的记录条数Appoint
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findAppointCount(AppointCond cond) ;
	
	/**
	 * 更新Appoint的ConfirmId
	 * @param map
	 * @throws RuntimeException
	 */
	public void updateAppointSetConfirmId(Map<String, Integer> map) throws RuntimeException;
	
	/**
	 * 查找公司报表
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public List<Map<String, Object>> findCompanyReport(AppointCond cond) throws RuntimeException;
	
	/**
	 * 查找项目报表
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public List<Map<String, Object>> findPropertyReport(AppointCond cond) throws RuntimeException;
	
}
