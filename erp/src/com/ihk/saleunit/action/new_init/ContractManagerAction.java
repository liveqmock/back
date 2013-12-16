package com.ihk.saleunit.action.new_init;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.property.data.pojo.ContractBarrules;
import com.ihk.property.data.pojo.ContractManager;
import com.ihk.property.data.pojo.PropertyArea;
import com.ihk.property.data.pojo.PropertyBuild;
import com.ihk.property.data.pojo.PropertyProject;
import com.ihk.property.data.services.IContractBarrulesServices;
import com.ihk.property.data.services.IContractManagerServices;
import com.ihk.property.data.services.IPropertyBuildServices;
import com.ihk.utils.ActionMethodModifyUtils;
import com.ihk.utils.CommonPojoUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.SupperAction;
import com.ihk.utils.saleunit.MyPropertyUtils;
import com.ihk.utils.saleunitnew.ContractManagerUtils;

/**
 * 合同管理
 * @author dtc
 * 2012-11-13,下午03:06:23
 */
public class ContractManagerAction extends SupperAction{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	IPropertyBuildServices buildServices;
	@Autowired
	IContractManagerServices contractManagerServices;
	@Autowired
	IContractBarrulesServices contractBarrulesServices;
	
	/**
	 * 列表
	 * @return
	 * @throws Exception
	 */
	public String contractManager() throws Exception{
		
		String type = request.getParameter("type");
		int id = Integer.parseInt(request.getParameter("id"));
		
		if("pro".equals(type) || "p".equals(type)){
			
			managerList = contractManagerServices.findContractManagerByProId(id);
			
		}else if("area".equals(type)){
			
			managerList = contractManagerServices.findContractManagerByAreaId(id);
			
		}else if("endNode".equals(type)){
			
			managerList = contractManagerServices.findContractManagerByBuildId(id);
		}
		
		String _for = request.getParameter("for");
		if("Saleunit".equalsIgnoreCase(_for)){
			//成交单元管理下的合同管理
			return "contractManagerForSaleunit";
		}
		
		return "contractManager";
	}
	
	/**
	 * 跳到增加页面
	 * @return
	 * @throws Exception
	 */
	public String toAddContractManager() throws Exception{
		
		init(null);
		
		return "toAddContractManager";
	}
	
	/**
	 * 跳到ajax增加页面
	 * @return
	 * @throws Exception
	 */
	public String toAjaxAddContractManager() throws Exception{
		
		init(null);
		
		return "toAjaxAddContractManager";
	}
	
	/**
	 * 增加
	 * @return
	 * @throws Exception
	 */
	public String addContractManager() throws Exception{
		
		return new ActionMethodModifyUtils(true) {
			
			@Override
			protected void modifyMethod() throws Exception {
				
				contractManager.setStatus(CommonUtils.NORMAL);
				CommonPojoUtils.initPojoCommonFiled(contractManager);
				contractManagerServices.addContractManager(contractManager);
				
				String[] ids = request.getParameterValues("barRuleIds"); //ContractManagerUtils.java方法getBarRuleMap()中声明
				if(ids != null && ids.length > 0){
					
					int length = ids.length;
					
					List<Integer> idList = new ArrayList<Integer>();
					
					for(int i=0; i<length; i++){
						
						idList.add(Integer.parseInt(ids[i]));
					}
					
					contractBarrulesServices.updateContractBarrulesSetManagerId(contractManager.getId(), idList);
					
				}
				
			}
		}.doModify(this);
		
	}
	
	/**
	 * 跳到查看,修改或复制页面
	 * @return
	 * @throws Exception
	 */
	public String showContractManager() throws Exception{
		
		int managerId = Integer.parseInt(request.getParameter("id"));
		contractManager = contractManagerServices.findContractManagerById(managerId);
		
		init(contractManager);
		
		String type = request.getParameter("type");
		if("copy".equals(type)){
			return "toCopyContractManager";
		}
		
		return "showContractManager";
	}
	
	/**
	 * 修改
	 * @return
	 * @throws Exception
	 */
	public String updateContractManager() throws Exception{
		
		return new ActionMethodModifyUtils() {
			
			@Override
			protected void modifyMethod() throws Exception {
				
				ContractManager oldManager = contractManagerServices.findContractManagerById(contractManager.getId());
				
				CommonPojoUtils.initPojoForUpdate(oldManager, contractManager);
				
				contractManagerServices.updateContractManager(contractManager);
				
			}
		}.doModify(this);
		
	}
	
