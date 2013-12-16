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
<b>杂项说明：</b>
过于零碎的事情，在这里进行记录，如果过多，再进行分拆合并
<br/>

<p></p>
<b>参考：</b><br/>

<hr/>
<b>避免地址被代理服务器缓存：</b><br/>
做法：地址url增加随机串(时间戳)
/demo/easyui/otherDocDemo.action?ts=< %=CacheUtils.getUrlTimeStamp()%>
<br/>(这里要把"< %=" 之间的空格去掉)<br/>
之前万科项目，使用代理服务器，对url地址进行了缓存，导致很多奇怪的问题，例如A账号看到B账号的客户信息<br/>
<hr/>
<br/>
<b>easyui的datagrid取得行数：</b><br/>
				var rows_length = $('#dg').datagrid('getRows').length;  
<hr/>
<br/>

<br/>
<p></p>
<b>主要代码说明：</b>
<br/>
<br/>

</body>
</html>

