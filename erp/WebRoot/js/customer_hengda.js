/**
 * 客户共用的js
 */

$().ready(function(){
	//tip	sub
	
	$("#hengda_sub").click(function(){
		var projectId = $("#customer_projectId").val();
		if(projectId == ""){
			clearTip("所属项目不能为空");
			return false;
		}
		
		/** 暂时注释
		var type = $("#type").val();
		var customerStates = document.getElementsByName("customer.customerState");
		var chooseState = "";
		for(var i=0; i<customerStates.length; i++){
			if(customerStates[i].checked == true){
				chooseState = customerStates[i].value;
				break;
			}
		}	
		if(type != 2 && chooseState == 3){
			clearTip("非管理员不能修改为此状态");
			return false;
		}
		*/
		
		var customerName = $("#customerName").val();
		if(customerName == ""){
			clearTip("客户姓名不能为空");
			$("#customerName").focus();
			return false;
		}
		
		var phone = $("#phone").val();
		if(phone == "" || phone.match("^\\d*$|^\\d*-\\d*$") == null){
			clearTip("联系电话不合规则");
			$("#phone").val("");
			$("#phone").focus();
			return false;
		}
		
		var jobDesc = $("#jobDesc").val();
		if(jobDesc == ""){
			clearTip("行业背景描述不能为空");
			$("#jobDesc").focus();
			return false;
		}
		
		var isRelation = document.getElementsByName("customer.isRelation");
		var choose = "";
		for(var i=0; i<isRelation.length; i++){
			if(isRelation[i].checked == true){
				choose = isRelation[i].value;
				break;
			}
		}
		if(choose == ""){
			clearTip("是否提及关系不能为空");
			return false;
		}
		if(choose == "1" && $("#relationDesc").val() == ""){
			clearTip("选择了提及关系,关系描述不能为空");
			$("#relationDesc").focus();
			return false;
		}			
		
			
		
		var isHave = false;				
		var arr = document.getElementsByName("knownFrom");
		for(var i=0; i<arr.length; i++){
			if(arr[i].checked == true){
				isHave = true;
				break;
			}					
		}				
		if(!isHave){
			clearTip("获知途径不能为空");
			return false;
		}
		
		var interest = $("#interest").val();
		if(interest == ""){
			clearTip("客户兴趣爱好不能为空");
			$("#interest").focus();
			return false;
		}
		
		// 当所选单元为必填的时候放开下面的js
		/**
		var building1 = $("#building1").val();
		var room1 = $("#room1").val();
		var originalPrice1 = $("#originalPrice1").val();
		var discountDesc1 = $("#discountDesc1").val();
		if(building1 == "" || room1 == "" || originalPrice1 == "" || discountDesc1 == ""){
			clearTip("所选单位1的数据不完整");
			return false;
		}
		if(originalPrice1.match("^\\d*$") == null){
			clearTip("原价不合规格");
			$("#originalPrice1").val("");
			$("#originalPrice1").focus();
			return false;
		}
		var originalPrice2 = $("#originalPrice2").val();
		var originalPrice3 = $("#originalPrice3").val();
		if(originalPrice2 != ""){
			if(originalPrice2.match("^\\d*$") == null){
				clearTip("原价不合规格");
				$("#originalPrice2").val("");
				$("#originalPrice2").focus();
				return false;
			}
		}
		if(originalPrice3 != ""){
			if(originalPrice3.match("^\\d*$") == null){
				clearTip("原价不合规格");
				$("#originalPrice3").val("");
				$("#originalPrice3").focus();
				return false;
			}
		}
		*/
		
		var originalPrice1 = $("#originalPrice1").val();
		if(originalPrice1.match("^\\d*$") == null){
			clearTip("原价不合规格");
			$("#originalPrice1").val("");
			$("#originalPrice1").focus();
			return false;
		}
		var originalPrice2 = $("#originalPrice2").val();
		var originalPrice3 = $("#originalPrice3").val();
		if(originalPrice2 != ""){
			if(originalPrice2.match("^\\d*$") == null){
				clearTip("原价不合规格");
				$("#originalPrice2").val("");
				$("#originalPrice2").focus();
				return false;
			}
		}
		if(originalPrice3 != ""){
			if(originalPrice3.match("^\\d*$") == null){
				clearTip("原价不合规格");
				$("#originalPrice3").val("");
				$("#originalPrice3").focus();
				return false;
			}
		}
		
		var notBuyReson = $("#notBuyReson").val();
		if(notBuyReson == ""){
			clearTip("客户购买抗性不能为空");
			$("#notBuyReson").focus();
			return false;
		}
		
		var remark1 = $("#remark1").val();
		if(remark1 == ""){
			clearTip("备注不能为空");
			$("#remark1").focus();
			return false;
		}
		
		var firstDate = $("#firstDate").val();
		if(firstDate == ""){
			clearTip("首次到场日期不能为空");	
			$("#firstDate").focus();
			return false;
		}
		
		return true;
		
	});		
	
	$("#phone").blur(function(){
		var action = $("#phone").attr("ac");
		var phone = $("#phone").val();
		
		if(phone != ""){
			$.ajax({
				type:"get",
				url: "./" + action + "!findPhoneIsExists.action",  
				data: "phone=" + phone,
				dataType: "html",
				success: function(data){
					if(data != ""){
						clearTip(data);
						$("#phone").val("");
						$("#phone").focus();
					}
				}
			});
		}
							  
	});
	
	$("#yes").focus(function(){
		$("#red").html("<font color='red'>*</font>");
		$("#relationDesc").removeAttr("disabled");//去除input元素的disabled属性
	});
	
	$("#no").focus(function(){
		$("#red").html("");
		$("#relationDesc").val("");
		$("#relationDesc").attr("disabled","disabled");//将input元素设置为disabled
						
	});
	
	/**
	 * update 使用 top
	 */
	
	$("#customer_isRelation1").focus(function(){
		$("#red").html("<font color='red'>*</font>");
		$("#relationDesc").removeAttr("disabled");//去除input元素的disabled属性
	});
	
	$("#customer_isRelation0").focus(function(){
		$("#red").html("");
		$("#relationDesc").val("");
		$("#relationDesc").attr("disabled","disabled");//将input元素设置为disabled
	});
	
	$("#follow").click(function(){
		var action = $("#follow").attr("ac");

		$.ajax({
			type:"get",
			url: "./" + action + "/getSomeForAddFollow.action",  //查询一些相关的数据
			dataType: "html",
			success: function(data){
				var dataJson = eval("("+data+")");
				
				var followDialog = 
				 "<form action='./" + action + "/addFollow.action'><table border='0'><tr><td>跟进类型:</td><td>"
				+ dataJson.type
				+ "</td>"
				+ "<td><span id='followTypeSpan'></span></td></tr>"
				+ "<tr><td>跟进内容:</td><td>"
				+ "<textarea name='customerFollow.followDesc' id='followDesc' rows='3' cols='30'></textarea></td>"
				+ "<td><span id='followDescSpan'></span></td></tr>"
				+ "<tr><td>跟进日期:</td><td>"
				+ "<input class='Wdate' type='text' name='customerFollow.createdTime' id='createdTime' onClick='WdatePicker()' value='"
				+ dataJson.createdTime
				+ "'/></td>"
				+ "<td><span id='customerPwdSpan'></span></td></tr>"
				+ "<tr align='center'><td colspan='2'><input type='submit' value='提交'/></td></tr>"
				+ "</table></form>"
				;				
				
				var dialog = new Dialog(followDialog,{title:'客户跟进'});	
				dialog.show();
			
			}
		});
	});
	
	/**
	 * update 使用 end
	 */
	
	
});

