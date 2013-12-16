<%@ page import="com.ihk.constanttype.EnumDevFlag" %>
<%@ page import="com.ihk.constanttype.EnumPrivCode" %>
<%@ page import="com.ihk.permission.PermissionUtils" %>
<%@ page import="com.ihk.utils.SessionUser" %>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>销售管理系统</title>

    <%--公用js   --%>
    <script type="text/javascript" src="<%=basePath%>ui/js/boot.js"></script>

    <!--楼盘初始的合同管理-->
    <script type="text/javascript" language="javascript" src="./js/contract_manager.js"></script>

    <!-- 开发使用,正式机应该去掉-->


    <link rel="stylesheet" type="text/css"  href="<%=basePath%>ui/css/common.css" />

    <link rel="stylesheet" type="text/css" href="<%=basePath%>ui/css/portal.css">
    <script type="text/javascript" src="<%=basePath%>ui/js/jquery.portal.js"></script>


    <!--[if IE 6]>
    <script type="text/javascript" src="<%=basePath%>js/DD_belatedPNG_0.0.8a-min.js"></script>

    <script type="text/javascript">
        $().ready(function(){
            DD_belatedPNG.fix('.logintitle,.loginbox,.logo');
        });
    </script>
    <![endif]-->

    <style type="text/css">
        .panel-tool #index_more{width: 40px;}
    </style>

    <script type="text/javascript">

        $.parser.onComplete = function(){
            setTimeout(function(){$("#loading").fadeOut("normal",function(){$(this).remove();})}, 1000);
        };

        $(function(){
            /*为选项卡绑定右键*/
            $(".tabs li").live('contextmenu',function(e){

                /* 选中当前触发事件的选项卡 */
                var subtitle =$(this).text();
                $('#tabs').tabs('select',subtitle);

                //显示快捷菜单
                $('#menu').menu('show', {
                    left: e.pageX,
                    top: e.pageY
                });

                return false;
            });


            $('#pp').portal({
                border:false ,
                width :"auto",
                fit:true
            });
        });

        function showArticle(url){

            openNormalIframeDialog(url, "", "", "公告内容", "860", "540");
            return false;
        }
	
	
	$(document).ready(function(){ 
	var count = "${count}";
	if(count != ''){
		$.messager.show({
		title: "请绑定内网帐号",
		msg: "请在"+count+"天内绑定内网帐号，过期帐号将被停用",// + "<a href='#' style='color:#1199FF; text-decoration:underline; float:right; padding: 20px 0px 0px 0px' onclick='return closeMessage()'>关闭提醒<a>",
		timeout: 0,
		showType:'slide'
		});
		}
	}); 

    </script>
    <%if(PermissionUtils.isReportMultiCompany()){%>
    <script type="text/javascript">
        $(document).ready(function () {
            $('#get_report11').load('./saleunit/index/report/getReport11.action');
            $('#get_report12').load('./saleunit/index/report/getReport12.action');
            $('#get_report13').load('./saleunit/index/report/getReport13.action');
            $('#get_report14').load('./saleunit/index/report/getReport14.action');
            $('#get_report15').load('./saleunit/index/report/getReport15.action');
            $('#get_report18').load('./saleunit/index/report/getReport18.action');
        });
    </script>

    <%}else if (PermissionUtils.isReportMultiProject()){%>
    <script type="text/javascript">
        $(document).ready(function () {
            $('#get_report11').load('./saleunit/index/report/getReport11.action');
            $('#get_report12').load('./saleunit/index/report/getReport22.action');
            $('#get_report13').load('./saleunit/index/report/getReport23.action');
            //$('#get_report14').load('./saleunit/index/report/getReport14.action');
            $('#get_report15').load('./saleunit/index/report/getReport25.action');
            $('#get_report18').load('./saleunit/index/report/getReport18.action');
        });
    </script>
    <%}else if (PermissionUtils.isReportOneProject()){%>
    <script type="text/javascript">
        $(document).ready(function () {
            $('#get_report11').load('./saleunit/index/report/getReport11.action');
            $('#get_report18').load('./saleunit/index/report/getReport18.action');
            $('#get_report33').load('./saleunit/index/report/getReport33.action');
            $('#get_report15').load('./saleunit/index/report/getReport35.action');
            $('#get_report36').load('./saleunit/index/report/getReport36.action');
        });
    </script>
    <%}else if (PermissionUtils.isReportOnlySale()){%>
    <script type="text/javascript">
        $(document).ready(function () {
            $('#get_report11').load('./saleunit/index/report/getReport11.action');
            //$('#get_report15').load('./saleunit/index/report/getReport15.action');
            $('#get_report18').load('./saleunit/index/report/getReport18.action');
            $('#get_report36').load('./saleunit/index/report/getReport46.action');

        });
    </script>

    <%}%>

