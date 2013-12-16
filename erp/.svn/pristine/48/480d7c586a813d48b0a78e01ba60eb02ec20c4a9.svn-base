package com.ihk.setting.data.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.setting.data.IProvinceMapper;
import com.ihk.setting.data.pojo.Province;
import com.ihk.setting.data.pojo.ProvinceCond;
import com.ihk.setting.data.services.IProvinceServices;

/**
 * Province的Services实现(业务实现)
 * @author 
 *
 */
@Service("provinceServices")
public class ProvinceServices implements IProvinceServices {
	/**
	 * province数据访问接口
	 */
	@Autowired	 IProvinceMapper provinceMapper;

	/**
	 * 删除一条Province
	 * @param id
	 */
	public void deleteProvince(int id) throws RuntimeException {
		provinceMapper.deleteProvince(id);
	}

	/**
	 * 新增Province
	 * @param province
	 */
	public void addProvince(Province province) throws RuntimeException {		
		provinceMapper.addProvince(province);
	}

	/**
	 * 查找一条Province
	 * @return Province
	 * @param id 主键id
	 */
	@Override
	public Province findProvinceById(int id) throws RuntimeException {
		return provinceMapper.findProvinceById(id);
	}

	/**
	 * 修改Province
	 * @param province
	 */
	@Override
	public void updateProvince(Province province) throws RuntimeException {
		provinceMapper.updateProvince(province);		
	}
	

	/**
	 * 分页查找Province
	 * @param cond 查询条件
	 * @return Province列表
	 */
	public List<Province> findProvincePage(ProvinceCond cond) throws RuntimeException {
		int recordCount = provinceMapper.findProvinceCount(cond);
		
		cond.recordCount = recordCount;
				
		return provinceMapper.findProvincePage(cond);
	}

	/**
	 * 查找全部Province
	 * @param cond 查询条件
	 * @return Province列表
	 */
	public List<Province> findProvince(ProvinceCond cond) throws RuntimeException {
    	return provinceMapper.findProvince(cond);
	}

	@Override
	public Province findProvineByName(String name) throws RuntimeException {
		// TODO Auto-generated method stub
		return provinceMapper.findProvineByName(name);
	}
}
