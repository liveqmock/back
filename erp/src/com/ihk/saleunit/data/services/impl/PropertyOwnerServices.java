package com.ihk.saleunit.data.services.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.saleunit.data.IPropertyOwnerMapper;
import com.ihk.saleunit.data.pojo.PropertyOwner;
import com.ihk.saleunit.data.pojo.PropertyOwnerCond;
import com.ihk.saleunit.data.services.IPropertyOwnerServices;

/**
 * PropertyOwner的Services实现(业务实现)
 * @author 
 *
 */
@Service("propertyOwnerServices")
@SuppressWarnings("unchecked")
public class PropertyOwnerServices implements IPropertyOwnerServices {
	/**
	 * propertyOwner数据访问接口
	 */
	@Autowired	 IPropertyOwnerMapper propertyOwnerMapper;

	/**
	 * 删除一条PropertyOwner
	 * @param id
	 */
	public void deletePropertyOwner(int id) throws RuntimeException {
		propertyOwnerMapper.deletePropertyOwner(id);
	}

	/**
	 * 新增PropertyOwner
	 * @param propertyOwner
	 */
	public void addPropertyOwner(PropertyOwner propertyOwner) throws RuntimeException {		
		propertyOwnerMapper.addPropertyOwner(propertyOwner);
	}

	/**
	 * 查找一条PropertyOwner
	 * @return PropertyOwner
	 * @param id 主键id
	 */
	@Override
	public PropertyOwner findPropertyOwnerById(int id) throws RuntimeException {
		return propertyOwnerMapper.findPropertyOwnerById(id);
	}

	/**
	 * 修改PropertyOwner
	 * @param propertyOwner
	 */
	@Override
	public void updatePropertyOwner(PropertyOwner propertyOwner) throws RuntimeException {
		propertyOwnerMapper.updatePropertyOwner(propertyOwner);		
	}

	/**
	 * 分页查找PropertyOwner
	 * @param cond 查询条件
	 * @return PropertyOwner列表
	 */
	public List<PropertyOwner> findPropertyOwnerPage(PropertyOwnerCond cond) throws RuntimeException {
		int recordCount = propertyOwnerMapper.findPropertyOwnerCount(cond);
		
		cond.recordCount = recordCount;
				
		return propertyOwnerMapper.findPropertyOwnerPage(cond);
	}

	/**
	 * 查找全部PropertyOwner
	 * @param cond 查询条件
	 * @return PropertyOwner列表
	 */
	public List<PropertyOwner> findPropertyOwner(PropertyOwnerCond cond) throws RuntimeException {
    	return propertyOwnerMapper.findPropertyOwner(cond);
	}
}
