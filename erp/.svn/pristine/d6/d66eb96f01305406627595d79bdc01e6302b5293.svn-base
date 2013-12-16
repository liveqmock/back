package com.ihk.property.data;

import com.ihk.property.data.pojo.Checkcommission;
import com.ihk.property.data.pojo.CheckcommissionCond;
import com.ihk.saleunit.data.pojo.ConfirmCond;
import com.ihk.utils.base.PojoDeleteCond;

import java.util.List;
import java.util.Map;

public interface ICheckcommissionSecMapper {

    /**
     * 新增Checkcommission
     * @param checkcommission
     */
    public void addCheckcommission(Checkcommission checkcommission) ;

    /**
     * 根据条件删除Checkcommission
     * @param cond 删除条件
     */
    public void deleteCheckcommission(PojoDeleteCond cond) throws RuntimeException;

    public void deleteCheckcommissionByUnitId(CheckcommissionCond cond) throws RuntimeException;

    public void updateCheckcommissionByUnitId(CheckcommissionCond cond) throws RuntimeException;

    public void saveCommission(CheckcommissionCond cond) throws RuntimeException;

    /**
     * 保存实收款
     * @param cond
     * @throws RuntimeException
     */
    public void savePayment(CheckcommissionCond cond) throws RuntimeException;


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
     * 查找符合条件的记录条数Checkcommission
     * @param cond 查询条件
     * @return 记录条数
     */
    public int findCheckcommissionCount(CheckcommissionCond cond) throws RuntimeException;

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
     * 查询已对数单元
     * @param cond
     * @return
     * @throws RuntimeException
     */
    public List<Map<String, Object>> findCheckfeeEd(ConfirmCond cond) throws RuntimeException;

    /**
     * 部分回款
     * @param cond
     * @return
     * @throws RuntimeException
     */
    public List<Map<String, Object>> findCheckfeePart(ConfirmCond cond) throws RuntimeException;

    /**
     * 查看对佣表
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
