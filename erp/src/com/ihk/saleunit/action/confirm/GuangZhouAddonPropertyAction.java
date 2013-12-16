package com.ihk.saleunit.action.confirm;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.ContConfirmType;
import com.ihk.property.data.pojo.PropertyBuild;
import com.ihk.property.data.pojo.PropertyProject;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.saleunit.data.pojo.AddonProperty;
import com.ihk.saleunit.data.pojo.AddonPropertyCond;
import com.ihk.saleunit.data.pojo.Confirm;
import com.ihk.saleunit.data.services.IAddonPropertyServices;
import com.ihk.saleunit.data.services.IConfirmServices;
import com.ihk.utils.ActionPageCallback;
import com.ihk.utils.ActionTemplate;
import com.ihk.utils.CommonPojoUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.SupperAction;

/**
 *  附属房产
 */
public class GuangZhouAddonPropertyAction extends SupperAction {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	IAddonPropertyServices addonPropertyServices;
	@Autowired
	IConfirmServices confirmServices;
	
	public String search() throws Exception{
		
		String confirmId = request.getParameter("confirmId");
		confirm = confirmServices.findConfirmById(Integer.parseInt(confirmId));
		
		final AddonPropertyCond cond = new AddonPropertyCond();
		cond.setConfirmType(ContConfirmType.CONFIRM);
		cond.setMainId(confirmId);
		
		ActionTemplate actionTemplate = new ActionTemplate(this, cond);
		actionTemplate.executePage(new ActionPageCallback() {
			
			@Override
			public void initActionPageList() {
				
				addList = addonPropertyServices.findAddonProperty(cond);
				
			}
		});
		
		return "search";
	}
	
	public String input() throws Exception{
		
		String out = "";
		
		try{
			
			addProperty.setConfirmType(ContConfirmType.CONFIRM);
			CommonPojoUtils.initPojoCommonFiled(addProperty);
			
			addonPropertyServices.addAddonProperty(addProperty);
			
			out = addProperty.getId() + "";
			
		}catch(Exception e){
		}
		
		CustomerUtils.writeResponse(response, out);
		
		return null;
	}
	
	public String getId() throws Exception {
		
		int id = Integer.parseInt(request.getParameter("addPropertyId"));
		
		addProperty = addonPropertyServices.findAddonPropertyById(id);
		
		String out = getJsonDataByAddonProperty(addProperty);
		
		CustomerUtils.writeResponse(response, out);
		
		return null;
	}
	
	public String update() throws Exception {
		
		AddonProperty oldAddProperty = addonPropertyServices.findAddonPropertyById(addProperty.getId());
		
		CommonPojoUtils.initPojoForUpdate(oldAddProperty, addProperty);
		addProperty.setConfirmType(oldAddProperty.getConfirmType());
		addProperty.setMainId(oldAddProperty.getMainId());
		
		String out = "";
		
		try{
			
			addonPropertyServices.updateAddonProperty(addProperty);
			out = getJsonDataByAddonProperty(addProperty, true);
			
		}catch(Exception e){
			
			out = getJsonDataByAddonProperty(oldAddProperty);
		}
		
		CustomerUtils.writeResponse(response, out);
		
		return null;
	}
	
	
	private String getJsonDataByAddonProperty(AddonProperty addProperty) throws IOException{
		
		return getJsonDataByAddonProperty(addProperty, false);
		
	}
	
	private String getJsonDataByAddonProperty(AddonProperty addProperty, boolean isSucc) throws IOException{
		
		if(addProperty == null)
			return "{}";
		
		PropertyUnit unit = addProperty.getUnit();
		PropertyBuild build = addProperty.getBuild();
		PropertyProject project = addProperty.getProject();
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("addPropertyName", project.getPropertyName());
		map.put("addPropertyHiddenId", project.getId()+"");
		map.put("addBuildName", build.getBuildName());
		map.put("addBulidHiddenId", build.getId()+"");
		map.put("addUnitName", unit.getUnitNo());
		map.put("addUnitHiddenId", unit.getId()+"");
		
		if(isSucc){
			map.put("isSucc", "true");
		}
		
		String data = CommonUtils.getMapJson(map);
		
		return data;
	}
	
	
	///
	private List<AddonProperty> addList;
	private Confirm confirm;
	
	private AddonProperty addProperty;
	
	public void setAddProperty(AddonProperty addProperty) {
		this.addProperty = addProperty;
	}
	
	public AddonProperty getAddProperty() {
		return addProperty;
	}
	
	public void setConfirm(Confirm confirm) {
		this.confirm = confirm;
	}
	
	public Confirm getConfirm() {
		return confirm;
	}
	
	public void setAddList(List<AddonProperty> addList) {
		this.addList = addList;
	}
	
	public List<AddonProperty> getAddList() {
		return addList;
	}
	
	
	
	

}
