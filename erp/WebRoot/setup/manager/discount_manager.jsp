<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>
	
	<title>折扣管理</title>
	
	<s:include value="../../customer/guangzhou/header_min.jsp"></s:include>	  
	
	<script type="text/javascript" language="javascript" src="./js/jquery.easyui.min.js"></script>
	<link href="./css/easyui.css" rel="stylesheet" type="text/css" charset="utf-8"/>
	<link href="./css/icon.css" rel="stylesheet" type="text/css" charset="utf-8"/>

	<script type="text/javascript" language="javascript" src="./js/easyui.utils.js"></script>
	<script type="text/javascript" language="javascript" src="./js/saleunit_new_common_min.js"></script>
	
	<script type="text/javascript" language="javascript">
		
		$(document).ready(function(){
		
			closeIframeDialog("myIframeDialog", "${closeMark}", "", "${suggestion}");
		});
	</script>
	
	<script type="text/javascript" language="javascript">
	
		var types = ${types};
		var editIndex = ""; //编辑的row索引
		
		function typeFormatter(value){
			for(var i=0; i<types.length; i++){
				if (types[i].typeId == value) return types[i].name;
			}
			return value;
		}
		
		$(function(){
			
			$('#detail_table').datagrid({
				toolbar:[{
					text:'增加折扣',
					iconCls:'icon-add',
					//url:'./saleunit_new/appoint/guangzhou/createDiscountDialog.action',
					queryParams:{},
					handler:function(){
						//$('#detail_table').datagrid('endEdit', lastIndex);
						$('#detail_table').datagrid('endEdit', editIndex);
						$('#detail_table').datagrid('appendRow',{
							typeId:'',
							percent:'',
							remark:''
						});
						//lastIndex = $('#detail_table').datagrid('getRows').length-1;
						
						editIndex = $('#detail_table').datagrid('getRows').length-1;
						$('#detail_table').datagrid('selectRow', editIndex);
						$('#detail_table').datagrid('beginEdit', editIndex);
					}
				},'-',{
					text:'删除折扣',
					iconCls:'icon-remove',
					handler:function(){
						var row = $('#detail_table').datagrid('getSelected');
						if (row){
						
							var index = $('#detail_table').datagrid('getRowIndex', row);
							$('#detail_table').datagrid('deleteRow', index);
							
							editIndex = "";
						}else{
							myAlert("请选择要删除的行");
						}
					}
				}
				],
				loadMsg:"加载中...",
				url: "${url}",
				
				onClickRow:function(rowIndex){
				
					if(editIndex == ""){
						$('#detail_table').datagrid('beginEdit', rowIndex);
					}else{
						$('#detail_table').datagrid('endEdit', editIndex);
						$('#detail_table').datagrid('beginEdit', rowIndex);
					}
					editIndex = rowIndex;
					
				}
				
			});
		});
		
		function formSubmit(){
			
			$('#detail_table').datagrid('endEdit', editIndex);
		
			var allLine = $('#detail_table').datagrid('getRows');
			
			var formStr = "";
			
			var length = allLine.length;
			for(var index=0; index<length; index++){
				
				var typeId = $.trim(allLine[index].typeId);
				var percent = $.trim(allLine[index].percent);
				var remark = $.trim(allLine[index].remark);
				
				formStr += "typeId" + (parseInt(index)+1) + "=" + typeId + "&" 
						+ "percent" + (parseInt(index)+1) + "=" + percent + "&" 
						+ "remark" + (parseInt(index)+1) + "=" + remark + "&";
			}
			
			formStr += "detailCount=" + length;
			
			$("#someDetail").attr("value" , formStr);
			
			$("#discountModify").submit();
			
			return true;						

		}
		
		
	</script>
	
	<style type="text/css">
		*{margin:0;padding:0;}
		body{font-size:75%}
		
	</style>
	
</head>

<body>

<form action="./saleunit_setup/payway/discountModify.action" method="post" id="discountModify">

<table id="detail_table" style="width:600;height:auto" title="" idField="typeId" iconCls="icon-edit" singleSelect="true">
	<thead>
		<tr>
			<th field="typeId" width="100" formatter="typeFormatter" 
            	editor="{type:'combobox',options:{valueField:'typeId',textField:'name',data:types,editable:false}}">类型</th>
			<th field="percent" width="100" editor="text">折扣(%)</th>
			<th field="remark" width="350" align="left" editor="text">说明</th>					
		</tr>
	</thead>
</table>

<input type="hidden" name="someDetail" id="someDetail"/>
<input type="hidden" name="payWayId" id="payWayId" value="${payWayId}"/>

</form>	


</body>
</html>
