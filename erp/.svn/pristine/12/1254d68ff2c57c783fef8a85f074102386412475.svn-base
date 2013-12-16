<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";			
	response.setHeader("Pragma","No-cache"); 	
	response.setHeader("Cache-Control","no-cache");  	
	response.setDateHeader("Expires", 0);  
%>
<s:include value="../../header/header_easyui.jsp"></s:include>
<script language="javascript" type="text/javascript" src="<%=basePath%>js/project.list.utils.js?v=1.2"></script>
<script type="text/javascript" src="<%=basePath%>js/highcharts.js"></script>
<script type="text/javascript" src="<%=basePath%>js/datetime.utils.js?v=1"></script>