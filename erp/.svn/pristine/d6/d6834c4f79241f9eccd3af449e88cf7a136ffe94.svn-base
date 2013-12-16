package com.ihk.saleunit.data;

import java.util.List;
import java.util.Map;

import com.ihk.saleunit.data.pojo.Chip;
import com.ihk.saleunit.data.pojo.ChipCond;

import com.ihk.utils.base.PojoDeleteCond;

/**
 * Chip数据访问接口Mapper
 * @author 
 *
 */ 
public interface IChipMapper {

	/**
	 * 新增Chip
	 * @param chip
	 */
	public void addChip(Chip chip) ;

	/**
	 * 根据条件删除Chip
	 * @param cond 删除条件
	 */
	public void deleteChip(PojoDeleteCond cond) throws RuntimeException;

	/**
	 * 修改Chip
	 * @param chip
	 */
	public void updateChip(Chip chip) throws RuntimeException;

	/**
	 * 查找一条Chip
	 * @return Chip
	 * @param id 主键id
	 */
	public Chip findChipById(int id) throws RuntimeException;

	/**
	 * 分页查找Chip
	 * @param cond 查询条件
	 * @return Chip列表
	 */
	public List<Chip> findChipPage(ChipCond cond) ;

	/**
	 * 查找全部Chip
	 * @param cond 查询条件
	 * @return Chip列表
	 */
	public List<Chip> findChip(ChipCond cond) ;

	/**
	 * 查找符合条件的记录条数Chip
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findChipCount(ChipCond cond) ;
	
	/**
	 * 根据unitId与ChipNo查找
	 * @param map
	 * @return
	 * @throws RuntimeException
	 */
	public List<Chip> findChipByUnitIdAndChipNo(Map<String, Integer> map) throws RuntimeException;
	
	/**
	 * 查找chip的最大认筹号
	 * @return
	 * @throws RuntimeException
	 */
	public Chip findMaxNoChip() throws RuntimeException;
	
	/**
	 * 根据楼盘项目id获取对应的Chip
	 * @param propertyProjectId
	 * @return
	 * @throws RuntimeException
	 */
	public List<Chip> findChipByPropertyProjectId(int propertyProjectId) throws RuntimeException;
	
	/**
	 * 作废
	 * @param id
	 * @throws RuntimeException
	 */
	public void disabledChip(PojoDeleteCond cond) throws RuntimeException;
	
}
