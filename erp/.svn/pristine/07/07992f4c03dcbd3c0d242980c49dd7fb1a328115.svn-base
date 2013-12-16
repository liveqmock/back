/**
  * 成交单元管理tabs
  */
 
//绑定中间跟底部tabs的相关事件
function managerTabs(){
	managerCenterTabs();
	managerBottomTabs();
}
 
//中间部分顶上的tabs
function managerCenterTabs(){
	
	$('#manager_center_tabs').tabs({
		onSelect:function(title){
			
			//是否收缩底下的tab
			isCollapseBottomTabs(title);
			
			var node = $("#left_tree").tree("getSelected");				
			var selectTabs = $("#manager_center_tabs").tabs("getTab", title);
			var href = selectTabs.attr("toHref");
			
			if(title == "明细"){
				
				detailTabsAjax(node, selectTabs);
			}else if(title == "其他费用"){
				
				otherTabsAjax(selectTabs);
			}else if(title == "底价管理"){
				
				basePriceManAjax(node,selectTabs);
			}else if(title == "实收管理"){
				
				paidInManAjax(node,selectTabs);
			}
			else if(title == "应收管理") {
				
				receiveInManAjax(node,selectTabs);
			}else if(title == "汇总"){
				
				gatherTabsAjax(selectTabs);
			}else if(title == "合同管理"){
				
				contractTabsAjax(node, selectTabs);
			}
		}
	});
}

//底部的tabs
function managerBottomTabs(){
	
	$('#manager_bottom_tabs').tabs({
		onSelect:function(title){
			
			var unitId = $("#hiddenUnitId").attr("value");
			if(unitId == undefined || unitId == "" || unitId == "0"){
				return ;
			}
		
			var selectTabs = $("#manager_bottom_tabs").tabs("getTab", title);
			var href = selectTabs.attr("toHref");
			
			if(title == "单元信息"){
				
				$(selectTabs).load(href + "?id=" + unitId + "&urlFrom=contractUnit");				
			}else if(title == "客户资料"){
				
				$(selectTabs).load(href + "?id=" + unitId);
			}else if(title == "单元房款应收"){
				
				$(selectTabs).load(href + "?unitId=" + unitId);
			}else if(title == "单元房款收款明细"){
				
				$(selectTabs).load(href + "?unitId=" + unitId);
			}else if(title == "单元实收佣金明细"){
				
				$(selectTabs).load(href + "?unitId=" + unitId);
			}
		}
	});
	
}

//判断底部的layout是抽缩,还是伸展
function isCollapseBottomTabs(title){
	
	var collapsed = $('#center_bottom').panel('options').collapsed;
	
	if(title == "其他费用" || title == "汇总" || title == "底价管理" || title == "应收管理" || title == "实收管理" || title == "合同管理"){
		
		if(!collapsed){
			$('#_center_layout').layout('collapse','south');
		}

	}else{
		
		if(collapsed){
			$('#_center_layout').layout('expand','south');
		}
	}
}

//manager_bottom的单元点击
function managerBottomForUnitClick(rowData){
	
	var selectTabs = $("#manager_bottom_tabs").tabs("getSelected");
	var href = selectTabs.attr("toHref");
	var title = selectTabs.panel('options').title;
	
	if(title == "单元信息"){
		
		$(selectTabs).load(href + "?id=" + rowData.id + "&urlFrom=contractUnit");		
	}else if(title == "客户资料"){
		
		$(selectTabs).load(href + "?id=" + rowData.id);
	}else if(title == "单元房款应收"){
				
		$(selectTabs).load(href + "?unitId=" + rowData.id);
	}else if(title == "单元房款收款明细"){
		
		$(selectTabs).load(href + "?unitId=" + rowData.id);
	}else if(title == "单元实收佣金明细"){
				
		$(selectTabs).load(href + "?unitId=" + rowData.id);
	}
}

