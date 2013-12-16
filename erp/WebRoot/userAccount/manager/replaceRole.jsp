<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
<title>替换角色</title>
<style type="text/css">
table {
	font-size: 12px;
}
</style>
<script type="text/javascript" language="javascript"
	src="<%=basePath%>ui/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" language="javascript">
</script>
</head>

<body>
	<form name="inputform" class="registerform" id="roleFormId"
		action="./user/manager/replaceRole.action" method="post">
		<table width="100%" border="0" align="left" cellpadding="0"
			cellspacing="1" class="gbox">
			<tr bgcolor="#FFFFFF">
				<td align="center" valign="middle">选择的角色：</td>
				<td align="left" valign="middle"><span>${roleName}</span><input type="hidden" name="roleid" value="${roleid}"></td>
				<td align="center" valign="middle">替换的角色：</td>
				<td><s:select list="roleList" listValue="roleName" listKey="id"	name="selectId" headerKey="" headerValue="全部" /></td>
			</tr>
		</table>
		<%--隐藏域，用于传值 --%>
		<span style="display:none">
                <label>&nbsp;<span>项目</span> </label>		
				<input type="text" id="projectIds" value="${projectIds}" name="projectIds"/>
				<label>&nbsp;<span>创建日期</span> </label>
				<input name="date1" class="easyui-datebox" style="width:90px" value="${date1 }"/>
				<input name="date2" class="easyui-datebox" style="width:90px" value="${date2 }"/>
		</span>
	</form>

</body>
</html>