	/**
	 * 作废
	 * @return
	 * @throws Exception
	 */
	public String cancelContractManager() throws Exception{
		
		return new ActionMethodModifyUtils() {
			
			@Override
			protected void modifyMethod() throws Exception {
				
				int managerId = Integer.parseInt(request.getParameter("id"));
				contractManagerServices.cancelContractManager(managerId);
				
			}
		}.doModify(this);
	}
	
	/**
	 * 复制(操作类似增加)
	 * @return
	 * @throws Exception
	 */
	public String copyContractManager() throws Exception{
		
		return addContractManager();
	}
	
	/**
	 * 结佣规则
	 * @return
	 * @throws Exception
	 */
	public String toAddBarRule() throws Exception{
		
		selBarOpr = ContractManagerUtils.initSelBarOpr();
		selBarOpr2 = ContractManagerUtils.initSelBarOpr2();
		
		managerId = request.getParameter("managerId");
		
		return "toAddBarRule";
	}
	
	/**
	 * 增加跳bar	
	 * @return
	 * @throws Exception
	 */
	public String addBarRule() throws Exception{
		
		return new ActionMethodModifyUtils() {

			@Override
			public void modifyMethod() throws Exception {

				contractBarrules.setStatus(CommonUtils.NORMAL);
				CommonPojoUtils.initPojoCommonFiled(contractBarrules);
				
				contractBarrulesServices.addContractBarrules(contractBarrules);
				
				request.getSession().setAttribute(ContractManagerUtils.SESSION_BAR_RULE, contractBarrules);
			}
		}.doModify(this);
		 
	}
	
	/**
	 * 根据manager id获取其对应的barRule列表
	 * @return
	 * @throws Exception
	 */
	public String getBarRuleListByManagerId() throws Exception{
		
		int managerId = Integer.parseInt(request.getParameter("id"));
		
		List<ContractBarrules> list = contractBarrulesServices.findContractBarrulesByManagerId(managerId);
		
		if(CommonUtils.isCollectionEmpty(list)){
			
			CustomerUtils.writeResponse(response, "[]");
			return null;
		}
		
		List<Map<String, String>> listMap = new ArrayList<Map<String,String>>();
		
		for(ContractBarrules barRule : list){
			
			listMap.add(ContractManagerUtils.getBarRuleMap(barRule));
		}
		
		String out = CommonUtils.getListMapJsonAnd(listMap);
		
		CustomerUtils.writeResponse(response, out);
		
		return null;
	}
	
	/**
	 * 根据manager id获取其对应的barRule列表,用于复制
	 * @return
	 * @throws Exception
	 */
	public String getBarRuleListByManagerIdForCopy() throws Exception{
		
		int managerId = Integer.parseInt(request.getParameter("id"));
		
		List<ContractBarrules> list = contractBarrulesServices.findContractBarrulesByManagerId(managerId);
		
		if(CommonUtils.isCollectionEmpty(list)){
			
			CustomerUtils.writeResponse(response, "[]");
			return null;
		}
		
		List<Map<String, String>> listMap = new ArrayList<Map<String,String>>();
		
		for(ContractBarrules barRule : list){
			
			//照原先的数据重新新增
			barRule.setContractManagerId(0);
			CommonPojoUtils.initPojoCommonFiled(barRule);
			contractBarrulesServices.addContractBarrules(barRule);
			
			listMap.add(ContractManagerUtils.getBarRuleMap(barRule));
		}
		
		String out = CommonUtils.getListMapJsonAnd(listMap);
		
		CustomerUtils.writeResponse(response, out);
		
		return null;
	}
	
