package com.ihk.property.data;

import java.util.List;
import java.util.Map;

import com.ihk.property.data.pojo.CheckcommissionList;
import com.ihk.property.data.pojo.CheckcommissionListCond;

import com.ihk.utils.base.PojoDeleteCond;

/**
 * CheckcommissionList数据访问接口Mapper
 * @author 
 *
 */ 
public interface ICheckcommissionListMapper {

	/**
	 * 新增CheckcommissionList
	 * @param checkcommissionList
	 */
	public void addCheckcommissionList(CheckcommissionList checkcommissionList) ;

	/**
	 * 根据条件删除CheckcommissionList
	 * @param cond 删除条件
	 */
	public void deleteCheckcommissionList(PojoDeleteCond cond) throws RuntimeException;


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
	 * 查找符合条件的记录条数CheckcommissionList
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findCheckcommissionListCount(CheckcommissionListCond cond) throws RuntimeException;
    
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
