/**
 * 合同管理
 */
 
//合同管理,选择的tree是楼栋及选择的tabs为合同管理才查询相关的信息
function treeToContractManager(){
	
	var node = $("#left_tree").tree("getSelected");
	var selectdTab = $("#sale_tabs").tabs("getSelected");	
	
	if(node == null)
		return ;
		
	if(selectdTab == null)
		return ;
		
	var title = selectdTab.panel('options').title;
	
	if(title == '合同管理'){
		
		var attr = node.attributes;
		if(attr != undefined){
			
			var type = attr.type;
			var id = attr.valId;
			
			$("#_contract_manager").load("./saleunit_new_init/appoint/guangzhou/contractManager.action?type=" + type + "&id=" + id);
			
		}else{
			
			$("#_contract_manager").html("楼盘项目分区楼栋结构获取出现问题.");
		}		
		
	}
	
}

//ajax增加
function addAjaxContractManager(){
	
	var node = $("#left_tree").tree("getSelected");
	if(node == null){
		
		myAlert("请选确定项目,分区或楼栋");
		return false;
	}
	
	var attr = node.attributes;
	if(attr == undefined || attr == null){
		
		myAlert("选定的值有问题,请重试");
		return false;
	}
	
	var type = attr.type; //类型
	var id = attr.valId; //具体的id值
	
	new MyAjaxDivDialog({title:'新增楼盘合同', formId:'contractManagerFormId', 
		ids:['contractNo', 'startDate:datebox', 'defaultCommission:number'],
		width:800, height:600,
		src:'./saleunit_new_init/appoint/guangzhou/toAjaxAddContractManager.action?type=' + type + "&id=" + id, 
		closeFn:treeToContractManager});
}

//增加(废弃)
function addContractManager(){
	
	var node = $("#left_tree").tree("getSelected");
	if(node == null){
		
		myAlert("先选定楼栋");
		return false;
	}
	
	var attr = node.attributes;
	if(attr == undefined || attr == null || attr.type != "endNode"){
		
		myAlert("选定的楼栋有问题");
		return false;
	}
	
	new MyAjaxDivDialog({title:'新增楼盘合同', formId:'contractManagerFormId',
		src:'./saleunit_new_init/appoint/guangzhou/toAddContractManager.action', closeFn:treeToContractManager});	
	
}

//查看
function showContractManager(){
	
	var contractManagerId = $(".exChangetd").attr("contractManagerId");
	if(contractManagerId == '0' || contractManagerId == undefined || contractManagerId == ""){
		
		myAlert("请先选择要操作的内容");
		return false;
	}
	
	new MyAjaxDivDialog({title:'查看楼盘合同', 
		width:800, height:600,
		src:'./saleunit_new_init/appoint/guangzhou/showContractManager.action?isShow=true&id=' + contractManagerId, buttons:false});	
	
}

//更新
function updateContractManager(){
	
	var contractManagerId = $(".exChangetd").attr("contractManagerId");
	if(contractManagerId == '0' || contractManagerId == undefined || contractManagerId == ""){
		
		myAlert("请先选择要操作的内容");
		return false;
	}
	
	new MyAjaxDivDialog({title:'修改楼盘合同', formId:'contractManagerFormId', 
		ids:['contractNo', 'startDate:datebox', 'defaultCommission:number'],
		width:800, height:600,
		src:'./saleunit_new_init/appoint/guangzhou/showContractManager.action?id=' + contractManagerId, 
		closeFn:treeToContractManager});	
}

//查看/修改
function modifyContractManager(){
	
	var contractManagerId = $(".exChangetd").attr("contractManagerId");
	if(contractManagerId == '0' || contractManagerId == undefined || contractManagerId == ""){
		
		myAlert("请先选择要操作的内容");
		return false;
	}
	
	var status = $(".exChangetd").attr("status");
	if(status == '0'){
		
		new MyAjaxDivDialog({title:'修改楼盘合同', formId:'contractManagerFormId', 
			ids:['contractNo', 'startDate:datebox', 'defaultCommission:number'],
			width:800, height:600,
			src:'./saleunit_new_init/appoint/guangzhou/showContractManager.action?id=' + contractManagerId, 
			closeFn:treeToContractManager});	
		
	}else{
		
		new MyAjaxDivDialog({title:'查看楼盘合同', 
			width:800, height:600,
			src:'./saleunit_new_init/appoint/guangzhou/showContractManager.action?isShow=true&id=' + contractManagerId, buttons:false});			
	}	
	
}

