package com.ihk.saleunit.action.new_report;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.ContSessionAttribute;
import com.ihk.constanttype.EnumDevFlag;
import com.ihk.constanttype.EnumPrivCode;
import com.ihk.customer.data.pojo.CustomerFollowCond;
import com.ihk.customer.data.services.ICustomerFollowServices;
import com.ihk.permission.PermissionUtils;
import com.ihk.utils.ActionAjaxPageCallback;
import com.ihk.utils.ActionTemplate;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.ReportUtils;
import com.ihk.utils.SupperAction;

/**
 * 通过传进的跟进类型和销售人员的用户id得到客户列表
 * @author xsj
 *
 */
public class CustomerListByFollow extends SupperAction{
	@Autowired
	ICustomerFollowServices customerFollowServices;
	private CustomerFollowCond cond;
	private Integer value;

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}


	public CustomerFollowCond getCond() {
		return cond;
	}

	public void setCond(CustomerFollowCond cond) {
		this.cond = cond;
	}

	/**
	 * 调用显示页面，初始化参数
	 * @return
	 */
	public String index(){
		return SUCCESS;
	}
	
	/**
	 * 返回数据
	 * @return
	 * @throws Exception 
	 */
	public 	String xsgjqkReportAjax() throws Exception{
		ActionTemplate.executeAjaxPage(this, cond, new ActionAjaxPageCallback() {
			
			@Override
			public int initTotal() throws Exception {
				return value;
			}
			
			@Override
			public List<Map<String, String>> initRows() throws Exception {
				List<Map<String,String>> retList = new ArrayList<Map<String,String>>();
				List<Map> list = null;
				if(!"".equals(cond.getFollowUserId()))
					list = customerFollowServices.findCustomerListByCustomerFollowUser(cond);
				else if(!"".equals(cond.getCompanyId()))
					list = customerFollowServices.findCustomerListByCustomer(cond);
				else if(!"".equals(cond.getProjectId()))
					list = customerFollowServices.findCustomerListByProject(cond);
				if(!CommonUtils.isCollectionEmpty(list)){
					for (Map obj : list) {
						Map<String,String> map =new HashMap<String, String>();
						
						map.put("name", obj.get("customerName").toString());
						if(PermissionUtils.hasPermission(EnumPrivCode.PRECUSTOMER_RETRIEVE_TEL,EnumDevFlag.GUANGZHOU)){
						map.put("phone1",obj.get("homePhone").toString());
						map.put("phone2", obj.get("phone").toString());
						}else{
							map.put("phone1","********");
							map.put("phone2","********");
						}
						map.put("area", obj.get("areaNum").toString());
						map.put("price", obj.get("priceNum").toString());
						map.put("pro", obj.get("projectName").toString());
						map.put("followUserName", obj.get("userId").toString());
						map.put("createdTime", obj.get("createdTime").toString().substring(0, obj.get("createdTime").toString().length()-2));
						retList.add(map);
					}
				}
				return retList;
			}
		});
		cond.pageSize = 0;
			List<Map<String,String>> downList = new ArrayList<Map<String,String>>();
			List<Map> list =null;
			if(!"".equals(cond.getFollowUserId()))
				list = customerFollowServices.findCustomerListByCustomerFollowUser(cond);
			else if(!"".equals(cond.getCompanyId()))
				list = customerFollowServices.findCustomerListByCustomer(cond);
			else if(!"".equals(cond.getProjectId()))
				list = customerFollowServices.findCustomerListByProject(cond);
			if(!CommonUtils.isCollectionEmpty(list)){
				for (Map obj : list) {
					Map<String,String> map =new HashMap<String, String>();
					map.put("name", obj.get("customerName").toString());
					map.put("phone1",obj.get("phone").toString());
					map.put("phone2", obj.get("homePhone").toString());
					map.put("area", obj.get("areaNum").toString());
					map.put("price", obj.get("priceNum").toString());
					map.put("pro", obj.get("projectName").toString());
					map.put("followUserName", obj.get("userId").toString());
					map.put("createdTime", obj.get("createdTime").toString().substring(0, obj.get("createdTime").toString().length()-2));
					downList.add(map);
				}
			}
		setDownloadData(downList);
		
		return null;
	}

	/**
	 * 下载
	 * @return
	 * @throws Exception
	 */
	public String download() throws Exception{
		List<Map<String,String>> dataList =(List<Map<String,String>>) request.getSession().getAttribute(ContSessionAttribute.XSGJQK_KUGJLB+ContSessionAttribute.DOWNLOAD_DATA);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("dataList", dataList);
		
		ReportUtils.downLoadReport(map, "customer-user-follow-customer-msg.xls", "download-客户跟进详细列表-销售-" + CustomerUtils.getNowForString() + "-.xls", response);
		
		return null;
	}
	
	/**
	 * 设置下载内容到session
	 */
	private void setDownloadData(List<Map<String,String>> dataList){
		request.getSession().setAttribute(ContSessionAttribute.XSGJQK_KUGJLB+ContSessionAttribute.DOWNLOAD_DATA, dataList);
	}
}
