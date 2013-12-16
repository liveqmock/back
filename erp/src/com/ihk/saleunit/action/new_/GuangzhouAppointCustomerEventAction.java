package com.ihk.saleunit.action.new_;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.saleunit.data.pojo.CustomerEvent;
import com.ihk.saleunit.data.pojo.CustomerEventCond;
import com.ihk.saleunit.data.services.ICustomerEventServices;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.ReportUtils;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;

/**
 * 客户服务事件
 */
public class GuangzhouAppointCustomerEventAction extends SupperAction{

	private static final long serialVersionUID = 1L;
	
	private String tips;
	private CustomerEvent createCustomerEvent;
	private int buildId;
	private List<CustomerEvent> customerEventList;
	@Autowired ICustomerEventServices customerEventServices;
	
	public String showList(){
		
		CustomerEventCond cond = new CustomerEventCond();
//		cond.setBuildId(this.buildId+"");
		customerEventList = customerEventServices.findCustomerEvent(cond);
		return "suc";
	}
	
	public String addDialog(){
		return "suc";
	}
	
	public String addDialogForm(){
		createCustomerEvent.setIsDeleted("0");
		createCustomerEvent.setCreatedId(SessionUser.getUserId());
		createCustomerEvent.setCreatedTime(new Date());
		createCustomerEvent.setModId(SessionUser.getUserId());
		createCustomerEvent.setModTime(createCustomerEvent.getCreatedTime());
		customerEventServices.addCustomerEvent(createCustomerEvent);
		tips = "新建成功!";
		return "suc";
	}

	
	public String getTips() {
		return tips;
	}

	public void setTips(String tips) {
		this.tips = tips;
	}

	public CustomerEvent getCreateCustomerEvent() {
		return createCustomerEvent;
	}

	public void setCreateCustomerEvent(CustomerEvent createCustomerEvent) {
		this.createCustomerEvent = createCustomerEvent;
	}

	public int getBuildId() {
		return buildId;
	}

	public void setBuildId(int buildId) {
		this.buildId = buildId;
	}

	public List<CustomerEvent> getCustomerEventList() {
		return customerEventList;
	}

	public void setCustomerEventList(List<CustomerEvent> customerEventList) {
		this.customerEventList = customerEventList;
	}

	/**
	 * 导出excel
	 * @return
	 */
	public String downLoad(){
		CustomerEventCond cond = new CustomerEventCond();
//		cond.setBuildId(this.buildId+"");
		customerEventList = customerEventServices.findCustomerEvent(cond);
				
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("eventList", customerEventList);
		
		try {
			ReportUtils.downLoadReport(map, "customer-event.xls", "download-cv-" + CustomerUtils.getNowForString() + "-.xls", response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
