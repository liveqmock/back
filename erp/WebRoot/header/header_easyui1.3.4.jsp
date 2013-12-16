<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
			
	response.setHeader("Pragma","No-cache");   
	
	response.setHeader("Cache-Control","no-cache");   
	
	response.setDateHeader("Expires", 0);  
%>
<base href="<%=basePath%>">	
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<script type="text/javascript" language="javascript" src="<%=basePath%>js/jquery-1.6.2.min.js"></script>   	

<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/easyui1.3.4.css?v=2">
   
<link href="<%=basePath%>css/icon.css" rel="stylesheet" type="text/css"	charset="utf-8" />

<script type="text/javascript" src="<%=basePath%>/js/easyui1.3.4/jquery.easyui1.3.4.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/easyui1.3.4/datagrid-groupview.js"></script>
   
<script type="text/javascript" src="<%=basePath%>js/easyui.utils.js?v=0712"></script>
<script type="text/javascript" language="javascript" src="<%=basePath%>css/local/easyui-lang-zh_CN.js"></script>
