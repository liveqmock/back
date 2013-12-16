<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
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
	
	<meta http-equiv=Content-Type content="text/html; charset=utf-8" /> 
	
	<link href="<%=basePath%>css/blue.css" rel="stylesheet" type="text/css" charset="utf-8" />
	
	<script type="text/javascript" language="javascript" src="./js/jquery-1.6.2.min.js"></script>
	
	<script type="text/javascript" src="<%=basePath%>js/DD_belatedPNG_0.0.8a-min.js"></script>   
	<script type="text/javascript"> 
	    DD_belatedPNG.fix('.logo');  
	</script>
	
	<script type="text/javascript" language="javascript">
		
		$().ready(function(){
			/**
			$("#customer").mouseover(function(){
				$("#customerSub").show();
			});
			
			$("#customer").mouseout(function(){
				$("#customerSub").hide();
			});
			**/
			
		});
		
		
	</script>
		
  </head>
  
  <body>
   
   <!--top-->
<div class="boxnavtop">
    <!--title-->
    <div class="logo"><img src="<%=request.getContextPath() %>/images/blue/logo.gif" width="303" height="37" alt="logo" /></div>
	

    <div class="logoword">天銮项目</div>

	
    <!--title.end-->
	
	
    <!--welcome-->
	<div class="welcome">
	
    <div class="welcome02">
		欢迎, <span class="fontblue">
		<s:property value="#session.loginAccount.realName"/>
		</span> | 
		<a href="./customer!customerLoginOut.action" title="注销" target="_self">注销</a> ｜ 
		<a href="#" title="培训" onClick="return false;">培训</a> ｜ 
		<a href="#" title="帮助" onClick="return false;">帮助</a> ｜
		<a href="#" title="关于" onClick="return false;">关于</a>
	</div>
  </div>
    <!--welcome.end-->
	
    <div class="c"></div>
    <!--menu-->
    <div class="nav">
<div class="table">
<ul class="select">
<li><a href="<%=request.getContextPath() %>/customer!searchCustomer.action"><b>主页</b></a>
</li>
</ul>

<ul class="select">
<li><a href="#" id="customer" onClick="return false;"><b>客户</b></a>
<div class="select_sub">
	<ul class="sub" >
		<li><a href="<%=request.getContextPath() %>/customer!doSomeForAddCustomer.action" target="_self">新建客户</a></li>
		<li><a href="<%=request.getContextPath() %>/customer!searchCustomer.action?from=left" target="_self">查询客户</a></li>		
	</ul>
</div>
</li>
</ul> 

<%
	Object obj = request.getSession().getAttribute("type");
	String type = "";
	if(obj != null){
		type = obj.toString();
	}
	
	if("2".equals(type)){
%>

<ul class="select">
<li><a href="<%=request.getContextPath() %>/user/indexUserAccount.action?tips=reset" onClick="return false"><b>用户管理</b></a>
<div class="select_sub">
	<ul class="sub">
		<li><a href="<%=request.getContextPath() %>/user/indexUserAccount.action">用户管理</a></li>
	</ul>
</div>
<%
}
%>
</li>
</ul>


<ul class="select"><li><a href="<%=request.getContextPath() %>/user/updateUserAccountJsp_user.action"><b>修改密码</b></a>
</ul>



<!--
<ul class="select"><li><a href="#" onClick="return false"><b> 个案解决方案</b></a>
<div class="select_sub">
	<ul class="sub">
		<li><a href="#">目录一</a></li>
		<li><a href="#">目录二</a></li>
		<li><a href="#">目录三</a></li>
		<li><a href="#">目录四</a></li>
		<li><a href="#">目录五</a></li>
	</ul>
</div>
-->

</li>
</ul>
</div>
</div>
    <!--menu.end-->
    <div class="blackline"></div>
    <div class="c"></div>
    </div>
<!--top.end-->
   
   
  </body>
</html>
