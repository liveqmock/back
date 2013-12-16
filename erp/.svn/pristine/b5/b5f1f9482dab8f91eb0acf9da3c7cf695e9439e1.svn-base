<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="com.ihk.utils.CacheUtils"%>
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
		<s:include value="../../../customer/guangzhou/header.jsp"></s:include>	
		<s:include value="../../../customer/guangzhou/header_left_js.jsp"></s:include>	
		<title>初始化楼栋</title>
		<style >
			.tb1 input{width:100%}
			.tb1 td{padding: 0px 10px }
			.tb1 tr{background:#FFFFFF}
			.redbor {border: 2px solid red}
		</style>
	</head>
	<body>
	
<%--固定的上部 --%>

<s:include value="../../../customer/guangzhou/body_up.jsp">
</s:include>	

<%--主体导航页头 --%>

<div class="title02" ><a href="./property/unit/search_list_index.action?ts=<%= CacheUtils.getUrlTimeStamp()%>" target="_self">单元列表</a></div>
<div class="title01" ><a href="./property/unit/show_index.action?ts=<%= CacheUtils.getUrlTimeStamp()%>"  target="_self">单元视图</a></div>
<table width="100%" border="0" cellspacing="0" class="d_top">
	<tr>
	  <td bgcolor="#edf8fe">
	  
	<div class="d_out">
		<a href="./property/unit/search_list_index.action?ts=<%=CacheUtils.getUrlTimeStamp()%>" target="_self">查询单元</a>
	</div>		
	<div class="d_over">
		<b><a href="./property/unit/index.action?ts=<%=CacheUtils.getUrlTimeStamp()%>" target="_self">初始化单元</a></b>
	</div>				
	 </td>
	</tr>
</table>
<div class="right99"></div>
<div class="blueline"></div>

<%--主体table --%>
	<div style="width: 1000px;height: inherit;float: left;vertical-align: top;">
		<form action="./property/unit/batch_input.action" method="post">
		<div style="width: 100%;float: left;">
	
			<table cellpadding="0" cellspacing="1"  style="vertical-align: top;width: 75%" class="tb1 gbox">
				<tr>
					<td align="right" width="100px">所属楼栋</td>
					<td colspan="3">
						<s:select list="buList" listValue="buildName" listKey="id" name="buildId"></s:select>
					</td>
					
				</tr>
					<tr>
					<td align="right">前缀</td>
					<td colspan="3"><input  name="prefix" style="width: 100px"/></td>
					
					
				</tr>
				<tr>
					<td align="right">单元编号生成方案</td>
					<td><select><option>方案1(前缀-楼层-房间号)</option></select></td>
					
					<td align="right">楼层</td>
					<td><input  name="startFloor" style="width: 50px"/>到<input  name="endFloor" style="width: 50px"/></td>
				</tr>
				<tr>
					<td align="right">单元别号方案</td>
					<td><select><option>方案1</option></select>
						
					</td>
					<td align="right">单元</td>
					<td><input  name="startUnit" style="width: 50px"/>到<input  name="endUnit" style="width: 50px"/></td>
					
					
				</tr>
				<tr>
					<td colspan="4" align="center"> <button type="submit" >  批量初始化 </button>
				 	<s:if test="tip == 'suc'" > 
						<a class="ablue" style="color:#1199FF" href="./property/unit/reset_index.action?unitCond.buildId=${buildId}">查看初始化的单元</a>
					 </s:if>
					<s:actionmessage cssStyle="color:red"/> </td>
				</tr>
		</table>
		</div>
		</form>
	</div>
<%--固定的底部 --%>
<s:include value="../../../customer/guangzhou/body_bottom.jsp">
</s:include>
	</body>
</html>
