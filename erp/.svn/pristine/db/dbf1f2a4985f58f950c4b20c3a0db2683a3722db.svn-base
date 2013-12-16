/**
 * 有关合同客户的弹出框
 */

function MyContractCustomerDataGrid(options){
	
	// 默认值
    var myDefaults = { 	
		salesModuleId: "",
		unitIdVal: "",
		confirmType: "",
		customerModuleId: "",
		datagridModuleId: "",
		mainId: "",
		isChip:false
    };
    var options = $.extend(myDefaults, options);
	
	var salesModuleId = options.salesModuleId;
	var unitIdVal = options.unitIdVal;
	var confirmType = options.confirmType;
	var customerModuleId = options.customerModuleId;
	var datagridModuleId = options.datagridModuleId;
	var mainId = options.mainId;
	var isChip = options.isChip;
	
	var disabled = false;
	var url = "";
	if(!isNaN(mainId) && mainId > 0){		
		//disabled = true;
		
		if(!isNaN(confirmType) && confirmType > 0){
			url = "./saleunit_new/appoint/guangzhou/getContractCustomerJson.action?confirmType=" + confirmType + "&mainId=" + mainId;
		}		
	}
	
	$('#' + datagridModuleId).datagrid({
		toolbar:[{
			text:'新增客户',
			iconCls:'icon-add',
			disabled:disabled,
			handler:function(){
				
				addContractCustomer(salesModuleId, unitIdVal, confirmType, customerModuleId, datagridModuleId);
			}
		},'-',{
			text:'查看/修改客户',
			iconCls:'icon-edit',
			handler:function(){
				var row = $('#' + datagridModuleId).datagrid('getSelected');
				if (row){		
				
					if(isChip == "true"){
					
						
					}else{
						
						modifyContractCustomer(datagridModuleId, row, disabled);	
					}
								
				}else{
					myAlert("请选择要修改的客户");
				}
			}
		},'-',{
			text:'删除客户',
			iconCls:'icon-cancel',
			disabled:disabled,
			handler:function(){
				var row = $('#' + datagridModuleId).datagrid('getSelected');
				if (row){
				
					deletePojo("./saleunit_new/appoint/guangzhou/deleteContractCustomer.action?id=" + row.customerId, function(){
					
						//删除隐藏域的id
						var oldCustomerId = $("#customerId").val();
						var newCustomerId = oldCustomerId.replace(row.customerId + ",", "");
						$("#customerId").val(newCustomerId);
						
						//删除页面行
						var index = $('#' + datagridModuleId).datagrid('getRowIndex', row);
						$('#' + datagridModuleId).datagrid('deleteRow', index);
						
					}, "");
					
				}else{
					myAlert("请选择要删除的客户");
				}
			}
		}
		],				
		singleSelect:true,
		rownumbers:true,
		loadMsg:"加载中...",
		url: url,
		width:760,
		columns:[[  
			{field:'customerId', hidden:true},  
			{field:'customerName',title:'客户名称',width:280,align:'center'},  
			{field:'mobilePhone',title:'联系电话',width:280,align:'center'}  
		]],
		onLoadSuccess:function(data){
			//加载成功
			
			if(data != undefined && data != ""){
				
				var valArray = new Array();
				
				var rows = data.rows;				
				$(rows).each(function(index){
					valArray.push(rows[index].customerId);
				});
				
				$("#" + customerModuleId).val(valArray.join(",") + ",");
			}
		}
		
	});
	
}

//初始化datagrid,salesModuleId为销售人员组件id,unitIdVal为单元的值,confirmType为客户类型(对应ContConfirmType.java),
//customerModuleId为保存客户id值的组件id,datagridModuleId为选择客户的datagrid组件id,mainId为confirmType对应的表contract_customer中的main_id
function initContractCustomerDataGrid(salesModuleId, unitIdVal, confirmType, customerModuleId, datagridModuleId, mainId){
	
	new MyContractCustomerDataGrid({salesModuleId:salesModuleId, unitIdVal:unitIdVal, confirmType:confirmType, 
		customerModuleId:customerModuleId, datagridModuleId:datagridModuleId, mainId:mainId});
	
}

