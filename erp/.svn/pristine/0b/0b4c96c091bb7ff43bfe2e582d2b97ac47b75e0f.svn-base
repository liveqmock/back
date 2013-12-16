<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title></title>
<s:include value="../../header/header_easyui.jsp"></s:include>
<s:include value="coder_header.jsp"></s:include>
</head>
<body  style="padding:10px;">
<b>左右结构说明：</b>
<p></p>
<b>参考：</b><br/>
/saleunit_new_report/report/guangzhou/layout.action<br/>
<p></p>
<b>主要代码说明：</b>
<br/>

在div region="center" 里面写一个iframe

<br/>
统一使用iframe来进行局部页面的加载，便于页面可以直接被其他页面调用，而不需要考虑对主体页面的代码形成影响
<br/>
<b>代码的框架:</b><br/>
<textarea rows="10" cols="150">


	<!-- layout的布局 -->
<body class="easyui-layout">

	<!-- 上部的内容 -->
	<div region="north" border="false"
		style="height:50px;background:#B3DFDA;padding:0px; overflow:hidden">
		上部的内容
	</div>
	
	

	<!-- 左边的功能树 -->
	<div region="west" split="true"
		title="<a href='./customer_guangzhou/index/login.action' style='color:#5482DE'>返回主页</a>"
		style="width:213px;padding:1px;">
		
		</div>
		
		
	<!-- 中间主体内容结构 -->
	<div region="center" title="<div id='showTitle'>报表</div>"
		style="padding:0px;background:white;" id="_center">
		<iframe id="_centerFrame" frameborder="0" scrolling="auto" style="width:100%;height:100%"></iframe>		
		</div>  
		
	
	
	<!-- 底部,不用放其他代码，预留占位-->
	<div region="south" border="false"
		style="background:#A9FACD;padding:0px;">
		<div style="width: 100%;height: 15px;background: #eeeeee"></div>
	</div>
</body>
</textarea>

		
		

</body>
</html>

