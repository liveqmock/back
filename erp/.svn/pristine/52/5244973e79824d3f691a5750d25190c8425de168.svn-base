<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	
	<title>新增成交客户</title>
	
	<s:include value="../../customer/guangzhou/header_min.jsp"></s:include>	  
		
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>
	<script type="text/javascript" language="javascript" src="<%=basePath%>css/local/easyui-lang-zh_CN.js"></script>
	<link href="./css/easyui.css" rel="stylesheet" type="text/css" charset="utf-8"/>
	<link href="./css/icon.css" rel="stylesheet" type="text/css" charset="utf-8"/>
	
	<script type="text/javascript" language="javascript" src="./js/project.list.utils.js?v=1.3"></script>
	<script type="text/javascript" language="javascript" src="./js/customer_value_change.js"></script>
	
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

<form action="./saleunit_new/appoint/guangzhou/addContractCustomer.action" method="post" id="contractCustomerFormId">
			  
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="font-size:12px; line-height:26px">	
	
		<tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
		style="empty-cells:show">
		<td id="t13" style="width:15%" align="right"><font color="#FF0000">*</font>移动电话&nbsp;</td>
		<td id="t14">
			
			<input type="text" id="mobilePhone" name="customer.mobilePhone" value="${customer.mobilePhone}"
				onkeyup="valueChangeGetCount('mobilePhone', 'phoneCount', 11)" onkeydown="valueChangeGetCount('mobilePhone', 'phoneCount', 11)"/>
			<span id="phoneCount"></span>
			
			
			<input type="hidden" id="confirmType" name="customer.confirmType" value="${customer.confirmType}"/>
			<input type="hidden" id="projectId" name="customer.projectId" value="${customer.projectId}" />
			
			<input type="hidden" name="customer.preCustomerType" value="${customer.preCustomerType}" />
			<input type="hidden" name="customer.preCustomerId" value="${customer.preCustomerId}" />
		</td>		
	  </tr>	 
			  
		<tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
		style="empty-cells:show">
		<td id="t13" style="width:15%" align="right"><font color="#FF0000">*</font>客户姓名&nbsp;</td>
		<td id="t14">
			<input type="text" id="customerName" name="customer.customerName" value="${customer.customerName}"/>
		</td>		
	  </tr>	 
	  
	  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
		style="empty-cells:show">
		<td id="t13" style="width:15%" align="right">性别&nbsp;</td>
		<td id="t14">
			<s:select list="selCustomerGender" cssStyle="width:auto" id="gender" name="customer.gender" />
		</td>		
	  </tr>	 
	  
	  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
		style="empty-cells:show">
		<td id="t13" style="width:15%" align="right">固定电话&nbsp;</td>
		<td id="t14">
			<input type="text" id="phone" name="customer.phone" value="${customer.phone}"/>
		</td>		
	  </tr>	 
	  
	  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
		style="empty-cells:show">
		<td id="t13" style="width:15%" align="right"><font color="#FF0000">*</font>证件类型&nbsp;</td>
		<td id="t14">
			<s:select list="selCustomerIdCardType" cssStyle="width:auto" id="idcardType" name="customer.idcardType"/>
		</td>		
	  </tr>	 
	  
	  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
		style="empty-cells:show">
		<td id="t13" style="width:15%" align="right"><font color="#FF0000">*</font>证件号码&nbsp;</td>
		<td id="t14">
			
			<input type="text" id="idcardNo" name="customer.idcardNo" value="${customer.idcardNo}"
				onkeyup="valueChangeGetCount('idcardNo', 'idcardNoCount', 30)" onkeydown="valueChangeGetCount('idcardNo', 'idcardNoCount', 30)" onblur="getBirthday();"/>
			<span id="idcardNoCount"></span>
		</td>		
	  </tr>	 
	  
	  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
		style="empty-cells:show">
		<td id="t13" style="width:15%" align="right"><font color="#FF0000"></font>生日&nbsp;</td>
		<td id="t14">
			<input type="text" id="birthday" style="width:90px" name="customer.birthday" value='<s:date format="yyyy-MM-dd"  name='customer.birthday'/>' />
			<span id="birthdaySpan"></span>
			
		</td>		
	  </tr>
	  
	  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
		style="empty-cells:show">
		<td id="t13" style="width:15%" align="right"><font color="#FF0000">*</font>通讯地址&nbsp;</td>
		<td id="t14">
			<input type="text" id="address" name="customer.address" style="width:95%" value="${customer.address}"/>
		</td>		
	  </tr>	 
	  
	  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
		style="empty-cells:show">
		<td id="t13" style="width:15%" align="right">邮编&nbsp;</td>
		<td id="t14">
			<input type="text" id="postcode" name="customer.postcode" value="${customer.postcode}"/>
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
