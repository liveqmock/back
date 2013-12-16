package com.ihk.user.data;

import java.util.List;
import java.util.Map;

import com.ihk.user.data.pojo.FuncTree;
import com.ihk.user.data.pojo.FuncTreeCond;

/**
 * FuncTree数据访问接口Mapper
 * @author 
 *
 */ 
public interface IFuncTreeMapper {

	/**
	 * 新增FuncTree
	 * @param funcTree
	 */
	public void addFuncTree(FuncTree funcTree) ;

	/**
	 * 根据条件删除FuncTree
	 * @param cond 删除条件
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
	public List<FuncTree> findFuncTreePage(FuncTreeCond cond) ;

	/**
	 * 查找符合条件的记录条数FuncTree
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findFuncTreeCount(FuncTreeCond cond) ;

	/**
	 * 查找全部FuncTree
	 * @param cond 查询条件
	 * @return FuncTree列表
	 */
	public List<FuncTree> findAll();
	
	/**
	 * 根据name查找
	 * @param tree
	 * @return
	 */
	public List<FuncTree> findListByName(FuncTree tree);
}
