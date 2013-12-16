package com.ihk.user.data;

import java.util.List;
import java.util.Map;

import com.ihk.user.data.pojo.Priv;
import com.ihk.user.data.pojo.PrivCond;

/**
 * Priv数据访问接口Mapper
 * @author 
 *
 */ 
public interface IPrivMapper {

	/**
	 * 新增Priv
	 * @param priv
	 */
	public void addPriv(Priv priv) ;

    /**
     * 根据条件删除Priv
     * @param id
     * @throws RuntimeException
     */
	public void deletePriv(int id) throws RuntimeException;


	/**
	 * 修改Priv
	 * @param priv
	 */
	public void updatePriv(Priv priv) throws RuntimeException;

	/**
	 * 查找一条Priv
	 * @return Priv
	 * @param id 主键id
	 */
	public Priv findPrivById(int id) throws RuntimeException;

	/**
	 * 分页查找Priv
	 * @param cond 查询条件
	 * @return Priv列表
	 */
	public List<Priv> findPrivPage(PrivCond cond) ;

	/**
	 * 查找符合条件的记录条数Priv
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findPrivCount(PrivCond cond) ;

	/**
	 * 查找全部Priv
	 * @return Priv列表
	 */
	public List<Priv> findAll()throws RuntimeException ;
	
	/**
	 * 查询用户的权限
	 * @param userId
	 * @return
	 * @throws RuntimeException
	 */
	public List<Map> findUserPriv(int userId) throws RuntimeException;
	
	/**
	 * 查找全部权限
	 * @return
	 * @throws RuntimeException
	 */
	public List<Priv> findPrivAll() throws RuntimeException;
}
