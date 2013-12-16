package com.ihk.saleunit.data.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.saleunit.data.IAddonPropertyMapper;
import com.ihk.saleunit.data.pojo.AddonProperty;
import com.ihk.saleunit.data.pojo.AddonPropertyCond;
import com.ihk.saleunit.data.services.IAddonPropertyServices;

/**
 * AddonProperty的Services实现(业务实现)
 * @author 
 *
 */
@Service("addonPropertyServices")
public class AddonPropertyServices implements IAddonPropertyServices {
	/**
	 * addonProperty数据访问接口
	 */
	@Autowired	 IAddonPropertyMapper addonPropertyMapper;

	/**
	 * 删除一条AddonProperty
	 * @param id
	 */
	public void deleteAddonProperty(int id) throws RuntimeException {
		addonPropertyMapper.deleteAddonProperty(id);
	}

	/**
	 * 新增AddonProperty
	 * @param addonProperty
	 */
	public void addAddonProperty(AddonProperty addonProperty) throws RuntimeException {		
		addonPropertyMapper.addAddonProperty(addonProperty);
	}

	/**
	 * 查找一条AddonProperty
	 * @return AddonProperty
	 * @param id 主键id
	 */
	@Override
	public AddonProperty findAddonPropertyById(int id) throws RuntimeException {
		return addonPropertyMapper.findAddonPropertyById(id);
	}

	/**
	 * 修改AddonProperty
	 * @param addonProperty
	 */
	@Override
	public void updateAddonProperty(AddonProperty addonProperty) throws RuntimeException {
		addonPropertyMapper.updateAddonProperty(addonProperty);		
	}

	/**
	 * 分页查找AddonProperty
	 * @param cond 查询条件
	 * @return AddonProperty列表
	 */
	public List<AddonProperty> findAddonPropertyPage(AddonPropertyCond cond) throws RuntimeException {
		int recordCount = addonPropertyMapper.findAddonPropertyCount(cond);
		
		cond.recordCount = recordCount;
				
		return addonPropertyMapper.findAddonPropertyPage(cond);
	}

	/**
	 * 查找全部AddonProperty
	 * @param cond 查询条件
	 * @return AddonProperty列表
	 */
	public List<AddonProperty> findAddonProperty(AddonPropertyCond cond) throws RuntimeException {
    	return addonPropertyMapper.findAddonProperty(cond);
	}
}