//要先判断是否选择了销售人员,及单元id,客户类型,
function addContractCustomer(salesModuleId, unitIdVal, confirmType, customerModuleId, datagridModuleId){

	var salesId = $("#" + salesModuleId).val();
	if(salesId == undefined || salesId == ""){
		myAlert("请先选择销售人员");
		return ;
	}
	
	if(unitIdVal == undefined || unitIdVal == ""){
		myAlert("请先确定单元");
		return ;
	}
	
	if(confirmType == undefined || confirmType == ""){
		myAlert("请先确定客户类型");
		return ;
	}			

	//先判断是否存在id为myContractCustomerIframeDialog的div,如果不存在就先新建,才能生成对应的弹出框
	if($("#myContractCustomerIframeDialog").length <= 0){
		//表示该div不存在,增加		
		var saleDiv = '<div id="myContractCustomerIframeDialog"><iframe scrolling="auto" frameborder="0" style="width:100%;height:100%;" ' + 
			'id="openContractCustomerIframe" src="./saleunit_new/guangzhou/loading.jsp"></iframe></div>';
			
		$(saleDiv).appendTo("body");		
	}			
	
	var height = 500;
	if(confirmType == "4"){
		height = 440;
	}
	
	$("#myContractCustomerIframeDialog").dialog({
		resizable: true,
		modal:true, //模态窗口,表示不能操作弹出框以外的内容
		maximizable: true, //显示最大化按钮
		width:500,
		height:height,
		onClose:function(){

			$('#openContractCustomerIframe').attr("src", "./saleunit_new/guangzhou/loading.jsp"); //清空内容
		},
		onBeforeClose:function(){
			
			var spanModule = $.currentIframeSuggSpan("myContractCustomerIframeDialog");
			
			var newCustomerId = spanModule.attr("customerId");					
			if(newCustomerId == undefined || undefined == ""){
				return ;
			}
			
			var oldCustomerId = $("#" + customerModuleId).val();
			$("#" + customerModuleId).val(oldCustomerId + newCustomerId + ",");
			
			$("#" + datagridModuleId).datagrid('appendRow',{
				customerId: spanModule.attr("customerId"),
				customerName: "" + spanModule.attr("customerName") + "",
				mobilePhone: spanModule.attr("mobilePhone")			
			});
			
		},
		buttons:[				 
		{
			text:'提交',
			iconCls:'icon-ok',
			handler:function(){
				
				var ids = ["mobilePhone:phone", "customerName", "idcardType:combobox", "idcardNo", "address"];
				dialogCurrentIframeAjaxSubmit("myContractCustomerIframeDialog", "openContractCustomerIframe", ids, "contractCustomerFormId", this);
								
			}
		},
		{
			text:'关闭',
			iconCls:'icon-cancel',
			handler:function(){
				$('#myContractCustomerIframeDialog').dialog('close');
			}
		}]
	});
		
	$('#myContractCustomerIframeDialog').dialog('open');
	$('#myContractCustomerIframeDialog').dialog('setTitle', '新增客户');

	$('#openContractCustomerIframe')[0].src = './saleunit_new/appoint/guangzhou/toAddContractCustomer.action?confirmType=' + confirmType 
		+ "&unitId=" + unitIdVal + "&salesId=" + salesId;
	
	return false;
}

/*
 *修改客户
 *disabled为true表示查看,隐藏提交按钮,false不隐藏
 */
