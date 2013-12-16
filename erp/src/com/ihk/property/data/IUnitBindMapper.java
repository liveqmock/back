package com.ihk.property.data;

import java.util.List;
import java.util.Map;

import com.ihk.property.data.pojo.UnitBind;
import com.ihk.property.data.pojo.UnitBindCond;

/**
 * UnitBind数据访问接口Mapper
 * @author 
 *
 */ 
public interface IUnitBindMapper {

	/**
	 * 新增UnitBind
	 * @param unitBind
	 */
	public void addUnitBind(UnitBind unitBind) ;

	/**
	 * 根据条件删除UnitBind
	 * @param cond 删除条件
	 */
	public void deleteUnitBind(int id) throws RuntimeException;

	/**
	 * 修改UnitBind
	 * @param unitBind
	 */
	public void updateUnitBind(UnitBind unitBind) throws RuntimeException;

    
	/**
	 * 查找一条UnitBind
	 * @return UnitBind
	 * @param id 主键id
	 */
	public UnitBind findUnitBindById(int id) throws RuntimeException;

	/**
	 * 分页查找UnitBind
	 * @param cond 查询条件
	 * @return UnitBind列表
	 */
	public List<UnitBind> findUnitBindPage(UnitBindCond cond) ;

	/**
	 * 查找全部UnitBind
	 * @param cond 查询条件
	 * @return UnitBind列表
	 */
	public List<UnitBind> findUnitBind(UnitBindCond cond) ;

	/**
	 * 查找符合条件的记录条数UnitBind
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findUnitBindCount(UnitBindCond cond) ;
	
	/**
	 * 根据buildId进行删除
	 * @param buildId
	 * @return
	 */
	public int deletedByBuildId (int buildId);
}
