package com.ihk.utils;

import java.util.HashMap;
import java.util.Map;

import com.ihk.property.data.pojo.PropertyGroup;
import com.ihk.saleunit.data.pojo.PayBill;

/**
 * AJAX异步(数据库)对象的bean
 * @author Administrator
 *
 */
public class AJAXBeanUtils {


	/**
	 * 获取json数据
	 * @param payBill
	 * @return
	 */
	public static String getJsonPayBill(PayBill payBill){
		return getJsonPayBill(payBill,"editPayBill.");
	}
	
	/**
	 * 获取json数据
	 * prefix:是前缀
	 */
	public static String getJsonPayBill(PayBill payBill,String prefix){
		
		Map<String, String> map = new HashMap<String, String>();
		
		//对象的处理
		map.put(prefix+"id", String.valueOf(payBill.getId()));			
		map.put(prefix+"confirmType", String.valueOf(payBill.getConfirmType()));			
		map.put(prefix+"mainId", String.valueOf(payBill.getMainId()));			
		map.put(prefix+"startSaleDate", DateTimeUtils.toStr(payBill.getStartSaleDate()));			
		map.put(prefix+"billType", String.valueOf(payBill.getBillType()));			
		map.put(prefix+"paperType", String.valueOf(payBill.getPaperType()));			
		map.put(prefix+"billNo", String.valueOf(payBill.getBillNo()));			
		map.put(prefix+"payMoney", String.valueOf(payBill.getPayMoney()));			
		map.put(prefix+"payMan", String.valueOf(payBill.getPayMan()));			
		map.put(prefix+"writerId", String.valueOf(payBill.getWriterId()));			
		map.put(prefix+"approvalDate", DateTimeUtils.toStr(payBill.getApprovalDate()));			
		map.put(prefix+"state", String.valueOf(payBill.getState()));			
		map.put(prefix+"remark", String.valueOf(payBill.getRemark()));				
		
		return CommonUtils.getMapJson(map);
	}
	
	
	 /**
	 * 获取json数据
	 * @param propertyGroup
	 * @return
	 */
	public static String getJsonPropertyGroup(PropertyGroup propertyGroup){
		return getJsonPropertyGroup(propertyGroup,"editPropertyGroup.");
	}
	
	/**
	 * 获取json数据
	 * @param propertyGroup
	 * prefix:是前缀
	 */
	public static String getJsonPropertyGroup(PropertyGroup propertyGroup,String prefix){
		Map<String, String> map = new HashMap<String, String>();
		
		//对象的处理
                map.put(prefix+"id", String.valueOf(propertyGroup.getId()));
                map.put(prefix+"projectId", String.valueOf(propertyGroup.getProjectId()));
                map.put(prefix+"areaId", String.valueOf(propertyGroup.getAreaId()));
                map.put(prefix+"groupName", String.valueOf(propertyGroup.getGroupName()));
                map.put(prefix+"chipType", String.valueOf(propertyGroup.getChipType()));
                map.put(prefix+"remark", String.valueOf(propertyGroup.getRemark()));
                map.put(prefix+"orderIndex", String.valueOf(propertyGroup.getOrderIndex()));
		
		return CommonUtils.getMapJson(map);
	}

}
