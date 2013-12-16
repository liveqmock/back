<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>客户信息历史记录</title>
<s:include value="../../header/header_easyui.jsp"></s:include>
<style type="text/css">
</style>
</head>
<body>
<table border="0" align="" cellpadding="0" cellspacing="1" class="gbox unit_table" >
	<tr style="background-color: #ffffff">
		<td width="100px" align="center" style="padding-left: 5px;line-height: 24px;font-weight: bold;">项目</td>
		<td width="100px" style="padding-left: 5px;line-height: 24px">${customerLog.descProjectId }</td>
		
		<td width="100px" align="center" style="padding-left: 5px;line-height: 24px;font-weight: bold;">客户姓名</td>
		<td width="100px" style="padding-left: 5px;line-height: 24px">${customerLog.customerName }</td>
	</tr>
	
	<tr style="background-color: #ffffff">
		<td width="100px" align="center" style="padding-left: 5px;line-height: 24px;font-weight: bold;">移动电话</td>
		<td width="100px" style="padding-left: 5px;line-height: 24px">${customerLog.phone }</td>
		
		<td width="100px" align="center" style="padding-left: 5px;line-height: 24px;font-weight: bold;">固定电话</td>
		<td width="100px" style="padding-left: 5px;line-height: 24px">${customerLog.homePhone }</td>
	</tr>
</table>
</body>
</html>

