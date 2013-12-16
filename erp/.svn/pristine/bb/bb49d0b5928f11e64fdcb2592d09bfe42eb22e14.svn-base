<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>
	<title>查看或者修改答卷</title>
	<s:include value="../../customer/guangzhou/header.jsp"></s:include>	  
	<style type="text/css">
		*{margin:0;padding:0;}
		td{padding: 5px}
		tr{background: #ffffff}
	</style>
	<script>
	function formsubmit (){
		document.getElementById("question_form").submit();
    }

	$().ready(function(){
		${tips}
	})
	</script>
	
	<script type="text/javascript" language="javascript" src="./js/provi_city_region_select.js"></script>
	<script type="text/javascript" language="javascript" src="./js/customer_guangzhou.js"></script>	
	</head>
<body>
<form id="question_form" action="${path }" method="post">
<div >		
	
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="font-size:12px; line-height:20px">
		<tr bgcolor="#ffffff">
			<td align="center" width="100px">问卷</td>
			<td colspan="3">
			基本问卷
			</td>
		</tr>
		<tr bgcolor="#ffffff">
			<td align="center" width="100px">回答人</td>
			<td colspan="3">
				<input value="${customer.customerName}" name="customer.customerName"/> 
			</td>
		</tr>
		<tr bgcolor="#ffffff">
			<td align="center" width="100px">备注</td>
			<td colspan="3">
				<input value="${customer.remark}" name="customer.remark"/> 
			</td>
		</tr>
	</table>
	
	
</div>

<div   >

<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="font-size:12px; line-height:20px;white-space:nowrap;">
	<tr>
		<td width="30"></td><td></td>
		<td width="">客户评级</td><td><s:select list="selRating"  name="customer.rating" /></td>
	</tr>
	<tr>
		<td>移动电话</td><td><input name="customer.phone" value="${ customer.phone}"/></td>
		<td>固定电话</td><td><input name="customer.homePhone" value="${ customer.homePhone}"/></td>
	</tr>
	<tr>
		<td>居住区域</td><td colspan="3">
					<s:select list="selProvince" id='customer_homeProvince' name='customer.homeProvince'   cssStyle="width:auto" />省
					<s:select list="selHomeCity" id='customer_homeCity' name='customer.homeCity'   cssStyle="width:auto" />市
					<s:select list="selHomeRegion" id='customer_homeRegion' name='customer.homeRegion'   cssStyle="width:auto" />
					<input name="customer.homeContent" value="${customer.homeContent}"/></td>
	</tr>
	<tr>
			<td>工作区域</td><td colspan="3">
					<s:select list="selProvince" id='customer_workProvince' name='customer.workProvince'   cssStyle="width:auto" />省
					<s:select list="selWorkCity" id='customer_workCity' name='customer.workCity'   cssStyle="width:auto" />市
					<s:select list="selWorkRegion" id='customer_workRegion' name='customer.workRegion'    cssStyle="width:auto" />
					<input name="customer.workContent" value="${customer.workContent }"/>
					<input id="copyHome" type="checkbox"/>与居住区域相同 
					</td>
	</tr>
	<tr>
			<td>户籍</td><td colspan="3">
					<s:select list="selProvince" id='customer_nativeProvince' name='customer.nativeProvince'   cssStyle="width:auto"/>省
					<s:select list="selNativeCity" id='customer_nativeCity' name='customer.nativeCity'   cssStyle="width:auto"/>市
					<s:select list="selNativeRegion" id='customer_nativeRegion' name='customer.nativeRegion'    cssStyle="width:auto"/>
					<input name="customer.nativeContent" value="${customer.nativeContent }"/>
					</td>
	</tr>
	<tr>
		<td>购房用途</td><td><s:select list="selBuyUse"  name='customer.buyUse' /></td>
		<td>置业次数</td><td><s:select list="selBuyCount"  name='customer.buyCount' /></td>
	</tr>
	<tr>
		<td>产品类型</td><td><s:select list="selHouseType"  name='customer.roomType' /></td>
		<td>客户来源</td><td><s:select list="selCustomerSource"   name='customer.customerSource' /></td>
	</tr>		
</table>
<input type="hidden" value="${id }" name="id"/>
</div>
</form>
</body>
</html>