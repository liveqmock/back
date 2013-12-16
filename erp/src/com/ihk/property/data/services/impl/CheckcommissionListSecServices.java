package com.ihk.property.data.services.impl;

import com.ihk.property.data.ICheckcommissionListSecMapper;
import com.ihk.property.data.pojo.CheckcommissionListSec;
import com.ihk.property.data.pojo.CheckcommissionListSecCond;
import com.ihk.property.data.services.ICheckcommissionListSecServices;
import com.ihk.utils.base.PojoDeleteCond;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("checkcommissionListSecServices")
public class CheckcommissionListSecServices implements ICheckcommissionListSecServices {
    /**
     * checkcommissionList数据访问接口
     */
    @Autowired
    ICheckcommissionListSecMapper checkcommissionListSecMapper;

    /**
     * 删除一条CheckcommissionList
     * @param id
     */
    @Override
    public void deleteCheckcommissionList(int id) throws RuntimeException {
        checkcommissionListSecMapper.deleteCheckcommissionList(new PojoDeleteCond(id));
    }

    /**
     * 新增CheckcommissionList
     * @param checkcommissionList
     */
    @Override
    public void addCheckcommissionList(CheckcommissionListSec checkcommissionList) throws RuntimeException {
        checkcommissionListSecMapper.addCheckcommissionList(checkcommissionList);
    }

    /**
     * 查找一条CheckcommissionList
     * @return CheckcommissionList
     * @param id 主键id
     */
    @Override
    public CheckcommissionListSec findCheckcommissionListById(int id) throws RuntimeException {
        return checkcommissionListSecMapper.findCheckcommissionListById(id);
    }

    /**
     * 修改CheckcommissionList
     * @param checkcommissionList
     */
    @Override
    public void updateCheckcommissionList(CheckcommissionListSec checkcommissionList) throws RuntimeException {
        checkcommissionListSecMapper.updateCheckcommissionList(checkcommissionList);
    }

    /**
     * 分页查找CheckcommissionList
     * @param cond 查询条件
     * @return CheckcommissionList列表
     */
    @Override
    public List<CheckcommissionListSec> findCheckcommissionListPage(CheckcommissionListSecCond cond) throws RuntimeException {
        int recordCount = checkcommissionListSecMapper.findCheckcommissionListCount(cond);

        cond.recordCount = recordCount;

        return checkcommissionListSecMapper.findCheckcommissionListPage(cond);
    }

    /**
     * 查找全部CheckcommissionList
     * @param cond 查询条件
     * @return CheckcommissionList列表
     */
    @Override
    public List<CheckcommissionListSec> findCheckcommissionList(CheckcommissionListSecCond cond) throws RuntimeException {
        return checkcommissionListSecMapper.findCheckcommissionList(cond);
    }

    /**
     * ajax分页查找CheckcommissionList
     * @param cond 查询条件
     * @return CheckcommissionList列表
     */
    @Override
    public List<CheckcommissionListSec> findCheckcommissionListForAjax(CheckcommissionListSecCond cond) throws RuntimeException {
        return checkcommissionListSecMapper.findCheckcommissionListForAjax(cond);
    }

    /**
     * ajax分页查找CheckcommissionList总数
     * @param cond 查询条件
     * @return int
     */
    @Override
    public int findCheckcommissionListCountForAjax(CheckcommissionListSecCond cond) throws RuntimeException {
        return checkcommissionListSecMapper.findCheckcommissionListCountForAjax(cond);
    }

    @Override
    public List<CheckcommissionListSec> findCheckcommissionListByPrjId(CheckcommissionListSecCond cond) throws RuntimeException {
        return checkcommissionListSecMapper.findCheckcommissionListByPrjId(cond);
    }
}