function modifyContractCustomer(datagridModuleId, row, disabled){
	
	//先判断是否存在id为myContractCustomerIframeDialog的div,如果不存在就先新建,才能生成对应的弹出框
	if($("#myContractCustomerIframeDialog").length <= 0){
		//表示该div不存在,增加		
		var saleDiv = '<div id="myContractCustomerIframeDialog"><iframe scrolling="auto" frameborder="0" style="width:100%;height:100%;" ' + 
			'id="openContractCustomerIframe" src="./saleunit_new/guangzhou/loading.jsp"></iframe></div>';
			
		$(saleDiv).appendTo("body");		
	}			
	
	var bt = [{
		text:'提交',
		iconCls:'icon-ok',
		handler:function(){
			
			var ids = ["mobilePhone:phone", "customerName", "idcardType:combobox", "idcardNo", "address"];
			dialogCurrentIframeAjaxSubmit("myContractCustomerIframeDialog", "openContractCustomerIframe", ids, "contractCustomerFormId", this);
							
		}
	},
	{
		text:'关闭',
		iconCls:'icon-cancel',
		handler:function(){
			$('#myContractCustomerIframeDialog').dialog('close');
		}
	}]; 
	
	if(disabled == true){
		bt = [];
	}
	
	$("#myContractCustomerIframeDialog").dialog({
		resizable: true,
		modal:true, //模态窗口,表示不能操作弹出框以外的内容
		maximizable: true, //显示最大化按钮
		width:500,
		height:500,
		onClose:function(){

			$('#openContractCustomerIframe').attr("src", "./saleunit_new/guangzhou/loading.jsp"); //清空内容
		},
		onBeforeClose:function(){
			
			var spanModule = $.currentIframeSuggSpan("myContractCustomerIframeDialog");
			
			var newCustomerId = spanModule.attr("customerId");					
			if(newCustomerId == undefined || undefined == ""){
				return ;
			}
			
			var index = $('#' + datagridModuleId).datagrid('getRowIndex', row);
			$("#" + datagridModuleId).datagrid('updateRow',{
				index: index,
				row:{
					customerId: spanModule.attr("customerId"),
					customerName: "" + spanModule.attr("customerName") + "",
					mobilePhone: spanModule.attr("mobilePhone")			
				}					
			});
			
			var spanModule = $.currentIframeSuggSpan("myContractCustomerIframeDialog");
			
			
			var rows = $("#" + datagridModuleId).datagrid('getRows');
			
			var s='';
			for(var i=0;i<rows.length;i++){
				s=s+rows[i].customerId+',';
			}
			$('#customerId').attr('value',s);
		},
		buttons: bt
	});
		
	$('#myContractCustomerIframeDialog').dialog('open');
	//$('#myContractCustomerIframeDialog').dialog('setTitle', '修改客户');
	var oldCustomerId=$('#oldCustomerId').val();
	if(disabled == false){
		$('#myContractCustomerIframeDialog').dialog('setTitle', '修改客户');
		$('#openContractCustomerIframe')[0].src = './saleunit_new/appoint/guangzhou/toModifyContractCustomer.action?customerId=' + row.customerId+'&oldCustomerId='+oldCustomerId;
	}else{
		$('#myContractCustomerIframeDialog').dialog('setTitle', '查看客户');
		$('#openContractCustomerIframe')[0].src = './saleunit_new/appoint/guangzhou/toModifyContractCustomerReadOnly.action?customerId=' + row.customerId+'&oldCustomerId='+oldCustomerId;
	}
	
	
	return false;
}




