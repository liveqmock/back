package com.ihk.property.data.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.property.data.IPropertyGroupMapper;
import com.ihk.property.data.pojo.PropertyGroup;
import com.ihk.property.data.pojo.PropertyGroupCond;
import com.ihk.property.data.services.IPropertyGroupServices;

/**
 * PropertyGroup的Services实现(业务实现)
 * @author 
 *
 */
@Service("propertyGroupServices")
public class PropertyGroupServices implements IPropertyGroupServices {
	/**
	 * propertyGroup数据访问接口
	 */
	@Autowired	 IPropertyGroupMapper propertyGroupMapper;

	/**
	 * 删除一条PropertyGroup
	 * @param id
	 */
	public void deletePropertyGroup(int id) throws RuntimeException {
		propertyGroupMapper.deletePropertyGroup(id);
	}

	/**
	 * 新增PropertyGroup
	 * @param propertyGroup
	 */
	public void addPropertyGroup(PropertyGroup propertyGroup) throws RuntimeException {		
		propertyGroupMapper.addPropertyGroup(propertyGroup);
	}

	/**
	 * 查找一条PropertyGroup
	 * @return PropertyGroup
	 * @param id 主键id
	 */
	@Override
	public PropertyGroup findPropertyGroupById(int id) throws RuntimeException {
		return propertyGroupMapper.findPropertyGroupById(id);
	}

	/**
	 * 修改PropertyGroup
	 * @param propertyGroup
	 */
	@Override
	public void updatePropertyGroup(PropertyGroup propertyGroup) throws RuntimeException {
		propertyGroupMapper.updatePropertyGroup(propertyGroup);		
	}

	/**
	 * 分页查找PropertyGroup
	 * @param cond 查询条件
	 * @return PropertyGroup列表
	 */
	public List<PropertyGroup> findPropertyGroupPage(PropertyGroupCond cond) throws RuntimeException {
		int recordCount = propertyGroupMapper.findPropertyGroupCount(cond);
		
		cond.recordCount = recordCount;
				
		return propertyGroupMapper.findPropertyGroupPage(cond);
	}

	/**
	 * 查找全部PropertyGroup
	 * @param cond 查询条件
	 * @return PropertyGroup列表
	 */
	public List<PropertyGroup> findPropertyGroup(PropertyGroupCond cond) throws RuntimeException {
    	return propertyGroupMapper.findPropertyGroup(cond);
	}

	@Override
	public List<PropertyGroup> findPropertyGroupByProjectId(int projectId)
			throws RuntimeException {
		return propertyGroupMapper.findPropertyGroupByProjectId(projectId);
	}

}
