package com.ihk.saleunit.data.services.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.saleunit.data.IReportDefineTypeMapper;
import com.ihk.saleunit.data.pojo.ReportDefineType;
import com.ihk.saleunit.data.pojo.ReportDefineTypeCond;
import com.ihk.saleunit.data.services.IReportDefineTypeServices;

import com.ihk.utils.base.PojoDeleteCond;

/**
 * ReportDefineType的Services实现(业务实现)
 * @author 
 *
 */
@Service("reportDefineTypeServices")
@SuppressWarnings("unchecked")
public class ReportDefineTypeServices implements IReportDefineTypeServices {
	/**
	 * reportDefineType数据访问接口
	 */
	@Autowired	 IReportDefineTypeMapper reportDefineTypeMapper;

	/**
	 * 删除一条ReportDefineType
	 * @param id
	 */
	public void deleteReportDefineType(int id) throws RuntimeException {
		reportDefineTypeMapper.deleteReportDefineType(new PojoDeleteCond(id));
	}

	/**
	 * 新增ReportDefineType
	 * @param reportDefineType
	 */
	public void addReportDefineType(ReportDefineType reportDefineType) throws RuntimeException {		
		reportDefineTypeMapper.addReportDefineType(reportDefineType);
	}

	/**
	 * 查找一条ReportDefineType
	 * @return ReportDefineType
	 * @param id 主键id
	 */
	@Override
	public ReportDefineType findReportDefineTypeById(int id) throws RuntimeException {
		return reportDefineTypeMapper.findReportDefineTypeById(id);
	}

	/**
	 * 修改ReportDefineType
	 * @param reportDefineType
	 */
	@Override
	public void updateReportDefineType(ReportDefineType reportDefineType) throws RuntimeException {
		reportDefineTypeMapper.updateReportDefineType(reportDefineType);		
	}

	/**
	 * 分页查找ReportDefineType
	 * @param cond 查询条件
	 * @return ReportDefineType列表
	 */
	public List<ReportDefineType> findReportDefineTypePage(ReportDefineTypeCond cond) throws RuntimeException {
		int recordCount = reportDefineTypeMapper.findReportDefineTypeCount(cond);
		
		cond.recordCount = recordCount;
				
		return reportDefineTypeMapper.findReportDefineTypePage(cond);
	}

	/**
	 * 查找全部ReportDefineType
	 * @param cond 查询条件
	 * @return ReportDefineType列表
	 */
	public List<ReportDefineType> findReportDefineType(ReportDefineTypeCond cond) throws RuntimeException {
    	return reportDefineTypeMapper.findReportDefineType(cond);
	}
}
