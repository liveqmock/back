package com.ihk.saleunit.data;

import java.util.List;

import com.ihk.saleunit.data.pojo.CancelUnit;
import com.ihk.saleunit.data.pojo.CancelUnitCond;
import com.ihk.utils.base.PojoDeleteCond;

/**
 * CancelUnit数据访问接口Mapper
 * @author 
 *
 */ 
public interface ICancelUnitMapper {

	/**
	 * 新增CancelUnit
	 * @param cancelUnit
	 */
	public void addCancelUnit(CancelUnit cancelUnit) ;

	/**
	 * 根据条件删除CancelUnit
	 * @param cond 删除条件
	 */
	public void deleteCancelUnit(PojoDeleteCond cond) throws RuntimeException;


	/**
	 * 修改CancelUnit
	 * @param cancelUnit
	 */
	public void updateCancelUnit(CancelUnit cancelUnit) throws RuntimeException;
	
    
	/**
	 * 查找一条CancelUnit
	 * @return CancelUnit
	 * @param id 主键id
	 */
	public CancelUnit findCancelUnitById(int id) throws RuntimeException;
	
	/**
	 * 查找多条CancelUnit
	 * @return CancelUnit
	 * @param id 主键unit_id
	 */
	public List<CancelUnit> findCancelUnitByUnitId(int unitId) throws RuntimeException;
	    
	/**
	 * 分页查找CancelUnit
	 * @param cond 查询条件
	 * @return CancelUnit列表
	 */
	public List<CancelUnit> findCancelUnitPage(CancelUnitCond cond) ;
        
	/**
	 * 查找全部CancelUnit
	 * @param cond 查询条件
	 * @return CancelUnit列表
	 */
	public List<CancelUnit> findCancelUnit(CancelUnitCond cond) ;
    
	/**
	 * 查找符合条件的记录条数CancelUnit
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findCancelUnitCount(CancelUnitCond cond) ;
}
