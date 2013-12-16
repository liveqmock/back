/**
  *
  * 认筹
  */
  

//节点的点击方法,isRefresh表示是否为刷新,主要给addChangeClass()使用,moduleId要为其上方增加刷新框的组件
function chipTreeNodeClick(treeId, node, isRefresh, moduleId){
		
	var attr = node.attributes;
	if(attr != undefined && attr.type == "endNode"){
		$.ajax({
			type:"get",
			url: "./saleunit_chip_manager/guangzhou/getUnit.action",							
			data: "buildId=" + attr.bid + "&isRefresh=" + isRefresh + "&ts=" + new Date(),
			dataType: "html",
			beforeSend: function(){
				
				getLeftChange(node, "");
				setChangeUnitAction(node);
				moduleMask(moduleId);
			},
			success: function(data){								
				$("#" + moduleId).html(data);	
			}			
		});	
		
	}else if(attr != undefined && attr.type == "endNodeGro"){
		$.ajax({
			type:"get",
			url: "./saleunit_chip_manager/guangzhou/getGroup.action",							
			data: "groId=" + attr.gid + "&isRefresh=" + isRefresh + "&ts=" + new Date(),
			dataType: "html",
			beforeSend: function(){
				
				getLeftChange(node, "");
				setChangeUnitAction(node);
				moduleMask(moduleId);
			},
			success: function(data){								
				$("#" + moduleId).html(data);					
			}			
		});	
	}else if(attr != undefined && attr.type == "area"){
		
		//$("#" + treeId).tree('toggle', node.target);
		
		$.ajax({
			type:"get",
			url: "./saleunit_chip_manager/guangzhou/getAreaUnit.action",							
			data: "areaId=" + attr.aid + "&isRefresh=" + isRefresh + "&ts=" + new Date(),
			dataType: "html",
			beforeSend: function(){
				
				getLeftChange(node, "");
				setChangeUnitAction(node);
				moduleMask(moduleId);
			},
			success: function(data){								
				$("#" + moduleId).html(data);	
				
			}			
		});	
		
	}else if(attr != undefined && attr.type == "p"){
		//$("#" + treeId).tree('toggle', node.target);
		getLeftChange(node, "");
		setChangeUnitAction(node);
	}else{
		$("#" + treeId).tree('toggle', node.target);
	}
}

function tdClick(td){
	
	var unitId = $(td).attr("unitid");
	if (unitId != "" && unitId != "0" && unitId != undefined) {
		
		//要先判断是否重复选择 $('#objId', parent.document); 放到提交去判断		
		
		$(".changetd").removeClass("changetd");
		$(td).addClass("changetd");
		
		getUnitAllNameByUnitIdAndChipNo(unitId);
		
	}
}

//获取单元全名,要先判断该意向是否可以选该单元
function getUnitAllNameByUnitIdAndChipNo(unitId){
	
	$.ajax({
		type:"get",
		url: "./saleunit_chip_manager/guangzhou/getUnitAllNameByUnitIdAndChipNo.action",							
		data: "unitId=" + unitId,
		dataType: "json",
		success: function(data){
			
			$("#chip1_customer1").html("");
			$("#chip1_customer2").html("");
			$("#chip1_customer3").html("");
			
			$("#chip2_customer1").html("");
			$("#chip2_customer2").html("");
			
			$("#chip3_customer1").html("");
			
			setChipCustomerName(data.chip1_customer1, "chip1_customer1");
			setChipCustomerName(data.chip1_customer2, "chip1_customer2");
			setChipCustomerName(data.chip1_customer3, "chip1_customer3");
			
			setChipCustomerName(data.chip2_customer1, "chip2_customer1");
			setChipCustomerName(data.chip2_customer2, "chip2_customer2");
			
			setChipCustomerName(data.chip3_customer1, "chip3_customer1");			
			
		}		
	});		
}

function setChipCustomerName(value, chipCustomerId){

	if(value != undefined && value != ""){
		
		$("#" + chipCustomerId).html(value);
	}
}

