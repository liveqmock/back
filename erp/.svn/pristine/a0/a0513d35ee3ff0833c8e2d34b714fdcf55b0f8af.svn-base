package com.ihk.property.action;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.property.data.pojo.PropertyArea;
import com.ihk.property.data.pojo.PropertyAreaCond;
import com.ihk.property.data.services.IPropertyAreaServices;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.Pager;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;
import com.opensymphony.xwork2.ActionContext;


/**
 * POJO:PropertyArea
 * IndexJsp:/crm/WebRoot/property/guangzhou/area/input_area.jsp
 * add area, update area, search area
 */
public class AreaAction extends SupperAction{

	private static final long serialVersionUID = 1L;
	
	@Autowired IPropertyAreaServices iPropertyAreaServices;
	private String propertyName;
	
	/**main*/
	public String index(){
		return this.inputIndex();
	}
	
	private PropertyAreaCond areaCond;
	private List<PropertyArea> areaList; 
	/**find Area
	 * @param areaCond 
	 * @param areaList
	 * */
	public String searchIndex(){
		areaCond = new PropertyAreaCond();
		initList();
		return "search";
	}
	public String searchForm(){
		initList();
		return "search";
	}
	private void initList(){
		 String action = CustomerUtils.getActionNameFromRequest(request);
		 Pager page = new Pager(ActionContext.getContext(), 10, action);
		 areaCond.recordCount = this.iPropertyAreaServices.findPropertyAreaCount(areaCond);
		 page.setCond(areaCond);
		 this.setShowPage(page.toHtmlString());
		 areaList = iPropertyAreaServices.findPropertyAreaPage(areaCond);
	}
	
	private PropertyArea inputArea;
	/**input Area
	 * @param inputArea
	 * */
	public String inputIndex(){
		return "input";
	}
	public String inputForm(){
		inputArea.setCreatedId(SessionUser.getUserId());
		inputArea.setCreatedTime(new Date());
		inputArea.setModId(SessionUser.getUserId());
		inputArea.setModTime(inputArea.getCreatedTime());
		inputArea.setIsDeleted("0");
		try {
			if(inputArea.getPropertyId() == 0 || inputArea.getAreaName().trim().equals("")){
				addActionMessage("请填写完整的信息!");
				return "input";
			}
			this.iPropertyAreaServices.addPropertyArea(inputArea);
		} catch (Exception e) {
			addActionMessage("请填写完整的信息!");
			return "input";
		}
		addActionMessage("新建成功!");
		this.updateArea = inputArea;
		return "update";
	}
	
	private PropertyArea updateArea;
	/**Area update
	 * @param updateArea
	 * */
	public String updateIndex(){
		try {
			updateArea = this.iPropertyAreaServices.findPropertyAreaById(updateArea.getId());
		} catch (Exception e) {
			addActionMessage("请选择正确的分区.");
			updateArea = new PropertyArea();
		}
		
		return "update";
	}
	public String updateForm(){
		if(updateArea.getId() == 0){
			return updateIndex();
		}
		PropertyArea tempArea = this.iPropertyAreaServices.findPropertyAreaById(updateArea.getId());
		tempArea.setRemark(updateArea.getRemark());
		tempArea.setAreaName(updateArea.getAreaName());
		tempArea.setModId(SessionUser.getUserId());
		tempArea.setModTime(new Date());
		iPropertyAreaServices.updatePropertyArea(tempArea);
		updateArea = tempArea;
		addActionMessage("修改成功!");
		return "update";
	}
	
	
	
	
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	public PropertyAreaCond getAreaCond() {
		return areaCond;
	}
	public void setAreaCond(PropertyAreaCond areaCond) {
		this.areaCond = areaCond;
	}
	public List<PropertyArea> getAreaList() {
		return areaList;
	}
	public void setAreaList(List<PropertyArea> areaList) {
		this.areaList = areaList;
	}
	public PropertyArea getInputArea() {
		return inputArea;
	}
	public void setInputArea(PropertyArea inputArea) {
		this.inputArea = inputArea;
	}
	public PropertyArea getUpdateArea() {
		return updateArea;
	}
	public void setUpdateArea(PropertyArea updateArea) {
		this.updateArea = updateArea;
	}
}
