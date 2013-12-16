package com.ihk.saleunit.data;

import java.util.List;
import java.util.Map;

import com.ihk.saleunit.data.pojo.ArAmount;
import com.ihk.saleunit.data.pojo.ArAmountCond;

import com.ihk.utils.base.PojoDeleteCond;

/**
 * ArAmount数据访问接口Mapper
 * @author 
 *
 */ 
public interface IArAmountMapper {

	/**
	 * 新增ArAmount
	 * @param arAmount
	 */
	public void addArAmount(ArAmount arAmount) ;

	/**
	 * 根据条件删除ArAmount
	 * @param cond 删除条件
	 */
	public void deleteArAmount(PojoDeleteCond cond) throws RuntimeException;


	/**
	 * 修改ArAmount
	 * @param arAmount
	 */
	public void updateArAmount(ArAmount arAmount) throws RuntimeException;
	
    
	/**
	 * 查找一条ArAmount
	 * @return ArAmount
	 * @param id 主键id
	 */
	public ArAmount findArAmountById(int id) throws RuntimeException;
	    
	/**
	 * 分页查找ArAmount
	 * @param cond 查询条件
	 * @return ArAmount列表
	 */
	public List<ArAmount> findArAmountPage(ArAmountCond cond) ;
        
	/**
	 * 查找全部ArAmount
	 * @param cond 查询条件
	 * @return ArAmount列表
	 */
	public List<ArAmount> findArAmount(ArAmountCond cond) ;
    
	/**
	 * 查找符合条件的记录条数ArAmount
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findArAmountCount(ArAmountCond cond) ;
}
