package com.ihk.saleunit.action.new_;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.permission.PermissionUtils;
import com.ihk.property.data.pojo.PropertyArea;
import com.ihk.property.data.pojo.PropertyAreaCond;
import com.ihk.property.data.pojo.PropertyBuild;
import com.ihk.property.data.pojo.PropertyBuildCond;
import com.ihk.property.data.pojo.PropertyProject;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.property.data.pojo.PropertyUnitCond;
import com.ihk.property.data.services.IPropertyAreaServices;
import com.ihk.property.data.services.IPropertyBuildServices;
import com.ihk.property.data.services.IPropertyGroupServices;
import com.ihk.property.data.services.IPropertyProjectServices;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.user.data.pojo.CompanyProject;
import com.ihk.user.data.pojo.UserRole;
import com.ihk.user.data.services.ICompanyProjectServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;
import com.ihk.utils.left.OrderTreeBean;
import com.ihk.utils.left.OrderTreeBeanListCacheUtils;
import com.ihk.utils.left.OrderTreeComparatorBean;
import com.ihk.utils.saleunit.BuildUnitUtils;
import com.ihk.utils.saleunitnew.DefaultFromPropertyUtils;
import com.ihk.utils.saleunitnew.JsonUtils;
import com.ihk.utils.saleunitnew.PropertyTreeUtils;

/**
 * 新的左边菜单
 */
public class GuangZhouAppointNewLeftAction extends SupperAction{
	
	private static final long serialVersionUID = 472168212432808269L;
	
	@Autowired
	IPropertyProjectServices projectServices;
	@Autowired
	IPropertyAreaServices areaServices;
	@Autowired
	IPropertyBuildServices buildServices;
	@Autowired
	IPropertyUnitServices unitServices;
	@Autowired 
	IPropertyGroupServices propertyGroupServices;
	@Autowired 
	ICompanyProjectServices companyProjectServices;
	
	/**
	 * 默认选中的楼栋
	 * @return
	 * @throws Exception
	 */
	public String getDefaultFromProperty() throws Exception{

		try{
			
			int propertyId = Integer.parseInt(request.getParameter("propertyId"));
			List<PropertyBuild> buildList = buildServices.findPropertyBuildByPropertyId(propertyId);
			
			if(!CommonUtils.isCollectionEmpty(buildList)){
				
				build = buildList.get(0);
				
				unitList = unitServices.findUnitsByBuildId(build.getId());
				trList = BuildUnitUtils.initUnitMap(unitList, build);
				
				isRefresh = "false";
				
			}
		}catch(Exception e){
		}
		
		return "getDefaultFromProperty";
	}
	
	/**
	 * 默认选中的单元
	 * @return
	 * @throws Exception
	 */
	public String getDefaultBuildFromProperty() throws Exception{
		
		String out = new String();
		
		try{
			
			int propertyId = Integer.parseInt(request.getParameter("propertyId"));
			
			List<PropertyBuild> buildList = buildServices.findPropertyBuildByPropertyId(propertyId);
			
			if(!CommonUtils.isCollectionEmpty(buildList)){
				
				PropertyBuild build = buildList.get(0);
				
				out = DefaultFromPropertyUtils.initShowContent(build, null);
				
			}
		}catch(Exception e){
			out = "";
		}
		
		CustomerUtils.writeResponse(response, out);
		
		return null;
	}

	/**
	 * ajax加载公司项目的下拉框
	 * @return
	 * @throws Exception
	 */
	public String layoutAjax2() throws Exception{
		
		urList = PermissionUtils.getUserRoleForLayoutLeft(); //该方法有缓存
		if(CommonUtils.isCollectionEmpty(urList)){
			
			return null;
		}
		
		List<OrderTreeBean> getCacheOrderList = OrderTreeBeanListCacheUtils.getOrderTreeBeanList(urList);
		
		List<OrderTreeBean> orderList = new ArrayList<OrderTreeBean>();
		
		String q = request.getParameter("q"); //提示下拉框的查找参数
		
		if(!CommonUtils.isStrEmpty(q)){
			
			for(OrderTreeBean bean : getCacheOrderList){
				
				String name = bean.getProjectNameAndPinyin();
				if(name.contains(q.trim().toUpperCase())){
					
					orderList.add(bean);
				}
			}
			
		}else{
			
			selectProId = PropertyTreeUtils.getLeftTreeProjectIdSession(request);
			
			orderList = getCacheOrderList;
			
		}
		
		JSONArray jsonArray = new JSONArray();
		JSONObject json = null;
		
		for(OrderTreeBean tmp : orderList){
			
			json = new JSONObject();
			
			json.put("id", tmp.getProjectId());
			//json.put("text", tmp.getProjectNameAndPinyin());
			json.put("text", tmp.getProjectName());
			
			if(selectProId == tmp.getProjectId()){
				json.put("selected", "true");
			}
			
			jsonArray.add(json);
		}
		
		String out = jsonArray.toString();
		
		CustomerUtils.writeResponse(response, out);
		
		return null;
		
	}
	
