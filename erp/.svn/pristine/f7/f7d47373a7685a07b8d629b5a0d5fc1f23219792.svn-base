package com.ihk.property.data.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.property.data.IUnitImageMapper;
import com.ihk.property.data.pojo.UnitImage;
import com.ihk.property.data.pojo.UnitImageCond;
import com.ihk.property.data.services.IUnitImageServices;

/**
 * UnitImage的Services实现(业务实现)
 * @author 
 *
 */
@Service("unitImageServices")
public class UnitImageServices implements IUnitImageServices {
	/**
	 * unitImage数据访问接口
	 */
	@Autowired	 IUnitImageMapper unitImageMapper;

	/**
	 * 删除一条UnitImage
	 * @param id
	 */
	public void deleteUnitImage(int id) throws RuntimeException {
		unitImageMapper.deleteUnitImage(id);
	}

	/**
	 * 新增UnitImage
	 * @param unitImage
	 */
	public void addUnitImage(UnitImage unitImage) throws RuntimeException {		
		unitImageMapper.addUnitImage(unitImage);
	}

	/**
	 * 查找一条UnitImage
	 * @return UnitImage
	 * @param id 主键id
	 */
	@Override
	public UnitImage findUnitImageById(int id) throws RuntimeException {
		return unitImageMapper.findUnitImageById(id);
	}

	/**
	 * 修改UnitImage
	 * @param unitImage
	 */
	@Override
	public void updateUnitImage(UnitImage unitImage) throws RuntimeException {
		unitImageMapper.updateUnitImage(unitImage);		
	}

	/**
	 * 分页查找UnitImage
	 * @param cond 查询条件
	 * @return UnitImage列表
	 */
	public List<UnitImage> findUnitImagePage(UnitImageCond cond) throws RuntimeException {
		int recordCount = unitImageMapper.findUnitImageCount(cond);
		
		cond.recordCount = recordCount;
				
		return unitImageMapper.findUnitImagePage(cond);
	}

	/**
	 * 查找全部UnitImage
	 * @param cond 查询条件
	 * @return UnitImage列表
	 */
	public List<UnitImage> findUnitImage(UnitImageCond cond) throws RuntimeException {
    	return unitImageMapper.findUnitImage(cond);
	}

	/**
	 * 根据unitId查找
	 */
	@Override
	public List<UnitImage> findUnitImageByUnitId(int unitId) throws RuntimeException {
		
		return unitImageMapper.findUnitImageByUnitId(unitId);
	}
}
