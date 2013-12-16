package com.ihk.saleunit.action.new_init;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.EnumCodeTypeName;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.property.data.pojo.PropertyUnitCond;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.saleunit.data.pojo.MakeBuildPrice;
import com.ihk.saleunit.data.pojo.MakeBuildPriceCond;
import com.ihk.saleunit.data.pojo.MakeBuildPriceDetail;
import com.ihk.saleunit.data.pojo.MakeBuildPriceDetailCond;
import com.ihk.saleunit.data.services.IMakeBuildPriceDetailServices;
import com.ihk.saleunit.data.services.IMakeBuildPriceServices;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;


/**
 * 价格管理
 * */
public class MakePriceTabAction extends SupperAction{
	@Autowired IMakeBuildPriceServices makeBuildPriceServices;
	@Autowired IMakeBuildPriceDetailServices  makeBuildPriceDetailServices;
	@Autowired IPropertyUnitServices propertyUnitServices;
	private String buildId;
	private List<MakeBuildPrice> makeList;
	
	
	
	public String makePriceTab(){
		if(buildId == null || buildId .trim().equals("")){
			return "suc";
		}
		
		MakeBuildPriceCond cond = new MakeBuildPriceCond();
		
		cond.setBuildId(buildId);
		makeList = makeBuildPriceServices.findMakeBuildPrice(cond);
		return "suc";
	}
	
	private String makeId;
	private List<MakeBuildPriceDetail> makeDeList;
	
	private List<Map<String,String>> pagMakList;
	/**
	 * @param makeId 选择的价格单据ID
	 * */
	public String showMakePriceDaDialog(){
		pagMakList = new ArrayList<Map<String,String>>();
		MakeBuildPriceDetailCond cond = new MakeBuildPriceDetailCond();
		cond.setMakeId(makeId);
		makeDeList = makeBuildPriceDetailServices.findMakeBuildPriceDetail(cond);
		MakeBuildPrice tpMake = makeBuildPriceServices.findMakeBuildPriceById(Integer.parseInt(makeId));
		List<PropertyUnit> unitList = propertyUnitServices.findPropertyUnit( new PropertyUnitCond().setBuildId(""+tpMake.getBuildId()) );
		
		for(MakeBuildPriceDetail m : makeDeList){
			PropertyUnit mu = this.findUnitById(unitList, m.getUnitId());
			if(mu == null)continue;
			Map<String ,String > ttp = new HashMap<String, String>();
			
			ttp.put("unitId", mu.getUnitNo());
			ttp.put("floor", mu.getFloorNum()+"");
			ttp.put("room", mu.getRoomNo()+"");
			
			String insideprisStr = decmentToSring( mu.getInsidePrice(),m.getInsidePrice());
			ttp.put("insidePrice", insideprisStr);
			
			String insideArea = decmentToSring( mu.getInsideArea(),m.getInsideArea());
			ttp.put("insideArea", insideArea);
			
			String buildPriceStr = decmentToSring(mu.getBuildPrice(),m.getBuildPrice());
			ttp.put("buildPrice", buildPriceStr);
			
			String buildArea = decmentToSring( mu.getBuildArea(),m.getBuildArea());
			ttp.put("buildArea", buildArea);
			
			String sumPriceStr = decmentToSring(mu.getSumPrice(),m.getSumPrice());
			ttp.put("sumPrice", sumPriceStr);	
			
			String orientation;//朝向
			orientation = StrToString(this.getOrientation(mu.getOrientation()),this.getOrientation(m.getOrientation())) ;
			ttp.put("orientation", orientation);
			
			
//			String roomType;//房间结构
//			roomType = StrToString(this.getRoomType(mu.getRoomType()),this.getRoomType(m.getRoomType()));
//			ttp.put("roomType", roomType);
			String roomNum;//房间数
			roomNum = intToString(mu.getRoomNum(),m.getRoomNum());
			ttp.put("roomNum", roomNum);
			
			String hallNum;//厅数
			hallNum = intToString(mu.getHallNum(),m.getHallNum());
			ttp.put("hallNum", hallNum);
			
			String toiletNum;//房间数
			toiletNum = intToString(mu.getToiletNum(),m.getToiletNum());
			ttp.put("toiletNum", toiletNum);
			
			String productType;//产品类型
			productType = StrToString(this.getProductType(mu.getProductType()),this.getProductType(m.getProductType())) ;
			ttp.put("productType", productType);
			
			String priceWay;//计价方式
			priceWay = StrToString(this.getPriceWay(mu.getPriceWay()),this.getPriceWay(m.getPriceWay()));
			ttp.put("priceWay", priceWay);
			
			String renovateDesc;//装修标准
			renovateDesc = StrToString(mu.getRenovateDesc(),m.getRenovateDesc());
			ttp.put("renovateDesc", renovateDesc);
			
			String renovatePrice;//装修单价
			renovatePrice = decmentToSring( mu.getRenovatePrice(),m.getRenovatePrice());
			ttp.put("renovatePrice", renovatePrice);
			
			String renovateMoney;//装修款
			renovateMoney = decmentToSring( mu.getRenovateMoney(),m.getRenovateMoney());
			ttp.put("renovateMoney", renovateMoney);
			
			String scenery;//景观
			scenery = StrToString(mu.getScenery(),m.getScenery());
			ttp.put("scenery", scenery);
			
			String remark;//备注
			remark = StrToString(mu.getRemark(),m.getRemark()) ;
			ttp.put("remark", remark);
			
			
			pagMakList.add(ttp);
		}
		return "suc";
	}
	
	
	
	
	
