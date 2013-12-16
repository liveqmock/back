<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'query_xshlfx_ld.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<s:include value="header_report.jsp"></s:include>
  </head>
  
  <body>
  <table width="100%" border="0" align="center" cellpadding="0"
	cellspacing="1" class="gbox" style="text-align: center;">
	<tr class="gboxbg">
		<th>项目名称</th>
		<th width="30px"></th>
		<th>选项</th>
		<th>楼层</th>
	</tr>
    <s:property value="showTable"  escape="false"/> 
  </table>
  </body>
</html>
