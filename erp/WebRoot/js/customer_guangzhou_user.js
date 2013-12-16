/**
 * 广州的用户js
 */

//提示框 top

function userList(userTextId){
	//userTextId为提示框id,
	$("#" + userTextId).autocomplete("./customer_guangzhou/search/users.action", {
		width: 150,  //提示框宽度
		selectFirst: false
	});
	
}

function userListForHiddenId(userTextId, hiddenId){
	//projectTextId为提示框id, hiddenId保存选择的project的id, 楼盘项目	
	var searchAction = "./customer_guangzhou/search/users.action";
	var checkAction = "./customer_guangzhou/search/getUserIdByName.action";
	//baseUserListForHiddenId(userTextId, hiddenId, searchAction, checkAction);
	baseUserListForHiddenId(userTextId, hiddenId, searchAction, "");

}

function appointCustomerListForHiddenId(customerTextId, hiddenId){
	
	var searchAction = "./customer_guangzhou/search/appointCustomers.action";
	
	baseUserListForHiddenId(customerTextId, hiddenId, searchAction, "");
}

function confirmCustomerListForHiddenId(customerTextId, hiddenId){
	
	var searchAction = "./customer_guangzhou/search/confirmCustomers.action";
	
	baseUserListForHiddenId(customerTextId, hiddenId, searchAction, "");
}

function contractCustomerListForHiddenId(customerTextId, hiddenId){
	
	var searchAction = "./customer_guangzhou/search/contractCustomers.action";
	
	baseUserListForHiddenId(customerTextId, hiddenId, searchAction, "");
}

function baseUserListForHiddenId(userTextId, hiddenId, searchAction, checkAction){
	
	$("#" + userTextId).autocomplete(searchAction, {
		width: 150,  //提示框宽度
		selectFirst: false,
		setHiddenId: hiddenId
	});

	$("#" + userTextId).blur(function(){
		var userName = $("#" + userTextId).val();
		
		if(userName != "" && userName != " "){
				if(checkAction != ""){
					$.ajax({
						type:"post",
						url: checkAction,
						data: "userName=" + userName,
						dataType: "html",
						success: function(data){
							
							$("#" + hiddenId).val(data);
						}
						
					});
				}
			
		}else{
			$("#" + hiddenId).val("");			
		}
	});

}


// appoint customer start
// 保存操作
function saveAppointCustomer(){
	
	var appointCustomerName = $("#appointCustomerName").val();
	var appointCustomerGender = $("#appointCustomerGender").val();
	var appointCustomerIdcardType = $("#appointCustomerIdcardType").val();
	var appointCustomerIdcardNo = $("#appointCustomerIdcardNo").val();
	var appointCustomerPhone = $("#appointCustomerPhone").val();
	
	if(appointCustomerName == ""){
		alert("客户姓名不能为空");
		return false;
	}
	
	if(appointCustomerPhone == ""){
		alert("电话号码不能为空");
		return false;
	}
	
	//$('#appointCustomerSubmit').css('display', 'none');
	$('#suggId').html('提交中...');	
	
	$.ajax({
		type:"post",
		url: "./customer_guangzhou/search/addAppointCustomer.action",
		data: "appointCustomer.customerName=" + appointCustomerName + "&appointCustomer.gender=" + appointCustomerGender 
			+ "&appointCustomer.idcardType=" + appointCustomerIdcardType + "&appointCustomer.idcardNo=" + appointCustomerIdcardNo
			+ "&appointCustomer.phone=" + appointCustomerPhone,
		dataType: "html",
		success: function(data){
			
			$("#appointCustomerId").val(data);
			//$('#appointCustomerSubmit').css('display', 'block');
			
			$("#appointCustomerName").val("");
			$("#appointCustomerPhone").val("");
			$("#appointCustomerGender").val("");
			$("#appointCustomerIdcardType").val("");
			$("#appointCustomerIdcardNo").val("");
			
			if(data != ""){
				//保存成功
				
				$("#hiddenCustomerId").attr("value", data);
				$('#suggId').html("<font color='red'>保存成功</font>");
				
			}else{				
				//保存失败
				
				$('#suggId').html("<font color='red'>保存失败,请重新新建</font>");
			}
		}		
	});
}

//增加成功后关闭操作
function appointCustomerCloseFn(){
	
	var appointCustomerId = $("#appointCustomerId").val();
	if(appointCustomerId != "" && appointCustomerId != undefined){
		//表明保存成功
		$.ajax({
			type:"get",
			url: "./customer_guangzhou/search/getAppointCustomerById.action",
			data: "appointCustomerId=" + appointCustomerId,
			dataType: "html",
			success: function(data){
				
				$("#customerName").val(data);
			}
		});
	}
}