//获取单元的全名,包括项目,分区,楼栋,单元号(可以考虑使用js的缓存,利用map或者apply)
function getUnitAllName(unitId, showId){
	
	$.ajax({
		type:"get",
		url: "./saleunit/common/getUnitAllName.action",							
		data: "unitId=" + unitId,
		dataType: "html",
		success: function(data){
			$("#" + showId).text(data);
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

//查找认筹客户
function searchChipCustomer(){
	
	//$("#searchChipCustomerDiv").children().children().show();
	showDialogDiv("searchChipCustomerDiv");
	
	$("#searchChipCustomerDiv").dialog({
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
					
					dialogNewSugg(this, "未查询到相关内容");
					return false;
				}
				
				dialogNewSugg(this, "提交中...");
				ajaxChipCustomer(customerId, this); //设置id,name,phone

			}
		},
		{
			text:'关闭',
			iconCls:'icon-cancel',
			handler:function(){
				
				$('#searchChipCustomerDiv').dialog('close');
			}
		}]
	});
		
	$('#searchChipCustomerDiv').dialog('open');
	$('#searchChipCustomerDiv').dialog('setTitle', '查找客户');
	
	return false;
	
}

//根据customer id设置ChipCustomer
function ajaxChipCustomer(customerId, dialogButton){
	
	$.ajax({
		type:"post",
		url: "./saleunit_chip_manager/guangzhou/ajaxChipCustomerFromCustomerIdForSearch.action",
		data: "customerId=" + customerId,
		dataType: "json",
		success: function(data){
			
			if(data != "" && data != null){
				//保存成功

				$('#searchChipCustomerDiv').dialog('close');
				
				$("#chipCustomerId").attr("value", data.id);
				$("#chipCustomerName").val(data.customerName);
				$("#chipCustomerPhone").val(data.phone);
				
				$("#chipCustomerGender").val(data.gender);
				$("#chipCustomerIdcardType").val(data.idcardType);
				$("#chipCustomerIdcardNo").val(data.idcardNo);
				
				$("#chipCustomerAddress").val(data.address);
								
			}else{				
				//保存失败
				
				dialogNewSugg(dialogButton, "<font color='red'>保存失败,请重试</font>");
			}
		}	
	});
	
}

//先判断是否可以认筹,并获取筹单状态
function createChipDiv(){
	
	var parent_ = $(window.parent.document);
	var buildId = parent_.find("#changeHiddenBuildId").attr("value");
	var areaId = parent_.find("#changeHiddenAreaId").attr("value");
	var projectId = parent_.find("#changeHiddenProjectId").attr("value");
	var groupId = parent_.find("#changeHiddenGroupId").attr("value");
	
	if(buildId == undefined && groupId == undefined && areaId == undefined && projectId == undefined){
		
		myAlert("请先确定楼栋、组团、分区或楼盘其中之一");
		return false;
	}	
	
	var idType = "";
	var id = "";
	if(buildId != undefined){
		
		idType = "build";
		id = buildId;
	}else if(groupId != undefined){
		idType = "group";
		id = groupId;
	}else if(areaId != undefined){
		idType = "area";
		id = areaId;
	}else if(projectId != undefined){
		idType = "project";
		id = projectId;
	}
	
	$.ajax({
		type:"get",
		url: "./saleunit_chip_manager/guangzhou/getChipTypeForAddChip.action",
		data: "idType=" + idType + "&id=" + id,
		dataType: "json",
		success: function(data){
			
			if(data.chipTypeName == ""){
				
				myAlert("不能确定认筹类型");
				return false;
			}else{
				
				realCreateChipDiv(data.chipTypeName, data.chipTypeId, data.unitId , data.type);
			}
						
		}	
	});	
}

