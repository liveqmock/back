/**
 *  easyui 中的单元信息, unit_info.jsp, unit_image_div.jsp
 */
 
$().ready(function(){
				   
	$("#confirmSub").click(function(){

		var ids = ["showConfirmCustomerId", "phone", "payWayId", "buildPrice:money", "insideUnitPrice:money", 
				   "sumMoney:money", "agreeNo", "shouldDeposit:money", "agreeMoney:money", "signDate", "workDate", "deliveryDate"];
		return myCheckOnlyById(ids);		
		
	});
	
	$("#subContract").click(function(){
		
		var ids = ["customerName","phone","unitName","propertyType","payWayId",
				   "buildPrice:money","insideUnitPrice:money","sumMoney:money","signDate","workDate"];
		return myCheckOnlyById(ids);
		
	});
});

//新建认购(成交)
function createConfirmDialog(unitId){	

	if(unitId == "" || unitId == "0" || unitId == undefined){
		
		return false;
	}
	
	new MyAjaxIframeDialog({title:"新建成交", width:800, height:650,
		src:'./saleunit_new/appoint/guangzhou/toCreateConfirmDialog.action?unitId=' + unitId,
		ids:["salesId", "customerId", "payWayId", "buildPrice:money","insideUnitPrice:money", "sumMoney:money", "agreeNo", "workDate"],
		idsSugg:{"customerId":"客户不能为空"},
		formId:"easyUIConfirmFormId",
		closeFn:gotoRefreshFn,
		closeFnArg:["openIframe", "reHiddenId", "isReload"]
		});
	
	/**
	parent.$("#myIframeDialog").dialog({
		resizable: true,
		modal:true, //模态窗口,表示不能操作弹出框以外的内容
		maximizable: true, //显示最大化按钮
		width:800,
		height:700,
		onClose:function(){
			//refreshFn();
			
			gotoRefreshFn("openIframe", "reHiddenId", "isReload");
			parent.$('#openIframe').attr("src", "./saleunit_new/guangzhou/loading.jsp"); //清空内容
		},
		buttons:[{
			text:'提交',
			iconCls:'icon-ok',
			handler:function(){
				
				var ids = ["showContractCustomerId", "phone", "payWayId", "buildPrice:money", 
						   "insideUnitPrice:money", "sumMoney:money", "agreeNo", "workDate", "salesId"];		
				dialogIframeSubmit("openIframe", ids, "xiaoZhuConfirmFormId", this);
								
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
	parent.$('#myIframeDialog').dialog('setTitle', '新建成交');
	
	//$('#openIframe')[0].src='./saleunit_new/appoint/guangzhou/createConfirmDialog.action?unitId=' + unitId; 
	parent.$('#openIframe')[0].src='./saleunit_new/appoint/guangzhou/createXiaoZhuConfirmDialog.action?unitId=' + unitId;
	*/
	
	return false;
}

//查看修改认购
function showConfirmDialog(confirmId){

	if(confirmId == "" || confirmId == "0" || confirmId == undefined){
		
		return false;
	}
	
	new MyAjaxIframeDialog({title:"查看成交", width:800, height:650,
		src:'./saleunit_new/appoint/guangzhou/toShowConfirmDialog.action?confirmId=' + confirmId,
		ids:["salesId", "customerId", "payWayId", "buildPrice:money","insideUnitPrice:money", "sumMoney:money", "agreeNo", "workDate"],
		idsSugg:{"customerId":"客户不能为空"},
		formId:"easyUIConfirmFormId",
		closeFn:gotoRefreshFn,
		closeFnArg:["openIframe", "reHiddenId", "isReload"]
		});
		
	/**
	parent.$("#myIframeDialog").dialog({
		resizable: true,
		modal:true, //模态窗口,表示不能操作弹出框以外的内容
		maximizable: true, //显示最大化按钮
		width:800,
		height:700,
		onClose:function(){

			gotoRefreshFn("openIframe", "checkOutId", "isReload");
			//gotoRefreshFn("openIframe", "reHiddenId", "isReload");
			parent.$('#openIframe').attr("src", "./saleunit_new/guangzhou/loading.jsp"); //清空内容
		},
		buttons:[				 
		{
			text:'提交',
			iconCls:'icon-ok',
			handler:function(){
				
				var ids = ["showContractCustomerId", "phone","payWayId", "buildPrice:money", 
						   "insideUnitPrice:money", "sumMoney:money", "agreeNo", "workDate", "salesId"];
				dialogIframeSubmit("openIframe", ids, "xiaoZhuConfirmFormId", this);				
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
	parent.$('#myIframeDialog').dialog('setTitle', '查看成交');
	
	parent.$('#openIframe')[0].src='./saleunit_new/appoint/guangzhou/showXiaoZhuConfirmDialog.action?confirmId=' + confirmId;
	*/
	
	return false;	
}

//只是查看认购,不能修改
function showConfirmDialogOnly(confirmId){
	
	if(confirmId == "" || confirmId == "0" || confirmId == undefined){
		
		return false;
	}
		
	parent.$("#myIframeDialog").dialog({
		resizable: true,
		modal:true, //模态窗口,表示不能操作弹出框以外的内容
		maximizable: true, //显示最大化按钮
		width:800,
		height:600,
		onClose:function(){

			parent.$('#openIframe').attr("src", "./saleunit_new/guangzhou/loading.jsp"); //清空内容
		},
		buttons:[] //因为用的是同一个dialog,所以每一次都要重新初始化底部按钮
	});
		
	parent.$('#myIframeDialog').dialog('open');
	parent.$('#myIframeDialog').dialog('setTitle', '查看成交');
	
	//$('#openIframe')[0].src='./saleunit_new/appoint/guangzhou/showConfirmDialog.action?confirmId=' + confirmId; 
	parent.$('#openIframe')[0].src='./saleunit_new/appoint/guangzhou/showXiaoZhuConfirmDialog.action?confirmId=' + confirmId;
	
	return false;	
}

//查看认购客户,弹出窗口
function showConfirmCustomer(){
	
	$("#confirmCustomerShowDiv").dialog({
		resizable: true,
		onClose:function(){
			
		}
	});
	
	$("#confirmCustomerShowDiv").bgiframe();  //ie6 覆盖下拉框
	
	$('#confirmCustomerShowDiv').dialog('open');
	$('#confirmCustomerShowDiv').dialog('setTitle', '查看成交客户');
	
	return false;
}

//新建签约(合同)
function createContractDialog(unitId){
	
	if(unitId == "" || unitId == "0" || unitId == undefined){
		
		return false;
	}
	
	$.ajax({
		type:"get",
		url: "./saleunit_new/appoint/guangzhou/isCanCreateXiaoZhuContractDialog.action?unitId=" + unitId,
		dataType: "json",
		success: function(data){
			
			var status = data.status;
			if(status == "false"){
				
				myAlert("要先建成交,才能建合同");
				return false;
				
			}else{
				
				createContractDialogReal(unitId);
			}
		}
   });
}

