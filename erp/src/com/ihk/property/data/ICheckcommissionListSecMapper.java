package com.ihk.property.data;

import com.ihk.property.data.pojo.CheckcommissionListSec;
import com.ihk.property.data.pojo.CheckcommissionListSecCond;
import com.ihk.utils.base.PojoDeleteCond;

import java.util.List;

public interface ICheckcommissionListSecMapper {

    /**
     * 新增CheckcommissionList
     * @param checkcommissionList
     */
    public void addCheckcommissionList(CheckcommissionListSec checkcommissionList) ;

    /**
     * 根据条件删除CheckcommissionList
     * @param cond 删除条件
     */
    public void deleteCheckcommissionList(PojoDeleteCond cond) throws RuntimeException;


    /**
     * 修改CheckcommissionList
     * @param checkcommissionList
     */
    public void updateCheckcommissionList(CheckcommissionListSec checkcommissionList) throws RuntimeException;


    /**
     * 查找一条CheckcommissionList
     * @return CheckcommissionList
     * @param id 主键id
     */
    public CheckcommissionListSec findCheckcommissionListById(int id) throws RuntimeException;

    /**
     * 分页查找CheckcommissionList
     * @param cond 查询条件
     * @return CheckcommissionList列表
     */
    public List<CheckcommissionListSec> findCheckcommissionListPage(CheckcommissionListSecCond cond) throws RuntimeException;

    /**
     * 查找全部CheckcommissionList
     * @param cond 查询条件
     * @return CheckcommissionList列表
     */
    public List<CheckcommissionListSec> findCheckcommissionList(CheckcommissionListSecCond cond) throws RuntimeException;

    /**
     * 查找符合条件的记录条数CheckcommissionList
     * @param cond 查询条件
     * @return 记录条数
     */
    public int findCheckcommissionListCount(CheckcommissionListSecCond cond) throws RuntimeException;

    /**
     * ajax分页查找CheckcommissionList
     * @param cond
     * @return
     * @throws RuntimeException
     */
    public List<CheckcommissionListSec> findCheckcommissionListForAjax(CheckcommissionListSecCond cond) throws RuntimeException;

    /**
     * ajax分页查找CheckcommissionList总数
     * @param cond
     * @return
     * @throws RuntimeException
     */
    public int findCheckcommissionListCountForAjax(CheckcommissionListSecCond cond) throws RuntimeException;

    public List<CheckcommissionListSec> findCheckcommissionListByPrjId(CheckcommissionListSecCond cond) throws RuntimeException;
}
