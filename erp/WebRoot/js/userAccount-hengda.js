
//删除用户 恒大 +广州 
function delUserAccount(action) {
	var delIds = document.getElementsByName("delId");
	var ids = "";
	for ( var i = 0; i < delIds.length; i++) {
		if (delIds[i].checked == true) {
			ids += delIds[i].value + "_";
		}
	}
	if (ids != "") {
		var r = confirm("确定删除所选?");
		if (r == true) {
			//location.href = "./sale_hengda/userAccount/" + action + ".action?ids="
			location.href = action + ".action?ids="
					+ ids;
		} else {
			return false;
		}
	} else {
		alert("请选择删除项.");
		return false;
	}
}

//guangzhou updateuser del user role
function delUserRoleById(action) {
	
	var delIds = document.getElementsByName("delId");
	var ids = "";
	
	
	for ( var i = 0; i < delIds.length; i++) {
		if (delIds[i].checked == true) {
			ids += delIds[i].value + "_";
		}
	}
	if (ids != "") {
		var r = confirm("确定删除选择的权限?");
		if (r == true) {
			//location.href = "./sale_hengda/userAccount/" + action + ".action?ids="
			location.href = action + "&ids="+ids;
			alert("发出请求.");
		} else {
		
			return false;
		}
	} else {
		alert("请先选择用户.");
		return false;
	}
}

function delUserRole(action) {
	
	var delIds = document.getElementsByName("delId");
	var ids = "";
	var delProjectId = $("#delProjectId").val();
	var delRoleId = $("#delRoleId").val();
	if(delProjectId == null ||delProjectId=="" || delProjectId == 0){
		alert("请选择正确的项目");
		return false;
		
	}
	for ( var i = 0; i < delIds.length; i++) {
		if (delIds[i].checked == true) {
			ids += delIds[i].value + "_";
		}
	}
	if (ids != "") {
		var r = confirm("确定删除选择用户的权限?");
		if (r == true) {
			//location.href = "./sale_hengda/userAccount/" + action + ".action?ids="
			location.href = action + ".action?ids="+ids+
					"&proId="+delProjectId+
					"&roleId="+delRoleId;
			alert("发出请求.");
		} else {
		
			return false;
		}
	} else {
		alert("请先选择用户.");
		return false;
	}
}

function addUserRole(action) {
	var delIds = document.getElementsByName("delId");
	var ids = "";
	var addProjectId = $("#addProjectId").val();
	var addRoleId = $("#addRoleId").val();
	if(addProjectId == null ||addProjectId=="" || addProjectId == 0){
		alert("请选择正确的项目");
		return false;
		
	}
	for ( var i = 0; i < delIds.length; i++) {
		if (delIds[i].checked == true) {
			ids += delIds[i].value + "_";
		}
	}
	if (ids != "") {
		var r = confirm("是否所有选择用户增加这个权限?");
		if (r == true) {
			//location.href = "./sale_hengda/userAccount/" + action + ".action?ids="
			location.href = action + ".action?ids="+ids+
					"&proId="+addProjectId+
					"&roleId="+addRoleId;
		} else {
			return false;
		}
	} else {
		alert("请先选择用户.");
		return false;
	}
}

function copyUserRole(action) {
	var delIds = document.getElementsByName("delId");
	var ids = "";
	var copyUserId = $("#copyUserId").val();
	

	for ( var i = 0; i < delIds.length; i++) {
		if (delIds[i].checked == true) {
			ids += delIds[i].value + "_";
		}
	}
	if (ids != "") {
		var r = confirm("是否复制该用户权限到选择用户组?");
		if (r == true) {
			//location.href = "./sale_hengda/userAccount/" + action + ".action?ids="
			location.href = action + ".action?ids="+ids+
					"&copyUserId="+copyUserId;
		} else {
			return false;
		}
	} else {
		alert("请先选择用户.");
		return false;
	}
}

function allDel() {
	var delIds = document.getElementsByName("delId");
	var allDelVal = document.getElementById("allDel");
	if (allDelVal.checked == true) {
		for ( var i = 0; i < delIds.length; i++) {
			delIds[i].checked = true;
		}
	} else {
		for ( var i = 0; i < delIds.length; i++) {
			delIds[i].checked = false;
		}
	}
}
function delId() {
	var delIds = document.getElementsByName("delId");
	var allDel = true;
	for ( var i = 0; i < delIds.length; i++) {
		if (delIds[i].checked == false) {
			allDel = false;
		}
	}
	if (allDel) {
		document.getElementById("allDel").checked = true;
	} else {
		document.getElementById("allDel").checked = false;
	}
}