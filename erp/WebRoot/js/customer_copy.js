var attr_ids="";
var attr_action="";


function nameCheck(){
	var copyUserId = $("#copyUserId").val();
	if(copyUserId == ""){

		myAlert("请先选择销售");
		return false;
	}else{
		
		$('#toCopy').css('display', 'none');
		$('#suggId').html('提交中...');
		return true;
	}
}


function copyCustomers(){
	var delIds = document.getElementsByName("delId");
	var ids = "";
	
	for(var i=0; i<delIds.length; i++){
		if(delIds[i].checked == true){
			ids += delIds[i].value + "_";
		}
	}
	
	if(ids != ""){
		
		var copyText = "<form action='./customer_guangzhou/copy/customers.action' method='post'>"
			+ "<div class='gbox1'><table border='0' cellpadding='0' cellspacing='1' class='gbox' style='white-space:normal' width='100%'>"
			+ "<tr bgcolor='#FFFFFF' height='28' style='white-space:nowrap'><td colspan='3' align='center'>(将客户转移给对应的销售)</td></tr>"
			+ "<tr bgcolor='#FFFFFF' height='28' style='white-space:nowrap'><td style='width:20%' align='center' valign='middle'>销售</td>"
			+ "<td><input type='text' id='copyUserName' name='copyUserName'/><input type='hidden' id='copyUserId' name='copyUserId'/></td>"
			+ "<td  style='width:20%'><span id='suggId'></span><input type='submit' id='toCopy' value='  转移  ' onClick=\"return nameCheck()\"/>"
			+ "<input type='hidden' id='copyIds' name='copyIds'/></td>"
			+ "</tr></table></div></form>"
			;			
		
		var dialog = new Dialog(copyText, {title:'<p style="color:black;font-weight: bold;">客户转移</p>', ie6width:"320px", ie6height:"160px"});			
		dialog.show();
		
		userListForHiddenId("copyUserName", "copyUserId");  //绑定提示框,该方法在customer_guangzhou_user.js
		$("#copyIds").val(ids);
		
		return false;
		
	}else{
		myAlert("请选择要转移的客户.");
		return false;
	}
	
}

function recoverCustomers(action){
	var delIds = document.getElementsByName("delId");
	var ids = "";
	
	for(var i=0; i<delIds.length; i++){
		if(delIds[i].checked == true){
			ids += delIds[i].value + "_";
		}
	}
	
	if(ids != ""){
		attr_ids = ids;
		attr_action = action;
		var copyText = "<form action='./customer_guangzhou/recover/customers.action' method='post'>"
			+ "<div class='gbox1'><table border='0' cellpadding='0' cellspacing='1' class='gbox' style='white-space:normal' width='100%'>"
			+ "<tr bgcolor='#FFFFFF' height='28' style='white-space:nowrap'><td colspan='3' align='center'>(将客户转移给对应的销售)</td></tr>"
			+ "<tr bgcolor='#FFFFFF' height='28' style='white-space:nowrap'><td style='width:20%' align='center' valign='middle'>销售</td>"
			+ "<td><input type='text' id='copyUserName' name='copyUserName'/><input type='hidden' id='copyUserId' name='copyUserId'/></td>"
			+ "<td  style='width:20%'><span id='suggId'></span><input type='submit' id='toCopy' value='  转移  ' onClick=\"return nameCheck()\"/>"
			+ "<input type='hidden' id='copyIds' name='copyIds'/></td>"
			+ "</tr></table></div></form>"
			;			
		
		var dialog = new Dialog(copyText, {title:'<p style="color:black;font-weight: bold;">恢复作废客户转移</p>', ie6width:"320px", ie6height:"160px"});			
		dialog.show();
		
		userListForHiddenId("copyUserName", "copyUserId");  //绑定提示框,该方法在customer_guangzhou_user.js
		$("#copyIds").val(ids);
		
		return false;
		
	}else{
		myAlert("请选择要恢复的作废客户.");
		return false;
	}
	
	
}

