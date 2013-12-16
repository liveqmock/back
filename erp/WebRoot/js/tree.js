function clearSuggestion(){
	//clearSome("suggestion",2000);
	$("#treeName").focus();
}
$().ready(function(){
	$("#treesub").click(function(){
		var treeName = $("#treeName").val();
		if(treeName==""){
			$("#treeName").focus();
			clearTips("功能名称不能为空");
			return false;
		}
		var treeName = $("#actionUrl").val();
		if(treeName==""){
			$("#actionUrl").focus();
			clearTips("action地址不能为空");
			return false;
		}
		return true;
	});
});

function clearTips(tipSug){
	
	$("#suggestion").html(tipSug);
	$("#suggestion2").html(tipSug);
	clearSome("suggestion",5000);
	clearSome("suggestion2",5000);
}

function clearSuggestion(){
	clearSome("suggestion",5000);
	clearSome("suggestion2",5000);
}

function clearSome(id, time){
	var ele = document.getElementById(id);
	if(ele != null){
		setTimeout("document.getElementById('" + id + "').innerHTML = ''", time);
	}
}