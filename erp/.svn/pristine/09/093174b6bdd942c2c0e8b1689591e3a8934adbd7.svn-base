<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>header</title>
	
	<link href="css/tianluan.css"  rel="stylesheet" type="text/css" charset="utf-8"/>
	<meta http-equiv=Content-Type content="text/html; charset=utf-8" /> 
	
	<script type="text/javascript" language="javascript" src="./js/jquery-1.6.2.min.js"></script>
	<script type="text/javascript" language="javascript" src="./js/dialogFollow.js"></script>
	<script type="text/javascript" language="javascript" src="./js/customer_huijing.js"></script>	
	<script language="javascript" type="text/javascript" src="./My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" language="javascript" src="./js/jquery.bgiframe.min.js"></script>
	
	<script type="text/javascript" src="<%=basePath%>js/DD_belatedPNG_0.0.8a-min.js"></script>   
	<script type="text/javascript"> 
	    DD_belatedPNG.fix('.logo');  
	</script>

  </head>
  
  <body>
  
<!--top-->
<div class="boxnavtop">
    <div class="logo"></div>
    <div class="logoword">汇景国际项目</div>
    <!--welcome-->
	<div class="welcome">
    	<div class="welcome01"></div>
        <div class="welcome02">
		
		欢迎, <span class="fontblue">
		<s:property value="#session.loginAccount.realName"/>
		</span> | 
		<a href="./customer_huijing!customerLoginOut.action" title="注销" target="_self">注销</a> 
		<%-- ｜ 
		<a href="#" title="培训" onClick="return false;">培训</a> ｜ 
		<a href="#" title="帮助" onClick="return false;">帮助</a> ｜
		<a href="#" title="关于" onClick="return false;">关于</a>
		--%>
  		</div>
    <!--welcome.end-->
    </div>
	<div class="topline"></div>
</div>
<!--top.end-->
  	
  
  </body>
</html>
