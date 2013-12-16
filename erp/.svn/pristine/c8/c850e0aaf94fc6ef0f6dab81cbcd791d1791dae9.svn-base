<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>客户修改</title>

<script language="javascript" type="text/javascript">
	function clearSuggestion(){
		setTimeout("document.getElementById('suggestion').innerHTML = ''", 2000);
	}
</script>

</head>

<body onload="clearSuggestion()">

<s:include value="header_customer.jsp"></s:include>
<s:include value="updateMain_customer_tl.jsp"></s:include>
<s:include value="bottom_customer.jsp"></s:include>

</body>
</html>