//新建认筹,弹出窗口
function realCreateChipDiv(chipTypeName, chipType, unitId, type){
	
	if(unitId == undefined || unitId <= 0){
		myAlert("选择的楼栋没有可以操作的单元");
		return false;
	}
	
	var title = '新建认筹(' + chipTypeName + ')';
	
	new MyAjaxIframeDialog({title:title, width:800, height:600,
		formId:'chipFormId', src:'./saleunit_chip_manager/guangzhou/toCreateChipDialog.action?unitId=' + unitId + "&chipType=" + chipType +"&type="+ type,
		ids:["salesId", "customerId", "chipNo", "unit_id1"],
		closeFn:submitSearch, 
		closeFnArg:["chip_tabs"]
		//closeFn:gotoRefreshFn, closeFnArg:["openIframe", "reHiddenId", "isReload"]
		//window.parent.refreshSelectedTab("chip_tabs"); 
	});
	
	/**
	showDialogDiv("createChipDiv");
		
	$("#createChipDiv").dialog({
		resizable: true,
		onClose:function(){
			
			$('#saveChipFormId')[0].reset();
			
			$("#unit_id1").attr("value", "");
			$("#showUnit1").html("");
			$("#unit_id2").attr("value", "");
			$("#showUnit2").html("");
			$("#unit_id3").attr("value", "");
			$("#showUnit3").html("");		
			
			$("#chipCustomerId").attr("value", "");
			
			moduleMask("searchChipTableId");
			window.parent.refreshSelectedTab("chip_tabs");  //在easyui.utils.js中
					
		},
		buttons:[{
			text:'提交',
			iconCls:'icon-ok',
			handler:function(){
				
				//保存之前要先判断是否重复选择单元
				saveChip(this, chipTypeId);				
			}
		},
		{
			text:'关闭',
			iconCls:'icon-cancel',
			handler:function(){
				
				$('#createChipDiv').dialog('close');
			}
		}]
	});
	
	$('#createChipDiv').dialog('open');
	$('#createChipDiv').dialog('setTitle', '新建认筹(' + chipTypeName + ')');
	*/
	
	return false;
}

//判断参数的值是否有重复,(也可以用冒泡法来判断,但是效率会相对低下)
function isValRepeat(ids){
	
	var isRepeat = false;
	
	var ary = new Array(); //数组
	
	for(var i=0; i<ids.length; i++){
		
		var val = $("#" + ids[i]).attr("value");
		if(val != undefined && val != ""){
			ary.push(val);
		}
	}

	var s = ary.join(",")+","; //数组组成的字符串
	
	for(var i=0;i<ary.length;i++) {
	
		if(s.replace(ary[i]+",","").indexOf(ary[i]+",")>-1) {
			
			isRepeat = true;
			break;
		}
	}
	
	return isRepeat;
	
}

//为之前选定的td加上选中的class
function addChangeClassForChip(oldChangeUnitId){
	
	$("#unitTable td").each(function(index){
			
		var getUnitId = $(this).attr("unitid");
		if(getUnitId == oldChangeUnitId){
			$(this).addClass("changetd");
			return false;
		}
	});
	
}

