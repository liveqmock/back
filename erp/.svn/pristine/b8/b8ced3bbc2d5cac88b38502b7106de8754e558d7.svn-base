package com.ihk.saleunit.data.services.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.saleunit.data.IPropertyProjectPlanMapper;
import com.ihk.saleunit.data.pojo.PropertyProjectPlan;
import com.ihk.saleunit.data.pojo.PropertyProjectPlanCond;
import com.ihk.saleunit.data.services.IPropertyProjectPlanServices;

import com.ihk.utils.base.PojoDeleteCond;

/**
 * PropertyProjectPlan的Services实现(业务实现)
 * @author 
 *
 */
@Service("propertyProjectPlanServices")
@SuppressWarnings("unchecked")
public class PropertyProjectPlanServices implements IPropertyProjectPlanServices {
	/**
	 * propertyProjectPlan数据访问接口
	 */
	@Autowired	 IPropertyProjectPlanMapper propertyProjectPlanMapper;

	/**
	 * 删除一条PropertyProjectPlan
	 * @param id
	 */
	public void deletePropertyProjectPlan(int id) throws RuntimeException {
		propertyProjectPlanMapper.deletePropertyProjectPlan(new PojoDeleteCond(id));
	}

	/**
	 * 新增PropertyProjectPlan
	 * @param propertyProjectPlan
	 */
	public void addPropertyProjectPlan(PropertyProjectPlan propertyProjectPlan) throws RuntimeException {		
		propertyProjectPlanMapper.addPropertyProjectPlan(propertyProjectPlan);
	}

	/**
	 * 查找一条PropertyProjectPlan
	 * @return PropertyProjectPlan
	 * @param id 主键id
	 */
	@Override
	public PropertyProjectPlan findPropertyProjectPlanById(int id) throws RuntimeException {
		return propertyProjectPlanMapper.findPropertyProjectPlanById(id);
	}

	/**
	 * 修改PropertyProjectPlan
	 * @param propertyProjectPlan
	 */
	@Override
	public void updatePropertyProjectPlan(PropertyProjectPlan propertyProjectPlan) throws RuntimeException {
		propertyProjectPlanMapper.updatePropertyProjectPlan(propertyProjectPlan);		
	}

	/**
	 * 分页查找PropertyProjectPlan
	 * @param cond 查询条件
	 * @return PropertyProjectPlan列表
	 */
	public List<PropertyProjectPlan> findPropertyProjectPlanPage(PropertyProjectPlanCond cond) throws RuntimeException {
		int recordCount = propertyProjectPlanMapper.findPropertyProjectPlanCount(cond);
		
		cond.recordCount = recordCount;
				
		return propertyProjectPlanMapper.findPropertyProjectPlanPage(cond);
	}

	/**
	 * 查找全部PropertyProjectPlan
	 * @param cond 查询条件
	 * @return PropertyProjectPlan列表
	 */
	public List<PropertyProjectPlan> findPropertyProjectPlan(PropertyProjectPlanCond cond) throws RuntimeException {
    	return propertyProjectPlanMapper.findPropertyProjectPlan(cond);
	}
}
