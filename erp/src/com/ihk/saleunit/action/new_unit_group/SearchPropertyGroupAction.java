package com.ihk.saleunit.action.new_unit_group;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.EnumSelectTypeSessionKey;
import com.ihk.property.data.pojo.PropertyGroup;
import com.ihk.property.data.pojo.PropertyGroupCond;
import com.ihk.property.data.pojo.PropertyProject;
import com.ihk.property.data.services.IPropertyGroupServices;
import com.ihk.property.data.services.IPropertyProjectServices;
import com.ihk.utils.AJAXBeanUtils;
import com.ihk.utils.AJAXUtils;
import com.ihk.utils.ActionPageCallback;
import com.ihk.utils.ActionTemplate;
import com.ihk.utils.CommonPojoUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.MyTransationTemplate;
import com.ihk.utils.SupperAction;
import com.ihk.utils.saleunitnew.JsonUtils;

/**
 * 查找组团
 * 
 */
public class SearchPropertyGroupAction extends SupperAction {

	private static final long serialVersionUID = 1L;
	
	@Autowired IPropertyGroupServices propertyGroupServices;  
	
	@Autowired IPropertyProjectServices propertyProjectServices;
    
	private PropertyGroupCond searchPropertyGroupCond;  
    
	public PropertyGroupCond getSearchPropertyGroupCond() {
		return searchPropertyGroupCond;
	}

	public void setSearchPropertyGroupCond(PropertyGroupCond searchPropertyGroupCond) {
		this.searchPropertyGroupCond = searchPropertyGroupCond;
	}
    
	private List<PropertyGroup> searchListPropertyGroup;
    
	public List<PropertyGroup> getSearchListPropertyGroup() {		
		return searchListPropertyGroup;
	}

	public void setSearchListPropertyGroupList(List<PropertyGroup> searchListPropertyGroup) {
		this.searchListPropertyGroup = searchListPropertyGroup;
	}
      
    //新建页面用于保存页面数据的对象
	private PropertyGroup createPropertyGroup;  
    
	public PropertyGroup getCreatePropertyGroup() {
		return createPropertyGroup;
	}

	public void setCreatePropertyGroup(PropertyGroup createPropertyGroup) {
		this.createPropertyGroup = createPropertyGroup;
	}
      
	
    //编辑页面用于保存页面数据的对象
	private PropertyGroup editPropertyGroup;  
    
	public PropertyGroup getEditPropertyGroup() {
		return editPropertyGroup;
	}

	public void setEditPropertyGroup(PropertyGroup editPropertyGroup) {
		this.editPropertyGroup = editPropertyGroup;
	}
		
	private int getProid(){
		String key = EnumSelectTypeSessionKey.Group.getValue();

		return (Integer)request.getSession().getAttribute(key);
	}
	
    /**
    * 执行查询
    */
	public String searchPropertyGroup() throws Exception{		
		
		if(searchPropertyGroupCond == null){ 
			searchPropertyGroupCond = new PropertyGroupCond();	

		//	searchPropertyGroupCond.setDate1(CommonUtils.getMonthFirstForString());
		//	searchPropertyGroupCond.setDate2(CommonUtils.getMonthEndForString());
		}
		searchPropertyGroupCond.setCompanyProject(getProid());
		
		ActionTemplate actionTemplate = new ActionTemplate(this, searchPropertyGroupCond);
		actionTemplate.executePage(new ActionPageCallback() {
		
			@Override
			public void initActionPageList() {

				searchListPropertyGroup = propertyGroupServices.findPropertyGroupPage(searchPropertyGroupCond);	
			}
			
		}, 20);
		
		try {
			initSel();
		} catch (Exception e) {
			CustomerUtils.writeResponse(response, "请先新建楼盘,不然无法使用组团功能");
		}
		
		return "finish";
	}
	
