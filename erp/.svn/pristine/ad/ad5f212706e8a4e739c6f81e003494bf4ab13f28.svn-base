package com.ihk.property.data.services;

import java.util.List;
import java.util.Map;

import com.ihk.property.data.pojo.Checkcommission;
import com.ihk.property.data.pojo.CheckcommissionCond;
import com.ihk.saleunit.data.pojo.ConfirmCond;
import org.springframework.transaction.annotation.Transactional;

import com.ihk.property.data.pojo.CheckcommissionSec;
import com.ihk.property.data.pojo.CheckcommissionSecCond;

@Transactional
public interface ICheckcommissionSecServices {

    /**
     * 新增Checkcommission
     * @param checkcommission
     */
    public void addCheckcommission(Checkcommission checkcommission) throws RuntimeException;

    /**
     * 删除一条Checkcommission
     * @param id
     */
    public void deleteCheckcommission(int id) throws RuntimeException;

    /**
     * 按单元id删除 一条 Checkcommission
     * @param cond
     * @throws RuntimeException
     */
    public void deleteCheckcommissionByUnitId(CheckcommissionCond cond ) throws RuntimeException;

    /**
     * unitid 更新对佣表状态
     * @param cond
     * @throws RuntimeException
     */
    public void updateCheckcommissionByUnitId(CheckcommissionCond cond ) throws RuntimeException;

    /**
     * 保存佣金点
     * @param cond
     * @throws RuntimeException
     */
    public void saveCommission(CheckcommissionCond cond ) throws RuntimeException;

    public void savePayment(CheckcommissionCond cond ) throws RuntimeException;

    /**
     * 修改Checkcommission
     * @param checkcommission
     */
    public void updateCheckcommission(Checkcommission checkcommission) throws RuntimeException;

    /**
     * 查找一条Checkcommission
     * @return Checkcommission
     * @param id 主键id
     */
    public Checkcommission findCheckcommissionById(int id) throws RuntimeException;

    /**
     * 分页查找Checkcommission
     * @param cond 查询条件
     * @return Checkcommission列表
     */
    public List<Checkcommission> findCheckcommissionPage(CheckcommissionCond cond) throws RuntimeException;

    /**
     * 查找全部Checkcommission
     * @param cond 查询条件
     * @return Checkcommission列表
     */
    public List<Checkcommission> findCheckcommission(CheckcommissionCond cond) throws RuntimeException;

    /**
     * ajax分页查找Checkcommission
     * @param cond
     * @return
     * @throws RuntimeException
     */
    public List<Checkcommission> findCheckcommissionForAjax(CheckcommissionCond cond) throws RuntimeException;

    /**
     * ajax分页查找Checkcommission总数
     * @param cond
     * @return
     * @throws RuntimeException
     */
    public int findCheckcommissionCountForAjax(CheckcommissionCond cond) throws RuntimeException;

    public void updateCheckcommissionByRepay(CheckcommissionCond cond) throws RuntimeException;

    /**
     * 全额回款
     * @param cond
     * @return
     * @throws RuntimeException
     */
    public List<Map<String, Object>> findCheckfeeEd(ConfirmCond cond) throws RuntimeException;

    /**
     * 部分回款查询
     * @param cond
     * @return
     * @throws RuntimeException
     */
    public List<Map<String, Object>> findCheckfeePart(ConfirmCond cond) throws RuntimeException;

    /**
     *查看对佣表
     * @param cond
     * @return
     * @throws RuntimeException
     */
    public List<Map<String, Object>> findCheckcommissionView(ConfirmCond cond) throws RuntimeException;

    public List<Map<String, Object>> checkDateList(CheckcommissionCond cond) throws RuntimeException;

    /**
     * 对佣表统计
     * @param cond
     * @return
     * @throws RuntimeException
     */
    public List<Map<String, Object>> sumByUnitId(CheckcommissionCond cond) throws RuntimeException;

}