//置业计划弹出框
function showCalcDialog(){
	
	var unitId = $("#center_bottom_title #hiddenUnitId").val();
	
	new MyAjaxIframeDialog({title:'置业计划', buttons:false, 
		width:400, height:160, maximizable:false,
		src:"./saleunit_new/appoint/guangzhou/getUnitInfoForCalc.action?unitId=" + unitId
	});
	
}


////////////////////////////////


//汇总,初始化组件
function gatherTabsAjax(selectTabs){
	
	var gatherTabsHiddenPropertyProjectId = $("#gatherTabsHiddenPropertyProjectId").val();
	
	var propertyProjectId = $("#hiddenPropertyProjectId").val(); //楼盘项目id
	if(propertyProjectId == undefined || propertyProjectId == ""){
		propertyProjectId = "0";
	}
	
	if(propertyProjectId == gatherTabsHiddenPropertyProjectId){
		return ;
	}	
	
	var href = selectTabs.attr("toHref");
	//var companyProjectId = $("#selectProId").val(); //公司项目
	
	$.ajax({
		type:"get",
		url: href + "?propertyProjectId=" + propertyProjectId, // + "?companyProjectId=" + companyProjectId,
		dataType: "html",
		beforeSend: function(){			
			//moduleMask(selectTabs.panel('options').id);
		},
		success: function(data){			
			$(selectTabs).html(data);
			$.parser.parse(selectTabs);
			//gatherTabsAjaxSucc(propertyProjectId);
			
			$("#gather_sale_select").combobox({
				editable:false,
				width:100
			});
			
			$("#gather_table").datagrid({
				url:'./saleunit_contract/manager/gatherAjaxTable.action?propertyProjectId=' + propertyProjectId + "&saleId=" + $("#gather_sale_select").combobox("getValue")
			});
		}		
	});	
	
}

//汇总tree的单击
function gatherTabsAjaxForClick(selectTabs){
	
	var gatherTabsHiddenPropertyProjectId = $("#gatherTabsHiddenPropertyProjectId").val();
	
	var propertyProjectId = $("#hiddenPropertyProjectId").val(); //楼盘项目id
	if(propertyProjectId == undefined || propertyProjectId == ""){
		propertyProjectId = "0";
	}
	
	if(gatherTabsHiddenPropertyProjectId == undefined || gatherTabsHiddenPropertyProjectId == "" || propertyProjectId == gatherTabsHiddenPropertyProjectId){
		return ;
	}
	
	var href = selectTabs.attr("toHref");
	
	var saleId = $("#gather_sale_select").combobox("getValue");
	
	$.ajax({
		type:"get",
		url: href + "?propertyProjectId=" + propertyProjectId + "&saleId=" + saleId,
		dataType: "html",
		beforeSend: function(){			
			//moduleMask(selectTabs.panel('options').id);
		},
		success: function(data){			
			$(selectTabs).html(data);
			$.parser.parse(selectTabs);
			gatherTabsAjaxSucc(propertyProjectId);
		}		
	});	
	
}

//汇总加载成功,不分页
function gatherTabsAjaxSucc(propertyProjectId){
	
	$("#gather_sale_select").combobox({
		editable:false,
		width:100
	});
	
	var saleId = $("#gather_sale_select").combobox("getValue");
	
	gatherAjaxCount(propertyProjectId, saleId);
	
	/**
	$("#gather_table").datagrid({
		url:'./saleunit_contract/manager/gatherAjaxTable.action',
		queryParams:{'propertyProjectId': propertyProjectId,'saleId': saleId},
		singleSelect:true,
		striped:true,
		fitColumns:true,
	});
	*/
	
}

//汇总查找
function searchGatherTabs(){
	
	 var propertyProjectId = $("#hiddenPropertyProjectId").val();
	 
	 if(propertyProjectId == undefined || propertyProjectId == ""){
		 myAlert("请先确定项目");
		 return false;
	}
	
	var saleId = $("#gather_sale_select").combobox("getValue");
	
	gatherAjaxCount(propertyProjectId, saleId);
	
	/**
	$("#gather_table").datagrid({
		url:'./saleunit_contract/manager/gatherAjaxTable.action',
		queryParams:{'propertyProjectId': propertyProjectId,'saleId': saleId},
		singleSelect:true,
		striped:true,
		fitColumns:true,
	});
	*/
}

