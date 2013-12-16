package com.ihk.property.action;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.EnumCodeTypeName;
import com.ihk.property.data.pojo.PropertyBuild;
import com.ihk.property.data.pojo.PropertyBuildCond;
import com.ihk.property.data.pojo.PropertyProject;
import com.ihk.property.data.pojo.PropertyProjectCond;
import com.ihk.property.data.services.IPropertyBuildServices;
import com.ihk.property.data.services.IPropertyProjectServices;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.Pager;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;
import com.opensymphony.xwork2.ActionContext;

/**
 * 楼栋操作
 * */
public class BuildAction extends SupperAction {
	private static final long serialVersionUID = 1L;
	@Autowired
	IPropertyBuildServices iPropertyBuildServices;
	@Autowired
	IPropertyProjectServices iPropertyProjectServices;

	private List<PropertyBuild> buildList;
	private PropertyBuildCond buildCond;
	private PropertyBuild inputBuild;
	private PropertyBuild updateBuild;
	private String updateId;
	private List<PropertyProject> projectList;
	private LinkedHashMap selSaleType;
	private LinkedHashMap selBuildType;
	private LinkedHashMap selBuildNature;

	private String propertyName;

	private String nameForPropertyId;

	public String index() {
		buildCond = new PropertyBuildCond();
		init();
		return "suc";
	}

	/** 跳转INPUT页面 */
	public String inputIndex() {
		if(inputBuild != null && inputBuild.getPropertyId( )!= 0){
				propertyName = DescUtils.findPropertyNameById(inputBuild.getPropertyId());
		}
		init();
		return "suc";
	}

	/** 提交录入表单 */
	public String input() {
		if(inputBuild.getPropertyId() == 0){
			addActionMessage("选择的项目不存在");
			init();
			return "suc";
		}
		if(inputBuild.getAreaId() == 0 ){
			addActionMessage("请选择分区");
			init();
			return "suc";
		}
		if(inputBuild.getBuildName() == null || inputBuild.getBuildName().trim().equals("")){
			addActionMessage("楼栋名称不能为空");
			init();
			return "suc";
		}
		
		inputBuild.setCreatedId(SessionUser.getUserId());
		inputBuild.setCreatedTime(new Date());
		inputBuild.setModId(inputBuild.getCreatedId());
		inputBuild.setModTime(inputBuild.getCreatedTime());
		inputBuild.setIsDeleted("0");
		iPropertyBuildServices.addPropertyBuild(inputBuild);
		addActionMessage("录入成功!");
		updateBuild = inputBuild;
		init();
		return "update";
	}

	public String search() {
		
		init();
		return "suc";
	}

	public String updateIndex() {
		init();
		updateBuild = iPropertyBuildServices.findPropertyBuildById(Integer
				.parseInt(this.updateId));
		this.nameForPropertyId = DescUtils.findPropertyNameById(updateBuild
				.getPropertyId());
		return "suc";
	}

	public String update() {
		init();
		PropertyBuild temp = iPropertyBuildServices
				.findPropertyBuildById(updateBuild.getId());

		temp.setPropertyId(updateBuild.getPropertyId());
		temp.setBuildName(updateBuild.getBuildName());
		//temp.setBuildType(updateBuild.getBuildType());
		temp.setBuildNature(updateBuild.getBuildNature());
		//temp.setParentId(updateBuild.getParentId());
		temp.setOrderIndex(updateBuild.getOrderIndex());
		temp.setRemark(updateBuild.getRemark());
		temp.setSaleType(updateBuild.getSaleType());

		temp.setModId(SessionUser.getUserId());
		temp.setModTime(new Date());
		iPropertyBuildServices.updatePropertyBuild(temp);
		addActionMessage("修改成功!");

		return updateIndex();
	}

	public String del() {
		init();
		return "suc";
	}

	private void init() {
		if(buildCond == null){
			buildCond =  new PropertyBuildCond();
		}

		String action = CustomerUtils.getActionNameFromRequest(request);
		Pager page = new Pager(ActionContext.getContext(), 10, action);
		buildCond.recordCount =
		this.iPropertyBuildServices.findPropertyBuildCount(buildCond);
		page.setCond(buildCond);
		buildList = iPropertyBuildServices.findPropertyBuild(buildCond);
		this.setShowPage(page.toHtmlString());

		this.selBuildType = DescUtils.getInitSelForGuangZhou(selBuildType,
				EnumCodeTypeName.PROPERTY_BUILD_TYPE, true);
		this.selSaleType = DescUtils.getInitSelForGuangZhou(selSaleType,
				EnumCodeTypeName.PROPERTY_SALE_TYPE, true);
		this.selBuildNature = DescUtils.getInitSelForGuangZhou(selBuildNature,
				EnumCodeTypeName.PROPERTY_BUILD_NATURE, true);
	}

	private String prid;

	public String selBuildByPr() {
		if (prid == null || prid.trim().equals("0"))
			return null;
		try {
			int intproid = Integer.parseInt(prid);
			PropertyBuildCond cond = new PropertyBuildCond();
			cond.setPropertyId(intproid + "");
			List<PropertyBuild> bulist = this.iPropertyBuildServices
					.findPropertyBuild(cond);
			StringBuffer sb = new StringBuffer();

			for (PropertyBuild p : bulist) {
				sb.append("<option value='");
				sb.append(p.getId() + "'>");
				sb.append(p.getBuildName());
				sb.append("</option>");
			}
			CustomerUtils.writeResponse(this.response, sb.toString());
		} catch (Exception e) {
			return null;
		}
		return null;
	}

	public List<PropertyBuild> getBuildList() {
		return buildList;
	}

	public void setBuildList(List<PropertyBuild> buildList) {
		this.buildList = buildList;
	}

	public PropertyBuildCond getBuildCond() {
		return buildCond;
	}

	public void setBuildCond(PropertyBuildCond buildCond) {
		this.buildCond = buildCond;
	}

	public PropertyBuild getInputBuild() {
		return inputBuild;
	}

	public void setInputBuild(PropertyBuild inputBuild) {
		this.inputBuild = inputBuild;
	}

	public PropertyBuild getUpdateBuild() {
		return updateBuild;
	}

	public void setUpdateBuild(PropertyBuild updateBuild) {
		this.updateBuild = updateBuild;
	}

	public String getUpdateId() {
		return updateId;
	}

	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}

	public List<PropertyProject> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<PropertyProject> projectList) {
		this.projectList = projectList;
	}

	public LinkedHashMap getSelSaleType() {
		return selSaleType;
	}

	public void setSelSaleType(LinkedHashMap selSaleType) {
		this.selSaleType = selSaleType;
	}

	public LinkedHashMap getSelBuildType() {
		return selBuildType;
	}

	public void setSelBuildType(LinkedHashMap selBuildType) {
		this.selBuildType = selBuildType;
	}

	public LinkedHashMap getSelBuildNature() {
		return selBuildNature;
	}

	public void setSelBuildNature(LinkedHashMap selBuildNature) {
		this.selBuildNature = selBuildNature;
	}

	public String getNameForPropertyId() {
		return nameForPropertyId;
	}

	public void setNameForPropertyId(String nameForPropertyId) {
		this.nameForPropertyId = nameForPropertyId;
	}

	public String getPrid() {
		return prid;
	}

	public void setPrid(String prid) {
		this.prid = prid;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

}
