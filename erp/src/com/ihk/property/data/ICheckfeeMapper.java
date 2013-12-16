package com.ihk.property.data;

import java.util.List;
import java.util.Map;

import com.ihk.property.data.pojo.Checkfee;
import com.ihk.saleunit.action.check_fee.pojo.CheckFeeCond;
import com.ihk.utils.base.PojoDeleteCond;

/**
 * Checkfee数据访问接口Mapper
 * @author 
 *
 */ 
public interface ICheckfeeMapper {

	/**
	 * 新增Checkfee
	 * @param checkfee
	 */
	public void addCheckfee(Checkfee checkfee) ;

	/**
	 * 根据条件删除Checkfee
	 * @param cond 删除条件
	 */
	public void deleteCheckfee(PojoDeleteCond cond) throws RuntimeException;

    /**
     * 按单元ID 删除
     * @param cond
     * @throws RuntimeException
     */
	public void deleteCheckfeeByUnitId(CheckFeeCond cond) throws RuntimeException;


	/**
	 * 修改Checkfee
	 * @param checkfee
	 */
	public void updateCheckfee(Checkfee checkfee) throws RuntimeException;

    /**
     * 修改对数表状态
     * @param cond
     * @throws RuntimeException
     */
	public void updateCheckfeeByUnitId(CheckFeeCond cond) throws RuntimeException;

    /**
     * 修改回款金额
     * @param cond
     * @throws RuntimeException
     */
	public void updateCheckfeeByRepay(CheckFeeCond cond) throws RuntimeException;

    
	/**
	 * 查找一条Checkfee
	 * @return Checkfee
	 * @param id 主键id
	 */
	public Checkfee findCheckfeeById(int id) throws RuntimeException;

    public Checkfee findCheckfeeByUnitId(int unitId) throws RuntimeException;

	/**
	 * 分页查找Checkfee
	 * @param cond 查询条件
	 * @return Checkfee列表
	 */
	public List<Checkfee> findCheckfeePage(CheckFeeCond cond) throws RuntimeException;
        
	/**
	 * 查找全部Checkfee
	 * @param cond 查询条件
	 * @return Checkfee列表
	 */
	public List<Checkfee> findCheckfee(CheckFeeCond cond) throws RuntimeException;
    
	/**
	 * 查找符合条件的记录条数Checkfee
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findCheckfeeCount(CheckFeeCond cond) throws RuntimeException;
    
     /**
	 * ajax分页查找Checkfee
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
    public List<Checkfee> findCheckfeeForAjax(CheckFeeCond cond) throws RuntimeException;
    
    /**
	 * ajax分页查找Checkfee总数
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
    public int findCheckfeeCountForAjax(CheckFeeCond cond) throws RuntimeException;
    
    /**
     * 根据应收id获取对应的对数日期为最近的对数数据
     * @param billId
     * @return
     * @throws RuntimeException
     */
    public Checkfee findLastCheckfeeDateByBillId(int billId) throws RuntimeException;
    
    
    
    public List<Map> findCheckfeeListByUnitIdList(Map<String,List> ids) throws RuntimeException;
    
    public List<Map> findCheckfeeListByCond(Map<String,Object> map) throws RuntimeException;
}
