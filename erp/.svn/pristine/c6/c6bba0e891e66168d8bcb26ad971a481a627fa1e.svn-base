<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="com.ihk.utils.CacheUtils"%>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
	
	<title>主页</title>
	
	<base href="<%=basePath%>"/>
		
	<s:include value="../../customer/guangzhou/header.jsp"></s:include>	  
	<s:include value="../../customer/guangzhou/header_left_js.jsp"></s:include>	 
	
	<link href="css/main20111105.css"  rel="stylesheet" type="text/css" charset="utf-8"/>
	
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/customer_guangzhou_project.js"></script>	 
	<script type="text/javascript" src="<%=basePath%>js/highcharts.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/ui_fix.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/nowtime.js"></script>
	
	
	<style>
		*{margin:0;padding:0;}
		
	</style>
	
  </head>
  
 <body>
 
			  
			  <!--  列表 top -->
			  
			 <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" >
			  <tr class="gboxbg" style="width: 100%">
			    <td width="100%" style="font-weight: bold;">
			       	&nbsp;选择要操作的项目
			   </td>
			   </tr>
			    <s:iterator value="userRoleList" var="c">
			 	<tr style="background-color: #ffffff;line-height: 18px" >
			    <td width="100%">
					   &nbsp;<a style="color:#1199FF" href="./saleunit_new/appoint/guangzhou/joinSaleunit.action?projectId=${c.projectId}&type=${type}">${c.descProjectId }</a>
			   </td>
			 </tr>
			 
			 </s:iterator>
</table>
</body>
</html>

