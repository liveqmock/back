<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
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
	
	<script type="text/javascript" language="javascript" src="./js/change_project_at_title.js"></script><!-- 项目修改 -->	

	<script type="text/javascript" language="javascript">

		$(document).ready(function(){
		
			$("#left_tree").tree({
				animate:false,
				url:'./saleunit_new/appoint/guangzhou/layoutLeft.action',
				onClick:function(node){
					
					clickToLoadTable(node);
				},
				onLoadSuccess:function(node, data){
					
				}
			});
			
			$("#contract_customer_table").datagrid({
				title:'成交客户',
				loadMsg:'加载中...',
				pagination:true, 
				singleSelect:true,
				striped:true,
				fitColumns:true,
				toolbar:'#customer_tb',
				onDblClickRow:function(rowIndex, rowData){
					
					var query = objectToQuery(rowData, "contractCustomer.");
					new MyAjaxDivDialog({title:'查看客户', buttons: false, src:'./saleunit_new/contract/customer/getRowDataToShow.action?' + query, 
						width:500, height:200});
				},
				onLoadSuccess:function(data){			
					$("#contract_customer_table").datagrid("getPager").pagination({showPageList:false});
					var rows = $($("#contract_customer_table").datagrid("getPanel").find(".datagrid-body").last()).find("tr");
					$(rows).each(function(){
						$(this).attr("title", "双击查看详情");
					});
				}
				
			});
			
			$("#contract_customer_table").datagrid("getPager").pagination({showPageList:false});
			
			$("#confirm_type").combobox({
				editable:false				
			});
			
			$("#search").click(function(){
				
				var node = $("#left_tree").tree("getSelected");
				clickToLoadTable(node);
				
			});
			
			$("#save").click(function(){
				
				var node = $("#left_tree").tree("getSelected");
				
				if(node == null || node == undefined){
				
					myAlert("请先确定左边的树");
					return false;
				}
			
				var attr = node.attributes;
				if(attr != undefined){
					
					var type = attr.type;
					var id = attr.valId;						
					
					var confirm_type = $("#confirm_type").combobox("getValue");
					
					var queryParams = "type=" + type + "&id=" + id + "&confirmType=" + confirm_type;
					window.location.href = "./saleunit_new/contract/customer/download.action?" + queryParams;
					
				}
				
			});
			
		});

	</script>
	
	<script type="text/javascript" language="javascript">
		function clickToLoadTable(node){
		
			if(node == null || node == undefined){
				
				myAlert("请先确定左边的树");
				return false;
			}
		
			var attr = node.attributes;
			if(attr != undefined){
				
				var type = attr.type;
				var id = attr.valId;						
				
				var confirm_type = $("#confirm_type").combobox("getValue");
				
				$("#contract_customer_table").datagrid({
					url:'./saleunit_new/contract/customer/customerAjaxTable.action',
					queryParams:{'type':type,'id':id, 'confirmType':confirm_type}
				});
				
			}
			
		}
	</script>

	
  </head>
  
<body class="easyui-layout">	
	
	 <div region="west" split="true" 
	 	title='<s:select list="urList" listKey="projectId" listValue="descProjectId" name="selectProId" 
	 		cssStyle="vertical-align: middle;" onChange="change_project(this)" rhref="./saleunit_new/contract/customer/layout.action"></s:select>' 
		style="width:213px;padding:1px;">	
	 
		<ul id="left_tree" animate="false"></ul>
	</div>
		
	<div region="center" style="padding:0px;" id="_center">

		<table id="contract_customer_table" style="width:auto;height:370px;">  
				
			<thead>
				<tr>
					<!--
					<th field="modify" width="40">操作</th>
					-->
					<th field="id" hidden="true"></th>
					
					<th field="customerName" width="100px" align="center">客户姓名</th>
					<th field="phone" width="100px" align="center">电话号码</th>
					
					<th field="buildName" width="140px" align="center">楼栋</th> 					
	                <th field="unitNo" width="140px" align="center">房号</th> 					
	                <th field="buildArea" width="140px" align="center">建筑面积</th>
					<th field="sumMoney" width="100px" align="center">成交总价</th>
					
					<th field="agreeNo" width="100px" align="center">认购书/合同编号</th>
					<th field="workDate" width="100px" align="center">认购/合同日期</th>					
					
					<th field="gender" width="30px" align="center">性别</th>
					<th field="idcardType" width="80px" align="center">证件类型</th>
					<th field="idcardNo" width="150px" align="center">证件号码</th>

					<th field="address" width="300px" align="center">通信地址</th>
					
				</tr>
										
			</thead>
		</table>	
		
	</div>
	
	<div id="customer_tb">
	客户类型:
		<select id="confirm_type">
			<option value="confirm">认购</option>
			<option value="contract">合同</option>
			<!--
			<option value="confirm_book">临定</option>
			<option value="chip">认筹</option>			
			-->
		</select>
		<a href="javascript:void(0)" id="search" class="easyui-linkbutton" iconCls="icon-search">查找</a> 
		<a href="javascript:void(0)" id="save" class="easyui-linkbutton" iconCls="icon-save">导出</a> 
	</div>
	
</body>
		

</html>
