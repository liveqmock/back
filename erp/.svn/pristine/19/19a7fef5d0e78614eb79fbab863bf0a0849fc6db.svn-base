<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
         isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8"%>


<%@ page import="com.ihk.utils.CacheUtils"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>

    <title>用户管理</title>

    <base href="<%=basePath%>"/>

    <s:include value="../../customer/guangzhou/header.jsp" />
    <link href="./css/easyui.css" rel="stylesheet" type="text/css"
          charset="utf-8" />
    <link href="./css/icon.css" rel="stylesheet" type="text/css"
          charset="utf-8" />
		  
    <script type="text/javascript" language="javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>
    <script type="text/javascript" language="javascript" src="./js/easyui.tab.utils.js"></script>

    <script type="text/javascript" language="javascript">
      
		function flushThis(){
			location=location;
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
        * {
            margin: 0;
            padding: 0;
        }
    </style>

</head>

<body class="easyui-layout">

<!-- 上部的内容 -->


<!-- 中间主体内容结构 -->
<div region="center" style="padding:0px;background:white;" id="_center">
    <iframe id="_centerFrame" frameborder="0" scrolling="auto" src="./user/manager/index.action" style="width:100%;height:100%"></iframe>
</div>

<!-- 底部,不用放其他代码，预留占位-->
<div region="south" border="false"
     style="background:#A9FACD;padding:0px;">
    <div style="width: 100%;height: 15px;background: #eeeeee"></div>
</div>

<!-- 统一dialog,myDialog表示没有iframe,myIframeDialog表示使用iframe,且iframe的名称统一为openIframe,(如果弹出的iframe中又包含弹出框,就不用变) -->
<div id="myDialog" class="easyui-dialog" closed="true" modal="true"
     title="标题"
     style="display:block;width:800px;height:500px; overflow-x:hidden">
</div>

<div id="myIframeDialog" class="easyui-dialog" closed="true"
     modal="true" title="标题"
     style="display:block;width:800px;height:500px; overflow-x:hidden">
    <iframe scrolling="auto" id='openIframe' frameborder="0"
            src="./saleunit_new/guangzhou/loading.jsp"
            style="width:100%;height:100%;"></iframe>
</div>
</body>



</html>

