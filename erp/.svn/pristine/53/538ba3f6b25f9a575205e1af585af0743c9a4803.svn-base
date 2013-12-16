package com.ihk.saleunit.action.new_init;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.property.data.pojo.PropertyBuild;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.property.data.pojo.PropertyUnitCond;
import com.ihk.property.data.services.IPropertyBuildServices;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.utils.SupperAction;
import com.ihk.utils.saleunit.BuildUnitUtils;

/**
 * 楼盘初始 中间界面 单元map
 * @author Administrator
 *
 */
public class GuangZhouNewUnitList extends SupperAction{
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * 根据buildId
	 * 得到全部的unit
	 * */
	
	@Autowired IPropertyUnitServices iPropertyUnitServices;
	@Autowired IPropertyBuildServices iPropertyBuildServices;
	private int buildId;
	private List<PropertyUnit> unitList;
	private List<String> trList; //房间的tr
	private PropertyBuild selBuild;
	
	

	public String indexList(){
		this.init();
		return "suc";
	}
	
	public String indexMap(){
		if(buildId == 0)return "suc";
		this.init();
		//trList = BuildUnitUtils.initTrAndDivTdByUnitList(unitList,"");
		trList = BuildUnitUtils.initUnitMap1(unitList,new PropertyBuild());
		trList.remove(0);
		selBuild = iPropertyBuildServices.findPropertyBuildById(buildId);
		return "suc";
	}

	private void init() {
		if(buildId == 0)return;
		PropertyUnitCond cond = new PropertyUnitCond();
		cond.setBuildId(this.buildId+"");
		this.unitList = this.iPropertyUnitServices.findPropertyUnit(cond);
	}

	public int getBuildId() {
		return buildId;
	}

	public void setBuildId(int buildId) {
		this.buildId = buildId;
	}

	public List<PropertyUnit> getUnitList() {
		return unitList;
	}

	public void setUnitList(List<PropertyUnit> unitList) {
		this.unitList = unitList;
	}

	public List<String> getTrList() {
		return trList;
	}

	public void setTrList(List<String> trList) {
		this.trList = trList;
	}


	public PropertyBuild getSelBuild() {
		return selBuild;
	}

	public void setSelBuild(PropertyBuild selBuild) {
		this.selBuild = selBuild;
	}
	
	
	
	
}
