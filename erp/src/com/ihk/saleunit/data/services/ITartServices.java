package com.ihk.saleunit.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.saleunit.data.pojo.Tart;
import com.ihk.saleunit.data.pojo.TartCond;

/**
 * Tart的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
@SuppressWarnings("unchecked")
public interface ITartServices {

	/**
	 * 新增Tart
	 * @param tart
	 */
	public void addTart(Tart tart) throws RuntimeException;

	/**
	 * 删除一条Tart
	 * @param id
	 */
	public void deleteTart(int id) throws RuntimeException;

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
	public List<Tart> findTartByUnitId(int unit_id) throws RuntimeException;
    
	/**
	 * 分页查找Tart
	 * @param cond 查询条件
	 * @return Tart列表
	 */
	public List<Tart> findTartPage(TartCond cond) throws RuntimeException;
    
	/**
	 * 查找全部Tart
	 * @param cond 查询条件
	 * @return Tart列表
	 */
	public List<Tart> findTart(TartCond cond) throws RuntimeException;
}