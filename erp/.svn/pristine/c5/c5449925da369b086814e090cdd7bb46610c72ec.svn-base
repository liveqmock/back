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

    <title>项目付款方式设置管理</title>

    <base href="<%=basePath%>">

    <s:include value="../../customer/guangzhou/header.jsp"/>

    <link href="./css/easyui.css" rel="stylesheet" type="text/css" charset="utf-8"/>
    <link href="./css/icon.css" rel="stylesheet" type="text/css" charset="utf-8"/>

    <script type="text/javascript" language="javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>

    <script type="text/javascript" language="javascript" src="./js/easyui.utils.js"></script>
	<script type="text/javascript" language="javascript" src="./js/easyui.left.tree.js"></script>
	<script type="text/javascript" language="javascript" src="./js/pay_way_discount.js"></script>
	<script type="text/javascript" language="javascript" src="./js/change_project_at_title.js"></script>
    <script type="text/javascript" language="javascript">
	
       // var build_id = '0';
    	var pp_id = '0'
        $(document).ready(function(){
			
			bindLeftCombobox("__myProjectId__", "__setup__", bindLeftTree, ["__setup__"]);

        });
		
		function bindLeftTree(selectType){
			$("#left_tree").tree({
                animate:false,
                url:'./saleunit_setup/payway/left.action?selectType=' + selectType,
                onClick:function(node){
					
					$("#project_manager_name").html(node.text);
					toProjectDiscountManager(node.attributes.id);
                }
            });
		}
		
		function toProjectDiscountManager(projectId){
			$.ajax({
				type:"get",
				url: "./saleunit_setup/payway/payWayList.action",
				data: "propertyProjectId=" + projectId, //应为: "projectId=" + projectId,
				dataType: "html",
				beforeSend: function(){
					$("#project_manager_main").html("加载中...");
				},
				success: function(data){
				
					$("#project_manager_main").html(data);
					pp_id = projectId;
				}
			});			
		}

        function flush_tab(){
            $.ajax({
                type:"get",
                url: "./saleunit_setup/payway/payWayList.action",
                data: "propertyProjectId=" + pp_id + "&ts=" + new Date(),
                dataType: "html",
                beforeSend: function(){
                    $("#project_manager_main").html("加载中...");
                },
                success: function(data){
                    $("#project_manager_main").html(data);
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
		 title='<input type="text" name="selectProId" id="__myProjectId__" style="width:160px" rhref="./saleunit_setup/manager/layout.action"/>'
		 style="width:200px;padding:1px;">	
		<ul id="left_tree" animate="false"></ul>		
	</div>

	<%--
	<div region="west" split="true" title='<s:select list="urList" listKey="projectId" listValue="descProjectId" name="selectProId" cssStyle="vertical-align: middle;"
		 onChange="change_project(this)" rhref="./saleunit_setup/manager/layout.action"></s:select>' style="width:213px;padding:1px;">
	
		<ul id="left_tree" url="#" animate="false"></ul>
	
	</div>
	--%>

	<div region="center" style="top:26px" title="<span id='project_manager_name'>&nbsp;</span>" id="project_manager_main">
		<div style="float:left;margin-left:60px;margin-top:30px;color:#003C9D;">请选择左边楼盘项目，显示对应楼盘项目的付款方式列表.</div>
	</div>
	

<!--
<div region="center" id="unit_map" style="top:26px">
    <div class="easyui-tabs" fit="true" border="false" id="sale_tabs"   region="center">
        <div title="付款方式" style="overflow: scroll;" id="_center_div" uid="" href="./saleunit_setup/payway/tabHtml.action?unitId=1">
        </div>

        <div title="售后下拉框"  style="padding:0px;" id="_make_price" uid="">
      单元资料管理
      </div> 
    </div>

</div>
-->




<%-- 统一dialog,myDialog表示没有iframe,myIframeDialog表示使用iframe,且iframe的名称统一为openIframe,(如果弹出的iframe中又包含弹出框,就不用变) --%>
<div id="myDialog" class="easyui-dialog" closed="true" modal="true" title="标题" style="display:block;width:800px;height:500px; overflow-x:hidden">
</div>

<div id="myIframeDialog" class="easyui-dialog" closed="true" modal="true" title="标题" style="display:block;width:800px;height:500px; overflow-x:hidden">
    <iframe scrolling="auto" id='openIframe' frameborder="0"  src="./saleunit_new/guangzhou/loading.jsp" style="width:100%;height:100%;"></iframe>
</div>

</body>


</html>
