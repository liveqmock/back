package com.ihk.saleunit.action.new_report.utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.ihk.constanttype.ContUnitSaleState;
import com.ihk.property.data.pojo.PropertyUnitReportCond;
import com.ihk.utils.saleunit.MyPropertyUtils;

public class SaleReportUtils {

	public static int getRGTS(PropertyUnitReportCond cond ) {// 认购套数
		if(cond == null)return 0;
		//cond.setSaleState(ContUnitSaleState.CONFIRM);
		int res = MyPropertyUtils.getPropertyUnitServices().findCountConfirm(cond);
		return res;
	}

	public static BigDecimal getRGZJ(PropertyUnitReportCond cond ) {// 认购总价
		if(cond == null)return null;
		//cond.setSaleState(ContUnitSaleState.CONFIRM);
		BigDecimal res = MyPropertyUtils.getPropertyUnitServices().findSumPriceConfirm(cond);
		return res == null ? new BigDecimal(0) : res;
	}

	public static BigDecimal getRGMJ(PropertyUnitReportCond cond ) {// 认购面积
		if(cond == null)return null;
		//cond.setSaleState(ContUnitSaleState.CONFIRM);
		BigDecimal res = MyPropertyUtils.getPropertyUnitServices().findSumBuildAreaConfirm(cond);
		return res == null ? new BigDecimal(0) : res;
	}

	public static int getQYTS(PropertyUnitReportCond cond ) {// 签约套数
		if(cond == null)return 0;
		//cond.setSaleState(ContUnitSaleState.CONTRACT);
		int res = MyPropertyUtils.getPropertyUnitServices().findCountContract(cond);
		return res;
	}

	public static BigDecimal getQYZJ(PropertyUnitReportCond cond )  {// 签约总价
		if(cond == null)return null;
		//cond.setSaleState(ContUnitSaleState.CONTRACT);
		BigDecimal res = MyPropertyUtils.getPropertyUnitServices().findSumPriceContract(cond);
		return res == null ? new BigDecimal(0) : res;
	}

	public static BigDecimal getQYMJ(PropertyUnitReportCond cond ) {// 签约面积
		if(cond == null)return null;
		//cond.setSaleState(ContUnitSaleState.CONTRACT);
		BigDecimal res = MyPropertyUtils.getPropertyUnitServices().findSumBuildAreaContract(cond);
		return res == null ? new BigDecimal(0) : res;
	}
	
	public static int getKSTS(PropertyUnitReportCond cond ) {// 剩余套数
		if(cond == null)return 0;
		List<String> ss = new ArrayList<String>();
		ss.add(ContUnitSaleState.FROZEN);
		ss.add(ContUnitSaleState.SALE_ABLE);
		int res = MyPropertyUtils.getPropertyUnitServices().findCountShengYu(cond);
		return res;
	}

	public static BigDecimal getKSZJ(PropertyUnitReportCond cond )  {// 剩余总价
		if(cond == null)return null;
		List<String> ss = new ArrayList<String>();
		ss.add(ContUnitSaleState.FROZEN);
		ss.add(ContUnitSaleState.SALE_ABLE);
		BigDecimal res = MyPropertyUtils.getPropertyUnitServices().findSumPriceShengYu(cond);
		return res == null ? new BigDecimal(0) : res;
	}

	public static BigDecimal getKSMJ(PropertyUnitReportCond cond ) {// 剩余面积
		if(cond == null)return null;
		List<String> ss = new ArrayList<String>();
		ss.add(ContUnitSaleState.FROZEN);
		ss.add(ContUnitSaleState.SALE_ABLE);
		BigDecimal res = MyPropertyUtils.getPropertyUnitServices().findSumBuildAreaShengYu(cond);
		return res == null ? new BigDecimal(0) : res;
	}
	
}
