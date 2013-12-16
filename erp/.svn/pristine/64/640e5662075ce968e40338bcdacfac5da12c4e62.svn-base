<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	
	<title>查看成交客户</title>
	
	<s:include value="../../customer/guangzhou/header_min.jsp"></s:include>	  
		
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>
	<script type="text/javascript" language="javascript" src="<%=basePath%>css/local/easyui-lang-zh_CN.js"></script>
	<link href="./css/easyui.css" rel="stylesheet" type="text/css" charset="utf-8"/>
	<link href="./css/icon.css" rel="stylesheet" type="text/css" charset="utf-8"/>
	
	<script type="text/javascript" language="javascript" src="./js/project.list.utils.js?v=3"></script>
	
	<script type="text/javascript" language="javascript">
		
		$().ready(function(){
			
			$("#gender").combobox({
				editable:false,
				onLoadSuccess:function(node, data){
				
					var module = $("#gender").combotree('textbox');
					$(module).bind('focus', function(){
						$("#gender").combotree('showPanel');	
					}).bind('blur', function(){
						$("#gender").combotree('hidePanel');	
					});					
				}
			});
			
			$("#idcardType").combobox({
				editable:false,
				onLoadSuccess:function(node, data){
				
					var module = $("#idcardType").combotree('textbox');
					$(module).bind('focus', function(){
						$("#idcardType").combotree('showPanel');	
					}).bind('blur', function(){
						$("#idcardType").combotree('hidePanel');	
					});					
				}
			});		
			
			bindProvinceCityRegion("householdProvince", "householdCity", "householdRegion");	
			bindProvinceCityRegion("homeProvince", "homeCity", "homeRegion");
			bindProvinceCityRegion("workProvince", "workCity", "workRegion");
			
		});
		
	</script>
		
	<style type="text/css">
		*{margin:0;padding:0;}
		body{font-size:75%}
		
	</style>
	
</head>
<body>
<div class="gbox1">			

<form action="./saleunit_new/appoint/guangzhou/updateContractCustomer.action" method="post" id="contractCustomerFormId">
			  
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="font-size:12px; line-height:26px">	
	
		<tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
		style="empty-cells:show">
		<td style="width:15%" align="right"><font color="#FF0000">*</font>移动电话&nbsp;</td>
		<td>
			<input type="text" id="mobilePhone" name="customer.mobilePhone" value="${customer.mobilePhone}" disabled="disabled"/>
						
			<input type="hidden" id="projectId" name="customer.projectId" value="${customer.projectId}" />
			<input type="hidden" id="companyId" name="customer.companyId" value="${customer.companyId}" />			
			<input type="hidden" id="userId" name="customer.userId" value="${customer.userId}"/>
			
			<input type="hidden" id="confirmType" name="customer.confirmType" value="${customer.confirmType}"/>			
			<input type="hidden" id="mainId" name="customer.mainId" value="${customer.mainId}"/>
			
			<input type="hidden" id="isValid" name="customer.isValid" value="${customer.isValid}"/>
			
			<input type="hidden" name="customer.preCustomerType" value="${customer.preCustomerType}" />
			<input type="hidden" name="customer.preCustomerId" value="${customer.preCustomerId}" />
			
			<input type="hidden" name="customer.id" value="${customer.id}" />
			
			<input type="hidden" name="oldCustomerId" value="${oldCustomerId}" />
			
		</td>		
	  </tr>	 
			  
		<tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"
		style="empty-cells:show">
		<td style="width:15%" align="right"><font color="#FF0000">*</font>客户姓名&nbsp;</td>
		<td>
			<input type="text" id="customerName" name="customer.customerName" value="${customer.customerName}" disabled="disabled"/>
		</td>		
	  </tr>	 
	  
	  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
		style="empty-cells:show">
		<td style="width:15%" align="right">性别&nbsp;</td>
		<td>
			<s:if test="customer.gender==1">男</s:if>
			<s:if test="customer.gender==2">女</s:if>
	
		</td>		
	  </tr>	 
	  
	  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
		style="empty-cells:show">
		<td style="width:15%" align="right">固定电话&nbsp;</td>
		<td>
			<input type="text" id="phone" name="customer.phone" value="${customer.phone}" disabled="disabled"/>
		</td>		
	  </tr>	 
	  
	  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
		style="empty-cells:show">
		<td style="width:15%" align="right"><font color="#FF0000">*</font>证件类型&nbsp;</td>
		<td>
			<s:if test="customer.idcardType==1">身份证</s:if>
			<s:if test="customer.idcardType==2">驾驶证</s:if>
			<s:if test="customer.idcardType==3">士官证</s:if>
			<s:if test="customer.idcardType==4">其他</s:if>
		</td>		
	  </tr>	 
	  
	  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
		style="empty-cells:show">
		<td style="width:15%" align="right"><font color="#FF0000">*</font>证件号码&nbsp;</td>
		<td>
			<input type="text" id="idcardNo" name="customer.idcardNo" value="${customer.idcardNo}" disabled="disabled"/>
		</td>		
	  </tr>	 
	  
	  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
		style="empty-cells:show">
		<td style="width:15%" align="right"><font color="#FF0000"></font>生日&nbsp;</td>
		<td>
			<input type="text" id="birthday" style="width:90px" value="<s:date format="yyyy-MM-dd"  name='customer.birthday'/>" />
			<span id="birthdaySpan"></span>
			
		</td>		
	  </tr>	 
	  
	  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
		style="empty-cells:show">
		<td style="width:15%" align="right"><font color="#FF0000">*</font>通讯地址&nbsp;</td>
		<td>
			<input type="text" id="address" name="customer.address" style="width:95%" value="${customer.address}" disabled="disabled"/>
		</td>		
	  </tr>	 
	  
	  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
		style="empty-cells:show">
		<td style="width:15%" align="right">邮编&nbsp;</td>
		<td>
			<input type="text" id="postcode" name="customer.postcode" value="${customer.postcode}" disabled="disabled"/>
		</td>		
	  </tr>	 
	  
	 	 
	  
	</table>
</form>	
	
	</div>
	
	<div id="changeCustomerToCopyDialog">
		<div class="gbox1" id="changeCustomerToCopyDialogHtmlId"></div>
	</div>
	
	<div id='loading' style="position:absolute;z-index:100000;top:0px;left:0px;width:100%;height:45%; background-color:#CCCCCC;text-align:center;padding-top: 20%; display:none">
		<h1><image src='images/loading.gif'/><font color="#15428B"><script type="text/javascript" language="javascript">document.write(parent.myGlobal.loadIng)</script></font></h1>
	</div>

</body>
</html>
