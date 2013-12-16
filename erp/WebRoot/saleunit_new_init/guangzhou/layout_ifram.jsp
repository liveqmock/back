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
	
	<title>楼盘建档</title>
	
	<base href="<%=basePath%>">
		
	<s:include value="../../header/header_easyui.jsp"/>
	
	<link href="./css/unit_table.css"  rel="stylesheet" type="text/css" charset="utf-8"/><!-- unit的样式 -->	

	
	<!-- ie6 水印问题 -->
	<script type="text/javascript" src="<%=basePath%>js/DD_belatedPNG_0.0.8a-min.js"></script>   
	<script type="text/javascript"> 
		DD_belatedPNG.fix('.logo'); 	
	</script>
	
	<style type="text/css">
		*{margin:0;padding:0;}		
		
		.tb1 td{padding-left: 2px;width:50px; text-align:center; cursor: pointer}
		.tb1 tr{background-color:#FFFFFF}
		.seltd{background-color:#FBEC88}
		.add_some{}
		.text_title_cl{
		display:inline-block;
	width:16px;
	height:18px;
	vertical-align:middle;}
		.re_some{display:inline-block;
		}
	
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
			<div title="楼盘初始" selected="true" style="padding:10px;"> 
			<a onclick="$('#ttxx').hide();addSome('add_project',0)" class="easyui-linkbutton" iconCls="icon-add"   plain="true">新建楼盘</a>
			<a onclick="copyBuild()" class="easyui-linkbutton"   plain="true">复制楼栋</a>
			<hr />
			<s:include value="layout_left.jsp"/>
		</div>
		</div>
		
	</div>
		
	<div region="center"  style="padding:0px;background:#efefef;" id="center_main">
		<iframe src="http://www.baidu.com" scrolling="auto" style="width: 100%;height: 100%" id="center_ifram">
		
		</iframe>
	</div>
	
	<div region="south" border="false"  style="background:#A9FACD;padding:0px;">
		<div style="width: 100%;height: 15px;background: #eeeeee" ></div>
	</div>	
	

<%--dialog --%>
	<div id="new_dialog" class="easyui-dialog" closed="true" modal="true" title="标题" style="display:block;width:500px;height:250px; overflow-x:hidden"> 			
    	<iframe scrolling="auto" id='new_dialog_ifram' frameborder="0"  src="./saleunit_new/guangzhou/loading.jsp" style="width:100%;height:100%;"></iframe> 
	</div> 
	
	<div id="init_unit_dialog" class="easyui-dialog" closed="true" modal="true" title="标题" style="display:block;width:800px;height:400px; overflow-x:hidden"> 			
    	<iframe scrolling="auto" id='init_unit_ifram' frameborder="0"  src="./saleunit_new/guangzhou/loading.jsp" style="width:100%;height:100%;"></iframe> 
	</div> 
	<div id="init_unit_one_dialog" class="easyui-dialog" closed="true" modal="true" title="标题" style="display:block;width:500px;height:250px; overflow-x:hidden"> 			
    	<iframe scrolling="auto" id='init_unit_one_ifram' frameborder="0"  src="./saleunit_new/guangzhou/loading.jsp" style="width:100%;height:100%;"></iframe> 
	</div> 
	
	<div id="myIframeDialog" class="easyui-dialog" closed="true" modal="true" title="标题" style="display:block;width:800px;height:500px; overflow-x:hidden"> 			
    	<iframe scrolling="auto" id='openIframe' frameborder="0"  src="./saleunit_new/guangzhou/loading.jsp" style="width:100%;height:100%;"></iframe> 
	</div> 

		
</body>


	
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/customer_guangzhou_user.js"></script>	 
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/unit_table.js"></script>	<!-- unit table -->
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/unit_infomation.js"></script>	
	<script type="text/javascript" language="javascript" src="<%=basePath%>saleunit_new_init/guangzhou/js/dialog_for_tree.js?v=1"></script>	
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/saleunit_new_unit_info.js"></script>
	
	<script type="text/javascript" language="javascript" src="./js/saleunit_new_common.js"></script>
	<script type="text/javascript" language="javascript" src="./js/easyui.utils.js"></script>
	
	<script type="text/javascript" language="javascript">
		var build_id = '0';
		var select_tabs = '单元信息';
		function doCustomerBeforTab(){
			var utabs = $("#_customer_question_befor");
			utabs.load("./saleunit_new_init/appoint/guangzhou/customerBeforeTab.action");
		}
$().ready(function(){
	$('#sale_tabs').tabs({ //绑定点击TABLS事件
		onSelect:function(title){ 
			if(title == '售前客户问卷'){
				doCustomerBeforTab();
			}
			select_tabs = title;
		} 
	});
			
			$("#back").click(function(){
				location.href = "./customer_guangzhou/index/login.action";
				return false;
			});
			
			$("#left_tree").tree({
				animate:false,
				url:'./saleunit_new_init/appoint/guangzhou/layoutLeft.action',
				onLoadSuccess:function(node, data){
					$(".add_some").click(function(event){
						event.stopPropagation();
						addSome($(this).attr('type'),$(this).attr('sid'));
					});
					$(".re_some").click(function(event){
						event.stopPropagation();
						var par = $(this).parent();
						reSome($(this).attr('type'),$(this).attr('sid'),par);
					});
				},		
				onClick:function(node){
					var attr = node.attributes;
					if(attr != undefined && attr.type == "endNode"){	
						$("#center_ifram").attr("src", "./saleunit_new_init/guangzhou/layout_property.jsp");		
					}else if(attr != undefined && attr.type == "pro"){																			
						$("#center_ifram").attr("src", "./saleunit_new_init/guangzhou/layout_build.jsp");
						$(this).tree('toggle', node.target);
					}
					else {	
						$(this).tree('toggle', node.target);
					}
				}
			});			
		});
		
		function getUnitMap(){
			if(build_id == '0'){
				return;
			}
			$.ajax({
				type:"get",
				url: "./saleunit_new_init/appoint/guangzhou/unitMap.action",	
				
				data: "buildId=" + build_id + "&ts=" + new Date(),
				dataType: "html",
				beforeSend: function(){
					$("#unit_map").html("加载中...");
				},
				success: function(data){								
					$("#unit_map").html(data);	
				}		
			});	
		}
		
		$(function(){
			var p = $('body').layout('panel','west').panel({
				onCollapse:function(){
					//alert('collapse'); 收缩
					//可以设置收缩session
				},
				onExpand:function(){
					//alert("expand"); 打开
				}
			});
		});


		function bindbutclass(str){
			$(str).hover(
					  function () {
						    $(this).addClass("btn1_mouseover");
						  },
						  function () {
						    $(this).removeClass("btn1_mouseover btn1_d");
						  }
						); 
			$(str).mousedown(function(){
				 $(this).removeClass("btn1_mouseover").addClass("btn1_d");
			});
		}
		
		
	</script>	
</html>

