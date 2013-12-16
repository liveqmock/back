package com.ihk.user.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.user.data.pojo.FuncTree;
import com.ihk.user.data.pojo.FuncTreeCond;

/**
 * FuncTree的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
public interface IFuncTreeServices {
	/**
	 * 新增FuncTree
	 * @param funcTree
	 */
	public void addFuncTree(FuncTree funcTree) throws RuntimeException;

	/**
	 * 删除一条FuncTree
	 * @param id
	 */
	public void deleteFuncTree(int id) throws RuntimeException;

	/**
	 * 修改FuncTree
	 * @param funcTree
	 */
	public void updateFuncTree(FuncTree funcTree) throws RuntimeException;

	/**
	 * 查找一条FuncTree
	 * @return FuncTree
	 * @param id 主键id
	 */
	public FuncTree findFuncTreeById(String id) throws RuntimeException;

	/**
	 * 分页查找FuncTree
	 * @param cond 查询条件
	 * @return FuncTree列表
	 */
	@SuppressWarnings("rawtypes")
	public List findFuncTreePage(FuncTreeCond cond) throws RuntimeException;

	/**
	 * 查找全部FuncTree
	 * @param cond 查询条件
	 * @return FuncTree列表
	 */
	public List<FuncTree> findAll();
	
	/**
	 * 根据名称查找
	 * @param funcTree
	 * @return
	 */
	public List<FuncTree> findListByName(FuncTree funcTree);
	
}