//table顶上的汇总信息
function gatherAjaxCount(propertyProjectId, saleId){
	
	$.ajax({
		type:"get",
		url: './saleunit_contract/manager/gatherAjaxCount.action?propertyProjectId=' + propertyProjectId + "&saleId=" + saleId,
		dataType: "json",
		beforeSend: function(){			
			//moduleMask(selectTabs.panel('options').id);
		},
		success: function(data){			
			
			if(data != ""){
				
				$("#countTd").html(data.countTd);
				
				$("#buildAreaTd").html(data.buildAreaTd);
				$("#buildPriceTd").html(data.buildPriceTd);
				
				$("#sumMoneyTd").html(data.sumMoneyTd);
				
				$("#shouldAmountTd").html(data.shouldAmountTd);
				$("#paymentAmountTd").html(data.paymentAmountTd);
				$("#notMoneyTd").html(data.notMoneyTd);		
				
				$("#otherExpensesTd").html(data.otherExpensesTd);		
				
				$("#priceOutTd").html(data.priceOutTd);		
				$("#totalPriceOutTd").html(data.totalPriceOutTd);					

                $("#secondLinkageAmountTd").html(data.secondLinkageAmountTd);
                $("#relAmountTd").html(data.relAmountTd);

				$("#gather_table").datagrid({
                    width:'auto',
					url:'./saleunit_contract/manager/gatherAjaxTable.action',
					queryParams:{'propertyProjectId': propertyProjectId,'saleId': saleId},
					singleSelect:true,
					striped:true,
					fitColumns:false,
                    fit:false
				});
				
			}
		}		
	});	
}

//////////////////////////

//明细查找
function searchDetailTabs(){
	
	$("#unit_detail_table").datagrid({
		url:'./saleunit_contract/manager/unitDetailAjaxTable.action',
		queryParams:getDetailQuery()
	});
	
	//$("#unit_detail_table").datagrid('reload', getDetailQuery()); //reload方法,cond.saleState的值会叠加,出现不正确
}

//获取明细查找的queryParams
function getDetailQuery(){
	
	var buildId = $("#build_select").combobox("getValue");
	/**
	if(buildId == ""){
		myAlert("请先确定楼栋");
		return;
	}
	*/
	
	if(buildId == ""){		
		var endValue = new Array();		
		
		//就获取该下拉框所有的项目id
		var allValues = $("#build_select").combobox("getData");
		
		$(allValues).each(function(){
		
			var val = this.value;
			if(val != ""){
				endValue.push(val);
			}
			
		});
		
		buildId = endValue.join(",");
	}
	
	var saleId = $("#sale_select").combobox("getValue");
	
	return {'buildId':buildId, 'cond.saleState':saleId};
}

//manager_center_tabs的明细function
function detailTabsAjax(node, selectTabs){
	
	var href = selectTabs.attr("toHref");
	var queryParams = "";
	
	try{		
		var attr = node.attributes;
		var type = attr.type;
		var id = attr.valId;						
		
		queryParams = "?type=" + type + "&id=" + id;		
		
	}catch(e){
	}
	
	$.ajax({
		type:"get",
		url: href + queryParams,
		dataType: "html",
		beforeSend: function(){			
			//moduleMask(selectTabs.panel('options').id);
		},
		success: function(data){			
			$(selectTabs).html(data);
			$.parser.parse(selectTabs);
			detailTabsAjaxSucc();
		}		
	});	
}

