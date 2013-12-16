package com.ihk.property.action;

import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.ContCompanyId;
import com.ihk.constanttype.EnumCodeTypeName;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.property.data.pojo.PropertyUnitCond;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.user.data.pojo.CompanyProject;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.SupperAction;

/**
 * 查找unit信息
 * */
public class PropertyAjaxAction extends SupperAction{
	private static final long serialVersionUID = 1L;
	@Autowired IPropertyUnitServices iPropertyUnitServices;
	
	public String searchUnitListByBuildId() throws Exception{
		
		StringBuffer sb = new StringBuffer();
		
		String buildId = request.getParameter("buildId");
		//name = new String(name.getBytes("ISO8859-1"), "UTF-8");
		
	//System.out.println(">>"+buildId);
		List<PropertyUnit> unitList;
		PropertyUnitCond cond =  new PropertyUnitCond();
		if(buildId != null && !buildId.trim().equals("")){
			cond.setBuildId(buildId);
		}else{
			cond.setBuildId("0");
		}
		
		unitList = iPropertyUnitServices.findPropertyUnit(cond);
		if(unitList == null || unitList.size() == 0){
			response.setCharacterEncoding("utf-8");
			PrintWriter pw = response.getWriter();
			pw.write("<em style='color:red'>没有找到数据</em>");
			pw.flush();
			pw.close();
			return null;
		}
		String floor = "-1";
		boolean tip = true;
		sb.append("<table bgcolor='#ffffff' border='1px' width='100%' id='unittable' style='border-style:solid;'  frame='box'> ");
		for(PropertyUnit p : unitList){
			//组成table<div class="td1"></div>
		//	<div style="float: left">m-11-2</div>
			if(!floor.equals(p.getFloorNum())){
				floor = p.getFloorNum();
				if(tip){
					sb.append("<tr>");
					tip = false;
				}else{
					sb.append("</tr><tr>");
				}
				sb.append("<td  uid='"+p.getId()+"'><div class='td"+p.getSaleState()+"'></div><div style='float: left'>");
				sb.append(p.getUnitNo());
				sb.append("</div></td>");
			}else{
				sb.append("<td  uid='"+p.getId()+"'><div class='td"+p.getSaleState()+"'></div><div style='float: left'>");
				sb.append(p.getUnitNo());
				sb.append("</div></td>");
			}
		}
		sb.append("</tr></table>");
		
		response.setCharacterEncoding("utf-8");
		PrintWriter pw = response.getWriter();
		pw.write(sb.toString());
		pw.flush();
		pw.close();
		return null;
	}
	
	/**
	 * 必须的条件 unit_id
	 * */
	private LinkedHashMap selHouseType;
	private LinkedHashMap selSaleState; //销售状态
	private LinkedHashMap selRoomType;//房间结构
	private LinkedHashMap selSaleType;//租售状态 
	private LinkedHashMap selPriceWay;//租售状态 
	private LinkedHashMap selAreaState;//租售状态 
	private LinkedHashMap selOrientation;//租售状态 
	private LinkedHashMap selProductType;//租售状态 
	private LinkedHashMap selMortgageState;//租售状态 
	private PropertyUnit selectUnit; 
	public String searchUnitById(){
		try {
		String unitId = request.getParameter("unitId");
		selectUnit = this.iPropertyUnitServices.findPropertyUnitById(Integer.parseInt(unitId));
		initSel();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		return "suc";
	}
	private void initSel(){
		//init 销售状态
		selSaleState = DescUtils.getInitSelForGuangZhou(selSaleState,EnumCodeTypeName.PROPERTY_SALE_STATE);
		
		selHouseType = DescUtils.getInitSelForGuangZhou(selHouseType,EnumCodeTypeName.PROPERTY_HOUSE_TYPE);
		selRoomType = DescUtils.getInitSelForGuangZhou(selRoomType,EnumCodeTypeName.PROPERTY_ROOM_TYPE);
		selSaleState = DescUtils.getInitSelForGuangZhou(selSaleState,EnumCodeTypeName.PROPERTY_SALE_STATE);
		selPriceWay = DescUtils.getInitSelForGuangZhou(selPriceWay,EnumCodeTypeName.PROPERTY_PRICE_WAY);
		selAreaState = DescUtils.getInitSelForGuangZhou(selAreaState,EnumCodeTypeName.PROPERTY_AREA_STATE);
		selOrientation = DescUtils.getInitSelForGuangZhou(selOrientation,EnumCodeTypeName.PROPERTY_ORIENTATION);
		selProductType = DescUtils.getInitSelForGuangZhou(selProductType,EnumCodeTypeName.PROPERTY_PRODUCT_TYPE);
		selMortgageState = DescUtils.getInitSelForGuangZhou(selMortgageState,EnumCodeTypeName.PROPERTY_MORTGAGE_STATE);
	}
	
	public PropertyUnit getSelectUnit() {
		return selectUnit;
	}
	public void setSelectUnit(PropertyUnit selectUnit) {
		this.selectUnit = selectUnit;
	}
	public LinkedHashMap getSelHouseType() {
		return selHouseType;
	}
	public void setSelHouseType(LinkedHashMap selHouseType) {
		this.selHouseType = selHouseType;
	}
	public LinkedHashMap getSelSaleState() {
		return selSaleState;
	}
	public void setSelSaleState(LinkedHashMap selSaleState) {
		this.selSaleState = selSaleState;
	}
	public LinkedHashMap getSelRoomType() {
		return selRoomType;
	}
	public void setSelRoomType(LinkedHashMap selRoomType) {
		this.selRoomType = selRoomType;
	}
	public LinkedHashMap getSelSaleType() {
		return selSaleType;
	}
	public void setSelSaleType(LinkedHashMap selSaleType) {
		this.selSaleType = selSaleType;
	}
	public LinkedHashMap getSelPriceWay() {
		return selPriceWay;
	}
	public void setSelPriceWay(LinkedHashMap selPriceWay) {
		this.selPriceWay = selPriceWay;
	}
	public LinkedHashMap getSelAreaState() {
		return selAreaState;
	}
	public void setSelAreaState(LinkedHashMap selAreaState) {
		this.selAreaState = selAreaState;
	}
	public LinkedHashMap getSelOrientation() {
		return selOrientation;
	}
	public void setSelOrientation(LinkedHashMap selOrientation) {
		this.selOrientation = selOrientation;
	}
	public LinkedHashMap getSelProductType() {
		return selProductType;
	}
	public void setSelProductType(LinkedHashMap selProductType) {
		this.selProductType = selProductType;
	}
	public LinkedHashMap getSelMortgageState() {
		return selMortgageState;
	}
	public void setSelMortgageState(LinkedHashMap selMortgageState) {
		this.selMortgageState = selMortgageState;
	}
	
}
