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
	
	<base href="<%=basePath%>">
		
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
 
 
<%--固定的上部 --%>
<s:include value="../../customer/guangzhou/body_up_login_index.jsp">
</s:include>

	
<%--主体table top --%>
		
  		
<%--主体导航页头 --%>
<div class="title01" ><a href="./saleunit_new/appoint/guangzhou/saleUnitInitSelect.action?type=1" target="_self">楼盘初始</a></div>
<div class="title01"><a href="./saleunit_new/appoint/guangzhou/saleUnitInitSelect.action?type=2">销控中心</a></div>
<div class="title02"><a href="./saleunit_new/appoint/guangzhou/saleUnitInitSelect.action?type=3">财务管理</a></div>			
<div class="right99"></div>
		  
		  <table style="width: -moz-available;" align="left" border="0" cellspacing="0">		  
		  
		  <!-- 搜索表单 top -->
       
 
		  
		<!-- 搜索表单 end -->
			
            <tr>
              <td height="10" colspan="6">
              <div class="blueline"></div>
              </td>
            </tr>		
		
			
            <tr>
              <td colspan="6">			  
			  
			  <!--  列表 top -->
			  <div class="gbox1">			  
			  
			  <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" >
  <tr class="gboxbg">
    
	

    <td width="100">
       	项目名称
   </td>
     <td width="100">
       	楼栋数量
   </td>
    <s:iterator value="userRoleList" var="c">
 	<tr style="background-color: #ffffff">
    <td width="100">
		    <a href="./saleunit_new/appoint/guangzhou/joinSaleunit.action?projectId=${c.projectId}&type=3">${c.descProjectId }</a>
   </td>
     <td width="100">
       	楼栋数量
   </td>
 </tr>
 
 </s:iterator>
</table>


<%--主体table end --%>



<%--固定的底部 --%>

</table>  
   <s:include value="../../customer/guangzhou/body_bottom.jsp">
</s:include>
</body>
</html>

