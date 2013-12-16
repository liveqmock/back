package com.ihk.utils.saleunitnew;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.ihk.constanttype.ContConfirmType;
import com.ihk.property.data.pojo.PayWayDiscount;
import com.ihk.property.data.pojo.ProjectDiscount;
import com.ihk.property.data.pojo.PropertyBuild;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.property.data.services.IPayWayDiscountServices;
import com.ihk.property.data.services.IProjectDiscountServices;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.saleunit.data.pojo.UnitDiscount;
import com.ihk.saleunit.data.pojo.UnitDiscountDetail;
import com.ihk.saleunit.data.services.IConfirmDiscountServices;
import com.ihk.saleunit.data.services.IUnitDiscountDetailServices;
import com.ihk.saleunit.data.services.IUnitDiscountServices;
import com.ihk.utils.CommonPojoUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.saleunit.MyPropertyUtils;

/**
 * 折扣管理
 * @author dtc
 * 2012-7-4
 */
public class DiscountManagerUtils {
	
	private static IUnitDiscountServices unitDiscountServices;
	
	private static IUnitDiscountDetailServices unitDiscountDetailServices;
	
	private static IPropertyUnitServices unitServices;
	
	private static IPayWayDiscountServices payWayDiscountServices;
	
	private static IProjectDiscountServices projectDiscountServices;
	
	private static IConfirmDiscountServices confirmDiscountServices;
	
	public void setConfirmDiscountServices(
			IConfirmDiscountServices confirmDiscountServices) {
		DiscountManagerUtils.confirmDiscountServices = confirmDiscountServices;
	}
	
	public static IConfirmDiscountServices getConfirmDiscountServices() {
		return confirmDiscountServices;
	}
	
	public void setProjectDiscountServices(
			IProjectDiscountServices projectDiscountServices) {
		DiscountManagerUtils.projectDiscountServices = projectDiscountServices;
	}
	
	public static IProjectDiscountServices getProjectDiscountServices() {
		return projectDiscountServices;
	}
	
	public void setPayWayDiscountServices(
			IPayWayDiscountServices payWayDiscountServices) {
		DiscountManagerUtils.payWayDiscountServices = payWayDiscountServices;
	}
	
	public static IPayWayDiscountServices getPayWayDiscountServices() {
		return payWayDiscountServices;
	}
	
	public void setUnitServices(IPropertyUnitServices unitServices) {
		DiscountManagerUtils.unitServices = unitServices;
	}
	
	public static IPropertyUnitServices getUnitServices() {
		return unitServices;
	}
	
	public void setUnitDiscountDetailServices(
			IUnitDiscountDetailServices unitDiscountDetailServices) {
		DiscountManagerUtils.unitDiscountDetailServices = unitDiscountDetailServices;
	}
	
	public static IUnitDiscountDetailServices getUnitDiscountDetailServices() {
		return unitDiscountDetailServices;
	}
	
	public void setUnitDiscountServices(
			IUnitDiscountServices unitDiscountServices) {
		DiscountManagerUtils.unitDiscountServices = unitDiscountServices;
	}
	
	public static IUnitDiscountServices getUnitDiscountServices() {
		return unitDiscountServices;
	}
	
	/**
	 * 房间总价的计算方式computeWay
	 * (1)	先加附加再优惠减价再折 
	 *	计算方式：(标准总价+附加价-优惠减价)×折扣 
	 *	(2)	先折再附加价再优惠减价 
	 *	计算方式：标准总价×折扣+附加价-优惠减价 
	 *	(3)	先优惠减价再折再附加价 
	 *	计算方式：(标准总价-优惠减价)×折扣+附加价 
	 */
	private static Map<String, String> computeWayMap;
	
	public void setComputeWayMap(Map<String, String> computeWayMap) {
		DiscountManagerUtils.computeWayMap = computeWayMap;
	}
	
	public static Map<String, String> getComputeWayMap() {
		return computeWayMap;
	}
	
