package com.ihk.saleunit.action.new_financial;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


import com.ihk.constanttype.ContTable;
import com.ihk.property.data.pojo.PropertyBuild;
import com.ihk.property.data.pojo.PropertyBuildCond;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.property.data.pojo.PropertyUnitCond;
import com.ihk.property.data.services.IPropertyBuildServices;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.ReportUtils;
import com.ihk.utils.SupperAction;
import com.ihk.utils.saleunit.BuildUnitUtils;
import com.ihk.utils.saleunitnew.DefaultFromPropertyUtils;

/**
 * 财务管理
 * @author dtc
 * 2012-7-11
 */
public class Layout extends SupperAction {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	IPropertyBuildServices buildServices;
	@Autowired
	IPropertyUnitServices unitServices;
	
	/**
	 * 旧的入口
	 * @return
	 * @throws Exception
	 */
	public String financialManagerLayout() throws Exception{
		
		return "financialManagerLayout";
	}
	
	/**
	 * 默认选中
	 * @return
	 * @throws Exception
	 */
	public String getDefaultFromProperty() throws Exception{

		try{
			
			int propertyId = Integer.parseInt(request.getParameter("propertyId"));
			
			build = DefaultFromPropertyUtils.getDefaultBuild(propertyId,request);
			
			unitList = unitServices.findUnitsByBuildId(build.getId());
			trList = DefaultFromPropertyUtils.getDefaultTrList(request, unitList, build); //type
			
		}catch(Exception e){
		}
		
		return DefaultFromPropertyUtils.getDefaultTo(request);
	}
	
	/**
	 * 获取默认选中的单元id
	 * @return
	 * @throws Exception
	 */
	public String getDefaultUnitIdFromProperty() throws Exception{
		
		String out = new String();
		
		try{
			
			int propertyId = Integer.parseInt(request.getParameter("propertyId"));
			
			List<PropertyBuild> buildList = buildServices.findPropertyBuildByPropertyId(propertyId);
			
			if(!CommonUtils.isCollectionEmpty(buildList)){
				
				PropertyBuild build = buildList.get(0);
				
				PropertyUnit unit = unitServices.findUnitOneByBuildId(build.getId());
				
				Map<String, String> map = new HashMap<String, String>();
				map.put("buildId", build.getId() + "");
				map.put("unitId", unit.getId() + "");
				
				out = CommonUtils.getMapJson(map);
				
			}
		}catch(Exception e){
			out = "{}";
		}
		
		CustomerUtils.writeResponse(response, out);
		
		return null;
	}
	
	//单元
	public String getUnit() throws Exception{
		
		buildId = request.getParameter("buildId");
		PropertyBuild bb = buildServices.findPropertyBuildById(Integer.parseInt(buildId));
		unitList = unitServices.findUnitsByBuildId(Integer.parseInt(buildId));
		trList = BuildUnitUtils.initUnitMap(unitList,bb);
		
		init();
		
		return "getUnit";
	}
	
	//分区
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
		maxFloorNum = this.unitServices.findMaxFloorByBuildIdList(ucond);
		minFloorNum = this.unitServices.findMinFloorByBuildIdList(ucond);
		
