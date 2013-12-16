/**
  *
  * 财务管理一些公用的方法
  */
  

//节点的点击方法,isRefresh表示是否为刷新,主要给addChangeClass()使用,moduleId要为其上方增加刷新框的组件
function treeNodeClickForFinancialManager(treeId, node, isRefresh, moduleId){
	
	var hiddenUnitId = $("#hiddenUnitId").val(); //在刷新之前,要先获取之前选择的单元
		
	if(node == undefined || node == null || node == ""){
		node = $("#" + treeId).tree("getSelected");
	}
	var attr = node.attributes;
	if(attr != undefined && attr.type == "endNode"){
		$.ajax({
			type:"get",
			url: "./saleunit_financial_manager/guangzhou/getUnit.action",							
			data: "buildId=" + attr.bid + "&isRefresh=" + isRefresh + "&ts=" + new Date(),
			dataType: "html",
			beforeSend: function(){
				//$("#center_main").html("加载中...");
				moduleMask(moduleId);
			},
			success: function(data){								
				$("#" + moduleId).html(data);	
				
				addChangeClass(isRefresh, hiddenUnitId);
			}			
		});	
		
	}else if(attr != undefined && attr.type == "endNodeGro"){
		$.ajax({
			type:"get",
			url: "./saleunit_financial_manager/guangzhou/getGroup.action",							
			data: "groId=" + attr.gid + "&isRefresh=" + isRefresh + "&ts=" + new Date(),
			dataType: "html",
			beforeSend: function(){
				//$("#center_main").html("加载中...");
				moduleMask(moduleId);
			},
			success: function(data){								
				$("#" + moduleId).html(data);	
				
				addChangeClass(isRefresh, hiddenUnitId);
			}			
		});	
	}else if(attr != undefined && attr.type == "area"){
		$.ajax({
			type:"get",
			url: "./saleunit_financial_manager/guangzhou/getAreaUnit.action",							
			data: "areaId=" + attr.aid + "&isRefresh=" + isRefresh + "&ts=" + new Date(),
			dataType: "html",
			beforeSend: function(){
				//$("#center_main").html("加载中...");
				moduleMask(moduleId);
			},
			success: function(data){								
				$("#" + moduleId).html(data);	
				
				addChangeClass(isRefresh, hiddenUnitId);
			}			
		});	
	}else{
		$("#" + treeId).tree('toggle', node.target);
	}
}

//财务管理弹出框的关闭刷新
function dialogCloseRefresh(){
	
	var unitId = $("#hiddenUnitId").val(); //在刷新之前,要先获取之前选择的单元
	if (unitId != "" && unitId != "0" && unitId != undefined) {
		
		unitClick(unitId);
	}
}

//点击单元的ajax事件
function unitClick(unitId){
	
	$.ajax({
		type:"get",
		url: "./saleunit_new/appoint/guangzhou/getUnitShowContent.action",							
		data: "unitId=" + unitId,
		dataType: "html",
		success: function(data){
			
			if(data != ""){
				$("#showUnitId").html(data);					
				payInfoAjax(unitId);					
			}
		}		
	});		
}

function tdOver(td) {
	var unitId = $(td).attr("unitid");
	if (unitId != "" && unitId != "0" && unitId != undefined) {
		$(td).addClass("seltd");

	}
}

function tdOut(td) {
	var unitId = $(td).attr("unitid");
	if (unitId != "" && unitId != "0" && unitId != undefined) {
		$(td).removeClass("seltd");
	}
}


function tdClick(td){
	
	var unitId = $(td).attr("unitid");
	if (unitId != "" && unitId != "0" && unitId != undefined) {
		$(".changetd").removeClass("changetd");
		$(td).addClass("changetd");
		
		unitClick(unitId);
	}
}

function payInfoAjax(unitId){
	
	$.ajax({
		type:"get",
		url: "./saleunit_financial_manager/guangzhou/unitPayInfo.action",							
		data: "unitId=" + unitId,
		dataType: "html",
		beforeSend: function(){
			//$("#center_main").html("加载中...");
			moduleMask("center_pay_info");
		},
		success: function(data){
			
			$("#center_pay_info").html(data);
			
			reloadSelectTabs();
		}		
	});		
	
}



