package com.ihk.property.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.EnumCodeTypeName;
import com.ihk.property.data.pojo.PropertyBuild;
import com.ihk.property.data.pojo.PropertyBuildCond;
import com.ihk.property.data.pojo.PropertyProject;
import com.ihk.property.data.pojo.PropertyProjectCond;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.property.data.pojo.PropertyUnitCond;
import com.ihk.property.data.services.IPropertyBuildServices;
import com.ihk.property.data.services.IPropertyProjectServices;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.SupperAction;

/**
 * 查看单元详细信息
 * */
public class ShowUnitAction extends SupperAction{

	private static final long serialVersionUID = 1L;
	@Autowired IPropertyBuildServices iPropertyBuildServices;
	@Autowired IPropertyUnitServices iPropertyUnitServices;
	@Autowired IPropertyProjectServices iPropertyProjectServices;
	private Map<String,PropertyUnit> unitList;
	private String buildId;
	private List<PropertyBuild> builList;
	private String selectUid;
	private PropertyUnit selectUnit;
	private HashMap<String, Map<String,String>> saleType;
	private List<String> tableList;
	private LinkedHashMap selHouseType;
	private LinkedHashMap selSaleState; //销售状态
	private LinkedHashMap selRoomType;//房间结构
	private LinkedHashMap selSaleType;//租售状态 
	private LinkedHashMap selPriceWay;//租售状态 
	private LinkedHashMap selAreaState;//租售状态 
	private LinkedHashMap selOrientation;//租售状态 
	private LinkedHashMap selProductType;//租售状态 
	private LinkedHashMap selMortgageState;//租售状态 
	private List<PropertyProject> proprojectList;
	private String propertyId;
	private PropertyUnitCond unitCond;
	
	public String index(){
		selectUnit = new PropertyUnit();
		init();
		initSel();
		return "suc";
	}
	
	/**查看单个unit详细信息
	 * selectUid
	 * selectUnit
	 * */
	public String showUnit(){
		this.selectUnit = this.iPropertyUnitServices.findPropertyUnitById(Integer.parseInt(this.selectUid));
		init();
		initSel();
		return "suc";
	}
	
	/**修改UNIT详细信息
	 * selectUid
	 * selectUnit
	 * */
	public String update(){
		if(selectUid == null || selectUid.trim().equals("")){
			init();
			initSel();
			return null;
		}
		
		PropertyUnit temp = new PropertyUnit();
		temp =  this.iPropertyUnitServices.findPropertyUnitById(Integer.parseInt(this.selectUid));
		temp.setSaleState(this.selectUnit.getSaleState());
		this.iPropertyUnitServices.updatePropertyUnit(temp);
		this.selectUnit = temp;
		init();
		initSel();	
		return null;
	}
	
	private String saleState;
	public String updateSaleState() {
		if(selectUid == null || selectUid.trim().equals("")){
			try {
				CustomerUtils.writeResponse(response, "选择的房间有错误");
				return null;
			} catch (IOException e) {
				return null;
			}
		}
		try {
		PropertyUnit temp = new PropertyUnit();
		temp =  this.iPropertyUnitServices.findPropertyUnitById(Integer.parseInt(this.selectUid));
		temp.setSaleState(this.saleState);
		this.iPropertyUnitServices.updatePropertyUnit(temp);
		CustomerUtils.writeResponse(response, "修改成功");
		} catch (IOException e) {
			return null;
		}
		return null;
	}
	
