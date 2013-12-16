package com.ihk.property.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

//import javax.mail.Session;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.EnumCodeTypeName;
import com.ihk.property.data.pojo.PropertyBuild;
import com.ihk.property.data.pojo.PropertyBuildCond;
import com.ihk.property.data.pojo.PropertyProject;
import com.ihk.property.data.pojo.PropertyProjectCond;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.property.data.pojo.PropertyUnitCond;
import com.ihk.property.data.pojo.UnitBind;
import com.ihk.property.data.pojo.UnitBindCond;
import com.ihk.property.data.services.IPropertyBuildServices;
import com.ihk.property.data.services.IPropertyProjectServices;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.property.data.services.IUnitBindServices;
import com.ihk.utils.DescUtils;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;
import com.ihk.utils.saleunit.BuildUnitUtils;
/**
 * 调整楼栋单元属性
 */
public class ResetUnitAction extends SupperAction{
	private static final long serialVersionUID = 1L;
	
	@Autowired IPropertyUnitServices iPropertyUnitServices;
	
	@Autowired IPropertyBuildServices iPropertyBuildServices;
	@Autowired IUnitBindServices iUnitBindServices;
	@Autowired IPropertyProjectServices iPropertyProjectServices;
	
	private List<PropertyUnit> unitNameList ;//显示选择的房间名
	private List<String> tableList;
	private List<PropertyProject> proprojectList;
	private String propertyId;
	
	private String buildId;//楼栋ID
	private List<PropertyBuild> buildList;
	private String ids;
	private PropertyUnit resetUnit;
	private String tip;
	private PropertyUnitCond unitCond;
	
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
	
	public String index(){
		tip="";
		this.initTable();
		initSel();
		return "suc";
	}
	
	/**ids
	 * 
	 * */
	public String resetIndex(){
		request.getSession().removeAttribute("unitNameList");
		tip="";
		 initSel();
		 if(ids == null || ids.trim().equals("")){
			 addActionMessage("没有选择房间");
		 }
		 String[] uids = ids.split(",");
		 List<Integer> idlist = new ArrayList<Integer>();
			for(String s : uids){
				idlist.add(Integer.parseInt(s));
			}
		
		PropertyUnitCond tc = new PropertyUnitCond();
		tc.setIds(idlist);
		unitNameList = this.iPropertyUnitServices.findUnitNameByIds(tc);
		request.getSession().setAttribute("unitNameList", unitNameList);
		return "suc";
	}
	
	public String reset(){
		tip="";
		String[] uids = ids.split(",");
		List<Integer> idlist = new ArrayList<Integer>();
		for(String s : uids){
			idlist.add(Integer.parseInt(s));
		}
		
		resetUnit.setModId(SessionUser.getUserId());
		resetUnit.setModTime(new Date());
//		resetUnit.setIds(idlist);
		Map<String,Object> par = new HashMap<String,Object>();
		par.put("unit", resetUnit);
		par.put("ids", idlist);
		this.iPropertyUnitServices.updateByIds(par);
		 initSel();
		 addActionMessage("修改成功!");
		return "suc";
	}
	
	public String bindUnit(){
		tip="";
		/**
		 * 需要添加的JS 如果选择的是已经绑定的单元 则同时选择绑定的组
		 * 
		 * 1 得到所选的ID 要是只有一个或者没有选 不做绑定操作
		 * 
		 * 2 如果选择多个单元  
		 * 	a.没有存在bindunid数据的话 则循环添加绑定记录
		 *  b.如果所选单元存在绑定数据 则 
		 *  		失败提示 那些是不符合要求的单元
		 *  		不符合要求: 已经绑定过的     &&  销售状态等需要统一的项不相等的
		 * 3 选择了绑定的单元之后 可以解除所有绑定
		 * 4 根据buildID删除所有绑定记录		
		 * 
		 * */
		//1 纯绑定
		String[] uids = ids.split(",");
		//如果不符合要求 
		//比如 之选一个1d 或者所选ID里面有已经绑定的记录  (专门写一个方法判断IDS里面有没有已经绑定过的记录s) 返回一个
		List<Integer> idlist = new ArrayList<Integer>();
		for(String s : uids){
			idlist.add(Integer.parseInt(s));
		}
		UnitBind bind = new UnitBind();
		bind.setCreatedId(SessionUser.getUserId());
		bind.setModId(bind.getCreatedId());
		bind.setCreatedTime(new Date());
		bind.setModTime(bind.getCreatedTime());
		bind.setIsDeleted("0");
		bind.setMainUnitId(idlist.get(0));
		idlist.remove(0);
		if(this.canBind(idlist)){
			//this.iUnitBindServices.bindUnit(idlist);
			for (int tid :idlist ) {
				bind.setSlaveUnitId(tid);
				iUnitBindServices.addUnitBind(bind);
			}
		}
		this.initTable();
		 initSel();
		//绑定 循环插入
		 tip="绑定成功";
		return "suc";
	}
	
	public String delBindUnit(){
		/**
		 * 根据传入的ids 删除所有符合条件的记录 只要有一个删除所有属于的组
		 * */
		String[] uids = ids.split(",");
	
		List<Integer> idlist = new ArrayList<Integer>();
		for(String s : uids){
			idlist.add(Integer.parseInt(s));
		}
		//this.iUnitBindServices.delUnit(idlist);
		
		return "suc";
	}
	
	public String delAllBindUnit(){
		 tip="";
		/**
		 * 根据 build id 联合查询出所有符合条件的IDS然后删除
		 * */
		if(this.unitCond.getBuildId() == null || this.unitCond.getBuildId().trim().equals("")){
			tip="楼盘没有选择,不能执行操作";
		}else{
			int t = this.iUnitBindServices.deletedByBuildId(Integer.parseInt(this.unitCond.getBuildId()));
			tip="删除了该楼栋绑定记录";
		}
		this.initTable();
		 initSel();
		return "suc";
	}
	
