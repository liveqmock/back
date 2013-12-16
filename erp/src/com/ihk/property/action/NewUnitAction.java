package com.ihk.property.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.EnumCodeTypeName;
import com.ihk.property.data.pojo.PropertyBuild;
import com.ihk.property.data.pojo.PropertyBuildCond;
import com.ihk.property.data.pojo.PropertyProject;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.property.data.pojo.PropertyUnitCond;
import com.ihk.property.data.services.IPropertyBuildServices;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.Pager;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;
import com.opensymphony.xwork2.ActionContext;

/**
 * 1 批量生成单元
 *  需要输入楼层 1-10 ? 门号 A-B?
 * 
 * 2 调整所有选择单元的属性 除了名称
 * 
 * 
 * jsp 
 * 1 到批量生成单元界面
 * 2 调整单元属性界面
 */
public class NewUnitAction extends SupperAction{

	private static final long serialVersionUID = 1L;
	
	@Autowired IPropertyUnitServices iPropertyUnitServices;
	@Autowired IPropertyBuildServices iPropertyBuildServices;
	private String buildId; //所属栋ID
	private String unitNoPlan; //生成单元编号方案
	private String aliasNoPlan; //生成单元别名方案
	private String prefix; // 前缀
	private int startFloor;//开始层
	private int endFloor;//结束
	private int startUnit;//开始单元
	private int endUnit;//结束单元
	
	private List<PropertyBuild> buildList;
	private List<PropertyUnit> unitlist;//unit list jsp 
	private PropertyUnitCond unitcond;//unit list jsp
	
	private List<PropertyBuild> buList;
	
	@SuppressWarnings("unchecked")
	private LinkedHashMap selHouseType;
	@SuppressWarnings("unchecked")
	private LinkedHashMap selRoomType;
	@SuppressWarnings("unchecked")
	private LinkedHashMap selAreaState;
	@SuppressWarnings("unchecked")
	private LinkedHashMap selOrientation;
	@SuppressWarnings("unchecked")
	private LinkedHashMap selProductType;
	@SuppressWarnings("unchecked")
	private LinkedHashMap selMortgageState;
	@SuppressWarnings("unchecked")
	private LinkedHashMap selSaleState;
	@SuppressWarnings("unchecked")
	private LinkedHashMap selPriceWay;
	
	private LinkedHashMap selIsSample;//需要手动生成 是否样板房
	private LinkedHashMap selIsSlave;//需要手动生成 附属房产
	private LinkedHashMap selSaleType; 
	
	/**到批量新建unit单元界面*/
	public String newUnitIndex(){
		init();
		return "suc";
	}

	/**
	 * 查询unit列表  index
	 * */
	public String searchListIndex(){
		this.unitcond = new PropertyUnitCond();
		this.initlist();
		return "suc";
	}
	
	/**
	 * 查询unit列表 
	 * */
	public String searchList(){
		if(this.unitcond == null){
			this.unitcond = new PropertyUnitCond();
		}
		this.initlist();
		return "suc";
	}
	
	private void initlist(){
		 String action = CustomerUtils.getActionNameFromRequest(request);
		 Pager page = new Pager(ActionContext.getContext(), 15, action);
		 unitcond.recordCount = iPropertyUnitServices.findPropertyUnitCount(unitcond);
		
		 page.setCond(unitcond);
		 this.unitlist = iPropertyUnitServices.findPropertyUnitPage(this.unitcond);
		 this.setShowPage(page.toHtmlString());
		 
		 buildList = this.iPropertyBuildServices.findPropertyBuild(new PropertyBuildCond());
	}

