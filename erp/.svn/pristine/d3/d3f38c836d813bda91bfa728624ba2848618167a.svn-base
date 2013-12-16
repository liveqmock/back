package com.ihk.saleunit.action.chip;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.ContConfirmType;
import com.ihk.property.data.pojo.PropertyArea;
import com.ihk.property.data.pojo.PropertyBuild;
import com.ihk.property.data.pojo.PropertyProject;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.property.data.services.IPropertyAreaServices;
import com.ihk.property.data.services.IPropertyBuildServices;
import com.ihk.property.data.services.IPropertyProjectServices;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.saleunit.data.pojo.Chip;
import com.ihk.saleunit.data.services.IChipServices;
import com.ihk.user.data.services.ICompanyProjectServices;
import com.ihk.utils.ActionTemplate;
import com.ihk.utils.CommonPojoUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;
import com.ihk.utils.chip.ChipManagerUtils;
import com.ihk.utils.contract.customer.ContractCustomerUtils;
import com.ihk.utils.method.ActionAjaxMethodModifyCallback;

/**
 * easyui框架下的认筹
 * @author dtc
 * 2013-5-23,下午03:38:45
 */
public class EasyuiChipAction extends SupperAction{

	private static final long serialVersionUID = -3656595578732697889L;
	
	@Autowired
	IPropertyUnitServices unitServices;
	@Autowired
	IPropertyBuildServices buildServices;
	@Autowired
	IPropertyAreaServices areaServices;
	@Autowired
	IChipServices chipServices;
	@Autowired
	IPropertyProjectServices propertyProjectServices;
	@Autowired
	ICompanyProjectServices companyProjectServices;
	
	/**
	 * 跳到新增认筹的界面
	 * @return
	 * @throws Exception
	 */
	public String toCreateChipDialog() throws Exception{
		
		confirmType = ContConfirmType.CHIP;
		
		String type = request.getParameter("type");
		unit = unitServices.findPropertyUnitById(Integer.parseInt(request.getParameter("unitId")));
		if("build".equals(type)){
			build = buildServices.findPropertyBuildById(unit.getBuildId());
			typeId = build.getId();
		}else if("area".equals(type)){
			area = areaServices.findPropertyAreaById(buildServices.findPropertyBuildById(unit.getBuildId()).getAreaId());
			typeId = area.getId();
		}else{
			project = propertyProjectServices.findPropertyProjectById(areaServices.findPropertyAreaById(buildServices.findPropertyBuildById(unit.getBuildId()).getAreaId()).getPropertyId());
			typeId = project.getId();
		}
		this.type = type;
		return "toCreateChipDialog";
	}
	
	/**
	 * 跳到修改认筹的界面
	 * @return
	 * @throws Exception
	 */
	public String toModifyChipDialog() throws Exception{
		
		confirmType = ContConfirmType.CHIP;
		
		String id = request.getParameter("id");
		chip = chipServices.findChipById(Integer.valueOf(id));
		String type = request.getParameter("type");
		unit = unitServices.findPropertyUnitById(Integer.parseInt(request.getParameter("unitId")));
		if("build".equals(type)){
			build = buildServices.findPropertyBuildById(unit.getBuildId());
			typeId = build.getId();
		}else if("area".equals(type)){
			area = areaServices.findPropertyAreaById(buildServices.findPropertyBuildById(unit.getBuildId()).getAreaId());
			typeId = area.getId();
		}else{
			project = propertyProjectServices.findPropertyProjectById(areaServices.findPropertyAreaById(buildServices.findPropertyBuildById(unit.getBuildId()).getAreaId()).getPropertyId());
			typeId = project.getId();
		}
		this.type = type;
		
		return "toModifyChipDialog";
	}
	