//保存认筹
function saveChip(dialogButton, chipTypeId){
	
	var chipNo = $("#chipNo").val();
	var chipCustomerName = $("#chipCustomerName").val();
	var chipCustomerPhone = $("#chipCustomerPhone").val();
	var unit_id1 = $("#unit_id1").attr("value");
		
	if(chipNo == ""){
		
		$("#chipNo").focus();
		dialogNewSugg(dialogButton, "筹单号不能为空");
		return false;
	}
	
	if(chipCustomerName == ""){
		
		$("#chipCustomerName").focus();
		dialogNewSugg(dialogButton, "客户名称不能为空");
		return false;
	}
	
	/** 可以多个号码
	if(chipCustomerPhone == "" || !isPhone(chipCustomerPhone)){
		
		$("#chipCustomerPhone").focus();
		dialogNewSugg(dialogButton, "电话号码不合规则");
		return false;
	}
	*/
	
	if(unit_id1 == ""){
		
		dialogNewSugg(dialogButton, "意向单元1不能为空");
		return false;
	}
	
	var ids = ["unit_id1","unit_id2","unit_id3"];
	if(isValRepeat(ids)){
		
		dialogNewSugg(dialogButton, "意向单元不能重复");
		return false;
	}

	dialogNewSugg(dialogButton, "提交中...");
	
	$.ajax({
		type:"post",
		url: "./saleunit_chip_manager/guangzhou/saveChip.action",
		data: $("#saveChipFormId").serialize() + "&chipTypeId=" + chipTypeId,
		dataType: "json",
		success: function(data){
			
			//根据返回的类型type判断是否成功,message做为提示内容
			
			var type = data.type;
			
			if(type == "true"){
				//保存成功
				
				$('#saveChipFormId')[0].reset();	
				$('#createChipDiv').dialog('close');
				
			}else{				
				//保存失败
				
				var message = data.message;
				if(message == ""){
					message = "出现异常,请重试";
				}
				
				var sugg = "<font color='red'>" + message + "</font>";
				dialogNewSugg(dialogButton, sugg);
			}
			
		}		
	});
}

//作废认筹
function voidChip(id, isVoid){
	
	if(isVoid == '1'){
		
		myAlert("已为作废状态");
		return false;
	}
	
	myConfirm("是否作废?", function(){
								
		$.ajax({
			type:"get",
			url: "./saleunit_chip_manager/guangzhou/voidChip.action?id=" + id,
			dataType: "json",
			success: function(data){				
				//根据返回的类型type判断是否成功,message做为提示内容
				var retType = data.type;
				if(retType == "true"){
					
					submitSearch(); //在search_chip.jsp中
				}else{
					myAlert("作废失败,请重试");
				}
			}		
		});		
		
	});
}

//选择单元的弹出框
function changeUnit(chipNo, id ,type){
	
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
				
				var parent_ = $(this).parent();
				var changeUnitId = parent_.find("#changeUnitId").attr("value");
				var changeBuildId = parent_.find("#changeBuildId").attr("value");
				var changeAreaId = parent_.find("#changeAreaId").attr("value");
				if(changeUnitId == undefined || changeUnitId == ""){
					dialogNewSugg(this, "请选择单元");
					return false;
				}
				
				$("#unit_id" + chipNo).attr("value", changeUnitId);
				$("#build_id" + chipNo).attr("value", changeBuildId);
				$("#area_id" + chipNo).attr("value", changeAreaId);
				$("#showUnit" + chipNo).html(parent_.find("#__dialogSugg__").html());
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
	$('#myIframeDialog').dialog('setTitle', '选择单元');

	//$('#openIframe')[0].src = './saleunit_chip_manager/guangzhou/changeUnitForAddChip.action?' + getChangeUnitAction();
	$('#openIframe')[0].src = './saleunit_chip_manager/guangzhou/changeUnitForAddChip.action?type='+type+'&'+type+'Id=' + id;
	
	return false;
	
}

//设置选择单元的请求action,_default_load_build_id及选择的楼栋或组团,供新建认筹时获取对应的认筹类型
function setChangeUnitAction(node){
	
	var attr = node.attributes;
	
	if(attr != undefined && attr.type == "endNode"){
		//点击了楼栋
		var action  = "type=build&buildId=" + attr.bid;
		$("#_get_change_unit_action_id").attr("value", action);
		
	}else if(attr != undefined && attr.type == "endNodeGro"){
		//点击了组团
		var action  = "type=group&groId=" + attr.gid;
		$("#_get_change_unit_action_id").attr("value", action);
		
	}else if(attr != undefined && attr.type == "area"){
		//点击了分区
		var action  = "type=area&areaId=" + attr.aid;
		$("#_get_change_unit_action_id").attr("value", action);	
	}else if(attr != undefined && attr.type == "p"){
		//点击了楼盘
		var action  = "type=p&projectId=" + attr.id;
		$("#_get_change_unit_action_id").attr("value", action);
		
	}
}

