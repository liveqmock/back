/**
 *  付款情况
 */
 
 
$().ready(function(){
	
	$("#payDetailSub").click(function(){
		
		var payType = $("#payType").val();
		if(payType == ""){
			showTip("款项类型不能为空");
			$("#payType").focus();
			return false;
		}
		
		var payName = $("#payName").val();
		if(payName == ""){
			showTip("款项名称不能为空");
			$("#payName").focus();
			return false;
		}
		
		var limitDate = $("#limitDate").val();
		if(limitDate == ""){
			showTip("付款期限不能为空");
			$("#limitDate").focus();
			return false;
		}
		
		var payMoney = $("#payMoney").val();
		if(payMoney == ""){
			showTip("金额不能为空");
			$("#payMoney").focus();
			return false;
		}

		return true;
	});
	
	
	
	
});

function inputPayDetailDialog(confirmId){

	var obj = new Object();
	obj.type = "iframe";
	obj.value = "./saleunit/confirm/guangzhou/forInputPayDetail.action?confirmId=" + confirmId;
	obj.width = "640px";
	obj.height = "270px";

	var dialog = new Dialog(obj,{title:'<font color="black">新建付款明细</font>', fixed:true, isReload:true});	
	dialog.show();
	
	return false;
}

function updatePayDetailDialog(payDetailId){

	var obj = new Object();
	obj.type = "iframe";
	obj.value = "./saleunit/confirm/guangzhou/getPayDetailId.action?payDetailId=" + payDetailId;
	obj.width = "640px";
	obj.height = "270px";

	var dialog = new Dialog(obj,{title:'<font color="black">修改付款明细</font>', fixed:true, isReload:true});	
	dialog.show();
	
	return false;
}

function inputPayDetailDialogForContract(contractId){

	var obj = new Object();
	obj.type = "iframe";
	obj.value = "./saleunit/contract/guangzhou/forInputPayDetail.action?contractId=" + contractId;
	obj.width = "640px";
	obj.height = "270px";

	var dialog = new Dialog(obj,{title:'<font color="black">新建付款明细</font>', fixed:true, isReload:true});	
	dialog.show();
	
	return false;
}

function updatePayDetailDialogForContract(payDetailId){

	var obj = new Object();
	obj.type = "iframe";
	obj.value = "./saleunit/contract/guangzhou/getPayDetailId.action?payDetailId=" + payDetailId;
	obj.width = "640px";
	obj.height = "270px";

	var dialog = new Dialog(obj,{title:'<font color="black">修改付款明细</font>', fixed:true, isReload:true});	
	dialog.show();
	
	return false;
}

function showTip(tipSug){
	$("#suggestion").html(tipSug);
}


