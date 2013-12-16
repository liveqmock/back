<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

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
   

<table width="100%" border="0" cellspacing="0">
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
    <div >
    <div class="right04"></div>
    <div class="right05">
      <div class="titlel"></div>
       <!-- 菜单开始 -->
        <div class="titlebg" style=" height:auto;overflow:hidden;">
		<div class="title02" ><a href="./function_tree!tree_list.action" target="_self">查询功能列表</a></div>
 <!--提示begin-->
			<font color="#FF0000"><span id="suggestion"><s:property value="#request.suggestion"/></span></font>
<!--提示begin-->		          		
			<!--
            <div class="title02" style="display:none;"><a href="#">录入</a></div>
            <div class="title01"><a href="#">录入2</a></div>
            <div class="title02" style="display:none;"><a href="#">录入</a></div>
            <div class="title01"><a href="#">录入3</a></div>
            <div class="title02" style="display:none;"><a href="#">录入</a></div>
            <div class="title01"><a href="#">录入4</a></div>
            <div class="title02" style="display:none;"><a href="#">录入</a></div>
			-->
		<!-- 留一行 -->
          <div class="c"></div>
 <!-- 搜索表单 begin -->		  
 <form action="function_tree!queryTreeByName.action" method="post">		  
   <table width="98%" border="0" align="left" cellspacing="0">
	<!-- 蓝色边条begin -->	
		 <tr>
              <td height="10" colspan="6">
              <div class="blueline"></div>
              </td>
        </tr>
<!-- 蓝色边条end -->		
       
			
            <tr>
			  <td width="8%" height="0" align="right"><label> <span>功能名称&nbsp;</span></label></td>
              <td height="0" colspan="2">
			  	<input type="text" id="treeName" name="tree.treeName"/>&nbsp;&nbsp;
				<input type="submit" value=" 搜 索 " id="searchSubmit" onclick="return check();"/>
			  </td>  
				</tr>
			  <!--<td width="17%" height="0" align="right" >所属项目:</td>
              <td width="19%" height="0" align="left" >
			  
			  </td>  -->   

			  <!-- 蓝色边条begin -->	
      <tr>
              <td height="10" colspan="6">
              <div class="blueline"></div>
              </td>
       </tr>		
	
		
	  <!-- 
            <tr>
              <td height="20" colspan="6">
			
			  操作： 	
				<input type="button" id="delete" value="删除" onClick="return delSales('sale_hengda')"/>
				
				
				<a href="#" target="_blank" onClick="return false">删除</a> ｜ 
				<a href="#" target="_blank" onClick="return false">增加</a> ｜  
				<a href="#" target="_blank" onClick="return false">追加</a> ｜  
				<a href="#" target="_blank" onClick="return false">批量删除</a>
				
			 
				</td>
            </tr>
			
		-->
<!-- 列表 begin -->
            <tr>
              <td colspan="6">			  
			  <div class="gbox1">			  
			  <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" >
  				<tr class="gboxbg">
  	<!--
    <td width="77">
	<label for="checkbox">
	
	  <input name="allDel" type="checkbox" value="" onClick="allDel()" id="allDel"/>      
	  
      </label>
	 </td>
-->	
	
    <td width="329" align="center" valign="middle">功能名称</td>
    <td width="357" align="center" valign="middle">地址项目</td>	
    <td width="591" align="center" valign="middle">排序号</td>
	
	
    
  </tr>
  
   <!-- 循环数据begin -->
   <s:iterator value="#request.treeList" id="r">  
	  <tr onmouseover="this.style.backgroundColor='#f1f9fe';" onmouseout="this.style.backgroundColor=''" bgcolor="#FFFFFF">
	  	<!-- 
		<td width="77">
			<input name="delId" type="radio" value="<s:property value='#c.id'/>" />
		
			<input name="delId" type="checkbox" value="<s:property value='#c.id'/>" onClick="delId()" />
			
		</td>
			-->
		<td align="center" valign="middle" class="fontblue">
			<a href="./function_tree!tree_update.action?treeCode=<s:property value='#r.treeCode'/>" target="_self" ><s:property value="#r.treeName"/></a>
			
		</td>
	
		<td align="center" valign="middle">
			<s:property value="#r.actionUrl"/>
		</td>
		<td align="center" valign="middle">
			<s:property value="#r.orderIndex"/>
		</td>
		
		
	  </tr>
    </s:iterator>
   <!-- 循环数据end -->
</table>
</div>
</td>
 </tr>
<!-- 列表 end -->
       
            <tr>
              <td colspan="6">
                <div class="manu">
					<s:property value="showPage" escape="false"/>
				</div>                
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
<s:include value="include/bottom.jsp"></s:include>
   
   
   
  </body>
</html>


