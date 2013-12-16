package com.ihk.saleunit.action.chip;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.EnumCodeTypeName;
import com.ihk.property.data.pojo.PropertyArea;
import com.ihk.property.data.pojo.PropertyBuild;
import com.ihk.property.data.pojo.PropertyGroup;
import com.ihk.property.data.services.IPropertyAreaServices;
import com.ihk.property.data.services.IPropertyBuildServices;
import com.ihk.property.data.services.IPropertyGroupServices;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.saleunit.data.pojo.Chip;
import com.ihk.saleunit.data.pojo.ChipCond;
import com.ihk.saleunit.data.services.IChipServices;
import com.ihk.saleunit.data.services.IContractCustomerServices;
import com.ihk.utils.ActionPageCallback;
import com.ihk.utils.ActionTemplate;
import com.ihk.utils.CommonPojoUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.MyTransationTemplate;
import com.ihk.utils.SupperAction;
import com.ihk.utils.chip.ChipManagerUtils;
import com.ihk.utils.chip.ChipTypeUtils;
import com.ihk.utils.saleunitnew.DefaultFromPropertyUtils;

/**
 * 查询认筹
 * 2012-8-27
 */
@SuppressWarnings("rawtypes")
public class SearchChipAction extends SupperAction {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	IChipServices chipServices;  
	@Autowired
	IPropertyUnitServices proerptyUnitServices; 
	@Autowired
	IContractCustomerServices contractCustomerServices; 	
	@Autowired
	IPropertyBuildServices buildServices;
	@Autowired
	IPropertyAreaServices areaServices;
	@Autowired
	IPropertyGroupServices groupServices;

	/**
	 * 默认加载的方法,主要获取默认选中的build认筹类型	  
	 * @return 
	 * 已选择==&gt;&nbsp;&nbsp;哈哈哈,aaa,vvvv<input id='changeHiddenBuildId' type='hidden' value='19'/>
	 * @throws Exception
	 */
	public String getDefaultLoadForSearch() throws Exception{
		
		Map<String, String> map = new HashMap<String, String>();
		
		try{
		
			StringBuffer sb = new StringBuffer();
			
			int propertyId = Integer.parseInt(request.getParameter("propertyId"));
			
			PropertyBuild build = DefaultFromPropertyUtils.getDefaultBuild(propertyId);
			
			if(build != null){
				
				sb.append("已选择==&gt;&nbsp;&nbsp;")
					.append(build.getDescPropertyId()).append(",")
					.append(build.getAreaName()).append(",")
					.append(build.getBuildName())
					.append("<input id='changeHiddenBuildId' type='hidden' value='").append(build.getId()).append("'/>")
					;
				
			}
			
			//如果sb为空,应该回传一个&nbsp;
			String out = sb.toString();
			if(CommonUtils.isStrEmpty(out)){
				out = "&nbsp;";
			}
			
			map.put("showChangeId", out);
			
		}catch (Exception e) {
		}
		
		CustomerUtils.writeResponse(response, CommonUtils.getMapJson(map));
		
		return null;
	}
		
	/**
	 * 查找筹单
	 * @return
	 * @throws Exception
	 */
	public String searchChip() throws Exception{		
		
		if(chipCond == null){ 
			chipCond = new ChipCond();	

			chipCond.setDate1(CommonUtils.getMonthFirstForString());
			chipCond.setDate2(CommonUtils.getMonthEndForString());
		}
//		if(chipCond.getProjectId()==0){
//			chipList = null;
//		}
		//chipCond.setProjectId(SessionUser.getProjectId());
		else{
			ActionTemplate actionTemplate = new ActionTemplate(this, chipCond);
			actionTemplate.executePage(new ActionPageCallback() {
			
				@Override
				public void initActionPageList() {
					//List<PropertyUnit> puList = proerptyUnitServices.findPropertyUnit(new PropertyUnitCond().setBuildId(chipCond.getBuildId()));
					chipList = chipServices.findChipPage(chipCond);	
				}
				
			}, 20);
			
			initSel();
		}
		
		
		return "success";
	}
	
