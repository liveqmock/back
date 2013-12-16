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
		
		<script type="text/javascript" language="javascript" src="<%=basePath%>js/customer_guangzhou_project.js"></script>	 
			
		<title>查询分区楼栋</title>
		<style >
			.tb1 input{width:100%}
			.thisdiv td{padding-left: 12px}
			.ablue {color:#1199ff; text-decoration:underline;}
		</style>
		
			<script type="text/javascript">
			$().ready(function(){
				propertyProjectListForHiddenId("projectName", "hiddenId");
		
			});
		</script>
	</head>
	<body>
	
<%--固定的上部 --%>

<s:include value="../../../customer/guangzhou/body_up.jsp">
</s:include>	

<%--主体导航页头 --%>
<div class="title01" ><a href="./property/developer/index.action?ts=<%= CacheUtils.getUrlTimeStamp()%>">开发商</a></div>
<div class="title01" ><a href="./property/project/index.action?ts=<%= CacheUtils.getUrlTimeStamp()%>">楼盘项目</a></div>
<div class="title01" ><a href="./property/area/searchIndex.action?ts=<%= CacheUtils.getUrlTimeStamp()%>" target="_self">分区</a></div>
<div class="title02" ><a href="./property/build/index.action?ts=<%= CacheUtils.getUrlTimeStamp()%>" target="_self">楼栋</a></div>
<table width="100%" border="0" cellspacing="0" class="d_top">
	<tr>
	  <td bgcolor="#edf8fe">
	<div class="d_over">
		<b><a href="./property/build/index.action" target="_self">查询楼栋</a></b>
	</div>		
	<div class="d_out">
		<a href="./property/build/input_index.action" target="_self">新建楼栋</a>
	</div>				
	 </td>
	</tr>
</table>
<div class="right99"></div>
<div class="blueline"></div>
<%--主体table --%>
<div title="查询" style="height: 25px;width: 100%">
<form action="./property/build/search.action" method="post">
	&nbsp;楼盘项目<input type="text" name="propertyName" id="projectName" value="${propertyName }"/>
	<input type="hidden" name="buildCond.propertyId" id="hiddenId" />
	&nbsp;楼栋名<input type="text" name="buildCond.searchName" value="${buildCond.searchName}"/>
	&nbsp;<input type="submit" value="  查询  "/>
	</form>
	
</div>
	<div  style="width: 100%;float: left;vertical-align: top;margin-top: 5px;">
		 <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox thisdiv" >
				<tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" class="gboxbg">
					<td><span>楼盘项目</span></td>	
					<td><span>楼栋名称</span></td>
					<td><span>租售类型</span></td>
					<td><span>建筑性质</span></td>
					<td><span>分区/楼栋</span></td>
				</tr>
				<s:iterator value="buildList" id="li">
				<tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
					<td>${li.descPropertyId}</td>
					<td>
					<a   href="./property/build/update_index.action?updateId=${li.id}" class="ablue" style="color:#1199ff">
					${li.buildName }</a></td>
					<td>${li.descSaleType}</td>
					<td>${li.descBuildNature}</td>
					<td>${li.descBuildType}</td>
					
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
