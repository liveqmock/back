package com.ihk.setting.data;

import java.util.List;
import java.util.Map;

import com.ihk.setting.data.pojo.Province;
import com.ihk.setting.data.pojo.ProvinceCond;

/**
 * Province数据访问接口Mapper
 * @author 
 *
 */ 
public interface IProvinceMapper {

	/**
	 * 新增Province
	 * @param province
	 */
	public void addProvince(Province province) ;

	/**
	 * 根据条件删除Province
	 * @param cond 删除条件
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
	public List<Province> findProvincePage(ProvinceCond cond) ;

	/**
	 * 查找全部Province
	 * @param cond 查询条件
	 * @return Province列表
	 */
	public List<Province> findProvince(ProvinceCond cond) ;

	/**
	 * 查找符合条件的记录条数Province
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findProvinceCount(ProvinceCond cond) ;
	
	
	public Province findProvineByName (String name);
}
