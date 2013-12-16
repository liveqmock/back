/**
* 销售中心下的单元应收款(收款情况)
*/

//判断单元是否有对应的实收或对数
function isUnitHaveReceiptOrCheckfee(unitId, succFn, succFnArg, falseFn, falseFnArg){
	$.ajax({
		type:"get",
		url: "./saleunit_financial_manager/guangzhou/isUnitHaveReceiptOrCheckfee.action",
		data: "unitId=" + unitId,
		dataType: "json",
		success: function(data){
			
			if(data.type == "false"){
				//没有实收或对数
				executeFn(succFn, succFnArg); //easyui.utils.js中				
			}else{
				
				executeFn(falseFn, falseFnArg); //easyui.utils.js中
				//myAlert("该单元已经有对应的实收或对数,不能改变付款方式.");
			}
			
		}		
	});		
}

//使用单元应收款公式
function unitPayBillFormula(unitId){
	
	isUnitHaveReceiptOrCheckfee(unitId, _unitPayBillFormula, [unitId], function(){myAlert("该单元已经有对应的实收或对数,不能改变付款方式.");});	
}

function _unitPayBillFormula(unitId){
	
	new MyAjaxIframeDialog({title:'使用公式', formId:'addUnitPayBillFormulaFormId', height:350, width:600,
		ids:["payWay:combobox"],
		closeFn:dialogCloseRefresh,
		src:'./saleunit_financial_manager/guangzhou/forUnitPayBillFormula.action?unitId=' + unitId
		});	
}

//新建应收款
function addUnitPayBill(unitId){
	
	new MyAjaxIframeDialog({title:'添加应收款', formId:'addUnitPayBillFormId', height:350, width:500,
		ids:["typeName:combobox", "payDate:datebox", "shouldPay:money"],
		closeFn:dialogCloseRefresh,
		src:'./saleunit_financial_manager/guangzhou/forAddUnitPayBill.action?unitId=' + unitId
		});		
}
					
//修改应收款
function modifyUnitPayBill(unitId){
	
	var billId = $(".exChangetd").attr("billId");
	if(billId == '0' || billId == undefined || billId == ""){
		
		myAlert("请先选择要修改的内容");
		return false;
	}
	
	isUnitHaveReceiptOrCheckfee(unitId, _modifyUnitPayBill, [billId], function(){myAlert("该单元已经有对应的实收或对数,不能修改应收款.");});	
}

function _modifyUnitPayBill(billId){
	
	new MyAjaxIframeDialog({title:'修改应收款', formId:'modifyUnitPayBillFormId', height:350, width:500,
		ids:["typeName:combobox", "payDate:datebox", "shouldPay:money"],
		closeFn:dialogCloseRefresh,
		src:'./saleunit_financial_manager/guangzhou/forModifyUnitPayBill.action?billId=' + billId
		});	
}

//查看
function showUnitPayBill(billId){
	new MyAjaxIframeDialog({title:'查看应收款', buttons:false, width:500, height:350,
		src:'./saleunit_financial_manager/guangzhou/forModifyUnitPayBill.action?billId=' + billId});	
}

//删除
function deleteUnitPayBill(unitId){
	
	var getExId = $(".exChangetd").attr("billId");
	if(getExId == '0' || getExId == undefined || getExId == ""){
		
		myAlert("请先选择要删除的内容");
		return false;
	}else{	
	
		isUnitHaveReceiptOrCheckfee(unitId, _deleteUnitPayBill, [getExId], function(){myAlert("该单元已经有对应的实收或对数,不能删除应收款.");});	
		return false;
	}	
}

function _deleteUnitPayBill(billId){
	
	myConfirm("确定要删除?", function(){
		$.ajax({
			type:"get",
			url: "./saleunit_financial_manager/guangzhou/deleteUnitPayBill.action",
			data: "billId=" + billId,
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
							
							dialogCloseRefresh();
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
							
							dialogCloseRefresh();
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