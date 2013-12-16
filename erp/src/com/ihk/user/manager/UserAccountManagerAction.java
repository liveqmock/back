package com.ihk.user.manager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.ContUserId;
import com.ihk.constanttype.EnumDevFlag;
import com.ihk.constanttype.EnumPrivCode;
import com.ihk.permission.PermissionUtils;
import com.ihk.user.data.pojo.CompanyProject;
import com.ihk.user.data.pojo.Role;
import com.ihk.user.data.pojo.UserAccount;
import com.ihk.user.data.pojo.UserAccountCond;
import com.ihk.user.data.services.ICompanyProjectServices;
import com.ihk.user.data.services.IUserAccountServices;
import com.ihk.utils.ActionAjaxFieldPageCallback;
import com.ihk.utils.ActionTemplate;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.GuangZhouUtils;
import com.ihk.utils.Pager;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;
import com.ihk.utils.exception.PrivException;
import com.ihk.utils.method.ActionAjaxMethodModifyNoThrowsExceptionCallback;
import com.opensymphony.xwork2.ActionContext;

/**
 * 用户管理类主方法
 * @author dtc
 * 2013-11-29,上午11:04:00
 */
public class UserAccountManagerAction extends SupperAction{
	
	private static final long serialVersionUID = -2740590354884318743L;

	@Autowired 
	IUserAccountServices userAccountServices;
	@Autowired
	ICompanyProjectServices companyProjectServices;
	
	private List<UserAccount> userlist;//查找到页面需要的用户列表
	private UserAccountCond searchCond;//搜索表单条件
	private List<Role> roleList;
	private String ids;//查询页面选择的多个id
	private boolean cbxIncludeHD=false;//是否包括恒大项目
	
	/**
	 * 跳到查询页面
	 * @return
	 */
	public String layout(){
		return "index";
	}
	
	/**
	 * easyui版本的查询页面
	 * @return
	 * @throws Exception
	 */
	public String easyuiLayout() throws Exception{
		
		roleList = GuangZhouUtils.getGuangZhouRole();
		
		return "easyuiLayout";
	}
	
	/**
	 * datagrid的ajax获取方法
	 * @return
	 * @throws Exception
	 */
	public String ajaxSearch() throws Exception{
		
		if(searchCond == null){
			searchCond = new UserAccountCond();
			searchCond.setIsDeleted(-1);
		}
		
		List<Integer> prlist = PermissionUtils.getUserProjectIdList(EnumPrivCode.SYSTEM_USER_CREATE);
		if(CommonUtils.isCollectionEmpty(prlist)){
			throw new PrivException("没有项目权限,不能查看用户管理");
		}
		
		//选择的项目,如果为空就为prList;否则为两者交集
		String[] projectIds = request.getParameterValues("pn");
		List<Integer> intList = CommonUtils.stringListToIntList(projectIds); //选择的项目
		
		if(!CommonUtils.isCollectionEmpty(intList)){
			
			List<Integer> endList = CommonUtils.listIntersection(prlist, intList); //交集
			searchCond.setCompanyProjectIds(endList);
			
		}else{
			
			searchCond.setCompanyProjectIds(prlist);
		}
		
		String cbxIncludeHD = request.getParameter("cbxIncludeHD");
		if("true".equals(cbxIncludeHD)){
			//表示包含恒大账号
			
			List<CompanyProject> hdList = companyProjectServices.findCompanyProjectForHengDa();
			
			if(!CommonUtils.isCollectionEmpty(hdList)){
				
				List<Integer> hdIntList = new ArrayList<Integer>();
				for(CompanyProject hd : hdList){
					hdIntList.add(hd.getId());
				}
				
				List<Integer> oldIdList = searchCond.getCompanyProjectIds();
				if(!CommonUtils.isCollectionEmpty(oldIdList)){
					hdIntList.addAll(oldIdList);
				}
				
				searchCond.setCompanyProjectIds(hdIntList);
			}
			
		}
		
		ActionTemplate.executeAjaxPage(this, searchCond, new ActionAjaxFieldPageCallback() {
			
			@Override
			public int initTotal() throws Exception {
				
				return userAccountServices.findUserAccountCount(searchCond);
			}
			
			@Override
			public List<?> initRows() throws Exception {
				
				initOrderByFiled(searchCond);
				
				return userAccountServices.findUserAccountPage(searchCond);
			}
			
		}, "id", "userNameClick", "realName", "descCompanyId", "descProjectId", "mobilePhone", "userRole",
			"createdTimeStr", "modTimeStr", "remark", "jobNumber", "isDeleted", "descIsDeleted", "changePwd");
		
		/**
		getCbxIncludeHD();
		List<Integer> prlist = PermissionUtils.getUserProjectIdList(EnumPrivCode.SYSTEM_USER_CREATE);
		if(prlist == null || prlist.size() ==0){
			throw new PrivException("没有项目权限,不能查看用户管理");
		}
		if(searchCond == null){
			searchCond = new UserAccountCond();
		}

		if(cbxIncludeHD==true && SessionUser.getUserId()==ContUserId.ADMIN){
			//只有超级管理员以及选择了包括恒大项目,才不加入项目条件
		} else{
            if(SessionUser.getUserId()==ContUserId.ADMIN){
                //管理员不加项目
            	
            	searchCond.setCompanyProjectIds(null);
            	searchCond.setProjectIds(null);
            	
            } else {
                searchCond.addPermissionCompanyProjectIds(prlist);
            }
		}
		
		ActionTemplate.executeAjaxPage(this, searchCond, new ActionAjaxFieldPageCallback() {
			
			@Override
			public int initTotal() throws Exception {
				
				searchCond.setIsDeleted(0);
				
				return userAccountServices.findUserAccountCount(searchCond);
			}
			
			@Override
			public List<?> initRows() throws Exception {
				
				searchCond.setIsDeleted(-1);
				
				return userAccountServices.findUserAccountPage(searchCond);
			}
			
		}, "id", "userNameClick", "realName", "descCompanyId", "descProjectId", "mobilePhone", "createdTimeStr", "remark", "descIsDeleted");
		
		*/
		
		return null;
	}
	
