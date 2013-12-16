package com.ihk.utils.saleunit;

import java.util.Map;

import org.springframework.util.CollectionUtils;

import com.ihk.constanttype.ContUnitChangeTypeFrom;
import com.ihk.constanttype.ContUnitSaleState;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.chip.ChipManagerUtils;

/**
 * 判断房间单元能否进行状态变化
 * 执行房间单元的状态变化
 * @author dtc
 */
public class UnitChangeUtils {
	
	/**
	 * 认筹,临定,成交,合同 四种状态之间的转换<br/>
	 * 判断源状态是否能转成目标状态<br/>
	 * @param srcSaleState
	 * @param descSaleState
	 * @return
	 */
	public static boolean isFourSaleStateCanChange(String srcSaleState, String descSaleState){
		
		/**
		 * 楼盘初始中,单元可以直接修改的状态:可售,预留,冻结,他售,不可售<br/>
		 * 其他操作可以修改的状态:认筹,临定,成交,合同<br/>
		 */
		
		if(CommonUtils.isStrEmpty(srcSaleState) || CommonUtils.isStrEmpty(descSaleState)){
			
			return false;
		}
		
		Map<String, String> stateMap = ContUnitSaleState.getSaleState();
		if(CommonUtils.isMapEmpty(stateMap) || !stateMap.containsKey(srcSaleState) || !stateMap.containsKey(descSaleState)){
			
			return false;
		}
		
		if(!ContUnitSaleState.CHIPS.equals(descSaleState) && !ContUnitSaleState.CONFIRM_BOOK.equals(descSaleState)
				&& !ContUnitSaleState.CONFIRM.equals(descSaleState) && !ContUnitSaleState.CONTRACT.equals(descSaleState)){
			
			return false;
		}
		
		if(srcSaleState.equals(descSaleState)){
			
			return true;
		}
		
		if(ContUnitSaleState.SALE_ABLE.equals(srcSaleState)){
			
			return true;
		}
		
		if(ContUnitSaleState.RESERVE.equals(srcSaleState) || ContUnitSaleState.FROZEN.equals(srcSaleState)
				|| ContUnitSaleState.IS_SALE.equals(srcSaleState) || ContUnitSaleState.NOT_FOR_SALE.equals(srcSaleState)){
			
			return false;
		}
		
		if(ContUnitSaleState.CHIPS.equals(srcSaleState)){
			
			if(ContUnitSaleState.CONFIRM_BOOK.equals(descSaleState) || ContUnitSaleState.CONFIRM.equals(descSaleState)
					|| ContUnitSaleState.CONTRACT.equals(descSaleState)){
				
				return true;
			}else{
				
				return false;
			}
			
		}else if(ContUnitSaleState.CONFIRM_BOOK.equals(srcSaleState)){
			
			if(ContUnitSaleState.CONFIRM.equals(descSaleState) || ContUnitSaleState.CONTRACT.equals(descSaleState)){
				
				return true;
			}else{
				
				return false;
			}
			
		}else if(ContUnitSaleState.CONFIRM.equals(srcSaleState)){
			
			if(ContUnitSaleState.CONTRACT.equals(descSaleState)){
				
				return true;
			}else{
				
				return false;
			}
		}
		
		return false;
	}
	
	/**
	 * 判断单元的认筹单是否都为0，若true则单元状态修改为可售
	 * @param unit
	 */
	public static void setSaleAble(int unitId,int chip){
		
		IPropertyUnitServices unitServices = MyPropertyUtils.getPropertyUnitServices();
		
		if(chip==0){
			unitServices.updatePropertyUnitSaleState(ChipManagerUtils.initUnitSaleStateForSaleById(unitId));
		}
	}
	
