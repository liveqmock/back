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
<b>楼盘项目，分区，楼栋级联下拉框说明：</b>

<br/>

<p></p>
<p><b>参考：</b></p>
楼盘项目单选<br/>
<a href="./saleunit_new/contract/customer/layoutDataGrid.action" target="_blank">./saleunit_new/contract/customer/layoutDataGrid.action</a>
<br/>

<p>struts-saleunit-contract-manager.xml</p>
<p>&lt;action name=&quot;layoutDataGrid&quot; class=&quot;com.ihk.saleunit.action.contract_customer.SearchAction&quot; method=&quot;layoutDataGrid&quot;&gt;<br />
&lt;result name=&quot;layoutDataGrid&quot;&gt;/saleunit_new/customer/layout_datagrid.jsp&lt;/result&gt;<br />
&lt;/action&gt;</p>
<p></p>
<b>主要代码说明：</b>
<br/>
<br/>
<b>代码示例：</b>
<textarea rows="30" cols="150">

		$().ready(function() {
		
	        //bindProjectDialogForXKZX("projectName", "hiddenId"); //多个项目的选择	       
			
			var id = "projectName";
			
			$("#" + id).combotree({
				url: "./saleunit/common/modifyCompanyPropertyProjectAreaBuildAjax.action",
				onChange:function(newValue, oldValue){
					//newValue为新选中的值
	
					//$("#hiddenId").val(newValue);					

					var typeAndId = newValue.split("_");
					var type = typeAndId[0];
					var id = typeAndId[1];
					
					$("#hiddenType").val(type);
					$("#hiddenId").val(id);
					
				},
				onBeforeSelect:function(node){
					
				},
				onLoadSuccess:function(node, data){
				
					var module = $("#" + id).combotree('textbox');
					$(module).bind('focus', function(){
						$("#" + id).combotree('showPanel');	
					});			
				},
				onHidePanel:function(){
					var module = $("#" + id).combotree('textbox');
					$(module).blur();
				}
			});
</textarea>
<br/>

</body>
</html>

