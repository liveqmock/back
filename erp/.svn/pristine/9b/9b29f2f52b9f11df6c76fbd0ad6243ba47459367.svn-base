package com.ihk.user.data;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.ihk.user.data.pojo.Priv;
import com.ihk.user.data.pojo.PrivFunc;
import com.ihk.user.data.pojo.PrivFuncCond;
import com.ihk.user.data.pojo.PrivFuncName;

/**
 * PrivFunc数据访问接口Mapper
 * @author 
 *
 */ 
public interface IPrivFuncMapper {

	/**
	 * 新增PrivFunc
	 * @param privFunc
	 */
	public void addPrivFunc(PrivFunc privFunc) ;

	/**
	 * 根据条件删除PrivFunc
	 * @param cond 删除条件
	 */
	public void deletePrivFunc(int id) throws RuntimeException;

	/**
	 * 修改PrivFunc
	 * @param privFunc
	 */
	public void updatePrivFunc(PrivFunc privFunc) throws RuntimeException;

	/**
	 * 查找一条PrivFunc
	 * @return PrivFunc
	 * @param id 主键id
	 */
	public PrivFunc findPrivFuncById(int id) throws RuntimeException;

	/**
	 * 分页查找PrivFunc
	 * @param cond 查询条件
	 * @return PrivFunc列表
	 */
	public List<PrivFunc> findPrivFuncPage(PrivFuncCond cond) ;

	/**
	 * 查找符合条件的记录条数PrivFunc
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findPrivFuncCount(PrivFuncCond cond) ;
	
	/**
	 * 查找
	 * @return
	 */
	public List<LinkedHashMap<String, String>> findAll();

	/**
	 * 根据name 查找
	 * @param priv
	 * @return
	 */
	public List<LinkedHashMap<String, String>> findListByName(Priv priv);

//	public List<PrivFuncName> findListByName(PrivFuncName privFuncName);
}
