/**
* 成交单元管理下的单元应收款
*/

//新建应收款
function addUnitPayBill(unitId){
	new MyIframeDialog({title:'添加应收款', formId:'addUnitPayBillFormId', width:500, height:350,
		ids:["typeName:combobox", "payDate:datebox", "shouldPay:money"],
		closeFn:reloadReceiptListTabs,
		src:'./saleunit_financial_manager/guangzhou/forAddUnitPayBill.action?unitId=' + unitId
		});	
}
					
//修改应收款
function modifyUnitPayBill(){
	
	var getExId = $(".exChangetd").attr("billId");
	if(getExId == '0' || getExId == undefined || getExId == ""){
		
		myAlert("请先选择要修改的内容");
		return false;
	}
		
	new MyIframeDialog({title:'修改应收款', formId:'modifyUnitPayBillFormId', width:500, height:350,
		ids:["typeName:combobox", "payDate:datebox", "shouldPay:money"],
		closeFn:reloadReceiptListTabs,
		src:'./saleunit_financial_manager/guangzhou/forModifyUnitPayBill.action?billId=' + getExId	
		});	
	
}

//删除
function deleteUnitPayBill(){
	
	var getExId = $(".exChangetd").attr("billId");
	if(getExId == '0' || getExId == undefined || getExId == ""){
		
		myAlert("请先选择要删除的内容");
		return false;
	}else{		
		
		myConfirm("确定要删除?", function(){
			$.ajax({
				type:"get",
				url: "./saleunit_financial_manager/guangzhou/deleteUnitPayBill.action",
				data: "billId=" + getExId,
				dataType: "html",
				success: function(data){
					
					if(data == "true"){
						
						reloadReceiptListTabs();
					}else{
						
						myAlert("删除失败,请重试.");
					}
					
				}		
			});	
		});
		
		return false;
	}
	
}

//修改状态(启用or作废),type为0表示启用操作,type为1表示作废操作
function modifyBillState(type){
	
	var getExId = $(".exChangetd").attr("billId");
	if(getExId == '0' || getExId == undefined || getExId == ""){
		
		myAlert("请先选择要操作的内容");
		return false;
	}else{
		
		if(type == "1"){			
			
			myConfirm("是否作废?", function(){
				$.ajax({
					type:"get",
					url: "./saleunit_financial_manager/guangzhou/disabledUnitPayBill.action",
					data: "billId=" + getExId,
					dataType: "html",
					success: function(data){
						
						if(data == "true"){
							
							reloadReceiptListTabs();
						}else{
							
							myAlert("作废失败,请重试.");
						}
						
					}		
				});	
			});
			
			
		}else if(type == "0"){
			
			myConfirm("是否启用?", function(){
				$.ajax({
					type:"get",
					url: "./saleunit_financial_manager/guangzhou/enabledUnitPayBill.action",
					data: "billId=" + getExId,
					dataType: "html",
					success: function(data){
						
						if(data == "true"){
							
							reloadReceiptListTabs();
						}else{
							
							myAlert("启用失败,请重试.");
						}
						
					}		
				});			
			});
			
		}
		
		return false;
	}
	
}

//重新加载单元应收款
function reloadReceiptListTabs(){
	var unitId = $("#hiddenUnitId").val();
	var selectTabs = $("#manager_bottom_tabs").tabs("getSelected");
	var href = selectTabs.attr("toHref");			
	$(selectTabs).load(href + "?unitId=" + unitId);
}