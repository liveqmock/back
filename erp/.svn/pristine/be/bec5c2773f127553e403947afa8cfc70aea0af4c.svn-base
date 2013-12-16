<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>
	
	<title>客户服务事件</title>
	
	<s:include value="../../customer/guangzhou/header_min.jsp"></s:include>	  
	
	<link href="./css/unit_table.css"  rel="stylesheet" type="text/css" charset="utf-8"/><!-- unit的样式 -->
	
	<script type="text/javascript" language="javascript" src="./js/customer_common.js"></script>
	<script type="text/javascript" language="javascript" src="./js/customer_guangzhou_project.js"></script>
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/customer_guangzhou_user.js"></script>	 
	
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/unit_table.js"></script>	<!-- unit table -->
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/unit_infomation.js"></script>	
	
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>
	<script type="text/javascript" language="javascript" src="<%=basePath%>css/local/easyui-lang-zh_CN.js"></script>
	<link href="./css/easyui.css" rel="stylesheet" type="text/css" charset="utf-8"/>
	<link href="./css/icon.css" rel="stylesheet" type="text/css" charset="utf-8"/>
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/saleunit_new_unit_info.js"></script>
	<style type="text/css">
		*{margin:0;padding:0;}
		body{font-size:75%}
	</style>
	<script type="text/javascript" language="javascript">
		$.ready(function(){
			
		})
		
		function formsubmit (){
			document.getElementById("addForm").submit();				
		};
	</script>	
</head>
<body>

<div class="gbox1">			
<form id="addForm" action="./saleunit_new/appoint/guangzhou/customerEventDialogForm.action" method="post">
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="font-size:12px; line-height:26px">		
		 	   <tr bgcolor="#E9F5FF" style="empty-cells:show">
				<td align="center"><b>客户事件记录</b>&nbsp;
					<input type="hidden" value="${buildId }" name="buildId"/>
				</td><td id="t16" style="width:70%"></td>
			  </tr>
			  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
				<td id="t15" style="width:30%" align="center"><font color="#FF0000">*</font>客户ID</td>
				<td id="t16" style="width:70%">&nbsp;&nbsp;<input type="text" id="createCustomerEvent_customerId" name="createCustomerEvent.customerId" required="required"  style="width:90px" class="easyui-numberbox" data-options="min:0,precision:0"/></td>
				</tr>
				<tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
				<td id="t15" style="width:30%" align="center"><font color="#FF0000">*</font>单元ID</td>
				<td id="t16" style="width:70%">&nbsp;&nbsp;<input type="text" id="createCustomerEvent_unitId" name="createCustomerEvent.unitId" required="required"  style="width:90px" class="easyui-numberbox" data-options="min:0,precision:0"/></td>
				</tr>
				<tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
				<td id="t15" style="width:30%" align="center"><font color="#FF0000">*</font>客户要求</td>
				<td id="t16" style="width:70%">&nbsp;&nbsp;<input type="text" id="createCustomerEvent_customerOpinion" name="createCustomerEvent.customerOpinion" required="required"  style="width:90px" /></td>
				</tr>
				<tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
				<td id="t15" style="width:30%" align="center"><font color="#FF0000">*</font>销售人员</td>
				<td id="t16" style="width:70%">&nbsp;&nbsp;<input type="text" id="createCustomerEvent_salesName" name="createCustomerEvent.salesName" required="required"  style="width:90px" /></td>
				</tr>
				<tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
				<td id="t15" style="width:30%" align="center"><font color="#FF0000">*</font>记录时间</td>
				<td id="t16" style="width:70%">&nbsp;&nbsp;<input type="text" id="createCustomerEvent_startTime" name="createCustomerEvent.startTime" required="required"  style="width:90px" class="easyui-datebox"/></td>
				</tr>
				<tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
				<td id="t15" style="width:30%" align="center"><font color="#FF0000">*</font>解决时间</td>
				<td id="t16" style="width:70%">&nbsp;&nbsp;<input type="text" id="createCustomerEvent_finishTime" name="createCustomerEvent.finishTime" required="required"  style="width:90px" class="easyui-datebox"/></td>
				</tr>
				<tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
				<td id="t15" style="width:30%" align="center"><font color="#FF0000">*</font>解决方法</td>
				<td id="t16" style="width:70%">&nbsp;&nbsp;<input type="text" id="createCustomerEvent_finishWay" name="createCustomerEvent.finishWay" required="required"  style="width:90px" /></td>
				</tr>
				<tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
				<td id="t15" style="width:30%" align="center"><font color="#FF0000">*</font>备注</td>
				<td id="t16" style="width:70%">&nbsp;&nbsp;<input type="text" id="createCustomerEvent_remark" name="createCustomerEvent.remark" required="required"  style="width:90px" /></td>
				</tr>
	</table>
</form>	
</div>

</body>
</html>
