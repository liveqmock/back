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
    
    <title>主页</title>
	
	<link href="css/hengda.css"  rel="stylesheet" type="text/css" charset="utf-8"/>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" /> 
	
  </head>
  
  <body onLoad="clearSuggestion()">
   
   
<!--main-->
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1">
  <tr>
  
 	<!--left.top-->
	
	<s:include value="left.jsp"></s:include>

    <!--left.end-->	
  
    <td width="100%" valign="top" height="100%" style="overflow:hidden;">
    <div class="right01"></div>
    <div class="right02"></div>
    <div class="right03"></div>
    <div class="c"></div>
	
    <div >
    <div class="right04"></div>
    <div class="right05">
      <div class="titlel"></div>
	  
        <div class="titlebg" style=" height:auto;overflow:hidden;">	
		
			<div class="title01" ><a href="./userrole!queryUserRoles.action" target="_self">查询用户角色</a></div>
            <div class="title02"><a href="./userrole!doSomeForAddUserRole.action" target="_self">新建用户角色</a></div>	
						
		
			
			
		   <div class="c"></div>
          <div class="c"></div>
		  
		  	   <div class="gbox1">		 
		  

              <div class="blueline"></div>
			  
		    <table width="50%" border="0" align="left" cellpadding="0" cellspacing="1" class="gbox" >
		   			
			  
			  <tr >
			 	<td height="20" colspan="4" bgcolor="#FFFFFF">
					&nbsp;&nbsp;
					<font color="#FF0000"><span id="suggestion"><s:property value="#request.suggestion"/></span></font>
				</td>
			  </tr>
			  
			  
			  
		    			
	  	<form class="registerform" action="userrole!addUserRole.action" method="get" >	

             <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td width="36%" align="center" id="t13">用户名称</td>
                <td width="64%" id="t14">
					&nbsp;<input type="text" id="userNameRemote" name="userName" style="width:180px"/>
				</td>  

              </tr>
			  
			   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td width="36%" align="center" id="t13">角色名称</td>
                <td width="64%" id="t14">
					&nbsp;<input type="text" id="roleName"  name="roleName" style="width:180px"/>
				</td>  

              </tr>
			 
	  
	  
		  <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"; align="center">
			<td colspan="4">
			  <input type="submit" value="  保存  " id="userRoleSub"/>
			  <input type="button" value="  取消  " onClick="javascript:window.location.href = './userrole!queryUserRoles.action?from=return'" />
			  
			 </td>
		  </tr>
		  
		   </form>
	  </table>
	  </div>
	  
			  <div class="c"></div>
			</div>
			
			
			
			<div class="titler"></div>
			<div class="c"></div>
		</div>
		<div class="right06"></div>
		<div class="c"></div>
		</div>
		<div class="right07"></div>
		<div class="right08"></div>
		<div class="right09"></div>
		<div class="c" ></div>
		</td>
	  </tr>
	  <!--main.end-->
	  <tr>
		<td height="5" colspan="3">
		</td>
	  </tr>
	</table>
	   
   
  </body>
</html>
