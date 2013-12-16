package com.ihk.saleunit.action.discount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.ContUnitComputeWay;
import com.ihk.constanttype.EnumCodeTypeName;
import com.ihk.property.data.pojo.ProjectDiscount;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.property.data.services.IProjectDiscountServices;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.saleunit.data.pojo.ConfirmDiscount;
import com.ihk.saleunit.data.pojo.UnitDiscount;
import com.ihk.saleunit.data.pojo.UnitDiscountDetail;
import com.ihk.saleunit.data.services.IConfirmDiscountServices;
import com.ihk.saleunit.data.services.IUnitDiscountDetailServices;
import com.ihk.saleunit.data.services.IUnitDiscountServices;
import com.ihk.utils.CommonPojoUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.MyTransationTemplate;
import com.ihk.utils.SupperAction;
import com.ihk.utils.saleunitnew.DiscountManagerUtils;

/**
 * 项目折扣(使用)
 * @author dtc
 * 2012-10-29,下午05:56:14
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public class ProjectDiscountManager extends SupperAction{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	IPropertyUnitServices unitServices;
	@Autowired
	IUnitDiscountServices unitDiscountServices;
	@Autowired
	IUnitDiscountDetailServices discountDetailServices;
	@Autowired
	IConfirmDiscountServices confirmDiscountServices;
	@Autowired
	IProjectDiscountServices projectDiscountServices;
	
	/**
	 * 跳到新增项目折扣界面
	 * @return
	 * @throws Exception
	 */
	public String createProjectDiscountDialog() throws Exception{
		
		init();
		
		return "createProjectDiscountDialog";
	}
	
	/**
	 * 增加项目折扣
	 * @return
	 * @throws Exception
	 */
	public String createProjectDiscount() throws Exception{
		
		try{
		
			new MyTransationTemplate() {
				
				@Override
				protected void doExecuteCallback() throws Exception {
					
					String someDetail = request.getParameter("someDetail");
					
					//增加单元折扣unit_discount
					CommonPojoUtils.initPojoCommonFiled(unitDiscount);
					unitDiscount.setDiscountName(DiscountManagerUtils.getDiscountNameAndProjectDiscountId(someDetail, projectDiscountId));
					unitDiscountServices.addUnitDiscount(unitDiscount);
					
					//增加单元折扣详细unit_discount_detail
					if(!CommonUtils.isStrEmpty(someDetail)){
						
						List<UnitDiscountDetail> tmpList = DiscountManagerUtils.initForAddDiscountDetail(someDetail, unitDiscount.getId());
						for(UnitDiscountDetail detail : tmpList){
							
							discountDetailServices.addUnitDiscountDetail(detail);
						}
						
					}
					
					//增加认购合同单的完整折扣confirm_discount
					//if(projectDiscountId != null && projectDiscountId.length > 0){
					if(!CommonUtils.isCollectionEmpty(projectDiscountId)){
						
						for(int proDiscountId : projectDiscountId){
							
							ConfirmDiscount confirmDiscount = new ConfirmDiscount();
							
							confirmDiscount.setUnitDiscountId(unitDiscount.getId());
							confirmDiscount.setProjectDiscountId(proDiscountId);
							CommonPojoUtils.initPojoCommonFiled(confirmDiscount);
							
							confirmDiscountServices.addConfirmDiscount(confirmDiscount);
						}
					}
					
					unitDiscountId = unitDiscount.getId() + "";
					
				}
			}.execute();
			
		}catch (Exception e) {
			
			unitDiscountId = "0";
		}
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("unitDiscountId", unitDiscountId);
		String out = CommonUtils.getMapJson(map);
		
		CustomerUtils.writeResponse(response, out);
		
		return null;
	}
	
	/**
	 * 关闭项目折扣,获取设置显示的值
	 * @return
	 * @throws Exception
	 */
	public String getProjectDiscountManagerCloseShowByDiscountId() throws Exception{
		
		Map<String, String> map = DiscountManagerUtils.getProjectDiscountManagerCloseShowAndMultiplyByDiscountId(request);
		
		CustomerUtils.writeResponse(response, CommonUtils.getMapJson(map));
		
		return null;
	}
	
	/**
	 * 根据单元折扣id获取对应的detail
	 * @return
	 * @throws Exception
	 */
	public String getUnitDiscountDetailByDiscountId() throws Exception{
		
		if(CommonUtils.isStrZeroEmpty(unitDiscountId) || "null".equals(unitDiscountId)){
			
			CustomerUtils.writeResponse(response, "[]");
			return null;
		}
		
		List<UnitDiscountDetail> detailList = discountDetailServices.findDetailByDiscountId(Integer.parseInt(unitDiscountId));
		
		String out = DiscountManagerUtils.discountDetailListJson(detailList);
		
		CustomerUtils.writeResponse(response, out);
		
		return null;
	}
	
	/**
	 * 跳到更新界面
	 * @return
	 * @throws Exception
	 */
	public String createUpdateProjectDiscountDialog() throws Exception{
		
		init();
		
		return "createUpdateProjectDiscountDialog";
	}
	
	/**
	 * 修改项目折扣
	 * @return
	 * @throws Exception
	 */
	public String updateProjectDiscount() throws Exception{
		
		try{
		
			new MyTransationTemplate() {
				
				@Override
				protected void doExecuteCallback() throws Exception {
					
					String someDetail = request.getParameter("someDetail");
					
					//修改单元折扣unit_discount
					UnitDiscount oldUnitDiscount = unitDiscountServices.findUnitDiscountById(unitDiscount.getId());
					unitDiscount.setDiscountName(DiscountManagerUtils.getDiscountNameAndProjectDiscountId(someDetail, projectDiscountId));
					CommonPojoUtils.initPojoForUpdate(oldUnitDiscount, unitDiscount);
					unitDiscountServices.updateUnitDiscount(unitDiscount);
					
					//修改单元折扣详细unit_discount_detail
					discountDetailServices.deleteUnitDiscountDetailByDiscountId(unitDiscount.getId());
					if(!CommonUtils.isStrEmpty(someDetail)){
						
						List<UnitDiscountDetail> tmpList = DiscountManagerUtils.initForAddDiscountDetail(someDetail, unitDiscount.getId());
						for(UnitDiscountDetail detail : tmpList){
							
							discountDetailServices.addUnitDiscountDetail(detail);
						}
						
					}
					
					//修改认购合同单的完整折扣confirm_discount
					confirmDiscountServices.deleteConfirmDiscountByUnitDiscountId(unitDiscount.getId());
					if(projectDiscountId != null && projectDiscountId.length > 0){
						
						for(int proDiscountId : projectDiscountId){
							
							ConfirmDiscount confirmDiscount = new ConfirmDiscount();
							
							confirmDiscount.setUnitDiscountId(unitDiscount.getId());
							confirmDiscount.setProjectDiscountId(proDiscountId);
							CommonPojoUtils.initPojoCommonFiled(confirmDiscount);
							
							confirmDiscountServices.addConfirmDiscount(confirmDiscount);
						}
					}
					
					unitDiscountId = unitDiscount.getId() + "";
					
				}
			}.execute();
			
		}catch (Exception e) {
			
			unitDiscountId = "0";
		}
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("unitDiscountId", unitDiscountId);
		String out = CommonUtils.getMapJson(map);
		
		CustomerUtils.writeResponse(response, out);
		
		return null;
	}
	
	/**
	 * 初始化方法
	 * 新建的时候页面传过来的参数包括:unitId,mainId,confirmType
	 * 更新的时候页面传过来的参数包括:unitDiscountId
	 */
	private void init(){
		
		selTypes = DescUtils.getInitSelForGuangZhou(selTypes, EnumCodeTypeName.SALEUNIT_DISCOUNT_TYPE);
		types = CommonUtils.getMapJsonSetUpKeyAndValueName(selTypes, "typeId", "name");
		
		selComputeWay = ContUnitComputeWay.getWayMap();
		
		int unitId = 0;
		changeProjectDiscountIdList = new ArrayList<String>();
		
		//说明为新建
		if(!isUpdate()){
			
			unitDiscount = new UnitDiscount();
			
			String mainId = request.getParameter("mainId");
			String confirmType = request.getParameter("confirmType");
			
			if(!CommonUtils.isIntString(mainId)){
				mainId = "0";
			}
			
			if(!CommonUtils.isIntString(confirmType)){
				confirmType = "0";
			}
			
			unitDiscount.setMainId(Integer.parseInt(mainId));
			unitDiscount.setConfirmType(confirmType);
			
			unitId = Integer.parseInt(request.getParameter("unitId"));
			
			url = "./project_discount/manager/getUnitDiscountDetailByDiscountId.action?unitDiscountId=0";
			
			List<ProjectDiscount> changeList = projectDiscountServices.findProjectDiscountByPayWayId(Integer.parseInt(payWayId)); 
			
			if(!CommonUtils.isCollectionEmpty(changeList)){
				
				for(ProjectDiscount change : changeList){
					
					changeProjectDiscountIdList.add(change.getId() + "");
				}
			}
			
		}else{
			//说明为更新
			unitDiscount = unitDiscountServices.findUnitDiscountById(Integer.parseInt(unitDiscountId));
			
			List<ProjectDiscount> changeList = projectDiscountServices.findProjectDiscountByUnitDiscountId(Integer.parseInt(unitDiscountId));
			
			if(!CommonUtils.isCollectionEmpty(changeList)){
				
				for(ProjectDiscount change : changeList){
					
					if(!changeProjectDiscountIdList.contains(change.getId() + "")){
						
						changeProjectDiscountIdList.add(change.getId() + "");
					}
				}
			}
			
			unitId = unitDiscount.getUnitId();
			
			url = "./project_discount/manager/getUnitDiscountDetailByDiscountId.action?unitDiscountId=" + unitDiscountId;
			
		}
		
		unit = unitServices.findPropertyUnitById(unitId);
		
		selProjectDiscount = DiscountManagerUtils.initSelProjectDiscountByPayWayId(Integer.parseInt(payWayId)); 
		
		request.getSession().setAttribute("changeProjectDiscountIdList", changeProjectDiscountIdList); //页面使用
		
	}
	
	/**
	 * 判断是否为更新过来
	 * @return
	 */
	private boolean isUpdate(){
		
		if(CommonUtils.isStrZeroEmpty(unitDiscountId) || "null".equals(unitDiscountId))
			
			return false;
		
		//当unitDiscountId>0还要判断payWayId是否为旧的
		
		/*List<ProjectDiscount> proDiscountList = projectDiscountServices.findProjectDiscountByUnitDiscountId(Integer.parseInt(unitDiscountId));
		
		if(CommonUtils.isCollectionEmpty(proDiscountList))
			return false;
		
		String getPayWayId = proDiscountList.get(0).getPayWayId() + "";
		if(!payWayId.equals(getPayWayId))
			return false;*/
		
		return true;
	}
	
	////
	
	private String types; //类型
	private LinkedHashMap selTypes;
	
	private PropertyUnit unit;
	
	//private String mainId; //如果在查看认购或签约的时候,新建折扣,那该字段有用,默认为0
	//private String confirmType; //认购或合同
	
	private LinkedHashMap<String, String> selComputeWay; //折扣计算方式
	
	private Map<String, String> selProjectDiscount; //具体的折扣(百分比)
	
	private UnitDiscount unitDiscount;
	
	private String projectId;
	
	private String url;
	
	private String unitDiscountId; //主要用于关闭弹出框,且要增加confirm_discount(认购合同单的完整折扣)对应的unit_discount_id
	
	private Integer[] projectDiscountId; //选择的项目折扣id
	
	private List<String> changeProjectDiscountIdList; //用于页面的项目折扣的选中
	
	private String payWayId;
	
	public void setPayWayId(String payWayId) {
		this.payWayId = payWayId;
	}
	
	public String getPayWayId() {
		return payWayId;
	}
	
	public void setChangeProjectDiscountIdList(
			List<String> changeProjectDiscountIdList) {
		this.changeProjectDiscountIdList = changeProjectDiscountIdList;
	}
	
	public List<String> getChangeProjectDiscountIdList() {
		return changeProjectDiscountIdList;
	}
	
	public void setProjectDiscountId(Integer[] projectDiscountId) {
		this.projectDiscountId = projectDiscountId;
	}
	
	public Integer[] getProjectDiscountId() {
		return projectDiscountId;
	}
	
	public void setUnitDiscountId(String unitDiscountId) {
		this.unitDiscountId = unitDiscountId;
	}
	
	public String getUnitDiscountId() {
		return unitDiscountId;
	}
	
	public String getTypes() {
		return types;
	}

	public void setTypes(String types) {
		this.types = types;
	}

	public LinkedHashMap getSelTypes() {
		return selTypes;
	}

	public void setSelTypes(LinkedHashMap selTypes) {
		this.selTypes = selTypes;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	
	public String getProjectId() {
		return projectId;
	}

	public PropertyUnit getUnit() {
		return unit;
	}

	public void setUnit(PropertyUnit unit) {
		this.unit = unit;
	}

	public LinkedHashMap<String, String> getSelComputeWay() {
		return selComputeWay;
	}

	public void setSelComputeWay(LinkedHashMap<String, String> selComputeWay) {
		this.selComputeWay = selComputeWay;
	}

	public Map<String, String> getSelProjectDiscount() {
		return selProjectDiscount;
	}
	
	public void setSelProjectDiscount(Map<String, String> selProjectDiscount) {
		this.selProjectDiscount = selProjectDiscount;
	}

	public UnitDiscount getUnitDiscount() {
		return unitDiscount;
	}

	public void setUnitDiscount(UnitDiscount unitDiscount) {
		this.unitDiscount = unitDiscount;
	}
	
}