//manager_center_tabs的明细 ajax succ function
function detailTabsAjaxSucc(){
	
	$("#unit_detail_table").datagrid({
		title:'',
		loadMsg:'加载中...',
		url:'./saleunit_contract/manager/unitDetailAjaxTable.action?buildId=' + selectToQuery('build_select') + "&cond.saleState=8",
		pagination:true, 
		singleSelect:true,
		striped:true,
		fitColumns:true,
		toolbar:'#detail_search_tb',
		onClickRow:function(rowIndex, rowData){
			
			var hidden = "<input type='hidden' id='hiddenUnitId' value='" + rowData.id + "'/>";
			var html = "已选择==&gt;&nbsp;&nbsp;" + rowData.allName + hidden;
			$("#center_bottom_title").html(html);
			
			managerBottomForUnitClick(rowData);
		},
		onLoadSuccess:function(data){			
			$("#unit_detail_table").datagrid("getPager").pagination({showPageList:false});			
			
		}
		
	});
	
	$("#unit_detail_table").datagrid("getPager").pagination({showPageList:false});
	
	$("#build_select").combobox({
		editable:false,
		width:180
	});
	
	$("#sale_select").combobox({
		editable:false,
		width:100
	});
	
}

/////////////////////////

//查询其他费用
function searchOtherTabs(){
	
	$("#other_expenses_table").datagrid('reload');
	//, {'propertyProjectId': $("#hiddenPropertyProjectId").val()});
}

//新建其他费用
function addOtherExpenses(){
	 var propertyProjectId = $("#hiddenPropertyProjectId").val();
	 
	 if(propertyProjectId == undefined || propertyProjectId == ""){
		 myAlert("请先确定项目");
		 return false;
	}
	
	 new MyAjaxDivDialog({title:'新增费用', width:550, height:350, formId:'addOtherFormId',
		ids:['expensesName', 'enterTime:datebox', 'expensesMoney:money'], closeFn:searchOtherTabs,
		src:"./saleunit_contract/manager/toAddOtherExpenses.action?propertyProjectId=" + propertyProjectId
		});
	
}

//编辑其他费用
function modifyOther(otherId){
	
	new MyAjaxDivDialog({title:'编辑费用', width:550, height:350, formId:'modifyOtherFormId',
		ids:['expensesName', 'enterTime:datebox', 'expensesMoney:money'], closeFn:searchOtherTabs,
		src:"./saleunit_contract/manager/toModifyOtherExpenses.action?otherId=" + otherId
		});
}

//删除其他费用,deletePojo(url, succFun, succFunArg);
function deleteOther(otherId){
	
	deletePojo('./saleunit_contract/manager/deleteOtherExpenses.action?otherId=' + otherId, searchOtherTabs, "");
}

//其他费用
function otherTabsAjax(selectTabs){
	
	var otherTabsHiddenPropertyProjectId = $("#otherTabsHiddenPropertyProjectId").val();
	
	var propertyProjectId = $("#hiddenPropertyProjectId").val(); //楼盘项目id
	if(propertyProjectId == undefined || propertyProjectId == ""){
		propertyProjectId = "0";
	}
	
	if(propertyProjectId == otherTabsHiddenPropertyProjectId){
		return ;
	}
	
	var href = selectTabs.attr("toHref");
	//var companyProjectId = $("#selectProId").val(); //公司项目
	
	$.ajax({
		type:"get",
		url: href + "?propertyProjectId=" + propertyProjectId, // + "?companyProjectId=" + companyProjectId,
		dataType: "html",
		beforeSend: function(){			
			//moduleMask(selectTabs.panel('options').id);
		},
		success: function(data){			
			$(selectTabs).html(data);
			$.parser.parse(selectTabs);
			otherTabsAjaxSucc(propertyProjectId);
		}		
	});	
}

