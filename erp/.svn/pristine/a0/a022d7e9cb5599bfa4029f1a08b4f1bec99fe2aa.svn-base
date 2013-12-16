<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>
	
	<title>新建合同</title>

	<s:include value="../../customer/guangzhou/header.jsp"></s:include>	  
	<style type="text/css">
		*{margin:0;padding:0;}
	</style>
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>
	<script type="text/javascript" language="javascript" src="<%=basePath%>css/local/easyui-lang-zh_CN.js"></script>
	<script>
			function dosubmit (){
				$("#this_form").submit();
			};

			$(document).ready(function(){
				$("#new_hander").keyup(function(){
					$(".new_hand").val($(this).val());
				});
			});
	</script>
	</head>
<body style="font-size: 12px">
<form action="./saleunit_new_contract_record/appoint/guangzhou/handChangeDialogForm.action" method="post" id="this_form">
<table style="background-color: #A9D9FF"  border="0" align="center" cellpadding="0" cellspacing="1" id="this_table" width="100%">
<tr style="background: #ffffff;;line-height: 24px" >
				
				<td width="30%"  align="center">变更持有人</td>
				<td width="60%" colspan="2"  align="left" ><input id="new_hander"/> </td>
			</tr>
			<tr style="background: #ffffff;;line-height: 24px" >
				
				<td  align="center">备注</td>
				<td colspan="2"   align="left" ><textarea rows="1" cols="15" name="handRemark"></textarea>
					<input value="${ids}" name="ids" type="hidden"/>
				 </td>
			</tr>
			
			
			<tr style="background: #eeeeee;;line-height: 24px" >
				<td   align="center">编号</td>
				<td  align="center" width="30%">原持有人</td>
				<td  align="center" >变更持有人</td>
			</tr>
			
			<s:iterator value="crtmpList" var="c">
				<tr style="background: #ffffff;;line-height: 24px" >
				<td  align="center">${c.contractNo}</td>
				<td  align="center">${c.handoverUser}</td>
				<td  align="left" > <input name="handMap.h${id}" class="new_hand"/></td>
			</tr>
			</s:iterator>
			
</table>
</form>

</body>
</html>