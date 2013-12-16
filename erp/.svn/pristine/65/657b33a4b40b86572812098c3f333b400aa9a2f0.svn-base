package com.ihk.utils.chip;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import com.ihk.constanttype.ContUnitSaleState;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.saleunit.data.pojo.Chip;
import com.ihk.saleunit.data.pojo.ContractCustomer;
import com.ihk.saleunit.data.services.IChipServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.saleunit.MyPropertyUtils;
import com.ihk.utils.saleunit.UnitChangeUtils;
import com.ihk.utils.saleunitnew.UnitOperRecordUtils;

/**
 * 认筹帮助类
 * @author dtc
 * 2012-8-24
 */
public class ChipManagerUtils {
	
	/**
	 * 获取认筹客户的json
	 * @param customer
	 * @return
	 */
	public static Map<String, String> getAjaxChipCustomerMap(ContractCustomer customer){
		
		List<String> fields = new ArrayList<String>();
		
		fields.add("id");
		fields.add("customerName");
		fields.add("phone");
		
		fields.add("gender");
		fields.add("idcardType");
		fields.add("idcardNo");
		
		fields.add("address");
		
		Map<String, String> map = CommonUtils.getPojoMap(customer, fields);
		
		return map;
	}
	
	/**
	 * 判断该单元是否为认筹单元
	 * @param unit
	 * @return
	 */
	public static boolean isUnitChip(PropertyUnit unit){
		
		if(unit.getChip1() > 0 || unit.getChip2() > 0 || unit.getChip3() > 0 || unit.getChipA() > 0 || unit.getChipB() > 0)
			
			return true;
		
		return false;
	}
	
	/**
	 * 返回该单元的认筹class标示,可认筹(2),已认筹(8),不能认筹(9)
	 * @param unit
	 * @return
	 */
	public static int getUnitChipClassNo(PropertyUnit unit){
		
		if(unit.getChip1() >= 3 && unit.getChip2() >= 2 && unit.getChip3() >= 1)
			
			return 16;
		
		if(isUnitChip(unit))
			
			return 4;
		
		return 2;
	}
	
	/**
	 * 获取单元的认筹显示,(可认筹:2102(0,0,0);已认筹(2,1,0);不能认筹:2102(3,2,1);)
	 * @param unit
	 * @return
	 */
	public static String getUnitChipShow(PropertyUnit unit){
		
		StringBuffer sb = new StringBuffer();
		
		sb.append(unit.getUnitNo()).append("(").append(unit.getChip1()).append(",")
			.append(unit.getChip2()).append(",").append(unit.getChip3()).append(")");
		
		return sb.toString();
	}
	
	/**
	 * 新增认筹,设置认筹号
	 * @param chip
	 */
	public static void setChipNoForAdd(Chip chip, IChipServices chipServices){
		
		Chip maxNoChip = chipServices.findMaxNoChip();
		String maxChipNo = "0";
		
		if(maxNoChip != null){
			
			maxChipNo = maxNoChip.getChipNo();
			
		}
		
		chip.setChipNo(getIncrementChipNoByMaxChipNo(maxChipNo));
		
	}
	
	/**
	 * 根据最大的认筹号,自增1,并设成6位(如:000001,000002)
	 * @param maxChipNo
	 * @return
	 */
	public static String getIncrementChipNoByMaxChipNo(String maxChipNo){
		
		int maxNo = 0;
		try{
			maxNo = Integer.parseInt(maxChipNo);
		}catch(Exception e){
		}
		
		AtomicInteger atomic = new AtomicInteger(maxNo);
		
		String retStr = "000000" + atomic.incrementAndGet();
		
		return retStr.substring(retStr.length()-6, retStr.length());
	}
	
