package com.ihk.property.data.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.property.data.IPropertyGroupDetailMapper;
import com.ihk.property.data.pojo.PropertyGroupDetail;
import com.ihk.property.data.pojo.PropertyGroupDetailCond;
import com.ihk.property.data.services.IPropertyGroupDetailServices;

/**
 * PropertyGroupDetail的Services实现(业务实现)
 * @author 
 *
 */
@Service("propertyGroupDetailServices")
public class PropertyGroupDetailServices implements IPropertyGroupDetailServices {
	/**
	 * propertyGroupDetail数据访问接口
	 */
	@Autowired	 IPropertyGroupDetailMapper propertyGroupDetailMapper;

	/**
	 * 删除一条PropertyGroupDetail
	 * @param id
	 */
	public void deletePropertyGroupDetail(int id) throws RuntimeException {
		propertyGroupDetailMapper.deletePropertyGroupDetail(id);
	}

	/**
	 * 新增PropertyGroupDetail
	 * @param propertyGroupDetail
	 */
	public void addPropertyGroupDetail(PropertyGroupDetail propertyGroupDetail) throws RuntimeException {		
		propertyGroupDetailMapper.addPropertyGroupDetail(propertyGroupDetail);
	}


	/**
	 * 查找一条PropertyGroupDetail
	 * @return PropertyGroupDetail
	 * @param id 主键id
	 */
	@Override
	public PropertyGroupDetail findPropertyGroupDetailById(int id) throws RuntimeException {
		return propertyGroupDetailMapper.findPropertyGroupDetailById(id);
	}

	/**
	 * 修改PropertyGroupDetail
	 * @param propertyGroupDetail
	 */
	@Override
	public void updatePropertyGroupDetail(PropertyGroupDetail propertyGroupDetail) throws RuntimeException {
		propertyGroupDetailMapper.updatePropertyGroupDetail(propertyGroupDetail);		
	}

	/**
	 * 分页查找PropertyGroupDetail
	 * @param cond 查询条件
	 * @return PropertyGroupDetail列表
	 */
	public List<PropertyGroupDetail> findPropertyGroupDetailPage(PropertyGroupDetailCond cond) throws RuntimeException {
		int recordCount = propertyGroupDetailMapper.findPropertyGroupDetailCount(cond);
		
		cond.recordCount = recordCount;
				
		return propertyGroupDetailMapper.findPropertyGroupDetailPage(cond);
	}

	/**
	 * 查找全部PropertyGroupDetail
	 * @param cond 查询条件
	 * @return PropertyGroupDetail列表
	 */
	public List<PropertyGroupDetail> findPropertyGroupDetail(PropertyGroupDetailCond cond) throws RuntimeException {
    	return propertyGroupDetailMapper.findPropertyGroupDetail(cond);
	}

	@Override
	public void addUnitByBuildId(PropertyGroupDetailCond cond)
			throws RuntimeException {
		propertyGroupDetailMapper.addUnitByBuildId(cond);
		
	}

	@Override
	public void addUnitByUnitIds(PropertyGroupDetailCond cond)
			throws RuntimeException {
		propertyGroupDetailMapper.addUnitByUnitIds(cond);
	}

	@Override
	public void deletePropertyGroupDetailByGroupIdAndUnitId(
			PropertyGroupDetailCond cond) throws RuntimeException {
		propertyGroupDetailMapper.deletePropertyGroupDetailByGroupIdAndUnitId(cond);
		
	}

}