//获取选择单元的请求action, type=build&buildId= 或 type=group&groId=
function getChangeUnitAction(){
	
	var ret = "";
	
	var parent = $(window.parent.document);
	var action = parent.find("#_get_change_unit_action_id").attr("value");
	
	if(action == ""){
		//表示为默认加载,还没点击左边的树	
		var buildId = parent.find("#changeHiddenBuildId").attr("value"); //获取默认的build id
		ret = "type=build&buildId=" + buildId;
	}else{
		
		ret = action;
	}
	
	return ret;
}

//显示选择的左边导航条,propertyId只有第一次加载的时候才不为空
function getLeftChange(node, propertyId){
	
	if(node == null){
		defaultLoadBuild(propertyId);
		return ;
	}
	
	$("#showChangeId").html("&nbsp;"); //先清空提示

	var parentNode = $("#left_tree").tree("getParent", node.target); //父node
	//var rootNode = $("#left_tree").tree("getRoot"); //根node这样获取总是拿到第一个
	var propertyName;
	
	if(parentNode!=null){
		var rootNode = $("#left_tree").tree("getParent", parentNode.target); //因为只有三级,所以只要拿父的父node即为跟
		if(rootNode==null){
			propertyName = removeMyClass(parentNode.text);
		}
		else{
			propertyName = removeMyClass(rootNode.text); //项目名称
		}
	}else{
		var rootNode = $("#left_tree").tree("getRoot"); 
		
		propertyName = removeMyClass(rootNode.text);
	}
	
	
	var attr = node.attributes;
	var show = "已选择==>&nbsp;&nbsp;"; //已选择==>  哈哈哈,aaa,1单元
	
	if(attr != undefined && attr.type == "endNode"){
		//点击了楼栋
		
		var areaName = removeMyClass(parentNode.text); //分区名称
		var buildName = removeMyClass(node.text); //楼栋名称
		var buildId = node.attributes.bid; //楼栋id
		var hiddenBuildId = "<input type='hidden' id='changeHiddenBuildId' value='" + buildId + "'/>";		
		
		show = show + propertyName + "," + areaName + "," + buildName + hiddenBuildId;
		
	}else if(attr != undefined && attr.type == "endNodeGro"){
		//点击了组团
		parent.myAlert("暂不支持组团认筹");
		return;
		
		var groupName = removeMyClass(node.text); //组团名称
		var groupId = node.attributes.gid; //组团id
		var hiddenGroupId = "<input type='hidden' id='changeHiddenGroupId' value='" + groupId + "'/>";	
		
		show = show + propertyName + "," + groupName + hiddenGroupId;		
		
	}else if(attr != undefined && attr.type == "area"){
		//点击了分区
		var areaId = node.attributes.aid;
		
		var areaName = removeMyClass(node.text); //分区名称
		
		var hiddenAreaId = "<input type='hidden' id='changeHiddenAreaId' value='" + areaId + "'/>";
		
		show = show + propertyName + "," + areaName + hiddenAreaId;	
	}else if(attr != undefined && attr.type == "p"){
		//点击了楼盘

		var projectId = node.attributes.id;
		
		var propertyName = removeMyClass(node.text); //分区名称
		
		var hiddenProjectId = "<input type='hidden' id='changeHiddenProjectId' value='" + projectId + "'/>";
		
		show = show + propertyName + hiddenProjectId;	
	}
	
	$("#showChangeId").html(show);
	
}

//.removeClass("text_title_cl")
function removeMyClass(html){
	return $(html).text();
}

//获取默认加载选中的楼栋
function defaultLoadBuild(propertyId){
	$.ajax({
		type:"get",
		url: "./saleunit_chip_manager/guangzhou/getDefaultLoadForSearch.action",							
		data: "propertyId=" + propertyId,
		dataType: "json",		
		success: function(data){	
			
			$("#showChangeId").html(data.showChangeId);
		}			
	});	
}
