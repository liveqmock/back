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
		<title>新建分区</title>
		<style >
			
			.tb1 td{padding: 0px 10px }
			.tb1 tr{background:#FFFFFF}
			.redbor {border: 2px solid red}
		</style>
		<script type="text/javascript">
			$().ready(function(){
				propertyProjectListForHiddenId("inputAreaPropertyName", "hiddenId");
				$("#input").click(function(){
				
						var	$str = $.trim($("#inputAreaPropertyName").val());
						if($str == ""){
							alert("需要选择楼盘");
							$("#inputAreaPropertyName").val("");
							$("#inputAreaPropertyName").focus();
							return false;
							}
						$str= $.trim($("#inputAreaName").val());
						if($str == ""){
								alert("需要填写名称");
								$("#inputAreaName").val("");
								$("#inputAreaName").focus();
								return false;
							};
					});
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
	<div class="d_out">
		<a href="./property/area/searchIndex.action" target="_self">查询分区</a>
	</div>		
	<div class="d_out">
	<a href="./property/area/index.action" target="_self">新建分区</a>
	</div>	
	<div class="d_over">
	<b>分区信息</b>
	</div>				
	 </td>
	</tr>
</table>
<div class="right99"></div>
<div class="blueline"></div>
<%--主体table --%>
	<div style="width:100%;float: left;margin-top: 5px">
		<form action="./property/area/updateForm.action" method="post">
		<div style="width: 100%;float: left;">
			<table cellpadding="0" cellspacing="1"  style="vertical-align: top;width: 75%" class="tb1 gbox">
				<tr>
					<td align="right" width="150px"><em style="color:red">* </em>所属楼盘</td>
					<td>
						<input id="inputAreaPropertyName" type="text" value="${updateArea.descPropertyId}"/>
						<input id="hiddenId" name="updateArea.propertyId" type="hidden" value="${updateArea.propertyId}"/>
					</td>
				</tr>
				<tr>
					<td align="right"><em style="color:red">* </em>分区名称</td>
					<td>
						<input id="inputAreaName" type="text" value="${updateArea.areaName}" name="updateArea.areaName"/>
					</td>
				</tr>
				<tr>
					<td align="right">备注</td>
					<td>
						 <textarea name="updateArea.remark" style="width: 80%;font-size: 12px">${updateArea.remark}</textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="hidden" name="updateArea.id" value="${updateArea.id}"/> 
						<input type="submit" value="  修改  " style="width: 50px" id="input"/>
						&nbsp;<a class="ablue" style="color:#1199FF" href="./property/build/input_index.action?inputBuild.propertyId=${updateArea.propertyId}&inputBuild.areaId=${updateArea.id}">新建楼栋</a>
						<s:actionmessage cssStyle="color:red"/>
					</td>	
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
