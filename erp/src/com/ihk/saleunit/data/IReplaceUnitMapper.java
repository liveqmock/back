package com.ihk.saleunit.data;

import java.util.List;

import com.ihk.saleunit.data.pojo.ReplaceUnit;
import com.ihk.saleunit.data.pojo.ReplaceUnitCond;
import com.ihk.utils.base.PojoDeleteCond;

/**
 * ReplaceUnit数据访问接口Mapper
 * @author 
 *
 */ 
public interface IReplaceUnitMapper {

	/**
	 * 新增ReplaceUnit
	 * @param replaceUnit
	 */
	public void addReplaceUnit(ReplaceUnit replaceUnit) ;

	/**
	 * 根据条件删除ReplaceUnit
	 * @param cond 删除条件
	 */
	public void deleteReplaceUnit(PojoDeleteCond cond) throws RuntimeException;


	/**
	 * 修改ReplaceUnit
	 * @param replaceUnit
	 */
	public void updateReplaceUnit(ReplaceUnit replaceUnit) throws RuntimeException;
	
    
	/**
	 * 查找一条ReplaceUnit
	 * @return ReplaceUnit
	 * @param id 主键id
	 */
	public ReplaceUnit findReplaceUnitById(int id) throws RuntimeException;
	
	/**
	 * 查找多条ReplaceUnit
	 * @return ReplaceUnit
	 * @param id 主键id
	 */
	public List<ReplaceUnit> findReplaceUnitByUnitId(int unitId) throws RuntimeException;
	    
	/**
	 * 分页查找ReplaceUnit
	 * @param cond 查询条件
	 * @return ReplaceUnit列表
	 */
	public List<ReplaceUnit> findReplaceUnitPage(ReplaceUnitCond cond) ;
        
	/**
	 * 查找全部ReplaceUnit
	 * @param cond 查询条件
	 * @return ReplaceUnit列表
	 */
	public List<ReplaceUnit> findReplaceUnit(ReplaceUnitCond cond) ;
    
	/**
	 * 查找符合条件的记录条数ReplaceUnit
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findReplaceUnitCount(ReplaceUnitCond cond) ;
}
