<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>
	
	<title>付款方式</title>
	<style type="text/css">
		*{margin:0;padding:0;}
	</style>
	<script>
	function formsubmit (){
		document.getElementById("question_toc_form").submit();
    }
	</script>
	</head>
<body>
<div class="gbox1" style="">		
<form action="./saleunit_setup/payway/dialogCopyPayWayForm.action" id="question_toc_form" method="post">	
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1"  style="font-size:12px; line-height:26px;">
		
		<tr bgcolor="#ffffff" >
			<td align="right">楼栋&nbsp;&nbsp;</td>
			<td>
				<s:select list="buildList" name="copyBuildId" listKey="id" listValue="buildName" cssStyle="min-width: 100px"/>
			</td>
		</tr>
		<tr bgcolor="#ffffff">
			<td width="120" align="right">复制方式&nbsp;&nbsp;</td>
			<td>
				<input type="radio" value="1" checked="checked" name="copyType"/>增加
				<input type="radio" value="2" name="copyType"/>覆盖
				<input type="hidden" name="buildId" value="${buildId }"/>
			</td>
		</tr>
		<tr>
			<td colspan="2" style="color: red">${mag }</td>
		</tr>
	</table>
	</form>
</div>
</body>
</html>