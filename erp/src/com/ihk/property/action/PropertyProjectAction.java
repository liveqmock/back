package com.ihk.property.action;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.EnumCodeTypeName;
import com.ihk.property.data.pojo.PropertyDeveloper;
import com.ihk.property.data.pojo.PropertyDeveloperCond;
import com.ihk.property.data.pojo.PropertyProject;
import com.ihk.property.data.pojo.PropertyProjectCond;
import com.ihk.property.data.services.IPropertyDeveloperServices;
import com.ihk.property.data.services.IPropertyProjectServices;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.Pager;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;
import com.opensymphony.xwork2.ActionContext;
/**
 *楼盘项目  操作类  明原
 */
public class PropertyProjectAction extends SupperAction{

	
	private static final long serialVersionUID = 1L;
	@Autowired IPropertyProjectServices iPropertyProjectServices;
	@Autowired IPropertyDeveloperServices iPropertyDeveloperServices;
	
	private List<PropertyProject> proproList;
	private PropertyProjectCond proProCond;
	private PropertyProject inputProPro;
	private PropertyProject updateProPro;
	private String updateId;
	private LinkedHashMap selProState;//PROPERTY_PROJECT_STATE
	
	private List<PropertyDeveloper> developerList;
	public String index(){
		proProCond = new PropertyProjectCond();
		this.init();
		return "suc";
	}
	
	/**跳转INPUT页面*/
	public String inputIndex(){
		init();
		return "suc";
	}
	/**提交录入表单*/
	public String input(){
		if(vil(inputProPro)){
			init();
			return "suc";
		}
		inputProPro.setCreatedId(SessionUser.getUserId());
		inputProPro.setCreatedTime(new Date());
		inputProPro.setModId(inputProPro.getCreatedId());
		inputProPro.setModTime(inputProPro.getCreatedTime());
		inputProPro.setIsDeleted("0");
		iPropertyProjectServices.addPropertyProject(inputProPro);
		addActionMessage("录入成功!");
		updateProPro = inputProPro;
		init();
		return "update";
	}
	
	public String search(){
		init();
		return "suc";
	}
	
	public String updateIndex(){
		init();
		this.updateProPro = this.iPropertyProjectServices.findPropertyProjectById(Integer.parseInt(this.updateId));
		return "suc";
	}
	
	public String update(){
		//System.out.println("进入");
		if(vil(updateProPro)){
			init();
			return "suc";
		}
		PropertyProject temp = this.iPropertyProjectServices.findPropertyProjectById(this.updateProPro.getId());
		
		temp.setAdName(updateProPro.getAdName());
		
		temp.setBlockName(updateProPro.getBlockName());
		temp.setBuildArea(updateProPro.getBuildArea());
		
		temp.setCoverArea(updateProPro.getCoverArea());
		temp.setCustomerDesc(updateProPro.getCustomerDesc());
		
		temp.setEndBuildDate(updateProPro.getEndBuildDate());
		temp.setEndSaleDate(updateProPro.getEndSaleDate());
		
		temp.setId(updateProPro.getId());
		temp.setProjectProvince(updateProPro.getProjectProvince());
		temp.setProjectCity(updateProPro.getProjectCity());
		temp.setProjectProvince(updateProPro.getProjectProvince());
		temp.setProjectFeatures(updateProPro.getProjectFeatures());
		temp.setDesignFeatures(updateProPro.getDesignFeatures());
		temp.setStartLandLife(updateProPro.getStartLandLife());
		temp.setEndLandLife(updateProPro.getEndLandLife());
		temp.setPreSalePermit(updateProPro.getPreSalePermit());
		
		temp.setParentId(updateProPro.getParentId());
		temp.setProjectDesc(updateProPro.getProjectDesc());
		temp.setProjectState(updateProPro.getProjectState());
		temp.setPropertyAddress(updateProPro.getPropertyAddress());
		temp.setPropertyName(updateProPro.getPropertyName());
		
		temp.setRemark(updateProPro.getRemark());
		
		temp.setSaleArea(updateProPro.getSaleArea());
		temp.setSimpleName(updateProPro.getSimpleName());
		temp.setStartBuildDate(updateProPro.getStartBuildDate());
		temp.setStartSaleDate(updateProPro.getStartSaleDate());
		
		temp.setModId(SessionUser.getUserId());
		temp.setModTime(new Date());
		this.iPropertyProjectServices.updatePropertyProject(temp);
		
		addActionMessage("修改成功!!");
		init();
		return "suc";
	}
	
	public String del(){
		init();
		return "suc";
	}
	
	private void init(){
		if(proProCond == null){
			proProCond = new PropertyProjectCond();
		}
		this.selProState = DescUtils.getInitSelForGuangZhou(selProState,EnumCodeTypeName.PROPERTY_PROJECT_STATE);
		this.developerList = this.iPropertyDeveloperServices.findPropertyDeveloper(new PropertyDeveloperCond());
		String action = CustomerUtils.getActionNameFromRequest(request);
		Pager page = new Pager(ActionContext.getContext(), 10, action);
		try {
			proProCond.recordCount = this.iPropertyProjectServices.findPropertyProjectCount(proProCond);
		} catch (Exception e) {
			e.printStackTrace();
		}
		page.setCond(proProCond);
		this.proproList = this.iPropertyProjectServices.findPropertyProject(this.proProCond);
		this.setShowPage(page.toHtmlString());
	}
	
	private boolean vil(PropertyProject tempPro ){
		//System.out.println("进入");
		if(tempPro == null)return true;
		if(tempPro.getPropertyName() == null || tempPro.getPropertyName().trim().equals("")){
			addActionMessage("没有填写楼盘名称,录入失败!");
			return true;
		}
		if(tempPro.getDeveloperId() == 0){
			//选择的开发商必须是有这个ID的
			addActionMessage("没有选择开发商,录入失败!");
			return true;
		}	
		return false;
	}

	
	
	public List<PropertyProject> getProproList() {
		return proproList;
	}

	public void setProproList(List<PropertyProject> proproList) {
		this.proproList = proproList;
	}

	public PropertyProjectCond getProProCond() {
		return proProCond;
	}

	public void setProProCond(PropertyProjectCond proProCond) {
		this.proProCond = proProCond;
	}

	public PropertyProject getInputProPro() {
		return inputProPro;
	}

	public void setInputProPro(PropertyProject inputProPro) {
		this.inputProPro = inputProPro;
	}

	public PropertyProject getUpdateProPro() {
		return updateProPro;
	}

	public void setUpdateProPro(PropertyProject updateProPro) {
		this.updateProPro = updateProPro;
	}

	public String getUpdateId() {
		return updateId;
	}

	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}

	public LinkedHashMap getSelProState() {
		return selProState;
	}

	public void setSelProState(LinkedHashMap selProState) {
		this.selProState = selProState;
	}

	public List<PropertyDeveloper> getDeveloperList() {
		return developerList;
	}

	public void setDeveloperList(List<PropertyDeveloper> developerList) {
		this.developerList = developerList;
	}
	
	
	
}
