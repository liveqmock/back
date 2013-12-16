package com.ihk.property.data.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.property.data.IPropertyAreaMapper;
import com.ihk.property.data.pojo.PropertyArea;
import com.ihk.property.data.pojo.PropertyAreaCond;
import com.ihk.property.data.services.IPropertyAreaServices;
import com.ihk.utils.DescUtils;

/**
 * PropertyArea的Services实现(业务实现)
 * @author 
 *
 */
@Service("propertyAreaServices")
public class PropertyAreaServices implements IPropertyAreaServices {
	/**
	 * propertyArea数据访问接口
	 */
	@Autowired	 IPropertyAreaMapper propertyAreaMapper;

	/**
	 * 删除一条PropertyArea
	 * @param id
	 */
	public void deletePropertyArea(int id) throws RuntimeException {
		propertyAreaMapper.deletePropertyArea(id);
	}

	/**
	 * 新增PropertyArea
	 * @param propertyArea
	 */
	public void addPropertyArea(PropertyArea propertyArea) throws RuntimeException {		
		
		int propertyId = propertyArea.getPropertyId();
		propertyArea.setCompanyProjectId(
					DescUtils.findPropertyProject(propertyId).getCompanyProjectId());
		
		propertyAreaMapper.addPropertyArea(propertyArea);
	}

	/**
	 * 查找一条PropertyArea
	 * @return PropertyArea
	 * @param id 主键id
	 */
	@Override
	public PropertyArea findPropertyAreaById(int id) throws RuntimeException {
		return propertyAreaMapper.findPropertyAreaById(id);
	}


	/**
	 * 修改PropertyArea
	 * @param propertyArea
	 */
	@Override
	public void updatePropertyArea(PropertyArea propertyArea) throws RuntimeException {
		propertyAreaMapper.updatePropertyArea(propertyArea);		
	}

	/**
	 * 分页查找PropertyArea
	 * @param cond 查询条件
	 * @return PropertyArea列表
	 */
	public List<PropertyArea> findPropertyAreaPage(PropertyAreaCond cond) throws RuntimeException {
		int recordCount = propertyAreaMapper.findPropertyAreaCount(cond);
		
		cond.recordCount = recordCount;
				
		return propertyAreaMapper.findPropertyAreaPage(cond);
	}

	/**
	 * 查找全部PropertyArea
	 * @param cond 查询条件
	 * @return PropertyArea列表
	 */
	public List<PropertyArea> findPropertyArea(PropertyAreaCond cond) throws RuntimeException {
    	return propertyAreaMapper.findPropertyArea(cond);
	}

	/**
	 * 符合要求的记录条数
	 */
	@Override
	public int findPropertyAreaCount(PropertyAreaCond cond)
			throws RuntimeException {
		return propertyAreaMapper.findPropertyAreaCount(cond);
	}
}
