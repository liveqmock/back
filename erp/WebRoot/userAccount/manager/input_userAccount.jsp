<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>新建用户</title>
		<s:include value="../../header/header_easyui.jsp"></s:include>
		<script language="javascript" type="text/javascript" src="./js/project.list.utils.js?v=1.2"></script>
		
		<script type="text/javascript">
			$().ready(function(){				
				bindProjectDialogForRYSQOnly("projectName", "hiddenId"); //公司项目的单择
			});	
			
			</script>
	</head>

	<body >
		<form name="inputform" class="registerform" id="inputform" action="./user/manager/formUser.action" method="post">
			<table width="100%" border="0" align="left" cellpadding="0" cellspacing="1" class="gbox">
				<tr bgcolor="#FFFFFF"  style="line-height: 24px">
					<td style="line-height: 15px" width="110" align="center" id="t15" nowrap="nowrap">
						<font color="red"> * </font>账号
					</td>
					<td style="line-height: 15px" width="257" nowrap="nowrap" id="t16">
						<input  name="userAccount.userName" id="userName" maxlength="25"/>
					</td>
				</tr>
				<tr bgcolor="#FFFFFF" ; style="" height="28px">
					<td style="line-height: 15px" width="110" align="center" id="t15" nowrap="nowrap">
						<font color="red"> * </font>密码
					</td>
					<td style="line-height: 15px" width="257" nowrap="nowrap" id="t16">
						<input  name="userAccount.userPwd"  value="a123456" id="userPwd" maxlength="12"/>
					</td>
				</tr>
				<tr bgcolor="#FFFFFF" ; height="28px">
					<td style="line-height: 15px" id="t13" align="center">
						<font color="red"> * </font>姓名
					</td>
					<td style="line-height: 15px" id="t14">
						<input name="userAccount.realName" id="realName" maxlength="12"/>
					</td>

				</tr>
				<tr bgcolor="#FFFFFF" ; height="28px">
					<td style="line-height: 15px" id="t13" align="center">
						所属项目
					</td>
					<td style="line-height: 15px" id="t14">
						<input type="text" id="projectName" size="40" name="projectName" />
						<input type="hidden" id="hiddenId" name="userAccount.projectId" />
					</td>

				</tr>
				<tr bgcolor="#FFFFFF" ; height="28px">
					<td style="line-height: 15px" id="t13" align="center">
						部门
					</td>
					<td style="line-height: 15px" id="t14">
						<input name="userAccount.remark" id="remark"
							 maxlength="50"/>
					</td>

				</tr>
				<tr bgcolor="#FFFFFF" ; height="28px">

					<td style="line-height: 15px" id="t13" align="center">
						电话
					</td>
					<td style="line-height: 15px" id="t14">
						<input type="text" name="userAccount.mobilePhone" value="${inputUser.mobilePhone }"  onkeyup="if(isNaN(value))execCommand('undo')" />
					</td>
				</tr>
				<tr bgcolor="#FFFFFF" height="28px">

					<td style="line-height: 15px" id="t13" align="center">
						工号
					</td>
					<td style="line-height: 15px" id="t14">
						<input type="text" name="userAccount.jobNumber" value="${inputUser.jobNumber }" />
					</td>
				</tr>
				<tr bgcolor="#FFFFFF" ; align="center">
					<td colspan="2" style="color: red; size: 4">
						<s:actionmessage />
					</td>
				</tr>
			</table>

		</form>

	</body>
</html>