		for(PropertyBuild bb: buildTmlist){
			unitList = unitServices.findUnitsByBuildId(bb.getId());
			List<String> trListtmp = BuildUnitUtils.initUnitMap(unitList,maxFloorNum,minFloorNum,bb);
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
	
	//组团
	public String getGroup(){
		
		groList = new ArrayList<List<String>>();
		String groId = request.getParameter("groId");
		unitList = unitServices.findUnitListByGroupId(Integer.parseInt(groId));
		int tpbid = 0;
		List<PropertyUnit> tpuList = new ArrayList<PropertyUnit>();
		String topName = "";
		while (unitList.size()>0){
			tpbid = unitList.get(0).getBuildId();
			topName = buildServices.findPropertyBuildById(tpbid).getBuildName();
			for( PropertyUnit u :unitList){
				if(u.getBuildId() == tpbid){
					tpuList.add(u);
				}
			}
			for(PropertyUnit u :tpuList){
				unitList.remove(u);
			}
			List<String> tpList = BuildUnitUtils.initUnitMap(tpuList,new PropertyBuild());
			tpList.remove(0);
			tpList.add(0, topName);
			groList.add(tpList);
			tpuList.clear();
		}
		
		init();
		
		return "getGroup";
	}
	
	private void init(){
		
		try{
			build = buildServices.findPropertyBuildById(Integer.parseInt(this.getBuildId()));
		}catch(Exception e){
		}
		
		isRefresh = request.getParameter("isRefresh");
	}
	
	private String isRefresh; //主要用于页面局部刷新,是否让单元信息处于选中状态
	
	private PropertyBuild build;
	private String buildId;
	
	private String id;
	private List<String> trList; //房间的tr
	private List<PropertyUnit> unitList;
	
	private List<List<String>> groList;
	
	public void setGroList(List<List<String>> groList) {
		this.groList = groList;
	}
	
	public List<List<String>> getGroList() {
		return groList;
	}
	
	public String getIsRefresh() {
		return isRefresh;
	}

	public void setIsRefresh(String isRefresh) {
		this.isRefresh = isRefresh;
	}

	public PropertyBuild getBuild() {
		return build;
	}

	public void setBuild(PropertyBuild build) {
		this.build = build;
	}

	public String getBuildId() {
		return buildId;
	}

	public void setBuildId(String buildId) {
		this.buildId = buildId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<String> getTrList() {
		return trList;
	}

	public void setTrList(List<String> trList) {
		this.trList = trList;
	}

	public List<PropertyUnit> getUnitList() {
		return unitList;
	}

	public void setUnitList(List<PropertyUnit> unitList) {
		this.unitList = unitList;
	}

	public String layoutLeftFinancial() throws Exception{
		
		JSONArray jsonArr = new JSONArray();
		
		JSONObject json1 = new JSONObject();
		json1.put("text", "报表");
		json1.put("state", "open"); //state：节点状态， 'open' 或 'closed'，默认是 'open'。当设为 'closed' 时，此节点有子节点，并且将从远程站点加载它们。
		
		JSONObject attJson = new JSONObject();
		attJson.put("type", "endNode");
		attJson.put("url", "./saleunit_new_financial/guangzhou/table.jsp");
		json1.put("attributes", attJson);
		
		jsonArr.add(json1);
		
		JSONObject json2 = new JSONObject();
		json2.put("text", "对数");
		json2.put("state", "open"); //state：节点状态， 'open' 或 'closed'，默认是 'open'。当设为 'closed' 时，此节点有子节点，并且将从远程站点加载它们。
		
		JSONObject attJson2 = new JSONObject();
		attJson2.put("type", "endNode");
		attJson2.put("url", "./saleunit_new_financial/guangzhou/check_up.jsp");
		//attJson2.put("iframe", "no"); //不用iframe来装载href
		json2.put("attributes", attJson2);
		
		jsonArr.add(json2);
		
		JSONObject json3 = new JSONObject();
		json3.put("text", "结佣");
		json3.put("state", "open"); //state：节点状态， 'open' 或 'closed'，默认是 'open'。当设为 'closed' 时，此节点有子节点，并且将从远程站点加载它们。
		
		JSONObject attJson3 = new JSONObject();
		attJson3.put("type", "endNode");
		attJson3.put("url", "./saleunit_new_financial/guangzhou/end_money.jsp");
		attJson3.put("iframe", "no"); //不用iframe来装载href
		json3.put("attributes", attJson3);
		
		jsonArr.add(json3);
		
		JSONObject json4 = new JSONObject();
		json4.put("text", "test");
		json4.put("state", "open"); //state：节点状态， 'open' 或 'closed'，默认是 'open'。当设为 'closed' 时，此节点有子节点，并且将从远程站点加载它们。
		
		JSONObject attJson4 = new JSONObject();
		attJson4.put("type", "endNode");
		attJson4.put("content", "<center><font color='red'>居中</font></center>");
		json4.put("attributes", attJson4);
		
		jsonArr.add(json4);
		
		String out = jsonArr.toString();
		
		CustomerUtils.writeResponse(response, out);
		
		return null;
	}
	
	public String download() throws Exception{
		
		String[] ths = new String[]{"楼盘项目", "楼盘分区", "楼盘分区", "房号", "单价", "总价", "是否对数", "对数日期"};
		
		final StringBuffer sb = new StringBuffer();
		
		sb.append(ContTable.TABLE_START)
			.append(ContTable.TR_START)
			;
		for(String th : ths){
			sb.append(ContTable.TH_START)
				.append(th)
				.append(ContTable.TH_END)
				;
			
		}
		sb.append(ContTable.TR_END);
		
		List<String[]> list = tmpList();
		
		for(String[] ls : list){
			
			sb.append(ContTable.TR_START);
			
			for(String l : ls){
				
				sb.append(ContTable.TD_START).append(l).append(ContTable.TD_END);
			}
			
			sb.append(ContTable.TR_END);
		}
		
		sb.append(ContTable.TALBE_END);
		
		String fileName = "download-" + CustomerUtils.getNowForString() + "-.xls";
		ReportUtils.downLoadReport(sb.toString(), fileName, response);
		
		return null;
	}
	
	///
	private List<String[]> tmpList(){
		
		List<String[]> retList = new ArrayList<String[]>();
		
		String[] a1 = new String[8];
		a1[0] = "金域蓝湾";
		a1[1] = "东区A8";
		a1[2] = "1单元";
		a1[3] = "C1-1";
		a1[4] = "10000";
		a1[5] = "1000000";
		a1[6] = "是";
		a1[7] = "2012-07-01";
		
		for(int i=1; i<=16; i++){
			retList.add(a1);
		}
		
		return retList;
	}
	

}
