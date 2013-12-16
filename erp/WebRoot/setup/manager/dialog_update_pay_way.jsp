<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>

	<base href="<%=basePath%>">	
	
	<title>付款方式</title>
	<style type="text/css">
		*{margin:0;padding:0;}
		body{font-size:75%}
		.gbox {
			background: none repeat scroll 0 0 #A9D9FF;
		}
	</style>
	
	<s:include value="../../header/header_easyui.jsp"></s:include>		
	
	</head>
<body>
<div class="gbox1" style="">		
<form action="./saleunit_setup/payway/updatePayWay.action" id="updatePayWayFormId" method="post">	
	<table style="width: 100%;line-height: 24px;" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" >
		<tr bgcolor="#ffffff">
			<td width="120" align="right"><font color="red">*</font>付款方式</td>
			<td>
				<input type="hidden" name="payWay.id" value="${wayId}"/>
				<input name="payWay.payName" value="${payWay.payName }" id="payName"/>
			</td>
		</tr>
		<tr bgcolor="#ffffff">
			<td align="right">备注</td>
			<td>
				<input name="payWay.remark" value="${payWay.remark }" style="width:80%"/>
			</td>
		</tr>
		
	</table>
	</form>
</div>
</body>
</html>