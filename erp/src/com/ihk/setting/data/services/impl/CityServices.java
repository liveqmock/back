package com.ihk.setting.data.services.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.setting.data.ICityMapper;
import com.ihk.setting.data.pojo.City;
import com.ihk.setting.data.pojo.CityCond;
import com.ihk.setting.data.services.ICityServices;

/**
 * City的Services实现(业务实现)
 * @author 
 *
 */
@Service("cityServices")
public class CityServices implements ICityServices {
	/**
	 * city数据访问接口
	 */
	@Autowired	 ICityMapper cityMapper;

	/**
	 * 删除一条City
	 * @param id
	 */
	public void deleteCity(int id) throws RuntimeException {
		cityMapper.deleteCity(id);
	}

	/**
	 * 新增City
	 * @param city
	 */
	public void addCity(City city) throws RuntimeException {		
		cityMapper.addCity(city);
	}

	/**
	 * 查找一条City
	 * @return City
	 * @param id 主键id
	 */
	@Override
	public City findCityById(int id) throws RuntimeException {
		return cityMapper.findCityById(id);
	}

	/**
	 * 修改City
	 * @param city
	 */
	@Override
	public void updateCity(City city) throws RuntimeException {
		cityMapper.updateCity(city);		
	}

	/**
	 * 分页查找City
	 * @param cond 查询条件
	 * @return City列表
	 */
	public List<City> findCityPage(CityCond cond) throws RuntimeException {
		int recordCount = cityMapper.findCityCount(cond);
		
		cond.recordCount = recordCount;
				
		return cityMapper.findCityPage(cond);
	}

	/**
	 * 查找全部City
	 * @param cond 查询条件
	 * @return City列表
	 */
	public List<City> findCity(CityCond cond) throws RuntimeException {
    	return cityMapper.findCity(cond);
	}

	/**
	 * 根据ProvinceId与city查找
	 */
	@Override
	public List<City> findCityByProvinceId(int id) throws Exception {
		return cityMapper.findCityByProvinceId(id);
	}

	/**
	 * 根据开头查找
	 * */
	@Override
	public City findCityByname(Map smap) throws RuntimeException {
		return cityMapper.findCityByname(smap);
	}

	@Override
	public City findCityByName(String cityName) throws RuntimeException {
		// TODO Auto-generated method stub
		return cityMapper.findCityByName(cityName);
	}
}
