<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title></title>
<s:include value="../../header/header_easyui.jsp"></s:include>
<s:include value="coder_header.jsp"></s:include>
</head>

<body  style="padding:10px;">
<b>常用权限类说明：</b>

<br/>

<p></p>
<p><b>参考：</b></p>
<p>com.ihk.permission.PermissionUtils.java<br/>
  
  <br/>
  <b>如何在action中判断如果没有权限，就跳出指定报错页面，不再显示原有页面</b><br/>
  UserAccountManagerAction中<br>
  </br>代码写为：<br>  </br>
  if(prlist == null || prlist.size() ==0){
			throw new PrivException("没有项目权限,不能查看用户管理");
		}
		
		<br/>
		struts-base.xml里面配置页面报错跳到哪个页面<br/>
		原有的struts配置文件，要修改为extends="struts-base"<br/>
		
  
</p>
<p></p>
<b>主要代码说明：</b>
<br/>
<br/>
<b>代码示例：</b><br/>
<textarea rows="80" cols="150">
 方法摘要
static void 	doCheckAdminOrOwner(java.lang.String loggerMessage, int ownerId)
          检验是否管理员或者创建者
static void 	doCheckLogin(java.lang.String loggerMessage)
          检验是否已经登录
static java.util.List 	findUserPriv(int userId)
          指定用户的实际权限列表
static java.util.List<com.ihk.user.data.pojo.CompanyProject> 	getAddCustomerCompanyProject()
          当前用户可以录客的项目
static java.util.List<java.lang.Integer> 	getCompanyAllProjectIdsByCompanys(java.util.List<java.lang.Integer> companyIds)
          取得公司所有的子项目id（包括子公司递归）
static java.util.List<com.ihk.user.data.pojo.CompanyProject> 	getCompanyProjectListByIds(java.util.List<java.lang.Integer> projectIds)
          根据项目id list获取对应的项目list
static java.util.List<com.ihk.user.data.pojo.CompanyProject> 	getCompanyProjectListByRoleId(int roleId)
          根据角色id获取对应的项目列表
static java.util.List<com.ihk.user.data.pojo.CompanyProject> 	getCompanyProjectListBySQKH()
          售前客户角色
static java.util.List<com.ihk.user.data.pojo.CompanyProject> 	getCompanyProjectListByXKZX()
          销控中心能查看的公司项目 报表里面能查看的公司项目
static java.util.List<java.lang.Integer> 	getProjectIdListByXKZX()
          销控role对应的CompanyProject id 销控中心拥有的公司项目
static java.util.List<java.lang.String> 	getProjectNameListByXKZX()
          销控role对应的CompanyProject name 销控中心拥有的公司项目
static java.util.List<com.ihk.property.data.pojo.PropertyProject> 	getPropertyProjectListByXKZX()
          当前用户，销控role对应的楼盘项目列表 销控中心拥有的楼盘项目
static java.util.List<java.lang.Integer> 	getUserCompanyIdList()
          当前用户拥有的公司id列表
static java.util.List<java.lang.Integer> 	getUserCompanyIdListByUid(int userId)
          指定用户拥有的公司id列表
static java.util.List<java.lang.Integer> 	getUserCompanyIdListByUid(int userId, com.ihk.constanttype.EnumPrivCode privCode)
          指定用户，指定权限，拥有的公司id列表
static java.util.List<com.ihk.user.data.pojo.Company> 	getUserCompanyList()
          当前用户拥有的公司列表（用户所有能看的公司）
static java.util.List<com.ihk.user.data.pojo.Company> 	getUserCompanyListByUid(int userId)
          指定用户拥有的公司列表(取得项目，然后再反查出公司)
static java.util.List<com.ihk.user.data.pojo.RolePriv> 	getUserPrivList()
          当前用户对应所有项目的权限
static java.util.List<com.ihk.user.data.pojo.RolePriv> 	getUserPrivListByUid(int userId)
          指定用户对应所有项目的权限
static java.util.List<java.lang.Integer> 	getUserProjectIdList()
          当前用户，拥有的公司项目id列表
static java.util.List<java.lang.Integer> 	getUserProjectIdList(com.ihk.constanttype.EnumPrivCode privCode)
          当前用户，指定权限，拥有的公司项目id列表
static java.util.List<java.lang.Integer> 	getUserProjectIdListByUid(int userId)
          指定用户,拥有的公司项目id列表
static java.util.List<java.lang.Integer> 	getUserProjectIdListByUid(int userId, com.ihk.constanttype.EnumPrivCode privCode)
          指定用户，指定权限，拥有的公司项目id列表
static java.util.List<com.ihk.user.data.pojo.CompanyProject> 	getUserProjectList()
          当前用户,拥有的公司项目列表