function copyOneCustomer(customerId){
		
	if(customerId != "" && customerId != 0){
		
		var copyText = "<form action='./customer_guangzhou/copy/customers.action' method='post'>"
			+ "<table width='260px' style='white-space:nowrap'><tr><td colspan='3' align='center'>(将客户转移给对应的销售)</td></tr>"
			+ "<tr><td>销售</td>"
			+ "<td><input type='text' id='copyUserName' name='copyUserName'/><input type='hidden' id='copyUserId' name='copyUserId'/></td>"
			+ "<td><span id='suggId'></span><input type='submit' id='toCopy' value='  转移  ' onClick=\"return nameCheck()\"/>"
			+ "<input type='hidden' id='copyIds' name='copyIds'/></td>"
			+ "</tr></table></form>"
			;			
		
		var dialog = new Dialog(copyText, {title:'<p style="color:black;font-weight: bold;">客户转移</p>', ie6width:"320px", ie6height:"110px"});		
		dialog.show();
		
		userListForHiddenId("copyUserName", "copyUserId");  //绑定提示框,该方法在customer_guangzhou_user.js
		$("#copyIds").val(customerId);
		
		return false;
		
	}else{
		myAlert("不能获取要转移客户的id.");
		return false;
	}
	
}

//设置只能跟进
function onlyFollowCustomers(){
	var delIds = document.getElementsByName("delId");
	var ids = "";
	
	for(var i=0; i<delIds.length; i++){
		if(delIds[i].checked == true){
			ids += delIds[i].value + "_";
		}
	}
	
	if(ids != ""){
		
		new MyAjaxIframeDialog({title:'客源共享设置', buttons:false,
			src:'./customer/only_follow/easyui/toSetUpOnlyFollow.action?ids=' + ids});
		
		/**
		var copyText = "<form action='./customer_guangzhou/only_follow/customers.action' method='post'>"
			+ "<div class='gbox1'><table border='0' cellpadding='0' cellspacing='1' class='gbox' style='white-space:normal' width='100%'>"
			+ "<tr bgcolor='#FFFFFF' height='28' style='white-space:nowrap'><td colspan='3' align='center'>(将只能查看客户的权限转给对应的销售)</td></tr>"
			+ "<tr bgcolor='#FFFFFF' height='28' style='white-space:nowrap'><td style='width:20%' align='center' valign='middle'>销售</td>"
			+ "<td><input type='text' id='copyUserName' name='copyUserName'/><input type='hidden' id='copyUserId' name='copyUserId'/></td>"
			+ "<td  style='width:20%'><span id='suggId'></span><input type='submit' id='toCopy' value='  转移  ' onClick=\"return nameCheck()\"/>"
			+ "<input type='hidden' id='copyIds' name='copyIds'/></td>"
			+ "</tr></table></div></form>"
			;			
		
		var dialog = new Dialog(copyText, {title:'<p style="color:black;font-weight: bold;">客户查看转移</p>', ie6width:"320px", ie6height:"160px"});			
		dialog.show();
		
		userListForHiddenId("copyUserName", "copyUserId");  //绑定提示框,该方法在customer_guangzhou_user.js
		$("#copyIds").val(ids);
		*/
		
		return false;
		
	}else{
		myAlert("请选择要设置的客户.");
		return false;
	}
	
}

function onlyFollowOneCustomer(customerId){
		
	if(customerId != "" && customerId != 0){
		
		var copyText = "<form action='./customer_guangzhou/only_follow/customers.action' method='post'>"
			+ "<table width='260px' style='white-space:nowrap'><tr><td colspan='3' align='center'>(将只能查看客户的权限转给对应的销售)</td></tr>"
			+ "<tr><td>销售</td>"
			+ "<td><input type='text' id='copyUserName' name='copyUserName'/><input type='hidden' id='copyUserId' name='copyUserId'/></td>"
			+ "<td><span id='suggId'></span><input type='submit' id='toCopy' value='  转移  ' onClick=\"return nameCheck()\"/>"
			+ "<input type='hidden' id='copyIds' name='copyIds'/></td>"
			+ "</tr></table></form>"
			;			
		
		var dialog = new Dialog(copyText, {title:'<p style="color:black;font-weight: bold;">客户查看转移</p>', ie6width:"320px", ie6height:"110px"});		
		dialog.show();
		
		userListForHiddenId("copyUserName", "copyUserId");  //绑定提示框,该方法在customer_guangzhou_user.js
		$("#copyIds").val(customerId);
		
		return false;
		
	}else{
		myAlert("不能获取要设置客户的id.");
		return false;
	}
	
}


