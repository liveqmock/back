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
	
	<link rel="stylesheet" href="./css/style.css" type="text/css" />
	<link rel="stylesheet" href="./css/imageflow.packed.css" type="text/css" />
	
	<script type="text/javascript" language="javascript" src="./js/imageflow.js"></script>
	<script type="text/javascript" language="javascript" src="./js/lhgcore.lhgdialog.min.js"></script>
	
<title>弃用</title></head>

<body>
	
	<div id="myImageFlow" class="imageflow">
	
		<s:iterator value="#request.imageList" id="c">  
	
			<img src="${c.url}" longdesc="${c.url}" width="400" height="400" alt="${c.context}" />
		
		</s:iterator>
		
	</div>
	
</body>

</html>
