package com.ihk.user.manager;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.ContDevCode;
import com.ihk.constanttype.EnumDevFlag;
import com.ihk.constanttype.EnumPrivCode;
import com.ihk.permission.PermissionUtils;
import com.ihk.user.data.pojo.Company;
import com.ihk.user.data.pojo.CompanyCond;
import com.ihk.user.data.pojo.Priv;
import com.ihk.user.data.pojo.Role;
import com.ihk.user.data.pojo.RolePriv;
import com.ihk.user.data.pojo.UserAccountCond;
import com.ihk.user.data.pojo.UserRole;
import com.ihk.user.data.pojo.UserRoleCond;
import com.ihk.user.data.services.ICompanyProjectServices;
import com.ihk.user.data.services.ICompanyServices;
import com.ihk.user.data.services.IPrivServices;
import com.ihk.user.data.services.IRolePrivServices;
import com.ihk.user.data.services.IRoleServices;
import com.ihk.user.data.services.IUserAccountServices;
import com.ihk.user.data.services.IUserRoleServices;
import com.ihk.utils.ActionAjaxFieldPageCallback;
import com.ihk.utils.ActionTemplate;
import com.ihk.utils.CommonPojoUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.GuangZhouUtils;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;
import com.ihk.utils.exception.PrivException;
import com.ihk.utils.method.ActionAjaxMethodModifyCallback;

/**
 * 用户的角色权限操作
 * */
@SuppressWarnings("rawtypes")
public class UserRoleAction extends SupperAction{
    private static final long serialVersionUID = 1L;
    @Autowired IUserAccountServices userAccountServices;
    @Autowired IUserRoleServices userRoleServices;
    @Autowired ICompanyProjectServices companyProjectServices;
    @Autowired ICompanyServices companyServices;
    @Autowired IRoleServices roleServices;
    @Autowired IPrivServices iPrivServices;
    @Autowired IRolePrivServices iRolePrivServices;
	
	private UserAccountCond searchCond;//搜索表单条件
	
	

//    private UserAccount userAccount;
    private List<Role> roleList;
    private List<Company> companyList;

    private int[] companyIds;
    private String projectIds;
    private int[] roleIds;
    private int userId;

    private int roleid;
    private String roleName;
    private String roleDesc;
    private String devFlag;
    private int companyId;
    private String isDeleted;
    private String createdTime;
    private String privCode;
    private String privName;
    private String remark;

    private int orderIndex=999;

    List<Priv>  privlist;
    List<RolePriv>  roleprivlist;
    
	List chkboxPrivId;
	
	private String date1;
	
	private String date2;

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getPrivCode() {
        return privCode;
    }

    public void setPrivCode(String privCode) {
        this.privCode = privCode;
    }

    public String getPrivName() {
        return privName;
    }