	/**
	 * 根据session中的值获取对应的barRule
	 * @return
	 * @throws Exception
	 */
	public String addBarRuleToTable() throws Exception{
		
		String out = "";
		
		try{
		
			Object obj = request.getSession().getAttribute(ContractManagerUtils.SESSION_BAR_RULE);
			
			if(obj != null){
				
				ContractBarrules sessionBarRule = (ContractBarrules) obj;
				
				Map<String, String> map = ContractManagerUtils.getBarRuleMap(sessionBarRule);
				
				out = CommonUtils.getMapJson(map);
				
			}
		
		}catch (Exception e) {
		}
		
		request.getSession().removeAttribute(ContractManagerUtils.SESSION_BAR_RULE);
		
		CustomerUtils.writeResponse(response, out);
		
		return null;
	}
	
	/**
	 * 跳到修改barRule界面
	 * @return
	 * @throws Exception
	 */
	public String toUpdateBarRule() throws Exception{
		
		int barId = Integer.parseInt(request.getParameter("id"));
		
		contractBarrules = contractBarrulesServices.findContractBarrulesById(barId);
		
		selBarOpr = ContractManagerUtils.initSelBarOpr();
		selBarOpr2 = ContractManagerUtils.initSelBarOpr2();
		
		return "toUpdateBarRule";
	}
	
	/**
	 * 修改barRule
	 * @return
	 * @throws Exception
	 */
	public String updateBarRule() throws Exception{
		
		return new ActionMethodModifyUtils() {
			
			@Override
			protected void modifyMethod() throws Exception {
				
				ContractBarrules oldBarrule = contractBarrulesServices.findContractBarrulesById(contractBarrules.getId());
				
				CommonPojoUtils.initPojoForUpdate(oldBarrule, contractBarrules);
				
				contractBarrulesServices.updateContractBarrules(contractBarrules);
				
				request.getSession().setAttribute(ContractManagerUtils.SESSION_BAR_RULE, contractBarrules);
				
			}
		}.doModify(this);
		
	}
	
	/**
	 * 删除barRule
	 * @return
	 * @throws Exception
	 */
	public String deleteBarRule() throws Exception{
		
		return new ActionMethodModifyUtils() {
			
			@Override
			protected void modifyMethod() throws Exception {
				
				int barId = Integer.parseInt(request.getParameter("id"));
				contractBarrulesServices.deleteContractBarrules(barId);
				
			}
		}.doModify(this);
	}
	
	private void init(ContractManager contractManager){
		
		selContractType = ContractManagerUtils.initSelContractType();
		selRefundType = ContractManagerUtils.initSelRefundType();
		
		selPriceType = ContractManagerUtils.initSelPriceType();
		
		selManagerType = ContractManagerUtils.initSelManagerType();
		
		isShow = request.getParameter("isShow");
		if(CommonUtils.isStrEmpty(isShow)){
			isShow = "false";
		}
		
		initBuildAndShowName(contractManager);
		
	}
	
	/**
	 * 初始化楼栋及页面显示的值
	 */
	private void initBuildAndShowName(ContractManager contractManager){
		
		if(contractManager == null){
			
			String type = request.getParameter("type");
			int id = Integer.parseInt(request.getParameter("id"));
			
			build = new PropertyBuild();
			
			if("pro".equals(type)){
				
				PropertyProject pro = MyPropertyUtils.getPropertyProjectServices().findPropertyProjectById(id);
				
				build.setPropertyId(id);
				showName = pro.getPropertyName();
				
			}else if("area".equals(type)){
				
				PropertyArea area = MyPropertyUtils.getPropertyAreaServices().findPropertyAreaById(id);
				PropertyProject pro = MyPropertyUtils.getPropertyProjectServices().findPropertyProjectById(area.getPropertyId());
				
				build.setAreaId(id);
				build.setPropertyId(pro.getId());
				
				showName = pro.getPropertyName() + "-" + area.getAreaName();
				
			}else if("endNode".equals(type)){

				build = buildServices.findPropertyBuildById(id);
				showName = build.getAllName();
				
			}
			
		}else{
			
			int buildId = contractManager.getBuildId();
			int areaId = contractManager.getAreaId();
			int propertyId = contractManager.getPropertyId();
			
			build = new PropertyBuild();
			
			if(buildId > 0){
				
				build = buildServices.findPropertyBuildById(buildId);
				showName = build.getAllName();
				
			}else if(areaId > 0){
				
				PropertyArea area = MyPropertyUtils.getPropertyAreaServices().findPropertyAreaById(areaId);
				PropertyProject pro = MyPropertyUtils.getPropertyProjectServices().findPropertyProjectById(area.getPropertyId());
				
				build.setAreaId(areaId);
				showName = pro.getPropertyName() + "-" + area.getAreaName();
				
			}else if(propertyId > 0){
				
				PropertyProject pro = MyPropertyUtils.getPropertyProjectServices().findPropertyProjectById(propertyId);
				
				build.setPropertyId(propertyId);
				showName = pro.getPropertyName();
				
			}
			
		}
		
	}
	
