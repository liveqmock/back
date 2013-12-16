<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="com.ihk.utils.CacheUtils"%>
<%@ page import="com.ihk.constanttype.EnumDevFlag" %>
<%@ page import="com.ihk.constanttype.EnumPrivCode" %>
<%@ page import="com.ihk.permission.PermissionUtils" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>

    <title>楼盘建档</title>

    <base href="<%=basePath%>" />

    <s:include value="../../header/header_easyui.jsp"/>

    <!-- ie6 水印问题 -->
    <script type="text/javascript" src="<%=basePath%>js/DD_belatedPNG_0.0.8a-min.js"></script>
    <script type="text/javascript" language="javascript" src="<%=basePath%>saleunit_new_init/guangzhou/js/dialog_for_tree.js?v=1"></script>

    <script type="text/javascript" language="javascript" src="./js/saleunit_new_common.js"></script>
    <script type="text/javascript" language="javascript" src="./js/easyui.utils.js"></script>

    <script type="text/javascript" language="javascript" src="./js/easyui.left.tree.js"></script>

    <script type="text/javascript" language="javascript" src="./js/change_project_at_title.js"></script>
    <script type="text/javascript" language="javascript" src="./js/contract_manager.js"></script>

    <!-- 主要使用其中的图片上传 -->
    <script type="text/javascript" language="javascript" src="./js/saleunit_new_unit_info.js"></script>

    <script type="text/javascript">
        $().ready(function(){
            DD_belatedPNG.fix('.logo');
        });
    </script>

    <script type="text/javascript" language="javascript">
		var select_tabs = '单元信息';
		var build_id = '0';
		var click_unit_id = '0';
		var pro_pro_id = '0';
		var selectProId ='0';
		var areaId = '0';
		var type ='com';
        $().ready(function(){

            doCustomerBeforTab();//选择了项目就有信息

            $('#sale_tabs').tabs({ //绑定点击TABLS事件
                onSelect:function(title){
                    if(title == '单元信息'){
                        doUnitInfo();
                    }else if(title == '单元图片'){
                        doUnitImage();
                    }
                    else if(title == '单元资料管理'){
                        doMakePrice();
                    }else if (title == '操作日志') {
               			 doSaleUnitLogInfo();
               		}
                    select_tabs = title;

                    //合同管理的方法
                    treeToContractManager();
                }
            });

            bindLeftCombobox("__myProjectId__", "__init__", bindLeftTree, ["__init__"]);

        });

        function bindLeftTree(selectType){

            $("#left_tree").tree({
                animate:false,
                url:'./saleunit_new_init/appoint/guangzhou/layoutLeft.action?selectType=' + selectType,
                onLoadSuccess:function(node, data){
                    $(".add_some").click(function(event){
                        //   event.stopPropagation();
                        addSomeProject($(this).attr('type'),$(this).attr('sid'));
                        if(node != null){
                            $(this).tree('toggle', node.target);
                        }
                    });
                    $(".re_some").click(function(event){
                        //  event.stopPropagation();
                        var par = $(this).parent();
                        reSome($(this).attr('type'),$(this).attr('sid'),par);
                        if(node != null){
                            $(this).tree('toggle', node.target);
                        }
                    });
                },
                onClick:function(node){
                    var attr = node.attributes;
                    if(attr != undefined && attr.type == "endNode"){
                        $.ajax({
                            type:"get",
                            url: "./saleunit_new_init/appoint/guangzhou/unitMap.action",
                            data: "buildId=" + attr.bid + "&ts=" + new Date(),
                            dataType: "html",
                            beforeSend: function(){
                                //$("#unit_map").html("加载中...");
                                moduleMask('unit_map');
                            },
                            success: function(data){
                                $("#unit_map").html(data);
                                build_id = attr.bid;
                                doMakePrice();//依据项目需要改变
                                doQuestion();
                            }
                        });
							type ="build";
							doSaleUnitLogInfo();
                    }else if(attr != undefined && attr.type == "pro"){
                        pro_pro_id = attr.proId;
                        $.ajax({
                            type:"get",
                            url: "./saleunit_new_init/appoint/guangzhou/projectInfo.action",
                            data: "proId=" + attr.proId + "&ts=" + new Date(),
                            dataType: "html",
                            beforeSend: function(){
                                //$("#unit_map").html("加载中...");
                                moduleMask('unit_map');
                            },
                            success: function(data){
                                $("#unit_map").html(data);
                                doQuestion();
                            }
                        });

                        $(this).tree('toggle', node.target);
						type='pro';
						doSaleUnitLogInfo();
                    }else if(attr != undefined && attr.type == "area"){
						areaId = attr.valId;
						type='area';
						doSaleUnitLogInfo();
						$(this).tree('toggle', node.target);
					
					}else {
                        $(this).tree('toggle', node.target);
                    }

                    //合同管理的方法
                    treeToContractManager();

                }
            });
        }
		function doSaleUnitLogInfo() {
		    var utabs = $("#_sale_unit_log_info");
		    utabs.load("./saleunit_new/appoint/guangzhou/buildingAreaUnitInitLogInfo.action?unitId="
		        + click_unit_id + "&selectProId=${selectProId}"+"&priId="+ pro_pro_id+"&areaId="+ areaId +"&buildId=" + build_id +"&type=" +type  );
		    utabs.attr("uid", click_unit_id);
		}
    </script>

    <link href="./css/unit_table.css"  rel="stylesheet" type="text/css" charset="utf-8"/><!-- unit的样式 -->
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

