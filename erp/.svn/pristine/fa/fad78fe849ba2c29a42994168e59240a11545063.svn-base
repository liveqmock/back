package com.ihk.saleunit.action.new_init;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.demo.data.pojo.DemoTable;
import com.ihk.property.data.pojo.PropertyProject;
import com.ihk.property.data.services.IPropertyProjectServices;
import com.ihk.saleunit.data.pojo.PropertyProjectPlan;
import com.ihk.saleunit.data.services.IPropertyProjectPlanServices;
import com.ihk.utils.CommonPojoUtils;
import com.ihk.utils.SupperAction;

/**
 * 楼盘项目的销售计划
 * 基本增删改查的action
 * 此action不包括复杂业务的操作，仅限于增删改查的基本单表操作
 * @author Administrator
 *
 */
public class PropertyProjectPlanAction extends SupperAction{

	private static final long serialVersionUID = 1L;

	@Autowired 
	IPropertyProjectServices propertyProjectServices;

	@Autowired 
	IPropertyProjectPlanServices propertyProjectPlanServices;
	
	private PropertyProjectPlan addData;
	private PropertyProjectPlan updateData;

	private PropertyProject propertyProject;
	
	private int propertyId;
	

	public int getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
	}

	public PropertyProject getPropertyProject() {		
		return propertyProject;
	}

	public void setPropertyProject(PropertyProject propertyProject) {
		this.propertyProject = propertyProject;
	}

	public PropertyProjectPlan getAddData() {
		return addData;
	}

	public void setAddData(PropertyProjectPlan addData) {
		this.addData = addData;
	}	

	public PropertyProjectPlan getUpdateData() {
		return updateData;
	}

	public void setUpdateData(PropertyProjectPlan updateData) {
		this.updateData = updateData;
	}

	/**
	 * 提供给添加页面
	 * @return
	 */
	public String forInput() {
		//添加前的初始化
		propertyProject = propertyProjectServices.findPropertyProjectById(propertyId);
		
		removeSuggestion();
		return "forInput";
	}
	
	/**
	 * action执行添加
	 * @return
	 */
	public String inputData() {
		System.out.println("doAdd:");

		try{	
			addData.setPropertyId(propertyProject.getId());
			CommonPojoUtils.initPojoCommonFiled(addData);
			propertyProjectPlanServices.addPropertyProjectPlan(addData);

			setUpMarkToClose();
			setSuggestion_Success();
			
		}
		catch(Exception e){			
			setSuggestion_Fail();
		}
		
		return "inputSuccess";
	}

	/**
	 * action执行查询
	 * @return
	 */
	public String doQuery(){
		return "querySuccess";
	}
	

	/**
	 * 楼盘销售计划 :取得一条数据显示的页面
	 * @return
	 * @throws Exception
	 */
	public String getPlanById() throws Exception{		
		updateData = propertyProjectPlanServices.findPropertyProjectPlanById(Integer.parseInt(request.getParameter("id")));
		
		removeSuggestion();
		
		return "finish";
	}
	
	/**
	 * 楼盘销售计划:执行修改数据的处理与页面
	 * @return
	 * @throws Exception
	 */
	public String updatePlanData() throws Exception{
		
		try{
			
			PropertyProjectPlan oldData = propertyProjectPlanServices.findPropertyProjectPlanById(updateData.getId());
			updateData.setPropertyId(oldData.getPropertyId());
			CommonPojoUtils.initPojoForUpdate(oldData, updateData);
			propertyProjectPlanServices.updatePropertyProjectPlan(updateData);
			
			setUpMarkToClose();
			setSuggestion_Success();
			
		}
		catch(Exception e){			
			setSuggestion_Fail();
		}
		
		return "finish";
	}

	/**
	 * action执行修改
	 * @return
	 */
	public String doDelete(){
		return "deleteSuccess";
	}
}
