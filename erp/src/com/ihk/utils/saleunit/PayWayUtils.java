package com.ihk.utils.saleunit;

import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.ihk.property.data.pojo.PayWay;
import com.ihk.property.data.pojo.PayWayCond;
import com.ihk.property.data.pojo.PayWayDetail;
import com.ihk.property.data.pojo.PayWayDetailCond;
import com.ihk.property.data.pojo.PropertyProject;
import com.ihk.property.data.pojo.UnitPayBill;
import com.ihk.saleunit.data.pojo.Confirm;
import com.ihk.utils.CommonPojoUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.financial.FinancialUtils;

/**
 * 付款方式 > 付款方式明细  >单元付款单 >单元付款单明细
 * 操作
 * */
public class PayWayUtils {
	
	private static final String TR_LEFT = "<tr onMouseOver=\"this.style.backgroundColor='#f1f9fe'\" " +
		"onMouseOut=\"this.style.backgroundColor=''\" bgcolor=\"#FFFFFF\"	style=\"empty-cells:show\">";

	private static final String TR_RIGHT = "</tr>";
	
	private static final String TD_FIRST_LEFT = "<td id=\"t13\" style=\"width:20%\" align=\"right\">";
	
	private static final String TD_SECOND_LEFT = "<td id=\"t14\" colspan=\"3\">";
	
	private static final String TD_RIGHT = "</td>";
	
	private static final String NBSP = "&nbsp;";
	
	private static final String MONEY = "￥";
	
	/***
	 * 根据认购生成单元付款单
	 * @param c 认购单
	 * */
	public void initUnitPayBill(Confirm c){
		int unitId = c.getUnitId();
		
		int buildId = DescUtils.findPropertyBuildByUnitId(unitId).getId();
		
		String payType = "";
		PayWayCond pwc = new PayWayCond();
		pwc.setBuildId(buildId);
		pwc.setPayType(payType);
		PayWay pw = MyPropertyUtils.getPayWayServices().findPayWay(pwc).get(0);
		/**
		 * <option value="1">一次性（三个月）</option>
			<option value="2">分期付款（一年）</option>
			<option value="3">商业贷款</option>
			<option value="4">公积金贷款</option>
			<option value="5">组合贷款</option>
		 * */
		
		//TODO 根据付款方式得到付款方式明细
		PayWayDetailCond pwdc= new PayWayDetailCond();
		pwdc.setWayId(pw.getId()+"");
		List<PayWayDetail> pwdList = MyPropertyUtils.getPayWayDetailServices().findPayWayDetail(pwdc);
		
		//TODO 更具付款方式明细生成单元付款单
		for(PayWayDetail pad : pwdList){
			UnitPayBill bill = new UnitPayBill();
			this.init(bill, pad , c);
			
			try {
				CommonPojoUtils.initPojoCommonFiled(bill);
			} catch (Exception e) {
			}
			
			MyPropertyUtils.getUnitPayBillServices().addUnitPayBill(bill);
		}
	}
	
	/**
	 * 基数种类: 1 = 标准总价
	 * 
	 * 暂时只做据准总价是标准总价
	 * */
	private void init(UnitPayBill u , PayWayDetail pad ,Confirm c){
		BigDecimal sum ;
		sum = (c.getSumMoney().multiply(pad.getPayPercent().divide(new BigDecimal(100)))).add(pad.getPayMoney()); 
		u.setShouldPay(sum);
		u.setNotPay(sum);
		u.setHadPay(new BigDecimal(0));
		
		u.setWayDetailId(pad.getId());
		u.setUnitId(c.getUnitId());
	}
	
	/**
	 * 根据楼盘项目id获取对应的付款方式下拉框
	 * @param buildId
	 * @return
	 */
	public static LinkedHashMap<String, String> getSelPayWayByProjectId(int projectId){
		
		return getSelPayWayByProjectId(projectId, false);
	}
	
	/**
	 * 根据公司项目id获取对应的付款方式下拉框
	 * @param buildId
	 * @return
	 */
	public static LinkedHashMap<String, String> getSelPayWayByCompanyProjectId(int companyProjectId){
		
		return getSelPayWayByCompanyProjectId(companyProjectId, false);
	}
	
