/**
 *  权益人
 */
 
 
$().ready(function(){
	
	$("#propertyOwnerSub").click(function(){
										  
		// customerName idcardNo phone rightPercent
		
		var customerName = $("#customerName").val();
		if(customerName == ""){
			showTip("客户姓名不能为空");
			$("#customerName").focus();
			return false;
		}
		
		var idcardNo = $("#idcardNo").val();
		if(idcardNo == ""){
			showTip("证件号码不能为空");
			$("#idcardNo").focus();
			return false;
		}
		
		var phone = $("#phone").val();
		if(phone == ""){
			showTip("联系电话不能为空");
			$("#phone").focus();
			return false;
		}
		
		var rightPercent = $("#rightPercent").val();
		if(rightPercent == ""){
			showTip("产权比例不能为空");
			$("#rightPercent").focus();
			return false;
		}
		
		return true;
	});
	
});

function inputPropertyOwnerDialog(confirmId){

	var obj = new Object();
	obj.type = "iframe";
	obj.value = "./saleunit/confirm/guangzhou/forInputPropertyOwner.action?confirmId=" + confirmId;
	obj.width = "640px";
	obj.height = "270px";

	var dialog = new Dialog(obj,{title:'<font color="black">添加权益人</font>', fixed:true, isReload:true});	
	dialog.show();
	
	return false;
}

function updatePropertyOwnerDialog(propertyOwnerId){

	var obj = new Object();
	obj.type = "iframe";
	obj.value = "./saleunit/confirm/guangzhou/getPropertyOwnerId.action?propertyOwnerId=" + propertyOwnerId;
	obj.width = "640px";
	obj.height = "270px";

	var dialog = new Dialog(obj,{title:'<font color="black">修改权益人</font>', fixed:true, isReload:true});	
	dialog.show();
	
	return false;
}

function inputPropertyOwnerDialogForContract(contractId){

	var obj = new Object();
	obj.type = "iframe";
	obj.value = "./saleunit/contract/guangzhou/forInputPropertyOwner.action?contractId=" + contractId;
	obj.width = "640px";
	obj.height = "270px";

	var dialog = new Dialog(obj,{title:'<font color="black">添加权益人</font>', fixed:true, isReload:true});	
	dialog.show();
	
	return false;
}

function updatePropertyOwnerDialogForContract(propertyOwnerId){

	var obj = new Object();
	obj.type = "iframe";
	obj.value = "./saleunit/contract/guangzhou/getPropertyOwnerId.action?propertyOwnerId=" + propertyOwnerId;
	obj.width = "640px";
	obj.height = "270px";

	var dialog = new Dialog(obj,{title:'<font color="black">修改权益人</font>', fixed:true, isReload:true});	
	dialog.show();
	
	return false;
}

function showTip(tipSug){
	$("#suggestion").html(tipSug);
}


