
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
		
		var message = "确定作废所选客户?";
		try{
			
			$.messager.defaults = { ok: "确定", cancel: "取消" };
			$.messager.confirm('确认框', message, function(ret){
				if (ret){
					
					window.location.href = action + "?ids=" + ids;
				}else{
					
					return false;
				}
			});
		}catch(e){
			
			var r = confirm(message);
			if(r == true){
				window.location.href = action + "?ids=" + ids;
				
			}else{
				return false;
			}
			
		}
				
	}else{
		myAlert("请选择要作废的客户.");
		return false;
	}
	
}

