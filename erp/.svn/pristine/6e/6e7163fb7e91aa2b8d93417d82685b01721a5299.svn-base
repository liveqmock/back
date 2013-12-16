package com.ihk.property.data;

import java.util.List;
import java.util.Map;

import com.ihk.property.data.pojo.BuildDiscount;
import com.ihk.property.data.pojo.BuildDiscountCond;

/**
 * BuildDiscount数据访问接口Mapper
 * @author 
 *
 */ 
public interface IBuildDiscountMapper {

	/**
	 * 新增BuildDiscount
	 * @param buildDiscount
	 */
	public void addBuildDiscount(BuildDiscount buildDiscount) ;

	/**
	 * 根据条件删除BuildDiscount
	 * @param cond 删除条件
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
	public List<BuildDiscount> findBuildDiscountPage(BuildDiscountCond cond) ;

	/**
	 * 查找全部BuildDiscount
	 * @param cond 查询条件
	 * @return BuildDiscount列表
	 */
	public List<BuildDiscount> findBuildDiscount(BuildDiscountCond cond) ;

	/**
	 * 查找符合条件的记录条数BuildDiscount
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findBuildDiscountCount(BuildDiscountCond cond) ;
}
