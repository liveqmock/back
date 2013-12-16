package com.ihk.saleunit.action.new_unit_group;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.EnumSelectTypeSessionKey;
import com.ihk.property.data.pojo.PropertyBuild;
import com.ihk.property.data.pojo.PropertyBuildCond;
import com.ihk.property.data.pojo.PropertyGroup;
import com.ihk.property.data.pojo.PropertyGroupDetail;
import com.ihk.property.data.pojo.PropertyGroupDetailCond;
import com.ihk.property.data.services.IPropertyBuildServices;
import com.ihk.property.data.services.IPropertyGroupDetailServices;
import com.ihk.property.data.services.IPropertyGroupServices;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.utils.CommonPojoUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.MyTransationTemplate;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;

/**
 * 单元组团
 *
 */
public class UnitGroupAction extends SupperAction{
	private static final long serialVersionUID = 1L;
	@Autowired IPropertyGroupServices propertyGroupServices;
	@Autowired IPropertyGroupDetailServices propertyGroupDetailServices;
	
	@Autowired IPropertyUnitServices propertyUnitServices;
	@Autowired IPropertyBuildServices propertyBuildServices;
	
	private String unitIds;
	private int buildId;
	private int groupId;
	private int proId;
	private PropertyGroup unitGroup;
	private String buildIds;
	
	
	private List<PropertyBuild> addGroupBuilds;
	
	
	private int getProid(){
		String key = EnumSelectTypeSessionKey.Init.getValue();

		return (Integer)request.getSession().getAttribute(key);
	}
	
	/**
	 * 新建组团 弹窗
	 * @param proId 组团在那个项目下
	 * @return addGroupBuilds 项目下的所有build 
	 * */
	public String dialogAddUnitGroup(){
		PropertyBuildCond cond = new PropertyBuildCond();
		cond.setPropertyId(proId+"");
		addGroupBuilds = propertyBuildServices.findPropertyBuild(cond);
		return "suc";
	}
	
	/**
	 * 新建组团 弹窗 需要选择楼盘
	 * @return addGroupBuilds 项目下的所有build 
	 * */
	public String dialogAddUnitGroupSelPro(){
		PropertyBuildCond cond = new PropertyBuildCond();
		cond.setPropertyId(proId+"");
		addGroupBuilds = propertyBuildServices.findPropertyBuild(cond);
		return "suc";
	}
	
	public String getBuildByProject(){
		return "suc";
	}
	
	/**
	 * 新建组团的同时 给该组团添加明细  FORM
	 * @param unitGroup.groupName
	 * @param buildIds
	 * @param unitIds
	 * */
	public String dialogAddUnitGroupForm() throws IOException{//
		if(unitGroup.getGroupName() == null || unitGroup.getGroupName().equals("")){
			CustomerUtils.writeResponse(response,"名称不能为空" );
			return null;
		}
		
		try {
			new MyTransationTemplate() {
				
				@Override
				protected void doExecuteCallback() throws Exception {
					
					
					CommonPojoUtils.initPojoCommonFiled(unitGroup);
				
					unitGroup.setProjectId(proId);
					unitGroup.setChipType("2");
					//TODO 需要在界面添加 还没有完善
					propertyGroupServices.addPropertyGroup(unitGroup);
					PropertyGroupDetailCond cond = new PropertyGroupDetailCond();
					String[] buids;
					if(buildIds != null){
						buids = buildIds.split(",");
						cond = new PropertyGroupDetailCond();
						PropertyGroupDetail pojo = new PropertyGroupDetail();
						pojo.setCreatedId(getProid());
						pojo.setCreatedTime(new Date());
						pojo.setModId(getProid());
						pojo.setModTime(new Date());
						cond.setPojo(pojo);
						cond.setGroupId(unitGroup.getId()+"");
						if(buids!= null && buids.length > 0){
							for(String bid : buids){
								if(bid.trim().equals(""))continue;
								cond.setBuildId(Integer.parseInt(bid.trim())+"");
								propertyGroupDetailServices.addUnitByBuildId(cond);
							}
						}
					}
					
					
					
					List<Integer> ids = initIds(unitIds);
					if(ids != null && ids.size() > 0){
						cond.setIds(ids);
						propertyGroupDetailServices.addUnitByUnitIds(cond);
					}
					CustomerUtils.writeResponse(response,"操作成功" );
					
				}
			}.execute();
		} catch (Exception e1) {
			e1.printStackTrace();
			CustomerUtils.writeResponse(response,"操作失败" );
		}
		return null;
	}
	
