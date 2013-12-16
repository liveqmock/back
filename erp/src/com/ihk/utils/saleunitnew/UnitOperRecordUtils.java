package com.ihk.utils.saleunitnew;

import com.ihk.saleunit.data.pojo.UnitOperRecord;
import com.ihk.saleunit.data.services.IUnitOperRecordServices;
import com.ihk.utils.CommonPojoUtils;
import com.ihk.utils.common.unit.CommonUnitPojoUtils;
import com.ihk.utils.exception.UnitOperRecordException;
import com.ihk.utils.saleunit.MyPropertyUtils;

/**
 * 单元操作记录
 * @author dtc
 * 2013-4-28,上午11:48:01
 */
public class UnitOperRecordUtils {
	
	/**
	 * 增加单元状态改变的操作日志
	 * operType操作类型,为单元的新状态,与ContUnitSaleState.java一致
	 * 可以根据对应单元的上一条记录去判断是否能增加对应的状态记录
	 * @param unitId
	 * @param operType
	 * @param mainId
	 * @throws Exception
	 */
	public static void addOperRecord(int unitId, String operType, int mainId) throws RuntimeException{
		
		try{
			IUnitOperRecordServices unitOperRecordServices  = MyPropertyUtils.getUnitOperRecordServices();
			
			//要新增的记录
			UnitOperRecord record = new UnitOperRecord();
			
			//对应单元的上一条有效记录
			UnitOperRecord prevRecord = unitOperRecordServices.findUnitOperRecordForLimit1ByUnitId(unitId);
			if(prevRecord != null){
				
				record.setParentId(prevRecord.getId());
			}else{
				
				record.setParentId(0);
			}
	
			record.setUnitId(unitId);
			CommonUnitPojoUtils.initPojoCommonFiled(record);
			
			record.setOperType(operType);
			record.setMainId(mainId);
			
			CommonPojoUtils.initPojoCommonFiled(record);
			
			unitOperRecordServices.addUnitOperRecord(record);
			
		}catch (Exception e) {
			
			throw new UnitOperRecordException(e);
		}
		
	}
	
	
public static void addOperRecordForRename(int unitId, String operType, int mainId) throws RuntimeException{
		
		try{
			IUnitOperRecordServices unitOperRecordServices  = MyPropertyUtils.getUnitOperRecordServices();
			
			//要新增的记录
			UnitOperRecord record = new UnitOperRecord();
			
			//对应单元的上一条有效记录
			UnitOperRecord prevRecord = unitOperRecordServices.findUnitOperRecordForLimit1ByUnitId(unitId);
			if(prevRecord != null){
				
				record.setParentId(prevRecord.getId());
			}else{
				
				record.setParentId(0);
			}
	
			record.setUnitId(unitId);
			//CommonUnitPojoUtils.initPojoCommonFiled(record);
			
			record.setOperType(operType);
			record.setMainId(mainId);
			
			CommonPojoUtils.initPojoCommonFiled(record);
			
			unitOperRecordServices.addUnitOperRecord(record);
			
		}catch (Exception e) {
			
			throw new UnitOperRecordException(e);
		}
		
	}

}
