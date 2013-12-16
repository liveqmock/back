/**
  *
  * 一些公用的方法(min)
  */
  

//关闭弹出框,(主要用于包含iframe的弹出框),closeFn为关闭前的函数,suggestion为提示内容 
function closeIframeDialog(dialogId, closeMark, closeFn, suggestion){
	
	var winParent = window.parent;
		
	if(closeMark == "true"){
		
		if(typeof closeFn == "function"){
			
			closeFn();
		}
		
		//获取suggestion,并提示(.dialog-button)
		
		winParent.dialogShowSuggestion(dialogId, suggestion);
		window.setTimeout(function(){winParent.closeDialog(dialogId);}, 1000);  //closeDialog()在easyui.util.js中,1秒后关闭dialog
	}else{
		
		winParent.dialogShowSuggestion(dialogId, suggestion);
		winParent.regainSubmitButton(dialogId); //恢复禁用的提交按钮
	}
	
}
