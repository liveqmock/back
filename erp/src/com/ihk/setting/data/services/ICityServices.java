package com.ihk.setting.data.services;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.setting.data.pojo.City;
import com.ihk.setting.data.pojo.CityCond;

/**
 * City的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
public interface ICityServices {
	/**
	 * 新增City
	 * @param city
	 */
	public void addCity(City city) throws RuntimeException;

	/**
	 * 删除一条City
	 * @param id
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
	public List<City> findCityPage(CityCond cond) throws RuntimeException;

	/**
	 * 查找全部City
	 * @param cond 查询条件
	 * @return City列表
	 */
	public List<City> findCity(CityCond cond) throws RuntimeException;
	
	/**
	 * 根据省id查找对应的市
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public List<City> findCityByProvinceId(int id) throws Exception; //根据省id查找对应的市
	
	
	public City findCityByname(Map smap) throws RuntimeException;
	
	public City findCityByName(String cityName) throws RuntimeException;
}