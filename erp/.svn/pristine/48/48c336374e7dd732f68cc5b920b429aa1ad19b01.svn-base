/**
 *
 *  折扣管理,mainId和confirmType为空的时候表示在新建认购或合同的界面调用该方法,不为空表示在更新认购或合同的界面调用该方法
 */
 
function createDiscountDialog(unitId, mainId, confirmType){
	
	$("#discountManagerDialog").dialog({
		resizable: true,
		modal:true, //模态窗口,表示不能操作弹出框以外的内容
		maximizable: false, //是否显示最大化按钮
		width:600,
		height:400,
		onClose:function(){
			
			$('#discountManagerIframe').attr("src", "./saleunit_new/guangzhou/loading.jsp"); //清空内容
		},
		buttons:[{
			text:'提交',
			iconCls:'icon-ok',
			handler:function(){
				
				//$('#discountManagerIframe').contents().find("#createDiscountManagerFormId").submit();				
				$("#discountManagerIframe")[0].contentWindow.formSubmit();
				
			}
		},
		{
			text:'关闭',
			iconCls:'icon-cancel',
			handler:function(){
				
				$("#discountManagerDialog").dialog("close");
			}
		}]
		
	});
		
	$('#discountManagerDialog').dialog('open');
	$('#discountManagerDialog').dialog('setTitle', '新增折扣'); 
	
	$('#discountManagerIframe')[0].src='./saleunit_new/appoint/guangzhou/createDiscountDialog.action?unitId=' + unitId
		+ "&mainId=" + mainId + "&confirmType=" + confirmType;
	
	return false;
}

//关闭折扣管理新建弹出框
function closeDiscount(unitDiscountId){
	
	$("#unitDiscountId").attr("value" , unitDiscountId); //设置隐藏域
	discountDetailToShow(unitDiscountId, "addDiscountId"); //显示其选中的折扣,并可以编辑
	
	$('#discountManagerDialog').dialog('close');
}

//设置折扣的详细显示,第二个参数为返回的值放到其前面,并绑定编辑事件,
function discountDetailToShow(unitDiscountId, modifyDiscountId){
	
	$.ajax({
		type:"get",
		url: "./saleunit_new/appoint/guangzhou/getDiscountDetailShowByDiscountId.action",
		data: "unitDiscountId=" + unitDiscountId + retAction(),
		dataType: "json",
		success: function(data){
			
			if(data != ""){
				
				var updateHref = '<a href="#" id="modifyDiscountId" style="float:left;" onclick="return createUpdateDiscountDialog(' 
					+ unitDiscountId + ')"><font color="#5482DE">' + data.detail + '</font></a>';
				
				$("#" + modifyDiscountId).parent().html(updateHref);			
				
				//设置房间总价及合同总价=房间总价+装修总价,并设置"建筑成交单价","套内成交单价";建筑成交单价=成交总价/建筑面积;套内成交单价=成交总价/套内面积
				setUnitSumMoneyAndContractMoneyAndOther(data);
				
			}
		}		
	});			
	
}

//获取要回传的几个字段的值
function retAction(){
	
	var sumPrice = $("#unitSumPriceId").val(); //标准总价
	//var buildPrice = $("#unitBuildPriceId").val(); //建筑单价
	//var insidePrice = $("#unitInsidePriceId").val(); //套内单价
	var buildArea = $("#hiddenBuildAreaId").val(); //建筑面积 
	var insideArea = $("#hiddenInsideAreaId").val(); //套内面积
	
	return "&sumPrice=" + sumPrice + "&buildArea=" + buildArea + "&insideArea=" + insideArea;
}

//根据比例获取金额并设置到对应的组件
function multiplyPercent(fromId, toId, percent){
	
	var fromMoney = $("#" + fromId).html();
	var toMoney = Math.round(fromMoney * percent);
	$("#" + toId).val(toMoney);
	
}