function appointCustomerCloseFnToFourth(){
		
	var buildId = $("#hiddenBuildId").val();
	var unitId = $("#hiddenUnitId").val();
	var customerId = $("#hiddenCustomerId").val();
	
	if(customerId != "" && customerId != undefined){
		window.location.href = 
			getBasePath() + "saleunit/appoint/guangzhou/changeCustomerToFourth.action?buildId=" + buildId + "&unitId=" + unitId + "&customerId=" + customerId;
	}
	
}

// 增加页面
function appointCustomer(){
	$.ajax({
		type:"post",
		url: "./customer_guangzhou/search/toAddAppointCustomer.action",  //查询一些相关的数据
		dataType: "html",
		success: function(data){
			
			var dataJson = eval("("+data+")");
			
			var followDialog = 	
			 "<head><script type=\"text/javascript\" language=\"javascript\" src=\"./js/customer_guangzhou_user.js\"></script></head>"
			+ "<div class='gbox1'><table border='0' cellpadding='0' cellspacing='1' class='gbox' style='white-space:nowrap' width='450px'>"
			+ "<tr bgcolor='#FFFFFF' height='28' style='white-space:nowrap'><td align='center' style='width:150px'><font color='#FF0000'>*</font>姓名</td><td>&nbsp;&nbsp;"
			+ "<input type='text' id='appointCustomerName' name='appointCustomer.customerName'/>"
			+ "</td></tr>"
			+ "<tr bgcolor='#FFFFFF' height='28'><td align='center'><font color='#FF0000'>*</font>电话号码</td><td>&nbsp;&nbsp;"
			+ "<input type='text' id='appointCustomerPhone' name='appointCustomer.phone'/>"
			+ "<td></tr>"
			+ "<tr bgcolor='#FFFFFF' height='28'><td align='center'>性别</td><td>&nbsp;&nbsp;"
			+ dataJson.gender
			+ "</td></tr>"
			+ "<tr bgcolor='#FFFFFF' height='28'><td align='center'>证件类型</td><td>&nbsp;&nbsp;"
			+ dataJson.idCardType
			+ "<td></tr>"
			+ "<tr bgcolor='#FFFFFF' height='28'><td align='center'>证件号码</td><td>&nbsp;&nbsp;"
			+ "<input type='text' id='appointCustomerIdcardNo' name='appointCustomer.idcardNo'/>"
			+ "<td></tr>"
			+ "<tr bgcolor='#FFFFFF' align='center'><td colspan='2' height='28'>"
			+ "<input id='appointCustomerSubmit' type='button' value='  提交  ' "
			+ "onClick=\"saveAppointCustomer()\"/><span id='suggId'></span></td></tr>"
			+ "</table></div>"
			;				
			
			//var dialog = new Dialog(followDialog, {title:'<p style="color:black;font-weight: bold;">新建客户</p>', afterClose:appointCustomerCloseFn});
			var dialog = new Dialog(followDialog, {title:'<p style="color:black;font-weight: bold;">新建客户</p>', afterClose:appointCustomerCloseFnToFourth});
			dialog.show();
			
			}
		});
}

//查看页面
function showAppointCustomer(customerId){
	$.ajax({
		type:"post",
		url: "./customer_guangzhou/search/showAppointCustomer.action",  //查询一些相关的数据
		data: "appointCustomerId=" + customerId,
		dataType: "html",
		success: function(data){
			
			var dataJson = eval("("+data+")");
			
			var followDialog = 	
			 "<head><script type=\"text/javascript\" language=\"javascript\" src=\"./js/customer_guangzhou_user.js\"></script></head>"
			+ "<div class='gbox1'><table border='0' cellpadding='0' cellspacing='1' class='gbox' style='white-space:nowrap' width='450px'>"
			+ "<tr bgcolor='#FFFFFF' height='28' style='white-space:nowrap'><td align='center' style='width:150px'><font color='#FF0000'>*</font>姓名</td><td>&nbsp;&nbsp;"
			+ dataJson.customerName
			+ "</td></tr>"
			+ "<tr bgcolor='#FFFFFF' height='28'><td align='center'><font color='#FF0000'>*</font>电话号码</td><td>&nbsp;&nbsp;"
			+ dataJson.phone
			+ "<td></tr>"
			+ "<tr bgcolor='#FFFFFF' height='28'><td align='center'>性别</td><td>&nbsp;&nbsp;"
			+ dataJson.gender
			+ "</td></tr>"
			+ "<tr bgcolor='#FFFFFF' height='28'><td align='center'>证件类型</td><td>&nbsp;&nbsp;"
			+ dataJson.idCardType
			+ "<td></tr>"
			+ "<tr bgcolor='#FFFFFF' height='28'><td align='center'>证件号码</td><td>&nbsp;&nbsp;"
			+ dataJson.idCardNo
			+ "<td></tr>"			
			+ "</table></div>"
			;				
			
			
			var dialog = new Dialog(followDialog, {title:'<p style="color:black;font-weight: bold;">查看客户</p>', 
									width:'450px',ie6height:"235px", ie6width:"512px"});
			dialog.show();
			
			}
		});
	
	return false;
}