	private HashMap<String, String> propertyProjectSel; //楼盘项目下拉
	public HashMap<String, String> getPropertyProjectSel() {
		return propertyProjectSel;
	}
	public void setPropertyProjectSel(HashMap<String, String> propertyProjectSel) {
		this.propertyProjectSel = propertyProjectSel;
	}
	/**
	 * 查询页面需要信息初始化
	 * */
	private void initSel() throws Exception{
		propertyProjectSel = new HashMap<String, String>();
		List<PropertyProject> prolist = JsonUtils.roleProlist();
		if(prolist.size() == 0)throw new Exception();
		
		for(PropertyProject p : prolist){
			String key = p.getId()+"";
			String value = p.getPropertyName();
			propertyProjectSel.put(key,value);
		}
	}
	
	/**
	 * ajax新增组团
	 * @return
	 * @throws Exception
	 */
	public String ajaxCreatePropertyGroup() throws Exception{
		
        //信息提示
		final Map<String, String> mapMassage = new HashMap<String, String>();
		
		try{			
			new MyTransationTemplate() {
				
				@Override
				protected void doExecuteCallback() throws Exception {
					//新增前的一些数据处理	
					if(createPropertyGroup.getGroupName() == null || createPropertyGroup.getGroupName().trim().equals("")
						|| createPropertyGroup.getChipType() == null || createPropertyGroup.getChipType().trim().equals("")
						|| createPropertyGroup.getProjectId() == 0){
						throw new Exception();
					}
					if(!createPropertyGroup.getGroupName().matches("^[\u4E00-\u9FA5]*$")){
						throw new Exception();
					}
					createPropertyGroup.setCompanyProject(getProid());
					//预处理表中的创建人信息
					CommonPojoUtils.initPojoCommonFiled(createPropertyGroup);
										
					propertyGroupServices.addPropertyGroup(createPropertyGroup);
					
					mapMassage.put("type", "true");
					mapMassage.put("message", createPropertyGroup.getId()+"");
					
				}
			}.execute();
			
		}catch(Exception e){
			mapMassage.put("type", "false");
			//mapMassage.put("message", e.getMessage());
			mapMassage.put("message", "组团名称必填且只能含中文");
			e.printStackTrace();
		}
		
		CustomerUtils.writeResponse(response, CommonUtils.getMapJson(mapMassage));
		
		return null;
	}
    
    
	/**
	 * 取得PropertyGroup用于编辑页面 的ajax
	 * @return
	 * @throws Exception
	 */
	public String ajaxGetPropertyGroupById() throws Exception{
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		editPropertyGroup = propertyGroupServices.findPropertyGroupById(id); 
		
		if(editPropertyGroup == null){			
			
			CustomerUtils.writeResponse(response, "");
		}else{
			//输出json数据
			AJAXUtils.writeResponse(response, AJAXBeanUtils.getJsonPropertyGroup(editPropertyGroup));
		}
		
		return null; 
	}
    
    
	/**
	 * 修改组团ajax方法
	 * @return
	 * @throws Exception
	 */
	public String ajaxUpdatePropertyGroup() throws Exception{
		
		final Map<String, String> mapMessage = new HashMap<String, String>();
		
		try{
			
			new MyTransationTemplate() {
				
				@Override
				protected void doExecuteCallback() throws Exception {
					
					PropertyGroup oldPropertyGroup = propertyGroupServices.findPropertyGroupById(editPropertyGroup.getId());
					
					CommonPojoUtils.initPojoForUpdate(oldPropertyGroup, editPropertyGroup);					

                    
					//editPropertyGroup.setChipNo(oldChip.getChipNo());
					//editPropertyGroup.setChipType(oldChip.getChipType());	
					//oldPropertyGroup.setProjectId(editPropertyGroup.getProjectId());
					oldPropertyGroup.setChipType(editPropertyGroup.getChipType());
					oldPropertyGroup.setRemark(editPropertyGroup.getRemark());
					oldPropertyGroup.setGroupName(editPropertyGroup.getGroupName());
					propertyGroupServices.updatePropertyGroup(oldPropertyGroup);
					
					mapMessage.put("type", "true");
					
				}
			}.execute();
			
		}catch(Exception e){
			
			mapMessage.put("type", "false");
			mapMessage.put("message", e.getMessage());
			e.printStackTrace();
		}
		
		CustomerUtils.writeResponse(response, CommonUtils.getMapJson(mapMessage));
		
		return null;
	}
	
	
	
}
