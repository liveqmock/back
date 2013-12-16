/**
 *  project_text,自定义下拉框的帮助类
 */

//初始化要使用的text弹出框,disabled指定是否可以编辑
function initProjectTextCombobox(moduleId, dialogTitle, disabled){
	
	if(disabled == "" || disabled == undefined){
		disabled = false;
	}
	
	//先预先生成一个div,用于弹出框
	var divId = initDivId(moduleId);
	var dataGridId = initDataGridId(moduleId);
	var div = "<div id='" + divId + "' closed='true'><table id='" + dataGridId + "' style='width:225px;height:240px' title='' "
		+ "iconCls='icon-edit' singleSelect='true' fitColumns='true'><thead><tr><th field='id' hidden='true' editor='text'>ID</th>"
		+ "<th field='code' width='220' fitColumns='true' align='left' editor='text'>名称</th></tr></thead></table></div>";
	$(document.body).find("#" + divId).remove();
	$(document.body).append(div);
	
	initDataGrid(moduleId); //加载页面就先把dialog中的datagrid表格初始化好
	initDialog(moduleId); //dialog默认为关闭的
	
	$("#" + moduleId).combobox({
		editable:false,
		disabled:disabled,
		onChange:function(newValue, oldValue){
					
			if(newValue == "__limit__"){
				
				if(getHiddenTypeNameValue(moduleId) == ""){					
					return false;
				}

				showDataGridDialog(moduleId, dialogTitle); //显示编辑dialog
				return false;
			}
			
		},
		onHidePanel:function(){
			
			if(getHiddenTypeNameValue(moduleId) == ""){
				//$("#" + moduleId).combobox("setText", "请选择");
				//$("#" + moduleId).combobox("setValue", "");
				$("#" + moduleId).combobox("select", "");
				return false;
			}			
		}
		
	 });
}

//批量初始化自定义下拉框,且对应的dialogTitle值为组件前面的内容,外部调用方法
function initProjectTextComboboxForAuto(moduleIds, feeDisabled){
	//var moduleIds = ["receiptAddress","payType","billType","recordedBank"];
	
	for(var i=0; i<moduleIds.length; i++){
		
		var moduleId = moduleIds[i];
		var dialogTitle = $("#" + moduleId).parent().prev().text();
		if(dialogTitle != ""){
			dialogTitle = $.trim(dialogTitle);
			var index = dialogTitle.indexOf("*");
			if(index > -1){
				dialogTitle = dialogTitle.substring(index+1, dialogTitle.length);
			}
		}
		
		initProjectTextCombobox(moduleId, dialogTitle, feeDisabled);
	}
}

//初始化datagrid表格中的值,兼容新的表结构,获取__text_type__及__main_id__
function initDataGrid(moduleId){
	
	var textType = $("#__text_type__").val();
	var mainId = $("#__main_id__").val();
	if(textType == undefined || isNaN(textType)){
		textType = "";
	}
	if(mainId == undefined || isNaN(mainId)){
		mainId = "";
	}
	
	var dataGridId = initDataGridId(moduleId);
	
	if($('#' + dataGridId).length > 0){
		//如果存在,就先销毁
		try{$('#' + dataGridId).datagrid('destroy');}catch(e){}		
	}	
	
	var editIndex = ""; //编辑的row索引
	
	$(function(){
			
		$('#' + dataGridId).datagrid({
			toolbar:[{
				text:'增加',
				iconCls:'icon-add',
				queryParams:{},
				handler:function(){

					$('#' + dataGridId).datagrid('endEdit', editIndex);
					$('#' + dataGridId).datagrid('appendRow',{
						id:'0',
						code:''
					});
					
					editIndex = $('#' + dataGridId).datagrid('getRows').length-1;
					$('#' + dataGridId).datagrid('selectRow', editIndex);
					$('#' + dataGridId).datagrid('beginEdit', editIndex);
				}
			},'-',{
				text:'删除',
				iconCls:'icon-remove',
				handler:function(){
					var row = $('#' + dataGridId).datagrid('getSelected');
					if (row){
					
						var index = $('#' + dataGridId).datagrid('getRowIndex', row);
						$('#' + dataGridId).datagrid('deleteRow', index);
						
						editIndex = "";
					}else{
						$.messager.defaults = { ok: "确定", cancel: "取消" };
						$.messager.alert("提示", "<center>请选择要删除的行</center>");
					}
				}
			},'-',{
				text:'保存',
				iconCls:'icon-save',
				handler:function(){
	
					$('#' + dataGridId).datagrid('endEdit', editIndex);
						
					var allLine = $('#' + dataGridId).datagrid('getRows');
					
					saveDataGrid(allLine, moduleId);					
				}
			}
			],
			loadMsg:"加载中...",
			url: "./saleunit_new/base/utils/getProjectTextListByTypeNameForDataGrid.action?typeName=" + getHiddenTypeNameValue(moduleId)
				+ "&textType=" + textType + "&mainId=" + mainId, //加载数据
			
			onClickRow:function(rowIndex){
			
				if(editIndex == ""){
					$('#' + dataGridId).datagrid('beginEdit', rowIndex);
				}else{
					$('#' + dataGridId).datagrid('endEdit', editIndex);
					$('#' + dataGridId).datagrid('beginEdit', rowIndex);
				}				
				editIndex = rowIndex;				
			}			
		});
	});
}

