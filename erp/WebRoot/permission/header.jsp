<%@ page language="java" import="java.util.*,com.ihk.utils.CommonUtils" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>header</title>
	 
	<link href="css/hengda.css"  rel="stylesheet" type="text/css" charset="utf-8"/>
	<meta http-equiv=Content-Type content="text/html; charset=utf-8" /> 
	
	<script type="text/javascript" language="javascript" src="./js/jquery-1.6.2.min.js"></script>
	<script language="javascript" type="text/javascript" src="./My97DatePicker/WdatePicker.js"></script>
	<script language="javascript" type="text/javascript" src="./js/permission.js"></script>
	
	<script type="text/javascript" src="./js/jquery.js"></script>
	<script type="text/javascript" src="./js/jquery.bgiframe.min.js"></script>
	<script type="text/javascript" src="./js/jquery.ajaxQueue.js"></script>
	<script type="text/javascript" src="./js/thickbox-compressed.js"></script>
	<script type="text/javascript" src="./js/jquery.autocomplete.js"></script>

	<link rel="stylesheet" type="text/css" href="css/jquery.autocomplete.css" />
	<link rel="stylesheet" type="text/css" href="css/thickbox.css" />

	<script type="text/javascript" src="<%=basePath%>js/DD_belatedPNG_0.0.8a-min.js"></script>   
	<script type="text/javascript"> 
	    DD_belatedPNG.fix('.logo');  
	</script>
	
  </head>
  
  <body>
  
<!--top-->
	<div class="boxnavtop">
    <div class="logo"></div>
    <div class="logoword">恒大项目</div>
    <!--welcome-->
<div class="welcome">
    	<div class="welcome01"></div>
        <div class="welcome02">
		
		欢迎, <span class="fontblue">
		<s:property value="#session.loginAccount.realName"/>
		</span> | 
		<a href="./customer!customerLoginOut.action" title="注销" target="_self">注销</a> 
		
	  </div>

    <!--welcome.end-->
    </div>
<div class="topline"></div>
</div>
<!--top.end-->
  	
  
  </body>
</html>
