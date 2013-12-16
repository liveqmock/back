$().ready(function(){
	$("#sub").click(function(){
		
		var articleType = $("#articleType").val();
		if(articleType == "" ){
			clearTip("文章类型不能为空");
			$("#articleType").focus();
			return false;
		}
		
		var orderIndex = $("#orderIndex").val();
		if(orderIndex == "" || orderIndex.match("^\\d*$") == null){
			clearTip("顺序只能为数字");
			$("#orderIndex").val("");
			$("#orderIndex").focus();
			return false;
		}
		var title = $("#title").val();
		if(title == "" ){
			clearTip("文章标题不能为空");
			$("#title").focus();
			return false;
		}
		
		var summary = $("#summary").val();
		if(summary == "" ){
			clearTip("文章摘要不能为空");
			$("#summary").focus();
			return false;
		}
		
		
		
		return true;
	});
	
});

function delArticle(action){
	
	
	var delIds = document.getElementsByName("delId");
	var ids = "";
	
	for(var i=0; i<delIds.length; i++){
		if(delIds[i].checked == true){
			ids += delIds[i].value + "_";
		}
	}
	
	if(ids != ""){
		var r = confirm("确定删除所选?");
		if(r == true){
			location.href ="./article/delete/"+ action +  ".action?ids=" + ids;
		}else{
			return false;
		}
	}else{
		alert("请选择要删除的数据.");
		return false;
	}
	
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
