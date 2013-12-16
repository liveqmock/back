package com.ihk.sale.data.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.sale.data.ISaleMonitorLogbeforeMapper;
import com.ihk.sale.data.pojo.SaleMonitorLogbefore;
import com.ihk.sale.data.pojo.SaleMonitorLogbeforeCond;
import com.ihk.sale.data.services.ISaleMonitorLogbeforeServices;
import com.ihk.utils.DateTimeUtils;

/**
 * SaleMonitorLogbefore的Services实现(业务实现)
 * @author 
 *
 */
@Service("saleMonitorLogbeforeServices")
public class SaleMonitorLogbeforeServices implements ISaleMonitorLogbeforeServices {

	/**
	 * saleMonitorLogbefore数据访问接口
	 */
	@Autowired	 ISaleMonitorLogbeforeMapper saleMonitorLogbeforeMapper;

	/**
	 * 删除一条SaleMonitorLogbefore
	 * @param id
	 */
	public void deleteSaleMonitorLogbefore(int id) throws RuntimeException {
		saleMonitorLogbeforeMapper.deleteSaleMonitorLogbefore(id);
	}


	/**
	 * 新增SaleMonitorLogbefore
	 * @param saleMonitorLogbefore
	 */
	public void addSaleMonitorLogbefore(SaleMonitorLogbefore saleMonitorLogbefore) throws RuntimeException {		
		
		SaleMonitorLogbeforeCond cond = new SaleMonitorLogbeforeCond();
		String dateString = DateTimeUtils.getDateFormatStr(saleMonitorLogbefore.getModTime()).substring(5);
		System.out.println(dateString);
		cond.setModTime(dateString);
		cond.setDateId(saleMonitorLogbefore.getDataId());
		List list = saleMonitorLogbeforeMapper.findOneDay(cond);
		System.out.println(list.size());
		if(list.size() == 0 || list == null){
			saleMonitorLogbeforeMapper.addSaleMonitorLogbefore(saleMonitorLogbefore);
		}
		
		
	}

	/**
	 * 查找一条SaleMonitorLogbefore
	 * @return SaleMonitorLogbefore
	 * @param id 主键id
	 */
	@Override
	public SaleMonitorLogbefore findSaleMonitorLogbeforeById(int id) throws RuntimeException {
		return saleMonitorLogbeforeMapper.findSaleMonitorLogbeforeById(id);
	}

	/**
	 * 修改SaleMonitorLogbefore
	 * @param saleMonitorLogbefore
	 */
	@Override
	public void updateSaleMonitorLogbefore(SaleMonitorLogbefore saleMonitorLogbefore) throws RuntimeException {
		saleMonitorLogbeforeMapper.updateSaleMonitorLogbefore(saleMonitorLogbefore);		
	}

	/**
	 * 分页查找SaleMonitorLogbefore
	 * @param cond 查询条件
	 * @return SaleMonitorLogbefore列表
	 */
	public List<SaleMonitorLogbefore> findSaleMonitorLogbeforePage(SaleMonitorLogbeforeCond cond) throws RuntimeException {
		int recordCount = saleMonitorLogbeforeMapper.findSaleMonitorLogbeforeCount(cond);
		
		cond.recordCount = recordCount;
				
		return saleMonitorLogbeforeMapper.findSaleMonitorLogbeforePage(cond);
	}

	/**
	 * 查找全部SaleMonitorLogbefore
	 * @param cond 查询条件
	 * @return SaleMonitorLogbefore列表
	 */
	public List<SaleMonitorLogbefore> findSaleMonitorLogbefore(SaleMonitorLogbeforeCond cond) throws RuntimeException {
    	return saleMonitorLogbeforeMapper.findSaleMonitorLogbefore(cond);
	}

	/**
	 * 查找，用于定时器
	 */
	@Override
	public List<SaleMonitorLogbefore> findSaleMonitorLogbeforeForQuartz(
			SaleMonitorLogbeforeCond cond) throws Exception {
		return saleMonitorLogbeforeMapper.findSaleMonitorLogbeforeForQuartz(cond);
	}
}
