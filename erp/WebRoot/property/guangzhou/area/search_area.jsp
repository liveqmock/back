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
<div class="title02" ><a href="./property/area/searchIndex.action?ts=<%= CacheUtils.getUrlTimeStamp()%>" target="_self">分区</a></div>
<div class="title01" ><a href="./property/build/index.action?ts=<%= CacheUtils.getUrlTimeStamp()%>" target="_self">楼栋</a></div>
<table width="100%" border="0" cellspacing="0" class="d_top">
	<tr>
	  <td bgcolor="#edf8fe">
	<div class="d_over">
		<b><a href="./property/area/searchIndex.action" target="_self">查询分区</a></b>
	</div>		
	<div class="d_out">
		<a href="./property/area/index.action" target="_self">新建分区</a>
	</div>				
	 </td>
	</tr>
</table>
<div class="right99"></div>
<div class="blueline"></div>
<%--主体table --%>
<div style="height: 25px;width: 100%;margin-top: 5px">
<form action="./property/area/searchForm.action" method="post">
	&nbsp;楼盘<input type="text" name="areaCond.propertyName" id="projectName" value="${areaCond.propertyName }"/>
	<input type="hidden" name="areaCond.propertyId" id="hiddenId" value="${areaCond.propertyId}"/>
	&nbsp;分区<input type="text" name="areaCond.areaName" value="${areaCond.areaName}"/>
	<input type="hidden" name="areaCond.likeAreaName" value="yes"/>
	&nbsp;<input type="submit" value="  查询  " id="submit_for_search_area"/>
	</form>
	
</div>

	<div  style="width: 100%;float: left;vertical-align: top;margin-top: 5px">
		 <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox thisdiv" >
				<tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"; class="gboxbg">
					<td><span>楼盘</span></td>	
					<td><span>分区</span></td>
					<td><span>创建时间</span></td>
					<td><span>创建人</span></td>
				</tr>
				<s:iterator value="areaList" id="li">
				<tr bgcolor="#FFFFFF">
					<td>${li.descPropertyId}</td>
					<td>
						<a   href="./property/area/updateIndex.action?updateArea.id=${li.id}" class="ablue" style="color:#1199ff">
						${li.areaName }</a>
					</td>
					<td>
						<s:date name="#request.li.createdTime" format="yyyy-MM-dd HH:ss"/>
					</td>
					<td>${li.descCreatedId}</td>
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
