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
		<title>销售单元</title>
		<link href="<%=basePath %>css/ui-lightness/jquery-ui-1.8.19.custom.css"  rel="stylesheet" type="text/css" charset="utf-8"/>
		<style >
			.tab1 td{line-height:19px;}
			.tdnull {background-color: #000000;width: 17px;float: left;height: 15px;border:
				 1px;margin: 2px;border: solid 2px;border-color: gray;cursor: pointer}/*未知*/
			.td {background-color: #000000;width: 17px;float: left;height: 15px;border:
				 1px;margin: 2px;border: solid 2px;border-color: gray;cursor: pointer}/*未知*/
			.td1 {background-color: #DCDCDC;width: 17px;float: left;height: 15px;border:
				 1px;margin: 2px;border: solid 2px;border-color: gray;cursor: pointer}/*待售 */
			.td2 {background-color: #FFFFFF;width: 17px;float: left;height: 15px;border:
				 1px;margin: 2px;border: solid 2px;border-color: gray;cursor: pointer}/*待售 */
			.td3 {background-color: #7FFF00;width: 17px;float: left;height: 
				15px;border: 1px;margin: 2px;border: solid 2px;border-color: gray;cursor: pointer}/*预约*/
			.td4 {background-color: #FFFF00;width: 17px;float: left;height: 
				15px;border: 1px;margin: 2px;border: solid 2px;border-color: gray;cursor: pointer}/*预留*/
			.td5 {background-color: #F4A460;width: 17px;float: left;height: 
				15px;border: 1px;margin: 2px;border: solid 2px;border-color: gray;cursor: pointer}/*小订*/
			.td6 {background-color: #CC0000;width: 17px;float: left;height: 
				15px;border: 1px;margin: 2px;border: solid 2px;border-color: gray;cursor: pointer}/*认购*/
			.td7 {background-color: #BA55D3;width: 17px;float: left;height:
				 15px;border: 1px;margin: 2px;border: solid 2px;border-color: gray;cursor: pointer}/*签约*/
			.td8 {background-color: #808080;width: 17px;float: left;height: 
				15px;border: 1px;margin: 2px;border: solid 2px;border-color: gray;cursor: pointer}/*非售*/
			.td9 {background-color: #228B22;width: 17px;float: left;height: 
				15px;border: 1px;margin: 2px;border: solid 2px;border-color: gray;cursor: pointer}/*交楼*/
			.td10 {background-color: #808000;width: 17px;float: left;height:
				 15px;border: 1px;margin: 2px;border: solid 2px;border-color: gray;cursor: pointer}/*出证*/
			
			.clicktd {background-color: pink}
			
			.unitmapdiv{width:100%;height: inherit;float: left;vertical-align: top}
			.unittablediv{width:75%;overflow: scroll;height: 500px;border: solid 2px;border-color: gray}
		</style>
	<script type="text/javascript" src="<%=basePath %>js/move_id.js"></script>
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/unit_infomation.js"></script>	
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/jquery.form.js"></script>	
	<script type="text/javascript" language="javascript" src="./js/jquery-ui-1.8.19.custom.min.js"></script>		
	<script type="text/javascript" language="javascript" src="./js/customer_guangzhou_project.js"></script>
	<script type="text/javascript" language="javascript" src="./js/customer_guangzhou_user.js"></script>	 
	<script type="text/javascript" language="javascript" src="./js/sale_unit.js"></script>	
		<script language="javascript" type="text/javascript">
			$().ready(function(){
				saleUnitBind("projectName", "projectHiddenId", "areaId", "buildId");	
			//	moveForId('showdiv','showdiv');
			/*
				$("td[uid]").click(function(){
						$.ajax({
							type:"post",
							url: "./property/unit/unit_infomation.action",
							data: "unitId=" + $(this).attr("uid"),
							dataType: "html",
							success: function(data)
								{
									$("#showdiv").html("");
									$("#showdiv").html(data);
									$("#showdiv").css("display","block")
									
								}
							});
					});*/
				$("#projectName").change(function(){
						//根据楼盘项目ID 拿到楼栋
						var hid = $("#projectName").val();
						if(hid == "" || hid == 0){
							return false;
						}else{
						
							$.ajax({
								type:"get",
								url: "./property/build/sel_build_by_pr.action",  
								data: "prid=" + hid,
								dataType: "html",
								success: function(data){
									$("#build_id").empty();
									$("#build_id").append(data);
								}
							});
						}
					});
					
				$("#showdiv").dialog({
						autoOpen: false,
						close:function(){
								$("form").submit();
							}
					});	
				$("td[uid]").click(function(){
					$.ajax({
						type:"post",
						url: "./property/unit/unit_infomation.action",
						data: "unitId=" + $(this).attr("uid"),
						dataType: "html",
						success: function(data)
							{
								$("#showdiv").html("");
								$("#showdiv").html(data);
							}
						});
					$("#showdiv").dialog("open");
				});
			});
		</script>
	</head>
	<body>
	
