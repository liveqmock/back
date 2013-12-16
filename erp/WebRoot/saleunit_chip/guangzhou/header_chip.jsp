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

<link href="./css/blue_guangzhou.css"  rel="stylesheet" type="text/css" charset="utf-8"/>
<link href="./css/jquery.autocomplete.css" rel="stylesheet" type="text/css" charset="utf-8"/>
<link href="./css/easyui.css" rel="stylesheet" type="text/css"	charset="utf-8" />
<link href="./css/icon.css" rel="stylesheet" type="text/css" charset="utf-8"/>

<script type="text/javascript" language="javascript" src="./js/jquery-1.6.2.min.js"></script>
<script type="text/javascript" language="javascript" src="./js/jquery.easyui.min.js"></script>	
<script type="text/javascript" language="javascript" src="./css/local/easyui-lang-zh_CN.js"></script>	

<script type="text/javascript" language="javascript" src="./js/jquery.autocomplete.js"></script>

<script type="text/javascript" language="javascript" src="./js/common.js"></script>
<script type="text/javascript" language="javascript" src="./js/customer_common.js"></script>

<script type="text/javascript" language="javascript" src="./js/customer_guangzhou_project.js"></script>