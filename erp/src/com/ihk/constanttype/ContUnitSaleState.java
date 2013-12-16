package com.ihk.constanttype;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
/**
 * saleState :  房间状态MAP
 * 这个类决定着单元的具体状态（数据库中的单元状态code_dtl应为辅助作用，数据库中PROPERTY_SALE_STATE应与此类同步）
 * 状态如下
	DEFAULT: "默认";
	
	FROZEN:"冻结";
	SALE_ABLE:"可售";
	RESERVE:"预留";
	CHIPS:"认筹";
	TEMP_CONFIRM:"临订";
			
	APPOINT:"预约";
	FAST_CONFIRM:"快速认购";
	CONFIRM:"认购";
	CONTRACT:"合同";
	KEEP_RECORD:"备案";
	
	IS_CHECK:"已对数";
	IS_COMMISSION:"已结佣";
	NOT_COMMISSION:"不结佣";
	DELIVERY:"已交楼";
	CERTIFICATE:"产权证";
	
	GET_CERTIFICATE:"领产权证";
	
	IS_SALE : "已售" 
	
	NOT_FOR_SALE: "不可售"
 * @author dtc
 */
public class ContUnitSaleState {
	
	/**
	 * 默认
	 */
	public final static String DEFAULT = "null"; //默认
	
	public final static String DEFAULT_STR = "默认";

	/**
	 * 冻结
	 */
	public final static String FROZEN = "1"; //冻结
	
	public final static String FROZEN_STR = "冻结";
	
	/**
	 * 可售
	 */
	public final static String SALE_ABLE = "2"; //可售
	
	public final static String SALE_ABLE_STR = "可售";
	
	/**
	 * 预留
	 */
	public final static String RESERVE = "3"; //预留
	
	public final static String RESERVE_STR = "预留"; //预留

	/**
	 * 认筹
	 */
	public final static String CHIPS = "4";
	
	public final static String CHIPS_STR = "认筹";

	/**
	 * 临订
	 */
	public final static String CONFIRM_BOOK = "5"; //临订
	
	public final static String CONFIRM_BOOK_STR = "临订"; //临订
	
	/**
	 * 预约
	 */
	public final static String APPOINT = "6"; //预约
	
	public final static String APPOINT_STR = "预约"; //预约

	/**
	 * 快速认购
	 */
	public final static String FAST_CONFIRM = "7"; //快速认购
	
	public final static String FAST_CONFIRM_STR = "快速认购"; //快速认购
	
	/**
	 * 认购,成交
	 */
	public final static String CONFIRM = "8"; //成交
	
	public final static String CONFIRM_STR = "成交"; //成交
	
	/**
	 * 合同(已签约)
	 */
	public final static String CONTRACT = "9"; //合同(已签约)
	
	public final static String CONTRACT_STR = "合同";

	/**
	 * 备案
	 */
	public final static String KEEP_RECORD = "10";
	
	public final static String KEEP_RECORD_STR = "备案";

	/**
	 * 已对数
	 */
	public final static String IS_CHECK = "11"; 
	
	public final static String IS_CHECK_STR = "已对数"; 

	/**
	 * 已结佣
	 */
	public final static String IS_COMMISSION = "12";
	
	public final static String IS_COMMISSION_STR = "已结佣";

	/**
	 * 不结佣
	 */
	public final static String NOT_COMMISSION = "13";
	
	public final static String NOT_COMMISSION_STR = "不结佣";

	/**
	 * 已交楼
	 */
	public final static String DELIVERY = "14"; //已交楼
	
	public final static String DELIVERY_STR = "已交楼"; //已交楼
	
	/**
	 * 产权证
	 */
	public final static String CERTIFICATE = "15"; //产权证
	
	public final static String CERTIFICATE_STR = "产权证"; //产权证

	/**
	 * 领产权证
	 */
	public final static String GET_CERTIFICATE = "16";
	
	public final static String GET_CERTIFICATE_STR = "领产权证";

	/**
	 * 已售
	 * */
	public final static String IS_SALE ="17";//它售 
	
	public final static String IS_SALE_STR ="他售 ";//他售 
	
	/***
	 * 不可售
	 * */
	public final static String NOT_FOR_SALE ="18";
	
	public final static String NOT_FOR_SALE_STR ="不可售";
	
	/**
	 * 挞定
	 */
	public final static String TART = "19";
	
	public final static String TART_STR = "挞定";
	
	/**
	 * 换房
	 */
	public final static String CHANGE_UNIT = "20";
	
	public final static String CHANGE_UNIT_STR = "换房";
	
	/**
	 * 退房
	 */
	public final static String CANCEL_UNIT = "21";
	
	public final static String CANCEL_UNIT_STR = "退房";
	
	/**
	 * 撤消挞定
	 */
	public final static String CANCEL_TART = "22";
	
	public final static String CANCEL_TART_STR = "撤消挞定";
	
	/**
	 * 换房
	 */
	public final static String CANCEL_CHANGE_UNIT = "23";
	
	public final static String CANCEL_CHANGE_UNIT_STR = "撤消换房";
	
	/**
	 * 退房
	 */
	public final static String CANCEL_CANCEL_UNIT = "24";
	
	public final static String CANCEL_CANCEL_UNIT_STR = "认购撤消退房";
	
	public final static String CONTRACT_CANCEL_CANCEL_UNIT = "25";
	
	public final static String CONTRACT_CANCEL_CANCEL_UNIT_STR = "合同撤消退房";
	
	
	
	/**
	 * 退房
	 */
	public final static String CHANGE_CUSTOMER = "26";
	
	public final static String CHANGE_CUSTOMER_STR = "改名";
	