//新建收款单据(点击页面的"收款")
function addReceipt(unitId){
	
	parent.$("#myIframeDialog").dialog({
		resizable: true,
		modal:true, //模态窗口,表示不能操作弹出框以外的内容
		maximizable: true, //显示最大化按钮
		width:800,
		height:600,
		onClose:function(){
			
			dialogCloseRefresh();
			parent.$('#openIframe').attr("src", "./saleunit_new/guangzhou/loading.jsp"); //清空内容
		},
		buttons:[{
			text:'提交',
			iconCls:'icon-ok',
			handler:function(){
				
				var receiptMoney = $.easyIframeHtml("openIframe", "receiptMoneyShow");
				var amountMoney = $.easyIframeHtml("openIframe", "amountMoney");
				if(receiptMoney != amountMoney){
					dialogButtonSugg("开票金额与合计金额不相等", this);
					return false;
				}
				
				var ids = ["receiptDate", "billNo", "payMan", "receiptAddress:combobox", "payType:combobox", "billType:combobox"];				
				dialogIframeSubmit("openIframe", ids, "addReceiptFormId", this);
								
			}
		},
		{
			text:'关闭',
			iconCls:'icon-cancel',
			handler:function(){
				parent.$('#myIframeDialog').dialog('close');
			}
		}]
		
	});
		
	parent.$('#myIframeDialog').dialog('open');
	parent.$('#myIframeDialog').dialog('setTitle', '添加收款单据'); 

	parent.$('#openIframe')[0].src='./saleunit_financial_manager/guangzhou/forAddReceipt.action?unitId=' + unitId; 
	
	return false;
	
}

//查看receipt
function checkReceipt(){
	
	var receiptId = $(".exChangetd").attr("receiptId");
	if(receiptId == '0' || receiptId == undefined || receiptId == ""){
		
		myAlert("请先选择要操作的内容");
		return false;
	}
	
	parent.$("#myIframeDialog").dialog({
		resizable: true,
		modal:true, //模态窗口,表示不能操作弹出框以外的内容
		maximizable: true, //显示最大化按钮
		width:800,
		height:600,
		onClose:function(){
			
			//dialogCloseRefresh();
			parent.$('#openIframe').attr("src", "./saleunit_new/guangzhou/loading.jsp"); //清空内容
		},
		buttons:[]
		
	});
		
	parent.$('#myIframeDialog').dialog('open');
	parent.$('#myIframeDialog').dialog('setTitle', '查看收款单据'); 

	parent.$('#openIframe')[0].src='./saleunit_financial_manager/guangzhou/forModifyReceipt.action?receiptId=' + receiptId; 
	
	return false;
	
}

//修改receipt
function updateReceipt(){
	
	var receiptId = $(".exChangetd").attr("receiptId");
	if(receiptId == '0' || receiptId == undefined || receiptId == ""){
		
		myAlert("请先选择要操作的内容");
		return false;
	}
	
	parent.$("#myIframeDialog").dialog({
		resizable: true,
		modal:true, //模态窗口,表示不能操作弹出框以外的内容
		maximizable: true, //显示最大化按钮
		width:800,
		height:600,
		onClose:function(){
			
			dialogCloseRefresh();
			parent.$('#openIframe').attr("src", "./saleunit_new/guangzhou/loading.jsp"); //清空内容
		},
		buttons:[{
			text:'提交',
			iconCls:'icon-ok',
			handler:function(){
				
				var receiptMoney = $.easyIframeHtml("openIframe", "receiptMoneyShow");
				var amountMoney = $.easyIframeHtml("openIframe", "amountMoney");
				if(receiptMoney != amountMoney){
					dialogButtonSugg("开票金额与合计金额不相等", this);
					return false;
				}
				
				var ids = ["receiptDate", "billNo", "payMan", "receiptAddress:combobox", "payType:combobox", "billType:combobox"];				
				dialogIframeSubmit("openIframe", ids, "updateReceiptFormId", this);
								
			}
		},
		{
			text:'关闭',
			iconCls:'icon-cancel',
			handler:function(){
				parent.$('#myIframeDialog').dialog('close');
			}
		}]
		
	});
		
	parent.$('#myIframeDialog').dialog('open');
	parent.$('#myIframeDialog').dialog('setTitle', '修改收款单据'); 

	parent.$('#openIframe')[0].src='./saleunit_financial_manager/guangzhou/forModifyReceipt.action?receiptId=' + receiptId; 
	
	return false;
	
}

//删除receipt
function deleteReceipt(){
	
	var receiptId = $(".exChangetd").attr("receiptId");
	if(receiptId == '0' || receiptId == undefined || receiptId == ""){
		
		myAlert("请先选择要删除的内容");
		return false;
	}else{
		
		/**
		var isDelete = confirm("确定要删除?");
		if(isDelete){
			
			$.ajax({
				type:"get",
				url: "./saleunit_financial_manager/guangzhou/deleteReceipt.action",
				data: "receiptId=" + receiptId,
				dataType: "html",
				success: function(data){
					
					if(data == "true"){
						
						dialogCloseRefresh();
					}else{
						
						myAlert("删除失败,请重试.");
					}
					
				}		
			});						
						
		}
		*/
		
		myConfirm("确定要删除?", function(){
			
			$.ajax({
				type:"get",
				url: "./saleunit_financial_manager/guangzhou/deleteReceipt.action",
				data: "receiptId=" + receiptId,
				dataType: "html",
				success: function(data){
					
					if(data == "true"){
						
						dialogCloseRefresh();
					}else{
						
						myAlert("删除失败,请重试.");
					}
					
				}		
			});	
		});
		return false;
	}
	
}