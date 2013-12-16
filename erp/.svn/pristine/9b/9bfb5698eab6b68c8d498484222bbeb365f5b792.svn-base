/**
 *  合同个性装修
 */
 
 
$().ready(function(){
	
	$("#contractRenovateSub").click(function(){
										  
		// serviceType stepState
		
		var payDate = $("#payDate").val();
		if(payDate == ""){
			showTip("应收日期不能为空");
			$("#payDate").focus();
			return false;
		}
		
		return true;
	});
	
});

function inputContractRenovateDialog(contractId){

	var obj = new Object();
	obj.type = "iframe";
	obj.value = "./saleunit/contract/guangzhou/forInputContractRenovate.action?contractId=" + contractId;
	obj.width = "640px";
	obj.height = "270px";

	var dialog = new Dialog(obj,{title:'<font color="black">新建个性装修</font>', fixed:true, isReload:true});	
	dialog.show();
	
	return false;
}

function updateContractRenovateDialog(contractRenovateId){

	var obj = new Object();
	obj.type = "iframe";
	obj.value = "./saleunit/contract/guangzhou/getContractRenovateId.action?contractRenovateId=" + contractRenovateId;
	obj.width = "640px";
	obj.height = "270px";

	var dialog = new Dialog(obj,{title:'<font color="black">修改个性装修</font>', fixed:true, isReload:true});	
	dialog.show();
	
	return false;
}

function showTip(tipSug){
	$("#suggestion").html(tipSug);
}


