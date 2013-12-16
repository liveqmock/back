<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<style type="text/css">
.unit_table td{
	padding-left: 5px;
	padding-right: 5px;
	line-height: 20px;
}
</style>


<div style="float: left">

<table style="width: 650px;line-height: 24px" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" >
		
		<tr style="background-color: #ffffff">
			<td width="150px">楼盘名称</td><td>${propojo.propertyName }</td>
		</tr>
		<tr style="background-color: #ffffff">
			<td>预售证号</td><td>${propojo.saleCard }</td>
		</tr>
		<tr style="background-color: #ffffff">
			<td>楼盘地址</td><td>${propojo.propertyAddress }</td>
		</tr>
		<tr style="background-color: #ffffff">
			<td>行政区域</td><td>${propojo.areaName }</td>
		</tr>
		<tr style="background-color: #ffffff">
			<td>项目功能描述</td><td>${propojo.projectDesc }</td>
		</tr>	
		<tr style="background-color: #ffffff">
			<td>开发商</td><td>${devpojo.developerName }</td>
		</tr>
		
		 
</table>

</div>

		





