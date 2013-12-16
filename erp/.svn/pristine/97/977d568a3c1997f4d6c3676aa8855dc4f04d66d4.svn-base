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
<b>日志的做法说明：</b>

<br/>

<p></p>
<p><b>参考：</b></p>
<p>日志共用的基类是com.ihk.utils.common.log.BaseLogger.java</p>
<p>
 后台类中的方法不要使用Systom.out来记录输出及调试，使用log的方式来替代。
<br/>
共用的方法是com.ihk.utils.common.log.BaseLogger.java。
<br/>
一般地，正常输出使用debug，警告使用warn，异常使用error，因为现在我们本地开发的log4j默认级别是debug，服务器上用的warn。

<br/>
  
  <br/>
</p>

</body>
</html>

