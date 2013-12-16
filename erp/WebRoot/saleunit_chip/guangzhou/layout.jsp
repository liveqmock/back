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
	
	<title>认筹管理</title>
	
	<base href="<%=basePath%>"/>		
		
	<s:include value="../../customer/guangzhou/header.jsp"/>
	<script type="text/javascript" language="javascript" src="./js/change_project_at_title.js"></script>
	
	<link href="./css/easyui.css" rel="stylesheet" type="text/css" charset="utf-8"/>
	<link href="./css/icon.css" rel="stylesheet" type="text/css" charset="utf-8"/>

	<link href="./css/unit_table.css"  rel="stylesheet" type="text/css" charset="utf-8"/><!-- unit的样式 -->	
	
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>
	
	<script type="text/javascript" language="javascript" src="./js/easyui.left.tree.js"></script>

    <script type="text/javascript" language="javascript" src="./js/saleunit_new_common.js"></script>
	<script type="text/javascript" language="javascript" src="./js/easyui.utils.js"></script>
	<script type="text/javascript" language="javascript" src="./js/saleunit_chip_manager.js?v=1.3"></script>

	<script type="text/javascript" language="javascript">
	
		var isFirstLoadReport = true;

		var propertyId = null; //默认加载的 propertyId
		${jsString}
		$(document).ready(function(){
			
			bindChipTabs();
			
			bindLeftCombobox("__myProjectId__", "__chip__", bindLeftTree, ["__chip__"]);

		});

		//获取当前选中的是否可以新建认筹,为楼栋或组团就可以了
		function getChange(){
			return $("#showChangeId").html();
		}

		//认筹tabs默认加载的内容
		function defaultLoad(propertyId){
			$.ajax({
				type:"get",
				url: "./saleunit_financial_manager/guangzhou/getDefaultFromProperty.action",
				data: "propertyId=" + propertyId + "&type=Chip&ts=" + new Date(),
				dataType: "html",
				beforeSend: function(){
					//$("#center_main").html("加载中...");
					moduleMask("center_main");
				},
				success: function(data){

					//1. 设置单元列表
					$("#center_main").html(data);

				}
			});
		}
		
		function bindChipTabs(){
		
			$("#chip_tabs").tabs({

				onSelect:function(title){

					if(title == "筹单管理"){

						try{

							window.document.getElementById("_searchChipFrame").contentWindow.submitSearch();
							//$("#_searchChipFrame").contentWindow.submitSearch();

						}catch(e){

							var iframe = $("#_chip_search_tab").find('iframe')[0];
							iframe.src = "./saleunit_chip_manager/guangzhou/searchChip.action";
						}

					}else if(title == "认筹情况"){

						var node = $("#left_tree").tree('getSelected');
						if(node != null){

							chipTreeNodeClick("left_tree", node, "false", "center_main");
						}else{

							defaultLoad(propertyId);

						}
					}else if(title == "认筹分析"){
						if(isFirstLoadReport){
						
							var iframe = $("#_chip_report_tab").find('iframe')[0];
							//iframe.src = "./saleunit_new_report/report/guangzhou/rcfxReport.action?propertyUnitCond.projectId="+$("#companyProjectList").val();
							iframe.src = "./saleunit_new_report/report/guangzhou/rcfxReportFirst.action?propertyUnitCond.projectId="+$("#__myProjectId__").combobox("getValue");
							
							isFirstLoadReport = false;
						}
					}

				}
			});
		}
		
		function bindLeftTree(selectType){
		
			$("#left_tree").tree({
				animate:false,
				url:'./saleunit_new/appoint/guangzhou/layoutLeft.action?selectType=' + selectType,
				onClick:function(node){
					//treeNodeClick("left_tree", node, "false", "");
					chipTreeNodeClick("left_tree", node, "false", "center_main");
				},
				onLoadSuccess:function(node, data){
					//用了异步加载tree节点的方法,每次加载成功都会调用该方法,应该只有当data[0].id为p开头才执行
					
					if(data[0] == undefined){
						return ;
					}
					
					var dataId = data[0].id;
					var type = dataId.substr(0, 1);

					if(type == "p"){

						propertyId = dataId.substr(1, dataId.length);

						//一进来应该默认选中一个单元,(最后操作的那个单元)
						//defaultLoad(propertyId);

						getLeftChange(node, propertyId);
						//如果有认筹的楼栋 自动选择
					}

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

		.drag-item{
			list-style-type:none;
			display:block;
			padding:5px;
			border:1px solid #ccc;
			margin:2px;
			width:300px;
			background:#fafafa;
		}
		.indicator{
			position:absolute;
			font-size:9px;
			width:10px;
			height:10px;
			display:none;
			color:red;
		}

	</style>

  </head>

<body class="easyui-layout">

	<div region="west" split="true" 
		 title='<input type="text" name="selectProId" id="__myProjectId__" style="width:160px" rhref="./saleunit_chip_manager/guangzhou/layout.action"/>'
		 style="width:200px;padding:1px;">	
		<ul id="left_tree" animate="false"></ul>
	</div>
	
	<div region="center" title="<div id='showChangeId'>&nbsp;</div>" style="padding:0px;background:#efefef;" id="_main_center">

		<div class="easyui-tabs" fit="true" border="false" id="chip_tabs" region="center">
		
			<div title="筹单管理" style="padding:0px;" id="_chip_search_tab" iconCls="icon-reload">
				<iframe id="_searchChipFrame" name="_searchChipFrameName" frameborder="0" scrolling="auto"
					src="" style="width:100%;height:100%"></iframe>
			</div>		

			<div title="认筹情况" id="_chip_tab">

				<div class="easyui-layout" fit="true" style="background:#cccccc;" id="_center_layout">

					<!-- 中间的顶上部分 -->
					<div region="north" id="center_top" style="height:30px; width:auto">
						<s:include value="unit_chip_state.jsp"/>
						<input type="hidden" id="_get_change_unit_action_id" value="" />
					</div>

					<!-- 中间的主要部分 -->
					<div region="center" id="center_main" style="top:26px"></div>

					<!-- 中间的底下部分 -->
					
					<div region="south" id="center_bottom" split="true" style="height:300px; width:400px" title="单元认筹情况">
						<s:include value="chip_unit_list.jsp"/>
					</div>
					

				</div>

			</div>
			
			<div title="认筹分析" style="padding:0px;" id="_chip_report_tab">
				<iframe id="_chipReport" name="_chipReportFrameName" frameborder="0" scrolling="auto"
					src="" style="width:100%;height:100%"></iframe>
			</div>		
			

		</div>
	</div>


	<%-- 统一dialog,myDialog表示没有iframe,myIframeDialog表示使用iframe,且iframe的名称统一为openIframe,(如果弹出的iframe中又包含弹出框,就不用变) --%>
	<!--
	<div id="myDialog" class="easyui-dialog" closed="true" modal="true" title="标题" style="display:block; overflow-x:hidden">
	</div>
	-->

	<div id="myIframeDialog" class="easyui-dialog" closed="true" modal="true" title="标题" style="display:block;width:800px;height:500px; overflow-x:hidden">
    	<iframe scrolling="auto" id='openIframe' frameborder="0"  src="./saleunit_new/guangzhou/loading.jsp" style="width:100%;height:100%;"></iframe>
	</div>

</body>


</html>
