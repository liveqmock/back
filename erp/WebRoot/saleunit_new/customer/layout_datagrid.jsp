<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page import="com.ihk.constanttype.EnumDevFlag" %>
<%@ page import="com.ihk.constanttype.EnumPrivCode" %>
<%@ page import="com.ihk.permission.PermissionUtils" %>
<%@ page contentType="text/html; charset=utf-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
  <head>
	
	<title>成交客户</title>
	
	<base href="<%=basePath%>" />		
		
	<s:include value="../../customer/guangzhou/header.jsp"/>
	
	<link href="./css/easyui.css" rel="stylesheet" type="text/css" charset="utf-8"/>

	<script type="text/javascript" language="javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/easyui-lang-zh_CN.js"></script>	
	
	<script type="text/javascript" language="javascript" src="./js/easyui.utils.js"></script>
	
	<script language="javascript" type="text/javascript" src="./js/project.list.utils.js"></script>

	<script type="text/javascript" language="javascript">
	
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
			
			
			$("#save").click(function(){
				
				var query = $("#thisForm").serialize();
				
				window.location.href = "./saleunit_new/contract/customer/download.action?" + query;
				
			});
			
		});
	
		$(function(){		
			
			$("#contract_customer_table").datagrid({
				loadMsg:'加载中...',
				pagination:true, 
				rownumbers:true,
				singleSelect:true,
				striped:true,
				nowrap:true,
				fitColumns:false,
				pageSize:20,
				toolbar:'#customer_tb',
				onDblClickRow:function(rowIndex, rowData){
					
					var query = objectToQuery(rowData, "contractCustomer.");
					new MyAjaxDivDialog({title:'查看客户', buttons: false, src:'./saleunit_new/contract/customer/getRowDataToShow.action?' + query, 
						width:500, height:220});
				},
				onLoadSuccess:function(data){			
					//$("#contract_customer_table").datagrid("getPager").pagination({showPageList:false});
					var rows = $($("#contract_customer_table").datagrid("getPanel").find(".datagrid-body").last()).find("tr");
					$(rows).each(function(){
						$(this).attr("title", "双击查看详情");
					});
				}
				
			});
			
		});
		
		function ajaxSubmitSearch(){
		
			var query = $("#thisForm").serialize();
			
			$("#contract_customer_table").datagrid({
				url:'./saleunit_new/contract/customer/customerAjaxTable.action?' + query
			});
			
			/**
			$("#contract_customer_table").datagrid({
				url:'./saleunit_new/contract/customer/customerAjaxTable.action',
				queryParams:{'type':type,'id':id, 'confirmType':confirm_type}
			});
			*/
			
		}

	</script>

	
  </head>
  
<body style="padding:0px;background:white;">
		
	<form class="registerform" id="thisForm" method="post">
		
		<table id="contract_customer_table" style="width:auto;height:612px;">  
				
			<thead>
				<tr>
					<!--
					<th field="modify" width="40">操作</th>
					-->				
					
					<!--
					客户类型（不选默认是包括认购和合同），楼栋，房号，客户姓名，性别，证件类型，证件号码，通信地址，电话号码，认购书编号，合同编号，认购日期，合同日期，建筑面积，成交总价
					-->
					
					<th field="id" hidden="true"></th>
					
					<th field="projectName" width="80px" align="center">项目</th>
					<th field="confirmType" width="80px" align="center">客户类型</th> 
					<th field="area" width="80px" align="center">分区</th>
	            	<th field="buildName" width="140px" align="center">楼栋</th> 
					<th field="floor" width="80px" align="center">楼层</th>
	                <th field="unitNo" width="140px" align="center">房号</th> 					
	                <th field="buildArea" width="140px" align="center">建筑面积</th>
					<th field="insideArea" width="140px" align="center">套内面积</th>
					<th field="agreeNo" width="140px" align="center">成交/合同编号</th>
					<th field="payType" width="140px" align="center">付款方式</th> 	
					<th field="workDate" width="140px" align="center">成交/合同日期</th> 	
	                <th field="sumMoney" width="140px" align="center">成交总价</th> 
					
					<th field="customerName" width="140px" align="center">客户姓名</th>
					<th field="phone" width="140px" align="center">电话号码</th>
					<th field="homePhone" width="140px" align="center">固定电话</th>
					<th field="idcardType" width="140px" align="center">证件类型</th>
	                <th field="idcardNo" width="190px" align="center">证件号码</th>
	                <th field="gender" width="50px" align="center">性别</th> 
					<th field="address" width="240px" align="center">通信地址</th>
					<th field="household" width="140px" align="center">户籍</th>
					<th field="home" width="140px" align="center">居住区域</th>
					
					
				</tr>
										
			</thead>
		</table>	
		
		
			<div id="customer_tb" style="height: auto;padding: 5px">   
			
			   <label>&nbsp;<span>楼栋</span> </label>			 

				<input type="text" id="projectName" size="40" style="width:200px"/>
				<input type="hidden" id="hiddenId" name="id"/>
				<input type="hidden" id="hiddenType" name="type"/>
					
				<label>&nbsp;<span>成交/合同日期</span> </label>
				<input class="easyui-datebox" type="text" style="width:90px"
				name="contractCustomerCond.date1" value="${contractCustomerCond.date1}" /> - 
				<input class="easyui-datebox" type="text" style="width:90px"
				name="contractCustomerCond.date2" value="${contractCustomerCond.date2}" /> 
				
				<s:radio list="selConfirmType" name="contractCustomerCond.confirmType"/>				
				&nbsp;
				<a href="javascript:void(0)" onclick="return ajaxSubmitSearch()" class="easyui-linkbutton" iconCls="icon-search">查询</a>

                <%if(PermissionUtils.hasPermission(EnumPrivCode.REPORT_SALEUNIT_DOWNLOAD, EnumDevFlag.GUANGZHOU) ){%>
				<a href="javascript:void(0)" id="save" class="easyui-linkbutton" iconCls="icon-save">导出</a> 
                <%} %>
			</div> 			
	
		</form>
	    
	</body>
</html>