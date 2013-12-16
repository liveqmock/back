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
	
	<title>成交单元管理</title>
	
	<base href="<%=basePath%>" />		
		
	<s:include value="../../customer/guangzhou/header.jsp"/>
	
	<link href="./css/easyui.css" rel="stylesheet" type="text/css" charset="utf-8"/>
	
	<link href="./css/unit_table.css"  rel="stylesheet" type="text/css" charset="utf-8"/><!-- unit的样式 -->	

	<script type="text/javascript" language="javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/easyui-lang-zh_CN.js"></script>	
	
	<script type="text/javascript" language="javascript" src="./js/easyui.utils.js"></script>
	<script type="text/javascript" language="javascript" src="./js/easyui.left.tree.js"></script>
	
	<script type="text/javascript" language="javascript" src="./js/change_project_at_title.js"></script><!-- 项目修改 -->	
	<script type="text/javascript" language="javascript" src="./js/saleunit_contract_manager_tabs.js"></script><!-- 关于tabs操作的js-->

	<script type="text/javascript" language="javascript" src="./js/saleunit_contract_manager_pay_plan.js"></script><!-- 单元应收款-->			
	<script type="text/javascript" language="javascript" src="./js/saleunit_contract_manager_paybill.js"></script><!-- 收款明细-->

	<script type="text/javascript" language="javascript">

		$(document).ready(function(){
		
			bindLeftCombobox("__myProjectId__", "__contractManager__", bindLeftTree, ["__contractManager__"]);			
		});
		
		
		function bindLeftTree(selectType){
		
			$("#left_tree").tree({
				animate:false,
				url:'./saleunit_new/appoint/guangzhou/layoutLeft.action?selectType=' + selectType,
				onClick:function(node){
					
					clickToLoadCenterTabs(node);
				},
				onLoadSuccess:function(node, data){
					
				}
			});			
			
			managerTabs();
		}
		
	</script>
	
	<script type="text/javascript" language="javascript">
		function clickToLoadCenterTabs(node){
		
			clickNode(node);
				
			var selectTabs = $("#manager_center_tabs").tabs("getSelected"); //获取选中的标签项
	        var title = selectTabs.panel('options').title;
			
			if(title == "汇总"){
				gatherTabsAjaxForClick(selectTabs);
				
			}else if(title == "明细"){
				detailTabsAjax(node, selectTabs);
				
			}else if(title == "底价管理") {
				basePriceManAjax(node, selectTabs);
				
			}else if(title == "应收管理") {
				receiveInManAjax(node, selectTabs);
				
			}else if(title == "实收管理") {
				paidInManAjax(node, selectTabs);
				
			}else if(title == "其他费用"){
				otherTabsAjax(selectTabs);
			}else if(title == "合同管理"){
				
				contractTabsAjax(node, selectTabs);
			}
			
		}
		
		//点击导航树,设定项目,分区,楼栋id
		function clickNode(node){
			
			var projectId = "";
			
			var attr = node.attributes;
			var type = attr.type;
			var valId = attr.valId;
			var target = node.target;
			
			if(type == "p"){
			
				projectId = attr.valId;
			}else if(type == "area"){
			
				projectId = $("#left_tree").tree('getParent', target).attributes.valId;							
			}else if(type == "endNode"){
				
				var areaNode = $("#left_tree").tree('getParent', target);
				var projectNode = $("#left_tree").tree('getParent', areaNode.target);
				projectId = projectNode.attributes.valId;				
			}
			
			$("#hiddenPropertyProjectId").val(projectId);			
			
		}
	</script>

	
  </head>
  
<body class="easyui-layout">	

	<div region="west" split="true" 
		 title='<input type="text" name="selectProId" id="__myProjectId__" style="width:160px" rhref="./saleunit_contract/manager/layout.action"/>'
		 style="width:200px;padding:1px;">	
		 
		<ul id="left_tree" animate="false"></ul>
		
		<!-- 左边树操作对应的上一个楼盘项目id -->
		<input type="hidden" id="hiddenPropertyProjectId" />
		
	</div>	
	
	<%--
	 <div region="west" split="true" 
	 	title='<s:select list="urList" listKey="projectId" listValue="descProjectId" name="selectProId" 
	 		cssStyle="vertical-align: middle;" onChange="change_project(this)" rhref="./saleunit_contract/manager/layout.action"></s:select>'
		style="width:213px;padding:1px;">	
	 
		<ul id="left_tree" animate="false"></ul>
		
		<!-- 左边树操作对应的上一个楼盘项目id -->
		<input type="hidden" id="hiddenPropertyProjectId" />
		
	</div>
	--%>
	
		
	<div region="center" title="" style="padding:0px;background:#efefef;" id="_center">
		
		<div class="easyui-layout" fit="true" style="background:#cccccc;" id="_center_layout">
			
			<!-- 中间的主要部分 -->
			<div region="center" id="center_main" style="top:26px">
				<s:include value="manager_center_tabs.jsp"/>
			</div>
			
			<!-- 中间的底下部分 title="<span id='center_bottom_title'>&nbsp;</span>"-->
			<div region="south" id="center_bottom" split="true" style="height:300px; width:500px" title="<span id='center_bottom_title'>&nbsp;</span>">
				<s:include value="manager_bottom_tabs.jsp"/>
			</div>
			
		</div>
		
	 </div>
	
</body>

</html>
