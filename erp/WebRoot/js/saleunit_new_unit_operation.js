/**
  * 销售管理中心下的单元操作
  */

function myRefreshFn(iframeId, moduleId, attrId){
	
	gotoRefreshFn(iframeId, moduleId, attrId);
	
	reFreshFnTabs();

}

function reFreshFnTabs(){
	
	 var utabs = $("#_unit_operation");
	 utabs.load("./saleunit/operation/unitOperation.action?unitId=" + click_unit_id + "");
}

//新建挞定
function addCancelContract(unitId){
	//DEMO 弹窗方式
	new MyAjaxDivDialog({title:'新建挞定', formId:'submitTartFormId', height:380,
		ids:["shouldDeposit", "tartDate", "approveName", "operator"],
		closeFn:myRefreshFn,closeFnArg:["openIframe", "reHiddenId", "isReload"],
		src:'./saleunit/operation/addCancelContract.action?unitId=' + unitId
		});	
}

//新建改名
function addChangeCustomerName(unitId){
	
if(unitId == "" || unitId == "0" || unitId == undefined){
		
		return false;
	}

new MyAjaxIframeDialog({title:'客户更名',height:550, width:800, formId:'submitReplaceCustomerNameFormId',
	ids:["inputMan", "customerRenameTime"],
	closeFn:myRefreshFn,closeFnArg:["openIframe", "reHiddenId", "isReload"],
	submitFn:true,
	src:'./saleunit/operation/addChangeCustomerName.action?unitId=' + unitId
});
		
	
	

}

//新建换房
function addChangeUnit(unitId){
	
	new MyAjaxDivDialog({title:'新建换房', formId:'submitReplaceUnitFormId', height:380,
		ids:["changeUnitDate","approverMan","inputMan"],
		closeFn:myRefreshFn,closeFnArg:["openIframe", "reHiddenId", "isReload"],submitText:'换房',
		src:'./saleunit/operation/addChangeUnit.action?unitId=' + unitId
		});
	
}

//新建退房
function addRejectUnit(unitId){
	
	new MyAjaxDivDialog({title:'新建退房', formId:'submitCancelUnitFormId', height:650,width:800,
		closeFn:myRefreshFn,closeFnArg:["openIframe", "reHiddenId", "isReload"], submitText:'退房',
		ids:["approverMan","inputMan"],
		src:'./saleunit/operation/addRejectUnit.action?unitId=' + unitId
		});
	
	
}

//查看详细
function showConfirmDetail(mainId){
	new MyAjaxIframeDialog({title:'查看详细', formId:'showConfirmDetailFormId', height:550, width:800,
		buttons:false,
		src:'./saleunit/operation/showConfirmDetail.action?mainId=' + mainId
		});
}


//查退房记录
function cancelUnitRecord(mainId){
	new MyAjaxDivDialog({title:'查看退房', formId:'showCancelFormId', height:650, width:800,
		closeFn:myRefreshFn,closeFnArg:["openIframe", "reHiddenId", "isReload"],
		buttons:false,
		src:'./saleunit/operation/showCancelUnitRecord.action?mainId=' + mainId
		});	
}


//查看挞订记录
function showTartRecord(mainId){
	//DEMO DIV弹出框
	new MyAjaxDivDialog({title:'查看挞定', formId:'showTartFormId', height:380,
		closeFn:myRefreshFn,closeFnArg:["openIframe", "reHiddenId", "isReload"],
		src:'./saleunit/operation/showTartRecord.action?mainId=' + mainId
		});	
}

//查看改名记录
function showCustomerRenameRecord(mainId,unitId){
	//DEMO DIV弹出框

	new MyAjaxIframeDialog({title:'查看改名', formId:'showCustomerRenameFormId', height:550,width:800,
		closeFn:myRefreshFn,closeFnArg:["openIframe", "reHiddenId", "isReload"],
		buttons:false,
		src:'./saleunit/operation/showCustomerRenameRecord.action?mainId=' + mainId + '&unitId=' + unitId
		});	
}



//查看换房记录
function changeUnitRecord(mainId){
	new MyAjaxIframeDialog({title:'查看新认购书', formId:'showReplaceUnitFormId', height:550,width:800,
		closeFn:myRefreshFn,closeFnArg:["openIframe", "reHiddenId", "isReload"],
		buttons:false,
		src:'./saleunit/operation/showConfirmChangeUnitDetail.action?mainId=' + mainId
		});	
}




