<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<base href="<%=basePath%>" />	

<table id="other_expenses_table" style="width:auto;height:364px;">  
		
	<thead>
		<tr>
			<!--
			<th field="modify" width="40">操作</th>
			-->
			<th field="id" hidden="true"></th>
			
			<th field="propertyName" width="80">项目名称</th>
			
			<th field="enterTime" width="80">录入日期</th>
			
			<th field="expensesName" width="80">费用名称</th>
			
			<th field="expensesMoney" width="60" align="right">金额</th>
			<th field="remark" width="200">备注</th>
			
			<th field="oper" width="80">操作</th>
			
		</tr>
								
	</thead>
</table>	

<div id="other_expenses_search_tb">
	<%--
	项目:<s:select list="projectMap" id="project_select"></s:select>
	<a href="javascript:void(0)" id="search" class="easyui-linkbutton" iconCls="icon-search" onclick="searchOtherTabs()">查找</a> 
	--%>
	<a href="javascript:void(0)" id="search" class="easyui-linkbutton" iconCls="icon-add" onclick="addOtherExpenses()">新增</a> 	
	
	<!-- 用于判断是否要重新加载页面,如果这个值跟hiddenPropertyProjectId的值相同,就不用重新加载-->
	<input type="hidden" id="otherTabsHiddenPropertyProjectId" value="${propertyProjectId}"/>

</div>