/**
 * 搜索 top 
 */
function check(){
	var searchPhone = document.getElementById("searchPhone").value;
	var date1 = document.getElementById("date1").value;
	var date2 = document.getElementById("date2").value;
	
	if(searchPhone != ""){
		if(searchPhone.length < 3){
			alert("电话号码至少要3位");
			return false;
		}
		if(searchPhone.match("^\\d*$") == null){
			alert("电话号码只能为数字");
			document.getElementById("searchPhone").value = "";
			return false;
		}
	}
	
	if(date1 != "" && date2 != "" && date1 > date2){
		alert("前面的日期不能大于后面的日期");
		return false;
	}
	return true;
}

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

function delCustomers(action){
	var delIds = document.getElementsByName("delId");
	var ids = "";
	
	for(var i=0; i<delIds.length; i++){
		if(delIds[i].checked == true){
			ids += delIds[i].value + "_";
		}
	}
	
	if(ids != ""){
		var r = confirm("确定删除所选客户?");
		if(r == true){
			location.href = action + "!delCustomers.action?ids=" + ids;
			
		}else{
			return false;
		}
	}else{
		alert("请选择要删除的客户.");
		return false;
	}
	
}

/**
 * 搜索 end 
 */

function clearTip(tipSug){
	
	$("#tip").html(tipSug);
	clearSome("tip",2000); //在天銮项目的更新中没有这个
	
	$("#suggestion").html(tipSug);
	clearSome("suggestion",2000);
}

function clearSuggestion(){
	clearSome("suggestion",2000);
	nowTime("nowTime");
}

function clearSome(id, time){
	var ele = document.getElementById(id);
	if(ele != null){
		setTimeout("document.getElementById('" + id + "').innerHTML = ''", time);
	}
}
