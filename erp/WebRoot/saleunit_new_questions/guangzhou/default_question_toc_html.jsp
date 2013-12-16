<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath%>"/>
<style>
input{width: auto;}
tr{background: #ffffff}
</style>

<script type="text/javascript" language="javascript" src="./js/provi_city_region_select.js"></script>
	<script type="text/javascript" language="javascript" src="./js/customer_guangzhou.js"></script>	
<div style="width: 100%;height: auto; float: left"> 
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="font-size:12px; line-height:20px;white-space:nowrap;">
	<tr>
		<td width="80px"></td><td></td>
		<td width="80px">客户评级</td><td><s:select list="selRating"  name="customer.rating"/></td>
	</tr>
	<tr>
		<td>移动电话</td><td><input name="customer.phone"/></td>
		<td>固定电话</td><td><input name="customer.homePhone"/></td>
	</tr>
	<tr>
		<td>居住区域</td><td colspan="3">
					<s:select list="selProvince" id='customer_homeProvince' name='customer.homeProvince'   cssStyle="width:auto"/>省
					<s:select list="selHomeCity" id='customer_homeCity' name='customer.homeCity'   cssStyle="width:auto"/>市
					<s:select list="selHomeRegion" id='customer_homeRegion' name='customer.homeRegion'   cssStyle="width:auto"/>
					<input name="customer.homeContent"/></td>
	</tr>
	<tr>
			<td>工作区域</td><td colspan="3">
					<s:select list="selProvince" id='customer_workProvince' name='customer.workProvince'   cssStyle="width:auto"/>省
					<s:select list="selHomeCity" id='customer_workCity' name='customer.workCity'   cssStyle="width:auto"/>市
					<s:select list="selHomeRegion" id='customer_workRegion' name='customer.workRegion'    cssStyle="width:auto"/>
					<input name="customer.workContent"/>
					<input id="copyHome" type="checkbox">与居住区域相同 
					</td>
	</tr>
	<tr>
			<td>户籍</td><td colspan="3">
					<s:select list="selProvince" id='customer_nativeProvince' name='customer.nativeProvince'   cssStyle="width:auto"/>省
					<s:select list="selHomeCity" id='customer_nativeCity' name='customer.nativeCity'   cssStyle="width:auto"/>市
					<s:select list="selHomeRegion" id='customer_nativeRegion' name='customer.nativeRegion'    cssStyle="width:auto"/>
					<input name="customer.nativeContent"/>
					<br>
					</td>
	</tr>
	<tr>
		<td>购房用途</td><td><s:select list="selBuyUse"  name='customer.buyUse' /></td>
		<td>置业次数</td><td><s:select list="selBuyCount"  name='customer.buyCount' /></td>
	</tr>
	<tr>
		<td>产品类型</td><td><s:select list="selHouseType"  name='customer.roomType'/></td>
		<td>客户来源</td><td><s:select list="selCustomerSource"   name='customer.customerSource'/></td>
	</tr>		
</table>
</div>





