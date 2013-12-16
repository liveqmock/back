package com.ihk.utils.saleunit;

import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.saleunit.data.pojo.Confirm;
import com.ihk.saleunit.data.pojo.Contract;
import com.ihk.saleunit.data.pojo.SaleUnitLog;
import com.ihk.utils.SessionUser;

/**

 * 表: sale_unit_log
 * 相关表: property_unit,confirm,contract
 * 使用:propertyUnitServices,confirmServices,contractServices
 * 
 * 当在修改记录和添加记录时候,增加记录
 * */
public class SaleUnitLogUtils {
	public final static String TYPE_NEW = "1";//--新建
	public final static String TYPE_UPDATE = "2";//--修改
	
	public final static String MIAN_CLASS_UNIT = "1";
	public final static String MIAN_CLASS_CONFIRM = "2";
	public final static String MIAN_CLASS_CONTRACT = "3";
	
	/**
	 * ConfirmLog操作记录 如果是新建 confirmOld 传null
	 * @param confirmNew 新数据
	 * @param confirmOld 老数据
	 * @param type 修改类型 SaleUnitLogUtils.TYPE_NEW or SaleUnitLogUtils.TYPE_UPDATE
	 * @return boolean 成功增加true else false
	 * */
	public static boolean addConfirmLog(Confirm confirmOld,Confirm confirmNew,String type){
		boolean res = false;
		try {
			SaleUnitLog saleUnitLog = new SaleUnitLog();
			saleUnitLog.setUnitId(confirmNew.getUnitId());
			saleUnitLog.setMainClass(SaleUnitLogUtils.MIAN_CLASS_CONFIRM);
			saleUnitLog.setConCustomerId(confirmNew.getCustomerId());
			saleUnitLog.setMainId(confirmNew.getId());
			saleUnitLog.setUserId(SessionUser.getUserId());
			String mark="";
			if(type.equals(TYPE_NEW)){
					saleUnitLog.setType(SaleUnitLogUtils.TYPE_NEW);
					mark = "总价:"+confirmNew.getSumMoney()+"\n"+"协议总价:"+confirmNew.getAgreeMoney()+"\n"+"业务员:"+confirmNew.getSalesId();
			}else if(type.equals(TYPE_UPDATE)){
				saleUnitLog.setType(SaleUnitLogUtils.TYPE_UPDATE);
				mark = "总价:"+confirmOld.getSumMoney()+">"+confirmNew.getSumMoney()+"\n"+
				"协议总价:"+confirmOld.getAgreeMoney()+">"+confirmNew.getAgreeMoney()+"\n"+"业务员:"+confirmNew.getSalesId();
			}
			saleUnitLog.setMark(mark);
			MyPropertyUtils.getSaleUnitLogServices().addSaleUnitLog(saleUnitLog);
			res = true;
		}catch (Exception e) {
			e.printStackTrace();
			res = false;
		}
		return res;
	}
	
	/**
	 * Contract 日志记录 如果type=新建 contractOld不做处理
	 * @param contractNew 新数据
	 * @param contractOld 老数据
	 * @param type 修改类型 SaleUnitLogUtils.TYPE_NEW or SaleUnitLogUtils.TYPE_UPDATE
	 * @return boolean 成功增加true else false
	 * */
	public static boolean addContractLog(Contract contractOld,Contract contractNew,String type){
		boolean res = false;
		try {
			SaleUnitLog saleUnitLog = new SaleUnitLog();
			saleUnitLog.setUnitId(contractNew.getUnitId());
			saleUnitLog.setMainClass(SaleUnitLogUtils.MIAN_CLASS_CONTRACT);
			saleUnitLog.setConCustomerId(contractNew.getCustomerId());
			saleUnitLog.setMainId(contractNew.getId());
			saleUnitLog.setUserId(SessionUser.getUserId());
			String mark = "";
			if(type.equals(TYPE_NEW)){
				saleUnitLog.setType(SaleUnitLogUtils.TYPE_NEW);
				mark = "总价:"+contractNew.getSumMoney();
			}else if(type.equals(TYPE_UPDATE)){
				saleUnitLog.setType(SaleUnitLogUtils.TYPE_UPDATE);
				mark = "总价:"+contractOld.getSumMoney()+">"+contractNew.getSumMoney();
			}
			saleUnitLog.setMark(mark);
			MyPropertyUtils.getSaleUnitLogServices().addSaleUnitLog(saleUnitLog);
			res = true;
		}catch (Exception e) {
			e.printStackTrace();
			res = false;
		}
		return res;
	}
	
	public static boolean addUnitLog(PropertyUnit unitOld,PropertyUnit unitNew,String type){
		return false;
	}
}
