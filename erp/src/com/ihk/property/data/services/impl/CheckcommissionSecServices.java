package com.ihk.property.data.services.impl;

import com.ihk.property.data.ICheckcommissionSecMapper;
import com.ihk.property.data.pojo.Checkcommission;
import com.ihk.property.data.pojo.CheckcommissionCond;
import com.ihk.property.data.services.ICheckcommissionSecServices;
import com.ihk.saleunit.data.pojo.ConfirmCond;
import com.ihk.utils.base.PojoDeleteCond;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("checkcommissionSecServices")
public class CheckcommissionSecServices implements ICheckcommissionSecServices {
    /**
     * checkcommission数据访问接口
     */
    @Autowired
    ICheckcommissionSecMapper checkcommissionSecMapper;

    /**
     * 删除一条Checkcommission
     * @param id
     */
    @Override
    public void deleteCheckcommission(int id) throws RuntimeException {
        checkcommissionSecMapper.deleteCheckcommission(new PojoDeleteCond(id));
    }

    @Override
    public void deleteCheckcommissionByUnitId(CheckcommissionCond cond) throws RuntimeException {
        checkcommissionSecMapper.deleteCheckcommissionByUnitId(cond);
    }
    @Override
    public void updateCheckcommissionByUnitId(CheckcommissionCond cond) throws RuntimeException {
        checkcommissionSecMapper.updateCheckcommissionByUnitId(cond);
    }

    @Override
    public void saveCommission(CheckcommissionCond cond) throws RuntimeException {
        checkcommissionSecMapper.saveCommission(cond);
    }

    public void savePayment(CheckcommissionCond cond) throws RuntimeException {
        checkcommissionSecMapper.savePayment(cond);
    }

    /**
     * 新增Checkcommission
     * @param checkcommission
     */
    @Override
    public void addCheckcommission(Checkcommission checkcommission) throws RuntimeException {
        checkcommissionSecMapper.addCheckcommission(checkcommission);
    }

    /**
     * 查找一条Checkcommission
     * @return Checkcommission
     * @param id 主键id
     */
    @Override
    public Checkcommission findCheckcommissionById(int id) throws RuntimeException {
        return checkcommissionSecMapper.findCheckcommissionById(id);
    }

    /**
     * 修改Checkcommission
     * @param checkcommission
     */
    @Override
    public void updateCheckcommission(Checkcommission checkcommission) throws RuntimeException {
        checkcommissionSecMapper.updateCheckcommission(checkcommission);
    }

    /**
     * 分页查找Checkcommission
     * @param cond 查询条件
     * @return Checkcommission列表
     */
    @Override
    public List<Checkcommission> findCheckcommissionPage(CheckcommissionCond cond) throws RuntimeException {
        int recordCount = checkcommissionSecMapper.findCheckcommissionCount(cond);

        cond.recordCount = recordCount;

        return checkcommissionSecMapper.findCheckcommissionPage(cond);
    }

    /**
     * 查找全部Checkcommission
     * @param cond 查询条件
     * @return Checkcommission列表
     */
    @Override
    public List<Checkcommission> findCheckcommission(CheckcommissionCond cond) throws RuntimeException {
        return checkcommissionSecMapper.findCheckcommission(cond);
    }

    /**
     * ajax分页查找Checkcommission
     * @param cond 查询条件
     * @return Checkcommission列表
     */
    @Override
    public List<Checkcommission> findCheckcommissionForAjax(CheckcommissionCond cond) throws RuntimeException {
        return checkcommissionSecMapper.findCheckcommissionForAjax(cond);
    }

    /**
     * ajax分页查找Checkcommission总数
     * @param cond 查询条件
     * @return int
     */
    @Override
    public int findCheckcommissionCountForAjax(CheckcommissionCond cond) throws RuntimeException {
        return checkcommissionSecMapper.findCheckcommissionCountForAjax(cond);
    }


    @Override
    public void updateCheckcommissionByRepay(CheckcommissionCond cond) throws RuntimeException {
        checkcommissionSecMapper.updateCheckcommissionByRepay(cond);
    }

    @Override
    public List<Map<String, Object>> findCheckfeeEd(ConfirmCond cond) throws RuntimeException {
        return checkcommissionSecMapper.findCheckfeeEd(cond);
    }

    @Override
    public List<Map<String, Object>> findCheckfeePart(ConfirmCond cond) throws RuntimeException {
        return checkcommissionSecMapper.findCheckfeePart(cond);
    }

    /**
     * 查找对佣表
     * @param cond 查询条件
     * @return Checkcommission列表
     */
    @Override
    public List<Map<String, Object>> findCheckcommissionView(ConfirmCond cond) throws RuntimeException {
        return checkcommissionSecMapper.findCheckcommissionView(cond);
    }

    @Override
    public List<Map<String, Object>> checkDateList(CheckcommissionCond cond) throws RuntimeException {
        return checkcommissionSecMapper.checkDateList(cond);
    }

    @Override
    public List<Map<String, Object>> sumByUnitId(CheckcommissionCond cond) throws RuntimeException {
        return checkcommissionSecMapper.sumByUnitId(cond);
    }
}