	/**
	 * 根据单元id获取折扣名称,(要重新修改)
	 * @param unitId
	 * @return
	 */
	@Deprecated
	public static String getDiscountName(int unitId){
		
		StringBuffer sb = new StringBuffer();
		
		try{
			
			PropertyUnit unit = MyPropertyUtils.getPropertyUnitServices().findPropertyUnitById(unitId);
			PropertyBuild build = MyPropertyUtils.getPropertyBuildServices().findPropertyBuildById(unit.getBuildId());
			
			sb.append(build.getBuildName()).append("_").append(unit.getUnitNo()).append("_");
			
		}catch(Exception e){
			
			sb = new StringBuffer();
			sb.append("_");
		}
		
		sb.append(CommonUtils.getNowForString());
		
		return sb.toString();
	}
	
	/**
	 * 根据折扣detail获取折扣名称,(98*97*94_2010-07-12)
	 * @param someDetail
	 * @return
	 */
	public static String getDiscountName(String someDetail){
		////typeId1=3&percent1=99&remark1=&typeId2=4&percent2=97&remark2=&detailCount=2
		
		StringBuffer sb = new StringBuffer();
		
		String[] details = someDetail.split("&");
		
		for(String detail : details){
			
			if(!CommonUtils.isStrEmpty(detail) && detail.startsWith("percent")){
				
				String[] tmp = detail.split("=");
				try{
					sb.append(tmp[1]);
				}catch (Exception e) {
				}
				sb.append("*");
			}
		}
		
		String ret = sb.toString();
		ret = CommonUtils.removeLastChar(ret);
		
		return ret + "_" + CommonUtils.getNowForString();
	}
	
	public static LinkedHashMap<Integer, String> getSelectMap(List<UnitDiscount> list){
		
		LinkedHashMap<Integer, String> retMap = new LinkedHashMap<Integer, String>();
		retMap.put(0, CommonUtils.EMPTY);
		
		for(UnitDiscount unitDis : list){
			
			retMap.put(unitDis.getId(), unitDis.getDiscountName());
		}
		
		return retMap;
	}
	
	public static String discountDetailListJson(List<UnitDiscountDetail> detailList){
		
		if(CommonUtils.isCollectionEmpty(detailList)){
			
			return "[]";
		}
		
		List<Map<String, String>> listMap = new ArrayList<Map<String,String>>();
		Map<String, String> map = null;
		
		for(UnitDiscountDetail detail : detailList){
			
			map = new HashMap<String, String>();
			
			map.put("typeId", detail.getDiscountType());
			map.put("percent", detail.getDiscountPercent().toString());
			map.put("remark", detail.getRemark());
			
			listMap.add(map);
			
		}
		
		String out = CommonUtils.getListMapJsonAnd(listMap);
		
		return out;
	}
	
	/**
	 * 获取pay_way_discount(付款方式折扣)的table map String
	 * @param payWayDiscountList
	 * @return
	 */
	public static String payWayDiscountListJson(List<PayWayDiscount> payWayDiscountList){
		
		if(CommonUtils.isCollectionEmpty(payWayDiscountList)){
			
			return "[]";
		}
		
		List<Map<String, String>> listMap = new ArrayList<Map<String,String>>();
		Map<String, String> map = null;
		
		for(PayWayDiscount detail : payWayDiscountList){
			
			map = new HashMap<String, String>();
			
			map.put("typeId", detail.getDiscountType());
			map.put("percent", detail.getDiscountPercent().toString());
			map.put("remark", detail.getRemark());
			
			listMap.add(map);
			
		}
		
		String out = CommonUtils.getListMapJsonAnd(listMap);
		
		return out;
	}
	
