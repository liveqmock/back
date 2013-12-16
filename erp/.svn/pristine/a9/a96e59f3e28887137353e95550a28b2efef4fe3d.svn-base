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
	
	<title>查询客户</title>
	
	<base href="<%=basePath%>">
		
	<s:include value="header.jsp"></s:include>	  
		
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>
		
	<link href="./css/easyui.css" rel="stylesheet" type="text/css" charset="utf-8"/>
	<link href="./css/icon.css" rel="stylesheet" type="text/css" charset="utf-8"/>

	<script type="text/javascript" language="javascript">
		$(function(){
			var p = $('body').layout('panel','west').panel({
				onCollapse:function(){
					//alert('collapse');
					//可以设置收缩session
				}
			});
		});
		
		$().ready(function(){
			$("#cl").click(function(){
				$("#center_top").html("");
			});
			
			$("#left_tree").tree({		
			
				onClick:function(node){
					$(this).tree('toggle', node.target);
					//alert('you click '+node.text);
				},
				onDblClick:function(node){
					var attr = node.attributes;
					if(attr != undefined && attr.type == "endNode"){
						
						$.ajax({
							type:"post",
							url: "./customer_guangzhou/search/tmpTree.action",							
							data: "buildId=" + node.id,
							dataType: "html",
							beforeSend: function(){
								$("#center_top").html("加载中...");
							},
							success: function(data){
								
								$("#center_top").html(data);
							}		
						});	
	
						
					}
				}
			});
			
			
			
			$("#java1").click(function(){
				$("#danyuan").html("<center><input type='button' value='按钮'/></center>");
			});


			$("#unitTable>td").click(function(){
				$().html("");
				
			});
		});
		
		
		$().ready(function(){
			DD_belatedPNG.fix('.logo'); 
		});
	</script>	
	
	<style>
		*{margin:0;padding:0;}
		
	</style>
	
  </head>
  
<body class="easyui-layout">

	<div region="north" border="false" style="height:60px;background:#B3DFDA;padding:0px; overflow:hidden">
		<s:include value="top.jsp"/>		
	</div>
	
	<div region="west" split="true" title="左边导航条" style="width:213px;padding:10px;">		
		<s:include value="layout_left.jsp"/>
	</div>
	
	<div region="south" border="false" style="height:auto;background:#A9FACD;padding:0px;">
		<s:include value="bottom.jsp"/>	
	</div>	
	
	<div region="center" title="中间主要内容" split="true" style="padding:0px;background:#efefef;" >
		<div class="easyui-layout" fit="true" style="background:#ccc;">
		
			<!-- 中间的上半部分-->
			<div region="center" id="center_top">
				<s:include value="bottom.jsp"/>					
			</div>
			
			<!-- 中间的下半部分-->
			<div region="south" id="center_bottom" split="true" style="height:200px; width:auto">
				<s:include value="bottom.jsp"/>			
			</div>
			
		</div>
	</div>

	
</body>

</html>

