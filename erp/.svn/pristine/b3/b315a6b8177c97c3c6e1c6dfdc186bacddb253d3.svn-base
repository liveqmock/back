<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head><s:include value="include/header.jsp"/>
<title>priv_func</title>
</head> 
  
<body onload="clearSuggestion()">
 <!-- top -->
<s:include value="include/top.jsp"></s:include>
<!-- top end -->
<!--main-->
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1">

  <tr>
 <!--left begin-->
    <td width="213" valign="top">
	<s:include value="include/left.jsp"/>	
  </td>
  
  
<td width="9" valign="middle">
<img src="<%=basePath%>images/tianluan/arrow01.gif" width="9" height="90" border="0" id="img" class="img" title="点击收缩"/>
</td>
 <!--left.end-->
  
    <td width="100%" valign="top" height="100%" style="overflow:hidden;">
    <div class="right01"></div>
    <div class="right02"></div>
    <div class="right03"></div>
    <div class="c"></div>
	
  
    <div class="right04"></div>
    <div class="right05">
    <div class="titlel"></div>
	  
    <div class="titlebg" style=" height:auto;overflow:hidden;">	
	<div class="title01" ><a href="./priv_func!privfunc_list.action" target="_self">查询功能列表</a></div>
    <div class="title02" ><a href="./priv_func!tree_add.action" target="_self">新增功能权限</a></div>						
 		&nbsp;&nbsp;
		<!-- 留一行 -->
          <div class="c"></div>
         <!-- 菜单结束 --> 
<!-- 提示显示begin -->
	<font color="#FF0000"><span id="suggestion"><s:property value="#request.suggestion"/></span></font>
<!-- 提示显示end -->		
<!-- 搜索表单 begin -->
<form class="registerform" action="<%=request.getContextPath() %>/priv_func!tree_updated.action" method="post" >
<table width="100%" border="0" align="left" cellspacing="0">
	<!-- 蓝色边条begin -->
			
		 <tr>
              <td height="10" colspan="6">
              <div class="blueline"></div>
              </td>
  			
  			<td height="10" colspan="6"><div class="c"></div></td>
  			
		</tr> 	
		<tr>
			<td height="10" colspan="6"><div class="c"></div></td>
		</tr>
	<!-- 蓝色边条end -->	  	  
<tr><td>	
  <table width="50%" border="0" align="left" cellpadding="0" cellspacing="1" class="gbox" >
			<input type="hidden"" name="privFunc.id" id="id" value="${privFunc.id}"/>
             <tr onmouseover="this.style.backgroundColor='#f1f9fe'" onmouseout="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
             
             <td width="33%" align="center" id="t13">功能树名称:</td>
                <td width="67%" id="t14">
					 &nbsp;
					 <s:select list="selPrivFunc" name="privFunc.treeCode" value="#request.privFunc.treeCode"></s:select>
				</td>  
			    </tr>
         
             
			   <tr onmouseover="this.style.backgroundColor='#f1f9fe'" onmouseout="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td width="33%" align="center" id="t13">权限名称:</td>
                <td width="67%" id="t14">
                &nbsp;
                <s:select list="selPriv" name="privFunc.privCode" value="#request.privFunc.privCode"></s:select>
                </td>  
              </tr>

		  <tr onmouseover="this.style.backgroundColor='#f1f9fe'" onmouseout="this.style.backgroundColor=''" bgcolor="#FFFFFF"; align="center">
			<td colspan="4">
			  <input type="submit" value="保 存" id="sub"/>
			  <input type="button" value="取 消" onclick="javascript:window.location.href = './priv_func!privfunc_list.action?from=return'" />
			  <font color="#FF0000"><span id="suggestion2"><s:property value="#request.suggestion2"/></span></font>
			 </td>
		  </tr>
</table>
</td>
</tr>	
</table>
</form>
</div>
			<div class="titler"></div>
			<div class="c"></div>
		</div>
		<div class="right06"></div>
		<div class="c"></div>
	
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
	<s:include value="include/bottom.jsp"></s:include>   
  </body>
</html>
