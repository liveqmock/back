package com.ihk.property.data.services;

import java.util.List;

import com.ihk.property.data.pojo.CheckcommissionList;
import com.ihk.property.data.pojo.CheckcommissionListCond;
import org.springframework.transaction.annotation.Transactional;

import com.ihk.property.data.pojo.CheckcommissionListSec;
import com.ihk.property.data.pojo.CheckcommissionListSecCond;

@Transactional
public interface ICheckcommissionListSecServices {

    /**
     * 新增CheckcommissionList
     * @param checkcommissionList
     */
    public void addCheckcommissionList(CheckcommissionListSec checkcommissionList) throws RuntimeException;

    /**
     * 删除一条CheckcommissionList
     * @param id
     */
    public void deleteCheckcommissionList(int id) throws RuntimeException;

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