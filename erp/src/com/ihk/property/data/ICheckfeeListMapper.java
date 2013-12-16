package com.ihk.property.data;

import java.util.List;

import com.ihk.property.data.pojo.CheckfeeList;
import com.ihk.property.data.pojo.CheckfeeListCond;
import com.ihk.utils.base.PojoDeleteCond;

/**
 * CheckfeeList数据访问接口Mapper
 * @author 
 *
 */ 
public interface ICheckfeeListMapper {

	/**
	 * 新增CheckfeeList
	 * @param checkfeeList
	 */
	public void addCheckfeeList(CheckfeeList checkfeeList) ;

	/**
	 * 根据条件删除CheckfeeList
	 * @param cond 删除条件
	 */
	public void deleteCheckfeeList(PojoDeleteCond cond) throws RuntimeException;


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
     * @param checkfeeListCond
     * @return
     * @throws RuntimeException
     */
    public  List<CheckfeeList> findCheckfeeListByPrjId(CheckfeeListCond checkfeeListCond) throws RuntimeException;

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
	 * 查找符合条件的记录条数CheckfeeList
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findCheckfeeListCount(CheckfeeListCond cond) throws RuntimeException;
    
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