//其他费用加载成功
function otherTabsAjaxSucc(propertyProjectId){
	
	$("#other_expenses_table").datagrid({
		title:'',
		loadMsg:'加载中...',
		url:'./saleunit_contract/manager/otherExpensesAjaxTable.action?propertyProjectId=' + propertyProjectId, 
		//$("#other_expenses_table").datagrid('reload', {'propertyProjectId': $("#project_select").combobox("getValue")});
		pagination:true, 
		singleSelect:true,
		striped:true,
		fitColumns:true,
		showFooter:true,
		toolbar:'#other_expenses_search_tb',
		onClickRow:function(rowIndex, rowData){
						
		},
		onLoadSuccess:function(data){			
			$("#other_expenses_table").datagrid("getPager").pagination({showPageList:false});	
			
			var rowsData = $("#other_expenses_table").datagrid("getRows");
			
			var rows = $($("#other_expenses_table").datagrid("getPanel").find(".datagrid-body").last()).find("tr");
			$(rows).each(function(index){
				$(rows[index]).attr("title", rowsData[index].remark);
			});
			
		}
		
	});
	
	/**
	$("#project_select").combobox({
		editable:false,
		width:180,
	});
	*/
	
}

//合同管理
function contractTabsAjax(node, selectTabs){
	
	if(node == null || node == undefined){
		myAlert("请先选定楼盘项目,分区或楼栋");
		return false;
	}
	
	var href = selectTabs.attr("toHref");
	
	var attr = node.attributes;
	if(attr != undefined){
		
		var type = attr.type;
		var id = attr.valId;
		
		$(selectTabs).load(href + "&type=" + type + "&id=" + id);
		
	}else{
		
		myAlert("楼盘项目分区楼栋结构获取出现问题.");
		return false;
	}	
	
}

//查看合同
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


///////////////////////


//底价管理
function basePriceManAjax(node,selectTabs){
	if(node == null){
		myAlert("先选定楼栋");
		return false;
	}
	var id = "",type = "";
	try{		
		var attr = node.attributes;
		type = attr.type;
		id = attr.valId;						
	}catch(e){
	}
	var href = selectTabs.attr("toHref");
	$.ajax({
		type:"get",
		url: href+id+"&type="+type,
		dataType:"html",
		beforeSend: function(){
		},
		success: function(data){
			$(selectTabs).html(data);
			$.parser.parse(selectTabs);
		}
	})
}
//实收管理
function paidInManAjax(node,selectTabs){
	if(node == null){
		myAlert("先选定楼栋");
		return false;
	}
	var id = "",type = "";
	try{		
		var attr = node.attributes;
		type = attr.type;
		id = attr.valId;						
	}catch(e){
	}
	var href = selectTabs.attr("toHref");
	$.ajax({
		type:"get",
		url: href+id+"&type="+type,
		dataType:"html",
		beforeSend: function(){
		},
		success: function(data){
			$(selectTabs).html(data);
			$.parser.parse(selectTabs);
			paidInManTab();
		}
	})
}

function paidInManTab() {
	$(function(){
        $('#tbPaid').datagrid({
        	title:'',//表格标题  
            iconCls:'icon-save',//表格图标  
            width: $(this).width(),
            height: $(this).height()-42,
            pageSize:20,
            pageList:[20,50,100],
            nowrap: true,//是否只显示一行，即文本过多是否省略部分。  
            striped: true,
            sortName: 'id',
            sortOrder: 'desc',  
            idField:'id', 
            loadMsg:'数据加载中...', 
            frozenColumns:[[  
            ]],  
            columns:[[
				{field:'operator',title:'操作',width:80,align:'center',
				    formatter:function(value,row,index){
				          var e = '<a href="javascript:void(0);" onclick="editPaidIn('+row.id+')" style="text-decoration: none;color: #800080;">编辑</a>&nbsp;';
				          e += '<a href="javascript:void(0);" onclick="deleteApPayment('+row.id+')" style="text-decoration: none;color: #800080;">删除</a> ';
				          return e;
					  }
				},
            	{field:'unit_id',title:'房间号',width:50,align:"center",sortable:true},
                {field:'amount',title:'金额',width:70,align:"right",sortable:true},

            	/*{field:'Receiptdate',title:'应收月份',width:80,align:"center",sortable:true},*/
            	{field:'ArDate',title:'收款日期',width:80,align:"center",sortable:true},
                /*{field:'Impdate',title:'导入日期',width:100,align:"center",sortable:true},*/
            	{field:'remark',title:'备注',width:50}
            ]],  
            pagination:true, //包含分页  
            rownumbers:true,  
            singleSelect:true
        });  
        });
}

