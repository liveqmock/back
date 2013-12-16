/**
 *  
 */
 
$().ready(function(){
				   
	$("#sub").click(function(){
							 
		var ids = ["appointDate","appointNum:number"];
		return myCheckOnlyById(ids);
			
		/*
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
		
		
	});
	
	
	$("#createAppointCustomer").click(function(){
		
		appointCustomer();
		
	});
	
	//showDiv("unitId", "hiddenUnitId", "buildId");
	showDiv("unitId","hiddenUnitId","hiddenBulidId","hiddenId");
	
	appointCustomerListForHiddenId("customerName", "appointCustomerId");   //appoint customer 的联想输入框
	
	propertyProjectListForHiddenId("projectName", "hiddenId"); //项目的联想框,及用隐藏域保存其id
			
	getBuildListFromPropertyIdForAuto("buildName", "hiddenId", "hiddenBulidId");  //根据楼盘项目id,获取对应的楼栋联想提示框
	
	//项目id有变化,要清空楼栋的值与id
	$("#projectName").change(function(){
									  
		$("#buildName").val("");
		$("#hiddenBulidId").attr("value", ""); 				
	});

	userListForHiddenId("saleName", "saleHiddenId");
	
	//getBuildListFromPropertyId("projectName", "hiddenId", "buildId");
	
});

/**
function showTip(tipSug){
	$("#suggestion").html(tipSug);
}
*/


