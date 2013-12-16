<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
  <head>
	
	<title>组团管理</title>
	
	<base href="<%=basePath%>"/>
		
	<s:include value="../../customer/guangzhou/header.jsp"/>
	
	<link href="./css/unit_table.css"  rel="stylesheet" type="text/css" charset="utf-8"/><!-- unit的样式 -->	
	<link href="./css/easyui.css" rel="stylesheet" type="text/css" charset="utf-8"/>
	<link href="./css/icon.css" rel="stylesheet" type="text/css" charset="utf-8"/>
	
	<style type="text/css">
		*{margin:0;padding:0;}		
		
		.tb1 td{padding-left: 2px;width:50px; text-align:center; cursor: pointer}
		.tb1 tr{background-color:#FFFFFF}
		.seltd{background-color:#FBEC88}
		.add_some{}
	
		.spanbu{color:#aa1122;cursor: pointer;border: 1px solid;padding: 10px;}
		
		.td_is_check{background: #FBEC88;}
	</style>	
	<script type="text/javascript">
	var sleunit = '';
		$().ready(function(){
			$("#unitTable1 td").bind('click',function(){
				var clickUnitId = $(this).attr("unitId");
				if(clickUnitId == '0' || clickUnitId == undefined || clickUnitId == ""){
					return false;
				}else{
					$(this).addClass("td_is_check");
					sleunit += ','+clickUnitId;
				}
			}).bind('mouseenter ',function(){//单元背景色HOVER
				var unitId = $(this).attr("unitid");
				if(unitId != "" && unitId != "0" && unitId != undefined){			
					$(this).addClass("seltd");
				}
			}).bind('mouseleave  ',function(){//单元背景色HOVER
				var unitId = $(this).attr("unitid");
				if(unitId != "" && unitId != "0" && unitId != undefined){			
					$(this).removeClass("seltd");
				}
			});
		})

		
	</script>
  </head>

<body>
	
	
						<p style="color: blue">${selBuild.buildName}</p>
							<table  id="unitTable1" border="0" align="center" cellpadding="0" cellspacing="1" class="tb1" style="margin: 0px;width:auto;float: left;background-color: #A9D9FF">
								 <s:iterator value="#request.trList" id="c">  
								 	${c}
								 </s:iterator>
							</table>
							</body>	