	/**
	 * 判断该项目下该筹单号是否合法
	 * @param chip
	 * @return
	 */
	public static boolean isChipNoAccord(Chip chip){
		
		if(chip == null || CommonUtils.isStrEmpty(chip.getChipNo())){
			
			return false;
		}
		
		try{
			
			int propertyProjectId = MyPropertyUtils.getPropertyProjectServices().findPropertyProjectIdByUnitId(chip.getUnitId1());
			
			List<Chip> chipList = MyPropertyUtils.getChipServices().findChipByPropertyProjectId(propertyProjectId);
			
			if(CommonUtils.isCollectionEmpty(chipList))
				return true;

			boolean ret = true;
			
			String chipNo = chip.getChipNo();
			for(Chip tmp : chipList){
				
				if(chipNo.equals(tmp.getChipNo())){
					
					ret = false;
					break;
				}
			}
			
			return ret;
		}catch (Exception e) {
			
			return false;
		}
		
	}
	
	/**
	 * 设置认筹单元的状态map
	 * @param unitId
	 * @return
	 */
	private static Map<String, String> initUnitSaleStateForChipById(int unitId){
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("id", unitId + "");
		map.put("saleState", ContUnitSaleState.CHIPS);
		
		return map;
	}
	
	/**
	 * 设置可售单元的状态map
	 * @param unitId
	 * @return
	 */
	public static Map<String, String> initUnitSaleStateForSaleById(int unitId){
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("id", unitId + "");
		map.put("saleState", ContUnitSaleState.SALE_ABLE);
		
		return map;
	}
	
	/**
	 * 根据chip设置单元对应的chip_1,chip_2...并修改对应的单元及单元状态
	 * @param chip
	 * @throws Exception
	 */
	public static void setUnitChipByChip(Chip chip) throws Exception{
		
		IPropertyUnitServices unitServices = MyPropertyUtils.getPropertyUnitServices();
		
		int unitId1 = chip.getUnitId1();
		if(unitId1 > 0){
			
			PropertyUnit unit1 = unitServices.findPropertyUnitById(unitId1);
			
			int chip1 = unit1.getChip1();
			
			if(chip1 >= 3)
				throw new Exception("第一意向不能超过三个");
			
			if(!UnitChangeUtils.isFourSaleStateCanChange(unit1.getSaleState(), ContUnitSaleState.CHIPS)){
				throw new Exception("非可售单元不能认筹");
			}
			unitServices.updatePropertyUnitChipByUnitIdAndChipTypeWithCountNo(unitId1, 1, ++chip1);
			
			unitServices.updatePropertyUnitSaleState(initUnitSaleStateForChipById(unitId1));
			

		}
		
		int unitId2 = chip.getUnitId2();
		if(unitId2 > 0){
			
			PropertyUnit unit2 = unitServices.findPropertyUnitById(unitId2);
			
			int chip2 = unit2.getChip2();
			
			if(chip2 >= 2)
				throw new Exception("第二意向不能超过二个");
			if(!UnitChangeUtils.isFourSaleStateCanChange(unit2.getSaleState(), ContUnitSaleState.CHIPS)){
				throw new Exception("非可售单元不能认筹");
			}
			unitServices.updatePropertyUnitChipByUnitIdAndChipTypeWithCountNo(unitId2, 2, ++chip2);
			
			unitServices.updatePropertyUnitSaleState(initUnitSaleStateForChipById(unitId2));
		}
		
		int unitId3 = chip.getUnitId3();
		if(unitId3 > 0){
			
			PropertyUnit unit3 = unitServices.findPropertyUnitById(unitId3);
			
			int chip3 = unit3.getChip3();
			
			if(chip3 >= 1)
				throw new Exception("第三意向不能超过一个");
			if(!UnitChangeUtils.isFourSaleStateCanChange(unit3.getSaleState(), ContUnitSaleState.CHIPS)){
				throw new Exception("非可售单元不能认筹");
			}
			unitServices.updatePropertyUnitChipByUnitIdAndChipTypeWithCountNo(unitId3, 3, ++chip3);
			
			unitServices.updatePropertyUnitSaleState(initUnitSaleStateForChipById(unitId3));
		}
		
	}
	
