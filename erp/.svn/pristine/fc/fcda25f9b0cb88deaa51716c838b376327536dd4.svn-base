package com.ihk.property.data.services.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.property.data.IPropertyPrivMapper;
import com.ihk.property.data.pojo.PropertyPriv;
import com.ihk.property.data.pojo.PropertyPrivCond;
import com.ihk.property.data.services.IPropertyPrivServices;

/**
 * PropertyPriv的Services实现(业务实现)
 * @author 
 *
 */
@Service("propertyPrivServices")
@SuppressWarnings("unchecked")
public class PropertyPrivServices implements IPropertyPrivServices {
	/**
	 * propertyPriv数据访问接口
	 */
	@Autowired	 IPropertyPrivMapper propertyPrivMapper;

	/**
	 * 删除一条PropertyPriv
	 * @param id
	 */
	public void deletePropertyPriv(int id) throws RuntimeException {
		propertyPrivMapper.deletePropertyPriv(id);
	}

	/**
	 * 新增PropertyPriv
	 * @param propertyPriv
	 */
	public void addPropertyPriv(PropertyPriv propertyPriv) throws RuntimeException {		
		propertyPrivMapper.addPropertyPriv(propertyPriv);
	}

	/**
	 * 查找一条PropertyPriv
	 * @return PropertyPriv
	 * @param id 主键id
	 */
	@Override
	public PropertyPriv findPropertyPrivById(int id) throws RuntimeException {
		return propertyPrivMapper.findPropertyPrivById(id);
	}

	/**
	 * 修改PropertyPriv
	 * @param propertyPriv
	 */
	@Override
	public void updatePropertyPriv(PropertyPriv propertyPriv) throws RuntimeException {
		propertyPrivMapper.updatePropertyPriv(propertyPriv);		
	}

    
	/**
	 * 分页查找PropertyPriv
	 * @param cond 查询条件
	 * @return PropertyPriv列表
	 */
	public List<PropertyPriv> findPropertyPrivPage(PropertyPrivCond cond) throws RuntimeException {
		int recordCount = propertyPrivMapper.findPropertyPrivCount(cond);
		
		cond.recordCount = recordCount;
				
		return propertyPrivMapper.findPropertyPrivPage(cond);
	}

	/**
	 * 查找全部PropertyPriv
	 * @param cond 查询条件
	 * @return PropertyPriv列表
	 */
	public List<PropertyPriv> findPropertyPriv(PropertyPrivCond cond) throws RuntimeException {
    	return propertyPrivMapper.findPropertyPriv(cond);
	}
}
