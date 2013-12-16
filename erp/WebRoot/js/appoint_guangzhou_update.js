/**
 *
 */

 
$().ready(function(){
				   
	$("#sub").click(function(){
							 
	
		/**						 
		var customerName = $("#customerName").val();
		if(customerName == ""){
			showTip("客户姓名不能为空");
			$("#customerName").focus();
			return false;
		}
		
		var appointDate = $("#appointDate").val();
		if(appointDate == ""){
			showTip("预约日期不能为空");
			$("#appointDate").focus();
			return false;
		}
		
		var appointNum = $("#appointNum").val();
		if(appointNum == ""){
			showTip("项目排号不能为空");
			$("#appointNum").focus();
			return false;
		}		
		*/
		var ids = ["appointDate", "appointNum:number"];
		return myCheckOnlyById(ids);		
					
	});
	
	
	$("#billSub").click(function(){
								 
		var ids = ["payMan", "writerName", "payDate", "appointBill_billType", "billNo", "writeDate"];
		var suggs = ["交款人", "开票人", "缴款日期", "票据类型", "票据编号", "开票日期"];
		return myCheck(ids, suggs);
					
	});
	
	
	$("#createAppointCustomer").click(function(){
		
		appointCustomer();
		
	});
		
	$("#showAppointCustomer").click(function(){
		
		var customerId = $("#appointCustomerId").val();
		showAppointCustomer(customerId);
		
	});
	
	//showDiv("unitId","hiddenUnitId","hiddenBulidId","hiddenId");
	
	appointCustomerListForHiddenId("customerName", "appointCustomerId");   //appoint customer 的联想输入框
	
	propertyProjectListForHiddenId("projectName", "hiddenId"); //项目的联想框,及用隐藏域保存其id
			
	getBuildListFromPropertyIdForAuto("buildName", "hiddenId", "hiddenBulidId");  //根据楼盘项目id,获取对应的楼栋联想提示框
	
	//项目id有变化,要清空楼栋的值与id
	$("#projectName").change(function(){
									  
		$("#buildName").val("");
		$("#hiddenBulidId").attr("value", ""); 				
	});

	userListForHiddenId("saleName", "saleHiddenId");
	
	$("#billListButton").click(function(){
				
		$(this).css("color", "#000000");
		$("#detailListButton").css("color", "#5482DE");
		
		$("#billList").show();
		$("#detailList").hide();
	});
	
	$("#detailListButton").click(function(){
										  
		$(this).css("color", "#000000");
		$("#billListButton").css("color", "#5482DE");
		
		$("#billList").hide();
		$("#detailList").show();
	});
	
	
	/**
	$("#appointBill").click(function(){
				
		var appointId = $("#appointId").val();
		var obj = new Object();
		obj.type = "iframe";
		obj.value = "./saleunit/appointbill/guangzhou/forInput.action?appointId=" + appointId;
		obj.width = "840px";
		obj.height = "400px";

		var dialog = new Dialog(obj,{title:'<font color="black">新建实收单据</font>', fixed:true, isReload:true});	
		dialog.show();
		
	});
	
	$("#appointBillUpdate").click(function(){
				
		var appointId = $("#appointId").val();
		var obj = new Object();
		obj.type = "iframe";
		obj.value = "./saleunit/appointbill/guangzhou/forInput.action?appointId=" + appointId;
		obj.width = "840px";
		obj.height = "400px";

		var dialog = new Dialog(obj,{title:'<font color="black">修改实收单据</font>', fixed:true, isReload:true});	
		dialog.show();
		
	});
	*/
	
	$("#appointBill").click(function(){
		
		var appointId = $("#appointId").val();
		location.href = getBasePath() + "saleunit/appointbill/guangzhou/forInput.action?appointId=" + appointId;
		
	});
	
	/**
	$("#appointBillDetail").click(function(){
		
		var appointBillId = $("#appointBillId").val();
		location.href = getBasePath() + "saleunit/appointbilldetail/guangzhou/forInput.action?appointBillId=" + appointBillId;
		
	});
	*/
		
	$("#allDel").click(function(){
		allDel();
	});
	
	$(".delId").click(function(){
		delId();
	});
	
	$("#allDel2").click(function(){
		allDel2();
	});
	
	$(".delId2").click(function(){
		delId2();
	});
				
});


