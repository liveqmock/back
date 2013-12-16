<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<style type="text/css">
	.saleinfo td{padding:10px}
</style>
<div style="float: left;">
		<table  border="0" align="center" cellpadding="0" cellspacing="1" class="gbox">
			<tr  bgcolor="#E9F5FF" style="line-height: 20px;"> 
				<th width="150" align="center">用户</th>
				<th width="150" align="center">时间</th>
				<th width="150" align="center">模块</th>
				<th width="150" align="center">类型</th>
				<th width="350" align="center">操作类容</th>
				<th width="150" align="center">电脑信息</th>
			</tr>
			<s:iterator value="logs" var="c">
			<tr  bgcolor="#ffffff" style="line-height: 20px;"> 
				<td width="150" align="center">${c.realName }</td>
				<td width="150" align="center">
					<s:date name="#request.c.createdTime" format="yyyy-MM-dd HH:ss"/>
				</td>
				<td width="150" align="center">${c.modul}</td>
				<td width="150" align="center">${c.type }</td>
				<td width="350" align="center">${c.operationProcedure }</td>
				<td width="350" align="center">${c.computerInformationl }</td>
			</tr>
			</s:iterator>
		</table>
   
				
		</div>