	/**
	 * 修改所选组团名称-弹窗
	 * @param groupId
	 * @param unitGroup
	 * */
	public String dialogUpdateUnitGroup(){
		unitGroup = propertyGroupServices.findPropertyGroupById(groupId);
		if(unitGroup == null){
			addActionMessage("出现错误,请重新操作.");
		}
		return "suc";
	}
	
	/**
	 * 修改所选组团名称-form
	 * @param unitGroup.groupName
	 * @param groupId
	 * */
	public String dialogUpdateUnitGroupForm(){
		if(unitGroup == null || unitGroup.getGroupName() == null || unitGroup.getGroupName().trim().equals("")){
			addActionMessage("名称不能为空.");
			return "suc";
		}
		if(groupId == 0){
			addActionMessage("出现错误,请重新操作.");
			return "suc";
		}
		if(unitGroup.getIsDeleted().equals("1")){
			propertyGroupServices.deletePropertyGroup(groupId);
			addActionMessage("删除成功");
			return "suc";
		}
		
		PropertyGroup old = propertyGroupServices.findPropertyGroupById(groupId);
		old.setGroupName(unitGroup.getGroupName());
		old.setModId(getProid());
		old.setModTime(new Date());
		
		propertyGroupServices.updatePropertyGroup(old);
		unitGroup = old;
		addActionMessage("修改成功");
		return "suc";
	}
	
	/**根据 Ids 去重复之后添加group的单元
	 * @param unitIds
	 * @param groupId
	 * */
	public String addUnitByUnitIds(){
		PropertyGroupDetailCond cond = new PropertyGroupDetailCond();
		cond.setGroupId(groupId+"");
		cond.setIds(initIds (unitIds));
		PropertyGroupDetail pojo = new PropertyGroupDetail();
		pojo.setCreatedId(getProid());
		pojo.setCreatedTime(new Date());
		pojo.setModId(getProid());
		pojo.setModTime(new Date());
		cond.setPojo(pojo);
		propertyGroupDetailServices.addUnitByUnitIds(cond);
		return null;
	}
	
	/**
	 * 添加整个楼到GROUP
	 * @param groupid
	 * @param buildid
	 * */
	public String addAddUnitByBuildId(){
		PropertyGroupDetailCond cond = new PropertyGroupDetailCond();
		cond.setBuildId(buildId+"");
		cond.setGroupId(groupId+"");
		PropertyGroupDetail pojo = new PropertyGroupDetail();
		pojo.setCreatedId(getProid());
		pojo.setCreatedTime(new Date());
		pojo.setModId(getProid());
		pojo.setModTime(new Date());
		cond.setPojo(pojo);
		propertyGroupDetailServices.addUnitByBuildId(cond);
		return null;
	}
	
	/**
	 * 在GROUP中移除UNIT
	 * @param unitIds
	 * @param groupId
	 * */
	public String delGroupUnit(){
		List<Integer> gids = initIds (unitIds);
		PropertyGroupDetailCond cond = new PropertyGroupDetailCond();
		cond.setGroupId(groupId+"");
		if(gids != null){
			for(int h : gids){
				cond.setUnitId(h+"");
				propertyGroupDetailServices.deletePropertyGroupDetailByGroupIdAndUnitId(cond);
			}
		}
		return null;
	}
	
	
	/**
	 * 根据string 拿Integer List
	 * */
	private List<Integer> initIds (String initIds){
		
		if(initIds == null || initIds.trim().equals(""))return null;
		List<Integer> intIds = new ArrayList<Integer>();
		try {
			String[]  ids = initIds.split(",");
		
			for(String uid : ids){
				if(uid.trim().equals(""))continue;
				intIds.add(Integer.parseInt(uid.trim()));
			}
		} catch (Exception e) {
			return null;
		}
		return intIds;
	}

	
	
	
	
	
	public String getUnitIds() {
		return unitIds;
	}

	public void setUnitIds(String unitIds) {
		this.unitIds = unitIds;
	}

	public int getBuildId() {
		return buildId;
	}

	public void setBuildId(int buildId) {
		this.buildId = buildId;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}


	public int getProId() {
		return proId;
	}


	public void setProId(int proId) {
		this.proId = proId;
	}

	public PropertyGroup getUnitGroup() {
		return unitGroup;
	}

	public void setUnitGroup(PropertyGroup unitGroup) {
		this.unitGroup = unitGroup;
	}

	public List<PropertyBuild> getAddGroupBuilds() {
		return addGroupBuilds;
	}

	public void setAddGroupBuilds(List<PropertyBuild> addGroupBuilds) {
		this.addGroupBuilds = addGroupBuilds;
	}

	public String getBuildIds() {
		return buildIds;
	}

	public void setBuildIds(String buildIds) {
		this.buildIds = buildIds;
	}
	
	
	
	
	

}
