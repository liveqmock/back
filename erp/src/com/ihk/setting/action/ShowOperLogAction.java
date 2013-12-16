package com.ihk.setting.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.setting.data.pojo.OperLog;
import com.ihk.setting.data.pojo.OperLogCond;
import com.ihk.setting.data.services.IOperLogServices;
import com.ihk.user.data.pojo.UserAccount;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.Pager;
import com.ihk.utils.SupperAction;
import com.opensymphony.xwork2.ActionContext;

/**
 * 显示操作日志
 *
 */
public class ShowOperLogAction extends SupperAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired IOperLogServices iOperLogServices;
	
	private List<OperLog> operList;//显示operlog
	private OperLogCond operCond;//
	private String projectName;
	public String index(){
		operCond= new OperLogCond();
		operCond.setDevFlag("customer_guangzhou");
		operCond.setDate1(CommonUtils.getOneWeekBeforeForString());
		initList();
		return "suc";
	}
	
	/**查看oper_log情况  只查看operlog表 根据cond查*/
	public String search(){
		if(operCond == null){
			operCond = new OperLogCond();
			operCond.setDevFlag("customer_guangzhou");
		}
		
		
		initList();
		return "suc";
	}
	
	private void initList(){
		if(operCond.getUserName() != null && !operCond.getUserName().trim().equals("")){
			operCond.setSearchName(DescUtils.getUserAccountByUserName(operCond.getUserName()).getRealName());
		}
		String action = CustomerUtils.getActionNameFromRequest(request);
		Pager page = new Pager(ActionContext.getContext(), 10, action);
		operCond.recordCount = iOperLogServices.findOperLogCount(operCond);
		page.setCond(operCond);
		this.operList = iOperLogServices.findOperLogPage(operCond);
		this.setShowPage(page.toHtmlString());
	}

	public List<OperLog> getOperList() {
		return operList;
	}

	public void setOperList(List<OperLog> operList) {
		this.operList = operList;
	}

	public OperLogCond getOperCond() {
		return operCond;
	}

	public void setOperCond(OperLogCond operCond) {
		this.operCond = operCond;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	
}








