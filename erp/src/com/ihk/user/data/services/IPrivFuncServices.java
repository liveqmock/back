package com.ihk.user.data.services;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.user.data.pojo.Priv;
import com.ihk.user.data.pojo.PrivFunc;
import com.ihk.user.data.pojo.PrivFuncCond;
import com.ihk.user.data.pojo.PrivFuncName;

/**
 * PrivFunc的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
@SuppressWarnings("unchecked")
public interface IPrivFuncServices {
	/**
	 * 新增PrivFunc
	 * @param privFunc
	 */
	public void addPrivFunc(PrivFunc privFunc) throws RuntimeException;

	/**
	 * 删除一条PrivFunc
	 * @param id
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
	public List findPrivFuncPage(PrivFuncCond cond) throws RuntimeException;
	
	//public List<PrivFuncName> findAll()throws RuntimeException;

	/**
	 * 根据name查找
	 */
	public List<LinkedHashMap<String, String>> findListByName(Priv priv);

	/**
	 * 查找全部
	 * @return
	 */
	public List<LinkedHashMap<String, String>> findAll();
}