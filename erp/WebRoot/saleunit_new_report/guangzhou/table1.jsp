<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<input type="button" value="添加问卷" id="_add_question" class="btn1" /> 
<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="1" style="background-color: #A9D9FF"  id="questiontable">
	<tr style="line-height: 20px;background: #E9F5FF">
		<th>调查问卷名称	</th>
		<th>创建人</th>
		<th>题目</th>
		<th></th>
	</tr>
	<s:iterator value="proproject" var="c">
	<tr style="line-height: 20px;background: #E9F5FF">
		<td>${c.id }</td>
		<td>${c.id }</td>
		<td>${c.id }</td>
		<td>${c.id }</td>
	</tr>
	
	</s:iterator>

</table>







