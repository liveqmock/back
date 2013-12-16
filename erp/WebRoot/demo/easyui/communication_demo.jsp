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
<b>界面间的通信说明：</b>

<br/>
1，元素的访问交互：<br/>
easyui.util.js<br/>
$.ed(selectType);
<br/>
<br/>
2，参数的传递：<br/>
url的参数传递，拼凑url
data: $(form).serialize(),
<br/>
<br/>
3,调用easyui.utils.js里面的getInputsAsOjbect(),可以组合成对象，进行post动作的传递
<br/>
<br/>
4,调用easyui.utils.js里面的requestParaToObject(),将地址栏组合成对象
<br/>


<p></p>

<br/>
<p></p>
<br/>

</body>
</html>

