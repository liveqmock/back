<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<s:include value="include/header.jsp"></s:include>
		
<script>
			$(function() {
				var editor = KindEditor.create('textarea[name="article.content"]');
			});
		</script>
		<title>录入通告</title>
		
	</head>
	<body onload="clearSuggestion()">
		<table width="100%" border="0" align="left" cellspacing="0" >
			<thead>
				<tr>
					<td colspan="2" style="border-collapse: collapse; border: 0px; margin: 0px; padding: 0px;">
						<s:include value="include/top.jsp"></s:include>
					</td>
				</tr>
			</thead>
			<tfoot>
				<tr>
					<td colspan="2">
						<s:include value="include/bottom.jsp"></s:include>
					</td>
				</tr>
			</tfoot>
			<tbody>
				<tr>
					<td valign="top">
						<s:include value="../hengda/sale/include/left.jsp">
						</s:include>
					</td>
					<td width="100%" valign="top" >
		 	<DIV style="WIDTH: 98%; HEIGHT: 100%; BACKGROUND-COLOR: #A4C3D7;padding: 1px">
		  	<%-- 基本table分割 ^^^^^^<td width="100%">^^^^^^^^^^^^^^^^^^^^^^--%>
						<%--main table开始 --%>
<!--main-->
<table width="100%" class="mainbg20111112" style="height: 100%; white-space: nowrap;" >
  <tr>
  
    <td width="100%" valign="top" height="100%" style="overflow:hidden;">
   
      <div class="titlel"></div>
	  
        <div class="titlebg" style=" height:auto;overflow:hidden;">	
		
        	<div class="title01"><a href="./article/search/all.action" target="_self">查询文章</a></div>	
	        <div class="title02" ><a href="./article/input/for_article.action" target="_self">录入文章</a></div>
            		
			
		   <div class="right99"></div>
			<div class="blueline"></div>
		
		<!-- right form top -->
		<form class="registerform" id ="registerform" action="./article/input/article.action" method="post" >	
			
          <div class="c"></div>
          <div class="c"></div>
		  
           <table width="750" border="0" align="left" cellpadding="0" cellspacing="1" class="gbox"  style="margin-top:10px;_margin-top:0px;*margin-top:0px;">
		   	   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
			<td width="100" align="center" id="t15"  >文章类型</td>
                <td  id="t16"  >
				&nbsp;
				<select name="article.articleType">
					<option value="1">系统公告</option>
					<option value="2">更新公告</option>
				</select>
				<td width="100" align="center" id="t15"  >顺序</td>
                <td width="505"  id="t16" >
				&nbsp;
				<input type="text"  id="orderIndex"  name="article.orderIndex" /></td>
			</tr>
		   	<tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
			<td width="100" align="center" id="t15"  nowrap="nowrap">标题</td>
                <td width="191"  id="t16" colspan="3">
				&nbsp;
				<input type="text"  id="title"  name="article.title"/></td>
				
			</tr>
		   	<tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
			<td width="100" align="center" id="t15"   >摘要</td>
               
                <td width="505"  id="t16" colspan="3">
				&nbsp;
				<input type="text"  id="summary"  name="article.summary" style="width: 70%"/></td>
			</tr>
		   	
			 
			
			
			 	<tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"; align="center">
			
             <td width="191"   colspan="4" align="left"><textarea name="article.content" style="width:800px;height:200px;"></textarea>
               </td>
			</tr>
		  		<tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"; align="center">
			<td colspan="6">
			  <input type="submit" value="  保存  " id="sub" />
			  <input type="button" value="  取消  " onClick="javascript:window.location.href = '<%=path %>/article/search/all.action'" />			
			  <font color="#FF0000">
			  &nbsp;&nbsp;<span id="suggestion"><s:property value="#request.suggestion"/></span></font>
			  </td>
		  </tr>
	  </table>
	  
	  </form>
	  
			  <div class="c"></div>
			</div>
			<div class="titler"></div>
			<div class="c"></div>
		<div class="c" ></div>
		</td>
  </tr>
		</table>
		
	  <!--main.end-->
		</td>
					<%-- 基本table分割 ^^^^^^^^^^^^^^^^^end^^^</td>^^^^^^^^^^^^^^^^^^^^^--%>
					</div>
				</tr>
			</tbody>

		</table>

	</body>
</html>

