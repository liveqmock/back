package com.ihk.saleunit.data;

import java.util.List;

import com.ihk.saleunit.data.pojo.ChangePrice;
import com.ihk.saleunit.data.pojo.ChangePriceCond;

/**
 * ChangePrice数据访问接口Mapper
 * @author 
 *
 */ 
public interface IChangePriceMapper {

	/**
	 * 新增ChangePrice
	 * @param changePrice
	 */
	public void addChangePrice(ChangePrice changePrice) ;

	/**
	 * 根据条件删除ChangePrice
	 * @param cond 删除条件
	 */
	public void deleteChangePrice(int id) throws RuntimeException;

	/**
	 * 修改ChangePrice
	 * @param changePrice
	 */
	public void updateChangePrice(ChangePrice changePrice) throws RuntimeException;

	/**
	 * 查找一条ChangePrice
	 * @return ChangePrice
	 * @param id 主键id
	 */
	public ChangePrice findChangePriceById(int id) throws RuntimeException;

	/**
	 * 分页查找ChangePrice
	 * @param cond 查询条件
	 * @return ChangePrice列表
	 */
	public List<ChangePrice> findChangePricePage(ChangePriceCond cond) ;

	/**
	 * 查找全部ChangePrice
	 * @param cond 查询条件
	 * @return ChangePrice列表
	 */
	public List<ChangePrice> findChangePrice(ChangePriceCond cond) ;

	/**
	 * 查找符合条件的记录条数ChangePrice
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findChangePriceCount(ChangePriceCond cond) ;
}
