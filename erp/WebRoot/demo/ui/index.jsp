<%@ page import="com.ihk.utils.CacheUtils" %>
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
    <script type="text/javascript" src="<%=basePath%>demo/ui/js/boot.js"></script>

    <link rel="stylesheet" type="text/css"  href="<%=basePath%>demo/ui/css/common.css" />

    <!--[if IE 6]>
    <script type="text/javascript" src="<%=basePath%>js/DD_belatedPNG_0.0.8a-min.js"></script>

    <script type="text/javascript">
        $().ready(function(){
            DD_belatedPNG.fix('.logintitle,.loginbox,.logo');
        });
    </script>
    <![endif]-->



    <script type="text/javascript">

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
        });

    </script>

    <style type="text/css">
            p.l-log-content
            {
                margin: 0;
                padding: 0;
                padding-left: 20px;
                line-height: 22px;
                font-size: 12px;
            }
            span.l-log-content-tag
            {
                color: #008000;
                margin-right: 2px;
                font-weight: bold;
            }
            h2.l-title
            {
                margin: 17px;
                padding: 0;
                font-size: 17px;
                font-weight: bold;
            }
            h3.l-title
            {
                margin: 14px;
                padding: 0;
                font-size: 15px;
                font-weight: bold;
            }
        </style>

</head>

<body class="easyui-layout" >

<div data-options="region:'north',border:false" style="height:64px;overflow: hidden;">
    <h1 style="line-height: 64px">销售管理系统UI框架开发帮助</h1>
</div>

<div data-options="region:'west',split:true,title:'导航菜单',iconCls:'icon-redo'" style="width:230px;">
    <s:include value="left.jsp" />
</div>


<div data-options="region:'center'">
    <div id="tabs" class="easyui-tabs" fit="true" border="false">
        <div title="欢迎使用">
            <div style="margin-left: 0px;margin-top:30px;">

                <h2 class='l-title'>欢迎页面</h2>

                <p class="l-log-content">使用控件及版本</p>

                <p class="l-log-content">Easyui: v1.3.1</p>

                <p class="l-log-content">Jquery: v1.7.1</p>

                <p class="l-log-content">Highcharts JS v2.2.5 </p>

                <h3 class='l-title'>目录说明</h3>
                <p class="l-log-content">ui  UI目录</p>
                <p class="l-log-content">ui/css UI样式</p>
                <p class="l-log-content">ui/js UI javascript 及控件</p>
                <p class="l-log-content">ui/js/boot.js 加载jquery、easyui、highcharts及皮肤</p>
                <p class="l-log-content">ui/left.jsp 左边导航菜单</p>

            </div>
        </div>
    </div>

</div>
<div data-options="region:'south',border:false" style="height:30px;line-height:30px;overflow: hidden;text-align: center;">
    Copyright ©2012 Hopefluent Properties All Rights Reserved.合富辉煌 版权所有
</div>

<div id="menu" class="easyui-menu" style="width:150px;">
    <div id="m-refresh">刷新</div>
    <div class="menu-sep"></div>
    <div id="m-closeall">全部关闭</div>
    <div id="m-closeother">除此之外全部关闭</div>
    <div class="menu-sep"></div>
    <div id="m-close">关闭</div>
</div>
</body>
</html>

