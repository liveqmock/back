package com.ihk.property.data.services;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.property.data.pojo.CheckcommissionList;
import com.ihk.property.data.pojo.CheckcommissionListCond;

/**
 * CheckcommissionList的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
public interface ICheckcommissionListServices {

	/**
	 * 新增CheckcommissionList
	 * @param checkcommissionList
	 */
	public void addCheckcommissionList(CheckcommissionList checkcommissionList) throws RuntimeException;

	/**
	 * 删除一条CheckcommissionList
	 * @param id
	 */
	public void deleteCheckcommissionList(int id) throws RuntimeException;

	/**
	 * 修改CheckcommissionList
	 * @param checkcommissionList
	 */
	public void updateCheckcommissionList(CheckcommissionList checkcommissionList) throws RuntimeException;

	/**
	 * 查找一条CheckcommissionList
	 * @return CheckcommissionList
	 * @param id 主键id
	 */
	public CheckcommissionList findCheckcommissionListById(int id) throws RuntimeException;
    
	/**
	 * 分页查找CheckcommissionList
	 * @param cond 查询条件
	 * @return CheckcommissionList列表
	 */
	public List<CheckcommissionList> findCheckcommissionListPage(CheckcommissionListCond cond) throws RuntimeException;
    
	/**
	 * 查找全部CheckcommissionList
	 * @param cond 查询条件
	 * @return CheckcommissionList列表
	 */
	public List<CheckcommissionList> findCheckcommissionList(CheckcommissionListCond cond) throws RuntimeException;
    
     /**
	 * ajax分页查找CheckcommissionList
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
    public List<CheckcommissionList> findCheckcommissionListForAjax(CheckcommissionListCond cond) throws RuntimeException;
    
    /**
	 * ajax分页查找CheckcommissionList总数
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
    public int findCheckcommissionListCountForAjax(CheckcommissionListCond cond) throws RuntimeException;

    public List<CheckcommissionList> findCheckcommissionListByPrjId(CheckcommissionListCond cond) throws RuntimeException;
}