	private String tips;
	/**
	 * @param makeId 执行这个价格单据
	 * */
	public  String doMakePrice(){
		
		tips = "";
		if(makeId ==null || makeId.equals("") || makeId.equals("0")){
			tips = "请先选择调价单";
		}
		
		MakeBuildPrice tpmp = makeBuildPriceServices.findMakeBuildPriceById(Integer.parseInt(this.makeId));
		
		
		MakeBuildPriceDetailCond cond = new MakeBuildPriceDetailCond();
		cond.setMakeId(tpmp.getId()+"");
		List<MakeBuildPriceDetail> tplist =  makeBuildPriceDetailServices.findMakeBuildPriceDetail(cond);
		
		PropertyUnitCond ucond = new PropertyUnitCond();
		ucond.setBuildId(tpmp.getBuildId()+"");
		List<PropertyUnit> uList = propertyUnitServices.findPropertyUnit(ucond);
		String tptis = "";
		for(MakeBuildPriceDetail m :tplist){
			PropertyUnit tpunit = findUnitById(uList,m.getUnitId());
			if(tpunit == null){
				tptis += m.getUnitId();
				continue;
			}
			tpunit.setInsidePrice(m.getInsidePrice());
			tpunit.setInsideArea(m.getInsideArea());
			
			tpunit.setBuildPrice(m.getBuildPrice());
			tpunit.setBuildArea(m.getBuildArea());
			
			tpunit.setSumPrice(m.getSumPrice());
			
			tpunit.setOrientation(m.getOrientation());
			
			//tpunit.setRoomType(m.getRoomType());
			tpunit.setRoomNum(m.getRoomNum());
			tpunit.setHallNum(m.getHallNum());
			tpunit.setToiletNum(m.getToiletNum());
			
			tpunit.setProductType(m.getProductType());
			
			tpunit.setPriceWay(m.getPriceWay());
			
			tpunit.setRenovateDesc(m.getRenovateDesc());
			tpunit.setRenovateMoney(m.getRenovateMoney());
			tpunit.setRenovatePrice(m.getRenovatePrice());
			
			tpunit.setScenery(m.getScenery());
			tpunit.setRemark(m.getRemark());
			
			tpunit.setModId(SessionUser.getUserId());
			tpunit.setModTime(new Date());
			
			propertyUnitServices.updatePropertyUnit(tpunit);
		}
		tpmp.setIsEffect("1");
		tpmp.setDoUser(SessionUser.getUserId());
		tpmp.setDoTime(new Date());
		makeBuildPriceServices.updateMakeBuildPrice(tpmp);
		
		if(tptis.equals("")){
			tips = "启用成功!";
		}else{
			tips = tptis + "单元没有修改成功";
		}
		makeId = null;
		return "suc";
	}
	
	private PropertyUnit findUnitById(List<PropertyUnit> tplist,int id){
		for(PropertyUnit u :tplist){
			if(u.getId() == id){
				return u;
			}
		}
		return null;
	}
	