//复制
function copyContractManager(){
	
	var contractManagerId = $(".exChangetd").attr("contractManagerId");
	if(contractManagerId == '0' || contractManagerId == undefined || contractManagerId == ""){
		
		myAlert("请先选择要操作的内容");
		return false;
	}	
	
	new MyAjaxDivDialog({title:'复制楼盘合同', formId:'contractManagerFormId', 
		ids:['contractNo', 'startDate:datebox', 'defaultCommission:number'],
		width:800, height:600,
		src:'./saleunit_new_init/appoint/guangzhou/showContractManager.action?type=copy&id=' + contractManagerId, 
		closeFn:treeToContractManager});
}

//作废
function cancelManager(){
	
	var contractManagerId = $(".exChangetd").attr("contractManagerId");
	if(contractManagerId == '0' || contractManagerId == undefined || contractManagerId == ""){
		
		myAlert("请先选择要操作的内容");
		return false;
	}
	
	myConfirm("确定作废?", function cancelData(){
		$.ajax({
			type:"get",
			url: "./saleunit_new_init/appoint/guangzhou/cancelContractManager.action?id=" + contractManagerId,
			dataType: "json",
			success: function(data){
				
				var type = data.type;
				if(type == "true"){
					treeToContractManager();
				}else{
					myAlert("操作失败,请重试");
				}
			},
			error: function(XMLHttpRequest, textStatus, errorThrown){
				myAlert("出现异常,请重试");
			}
		})	
	});
	
}

//增加结佣规则
function barRule(managerId){
	
	new MyAjaxIframeDialog({title:'添加跳bar规则', formId:'barRuleFormId', width:500, height:500,
		src:'./saleunit_new_init/appoint/guangzhou/toAddBarRule.action?managerId=' + managerId,
		closeFn:addBarRuleToTable});	
	
}

//增加结佣规则弹出框关闭后执行的函数,
function addBarRuleToTable(){
	
	$.ajax({
		type:"get",
		url: "./saleunit_new_init/appoint/guangzhou/addBarRuleToTable.action",
		dataType: "json",
		success: function(data){
			
			if(data != null && data != ""){
				
				$.ed('#viewbar_table').datagrid('appendRow',data);
				
			}
		},
		error: function(XMLHttpRequest, textStatus, errorThrown){
			myAlert("获取返回数据出现异常");
		}
	})	
}

//查看修改barRule
function modifyBarRule(){
	
	var row = $.ed('#viewbar_table').datagrid('getSelected');
	if (row){
		
		var index = $.ed('#viewbar_table').datagrid('getRowIndex', row);
						
		var id = row.id;
		
		new MyAjaxIframeDialog({title:'查看跳bar规则', formId:'barRuleFormId', width:500, height:500,
			src:'./saleunit_new_init/appoint/guangzhou/toUpdateBarRule.action?id=' + id,
			closeFn:updateBarRuleToTable, closeFnArg:[index]});	 		

	}else{
		myAlert("请先选择要操作的内容");
	}
}

//修改操作后对tr数据的更新
function updateBarRuleToTable(rowIndex){
	
	$.ajax({
		type:"get",
		url: "./saleunit_new_init/appoint/guangzhou/addBarRuleToTable.action",
		dataType: "json",
		success: function(data){
			
			if(data != null){
				$.ed('#viewbar_table').datagrid('updateRow',{"index":rowIndex, "row":data});
			}
		},
		error: function(XMLHttpRequest, textStatus, errorThrown){
			myAlert("获取返回数据出现异常");
		}
	})	
}

//删除barRule
function deleteBarRule(){
	
	var row = $.ed('#viewbar_table').datagrid('getSelected');
	if (row){
		
		var index = $.ed('#viewbar_table').datagrid('getRowIndex', row);
						
		var id = row.id;
		
		myConfirm("确定删除?", function deleteData(){
			$.ajax({
				type:"get",
				url: "./saleunit_new_init/appoint/guangzhou/deleteBarRule.action?id=" + id,
				dataType: "json",
				success: function(data){
					
					var type = data.type;
					if(type == "true"){
						$.ed('#viewbar_table').datagrid('deleteRow', index);
					}else{
						myAlert("操作失败,请重试");
					}
				},
				error: function(XMLHttpRequest, textStatus, errorThrown){
					myAlert("出现异常,请重试");
				}
			})	
		});

	}else{
		myAlert("请选择要删除的行");
	}
}