//设置房间总价及合同总价=房间总价+装修总价,
/**房间总价的计算方式
	(1)	先加附加再优惠减价再折 
	计算方式：（标准总价+附加价-优惠减价）×折扣 
	(2)	先折再附加价再优惠减价 
	计算方式：标准总价×折扣+附加价-优惠减价 
	(3)	先优惠减价再折再附加价 
	计算方式：（标准总价-优惠减价）×折扣+附加价 
*/
//设置房间总价及合同总价=房间总价+装修总价,并设置"建筑成交单价","套内成交单价";建筑成交单价=成交总价/建筑面积;套内成交单价=成交总价/套内面积
function setUnitSumMoneyAndContractMoneyAndOther(data){

	$("#sumMoney").val(data.sumMoney); //成交总价
	$("#tmpSumMoney").val(data.sumMoney); //隐藏成交总价,用于该输入框的blur()事件
	$("#buildPrice").val(data.buildPrice); //建筑成交单价
	$("#insideUnitPrice").val(data.insidePrice); //套内成交单价
	//$("#contractMoney").val(data.contractMoney); //合同总价
	
	$("#discountPercent").val(data.multiply); //具体的折扣
	
}

//查看修改折扣
function createUpdateDiscountDialog(unitDiscountId){
	
	$("#discountManagerDialog").dialog({
		resizable: true,
		modal:true, //模态窗口,表示不能操作弹出框以外的内容
		maximizable: false, //是否显示最大化按钮
		width:600,
		height:400,
		onClose:function(){
			
			$('#discountManagerIframe').attr("src", "./saleunit_new/guangzhou/loading.jsp"); //清空内容
		},
		buttons:[{
			text:'提交',
			iconCls:'icon-ok',
			handler:function(){
				
				//$('#discountManagerIframe').contents().find("#createDiscountManagerFormId").submit();				
				$("#discountManagerIframe")[0].contentWindow.formSubmit();
				
			}		
		},
		{
			text:'关闭',
			iconCls:'icon-cancel',
			handler:function(){
				
				$("#discountManagerDialog").dialog("close");
			}
		}]
		
	});
		
	$('#discountManagerDialog').dialog('open');
	$('#discountManagerDialog').dialog('setTitle', '查看折扣'); 
	
	$('#discountManagerIframe')[0].src='./saleunit_new/appoint/guangzhou/forUpdateDiscountDialog.action?unitDiscountId=' + unitDiscountId; 	
	
	return false;
}

//关闭折扣管理修改弹出框
function closeUpdateDiscount(unitDiscountId){
	
	$("#unitDiscountId").attr("value" , unitDiscountId); //设置隐藏域
	discountDetailToShow(unitDiscountId, "modifyDiscountId"); //显示其选中的折扣,并可以编辑,且根据公式(标准总价),算出房间总价
	
	$('#discountManagerDialog').dialog('close');
}