	/**
	 * ajax加载公司项目的下拉框
	 * @return
	 * @throws Exception
	 */
	public String layoutAjax() throws Exception{
		
		List<CompanyProject> proList = PermissionUtils.getCompanyProjectListByXKZX();
		
		if(CommonUtils.isCollectionEmpty(proList)){
			
			return null;
		}
		
		List<OrderTreeBean> getCacheOrderList = OrderTreeBeanListCacheUtils.getOrderTreeBeanListForProList(proList);
		
		List<OrderTreeBean> orderList = new ArrayList<OrderTreeBean>();
		
		String q = request.getParameter("q"); //提示下拉框的查找参数
		
		if(!CommonUtils.isStrEmpty(q)){
			
			for(OrderTreeBean bean : getCacheOrderList){
				
				String name = bean.getProjectNameAndPinyin();
				if(name.contains(q.trim().toUpperCase())){
					
					orderList.add(bean);
				}
			}
			
		}else{
			
			selectProId = PropertyTreeUtils.getLeftTreeProjectIdSession(request);
			
			orderList = getCacheOrderList;
			
		}
		
		JSONArray jsonArray = new JSONArray();
		JSONObject json = null;
		
		for(OrderTreeBean tmp : orderList){
			
			json = new JSONObject();
			
			json.put("id", tmp.getProjectId());
			//json.put("text", tmp.getProjectNameAndPinyin());
			json.put("text", tmp.getProjectName());
			
			if(selectProId == tmp.getProjectId()){
				json.put("selected", "true");
			}
			
			jsonArray.add(json);
		}
		
		String out = jsonArray.toString();
		
		CustomerUtils.writeResponse(response, out);
		
		return null;
		
	}
	
	/**
	 * 把所有的数据加载到页面的跳转
	 * "交易管理","财务管理"下的共同入口,根据参数设置不同tabs选中的不同session
	 * @return
	 * @throws Exception
	 */
	public String layout() throws Exception{
		
		List<CompanyProject> proList = PermissionUtils.getCompanyProjectListByRCGL();
		
		if(CommonUtils.isCollectionEmpty(proList)){
			
			return null;
		}
		
		if(selectProId == 0){
			
			selectProId = proList.get(0).getId();
		}
		
		PropertyTreeUtils.setLeftTreeProjectIdSession(request, selectProId); //根据selectType设置session
		
		return "layout";
	}
	
	public String layout_old() throws Exception{
		
		urList = PermissionUtils.getUserRoleForLayoutLeft();
		if(CommonUtils.isCollectionEmpty(urList)){
			
			return null;
		}
		
		if(selectProId != 0 ){
			SessionUser.getSessionUser().setProjectId(selectProId);
		}else{
			selectProId = urList.get(0).getProjectId();
			SessionUser.getSessionUser().setProjectId(selectProId);
		}
		
		List<OrderTreeBean> orderList = new ArrayList<OrderTreeBean>();
		OrderTreeBean order = null;
		
		for(UserRole ur : urList){
			
			order = new OrderTreeBean();
			
			order.setProjectNameAndPinyin(ur.getProjectNameAndPinyin());
			order.setProjectId(ur.getProjectId());
			
			orderList.add(order);
		}
		
		Collections.sort(orderList, new OrderTreeComparatorBean());
		
		return "layout";
	}
	
	public String selectLayout(){
		return "suc";
	}
	
	/**
	 * 楼盘项目,分区,楼栋的导航树
	 * 该方法不是很合适,但是获取参数的方法不能替换掉,因为很多地方的导航树都使用了该方法
	 * @return
	 * @throws Exception
	 */
	public String layoutLeft() throws Exception{
		
		String ty = null; //类型,(p代表楼盘项目,a代表楼盘分区,
		String tyid = null; //对应的id
		if(id != null){ //值类似 p154 或 a251
			 ty = id.substring(0,1);
			 tyid=id.substring(1);
		}
		
		//String out = JsonUtils.getJsonForAll(tyid,ty); //该方法每次都要重新查询相关的数据,效率太低,
		//String out = PropertyTreeUtils.getLayoutLeftTree(ty, tyid);
		
		String out = PropertyTreeUtils.getLayoutLeftTreeByTypeAndSelectProId(ty, tyid, request);
		
		CustomerUtils.writeResponse(response, out);
		
		return null;
	}
	
