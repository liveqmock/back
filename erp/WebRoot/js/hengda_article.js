

function delArticle(action) {
	var delIds = document.getElementsByName("delId");
	var ids = "";
	for ( var i = 0; i < delIds.length; i++) {
		if (delIds[i].checked == true) {
			ids += delIds[i].value + "_";
		}
	}
	if (ids != "") {
		var r = confirm("确定删除?");
		if (r == true) {
			//location.href = "./sale_hengda/userAccount/" + action + ".action?ids="
			location.href = action + ".action?ids="
					+ ids;
		} else {
			return false;
		}
	} else {
		alert("选择删除的项");
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