	/**
	 * 根据折扣id获取其显示格式(为其对应的详细折扣百分比,如98*97)
	 * @param discountId
	 * @return
	 */
	public static String getDiscountDetailShowByDiscountId(int discountId){
		
		StringBuffer sb = new StringBuffer();
		
		UnitDiscount unitDiscount = unitDiscountServices.findUnitDiscountById(discountId);
		
		try {
			
			List<UnitDiscountDetail> detailList = unitDiscountDetailServices.findDetailByDiscountId(discountId);
			
			if(!CommonUtils.isCollectionEmpty(detailList)){
				for(UnitDiscountDetail detail : detailList){
					
					sb.append(detail.getDiscountPercent()).append("*");
				}
			}else{
				
				sb.append(unitDiscount.getDiscountName());
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String ret = sb.toString();
		if(ret.endsWith("*")){
			ret = ret.substring(0, ret.length()-1);
		}
		
		//增加折扣对应的说明
		String computeWay = unitDiscount.getComputeWay();
		String wayValue = computeWayMap.get(computeWay);
		if(!CommonUtils.isStrEmpty(wayValue)){
			
			ret += wayValue;
		}
		
		return ret;
	}
	
	/**
	 * 根据单元折扣id获取项目折扣的显示名称
	 * @param unitDiscountId
	 * @return
	 */
	public static String getProjectDiscountShowByUnitDiscountId(int unitDiscountId){
		
		StringBuffer sb = new StringBuffer();
		
		UnitDiscount unitDiscount = unitDiscountServices.findUnitDiscountById(unitDiscountId);
		
		try {
			
			List<UnitDiscountDetail> detailList = unitDiscountDetailServices.findDetailByDiscountId(unitDiscountId);
			
			if(!CommonUtils.isCollectionEmpty(detailList)){
				for(UnitDiscountDetail detail : detailList){
					
					sb.append(detail.getDiscountPercent()).append("*");
				}
			}
			
			List<ProjectDiscount> proList = projectDiscountServices.findProjectDiscountByUnitDiscountId(unitDiscountId);
			
			if(!CommonUtils.isCollectionEmpty(proList)){
				for(ProjectDiscount pro : proList){
					
					sb.append(pro.getDiscountPercent()).append("*");
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			sb.delete(0, sb.length());
			sb.append(unitDiscount.getDiscountName());
		}
		
		String ret = sb.toString();
		if(ret.endsWith("*")){
			
			ret = ret.substring(0, ret.length()-1);
			
			//增加折扣对应的说明
			String computeWay = unitDiscount.getComputeWay();
			String wayValue = computeWayMap.get(computeWay);
			if(!CommonUtils.isStrEmpty(wayValue)){
				
				ret += wayValue;
			}
		}
		
		if(CommonUtils.isStrEmpty(ret)){
			ret = "查看折扣";
		}
		
		return ret;
	}
	
	/**
	 * 根据折扣id获取其显示及折扣乘积
	 * @param discountId
	 * @return
	 */
	public static Map<String, String> getDiscountDetailShowAndMultiplyByDiscountId(HttpServletRequest request){
		
		int discountId = Integer.parseInt(request.getParameter("unitDiscountId"));
		
		Map<String, String> retMap = new HashMap<String, String>();
		
		StringBuffer sb = new StringBuffer();
		BigDecimal multiply = new BigDecimal(1); //具体的折扣
		
		UnitDiscount unitDiscount = unitDiscountServices.findUnitDiscountById(discountId);
		
		try {
			
			List<UnitDiscountDetail> detailList = unitDiscountDetailServices.findDetailByDiscountId(discountId);
			
			if(!CommonUtils.isCollectionEmpty(detailList)){
				for(UnitDiscountDetail detail : detailList){
					
					sb.append(detail.getDiscountPercent()).append("*");
					multiply = multiply.multiply(detail.getDiscountPercent().divide(new BigDecimal(100)));
				}
			}else{
				
				sb.append(unitDiscount.getDiscountName());
				
			}
			
			retMap = initSumMoneyAndContractMoney(request, discountId, multiply, retMap); //设置其他的相关金额
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String detail = sb.toString();
		if(detail.endsWith("*")){
			detail = detail.substring(0, detail.length()-1);
		}
		
		//增加折扣对应的说明
		String computeWay = unitDiscount.getComputeWay();
		String wayValue = computeWayMap.get(computeWay);
		if(!CommonUtils.isStrEmpty(wayValue)){
			
			detail += wayValue;
		}
		
		retMap.put("detail", detail); //折扣显示
		retMap.put("multiply", multiply.toString()); //具体的折扣
		
		return retMap;
	}
	
	/**
	 * 根据type及mainId获取对应的折扣,如果有就返回查看的href,没有就返回新建的href
	 * @param type
	 * @param mainId
	 * @param unitId
	 * @return
	 */
	public static String getDiscountModifyHref(String type, int mainId, int unitId){
		
		StringBuffer sb = new StringBuffer();
		
		UnitDiscount discount = unitDiscountServices.findUnitDiscountByTypeAndMainId(type, mainId);
		if(discount == null){
			// <a href="#" id="addDiscountId" style="float:left;" onclick="return createDiscountDialog(${selectUnit.id})">
			//<font color="#5482DE">新增折扣</font></a>
			
			sb.append("<a href='javascript:void(0)' id='modifyDiscountId' style='float:left;' onclick='return createProjectDiscountDialog(")
				.append(unitId).append(",").append(mainId).append(",").append(type)
				.append(")'>")
				.append("<font color='#5482DE'>新增折扣</font>")
				.append("</a>")
				;
			
		}else{
			//<a href="#" id="updateDiscountId" style="float:left;" onclick="return createUpdateDiscountDialog(${unitDiscountId})">
			//<font color="#5482DE">98.00%*97.00%</font></a>
			
			int unitDiscountId = discount.getId();
			String detailShow = getProjectDiscountShowByUnitDiscountId(unitDiscountId);
			
			sb.append("<a href='javascript:void(0)' id='modifyDiscountId' style='float:left;' onclick='return createUpdateProjectDiscountDialog(")
				.append(unitDiscountId)
				.append(")'>")
				.append("<font color='#5482DE'>")
				.append(detailShow)
				.append("</font>")
				.append("</a>")
				;
			
		}
		
		return sb.toString();
	}
	
	/**
	 * 单元为签约,新建合同时,要显示的折扣href
	 * "新增折扣"functiont的type为ContConfirmType.CONTRACT
	 * @param mainId
	 * @param unitId
	 * @param unitDiscount
	 * @return
	 */
	public static String getDiscountModifyHrefForContract(int mainId, int unitId, UnitDiscount discount){
		
		StringBuffer sb = new StringBuffer();
		
		//UnitDiscount discount = getUnitDiscountByTypeAndMainId(ContConfirmType.CONFIRM, mainId);
		if(discount == null || discount.getId() == 0){
			
			sb.append("<a href='javascript:void(0)' id='modifyDiscountId' style='float:left;' onclick='return createProjectDiscountDialog(")
				.append(unitId).append(",").append(mainId).append(",").append(ContConfirmType.CONTRACT)
				.append(")'>")
				.append("<font color='#5482DE'>新增折扣</font>")
				.append("</a>")
				;
			
		}else{
			
			int unitDiscountId = discount.getId();
			String detailShow = getProjectDiscountShowByUnitDiscountId(unitDiscountId);
			
			sb.append("<a href='javascript:void(0)' id='modifyDiscountId' style='float:left;' onclick='return createUpdateProjectDiscountDialog(")
				.append(unitDiscountId)
				.append(")'>")
				.append("<font color='#5482DE'>")
				.append(detailShow)
				.append("</font>")
				.append("</a>")
				;
			
		}
		
		return sb.toString();
	}
	
	/**
	 * 根据type和mainId返回对应的单元折扣
	 * @param type
	 * @param mainId
	 * @return
	 */
	public static UnitDiscount getUnitDiscountByTypeAndMainId(String type, int mainId){
		
		UnitDiscount discount = null;
		
		try{
			
			discount = DiscountManagerUtils.getUnitDiscountServices().findUnitDiscountByTypeAndMainId(type, mainId);
			
			if(discount == null){
				discount = new UnitDiscount();
			}
			
		}catch (Exception e) {
		}
		
		return discount;
	}
	
	
	/**
	 * 设置房间总价及合同总价(合同总价=房间总价+装修总价)
	 * 房间总价的计算方式
	 *	(1)	先加附加再优惠减价再折 
	 *	计算方式：（标准总价+附加价-优惠减价）×折扣 
	 *	(2)	先折再附加价再优惠减价 
	 *	计算方式：标准总价×折扣+附加价-优惠减价 
	 *	(3)	先优惠减价再折再附加价 
	 *	计算方式：（标准总价-优惠减价）×折扣+附加价 
	 *
	 *  并设置"建筑成交单价","套内成交单价"
	 * @param discountId
	 * @param multiply, 具体的折扣
	 * @param map
	 * @return
	 */
	private static Map<String, String> initSumMoneyAndContractMoney(HttpServletRequest request, int discountId, BigDecimal multiply, Map<String, String> map){
		
		UnitDiscount unitDiscount = unitDiscountServices.findUnitDiscountById(discountId);
		
		String computeWay = unitDiscount.getComputeWay(); //折扣方式
		
		BigDecimal addSumPrice = unitDiscount.getAddSumPrice() == null ? new BigDecimal(0) : unitDiscount.getAddSumPrice(); //附加价
		BigDecimal reduceSumPrice = unitDiscount.getReduceSumPrice() == null ? new BigDecimal(0) : unitDiscount.getReduceSumPrice(); //优惠减价

		//PropertyUnit unit = unitServices.findPropertyUnitById(unitDiscount.getUnitId()); //对应的单元
		//BigDecimal sumPrice = unit.getSumPrice() == null ? new BigDecimal(0) : unit.getSumPrice(); //标准总价
		//BigDecimal buildPrice = unit.getBuildPrice() == null ? new BigDecimal(0) : unit.getBuildPrice(); //建筑单价
		//BigDecimal insidePrice = unit.getInsidePrice() == null ? new BigDecimal(0) : unit.getInsidePrice(); //套内单价
		
		//下面几个字段从页面传过来
		BigDecimal sumPrice = new BigDecimal(request.getParameter("sumPrice")); //标准总价
		BigDecimal buildArea = new BigDecimal(request.getParameter("buildArea")); //建筑面积 
		BigDecimal insideArea = new BigDecimal(request.getParameter("insideArea")); //套内面积
		
		BigDecimal sumMoney = new BigDecimal(0); //成交总价
		
		if("1".equals(computeWay)){
			
			sumMoney = (sumPrice.add(addSumPrice).subtract(reduceSumPrice)).multiply(multiply);
			
		}else if("2".equals(computeWay)){
			
			sumMoney = sumPrice.multiply(multiply).add(addSumPrice).subtract(reduceSumPrice);
			
		}else if("3".equals(computeWay)){
			
			sumMoney = (sumPrice.subtract(reduceSumPrice)).multiply(multiply).add(addSumPrice);
			
		}
		
		sumMoney = sumMoney.divide(new BigDecimal(1), 0, BigDecimal.ROUND_HALF_EVEN); //四舍五入
		
		map.put("sumMoney", sumMoney.toString()); //成交总价
		map.put("buildPrice", CommonUtils.moneyDivide(sumMoney, buildArea, 0)); //建筑成交单价=成交总价/建筑面积 
		map.put("insidePrice", CommonUtils.moneyDivide(sumMoney, insideArea, 0)); //套内成交单价=成交总价/套内面积 
		
		return map;
	}
	
	/**
	 * 根据payWayId获取具体的折扣(百分比)多选框
	 * @param payWayId
	 * @return
	 */
	public static Map<String, String> initSelPayWayDiscountByPayWayId(int payWayId){
		
		List<PayWayDiscount> list = payWayDiscountServices.findPayWayDiscountByPayWayId(payWayId);
		
		Map<String, String> map = new HashMap<String, String>();
		if(CommonUtils.isCollectionEmpty(list))
			return map;
		
		for(PayWayDiscount discount : list){
			
			String key = discount.getId() + "";
			String value = discount.getDescDiscountType() + "(" + discount.getDiscountPercent() + ")";
			
			map.put(key, value);
		}
		
		return map;
	}
	
	/**
	 * 根据projectId获取具体的折扣(百分比)多选框
	 * @param projectId
	 * @return
	 */
	@Deprecated
	public static Map<String, String> initSelProjectDiscountByProjectId(int projectId){
		
		//List<ProjectDiscount> list = projectDiscountServices.findProjectDiscountByProjectId(projectId);
		
		List<ProjectDiscount> list = new ArrayList<ProjectDiscount>();
		
		Map<String, String> map = new HashMap<String, String>();
		if(CommonUtils.isCollectionEmpty(list))
			return map;
		
		for(ProjectDiscount discount : list){
			
			String key = discount.getId() + "";
			String value = discount.getDescDiscountType() + "(" + discount.getDiscountPercent() + ")";
			
			map.put(key, value);
		}
		
		return map;
	}
	
	/**
	 * 根据payWayId获取具体的折扣(百分比)多选框
	 * @param payWayId
	 * @return
	 */
	public static Map<String, String> initSelProjectDiscountByPayWayId(int payWayId){
		
		List<ProjectDiscount> list = projectDiscountServices.findProjectDiscountByPayWayId(payWayId);
		
		Map<String, String> map = new HashMap<String, String>();
		if(CommonUtils.isCollectionEmpty(list))
			return map;
		
		for(ProjectDiscount discount : list){
			
			String key = discount.getId() + "";
			String value = discount.getDescDiscountType() + "(" + discount.getDiscountPercent() + ")";
			
			map.put(key, value);
		}
		
		return map;
	}
	
	/**
	 * 获取折扣记忆名称
	 * @param payWayDiscountIds
	 * @return
	 */
	public static String initUnitDiscountDiscountNameByPayWayDiscountIds(String[] payWayDiscountIds){
		
		StringBuffer sb = new StringBuffer();
		
		if(payWayDiscountIds != null){
			for(String payWayDiscountId : payWayDiscountIds){
				
				PayWayDiscount discount = payWayDiscountServices.findPayWayDiscountById(Integer.parseInt(payWayDiscountId));
				sb.append(discount.getDiscountPercent());
				
			}
		}
		
		String ret = sb.toString();
		ret = CommonUtils.removeLastChar(ret);
		
		return ret + "_" + CommonUtils.getNowForString();
	}
	
	/**
	 * 获取单元折扣dialog关闭要设置的值
	 * @param request
	 * @return
	 */
	public static Map<String, String> getUnitDiscountManagerCloseShowAndMultiplyByDiscountId(HttpServletRequest request){
		
		int discountId = Integer.parseInt(request.getParameter("unitDiscountId"));
		
		Map<String, String> retMap = new HashMap<String, String>();
		
		StringBuffer sb = new StringBuffer();
		BigDecimal multiply = new BigDecimal(1); //具体的折扣
		
		UnitDiscount unitDiscount = unitDiscountServices.findUnitDiscountById(discountId);
		
		try {
			
			List<PayWayDiscount> discountList = payWayDiscountServices.findPayWayDiscountByUnitDiscountId(discountId);
			
			if(!CommonUtils.isCollectionEmpty(discountList)){
				for(PayWayDiscount discount : discountList){
					
					sb.append(discount.getDiscountPercent()).append("*");
					multiply = multiply.multiply(discount.getDiscountPercent().divide(new BigDecimal(100)));
				}
			}else{
				
				sb.append(unitDiscount.getDiscountName());
				
			}
			
			retMap = initSumMoneyAndContractMoney(request, discountId, multiply, retMap); //设置其他的相关金额
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String detail = sb.toString();
		if(detail.endsWith("*")){
			detail = detail.substring(0, detail.length()-1);
		}
		
		//增加折扣对应的说明
		String computeWay = unitDiscount.getComputeWay();
		String wayValue = computeWayMap.get(computeWay);
		if(!CommonUtils.isStrEmpty(wayValue)){
			
			detail += wayValue;
		}
		
		retMap.put("detail", detail); //折扣显示
		retMap.put("multiply", multiply.toString()); //具体的折扣
		
		return retMap;
	}
	
	/**
	 * 获取project_discount(楼盘折扣)的table map String
	 * @param payWayDiscountList
	 * @return
	 */
	public static String projectDiscountListJson(List<ProjectDiscount> projectDiscountList){
		
		if(CommonUtils.isCollectionEmpty(projectDiscountList)){
			
			return "[]";
		}
		
		List<Map<String, String>> listMap = new ArrayList<Map<String,String>>();
		Map<String, String> map = null;
		
		for(ProjectDiscount detail : projectDiscountList){
			
			map = new HashMap<String, String>();
			
			map.put("typeId", detail.getDiscountType());
			map.put("percent", detail.getDiscountPercent().toString());
			map.put("remark", detail.getRemark());
			
			listMap.add(map);
			
		}
		
		String out = CommonUtils.getListMapJsonAnd(listMap);
		
		return out;
	}
	
	/**
	 * 根据请求参数及单元折扣id,获取单元折扣详细列表
	 * @param someDetail
	 * @param discountId
	 * @return
	 * @throws Exception
	 */
	public static List<UnitDiscountDetail> initForAddDiscountDetail(String someDetail, int discountId) throws Exception{
		//typeId1=3&percent1=99&remark1=&typeId2=4&percent2=97&remark2=&detailCount=2
		
		Map<String, String> map = new HashMap<String, String>();
		
		String[] details = someDetail.split("&");
		for(String detail : details){
			
			String[] tmp = detail.split("=");
			try{
				
				map.put(tmp[0], tmp[1]);
			}catch(Exception e){
				
				map.put(tmp[0], "");
			}
		}
		
		List<UnitDiscountDetail> retList = new ArrayList<UnitDiscountDetail>();
		int beanCount = Integer.parseInt(map.get("detailCount"));
		
		for(int i=1; i<=beanCount; i++){
			
			UnitDiscountDetail tmpDetail = new UnitDiscountDetail();
			
			String typeId = map.get("typeId" + i);
			String percent = map.get("percent" + i);
			String remark = map.get("remark" + i);
			
			if(CommonUtils.isStrEmpty(typeId) && CommonUtils.isStrEmpty(percent) && CommonUtils.isStrEmpty(remark))
				continue;
			
			tmpDetail.setDiscountId(discountId);
			tmpDetail.setDiscountType(typeId);
			tmpDetail.setDiscountPercent(CommonUtils.exceptionToZero(percent));
			tmpDetail.setRemark(remark);
			
			CommonPojoUtils.initPojoCommonFiled(tmpDetail);
			
			retList.add(tmpDetail);
			
		}
		
		return retList;
	}
	
	/**
	 * 根据请求参数及项目折扣id获取单元折扣名称
	 * @param someDetail
	 * @return
	 */
	public static String getDiscountNameAndProjectDiscountId(String someDetail, Integer[] projectDiscountId){
		////typeId1=3&percent1=99&remark1=&typeId2=4&percent2=97&remark2=&detailCount=2
		
		StringBuffer sb = new StringBuffer();
		
		String[] details = someDetail.split("&");
		
		for(String detail : details){
			
			if(!CommonUtils.isStrEmpty(detail) && detail.startsWith("percent")){
				
				String[] tmp = detail.split("=");
				try{
					sb.append(tmp[1]);
				}catch (Exception e) {
				}
				sb.append("*");
			}
		}
		
		if(projectDiscountId != null && projectDiscountId.length > 0){
			
			for(int proDiscountId : projectDiscountId){
				
				ProjectDiscount proDiscount = projectDiscountServices.findProjectDiscountById(proDiscountId);
				sb.append(proDiscount.getDiscountPercent().intValue()).append("*");
			}
		}
		
		String ret = sb.toString();
		ret = CommonUtils.removeLastChar(ret);
		
		return ret + "_" + CommonUtils.getNowForString();
	}
	
	/**
	 * 获取项目折扣dialog关闭要设置的值
	 * @param request
	 * @return
	 */
	public static Map<String, String> getProjectDiscountManagerCloseShowAndMultiplyByDiscountId(HttpServletRequest request){
		
		int discountId = Integer.parseInt(request.getParameter("unitDiscountId"));
		
		Map<String, String> retMap = new HashMap<String, String>();
		
		StringBuffer sb = new StringBuffer();
		BigDecimal multiply = new BigDecimal(1); //具体的折扣,为单元折扣明细(unit_discount_detail)+认购合同单的完整折扣(confirm_discount)
		
		UnitDiscount unitDiscount = unitDiscountServices.findUnitDiscountById(discountId);
		
		try {
			
			//单元折扣明细
			List<UnitDiscountDetail> detailList = unitDiscountDetailServices.findDetailByDiscountId(discountId);
			
			if(!CommonUtils.isCollectionEmpty(detailList)){
				
				for(UnitDiscountDetail detail : detailList){
					
					sb.append(detail.getDiscountPercent()).append("*");
					multiply = multiply.multiply(detail.getDiscountPercent().divide(new BigDecimal(100)));
				}
			}
			
			//认购合同单折扣
			List<ProjectDiscount> proDiscountList = projectDiscountServices.findProjectDiscountByUnitDiscountId(discountId);
			
			if(!CommonUtils.isCollectionEmpty(proDiscountList)){
				
				for(ProjectDiscount proDiscount : proDiscountList){
					
					sb.append(proDiscount.getDiscountPercent()).append("*");
					multiply = multiply.multiply(proDiscount.getDiscountPercent().divide(new BigDecimal(100)));
				}
			}
			
			if(sb.length() <= 0){
				
				sb.append(unitDiscount.getDiscountName());
			}
			
			retMap = initSumMoneyAndContractMoney(request, discountId, multiply, retMap); //设置其他的相关金额
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String detail = sb.toString();
		if(detail.endsWith("*")){
			detail = detail.substring(0, detail.length()-1);
		}
		
		//增加折扣对应的说明
		String computeWay = unitDiscount.getComputeWay();
		String wayValue = computeWayMap.get(computeWay);
		if(!CommonUtils.isStrEmpty(wayValue)){
			
			detail += wayValue;
		}
		
		retMap.put("detail", detail); //折扣显示
		retMap.put("multiply", multiply.toString()); //具体的折扣
		
		return retMap;
	}
	
	/**
	 * 根据单元折扣id获取对应的项目折扣id
	 * @param unitDiscountId
	 * @return
	 */
	public static Integer[] getProjectDiscountIdsByUnitDiscountId(int unitDiscountId){
		
		List<ProjectDiscount> changeList = projectDiscountServices.findProjectDiscountByUnitDiscountId(unitDiscountId);
		
		List<Integer> idList = new ArrayList<Integer>();
		
		if(!CommonUtils.isCollectionEmpty(changeList)){
			
			for(ProjectDiscount change : changeList){
				
				idList.add(change.getId());
			}
		}
		
		if(CommonUtils.isCollectionEmpty(idList))
			return new Integer[0];
		
		Integer[] ret = new Integer[idList.size()];
		for(int i=0; i<idList.size(); i++){
			ret[i] = idList.get(i);
		}
		
		return ret;
	}
	
}
