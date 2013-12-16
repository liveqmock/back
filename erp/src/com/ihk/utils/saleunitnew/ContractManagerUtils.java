package com.ihk.utils.saleunitnew;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.ihk.constanttype.ContContractManager;
import com.ihk.property.data.pojo.ContractBarrules;
import com.ihk.utils.CommonUtils;

/**
 * 楼盘初始合同管理帮助类
 * @author dtc
 * 2012-11-14,上午11:56:23
 */
public class ContractManagerUtils {
	
	public static final String SESSION_BAR_RULE = "sessionBarRule";
	
	/**
	 * 合同类型
	 * @return
	 */
	public static Map<String, String> initSelContractType(){
		
		Map<String, String> selContractType = new LinkedHashMap<String, String>();
		
		selContractType.put(ContContractManager.CONFIRM, ContContractManager.CONFIRM_STR);
		selContractType.put(ContContractManager.CONTRACT, ContContractManager.CONTRACT_STR);
		
		return selContractType;
	}
	
	/**
	 * 回款类型
	 * @return
	 */
	public static Map<String, String> initSelRefundType(){
		
		Map<String, String> selRefundType = new LinkedHashMap<String, String>();
		
		selRefundType.put(ContContractManager.ALL_REFUND, ContContractManager.ALL_REFUND_STR);
		selRefundType.put(ContContractManager.PART_REFUND, ContContractManager.PART_REFUND_STR);
		
		return selRefundType;
	}
	
	/**
	 * 跳bar类型
	 * @return
	 */
	public static Map<String, String> initSelBarType(){
		
		Map<String, String> selBarType = new LinkedHashMap<String, String>();
		
		//selBarType.put("", CommonUtils.EMPTY);
		selBarType.put(ContContractManager.BAR_MONEY, ContContractManager.BAR_MONEY_STR);
		selBarType.put(ContContractManager.BAR_SUIT, ContContractManager.BAR_SUIT_STR);
		selBarType.put(ContContractManager.BAR_GOODS, ContContractManager.BAR_GOODS_STR);
		selBarType.put(ContContractManager.BAR_AREA, ContContractManager.BAR_AREA_STR);
		
		return selBarType;
	}
	
	/**
	 * 溢价类型
	 * @return
	 */
	public static Map<String, String> initSelPriceType(){
		
		Map<String, String> selPriceType = new LinkedHashMap<String, String>();
		
		selPriceType.put(ContContractManager.PRICE_ALL, ContContractManager.PRICE_ALL_STR);
		selPriceType.put(ContContractManager.PRICE_PART, ContContractManager.PRICE_PART_STR);
		
		return selPriceType;
		
	}
	
	/**
	 * 合同类型
	 * @return
	 */
	public static Map<String, String> initSelManagerType(){
		
		Map<String, String> selManagerType = new LinkedHashMap<String, String>();
		
		selManagerType.put(ContContractManager.MAIN_CONTRACT, ContContractManager.MAIN_CONTRACT_STR);
		selManagerType.put(ContContractManager.SECOND_LINKAGE, ContContractManager.SECOND_LINKAGE_STR);
		
		return selManagerType;
	}
	
	/**
	 * 跳bar规则中的操作符
	 * @return
	 */
	
	/**
	 * <=,<,=,>=,>
	 */
	private static Map<String, String> selAllBarOpr;
	
	/**
	 * >=,>,=
	 */
	private static Map<String, String> selBarOpr;
	/**
	 * <=,<
	 */
	private static Map<String, String> selBarOpr2;
	
