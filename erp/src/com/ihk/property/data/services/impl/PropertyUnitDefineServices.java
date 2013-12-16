package com.ihk.property.data.services.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.property.data.IPropertyUnitDefineMapper;
import com.ihk.property.data.pojo.PropertyUnitDefine;
import com.ihk.property.data.pojo.PropertyUnitDefineCond;
import com.ihk.property.data.services.IPropertyUnitDefineServices;

/**
 * PropertyUnitDefine的Services实现(业务实现)
 * @author 
 *
 */
@Service("propertyUnitDefineServices")
@SuppressWarnings("unchecked")
public class PropertyUnitDefineServices implements IPropertyUnitDefineServices {
	/**
	 * propertyUnitDefine数据访问接口
	 */
	@Autowired	 IPropertyUnitDefineMapper propertyUnitDefineMapper;

	/**
	 * 删除一条PropertyUnitDefine
	 * @param id
	 */
	public void deletePropertyUnitDefine(int id) throws RuntimeException {
		propertyUnitDefineMapper.deletePropertyUnitDefine(id);
	}

	/**
	 * 新增PropertyUnitDefine
	 * @param propertyUnitDefine
	 */
	public void addPropertyUnitDefine(PropertyUnitDefine propertyUnitDefine) throws RuntimeException {		
		propertyUnitDefineMapper.addPropertyUnitDefine(propertyUnitDefine);
	}

	/**
	 * 查找一条PropertyUnitDefine
	 * @return PropertyUnitDefine
	 * @param id 主键id
	 */
	@Override
	public PropertyUnitDefine findPropertyUnitDefineById(int id) throws RuntimeException {
		return propertyUnitDefineMapper.findPropertyUnitDefineById(id);
	}

	/**
	 * 修改PropertyUnitDefine
	 * @param propertyUnitDefine
	 */
	@Override
	public void updatePropertyUnitDefine(PropertyUnitDefine propertyUnitDefine) throws RuntimeException {
		propertyUnitDefineMapper.updatePropertyUnitDefine(propertyUnitDefine);		
	}

	/**
	 * 分页查找PropertyUnitDefine
	 * @param cond 查询条件
	 * @return PropertyUnitDefine列表
	 */
	public List<PropertyUnitDefine> findPropertyUnitDefinePage(PropertyUnitDefineCond cond) throws RuntimeException {
		int recordCount = propertyUnitDefineMapper.findPropertyUnitDefineCount(cond);
		
		cond.recordCount = recordCount;
				
		return propertyUnitDefineMapper.findPropertyUnitDefinePage(cond);
	}

	/**
	 * 查找全部PropertyUnitDefine
	 * @param cond 查询条件
	 * @return PropertyUnitDefine列表
	 */
	public List<PropertyUnitDefine> findPropertyUnitDefine(PropertyUnitDefineCond cond) throws RuntimeException {
    	return propertyUnitDefineMapper.findPropertyUnitDefine(cond);
	}

	@Override
	public PropertyUnitDefine findPropertyUnitDefineByUnitId(int id)
			throws RuntimeException {
		// TODO Auto-generated method stub
		return propertyUnitDefineMapper.findPropertyUnitDefineByUnitId(id);
	}
}
