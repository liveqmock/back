package com.ihk.setting.data.services.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.setting.data.IRegionMapper;
import com.ihk.setting.data.pojo.Region;
import com.ihk.setting.data.pojo.RegionCond;
import com.ihk.setting.data.services.IRegionServices;

/**
 * Region的Services实现(业务实现)
 * @author 
 *
 */
@Service("regionServices")
public class RegionServices implements IRegionServices {
	/**
	 * region数据访问接口
	 */
	@Autowired	 IRegionMapper regionMapper;

	/**
	 * 删除一条Region
	 * @param id
	 */
	public void deleteRegion(int id) throws RuntimeException {
		regionMapper.deleteRegion(id);
	}

	/**
	 * 新增Region
	 * @param region
	 */
	public void addRegion(Region region) throws RuntimeException {		
		regionMapper.addRegion(region);
	}

	/**
	 * 查找一条Region
	 * @return Region
	 * @param id 主键id
	 */
	@Override
	public Region findRegionById(int id) throws RuntimeException {
		return regionMapper.findRegionById(id);
	}

	/**
	 * 修改Region
	 * @param region
	 */
	@Override
	public void updateRegion(Region region) throws RuntimeException {
		regionMapper.updateRegion(region);		
	}

	/**
	 * 分页查找Region
	 * @param cond 查询条件
	 * @return Region列表
	 */
	public List<Region> findRegionPage(RegionCond cond) throws RuntimeException {
		int recordCount = regionMapper.findRegionCount(cond);
		
		cond.recordCount = recordCount;
				
		return regionMapper.findRegionPage(cond);
	}

	/**
	 * 查找全部Region
	 * @param cond 查询条件
	 * @return Region列表
	 */
	public List<Region> findRegion(RegionCond cond) throws RuntimeException {
    	return regionMapper.findRegion(cond);
	}

	/**
	 * 根据cityId查找
	 */
	@Override
	public List<Region> findRegionByCityId(int id) throws Exception {
		
		return regionMapper.findRegionByCityId(id);
	}

	@Override
	public Region findRegionByName(Map smap) throws RuntimeException {
		return regionMapper.findRegionByName(smap);
	}

	@Override
	public Region findRegionByNameStr(String region) throws RuntimeException {
		return regionMapper.findRegionByNameStr(region);
	}
}
