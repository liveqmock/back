package com.ihk.property.data.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.property.data.IBuildDiscountMapper;
import com.ihk.property.data.pojo.BuildDiscount;
import com.ihk.property.data.pojo.BuildDiscountCond;
import com.ihk.property.data.services.IBuildDiscountServices;

/**
 * BuildDiscount的Services实现(业务实现)
 * @author 
 *
 */
@Service("buildDiscountServices")
public class BuildDiscountServices implements IBuildDiscountServices {
	/**
	 * buildDiscount数据访问接口
	 */
	@Autowired	 IBuildDiscountMapper buildDiscountMapper;

	/**
	 * 删除一条BuildDiscount
	 * @param id
	 */
	public void deleteBuildDiscount(int id) throws RuntimeException {
		buildDiscountMapper.deleteBuildDiscount(id);
	}

	/**
	 * 新增BuildDiscount
	 * @param buildDiscount
	 */
	public void addBuildDiscount(BuildDiscount buildDiscount) throws RuntimeException {		
		buildDiscountMapper.addBuildDiscount(buildDiscount);
	}

	/**
	 * 查找一条BuildDiscount
	 * @return BuildDiscount
	 * @param id 主键id
	 */
	@Override
	public BuildDiscount findBuildDiscountById(int id) throws RuntimeException {
		return buildDiscountMapper.findBuildDiscountById(id);
	}

	/**
	 * 修改BuildDiscount
	 * @param buildDiscount
	 */
	@Override
	public void updateBuildDiscount(BuildDiscount buildDiscount) throws RuntimeException {
		buildDiscountMapper.updateBuildDiscount(buildDiscount);		
	}

	/**
	 * 分页查找BuildDiscount
	 * @param cond 查询条件
	 * @return BuildDiscount列表
	 */
	public List<BuildDiscount> findBuildDiscountPage(BuildDiscountCond cond) throws RuntimeException {
		int recordCount = buildDiscountMapper.findBuildDiscountCount(cond);
		
		cond.recordCount = recordCount;
				
		return buildDiscountMapper.findBuildDiscountPage(cond);
	}

	/**
	 * 查找全部BuildDiscount
	 * @param cond 查询条件
	 * @return BuildDiscount列表
	 */
	public List<BuildDiscount> findBuildDiscount(BuildDiscountCond cond) throws RuntimeException {
    	return buildDiscountMapper.findBuildDiscount(cond);
	}
}
