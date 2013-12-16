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
		
		<s:include value="/customer/guangzhou/header.jsp"></s:include>	
		<s:include value="/customer/guangzhou/header_left_js.jsp"></s:include>	
		<title>查询开发商</title>
		<style >
			.tb1 input{width:100%}
			.thisdiv td{padding-left: 12px}
			.ablue {color:#1199ff; text-decoration:underline;}
		</style>
	</head>
	<body>
	
<%--固定的上部 --%>

<s:include value="/customer/guangzhou/body_up.jsp">
</s:include>	

<%--主体导航页头 --%>
<div class="title02" ><a href="./property/developer/index.action?ts=<%= CacheUtils.getUrlTimeStamp()%>">开发商</a></div>
<div class="title01" ><a href="./property/project/index.action?ts=<%= CacheUtils.getUrlTimeStamp()%>">楼盘项目</a></div>
<div class="title01" ><a href="./property/area/searchIndex.action?ts=<%= CacheUtils.getUrlTimeStamp()%>" target="_self">分区</a></div>
<div class="title01" ><a href="./property/build/index.action?ts=<%= CacheUtils.getUrlTimeStamp()%>" target="_self">楼栋</a></div>


<table width="100%" border="0" cellspacing="0" class="d_top">
	<tr>
	  <td bgcolor="#edf8fe">
	  
	<div class="d_over">
		<b><a href="./property/developer/index.action">查询开发商</a></b>
	</div>		
	<div class="d_out">
		<a href="./property/developer/input_index.action">新建开发商</a>
	</div>		
	

	<div class="d_out">
		<font color="#FF0000"><span id="suggestion"><s:property value="#request.session.suggestion"/></span></font>					
	</div>
		
	 </td>
	</tr>
</table>
<div class="right99"></div>
<div class="blueline"></div>

<%--主体table --%>
<div title="查询" style="height: 25px;width: 100%">
	<form action="./property/developer/search.action" method="post">
	 &nbsp;名称<input type="text" name="deveCond.searchName" value="${deveCond.searchName}"/>&nbsp;<input type="submit" value="  查询  "/></form>
</div>

	<div  style="width: 100%;float: left;vertical-align: top;" class = "thisdiv">
		 <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="margin-top: 5px;">
				<tr bgcolor="#FFFFFF"; class="gboxbg">
					<td><span>开发商名称</span></td>
					<td><span>备注</span></td>
					<td><span>创建时间</span></td>
					<td></td>
				</tr>
				<s:iterator value="deveList" id="li">
				<tr bgcolor="#FFFFFF";">
					<td>
					<a   href="./property/developer/update_index.action?updateId=${li.id}" class="ablue" style="color:#1199ff">
					${li.developerName}</a></td>
					<td>${li.remark}</td>
					<td>
						<s:date name="#li.createdTime" format="yyyy-MM-dd"/>
					</td>
					<td><span>
						<a href="./property/project/input_index.action?inputProPro.developerId=${li.id}" style="color:#1199ff;text-decoration: underline">新建楼盘</a>
					</span></td>
					</tr>
					
				</s:iterator>	
		</table>
		<div class="manu">
					<s:property value="showPage" escape="false"/>
				</div>
	</div>
	 
<%--固定的底部 --%>
<s:include value="/customer/guangzhou/body_bottom.jsp">
</s:include>
	</body>
</html>
