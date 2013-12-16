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
    
    <title>update ref role priv</title>
	
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
		
        	
	         <div class="title01" ><a href="./user_role_priv!rolePrivRef_index.action" target="_self">列表</a></div>
            <div class="title02"><a href="./user_role_priv!addRefRolePriv.action" target="_self" >新建</a></div>								
			
		
		
		<!-- right form top -->
	<form class="registerform" action="./user_role_priv!updateRefRolePrivAction.action" method="get" >	
			
          <div class="c"></div>
          <div class="c">
		  	  &nbsp;&nbsp;	
			
			
		  </div>
		  
		  	  
		  
           <table width="30%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" >
		    
			  
             <tr bgcolor="#FFFFFF" onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" >
                <td width="20%" align="right" id="t13">角色:</td>
                <td width="80%" id="t14">
					<input type="text" name="ref.roleId" id="roleid" class="leftcreateinputbox01"  value="${ref.roleId}" disabled="disabled"/>				</td>  
              </tr>
			  
			  
			  
             <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                 <td width="20%" align="right" id="t13">仿照:</td>
                 <td width="80%" id="t14">
					<input type="text" name="ref.refRoleId" id="initRolePriv" class="leftcreateinputbox01"  value="${ref.refRoleId}"/>				</td>  
              </tr>
             
			 
             
	  
		  <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"; align="left">
			<td >&nbsp;&nbsp;<FONT color="red"><s:actionmessage/></FONT>			 </td>
			<td><input name="submit" type="submit" id="sub" value=" 保 存"/>
			  <input name="button" type="button" onClick="javascript:window.location.href = './user_role_priv!rolePrivRef_index.action'" value=" 取 消" />			  </td>
		  </tr>
	  </table>
	  
	  </form>
	  
	  
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
