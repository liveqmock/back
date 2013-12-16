<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>
	
	<title>合同</title>

	<script type="text/javascript" language="javascript" src="<%=basePath%>js/jquery-1.6.2.min.js"></script>	
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>
	<link href="<%=basePath%>css/easyui.css" rel="stylesheet" type="text/css" charset="utf-8"/>
	<link href="<%=basePath%>css/icon.css" rel="stylesheet" type="text/css" charset="utf-8"/>
	
	<style type="text/css">
		*{margin:0;padding:0;}
	</style>
	<script>
			function tosubmit (){
				document.getElementById("new_customer_up").submit();
			}  
	</script>
	</head>
<body>
<div style="float: left;">
<form action="./saleunit_new/appoint/guangzhou/updateContractForm.action" method="post" id="new_customer_up">
		<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1"  style="font-size:12px; line-height:26px;background: #A9D9FF">
			<tr bgcolor="#ffffff" style="empty-cells:show"> 
			<td width="80px">客户姓名</td><td width="150px"><input  name="addCus.customerName"/></td>
				<td width="80px">性别</td><td width="150px">男<input  name="addCus.gender" type="radio" value="0"/> 女<input  name="addCus.gender" type="radio" value="1"/></td>
			</tr>
			
				<tr bgcolor="#ffffff" style="empty-cells:show">  
			<td>证件类型</td><td> 
				<select  name="addCus.idcardType">
					<option value="0">身份证</option>
					<option value="1">其他</option>
				</select>
			</td>
				<td>证件号码</td><td> <input  name="addCus.idcardNo"/></td>
			</tr>
				<tr bgcolor="#ffffff" style="empty-cells:show"> 
			<td>联系电话</td><td colspan="3"><input  name="addCus.phone"/> 
				<input type="hidden" value="${id}" name="id"/>
				
			</td>
			</tr> 
		</table>
		</form>
		</div>
		</body>
		</html>