<%--固定的上部 --%>

<s:include value="../../../customer/guangzhou/body_up.jsp">
</s:include>	

<%--主体导航页头 --%>
<div class="title01" ><a href="./property/unit/search_list_index.action?ts=<%= CacheUtils.getUrlTimeStamp()%>" target="_self">单元列表</a></div>
<div class="title02" ><a href="./property/unit/show_index.action?ts=<%= CacheUtils.getUrlTimeStamp()%>" target="_self">单元视图</a></div>
<table width="100%" border="0" cellspacing="0" class="d_top">
	<tr>
	  <td bgcolor="#edf8fe">
	  
	<div class="d_over">
		<b><a href="./property/unit/show_index.action?ts=<%= CacheUtils.getUrlTimeStamp()%>" target="_self">查看单元</a></b>
	</div>		
	<div class="d_out">
		<a href="./property/unit/reset_index.action?
		ts=<%=CacheUtils.getUrlTimeStamp()%>" target="_self">调整单元</a>
	</div>
	<!-- 
	<div class="d_out">
		<a href="./property/unit/bind_index.action?
		ts=<%=CacheUtils.getUrlTimeStamp()%>" target="_self">绑定单元</a>
	</div> -->
	 </td>
	</tr>
</table>
<div class="right99"></div>
<div class="blueline"></div>
<%--主体table --%>

<%--显示弹出框的DIV --%>
<div id="showdiv" style="" title="单元信息">
</div>

<div class="unitmapdiv">

	<form action="./property/unit/show_index.action" method="post" >
	<div>
	&nbsp;楼盘项目<p:project id="projectName" name="unitCond.propertyName" value="${unitCond.descPropertyId}"
		 hiddenId="projectHiddenId" hiddenName="unitCond.propertyId" hiddenValue="${unitCond.propertyId}"/>
	&nbsp;分区<p:area id="areaId" name="unitCond.areaId" value="${unitCond.areaId}" relyValue="${unitCond.propertyId}"/>		 
	&nbsp;楼栋<p:build id="buildId" name="unitCond.buildId" value="${unitCond.buildId}" relyValue="${unitCond.areaId}"/>
	<input type="submit" value="  搜索  " />
	</div></form>
	<div style="width: 100%">
		<div  id="table" class="unittablediv">
			
			<table id = "table1"  border="0" align="center" cellpadding="0" cellspacing="1" class="gbox tab1"  >
				<s:iterator value="tableList" id="tr">
					<tr  bgcolor="#FFFFFF";>
						${tr}
					</tr>
				</s:iterator>
			</table>
			<br/>
		</div>
	</div>
	<div style="width: 100%;height: auto;"> 
	<table>
				<tr>
					<td title="01" width="40px" ><div class="td1"></div> <div style="float: left">销控</div>  </td>
					<td title="01" width="40px" ><div class="td2"></div> <div style="float: left">待售</div>  </td>
					<td title="01" width="40px" ><div class="td3"></div> <div style="float: left">预约</div>  </td>
					<td title="03" width="40px" ><div class="td4"></div> <div style="float: left">预留</div>  </td>
					<td title="04" width="40px" ><div class="td5"></div> <div style="float: left">小订</div>  </td>
					<td title="01" width="40px" ><div class="td6"></div> <div style="float: left">认购</div>  </td>
					<td title="01" width="40px" ><div class="td7"></div> <div style="float: left">签约</div>  </td>
					<td title="03" width="40px" ><div class="td8"></div> <div style="float: left">非售</div>  </td>
					<td title="04" width="40px" ><div class="td9"></div> <div style="float: left">交楼</div>  </td>
					<td title="04" width="40px" ><div class="td10"></div> <div style="float: left">出证</div>  </td>
				</tr>
			</table>
</div>
</div>
<%--固定的底部 --%>
<s:include value="../../../customer/guangzhou/body_bottom.jsp">
</s:include>
	</body>
</html>