	private String tip;
	public String newUnitForm(){
		this.tip = "";
		PropertyUnitCond tc = new PropertyUnitCond();
		tc.setBuildId(this.buildId);
		int t = this.iPropertyUnitServices.findPropertyUnitCount(tc);
		if(t> 0 ) {
			addActionMessage("选择的楼栋早先已初始化 ,如果想重新初始化 ,请先删除所有房间资料");
			init();
			return "suc";
		}
		try {
			if(startFloor > endFloor||startUnit > endUnit){
				addActionMessage("层数以及单元无效");
				init();
				return "suc";
			}
		} catch (Exception e) {
			addActionMessage("层数以及单元无效");
			init();
			return "suc";
		}
		
		List<PropertyUnit> Ulist = initInputList();
		for(PropertyUnit p : Ulist){
			this.iPropertyUnitServices.addPropertyUnit(p);
		}
		addActionMessage("批量录入成功");
		this.tip = "suc";
		init();
		return "suc";
	}
	
	private List<PropertyUnit> initInputList(){
		List<PropertyUnit> uList = new ArrayList<PropertyUnit>();
		
		for (int i = this.startFloor; i <= this.endFloor; i++) {
			for(int j = this.startUnit; j <= this.endUnit; j++){
				PropertyUnit p = new PropertyUnit();
				p.setUnitNo(prefix + "-" + i +"-"+ j);
				p.setAliasNo(i+""+j);
				p.setFloorNum(""+i);
				p.setRoomNo(j+"");
				p.setBuildId(Integer.parseInt(this.buildId));
				
				p.setIsDeleted("0");
				p.setCreatedId(SessionUser.getUserId());
				p.setCreatedTime(new Date());
				p.setModId(p.getCreatedId());
				p.setModTime(p.getCreatedTime());
				uList.add(p);
			}
		}
		return uList;
	}
	
	private PropertyUnit selectUnit;
	private String unitId;
	/**修改一个unit页面index
	 * @param unitId 选择的ID 必须有
	 * @param PropertyUnit selectUnit 返回的unit 
	 * */
	public String updateOneUnitIndex(){
		try {
			this.selectUnit = this.iPropertyUnitServices.findPropertyUnitById(Integer.parseInt(this.unitId));
		} catch (Exception e) {
			addActionMessage("房间信息错误");
		}
		initSel();
		return "suc";
	}
	public String updateOneUnit(){//提交页面
		PropertyUnit temp = this.iPropertyUnitServices.findPropertyUnitById(selectUnit.getId());
		selectUnit.setCreatedId(temp.getCreatedId());
		selectUnit.setCreatedTime(temp.getCreatedTime());
		selectUnit.setIsDeleted("0");
		selectUnit.setRoomNo(temp.getRoomNo());
		selectUnit.setFloorNum(temp.getFloorNum());
		selectUnit.setModId(SessionUser.getUserId());
		selectUnit.setModTime(new Date());
		selectUnit.setBuildId(temp.getBuildId());
		this.iPropertyUnitServices.updatePropertyUnit(selectUnit);
		initSel();
		return "suc";
	}
	private void init(){
		this.buList = iPropertyBuildServices .findPropertyBuild(new PropertyBuildCond());
	}
	
	
		
	private void initSel(){
			
			selHouseType = DescUtils.getInitSelForGuangZhou(selHouseType,EnumCodeTypeName.PROPERTY_HOUSE_TYPE,true);
			selRoomType = DescUtils.getInitSelForGuangZhou(selRoomType,EnumCodeTypeName.PROPERTY_ROOM_TYPE,true);
			selSaleState = DescUtils.getInitSelForGuangZhou(selSaleState,EnumCodeTypeName.PROPERTY_SALE_STATE,true);
			selPriceWay = DescUtils.getInitSelForGuangZhou(selPriceWay,EnumCodeTypeName.PROPERTY_PRICE_WAY,true);
			selAreaState = DescUtils.getInitSelForGuangZhou(selAreaState,EnumCodeTypeName.PROPERTY_AREA_STATE,true);
			selOrientation = DescUtils.getInitSelForGuangZhou(selOrientation,EnumCodeTypeName.PROPERTY_ORIENTATION,true);
			selProductType = DescUtils.getInitSelForGuangZhou(selProductType,EnumCodeTypeName.PROPERTY_PRODUCT_TYPE,true);
			selMortgageState = DescUtils.getInitSelForGuangZhou(selMortgageState,EnumCodeTypeName.PROPERTY_MORTGAGE_STATE,true);
			selSaleType = DescUtils.getInitSelForGuangZhou(selSaleType,EnumCodeTypeName.PROPERTY_SALE_TYPE,true);
			
			selIsSample = new LinkedHashMap<String, String>();
			selIsSample.put("", "请选择");
			selIsSample.put("1", "是");
			selIsSample.put("0", "否");
			selIsSlave = new LinkedHashMap<String, String>();
			selIsSlave.put("", "请选择");
			selIsSlave.put("1", "是");
			selIsSlave.put("0", "否");
	}
	/**************************************************************************************/