// appoint customer end

// confirm customer start
// 保存操作
function saveConfirmCustomer(typeVal){
	
	var confirmCustomerName = $("#confirmCustomerName").val();
	var confirmCustomerGender = $("#confirmCustomerGender").val();
	var confirmCustomerIdcardType = $("#confirmCustomerIdcardType").val();
	var confirmCustomerIdcardNo = $("#confirmCustomerIdcardNo").val();
	var confirmCustomerPhone = $("#confirmCustomerPhone").val();
	
	if(confirmCustomerName == ""){
		alert("客户姓名不能为空");
		return false;
	}
	
	if(confirmCustomerPhone == ""){
		alert("电话号码不能为空");
		return false;
	}
	
	//$('#appointCustomerSubmit').css('display', 'none');
	$('#suggId').html('提交中...');
	
	$.ajax({
		type:"post",
		url: "./customer_guangzhou/search/addConfirmCustomer.action",
		data: "confirmCustomer.customerName=" + confirmCustomerName + "&confirmCustomer.gender=" + confirmCustomerGender 
			+ "&confirmCustomer.idcardType=" + confirmCustomerIdcardType + "&confirmCustomer.idcardNo=" + confirmCustomerIdcardNo
			+ "&confirmCustomer.phone=" + confirmCustomerPhone
			+ "&confirmCustomer.confirmType=" + typeVal,
		dataType: "html",
		success: function(data){
			
			$("#confirmCustomerId").val(data);
			
			$("#confirmCustomerName").val("");
			$("#confirmCustomerGender").val("");
			$("#confirmCustomerIdcardType").val("");
			$("#confirmCustomerIdcardNo").val("");
			$("#confirmCustomerPhone").val("");
			
			if(data != ""){
				//保存成功
				
				$("#hiddenCustomerId").attr("value", data);
				$('#suggId').html("<font color='red'>保存成功</font>");
				
			}else{				
				//保存失败
				
				$('#suggId').html("<font color='red'>保存失败,请重新新建</font>");
			}
		}		
	});
}

//增加成功后关闭操作
function confirmCustomerCloseFn(){
	
	var confirmCustomerId = $("#confirmCustomerId").val();
	if(confirmCustomerId != ""){
		//表明保存成功
		$.ajax({
			type:"get",
			url: "./customer_guangzhou/search/getConfirmCustomerById.action",
			data: "confirmCustomerId=" + confirmCustomerId,
			dataType: "html",
			success: function(data){
				
				$("#customerName").val(data);
			}
		});
	}
}

function confirmCustomerCloseFnToFourth(){
		
	var buildId = $("#hiddenBuildId").val();
	var unitId = $("#hiddenUnitId").val();
	var customerId = $("#hiddenCustomerId").val();
	
	if(customerId != "" && customerId != undefined){
		window.location.href = 
			getBasePath() + "saleunit/confirm/guangzhou/changeCustomerToFourth.action?buildId=" + buildId + "&unitId=" + unitId + "&customerId=" + customerId;
	}
	
}

function contractCustomerCloseFnToFourth(){
		
	var buildId = $("#hiddenBuildId").val();
	var unitId = $("#hiddenUnitId").val();
	var customerId = $("#hiddenCustomerId").val();
	
	if(customerId != "" && customerId != undefined){
		window.location.href = 
			getBasePath() + "saleunit/contract/guangzhou/changeCustomerToFourth.action?buildId=" + buildId + "&unitId=" + unitId + "&customerId=" + customerId;
	}
	
}