	/**
	 * 根据chip设置单元对应的chip_1,chip_2...并修改对应的单元及单元状态(修改筹单时用，需要取原来筹单比较)
	 * @param chip
	 * @throws Exception
	 */
	public static void setUnitChipByChipForModify(Chip srcChip,Chip chip) throws Exception{
		
		IPropertyUnitServices unitServices = MyPropertyUtils.getPropertyUnitServices();
		
		int unitId1 = chip.getUnitId1();
		
		if(unitId1 > 0){
			
			PropertyUnit unit1 = unitServices.findPropertyUnitById(unitId1);
			
			int chip1 = unit1.getChip1();
			
			if(chip1 >= 3 && srcChip.getUnitId1()!=chip.getUnitId1())
				throw new Exception("第一意向不能超过三个");
			
			if(!UnitChangeUtils.isFourSaleStateCanChange(unit1.getSaleState(), ContUnitSaleState.CHIPS)){
				throw new Exception("非可售单元不能认筹");
			}
			unitServices.updatePropertyUnitChipByUnitIdAndChipTypeWithCountNo(unitId1, 1, ++chip1);
			
			unitServices.updatePropertyUnitSaleState(initUnitSaleStateForChipById(unitId1));
			

		}
		
		int srcUnitId1 = srcChip.getUnitId1();
		
		if(srcUnitId1 > 0){
			
			if(srcUnitId1 > 0){
				PropertyUnit srcUnit1 = unitServices.findPropertyUnitById(srcUnitId1);
				int srcChip1 = srcUnit1.getChip1();
				if(srcUnit1 != null && srcChip1 > 0){
					unitServices.updatePropertyUnitChipByUnitIdAndChipTypeWithCountNo(srcUnitId1, 1, --srcChip1);
					UnitChangeUtils.setSaleAble(srcUnitId1,srcChip1);
				}
			}
			

		}
		
		int unitId2 = chip.getUnitId2();
		if(unitId2 > 0){
			
			PropertyUnit unit2 = unitServices.findPropertyUnitById(unitId2);
			
			int chip2 = unit2.getChip2();
			
			if(chip2 >= 2 && srcChip.getUnitId2()!=chip.getUnitId2())
				throw new Exception("第二意向不能超过二个");
			if(!UnitChangeUtils.isFourSaleStateCanChange(unit2.getSaleState(), ContUnitSaleState.CHIPS)){
				throw new Exception("非可售单元不能认筹");
			}
			unitServices.updatePropertyUnitChipByUnitIdAndChipTypeWithCountNo(unitId2, 2, ++chip2);
			
			unitServices.updatePropertyUnitSaleState(initUnitSaleStateForChipById(unitId2));
		}
		
		int srcUnitId2 = srcChip.getUnitId2();
		
		if(srcUnitId2 > 0){

			if(srcUnitId2 > 0){
				PropertyUnit srcUnit2 = unitServices.findPropertyUnitById(srcUnitId2);
				int srcChip2 = srcUnit2.getChip2();
				if(srcUnit2 != null && srcChip2 > 0){
					unitServices.updatePropertyUnitChipByUnitIdAndChipTypeWithCountNo(srcUnitId2, 2, --srcChip2);
					UnitChangeUtils.setSaleAble(srcUnitId2,srcChip2);
				}
			}
			

		}
		
		int unitId3 = chip.getUnitId3();
		if(unitId3 > 0){
			
			PropertyUnit unit3 = unitServices.findPropertyUnitById(unitId3);
			
			int chip3 = unit3.getChip3();
			
			if(chip3 >= 1&& srcChip.getUnitId3()!=chip.getUnitId3())
				throw new Exception("第三意向不能超过一个");
			if(!UnitChangeUtils.isFourSaleStateCanChange(unit3.getSaleState(), ContUnitSaleState.CHIPS)){
				throw new Exception("非可售单元不能认筹");
			}
			unitServices.updatePropertyUnitChipByUnitIdAndChipTypeWithCountNo(unitId3, 3, ++chip3);
			
			unitServices.updatePropertyUnitSaleState(initUnitSaleStateForChipById(unitId3));
		}
		
		int srcUnitId3 = srcChip.getUnitId3();
		
		if(srcUnitId3 > 0){

			if(srcUnitId3 > 0){
				PropertyUnit srcUnit3 = unitServices.findPropertyUnitById(srcUnitId3);
				int srcChip3 = srcUnit3.getChip3();
				if(srcUnit3 != null && srcChip3 > 0){
					unitServices.updatePropertyUnitChipByUnitIdAndChipTypeWithCountNo(srcUnitId3, 3, --srcChip3);
					UnitChangeUtils.setSaleAble(srcUnitId1,srcChip3);
				}
			}
			

		}
		
	}
	
	
	
