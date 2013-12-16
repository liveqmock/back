package com.ihk.property.data;

import java.util.List;

import com.ihk.property.data.pojo.UnitImage;
import com.ihk.property.data.pojo.UnitImageCond;

/**
 * UnitImage数据访问接口Mapper
 * @author 
 *
 */ 
public interface IUnitImageMapper {

	/**
	 * 新增UnitImage
	 * @param unitImage
	 */
	public void addUnitImage(UnitImage unitImage) ;

	/**
	 * 根据条件删除UnitImage
	 * @param cond 删除条件
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
	public List<UnitImage> findUnitImagePage(UnitImageCond cond) ;

	/**
	 * 查找全部UnitImage
	 * @param cond 查询条件
	 * @return UnitImage列表
	 */
	public List<UnitImage> findUnitImage(UnitImageCond cond) ;

	/**
	 * 查找符合条件的记录条数UnitImage
	 * @param cond 查询条件
	 * @return 记录条数
	 */
	public int findUnitImageCount(UnitImageCond cond) ;
	
	/**
	 * 根据unitId查找
	 * @param unitId
	 * @return
	 * @throws RuntimeException
	 */
	public List<UnitImage> findUnitImageByUnitId(int unitId) throws RuntimeException;
}