// 增加页面,typeStr的值可以为confirm,contract
function confirmCustomer(typeStr){
	$.ajax({
		type:"post",
		url: "./customer_guangzhou/search/toAddConfirmCustomer.action",  //查询一些相关的数据
		data: "type=" + typeStr,
		dataType: "html",
		success: function(data){
			
			var dataJson = eval("("+data+")");
			
			var followDialog = 	
			 "<head><script type=\"text/javascript\" language=\"javascript\" src=\"./js/customer_guangzhou_user.js\"></script></head>"
			+ "<div class='gbox1'><table border='0' cellpadding='0' cellspacing='1' class='gbox' style='white-space:nowrap' width='450px'>"
			+ "<tr bgcolor='#FFFFFF' height='28' style='white-space:nowrap'><td align='center' style='width:150px'><font color='#FF0000'>*</font>姓名</td><td>&nbsp;&nbsp;"
			+ "<input type='text' id='confirmCustomerName' name='confirmCustomer.customerName'/>"
			+ "</td></tr>"
			+ "<tr bgcolor='#FFFFFF' height='28'><td align='center'><font color='#FF0000'>*</font>电话号码</td><td>&nbsp;&nbsp;"
			+ "<input type='text' id='confirmCustomerPhone' name='confirmCustomer.phone'/>"
			+ "<td></tr>"
			+ "<tr bgcolor='#FFFFFF' height='28'><td align='center'>性别</td><td>&nbsp;&nbsp;"
			+ dataJson.gender
			+ "</td></tr>"
			+ "<tr bgcolor='#FFFFFF' height='28'><td align='center'>证件类型</td><td>&nbsp;&nbsp;"
			+ dataJson.idCardType
			+ "<td></tr>"
			+ "<tr bgcolor='#FFFFFF' height='28'><td align='center'>证件号码</td><td>&nbsp;&nbsp;"
			+ "<input type='text' id='confirmCustomerIdcardNo' name='confirmCustomer.idcardNo'/>"
			+ "<td></tr>"			
			+ "<tr bgcolor='#FFFFFF' align='center'><td colspan='2' height='28'>"
			+ "<input id='confirmCustomerSubmit' type='button' value='  提交  ' "
			+ "onClick=\"saveConfirmCustomer('" + dataJson.type + "')\"/><span id='suggId'></span></td></tr>"
			+ "</table></div>"
			;				
			
			var closeFn = "";
			if(typeStr == "confirm"){
				closeFn = confirmCustomerCloseFnToFourth;
			}
			if(typeStr == "contract"){
				closeFn = contractCustomerCloseFnToFourth;
			}
			
			var dialog = new Dialog(followDialog, {title:'<p style="color:black;font-weight: bold;">新建客户</p>', afterClose:closeFn});
			dialog.show();
			
			}
		});
}

//查看页面
function showConfirmCustomer(customerId){
	$.ajax({
		type:"post",
		url: "./customer_guangzhou/search/showConfirmCustomer.action",  //查询一些相关的数据
		data: "confirmCustomerId=" + customerId,
		dataType: "html",
		success: function(data){
			
			var dataJson = eval("("+data+")");
			
			var followDialog = 	
			 "<head><script type=\"text/javascript\" language=\"javascript\" src=\"./js/customer_guangzhou_user.js\"></script></head>"
			+ "<div class='gbox1'><table border='0' cellpadding='0' cellspacing='1' class='gbox' style='white-space:nowrap' width='450px'>"
			+ "<tr bgcolor='#FFFFFF' height='28' style='white-space:nowrap'><td align='center' style='width:150px'><font color='#FF0000'>*</font>姓名</td><td>&nbsp;&nbsp;"
			+ dataJson.customerName
			+ "</td></tr>"
			+ "<tr bgcolor='#FFFFFF' height='28'><td align='center'><font color='#FF0000'>*</font>电话号码</td><td>&nbsp;&nbsp;"
			+ dataJson.phone
			+ "<td></tr>"
			+ "<tr bgcolor='#FFFFFF' height='28'><td align='center'>性别</td><td>&nbsp;&nbsp;"
			+ dataJson.gender
			+ "</td></tr>"
			+ "<tr bgcolor='#FFFFFF' height='28'><td align='center'>证件类型</td><td>&nbsp;&nbsp;"
			+ dataJson.idCardType
			+ "<td></tr>"
			+ "<tr bgcolor='#FFFFFF' height='28'><td align='center'>证件号码</td><td>&nbsp;&nbsp;"
			+ dataJson.idCardNo
			+ "<td></tr>"						
			+ "</table></div>"
			;				
			
			
			var dialog = new Dialog(followDialog, {title:'<p style="color:black;font-weight: bold;">查看客户</p>', ie6height:"235px"});
			dialog.show();
			
			}
		});
}

// confirm customer end

