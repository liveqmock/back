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
	
	<title>销售中心</title>
	
	<base href="<%=basePath%>" />		
		
	<s:include value="../../customer/guangzhou/header.jsp"/>
	
	<link href="./css/unit_table.css"  rel="stylesheet" type="text/css" charset="utf-8"/><!-- unit的样式 -->	
	
	<link href="./css/easyui.css" rel="stylesheet" type="text/css" charset="utf-8"/>
	<link href="./css/icon.css" rel="stylesheet" type="text/css" charset="utf-8"/>

	<script type="text/javascript" language="javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/easyui-lang-zh_CN.js"></script>

	<script type="text/javascript" language="javascript" src="./js/saleunit_new_discount.js"></script>

    <script type="text/javascript" language="javascript" src="<%=basePath%>js/saleunit_new_unit_info.js?v=4"></script>
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/saleunit_sale.js?v=3"></script><!-- 管理销售弹出框 -->
	<script type="text/javascript" language="javascript" src="./js/saleunit_contract_customer.js?v=4"></script><!-- 合同客户弹出框 -->
	<script type="text/javascript" language="javascript" src="<%=basePath%>saleunit_new/guangzhou/pay_for_unit.js"></script>

	<script type="text/javascript" language="javascript" src="<%=basePath%>js/customer_guangzhou_user.js"></script>

	<script type="text/javascript" language="javascript" src="./js/saleunit_new_common.js?v=1.0"></script>
	<script type="text/javascript" language="javascript" src="./js/saleunit_new_unit_info_load.js?v=1.2"></script>
	<script type="text/javascript" language="javascript" src="./js/easyui.utils.js?v=2"></script>
	
	<script type="text/javascript" language="javascript" src="./js/easyui.left.tree.js?v=1.0"></script>

	<script type="text/javascript" language="javascript" src="./js/project.list.utils.js?v=1.3"></script>

	<script type="text/javascript" language="javascript" src="./js/change_project_at_title.js"></script><!-- 项目修改 -->	
	<script type="text/javascript" language="javascript" src="./js/saleunit_financial_pay_plan.js?v=1.2"></script> <!--应收款 分割了文件  -->
	<script type="text/javascript" language="javascript" src="./js/saleunit_unit_paybill.js?v=1.4"></script> <!-- 收款内容 -->
	
	<script type="text/javascript" language="javascript" src="./js/customer_guangzhou_project.js"></script>
	
	<%--DEMO 页面用到的脚本，提前统一放置 --%>
	<script type="text/javascript" language="javascript" src="./js/saleunit_new_unit_operation.js?v=2"></script>

	<script type="text/javascript" language="javascript">

		$(document).ready(function(){		
			//延期签约的弹出框
			messageShow("延期签约提醒");

			bindLeftCombobox("__myProjectId__", "__appoint__", bindLeftTree, ["__appoint__"]);
			
		});
		
		function bindLeftTree(selectType){
			
			$("#left_tree").tree({
				animate:false,
				url:'./saleunit_new/appoint/guangzhou/layoutLeft.action?selectType=' + selectType,
				onClick:function(node){
					treeNodeClick("left_tree", node, "false", "");
				},
				onLoadSuccess:function(node, data){
					//用了异步加载tree节点的方法,每次加载成功都会调用该方法,应该只有当data[0].id为p开头才执行
					
					if(data[0] == undefined){
						return ;
					}
					
					var dataId = data[0].id;
					var type = dataId.substr(0, 1);
					if(type == "p"){

						var propertyId = dataId.substr(1, dataId.length);
						//一进来应该默认选中一个单元,(最后操作的那个单元)
						$.ajax({
							type:"get",
							url: "./saleunit_financial_manager/guangzhou/getDefaultFromProperty.action",
							data: "propertyId=" + propertyId + "&ts=" + new Date(),
							dataType: "html",
							beforeSend: function(){
								//$("#center_main").html("加载中...");
								moduleMask("center_main");								
							},
							success: function(data){
							
								//移除遮罩层
								//moduleMaskRemove();

								//1. 设置单元列表
								$("#center_main").html(data);

								//2. 设置选中单元
								getDefaultBuildFromProperty(propertyId);
							}
						});
					}

				}
			});
		}

		//获取初次加载要选中的单元id
		function getDefaultBuildFromProperty(propertyId){

			$.ajax({
				type:"get",
				url: "./saleunit_new/appoint/guangzhou/getDefaultBuildFromProperty.action",
				data: "propertyId=" + propertyId,
				dataType: "html",
				success: function(data){
				
					if(data == ""){
						data = "&nbsp;";
					}

					$("#_center_layout .panel-title").html(data);
				}
			});
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
		.tb1 td{padding-left: 2px;width:50px; text-align:center; cursor: pointer}
		.tb1 tr{background-color:#FFFFFF}
		.seltd{background-color:#EEAD0E}
		.changetd{background-color:#EEAD0E}
		.exChangetd{background-color:#EEAD0E}
	</style>	
	
  </head>
  
<body class="easyui-layout">
	
	<div region="west" split="true" 
		 title='<input type="text" name="selectProId" id="__myProjectId__" style="width:160px" rhref="./saleunit_new/appoint/guangzhou/layout.action"/>'
		 style="width:200px;padding:1px;">	
		<ul id="left_tree" animate="false"></ul>
	</div>
	
<%--

	<div region="west" split="true" 
		 title='<input type="text" name="selectProId" id="__myProjectId__" style="width:160px" rhref="./saleunit_new/appoint/guangzhou/layout.action"/>'
		 style="width:200px;padding:1px;">	
		<ul id="left_tree" animate="false"></ul>
	</div>
	
	<div region="west" split="true"
	 title='<s:select list="urList" listKey="projectId" listValue="descProjectId" name="selectProId" id="__myProjectId2__"
	 cssStyle="vertical-align: middle;" onChange="change_project(this)" rhref="./saleunit_new/appoint/guangzhou/layout.action"></s:select>' 
	 style="width:213px;padding:1px;">	
		<ul id="left_tree" animate="false"></ul>
	</div>

	
--%>	

		
	<div region="center" title="(设置自动刷新时间:
		<select id='autoRefrehTimeId'>
			<option value='0.5'>30秒</option>
			<option value='1'>1分钟</option>
			<option value='2'>2分钟</option>
			<option value='5'>5分钟</option>
			<option value='10'>10分钟</option>
		</select>	 			
		<a href='javascript:void(0)' style='color:#1199FF; text-decoration:underline;' onclick='autoRefresh()'>确定</a>
		<a href='javascript:void(0)' style='color:#1199FF; text-decoration:underline;' onclick='cancelAutoRefresh()'>取消</a>)
		<a href='javascript:void(0)' style='color:#1199FF; text-decoration:underline;' onclick='refreshFn()'>刷新</a>
		<span id='setShowId'></span>" 							
			style="padding:0px;background:#efefef;" id="_center">
								
		<div class="easyui-layout" fit="true" style="background:#cccccc;" id="_center_layout">
			
			<!-- 中间的主要部分 -->
			<div region="center" id="center_main_fu" style="top:26px">
				<div class="easyui-tabs" fit="true" border="false" id="unit_tabl">
					<div title="图形" style="" id="" uid="" > 
						<div style="height: 24px;width: 100%;p"> 
						<s:include value="unit_sale_state.jsp"/>
						<a href='javascript:void(0)' style='color:#1199FF; text-decoration:underline; padding:0 0 0 10px; display:none' id="_dialog_for_">销售情况</a>
						</div>
						<div id="center_main" > 
						</div>
					</div>
					<div title="列表"  style="padding:0px;" id="liebiao" href="./saleunit_new/appoint/guangzhou/unitList.action">	
					</div>
				</div>
			</div>
			
			<!-- 中间的底下部分 -->
			<div region="south" id="center_bottom" split="true" style="height:280px; width:500px" title="&nbsp;">
				<s:include value="layout_center_bottom.jsp"/>
			</div>
			
		</div>
		
	</div>
	
	<%-- 统一dialog,myDialog表示没有iframe,myIframeDialog表示使用iframe,且iframe的名称统一为openIframe,(如果弹出的iframe中又包含弹出框,就不用变) --%>
	<div id="myDialog" class="easyui-dialog" closed="true" modal="true" title="标题" style="display:block;width:800px;height:500px; overflow:hidden"> 			
	</div> 	
	
	<div id="myIframeDialog" class="easyui-dialog" closed="true" modal="true" title="标题" style="display:block;width:800px;height:500px; overflow:hidden"> 			
    	<iframe scrolling="auto" id='openIframe' frameborder="0"  src="./saleunit_new/guangzhou/loading.jsp" style="width:100%;height:100%;"></iframe> 
	</div> 	
	
</body>
		

</html>
