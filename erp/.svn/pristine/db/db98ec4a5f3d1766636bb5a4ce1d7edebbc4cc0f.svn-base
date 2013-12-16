package com.ihk.saleunit.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.saleunit.data.pojo.Appoint;
import com.ihk.saleunit.data.pojo.SaleDailyCond;
import com.ihk.saleunit.data.pojo.SaleDaily;
import com.ihk.saleunit.data.services.ISaleDailyServices;
import com.ihk.utils.CommonPageActionUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.SupperAction;

/**
 *  查询列表
 */
public class GuangZhouLogSearchListAction extends SupperAction {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	ISaleDailyServices saleDailyServices;

	private List<SaleDaily> dailyList;
	private SaleDailyCond cond;
	
	public void setCond(SaleDailyCond cond) {
		this.cond = cond;
	}
	
	public SaleDailyCond getCond() {
		return cond;
	}
	
	public void setDailyList(List<SaleDaily> dailyList) {
		this.dailyList = dailyList;
	}
	
	public List<SaleDaily> getDailyList() {
		return dailyList;
	}
	
	
	/**
	 * 查询
	 * @return
	 * @throws Exception
	 */
	public String searchList() throws Exception{
		
		if(cond == null){
			cond = new SaleDailyCond();
		}

		initPager(cond);
		dailyList = saleDailyServices.findSaleDailyPage(cond);
		showPager(cond);		
		
		String deleteSession = request.getParameter("deleteSession");
		
		if(!"false".equals(deleteSession)){
			removeSuggestion();
		}
		
		return "searchList";
	}
	
	/**
	 * 排序
	 * @return
	 */
	public String searchOrderBy(){
		HttpSession session = request.getSession();
		
		Object o = session.getAttribute(CommonUtils.COND);
		if(o == null){
			
			cond = new SaleDailyCond();
		}else{
			
			cond = (SaleDailyCond)o;
		}		

		initPager(cond);
		dailyList = saleDailyServices.findSaleDailyPage(cond);
		showPager(cond);	
		
		return "searchList";
	}
	
	
}
