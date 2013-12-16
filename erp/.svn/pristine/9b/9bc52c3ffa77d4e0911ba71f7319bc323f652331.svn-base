/**
 *
 *  根据项目id获取对应的下拉框
 *
**/

function setSelByIdAndAction(selId, action, args){
	$.ajax({
		type:"post",
		url: action,
		data: args,
		dataType: "html",
		success: function(data){
			if(data != ""){
				$("#" + selId).empty();
				$("#" + selId).append(data);
			}
		}
	});
}