	/**
	 * init unitList builList
	 * 状态列表 和状态颜色
	 * */
	private void init(){
		if(unitCond == null) unitCond = (PropertyUnitCond)request.getSession().getAttribute("SessionUnitCond");
		if(unitCond == null){
			unitCond = new PropertyUnitCond();
		}else{
			request.getSession().setAttribute("SessionUnitCond", unitCond);
		}
		
		List<PropertyUnit> temp = this.iPropertyUnitServices.findPropertyUnit(unitCond);
		unitList = new HashMap<String, PropertyUnit>();
		for(PropertyUnit p :temp){
			unitList.put(p.getId()+"", p);
		}
		
		if(propertyId != null && !propertyId.trim().equals("") && !propertyId.trim().equals("0")){
			PropertyBuildCond bbcond = new PropertyBuildCond();
			bbcond.setPropertyId(this.propertyId);
			builList = this.iPropertyBuildServices.findPropertyBuild(bbcond);
		}else{
			builList = iPropertyBuildServices.findPropertyBuild(new PropertyBuildCond());
		}
		this.proprojectList = this.iPropertyProjectServices.findPropertyProject(new PropertyProjectCond());
		
		initTable();
	}

	
	private  void initTable(){
		if(this.unitCond == null )	return;
		if(this.unitCond.getBuildId() == null || this.unitCond.getBuildId().equals(""))return ;
		
		PropertyUnitCond cond = new PropertyUnitCond();
		cond.setBuildId(this.unitCond.getBuildId());
		List<PropertyUnit> ulist = iPropertyUnitServices.findPropertyUnitPage(cond);//order by floorNum
		if(ulist == null || ulist.isEmpty()){
			this.tableList = new ArrayList<String>();
			return ;
		}
		//得到所属楼栋信息
		PropertyBuild bu = this.iPropertyBuildServices.findPropertyBuildById(Integer.parseInt(this.unitCond.getBuildId()));
		
		List<List<PropertyUnit>> table = new ArrayList<List<PropertyUnit>>();
		List<PropertyUnit> ceng = new ArrayList<PropertyUnit>();
		PropertyUnit temp = new PropertyUnit();
	
		for(int i = 0; i < ulist.size();i++){
			PropertyUnit p = ulist.get(i);
			if(temp.getFloorNum() == p.getFloorNum()){
				ceng.add(p);
			}else{
				if(ceng.size() > 0 )table.add(ceng);
				ceng = new ArrayList<PropertyUnit>();
				temp  = p;
				ceng.add(p);
			}
			if(ulist.size() - 1 == i ){
				if(ceng.size() > 0 )table.add(ceng);
			}
		}
		
		this.tableList = new ArrayList<String>();
		String tr = "";
		tr = tr + "<td nowrap='nowrap' width='100px'>楼层</td><td nowrap='nowrap' colspan='"+(table.get(0).size()+1)+"'>"+bu.getBuildName()+"</td>";
		this.tableList.add(tr);
	
		for(List<PropertyUnit> li : table){
			tr = "";
			tr = tr + "<td>" + li.get(0).getFloorNum() +"</td><td><a class='flo' nowrap='nowrap' flo='"+li.get(0).getFloorNum()+"'></a></td>";
			for(PropertyUnit lii : li){
				tr = tr +"<td width='150px' class='unit' flo='"+lii.getFloorNum()+"' rom='"+lii.getRoomNo()+"' uid='"+lii.getId()+"'><div class='td"+lii.getSaleState()+"'></div><div style='float: left'>" +lii.getUnitNo() +"</div></td>";
			}
			tableList.add(tr);
		}
	}
	
	private void initSel(){
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

	
	public String getSaleState() {
		return saleState;
	}

	public void setSaleState(String saleState) {
		this.saleState = saleState;
	}

	public Map<String, PropertyUnit> getUnitList() {
		return unitList;
	}

	public void setUnitList(Map<String, PropertyUnit> unitList) {
		this.unitList = unitList;
	}

	public String getBuildId() {
		return buildId;
	}

	public void setBuildId(String buildId) {
		this.buildId = buildId;
	}

	public List<PropertyBuild> getBuilList() {
		return builList;
	}

	public void setBuilList(List<PropertyBuild> builList) {
		this.builList = builList;
	}

	public String getSelectUid() {
		return selectUid;
	}

	public void setSelectUid(String selectUid) {
		this.selectUid = selectUid;
	}

	public PropertyUnit getSelectUnit() {
		return selectUnit;
	}

	public void setSelectUnit(PropertyUnit selectUnit) {
		this.selectUnit = selectUnit;
	}

	public HashMap<String, Map<String, String>> getSaleType() {
		return saleType;
	}

	public void setSaleType(HashMap<String, Map<String, String>> saleType) {
		this.saleType = saleType;
	}

	public List<String> getTableList() {
		return tableList;
	}

	public void setTableList(List<String> tableList) {
		this.tableList = tableList;
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

	public LinkedHashMap getSelHouseType() {
		return selHouseType;
	}

	public void setSelHouseType(LinkedHashMap selHouseType) {
		this.selHouseType = selHouseType;
	}

	public String getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
	}

	public PropertyUnitCond getUnitCond() {
		return unitCond;
	}

	public void setUnitCond(PropertyUnitCond unitCond) {
		this.unitCond = unitCond;
	}

	public List<PropertyProject> getProprojectList() {
		return proprojectList;
	}

	public void setProprojectList(List<PropertyProject> proprojectList) {
		this.proprojectList = proprojectList;
	}
	
	
}
