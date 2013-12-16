package com.ihk.setting.data.services;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.setting.data.pojo.Region;
import com.ihk.setting.data.pojo.RegionCond;

/**
 * Region的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
public interface IRegionServices {
	/**
	 * 新增Region
	 * @param region
	 */
	public void addRegion(Region region) throws RuntimeException;

	/**
	 * 删除一条Region
	 * @param id
	 */
	public void deleteRegion(int id) throws RuntimeException;

	/**
	 * 修改Region
	 * @param region
	 */
	public void updateRegion(Region region) throws RuntimeException;

	/**
	 * 查找一条Region
	 * @return Region
	 * @param id 主键id
	 */
	public Region findRegionById(int id) throws RuntimeException;

	/**
	 * 分页查找Region
	 * @param cond 查询条件
	 * @return Region列表
	 */
	public List<Region> findRegionPage(RegionCond cond) throws RuntimeException;

	/**
	 * 查找全部Region
	 * @param cond 查询条件
	 * @return Region列表
	 */
	public List<Region> findRegion(RegionCond cond) throws RuntimeException;
	
	/**
	 * 根据cityId查找
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public List<Region> findRegionByCityId(int id) throws Exception; //根据市id获取对应的地区
	
	/**
	 * 根据父ID 开头2字查找
	 * */
	public Region findRegionByName(Map smap)throws RuntimeException;
	
	public Region findRegionByNameStr(String region)throws RuntimeException;
}