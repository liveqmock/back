<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<style type="text/css">
	*{margin:0;padding:0;}
</style>

<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="white-space:nowrap; font-size:15px">
	 
	 <!-- 
	   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
		style="empty-cells:show">
		<td id="t15"  style="width:30%"  align="right">客户类型&nbsp;</td>
		<td id="t16" colspan="3">
			${contractCustomer.confirmType}	
		</td>
		 
	  </tr>
	   -->
	   
	   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
		style="empty-cells:show">
		<td id="t15"  style="width:30%"  align="right">客户姓名&nbsp;</td>
		<td id="t16" colspan="3">
			${contractCustomer.customerName}	
		</td>
		 
	  </tr>
	  
	   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
		style="empty-cells:show">
		<td id="t15"  style="width:30%"  align="right">电话号码&nbsp;</td>
		<td id="t16" colspan="3">
			${contractCustomer.phone}	
		</td>
		 
	  </tr>
	  
	   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
		style="empty-cells:show">
		<td id="t15"  style="width:30%"  align="right">性别&nbsp;</td>
		<td id="t16" colspan="3">
			${contractCustomer.gender}	
		</td>
		 
	  </tr>
	  
	   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
		style="empty-cells:show">
		<td id="t15"  style="width:30%"  align="right">证件类型&nbsp;</td>
		<td id="t16" colspan="3">
			${contractCustomer.idcardType}	
		</td>
		 
	  </tr>
	  
	   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
		style="empty-cells:show">
		<td id="t15"  style="width:30%"  align="right">证件号码&nbsp;</td>
		<td id="t16" colspan="3">
			${contractCustomer.idcardNo}	
		</td>
		 
	  </tr>
	  
	  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
		style="empty-cells:show">
		<td id="t15"  style="width:30%"  align="right">通信地址&nbsp;</td>
		<td id="t16" colspan="3">
			${contractCustomer.address}	
		</td>
		 
	  </tr>
</table>