	/**
	 * 楼盘项目id固定获取对应的分区,楼栋tree
	 * 主要用于单元操作的换房
	 * @return
	 * @throws Exception
	 */
	public String layoutLeftForOper() throws Exception{
		
		String propertyProjectId = request.getParameter("propertyProjectId");
		
		JSONObject json = new JSONObject();
		
		if(id == null){
			//只显示楼盘项目及分区,并展开
			
			int propertyId = Integer.parseInt(propertyProjectId);
			
			PropertyProject project = projectServices.findPropertyProjectById(Integer.parseInt(propertyProjectId));
			
			json.put("id", "p" + project.getId());
			json.put("text", project.getPropertyName());
			json.put("state", "open");
			
			PropertyAreaCond cond = new PropertyAreaCond();
			cond.setPropertyId(propertyId);
			List<PropertyArea> areaList = areaServices.findPropertyArea(cond);
			if(!CommonUtils.isCollectionEmpty(areaList)){
				
				String areaJson = JsonUtils.getAreaAndGroupListJson(areaList, null);
				json.put("children", areaJson);
			}
			
		}else{
			//显示分区下对应的楼栋
			
			String type = id.substring(0,1);
			String typeId = id.substring(1);
			
			String out = PropertyTreeUtils.getLayoutLeftTreeByTypeAndSelectProId(type, typeId, request);
			
			CustomerUtils.writeResponse(response, out);
			
			return null;
		}
		
		String out = "[" + json.toString() + "]";
		
		CustomerUtils.writeResponse(response, out);
		
		return null;
	}
	
	/**
	 * 楼盘初始(没有组团)
	 * @return
	 * @throws Exception
	 */
	public String layoutLeftForInit() throws Exception{
		
		String ty = null; //类型,(p代表楼盘项目,a代表楼盘分区,
		String tyid = null; //对应的id
		if(id != null){ //值类似 p154 或 a251
			 ty = id.substring(0,1);
			 tyid=id.substring(1);
		}
		
		//String out = PropertyTreeUtils.getLayoutLeftTree1(ty, tyid);
		
		String out = PropertyTreeUtils.getLayoutLeftTreeNoGroupByTypeAndSelectProId(ty, tyid, request);
		
		CustomerUtils.writeResponse(response, out);
		
		return null;
	}
	
	public String getUnit() throws Exception{
		
		String type = request.getParameter("type");
		if(type != null && type.trim().equals("list")){//要得到的是unitlist
			return "getUnitList";
		}
		
		buildId = request.getParameter("buildId");
		PropertyBuild bb = buildServices.findPropertyBuildById(Integer.parseInt(buildId));
		unitList = unitServices.findUnitsByBuildId(Integer.parseInt(buildId));
		trList = BuildUnitUtils.initUnitMap(unitList,bb);
		
		init();
		
		//2013.4.28dtc增加换房的单元选择
		if("oper".equals(type)){
			
			return "getUnitForOper";
		}
		
		//2013.5.28dtc增加对数的单元选择
		if("checkFee".equals(type)){
			
			return "getUnitForCheckFee";
		}
		
		//2013.6.27dtc增加部分回款单元选择
		if("checkFeeForPart".equals(type)){
			
			return "getUnitForCheckFeePart";
		}
		
		return "getUnit";
	}
	
	public String getAreaUnit() throws Exception{
		String areaId =  request.getParameter("areaId");
		
		List<List<String>> areaUnitList = new ArrayList<List<String>>();//区域内所有房间
		
		
		//拿到所有符合条件的BUILD
		PropertyBuildCond cond = new PropertyBuildCond();
		cond.setAreaId(areaId);
		List<PropertyBuild> buildTmlist = buildServices.findPropertyBuild(cond);
		
		List<Integer> buildIdList = new ArrayList<Integer>();
		for(PropertyBuild bb: buildTmlist){
			buildIdList.add(bb.getId());
		}
		
		int maxFloorNum = 0,minFloorNum = 0;
		PropertyUnitCond ucond = new PropertyUnitCond();
		ucond.setBuildIds(buildIdList);
		try {
			maxFloorNum = this.unitServices.findMaxFloorByBuildIdList(ucond);
			minFloorNum = this.unitServices.findMinFloorByBuildIdList(ucond);
		} catch (Exception e) {
			
			return "getAreaUnit";
		}
	
		
		for(PropertyBuild build: buildTmlist){
			
			unitList = unitServices.findUnitsByBuildId(build.getId());
			List<String> trListtmp = BuildUnitUtils.initUnitMapForScene(unitList,maxFloorNum,minFloorNum,build);
			areaUnitList.add(trListtmp);
		}
		trList = new ArrayList<String>();
		for(List<String> hStr:areaUnitList){
			for (int i = 0; i < hStr.size(); i++) {
				if(trList.size()<=i){
					this.trList.add(hStr.get(i));
				}else{
					trList.set(i, trList.get(i) + hStr.get(i)) ;
				}
			}	
		}
		
		for (int i = 0; i < trList.size(); i++) {
			trList.set(i, "<tr>"+trList.get(i)+"</tr>");
		}
		init();
		return "getAreaUnit";
	}
	
