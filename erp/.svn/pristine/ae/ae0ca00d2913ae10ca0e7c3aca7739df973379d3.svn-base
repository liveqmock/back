<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
	<base href="<%=basePath%>">		
	
<div id="searchChipCustomerDiv" class="easyui-dialog" closed="true" modal="true" title="查找客户" style="width:375px;height:180px; display:none">

	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="font-size:12px; line-height:26px">			

	  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
		<td id="t15" style="width:30%" align="center">姓名</td>
		<td id="t16" style="width:70%">&nbsp;&nbsp;
		   <input type="text" id="customerName"/>
		   <input type="hidden" id="customerHiddenId"/>
		</td>
		</tr>
		
		<tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
		<td id="t15" style="width:30%" align="center">电话</td>
		<td id="t16" style="width:70%">&nbsp;&nbsp;
		   <input type="text" id="customerPhone"/>
		</td>
		</tr>
		
	</table>
</div>
	
<div id="createChipDiv" class="easyui-dialog" closed="true" modal="true" title="新建认筹" style="width:450px;height:450px; display:block">
	
	<form id="saveChipFormId">
		<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="font-size:12px; line-height:26px">	

	<!--
<div id="createChipDiv" class="easyui-dialog" closed="true" modal="true" title="新建认筹" style="width:450px;">
	
	<form id="saveChipFormId">
		<table id="createChipTable" width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="display:block;font-size:12px; height:400px; line-height:26px">
			-->
		<!--
			<tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
			<td id="t15" style="width:30%" align="center"><font color="#FF0000">*</font>筹单号</td>
			<td id="t16" style="width:70%">&nbsp;&nbsp;<span >11</span></td>
			</tr>
		-->
		
		 <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
			<td id="t15" style="width:30%" align="center"><font color="#FF0000">*</font>筹单号</td>
			<td id="t16" style="width:70%">&nbsp;&nbsp;<input type="text" id="chipNo" name="chip.chipNo"/></td>
		 </tr>
		
		  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show;">
			<td id="t15" style="width:30%" align="center"><font color="#FF0000">*</font>姓名</td>
			<td id="t16" style="width:70%">&nbsp;&nbsp;<input type="text" id="chipCustomerName" name="chipCustomer.customerName"/>
			<input type="hidden" id="chipCustomerId" name="chipCustomer.id" value="0"/>
			<a href="javascript:void(0)" style="color:#1199FF; text-decoration:underline;" onclick="return searchChipCustomer()">查找客户</a>		
			</td>
			</tr>
			
			 <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
			<td id="t15" style="width:30%" align="center"><font color="#FF0000">*</font>电话号码</td>
			<td id="t16" style="width:70%">&nbsp;&nbsp;<input type="text" id="chipCustomerPhone" name="chipCustomer.phone"/></td>
			</tr>
			
			 <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
			<td id="t15" style="width:30%" align="center">性别</td>
			<td id="t16" style="width:70%">&nbsp;&nbsp;<s:select list="selCustomerGender" cssStyle="width:auto" id="chipCustomerGender" name="chipCustomer.gender"/></td>
			</tr>
			
			 <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
			<td id="t15" style="width:30%" align="center">证件类型</td>
			<td id="t16" style="width:70%">&nbsp;&nbsp;<s:select list="selCustomerIdCardType" cssStyle="width:auto" id="chipCustomerIdcardType" name="chipCustomer.idcardType"/></td>
			</tr>
			
			 <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
			<td id="t15" style="width:30%" align="center">证件号码</td>
			<td id="t16" style="width:70%">&nbsp;&nbsp;<input type="text" id="chipCustomerIdcardNo" name="chipCustomer.idcardNo"/></td>
			</tr>
			
			 <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
			<td id="t15" style="width:30%" align="center">通信地址</td>
			<td id="t16" style="width:70%">&nbsp;&nbsp;<input type="text" id="chipCustomerAddress" style="width: 85%;" name="chipCustomer.address"/></td>
			</tr>
			
			 <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
			<td id="t15" style="width:30%" align="center">销售人员</td>
			<td id="t16" style="width:70%">&nbsp;&nbsp;<input type="text" id="salesName" class="readonly" readonly="readonly"/>
				 <input type="hidden" id="salesId" name="chip.salesId"/>
				 <a href="javascript:void(0)" style="color:#1199FF; text-decoration:underline;" onclick="return modifySale('salesId', 'salesName', '__chip__')">选择销售</a>	
				 
		  		 <input type="hidden" name="chip.userId" value="${LOGIN_SESSION.id}"/>
			</td>
			</tr>
			
			 <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
			<td id="t15" style="width:30%" align="center">认筹金额</td>
			<td id="t16" style="width:70%">&nbsp;&nbsp;<input type="text" style="width:20%" id="chipMoney" name="chip.chipMoney"/></td>
			</tr>
			
			 <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
			<td id="t15" style="width:30%" align="center"><font color="#FF0000">*</font>意向单元1</td>
			<td id="t16" style="width:70%">&nbsp;&nbsp;
				<input type="hidden" id="unit_id1" name="chip.unitId1"/>
				<span id="showUnit1" style="color:#FF0000"></span>
				<a href="javascript:void(0)" style="color:#1199FF; text-decoration:underline;" onclick="return changeUnit(1)">选择单元</a>
			</td>
			</tr>
			
			 <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
			<td id="t15" style="width:30%" align="center">意向单元2</td>
			<td id="t16" style="width:70%">&nbsp;&nbsp;
				<input type="hidden" id="unit_id2" name="chip.unitId2"/>
				<span id="showUnit2" style="color:#FF0000"></span>
				<a href="javascript:void(0)" style="color:#1199FF; text-decoration:underline;" onclick="return changeUnit(2)">选择单元</a>
			</td>
			</tr>
			
			 <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
			<td id="t15" style="width:30%" align="center">意向单元3</td>
			<td id="t16" style="width:70%">&nbsp;&nbsp;
				<input type="hidden" id="unit_id3" name="chip.unitId3"/>
				<span id="showUnit3" style="color:#FF0000"></span>
				<a href="javascript:void(0)" style="color:#1199FF; text-decoration:underline;" onclick="return changeUnit(3)">选择单元</a>
			</td>
			</tr>
			
		</table>
	</form>
	
