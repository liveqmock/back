<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="com.ihk.utils.CacheUtils"%>
<%@ taglib prefix="p" uri="/WEB-INF/property.tld"%>
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
		<script type="text/javascript" language="javascript" src="./js/customer_guangzhou_project.js"></script>
		<script type="text/javascript" language="javascript" src="./js/customer_guangzhou_user.js"></script>	 
		<script type="text/javascript" language="javascript" src="./js/sale_unit.js"></script>		 
		<title>修改分区楼栋</title>
		<style >
		
			.tb1 td{padding: 0px 10px }
			.tb1 tr{background:#FFFFFF}
			.redbor {border: 2px solid red}
		</style>
		<script type="text/javascript">
			$().ready(function(){
				
				saleUnitBind("projectName", "projectHiddenId", "areaId", "");	
				$("#update").click(function(){
					
					var	$str = $.trim($("#buildName").val());
					if($str == ""){
						alert("楼栋名称需要填写");
						$("#buildName").val("");
						$("#buildName").focus();
						return false;
						}
					$str= $.trim($("#projectName").val());
					if($str == ""){
							alert("楼盘需要填写");
							$("#projectName").val("");
							$("#projectName").focus();
							return false;
					};
					$str= $.trim($("#areaId").val());
					if($str == ""){
							alert("请选择分区");
							$("#areaId").val("");
							$("#areaId").focus();
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
<div class="title01" ><a href="./property/area/searchIndex.action?ts=<%= CacheUtils.getUrlTimeStamp()%>" target="_self">分区</a></div>
<div class="title02" ><a href="./property/build/index.action?ts=<%= CacheUtils.getUrlTimeStamp()%>" target="_self">楼栋</a></div>

<table width="100%" border="0" cellspacing="0" class="d_top">
	<tr>
	  <td bgcolor="#edf8fe">
	  
	<div class="d_out">
		<a href="./property/build/index.action" target="_self">查询楼栋</a>
	</div>		
	<div class="d_out">
		<a href="./property/build/input_index.action" target="_self">新建楼栋</a>
	</div>		
	<div class="d_over">
		<b><a href="./property/build/input_index.action" target="_self">楼栋信息</a></b>
	</div>			
	 </td>
	</tr>
</table>
<div class="right99"></div>
<div class="blueline"></div>
<%--主体table --%>
	<div style="width: 75%;height: inherit;float: left;vertical-align: top;margin-top: 5px">
		<form action="./property/build/update.action" method="post">
		<div style="width:100%;float: left;">
		<table cellpadding="0" cellspacing="1"  style="vertical-align: top;width: 100%" class="tb1 gbox">
				<tr>
					<td align="right" width="20%" nowrap="nowrap"><em style="color:red">* </em>所属楼盘</td>
					<td width="30%">
						<p:project id="projectName" name="nameForPropertyId" value="${updateBuild.descPropertyId}"
			 hiddenId="projectHiddenId" hiddenName="updateBuild.propertyId" hiddenValue="${updateBuild.propertyId}"/>
					</td>
					<td align="right" width="20%" nowrap="nowrap"><em style="color:red">* </em>所属分区</td>
					<td width="30%">
						<p:area id="areaId" name="updateBuild.areaId" value="${updateBuild.areaId}" relyValue="${updateBuild.propertyId}"/>
					</td>
				</tr>
				<tr>
					<td align="right" width="20%"><em style="color:red">* </em>楼栋名称</td>
					<td colspan="3">
						<input name="updateBuild.buildName" id="buildName" value="${updateBuild.buildName}"/>
					</td>
				</tr>
				<tr>
					<td align="right">租售类型</td>
					<td>
						<s:select list="selSaleType" name="updateBuild.saleType"></s:select>
					</td>
					<td align="right">建筑性质</td>
					<td>
						<s:select list="selBuildNature" name="updateBuild.buildNature"></s:select>
					</td>
				</tr>
				<tr>
					<td align="right">备注</td>
					<td colspan="3" style="padding: 5px">
						<textarea rows="" cols="" style="width: 90%" name="updateBuild.remark">${updateBuild.remark}</textarea>
					</td>
				</tr>
				<tr>
					<td colspan="4" align="center"> 
						<input type="hidden" name="updateBuild.id" value="${updateBuild.id}"/>
						<input type="hidden" name="updateId" value="${updateId }"/>
					<input type="submit" value="  修改  " style="width: 50px" id ="update"/>
				<a  class="ablue" style="color:#1199ff" href="./property/unit/index.action?buildId=${updateBuild.id}">初始化单元</a>
					<s:actionmessage cssStyle="color:red"/></td>
					
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