	public String getBuildId() {
		return buildId;
	}

	public void setBuildId(String buildId) {
		this.buildId = buildId;
	}

	public String getUnitNoPlan() {
		return unitNoPlan;
	}

	public void setUnitNoPlan(String unitNoPlan) {
		this.unitNoPlan = unitNoPlan;
	}

	public String getAliasNoPlan() {
		return aliasNoPlan;
	}

	public void setAliasNoPlan(String aliasNoPlan) {
		this.aliasNoPlan = aliasNoPlan;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public int getStartFloor() {
		return startFloor;
	}

	public void setStartFloor(int startFloor) {
		this.startFloor = startFloor;
	}

	public int getEndFloor() {
		return endFloor;
	}

	public void setEndFloor(int endFloor) {
		this.endFloor = endFloor;
	}

	public int getStartUnit() {
		return startUnit;
	}

	public void setStartUnit(int startUnit) {
		this.startUnit = startUnit;
	}

	public int getEndUnit() {
		return endUnit;
	}

	public void setEndUnit(int endUnit) {
		this.endUnit = endUnit;
	}

	public List<PropertyBuild> getBuList() {
		return buList;
	}

	public void setBuList(List<PropertyBuild> buList) {
		this.buList = buList;
	}

	public List<PropertyUnit> getUnitlist() {
		return unitlist;
	}

	public void setUnitlist(List<PropertyUnit> unitlist) {
		this.unitlist = unitlist;
	}

	public PropertyUnitCond getUnitcond() {
		return unitcond;
	}

	public void setUnitcond(PropertyUnitCond unitcond) {
		this.unitcond = unitcond;
	}

	public PropertyUnit getSelectUnit() {
		return selectUnit;
	}

	public void setSelectUnit(PropertyUnit selectUnit) {
		this.selectUnit = selectUnit;
	}

	public String getUnitId() {
		return unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	public LinkedHashMap getSelHouseType() {
		return selHouseType;
	}

	public void setSelHouseType(LinkedHashMap selHouseType) {
		this.selHouseType = selHouseType;
	}

	public LinkedHashMap getSelRoomType() {
		return selRoomType;
	}

	public void setSelRoomType(LinkedHashMap selRoomType) {
		this.selRoomType = selRoomType;
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

	public LinkedHashMap getSelSaleState() {
		return selSaleState;
	}

	public void setSelSaleState(LinkedHashMap selSaleState) {
		this.selSaleState = selSaleState;
	}

	public LinkedHashMap getSelPriceWay() {
		return selPriceWay;
	}

	public void setSelPriceWay(LinkedHashMap selPriceWay) {
		this.selPriceWay = selPriceWay;
	}

	public LinkedHashMap getSelIsSample() {
		return selIsSample;
	}

	public void setSelIsSample(LinkedHashMap selIsSample) {
		this.selIsSample = selIsSample;
	}

	public LinkedHashMap getSelIsSlave() {
		return selIsSlave;
	}

	public void setSelIsSlave(LinkedHashMap selIsSlave) {
		this.selIsSlave = selIsSlave;
	}

	public LinkedHashMap getSelSaleType() {
		return selSaleType;
	}

	public void setSelSaleType(LinkedHashMap selSaleType) {
		this.selSaleType = selSaleType;
	}

	public List<PropertyBuild> getBuildList() {
		return buildList;
	}

	public void setBuildList(List<PropertyBuild> buildList) {
		this.buildList = buildList;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	
	
}