//实收管理 编辑
function editPaidIn(id) {
    new MyAjaxDivDialog({title:'实收管理编辑', formId:'fnEdit',closeFn:function(){$('#tbPaid').datagrid('reload');}, src:"./saleunit_contract/manager/editPaidIn.action?id="+id});
	//$('#openpaidIn')[0].src="./saleunit_contract/manager/editPaidIn.action?id="+id;
	//$('#editPaidIn').window('open');
}


//实收管理 查找
function paidSearch() {
	var node = $("#left_tree").tree("getSelected");
	if(node == null){
		myAlert("先选定楼栋");
		return false;
	}
	$('#tbPaid').datagrid({
        url:'./saleunit_contract/manager/searchPaidIn.action',
        queryParams:{buildId:$("#build_id").val(),impdate:$('#impdate').datebox('getValue')}
    });
}

//实收管理 下载
function downloadPaid() {
	var node = $("#left_tree").tree("getSelected");
	if(node == null){
		myAlert("先选定楼栋");
		return false;
	}
	
	var id = $("#build_id").val();
	$('#paidDownload').form({
		url:'./saleunit_contract/manager/excelPaid.action?buildId='+id,    
		success:function(data){}
	});
	$('#paidDownload').submit();
}

//实收管理 上传
function uploadPaid() {
	var node = $("#left_tree").tree("getSelected");
	if(node == null){
		myAlert("先选定楼栋");
		return false;
	}
	$('#paidUpload').form({
		url:'./saleunit_contract/manager/excelPaidUpload.action',    
		success:function(data){
            $.messager.defaults = { ok: '确定'};
            $.messager.alert('提示', data, 'info');
        }
	});
	$('#paidUpload').submit();
}

//实收管理 删除
function deleteApPayment(id) {
	var selected = $('#tbPaid').datagrid('getSelected');
    if(selected){
        $.messager.confirm('删除','确认删除吗?',function(d){
            if(d){
            /* 将数据删除 */
             $.ajax({
                     type:"POST",
                     url:"./saleunit_contract/manager/deleteApPayment.action",
                     data:"id="+selected.id
             });
             $('#tbPaid').datagrid('reload');
            }
        });
    }
}

//应收管理
function receiveInManAjax(node,selectTabs){
	if(node == null){
		myAlert("先选定楼栋");
		return false;
	}
	var id = "",type = "";
	try{		
		var attr = node.attributes;
		type = attr.type;
		id = attr.valId;						
	}catch(e){
	}
	var href = selectTabs.attr("toHref");
	$.ajax({
		type:"get",
		url: href+id+"&type="+type,
		dataType:"html",
		beforeSend: function(){
		},
		success: function(data){
			$(selectTabs).html(data);
			$.parser.parse(selectTabs);
			receiveInManTab();
		}
	})
}

function receiveInManTab() {
	$(function(){
        $('#tbReceive').datagrid({
        	title:'',//表格标题  
            iconCls:'icon-save',//表格图标  
            width: 770,
            height: 450,
            nowrap: true,//是否只显示一行，即文本过多是否省略部分。  
            striped: true,
            pageSize:15,
            pageList:[10,15,30],
            sortName: 'id',
            sortOrder: 'desc',  
            idField:'nodeID', 
            loadMsg:'数据加载中...', 
            frozenColumns:[[  
            ]],  
            columns:[[
				{field:'operator',title:'操作',width:100,align:'center',
				    formatter:function(value,row,index){
				          var e = '<a href="javascript:void(0);" onclick="editReceiveIn('+row.id+')" style="text-decoration: none;color: #800080;">编辑</a> ';
				          var d = '<a href="javascript:void(0);" onclick="deleteReceiveIn('+row.id+')" style="text-decoration: none;color: #800080;">删除</a>';
				          return e+"&nbsp;"+d;
					  }
				},      
            	{field:'unit_id',title:'房间号',width:50,align:'center',sortable:true},
                {field:'amount',title:'金额',width:70,align:'right',sortable:true},

                {field:'impdate',title:'导入日期',width:100,align:'center',sortable:true},
                {field:'ar_date',title:'应收月份',width:100,align:'center',sortable:true},
            	{field:'remark',title:'备注',width:200}
            ]],  
            pagination:true, //包含分页  
            rownumbers:true,  
            singleSelect:true
        });


        });
}

