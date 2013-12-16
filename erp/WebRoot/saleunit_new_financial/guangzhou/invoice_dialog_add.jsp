<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>
	
	<title>新建问卷详细信息</title>
	
	
	<base href="<%=basePath%>">		
		
	<s:include value="../../customer/guangzhou/header.jsp"/>
	
	<link href="./css/easyui.css" rel="stylesheet" type="text/css" charset="utf-8"/>
	<link href="./css/icon.css" rel="stylesheet" type="text/css" charset="utf-8"/>

	<link href="./css/unit_table.css"  rel="stylesheet" type="text/css" charset="utf-8"/><!-- unit的样式 -->	
	
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>
	<script type="text/javascript" language="javascript" src="<%=basePath%>css/local/easyui-lang-zh_CN.js"></script>
	
	<style type="text/css">
		*{margin:0;padding:0;}
		tr{line-height: 20px}
		td{padding: 2px 5px ;}
		input{width: auto;}
	</style>
	<script>
	function formsubmit (){
		document.getElementById("invoice_form").submit();
    }
	</script>
	</head>
<body>
<div class="gbox1" style="">		
<form action="./saleunit_financial_manager/guangzhou/invoiceAddDialogForm.action" id="invoice_form" method="post">	
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="font-size:12px; line-height:26px;background-color: #A9D9FF">
		<tr bgcolor="#ffffff">
			<td align="center" width="100px">发票号码</td>
			<td width="150px">
				<input name="selectInvoice.invoiceNo"/>
			</td>
			<td width="100px"></td>
			<td>
			</td>
		</tr>
		<tr bgcolor="#ffffff">
			<td align="center">金额</td>
			<td>
				<input name="selectInvoice.invoiceMoney"/>
			</td>
			<td align="center">日期</td>
			<td>
				<input name="selectInvoice.invoeceDate"  class="easyui-datebox"/>
			</td>
		</tr>
		<tr bgcolor="#ffffff">
			<td align="center">领票人</td>
			<td>
				<input name="selectInvoice.receiveMan"/>
			</td>
			<td align="center">领票日期</td>
			<td>
				<input name="selectInvoice.receiveDate"  class="easyui-datebox"/>
			</td>
		</tr>
		<tr bgcolor="#ffffff">
			<td align="center">办证领票人</td>
			<td>
				<input name="selectInvoice.receiveManDo"/>
			</td>
			<td align="center">办证领票日期</td>
			<td>
				<input name="selectInvoice.receiveDateDo"  class="easyui-datebox"/>
			</td>
		</tr>
		<tr bgcolor="#ffffff">
			<td colspan="4">备注</td>
		</tr>
		<tr bgcolor="#ffffff">
			<td colspan="4">
				<textarea rows="" cols="" style="width: 95%;height: 100%;font-size: 14px" name="selectInvoice.remark" ></textarea>
				<input type="hidden" name="id" value="${id}"/>
			</td>
		</tr>
	</table>
	</form>
</div>
</body>
</html>