<div region="west" split="true"
     title='<input type="text" name="selectProId" id="__myProjectId__" style="width:160px" rhref="./saleunit_new_init/appoint/guangzhou/layout.action"/>'
     style="width:200px;padding:1px;">

    <%if(PermissionUtils.hasPermission(EnumPrivCode.SALEUNIT_INIT_UNITINFO, EnumDevFlag.GUANGZHOU)){%>
    <a onclick="$('#ttxx').hide();addSome('add_project',0)" class="easyui-linkbutton" iconCls="icon-add"   plain="true">新建楼盘</a>
    <a onclick="copyBuild()" class="easyui-linkbutton"   plain="true">复制楼栋</a>
    <hr />
    <%}%>

    <s:include value="layout_left.jsp"/>
</div>

<div region="center"  style="padding:0px;background:#ffffff;" id="center_main" >

    <div class="easyui-layout" fit="true" style="background:#ccc;" id="_center_layout">

        <!-- 中间的顶上部分 -->
        <div region="north" id="center_top" style="height:55px; width:auto">
            <s:include value="../../saleunit_new/guangzhou/unit_sale_state.jsp"/>
            <s:include value="init_unit_some_bar.jsp"/>

        </div>

        <!-- 中间的主要部分 -->
        <div region="center" id="unit_map" style="top:26px">

            <div style="float:left;margin-left:60px;margin-top:30px;color:#003C9D;">请选择左边楼栋，显示对应单元.</div>

        </div>

        <!-- 中间的底下部分 -->
        <div region="south" id="center_bottom" split="true" style="height:230px; width:500px" title="">

            <s:include value="layout_center_bottom.jsp"/>
        </div>

    </div>

</div>

<%--dialog --%>
<div id="new_dialog" class="easyui-dialog" closed="true" modal="true" title="标题" style="display:block;width:500px;height:250px; overflow-x:hidden">
    <iframe scrolling="auto" id='new_dialog_ifram' frameborder="0"  src="./saleunit_new/guangzhou/loading.jsp" style="width:100%;height:100%;"></iframe>
</div>
<div id="myIframeDialog" class="easyui-dialog" closed="true" modal="true" title="标题" style="display:block;width:500px;height:250px; overflow-x:hidden">
    <iframe scrolling="auto" id='openIframe' frameborder="0"  src="./saleunit_new/guangzhou/loading.jsp" style="width:100%;height:100%;"></iframe>
</div>

</body>
</html>

