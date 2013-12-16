package com.ihk.saleunit.data.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihk.saleunit.data.IUnitOperRecordMapper;
import com.ihk.saleunit.data.pojo.UnitOperRecord;
import com.ihk.saleunit.data.pojo.UnitOperRecordCond;
import com.ihk.saleunit.data.services.IUnitOperRecordServices;

import com.ihk.utils.base.PojoDeleteCond;

/**
 * UnitOperRecord的Services实现(业务实现)
 * @author 
 *
 */
@Service("unitOperRecordServices")
public class UnitOperRecordServices implements IUnitOperRecordServices {
	/**
	 * unitOperRecord数据访问接口
	 */
	@Autowired	 IUnitOperRecordMapper unitOperRecordMapper;

	/**
	 * 删除一条UnitOperRecord
	 * @param id
	 */
    @Override
	public void deleteUnitOperRecord(int id) throws RuntimeException {
		unitOperRecordMapper.deleteUnitOperRecord(new PojoDeleteCond(id));
	}

	/**
	 * 新增UnitOperRecord
	 * @param unitOperRecord
	 */
    @Override
	public void addUnitOperRecord(UnitOperRecord unitOperRecord) throws RuntimeException {		
		unitOperRecordMapper.addUnitOperRecord(unitOperRecord);
	}

	/**
	 * 查找一条UnitOperRecord
	 * @return UnitOperRecord
	 * @param id 主键id
	 */
	@Override
	public UnitOperRecord findUnitOperRecordById(int id) throws RuntimeException {
		return unitOperRecordMapper.findUnitOperRecordById(id);
	}

	/**
	 * 修改UnitOperRecord
	 * @param unitOperRecord
	 */
	@Override
	public void updateUnitOperRecord(UnitOperRecord unitOperRecord) throws RuntimeException {
		unitOperRecordMapper.updateUnitOperRecord(unitOperRecord);		
	}
	    
	/**
	 * 分页查找UnitOperRecord
	 * @param cond 查询条件
	 * @return UnitOperRecord列表
	 */
    @Override
	public List<UnitOperRecord> findUnitOperRecordPage(UnitOperRecordCond cond) throws RuntimeException {
		int recordCount = unitOperRecordMapper.findUnitOperRecordCount(cond);
		
		cond.recordCount = recordCount;
				
		return unitOperRecordMapper.findUnitOperRecordPage(cond);
	}
        
	/**
	 * 查找全部UnitOperRecord
	 * @param cond 查询条件
	 * @return UnitOperRecord列表
	 */
    @Override
	public List<UnitOperRecord> findUnitOperRecord(UnitOperRecordCond cond) throws RuntimeException {
    	return unitOperRecordMapper.findUnitOperRecord(cond);
	}
    
    /**
	 * ajax分页查找UnitOperRecord
	 * @param cond 查询条件
	 * @return UnitOperRecord列表
	 */
    @Override
	public List<UnitOperRecord> findUnitOperRecordForAjax(UnitOperRecordCond cond) throws RuntimeException {
        return unitOperRecordMapper.findUnitOperRecordForAjax(cond);
	}
    
     /**
	 * ajax分页查找UnitOperRecord总数
	 * @param cond 查询条件
	 * @return int
	 */
    @Override
    public int findUnitOperRecordCountForAjax(UnitOperRecordCond cond) throws RuntimeException {
        return unitOperRecordMapper.findUnitOperRecordCountForAjax(cond);
    }

	@Override
	public UnitOperRecord findUnitOperRecordByUnitIdOfMaxId(int unitId)
			throws RuntimeException {
		return unitOperRecordMapper.findUnitOperRecordByUnitIdOfMaxId(unitId);
	}

	@Override
	public List<UnitOperRecord> findUnitOperRecordByUnitId(int unitId)
			throws RuntimeException {
		return unitOperRecordMapper.findUnitOperRecordByUnitId(unitId);
	}
	
	@Override
	public UnitOperRecord findUnitOperRecordForLimit1ByUnitId(int unitId)
			throws RuntimeException {
		return unitOperRecordMapper.findUnitOperRecordForLimit1ByUnitId(unitId);
	}
}
