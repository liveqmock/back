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
		
	<script type="text/javascript" language="javascript" src="./js/saleunit_new_discount.js"></script>
	<script type="text/javascript" language="javascript" src="./js/easyui.utils.js"></script>
	
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
			
			$("#createDiscountManagerFormId").submit();
			
			return true;						

		}
		
		function loadClose(){
		
			var unitDiscountId = '${unitDiscountId}';
			
			if(unitDiscountId != "" && unitDiscountId != "0"){
				window.setTimeout(function(){window.parent.closeDiscount(unitDiscountId);}, 1000);				
			}
			
		}
		
		function getHistory(){
		
			var histroyDiscountId = $("#histroyDiscountId").val();
			var hiddenUnitId = $("#hiddenUnitId").attr("value");
			var mainId = $("#mainId").attr("value");
			var confirmType = $("#confirmType").attr("value");
			
			if(histroyDiscountId == "" || histroyDiscountId == "0"){
			
				myAlert("请选择要应用的历史折扣");
				return false;
			}else{
			
				window.location.href = "./saleunit_new/appoint/guangzhou/applyHistoryDiscountManager.action?histroyDiscountId=" 
					+ histroyDiscountId + "&unitId=" + hiddenUnitId + "&mainId=" + mainId + "&confirmType=" + confirmType;
				return true;
			}
		
			//$('#detail_table').datagrid('reload', {"url":"./saleunit_new/appoint/guangzhou/createDiscountDialog.action?histroyDiscountId=" + histroyDiscountId});
			
			//var queryParams = $("#detail_table").datagrid('options').queryParams;
			//queryParams.histroyDiscountId = histroyDiscountId;
			//$('#detail_table').datagrid('options').queryParams = queryParams;
			//$("#detail_table").datagrid('reload');  
			
		}
		
	</script>
	
	<style type="text/css">
		*{margin:0;padding:0;}
		body{font-size:75%}
	</style>
	
</head>

<body onload="loadClose()">

<form action="./saleunit_new/appoint/guangzhou/createDiscountManager.action" method="post" id="createDiscountManagerFormId">

<div class="gbox1">			
			  
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="font-size:12px; line-height:26px; white-space:nowrap">
		  
		 
		 	   <tr bgcolor="#E9F5FF" style="empty-cells:show">
				
				<td colspan="3">
					<s:radio list="selComputeWay" name="unitDiscount.computeWay" id="computeWayId"/> 
				</td>
			  </tr>

              <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right">附加价&nbsp;</td>
                <td id="t16" style="" colspan="2">	
				
					<table style="width:100%; white-space:nowrap">
						<tr>
						<!--
							<td style="text-align:right">单价(+)</td>
							<td><input style="width:80px" type="text" name="unitDiscount.addUnitPrice" value="${unitDiscount.addUnitPrice}" /></td>
						-->
							<td style="text-align:right">总价(+)</td>
							<td><input style="width:80px" type="text" name="unitDiscount.addSumPrice" value="${unitDiscount.addSumPrice}" /></td>
							<td style="text-align:right">优惠减价</td>
							<td><input style="width:80px" type="text" name="unitDiscount.reduceSumPrice" value="${unitDiscount.reduceSumPrice}" /></td>
						</tr>
					</table>
					
				</td>
				
				<!--
                <td id="t16" style="width:25%">
					<input type="button" value="  计算折后价  " />
				</td>
				-->
              </tr>			
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right">附加价原因&nbsp;</td>
                <td id="t16" colspan="2"><input type="text" name="unitDiscount.discountDesc" style="width:80%" value="${unitDiscount.discountDesc}"/></td>
              </tr>					  
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right">折扣批准人&nbsp;</td>
                <td id="t16" style="width:100px" >
					<input name="unitDiscount.discountMan" type="text" value="${unitDiscount.discountMan}"/>
				</td>
            	<td><font color="#FF0000"><span id="uploadSuggestion">${suggestion}</span></font></td>    			
              </tr>		
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right">历史折扣&nbsp;</td>
                <td id="t16" style="width:100px" >
					<s:select list="selHistroyDiscount" id="histroyDiscountId" name="selectUnitDiscountId"></s:select>
					
				</td>
            	<td><input type="button" value="  选择  " id="getHistoryId" onclick="return getHistory()"/></td>    			
              </tr>		
			  
			 
			  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show" align="center">
				
				<td colspan="3" width="100%" height="100%">
					<input type="hidden" name="someDetail" id="someDetail"/>
					<input type="hidden" id="confirmType" name="unitDiscount.confirmType" value="${confirmType}" />
					<input type="hidden" id="mainId" name="unitDiscount.mainId" value="${mainId}" />
					<input type="hidden" id="hiddenUnitId" name="unitDiscount.unitId" value="${unit.id}" />
					<input type="hidden" name="unitDiscount.buildId" value="${unit.buildId}" />
					
				</td>
				
              </tr>		
			  
    </table>

	
</div>

<table id="detail_table" style="width:600;height:auto" title="" idField="typeId" iconCls="icon-edit" singleSelect="true">
	<thead>
		<tr>
			<th field="typeId" width="100" formatter="typeFormatter" editor="{type:'combobox',options:{valueField:'typeId',textField:'name',data:types}}">类型</th>
			<th field="percent" width="100" editor="text">折扣</th>
			<th field="remark" width="350" align="left" editor="text">说明</th>					
		</tr>
	</thead>
</table>

</form>	

</body>
</html>
