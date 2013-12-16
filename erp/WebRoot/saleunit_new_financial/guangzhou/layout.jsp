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
	
	<title>财务管理</title>
	
	<base href="<%=basePath%>" />
		
	<s:include value="../../customer/guangzhou/header.jsp"/>
	
	<link href="./css/unit_table.css"  rel="stylesheet" type="text/css" charset="utf-8"/><!-- unit的样式 -->	
				
	<link href="./css/easyui.css" rel="stylesheet" type="text/css" charset="utf-8"/>
	<link href="./css/icon.css" rel="stylesheet" type="text/css" charset="utf-8"/>

    <script type="text/javascript" language="javascript" src="./js/customer_guangzhou_project.js"></script>
	<script type="text/javascript" language="javascript" src="./js/customer_guangzhou_user.js"></script>

	<script type="text/javascript" language="javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>

	<script type="text/javascript" language="javascript" src="./js/saleunit_financial_manager.js"></script>
	<script type="text/javascript" language="javascript" src="./js/saleunit_financial_pay_plan.js"></script> <!--应收款 分割了文件  -->
	<script type="text/javascript" language="javascript" src="./js/saleunit_financial_manager_tabs.js"></script>

	<script type="text/javascript" language="javascript" src="./js/saleunit_new_common.js"></script>

	<script type="text/javascript" language="javascript" src="./js/easyui.utils.js"></script>
	<script type="text/javascript" language="javascript" src="./js/easyui.tab.utils.js"></script>
	<script type="text/javascript" language="javascript" src="./js/easyui.left.tree.js"></script>
	
	<script type="text/javascript" language="javascript" src="./js/project.text.utils.js"></script>

	<script type="text/javascript" language="javascript" src="./js/saleunit_new_unit_info.js"></script>
	<script type="text/javascript" language="javascript" src="./js/saleunit_sale.js"></script><!-- 管理销售弹出框 -->

	<!--
	<script type="text/javascript" language="javascript" src="./js/base_price_manager.js"></script>
	-->
	
	<script type="text/javascript" language="javascript">

		$().ready(function(){
		
			bindLeftCombobox("__myProjectId__", "__financial__", bindLeftTree, ["__financial__"]);			
			
			bindFinancialTabs();

		});
		
		function bindFinancialTabs(){
		
			$('#financial_tabs').tabs({
					onSelect : function(title) {
					
					var selectTabs = $("#financial_tabs").tabs("getTab", title);
					var selectUnitId = $("#hiddenUnitId").attr("value");		
					
					selectTabsToAction(selectTabs, selectUnitId);
				}
			});
		}
		
		function bindLeftTree(selectType){
			
			$("#left_financial_tree").tree({
				//url:"./saleunit_new_questions/appoint/guangzhou/layoutLeft.action",
				url:'./saleunit_new/appoint/guangzhou/layoutLeft.action?selectType=' + selectType,
				onClick:function(node){

					treeNodeClickForFinancialManager("left_financial_tree", node, "false", "left_main");

				},
				onLoadSuccess:function(node, data){
					//用了异步加载tree节点的方法,每次加载成功都会调用该方法,应该只有当data[0].id为p开头才执行
					var dataId = data[0].id;
					var type = dataId.substr(0, 1);
					if(type == "p"){
						var propertyId = dataId.substr(1, dataId.length);

						//一进来应该默认选中一个单元,(最后操作的那个单元)

						$.ajax({
							type:"get",
							url: "./saleunit_financial_manager/guangzhou/getDefaultFromProperty.action",
							data: "propertyId=" + propertyId + "&type=Financial&ts=" + new Date(),
							dataType: "html",
							beforeSend: function(){
								//$("#center_main").html("加载中...");
								moduleMask("left_main");
							},
							success: function(data){

								//1. 设置单元列表
								$("#left_main").html(data);

								//2. 设置选中单元
								getDefaultUnitIdFromProperty(propertyId);
							}
						});
					}

				}
			});
		}

		//获取初次加载要选中的单元id
		function getDefaultUnitIdFromProperty(propertyId){

			$.ajax({
				type:"get",
				url: "./saleunit_financial_manager/guangzhou/getDefaultUnitIdFromProperty.action",
				data: "propertyId=" + propertyId,
				dataType: "json",
				success: function(data){
				
					if(data == null){
						return ;
					}

					var unitId = data.unitId;
					if (unitId != "" && unitId != "0" && unitId != undefined) {

						unitClick(unitId);  //saleunit_financial_manager.js
						addChangeClass("true", unitId);  //saleunit_new_common.js
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
		.tb1 td{padding-left: 5px;width:75px; text-align:center; cursor: pointer}
		.tb1 tr{background-color:#FFFFFF}
		.seltd{background-color:#EEAD0E}
		.changetd{background-color:#EEAD0E}
		.exChangetd{background-color:#EEAD0E}
	</style>	
	
  </head>
  
<body class="easyui-layout">

	<%--
	<div region="west" split="true" title="财务管理" style="width:213px;padding:1px;">	
	--%>
	
	<div region="west" split="true" title='<input type="text" name="selectProId" id="__myProjectId__" style="width:160px" rhref="./saleunit_financial_manager/guangzhou/layout.action"/>'
		style="width:213px;padding:1px;">	
		
		<div class="easyui-layout" fit="true" style="background:#cccccc;" id="_west_layout">
			
			 <div region="north" title="" id="west_center_north" split="true" style="height:342px;">
				<ul id="left_financial_tree" animate="false"></ul>
			  </div>  
			  
			  <div region="center" id="west_center_main" style="padding:0px;">	
			  	<!-- 单元table -->
				 <div region="center" id="left_main" style="padding:0px;"></div>
			  </div>
			
		</div>
		
	</div>
		
	<!-- 中间再分上下结构 -->
	<div region="center" title="<div id='showUnitId'>&nbsp;</div>" style="padding:0px;background:#efefef;" id="_center">		
		
		<div class="easyui-layout" fit="true" style="background:#cccccc;" id="_center_layout">
			
			 <div region="north" title="" id="center_pay_info" split="true" style="height:350px;">			 	
				<!-- 具体的收费款项 table-->
			  </div>  
			  
			  <div region="center" id="center_pay_tabs" style="padding:0px;">	
			  	<!-- 款项的操作 tabs-->
				 <s:include value="financial_bottom_tabs.jsp"/>
			  </div>
			
		</div>
		
	</div>
	
	<!-- 底部,不用放其他代码-->
	<!--
	<div region="south" border="false"  style="background:#A9FACD;padding:0px;">
		<div style="width: 100%;height: 15px;background: #eeeeee" ></div>
	</div>		
	-->
	
	<!-- 统一dialog,myDialog表示没有iframe,myIframeDialog表示使用iframe,且iframe的名称统一为openIframe,(如果弹出的iframe中又包含弹出框,就不用变) -->
	<div id="myDialog" class="easyui-dialog" closed="true" modal="true" title="标题" style="display:block;width:800px;height:500px; overflow-x:hidden"> 			
	</div> 	
	
	<div id="myIframeDialog" class="easyui-dialog" closed="true" modal="true" title="标题" style="display:block;width:800px;height:500px; overflow-x:hidden"> 			
    	<iframe scrolling="auto" id='openIframe' frameborder="0"  src="./saleunit_new/guangzhou/loading.jsp" style="width:100%;height:100%;"></iframe> 
	</div> 		 	

</body>



</html>

