package com.ihk.saleunit.action.new_;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.property.data.pojo.PropertyBuild;
import com.ihk.property.data.pojo.PropertyBuildCond;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.property.data.pojo.PropertyUnitCond;
import com.ihk.property.data.services.IPropertyBuildServices;
import com.ihk.property.data.services.IPropertyGroupServices;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.utils.SupperAction;
import com.ihk.utils.saleunit.BuildUnitUtils;

/**
 * 现场销控情况
 * @author dtc
 * 2012-10-24,下午04:58:34
 */
public class GuangZhouSceneAction extends SupperAction{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	IPropertyBuildServices buildServices;
	@Autowired
	IPropertyUnitServices unitServices;
	@Autowired 
	IPropertyGroupServices propertyGroupServices;
	
	public String layoutScene() throws Exception{
		
		return "layoutScene";
	}
	
	public String getUnit() throws Exception{
		
		buildId = request.getParameter("buildId");
		PropertyBuild build = buildServices.findPropertyBuildById(Integer.parseInt(buildId));
		unitList = unitServices.findUnitsByBuildId(Integer.parseInt(buildId));
		
		trList = BuildUnitUtils.initUnitMapForScene(unitList, build);
		
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
		
		return "getAreaUnit";
	}
	
	/**
	 * 组团
	 * @return
	 * @throws Exception
	 */
	public String getGroup() throws Exception{
		
		String groId = request.getParameter("groId");
		groList = getStaticGroupStrByGroupId(Integer.parseInt(groId));
		
		return "getGroup";
	}
	
	private List<List<String>> getStaticGroupStrByGroupId(int gid){
		
		List<List<String>> groListR = new ArrayList<List<String>>();
		List<PropertyUnit> unitListR = unitServices.findUnitListByGroupId(gid);;
		
		int tpbid = 0;
		List<PropertyUnit> tpuList = new ArrayList<PropertyUnit>();
		String topName = "";
		
		while (unitListR.size()>0){
			tpbid = unitListR.get(0).getBuildId();
			topName = buildServices.findPropertyBuildById(tpbid).getBuildName();
			for( PropertyUnit u :unitListR){
				if(u.getBuildId() == tpbid){
					tpuList.add(u);
				}
			}
			for(PropertyUnit u :tpuList){
				unitListR.remove(u);
			}
			List<String> tpList = BuildUnitUtils.initUnitMapForScene(tpuList, new PropertyBuild());
			tpList.remove(0);
			tpList.add(0, topName);
			groListR.add(tpList);
			tpuList.clear();
		}
		
		return groListR;
	}
	
	///
	
	private String buildId;
	
	private List<String> trList; //房间的tr
	private List<PropertyUnit> unitList;
	
	private List<List<String>> groList;
	
	public void setGroList(List<List<String>> groList) {
		this.groList = groList;
	}
	
	public List<List<String>> getGroList() {
		return groList;
	}

	public String getBuildId() {
		return buildId;
	}

	public void setBuildId(String buildId) {
		this.buildId = buildId;
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
	
}
