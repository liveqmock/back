package com.ihk.saleunit.data.services.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.saleunit.data.IReportDefineColumnMapper;
import com.ihk.saleunit.data.pojo.ReportDefineColumn;
import com.ihk.saleunit.data.pojo.ReportDefineColumnCond;
import com.ihk.saleunit.data.services.IReportDefineColumnServices;

import com.ihk.utils.base.PojoDeleteCond;

/**
 * ReportDefineColumn的Services实现(业务实现)
 * @author 
 *
 */
@Service("reportDefineColumnServices")
@SuppressWarnings("unchecked")
public class ReportDefineColumnServices implements IReportDefineColumnServices {
	/**
	 * reportDefineColumn数据访问接口
	 */
	@Autowired	 IReportDefineColumnMapper reportDefineColumnMapper;

	/**
	 * 删除一条ReportDefineColumn
	 * @param id
	 */
	public void deleteReportDefineColumn(int id) throws RuntimeException {
		reportDefineColumnMapper.deleteReportDefineColumn(new PojoDeleteCond(id));
	}

	/**
	 * 新增ReportDefineColumn
	 * @param reportDefineColumn
	 */
	public void addReportDefineColumn(ReportDefineColumn reportDefineColumn) throws RuntimeException {		
		reportDefineColumnMapper.addReportDefineColumn(reportDefineColumn);
	}

	/**
	 * 查找一条ReportDefineColumn
	 * @return ReportDefineColumn
	 * @param id 主键id
	 */
	@Override
	public ReportDefineColumn findReportDefineColumnById(int id) throws RuntimeException {
		return reportDefineColumnMapper.findReportDefineColumnById(id);
	}

	/**
	 * 修改ReportDefineColumn
	 * @param reportDefineColumn
	 */
	@Override
	public void updateReportDefineColumn(ReportDefineColumn reportDefineColumn) throws RuntimeException {
		reportDefineColumnMapper.updateReportDefineColumn(reportDefineColumn);		
	}

	/**
	 * 分页查找ReportDefineColumn
	 * @param cond 查询条件
	 * @return ReportDefineColumn列表
	 */
	public List<ReportDefineColumn> findReportDefineColumnPage(ReportDefineColumnCond cond) throws RuntimeException {
		int recordCount = reportDefineColumnMapper.findReportDefineColumnCount(cond);
		
		cond.recordCount = recordCount;
				
		return reportDefineColumnMapper.findReportDefineColumnPage(cond);
	}

	/**
	 * 查找全部ReportDefineColumn
	 * @param cond 查询条件
	 * @return ReportDefineColumn列表
	 */
	public List<ReportDefineColumn> findReportDefineColumn(ReportDefineColumnCond cond) throws RuntimeException {
    	return reportDefineColumnMapper.findReportDefineColumn(cond);
	}

    
	/**
	 * 
	 */
	public List<ReportDefineColumn> findReportDefineColumnForY(ReportDefineColumnCond cond) throws RuntimeException {
    	return reportDefineColumnMapper.findReportDefineColumnForY(cond);
	}
	
	public List<Map> findReportDefineColumnAndType(ReportDefineColumnCond cond) throws RuntimeException {
		return reportDefineColumnMapper.findReportDefineColumnAndType(cond);
	}
}