    public void setPrivName(String privName) {
        this.privName = privName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List getChkboxPrivId() {
        return chkboxPrivId;
    }

    public void setChkboxPrivId(List chkboxPrivId) {
        this.chkboxPrivId = chkboxPrivId;
    }

    public List<RolePriv> getRoleprivlist() {
        return roleprivlist;
    }

    public void setRoleprivlist(List<RolePriv> roleprivlist) {
        this.roleprivlist = roleprivlist;
    }

    public List<Priv> getPrivlist() {
        return privlist;
    }

    public void setPrivlist(List<Priv> privlist) {
        this.privlist = privlist;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getDeleted() {
        return isDeleted;
    }

    public void setDeleted(String deleted) {
        isDeleted = deleted;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public String getDevFlag() {
        return devFlag;
    }

    public void setDevFlag(String devFlag) {
        this.devFlag = devFlag;
    }

    public int getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(int orderIndex) {
        this.orderIndex = orderIndex;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public List<Company> getCompanyList() {
        return companyList;
    }

    public void setCompanyList(List<Company> companyList) {
        this.companyList = companyList;
    }

    public int[] getCompanyIds() {
        return companyIds;
    }

    public void setCompanyIds(int[] companyIds) {
        this.companyIds = companyIds;
    }

    public String getProjectIds() {
        return projectIds;
    }

    public void setProjectIds(String projectIds) {
        this.projectIds = projectIds;
    }

    public int[] getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(int[] roleIds) {
        this.roleIds = roleIds;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    
	public UserAccountCond getSearchCond() {
		return searchCond;
	}

	public void setSearchCond(UserAccountCond searchCond) {
		this.searchCond = searchCond;
	}

    /**
     * 新建用户的角色权限(页面初始)
     * @return
     */
    public String inputUserRole(){
        this.roleList = GuangZhouUtils.getGuangZhouRole(SessionUser.getCompanyId());
        CompanyCond cond = new CompanyCond();
        cond.setCompanyIds(PermissionUtils.getUserCompanyIdList());
        cond.setDevCode(ContDevCode.CUSTOMER_GUANGZHOU);
		cond.topNum = 0;
        this.companyList = companyServices.findCompany(cond);
        return "success";
    }


    /**
     * 新建用户角色的提交
     * @return
     */
    public String submitUserRole(){

        ActionTemplate.executeAjaxMethod(true,this, new ActionAjaxMethodModifyCallback() {

            @Override
            public void modifyMethodException(Exception e) {
                setUpEasyuiAjaxForFail(e.getMessage());
            }

            @Override
            public void modifyMethod() throws Exception {
                if(!PermissionUtils.hasPermission(EnumPrivCode.SYSTEM_POWER_CREATE, EnumDevFlag.GUANGZHOU)){
                    throw new Exception("权限不够");
                }
                if(companyIds.length<=0
                        && projectIds.isEmpty()){
                    throw new Exception("必须选择公司列或项目列");
                }
                if(companyIds.length>0
                        && projectIds.isEmpty()==false){
                    throw new Exception("不能同时选择公司列与项目列");
                }
                if(roleIds.length<=0){
                    throw new Exception("必须选择角色");
                }

                //根据公司,角色进行循环，新增数据
                for(int i=0;i<companyIds.length;i++){
                    for(int j=0;j<roleIds.length;j++){
                        UserRole userRole = new UserRole();
                        CommonPojoUtils.initPojoCommonFiled(userRole);
                        userRole.setCompanyId(companyIds[i]);
                        userRole.setRoleId(roleIds[j]);
                        userRole.setUserId(userId);

                        userRoleServices.addUserRole(userRole);
                    }
                }

                if(!projectIds.isEmpty()){
                    String strPids[]=projectIds.split(",");
                    //根据项目,角色进行循环，新增数据
                    for(int i=0;i<strPids.length;i++){
                        int pid=0;
                        try{
                            pid = Integer.parseInt(strPids[i]);
                        }
                        catch(Exception e){
                            continue;
                        }
                        if(pid<=0){
                            continue;
                        }
                        for(int j=0;j<roleIds.length;j++){
                            UserRole userRole = new UserRole();
                            CommonPojoUtils.initPojoCommonFiled(userRole);
                            userRole.setCompanyId(DescUtils.getCompanyIdByProjectId(pid));
                            userRole.setProjectId(pid);
                            userRole.setRoleId(roleIds[j]);
                            userRole.setUserId(userId);

                            userRoleServices.addUserRole(userRole);
                        }
                    }
                }
            }
        });

        return null;
    }
    public String addRoleFirst(){
        initCompanyList();
        return "success";
    }

    /**
     * 保存新增角色
     * @return
     */
    public String addRole(){
        ActionTemplate.executeAjaxMethod(true,this, new ActionAjaxMethodModifyCallback() {

            @Override
            public void modifyMethodException(Exception e) {
                setUpEasyuiAjaxForFail(e.getMessage());
            }

            @Override
            public void modifyMethod() throws Exception {
                if(!PermissionUtils.hasPermission(EnumPrivCode.SYSTEM_POWER_CREATE, EnumDevFlag.GUANGZHOU)){
                    throw new Exception("权限不够");
                }
                if(roleName.trim().length()==0){
                    throw new Exception("必须填写角色名称");
                }
                if(devFlag.trim().length()==0){
                    throw new Exception("必须填写开发标记");
                }

                Date today = new Date();
                Role role = new Role();
                role.setRoleName(roleName);
                role.setRoleDesc(roleDesc);
                role.setDevFlag(devFlag);
                role.setOrderIndex(orderIndex);
                role.setCompanyId(companyId);

                role.setIsDeleted("0");
                role.setCreatedId(SessionUser.getUserId());
                role.setCreatedTime(today);
                role.setModTime(today);
                role.setModId(SessionUser.getUserId());
                roleServices.addRole(role);
            }
        });
        return null;
    }

    /**
     * 保存修改角色
     * @return
     */
    public String updateRole(){
        ActionTemplate.executeAjaxMethod(true,this, new ActionAjaxMethodModifyCallback() {

            @Override
            public void modifyMethodException(Exception e) {
                setUpEasyuiAjaxForFail(e.getMessage());
            }

            @Override
            public void modifyMethod() throws Exception {
                if(!PermissionUtils.hasPermission(EnumPrivCode.SYSTEM_POWER_CREATE, EnumDevFlag.GUANGZHOU)){
                    throw new Exception("权限不够");
                }
                if(roleName.trim().length()==0){
                    throw new Exception("必须填写角色名称");
                }
                if(devFlag.trim().length()==0){
                    throw new Exception("必须填写开发标记");
                }

                Date today = new Date();
                Role role = new Role();
                role.setId(roleid);
                role.setRoleName(roleName);
                role.setRoleDesc(roleDesc);
                role.setDevFlag(devFlag);
                role.setOrderIndex(orderIndex);
                role.setCompanyId(companyId);

                role.setIsDeleted("0");
                //role.setCreatedId(SessionUser.getUserId());
                //role.setCreatedTime(today);
                role.setModTime(today);
                role.setModId(SessionUser.getUserId());
                roleServices.updateRole(role);
            }
        });
        return null;
    }

    /**
     * 编辑角色
     * @return
     */
    public String editRole(){
        initCompanyList();

        Role role = roleServices.findRoleById(this.roleid);
        setRoleid(role.getId());
        setRoleName(role.getRoleName());
        setRoleDesc(role.getRoleDesc());
        setDevFlag(role.getDevFlag());
        setOrderIndex(role.getOrderIndex());
        setCompanyId(role.getCompanyId());
        setDeleted(role.getIsDeleted());
        setCreatedTime(CommonUtils.getDateString(role.getCreatedTime()));

        return "update";
    }

    /**
     * 编辑角色权限
     * @return
     */
    public String editRolePriv(){
        privlist = iPrivServices.findAll();

        roleprivlist = iRolePrivServices.findRolePrivByRoleId(this.roleid);

        return "update";
    }

    /**
     * 保存修改角色权限
     * @return
     */
    public String updateRolePriv(){
        ActionTemplate.executeAjaxMethod(true,this, new ActionAjaxMethodModifyCallback() {

            @Override
            public void modifyMethodException(Exception e) {
                setUpEasyuiAjaxForFail(e.getMessage());
            }

            @Override
            public void modifyMethod() throws Exception {
                if(!PermissionUtils.hasPermission(EnumPrivCode.SYSTEM_POWER_CREATE, EnumDevFlag.GUANGZHOU)){
                    throw new Exception("权限不够");
                }
                Date today = new Date();
                iRolePrivServices.deleteRolePrivByRoleId(roleid);
                if(chkboxPrivId!=null){
                    Iterator it = chkboxPrivId.iterator();
                    while(it.hasNext()){
                        String privid = it.next().toString();
                        RolePriv rolePriv = new RolePriv();
                        rolePriv.setPrivId(Integer.parseInt(privid));
                        rolePriv.setRoleId(roleid);
                        rolePriv.setIsHave("1");
                        rolePriv.setIsDeleted("0");
                        rolePriv.setCreatedId(SessionUser.getUserId());
                        rolePriv.setCreatedTime(today);
                        rolePriv.setModTime(today);
                        rolePriv.setModId(SessionUser.getUserId());

                        iRolePrivServices.addRolePriv(rolePriv);
                        //System.out.println(""+it.next());
                    }
                }
            }
        });
        return null;
    }

    /**
     * 保存新增权限
     * @return
     */
    public String addPriv(){
        ActionTemplate.executeAjaxMethod(true,this, new ActionAjaxMethodModifyCallback() {

            @Override
            public void modifyMethodException(Exception e) {
                setUpEasyuiAjaxForFail(e.getMessage());
            }

            @Override
            public void modifyMethod() throws Exception {
                if(!PermissionUtils.hasPermission(EnumPrivCode.SYSTEM_POWER_CREATE, EnumDevFlag.GUANGZHOU)){
                    throw new Exception("权限不够");
                }
                if(privName.trim().length()==0){
                    throw new Exception("必须填写角色名称");
                }
                if(privCode.trim().length()==0){
                    throw new Exception("必须填写开发标记");
                }

                Priv priv = new Priv();
                priv.setPrivName(privName);
                priv.setPrivCode(privCode);
                priv.setDevFlag(devFlag);
                priv.setOrderIndex(orderIndex);


                iPrivServices.addPriv(priv);
            }
        });
        return null;
    }

    private void initCompanyList(){
        CompanyCond cond = new CompanyCond();
        cond.setCompanyIds(PermissionUtils.getUserCompanyIdList());
        companyList = this.companyServices.findCompany(cond);
    }

    public String copyRoleForm() throws Exception{
    	initCompanyList();
    	Role role = roleServices.findRoleById(this.roleid);
    	setRoleid(role.getId());
        setRoleName(role.getRoleName());
        setRoleDesc(role.getRoleDesc());
        setDevFlag(role.getDevFlag());
        setOrderIndex(role.getOrderIndex());
        setCompanyId(role.getCompanyId());
        setDeleted(role.getIsDeleted());
        setCreatedTime(CommonUtils.getDateString(role.getCreatedTime()));
    	return "copyRole";
    }
    
    public String copyRole(){
    	ActionTemplate.executeAjaxMethod(true,this, new ActionAjaxMethodModifyCallback() {

            @Override
            public void modifyMethodException(Exception e) {
                setUpEasyuiAjaxForFail(e.getMessage());
            }

            @Override
            public void modifyMethod() throws Exception {
                if(!PermissionUtils.hasPermission(EnumPrivCode.SYSTEM_POWER_CREATE, EnumDevFlag.GUANGZHOU)){
                    throw new Exception("权限不够");
                }
                if(roleName.trim().length()==0){
                    throw new Exception("必须填写角色名称");
                }
                if(devFlag.trim().length()==0){
                    throw new Exception("必须填写开发标记");
                }

                Date today = new Date();
                Role role = new Role();
                role.setRoleName(roleName);
                role.setRoleDesc(roleDesc);
                role.setDevFlag(devFlag);
                role.setOrderIndex(orderIndex);
                role.setCompanyId(companyId);

                role.setIsDeleted("0");
                role.setCreatedId(SessionUser.getUserId());
                role.setCreatedTime(today);
                role.setModTime(today);
                role.setModId(SessionUser.getUserId());
                roleServices.addRole(role);
                //复制权限
                int nowRoleId = role.getId();
                List<RolePriv>  srcRoleprivlist = iRolePrivServices.findRolePrivByRoleId(roleid);
                for (RolePriv src : srcRoleprivlist) {
                	src.setIsHave("1");
                	src.setIsDeleted("0");
                	src.setCreatedId(SessionUser.getUserId());
                	src.setCreatedTime(today);
                	src.setModTime(today);
                	src.setModId(SessionUser.getUserId());
                	src.setRoleId(nowRoleId);
                	iRolePrivServices.addRolePriv(src);
				}
            }
        });
    	return null;
    }

    private String selectId;
	/**
	 * 替换角色
	 * @return
	 */
	public String replaceRole() throws Exception{
		
		final UserRoleCond cond = new UserRoleCond();
		String roleId = request.getParameter("roleid");
		if(roleId==null)
			roleId = "-1";
		String date1 = request.getParameter("date1");
		String date2 = request.getParameter("date2");
		String newRoleId = request.getParameter("selectId");
		cond.setNewRoleId(newRoleId);
		cond.setRoleId(roleId);
		cond.setDate1(date1);
		cond.setDate2(date2);
		List<Integer> prlist = PermissionUtils
				.getUserProjectIdList(EnumPrivCode.SYSTEM_USER_CREATE);
		if (CommonUtils.isCollectionEmpty(prlist)) {
			throw new PrivException("没有项目权限,不能查看用户管理");
		}

		// 选择的项目,如果为空就为prList;否则为两者交集
		String projectIdstr = request.getParameter("projectIds");
		String[] projectIds=new String[]{};
		if(projectIdstr!=null){
			 projectIds = projectIdstr.split(",");
		}
		
		List<Integer> intList = CommonUtils.stringListToIntList(projectIds); // 选择的项目

		if (!CommonUtils.isCollectionEmpty(intList)) {

			List<Integer> endList = CommonUtils.listIntersection(prlist,
					intList); // 交集
			cond.setProjectIds(endList);

		} else {

			cond.setProjectIds(prlist);
		}
		ActionTemplate.executeAjaxMethod(this, new ActionAjaxMethodModifyCallback() {
			
			@Override
			public void modifyMethod() throws Exception {
				userRoleServices.replaceRole(cond);
				//throw new Exception();
			}
			@Override
			public void modifyMethodException(Exception e) {
				LOG.error("替换角色出错", e.toString());
			}
		});
		return null;
	}

	public String replaceRoleFrist() throws Exception {
		;
		this.roleid = Integer.valueOf(request.getParameter("roleId"));
		roleName = roleServices.findRoleById(roleid).getRoleName();
		roleList = GuangZhouUtils.getGuangZhouRole(SessionUser.getCompanyId());
		String[] projectIds = request.getParameterValues("pn");
		StringBuilder builder = new StringBuilder();
		for (String string : projectIds) {
			builder.append(string + ",");
		}
		this.projectIds = builder.toString();
		return SUCCESS;
	}

	public String ajaxSearchRoleFrist() throws Exception {
		roleList = GuangZhouUtils.getGuangZhouRole();
		return SUCCESS;
	}

/**
 * @return
 * @throws Exception
 */
	public String ajaxSearchRole() throws Exception {
		final UserRoleCond cond = new UserRoleCond();
		String roleId = request.getParameter("roleId");
		if(roleId==null)
			roleId = "-1";
		String date1 = request.getParameter("date1");
		String date2 = request.getParameter("date2");
		cond.setRoleId(roleId);
		cond.setDate1(date1);
		cond.setDate2(date2);
		List<Integer> prlist = PermissionUtils
				.getUserProjectIdList(EnumPrivCode.SYSTEM_USER_CREATE);
		if (CommonUtils.isCollectionEmpty(prlist)) {
			throw new PrivException("没有项目权限,不能查看用户管理");
		}

		// 选择的项目,如果为空就为prList;否则为两者交集
		String[] projectIds = request.getParameterValues("pn");
		List<Integer> intList = CommonUtils.stringListToIntList(projectIds); // 选择的项目

		if (!CommonUtils.isCollectionEmpty(intList)) {

			List<Integer> endList = CommonUtils.listIntersection(prlist,
					intList); // 交集
			cond.setProjectIds(endList);

		} else {

			cond.setProjectIds(prlist);
		}
		ActionTemplate.executeAjaxPage(this, cond,
				new ActionAjaxFieldPageCallback() {

					@Override
					public int initTotal() throws Exception {

						return 0;
					}

					@Override
					public List<?> initRows() throws Exception {

						return userRoleServices.findRoleByCond(cond);
					}

				}, "id", "userNameClick", "realName", "descCompanyId",
				"descProjectId", "mobilePhone", "createdTimeStr", "modTimeStr",
				"remark", "jobNumber", "isDeleted", "descIsDeleted",
				"changePwd");

		return null;
	}

public String getSelectId() {
	return selectId;
}

public void setSelectId(String selectId) {
	this.selectId = selectId;
}

public String getDate1() {
	return date1;
}

public void setDate1(String date1) {
	this.date1 = date1;
}

public String getDate2() {
	return date2;
}

public void setDate2(String date2) {
	this.date2 = date2;
}
}
