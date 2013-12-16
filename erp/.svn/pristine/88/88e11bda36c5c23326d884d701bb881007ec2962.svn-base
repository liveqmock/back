<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>

<head>
	
	<base href="<%=basePath%>">
	
	<style type="text/css">
		*{margin:0;padding:0;}
		body{font-size:75%}
		.gbox {
			background: none repeat scroll 0 0 #A9D9FF;
		}
		
		.Wdate{
			border:#999 1px solid;
			height:20px;
			background:#fff url(css/datePicker.gif) no-repeat right;
		}
	</style>
	
</head>

<body>

	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="font-size:12px; line-height:26px">			

		<tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
		<td id="t15" style="width:30%" align="left" colspan="2">1.申请内容</td>
		</tr>

	  	<tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
		<td id="t15" style="width:30%" align="center"><font color="#FF0000">*</font>申请日期</td>
		<td id="t16" style="width:70%">&nbsp;&nbsp;<s:date name="#session.extensionContract.applyTime" format="yyyy-MM-dd "/> 
		</td>
		</tr>
		
		 <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
		<td id="t15" style="width:30%" align="center">客户已付金额</td>
		<td id="t16" style="width:70%">&nbsp;&nbsp;${payBill.hadPay}</td>
		</tr>
		
		 <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
		<td id="t15" style="width:30%" align="center">原约定签约日期</td>
		<td id="t16" style="width:70%">&nbsp;&nbsp;<s:date name="#session.extensionContract.oldSignDate" format="yyyy-MM-dd "/>
		</td>
		</tr>
		
		 <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
		<td id="t15" style="width:30%" align="center"><font color="#FF0000">*</font>延期签约天数</td>
		<td id="t16" style="width:70%">&nbsp;&nbsp;${extensionContract.extensionDay}</td>
		</tr>
		
		 <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
		<td id="t15" style="width:30%" align="center"><font color="#FF0000">*</font>改为签约日期</td>
		<td id="t16" style="width:70%">&nbsp;&nbsp;${extensionContract.newApplyTime}</td>		
		</tr>
		
		 <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
		<td id="t15" style="width:30%" align="center"><font color="#FF0000">*</font>是否首次延期</td>
		<td id="t16" style="width:70%">&nbsp;&nbsp;${extensionContract.extensionFirstStr}
		</td>
		</tr>
		
		 <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
		<td id="t15" style="width:30%" align="center">延期签约原因</td>
		<td id="t16" style="width:70%">&nbsp;&nbsp;<textarea style="font-size:12px; width:80%; height:60px" 
        	id="extensionReason" name="extensionContract.extensionReason" disabled="disabled">${extensionContract.extensionReason}</textarea></td>
		</tr>
		
		<tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
		<td id="t15" style="width:30%" align="left" colspan="2">2.批准内容</td>
		</tr>
		
		 <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
		<td id="t15" style="width:30%" align="center">延期批准人</td>
		<td id="t16" style="width:70%">&nbsp;&nbsp;${extensionContract.approvedMan}</td>
		</tr>
		
		 <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
		<td id="t15" style="width:30%" align="center">延期批准日期</td>
		<td id="t16" style="width:70%">&nbsp;&nbsp;<s:date name="#session.extensionContract.approvedDay" format="yyyy-MM-dd "/></td>
		</tr>		
		
	</table>
	
</body>
</html>