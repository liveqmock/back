package com.ihk.user.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.constanttype.EnumDevFlag;
import com.ihk.constanttype.EnumPrivCode;
import com.ihk.user.data.pojo.Priv;
import com.ihk.user.data.pojo.PrivCond;

/**
 * Priv的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
@SuppressWarnings("unchecked")
public interface IPrivServices {
	/**
	 * 新增Priv
	 * @param priv
	 */
	public void addPriv(Priv priv) throws RuntimeException;

	/**
	 * 删除一条Priv
	 * @param id
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

	public int findIdByCodeDevFlag(EnumPrivCode privCode,EnumDevFlag devFlag) throws RuntimeException;

	/**
	 * 分页查找Priv
	 * @param cond 查询条件
	 * @return Priv列表
	 */
	public List findPrivPage(PrivCond cond) throws RuntimeException;
	
	public List<Priv> findAll()throws RuntimeException;
	
	public List findUserPriv(int userId) throws RuntimeException;
}