static java.util.List<com.ihk.user.data.pojo.CompanyProject> 	getUserProjectList(com.ihk.constanttype.EnumPrivCode privCode, com.ihk.constanttype.EnumDevFlag devFlag)
          当前用户拥有的某权限的项目列表
 
static java.util.List<com.ihk.user.data.pojo.CompanyProject> 	getUserProjectListByUid(com.ihk.constanttype.EnumPrivCode privCode, com.ihk.constanttype.EnumDevFlag devFlag, int userId)
          指定用户拥有的某权限的项目列表 ?
static java.util.List<com.ihk.user.data.pojo.CompanyProject> 	getUserProjectListByUid(int userId)
          指定用户，拥有的公司项目列表
static java.util.List<com.ihk.user.data.pojo.UserRole> 	getUserRoleForLayoutLeft()
          左边导航树的选择
static java.util.List<com.ihk.user.data.pojo.Role> 	getUserRoleList()
          当前用户拥有的角色
static java.util.List<com.ihk.user.data.pojo.Role> 	getUserRoleList(com.ihk.constanttype.EnumPrivCode privCode, com.ihk.constanttype.EnumDevFlag devFlag)
          当前用户，指定权限，指定开发代号，拥有的角色
static java.util.List<com.ihk.user.data.pojo.Role> 	getUserRoleListByProjectId(int projectId)
          当前用户，在指定项目中拥有的角色
static java.util.List<com.ihk.user.data.pojo.Role> 	getUserRoleListByProjectIdUid(int projectId, int userId)
          指定用户，在指定项目中拥有的角色
static java.util.List<com.ihk.user.data.pojo.Role> 	getUserRoleListByUid(com.ihk.constanttype.EnumPrivCode privCode, com.ihk.constanttype.EnumDevFlag devFlag, int userId)
          指定用户，指定权限，指定开发代号，拥有的角色
static java.util.List<com.ihk.user.data.pojo.Role> 	getUserRoleListByUid(int userId)
          指定用户拥有的角色
static java.util.List<com.ihk.user.data.pojo.UserRole> 	getUserRoleListByUserIdAndRoleId(int userId, int roleId)
          指定用户,指定角色 ，查询用户角色关系列表
static java.util.Map<java.lang.String,java.lang.String> 	getUserRoleMapForLayoutLeft()
          左边导航树的选择的Map
static boolean 	hasPermission(com.ihk.constanttype.EnumPrivCode privCode, com.ihk.constanttype.EnumDevFlag devFlag)
          当前用户是否具备某权限（只要有任一角色有权限，则视为有权限）
static boolean 	hasPermission(int projectId, com.ihk.constanttype.EnumPrivCode privCode, com.ihk.constanttype.EnumDevFlag devFlag)
          当前用户是否具备某项目的某权限
static boolean 	hasPermissionByUid(com.ihk.constanttype.EnumPrivCode privCode, com.ihk.constanttype.EnumDevFlag devFlag, int userId)
          指定用户是否具备某权限（只要有任一角色有权限，则视为有权限）
static boolean 	hasPermissionByUid(int projectId, com.ihk.constanttype.EnumPrivCode privCode, com.ihk.constanttype.EnumDevFlag devFlag, int userId)
          指定用户是否具备某项目的某权限
 void 	init()
          静态方法的初始化,用于applicationContext
static boolean 	isHaveThisRole(int roleId)
          当前用户是否具有该角色
static boolean 	isMultiCompany()
          当前用户是否跨公司(有多个公司操作权)
static boolean 	isMultiCompanyByUid(int userId)
          指定用户是否跨公司(有多个公司操作权)
static boolean 	isMultiProject()
          当前用户是否跨项目(多个项目的操作权)
static boolean 	isMultiProjectByUid(int userId)
          指定用户是否跨项目(多个项目的操作权)
static boolean 	isReportMultiCompany()
          当前用户的报表权限是否跨公司：首页的多公司管理员判别
static boolean 	isReportMultiCompany(int userId)
          当前用户的报表权限是否跨公司：首页的多公司管理员判别
static boolean 	isReportMultiProject()
          当前用户的报表权限是否跨项目：首页的多项目管理员判别
static boolean 	isReportMultiProject(int userId)
          当前用户的报表权限是否跨项目：首页的多项目管理员判别 如果是多公司管理员，本方法也返回false
static boolean 	isReportOneProject()
          当前用户的报表权限是否单项目：首页的单项目管理员判别
static boolean 	isReportOneProject(int userId)
          当前用户的报表权限是否单项目：首页的单项目管理员判别
static boolean 	isReportOnlySale()
          当前用户的报表权限是否纯销售人员：首页的纯销售人员判别
static boolean 	isReportOnlySale(int userId)
          当前用户的报表权限是否纯销售人员：首页的纯销售人员判别
 
</textarea>
<br/>

</body>
</html>

