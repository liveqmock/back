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
<b>增删改查说明：</b>

这是基本的增删改查页面，可以用代码生成器生成全套代码<br/>

<p></p>
<b>参考：</b><br/>
/demo/easyui/searchList.action<br/>
<p></p>
<b>主要代码说明：</b>
<br/>
添加，修改，一般采用弹出窗口(iframe)的方式实现；
<br/>
查询，分页，采用自己公司制作的样式与实现；
<br/>

</body>
</html>

