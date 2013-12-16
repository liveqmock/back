/**
 *  
 */
 
$().ready(function(){
				   
	$("#sub").click(function(){
		
		var ids = ["phone:phone", "payType", "discountPercent:money", "buildPrice:money", "insideUnitPrice:money", 
				   "sumMoney:money", "agreeNo", "shouldDeposit:money", "agreeMoney:money", "signDate", "workDate", "deliveryDate"];
		return myCheckOnlyById(ids);	
					
	});
	
	$("#createConfirmCustomer").click(function(){
		
		confirmCustomer("confirm");
		
	});
		
	$("#showConfirmCustomer").click(function(){
		
		var customerId = $("#confirmCustomerId").val();
		showConfirmCustomer(customerId);
		
	});
	
	//showDiv("refUnitId","hiddenRefUnitId","","");
	
	userListForHiddenId("saleName", "hiddenSalesId");
	
	/**
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
	**/	
	
	//confirmCustomerListForHiddenId("customerName", "confirmCustomerId");   //confirm customer 的联想输入框
			
	/**
	propertyProjectListForHiddenId("unitName", "hiddenUnitId"); 
	userListForHiddenId("saleName", "saleHiddenId");
	
	getBuildListFromPropertyId("projectName", "hiddenId", "buildId");
	**/
	
});


//转合同
function changeToContract(confirmId){
	
	$.ajax({
		type:"get",
		url: "./saleunit/confirm/guangzhou/changeToContract.action",
		data: "confirmId=" + confirmId,
		dataType: "json",
		success: function(data){
			
			if(data.type == "true"){
				
				$("#changeToContractButton").hide();
				
				var ret = confirm("转合同成功,是否跳到合同页面?");				
				if(ret == true){
					
					loading();
					var contractId = data.id;
					location.href = getBasePath() + "saleunit/contract/guangzhou/getById.action?id=" + contractId;
					
				}
				
				
			}else{
				alert("转合同失败,请重新操作");
			}
			
		}
		
	});
	
	return false;
}

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

/**
function showTip(tipSug){
	$("#suggestion").html(tipSug);
}
*/