	/**
	 * 修改认筹的时候,根据新旧chip判断设置对应的单元(好像考虑的不是很周全)
	 * @param oldChip
	 * @param newChip
	 * @throws Exception
	 */
	@Deprecated
	public static void setUnitChipByChip(Chip oldChip, Chip newChip) throws Exception{
			
		IPropertyUnitServices unitServices = MyPropertyUtils.getPropertyUnitServices();
		
		int unitId1 = newChip.getUnitId1();
		int oldUnitId1 = oldChip.getUnitId1();
		if(unitId1 > 0 && unitId1 != oldUnitId1){
			
			PropertyUnit unit1 = unitServices.findPropertyUnitById(unitId1);
			
			int chip1 = unit1.getChip1();
			
			if(chip1 >= 3)
				throw new Exception("第一意向不能超过三个");
			
			//新的认筹对应的第一意向的单元chip1增加1
			unitServices.updatePropertyUnitChipByUnitIdAndChipTypeWithCountNo(unitId1, 1, ++chip1);
			
		}
		if(oldUnitId1 > 0){
			
			//旧的认筹对应的第一意向的单元chip1减去1
			PropertyUnit oldUnit1 = unitServices.findPropertyUnitById(oldUnitId1);
			int oldChip1 = oldUnit1.getChip1();
			if(oldChip1 > 0){
				unitServices.updatePropertyUnitChipByUnitIdAndChipTypeWithCountNo(oldUnitId1, 1, --oldChip1);
			}
			
		}
		
		int unitId2 = newChip.getUnitId2();
		int oldUnitId2 = oldChip.getUnitId2();
		if(unitId2 > 0 && unitId2 != oldUnitId2){
			
			PropertyUnit unit2 = unitServices.findPropertyUnitById(unitId2);
			
			int chip2 = unit2.getChip2();
			
			if(chip2 >= 2)
				throw new Exception("第二意向不能超过二个");
			
			unitServices.updatePropertyUnitChipByUnitIdAndChipTypeWithCountNo(unitId2, 2, ++chip2);
			
		}
		if(oldUnitId2 > 0){
			
			PropertyUnit oldUnit2 = unitServices.findPropertyUnitById(oldUnitId2);
			int oldChip2 = oldUnit2.getChip2();
			if(oldChip2 > 0){
				unitServices.updatePropertyUnitChipByUnitIdAndChipTypeWithCountNo(oldUnitId2, 2, --oldChip2);
			}
		}
		
		int unitId3 = newChip.getUnitId3();
		int oldUnitId3 = oldChip.getUnitId3();
		if(unitId3 > 0 && unitId3 != oldUnitId3){
			
			PropertyUnit unit3 = unitServices.findPropertyUnitById(unitId3);
			
			int chip3 = unit3.getChip3();
			
			if(chip3 >= 1)
				throw new Exception("第三意向不能超过一个");
			
			unitServices.updatePropertyUnitChipByUnitIdAndChipTypeWithCountNo(unitId3, 3, ++chip3);
			
		}
		if(oldUnitId3 > 0){
			
			PropertyUnit oldUnit3 = unitServices.findPropertyUnitById(oldUnitId3);
			int oldChip3 = oldUnit3.getChip3();
			if(oldChip3 > 0){
				unitServices.updatePropertyUnitChipByUnitIdAndChipTypeWithCountNo(oldUnitId3, 3, --oldChip3);
			}
		}
		
	}

