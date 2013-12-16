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
	
	<title>部分回款(选择单元)</title>
	
	<base href="<%=basePath%>" />		
		
	<s:include value="../../customer/guangzhou/header.jsp"/>
	
	<link href="./css/unit_table.css"  rel="stylesheet" type="text/css" charset="utf-8"/><!-- unit的样式 -->	
	
	<link href="./css/easyui.css" rel="stylesheet" type="text/css" charset="utf-8"/>
	<link href="./css/icon.css" rel="stylesheet" type="text/css" charset="utf-8"/>
	
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" language="javascript" src="./js/easyui.utils.js"></script>

	<script type="text/javascript" language="javascript">

		$(document).ready(function(){
			
			bindLeftTree();			
		});
		
		function bindLeftTree(){
			
			$("#left_tree").tree({
				animate:false,
				url:'./saleunit/operation/layoutLeftForOper.action?selectType=__financial__&propertyProjectId=${propertyProjectId}',
				onClick:function(node){
					
					var attr = node.attributes;
					
					if(attr != undefined && attr.type == "endNode"){
						
						$.ajax({
							type:"get",
							url: "./saleunit/operation/getUnit.action",							
							data: "buildId=" + attr.bid + "&type=checkFeeForPart&ts=" + new Date(),
							dataType: "html",
							beforeSend: function(){

								moduleMask("center_main_top");
							},
							success: function(data){									
											
								$("#center_main").html($.trim(data));
								moduleMaskRemove();
								
							}			
						});	
					}
					
					$("#left_tree").tree('toggle', node.target);
					
				},
				onLoadSuccess:function(node, data){
					
				}
			});
		}

	</script>
	
	<style type="text/css">
		*{margin:0;padding:0;}		
		.tb1 td{padding-left: 2px;width:50px; text-align:center; cursor: pointer}
		.tb1 tr{background-color:#FFFFFF}
		.seltd{background-color:#EEAD0E}
		.changetd{background-color:#EEAD0E}
		.exChangetd{background-color:#EEAD0E}
	</style>	
	
  </head>
  
<body class="easyui-layout">

	<div region="west" split="true" style="width:200px;padding:1px;">	
		<ul id="left_tree" animate="false"></ul>
	</div>
		
	<!-- 中间的主要部分 -->
	<div region="center" id="center_main_top" style="top:26px">

		<s:include value="../guangzhou/unit_sale_state.jsp"/>
		<div id="center_main"></div> 
		
	</div>	
	
	<div region="south" split="true" style="height:150px" id="receipt_div">
	</div>	
	
</body>		

</html>
