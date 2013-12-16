package com.ihk.property.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.property.data.pojo.CheckfeeList;
import com.ihk.property.data.pojo.CheckfeeListCond;

/**
 * CheckfeeList的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
public interface ICheckfeeListServices {

	/**
	 * 新增CheckfeeList
	 * @param checkfeeList
	 */
	public void addCheckfeeList(CheckfeeList checkfeeList) throws RuntimeException;

	/**
	 * 删除一条CheckfeeList
	 * @param id
	 */
	public void deleteCheckfeeList(int id) throws RuntimeException;

	/**
	 * 修改CheckfeeList
	 * @param checkfeeList
	 */
	public void updateCheckfeeList(CheckfeeList checkfeeList) throws RuntimeException;

	/**
	 * 查找一条CheckfeeList
	 * @return CheckfeeList
	 * @param id 主键id
	 */
	public CheckfeeList findCheckfeeListById(int id) throws RuntimeException;

    /**
     * 查找CheckfeeList 不分页
     * @return CheckfeeList
     * @param checkfeeListCond
     */
    public List<CheckfeeList> findCheckfeeListByPrjId(CheckfeeListCond checkfeeListCond) throws RuntimeException;
    
	/**
	 * 分页查找CheckfeeList
	 * @param cond 查询条件
	 * @return CheckfeeList列表
	 */
	public List<CheckfeeList> findCheckfeeListPage(CheckfeeListCond cond) throws RuntimeException;
    
	/**
	 * 查找全部CheckfeeList
	 * @param cond 查询条件
	 * @return CheckfeeList列表
	 */
	public List<CheckfeeList> findCheckfeeList(CheckfeeListCond cond) throws RuntimeException;
    
     /**
	 * ajax分页查找CheckfeeList
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
    public List<CheckfeeList> findCheckfeeListForAjax(CheckfeeListCond cond) throws RuntimeException;
    
    /**
	 * ajax分页查找CheckfeeList总数
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
    public int findCheckfeeListCountForAjax(CheckfeeListCond cond) throws RuntimeException;
    
    
   
}