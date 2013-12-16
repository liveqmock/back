package com.ihk.report.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.saleunit.data.pojo.Appoint;
import com.ihk.saleunit.data.pojo.AppointCond;
import com.ihk.saleunit.data.services.IAppointServices;
import com.ihk.utils.CommonPageActionUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.SupperAction;

/**
 *  查询列表
 */
public class GuangZhouPropertySaleSumAction extends SupperAction {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	IAppointServices appointServices;

	private List<Appoint> appintList;
	private AppointCond cond;
	
	public void setCond(AppointCond cond) {
		this.cond = cond;
	}
	
	public AppointCond getCond() {
		return cond;
	}
	
	public void setAppintList(List<Appoint> appintList) {
		this.appintList = appintList;
	}
	
	public List<Appoint> getAppintList() {
		return appintList;
	}
	
	
	/**
	 * 查询
	 * @return
	 * @throws Exception
	 */
	public String propertySaleSum() throws Exception{
		
		if(cond == null){
			cond = new AppointCond();
		}

		initPager(cond);
		appintList = appointServices.findAppointPage(cond);
		showPager(cond);		
		
		String deleteSession = request.getParameter("deleteSession");
		
		if(!"false".equals(deleteSession)){
			removeSuggestion();
		}
		
		return "propertySaleSum";
	}
	
	/**
	 * 排序
	 * @return
	 */
	public String searchOrderBy(){
		HttpSession session = request.getSession();
		
		Object o = session.getAttribute(CommonUtils.COND);
		if(o == null){
			
			cond = new AppointCond();
		}else{
			
			cond = (AppointCond)o;
		}		

		initPager(cond);
		appintList = appointServices.findAppointPage(cond);
		showPager(cond);	
		
		return "searchAppoint";
	}
	
	
}