</head>

<body class="easyui-layout">

<div id='loading' style="position:absolute;z-index:100000;top:0px;left:0px;width:100%;height:100%; background-color:#eeeeee;text-align:center;padding-top: 20%;">
    <h1><image src='images/loading.gif'/><font color="#15428B"><script type="text/javascript" language="javascript">document.write(myGlobal.loadIng)</script></font></h1>
</div>

<div data-options="region:'north',border:false" style="height:64px;overflow: hidden;">
    <s:include value="../customer/guangzhou/top.jsp" />
</div>

<div data-options="region:'west',split:false,title:'导航菜单',iconCls:'icon-menu'" style="width:222px;">
    <s:include value="left.jsp" />
</div>


<div data-options="region:'center'">
    <div id="tabs" class="easyui-tabs" fit="true" border="false">
        <div title="欢迎使用" style="overflow-x: hidden;">
            <%if(PermissionUtils.isReportMultiCompany()){%>
            <s:include value="include/index/multiCompany.jsp" />
            <%}else if (PermissionUtils.isReportMultiProject()){%>
            <s:include value="include/index/multiProject.jsp" />
            <%}else if (PermissionUtils.isReportOneProject()){%>
            <s:include value="include/index/singleProject.jsp" />
            <%}else if (PermissionUtils.isReportOnlySale()){%>
            <s:include value="include/index/sales.jsp" />
            <%}else{%>
            <s:include value="include/index/other.jsp" />
            <%}%>
        </div>
    </div>
</div>

<div data-options="region:'south',border:false" style="height:20px;line-height:20px;overflow: hidden;text-align: center;">
    Copyright ©2013 Hopefluent Properties All Rights Reserved.合富辉煌 版权所有
</div>

<div id="menu" class="easyui-menu" style="width:150px;">
    <div id="m-refresh">刷新</div>
    <div class="menu-sep"></div>
    <div id="m-closeall">全部关闭</div>
    <div id="m-closeother">除此之外全部关闭</div>
    <div class="menu-sep"></div>
    <div id="m-close">关闭</div>
</div>

<div id="myIframeDialog" class="easyui-dialog" closed="true" modal="true" title="标题" style="display:block;width:800px;height:500px; overflow:hidden">
    <iframe scrolling="auto" id='openIframe' frameborder="0"  src="./saleunit_new/guangzhou/loading.jsp" style="width:100%;height:100%;"></iframe>
</div>

<div id="myIframeDialogX2" class="easyui-dialog" closed="true" modal="true" title="第二层弹出框(弹出框的弹出框)" style="display:block;width:800px;height:500px; overflow:hidden">
    <iframe scrolling="auto" id='openIframeX2' frameborder="0"  src="./saleunit_new/guangzhou/loading.jsp" style="width:100%;height:100%;"></iframe>
</div>

<div id="myIframeDialogX3" class="easyui-dialog" closed="true" modal="true" title="第三层弹出框" style="display:block;width:800px;height:500px; overflow:hidden">
    <iframe scrolling="auto" id='openIframeX3' frameborder="0"  src="./saleunit_new/guangzhou/loading.jsp" style="width:100%;height:100%;"></iframe>
</div>

<div id="myIframeDialogX4" class="easyui-dialog" closed="true" modal="true" title="第四层弹出框" style="display:block;width:800px;height:500px; overflow:hidden">
    <iframe scrolling="auto" id='openIframeX4' frameborder="0"  src="./saleunit_new/guangzhou/loading.jsp" style="width:100%;height:100%;"></iframe>
</div>

</body>
</html>

