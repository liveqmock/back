package com.ihk.property.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.property.data.pojo.BuildDiscount;
import com.ihk.property.data.pojo.BuildDiscountCond;

/**
 * BuildDiscount的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
public interface IBuildDiscountServices {

	/**
	 * 新增BuildDiscount
	 * @param buildDiscount
	 */
	public void addBuildDiscount(BuildDiscount buildDiscount) throws RuntimeException;

	/**
	 * 删除一条BuildDiscount
	 * @param id
	 */
	public void deleteBuildDiscount(int id) throws RuntimeException;

	/**
	 * 修改BuildDiscount
	 * @param buildDiscount
	 */
	public void updateBuildDiscount(BuildDiscount buildDiscount) throws RuntimeException;

	/**
	 * 查找一条BuildDiscount
	 * @return BuildDiscount
	 * @param id 主键id
	 */
	public BuildDiscount findBuildDiscountById(int id) throws RuntimeException;

	/**
	 * 分页查找BuildDiscount
	 * @param cond 查询条件
	 * @return BuildDiscount列表
	 */
	public List<BuildDiscount> findBuildDiscountPage(BuildDiscountCond cond) throws RuntimeException;

	/**
	 * 查找全部BuildDiscount
	 * @param cond 查询条件
	 * @return BuildDiscount列表
	 */
	public List<BuildDiscount> findBuildDiscount(BuildDiscountCond cond) throws RuntimeException;
}