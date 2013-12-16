package com.ihk.setting.data;

import java.util.List;
import java.util.Map;

import com.ihk.setting.data.pojo.City;
import com.ihk.setting.data.pojo.CityCond;

/**
 * City数据访问接口Mapper
 * @author 
 *
 */ 
public interface ICityMapper {

	/**
	 * 新增City
	 * @param city
	 */
	public void addCity(City city) ;

	/**
	 * 根据条件删除City
	 * @param cond 删除条件
	 */
	public void deleteCity(int id) throws RuntimeException;

	/**
	 * 修改City
	 * @param city
	 */
	public void updateCity(City city) throws RuntimeException;

	/**
	 * 查找一条City
	 * @return City
	 * @param id 主键id
	 */
	public City findCityById(int id) throws RuntimeException;

	/**
	 * 分页查找City
	 * @param cond 查询条件
	 * @return City列表
	 */
	public List<City> findCityPage(CityCond cond) ;

	/**
	 * 查找全部City
	 * @param cond 查询条件
	 * @return City列表
	 */
	public List<City> findCity(CityCond cond) ;
    

	/**
	 * 查找符合条件的记录条数City
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findCityCount(CityCond cond) ;
	
	/**
	 * 根据省id查找对应的市
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public List<City> findCityByProvinceId(int id) throws Exception; //根据省id查找对应的市
	
	public City findCityByname(Map smap) ;

	public City findCityByName(String cityName);
	
}