	public String getUnitForRefresh() throws Exception{
		
		buildId = request.getParameter("buildId");
		PropertyBuild bb = buildServices.findPropertyBuildById(Integer.parseInt(buildId));
		unitList = unitServices.findUnitsByBuildId(Integer.parseInt(buildId));
		trList = BuildUnitUtils.initUnitMap(unitList,bb);
		
		CustomerUtils.writeResponse(response, trList.toString());
		
		return null;
	}
	
	private List<List<String>> groList;
	public String getGroup(){//组团
		
		String groId = request.getParameter("groId");
		groList = GuangZhouAppointNewLeftAction.getStaticGroupStrByGroupId(Integer.parseInt(groId), unitServices, buildServices);
		
		init();
		
		return "suc";
	}
	
	/**
	 * 根据groupId得到group map string
	 * @param gid 组团ID
	 * @param PropertyUnitServices实现
	 * @return  List<List<String>> 显示用 group table
	 * */
	public static List<List<String>> getStaticGroupStrByGroupId(int gid,IPropertyUnitServices unitServices2,IPropertyBuildServices buildServicesR){
		List<List<String>> groListR = new ArrayList<List<String>>();
		List<PropertyUnit> unitListR = unitServices2.findUnitListByGroupId(gid);;
		
		int tpbid = 0;
		List<PropertyUnit> tpuList = new ArrayList<PropertyUnit>();
		String topName = "";
		
		while (unitListR.size()>0){
			tpbid = unitListR.get(0).getBuildId();
			topName = buildServicesR.findPropertyBuildById(tpbid).getBuildName();
			for( PropertyUnit u :unitListR){
				if(u.getBuildId() == tpbid){
					tpuList.add(u);
				}
			}
			for(PropertyUnit u :tpuList){
				unitListR.remove(u);
			}
			List<String> tpList = BuildUnitUtils.initUnitMap(tpuList,new PropertyBuild());
			tpList.remove(0);
			tpList.add(0, topName);
			groListR.add(tpList);
			tpuList.clear();
		}
		
		return groListR;
	}
	
	private void init(){
		
		try{
			build = buildServices.findPropertyBuildById(Integer.parseInt(this.getBuildId()));
		}catch(Exception e){
		}
		
		isRefresh = request.getParameter("isRefresh");
	}
	
	////
	private String id;
	private List<String> trList; //房间的tr
	private List<PropertyUnit> unitList;
	
	private PropertyBuild build;
	private String buildId;
	
	private String isRefresh; //主要用于页面局部刷新,是否让单元信息处于选中状态
	
	private int selectProId;
	
	private List<UserRole> urList;
	
	public int getSelectProId() {
		return selectProId;
	}

	public void setSelectProId(int selectProId) {
		this.selectProId = selectProId;
	}

	public void setIsRefresh(String isRefresh) {
		this.isRefresh = isRefresh;
	}
	
	public String getIsRefresh() {
		return isRefresh;
	}

	public void setBuildId(String buildId) {
		this.buildId = buildId;
	}
	
	public String getBuildId() {
		return buildId;
	}
	
	public void setBuild(PropertyBuild build) {
		this.build = build;
	}
	
	public PropertyBuild getBuild() {
		return build;
	}
	
	public void setTrList(List<String> trList) {
		this.trList = trList;
	}
	
	public List<String> getTrList() {
		return trList;
	}
	
	public void setUnitList(List<PropertyUnit> unitList) {
		this.unitList = unitList;
	}
	
	public List<PropertyUnit> getUnitList() {
		return unitList;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<List<String>> getGroList() {
		return groList;
	}

	public void setGroList(List<List<String>> groList) {
		this.groList = groList;
	}

	public List<UserRole> getUrList() {
		return urList;
	}

	public void setUrList(List<UserRole> urList) {
		this.urList = urList;
	}



}