	/**
	 * 新增认筹
	 * @return
	 * @throws Exception
	 */
	public String addChip() throws Exception{
		
		ActionTemplate.executeAjaxMethod(true, this, new ActionAjaxMethodModifyCallback() {
			
			@Override
			public void modifyMethod() throws Exception {
				
				//先判断该筹单号是否合法
				boolean isAccord = ChipManagerUtils.isChipNoAccord(chip);
				if(!isAccord)
					throw new Exception("该项目下该筹单号已经存在");
				
				chip.setIsVoid(CommonUtils.NORMAL);
				chip.setVoidTime(new Date());
				
				chip.setUserId(SessionUser.getUserId());
				chip.setCompanyProjectId(unitServices.findPropertyUnitById(chip.getUnitId1()).getCompanyProjectId()); //设置对应的项目id
				
				//设置对应的楼盘项目id
				int proProjectId = propertyProjectServices.findPropertyProjectIdByUnitId(chip.getUnitId1());
				chip.setPropertyProjectId(proProjectId);
				
				CommonPojoUtils.initPojoCommonFiled(chip);
				
				//设置对应单元的认筹数量及单元状态
				ChipManagerUtils.setUnitChipByChip(chip);
				
				chipServices.addChip(chip);
				
				//设置客户mainId
				String customerId = request.getParameter("customerId");
				ContractCustomerUtils.setUpContractCustomerMainId(customerId, chip.getId());
				
			}
			
			@Override
			public void modifyMethodException(Exception e) {
				setUpEasyuiAjaxForFail(e.getMessage());
			}
		});
		
		return null;
	}
	
	
	public String modifyChip() {
		ActionTemplate.executeAjaxMethod(true, this, new ActionAjaxMethodModifyCallback() {
			
			@Override
			public void modifyMethod() throws Exception {
				
				//先判断该筹单号是否合法
//				boolean isAccord = ChipManagerUtils.isChipNoAccord(chip);
//				if(!isAccord)
//					throw new Exception("该项目下该筹单号已经存在");
				
				chip.setIsVoid(CommonUtils.NORMAL);
				chip.setVoidTime(new Date());
				
				chip.setUserId(SessionUser.getUserId());
				chip.setCompanyProjectId(unitServices.findPropertyUnitById(chip.getUnitId1()).getCompanyProjectId()); //设置对应的项目id
				
				//设置对应的楼盘项目id
				int proProjectId = propertyProjectServices.findPropertyProjectIdByUnitId(chip.getUnitId1());
				chip.setPropertyProjectId(proProjectId);
				
				CommonPojoUtils.initPojoCommonFiled(chip);
				
				Chip srcChip = chipServices.findChipById(chip.getId());
				//设置对应单元的认筹数量及单元状态
				ChipManagerUtils.setUnitChipByChipForModify(srcChip,chip);
				
				
				
				chipServices.updateChip(chip);
				
				//设置客户mainId
				String customerId = request.getParameter("customerId");
				ContractCustomerUtils.setUpContractCustomerMainId(customerId, chip.getId());
				
			}
			
			@Override
			public void modifyMethodException(Exception e) {
				setUpEasyuiAjaxForFail(e.getMessage());
			}
		});
		
		return null;

	}
	
	////
	/**
	 * 客户类型
	 */
	private String confirmType;
	
	/**
	 * 认筹类型
	 */
	private String chipType;
	
	private PropertyUnit unit;
	
	private PropertyBuild build;
	
	private PropertyArea area;
	
	private PropertyProject project;
	
	private int typeId;
	
	private String type;
	
	private Chip chip;
	
	
	
	public void setChipType(String chipType) {
		this.chipType = chipType;
	}
	
	public String getChipType() {
		return chipType;
	}
	
	public void setChip(Chip chip) {
		this.chip = chip;
	}
	
	public Chip getChip() {
		return chip;
	}
	
	public void setUnit(PropertyUnit unit) {
		this.unit = unit;
	}
	
	public PropertyUnit getUnit() {
		return unit;
	}
	
	public void setConfirmType(String confirmType) {
		this.confirmType = confirmType;
	}
	
	public String getConfirmType() {
		return confirmType;
	}

	public PropertyBuild getBuild() {
		return build;
	}

	public void setBuild(PropertyBuild build) {
		this.build = build;
	}

	public PropertyArea getArea() {
		return area;
	}

	public void setArea(PropertyArea area) {
		this.area = area;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public PropertyProject getProject() {
		return project;
	}

	public void setProject(PropertyProject project) {
		this.project = project;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
