package com.ihk.sale.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.EnumDevFlag;
import com.ihk.constanttype.EnumPrivCode;
import com.ihk.permission.PermissionUtils;
import com.ihk.user.data.pojo.CompanyProject;
import com.ihk.user.data.pojo.UserAccount;
import com.ihk.user.data.pojo.UserAccountCond;
import com.ihk.user.data.services.IUserAccountServices;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.Pager;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;
import com.ihk.utils.exception.PrivException;
import com.opensymphony.xwork2.ActionContext;

/**
 * 查找用户
 */
public class SearchUserAccount extends SupperAction{

	private static final long serialVersionUID = 1L;
	
	@Autowired IUserAccountServices iUserAccountServices;
	
	private List<UserAccount> userlist;
	private UserAccountCond searchCond;//搜索表单条件
	private UserAccountCond searchCondSave;
	/**初始化查询用户界面*/
	public String searchUserIndex(){
		if( !isHaveSearchRole()){
			addActionMessage("没有查看权限");
			return "search";
		}
		searchCond = new UserAccountCond();
		this.initSearch();
		return "search";
	}
	/**点击搜索表单*/
	public String searchUserForm(){
		if( !isHaveSearchRole()){
			addActionMessage("没有查看权限");
			return "search";
		}
		if(searchCond == null){
			searchCond = new UserAccountCond();
		}	
		if(searchCondSave == null){
			searchCondSave = new UserAccountCond();
		}
		searchCondSave.setUserName(searchCond.getUserName());
		initSearch();
//		searchCondSave.setUserName(searchCond.getUserName());
		return "search";
	}
	private String ids;
	
	
	public String delUserAccount(){
		String tempids[]=ids.split("_");
		for (String id:tempids){
			this.iUserAccountServices.deleteUserAccount(Integer.parseInt(id));
		}
		if(searchCond==null){
			searchCond = new UserAccountCond();
		}
		
		this.initSearch();
	
		
		return "search";
	}
	
	private void initSearch(){
		if(1==1){
			//peter:20130529,统一用户管理列表为struts-user-manager.xml,其他原有的用户管理关闭；需要开放的话，需要重新测试是否串了位置（广州项目与恒大项目）
			throw new PrivException("页面调整，无法访问，请与开发人员联系");
		}
		//初始化页面需要的列表信息  a.项目下拉框
		
//		searchCond.setProIN("(8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46)");
		searchCond.setProjectIds(PermissionUtils.getUserProjectIdList());
		
		String action = CustomerUtils.getActionNameFromRequest(request);
		Pager page = new Pager(ActionContext.getContext(),15,action);	
		searchCond.recordCount = iUserAccountServices.findUserAccountCount(searchCond);
		page.setCond(searchCond);
		this.userlist = iUserAccountServices.findUserAccountPage(searchCond); 	
		for (int i = 0; i < userlist.size(); i++) {
			userlist.get(i).initSelectUserRoleList();
		}
		this.setShowPage(page.toHtmlString());

	}
	private boolean isHaveSearchRole(){
		List<CompanyProject> projectList = PermissionUtils.getUserProjectListByUid(EnumPrivCode.LOCK_SALE,EnumDevFlag.HENGDA, SessionUser.getUserId());
		if(projectList == null){
			
			return  false;
		}
		return true;
	}
/////////////////////////////////////////////////setget
	public List<UserAccount> getUserlist() {
		return userlist;
	}
	public void setUserlist(List<UserAccount> userlist) {
		this.userlist = userlist;
	}
	public UserAccountCond getSearchCond() {
		return searchCond;
	}
	public void setSearchCond(UserAccountCond searchCond) {
		this.searchCond = searchCond;
	}
	public UserAccountCond getSearchCondSave() {
		return searchCondSave;
	}
	
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	
	
}
