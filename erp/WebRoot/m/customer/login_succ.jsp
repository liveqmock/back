<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html> 
<html>
<head>
	<meta charset="utf-8">
	<title>erp手机登陆成功</title>
    
    <base href="<%=basePath%>"/>
    
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    
    <link rel="stylesheet" href="./m/js/jquery.mobile-1.3.1.min.css"/>    
    <link rel="stylesheet" href="./m/css/mobiscroll.custom-2.5.0.min.css"/>
    
	<script type="text/javascript" language="javascript" src="./m/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" language="javascript" src="./m/js/jquery.mobile-1.3.1.min.js"></script>
	<script type="text/javascript" language="javascript" src="./m/js/mobiscroll.js"></script>    
    
    <script type="text/javascript" language="javascript">
		
		//注销
		function loginOut(){
			var ret = confirm("是否注销");
			if(ret == true){
				location.href = "<%=basePath%>m/loginOut.action";
			}
		}
	
	</script>
    
</head>

<body>

<div data-role="page" id="login_succ_page">

	<div data-role="header" data-theme="b">
		<a href="javascript:void(0)" data-icon="forward" id="loginOut" data-ajax="false" onClick="loginOut();">注销</a>
		<h1>欢迎:${loginAccount.realName}</h1>               

	</div><!-- /header -->

	<div data-role="content">
    
    	<a href="<%=basePath%>m/to.action" data-icon="save" data-role="button" data-ajax="false" data-theme="e">录入客户</a>
        
        <a href="<%=basePath%>m/indexSearch.action?ts=<%=new Date()%>" data-icon="search" data-role="button" data-ajax="false" data-theme="e">查询客户</a>
    
        
    </div><!-- /content -->

	<!-- data-position="fixed",把顶部或底部固定; data-fullscreen="true",是否全屏,也是点上去是否隐藏顶部及底部-->
	<div data-role="footer" data-theme="b" data-fullscreen="false" data-position="fixed">
		<h4>Copyright ©2013合富辉煌 版权所有</h4>
	</div><!-- /footer -->
    
    
</div><!-- /page -->

	
</body>
</html>