//转认购
function changeToConfirm(appointId){
	
	$.ajax({
		type:"get",
		url: "./saleunit/appoint/guangzhou/changeToConfirm.action",
		data: "appointId=" + appointId,
		dataType: "json",
		success: function(data){
			
			if(data.type == "true"){
				
				$("#changeToConfirmButton").hide();
				
				var ret = confirm("转认购成功,是否跳到认购页面?");				
				if(ret == true){
					
					loading();
					var confirmId = data.id;
					location.href = getBasePath() + "saleunit/confirm/guangzhou/getById.action?id=" + confirmId;
					
				}
				
				//alert("转认购成功");
				//$("#changeToConfirmButton").hide();
			}else{
				alert("转认购失败,请重新操作");
			}
			
		}
		
	});
	
	return false;
}

function delAppointBill(billId, appointId){
			
	var isDel = confirm("确定删除?");
	if(isDel){
	
		loading();
		location.href = getBasePath() + "saleunit/appoint/guangzhou/deleteAppointBill.action?billId=" + billId + "&appointId=" + appointId;
		return false;
	}else{
		
		return false;
	}
}

function delAppointDetail(detailId, appointId){
	
	var isDel = confirm("确定删除?");
	if(isDel){
	
		loading();
		location.href = getBasePath() + "saleunit/appoint/guangzhou/deleteAppointDetail.action?detailId=" + detailId + "&appointId=" + appointId;
		return false;
	}else{
		
		return false;
	}
}

function billRet(appointId){	

	location.href = getBasePath() + "saleunit/appoint/guangzhou/getById.action?id=" + appointId;
}

function billDetailRet(billId){
	
	location.href = getBasePath() + "saleunit/appointbill/guangzhou/getById.action?appointBillId=" + billId;
}

function updateBillDetail(detailId){

	var obj = new Object();
	obj.type = "iframe";
	obj.value = "./saleunit/appointbilldetail/guangzhou/getById.action?detailId=" + detailId;
	obj.width = "640px";
	obj.height = "270px";

	var dialog = new Dialog(obj,{title:'<font color="black">修改实收款项</font>', fixed:true, isReload:true});	
	dialog.show();
	
	return false;
}

function inputBillDetail(billId){

	var obj = new Object();
	obj.type = "iframe";
	obj.value = "./saleunit/appointbilldetail/guangzhou/forInput.action?appointBillId=" + billId;
	obj.width = "640px";
	obj.height = "270px";

	var dialog = new Dialog(obj,{title:'<font color="black">新建实收款项</font>', fixed:true, isReload:true});	
	dialog.show();
	
	return false;
}


//直接引入customer_common.js不能读取,??
function allDel(){
	var delIds = document.getElementsByName("delId");
	var allDelVal = document.getElementById("allDel");
	
	if(allDelVal.checked == true){
		for(var i=0; i<delIds.length; i++){
			delIds[i].checked = true;
		}
	}else{
		for(var i=0; i<delIds.length; i++){
			delIds[i].checked = false;
		}
	}
}

function delId(){
	var delIds = document.getElementsByName("delId");
	var allDel = true;
	
	for(var i=0; i<delIds.length; i++){
		if(delIds[i].checked == false){
			allDel = false;
		}
	}
	
	if(allDel){
		document.getElementById("allDel").checked = true;
	}else{
		document.getElementById("allDel").checked = false;
	}
}

function allDel2(){
	var delIds = document.getElementsByName("delId2");
	var allDelVal = document.getElementById("allDel2");
	
	if(allDelVal.checked == true){
		for(var i=0; i<delIds.length; i++){
			delIds[i].checked = true;
		}
	}else{
		for(var i=0; i<delIds.length; i++){
			delIds[i].checked = false;
		}
	}
}

function delId2(){
	var delIds = document.getElementsByName("delId2");
	var allDel = true;
	
	for(var i=0; i<delIds.length; i++){
		if(delIds[i].checked == false){
			allDel = false;
		}
	}
	
	if(allDel){
		document.getElementById("allDel2").checked = true;
	}else{
		document.getElementById("allDel2").checked = false;
	}
}
		

function showTip(tipSug){
	$("#suggestion").html(tipSug);
}