	/**
	 * 搜索和 index用方法 
	 * @return
	 */
	public String index(){
		
		getCbxIncludeHD();
		List<Integer> prlist = PermissionUtils.getUserProjectIdList(EnumPrivCode.SYSTEM_USER_CREATE);
		if(prlist == null || prlist.size() ==0){
			throw new PrivException("没有项目权限,不能查看用户管理");
		}
		if(searchCond == null)searchCond = new UserAccountCond();
		String action = CustomerUtils.getActionNameFromRequest(request);
		Pager page = new Pager(ActionContext.getContext(),15,action);	

		if(cbxIncludeHD==true && SessionUser.getUserId()==ContUserId.ADMIN){
			//只有超级管理员以及选择了包括恒大项目,才不加入项目条件
			
			
		} else{
            if(SessionUser.getUserId()==ContUserId.ADMIN){
                //管理员不加项目
            	
            	searchCond.setCompanyProjectIds(null);
            	searchCond.setProjectIds(null);
            	
            } else {
                searchCond.addPermissionCompanyProjectIds(prlist);
            }
		}
		searchCond.recordCount = userAccountServices.findUserAccountCount(searchCond);
		page.setCond(searchCond);
		searchCond.setSearchInclueDeleted();
		this.userlist = userAccountServices.findUserAccountPage(searchCond); 	
		this.roleList = GuangZhouUtils.getGuangZhouRole();
		this.setShowPage(page.toHtmlString());
		
		return "index";
	}

	/**
	 * 删除多个用户
	 * @return
	 * @throws IOException
	 */
	public String delUsers() throws IOException{
		
		ActionTemplate.executeAjaxMethod(true, this, new ActionAjaxMethodModifyNoThrowsExceptionCallback() {
			
			@Override
			public void modifyMethod() throws Exception {

				//判断当前用户的权限是否有这个删除权限
				if(!PermissionUtils.hasPermission(EnumPrivCode.SYSTEM_USER_DELETE, EnumDevFlag.GUANGZHOU) &&
						SessionUser.getUserId() != ContUserId.ADMIN){
					
					throw new Exception();	
				}
				
				List<Integer> idList = CommonUtils.stringToList(ids, "_");
				if(!CommonUtils.isCollectionEmpty(idList)){
					
					for(int id : idList){
						userAccountServices.deleteUserAccount(id);
					}
				}

				
			}
		});
		
		return null;
	}
	
	/**
	 * 初始化排序字段
	 * @param searchCond
	 */
	private void initOrderByFiled(UserAccountCond searchCond){
		
		String sort = searchCond.getSort(); //排序字段
		String order = searchCond.getOrder(); //升序或降序
		
		if("userNameClick".equals(sort)){
			//账号
			if("desc".equals(order)){
				
				searchCond.setOrderByFiled("42");
			}else{
				
				searchCond.setOrderByFiled("41");
			}
			
		}else if("realName".equals(sort)){
			//姓名
			if("desc".equals(order)){
				
				searchCond.setOrderByFiled("52");
			}else{
				
				searchCond.setOrderByFiled("51");
			}
			
		}else if("jobNumber".equals(sort)){
			//工号
			if("desc".equals(order)){
				
				searchCond.setOrderByFiled("62");
			}else{
				
				searchCond.setOrderByFiled("61");
			}
			
		}else if("descProjectId".equals(sort)){
			//项目
			if("desc".equals(order)){
				
				searchCond.setOrderByFiled("72");
			}else{
				
				searchCond.setOrderByFiled("71");
			}

		}
		
	}
	
	////
	
	public List<UserAccount> getUserlist() {
		return userlist;
	}

	public void setUserlist( List<UserAccount> userlist) {
		this.userlist = userlist;
	}

	public UserAccountCond getSearchCond() {
		return searchCond;
	}

	public void setSearchCond(UserAccountCond searchCond) {
		this.searchCond = searchCond;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}	
	
	public boolean getCbxIncludeHD() {
		return cbxIncludeHD;
	}

	public void setCbxIncludeHD(boolean cbxIncludeHD) {
		this.cbxIncludeHD = cbxIncludeHD;
	}
	
}