	/**
	 * 获取筹单类型,(2031.5.23,并返回对应楼栋或组团中的一个合法单元id,用于新建客户)
	 * @return
	 * @throws Exception
	 * chipTypeId 认筹类型:1 ,2
	 * chipTypeName 认筹名称:AB筹, 普通筹
	 */
	public String getChipTypeForAddChip() throws Exception{
		
		Map<String, String> map = new HashMap<String, String>();
		
		try{
		
			String idType = request.getParameter("idType");
			int id = Integer.parseInt(request.getParameter("id"));
			PropertyBuild build = buildServices.findPropertyBuildById(id);
			if("build".equals(idType)){
				map.put("chipTypeId", build.getChipType());
				map.put("chipTypeName", ChipTypeUtils.getChipTypeDescByChipType(build.getChipType()));
				map.put("type", idType);
				map.put("unitId", proerptyUnitServices.findLastModifyUnitByBuildId(id).getId() + "");
				
			}else if("group".equals(idType)){
				
				PropertyGroup group = groupServices.findPropertyGroupById(id);
				map.put("chipTypeId", group.getChipType());
				map.put("chipTypeName", ChipTypeUtils.getChipTypeDescByChipType(group.getChipType()));
				
			}else if("area".equals(idType)){
				
				
				map.put("chipTypeId", build.getChipType());
				map.put("chipTypeName", ChipTypeUtils.getChipTypeDescByChipType(build.getChipType()));
				map.put("type", idType);
				map.put("unitId", proerptyUnitServices.findLastModifyUnitByAreaId(id).getId() + "");
				
			}else if("project".equals(idType)){
				map.put("chipTypeId", build.getChipType());
				map.put("chipTypeName", ChipTypeUtils.getChipTypeDescByChipType(build.getChipType()));
				map.put("type", idType);
				map.put("unitId", proerptyUnitServices.findLastModifyUnitByProjectId(id).getId() + "");
			}
		}catch(Exception e){
		}
		
		CustomerUtils.writeResponse(response, CommonUtils.getMapJson(map));
		
		return null;
	}
	
	private void initSel(){
		
		selCustomerGender = DescUtils.getInitSelEmptyAndGender(selCustomerGender);
		selCustomerIdCardType = DescUtils.getInitSelForGuangZhou(selCustomerIdCardType, EnumCodeTypeName.SALEUNIT_IDCARD_TYPE, true);
		
	}
	
	/**
	 * 取得chip用于编辑页面 的ajax
	 * @return
	 * @throws Exception
	 */
	public String ajaxGetChipById() throws Exception{
		
		int chipId = Integer.parseInt(request.getParameter("id"));
		
		editChip = chipServices.findChipById(chipId); 
		
		if(editChip == null){			
			
			CustomerUtils.writeResponse(response, "");
		}else{
			
			CustomerUtils.writeResponse(response, ChipManagerUtils.getAjaxJson_Chip(editChip,"editChip."));
		}
		
		return null; 
	}
	
	/**
	 * 修改认筹
	 * @return
	 * @throws Exception
	 */
	public String updateChip() throws Exception{
		
		final Map<String, String> map = new HashMap<String, String>();
		
		try{
			
			new MyTransationTemplate() {
				
				@Override
				protected void doExecuteCallback() throws Exception {
					
					Chip oldChip = chipServices.findChipById(editChip.getId());
					
					CommonPojoUtils.initPojoForUpdate(oldChip, editChip);					

					editChip.setChipNo(oldChip.getChipNo());
					editChip.setChipType(oldChip.getChipType());
					editChip.setCustomerId(oldChip.getCustomerId());
					
					editChip.setCompanyProjectId(oldChip.getCompanyProjectId());
					editChip.setIsVoid(oldChip.getIsVoid());
					editChip.setVoidTime(oldChip.getVoidTime());
					
					//设置对应单元的认筹数量
					ChipManagerUtils.setUnitChipByChip(oldChip, editChip);
					
					chipServices.updateChip(editChip);
					
					map.put("type", "true");
					
				}
			}.execute();
			
		}catch(Exception e){
			
			map.put("type", "false");
			map.put("message", e.getMessage());
			e.printStackTrace();
		}
		
		CustomerUtils.writeResponse(response, CommonUtils.getMapJson(map));
		
		return null;
	}
	
	////
	
	/**
	 * 新建客户,性别
	 */
	private LinkedHashMap selCustomerGender; //新建客户,性别
	
	/**
	 * 新建客户,证件类型
	 */
	private LinkedHashMap selCustomerIdCardType; //新建客户,证件类型
	
	private List<Chip> chipList;
	private ChipCond chipCond;  
	
	public LinkedHashMap getSelCustomerGender() {
		return selCustomerGender;
	}

	public void setSelCustomerGender(LinkedHashMap selCustomerGender) {
		this.selCustomerGender = selCustomerGender;
	}

	public LinkedHashMap getSelCustomerIdCardType() {
		return selCustomerIdCardType;
	}

	public void setSelCustomerIdCardType(LinkedHashMap selCustomerIdCardType) {
		this.selCustomerIdCardType = selCustomerIdCardType;
	}

	public List<Chip> getChipList() {		
		return chipList;
	}

	public void setChipList(List<Chip> chipList) {
		this.chipList = chipList;
	}

	public ChipCond getChipCond() {
		return chipCond;
	}

	public void setChipCond(ChipCond chipCond) {
		this.chipCond = chipCond;
	}
	
	private Chip editChip;

	public Chip getEditChip() {
		return editChip;
	}

	public void setEditChip(Chip editChip) {
		this.editChip = editChip;
	}
	
}
