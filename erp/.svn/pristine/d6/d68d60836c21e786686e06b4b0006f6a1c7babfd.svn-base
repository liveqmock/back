package com.ihk.saleunit.data.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.saleunit.data.IAppointBillDetailMapper;
import com.ihk.saleunit.data.pojo.AppointBillDetail;
import com.ihk.saleunit.data.pojo.AppointBillDetailCond;
import com.ihk.saleunit.data.services.IAppointBillDetailServices;

/**
 * AppointBillDetail的Services实现(业务实现)
 * @author 
 *
 */
@Service("appointBillDetailServices")
public class AppointBillDetailServices implements IAppointBillDetailServices {
	/**
	 * appointBillDetail数据访问接口
	 */
	@Autowired	 IAppointBillDetailMapper appointBillDetailMapper;

	/**
	 * 删除一条AppointBillDetail
	 * @param id
	 */
	public void deleteAppointBillDetail(int id) throws RuntimeException {
		appointBillDetailMapper.deleteAppointBillDetail(id);
	}

	/**
	 * 新增AppointBillDetail
	 * @param appointBillDetail
	 */
	public void addAppointBillDetail(AppointBillDetail appointBillDetail) throws RuntimeException {		
		appointBillDetailMapper.addAppointBillDetail(appointBillDetail);
	}

	/**
	 * 查找一条AppointBillDetail
	 * @return AppointBillDetail
	 * @param id 主键id
	 */
	@Override
	public AppointBillDetail findAppointBillDetailById(int id) throws RuntimeException {
		return appointBillDetailMapper.findAppointBillDetailById(id);
	}

	/**
	 * 修改AppointBillDetail
	 * @param appointBillDetail
	 */
	@Override
	public void updateAppointBillDetail(AppointBillDetail appointBillDetail) throws RuntimeException {
		appointBillDetailMapper.updateAppointBillDetail(appointBillDetail);		
	}

	/**
	 * 分页查找AppointBillDetail
	 * @param cond 查询条件
	 * @return AppointBillDetail列表
	 */
	public List<AppointBillDetail> findAppointBillDetailPage(AppointBillDetailCond cond) throws RuntimeException {
		int recordCount = appointBillDetailMapper.findAppointBillDetailCount(cond);
		
		cond.recordCount = recordCount;
				
		return appointBillDetailMapper.findAppointBillDetailPage(cond);
	}

	/**
	 * 查找全部AppointBillDetail
	 * @param cond 查询条件
	 * @return AppointBillDetail列表
	 */
	public List<AppointBillDetail> findAppointBillDetail(AppointBillDetailCond cond) throws RuntimeException {
    	return appointBillDetailMapper.findAppointBillDetail(cond);
	}

	/**
	 * 查找，根据billId
	 */
	@Override
	public List<AppointBillDetail> findDetailByAppointBillId(int billId)
			throws RuntimeException {
		return appointBillDetailMapper.findDetailByAppointBillId(billId);
	}
}
