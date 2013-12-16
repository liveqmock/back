package com.ihk.saleunit.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.saleunit.data.pojo.Chip;
import com.ihk.saleunit.data.pojo.ChipCond;

/**
 * Chip的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
public interface IChipServices {
	/**
	 * 新增Chip
	 * @param chip
	 */
	public void addChip(Chip chip) throws RuntimeException;

	/**
	 * 删除一条Chip
	 * @param id
	 */
	public void deleteChip(int id) throws RuntimeException;

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
	public List<Chip> findChipPage(ChipCond cond) throws RuntimeException;

	/**
	 * 查找全部Chip
	 * @param cond 查询条件
	 * @return Chip列表
	 */
	public List<Chip> findChip(ChipCond cond) throws RuntimeException;
	
	/**
	 * 根据unitId与chipNo查找
	 * @param unitId
	 * @param chipNo
	 * @return
	 * @throws RuntimeException
	 */
	public List<Chip> findChipByUnitIdAndChipNo(int unitId, int chipNo) throws RuntimeException;
	
	/**
	 * 查找最大chipNo的Chip
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
	public void disabledChip(int id) throws RuntimeException;
	
}