	/**
	 * 根据楼盘项目id获取对应的付款方式下拉框,是否包含有付款明细的付款方式
	 * @param projectId
	 * @param isJudgeDetail,是否判断有付款明细
	 * @return
	 */
	public static LinkedHashMap<String, String> getSelPayWayByProjectId(int projectId, boolean isJudgeDetail){
		
		PayWayCond cond = new PayWayCond();
		cond.setProjectId(projectId);
		
		List<PayWay> wayList = MyPropertyUtils.getPayWayServices().findPayWay(cond);
		
		LinkedHashMap<String, String> retMap = new LinkedHashMap<String, String>();
		retMap.put("", CommonUtils.EMPTY);
		
		if(isJudgeDetail){
			
			for(PayWay way : wayList){
				
				if(isPayWayHaveDetail(way.getId())){
					retMap.put(way.getId() + "", way.getPayName());
				}
			}
			
		}else{
			
			for(PayWay way : wayList){
				retMap.put(way.getId() + "", way.getPayName());
			}
		}
		
		return retMap;
	}
	
	
	/**
	 * 根据楼盘项目id获取对应的付款方式下拉框,是否包含有付款明细的付款方式
	 * @param projectId
	 * @param isJudgeDetail,是否判断有付款明细
	 * @return
	 */
	public static LinkedHashMap<String, String> getSelPayWayByCompanyProjectId(int companyProjectId, boolean isJudgeDetail){
		
		PayWayCond cond = new PayWayCond();
		List<PropertyProject> lpp=DescUtils.getPropertyProjectByCompanyProjectId(companyProjectId);
		for(PropertyProject pp:lpp){
			cond.setProjectId(pp.getId());
		}
		
		List<PayWay> wayList = MyPropertyUtils.getPayWayServices().findPayWay(cond);
		
		LinkedHashMap<String, String> retMap = new LinkedHashMap<String, String>();
		retMap.put("", CommonUtils.EMPTY);
		
		if(isJudgeDetail){
			
			for(PayWay way : wayList){
				
				if(isPayWayHaveDetail(way.getId())){
					retMap.put(way.getPayName(), way.getPayName());
				}
			}
			
		}else{
			
			for(PayWay way : wayList){
				retMap.put(way.getPayName(), way.getPayName());
			}
		}
		
		return retMap;
	}
	
	/**
	 * 判断付款方式是否有明细
	 * @param way
	 * @return
	 */
	public static boolean isPayWayHaveDetail(int wayId){
		
		List<PayWayDetail> detailList = MyPropertyUtils.getPayWayDetailServices().findPayWayDetailByWayId(wayId);
		
		if(CommonUtils.isCollectionEmpty(detailList)){
			
			return false;
		}
		
		return true;
	}
	
	/**
	 * 根据单元id获取对应的付款方式下拉框
	 * @param unitId
	 * @return
	 */
	public static LinkedHashMap<String, String> getSelPayWayByUnitId(int unitId){
		
		int projectId = MyPropertyUtils.getPropertyProjectServices().findPropertyProjectIdByUnitId(unitId);
		
		return getSelPayWayByProjectId(projectId);
		
	}
	
	/**
	 * 根据单元id获取具有付款明细的付款方式下拉框
	 * @param unitId
	 * @return
	 */
	public static LinkedHashMap<String, String> getSelPayWayHaveDetailByUnitId(int unitId){
		
		int projectId = MyPropertyUtils.getPropertyProjectServices().findPropertyProjectIdByUnitId(unitId);
		
		return getSelPayWayByProjectId(projectId, true);
	}
	
	/**
	 * 获取固定的按揭比例,一成,二成...
	 * @return
	 */
	public static Map<Integer, String> getSelProportion(){
		
		Map<Integer, String> map = new LinkedHashMap<Integer, String>();
		
		map.put(10, "一成");
		map.put(20, "二成");
		map.put(30, "三成");
		map.put(40, "四成");
		map.put(50, "五成");
		
		map.put(60, "六成");
		map.put(70, "七成");
		map.put(80, "八成");
		map.put(90, "九成");
		
		return map;
	}
	
	/**
	 * 判断付款明细中的fee_type是否包含按揭
	 * @param detailList
	 * @return
	 */
	public static boolean isPayWayDetailHaveMortgage(List<PayWayDetail> detailList){
		
		if(CommonUtils.isCollectionEmpty(detailList)){
			return false;
		}
		
		boolean isHave = false;
		for(PayWayDetail detail : detailList){
			
			if(FinancialUtils.MORTGAGE.equals(detail.getFeeType())){
				
				isHave = true;
				break;
			}
		}
		
		return isHave;
	}
	
	/**
	 * 根据付款方式id获取对应的中文显示
	 * @param payWayId
	 * @return
	 */
	public static String getPayWayNameById(int payWayId){
		
		if(payWayId <= 0)
			return "";
		
		PayWay payWay = MyPropertyUtils.getPayWayServices().findPayWayById(payWayId);
		
		return payWay == null ? "" : payWay.getPayName();
	}
	
	/**
	 * 根据付款方式id,返回大学小筑
	 * @param wayId
	 * @return
	 */
	public static String getDetailTrByPayWayIdForXiaoZhu(int wayId){
		
		StringBuffer sb = new StringBuffer();
		 
		try{
		
			List<PayWayDetail> detailList = MyPropertyUtils.getPayWayDetailServices().findPayWayDetailByWayId(wayId);
			
			for(PayWayDetail detail : detailList){
				
				sb.append(TR_LEFT)
					.append(TD_FIRST_LEFT).append(detail.getDetailName()).append(NBSP).append(TD_RIGHT)
					.append(TD_SECOND_LEFT).append(MONEY).append(detail.getPayMoney() == null ? "0" : detail.getPayMoney())
					.append(initPayDay(detail.getDayNum())).append(TD_RIGHT)
					.append(TR_RIGHT)
					;
				
			}
		}catch(Exception e){
		}
		
		return sb.toString();
	}
	
	//
	
	/**
	 * 初始化付款日期
	 */
	private static String initPayDay(int afterDay){
		
		String ret = "须于${day}前付清";
		
		String day = CommonUtils.getAfterDate(new Date(), afterDay);
		
		ret = ret.replace("${day}", day);
		
		return ret;
		
	}
	
}

