package com.ihk.saleunit.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.saleunit.data.pojo.Appoint;
import com.ihk.saleunit.data.services.IAppointServices;
import com.ihk.utils.AppointUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.SupperAction;

/**
 * 录入
 */
public class GuangZhouMortgageInputAction extends SupperAction {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	IAppointServices appointServices; 
	
	private Appoint appoint;
	
	public void setAppoint(Appoint appoint) {
		this.appoint = appoint;
	}
	
	public Appoint getAppoint() {
		return appoint;
	}
	
	/**
	 * 执行录入
	 * @return
	 * @throws Exception
	 */
	public String inputMortgage() throws Exception{
		
		boolean isSucc = true;
		
		try{
			
			AppointUtils.initOther(appoint);
			appointServices.addAppoint(appoint);
			
		}catch(Exception e){
			e.printStackTrace();
			isSucc = false;
		}
		
		if(isSucc){
			
			setSuggestion(CommonUtils.SUCCSUGG);
		}else{
			
			setSuggestion(CommonUtils.FAILSUGG);
		}
		
		return "inputMortgage";
	}
	
	/**
	 * 显示录入界面
	 * @return
	 * @throws Exception
	 */
	public String forInput() throws Exception{
		
		String deleteSession = request.getParameter("deleteSession");
		
		if(!"false".equals(deleteSession)){
			removeSuggestion();
		}
		
		if("token".equals(deleteSession)){
			setSuggestion("重复提交,可能已经录入成功,请查询后再录入");
		}
		
		return "forInput";
	}
		
	
	

}
