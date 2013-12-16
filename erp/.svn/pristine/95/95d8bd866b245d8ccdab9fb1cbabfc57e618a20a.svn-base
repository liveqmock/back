package com.ihk.saleunit.data.services.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.saleunit.data.IAppointMapper;
import com.ihk.saleunit.data.pojo.Appoint;
import com.ihk.saleunit.data.pojo.AppointCond;
import com.ihk.saleunit.data.services.IAppointServices;

/**
 * Appoint的Services实现(业务实现)
 * @author 
 *
 */
@Service("appointServices")
public class AppointServices implements IAppointServices {
	/**
	 * appoint数据访问接口
	 */
	@Autowired	 IAppointMapper appointMapper;

	/**
	 * 删除一条Appoint
	 * @param id
	 */
	public void deleteAppoint(int id) throws RuntimeException {
		appointMapper.deleteAppoint(id);
	}

	/**
	 * 新增Appoint
	 * @param appoint
	 */
	public void addAppoint(Appoint appoint) throws RuntimeException {		
		appointMapper.addAppoint(appoint);
	}

	/**
	 * 查找一条Appoint
	 * @return Appoint
	 * @param id 主键id
	 */
	@Override
	public Appoint findAppointById(int id) throws RuntimeException {
		return appointMapper.findAppointById(id);
	}

	/**
	 * 修改Appoint
	 * @param appoint
	 */
	@Override
	public void updateAppoint(Appoint appoint) throws RuntimeException {
		appointMapper.updateAppoint(appoint);		
	}

	/**
	 * 分页查找Appoint
	 * @param cond 查询条件
	 * @return Appoint列表
	 */
	public List<Appoint> findAppointPage(AppointCond cond) throws RuntimeException {
		int recordCount = appointMapper.findAppointCount(cond);
		
		cond.recordCount = recordCount;
				
		return appointMapper.findAppointPage(cond);
	}

	/**
	 * 查找全部Appoint
	 * @param cond 查询条件
	 * @return Appoint列表
	 */
	public List<Appoint> findAppoint(AppointCond cond) throws RuntimeException {
    	return appointMapper.findAppoint(cond);
	}

	/**
	 * 更新appoint设置ConfirmId
	 */
	@Override
	public void updateAppointSetConfirmId(int appointId, int confirmId)
			throws RuntimeException {
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("appointId", appointId);
		map.put("confirmId", confirmId);
		
		appointMapper.updateAppointSetConfirmId(map);
	}

	/**
	 * 查找公司报表
	 */
	@Override
	public List<Map<String, Object>> findCompanyReport(AppointCond cond)
			throws RuntimeException {
		
		return appointMapper.findCompanyReport(cond);
	}
	

	/**
	 * 查找property报表
	 */
	@Override
	public List<Map<String, Object>> findPropertyReport(AppointCond cond)
			throws RuntimeException {
		
		return appointMapper.findPropertyReport(cond);
	}

	/**
	 * 根据detailId查找
	 */
	@Override
	public Appoint findAppointByDetailId(int detailId) throws RuntimeException {
		
		return appointMapper.findAppointByDetailId(detailId);
	}

	/**
	 * 根据unitId查找
	 */
	@Override
	public List<Appoint> findAppointByUnitId(int unitId)
			throws RuntimeException {
		
		return appointMapper.findAppointByUnitId(unitId);
	}
}
