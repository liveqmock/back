<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@ page import="com.ihk.utils.SessionUser" %>
<%@ page import="com.ihk.constanttype.ContUserId" %>
<%@ page import="com.ihk.constanttype.EnumDevFlag" %>
<%@ page import="com.ihk.constanttype.EnumPrivCode" %>
<%@ page import="com.ihk.permission.PermissionUtils" %>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<s:include value="../../header/header_easyui.jsp"></s:include>
		<script type="text/javascript" src="<%=basePath%>js/list.checkbox.js"></script>
		<script language="javascript" type="text/javascript" src="<%=basePath%>js/project.list.utils.js?v=1.3"></script>

		<title>用户管理</title>
		
		<base href="<%=basePath%>" />		
<style>
* {
	margin: 0;
	padding: 0;
}

html,body {
	height: 100%;
	width: 100%;
}
</style>
		<script type="text/javascript">			
		//新建用户账户
		function dialog_input_user(){		
			new MyAjaxIframeDialog({title:'新建用户账户', formId:'inputform',
				height:450,
				src:'./user/manager/inputUser.action',
				ids:['userName','userPwd','realName'],
				closeFn:function(){$("#queryForm").submit();}
				});		
		}
		
		//批量新建用户账户
		function batAddUsers(){		
			new MyAjaxIframeDialog({title:'批量新建用户账户', formId:'inputform',
				height:650,
				src:'./user/manager/batInputUser.action',
				ids:['hiddenId','selRoleId'],
				closeFn:function(){$("#queryForm").submit();}
				});		
		}

		//查看修改用户
		function dialog_update_user(user_id){
		
			new MyAjaxIframeDialog({title:'查看/修改用户', formId:'inputform',
				width:650,
				height:550,
				src:'./user/manager/updateUser.action?userId='+user_id,
				buttons:false,
				closeFn:function(){$("#queryForm").submit();}
				});					
		}
		
		//删除多个用户
		function delUsers() {			
			var ids=getSelectOneStr('_');
			if (ids != "") {
				deletePojo('./user/manager/delUsers.action?ids='+ids, function(){
					$("#queryForm").submit();
				},'');

			} else {
				myAlert("请选择删除项.");
				return false;
			}
		}	
		
		$().ready(function(){				
			bindProjectDialogForRYSQ("projectName", "hiddenId"); //多个项目的选择
		});	
		
		
	</script>

	</head>
	<body style="margin-top: 5px;">

		<form method="post" id="queryForm" action="./user/manager/index.action">
			&nbsp; 帐号
			<input size="10" type="text" name="searchCond.userName"
				value="${searchCond.userName}" />
			&nbsp; 姓名
			<input size="10" type="text" id="realName" name="searchCond.realName"
				maxlength="10" value="${searchCond.realName}" />
	     	&nbsp;项目<input type="text" id="projectName" size="40" name="projectName" value="${searchCond.strSearchCompanyProjectNames}"/>
			<input type="hidden" id="hiddenId" name="searchCond.strSearchCompanyProjectIds" value="${searchCond.strSearchCompanyProjectIds}"/>
			&nbsp; 角色
			<s:select list="roleList" listValue="roleName" listKey="id"
				name="searchCond.roleId" headerKey="" headerValue="全部"></s:select>
			&nbsp; 创建日期
				<input name="searchCond.date1" value="${searchCond.date1}"  class="easyui-datebox" style="width:90px"/>
			-
			<input name="searchCond.date2" value="${searchCond.date2}"  class="easyui-datebox" style="width:90px"/>
			&nbsp;
            <input type="submit" name="button3" id="button3" value=" 搜索 " align="left" />

            <%if(PermissionUtils.hasPermission(EnumPrivCode.SYSTEM_USER_CREATE, EnumDevFlag.GUANGZHOU) || SessionUser.getUserId() == ContUserId.ADMIN){%>
            <input type="button" onclick="dialog_input_user()"  value=" 新建 " align="left" />
            <%} %>


            <br/>
            <%if(PermissionUtils.hasPermission(EnumPrivCode.SYSTEM_USER_DELETE, EnumDevFlag.GUANGZHOU) || SessionUser.getUserId() == ContUserId.ADMIN){%>
            <input  type="button" value=" 删除  "  onclick="delUsers()"/>
            <%} %>
            <%if(SessionUser.getUserId() == ContUserId.ADMIN){%>
            <input  type="button" value=" 批量新建  "  onclick="batAddUsers()"/>
            <s:checkbox label="是否包括恒大项目" name="cbxIncludeHD" theme="xhtml"></s:checkbox>
            <%} %>
			<s:actionmessage cssStyle="color:red" />
		</form>

		<!-- 搜索表单 end -->

		<div class="blueline" style="margin-top: 5px;"></div>

		<table width="100%" border="0" align="left" cellpadding="0"
			cellspacing="1" class="gbox">
			<tr class="gboxbg" style="line-height: 14px;font-weight: bold;">
				<td width="25px" align="center">
					<input type="checkbox" id="selectAll" name="selectAll" onclick="selectAllCheckbox()" />
				</td>

				<td width="100px" align="center">
					账号
				</td>
				<td width="100px" align="center">
					姓名
				</td>
				<td width="100px" align="center">
					公司
				</td>
				<td width="180px" align="center">
					项目
				</td>
				<td width="197px" align="center">
					手机号
				</td>
                <td width="188px" align="center">
                    部门
                </td>
                <td width="188px" align="center">
					创建时间
				</td>
				<td width="188px" align="center">
					修改时间
				</td>
				<td width="88px" align="center">
					 状态
				</td>
			</tr>


            <%
                int isadmin = ContUserId.ADMIN.intValue();
                request.setAttribute("isadmin",isadmin);
            %>

			<s:iterator value="userlist" id="u">
				<tr onMouseOver="this.style.backgroundColor='#f1f9fe'"
					onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="line-height: 24px">
					<td align="center" valign="middle">
						<input name="selectOne" type="checkbox"
							value="<s:property value='id'/>" onclick="selectOneCheckbox()" />
					</td>
					<td align="center" valign="middle" class="fontblue">

                        <s:if test="#session.loginAccount.id == #request.isadmin|| #session.loginAccount.id!=#u.id">
                            <a style="color: #1199FF;cursor: pointer;" class="ablue"
                               onclick="dialog_update_user(${u.id});"
                               target="_self"> &nbsp;<s:property value="userName" />
                            </a>
                        </s:if>
                        <s:else>
                            &nbsp;<s:property value="userName" />
                        </s:else>
 					</td>


					<td align="center" valign="middle">
						<s:property value="realName" />
					</td>
					<td align="center" valign="middle">
						<s:property value="descCompanyId" />
					</td>
					<td align="center" valign="middle">
						<s:property value="descProjectId" />
					</td>
					<td align="center" valign="middle">
						<s:property value="mobilePhone" />
					</td>
					<td align="center" valign="middle">
						<s:property value="remark" />
					</td>
                    <td align="center" valign="middle">
                        <s:date name="#request.createdTime" format="yyyy-MM-dd HH:mm:ss"/>
                    </td>
					<td align="center" valign="middle">
                        <s:date name="#request.modTime" format="yyyy-MM-dd HH:mm:ss"/>
                    </td>
					<td align="center" valign="middle">
						<s:property value="descIsDeleted" />
					</td>
				</tr>

			</s:iterator>


		<tr>
			<td colspan="10" align="center" style="background-color: #ffffff">
				<div class="manu">
					<s:property value="showPage" escape="false" />
				</div>
			</td>
		</tr>
		</table>
		
		
		<div id="new_dialog" class="easyui-dialog" closed="true" modal="true" title="标题" style="display:block;width:800px;height:400px; overflow-x:hidden">
    <iframe scrolling="auto" id='new_dialog_ifram' frameborder="0"  src="./saleunit_new/guangzhou/loading.jsp" style="width:100%;height:100%;"></iframe>
</div>
	</body>
</html>