	/**
	 * 该方法不通用,判断单元状态是否能转成目标状态,不要调用该方法
	 * @param typeTo 为转向的类型,appoint,confirm,contract
	 * @param unit 对应的房间单元
	 * @return
	 */
	public static boolean isCanChange(String typeTo, PropertyUnit unit){
		
		if(!CollectionUtils.contains(ContUnitChangeTypeFrom.typeFromList().iterator(), typeTo)){
			
			throw new RuntimeException("要转变的类型不合法");
		}
		
		boolean isCan = true;
		
		if(ContUnitChangeTypeFrom.APPOINT.equals(typeTo)){
			
			
		}else if(ContUnitChangeTypeFrom.CONFIRM.equals(typeTo)){
			
			if(ContUnitSaleState.CONFIRM.equals(unit.getSaleState()) || ContUnitSaleState.CONTRACT.equals(unit.getSaleState())){
				isCan = false;
			}
			
		}else if(ContUnitChangeTypeFrom.CONTRACT.equals(typeTo)){
			
			if(ContUnitSaleState.CONTRACT.equals(unit.getSaleState())){
				isCan = false;
			}
		}
		
		return isCan;
	}
	
	/**
	 * 根据单元的状态本身判断能否修改状态
	 * @param unit
	 * @param contUnitSaleState
	 * 默认都是可以转的
	 * @return
	 */
	/**该方法有问题
	public static boolean isCanChangeCheckByState(PropertyUnit unit,String contUnitSaleState){
		
		//不能转为冻结的情况
		if(unit.getSaleState().equals(ContUnitSaleState.CONFIRM)
				|| unit.getSaleState().equals(ContUnitSaleState.CONTRACT)
				|| unit.getSaleState().equals(ContUnitSaleState.DELIVERY)
				|| unit.getSaleState().equals(ContUnitSaleState.CERTIFICATE)){
			return false;
		}
		
		//不能转为可售的情况
		if(unit.getSaleState().equals(ContUnitSaleState.CONFIRM)
				|| unit.getSaleState().equals(ContUnitSaleState.CONTRACT)
				|| unit.getSaleState().equals(ContUnitSaleState.DELIVERY)
				|| unit.getSaleState().equals(ContUnitSaleState.CERTIFICATE)){
			return false;
		}
		
		//不能转为预约的情况
		if(unit.getSaleState().equals(ContUnitSaleState.CONFIRM)
				|| unit.getSaleState().equals(ContUnitSaleState.CONTRACT)
				|| unit.getSaleState().equals(ContUnitSaleState.DELIVERY)
				|| unit.getSaleState().equals(ContUnitSaleState.CERTIFICATE)){
			return false;
		}
		
		//不能转为临订的情况
		if(unit.getSaleState().equals(ContUnitSaleState.CONFIRM)
				|| unit.getSaleState().equals(ContUnitSaleState.CONTRACT)
				|| unit.getSaleState().equals(ContUnitSaleState.DELIVERY)
				|| unit.getSaleState().equals(ContUnitSaleState.CERTIFICATE)){
			return false;
		}
		
		//不能转为认购的情况
		if(unit.getSaleState().equals(ContUnitSaleState.CONTRACT)
				|| unit.getSaleState().equals(ContUnitSaleState.DELIVERY)
				|| unit.getSaleState().equals(ContUnitSaleState.CERTIFICATE)){
			return false;
		}
		
		//不能转为已签约的情况
		if(unit.getSaleState().equals(ContUnitSaleState.DELIVERY)
				|| unit.getSaleState().equals(ContUnitSaleState.CERTIFICATE)){
			return false;
		}
		
		//不能转为已交楼的情况
		if(unit.getSaleState().equals(ContUnitSaleState.CERTIFICATE)){
			return false;
		}
		
		return true;
	}
	*/
	
	/**
	 * 判断常用单元状态是否可以转换
	 * 楼盘初始中,单元可以直接修改的状态:可售,预留,冻结,他售,不可售
	 * 其他操作可以修改的状态:认筹,临定,成交,合同
	 * @param descSaleState,目标状态
	 * @param srcUnit,源单元
	 * @return
	 */
	public static boolean isCommonSaleStateCanChange(String descSaleState, PropertyUnit srcUnit){
		
		//ContUnitSaleState
		
		String srcSaleState = srcUnit.getSaleState();
		
		if(CommonUtils.isStrEmpty(srcSaleState) || CommonUtils.isStrEmpty(descSaleState) ||
				!CollectionUtils.contains(ContUnitSaleState.getDealUnitSale().iterator(), descSaleState)){
			
			throw new RuntimeException("参数单元状态有问题");
		}
		
		return true;
	}

	
}
