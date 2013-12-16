package com.ihk.property.data.services.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.property.data.IPropertyDeveloperMapper;
import com.ihk.property.data.pojo.PropertyDeveloper;
import com.ihk.property.data.pojo.PropertyDeveloperCond;
import com.ihk.property.data.services.IPropertyDeveloperServices;

/**
 * PropertyDeveloper的Services实现(业务实现)
 * @author 
 *
 */
@Service("propertyDeveloperServices")
public class PropertyDeveloperServices implements IPropertyDeveloperServices {
	/**
	 * propertyDeveloper数据访问接口
	 */
	@Autowired	 IPropertyDeveloperMapper propertyDeveloperMapper;

	/**
	 * 删除一条PropertyDeveloper
	 * @param id
	 */
	public void deletePropertyDeveloper(int id) throws RuntimeException {
		propertyDeveloperMapper.deletePropertyDeveloper(id);
	}

	/**
	 * 新增PropertyDeveloper
	 * @param propertyDeveloper
	 */
	public void addPropertyDeveloper(PropertyDeveloper propertyDeveloper) throws RuntimeException {		
		propertyDeveloperMapper.addPropertyDeveloper(propertyDeveloper);
	}

	/**
	 * 查找一条PropertyDeveloper
	 * @return PropertyDeveloper
	 * @param id 主键id
	 */
	@Override
	public PropertyDeveloper findPropertyDeveloperById(int id) throws RuntimeException {
		return propertyDeveloperMapper.findPropertyDeveloperById(id);
	}


	/**
	 * 修改PropertyDeveloper
	 * @param propertyDeveloper
	 */
	@Override
	public void updatePropertyDeveloper(PropertyDeveloper propertyDeveloper) throws RuntimeException {
		propertyDeveloperMapper.updatePropertyDeveloper(propertyDeveloper);		
	}

    
	/**
	 * 分页查找PropertyDeveloper
	 * @param cond 查询条件
	 * @return PropertyDeveloper列表
	 */
	public List<PropertyDeveloper> findPropertyDeveloperPage(PropertyDeveloperCond cond) throws RuntimeException {
		int recordCount = propertyDeveloperMapper.findPropertyDeveloperCount(cond);
		
		cond.recordCount = recordCount;
				
		return propertyDeveloperMapper.findPropertyDeveloperPage(cond);
	}

	/**
	 * 查找全部PropertyDeveloper
	 * @param cond 查询条件
	 * @return PropertyDeveloper列表
	 */
	public List<PropertyDeveloper> findPropertyDeveloper(PropertyDeveloperCond cond) throws RuntimeException {
    	return propertyDeveloperMapper.findPropertyDeveloper(cond);
	}

	/**
	 * 符合条件的记录条数
	 */
	@Override
	public int findPropertyDeveloperCount(PropertyDeveloperCond cond)
			throws RuntimeException {
		return propertyDeveloperMapper.findPropertyDeveloperCount(cond);
	}
}