function initOldContractCustomerDataGrid(salesModuleId, unitIdVal, confirmType, customerModuleId, datagridModuleId, mainId){
	var disabled = true;
	var url = "";
	if(!isNaN(mainId) && mainId > 0){		
		//disabled = true;
		var customer = $('#'+ customerModuleId).attr('value');
		if(!isNaN(confirmType) && confirmType > 0){
			url = "./saleunit_new/appoint/guangzhou/getOldContractCustomerJson.action?confirmType=" + confirmType + "&customerModuleId=" + customer;
		}		
	}
	
	$('#' + datagridModuleId).datagrid({
		toolbar:[{
			text:'新增客户',
			iconCls:'icon-add',
			disabled:disabled,
			handler:function(){
				
				addContractCustomer(salesModuleId, unitIdVal, confirmType, customerModuleId, datagridModuleId);
			}
		},'-',{
			text:'查看/修改客户',
			iconCls:'icon-edit',
			handler:function(){
				var row = $('#' + datagridModuleId).datagrid('getSelected');
				if (row){		
					
					modifyContractCustomer(datagridModuleId, row, disabled);				
				}else{
					myAlert("请选择要修改的客户");
				}
			}
		},'-',{
			text:'删除客户',
			iconCls:'icon-cancel',
			disabled:disabled,
			handler:function(){
				var row = $('#' + datagridModuleId).datagrid('getSelected');
				if (row){
				
					deletePojo("./saleunit_new/appoint/guangzhou/deleteContractCustomer.action?id=" + row.customerId, function(){
					
						//删除隐藏域的id
						var oldCustomerId = $("#customerId").val();
						var newCustomerId = oldCustomerId.replace(row.customerId + ",", "");
						$("#customerId").val(newCustomerId);
						
						//删除页面行
						var index = $('#' + datagridModuleId).datagrid('getRowIndex', row);
						$('#' + datagridModuleId).datagrid('deleteRow', index);
						
					}, "");
					
				}else{
					myAlert("请选择要删除的客户");
				}
			}
		}
		],				
		singleSelect:true,
		rownumbers:true,
		loadMsg:"加载中...",
		url: url,
		columns:[[  
			{field:'customerId', hidden:true},  
			{field:'customerName',title:'客户名称',width:280,align:'center'},  
			{field:'mobilePhone',title:'联系电话',width:280,align:'center'}  
		]],
		onLoadSuccess:function(data){
			//加载成功
			
			if(data != undefined && data != ""){
				
				var valArray = new Array();
				
				var rows = data.rows;				
				$(rows).each(function(index){
					valArray.push(rows[index].customerId);
				});
				
				//$("#" + customerModuleId).val(valArray.join(",") + ",");
			}
		}
		
	});
}



function initContractCustomerDataGridNewRename(salesModuleId, unitIdVal, confirmType, customerModuleId, datagridModuleId, mainId){
	var disabled = false;
	var url = "";
	if(!isNaN(mainId) && mainId > 0){		
		//disabled = true;
		
		if(!isNaN(confirmType) && confirmType > 0){
			url = "./saleunit_new/appoint/guangzhou/getContractCustomerJson.action?confirmType=" + confirmType + "&mainId=" + mainId;
		}		
	}
	
	$('#' + datagridModuleId).datagrid({
		toolbar:[{
			text:'新增客户',
			iconCls:'icon-add',
			disabled:disabled,
			handler:function(){
				
				addContractCustomer(salesModuleId, unitIdVal, confirmType, customerModuleId, datagridModuleId);
			}
		},'-',{
			text:'查看/修改客户',
			iconCls:'icon-edit',
			handler:function(){
				var row = $('#' + datagridModuleId).datagrid('getSelected');
				if (row){		
					
					modifyContractCustomer(datagridModuleId, row, disabled);				
				}else{
					myAlert("请选择要修改的客户");
				}
			}
		},'-',{
			text:'删除客户',
			iconCls:'icon-remove',
			disabled:disabled,
			handler:function(){
				var row = $('#' + datagridModuleId).datagrid('getSelected');
				if (row){
				
					deletePojo("./saleunit_new/appoint/guangzhou/deleteContractCustomer.action?id=" + row.customerId, function(){
					
						//删除隐藏域的id
						var oldCustomerId = $("#customerId").val();
						var newCustomerId = oldCustomerId.replace(row.customerId + ",", "");
						$("#customerId").val(newCustomerId);
						
						//删除页面行
						var index = $('#' + datagridModuleId).datagrid('getRowIndex', row);
						$('#' + datagridModuleId).datagrid('deleteRow', index);
						
					}, "");
					
				}else{
					myAlert("请选择要删除的客户");
				}
			}
		}
		],				
		singleSelect:true,
		rownumbers:true,
		loadMsg:"加载中...",
		url: url,
		columns:[[  
			{field:'customerId', hidden:true},  
			{field:'customerName',title:'客户名称',width:280,align:'center'},  
			{field:'mobilePhone',title:'联系电话',width:280,align:'center'}  
		]],
		onLoadSuccess:function(data){
			//加载成功
			
			if(data != undefined && data != ""){
				
				var valArray = new Array();
				
				var rows = data.rows;				
				$(rows).each(function(index){
					valArray.push(rows[index].customerId);
				});
				
				$("#" + customerModuleId).val(valArray.join(",") + ",");
			}
		}
		
	});
}