//实际的新建签约(合同)
function createContractDialogReal(unitId){
	
	if(unitId == "" || unitId == "0" || unitId == undefined){
		
		return false;
	}
	
	parent.$("#myIframeDialog").dialog({
		resizable: true,
		modal:true, //模态窗口,表示不能操作弹出框以外的内容
		maximizable: true, //显示最大化按钮
		width:800,
		height:600,		
		onClose:function(){
			//refreshFn();
			
			gotoRefreshFn("openIframe", "reHiddenId", "isReload");
			parent.$('#openIframe').attr("src", "./saleunit_new/guangzhou/loading.jsp"); //清空内容
		},
		
		buttons:[
		{
			text:'提交',
			iconCls:'icon-ok',
			handler:function(){
					
				var ids = ["showContractCustomerId", "phone","unitName","payWayId",
				   "buildPrice:money","insideUnitPrice:money", "sumMoney:money","contractNo","signDate", "hiddenSalesId"];
				dialogIframeSubmit("openIframe", ids, "xiaoZhuContractFormId", this);
				
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
	parent.$('#myIframeDialog').dialog('setTitle', '新建合同');
	
	//$('#openIframe')[0].src='./saleunit_new/appoint/guangzhou/createContractDialog.action?unitId=' + unitId; 	
	parent.$('#openIframe')[0].src='./saleunit_new/appoint/guangzhou/createXiaoZhuContractDialog.action?unitId=' + unitId;
	
	return false;
}

//该单元为成交,要用成交的基本信息设到合同的基本信息中
function createContractDialogFromConfirm(unitId){
	
	if(unitId == "" || unitId == "0" || unitId == undefined){
		
		return false;
	}
	
	new MyAjaxIframeDialog({title:"新建合同", width:800, height:700,
		src:'./saleunit_new/appoint/guangzhou/toCreateContractDialog.action?unitId=' + unitId,
		ids:["payWayId", "buildPrice:money","insideUnitPrice:money", "sumMoney:money","contractNo",
		   function(_easy){
			   var propertyProjectId = _easy.$("#hiddenPropertyProjectId").val();					   
			   var contractNo = _easy.$("#contractNo").val();
			   
				if($.trim(contractNo) == ""){
					return "合同编号不能为空";
				}

				if(propertyProjectId == "" || propertyProjectId == "0"){
					return "楼盘项目id不合法";
				}
				
				var ret = "";					   
				$.ajax({
					type: "get",
					async: false,
					cache: true,
					url: "./saleunit_new/appoint/guangzhou/isContractNoRepeatInPropertyProject.action",
					data: "propertyProjectId=" + propertyProjectId + "&contractNo=" + contractNo,
					dataType: "json",
					success: function(data){
						
						repeat = data.repeat;
						if(repeat){
							_easy.$("#contractNo").val("");
							ret = data.repeatSugg;
						}
					}
				});					   
			   return ret;		
			},
		   "signDate", "hiddenSalesId"],
		formId:"easyUIContractFormId",
		closeFn:gotoRefreshFn,
		closeFnArg:["openIframe", "reHiddenId", "isReload"]
		});
	
	/**
	parent.$("#myIframeDialog").dialog({
		resizable: true,
		modal:true, //模态窗口,表示不能操作弹出框以外的内容
		maximizable: true, //显示最大化按钮
		width:800,
		height:800,
		onClose:function(){
			//refreshFn();
			
			gotoRefreshFn("openIframe", "reHiddenId", "isReload");
			parent.$('#openIframe').attr("src", "./saleunit_new/guangzhou/loading.jsp"); //清空内容
		},
		
		buttons:[
		{
			text:'提交',
			iconCls:'icon-ok',
			handler:function(){
					
				var ids = ["contractCustomerId", "phone","unitName","payWayId",
				   "buildPrice:money","insideUnitPrice:money", "sumMoney:money","contractNo",
				   function(_easy){
					   var propertyProjectId = _easy.$("#hiddenPropertyProjectId").val();					   
					   var contractNo = _easy.$("#contractNo").val();
					   
						if($.trim(contractNo) == ""){
							return "合同编号不能为空";
						}

						if(propertyProjectId == "" || propertyProjectId == "0"){
							return "楼盘项目id不合法";
						}
						
						var ret = "";					   
					   	$.ajax({
							type: "get",
							async: false,
							cache: true,
							url: "./saleunit_new/appoint/guangzhou/isContractNoRepeatInPropertyProject.action",
							data: "propertyProjectId=" + propertyProjectId + "&contractNo=" + contractNo,
							dataType: "json",
							success: function(data){
								
								repeat = data.repeat;
								if(repeat){
									_easy.$("#contractNo").val("");
									ret = data.repeatSugg;
								}
							}
						});					   
					   return ret;
				
					},
				   "signDate", "hiddenSalesId"];
				
				dialogIframeSubmit("openIframe", ids, "xiaoZhuContractFormId", this);
				
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
	parent.$('#myIframeDialog').dialog('setTitle', '新建合同');
	
	//$('#openIframe')[0].src='./saleunit_new/appoint/guangzhou/createContractDialog.action?unitId=' + unitId; 	
	parent.$('#openIframe')[0].src='./saleunit_new/appoint/guangzhou/createContractDialogFromConfirm.action?unitId=' + unitId;
	*/
	
	return false;	
}

//查看修改签约(合同)
function showContractDialog(contractId){
	
	if(contractId == "" || contractId == "0" || contractId == undefined){
		
		return false;
	}
	
	new MyAjaxIframeDialog({title:"查看合同", width:800, height:700,
		src:'./saleunit_new/appoint/guangzhou/toShowContractDialog.action?contractId=' + contractId,
		ids:["payWayId", "buildPrice:money","insideUnitPrice:money", "sumMoney:money","contractNo",
		   function(_easy){
			   var propertyProjectId = _easy.$("#hiddenPropertyProjectId").val();					   
			   var contractNo = _easy.$("#contractNo").val();
			   var hiddenOldContractNo = _easy.$("#hiddenOldContractNo").val();
			   
				if(hiddenOldContractNo == contractNo){
					return ;
				}
				
				if($.trim(contractNo) == ""){
					return "合同编号不能为空";
				}

				if(propertyProjectId == "" || propertyProjectId == "0"){
					return "楼盘项目id不合法";
				}
				
				var ret = "";					   
				$.ajax({
					type: "get",
					async: false,
					cache: true,
					url: "./saleunit_new/appoint/guangzhou/isContractNoRepeatInPropertyProject.action",
					data: "propertyProjectId=" + propertyProjectId + "&contractNo=" + contractNo,
					dataType: "json",
					success: function(data){
						
						repeat = data.repeat;
						if(repeat){
							_easy.$("#contractNo").val(hiddenOldContractNo);
							ret = data.repeatSugg;							
						}
					}
				});					   
			   return ret;
			},
		   "signDate", "hiddenSalesId"],
		formId:"easyUIContractFormId",
		closeFn:gotoRefreshFn,
		closeFnArg:["openIframe", "reHiddenId", "isReload"]
		});
		
	/**
	parent.$("#myIframeDialog").dialog({
		resizable: true,
		modal:true, //模态窗口,表示不能操作弹出框以外的内容
		maximizable: true, //显示最大化按钮
		width:800,
		height:800,
		onClose:function(){
			
			gotoRefreshFn("openIframe", "checkOutId", "isReload");
			//gotoRefreshFn("openIframe", "reHiddenId", "isReload");
			parent.$('#openIframe').attr("src", "./saleunit_new/guangzhou/loading.jsp"); //清空内容
		},
		buttons:[
		{
			text:'提交',
			iconCls:'icon-ok',
			handler:function(){
				
			var ids = ["contractCustomerId", "phone","unitName","payWayId",
				   "buildPrice:money","insideUnitPrice:money", "sumMoney:money","contractNo",
				   function(_easy){
					   var propertyProjectId = _easy.$("#hiddenPropertyProjectId").val();					   
					   var contractNo = _easy.$("#contractNo").val();
					   var hiddenOldContractNo = _easy.$("#hiddenOldContractNo").val();
					   
						if(hiddenOldContractNo == contractNo){
							return ;
						}
						
						if($.trim(contractNo) == ""){
							return "合同编号不能为空";
						}

						if(propertyProjectId == "" || propertyProjectId == "0"){
							return "楼盘项目id不合法";
						}
						
						var ret = "";					   
					   	$.ajax({
							type: "get",
							async: false,
							cache: true,
							url: "./saleunit_new/appoint/guangzhou/isContractNoRepeatInPropertyProject.action",
							data: "propertyProjectId=" + propertyProjectId + "&contractNo=" + contractNo,
							dataType: "json",
							success: function(data){
								
								repeat = data.repeat;
								if(repeat){
									_easy.$("#contractNo").val(hiddenOldContractNo);
									ret = data.repeatSugg;
								}
							}
						});					   
					   return ret;
				
					},
				 "signDate", "hiddenSalesId"];
			
				dialogIframeSubmit("openIframe", ids, "xiaoZhuContractFormId", this);
				
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
	parent.$('#myIframeDialog').dialog('setTitle', '查看合同');
	
	//$('#openIframe')[0].src='./saleunit_new/appoint/guangzhou/showContractDialog.action?contractId=' + contractId; 
	parent.$('#openIframe')[0].src='./saleunit_new/appoint/guangzhou/showXiaoZhuContractDialog.action?contractId=' + contractId;
	*/
	
	return false;	
	
}

//查看签约客户,弹出窗口(改为成交)
function showContractCustomer(){
	
	$("#contractCustomerShowDiv").dialog({
		resizable: true,
		onClose:function(){
			
		},		
		buttons:[{
			text:'提交',
			iconCls:'icon-ok',
			handler:function(){

				updateContractCustomerForDialog(this);
			}
		},
		{
			text:'关闭',
			iconCls:'icon-cancel',
			handler:function(){
				
				$('#contractCustomerShowDiv').dialog('close');
			}
		}]
	});
	
	$("#contractCustomerShowDiv").bgiframe();  //ie6 覆盖下拉框
	
	$('#contractCustomerShowDiv').dialog('open');
	$('#contractCustomerShowDiv').dialog('setTitle', '查看合同客户(多个姓名或电话号码,请用","隔开)');
	
	return false;
}

//修改成交客户
function updateContractCustomerForDialog(dialogButton){
	
	var contractCustomerName = $("#showContractCustomerName_update").val();
	var contractCustomerPhone = $("#showContractCustomerPhone").val();
	
	if($.trim(contractCustomerName) == ""){
		$("#showContractCustomerName_update").focus();
		dialogNewSugg(dialogButton, "客户名称不能为空");
		return false;
	}
	
	if($.trim(contractCustomerPhone) == ""){
		$("#showContractCustomerPhone").focus();
		dialogNewSugg(dialogButton, "电话号码不合规则");
		return false;
	}

	//$('#suggId').html('提交中...');
	dialogNewSugg(dialogButton, "提交中...");
	
	$.ajax({
		type:"post",
		url: "./saleunit_new/appoint/guangzhou/updateContractCustomerForDialog.action",
		data: $("#showContractCustomerFormId").serialize(),
		dataType: "json",
		success: function(data){
			
			if(data != "" && data != null){
				
				//保存成功				
				$('#contractCustomerShowDiv').dialog('close');
				
				//showContractCustomerName,showContractCustomerName_update,showContractCustomerPhone,showContractCustomerGender,
				//showContractCustomerIdcardType,showContractCustomerIdcardNo,showContractCustomerAddress
				
				$("#showContractCustomerName").html(data.name);
				$("#phone").val(data.phone);
				
				$("#showContractCustomerName_update").val(data.name);
				$("#showContractCustomerPhone").val(data.phone);
				$("#showContractCustomerGender").val(data.gender);
				
				$("#showContractCustomerIdcardType").val(data.idcardType);
				$("#showContractCustomerIdcardNo").val(data.idcardNo);
				$("#showContractCustomerAddress").val(data.address);
				
				
			}else{				
			
				//保存失败
				dialogNewSugg(dialogButton, "<font color='red'>保存失败,请重新新建</font>");
			}
		}		
	});
}

//新建认购客户,弹出窗口
function createConfirmCustomer(){
	
	$("#confirmCustomerDiv").dialog({
		resizable: true,
		onClose:function(){
			
		}
	});
	
	$("#confirmCustomerDiv").bgiframe();  //ie6 覆盖下拉框
	
	$('#confirmCustomerDiv').dialog('open');
	$('#confirmCustomerDiv').dialog('setTitle', '新建成交客户');
	
	return false;
}

//新建合同客户,弹出窗口
function createContractCustomer(confirmType){
	
	$("#contractCustomerDiv").dialog({
		resizable: true,
		onClose:function(){
			
		},
		buttons:[{
			text:'提交',
			iconCls:'icon-ok',
			handler:function(){
				
				saveContractCustomerForNewDialog(confirmType, this);				
			}
		},
		{
			text:'关闭',
			iconCls:'icon-cancel',
			handler:function(){
				
				$('#contractCustomerDiv').dialog('close');
			}
		}]
	});
	
	$("#contractCustomerDiv").bgiframe();  //ie6 覆盖下拉框
	
	$('#contractCustomerDiv').dialog('open');
	$('#contractCustomerDiv').dialog('setTitle', '新建合同客户(多个姓名或电话号码,请用","隔开)');
	
	return false;
}

//查找合同客户(为售前客户,也就是"查询客户"中的客户-->应该改为从合同客户表中获取)
function searchContractCustomer(){
	
	$("#searchContractCustomerDiv").dialog({
		resizable: true,
		onClose:function(){
			
			$("#customerName").val("");
			$("#customerPhone").val("");
			$("#customerHiddenId").attr("value", "");
		},
		buttons:[{
			text:'提交',
			iconCls:'icon-ok',
			handler:function(){
				
				var customerId = $("#customerHiddenId").attr("value");
				if(customerId == ""){
					
					dialogNewSugg(this, "请选择客户");
					return false;
				}
				
				dialogNewSugg(this, "保存中...");
				ajaxContractCustomer(customerId, this); //设置id,name,phone

			}
		},
		{
			text:'关闭',
			iconCls:'icon-cancel',
			handler:function(){
				
				$('#searchContractCustomerDiv').dialog('close');
			}
		}]
	});
	
	$("#searchContractCustomerDiv").bgiframe();  //ie6 覆盖下拉框
	
	$('#searchContractCustomerDiv').dialog('open');
	$('#searchContractCustomerDiv').dialog('setTitle', '查找客户');
	
	return false;
	
}

//根据customer id设置ContractCustomer
function ajaxContractCustomer(customerId, dialogButton){
	
	$.ajax({
		type:"post",
		url: "./saleunit_new/appoint/guangzhou/saveContractCustomerFromCustomerId.action",
		data: "customerId=" + customerId,
		dataType: "json",
		success: function(data){
			if(data != "" && data != null){
				//保存成功

				$("#showContractCustomerId").attr("value", data.id);		
				$("#showContractCustomerId_update").attr("value", data.id);		
				
				$("#showContractCustomerName").html(data.name); //显示没有点击查看事件
				$("#phone").val(data.phone);
				
				$('#searchContractCustomerDiv').dialog('close');
				
			}else{				
				//保存失败
				
				dialogNewSugg(dialogButton, "<font color='red'>保存失败,请重试</font>");
			}
		}	
	});
	
}

//保存合同客户(新的)
function saveContractCustomerForNewDialog(typeVal, dialogButton){
	
	var contractCustomerName = $.trim($("#contractCustomerName").val());
	var contractCustomerPhone = $.trim($("#contractCustomerPhone").val());
	var contractCustomerGender = $.trim($("#contractCustomerGender").val());
	var contractCustomerIdcardType = $.trim($("#contractCustomerIdcardType").val());
	var contractCustomerIdcardNo = $.trim($("#contractCustomerIdcardNo").val());
	var contractCustomerAddress = $.trim($("#contractCustomerAddress").val());
	
	if(contractCustomerName == ""){
		//myAlert("客户名称不能为空");
		$("#contractCustomerName").focus();
		dialogNewSugg(dialogButton, "客户名称不能为空");
		return false;
	}
	
	if(contractCustomerPhone == ""){
		//myAlert("电话号码不合规则");
		$("#contractCustomerPhone").focus();
		dialogNewSugg(dialogButton, "电话号码不合规则");
		return false;
	}

	//$('#suggId').html('提交中...');
	dialogNewSugg(dialogButton, "提交中...");
	
	$.ajax({
		type:"post",
		url: "./saleunit_new/appoint/guangzhou/saveContractCustomerForDialog.action",
		data: "confirmCustomer.customerName=" + contractCustomerName + "&confirmCustomer.gender=" + contractCustomerGender 
			+ "&confirmCustomer.idcardType=" + contractCustomerIdcardType + "&confirmCustomer.idcardNo=" + contractCustomerIdcardNo
			+ "&confirmCustomer.phone=" + contractCustomerPhone + "&confirmCustomer.address=" + contractCustomerAddress
			+ "&confirmCustomer.confirmType=" + typeVal,
		dataType: "json",
		success: function(data){
			
			$("#contractCustomerName").val("");
			$("#contractCustomerGender").val("");
			$("#contractCustomerIdcardType").val("");
			$("#contractCustomerIdcardNo").val("");
			$("#contractCustomerPhone").val("");
			$("#contractCustomerAddress").val("");
			
			if(data != "" && data != null){
				//保存成功
				
				$('#contractCustomerDiv').dialog('close');
				
				//设置显示
				$("#showContractCustomerName").html(data.name); 
				//$("#showNewCreateContractCustomerName").bind('click', showContractCustomer()); //显示没有点击查看事件(加上点击修改事件2010-10-18)
				$("#phone").val(data.phone);
				
				//设置修改
				$("#showContractCustomerId").attr("value", data.id);		
				
				$("#showContractCustomerId_update").attr("value", data.id);	
				$("#showContractCustomerName_update").val(data.name);
				$("#showContractCustomerPhone").val(data.phone);
				$("#showContractCustomerGender").val(data.gender);
				
				$("#showContractCustomerIdcardType").val(data.idcardType);
				$("#showContractCustomerIdcardNo").val(data.idcardNo);
				$("#showContractCustomerAddress").val(data.address);
				
				
			}else{				
				//保存失败
				
				//$('#suggId').html("<font color='red'>保存失败,请重新新建</font>");
				dialogNewSugg(dialogButton, "<font color='red'>保存失败,请重新新建</font>");
			}
		}		
	});
}


//保存认购客户
function saveConfirmCustomerForDialog(typeVal){
	
	var confirmCustomerName = $.trim($("#confirmCustomerName").val());
	var confirmCustomerPhone = $.trim($("#confirmCustomerPhone").val());
	var confirmCustomerGender = $.trim($("#confirmCustomerGender").val());
	var confirmCustomerIdcardType = $.trim($("#confirmCustomerIdcardType").val());
	var confirmCustomerIdcardNo = $.trim($("#confirmCustomerIdcardNo").val());
	
	if(confirmCustomerName == ""){
		myAlert("客户名称不能为空");
		return false;
	}
	
	if(confirmCustomerPhone == ""){
		myAlert("电话号码不合规则");
		return false;
	}
	
	//$('#confirmCustomerForDialog').css('display', 'none');
	$('#suggId').html('提交中...');
	
	$.ajax({
		type:"post",
		url: "./saleunit_new/appoint/guangzhou/saveConfirmCustomerForDialog.action",
		data: "confirmCustomer.customerName=" + confirmCustomerName + "&confirmCustomer.gender=" + confirmCustomerGender 
			+ "&confirmCustomer.idcardType=" + confirmCustomerIdcardType + "&confirmCustomer.idcardNo=" + confirmCustomerIdcardNo
			+ "&confirmCustomer.phone=" + confirmCustomerPhone
			+ "&confirmCustomer.confirmType=" + typeVal,
		dataType: "json",
		success: function(data){
			
			$("#confirmCustomerName").val("");
			$("#confirmCustomerGender").val("");
			$("#confirmCustomerIdcardType").val("");
			$("#confirmCustomerIdcardNo").val("");
			$("#confirmCustomerPhone").val("");
			
			if(data != "" && data != null){
				//保存成功
				
				$('#confirmCustomerDiv').dialog('close');
				$('#suggId').html("");
				
				$("#showConfirmCustomerId").attr("value", data.id);
				$("#showConfirmCustomerName").html(data.name);
				$("#phone").val(data.phone);
				//$('#suggId').html("<font color='red'>保存成功</font>");
				
			}else{				
				//保存失败
				
				$('#suggId').html("<font color='red'>保存失败,请重新新建</font>");
			}
		}		
	});
}


//转签约
function changeToContract(confirmId){
	
	$.ajax({
		type:"get",
		url: "./saleunit_new/appoint/guangzhou/changeToContract.action",
		data: "confirmId=" + confirmId + "&unitDiscountId=" + $("#unitDiscountId").attr("value"),
		dataType: "json",
		success: function(data){
			
			if(data.type == "true"){
				
				$("#changeToContractButton").hide();
				
				myAlert("转签约成功");
				
			}else{
				
				if(data.error == "errorState"){
					myAlert("该单元状态不能转签约");
				}else{
					myAlert("转签约失败,请重新操作");
				}
			}
			
		}
		
	});
	
	return false;
}

//保存合同客户
function saveContractCustomerForDialog(typeVal){
	
	var contractCustomerName = $.trim($("#contractCustomerName").val());
	var contractCustomerPhone = $.trim($("#contractCustomerPhone").val());
	var contractCustomerGender = $.trim($("#contractCustomerGender").val());
	var contractCustomerIdcardType = $.trim($("#contractCustomerIdcardType").val());
	var contractCustomerIdcardNo = $.trim($("#contractCustomerIdcardNo").val());
	var contractCustomerAddress = $.trim($("#contractCustomerAddress").val());
	
	if(contractCustomerName == ""){
		myAlert("客户名称不能为空");
		return false;
	}
	
	if(contractCustomerPhone == ""){
		myAlert("电话号码不合规则");
		return false;
	}
	
	//$('#contractCustomerForDialog').css('display', 'none');
	$('#suggId').html('提交中...');
	
	$.ajax({
		type:"post",
		url: "./saleunit_new/appoint/guangzhou/saveContractCustomerForDialog.action",
		data: "confirmCustomer.customerName=" + contractCustomerName + "&confirmCustomer.gender=" + contractCustomerGender 
			+ "&confirmCustomer.idcardType=" + contractCustomerIdcardType + "&confirmCustomer.idcardNo=" + contractCustomerIdcardNo
			+ "&confirmCustomer.phone=" + contractCustomerPhone + "&confirmCustomer.address=" + contractCustomerAddress
			+ "&confirmCustomer.confirmType=" + typeVal,
		dataType: "json",
		success: function(data){
			
			$("#contractCustomerName").val("");
			$("#contractCustomerGender").val("");
			$("#contractCustomerIdcardType").val("");
			$("#contractCustomerIdcardNo").val("");
			$("#contractCustomerPhone").val("");
			$("#contractCustomerAddress").val("");
			
			if(data != "" && data != null){
				//保存成功
				
				$('#contractCustomerDiv').dialog('close');
				$('#suggId').html("");
				
				$("#showContractCustomerId").attr("value", data.id);
				$("#showContractCustomerId_update").attr("value", data.id);	
				
				$("#showContractCustomerName").html(data.name); //显示没有点击查看事件
				$("#phone").val(data.phone);
				//$('#suggId').html("<font color='red'>保存成功</font>");
				
			}else{				
				//保存失败
				
				$('#suggId').html("<font color='red'>保存失败,请重新新建</font>");
			}
		}		
	});
}

function toShowImageIframe(unitId){
	
	$.ajax({
		type:"post",
		url: "./saleunit_new/appoint/guangzhou/getUnitImageIsCanShow.action",
		data: "unitId=" + unitId,
		dataType: "html",
		success: function(data){
			
			if(data != ""){
				
				$("#unitImageDialog").dialog({
					resizable: true,
					modal:true, //模态窗口,表示不能操作弹出框以外的内容
					maximizable: true, //显示最大化按钮
					onClose:function(){
						$('#show_image_dialog_ifram').attr("src", "./saleunit_new/guangzhou/loading.jsp"); //清空内容
					},
					buttons:[{
						text:'关闭',
						iconCls:'icon-cancel',
						handler:function(){
							$('#unitImageDialog').dialog('close');
						}
					}]
					
				});
					
				$('#unitImageDialog').dialog('open');
				
				$('#show_image_dialog_ifram')[0].src='./saleunit_new/appoint/guangzhou/toShowImageIframe.action?unitId=' + unitId; 
			}else{
				myAlert("该单元没有图片");
			}
			
			return false;
			
		}		
	});
	
	return false;
}

function toShowImage(){
	var hiddenUnitId = $("#hiddenUnitId").val();
		
	if(hiddenUnitId == undefined || hiddenUnitId == "" || hiddenUnitId == "0"){
		myAlert("请先选择单元");
		return false;
	}
	
	return showImage(hiddenUnitId);
	//return toShowImageIframe(hiddenUnitId);
	
	//return false;
}

//查看单元图片
function showImage(unitId){
	
	$.ajax({
		type:"post",
		url: "./saleunit_new/appoint/guangzhou/getUnitImageUrl.action",
		data: "unitId=" + unitId,
		dataType: "html",
		success: function(data){
			
			if(data != ""){
				
				$("#unitImageDialogImgId").attr("src", data);
				
				$("#unitImageDialog").dialog({
					resizable: true,
					modal:true, //模态窗口,表示不能操作弹出框以外的内容
					maximizable: true, //显示最大化按钮
					onClose:function(){
						
					},
					buttons:[{
						text:'关闭',
						iconCls:'icon-cancel',
						handler:function(){
							$('#unitImageDialog').dialog('close');
						}
					}]
				});
				
				$('#unitImageDialog').dialog('open');
			}else{
				myAlert("该单元没有图片");
			}
			
			return false;
			
		}		
	});
	
	return false;
	
}

function toUnloadImage(){
	var hiddenUnitId = $("#hiddenUnitId").val();
		
	if(hiddenUnitId == undefined || hiddenUnitId == "" || hiddenUnitId == "0"){
		myAlert("请先选择单元");
		return false;
	}
	
	unloadImage(hiddenUnitId);
	return false;
}

//单元图片上传
function unloadImage(unitId){
	
	$("#uploadUnitImageDialog").dialog({
		resizable: true,
		modal:true, //模态窗口,表示不能操作弹出框以外的内容
		maximizable: false, //显示最大化按钮
		onOpen:function(){

			$('#upload_image_dialog_iframe')[0].src = "./saleunit_new/appoint/guangzhou/toUploadUnitImage.action?unitId=" + unitId;
			
			var tab = $("#upload_image_dialog_iframe").contents();
			tab.find("#type").val("");
			tab.find("#context").val("");
			tab.find("#unitImage").val("");
			tab.find("#uploadSuggestion").html("");
		},
		onClose:function(){

			$('#upload_image_dialog_iframe')[0].src = "./saleunit_new/guangzhou/loading.jsp";  //还原	

			toGetUnitImageInfo(unitId);
			
		},
		buttons:[{
			text:'提交',
			iconCls:'icon-ok',
			handler:function(){
				
				var ids = ["unitImage"];				
				dialogIframeSubmit("upload_image_dialog_iframe", ids, "upload", this);
			}
		},
		{
			text:'关闭',
			iconCls:'icon-cancel',
			handler:function(){
				$('#uploadUnitImageDialog').dialog('close');
			}
		}]
	});
	
	$('#uploadUnitImageDialog').dialog('open');
	
}

//关闭图片上传弹出框
function closeUpload(){
	
	//window.setInterval(function(){$('#uploadUnitImageDialog').dialog('close');}, 1000);
	//$("#sale_tabs").panel("maximize");
	
	$('#uploadUnitImageDialog').dialog('close');
	
	var unitId = $("#hiddenUnitId").val();
	toGetUnitImageInfo(unitId);

}

function toGetUnitImageInfo(unitId){
	
	$.ajax({
		type:"post",
		url: "./saleunit_new/appoint/guangzhou/getUnitImageInfo.action",
		data: "unitId=" + unitId,
		dataType: "html",
		success: function(data){
			
			//先删除除了第一行的内容
			
			$(".imageTr:gt(0)").remove();
			if(data != ""){
				//$("#imageTable").appendTo();				
				 $(data).insertAfter($("#imageTable tr:eq(0)")); 
				
			}
			
		}		
	});
}

function showImageDiv(src){
	
	new MyAjaxIframeDialog({title:'查看图片', src:src, width:800, height:600, buttons:false});	
	
	
	/**
	
	$("#unitImageDialogImgId").attr("src", data);
	
	$("#unitImageDialog").dialog({
		resizable: true,
		modal:true, //模态窗口,表示不能操作弹出框以外的内容
		maximizable: true, //显示最大化按钮
		width:800,
		height:600,
		onClose:function(){
			
		}
	});
		
	//$('#unitImageDialog').dialog('maximize');
	$('#unitImageDialog').dialog('open');
	*/
	return false;
}


function deleteImage(imageId, rowNo){
	
	var retFun = function(){
		
		$.ajax({
			type:"post",
			url: "./saleunit_new/appoint/guangzhou/deleteUnitImage.action",
			data: "imageId=" + imageId,
			dataType: "html",
			success: function(data){
				
				if(data != ""){
					
					//$(".imageTr:eq(" +  rowNo + ")").remove();
					var unitId = $("#hiddenUnitId").val();
					toGetUnitImageInfo(unitId);
				}else{
					
					myAlert("删除失败,请重试.");
				}
				
			}		
		});
		
	};
	myConfirm("确定删除该图片?", retFun);
	
	/**
	var r = confirm("确定删除该图片?");
	if(r == true){
		
		$.ajax({
			type:"post",
			url: "./saleunit_new/appoint/guangzhou/deleteUnitImage.action",
			data: "imageId=" + imageId,
			dataType: "html",
			success: function(data){
				
				if(data != ""){
					
					//$(".imageTr:eq(" +  rowNo + ")").remove();
					var unitId = $("#hiddenUnitId").val();
					toGetUnitImageInfo(unitId);
				}else{
					
					myAlert("删除失败,请重试.");
				}
				
			}		
		});
		
		return false;
		
	}
	*/
	return false;
}

//置业计划弹出框
function showCalcDialog(){
	
	var unitId = $("#hiddenUnitId").val();
			
	parent.$("#myIframeDialog").dialog({
		resizable: false,
		modal:true, //模态窗口,表示不能操作弹出框以外的内容
		maximizable: false, //显示最大化按钮
		width:400,
		height:160,
		onOpen:function(){
						
		},
		onClose:function(){
			
			parent.$('#openIframe')[0].src = "./saleunit_new/guangzhou/loading.jsp";  //还原
		},
		buttons:[]
		
	});
	
	parent.$('#myIframeDialog').dialog('open');
	parent.$('#myIframeDialog').dialog('setTitle', '置业计划');
	
	parent.$('#openIframe')[0].src = "./saleunit_new/appoint/guangzhou/getUnitInfoForCalc.action?unitId=" + unitId;
	
	return false;
	
}

var closeMessageInt = ""; //提示框的指引
var showCount = 1;

//弹出框提醒
function message(title, msg){
	
	$.messager.show({
		title: title,
		msg: msg,// + "<a href='#' style='color:#1199FF; text-decoration:underline; float:right; padding: 20px 0px 0px 0px' onclick='return closeMessage()'>关闭提醒<a>",
		timeout: 0,
		showType:'slide'
	});
	
	/*
	if(showCount <= 5){
		
		$.messager.show({
			title: title,
			msg: msg + "<a href='#' style='color:#1199FF; text-decoration:underline; float:right; padding: 20px 0px 0px 0px' onclick='return closeMessage()'>关闭提醒<a>",
			timeout: 5000,
			showType:'slide'
		});
		
		showCount++;
		
	}else{
		closeMessage();
	}
	*/
}

function messageShow(title){
	
	window.setTimeout(function(){ajaxMessage(title);}, 10000); //只执行一次
		
}

function ajaxMessage(title){
	
	$.ajax({
		type:"get",
		url: "./saleunit_new/appoint/guangzhou/getAjaxExtensionContract.action",
		dataType: "html",
		success: function(data){
			
			//获取对应的延期签约内容
			if(data != ""){
				//closeMessageInt = window.setInterval(function(){message(title, data);}, 10000);
				//window.setTimeout(function(){message(title, data);}, 10000); //只执行一次
				//message(title, data); //暂时注释
			}
		}		
	});
}

function closeMessage(){
	if(closeMessageInt != ""){
		window.clearInterval(closeMessageInt);
		closeMessageInt = "";
		showCount = 1;
	}
	return false;
}

//增加延期签约
function extensionContractAddDiv(){
	
	var hiddenUnitId = $("#hiddenUnitId").val();
	var conCustomerId = $("#conCustomerId").val();
		
	if(hiddenUnitId == undefined || hiddenUnitId == "" || hiddenUnitId == "0"){
		myAlert("请先选择单元");
		return false;
	}	
	
	if(conCustomerId == undefined || conCustomerId == "" || conCustomerId == "0"){
		myAlert("请先选择客户");
		return false;
	}	
	
	parent.$("#myIframeDialog").dialog({
		resizable: true,
		modal:true, //模态窗口,表示不能操作弹出框以外的内容
		maximizable: true, //显示最大化按钮
		width:450,
		height:450,
		onOpen:function(){
						
		},
		onClose:function(){
			
			parent.$('#openIframe')[0].src = "./saleunit_new/guangzhou/loading.jsp";  //还原
			
			var utabs = $("#_extension_contract");
			utabs.load("./saleunit_new/appoint/guangzhou/extensionContractList.action?id="+click_unit_id+"");			
			
		},
		buttons:[{
			text:'提交',
			iconCls:'icon-ok',
			handler:function(){
				
				var ids = ["applyTime:datebox", "newApplyTime:datebox", "extensionFirst"];				
				dialogIframeSubmit("openIframe", ids, "addExtensionContractForm", this);
				
			}
		},{
			text:'关闭',
			iconCls:'icon-cancel',
			handler:function(){
				parent.$('#myIframeDialog').dialog('close');
			}
		}]
		
	});
	
	parent.$('#myIframeDialog').dialog('open');
	parent.$('#myIframeDialog').dialog('setTitle', '新增延期签约');
	
	parent.$('#openIframe')[0].src = "./saleunit_new/appoint/guangzhou/toAddExtensionContract.action?unitId=" + hiddenUnitId + "&customerId=" + conCustomerId;
	
	return false;	
	
}

//关闭新建延期签约
function closeExtension(){
	
	parent.$('#myIframeDialog').dialog('close');

}

//关闭更新延期签约
function closeUpdateExtension(){
	
	parent.$('#myIframeDialog').dialog('close');
}

//判断为查看or更新延期签约
function canShowOrUpdate(isUpdate){
	
	var getExId = $(".exChangetd").attr("exId");
	if(getExId == '0' || getExId == undefined || getExId == ""){
		
		if(isUpdate){
			
			myAlert("请先选择要修改的内容");
		}else{
			
			myAlert("请先选择要查看的内容");
		}		
		return false;
	}else{
	
		if(isUpdate){
			
			extensionContractUpdateDiv(getExId);
		}else{
			
			extensionContractShowDiv(getExId);
		}
		return false;
	}
} 

//查看延期签约
function extensionContractShowDiv(exId){
	
	parent.$("#myIframeDialog").dialog({
		resizable: true,
		modal:true, //模态窗口,表示不能操作弹出框以外的内容
		maximizable: true, //显示最大化按钮
		width:450,
		height:450,
		onOpen:function(){
						
		},
		onClose:function(){
			
			parent.$('#openIframe')[0].src = "./saleunit_new/guangzhou/loading.jsp";  //还原
			
		},
		buttons:[]
		
	});
	
	parent.$('#myIframeDialog').dialog('open');
	parent.$('#myIframeDialog').dialog('setTitle', '查看延期签约');
	
	parent.$('#openIframe')[0].src = "./saleunit_new/appoint/guangzhou/showExtensionContract.action?exId=" + exId;
	
	return false;	
	
}

function extensionContractUpdateDiv(exId){
	
	parent.$("#myIframeDialog").dialog({
		resizable: false,
		modal:true, //模态窗口,表示不能操作弹出框以外的内容
		maximizable: true, //显示最大化按钮
		width:450,
		height:450,
		onOpen:function(){
						
		},
		onClose:function(){
			
			parent.$('#openIframe')[0].src = "./saleunit_new/guangzhou/loading.jsp";  //还原
			
			var utabs = $("#_extension_contract");
			utabs.load("./saleunit_new/appoint/guangzhou/extensionContractList.action?id="+click_unit_id+"");	
			
		},
		buttons:[{
			text:'提交',
			iconCls:'icon-ok',
			handler:function(){
				
				var ids = ["applyTime", "newApplyTime", "extensionFirst"];				
				dialogIframeSubmit("openIframe", ids, "updateExtensionContractForm", this);
			}
		},{
			text:'关闭',
			iconCls:'icon-cancel',
			handler:function(){
				parent.$('#myIframeDialog').dialog('close');
			}
		}]
		
	});
	
	parent.$('#myIframeDialog').dialog('open');
	parent.$('#myIframeDialog').dialog('setTitle', '修改延期签约');
	
	parent.$('#openIframe')[0].src = "./saleunit_new/appoint/guangzhou/toUpdateExtensionContract.action?exId=" + exId;
	
	return false;	
	
}

//删除
function canDelete(){
	
	var getExId = $(".exChangetd").attr("exId");
	if(getExId == '0' || getExId == undefined || getExId == ""){
		
		myAlert("请先选择要删除的内容");
		return false;
	}else{
		
		var retFun = function(){
			
			$.ajax({
				type:"get",
				url: "./saleunit_new/appoint/guangzhou/deleteEx.action",
				data: "exId=" + getExId,
				dataType: "html",
				success: function(data){
					
					if(data == "true"){
						
						var utabs = $("#_extension_contract");
						utabs.load("./saleunit_new/appoint/guangzhou/extensionContractList.action?id="+click_unit_id+"");
					}else{
						
						myAlert("删除失败,请重试.");
					}
					
				}		
			});			
			
		}
		myConfirm("确定要删除?", retFun);
		
		/**
		var isDelete = confirm("确定要删除?");
		if(isDelete){
			
			$.ajax({
				type:"get",
				url: "./saleunit_new/appoint/guangzhou/deleteEx.action",
				data: "exId=" + getExId,
				dataType: "html",
				success: function(data){
					
					if(data == "true"){
						
						var utabs = $("#_extension_contract");
						utabs.load("./saleunit_new/appoint/guangzhou/extensionContractList.action?id="+click_unit_id+"");
					}else{
						
						myAlert("删除失败,请重试.");
					}
					
				}		
			});						
						
		}
		*/
		return false;
	}
	
}

//重新绑定td的事件
function reBindTd(){
	
	$("#unitTable td").bind({
			 			 
		click:function(){tdClick(this);},
		//给单元格加鼠标经过的背景颜色
		mouseover:function(){tdOver(this);},  
		mouseout:function(){tdOut(this);}  
		
	 });	
}

//退房(type:认购或签约, mainId:认购或签约单的id, unitId:单元id)
function checkOut(type, mainId, unitId){
	
	var url = "";
	if(type == "confirm"){
		url = "./saleunit_new/appoint/guangzhou/confirmCheckOut.action";
	}
	
	if(type == "contract"){
		url = "./saleunit_new/appoint/guangzhou/contractCheckOut.action";
	}
	
	if(url != ""){
		$.ajax({
			type:"get",
			url: url,							
			data: "mainId=" + mainId + "&unitId=" + unitId,
			dataType: "html",
			success: function(data){								
				
				if(data == "true"){
					myAlert("退房成功");
					$("#checkOutId").hide(); //隐藏"退房"按钮
					$("#checkOutId").attr("isReload", "true"); //增加刷新标示isReload
				}
				
			}		
		});			
	}
	
	return false;	
}

function dialogCheckOut(type, mainId, unitId, dialogButton, dilogId){
	
	var url = "";
	if(type == "confirm"){
		url = "./saleunit_new/appoint/guangzhou/confirmCheckOut.action";
	}
	
	if(type == "contract"){
		url = "./saleunit_new/appoint/guangzhou/contractCheckOut.action";
	}
	
	if(url != ""){
		$.ajax({
			type:"get",
			url: url,							
			data: "mainId=" + mainId + "&unitId=" + unitId,
			dataType: "html",
			success: function(data){								
				
				if(data == "true"){
					
					dialogButtonSugg("退房成功", dialogButton);
					$(dialogButton).hide();					
					
					closeParentDialogTimeout(dilogId, 1000);
					
				}else{
					
					dialogButtonSugg("退房失败,请重新操作", dialogButton);
				}
				
			}		
		});			
	}
}

//临定 TEMP_CONFIRM
function createTempConfirmDialog(unitId){	

	if(unitId == "" || unitId == "0" || unitId == undefined){
		
		return false;
	}
	
	new MyAjaxIframeDialog({title:'新建临定', width:800, height:600,
		formId:'confirmBookFormId', src:'./saleunit_new/appoint/guangzhou/toCreateConfirmBookDialog.action?unitId=' + unitId,
		ids:["customerName", "phone", "bookMoney:money"],
		closeFn:gotoRefreshFn, closeFnArg:["openIframe", "reHiddenId", "isReload"]
	});
		
	/**
	parent.$("#myIframeDialog").dialog({
		resizable: true,
		modal:true, //模态窗口,表示不能操作弹出框以外的内容
		maximizable: true, //显示最大化按钮
		width:800,
		height:500,
		onClose:function(){
			//refreshFn();
			
			gotoRefreshFn("openIframe", "reHiddenId", "isReload");
			parent.$('#openIframe').attr("src", "./saleunit_new/guangzhou/loading.jsp"); //清空内容
		},
		buttons:[{
			text:'提交',
			iconCls:'icon-ok',
			handler:function(){
				
				var ids = ["customerName", "phone", "bookMoney:money"];				
				dialogIframeSubmit("openIframe", ids, "tempConfirmFormId", this);
								
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
	parent.$('#myIframeDialog').dialog('setTitle', '新建临定');
	
	//$('#openIframe')[0].src='./saleunit_new/appoint/guangzhou/createConfirmDialog.action?unitId=' + unitId; 
	parent.$('#openIframe')[0].src='./saleunit_new/appoint/guangzhou/createTempConfirmDialog.action?unitId=' + unitId;
	*/
	
	return false;
}

//查看修改临定
function showTempConfirmDialog(confirmBookId){
	
	if(confirmBookId == "" || confirmBookId == "0" || confirmBookId == undefined){
		
		return false;
	}
	
	new MyAjaxIframeDialog({title:'查看临定', width:800, height:600,
		formId:'confirmBookFormId', src:'./saleunit_new/appoint/guangzhou/toShowConfirmBookDialog.action?confirmBookId=' + confirmBookId,
		ids:["customerName", "phone", "bookMoney:money"],
		closeFn:gotoRefreshFn, closeFnArg:["openIframe", "checkOutId", "isReload"]
	});
		
	/**
	parent.$("#myIframeDialog").dialog({
		resizable: true,
		modal:true, //模态窗口,表示不能操作弹出框以外的内容
		maximizable: true, //显示最大化按钮
		width:800,
		height:600,
		onClose:function(){

			gotoRefreshFn("openIframe", "checkOutId", "isReload");
			//gotoRefreshFn("openIframe", "reHiddenId", "isReload");
			parent.$('#openIframe').attr("src", "./saleunit_new/guangzhou/loading.jsp"); //清空内容
		},
		buttons:[				 
		{
			text:'提交',
			iconCls:'icon-ok',
			handler:function(){
				
				var ids = ["customerName", "phone", "bookMoney:money"];				
				dialogIframeSubmit("openIframe", ids, "tempConfirmFormId", this);
				
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
	parent.$('#myIframeDialog').dialog('setTitle', '查看临定');
	
	//$('#openIframe')[0].src='./saleunit_new/appoint/guangzhou/showConfirmDialog.action?confirmId=' + confirmId; 
	parent.$('#openIframe')[0].src='./saleunit_new/appoint/guangzhou/showTempConfirmDialog.action?tempConfirmId=' + tempConfirmId;
	*/
	
	return false;	
}

//只是查看认购,不能修改
function showTempConfirmDialogOnly(confirmId){
	
	if(confirmId == "" || confirmId == "0" || confirmId == undefined){
		
		return false;
	}
		
	parent.$("#myIframeDialog").dialog({
		resizable: true,
		modal:true, //模态窗口,表示不能操作弹出框以外的内容
		maximizable: true, //显示最大化按钮
		width:800,
		height:500,
		onClose:function(){

			parent.$('#openIframe').attr("src", "./saleunit_new/guangzhou/loading.jsp"); //清空内容
		},
		buttons:[] //因为用的是同一个dialog,所以每一次都要重新初始化底部按钮
	});
		
	parent.$('#myIframeDialog').dialog('open');
	parent.$('#myIframeDialog').dialog('setTitle', '查看临定');

	parent.$('#openIframe')[0].src='./saleunit_new/appoint/guangzhou/showTempConfirmDialog.action?confirmId=' + confirmId;
	
	return false;	
}

//新增销售(废弃),使用modifySale()
function searchSale(){
	
	$("#myIframeDialog").dialog({
		resizable: true,
		modal:true, //模态窗口,表示不能操作弹出框以外的内容
		maximizable: true, //显示最大化按钮
		width:420,
		height:350,
		onClose:function(){

			$('#openIframe').attr("src", "./saleunit_new/guangzhou/loading.jsp"); //清空内容
		},
		buttons:[				 
		{
			text:'提交',
			iconCls:'icon-ok',
			handler:function(){
				
				var idArray = new Array(); //应该把之前的值保存进去,
				var nameArray = new Array();
				
				var salesId = $("#salesId").val(); //之前保存的id值
				if(salesId != ""){
					var oldIds = salesId.split(",");
					$(oldIds).each(function(index){
						
						idArray.push(oldIds[index]);	
					});
				}
				var salesName = $("#salesName").val();
				if(salesName != ""){
					var oldNames = salesName.split(",");
					$(oldNames).each(function(index){
						
						nameArray.push(oldNames[index]);	
					});
				}
				
				var contentWindow = $("#openIframe")[0].contentWindow;
				
				var companyId = contentWindow.$("#commpanySaleId").val();
				if(companyId != ""){
					idArray.push(companyId);
					nameArray.push(contentWindow.$("#companySaleName").val());
				}
				
				var projectIds = contentWindow.$("input[name=sale]");
				$(projectIds).each(function(){

					if($(this).attr("checked") == "checked"){
						
						var getId = $(this).attr("value");
						if(!isArrayInclude(idArray, getId)){
							idArray.push(getId);
							nameArray.push($(this).attr("label"));
						}						
					}
				});
				
				var ids = idArray.join(",");
				var names = nameArray.join(",");
				
				$("#salesName").val(names);
				$("#salesId").val(ids);
				
				$('#myIframeDialog').dialog('close');
								
			}
		},
		{
			text:'关闭',
			iconCls:'icon-cancel',
			handler:function(){
				$('#myIframeDialog').dialog('close');
			}
		}]
	});
		
	$('#myIframeDialog').dialog('open');
	$('#myIframeDialog').dialog('setTitle', '新增销售');

	$('#openIframe')[0].src = './saleunit_new/appoint/guangzhou/searchSale.action';
	
	return false;	
}

//删除销售(废弃),移动modifySale()
function deleteSale(){
	
	var salesId = $("#salesId").val(); //之前保存的id值
	if(salesId == ""){
		
		myAlert("没有选择销售");
		return false;
	}
	var salesName = $("#salesName").val();
	
	$("#myIframeDialog").dialog({
		resizable: true,
		modal:true, //模态窗口,表示不能操作弹出框以外的内容
		maximizable: true, //显示最大化按钮
		width:420,
		height:350,
		onClose:function(){

			$('#openIframe').attr("src", "./saleunit_new/guangzhou/loading.jsp"); //清空内容
		},
		buttons:[				 
		{
			text:'提交',
			iconCls:'icon-ok',
			handler:function(){
				
				var idArray = new Array(); 
				var nameArray = new Array();
				
				var contentWindow = $("#openIframe")[0].contentWindow;
				
				var projectIds = contentWindow.$("input[name=sale]");
				$(projectIds).each(function(){

					if($(this).attr("checked") != "checked"){
						
						var getId = $(this).attr("value");
						idArray.push(getId);
						nameArray.push($(this).attr("label"));						
					}
				});
				
				var ids = idArray.join(",");
				var names = nameArray.join(",");
				
				$("#salesName").val(names);
				$("#salesId").val(ids);
				
				$('#myIframeDialog').dialog('close');
								
			}
		},
		{
			text:'关闭',
			iconCls:'icon-cancel',
			handler:function(){
				$('#myIframeDialog').dialog('close');
			}
		}]
	});
		
	$('#myIframeDialog').dialog('open');
	$('#myIframeDialog').dialog('setTitle', '删除销售');

	$('#openIframe')[0].src = './saleunit_new/appoint/guangzhou/deleteSale.action?salesId=' + salesId + "&salesName=" + salesName;
	
	return false;
	
}

//管理销售(移到saleunit_sale.js中)
/**
function modifySale(salesTextId, salesTextName){
	
	var salesId = $("#" + salesTextId).val(); //之前保存的id值	
	var salesName = $("#" + salesTextName).val();
	
	$("#myIframeDialog").dialog({
		resizable: true,
		modal:true, //模态窗口,表示不能操作弹出框以外的内容
		maximizable: true, //显示最大化按钮
		width:420,
		height:400,
		onClose:function(){

			$('#openIframe').attr("src", "./saleunit_new/guangzhou/loading.jsp"); //清空内容
		},
		buttons:[				 
		{
			text:'提交',
			iconCls:'icon-ok',
			handler:function(){
				
				var idArray = new Array(); //应该把之前的值保存进去,
				var nameArray = new Array();
				
				var contentWindow = $("#openIframe")[0].contentWindow;
				
				var companyId = contentWindow.$("#commpanySaleId").val();
				if(companyId != ""){
					idArray.push(companyId);
					nameArray.push(contentWindow.$("#companySaleName").val());
				}
				
				var projectIds = contentWindow.$("input[name=sale]");
				$(projectIds).each(function(){

					if($(this).attr("checked") == "checked"){
						
						var getId = $(this).attr("value");
						if(!isArrayInclude(idArray, getId)){
							idArray.push(getId);
							nameArray.push($(this).attr("label"));
						}						
					}
				});
				
				var ids = idArray.join(",");
				var names = nameArray.join(",");
				
				$("#" + salesTextName).val(names);
				$("#" + salesTextId).val(ids);

				$('#myIframeDialog').dialog('close');
								
			}
		},
		{
			text:'关闭',
			iconCls:'icon-cancel',
			handler:function(){
				$('#myIframeDialog').dialog('close');
			}
		}]
	});
		
	$('#myIframeDialog').dialog('open');
	$('#myIframeDialog').dialog('setTitle', '选择销售');

	$('#openIframe')[0].src = './saleunit_new/appoint/guangzhou/modifySale.action?salesId=' + salesId + "&salesName=" + salesName;
	
	return false;
}
*/
