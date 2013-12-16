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
<b>删除做法说明：</b>

<br/>

<p></p>
<b>参考：</b><br/>
js/easyui.utils.js中的deletePojo()<br/>

这里包括了删除的确认提示，以及对应的删除操作后的做法<br/>
可以参考用户列表中的删除操作:<a href='./user/manager/index.action' target="_blank">/user/manager/index.action</a><br/>

图片<br/>

<img src="<%= basePath%>/demo/easyui/images/delete_data_demo.jpg" width="300px"/>
<br/>
struts-user-manager.xml<br/>
采用的是ajax的删除提示做法<br/>
<p></p>
<b>主要代码说明：</b>
<br/>
<br/>
<b>代码示例：</b><br/>
<textarea rows="20" cols="150">

		<!-- 批量删除用户账户 -->
		<action name="delUsers" class="com.ihk.user.manager.UserAccountManagerAction" method="delUsers">
		</action>
		
	deletePojo('./saleunit_contract/manager/deleteOtherExpenses.action?otherId=' + otherId, searchOtherTabs, "");
	
	
	
					deletePojo("./saleunit_new/appoint/guangzhou/deleteContractCustomer.action?id=" + row.customerId, function(){
					
						//删除隐藏域的id
						var oldCustomerId = $("#customerId").val();
						var newCustomerId = oldCustomerId.replace(row.customerId + ",", "");
						$("#customerId").val(newCustomerId);
						
						//删除页面行
						var index = $('#' + datagridModuleId).datagrid('getRowIndex', row);
						$('#' + datagridModuleId).datagrid('deleteRow', index);
						
					}, "");
</textarea>
<br/>

</body>
</html>

