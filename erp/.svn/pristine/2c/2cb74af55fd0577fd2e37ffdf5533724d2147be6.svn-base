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
		
		var phone = $("#phone").val();
		if(phone == ""){
			showTip("联系电话不能为空");
			$("#phone").focus();
			return false;
		}
		
		var unitName = $("#unitName").val();
		if(unitName == ""){
			showTip("房间不能为空");
			$("#unitName").focus();
			return false;
		}
		
		var propertyType = $("#propertyType").val();
		if(propertyType == ""){
			showTip("房产类型不能为空");
			$("#propertyType").focus();
			return false;
		}
		
		var payType = $("#payType").val();
		if(payType == ""){
			showTip("付款方式不能为空");
			$("#payType").focus();
			return false;
		}
		
		var discountPercent = $("#discountPercent").val();
		if(discountPercent == ""){
			showTip("折扣不能为空");
			$("#discountPercent").focus();
			return false;
		}
		
		var buildPrice = $("#buildPrice").val();
		if(buildPrice == ""){
			showTip("建筑成交单价不能为空");
			$("#buildPrice").focus();
			return false;
		}
		
		var insideUnitPrice = $("#insideUnitPrice").val();
		if(insideUnitPrice == ""){
			showTip("套内成交单价不能为空");
			$("#insideUnitPrice").focus();
			return false;
		}
		
		var sumMoney = $("#sumMoney").val();
		if(sumMoney == ""){
			showTip("房间总价不能为空");
			$("#sumMoney").focus();
			return false;
		}
				
		var contractMoney = $("#contractMoney").val();
		if(contractMoney == ""){
			showTip("合同总价不能为空");
			$("#contractMoney").focus();
			return false;
		}
				
		var signDate = $("#signDate").val();
		if(signDate == ""){
			showTip("签合同日期不能为空");
			$("#signDate").focus();
			return false;
		}
		
		var workDate = $("#workDate").val();
		if(workDate == ""){
			showTip("业务归属日期不能为空");
			$("#workDate").focus();
			return false;
		}
		
		return true;
		*/
		
		var ids = ["customerName","phone:phone","unitName","payType","discountPercent:money",
				   "buildPrice:money","insideUnitPrice:money","sumMoney:money","contractNo","contractMoney:money","signDate","workDate"];
		return myCheckOnlyById(ids);	
					
	});
	
	$("#unitOtherData").click(function(){
			
		var unitId = $("#hiddenUnitId").val();
		if(unitId == ""){
			
			alert("请先选定房间");
		}else{
			
			$.ajax({
				type:"post",
				url: "./customer_guangzhou/search/getOtherDataByUnitId.action",
				data: "unitId=" + unitId,
				dataType: "html",
				success: function(data){
					var dataJson = eval("("+data+")");					
					
					$("#property").html(dataJson.property);
					$("#build").html(dataJson.build);
					$("#priceWay").html(dataJson.priceWay);
					
					$("#buildPrice").html(dataJson.buildPrice);					
					$("#renovateDesc").html(dataJson.renovateDesc);
					$("#renovatePrice").html(dataJson.renovatePrice);
					
					$("#renovateMoney").html(dataJson.renovateMoney);					
					
				}
				
			});
		}
	});
	
	$("#createContractCustomer").click(function(){
		
		confirmCustomer("contract");
		
	});
		
	$("#showContractCustomer").click(function(){
		
		var customerId = $("#contractCustomerId").val();
		showConfirmCustomer(customerId);
		
	});
	
	showDiv("unitName","hiddenUnitId","","");
	
	showDiv("refUnitId","hiddenRefUnitId","","");
	
	userListForHiddenId("saleName", "hiddenSalesId");
	
	contractCustomerListForHiddenId("customerName", "confirmCustomerId");   //confirm customer 的联想输入框
	
	
});

function getUnitOtherData(unitId){
	
	$.ajax({
		type:"post",
		url: "./customer_guangzhou/search/getOtherDataByUnitId.action",
		data: "unitId=" + unitId,
		dataType: "json",
		success: function(data){
			//var dataJson = eval("("+data+")");
			
			for(var key in data){
				//alert(key + "=" + data[key]);
				$("#" + key).html(data[key]);
			}	
			
		}
		
	});
}


function showTip(tipSug){
	$("#suggestion").html(tipSug);
	$("#suggestion2").html(tipSug);
}


