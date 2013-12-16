<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>
		
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
				},'-',{
					text:'保存(增加或删除都要保存)',
					iconCls:'icon-save',
					handler:function(){
						formSubmit();
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
		
		
	</script>
	
	<style type="text/css">
		*{margin:0;padding:0;}
		body{font-size:75%}
		
	</style>
	
</head>

<body>

<table id="detail_table" style="width:800;height:auto" title="" idField="typeId" iconCls="icon-edit" singleSelect="true">
	<thead>
		<tr>
			<th field="typeId" width="100" formatter="typeFormatter" editor="{type:'combobox',options:{valueField:'typeId',textField:'name',data:types}}">类型</th>
			<th field="percent" width="100" editor="text">折扣</th>
			<th field="remark" width="550" align="left" editor="text">说明</th>					
		</tr>
	</thead>
</table>

</body>
</html>
