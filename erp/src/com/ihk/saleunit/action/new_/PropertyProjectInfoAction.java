package com.ihk.saleunit.action.new_;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.property.data.pojo.PropertyDeveloper;
import com.ihk.property.data.pojo.PropertyProject;
import com.ihk.property.data.services.IPropertyDeveloperServices;
import com.ihk.property.data.services.IPropertyProjectServices;
import com.ihk.saleunit.data.pojo.PropertyProjectPlan;
import com.ihk.saleunit.data.pojo.PropertyProjectPlanCond;
import com.ihk.saleunit.data.services.IPropertyProjectPlanServices;
import com.ihk.utils.SupperAction;

/**
 * 楼盘项目
 *
 */
public class PropertyProjectInfoAction extends  SupperAction{
	private static final long serialVersionUID = 1L;
	
	@Autowired IPropertyProjectServices propertyProjectServices;
	@Autowired IPropertyDeveloperServices propertyDeveloperServices;
	@Autowired
	IPropertyProjectPlanServices propertyProjectPlanServices;
	

	private List<PropertyProjectPlan> propertyProjectPlanList;
	private PropertyProjectPlanCond propertyProjectPlanCond;  
	
	
	
	public List<PropertyProjectPlan> getPropertyProjectPlanList() {
		return propertyProjectPlanList;
	}
	public void setPropertyProjectPlanList(
			List<PropertyProjectPlan> propertyProjectPlanList) {
		this.propertyProjectPlanList = propertyProjectPlanList;
	}
	
	/**
	 * 项目信息
	 * */
	public String proInfo(){
		propojo = propertyProjectServices.findPropertyProjectById(proId);
		
		if(propojo.getDeveloperId() == 0){
			devpojo = new PropertyDeveloper();
		}else{
			devpojo = propertyDeveloperServices.findPropertyDeveloperById(propojo.getDeveloperId());
		}
		
		propertyProjectPlanCond = new PropertyProjectPlanCond();
		propertyProjectPlanCond.setPropertyId(String.valueOf(propojo.getId()));
		propertyProjectPlanList = propertyProjectPlanServices.findPropertyProjectPlan(propertyProjectPlanCond);
		
		return "suc";
	}
	
	/**
	 * 项目信息 销控中心用
	 * */
	public String proInfoBySaleUnit(){
		propojo = propertyProjectServices.findPropertyProjectById(proId);
		
		if(propojo.getDeveloperId() == 0){
			devpojo = new PropertyDeveloper();
		}else{
			devpojo = propertyDeveloperServices.findPropertyDeveloperById(propojo.getDeveloperId());
		}
		
		
		return "suc";
	}
	
	private int proId;
	
	private PropertyProject propojo;
	private PropertyDeveloper devpojo;
	
	public int getProId() {
		return proId;
	}
	public void setProId(int proId) {
		this.proId = proId;
	}
	public PropertyProject getPropojo() {
		return propojo;
	}
	public void setPropojo(PropertyProject propojo) {
		this.propojo = propojo;
	}
	public PropertyDeveloper getDevpojo() {
		return devpojo;
	}
	public void setDevpojo(PropertyDeveloper devpojo) {
		this.devpojo = devpojo;
	}

	
}
