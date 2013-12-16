package com.ihk.saleunit.data;

import java.util.List;

import com.ihk.saleunit.data.pojo.Tart;
import com.ihk.saleunit.data.pojo.TartCond;
import com.ihk.utils.base.PojoDeleteCond;

/**
 * Tart数据访问接口Mapper
 * @author 
 *
 */ 
public interface ITartMapper {

	/**
	 * 新增Tart
	 * @param tart
	 */
	public void addTart(Tart tart) ;

	/**
	 * 根据条件删除Tart
	 * @param cond 删除条件
	 */
	public void deleteTart(PojoDeleteCond cond) throws RuntimeException;


	/**
	 * 修改Tart
	 * @param tart
	 */
	public void updateTart(Tart tart) throws RuntimeException;
	
    
	/**
	 * 查找一条Tart
	 * @return Tart
	 * @param id 主键id
	 */
	public Tart findTartById(int id) throws RuntimeException;
	
	/**
	 * 查找一条Tart
	 * @return Tart
	 * @param id unit_id
	 */
	public List<Tart> findTartByUnitId(int id) throws RuntimeException;
	    
	/**
	 * 分页查找Tart
	 * @param cond 查询条件
	 * @return Tart列表
	 */
	public List<Tart> findTartPage(TartCond cond) ;
        
	/**
	 * 查找全部Tart
	 * @param cond 查询条件
	 * @return Tart列表
	 */
	public List<Tart> findTart(TartCond cond) ;
    
	/**
	 * 查找符合条件的记录条数Tart
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findTartCount(TartCond cond) ;
}
