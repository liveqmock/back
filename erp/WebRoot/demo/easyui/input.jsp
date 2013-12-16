<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8"%>

<%@ page import="com.ihk.utils.CacheUtils"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()	+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>

<title>input</title>

<base href="<%=basePath%>">

<s:include value="../../header/header_easyui.jsp"></s:include>

<link href="./css/easyui.css" rel="stylesheet" type="text/css" charset="utf-8" />
<link href="./css/icon.css" rel="stylesheet" type="text/css" charset="utf-8" />

<script type="text/javascript" language="javascript" src="./js/easyui.utils.js"></script>

<script type="text/javascript" language="javascript">
	
	$().ready(function(){

		autoCloseIframeDialog("${closeMark}", "${suggestion}");
	});
</script>


<style type="text/css">
* {
	margin: 0;
	padding: 0;
}
</style>

</head>

<body>	
	
	<form id="saveDemoFormId" method="post" action="./demo/easyui/inputData.action">
		<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="font-size:12px; line-height:26px">	
		
		  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
			<td id="t15" style="width:30%" align="center"><font color="#FF0000">*</font>columnInt</td>
			<td id="t16" style="width:70%">&nbsp;&nbsp;<input type="text" id="columnInt" name="demoTable.columnInt"/>
			</td>
			</tr>
			
			 <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
			<td id="t15" style="width:30%" align="center"><font color="#FF0000">*</font>columnCode</td>
			<td id="t16" style="width:70%">&nbsp;&nbsp;<input type="text" id="columnCode" name="demoTable.columnCode"/></td>
			</tr>
			
			 <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
			<td id="t15" style="width:30%" align="center">columnVarchar</td>
			<td id="t16" style="width:70%">&nbsp;&nbsp;<input type="text" id="columnVarchar" name="demoTable.columnVarchar"/></td>
			</tr>
			
			 <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
			<td id="t15" style="width:30%" align="center">columnVarchar2</td>
			<td id="t16" style="width:70%">&nbsp;&nbsp;<input type="text" id="columnVarchar2" name="demoTable.columnVarchar2"/></td>
			</tr>
			
			 <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
			<td id="t15" style="width:30%" align="center">columnVarchar3</td>
			<td id="t16" style="width:70%">&nbsp;&nbsp;<input type="text" id="columnVarchar3" name="demoTable.columnVarchar3"/></td>
			</tr>
			
			 <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
			<td id="t15" style="width:30%" align="center">columnText</td>
			<td id="t16" style="width:70%">&nbsp;&nbsp;<input type="text" id="columnText" style="width: 85%;" name="demoTable.columnText"/></td>
			</tr>
			
			 <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
			<td id="t15" style="width:30%" align="center">columnDate</td>
			<td id="t16" style="width:70%">&nbsp;&nbsp;<input class="easyui-datebox" type="text" style="width:90px" id="columnDate" name="demoTable.columnDate" /></td>
			</tr>
			
			 <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
			<td id="t15" style="width:30%" align="center">columnPrice</td>
			<td id="t16" style="width:70%">&nbsp;&nbsp;<input type="text" id="columnPrice" name="demoTable.columnPrice"/></td>
			</tr>
			
		</table>
	</form>


</body>

</html>
