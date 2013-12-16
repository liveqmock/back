<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<style>
input{width: auto;}
</style>
<div style="width: 100%;height: auto; float: left"> 
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="font-size:12px; line-height:20px">
	<tr style="background: #E9F5FF">
		<th width="80px">问题</th>
		<th>选项</th>
	</tr>
	<s:iterator value="tocList" var="c">
	<tr style="background: #ffffff;line-height: 20px">
		<td style="min-width: 150px;max-width: 300px" nowrap="nowrap">${c.name}</td><td nowrap="nowrap">${c.content}</td>
	</tr>
	</s:iterator>
</table>
<p>${tips}</p>
</div>





