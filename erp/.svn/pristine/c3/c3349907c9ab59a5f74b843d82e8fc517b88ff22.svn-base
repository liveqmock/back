package com.ihk.saleunit.action.new_report;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.EnumCodeTypeName;
import com.ihk.constanttype.EnumPrivCode;
import com.ihk.customer.data.pojo.CustomerCond;
import com.ihk.customer.data.services.ICustomerServices;
import com.ihk.permission.PermissionUtils;
import com.ihk.utils.ActionAjaxPageCallback;
import com.ihk.utils.ActionTemplate;
import com.ihk.utils.DescUtils;
import com.ihk.utils.SupperAction;

/**
 * 售前客户,客户来源及来访日期报表
 * @author dtc
 * 2013-3-1,上午09:57:46
 */
public class CustomerSourceAndVisitDateReportAction extends SupperAction{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	ICustomerServices customerServices;
	
	/**
	 * 跳到查询界面
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public String layout() throws Exception{
		
		selCustomerSource = DescUtils.getInitSelForGuangZhou(selCustomerSource, EnumCodeTypeName.CUSTOMER_SOURCE, true);
		
		return "layout";
	}
	
	/**
	 * ajax统计,加上权限
	 * @return
	 * @throws Exception
	 */
	public String sourceAndVisitAjax() throws Exception{
		
		if(cond.getProjectId() == 0){
			
			//没有选择项目,加上项目权限
			List<Integer> projectIds = PermissionUtils.getUserProjectIdList(EnumPrivCode.REPORT_PRECUSTOMER_DOWNLOAD);
			cond.setProjectIds(projectIds);
		}
		
		ActionTemplate.executeAjaxPage(this, cond, new ActionAjaxPageCallback() {
			
			@Override
			public int initTotal() throws Exception {
				
				return 0; //没有分页
			}
			
			@Override
			public List<Map<String, String>> initRows() throws Exception {
				
				List<Map<String, String>> retList = new ArrayList<Map<String,String>>();
				
				List<Map<String, Object>> mapList = customerServices.findCustomerSourceAndVisit(cond);
				
				if(mapList != null && mapList.size() > 0){
					
					Map<String, String> retMap = null;
					
					for(Map<String, Object> map : mapList){
						
						retMap = new HashMap<String, String>();
						
						retMap.put("projectName", map.get("projectName")==null ? "" : map.get("projectName").toString());
						retMap.put("customerCount", map.get("customerCount")==null ? "0" : map.get("customerCount").toString());
						
						retMap.put("customerSearch", getHref(cond, map.get("projectId").toString()));
						
						retList.add(retMap);
					}
					
				}
				
				return retList;
			}
		});
		
		return null;
	}
	
	private String getHref(CustomerCond cond, String projectId){
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("<a href='./customer_guangzhou/search/search.action?");
		
		if(cond != null){
			
			sb.append("searchCond.projectId=").append(projectId)
				.append("&searchCond.customerSource=").append(cond.getCustomerSource())
				.append("&searchCond.visitDate1=").append(cond.getVisitDate1())
				.append("&searchCond.visitDate2=").append(cond.getVisitDate2())
				;
		}
		
		sb.append("'>查询</a>");
		
		return sb.toString();
	}
	
	//
	
	private CustomerCond cond;
	
	private LinkedHashMap<String, String> selCustomerSource; //客户来源
	
	public void setCond(CustomerCond cond) {
		this.cond = cond;
	}
	
	public CustomerCond getCond() {
		return cond;
	}
	
	public void setSelCustomerSource(
			LinkedHashMap<String, String> selCustomerSource) {
		this.selCustomerSource = selCustomerSource;
	}
	
	public LinkedHashMap<String, String> getSelCustomerSource() {
		return selCustomerSource;
	}

}