	private boolean canBind(List<Integer> idlist){
		boolean tip = true;//可以绑定
		//有绑定的 false 返回
		//所选的状态不同 false 返回
		
		return tip;
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
		
		selSaleType = DescUtils.getInitSelForGuangZhou(selMortgageState,EnumCodeTypeName.PROPERTY_SALE_TYPE,true);
		
		selIsSample = new LinkedHashMap<String, String>();
		selIsSample.put("", "请选择");
		selIsSample.put("1", "是");
		selIsSample.put("0", "否");
		selIsSlave = new LinkedHashMap<String, String>();
		selIsSlave.put("", "请选择");
		selIsSlave.put("1", "是");
		selIsSlave.put("0", "否");
//		PROPERTY_HOUSE_TYPE 户型
//		PROPERTY_ROOM_TYPE 房间结构
//		PROPERTY_SALE_STATE 销售状态
//		PROPERTY_PRICE_WAY 计价方式
//		PROPERTY_AREA_STATE 面积状态
//		PROPERTY_ORIENTATION 朝向
//		PROPERTY_PRODUCT_TYPE 产品类型
//		PROPERTY_MORTGAGE_STATE 抵
		
		
		if(propertyId != null && !propertyId.trim().equals("") && !propertyId.trim().equals("0")){
			PropertyBuildCond cond = new PropertyBuildCond();
			cond.setPropertyId(this.propertyId);
			buildList = this.iPropertyBuildServices.findPropertyBuild(cond);
		}else{
			buildList = iPropertyBuildServices.findPropertyBuild(new PropertyBuildCond());
		}
		this.proprojectList = this.iPropertyProjectServices.findPropertyProject(new PropertyProjectCond());
	}
	
	//初始化 楼栋单元table
	private void initTable(){
		if(this.unitCond == null ) unitCond = (PropertyUnitCond)request.getSession().getAttribute("SessionUnitCond");
		if(unitCond == null  || this.unitCond.getBuildId() == null || this.unitCond.getBuildId().equals("") || this.unitCond.getBuildId().equals("0"))return ;
		request.getSession().setAttribute("SessionUnitCond", unitCond);
		//如果只有unitCond.build id有值 帮他填上 areaId propertyid
		if(unitCond.getAreaId() == null || unitCond.getPropertyId() == null){
			unitCond.setAreaId(
					DescUtils.getBuildById(Integer.parseInt(unitCond.getBuildId()))
						.getAreaId()+""
					);
			unitCond.setPropertyId(
					DescUtils.getPropertyAreaServices().findPropertyAreaById(Integer.parseInt(unitCond.getAreaId()))
						.getPropertyId()+""
					);
		}
		
		//根据BUILDID得到所有单元
		//根据楼层 单元号 得到每册的数据 然后写到STRING
		PropertyUnitCond cond = new PropertyUnitCond();
		cond.setBuildId(this.unitCond.getBuildId()+"");
		List<PropertyUnit> ulist = iPropertyUnitServices.findPropertyUnitPage(cond);//order by floorNum
		
		
		if(ulist == null || ulist.size() ==0){
			return;
		}
//		tableList = new ArrayList<String>();
//		tableList = BuildUnitUtils.initTrAndDivTdByUnitList(ulist);
		
		
		
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
		
		tableList = new ArrayList<String>();
		String tr = "";
		tr = tr + "<td>楼层</td><td colspan='"+(table.get(0).size()+1)+"'></td>";
		tableList.add(tr);
	
		tr = "<td></td><td></td>";
		for(PropertyUnit p : table.get(0)){
			tr += "<td><a class='rom' style='color: #1199FF;' rom = '"+p.getRoomNo()+"'>房间调整</a></td>";
		}
		tableList.add(tr);
		
		for(List<PropertyUnit> li : table){
			tr = "";
			tr = tr + "<td>" + li.get(0).getFloorNum() +"</td><td><a class='flo' style='color: #1199FF;' flo='"+li.get(0).getFloorNum()+"'>楼层调整</a></td>";
			for(PropertyUnit lii : li){
				tr = tr +"<td class='unit' flo='"+lii.getFloorNum()+"' rom='"+lii.getRoomNo()+"' uid='"+lii.getId()+"'>" +lii.getUnitNo() +"</td>";
			}
			tableList.add(tr);
		}
	}
	
	
	
	public List<String> getTableList() {
		return tableList;
	}

	public void setTableList(List<String> tableList) {
		this.tableList = tableList;
	}

	public String getBuildId() {
		return buildId;
	}

	public void setBuildId(String buildId) {
		this.buildId = buildId;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public PropertyUnit getResetUnit() {
		return resetUnit;
	}

	public void setResetUnit(PropertyUnit resetUnit) {
		this.resetUnit = resetUnit;
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

	public List<PropertyUnit> getUnitNameList() {
		return unitNameList;
	}

	public void setUnitNameList(List<PropertyUnit> unitNameList) {
		this.unitNameList = unitNameList;
	}

	public List<PropertyProject> getProprojectList() {
		return proprojectList;
	}

	public void setProprojectList(List<PropertyProject> proprojectList) {
		this.proprojectList = proprojectList;
	}

	public String getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
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

	public PropertyUnitCond getUnitCond() {
		return unitCond;
	}

	public void setUnitCond(PropertyUnitCond unitCond) {
		this.unitCond = unitCond;
	}

	



	
	
	
	
}
















