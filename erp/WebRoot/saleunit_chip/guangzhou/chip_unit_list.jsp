<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
	<base href="<%=basePath%>">		
		
<!--
<ul style="margin:0;padding:0;margin-left:10px;">

	<li class="drag-item">第一意向:<span id="chip1" style="color:#FF0000"></span><input type="hidden" id="chipUnitId1" /></li>
	<li class="drag-item">第二意向:<span id="chip2" style="color:#FF0000"></span><input type="hidden" id="chipUnitId2" /></li>
	<li class="drag-item">第三意向:<span id="chip3" style="color:#FF0000"></span><input type="hidden" id="chipUnitId3" /></li>
	
</ul>
-->

<div>
<table width="75%" border="0" align="left" cellpadding="0" cellspacing="1" class="gbox" style="font-size:12px; line-height:26px; white-space:normal">	
	
	  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
		<td id="t15" style="width:30%" align="center">意向</td>
		<td id="t16" style="width:70%; text-align:center" colspan="3">客户姓名</td>
		</tr>
		
		<tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
		<td id="t15" style="width:30%" align="center">第一意向</td>
		<td width="25%"><span id="chip1_customer1" style="color:#FF0000"></span></td>
		<td width="25%"><span id="chip1_customer2" style="color:#FF0000"></span></td>
		<td width="25%"><span id="chip1_customer3" style="color:#FF0000"></span></td>
		</tr>
		
		<tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
		<td id="t15" style="width:30%" align="center">第二意向</td>
		<td width="25%"><span id="chip2_customer1" style="color:#FF0000"></span></td>
		<td width="25%"><span id="chip2_customer2" style="color:#FF0000"></span></td>
		<td width="25%"><span id="chip2_customer3" style="color:#FF0000"></span></td>
		</tr>
		
		<tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
		<td id="t15" style="width:30%" align="center">第三意向</td>
		<td width="25%"><span id="chip3_customer1" style="color:#FF0000"></span></td>
		<td width="25%"><span id="chip3_customer2" style="color:#FF0000"></span></td>
		<td width="25%"><span id="chip3_customer3" style="color:#FF0000"></span></td>
		</tr>
		
</table>
<input type="hidden" id="unitNumberId" value="0" />	

</div>