//保存新增的datagrid,兼容新的表结构,获取__text_type__及__main_id__
function saveDataGrid(allLine, moduleId){
	
	var textType = $("#__text_type__").val();
	var mainId = $("#__main_id__").val();
	if(textType == undefined || isNaN(textType)){
		textType = "";
	}
	if(mainId == undefined || isNaN(mainId)){
		mainId = "";
	}
	
	var formStr = "idCode=";
	var length = allLine.length;
	for(var index=0; index<length; index++){
		
		var id = $.trim(allLine[index].id);
		var code = $.trim(allLine[index].code);
		
		formStr += id + "|" + code + "_";		
	}
	
	formStr += "&typeName=" + getHiddenTypeNameValue(moduleId);
	
	$.ajax({
		type:"get",
		url: "./saleunit_new/base/utils/saveProjectText.action",
		data: formStr + "&textType=" + textType + "&mainId=" + mainId,
		dataType: "json",
		success: function(data){
			
			if(data.type == "true"){
				
				$("#" + initDivId(moduleId)).dialog('close');
			}else{
				$.messager.defaults = { ok: "确定", cancel: "取消" };
				$.messager.alert("提示", "<center>新增失败,请重试</center>");
			}
		}
		
	});
	
}

//显示dialog,并设置关闭事件(重新设置下拉框及新的datagrid表格的值)
function showDataGridDialog(moduleId, dialogTitle){
	
	initDataGrid(moduleId); //重新设置datagrid表格的值
	
	var dialogId = initDivId(moduleId);
	
	$('#' + dialogId).dialog('open');
	$('#' + dialogId).dialog('setTitle', dialogTitle);
	
}

//默认加载dialog的时候为关闭的,兼容新的表结构,获取__text_type__及__main_id__
function initDialog(moduleId){
	
	var textType = $("#__text_type__").val();
	var mainId = $("#__main_id__").val();
	if(textType == undefined || isNaN(textType)){
		textType = "";
	}
	if(mainId == undefined || isNaN(mainId)){
		mainId = "";
	}
	
	var dialogId = initDivId(moduleId);
	
	$("#" + dialogId).dialog({
		resizable: true,
		modal:true, //模态窗口,表示不能操作弹出框以外的内容
		maximizable: false, //显示最大化按钮
		width:250,
		height:280,
		onClose:function(){
			
			//重新设置下拉框			
			$("#" + moduleId).combobox("reload", "./saleunit_new/base/utils/getProjectTextListByTypeNameForComboBox.action?typeName=" + getHiddenTypeNameValue(moduleId)
				+ "&textType=" + textType + "&mainId=" + mainId); //加载数据	
			$("#" + moduleId).combobox("select", "");			
		}
		
	});
	
	//$('#' + dialogId).dialog('close');
	
}

//获取生成的dialog id
function initDivId(moduleId){
	return "__" + moduleId + "_dialog__";
}

//获取隐藏的typeName 的id
function initTypeNameId(moduleId){
	return  moduleId + "_typeName";
}

//获取隐藏的typeName的值
function getHiddenTypeNameValue(moduleId){
	return $("#" + moduleId + "_typeName").attr("value");
}

//设置隐藏的typeName的值
function setHiddenTypeNameValue(moduleId, value){
	$("#" + moduleId + "_typeName").attr("value", value);
}
			
//获取datagrid id
function initDataGridId(moduleId){
	return "__" + moduleId + "_dataGrid__";
}

////下面的方法是针对"收费类别"及"收款内容"的关联

//收费类别(格式:<s:select..></select>)及收费内容(格式:<pt:sel../>)的级联,typeId为类别id,feeId为内容id
function bindPayTypeByFee(typeId, feeId){
	
	initProjectTextComboboxForAuto([feeId], false);
	
	//收费类别如果有值,应该setHiddenTypeNameValue(feeId, data);给收费内容设置对应的typeName
	$("#" + typeId).combobox({
		editable:false,
		onChange:function(newValue, oldValue){
			
			setFeeIdByAjax(feeId, newValue, false);			
		},
		onLoadSuccess:function(){
			
			var payTypeValue = $("#" + typeId).combobox("getValue"); //获取收费类别下拉框的初始值
			setFeeIdByAjax(feeId, payTypeValue, true);
		}
	});
}