	/**
	 * 获取json数据
	 * prefix:是前缀
	 */
	public static String getAjaxJson_Chip(Chip chip,String prefix){
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put(prefix+"id", String.valueOf(chip.getId()));
		map.put(prefix+"chipNo", chip.getChipNo());
		map.put(prefix+"customer.customerName", chip.getCustomer().getCustomerName());
		map.put(prefix+"customer.phone", chip.getCustomer().getPhone());
		map.put(prefix+"customer.gender", chip.getCustomer().getGender());
		map.put(prefix+"customer.idcardType", chip.getCustomer().getIdcardType());
		map.put(prefix+"customer.idcardNo", chip.getCustomer().getIdcardNo());
		map.put(prefix+"customer.address", chip.getCustomer().getAddress());

		map.put(prefix+"unitId1", String.valueOf(chip.getUnitId1()));
		if(chip.getUnitId1()>0){
			
			PropertyUnit unit1 = chip.getUnit1();
			map.put(prefix+"unit1.allName", unit1.getAllName());
			
			//设置第一意向的build id, editChip.buildId
			map.put(prefix + "buildId", unit1.getBuildId() + "");
			
		}
		map.put(prefix+"unitId2", String.valueOf(chip.getUnitId2()));
		if(chip.getUnitId2()>0){
			map.put(prefix+"unit2.allName", chip.getUnit2().getAllName());
		}
		map.put(prefix+"unitId3", String.valueOf(chip.getUnitId3()));
		if(chip.getUnitId3()>0){
			map.put(prefix+"unit3.allName", chip.getUnit3().getAllName());
		}
		
		//设置录入人员id和名称, userName
		map.put(prefix + "userId", chip.getUserId() + "");
		map.put(prefix + "userName", DescUtils.getUserRealName(chip.getUserId()));
		
		//销售人员
		map.put(prefix + "salesName", chip.getSalesName());
		map.put(prefix + "salesId", chip.getSalesId());
		
		return CommonUtils.getMapJson(map);
	}
	
	/**
	 * 获取对应单元的认筹客户,如 第一意向:小姐李(134511231),先生邓(13451212),莫生(12312312312);第二意向:...
	 * @param unit
	 * @return
	 */
	public static String getChipCustomerByUnit(PropertyUnit unit){
		
		return null;
	}
	
	/**
	 * 增加认筹单元的操作记录
	 * @param chip
	 */
	public static void addChipUnitOperRecord(Chip chip){
		
		if(chip == null)
			return ;
		
		int unitId1 = chip.getUnitId1();
		if(unitId1 > 0){
			UnitOperRecordUtils.addOperRecord(unitId1, ContUnitSaleState.CHIPS, chip.getId());
		}
		
		int unitId2 = chip.getUnitId2();
		if(unitId2 > 0){
			UnitOperRecordUtils.addOperRecord(unitId2, ContUnitSaleState.CHIPS, chip.getId());
		}
		
		int unitId3 = chip.getUnitId3();
		if(unitId3 > 0){
			UnitOperRecordUtils.addOperRecord(unitId3, ContUnitSaleState.CHIPS, chip.getId());
		}
		
		int unitId4 = chip.getUnitId4();
		if(unitId4 > 0){
			UnitOperRecordUtils.addOperRecord(unitId4, ContUnitSaleState.CHIPS, chip.getId());
		}
		
		int unitId5 = chip.getUnitId5();
		if(unitId5 > 0){
			UnitOperRecordUtils.addOperRecord(unitId5, ContUnitSaleState.CHIPS, chip.getId());
		}
		
	}

}
