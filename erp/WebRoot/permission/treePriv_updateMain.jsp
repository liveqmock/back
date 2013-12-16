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
<table width="100%" border="0" align="left" cellpadding="0" cellspacing="1">
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
 <!-- 菜单开始 -->	  
    <div class="titlebg" style=" height:auto;overflow:hidden;">	
	<div class="title02" ><a href="./function_tree!queryTreeByName.action" target="_self">查询功能列表</a></div>
     &nbsp;&nbsp;       						
<!-- 留一行 -->
          <div class="c"></div>
         <!-- 菜单结束 -->   			
<!-- 提示显示begin -->
	<font color="#FF0000"><span id="suggestion"><s:property value="#request.suggestion"/></span></font>
<!-- 提示显示end -->		
<!-- 搜索表单 begin -->		
<form class="registerform" action="<%=request.getContextPath() %>/function_tree!tree_updated.action" method="post" >	
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
		    
			<input type="hidden"" name="tree.treeCode" id="treecode" value="${tree.treeCode}"/>
             <tr onmouseover="this.style.backgroundColor='#f1f9fe'" onmouseout="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
			 
			  <td width="22%" align="center" id="t13">功能编码</td>
                <td width="78%" id="t14">
					 &nbsp;<input type="text" name="tree.treeCode" id="treeCode" class="leftcreateinputbox01" value="${tree.treeCode}" disabled="disabled"/>
				</td>	
			    </tr>
				 
				  <tr onmouseover="this.style.backgroundColor='#f1f9fe'" onmouseout="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td width="22%" align="center" id="t13">功能名称</td>
                <td width="78%" id="t14">
					&nbsp;<input type="text" name="tree.treeName" id="treeName" class="leftcreateinputbox01" value="${tree.treeName}" />
				</td>  
					
                
              </tr>
			  
			   <tr onmouseover="this.style.backgroundColor='#f1f9fe'" onmouseout="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td width="22%" align="center" id="t13">action地址&nbsp;</td>
                <td width="78%" id="t14">
					&nbsp;<input type="text" name="tree.actionUrl" id="actionUrl" class="leftcreateinputbox02" value="${tree.actionUrl }"  style="width:80%"/>
				</td>  
					
                
              </tr>
			  
             <tr onmouseover="this.style.backgroundColor='#f1f9fe'" onmouseout="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t11" align="center" >排序号</td>
                <td id="t12" colspan="3">
					 &nbsp;<input type="text" name="tree.orderIndex" id="orderIndex" class="leftcreateinputbox01"  value="${tree.orderIndex }"/>
				</td>
              </tr>
             
		  <tr onmouseover="this.style.backgroundColor='#f1f9fe'" onmouseout="this.style.backgroundColor=''" bgcolor="#FFFFFF"; align="center">
			<td colspan="4">
			  <input type="submit" value="保 存" id="treesub"/>
			  
			  <input type="button" value="取 消" onclick="javascript:window.location.href = './function_tree!tree_list.action?from=return'" />
		
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
