package com.ihk.property.action;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.property.data.pojo.PropertyDeveloper;
import com.ihk.property.data.pojo.PropertyDeveloperCond;
import com.ihk.property.data.services.IPropertyDeveloperServices;
import com.ihk.property.data.services.impl.PropertyDeveloperServices;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.Pager;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;
import com.opensymphony.xwork2.ActionContext;

/**
 * 开发商  search_developer.jsp index
 * */
public class DeveloperAction extends SupperAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired IPropertyDeveloperServices iPropertyDeveloperServices;
	
	List<PropertyDeveloper> deveList;
	PropertyDeveloperCond deveCond;
	PropertyDeveloper inputDeveloper;
	PropertyDeveloper updateDeveloper;
	String updateId;
	
	public String index(){
		deveCond = new PropertyDeveloperCond();
		init();
		return "suc";
	}
	
	/**跳转INPUT页面*/
	public String inputIndex(){
		return "suc";
	}
	/**提交录入表单*/
	public String input(){
		if(inputDeveloper.getDeveloperName() == null || inputDeveloper.getDeveloperName().trim().equals("")){
			addActionMessage("开发商名不能为空,请填写名称!!");
			return "suc";
		}
		inputDeveloper.setCreatedId(SessionUser.getUserId());
		inputDeveloper.setCreatedTime(new Date());
		inputDeveloper.setModId(inputDeveloper.getCreatedId());
		inputDeveloper.setModTime(inputDeveloper.getCreatedTime());
		inputDeveloper.setIsDeleted("0");
		iPropertyDeveloperServices.addPropertyDeveloper(inputDeveloper);
		updateDeveloper = inputDeveloper;
		addActionMessage("录入成功!!");
		return "update";
	}
	
	public String search(){
		init();
		return "suc";
	}
	
	public String updateIndex(){
		updateDeveloper = iPropertyDeveloperServices.findPropertyDeveloperById(Integer.parseInt(this.updateId));
		return "suc";
	}
	public String update(){
		if(updateDeveloper.getDeveloperName() == null || updateDeveloper.getDeveloperName().trim().equals("")){
			updateDeveloper = iPropertyDeveloperServices.findPropertyDeveloperById(updateDeveloper.getId());
			addActionMessage("开发商名不能为空,请填写名称!!");
			return "suc";
		}
		PropertyDeveloper temp = iPropertyDeveloperServices.findPropertyDeveloperById(updateDeveloper.getId());
		temp.setDeveloperName(updateDeveloper.getDeveloperName());
		temp.setRemark(updateDeveloper.getRemark());
		temp.setModId(SessionUser.getUserId());
		temp.setModTime(new Date());
		iPropertyDeveloperServices.updatePropertyDeveloper(temp);
		addActionMessage("修改成功!!");
		return "suc";
	}
	
	public String del(){
		init();
		return "suc";
	}
	
	private void init(){
		if(deveCond == null) deveCond = new PropertyDeveloperCond() ;
		String action = CustomerUtils.getActionNameFromRequest(request);
		Pager page = new Pager(ActionContext.getContext(), 10, action);
		deveCond.recordCount = this.iPropertyDeveloperServices.findPropertyDeveloperCount(deveCond);
		page.setCond(deveCond);
		deveList = iPropertyDeveloperServices.findPropertyDeveloperPage(deveCond);
		this.setShowPage(page.toHtmlString());
		
		deveList = iPropertyDeveloperServices.findPropertyDeveloper(deveCond);
	}

	
	
	public List<PropertyDeveloper> getDeveList() {
		return deveList;
	}

	public void setDeveList(List<PropertyDeveloper> deveList) {
		this.deveList = deveList;
	}

	public PropertyDeveloperCond getDeveCond() {
		return deveCond;
	}

	public void setDeveCond(PropertyDeveloperCond deveCond) {
		this.deveCond = deveCond;
	}

	public PropertyDeveloper getInputDeveloper() {
		return inputDeveloper;
	}

	public void setInputDeveloper(PropertyDeveloper inputDeveloper) {
		this.inputDeveloper = inputDeveloper;
	}

	public PropertyDeveloper getUpdateDeveloper() {
		return updateDeveloper;
	}

	public void setUpdateDeveloper(PropertyDeveloper updateDeveloper) {
		this.updateDeveloper = updateDeveloper;
	}

	public String getUpdateId() {
		return updateId;
	}

	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}
	
	
}
