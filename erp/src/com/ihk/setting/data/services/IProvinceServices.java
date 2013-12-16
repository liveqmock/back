package com.ihk.setting.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.setting.data.pojo.Province;
import com.ihk.setting.data.pojo.ProvinceCond;

/**
 * Province的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
public interface IProvinceServices {
	/**
	 * 新增Province
	 * @param province
	 */
	public void addProvince(Province province) throws RuntimeException;

	/**
	 * 删除一条Province
	 * @param id
	 */
	public void deleteProvince(int id) throws RuntimeException;

	/**
	 * 修改Province
	 * @param province
	 */
	public void updateProvince(Province province) throws RuntimeException;

	/**
	 * 查找一条Province
	 * @return Province
	 * @param id 主键id
	 */
	public Province findProvinceById(int id) throws RuntimeException;

	/**
	 * 分页查找Province
	 * @param cond 查询条件
	 * @return Province列表
	 */
	public List<Province> findProvincePage(ProvinceCond cond) throws RuntimeException;
    
	/**
	 * 查找
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
	public List<Province> findProvince(ProvinceCond cond) throws RuntimeException;
	
	public Province findProvineByName (String name)throws RuntimeException;
	
}