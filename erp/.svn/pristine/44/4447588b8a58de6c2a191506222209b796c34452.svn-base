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

		<script type="text/javascript" language="javascript" src="<%=basePath%>js/sale_unit.js"></script>	 
		<script type="text/javascript" language="javascript" src="<%=basePath%>js/guangzhou_input_valdate.js"></script>
		<title>新建楼栋</title>
		<style>
			.poppng{background:url(<%=basePath%>/images/pop.png) no-repeat}
			.err_input_class{border-color: red;border-width: 2px}
			.tb1 td{padding: 0px 10px }
			.tb1 tr{background:#FFFFFF}
			.redbor {border: 2px solid red}
			.body_div{width: 75%;height: inherit;float: left;vertical-align: top;}
		</style>
		<script type="text/javascript">
			$().ready(function(){
				saleUnitBind("projectName", "projectHiddenId", "areaId", "");	
				//propertyProjectListForHiddenId("projectName", "projectHiddenId");
				
				$("#input").click(function(){//submit 验证
						var	$str = $.trim($("#buildName").val());
						if($str == "")
						{
							alert("楼栋名称需要填写");
							$("#buildName").val("");
							$("#buildName").focus();
							return false;
						}
						
						$str= $.trim($("#projectName").val());
						if($str == "")
						{
							alert("楼盘项目需要填写");
							$("#projectName").val("");
							$("#projectName").focus();
							return false;
						};

						$str= $.trim($("#areaId").val());
						if($str == "")
						{
							alert("请选择分区");
							$("#areaId").val("");
							$("#areaId").focus();
							return false;
						};
				});//submit 验证 end

				$("#buildName").inputVal({massage:"需要填写"});//build_name  pop
				$("#projectName").inputVal({massage:"需要填写"});//property_name pop
			
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
	<div class="d_over">
		<b><a href="./property/build/input_index.action" target="_self">新建楼栋</a></b>
	</div>				
	 </td>
	</tr>
</table>
<div class="right99"></div>
<div class="blueline"></div>
<%--主体table --%>
	<div class = "body_div" >
		<form action="./property/build/input.action" method="post">
		<div style="float: left;margin-top: 5px;width: 100%">
			<table cellpadding="0" cellspacing="1"  style="vertical-align: top;width: 100%" class="tb1 gbox">
				<tr>
					<td align="right" width="20%" nowrap="nowrap"><em style="color:red">* </em>所属楼盘</td>
					<td width="30%">
						<p:project id="projectName" name="" value="${inputBuild.descPropertyId}"
							 hiddenId="projectHiddenId" hiddenName="inputBuild.propertyId" hiddenValue="${inputBuild.propertyId}"/>
					</td>
					<td align="right" width="20%" nowrap="nowrap"><em style="color:red">* </em>所属分区</td>
					<td width="30%">
						<p:area id="areaId" name="inputBuild.areaId" value="${inputBuild.areaId}" relyValue="${inputBuild.propertyId}"/>
					</td>
				</tr>
				<tr>
					<td align="right" width="20%"><em style="color:red">* </em>楼栋名称</td>
					<td colspan="3">
						<input name="inputBuild.buildName" id="buildName"/>
					</td>
				</tr>
				<tr>
					<td align="right">销售方式</td>
					<td>
						<s:select list="selSaleType" name="inputBuild.saleType"></s:select>
					</td>
					<td align="right">房屋用途</td>
					<td>
						<s:select list="selBuildNature" name="inputBuild.buildNature"></s:select>
					</td>
				</tr>
				<tr>
					<td align="right">备注</td>
					<td colspan="3" style="padding: 5px">
						<textarea rows="" cols="" style="width: 90%" name="inputBuild.remark"></textarea>
					</td>
				</tr>
				<tr>
					<td colspan="4" align="center"> <input type="submit" value="  新建  " style="width: 50px" id="input"/>
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

<%--POP --%>
<div id="org_box" class="poppng" style="height:20px; width:250px;
	  position:absolute; display: none;font-size: 12px;padding: 3px; overflow: hidden;"></div>
	</body>
</html>
