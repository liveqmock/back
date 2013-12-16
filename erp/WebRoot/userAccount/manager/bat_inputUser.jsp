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
		<title>批量新建用户</title>
		<s:include value="../../header/header_easyui.jsp"></s:include>
		<script language="javascript" type="text/javascript" src="./js/project.list.utils.js?v=1.2"></script>
		
		<script type="text/javascript">
			$().ready(function(){				
				bindProjectDialogForRYSQOnly("projectName", "hiddenId"); //公司项目的单择
			});	
			
			</script>
	</head>

	<body >
		<form name="inputform" class="registerform" id="inputform" action="./user/manager/submitBatUser.action" method="post">
			<table width="100%" border="0" align="left" cellpadding="0" cellspacing="1" class="gbox">
				<tr bgcolor="#FFFFFF" ; height="28px">
					<td style="line-height: 15px" id="t13" align="center">
						所属项目
					</td>
					<td style="line-height: 15px" id="t14">
						<input type="text" id="projectName" size="40" name="projectName" />
						<input type="hidden" id="hiddenId" name="selProjectId" />
					</td>
				</tr>
				<tr bgcolor="#FFFFFF" ; height="28px">
					<td style="line-height: 15px" id="t13" align="center">
						角色
					</td>
					<td style="line-height: 15px" id="t14">					
						<s:select list="roleList" listValue="roleName" listKey="id"
							name="selRoleId"></s:select>
					</td>
				</tr>
				<tr bgcolor="#FFFFFF" ; height="28px">
					<td style="line-height: 15px" id="t13" align="center">
						用户信息
					</td>
					<td style="line-height: 15px" id="t14">	
					每个用户一行,回车换行<br/>
					每行用户的格式为(英文半角逗号分隔):账号,姓名,部门,电话,工号<br/>
					提交会自动判断用户名是否冲突,留意提交后的信息<br/>		
						<textarea rows="20" cols="50" name="userStr"></textarea>
					</td>
				</tr>
			</table>

		</form>

	</body>
</html>

