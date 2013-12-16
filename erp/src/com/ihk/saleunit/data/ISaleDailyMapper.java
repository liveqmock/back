package com.ihk.saleunit.data;

import java.util.List;

import com.ihk.saleunit.data.pojo.SaleDaily;
import com.ihk.saleunit.data.pojo.SaleDailyCond;

/**
 * SaleDaily数据访问接口Mapper
 * @author 
 *
 */ 
public interface ISaleDailyMapper {

	/**
	 * 新增SaleDaily
	 * @param saleDaily
	 */
	public void addSaleDaily(SaleDaily saleDaily) ;

	/**
	 * 根据条件删除SaleDaily
	 * @param cond 删除条件
	 */
	public void deleteSaleDaily(int id) throws RuntimeException;

	/**
	 * 修改SaleDaily
	 * @param saleDaily
	 */
	public void updateSaleDaily(SaleDaily saleDaily) throws RuntimeException;

	/**
	 * 查找一条SaleDaily
	 * @return SaleDaily
	 * @param id 主键id
	 */
	public SaleDaily findSaleDailyById(int id) throws RuntimeException;

	/**
	 * 分页查找SaleDaily
	 * @param cond 查询条件
	 * @return SaleDaily列表
	 */
	public List<SaleDaily> findSaleDailyPage(SaleDailyCond cond) ;

	/**
	 * 查找全部SaleDaily
	 * @param cond 查询条件
	 * @return SaleDaily列表
	 */
	public List<SaleDaily> findSaleDaily(SaleDailyCond cond) ;

	/**
	 * 查找符合条件的记录条数SaleDaily
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findSaleDailyCount(SaleDailyCond cond) ;
}
