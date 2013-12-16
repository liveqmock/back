/**
  * 销售中心下的收款明细
  */

//新建收款单据(点击页面的"收款"),废弃
function addReceiptBySaleunit(unitId){
	
	new MyAjaxIframeDialog({title:'添加收款单据', formId:'addReceiptFormId', height:380,
		ids:["typeName:combobox", "feeType:combobox", "receiptDate:datebox", "billNo", "payMan", "receiptMoney:money", "inputMan"],
		closeFn:doUnitPayBill,
		src:'./saleunit_financial_tabs/guangzhou/forAddReceipt.action?unitId=' + unitId
		});		
}

//销售中心-->收款情况
function addReceiptByUnitIdAndBillId(unitId, billId){
	
	new MyAjaxIframeDialog({title:'添加收款单据', formId:'addReceiptFormId', height:380,
		ids:["receiptMoney:money"],
		closeFn:doUnitPayPlan,
		src:'./saleunit_financial_tabs/guangzhou/forAddReceipt.action?unitId=' + unitId + "&billId=" + billId
		});		
}

//根据billId查看receipt
function showReceiptListByBillId(billId){
	
	new MyAjaxIframeDialog({title:'查看收款明细', height:300, width:800, buttons:false,
		closeAlwaysExceFn:true, closeFn:doUnitPayPlan,
		src:'./saleunit_financial_tabs/guangzhou/receiptListDialog.action?billId=' + billId
	});
}

//查看receipt
function checkReceiptBySaleunit(){
	
	var receiptId = $(".exChangetd").attr("receiptId");
	if(receiptId == '0' || receiptId == undefined || receiptId == ""){
		
		myAlert("请先选择要操作的内容");
		return false;
	}
	
	new MyAjaxIframeDialog({title:'查看收款单据', height:380, buttons:false,
		src:'./saleunit_financial_tabs/guangzhou/forModifyReceipt.action?receiptId=' + receiptId});		
}

//修改receipt
function updateReceiptBySaleunit(){
	
	var receiptId = $(".exChangetd").attr("receiptId");
	if(receiptId == '0' || receiptId == undefined || receiptId == ""){
		
		myAlert("请先选择要操作的内容");
		return false;
	}
	
	new MyAjaxIframeDialog({title:'修改收款单据', formId:'updateReceiptFormId', height:380,
		ids:["typeName:combobox", "feeType:combobox", "receiptDate:datebox", "billNo", "payMan", "receiptMoney:money", "inputMan"],
		closeFn:doUnitPayBill,
		src:'./saleunit_financial_tabs/guangzhou/forModifyReceipt.action?receiptId=' + receiptId});		
}

//删除receipt
function deleteReceiptBySaleunit(){
	
	var receiptId = $(".exChangetd").attr("receiptId");
	if(receiptId == '0' || receiptId == undefined || receiptId == ""){
		
		myAlert("请先选择要删除的内容");
		return false;
	}else{
		
		myConfirm("确定要删除?", function(){
			
			$.ajax({
				type:"get",
				url: "./saleunit_financial_tabs/guangzhou/deleteReceipt.action",
				data: "receiptId=" + receiptId,
				dataType: "json",
				success: function(data){
					
					if(data.type == "true"){
						
						doUnitPayBill();
					}else{
						
						myAlert("删除失败,请重试.");
					}
					
				}		
			});	
		});
		return false;
	}
	
}