package com.ihk.saleunit.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.saleunit.data.pojo.UnitOperRecord;
import com.ihk.saleunit.data.pojo.UnitOperRecordCond;

/**
 * UnitOperRecord的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
public interface IUnitOperRecordServices {

	/**
	 * 新增UnitOperRecord
	 * @param unitOperRecord
	 */
	public void addUnitOperRecord(UnitOperRecord unitOperRecord) throws RuntimeException;

	/**
	 * 删除一条UnitOperRecord
	 * @param id
	 */
	public void deleteUnitOperRecord(int id) throws RuntimeException;

	/**
	 * 修改UnitOperRecord
	 * @param unitOperRecord
	 */
	public void updateUnitOperRecord(UnitOperRecord unitOperRecord) throws RuntimeException;

	/**
	 * 查找一条UnitOperRecord
	 * @return UnitOperRecord
	 * @param id 主键id
	 */
	public UnitOperRecord findUnitOperRecordById(int id) throws RuntimeException;
	
	/**
	 * 查找多条UnitOperRecord
	 * @return UnitOperRecord
	 * @param id 主键unit_id
	 */
	public List<UnitOperRecord> findUnitOperRecordByUnitId(int unitId) throws RuntimeException;
	
	/**
	 * 查找unit_id对应最大id的UnitOperRecord
	 * @return UnitOperRecord
	 * @param id unit_id
	 */
	public UnitOperRecord findUnitOperRecordByUnitIdOfMaxId(int unitId) throws RuntimeException;
	
    
	/**
	 * 分页查找UnitOperRecord
	 * @param cond 查询条件
	 * @return UnitOperRecord列表
	 */
	public List<UnitOperRecord> findUnitOperRecordPage(UnitOperRecordCond cond) throws RuntimeException;
    
	/**
	 * 查找全部UnitOperRecord
	 * @param cond 查询条件
	 * @return UnitOperRecord列表
	 */
	public List<UnitOperRecord> findUnitOperRecord(UnitOperRecordCond cond) throws RuntimeException;
    
     /**
	 * ajax分页查找UnitOperRecord
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
    public List<UnitOperRecord> findUnitOperRecordForAjax(UnitOperRecordCond cond) throws RuntimeException;
    
    /**
	 * ajax分页查找UnitOperRecord总数
	 * @param cond
	 * @return
	 * @throws RuntimeException
	 */
    public int findUnitOperRecordCountForAjax(UnitOperRecordCond cond) throws RuntimeException;
    
    /**
     * 获取对应单元的上一条记录,如果为空表示第一次增加
     * @param unitId
     * @return
     * @throws RuntimeException
     */
    public UnitOperRecord findUnitOperRecordForLimit1ByUnitId(int unitId) throws RuntimeException;
}