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
		<title>查询楼盘</title>
		<style >
			.tb1 input{width:100%}
			.thisdiv td{padding-left: 12px}
			.ablue {color:#1199ff; text-decoration:underline;}
		</style>
	</head>
	<body>
	
<%--固定的上部 --%>

<s:include value="../../../customer/guangzhou/body_up.jsp">
</s:include>	

<%--主体导航页头 --%>
<div class="title01" ><a href="./property/developer/index.action?ts=<%= CacheUtils.getUrlTimeStamp()%>">开发商</a></div>
<div class="title02" ><a href="./property/project/index.action?ts=<%= CacheUtils.getUrlTimeStamp()%>">楼盘项目</a></div>
<div class="title01" ><a href="./property/area/searchIndex.action?ts=<%= CacheUtils.getUrlTimeStamp()%>" target="_self">分区</a></div>
<div class="title01" ><a href="./property/build/index.action?ts=<%= CacheUtils.getUrlTimeStamp()%>" target="_self">楼栋</a></div>

<table width="100%" border="0" cellspacing="0" class="d_top">
	<tr>
	  <td bgcolor="#edf8fe">
	  
	<div class="d_over">
		<b><a href="./property/project/index.action" target="_self">查询楼盘</a></b>
	</div>		
	<div class="d_out">
		<a href="./property/project/input_index.action" target="_self">新建楼盘</a>
	</div>				
	 </td>
	</tr>
</table>
<div class="right99"></div>
<div class="blueline"></div>

<%--主体table --%>
<div title="查询" style="height: 25px;width: 100%">
<form action="./property/project/search.action" method="post">
	&nbsp;楼盘名<input type="text" name="proProCond.searchName" value="${proProCond.searchName}"/>&nbsp;<input type="submit" value="  查询  "/>
	</form>
	
</div>

	<div  style="width: 100%;float: left;vertical-align: top;">
		 <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox thisdiv" style="margin-top: 5px;">
				<tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"; class="gboxbg">
					<td><span>楼盘名称</span></td>
					<td><span>开盘日期</span></td>
					<td><span>封盘日期</span></td>
					<td><span>别名</span></td>
					<td><span>创建日期</span></td>
					<td></td>
				</tr>
				<s:iterator value="proproList" id="li">
				<tr bgcolor="#FFFFFF";">
					<td>
					<a   href="./property/project/update_index.action?updateId=${li.id}" class="ablue" style="color:#1199ff">
					${li.propertyName}</a></td>
					<td>
						<s:date name="#li.startSaleDate" format="yyyy-MM-dd"/>
					</td>
					<td>
						<s:date name="#li.endSaleDate" format="yyyy-MM-dd"/>
					</td>
					<td>${li.simpleName}</td>
					<td>
						<s:date name="#li.createdTime" format="yyyy-MM-dd"/>
					</td>
					<td> <a  class="ablue" style="color:#1199ff" href="./property/build/input_index.action?inputBuild.propertyId=${li.id}">新建楼栋</a> </td>
					</tr>
				</s:iterator>	
		</table>
		<div class="manu">
					<s:property value="showPage" escape="false"/>
				</div>
	</div>
	 
<%--固定的底部 --%>
<s:include value="../../../customer/guangzhou/body_bottom.jsp">
</s:include>
	</body>
</html>