//应收管理 编辑
function editReceiveIn(id) {
	$('#openreceiveIn')[0].src="./saleunit_contract/manager/editReceiveIn.action?id="+id;
	$('#editReceiveIn').window('open');
}

//应收管理 删除
function deleteReceiveIn(id) {
	var selected = $('#tbReceive').datagrid('getSelected');
    if(selected){
        $.messager.confirm('删除','确认删除吗?',function(d){
            if(d){
            /* 将数据删除 */    
             $.ajax({
                     type:"POST",
                     url:"./saleunit_contract/manager/deleteReceiveIn.action",
                     data:"id="+selected.id
             });
             $('#tbReceive').datagrid('reload');
            }
        });
    }
}

//应收管理 下载
function downloadReceive() {
	
	var node = $("#left_tree").tree("getSelected");
	if(node == null){
		myAlert("先选定楼栋");
		return false;
	}

	var id = $("#build_id").val();
	$('#downloadFm').form({
		url:'./saleunit_contract/manager/excelReceive.action?buildId='+id,    
		success:function(data){}
	});
	$('#downloadFm').submit();
}

//应收管理 查找
function receiveSearch() {
	var node = $("#left_tree").tree("getSelected");
	if(node == null){
		myAlert("先选定楼栋");
		return false;
	}

	$('#tbReceive').datagrid({
        url:'./saleunit_contract/manager/searchReceiveIn.action',
        queryParams:{ buildId:$("#build_id").val(),impdate:$('#impdate').datebox('getValue')}
    });
}


//应收管理 上传
function uploadReceive() {
	var node = $("#left_tree").tree("getSelected");
	if(node == null){
		myAlert("先选定楼栋");
		return false;
	}
	$('#receiveUpload').form({
		url:'./saleunit_contract/manager/excelReceiveUpload.action',    
		success:function(data){
			$.messager.defaults = { ok: '确定'};
			$.messager.alert('提示', data, 'info');
		}
	});
	$('#receiveUpload').submit();
}

//底价管理 下载
function downloadBase() {
	var node = $("#left_tree").tree("getSelected");
	if(node == null){
		myAlert("先选定楼栋");
		return false;
	}
	
    $('#baseDownloadFm').form({
		url:'./saleunit_contract/manager/excelDownLoad.action',    
		success:function(data){}
	});
	$('#baseDownloadFm').submit();
}
//底价管理 上传
function uploadBase() {
	$('#uploadFm').form({
		url:'./saleunit_contract/manager/excelUpload.action',   
		success:function(data){
			parent.hideLoading();
			$.messager.defaults = { ok: '确定'};
			$.messager.alert('提示', '数据上传成功', 'info'); 
		}
	});
	parent.showLoading();
	$('#uploadFm').submit(); 
}

$.fn.extend({
    /**
     * 修改DataGrid对象的默认大小，以适应页面宽度。
     *
     * @param heightMargin
     *            高度对页内边距的距离。
     * @param widthMargin
     *            宽度对页内边距的距离。
     * @param minHeight
     *            最小高度。
     * @param minWidth
     *            最小宽度。
     *
     */
    resizeDataGrid : function(heightMargin, widthMargin, minHeight, minWidth) {
        var height = $(document.body).height() - heightMargin;
        var width = $(document.body).width() - widthMargin;
        height = height < minHeight ? minHeight : height;
        width = width < minWidth ? minWidth : width;
        $(this).datagrid('resize', {
            height : height,
            width : width
        });
    }
});