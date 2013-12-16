package com.ihk.report.action;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.saleunit.data.pojo.AppointCond;
import com.ihk.saleunit.data.services.IAppointServices;
import com.ihk.utils.SupperAction;

/**
 *  公司预约单报表分析
 */
public class GuangZhouAppointAction extends SupperAction {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	IAppointServices appointServices;
	
	public String appoint() throws Exception{
		
		if(cond == null){
			cond = new AppointCond();
		}
		
		appointReportList = appointServices.findCompanyReport(cond);
		
		return "appoint";
	}
	
	
	////
	
	private AppointCond cond;
	private List<Map<String, Object>> appointReportList;
	
	public void setAppointReportList(List<Map<String, Object>> appointReportList) {
		this.appointReportList = appointReportList;
	}
	
	public List<Map<String, Object>> getAppointReportList() {
		return appointReportList;
	}
	
	public void setCond(AppointCond cond) {
		this.cond = cond;
	}
	
	public AppointCond getCond() {
		return cond;
	}
	
}
