/**
 *  合同销售服务
 */
 
 
$().ready(function(){
	
	$("#contractServicesSub").click(function(){
										  
		// serviceType stepState
		
		var serviceType = $("#serviceType").val();
		if(serviceType == ""){
			showTip("服务项目不能为空");
			$("#serviceType").focus();
			return false;
		}
		
		var stepState = $("#stepState").val();
		if(stepState == ""){
			showTip("服务进程不能为空");
			$("#stepState").focus();
			return false;
		}
		
		return true;
	});
	
});

function inputContractServiceDialog(contractId){

	var obj = new Object();
	obj.type = "iframe";
	obj.value = "./saleunit/contract/guangzhou/forInputContractService.action?contractId=" + contractId;
	obj.width = "640px";
	obj.height = "270px";

	var dialog = new Dialog(obj,{title:'<font color="black">新建销售服务</font>', fixed:true, isReload:true});	
	dialog.show();
	
	return false;
}

function updateContractServiceDialog(contractServiceId){

	var obj = new Object();
	obj.type = "iframe";
	obj.value = "./saleunit/contract/guangzhou/getContractServiceId.action?contractServiceId=" + contractServiceId;
	obj.width = "640px";
	obj.height = "270px";

	var dialog = new Dialog(obj,{title:'<font color="black">修改销售服务</font>', fixed:true, isReload:true});	
	dialog.show();
	
	return false;
}

function showTip(tipSug){
	$("#suggestion").html(tipSug);
}