//选择新单元列表
function showUnitList(propertyProjectId){
	//DEMO iframe模式
	new MyAjaxIframeDialog({title:'选择新单元列表',height:550, width:800,
		src:'./saleunit/operation/chooseNewUnit.action?propertyProjectId=' + propertyProjectId,
		submitFn:function(){
			parent.$("#newUnitShow").html(parent.$("#__dialogSugg__").html()); //设置显示的单元全名
			parent.$("#newUnitId").val(parent.$("#__changeUnitId__").val()); //设置新的单元id隐藏域
			parent.$('#myIframeDialog').dialog('close'); //关闭弹出框
		}
	});
}


//新建认购(成交)
function createChangeUnitConfirmDialog(unitId,oldUnitId){
	new MyAjaxIframeDialog({title:'新建认购',height:550, width:800, formId:'xiaoZhuConfirmFormId',
		ids:["payWay","sumMoney","agreeNo","workDate","salesName"],
		src:'./saleunit/operation/createXiaoZhuConfirmDialog.action?type=changeUnit&unitId=' + unitId+'&oldUnitId='+oldUnitId
	});
}

//撤消挞订
function cancelTart(recordId){
	$.ajax({
		type:"get",
		url: "./saleunit/operation/cancelTart.action",
		data: "recordId=" + recordId ,
		dataType: "json",
		success: function(data){
			if(data==true){
				myAlert("撤消成功");
			}
			if(data==false){
				myAlert("撤消失败");
			}
			myRefreshFn("openIframe", "reHiddenId", "isReload");
			
		}
		
	});
	
	return false;	
}

//撤消挞订
function cancelCustomerRename(recordId){
	$.ajax({
		type:"get",
		url: "./saleunit/operation/cancelCustomerRename.action",
		data: "recordId=" + recordId ,
		dataType: "json",
		success: function(data){
			if(data==true){
				myAlert("撤消成功");
			}
			if(data==false){
				myAlert("撤消失败");
			}
			myRefreshFn("openIframe", "reHiddenId", "isReload");
			
		}
		
	});
	
	return false;	
}

//撤消退房
function cancelCancelUnit(recordId){
	$.ajax({
		type:"get",
		url: "./saleunit/operation/cancelCancelUnit.action",
		data: "recordId=" + recordId ,
		dataType: "json",
		success: function(data){
			if(data==true){
				myAlert("撤消成功");
			}
			if(data==false){
				myAlert("撤消失败");
			}
			myRefreshFn("openIframe", "reHiddenId", "isReload");
			
		}
		
	});
	
	return false;	
}

//撤消换房
function cancelChangeUnit(recordId){
	$.ajax({
		type:"get",
		url: "./saleunit/operation/cancelChangeUnit.action",
		data: "recordId=" + recordId ,
		dataType: "json",
		success: function(data){
			if(data==true){
				myAlert("撤消成功");
			}
			if(data==false){
				myAlert("撤消失败");
			}
			myRefreshFn("openIframe", "reHiddenId", "isReload");
			
		}
		
	});
	
	return false;	
}



/*
 *修改客户
 *disabled为true表示查看,隐藏提交按钮,false不隐藏
 */
function modifyContractCustomerChange(customerId){
	
			
	
	var bt = [{
		text:'提交',
		iconCls:'icon-ok',
		handler:function(){
			
			var ids = ["mobilePhone:phone", "customerName", "idcardType:combobox", "idcardNo", "address", "householdProvince:combobox", "homeProvince:combobox"];
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
	
	//先判断是否存在id为myContractCustomerIframeDialog的div,如果不存在就先新建,才能生成对应的弹出框
	if($("#myContractCustomerIframeDialog").length <= 0){
		//表示该div不存在,增加		
		var saleDiv = '<div id="myContractCustomerIframeDialog"><iframe scrolling="auto" frameborder="0" style="width:100%;height:100%;" ' + 
			'id="openContractCustomerIframe" src="./saleunit_new/guangzhou/loading.jsp"></iframe></div>';
			
		$(saleDiv).appendTo("body");		
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
		buttons: bt
	});
		
	$('#myContractCustomerIframeDialog').dialog('open');
	$('#myContractCustomerIframeDialog').dialog('setTitle', '修改客户');

	$('#openContractCustomerIframe')[0].src = './saleunit_new/appoint/guangzhou/toModifyContractCustomer.action?customerId=' +customerId;
	
	return false;
}




