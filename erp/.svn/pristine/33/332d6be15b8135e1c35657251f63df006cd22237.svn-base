//此js使用之前，需要引入jquery.autocomplete.css,jquery.autocomplete.js
/**
 * 自动填充文本框
 * @param textId 文本框
 * @param hiddenId 隐藏框
 * @param searchAction 查询的地址
 * @param blurCheckAction 直接复制进去的查询地址
 */		
function autoText(textId, hiddenId, searchAction, blurCheckAction){
	$("#" + textId).autocomplete(searchAction, {
		width: 150,  //提示框宽度
		selectFirst: false,
		setHiddenId: hiddenId
	});	
	
	$("#" + textId).blur(function(){
		var projectName = $("#" + textId).val();
		
		if($.trim(projectName) != ""){
			
			if(checkAction != ""){
				$.ajax({
					type:"post",
					url: checkAction,
					data: "projectName=" + projectName,
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

/**
 * 销售人员的只能提示框
 * @param textId
 * @param hiddenId
 */
function autoTextSalesman(textId, hiddenId){
	autoText(textId,hiddenId,"./customer_guangzhou/search/sales.action","");
}