//设置收费类别及收款内容的级联,要判断收款内容是否可编辑,该function不通用,只是在"添加付款明细下"使用
function bindPayTypeByFeeEdit(typeId, feeId, feeDisabled, showFixedFeeTextId, textType, wayIdVal){
	
	initProjectTextComboboxForAuto([feeId], feeDisabled);
	
	//收费类别如果有值,应该setHiddenTypeNameValue(feeId, data);给收费内容设置对应的typeName
	$("#" + typeId).combobox({
		editable:false,
		onChange:function(newValue, oldValue){
			
			if(newValue == ""){
				//隐藏底下的"是否包含定金"或"取整方式"
				$("#isIncludeDepositTr").hide();
				$("#roundingTr").hide();
			}
			
			setFeeIdByAjaxByPayWayIdVal(feeId, newValue, false, wayIdVal); //设置收款内容的自定义
			showFixedFeeByType(typeId, feeId, showFixedFeeTextId); //显示对应收费类别的收款内容(固定)
		},
		onLoadSuccess:function(){
			
			var payTypeValue = $("#" + typeId).combobox("getValue"); //获取收费类别下拉框的初始值
			setFeeIdByAjaxByPayWayIdVal(feeId, payTypeValue, true, wayIdVal); //设置收款内容的自定义
			showFixedFeeByType(typeId, feeId, showFixedFeeTextId); //显示对应收费类别的收款内容(固定)
		}
	});
}

//显示对应收费类别的收款内容(固定)
function showFixedFeeByType(typeId, feeId, showFixedFeeTextId){
	
	var payTypeValue = $("#" + typeId).combobox("getValue");
	var feeValue = $("#" + feeId).combobox('getValue');
	$.ajax({
		type: "get",
		url: "./saleunit_financial_manager/guangzhou/getFixedFeeByType.action?payTypeValue=" + payTypeValue + "&feeValue=" + feeValue,
		dataType: "html",
		success: function(data){			
			$("#" + showFixedFeeTextId).html(data);			
		},
		error: function(XMLHttpRequest, textStatus, errorThrown){
			$.messager.defaults = { ok: "确定", cancel: "取消" };
			$.messager.alert("提示", "<center>请求出现异常</center>");
		}
		
	});		
	
}

//初始化或设置收款内容内容,isDefault判断是否设置旧的值为选中状态
function setFeeIdByAjax(feeId, payTypeValue, isDefault){
	
	$.ajax({
		type: "get",
		url: "./saleunit_financial_manager/guangzhou/payTypeValueToKey.action?payTypeValue=" + payTypeValue,
		dataType: "html",
		success: function(data){			
		
			setHiddenTypeNameValue(feeId, data);
			
			var url = "./saleunit_financial_manager/guangzhou/payTypeToFeeType.action?payTypeId=" + data;
			if(isDefault){
				url += "&default=" + $("#" + feeId).combobox('getValue');
				$("#" + feeId).combobox("reload", url);	
				//$("#" + feeId).combobox("select", "");  //放到reload方法中设置
			}else{
				$("#" + feeId).combobox("reload", url);	
				$("#" + feeId).combobox("select", "");  
			}
			
		},
		error: function(XMLHttpRequest, textStatus, errorThrown){
			$.messager.defaults = { ok: "确定", cancel: "取消" };
			$.messager.alert("提示", "<center>请求出现异常</center>");
		}
		
	});	
}

//根据付款方式id,初始化或设置收款内容内容,isDefault判断是否设置旧的值为选中状态
function setFeeIdByAjaxByPayWayIdVal(feeId, payTypeValue, isDefault, wayIdVal){
	
	$.ajax({
		type: "get",
		url: "./saleunit_financial_manager/guangzhou/payTypeValueToKey.action?payTypeValue=" + payTypeValue,
		dataType: "html",
		success: function(data){			
		
			setHiddenTypeNameValue(feeId, data);
			
			//根据收款类别及付款方式id设置,收款类别及收款内容的级联
			var url = "./saleunit_financial_manager/guangzhou/payTypeToFeeTypeAndWayId.action?payTypeId=" + data + "&wayId=" + wayIdVal;
			if(isDefault){
				url += "&default=" + $("#" + feeId).combobox('getValue');
				$("#" + feeId).combobox("reload", url);	
				//$("#" + feeId).combobox("select", "");  //放到reload方法中设置
			}else{
				$("#" + feeId).combobox("reload", url);	
				$("#" + feeId).combobox("select", "");  
			}
			
		},
		error: function(XMLHttpRequest, textStatus, errorThrown){
			$.messager.defaults = { ok: "确定", cancel: "取消" };
			$.messager.alert("提示", "<center>请求出现异常</center>");
		}
		
	});		
	
}