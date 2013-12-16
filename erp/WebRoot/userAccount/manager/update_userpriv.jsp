<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
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
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<s:include value="../../header/header_easyui.jsp"></s:include>
		<script type="text/javascript" src="<%=basePath%>js/list.checkbox.js"></script>
		<script language="javascript" type="text/javascript" src="<%=basePath%>js/project.list.utils.js?v=1.2"></script>
		
	<script type="text/javascript">	
		//初始化密码	
		function initPwd(uid){
			parent.$.messager.confirm('初始化密码','是否确认初始化密码为 a123456?',function(r){   
			    if (r){   
					$.ajax({
						type: "post",
						url: "./user/manager/initPwd.action",
						data: {'initId':uid},
						dataType: "json",		
						success: function(data){						
							if(data.type == "true"){
								parent.myAlert("修改密码成功！");
							}else{
								parent.myAlert("失败:"+data.title);
							}
						}
					});
			     }   
			});  
		}

		//删除账户
		function delUser(uid){
			parent.$.messager.confirm('删除账户','是否确认删除?成功后此账户将不能使用.',function(r){   
			    if (r){   
					$.ajax({
						type: "post",
						url: "./user/manager/delUser.action",
						data: {'initId':uid},
						dataType: "json",		
						success: function(data){						
							if(data.type == "true"){
								parent.myAlert("删除成功！");
								parent.$('#myIframeDialog').dialog('close');
							}else{
								parent.myAlert("失败:"+data.title);
							}
						}
					});
			     }   
			});  
		}
		
		//恢复账户
		function undoDelUser(uid){    
			$.ajax({
				type: "post",
				url: "./user/manager/undoDelUser.action",
				data: {'initId':uid},
				dataType: "json",		
				success: function(data){						
					if(data.type == "true"){
						parent.myAlert("恢复成功！");
						parent.$('#myIframeDialog').dialog('close');
					}else{
						parent.myAlert("失败:"+data.title);
					}
				}
			});
		}
		
		//保存基本信息
		function saveBaseInfo(){
				$.ajax({
					type: "post",
					url: "./user/manager/updateUserForm.action",
					data: $("#update_user_info").serialize(),
					dataType: "json",		
					success: function(data){						
						if(data.type == "true"){
							parent.myAlert("修改成功！");
						}else{
							parent.myAlert("失败:"+data.title);
						}
					}
				});
				
				return false;
		}
		
		//删除角色
		function delUserRole(userRoleId){ 
			$.ajax({
				type: "post",
				url: "./user/manager/delUserRole.action",
				data: {'userRoleId':userRoleId},
				dataType: "json",		
				success: function(data){						
					if(data.type == "true"){
						//页面重新加载
						location.href = location.href;
					}else{
						parent.myAlert("失败:"+data.title);
					}
				}
			});
		}
		
		//删除多个角色权限
		function delUserRoles() {			
			var ids=getSelectOneStr('_');
			if (ids != "") {
				deletePojo('./user/manager/delUserRoles.action?userRoleIds='+ids, function(){
					//页面重新加载
					location.href = location.href;
				},'');

			} else {
				parent.myAlert("请选择删除项.");
				return false;
			}
		}	
		
		$().ready(function(){
			bindProjectDialogForRYSQOnly("projectName", "hiddenId"); //公司项目的单择
		});
		
		//添加角色权限弹出框
		function dialog_add_role(){	
			new MyAjaxIframeDialogX2({title:'添加用户角色权限', formId:'inputform',
				width:800,
                height:550,
				src:'./user/manager/inputUserRole.action?userId='+<s:property value="userId"  escape="false"/>,
				closeFn:function(){
					//页面重新加载
					location.href = location.href;
					}
				});
				return false;		
		}
		
		function viewRolepriv(roleId){
			new MyAjaxIframeDialogX2({title:'查看角色权限', 
				width:650,
				height:700,
				src:'./user/manager/searchRolepriv.action?selRoleId='+roleId,
				buttons:false
				});		
		}
		
	</script>
	</head>
	

	<body >

	<div class="gbox1" style="font-size:12px">			
	<form  id="update_user_info" method="post">
		<table id="" width="100%" border="0" align="left" cellpadding="0" cellspacing="1" class="gbox">
		
			<tr  style="line-height: 24px" >
				<td style="background: #eeeeee;font-weight: bold;" colspan="2">
					基本信息
				</td>
			</tr>
			<tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="line-height: 24px">
				<td width="" align="center" nowrap="nowrap">
					账号
				</td>
				<td width="" nowrap="nowrap">
					&nbsp;${userAccount.userName}
				</td>
			</tr>
			<tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="line-height: 24px">

				<td align="center">
					姓名
				</td>
				<td>
					<input  name="userAccount.realName"  value="${userAccount.realName}" maxlength="15"/>
					<input type="hidden" name="userAccount.id" value="${userAccount.id}"/>
				</td>

			</tr>
			<tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="line-height: 24px">
					<td style="line-height: 15px" align="center">
						部门
					</td>
					<td style="line-height: 15px">
						<input name="userAccount.remark"  value="${userAccount.remark}"
							 maxlength="50"/>
					</td>

				</tr>
			<tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="line-height: 24px">
				<td id="t13" align="center">
					移动电话
				</td>
				<td>
				<input  name="userAccount.mobilePhone"  value="${userAccount.mobilePhone}" maxlength="20"/>
				</td>
			</tr>
			<tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="line-height: 24px">
				<td  align="center">
					工号
				</td>
				<td>
				<input name="userAccount.jobNumber" value="${userAccount.jobNumber}" maxlength="20"/>
				</td>

			</tr>
			<tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="line-height: 24px">
				<td  align="center">
					所属项目
				</td>
				<td >				
						<input type="text" id="projectName" size="40" name="projectName" value="${userAccount.descProjectId}"/>
						<input type="hidden" id="hiddenId" name="userAccount.projectId" value="${userAccount.projectId}"/>
				</td>
			</tr>
			
			<tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="line-height: 24px;display:none" >
				<td  align="center">
					内网绑定验证
				</td>
				<td >				
						<s:select list="#{'1':'是','5':'否'}" value="unBind" name="unBind"></s:select>
				</td>
			</tr>
			 
			<tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="line-height: 24px">
				<td  align="center">
					修改基本信息
				</td>
				<td >
					<input type="button" onclick="saveBaseInfo();" value=" 保存 ">
					<input type="button" value="初始密码" onclick="initPwd(${userAccount.id})"/>	
					${userAccount.isDeleted}
					<s:if test="#request.userAccount.isDeleted==0">
					<input type="button" value="删除账号" onclick="delUser(${userAccount.id})"/>
					</s:if>
					<s:else>
					<input type="button" value="恢复账号" onclick="undoDelUser(${userAccount.id})"/>
					</s:else>
				</td>
			</tr>
		</table>
		</form>
		<br/><br/>
		<div style="width: 100%;float: left;">
		<hr width="100%"/>
		</div>
		<b>角色权限列表</b><br/>
		&nbsp;&nbsp;<input type="button" onclick="delUserRoles()" value="删除所选角色"/>
		&nbsp;&nbsp;<a onclick="dialog_add_role();" style="color: #1199FF;cursor: pointer;" class="ablue">添加角色权限</a>
		<table width="100%" border="0" align="left" cellpadding="0" cellspacing="1" class="gbox">
			<tr class="gboxbg">
				<td width="25px" align="center">
					<input type="checkbox" id="selectAll" name="selectAll" onclick="selectAllCheckbox()" />
				</td>
				<td align="center" width="25%">
					公司
				</td>
				<td align="center" width="25%">
					项目
				</td>

				<td align="center" width="25%">
					角色
				</td>

				<td align="center" width="25%">
					功能
				</td>
			</tr>
			<div class="right99"></div>
			<div class="blueline"></div>
			<s:iterator value="userRoleList" id="li">
				<tr onMouseOver="this.style.backgroundColor = '#f1f9fe'" onMouseOut="this.style.backgroundColor = ''" bgcolor="#FFFFFF">
					<td align="center" valign="middle">
						<input name="selectOne" type="checkbox"
							value="<s:property value='id'/>" onclick="selectOneCheckbox()" />
					</td>
					<td align="center" valign="middle">
						<s:property value="DescCompanyId" />
					</td>
					<td align="center" valign="middle">
						<s:property value="DescProjectId" />
					</td>
					<td align="center" valign="middle">
						<a onclick="viewRolepriv('<s:property value="roleId" />')"  class="blueLink"><s:property value="DescRoleName" /></a>
					</td>
					<td align="center" >
						<input type="button" value="删除" onclick="delUserRole(${li.id});">
					</td>
				</tr>

			</s:iterator>
		</table>
	</div>
</body>
</html>
