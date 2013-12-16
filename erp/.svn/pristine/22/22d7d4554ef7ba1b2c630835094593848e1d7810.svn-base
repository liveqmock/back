package com.ihk.test;

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
 * 选择单元action
 * @author dtc
 * 2012-9-29
 */
public class SelectUnitAction extends SupperAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired IPropertyBuildServices iPropertyBuildServices;
	@Autowired IPropertyUnitServices iPropertyUnitServices;
	@Autowired IPropertyProjectServices iPropertyProjectServices;
	
	private Map<String,PropertyUnit> unitList;
	//private List<PropertyProject> propertyList;
	//private List<PropertyBuild> builList;
	
	private String selectUid;
	private PropertyUnit selectUnit;
	private HashMap<String, Map<String,String>> saleType;
	
	private String unitNoInput;
	private String unitIdInput;
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
	
	private String showdiv_buildId;
	private String showdiv_propertyId;
	private String showdiv_propertyName;
	private String showdiv_areaId;
	
//	price_way            char(2) comment '计价方式',
//	   area_state           char(2) comment '面积状态',
//	   orientation          char(2) comment '朝向',
//	   product_type         char(2) comment '产品类型',
//	   mortgage_state       char(2) comment '抵押状态',
//	
	public String index(){
		if(showdiv_buildId == null || showdiv_buildId.equals("")){
			showdiv_buildId = "2";
		}
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
	
	/**
	 * init unitList builList
	 * 状态列表 和状态颜色
	 * */
	private void init(){
		if(this.showdiv_buildId == null || this.showdiv_buildId .equals("0")){
			tableList = new ArrayList<String>();
			unitList = new HashMap<String, PropertyUnit>();
			return ;
		}
		
		PropertyUnitCond cond = new PropertyUnitCond();
		cond.setBuildId(this.showdiv_buildId);
		
		List<PropertyUnit> temp = this.iPropertyUnitServices.findPropertyUnit(cond);
		unitList = new HashMap<String, PropertyUnit>();
		for(PropertyUnit p :temp){
			unitList.put(p.getId()+"", p);
		}
		
		
//		PropertyBuildCond bcond = new PropertyBuildCond();
//		bcond.setPropertyId("-1");
//		this.propertyList = this.iPropertyProjectServices.findPropertyProject(new PropertyProjectCond());
//		if(showdiv_propertyId != null && !showdiv_propertyId .equals("")){
//			bcond.setPropertyId(this.showdiv_propertyId.trim());
//		}else{
//			bcond.setPropertyId("-1");
//		}
//		
//		
//		this.builList =  this.iPropertyBuildServices.findPropertyBuild(bcond);
		initTable();
	}

	
	private  void initTable(){
		
		//initSaleType();//生产type信息
		//根据showdiv_buildId得到所有单元
		//根据楼层 单元号 得到每册的数据 然后写到STRING
		PropertyUnitCond cond = new PropertyUnitCond();
		cond.setBuildId(this.showdiv_buildId);
		List<PropertyUnit> ulist = iPropertyUnitServices.findPropertyUnitPage(cond);//order by floorNum
		if(ulist == null || ulist.isEmpty()){
			this.tableList = new ArrayList<String>();
			return ;
		}
		//得到所属楼栋信息
		PropertyBuild bu = this.iPropertyBuildServices.findPropertyBuildById(Integer.parseInt(this.showdiv_buildId));
		
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

	
	/**查看单个单元信息 只是查看!~*/
	public String selectUnitInformation(){
		//selectUid
		initSel();
		selectUnit = DescUtils.getUnitById(Integer.parseInt(this.selectUid));
		return "ret";
	}
	
	private String unitNo;
	public String findUid(){
		//根据单元no 返回单元ID
		//根据like 得到第一个
		int sb  = this.iPropertyUnitServices.findUnitIdByLikeUnitNo(unitNo);
		try {
			CustomerUtils.writeResponse(response, sb+"");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	public String getShowdiv_propertyId() {
		return showdiv_propertyId;
	}

	public void setShowdiv_propertyId(String showdiv_propertyId) {
		this.showdiv_propertyId = showdiv_propertyId;
	}

	public Map<String, PropertyUnit> getUnitList() {
		return unitList;
	}

	public void setUnitList(Map<String, PropertyUnit> unitList) {
		this.unitList = unitList;
	}

	public String getShowdiv_buildId() {
		return showdiv_buildId;
	}

	public void setShowdiv_buildId(String showdiv_buildId) {
		this.showdiv_buildId = showdiv_buildId;
	}

//	public List<PropertyBuild> getBuilList() {
//		return builList;
//	}
//
//	public void setBuilList(List<PropertyBuild> builList) {
//		this.builList = builList;
//	}

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

//	public List<PropertyProject> getPropertyList() {
//		return propertyList;
//	}
//
//	public void setPropertyList(List<PropertyProject> propertyList) {
//		this.propertyList = propertyList;
//	}

	public LinkedHashMap getSelHouseType() {
		return selHouseType;
	}

	public void setSelHouseType(LinkedHashMap selHouseType) {
		this.selHouseType = selHouseType;
	}


	public String getUnitNoInput() {
		return unitNoInput;
	}

	public void setUnitNoInput(String unitNoInput) {
		this.unitNoInput = unitNoInput;
	}

	public String getUnitIdInput() {
		return unitIdInput;
	}

	public void setUnitIdInput(String unitIdInput) {
		this.unitIdInput = unitIdInput;
	}

	public String getUnitNo() {
		return unitNo;
	}

	public void setUnitNo(String unitNo) {
		this.unitNo = unitNo;
	}

	public String getShowdiv_propertyName() {
		return showdiv_propertyName;
	}

	public void setShowdiv_propertyName(String showdivPropertyName) {
		showdiv_propertyName = showdivPropertyName;
	}

	public String getShowdiv_areaId() {
		return showdiv_areaId;
	}

	public void setShowdiv_areaId(String showdivAreaId) {
		showdiv_areaId = showdivAreaId;
	}

	
	
	
}
