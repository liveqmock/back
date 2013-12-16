package com.ihk.property.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihk.property.data.pojo.UnitImage;
import com.ihk.property.data.pojo.UnitImageCond;

/**
 * UnitImage的Services接口(业务接口)
 * @author 
 *
 */
@Transactional 
public interface IUnitImageServices {

	/**
	 * 新增UnitImage
	 * @param unitImage
	 */
	public void addUnitImage(UnitImage unitImage) throws RuntimeException;

	/**
	 * 删除一条UnitImage
	 * @param id
	 */
	public void deleteUnitImage(int id) throws RuntimeException;

	/**
	 * 修改UnitImage
	 * @param unitImage
	 */
	public void updateUnitImage(UnitImage unitImage) throws RuntimeException;

	/**
	 * 查找一条UnitImage
	 * @return UnitImage
	 * @param id 主键id
	 */
	public UnitImage findUnitImageById(int id) throws RuntimeException;

	/**
	 * 分页查找UnitImage
	 * @param cond 查询条件
	 * @return UnitImage列表
	 */
	public List<UnitImage> findUnitImagePage(UnitImageCond cond) throws RuntimeException;

	/**
	 * 查找全部UnitImage
	 * @param cond 查询条件
	 * @return UnitImage列表
	 */
	public List<UnitImage> findUnitImage(UnitImageCond cond) throws RuntimeException;
	
	/**
	 * 根据unitId 查找
	 * @param unitId
	 * @return
	 * @throws RuntimeException
	 */
	public List<UnitImage> findUnitImageByUnitId(int unitId) throws RuntimeException;
}