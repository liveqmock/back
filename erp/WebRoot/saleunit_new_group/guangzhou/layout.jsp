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
	
	<title>数据分组</title>
	
	<base href="<%=basePath%>">
		
	<s:include value="../../customer/guangzhou/header.jsp"/>
		
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>
				
	<link href="./css/easyui.css" rel="stylesheet" type="text/css" charset="utf-8"/>
	<link href="./css/icon.css" rel="stylesheet" type="text/css" charset="utf-8"/>
	
	<script type="text/javascript" language="javascript">
	
		$(function(){
			var p = $('body').layout('panel','west').panel({
				onCollapse:function(){
					//alert('collapse'); 收缩
					//可以设置收缩session
				},
				onExpand:function(){
					//alert("expand"); 打开
				},
				onOpen:function(){
					//messageShow("", "");
				}
			});
			
		});
		
		
		$().ready(function(){			

			
			$("#back").click(function(){
				
				//history.go(-1);
				location.href = "./customer_guangzhou/index/login.action";
				return false;
			});
			
			$("#left_group_tree").tree({		
			
				onBeforeLoad:function(node, param){
					$(this).html("加载中...");
				},
			
				onClick:function(node){
					
					var attr = node.attributes;
					if(attr != undefined && attr.type == "endNode"){
						
						
					}else{
						$(this).tree('toggle', node.target);
						//alert('you click '+node.text);
					}
					
				},
				
				onDblClick:function(node){
					
				},
				
				onLoadSuccess:function(node, data){
				
					$(".search").attr("title", "点击设定查找条件");
				
					$(".search").click(function(){
				
						alert($(this).attr("id"));
						return false;
					});
					
				},
				
			});			
			
		});
		
		function toSearch(){
			
			var groupby = "";
			var cbs = $("._cb");
			for(var i=0; i<cbs.length; i++){
				var cb = cbs[i];
				if(cb.checked == true){
					groupby = groupby + $(cb).attr("grouptype") + "=" + $(cb).attr("groupname") + "_";
				}
			}
			
			if(groupby != ""){
				$("#groupDataIframeId").attr("src", "./saleunit_new/appoint/guangzhou/groupDataGrid.action?groupby=" + groupby);
			}
		}
		
		
	</script>	
	
	<!-- ie6 水印问题 -->
	<script type="text/javascript" src="<%=basePath%>js/DD_belatedPNG_0.0.8a-min.js"></script>   
	<script type="text/javascript"> 
		$().ready(function(){
            DD_belatedPNG.fix('.logo');
        });
	</script>
	
	<style type="text/css">
		*{margin:0;padding:0;}	
		
		.search {
			background: url("images/search.png") no-repeat scroll 0 0 transparent;
			display: inline-block;
			height: 13px;
			vertical-align: middle;
			width: 14px;
		}			
		
		.check_name{
			padding:0 15px 0 0;
		}
				
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
			<div title="自定义报表" selected="true" style="padding:10px;">  
				<ul id="left_group_tree" url="./saleunit_new/appoint/guangzhou/layoutLeftGroup.action" animate="false"></ul>
			</div>
		</div>
		
	</div>
		
	<div region="center" title="<input type='button' value='  统计  ' onclick='return toSearch();'/>" style="padding:0px;background:#efefef;" id="_center">		
		<iframe scrolling="auto" frameborder="0"  src="" style="width:100%;height:100%;" id="groupDataIframeId"></iframe>	
	</div>
	
	<div region="south" border="false"  style="background:#A9FACD;padding:0px;">
		<div style="width: 100%;height: 15px;background: #eeeeee" ></div>
	</div>	
	 	

</body>

</html>

