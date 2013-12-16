package com.ihk.utils.saleunit;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.ihk.constanttype.ContUnitSaleState;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.SessionUser;

/**
 * 单元销售状态工具类
 *
 */
public class UnitSaleStateUtils {
	
	/**
	 * 不认购就不能转合同的项目id
	 */
	private static String restrictId;
	
	public void setRestrictId(String restrictId) {
		UnitSaleStateUtils.restrictId = restrictId;
	}
	
	public String getRestrictId() {
		return restrictId;
	}
	
	public static void changeSaleState(IPropertyUnitServices unitServices, int unitId, String saleState) throws Exception{
		
		try{
			
			//新建预约的时候可能为0,(没有选择单元)
			if(unitId == 0)
				return ;
			
			
			
			Map<String,String> map=new HashMap<String,String>();
			map.put("id", unitId+"");
			map.put("saleState", saleState);
			unitServices.updatePropertyUnitSaleState(map);//更新单元状态
			
		}catch(Exception e){
			
			throw e;
		}
		
	}
	
	public static void changeSaleState(int unitId, String saleState) throws Exception{
		
		try{
			
			IPropertyUnitServices unitServices = MyPropertyUtils.getPropertyUnitServices();
			
			PropertyUnit unit = unitServices.findPropertyUnitById(unitId);
			
			if(saleState.equals(ContUnitSaleState.IS_CHECK) ){
				if(unit.getSaleState().equals(ContUnitSaleState.CONTRACT)){
					unit.setSaleState(saleState);
					unit.setModId(SessionUser.getUserId());
					unit.setModTime(new Date());
					unitServices.updatePropertyUnit(unit);
					return ;
				}else{
					throw new Exception();
				}
			}
			
			if(saleState.equals(ContUnitSaleState.IS_COMMISSION) ){
				if(unit.getSaleState().equals(ContUnitSaleState.IS_CHECK)){
					unit.setSaleState(saleState);
					unit.setModId(SessionUser.getUserId());
					unit.setModTime(new Date());
					unitServices.updatePropertyUnit(unit);
					return ;
				}else{
					throw new Exception();
				}
			}
			
			unit.setSaleState(saleState);
			
			unit.setModId(SessionUser.getUserId());
			unit.setModTime(new Date());
			
			unitServices.updatePropertyUnit(unit);
			
		}catch(Exception e){
			
			throw e;
		}
		
	}
	
	/**
	 * 获取限制的公司id list
	 * @return
	 */
	public static Set<Integer> getRestrictIdSet(){
		
		Set<Integer> retSet = new HashSet<Integer>();
		
		if(!CommonUtils.isStrZeroEmpty(restrictId)){
			
			String[] ids = restrictId.split(",");
			for(String id : ids){
				
				if(!CommonUtils.isStrZeroEmpty(id)){
					retSet.add(Integer.parseInt(id));
				}
			}
		}
		
		return retSet;
	}
	
	/**
	 * 判断该unitId是否能建合同
	 * 现在所有的情况都是要先建成交才能再建合同
	 * @param unitId
	 * @return
	 */
	public static boolean isCanCreateContract(int unitId){
		
		return false;
		
		/**
		int companyId = MyPropertyUtils.getPropertyUnitServices().findUnitCompanyId(unitId);
		if(getRestrictIdSet().contains(companyId)){
			
			return false;
		}
		
		return true;
		*/
	}

}

