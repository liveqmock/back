/**
 * 汇景的js
 */

$().ready(function(){
	//tip	sub
	
	$("#sub").click(function(){
		var customerName = $("#customerName").val();
		if(customerName == ""){
			clearTip("客户姓名不能为空");
			$("#customerName").focus();
			return false;
		}
		
		var phone = $("#phone").val();
		if(phone != "" && phone.match("^\\d*$|^\\d*-\\d*$") == null){
			clearTip("联系电话不合规则");
			$("#phone").val("");
			$("#phone").focus();
			return false;
		}
		
		var peerNumber = $("#peerNumber").val();
		if(peerNumber.match("^\\d*$") == null){
			clearTip("同行人数只能为数字");
			$("#peerNumber").val("");
			$("#peerNumber").focus();
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
		if(choose == "1" && $("#relationDesc").val() == ""){
			clearTip("选择了提及关系,关系描述不能为空");
			$("#relationDesc").focus();
			return false;
		}	
		
		//customer.rating 客户初步评价  ratingRemark
		var isRating = document.getElementsByName("customer.rating");
		var ratingRemark = $("#ratingRemark").val();
		if(ratingRemark == ""){
			var choose = "";
			for(var i=0; i<isRating.length; i++){
				if(isRating[i].checked == true){
					choose = isRating[i].value;
					break;
				}
			}
			if(choose == ""){
				clearTip("客户初步评价不能为空");
				return false;
			}
		}
						
	});
	
	$("#yes").click(function(){
		$("#relationDesc").removeAttr("disabled");
							 
	});
	
	$("#no").click(function(){
		$("#relationDesc").val("");
		$("#relationDesc").attr("disabled","disabled");
	});
	
	$("#customer_isRelation1").click(function(){
		$("#relationDesc").removeAttr("disabled");
							 
	});
	
	$("#customer_isRelation0").click(function(){
		$("#relationDesc").val("");
		$("#relationDesc").attr("disabled","disabled");
	});
});


/**
 * 搜索 top 
 */
function check(){
	var searchPhone = document.getElementById("searchPhone").value;
	var homePhone = document.getElementById("homePhone").value;
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
	
	if(homePhone != ""){
		if(homePhone.length < 3){
			alert("电话号码至少要3位");
			return false;
		}
		if(homePhone.match("^\\d*$") == null){
			alert("电话号码只能为数字");
			document.getElementById("homePhone").value = "";
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

function clearTip(tipSug){
	
	$("#tip").html(tipSug);
	clearSome("tip",2000); //在天銮项目的更新中没有这个
	
	$("#suggestion").html(tipSug);
	clearSome("suggestion",2000);
}

function clearSuggestion(){
	clearSome("suggestion",2000);
}

function clearSome(id, time){
	var ele = document.getElementById(id);
	if(ele != null){
		setTimeout("document.getElementById('" + id + "').innerHTML = ''", time);
	}
}