	static{
		
		selBarOpr = new LinkedHashMap<String, String>();
		
		selBarOpr.put(ContContractManager.GT_EQ_VAL, ContContractManager.GT_EQ);
		selBarOpr.put(ContContractManager.GT_VAL, ContContractManager.GT);
		selBarOpr.put(ContContractManager.EQ_VAL, ContContractManager.EQ);
		//selBarOpr.put(ContContractManager.LT_VAL, ContContractManager.LT);
		//selBarOpr.put(ContContractManager.LT_EQ_VAL, ContContractManager.LT_EQ);
		
		selBarOpr2 = new LinkedHashMap<String, String>();
		
		selBarOpr2.put(ContContractManager.LT_EQ_VAL, ContContractManager.LT_EQ);
		selBarOpr2.put(ContContractManager.LT_VAL, ContContractManager.LT);
		//selBarOpr2.put(ContContractManager.EQ_VAL, ContContractManager.EQ);
		//selBarOpr2.put(ContContractManager.GT_EQ_VAL, ContContractManager.GT_EQ);
		//selBarOpr2.put(ContContractManager.GT_VAL, ContContractManager.GT);
		
		selAllBarOpr = new LinkedHashMap<String, String>();
		
		selAllBarOpr.put(ContContractManager.LT_EQ_VAL, ContContractManager.LT_EQ);
		selAllBarOpr.put(ContContractManager.LT_VAL, ContContractManager.LT);
		selAllBarOpr.put(ContContractManager.EQ_VAL, ContContractManager.EQ);
		selAllBarOpr.put(ContContractManager.GT_EQ_VAL, ContContractManager.GT_EQ);
		selAllBarOpr.put(ContContractManager.GT_VAL, ContContractManager.GT);
	}
	
	public static Map<String, String> initSelBarOpr(){
		
		return selBarOpr;
	}
	
	public static Map<String, String> initSelBarOpr2(){
		
		return selBarOpr2;
	}
	
	/**
	 * 获取bar要在页面table作为一个tr的map
	 * @param barRule
	 * @return
	 */
	public static Map<String, String> getBarRuleMap(ContractBarrules barRule){
		
		Map<String, String> retMap = new HashMap<String, String>();
		
		if(barRule != null){
			
			//retMap.put("modify", "<a href='javascript:void(0)' class='icon-cancel'></a>"); //操作
			
			retMap.put("id", barRule.getId() + ""); //页面获取的id
			retMap.put("name", "<input type='hidden' name='barRuleIds' value='" + barRule.getId() + "'/>"); //后台获取的id
			
			retMap.put("startDate", barRule.getStartDate() == null ? "" : CommonUtils.getDateString(barRule.getStartDate())); //开始时间
			retMap.put("endDate", barRule.getEndDate() == null ? "" : CommonUtils.getDateString(barRule.getEndDate())); //结束时间
			
			retMap.put(ContContractManager.RATE, selAllBarOpr.get(barRule.getOprF1()) + barRule.getDataF1() + "且" 
					+ selAllBarOpr.get(barRule.getOprB1()) + barRule.getDataB1()); //面积销售率
			
			retMap.put(ContContractManager.CONTRACT_RATE, selAllBarOpr.get(barRule.getOprF2()) + barRule.getDataF2() + "且" 
					+ selAllBarOpr.get(barRule.getOprB2()) + barRule.getDataB2()); //面积签约率
			
			retMap.put(ContContractManager.SUIT, selAllBarOpr.get(barRule.getOprF3()) + barRule.getDataF3() + "且" 
					+ selAllBarOpr.get(barRule.getOprB3()) + barRule.getDataB3()); //销售套数
			
			retMap.put(ContContractManager.MONEY, selAllBarOpr.get(barRule.getOprF4()) + barRule.getDataF4() + "且" 
					+ selAllBarOpr.get(barRule.getOprB4()) + barRule.getDataB4()); //销售金额
			
			retMap.put(ContContractManager.AREA, selAllBarOpr.get(barRule.getOprF5()) + barRule.getDataF5() + "且" 
					+ selAllBarOpr.get(barRule.getOprB5()) + barRule.getDataB5()); //销售面积
			
			retMap.put(ContContractManager.PRICE, selAllBarOpr.get(barRule.getOprF6()) + barRule.getDataF6() + "且" 
					+ selAllBarOpr.get(barRule.getOprB6()) + barRule.getDataB6()); //销售均价

			retMap.put(ContContractManager.SUIT_RATE, selAllBarOpr.get(barRule.getOprF7()) + barRule.getDataF7() + "且"
					+ selAllBarOpr.get(barRule.getOprB7()) + barRule.getDataB7()); //套数销售率

			retMap.put(ContContractManager.SUIT_CONTRACT_RATE, selAllBarOpr.get(barRule.getOprF8()) + barRule.getDataF8() + "且"
					+ selAllBarOpr.get(barRule.getOprB8()) + barRule.getDataB8()); //套数签约率

			retMap.put("commission", barRule.getCommission() == null ? "" : barRule.getCommission().toString()); //佣金点数
			
			retMap.put("memo", barRule.getMemo()); //描述
			
		}
		
		return retMap;
	}

}