	private String decmentToSring(BigDecimal oldDec,BigDecimal newDec){
		if(oldDec == null)
			oldDec = new BigDecimal(0);
		if(newDec == null)
			newDec = new BigDecimal(0);
		String insideprisStr = ""; 
		int uu = oldDec.compareTo(newDec);
		
		if(oldDec.compareTo(newDec) == -1){
			insideprisStr = oldDec.toString() + ">" + "<font color=red>" + newDec.toString()+"</font>";
		}else if(oldDec.compareTo(newDec) == 1){
			insideprisStr = oldDec.toString() + ">" + "<font color=green>" + newDec.toString()+"</font>";
		}
		else if(oldDec.compareTo(newDec) == 0){
			insideprisStr = oldDec.toString() + ">" + "<font color=black>" + newDec.toString()+"</font>";
		}
		return insideprisStr;
	}
	
	private String StrToString(String str1,String str2){
		if(str1 ==null)str1="";
		if(str2 ==null)str2="";
		if(str1.equals(str2)){
			return str1 + ">" + "<font color=black>" + str2+"</font>";
		}else{
			return str1 + ">" + "<font color=red>" + str2+"</font>";
		}
		
	}
	
	private String intToString(int ia,int ib){
		if(ia > ib){
			return ia +">" + "<font color=red>" + ib+"</font>";
		}else if(ia == ib){
			return ia +">" + "<font color=black>" + ib+"</font>";
		}else{
			return ia +">" + "<font color=green>" + ib+"</font>";
		}
	}
	
	
	/**
	 * 删除选择的makeprice
	 * @param makeId 
	 * */
	public String delMakePrice() throws Exception{
		if(makeId == null || makeId.trim().equals("0"))return null;
		MakeBuildPrice tpMake = makeBuildPriceServices.findMakeBuildPriceById(Integer.parseInt(makeId));
		if(tpMake.getIsEffect().equals("1")){
			CustomerUtils.writeResponse(this.response, "已启用不能删除");
		}else{
			makeBuildPriceServices.deleteMakeBuildPrice(Integer.parseInt(makeId));
			CustomerUtils.writeResponse(this.response, "已经删除");
		}
		return null;
	}
	
	
	private LinkedHashMap selOrientation;
	private LinkedHashMap selRoomType;
	private LinkedHashMap selProductType;
	private LinkedHashMap selPriceWay;
	private String getPriceWay(String key){
		if(selPriceWay ==null)
		selPriceWay = DescUtils.getInitSelForGuangZhou(selPriceWay,EnumCodeTypeName.PROPERTY_PRICE_WAY,true);
		
		return (String) selPriceWay.get(key);
	}
	
	private String getRoomType(String key){
		if(selRoomType ==null)
		selRoomType = DescUtils.getInitSelForGuangZhou(selRoomType,EnumCodeTypeName.PROPERTY_ROOM_TYPE,true);
		return (String) selRoomType.get(key);
	}
	
	private String getProductType(String key){
		if(selProductType ==null)
		selProductType = DescUtils.getInitSelForGuangZhou(selProductType,EnumCodeTypeName.PROPERTY_PRODUCT_TYPE,true);
		return (String) selProductType.get(key);
	}
	
	private String getOrientation(String key){
		if(selOrientation ==null)
		selOrientation = DescUtils.getInitSelForGuangZhou(selOrientation, EnumCodeTypeName.PROPERTY_ORIENTATION,true);
		return (String) selOrientation.get(key);
	}
	
	public String getBuildId() {
		return buildId;
	}

	public void setBuildId(String buildId) {
		this.buildId = buildId;
	}

	public List<MakeBuildPrice> getMakeList() {
		return makeList;
	}

	public void setMakeList(List<MakeBuildPrice> makeList) {
		this.makeList = makeList;
	}

	public String getMakeId() {
		return makeId;
	}

	public void setMakeId(String makeId) {
		this.makeId = makeId;
	}

	public List<MakeBuildPriceDetail> getMakeDeList() {
		return makeDeList;
	}

	public void setMakeDeList(List<MakeBuildPriceDetail> makeDeList) {
		this.makeDeList = makeDeList;
	}

	public String getTips() {
		return tips;
	}

	public void setTips(String tips) {
		this.tips = tips;
	}

	public List<Map<String, String>> getPagMakList() {
		return pagMakList;
	}

	public void setPagMakList(List<Map<String, String>> pagMakList) {
		this.pagMakList = pagMakList;
	}
	
	
	

}