//下面的为单元折扣的折扣
//新增折扣
function createUnitDiscountDialog(payWayValId, unitId, mainId, confirmType){
	
	var payWayId = $("#" + payWayValId).val();

	if(payWayId == "" || payWayId == "0" || payWayId == undefined){
		
		myAlert("请选确定付款方式");
		return false;
	}

	$("#myIframeDialog").dialog({
		resizable: true,
		modal:true, //模态窗口,表示不能操作弹出框以外的内容
		maximizable: true, //显示最大化按钮
		width:600,
		height:300,
		onClose:function(){
		
			$('#openIframe').attr("src", "./saleunit_new/guangzhou/loading.jsp"); //清空内容
		},
		buttons:[{
			text:'提交',
			iconCls:'icon-ok',
			handler:function(){

				var content = $.easyIframeContentWindow("openIframe");		
				var ways = content.$("input[name='unitDiscount.computeWay']");
				if(!isCheckboxCheck(ways)){
					dialogButtonSugg("折扣方式不能为空", this);
					return false;
				}
				
				dialogButtonSugg("提交中...", this);
				$(this).linkbutton({disabled:true}); //禁用"提交"按钮,避免重复提交
				
				content.$("#createUnitDiscountManagerFormId").submit();
				clearDialogButtonSugg(2000);
				
				//dialogIframeSubmit("openIframe", "", "createUnitDiscountManagerFormId", this); //这样有问题?
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
	
	$('#myIframeDialog').dialog('setTitle', '新增折扣'); 
	
	$('#openIframe')[0].src='./unit_discount/manager/createUnitDiscountDialog.action?unitId=' + unitId
		+ "&mainId=" + mainId + "&confirmType=" + confirmType + "&payWayId=" + payWayId;
	
	return false;
}

//关闭单元折扣dialog的执行函数
function closeUnitDiscountManagerFn(unitDiscountId){
	
	$("#unitDiscountId").attr("value" , unitDiscountId); //设置隐藏域
	getUnitDiscountManagerCloseShowByDiscountId(unitDiscountId, "addDiscountId"); //显示其选中的折扣,并可以编辑,且根据公式(标准总价),算出房间总价
}

//设置折扣的详细显示,第二个参数为返回的值放到其前面,并绑定编辑事件,
function getUnitDiscountManagerCloseShowByDiscountId(unitDiscountId, modifyDiscountId){
	
	$.ajax({
		type:"get",
		url: "./unit_discount/manager/getUnitDiscountManagerCloseShowByDiscountId.action",
		data: "unitDiscountId=" + unitDiscountId + retAction(),
		dataType: "json",
		success: function(data){
			
			if(data != ""){
				
				//var updateHref = '<a href="javascript:void(0)" id="modifyDiscountId" style="float:left;" onclick="return createUpdateUnitDiscountDialog(' 
					//+ unitDiscountId + ')"><font color="#5482DE">' + data.detail + '</font></a>';
				
				var updateHref = '<a href="javascript:void(0)" id="modifyDiscountId" style="float:left;"><font color="#5482DE">' + data.detail + '</font></a>';
				
				$("#" + modifyDiscountId).parent().html(updateHref);			
				
				//设置房间总价及合同总价=房间总价+装修总价,并设置"建筑成交单价","套内成交单价";建筑成交单价=成交总价/建筑面积;套内成交单价=成交总价/套内面积
				setUnitSumMoneyAndContractMoneyAndOther(data);
				
			}
		}		
	});			
	
}

//查看修改单元折扣
function createUpdateUnitDiscountDialog(unitDiscountId){
	
	$("#myIframeDialog").dialog({
		resizable: true,
		modal:true, //模态窗口,表示不能操作弹出框以外的内容
		maximizable: false, //是否显示最大化按钮
		width:600,
		height:300,
		onClose:function(){
			
			$('#openIframe').attr("src", "./saleunit_new/guangzhou/loading.jsp"); //清空内容
		},
		buttons:[{
			text:'提交',
			iconCls:'icon-ok',
			handler:function(){
				
				//$('#discountManagerIframe').contents().find("#createDiscountManagerFormId").submit();				
				//$("#discountManagerIframe")[0].contentWindow.formSubmit();
				
			}		
		},
		{
			text:'关闭',
			iconCls:'icon-cancel',
			handler:function(){
				
				$("#myIframeDialog").dialog("close");
			}
		}]
		
	});
		
	$('#myIframeDialog').dialog('open');
	$('#myIframeDialog').dialog('setTitle', '查看折扣'); 
	
	$('#openIframe')[0].src='./saleunit_new/appoint/guangzhou/forUpdateDiscountDialog.action?unitDiscountId=' + unitDiscountId; 	
	
	return false;
}

//下面为项目折扣
//新增项目折扣
function createProjectDiscountDialog(unitId, mainId, confirmType){
	
	var payWayId = $("#payWayId").val();

	if(payWayId == "" || payWayId == "0" || payWayId == undefined){
		
		myAlert("请选确定付款方式");
		return false;
	}
	
	$("#myIframeDialog").dialog({
		resizable: true,
		modal:true, //模态窗口,表示不能操作弹出框以外的内容
		maximizable: true, //显示最大化按钮
		width:600,
		height:400,
		onClose:function(){
		
			$('#openIframe').attr("src", "./saleunit_new/guangzhou/loading.jsp"); //清空内容
		},
		buttons:[{
			text:'提交',
			iconCls:'icon-ok',
			handler:function(){

				var content = $.easyIframeContentWindow("openIframe");		
				var ways = content.$("input[name='unitDiscount.computeWay']");
				if(!isCheckboxCheck(ways)){
					dialogButtonSugg("折扣方式不能为空", this);
					return false;
				}
				
				content.formSubmit(this, "createProjectDiscount");
				
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
	
	$('#myIframeDialog').dialog('setTitle', '新增折扣'); 
	
	$('#openIframe')[0].src='./project_discount/manager/createProjectDiscountDialog.action?unitId=' + unitId
		+ "&mainId=" + mainId + "&confirmType=" + confirmType + "&payWayId=" + payWayId;
	
	return false;
}

//关闭项目折扣dialog的执行函数
function closeProjectDiscountManagerFn(unitDiscountId){
	
	$("#unitDiscountId").attr("value" , unitDiscountId); //设置隐藏域
	getProjectDiscountManagerCloseShowByDiscountId(unitDiscountId, "modifyDiscountId"); //显示其选中的折扣,并可以编辑,且根据公式(标准总价),算出房间总价	
}

//设置项目折扣的详细显示,第二个参数为返回的值放到其前面,并绑定编辑事件,
function getProjectDiscountManagerCloseShowByDiscountId(unitDiscountId, modifyDiscountId){
	
	$.ajax({
		type:"get",
		url: "./project_discount/manager/getProjectDiscountManagerCloseShowByDiscountId.action",
		data: "unitDiscountId=" + unitDiscountId + retAction(),
		dataType: "json",
		success: function(data){
			
			if(data != ""){
				
				var updateHref = '<a href="javascript:void(0)" id="modifyDiscountId" style="float:left;" onclick="return createUpdateProjectDiscountDialog(' 
					+ unitDiscountId + ')"><font color="#5482DE">' + data.detail + '</font></a>';
				
				//var updateHref = '<a href="javascript:void(0)" id="modifyDiscountId" style="float:left;"><font color="#5482DE">' + data.detail + '</font></a>';
				
				$("#" + modifyDiscountId).parent().html(updateHref);			
				
				//设置房间总价及合同总价=房间总价+装修总价,并设置"建筑成交单价","套内成交单价";建筑成交单价=成交总价/建筑面积;套内成交单价=成交总价/套内面积
				setUnitSumMoneyAndContractMoneyAndOther(data);
				
				$('#myIframeDialog').dialog('close'); //关闭项目折扣dialog
				
			}
		}		
	});			
	
}

//修改项目折扣
function createUpdateProjectDiscountDialog(unitDiscountId){
	
	var payWayId = $("#payWayId").val();

	if(payWayId == "" || payWayId == "0" || payWayId == undefined){
		
		myAlert("请选确定付款方式");
		return false;
	}
	
	$("#myIframeDialog").dialog({
		resizable: true,
		modal:true, //模态窗口,表示不能操作弹出框以外的内容
		maximizable: false, //是否显示最大化按钮
		width:600,
		height:400,
		onClose:function(){
			
			$('#openIframe').attr("src", "./saleunit_new/guangzhou/loading.jsp"); //清空内容
		},
		buttons:[{
			text:'提交',
			iconCls:'icon-ok',
			handler:function(){
				
				var content = $.easyIframeContentWindow("openIframe");		
				var ways = content.$("input[name='unitDiscount.computeWay']");
				if(!isCheckboxCheck(ways)){
					dialogButtonSugg("折扣方式不能为空", this);
					return false;
				}
				
				content.formSubmit(this, "updateProjectDiscount");				
								
			}		
		},
		{
			text:'关闭',
			iconCls:'icon-cancel',
			handler:function(){
				
				$("#myIframeDialog").dialog("close");
			}
		}]
		
	});
		
	$('#myIframeDialog').dialog('open');
	$('#myIframeDialog').dialog('setTitle', '查看折扣'); 
	
	$('#openIframe')[0].src='./project_discount/manager/createUpdateProjectDiscountDialog.action?unitDiscountId=' + unitDiscountId 
		+ "&payWayId=" + payWayId + "&unitId=" + $("#hiddenUnitId").val(); 	
	
	return false;
	
}