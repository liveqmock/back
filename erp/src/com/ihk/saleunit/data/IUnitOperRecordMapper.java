package com.ihk.saleunit.data;

import java.util.List;

import com.ihk.saleunit.data.pojo.UnitOperRecord;
import com.ihk.saleunit.data.pojo.UnitOperRecordCond;

import com.ihk.utils.base.PojoDeleteCond;

/**
 * UnitOperRecord数据访问接口Mapper
 * @author 
 *
 */ 
public interface IUnitOperRecordMapper {

	/**
	 * 新增UnitOperRecord
	 * @param unitOperRecord
	 */
	public void addUnitOperRecord(UnitOperRecord unitOperRecord) ;

	/**
	 * 根据条件删除UnitOperRecord
	 * @param cond 删除条件
	 */
	public void deleteUnitOperRecord(PojoDeleteCond cond) throws RuntimeException;


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
	 * 查找unit_id对应最大id的UnitOperRecord
	 * @return UnitOperRecord
	 * @param id unit_id
	 */
	public UnitOperRecord findUnitOperRecordByUnitIdOfMaxId(int unitId) throws RuntimeException;
	
	/**
	 * 查找多条UnitOperRecord
	 * @return UnitOperRecord
	 * @param id unit_id
	 */
	public List<UnitOperRecord> findUnitOperRecordByUnitId(int unitId) throws RuntimeException;
	    
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
	 * 查找符合条件的记录条数UnitOperRecord
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findUnitOperRecordCount(UnitOperRecordCond cond) throws RuntimeException;
    
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
     * 获取对应单元的上一条记录
     * @param unitId
     * @return
     * @throws RuntimeException
     */
    public UnitOperRecord findUnitOperRecordForLimit1ByUnitId(int unitId) throws RuntimeException;
}
