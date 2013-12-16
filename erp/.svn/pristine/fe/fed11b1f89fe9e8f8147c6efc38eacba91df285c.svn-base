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
	
	<title>新框架</title>
	
	<base href="<%=basePath%>">
		
	<s:include value="../../customer/guangzhou/header.jsp"/>
		
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/customer_guangzhou_user.js"></script>	 
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/unit_table.js"></script>	<!-- unit table -->
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/unit_infomation.js"></script>	
	<script type="text/javascript" language="javascript" src="<%=basePath%>saleunit_new_init/guangzhou/js/dialog_for_tree.js"></script>	
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/saleunit_new_unit_info.js"></script>
	<link href="./css/unit_table.css"  rel="stylesheet" type="text/css" charset="utf-8"/><!-- unit的样式 -->	
	<link href="./css/easyui.css" rel="stylesheet" type="text/css" charset="utf-8"/>
	<link href="./css/icon.css" rel="stylesheet" type="text/css" charset="utf-8"/>

	<script type="text/javascript" language="javascript">
	var treeId = '0';
	var treeType = 'build';
	var qid = '0';
		$(function(){
			var p = $('body').layout('panel','west').panel({
				onCollapse:function(){
				},
				onExpand:function(){
				}
			});
		});
		$().ready(function(){
			
			
			
			$("#back").click(function(){
				location.href = "./customer_guangzhou/index/login.action";
				return false;
			});
			
			$("#left_tree").tree({
				url:'./saleunit_new_questions/appoint/guangzhou/layoutLeft.action',	
				onBeforeLoad:function(node, param){
				},
			
				onClick:function(node){
					var attr = node.attributes;
					if(attr != undefined && attr.type == "endNode"){
						$.ajax({
							type:"get",
							url: "./saleunit_new_questions/appoint/guangzhou/selectQuestion.action",							
							data: "treeId=" + attr.bid + "&ts=" + new Date(),
							dataType: "html",
							beforeSend: function(){
								$("#unit_map").html("加载中...");
							},
							success: function(data){								
								$("#unit_map").html(data);	
								treeId = attr.bid;
							}		
						});	
						
					}else{
						$(this).tree('toggle', node.target);
						//alert('you click '+node.text);
					}
				},
			});			
		});
		
		function flushQuestionTable(){
			$.ajax({
				type:"get",
				url: "./saleunit_new_questions/appoint/guangzhou/selectQuestion.action",							
				data: "treeId=" + treeId + "&ts=" + new Date(),
				dataType: "html",
				beforeSend: function(){
					$("#unit_map").html("加载中...");
				},
				success: function(data){								
					$("#unit_map").html(data);	
				}		
			});	
		};
		
		function flushQuestionTocTable(tocid){
			$.ajax({
				type:"get",
				url: "./saleunit_new_questions/appoint/guangzhou/selectQuestion.action",							
				data: "qid=" + tocid + "&ts=" + new Date(),
				dataType: "html",
				beforeSend: function(){
					$("#center_bottom").html("加载中...");
				},
				success: function(data){								
					$("#center_bottom").html(data);	
				}		
			});	
		};
	</script>	
	<!-- ie6 水印问题 -->
	<script type="text/javascript" src="<%=basePath%>js/DD_belatedPNG_0.0.8a-min.js"></script>   
	<script type="text/javascript"> 
		DD_belatedPNG.fix('.logo'); 	
	</script>
	
	<style type="text/css">
		*{margin:0;padding:0;}		
		
		.tb1 td{padding-left: 5px;width:75px; text-align:center; cursor: pointer}
		.tb1 tr{background-color:#FFFFFF}
		.seltd{background-color:#EEAD0E}
		.add_some{}
		.re_some{padding: 0 5px}
		.spanbu{color:#aa1122;cursor: pointer;border: 1px solid;padding: 10px;}
	</style>	
	
  </head>
  
<body class="easyui-layout">

	<div region="north" border="false" style="height:50px;background:#B3DFDA;padding:0px; overflow:hidden">
		<s:include value="../../customer/guangzhou/top.jsp"/>
	</div>
	
	<div region="west" split="true" title="<a href='./customer_guangzhou/index/login.action' style='color:#5482DE'>返回主页</a>" style="width:213px;padding:1px;">
	
		
		
		<div class="easyui-accordion" fit="true" border="false">
		<div title="交易管理" style="padding:5px;overflow:auto;">
			<s:include value="../../saleunit_new/guangzhou/left_unit.jsp"/>
		</div>
		<div title="问卷初始" selected="true" style="padding: 10px">  
			<s:include value="../../saleunit_new/guangzhou/layout_left.jsp"/>
		</div>
		</div>
	</div>
		
	<div region="center"  style="padding:0px;background:#efefef;" id="center_main">
	<div class="easyui-layout" fit="true" style="background:#ccc;" id="_center_layout">
		
				<!-- 中间的顶上部分 -->
			<div region="north" id="center_top" style="height:30px; width:auto">
				<s:include value="top_bar.jsp"/>
			</div>
			
			<!-- 中间的主要部分 -->
			<div region="center" id="unit_map" style="top:26px">
			</div>
			
			<!-- 中间的底下部分 -->
			<div region="south" id="center_bottom" split="true" style="height:300px; width:500px" >
				<!--<s:include value="layout_center_bottom.jsp"/>-->
			</div>
			
		</div>
			<!--<s:include value="layout_center_tabls.jsp"/>-->
			
	</div>
	
	<div region="south" border="false"  style="background:#A9FACD;padding:0px;">
		<div style="width: 100%;height: 15px;background: #eeeeee" ></div>
	</div>	
	

<%--dialog --%>
	<div id="min_dialog" class="easyui-dialog" closed="true" modal="true" title="标题" style="display:block;width:500px;height:250px; overflow-x:hidden"> 			
    	<iframe scrolling="auto" id='min_dialog_ifram' frameborder="0"  src="./saleunit_new/guangzhou/loading.jsp" style="width:100%;height:100%;"></iframe> 
	</div> 
	<div id="mid_dialog" class="easyui-dialog" closed="true" modal="true" title="标题" style="display:block;width:800px;height:400px; overflow-x:hidden"> 			
    	<iframe scrolling="auto" id='mid_dialog_ifram' frameborder="0"  src="./saleunit_new/guangzhou/loading.jsp" style="width:100%;height:100%;"></iframe> 
	</div> 
	<div id="max_dialog" class="easyui-dialog" closed="true" modal="true" title="标题" style="display:block;width:500px;height:250px; overflow-x:hidden"> 			
    	<iframe scrolling="auto" id='max_dialog_ifram' frameborder="0"  src="./saleunit_new/guangzhou/loading.jsp" style="width:100%;height:100%;"></iframe> 
	</div> 
</body>



</html>