	/**
	 * 撤消挞定
	 */
	public final static String CANCEL_CHANGE_CUSTOMER = "27";
	
	public final static String CANCEL_CHANGE_CUSTOMER_STR = "撤消改名";

    /**
     *成交 + 合同
     */
    public final static String CONFIRM_CONTRACT = "28";

    public final static String CONFIRM_CONTRACT_STR = "成交+合同";
    
    /**
     *修改成交
     */
    public final static String MODIFY_CONFIRM = "29";

    public final static String MODIFY_CONFIRM_STR = "修改成交";
    
    /**
     *修改成交
     */
    public final static String MODIFY_CONTRACT = "30";

    public final static String MODIFY_CONTRACT_STR = "修改合同";


    /**
	 * 所有的状态
	 */
	private static Map<String, String> saleState;
	static{
		saleState = new LinkedHashMap<String, String> ();
		
		saleState.put(DEFAULT, DEFAULT_STR);

		saleState.put(FROZEN, FROZEN_STR);
		saleState.put(SALE_ABLE, SALE_ABLE_STR);
		saleState.put(RESERVE, RESERVE_STR);
		saleState.put(CHIPS, CHIPS_STR);
		saleState.put(CONFIRM_BOOK, CONFIRM_BOOK_STR);
		
		saleState.put(APPOINT, APPOINT_STR);
		saleState.put(FAST_CONFIRM, FAST_CONFIRM_STR);
		saleState.put(CONFIRM, CONFIRM_STR);
		saleState.put(CONTRACT, CONTRACT_STR);
		saleState.put(KEEP_RECORD, KEEP_RECORD_STR);

		saleState.put(IS_CHECK, IS_CHECK_STR);
		saleState.put(IS_COMMISSION, IS_COMMISSION_STR);
		saleState.put(NOT_COMMISSION, NOT_COMMISSION_STR);
		saleState.put(DELIVERY, DELIVERY_STR);
		saleState.put(CERTIFICATE, CERTIFICATE_STR);

		saleState.put(GET_CERTIFICATE, GET_CERTIFICATE_STR);

		saleState.put(IS_SALE, IS_SALE_STR);
		saleState.put(NOT_FOR_SALE, NOT_FOR_SALE_STR);
		
		saleState.put(TART, TART_STR);
		saleState.put(CHANGE_UNIT, CHANGE_UNIT_STR);
		saleState.put(CANCEL_UNIT, CANCEL_UNIT_STR);
		
		saleState.put(CANCEL_TART, CANCEL_TART_STR);
		saleState.put(CANCEL_CHANGE_UNIT, CANCEL_CHANGE_UNIT_STR);
		saleState.put(CANCEL_CANCEL_UNIT, CANCEL_CANCEL_UNIT_STR);
		saleState.put(CONTRACT_CANCEL_CANCEL_UNIT, CONTRACT_CANCEL_CANCEL_UNIT_STR);
		saleState.put(CHANGE_CUSTOMER, CHANGE_CUSTOMER_STR);
		saleState.put(CANCEL_CHANGE_CUSTOMER, CANCEL_CHANGE_CUSTOMER_STR);
		saleState.put(MODIFY_CONFIRM, MODIFY_CONFIRM_STR);
		saleState.put(MODIFY_CONTRACT,MODIFY_CONTRACT_STR);

	}
	
	public static Map<String, String> getSaleState() {
		return saleState;
	}
	
	/**
	 * 成交状态,com.ihk.saleunit.action.contract_unit.DetailManagerAction中使用
	 * 返回"可售","成交","合同"
	 * @return
	 */
	public static Map<String, String> getContractState(){
		return getContractState(true);
	}
	
	/**
	 * @param isSaleAble,是否要"可售",默认认购
	 * @return
	 */
	public static Map<String, String> getContractState(boolean isSaleAble){
		
		Map<String, String> contractState = new LinkedHashMap<String, String>();

        contractState.put(CONTRACT, CONTRACT_STR);
        contractState.put(CONFIRM, CONFIRM_STR);

        if(isSaleAble){
            contractState.put(SALE_ABLE, SALE_ABLE_STR);
        }
		return contractState;
	}

    /**
     * 所有销售状态
     * @param isSaleAble
     * @return
     */
	public static Map<String, String> getContractStateAll(boolean isSaleAble){

		Map<String, String> contractState = new LinkedHashMap<String, String>();

        contractState.put(CONFIRM_CONTRACT, CONFIRM_CONTRACT_STR);
        contractState.put(CONTRACT, CONTRACT_STR);
        contractState.put(CONFIRM, CONFIRM_STR);

        if(isSaleAble){
            contractState.put(SALE_ABLE, SALE_ABLE_STR);
        }
		return contractState;
	}

	
	/**
	 * 对其key进行自然排序
	 * @return
	 */
	public static List<String> getSortKey(){
		
		Set<String> keys = saleState.keySet();
		
		List<String> soreKeys = new ArrayList<String>();
		
		Iterator<String> it = keys.iterator();
		while(it.hasNext()){
			soreKeys.add(it.next());
		}
		
		Collections.sort(soreKeys);
		
		return soreKeys;
	}
	
	/**
	 * 获取页面操作可能改变到的单元状态:
	 * 认筹,临定,成交,合同
	 * @return
	 */
	public static List<String> getDealUnitSale(){
		
		List<String> dealList = new ArrayList<String>();
		
		dealList.add(CHIPS);
		dealList.add(CONFIRM_BOOK);
		dealList.add(CONFIRM);
		dealList.add(CONTRACT);
		
		return dealList;
	}
	
}
