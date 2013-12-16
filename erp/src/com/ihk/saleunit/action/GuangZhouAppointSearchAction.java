package com.ihk.saleunit.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.saleunit.data.pojo.Appoint;
import com.ihk.saleunit.data.pojo.AppointCond;
import com.ihk.saleunit.data.services.IAppointServices;
import com.ihk.utils.ActionPageCallback;
import com.ihk.utils.ActionTemplate;
import com.ihk.utils.SupperAction;

/**
 *  广州预约排号查询主页
 */
public class GuangZhouAppointSearchAction extends SupperAction {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	IAppointServices appointServices;
	
	public String index() throws Exception{
		
		if(cond == null){
			cond = new AppointCond();
		}
		
		/*new CommonPageActionUtils(this, cond) {
			
			@Override
			public void initActionList() {
				appintList = appointServices.findAppointPage(cond);
				
			}
		};*/
		
		// 抽象类CommonPageActionUtils与ActionTemplate使用接口ActionPageCallback的区别及各自的利弊   ???
		ActionTemplate actionTemplate = new ActionTemplate(this, cond);
		actionTemplate.executePage(new ActionPageCallback() {
			
			@Override
			public void initActionPageList() {
				
				appointList = appointServices.findAppointPage(cond);
			}
		});
		
		String deleteSession = request.getParameter("deleteSession");
		
		if(!"false".equals(deleteSession)){
			removeSuggestion();
		}
		
		return "appointIndex";
	}
	
	/**
	 * 排序
	 * @return
	 */
	public String searchOrderBy(){
		
		final ActionTemplate actionTemplate = new ActionTemplate(this, cond, true);
		actionTemplate.executePage(new ActionPageCallback() {
			
			@Override
			public void initActionPageList() {
				
				appointList = appointServices.findAppointPage((AppointCond) actionTemplate.getCond());
			}
		});
		
		/*HttpSession session = request.getSession();
		
		Object o = session.getAttribute(CommonUtils.COND);
		if(o == null){
			
			cond = new AppointCond();
		}else{
			
			cond = (AppointCond)o;
		}
		
		new CommonPageActionUtils(this, cond) {
			
			@Override
			public void initActionList() {
				appointList = appointServices.findAppointPage(cond);
				
			}
		};*/
		
		return "searchAppoint";
	}
	
	////////////////////
	
	private List<Appoint> appointList;
	private AppointCond cond;
	
	public void setCond(AppointCond cond) {
		this.cond = cond;
	}
	
	public AppointCond getCond() {
		return cond;
	}
	
	public void setAppointList(List<Appoint> appointList) {
		this.appointList = appointList;
	}
	
	public List<Appoint> getAppointList() {
		return appointList;
	}
	
	
}