</div>

<!--
<div id="chipCustomerShowDiv" class="easyui-dialog" closed="true" modal="true" title="查看签约客户" style="width:450px;height:220px;">

	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="font-size:12px; line-height:26px">			

	  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
		<td id="t15" style="width:30%" align="center"><font color="#FF0000">*</font>姓名</td>
		<td id="t16" style="width:70%">&nbsp;&nbsp;${confirmCustomer.customerName}</td>
		</tr>
		
		 <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
		<td id="t15" style="width:30%" align="center"><font color="#FF0000">*</font>电话号码</td>
		<td id="t16" style="width:70%">&nbsp;&nbsp;${confirmCustomer.phone}</td>
		</tr>
		
		 <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
		<td id="t15" style="width:30%" align="center">性别</td>
		<td id="t16" style="width:70%">&nbsp;&nbsp;${confirmCustomer.genderStr}</td>
		</tr>
		
		 <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
		<td id="t15" style="width:30%" align="center">证件类型</td>
		<td id="t16" style="width:70%">&nbsp;&nbsp;${confirmCustomer.idcardTypeStr}</td>
		</tr>
		
		 <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
		<td id="t15" style="width:30%" align="center">证件号码</td>
		<td id="t16" style="width:70%">&nbsp;&nbsp;${confirmCustomer.idcardNo}</td>
		</tr>
		
		 <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
		<td id="t15" style="width:30%" align="center">通信地址</td>
		<td id="t16" style="width:70%">&nbsp;&nbsp;${confirmCustomer.address}</td>
		</tr>
		
	</table>
	
</div>
-->


<div id="myIframeDialog" class="easyui-dialog" closed="true" modal="true" title="标题" style="display:block;width:800px;height:500px; overflow-x:hidden"> 			
	<iframe scrolling="auto" id='openIframe' frameborder="0" style="width:100%;height:100%;"></iframe> 
</div> 	