	////
	private ContractManager contractManager;
	
	private ContractBarrules contractBarrules;
	
	private List<ContractManager> managerList;
	
	/**
	 * 签订类型
	 */
	private Map<String, String> selContractType;
	/**
	 * 回款类型
	 */
	private Map<String, String> selRefundType;
	
	/**
	 * bar类型
	 */
	private Map<String, String> selBarType;
	
	/**
	 * 溢价类型
	 */
	private Map<String, String> selPriceType;
	
	/**
	 * 跳bar操作符:>=,>,=,<=,<
	 */
	private Map<String, String> selBarOpr;
	
	/**
	 * 跳bar操作符2:<=,<,=,>=,>
	 */
	private Map<String, String> selBarOpr2;
	
	/**
	 * 合同类型
	 */
	private Map<String, String> selManagerType;
	
	/**
	 * 楼栋
	 */
	private PropertyBuild build;
	
	/**
	 * 是否查看而已,如果只是查看,"添加跳BAR规则:,"查看","删除",按钮不能点击
	 */
	private String isShow;
	
	/**
	 * 增加结佣规则要用到
	 */
	private String managerId;
	
	/**
	 * 页面要显示的值,要判断项目,分区是否为0
	 */
	private String showName;
	
	public void setSelManagerType(Map<String, String> selManagerType) {
		this.selManagerType = selManagerType;
	}
	
	public Map<String, String> getSelManagerType() {
		return selManagerType;
	}
	
	public void setShowName(String showName) {
		this.showName = showName;
	}
	
	public String getShowName() {
		return showName;
	}
	
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	
	public String getManagerId() {
		return managerId;
	}
	
	public void setIsShow(String isShow) {
		this.isShow = isShow;
	}
	
	public String getIsShow() {
		return isShow;
	}
	
	public void setSelBarOpr2(Map<String, String> selBarOpr2) {
		this.selBarOpr2 = selBarOpr2;
	}
	
	public Map<String, String> getSelBarOpr2() {
		return selBarOpr2;
	}
	
	public void setContractBarrules(ContractBarrules contractBarrules) {
		this.contractBarrules = contractBarrules;
	}
	
	public ContractBarrules getContractBarrules() {
		return contractBarrules;
	}
	
	public void setSelBarOpr(Map<String, String> selBarOpr) {
		this.selBarOpr = selBarOpr;
	}
	
	public Map<String, String> getSelBarOpr() {
		return selBarOpr;
	}
	
	public void setManagerList(List<ContractManager> managerList) {
		this.managerList = managerList;
	}
	
	public List<ContractManager> getManagerList() {
		return managerList;
	}
	
	public void setBuild(PropertyBuild build) {
		this.build = build;
	}
	
	public PropertyBuild getBuild() {
		return build;
	}
	
	public void setSelPriceType(Map<String, String> selPriceType) {
		this.selPriceType = selPriceType;
	}
	
	public Map<String, String> getSelPriceType() {
		return selPriceType;
	}
	
	public void setSelBarType(Map<String, String> selBarType) {
		this.selBarType = selBarType;
	}
	
	public Map<String, String> getSelBarType() {
		return selBarType;
	}
	
	public void setSelRefundType(Map<String, String> selRefundType) {
		this.selRefundType = selRefundType;
	}
	
	public Map<String, String> getSelRefundType() {
		return selRefundType;
	}
	
	public void setSelContractType(Map<String, String> selContractType) {
		this.selContractType = selContractType;
	}
	
	public Map<String, String> getSelContractType() {
		return selContractType;
	}
	
	public void setContractManager(ContractManager contractManager) {
		this.contractManager = contractManager;
	}
	
	public ContractManager getContractManager() {
		return contractManager;
	}
	
}
