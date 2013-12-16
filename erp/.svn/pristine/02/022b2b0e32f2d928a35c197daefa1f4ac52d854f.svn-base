package com.ihk.setting.data;

import java.util.List;
import java.util.Map;

import com.ihk.setting.data.pojo.Region;
import com.ihk.setting.data.pojo.RegionCond;

/**
 * Region数据访问接口Mapper
 * @author 
 *
 */ 
public interface IRegionMapper {

	/**
	 * 新增Region
	 * @param region
	 */
	public void addRegion(Region region) ;

	/**
	 * 根据条件删除Region
	 * @param cond 删除条件
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
	public List<Region> findRegionPage(RegionCond cond) ;

	/**
	 * 查找全部Region
	 * @param cond 查询条件
	 * @return Region列表
	 */
	public List<Region> findRegion(RegionCond cond) ;

	/**
	 * 查找符合条件的记录条数Region
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findRegionCount(RegionCond cond) ;
	
	/**
	 * 根据CityId查找
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public List<Region> findRegionByCityId(int id) throws Exception;
	
	
	public Region findRegionByName(Map smap);

	public Region findRegionByNameStr(String region);
}
