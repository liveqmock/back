<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<base href="<%=basePath%>" />	

<table id="unit_detail_table" style="width:auto;height:330px;">
		
	<thead>
		<tr>
			<!--
			<th field="modify" width="40">操作</th>
			-->
			<th field="id" hidden="true"></th>
			<th field="allName" width="200" align="center">项目,分区,楼栋,房间号</th>
			
			<th field="unitNo"  align="center" hidden="true">房间号</th>
			<th field="saleState" width="60" align="center">状态</th>
			
			<th field="buildArea" width="60" align="center">建筑面积</th>
			
			<th field="buildPrice" width="60" align="center">销售单价</th>
			<th field="sumMoney" width="65" align="center">销售总价</th>
			
			<th field="shouldAmount" width="60" align="center">应收金额</th>
			<th field="paymentAmount" width="60" align="center">实收金额</th>
			
			<th field="baseprice" width="60" align="center">单价(底价)</th>
			<th field="totalBaseprice" width="65" align="center">总价(底价)</th>
			
		</tr>
								
	</thead>
</table>	

<div id="detail_search_tb">
	楼栋:<s:select list="buildMap" id="build_select"></s:select>
	状态:<s:select list="saleMap" id="sale_select"></s:select>
	<a href="javascript:void(0)" id="search" class="easyui-linkbutton" iconCls="icon-search" onclick="searchDetailTabs()">查找</a> 
</div>