package com.ihk.saleunit.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.saleunit.data.pojo.Appoint;
import com.ihk.saleunit.data.services.IAppointServices;
import com.ihk.utils.AppointUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.SupperAction;

/**
 *  修改action
 */
public class GuangZhouMortgageUpdateAction extends SupperAction {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	IAppointServices appointServices;
	
	public String getById() throws Exception{
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		appoint = appointServices.findAppointById(id);
		
		return "getById";
	}
	
	public String updateMortgage() throws Exception{
		
		int id = appoint.getId();
		
		Appoint oldAppoint = appointServices.findAppointById(id);
		
		AppointUtils.initOtherForUpdate(oldAppoint, appoint);
		
		try{
			
			appointServices.updateAppoint(appoint);
			setSuggestion(CommonUtils.SUCCSUGG);
			
		}catch(Exception e){
			e.printStackTrace();
			
			setSuggestion(CommonUtils.FAILSUGG);
		}
		
		appoint = appointServices.findAppointById(id);
		
		return "updateMortgage";
	}
	
	
	////////////
	
	private Appoint appoint;
	
	public void setAppoint(Appoint appoint) {
		this.appoint = appoint;
	}
	
	public Appoint getAppoint() {
		return appoint;
	}
	

}
