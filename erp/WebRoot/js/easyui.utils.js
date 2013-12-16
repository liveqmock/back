/**
 *  easyui 一些帮助方法
 */

//全局声明变量
var myGlobal = {
	sugg:"不合规则",
	submitIng:"提交中...",
	title:"弹出框",
	loadIng:"正在加载数据,请稍候...",
	succ:"操作成功",
	fail:"操作失败,请重试",
	checkFail:"调用有问题,请通知开发人员",
	ajaxError:"加载请求出错",
	ajaxInputError:"保存失败,可能是保存的类型不对,请重试",
	empty:"请选择"
};

//弹出框中的iframe表单的判断
function myCheckForIframeAndId(iframeId, ids){
	//var ids = ["payType","payName","payMoney:money","payWay","inBank","bankWay"];
	
	//var _easy = parent.$("#" + iframeId)[0].contentWindow; //获取iframe中的所有元素
	
	var _easy = null;
	try{
		_easy = parent.$("#" + iframeId)[0].contentWindow; //获取iframe中的所有元素
	}catch(e){
		_easy = $("#" + iframeId)[0].contentWindow; //获取iframe中的所有元素
	}
	
	var idsLength = ids.length;
	for(var i=0; i<idsLength; i++){
		
		var id = ids[i];
		
		if(typeof id == "function"){
			//增加对验证函数的判断,验证函数如果不是最后一个参数,就不应该返回true,只要在验证不通过的地方,返回提示语就可以了,
			//函数默认包含参数_easy,如果是ajax就要在调用的时候设置async: false,且返回值要放到success外部返回
			var getRet = id(_easy);
			if(getRet != undefined && getRet != ""){
				
				if(i != idsLength-1){
					//表示不是最后一个参数
					if(getRet != true){
						return getRet;
					}
				}else{
					//最后一个参数,不用考虑是否为true
					return getRet;
				}
				
			}
			
		}else{
			
			var fIndex = id.indexOf(":");
			if(fIndex > 0){
				
				var checkType = id.substring(fIndex+1, id.length);
				id = id.substring(0,fIndex); //如果checkType为function,那么id为对应的function name
				
				var module = _easy.$("#" + id); //获取对应的组件
				
				if(checkType.toLowerCase() == "money"){
					
					var value = module.val();
					if(!$.isMoney(value)){
						var sugg = initSuggByModule(module);
						bindValidate(module, myGlobal.sugg, _easy.$("body"));
						module.focus();
						module.val("");
						return sugg + myGlobal.sugg;
					}
					
				}else if(checkType.toLowerCase() == "mail"){
					
					var value = module.val();
					if(!$.isMail(value)){
						var sugg = initSuggByModule(module);	
						bindValidate(module, myGlobal.sugg, _easy.$("body"));
						module.focus();
						module.val("");
						return sugg + myGlobal.sugg;
					}
					
					
				}else if(checkType.toLowerCase() == "phone"){
					
					var value = module.val();
					if(!$.isPhone(value)){
						var sugg = initSuggByModule(module);	
						bindValidate(module, myGlobal.sugg, _easy.$("body"));
						module.focus();
						module.val("");
						return sugg + myGlobal.sugg;
					}
					
				}else if(checkType.toLowerCase() == "number"){
					
					var value = module.val();
					if(value=="" || isNaN(value)){
						var sugg = initSuggByModule(module);	
						bindValidate(module, myGlobal.sugg, _easy.$("body"));
						module.focus();
						module.val("");
						return sugg + myGlobal.sugg;
					}
					
				}else if(checkType.toLowerCase() == "combobox"){
					
					var value = module.combobox("getValue");
					if(value=="" || value==myGlobal.empty){
						var sugg = initSuggByModule(module);	
						bindValidate(module.combo("textbox"), myGlobal.sugg, _easy.$("body")); 
						module.combo("textbox").focus();
						return sugg + myGlobal.sugg;
					}
					
				}else if(checkType.toLowerCase() == "datebox"){
					
					var value = module.datebox("getValue");
					if(value=="" || !$.isDate(value)){
						var sugg = initSuggByModule(module);	
						bindValidate(module.combo("textbox"), myGlobal.sugg, _easy.$("body")); 
						module.combo("clear"); //清空	
						module.combo("textbox").focus();	
						return sugg + myGlobal.sugg;
					}
					
				}else if(checkType.toLowerCase() == "name"){
					//多选或者单选,radio,checkbox
					var nameModule = _easy.$("input[name='" + id + "']");
					var checkedVal = _easy.$("input:[name='" + id + "']:checked").val();
					if(checkedVal == undefined || checkedVal == null){
	
						var sugg = initSuggByModule(nameModule);
						bindValidate(nameModule, myGlobal.sugg, _easy.$("body"));
						nameModule.focus();
						return sugg + myGlobal.sugg;
					}
	
				}else{
	
					myAlert("没有" + checkType + ",这种检查类型");
					return "";
				}
				
			}else{
				//默认检验类型,只是判断是否为空
				
				var module = _easy.$("#" + id);
				var value = module.val();
									
				if(value == ""){
					
					var sugg = initSuggByModule(module);				
					bindValidate(module, myGlobal.sugg, _easy.$("body"));
					module.focus();
					return sugg + myGlobal.sugg;
				}			
				
			}
			
		}
		
	}
	
	return true;
}

//弹出框中的iframe表单的判断(有自定义提示)
function myCheckForIframeAndIdByIdsSugg(iframeId, ids, idsSugg){
	
	var _easy = null;
	try{
		_easy = parent.$("#" + iframeId)[0].contentWindow; //获取iframe中的所有元素
	}catch(e){
		_easy = $("#" + iframeId)[0].contentWindow; //获取iframe中的所有元素
	}
	
	var idsLength = ids.length;
	for(var i=0; i<idsLength; i++){
		
		var id = ids[i];
		
		if(typeof id == "function"){
			//增加对验证函数的判断,验证函数如果不是最后一个参数,就不应该返回true,只要在验证不通过的地方,返回提示语就可以了,
			//函数默认包含参数_easy,如果是ajax就要在调用的时候设置async: false,且返回值要放到success外部返回
			var getRet = id(_easy);
			if(getRet != undefined && getRet != ""){
				
				if(i != idsLength-1){
					//表示不是最后一个参数
					if(getRet != true){
						return getRet;
					}
				}else{
					//最后一个参数,不用考虑是否为true
					return getRet;
				}
				
			}
			
		}else{
			
			var fIndex = id.indexOf(":");
			if(fIndex > 0){
				
				var checkType = id.substring(fIndex+1, id.length);
				id = id.substring(0,fIndex); //如果checkType为function,那么id为对应的function name
				
				var module = _easy.$("#" + id); //获取对应的组件
				var ownSugg = idsSugg[id];
				
				if(checkType.toLowerCase() == "money"){
					
					var value = module.val();
					if(!$.isMoney(value)){
						var sugg = initSuggByModule(module);
						module.focus();
						module.val("");						
						return ownBindValidateAndRet(module, sugg, ownSugg, _easy.$("body"));				
					}
					
				}else if(checkType.toLowerCase() == "mail"){
					
					var value = module.val();
					if(!$.isMail(value)){
						var sugg = initSuggByModule(module);
						module.focus();
						module.val("");						
						return ownBindValidateAndRet(module, sugg, ownSugg, _easy.$("body"));
					}					
					
				}else if(checkType.toLowerCase() == "phone"){
					
					var value = module.val();
					if(!$.isPhone(value)){
						var sugg = initSuggByModule(module);
						module.focus();
						module.val("");						
						return ownBindValidateAndRet(module, sugg, ownSugg, _easy.$("body"));
					}
					
				}else if(checkType.toLowerCase() == "number"){
					
					var value = module.val();
					if(value=="" || isNaN(value)){
						var sugg = initSuggByModule(module);
						module.focus();
						module.val("");						
						return ownBindValidateAndRet(module, sugg, ownSugg, _easy.$("body"));
					}
					
				}else if(checkType.toLowerCase() == "combobox"){
					
					var value = module.combobox("getValue");
					if(value=="" || value==myGlobal.empty){						
						var sugg = initSuggByModule(module);
						module.combo("textbox").focus();	
						return ownBindValidateAndRet(module.combo("textbox"), sugg, ownSugg, _easy.$("body"));
					}
					
				}else if(checkType.toLowerCase() == "datebox"){
					
					var value = module.datebox("getValue");
					if(value=="" || !$.isDate(value)){
						var sugg = initSuggByModule(module);							
						module.combo("clear"); //清空	
						module.combo("textbox").focus();	
						return ownBindValidateAndRet(module.combo("textbox"), sugg, ownSugg, _easy.$("body"));						
					}
					
				}else if(checkType.toLowerCase() == "name"){
					//多选或者单选,radio,checkbox
					var nameModule = _easy.$("input[name='" + id + "']");
					var checkedVal = _easy.$("input:[name='" + id + "']:checked").val();
					if(checkedVal == undefined || checkedVal == null){
	
						var sugg = initSuggByModule(nameModule);						
						nameModule.focus();						
						return ownBindValidateAndRet(nameModule, sugg, ownSugg, _easy.$("body"));	
					}
	
				}else{
	
					myAlert("没有" + checkType + ",这种检查类型");
					return "";
				}
				
			}else{
				//默认检验类型,只是判断是否为空
				
				var module = _easy.$("#" + id);
				var value = module.val();
									
				if(value == ""){
					
					var ownSugg = idsSugg[id];
					var sugg = initSuggByModule(module);						
					module.focus();						
					return ownBindValidateAndRet(module, sugg, ownSugg, _easy.$("body"));						
				}			
				
			}
			
		}
		
	}
	
	return true;
}

//自定义提示语的显示及返回
function ownBindValidateAndRet(module, sugg, ownSugg, valiBody){
	
	var validateSugg = myGlobal.sugg; //页面组件的提示语
	var retSugg = sugg + myGlobal.sugg; //返回的提示语
	
	if(ownSugg != undefined && ownSugg != ""){
		validateSugg = ownSugg;
		retSugg = ownSugg;
	}
	
	bindValidate(module, validateSugg, valiBody);						
	return retSugg;
}

/**
 * 弹出框中的div表单的判断
 */
function myCheckForDivAndId(_easy, ids){
			
	for(var i=0; i<ids.length; i++){
		
		var id = ids[i];
		
		if(typeof id == "function"){
			//增加对验证函数的判断,验证函数如果不是最后一个参数,就不应该返回true,只要在验证不通过的地方,返回提示语就可以了,
			//函数默认包含参数_easy,如果是ajax就要在调用的时候设置async: false,且返回值要放到success外部返回
			var getRet = id(_easy);
			if(getRet != undefined && getRet != ""){
				
				if(i != idsLength-1){
					//表示不是最后一个参数
					if(getRet != true){
						return getRet;
					}
				}else{
					//最后一个参数,不用考虑是否为true
					return getRet;
				}
				
			}
			
		}else{
			
			var fIndex = id.indexOf(":");
			if(fIndex > 0){
				
				var checkType = id.substring(fIndex+1, id.length);
				id = id.substring(0,fIndex); //如果checkType为function,那么id为对应的function name
	
				var module = parent.$(_easy).find("#" + id); //获取对应的组件
				
				if(checkType.toLowerCase() == "money"){
					
					var value = module.val();
					if(!$.isMoney(value)){
						var sugg = initSuggByModule(module);
						bindValidate(module, myGlobal.sugg, parent.$("body"));
						module.focus();
						module.val("");
						return sugg + myGlobal.sugg;
					}
					
				}else if(checkType.toLowerCase() == "mail"){
					
					var value = module.val();
					if(!$.isMail(value)){
						var sugg = initSuggByModule(module);	
						bindValidate(module, myGlobal.sugg, parent.$("body"));
						module.focus();
						module.val("");
						return sugg + myGlobal.sugg;
					}
					
					
				}else if(checkType.toLowerCase() == "phone"){
					
					var value = module.val();
					if(!$.isPhone(value)){
						var sugg = initSuggByModule(module);	
						bindValidate(module, myGlobal.sugg, parent.$("body"));
						module.focus();
						module.val("");
						return sugg + myGlobal.sugg;
					}
					
				}else if(checkType.toLowerCase() == "number"){
					
					var value = module.val();
					if(value=="" || isNaN(value)){
						var sugg = initSuggByModule(module);	
						bindValidate(module, myGlobal.sugg, parent.$("body"));
						module.focus();
						module.val("");
						return sugg + myGlobal.sugg;
					}
					
				}else if(checkType.toLowerCase() == "combobox"){
					
					var value = module.combobox("getValue");
					if(value=="" || value==myGlobal.empty){
						var sugg = initSuggByModule(module);	
						bindValidate(module.combo("textbox"), myGlobal.sugg, parent.$("body")); 
						module.combo("textbox").focus();
						return sugg + myGlobal.sugg;
					}
					
				}else if(checkType.toLowerCase() == "datebox"){
					
					var value = module.datebox("getValue");
					if(value=="" || !$.isDate(value)){
						var sugg = initSuggByModule(module);	
						bindValidate(module.combo("textbox"), myGlobal.sugg, parent.$("body")); 
						module.combo("clear"); //清空	
						module.combo("textbox").focus();	
						return sugg + myGlobal.sugg;
					}
					
				}else if(checkType.toLowerCase() == "name"){
					//多选或者单选,radio,checkbox
					var nameModule = parent.$(_easy).find("input[name='" + id + "']");
					var checkedVal = parent.$(_easy).find("input:[name='" + id + "']:checked").val();
					if(checkedVal == undefined || checkedVal == null){
						
						var sugg = initSuggByModule(nameModule);			
						bindValidate(nameModule, myGlobal.sugg, parent.$("body")); 
						nameModule.focus();
						return sugg + myGlobal.sugg;
					}
					
				}else{
					
					myAlert("没有" + checkType + ",这种检查类型");
					return "";
				}
				
			}else{
				
				//默认检验类型,只是判断是否为空
							
				var module = parent.$(_easy).find("#" + id); //获取对应的组件
				var value = module.val();
									
				if(value == ""){
					
					var sugg = initSuggByModule(module);				
					bindValidate(module, myGlobal.sugg, parent.$("body"));
					module.focus();
					return sugg + myGlobal.sugg;
				}			
				
			}
			
		}
		
	}
	
	return true;
}

//获取提示内容
function initSuggByModule(module){	
	
	try{
		var sugg = module.parent().prev().text();
		if(sugg != ""){
			//sugg = $.trim(sugg);
			var index = sugg.indexOf("*");
			if(index > -1){
				sugg = sugg.substring(index+1, sugg.length);
			}
		}
		return sugg;
	}catch(e){
		return "";
	}
}

//弹出框iframe中表单提交
function dialogIframeSubmit(iframeId, ids, formId, dialogButton){

	//var getCheck = myCheckForIframeAndId(iframeId, ids);
	
	var getCheck = "";
	try{
		
		getCheck = myCheckForIframeAndId(iframeId, ids);
	}catch(e){
		
		getCheck = myGlobal.checkFail;
	}

	if(getCheck != true){
		
		dialogButtonSugg(getCheck, dialogButton);
				
	}else{
		
		try{
			$.easyParentIframe(iframeId, formId).submit();
		}catch(e){
			$.easyIframe(iframeId, formId).submit();
		}
		
		dialogButtonSugg(myGlobal.submitIng, dialogButton);
		try{
			parent.$(dialogButton).linkbutton({disabled:true}); //禁用"提交"按钮,避免重复提交
			$(dialogButton).linkbutton({disabled:true});
		}catch(e){
			$(dialogButton).linkbutton({disabled:true});
		}
		
		clearDialogButtonSugg(2000);
	}
	
}

//根据dialogId恢复底部禁用的提交按钮
function regainSubmitButton(dialogId){
	
	var allButtons = $("#" + dialogId + " .dialog-button a");
	$(allButtons).each(function(){
		
		$(this).linkbutton({disabled:false});
	});	
}

//设置弹出框右下角按钮前的提示
function dialogButtonSugg(sugg, dialogButton){
	
	var buttonParent = $(dialogButton).parent();	
	dialogSugg(buttonParent, sugg);
}

//弹出框底部提示,获取suggestion,并提示(.dialog-button)
function dialogShowSuggestion(dialogId, suggestion){
	
	var buttonParent = $("#" + dialogId + " .dialog-button:last"); //应该加上:last,否则可能出现问题
	dialogSugg(buttonParent, suggestion);	
}

//提示内容的span,buttonParent为在其中显示的提示的组件(div),用于设定span的padding,避免因为dialog的大小而显示不出来,(不过好像ie6下有点问题),加上left:20%;都ok了
function dialogSugg(buttonParent, sugg){
	
	buttonParent.find("#__dialogSugg__").remove();
	$(buttonParent).append("<span id='__dialogSugg__' style='color:#FF0000;position:absolute;left:20%;padding-top:5px'>" + sugg + "</span>");
}

//为id为"__dialogSugg__"增加属性
function dialogSuggAttr(data, dialogButton){
	
	var isAddAttr = false; //是否有要增加的属性值
	
	var attrData = {}; //去除type及title的data	
	
	for(var key in data){
		
		if(key != undefined && key != "type" && key != "title"){
			attrData[key] = data[key];
			isAddAttr = true;
		}		
	}

	if(isAddAttr){		
	
		var buttonParent = $(dialogButton).parent(); //获取.dialog-button的div
		var suggSpan = $(buttonParent).find("#__dialogSugg__");
		for(var key in attrData){
			$(suggSpan).attr(key, attrData[key]);
		}		
	}
	
}

//清空弹出框右下角按钮前面的提示
function clearDialogButtonSugg(time){
	if(time==undefined){
		time = 2000;
	}
	setTimeout("$('#__dialogSugg__').html('')", time);	
}

//清空提示，然后关闭对话框
function clearDialogButtonSuggClose(){
	setTimeout(function(){$('#__dialogSugg__').html('');$('#myIframeDialog').dialog('close');}, 2000);
}

//扩展jquery的方法,获取iframe中的元素,使用方法:$.easyIframeVal(iframeId, id);	
$.extend({
			
	easyIframeVal:function(iframeId, id){
		
		try{
			return $("#" + iframeId)[0].contentWindow.$("#" + id).val();
		}catch(e){
			return parent.$("#" + iframeId)[0].contentWindow.$("#" + id).val();
		}
	},

	easyIframeHtml:function(iframeId, id){
		
		try{
			return $("#" + iframeId)[0].contentWindow.$("#" + id).html();
		}catch(e){
			return parent.$("#" + iframeId)[0].contentWindow.$("#" + id).html();
		}		
	},
	
	easyIframe:function(iframeId, id){
		
		try{
			return $("#" + iframeId)[0].contentWindow.$("#" + id);
		}catch(e){
			return parent.$("#" + iframeId)[0].contentWindow.$("#" + id);
		}		
	},
	
	easyIframeContentWindow:function(iframeId){
		try{
			return $("#" + iframeId)[0].contentWindow;
		}catch(e){
			return parent.$("#" + iframeId)[0].contentWindow;
		}	
	},
	
	easyParentIframeVal:function(iframeId, id){
		return parent.$("#" + iframeId)[0].contentWindow.$("#" + id).val();
	},

	easyParentIframeHtml:function(iframeId, id){
		return parent.$("#" + iframeId)[0].contentWindow.$("#" + id).html();
	},
	
	easyParentIframe:function(iframeId, id){
		return parent.$("#" + iframeId)[0].contentWindow.$("#" + id);
	},
	
	easyParentIframeContentWindow:function(iframeId){
		return parent.$("#" + iframeId)[0].contentWindow;
	}
	
});

//关闭弹出框,(主要用于包含iframe的弹出框),suggestion为提示内容,autoCloseIframeDialog("${closeMark}", "${suggestion}"); 
function autoCloseIframeDialog(closeMark, suggestion){
	
	var dialogId = "myIframeDialog";
		
	if(closeMark == "true"){
		
		//获取suggestion,并提示(.dialog-button)
		
		window.parent.dialogShowSuggestion(dialogId, suggestion);
		window.setTimeout(function(){window.parent.closeDialog(dialogId);}, 1000);  
		
	}else{

		window.parent.dialogShowSuggestion(dialogId, suggestion);
	}
	
}

//刷新tab
function refreshSelectedTab(tabsId){
	
	var selectedTab = $("#" + tabsId).tabs("getSelected");
	var iframe = $(selectedTab).find('iframe')[0];
	if(iframe != undefined){

		//iframe.src = "http://172.16.6.40:8080/erp/saleunit_chip_manager/guangzhou/searchChip.action"//iframe.src;
		//iframe.src = getBasePath() + "saleunit_chip_manager/guangzhou/searchChip.action";
		
		iframe.src = iframe.src;
		
	}else{
		selectedTab.panel('refresh');
	}
}

//打开常规的iframeDialog
//actionUrl必填 提交的action地址
//submitFormIdOrFunc必填 form的ID，自定义的提交按钮函数function，包括验证等功能的函数
//dialogTitle对话框标题
//width对话框宽度
//height对话框高度
function openNormalDialog(actionUrl,submitFormIdOrFunc,dialogTitle,width,height,isAutoClose){
	var submitFunc;
	if(typeof(submitFormIdOrFunc)=="string"){
		submitFunc=function(){	
			//验证并提交
			if($.easyParentIframe("openIframe",submitFormIdOrFunc).form('validate')){
				$.easyParentIframe("openIframe",submitFormIdOrFunc).submit();
				
				return true;
			}
		};
	}
	else{
		submitFunc = submitFormIdOrFunc;
	}
	
	if(dialogTitle==undefined){
		dialogTitle=myGlobal.title;
	}
	if(width==undefined){
		width=500;
	}
	if(height==undefined){
		height=300;
	}
	
	parent.$("#myIframeDialog").dialog({
		resizable: true,
		modal:true, //模态窗口,表示不能操作弹出框以外的内容
		maximizable: false, //显示最大化按钮
		width:width,
		height:height,
		onClose:function(){			
			//dialogCloseRefresh();
			parent.$('#openIframe').attr("src", "./saleunit_new/guangzhou/loading.jsp"); //清空内容
		},
		buttons:[{
			text:'提交',
			iconCls:'icon-ok',
			handler:function(){				
				if(submitFunc()){
					dialogButtonSugg(myGlobal.submitIng, this);				
					clearDialogButtonSugg(2000);
				}
			}
		},
		{
			text:'关闭',
			iconCls:'icon-cancel',
			handler:function(){
			parent.$('#myIframeDialog').dialog('close');
			}
		}]
		
	});
				
	parent.$('#myIframeDialog').dialog('setTitle', dialogTitle);	
	parent.$('#openIframe')[0].src=actionUrl;
	parent.$('#myIframeDialog').dialog('open');	
	
	return false;
}



//var ids = ["customerName", "phone:phone", "bookMoney:money"];		
/**
  * actionUrl请求action
  * submitFormId表单id 
  * ids提交要验证的id及规则
  * 
  */
function openNormalIframeDialog(actionUrl, submitFormId, ids, dialogTitle, width, height){
    if(submitFormId.length>0){
        if(dialogTitle==undefined){
            dialogTitle=myGlobal.title;
        }
        if(width==undefined){
            width=500;
        }
        if(height==undefined){
            height=300;
        }

        $("#myIframeDialog").dialog({
            resizable: true,
            modal:true, //模态窗口,表示不能操作弹出框以外的内容
            maximizable: false, //显示最大化按钮
            width:width,
            height:height,
            onClose:function(){

                $('#openIframe').attr("src", "./saleunit_new/guangzhou/loading.jsp"); //清空内容
                //refresh(); //刷新
            },
            buttons:[
                {
                    text:'提交',
                    iconCls:'icon-ok',
                    handler:function(){

                        //var ids = ["customerName", "phone:phone", "bookMoney:money"];
                        dialogIframeSubmit("openIframe", ids, submitFormId, this);
                    }
                },
                {
                    text:'关闭',
                    iconCls:'icon-cancel',
                    handler:function(){
                        $('#myIframeDialog').dialog('close');
                    }
                }
            ]

        });
        $('#myIframeDialog').dialog('setTitle', dialogTitle);
        $('#openIframe')[0].src=actionUrl;
        $('#myIframeDialog').dialog('open');

        return false;
    } else{
        openNormalIframeDialogNoSubmit(actionUrl,dialogTitle,width,height);
    }

}

function openNormalIframeDialogNoSubmit(actionUrl, dialogTitle, width, height){

	if(dialogTitle==undefined){
		dialogTitle=myGlobal.title;
	}
	if(width==undefined){
		width=540;
	}

    $("#myIframeDialog").dialog({
        resizable: true,
        modal:true, //模态窗口,表示不能操作弹出框以外的内容
        maximizable: false, //显示最大化按钮
        width:width,
        height:height,
        onClose:function(){

            $('#openIframe').attr("src", "./saleunit_new/guangzhou/loading.jsp"); //清空内容
        },
        buttons:[
            {
                text:'关闭',
                iconCls:'icon-cancel',
                handler:function(){
                    $('#myIframeDialog').dialog('close');
                }
            }
        ]
    });

	$('#myIframeDialog').dialog('setTitle', dialogTitle);
	$('#openIframe')[0].src=actionUrl;
	$('#myIframeDialog').dialog('open');

	return false;
}

//声明一个全局对象Namespace，用来注册命名空间
//具体使用方法参考property_project_info.jsp
Namespace = new Object(); 
// 全局对象仅仅存在register函数，参数为名称空间全路径，如"erp.saleunit.chip"
Namespace.register = function(fullNS)
{
    // 将命名空间切成N部分, 比如Grandsoft、GEA等
    var nsArray = fullNS.split('.');
    var sEval = "";
    var sNS = "";
    for (var i = 0; i < nsArray.length; i++)
    {
        if (i != 0) sNS += ".";
        sNS += nsArray[i];
        // 依次创建构造命名空间对象（假如不存在的话）的语句
        // 比如先创建erp，然后创建erp.saleunit，依次下去
        sEval += "if (typeof(" + sNS + ") == 'undefined') " + sNS + " = new Object();";
    }
    if (sEval != "") eval(sEval);
};

//有界面效果的alert
function myAlert(message){
	
	try{
		$.messager.defaults = { ok: "确定", cancel: "取消" };
		$.messager.alert("提示", "<center>" + message + "</center>");
	}catch(e){
		alert(message);
	}
}

//操作提示，用于保存等提示操作(当message为空的时候不弹出)
function msgAlert(message){
	if(message != ""){
		
		$.messager.defaults = { ok: "确定" };
		$.messager.alert("操作提示", "<center>" + message + "</center>");
	}
}

//easyui的confirm,message为提示内容,retFun为点确定的返回函数
function myConfirm(message, retFun){
	
	$.messager.defaults = { ok: "确定", cancel: "取消" };
	$.messager.confirm('确认框', message, function(ret){
		if (ret){
			
			if(typeof retFun == "function"){
				
				retFun();
			}
			
		}
	});
}

//删除确认框
function deletePojo(url, succFun, succFunArg){	
	myConfirm("确定删除?", function deleteData(){
		$.ajax({
			type:"get",
			url: url,
			dataType: "json",
			success: function(data){
				
				var type = data.type;
				if(type == "true"){
					
					executeFn(succFun, succFunArg);						
				}else{
					myAlert("操作失败,请重试");
				}
			},
			error: function(XMLHttpRequest, textStatus, errorThrown){
				myAlert("出现异常,请重试");
			}
		})	
	});		
}

/**
 * 删除确认框,校验id是否为空串
 * @param url
 * @param succFun
 * @param succFunArg
 * @param strIds
 * @returns {Boolean}
 */
function deletePojoBeforeCheck(url, succFun, succFunArg,strIds){	
	if (strIds != "") {		
		deletePojo(url, succFun, succFunArg);
	}
	else {
		myAlert("请选择删除项.");
		return false;
	}
}

//给一个table或其他组件增加刷新遮罩层,$('#table').moduleMask();
function moduleMask(moduleId){
	
	var module = $("#" + moduleId);
	var width = module.width();
	var height = module.height();
	//module.css("width", width);
	//module.css("height", height);
	//module.css("background-color","white");
	
	var mask = '<div id="maskDiv" style="display: block;" class="datagrid-mask"></div>'; // width: 578px; height: 31px;
	var msg = '<div id="msgDiv" style="display: block;" class="datagrid-mask-msg">' + myGlobal.loadIng + '</div>'; //left: 242.5px; top: -5.5px; 
	
	$("#" + moduleId).append(mask);
	$("#" + moduleId).append(msg);
	
	$("#maskDiv").width(width+10).height(height+10);
	$("#msgDiv").css("left", width/2).css("top", height/2);
	
}

//直接给一个组件增加遮罩层
function moduleMaskByModule(module){
	
	var width = module.width();
	var height = module.height();
	
	var mask = '<div id="maskDiv" style="display: block;" class="datagrid-mask"></div>'; // width: 578px; height: 31px;
	var msg = '<div id="msgDiv" style="display: block;" class="datagrid-mask-msg">' + myGlobal.loadIng + '</div>'; //left: 242.5px; top: -5.5px; 
	
	$(module).append(mask);
	$(module).append(msg);
	
	$("#maskDiv").width(width+10).height(height+10);
	$("#msgDiv").css("left", width/2).css("top", height/2);
	
}

//删除遮罩层
function moduleMaskRemove(){
	
	$("#maskDiv").remove();
	$("#msgDiv").remove();
}

//供dialog中的iframe调用的关闭dialog函数
function closeDialog(dialogId){
	
	$('#' + dialogId).dialog('close');
}

//setTimeout关闭弹出框
function closeDialogTimeout(dialogId, time){
	
	window.setTimeout(function(){$('#' + dialogId).dialog('close');}, time);
}

//setTimeout parent关闭弹出框
function closeParentDialogTimeout(dialogId, time){
	
	window.setTimeout(function(){parent.$('#' + dialogId).dialog('close');}, time);
}

//new dialog sugg
function dialogNewSugg(dialogButton, sugg){

	var buttonParent = $(dialogButton).parent();	
	buttonParent.find("#__dialogSugg__").remove();
	$(buttonParent).append("<span id='__dialogSugg__' style='color:#FF0000;position:absolute;left:20%;padding-top:5px'>" + sugg + "</span>");

}

//为了加载显示的流畅性,会先隐藏绑定为dialog的div,可是调用显示dialog时,应该把对应的div显示出来
function showDialogDiv(divId){
	$("#" + divId).children().children().show();
}

//iframe弹出框ajax表单提交
function dialogIframeAjaxSubmit(iframeId, ids, formId, dialogButton){
	var fixDivId = iframeId.replace("open","my").replace("frame","frameDialog")// openIframe变为"myIframeDialog"
		
	var getCheck = "";
	try{
		
		getCheck = myCheckForIframeAndId(iframeId, ids);
	}catch(e){
		//调用的时候传入不存在的验证id
		getCheck = myGlobal.checkFail;
	}

	if(getCheck != true){
		
		dialogButtonSugg(getCheck, dialogButton);
				
	}else{
		
		dialogButtonSugg(myGlobal.submitIng, dialogButton);
		parent.$(dialogButton).linkbutton({disabled:true}); //禁用"提交"按钮,避免重复提交
		
		var form = $.easyParentIframe(iframeId, formId);
		var action = $(form).attr("action");
		var method = $(form).attr("method");
		
		$.ajax({
			type: method,
			url: action,
			data: $(form).serialize(),
			dataType: "json",
			success: function(data){
				
				if(data == null){
					
					dialogButtonSugg(myGlobal.fail, dialogButton);
					parent.$(dialogButton).linkbutton({disabled:false}); //恢复"提交"按钮		
					
					return;
				}
				
				var retType = data.type;
				if(retType == "true"){
					//操作成功
					
					var title = data.title;
					if(title == null || title == undefined){
						title = myGlobal.succ;
					}
					
					dialogButtonSugg(title, dialogButton); //设置提示语
					
					dialogSuggAttr(data, dialogButton); //设置自定义的返回值到id为"__dialogSugg__"的span
					
					//parent.$(dialogButton).linkbutton({disabled:false}); //恢复"提交"按钮,==>不用恢复"提交"按钮
					setTimeout(function(){parent.$('#'+fixDivId).dialog('close');}, 1000); //关闭弹出框
				}else{
					//操作失败
					
					var title = data.title;
					if(title == null || title == undefined){
						title = myGlobal.fail;
					}
					
					dialogButtonSugg(title, dialogButton); //设置提示语
					
					dialogSuggAttr(data, dialogButton); //设置自定义的返回值到id为"__dialogSugg__"的span
					
					parent.$(dialogButton).linkbutton({disabled:false}); //恢复"提交"按钮					
					
				}
			},
			error: function(XMLHttpRequest, textStatus, errorThrown){
				
				dialogButtonSugg(myGlobal.ajaxInputError, dialogButton);
				parent.$(dialogButton).linkbutton({disabled:false}); //恢复"提交"按钮	
			}
			
		});
		
	}
	
}

//iframe弹出框ajax表单提交,自定义提示语
function dialogIframeAjaxSubmitByIdsSugg(iframeId, ids, idsSugg, formId, dialogButton){
	var fixDivId = iframeId.replace("open","my").replace("frame","frameDialog")// openIframe变为"myIframeDialog"
		
	var getCheck = "";
	try{
		
		getCheck = myCheckForIframeAndIdByIdsSugg(iframeId, ids, idsSugg);
	}catch(e){
		//调用的时候传入不存在的验证id
		getCheck = myGlobal.checkFail;
	}

	if(getCheck != true){
		
		dialogButtonSugg(getCheck, dialogButton);
				
	}else{
		
		dialogButtonSugg(myGlobal.submitIng, dialogButton);
		parent.$(dialogButton).linkbutton({disabled:true}); //禁用"提交"按钮,避免重复提交
		
		var form = $.easyParentIframe(iframeId, formId);
		var action = $(form).attr("action");
		var method = $(form).attr("method");
		
		$.ajax({
			type: method,
			url: action,
			data: $(form).serialize(),
			dataType: "json",
			success: function(data){
				
				if(data == null){
					
					dialogButtonSugg(myGlobal.fail, dialogButton);
					parent.$(dialogButton).linkbutton({disabled:false}); //恢复"提交"按钮		
					
					return;
				}
				
				var retType = data.type;
				if(retType == "true"){
					//操作成功
					
					var title = data.title;
					if(title == null || title == undefined){
						title = myGlobal.succ;
					}
					
					dialogButtonSugg(title, dialogButton); //设置提示语
					
					dialogSuggAttr(data, dialogButton); //设置自定义的返回值到id为"__dialogSugg__"的span
					
					//parent.$(dialogButton).linkbutton({disabled:false}); //恢复"提交"按钮,==>不用恢复"提交"按钮
					setTimeout(function(){parent.$('#'+fixDivId).dialog('close');}, 1000); //关闭弹出框
				}else{
					//操作失败
					
					var title = data.title;
					if(title == null || title == undefined){
						title = myGlobal.fail;
					}
					
					dialogButtonSugg(title, dialogButton); //设置提示语
					
					dialogSuggAttr(data, dialogButton); //设置自定义的返回值到id为"__dialogSugg__"的span
					
					parent.$(dialogButton).linkbutton({disabled:false}); //恢复"提交"按钮					
					
				}
			},
			error: function(XMLHttpRequest, textStatus, errorThrown){
				
				dialogButtonSugg(myGlobal.ajaxInputError, dialogButton);
				parent.$(dialogButton).linkbutton({disabled:false}); //恢复"提交"按钮	
			}
			
		});
		
	}
	
}

//当前页面的iframe弹出框的ajax提交
function dialogCurrentIframeAjaxSubmit(iframeDialogId, iframeId, ids, formId, dialogButton){

	var getCheck = "";
	try{
		
		getCheck = myCheckForIframeAndId(iframeId, ids);
	}catch(e){
		//调用的时候传入不存在的验证id
		getCheck = myGlobal.checkFail;
	}

	if(getCheck != true){
		
		dialogButtonSugg(getCheck, dialogButton);
				
	}else{
		
		dialogButtonSugg(myGlobal.submitIng, dialogButton);
		$(dialogButton).linkbutton({disabled:true}); //禁用"提交"按钮,避免重复提交		
		
		var form = $("#" + iframeId)[0].contentWindow.$("#" + formId);		
		var action = $(form).attr("action");
		var method = $(form).attr("method");
		
		$.ajax({
			type: method,
			url: action,
			data: $(form).serialize(),
			dataType: "json",
			success: function(data){
				
				if(data == null){
					
					dialogButtonSugg(myGlobal.fail, dialogButton);
					$(dialogButton).linkbutton({disabled:false}); //恢复"提交"按钮		
					
					return;
				}
				
				var retType = data.type;
				if(retType == "true"){
					//操作成功
					
					var title = data.title;
					if(title == null || title == undefined){
						title = myGlobal.succ;
					}
					
					dialogButtonSugg(title, dialogButton); //设置提示语
					
					dialogSuggAttr(data, dialogButton); //设置自定义的返回值到id为"__dialogSugg__"的span
					
					//parent.$(dialogButton).linkbutton({disabled:false}); //恢复"提交"按钮,==>不用恢复"提交"按钮
					setTimeout(function(){$('#' + iframeDialogId).dialog('close');}, 1000); //关闭弹出框
					
				}else{
					//操作失败
					
					var title = data.title;
					if(title == null || title == undefined){
						title = myGlobal.fail;
					}
					
					dialogButtonSugg(title, dialogButton); //设置提示语
					
					dialogSuggAttr(data, dialogButton); //设置自定义的返回值到id为"__dialogSugg__"的span
					
					$(dialogButton).linkbutton({disabled:false}); //恢复"提交"按钮					
					
				}
			},
			error: function(XMLHttpRequest, textStatus, errorThrown){
				
				dialogButtonSugg(myGlobal.ajaxInputError, dialogButton);
				$(dialogButton).linkbutton({disabled:false}); //恢复"提交"按钮	
			}
			
		});
		
	}
	
}

/*
旧的dialog,使用方法如MyAjaxIframeDialog,废弃
*/
function MyIframeDialog(options){	
	// 默认值
    var myDefaults = { 	
		resizable: true,
		modal:true, //模态窗口,表示不能操作弹出框以外的内容
		maximizable: true, //显示最大化按钮
		width:550,
		height:320,
		title:myGlobal.title, //弹出框title		
		submitFn:'', //表单提交前执行的函数,return false,那么表单不会提交
		submitFnArg:[], //表单提交前执行的函数的参数列表
		openFn:'', //打开函数
		openFnArg:[], //打开函数的参数列表
		closeFn:'', //关闭函数
		closeFnArg:[], //关闭函数参数列表,为具体的参数值或参数对象
		src:'#', //不应该为空
		formId:'', //iframe中表单id,有"提交"按钮的时候不应该为空,为''时就不执行表单提交
		ids:[], //提交表单要验证的字段及规则
		buttons:true //是否有"提交","关闭"按钮
    };
    var options = $.extend(myDefaults, options);
	
	var bt = [{
		text:'提交',
		iconCls:'icon-ok',
		handler:function(){
			
			executeFn(options.submitFn, options.submitFnArg);
			
			if(options.formId != ''){
				dialogIframeAjaxSubmit('openIframe', options.ids, options.formId, this);
			}	
		}
	},
	{
		text:'关闭',
		iconCls:'icon-cancel',
		handler:function(){
			parent.$('#myIframeDialog').dialog('close');
		}
	}];
	
	if(options.buttons == false){
		bt = [];
	}
		
	parent.$("#myIframeDialog").dialog({
		resizable: options.resizable,
		modal: options.modal, //模态窗口,表示不能操作弹出框以外的内容
		maximizable: options.maximizable, //显示最大化按钮
		width:options.width,
		height:options.height,
		onOpen:function(){
			
			executeFn(options.openFn, options.openFnArg);			
		},
		onClose:function(){
		
			parent.$('#openIframe').attr("src", "./saleunit_new/guangzhou/loading.jsp"); //清空内容
			
			executeFn(options.closeFn, options.closeFnArg);
		},
		buttons: bt
		
	});
		
	parent.$('#myIframeDialog').dialog('open');
	parent.$('#myIframeDialog').dialog('setTitle', options.title);

	parent.$('#openIframe')[0].src = options.src;
	
	return false;
	
}

/*
new MyAjaxIframeDialog({title:'新增楼盘合同', formId:'contractManagerFormId', src:'./saleunit_new_init/appoint/guangzhou/toAddContractManager.action'});	
*/
function MyAjaxIframeDialog(options){	
	return MyAjaxIframeDialogX(options,'myIframeDialog','openIframe');
	/*
	// 默认值
    var myDefaults = { 	
		resizable: true,
		modal:true, //模态窗口,表示不能操作弹出框以外的内容
		maximizable: true, //显示最大化按钮
		width:550,
		height:320,
		title:myGlobal.title, //弹出框title		
		submitText:'提交', //提交按钮的文字
		submitIcon:'icon-ok', //提交按钮的icon
		submitFn:'', //表单提交前执行的函数,return false,那么表单不会提交
		submitFnArg:[], //表单提交前执行的函数的参数列表
		openFn:'', //打开函数
		openFnArg:[], //打开函数的参数列表
		closeText:'关闭', //关闭按钮的文字
		closeIcon:'icon-cancel', //关闭按钮的icon
		closeFn:'', //关闭后执行的函数
		closeFnArg:[], //关闭后执行的函数的参数列表,为具体的参数值或参数对象
		beforeCloseFn:'', //关闭前执行的函数
		beforeCloseFnArg:[], //关闭前执行的函数的参数列表,为具体的参数值或参数对象
		src:'#', //不应该为空
		formId:'', //iframe中表单id,有"提交"按钮的时候不应该为空,为''时就不执行表单提交
		ids:[], //提交表单要验证的字段及规则
		buttons:true //是否有"提交","关闭"按钮
    };
    var options = $.extend(myDefaults, options);
	
	var bt = [{
		text:options.submitText,
		iconCls:options.submitIcon,
		handler:function(){
			
			executeFn(options.submitFn, options.submitFnArg);
			
			if(options.formId != ''){
				dialogIframeAjaxSubmit('openIframe', options.ids, options.formId, this);
			}			
		}
	},
	{
		text:options.closeText,
		iconCls:options.closeIcon,
		handler:function(){
			parent.$('#myIframeDialog').dialog('close');
		}
	}];
	
	if(options.buttons == false){
		bt = [];
	}
		
	parent.$("#myIframeDialog").dialog({
		resizable: options.resizable,
		modal: options.modal, //模态窗口,表示不能操作弹出框以外的内容
		maximizable: options.maximizable, //显示最大化按钮
		width:options.width,
		height:options.height,
		onOpen:function(){
			
			executeFn(options.openFn, options.openFnArg);			
		},
		onBeforeClose:function(){
			
			executeFn(options.beforeCloseFn, options.beforeCloseFnArg);	
		},
		onClose:function(){
		
			parent.$('#openIframe').attr("src", "./saleunit_new/guangzhou/loading.jsp"); //清空内容		
			
			executeFn(options.closeFn, options.closeFnArg);			
		},
		buttons: bt
		
	});
		
	parent.$('#myIframeDialog').dialog('open');
	parent.$('#myIframeDialog').dialog('setTitle', options.title);

	parent.$('#openIframe')[0].src = options.src;
	
	return false;
	*/
}


function MyAjaxIframeDialogX2(options){
	return MyAjaxIframeDialogX(options,'myIframeDialogX2','openIframeX2');
}
function MyAjaxIframeDialogX3(options){
	return MyAjaxIframeDialogX(options,'myIframeDialogX3','openIframeX3');
}
function MyAjaxIframeDialogX4(options){
	return MyAjaxIframeDialogX(options,'myIframeDialogX4','openIframeX4');
}


/**
* new MyAjaxIframeDialog({title:'新增楼盘合同', formId:'contractManagerFormId', src:'./saleunit_new_init/appoint/guangzhou/toAddContractManager.action'});	
*/
function MyAjaxIframeDialogX(options,divId,iframeId){	
	// 默认值
    var myDefaults = { 	
		resizable: true,
		modal:true, //模态窗口,表示不能操作弹出框以外的内容
		maximizable: true, //显示最大化按钮
		width:550,
		height:320,
		title:myGlobal.title, //弹出框title		
		submitText:'提交', //提交按钮的文字
		submitIcon:'icon-ok', //提交按钮的icon
		submitFn:'', //表单提交前执行的函数,return false,那么表单不会提交
		submitFnArg:[], //表单提交前执行的函数的参数列表
		openFn:'', //打开函数
		openFnArg:[], //打开函数的参数列表
		closeText:'关闭', //关闭按钮的文字
		closeIcon:'icon-cancel', //关闭按钮的icon
		closeAlwaysExceFn:true, //判断手工关闭弹出框是否执行关闭后的函数,默认总是执行,另外如果是返回type="true",自动关闭的话,该参数不起效,总是执行关闭后的函数
		closeFn:'', //关闭后执行的函数
		closeFnArg:[], //关闭后执行的函数的参数列表,为具体的参数值或参数对象
		beforeCloseFn:'', //关闭前执行的函数,获取提示框中的属性$.currentIframeSuggSpan(divId);
		beforeCloseFnArg:[], //关闭前执行的函数的参数列表,为具体的参数值或参数对象
		src:'#', //不应该为空
		formId:'', //iframe中表单id,有"提交"按钮的时候不应该为空,为''时就不执行表单提交
		ids:[], //提交表单要验证的字段及规则
		idsSugg:{}, //表单验证字段的自定义提示,json格式(2013.6.20增加)
		buttons:true //是否有"提交","关闭"按钮
    };
    var options = $.extend(myDefaults, options);
	
	var bt = [{
		text:options.submitText,
		iconCls:options.submitIcon,
		handler:function(){
			
			executeFn(options.submitFn, options.submitFnArg);
			
			if(options.formId != ''){
				//dialogIframeAjaxSubmit(iframeId, options.ids, options.formId, this); //没有使用自定义提示语
				dialogIframeAjaxSubmitByIdsSugg(iframeId, options.ids, options.idsSugg, options.formId, this); //使用自定义提示语
			}			
		}
	},
	{
		text:options.closeText,
		iconCls:options.closeIcon,
		handler:function(){
			parent.$('#'+divId).dialog('close');
		}
	}];
	
	if(options.buttons == false){
		bt = [];
	}
		
	parent.$('#'+divId).dialog({
		resizable: options.resizable,
		modal: options.modal, //模态窗口,表示不能操作弹出框以外的内容
		maximizable: options.maximizable, //显示最大化按钮
		width:options.width,
		height:options.height,
		onOpen:function(){
			
			try{
				//要加上这个异常的处理,否则会出问题
				parent.$('#'+divId).dialog("restore");
			}catch(e){}
			
			executeFn(options.openFn, options.openFnArg);	
			
			//增加双击header就最大化或还原的事件
			parent.$('#'+divId).dialog("header").unbind('dblclick').bind('dblclick', 
				function(){

					var maximized = parent.$('#'+divId).dialog("options").maximized; //是否为最大化状态
					if(maximized){
						parent.$('#'+divId).dialog("restore");
					}else{
						parent.$('#'+divId).dialog("maximize");	
					}					
					
				}
			);		
			
			//绑定esc按钮关闭弹出框(不行)
			/**
			parent.$('#'+divId).dialog("header").unbind('keydown').bind("keydown", function (e) { 
			
				if (e.keyCode == 13) {
					parent.$('#'+divId).dialog('close');
				}
			});
			*/
			
		},
		onBeforeClose:function(){
			
			var spanModule = $.currentIframeSuggSpan(divId); //获取提示框中的属性
			if(spanModule != undefined && spanModule.attr("type") == true){
				options.closeAlwaysExceFn = true;
			}
			
			executeFn(options.beforeCloseFn, options.beforeCloseFnArg);	
		},
		onClose:function(){
		
			parent.$('#'+iframeId).attr("src", "./saleunit_new/guangzhou/loading.jsp"); //清空内容		
			
			if(options.closeAlwaysExceFn == true){
				executeFn(options.closeFn, options.closeFnArg);			
			}
		},
		buttons: bt
		
	});
		
	parent.$('#'+divId).dialog('open');
	parent.$('#'+divId).dialog('setTitle', options.title);

	parent.$('#'+iframeId)[0].src = options.src;
	
	return false;
}

//执行函数
function executeFn(fn, fnArg){
	
	if(fn != "" && typeof fn == "function"){
		
		if(fnArg != undefined && fnArg.length > 0){
				
			var argLength = fnArg.length;			
			var arr = new Array([argLength]);
			$(fnArg).each(function(index){
				arr[index] = fnArg[index];
			});
			fn.apply(fn, arr);
		}else{
			
			fn();
		}		
	}	
}

//div弹出框ajax表单提交
function dialogDivAjaxSubmit(ids, formId, dialogButton){
	
	var _easy = $(parent.$('#__myDivDialog__').dialog("body").children()[0]).children()[0];

	var getCheck = "";
	try{
		
		getCheck = myCheckForDivAndId(_easy, ids);
	}catch(e){
		//调用的时候传入不存在的验证id
		getCheck = myGlobal.checkFail;
	}

	if(getCheck != true){
		
		dialogButtonSugg(getCheck, dialogButton);
				
	}else{
		
		dialogButtonSugg(myGlobal.submitIng, dialogButton);
		parent.$(dialogButton).linkbutton({disabled:true}); //禁用"提交"按钮,避免重复提交
		
		var form = $(_easy).find("#" + formId);
		var action = $(form).attr("action");
		var method = $(form).attr("method");
		
		$.ajax({
			type: method,
			url: action,
			data: $(form).serialize(),
			dataType: "json",
			success: function(data){
				
				if(data == null){
					
					dialogButtonSugg(myGlobal.fail, dialogButton);
					parent.$(dialogButton).linkbutton({disabled:false}); //恢复"提交"按钮		
					
					return;
				}
				
				var retType = data.type;
				if(retType == "true"){
					//操作成功
					
					var title = data.title;
					if(title == null || title == undefined){
						title = myGlobal.succ;
					}
					
					dialogButtonSugg(title, dialogButton); //设置提示语
					
					dialogSuggAttr(data, dialogButton); //设置自定义的返回值到id为"__dialogSugg__"的span
					//parent.$(dialogButton).linkbutton({disabled:false}); //恢复"提交"按钮,
					setTimeout(function(){parent.$('#__myDivDialog__').dialog('destroy');}, 1000); //关闭弹出框
					
				}else{
					//操作失败
					
					var title = data.title;
					if(title == null || title == undefined){
						title = myGlobal.fail;
					}
					
					dialogButtonSugg(title, dialogButton); //设置提示语
					
					dialogSuggAttr(data, dialogButton); //设置自定义的返回值到id为"__dialogSugg__"的span
					
					parent.$(dialogButton).linkbutton({disabled:false}); //恢复"提交"按钮					
					
				}
			},
			error: function(XMLHttpRequest, textStatus, errorThrown){
				
				dialogButtonSugg(myGlobal.ajaxInputError, dialogButton);
				parent.$(dialogButton).linkbutton({disabled:false}); //恢复"提交"按钮	
			}
			
		});
		
	}
	
}

/*
 * DEMO 
div 弹出框
new MyAjaxDivDialog({title:'新增楼盘合同', formId:'contractManagerFormId', src:'./saleunit_new_init/appoint/guangzhou/toAjaxAddContractManager.action'});
注意获取div里面元素用此办法：$.ed('#tartsetPartyb')	
*/
function MyAjaxDivDialog(options){
	
	//判断index页面是否包含对应的div,
	if(parent.$("#__myDivDialog__").length > 0){
		//如果存在,就先销毁
		try{parent.$('#__myDivDialog__').dialog('destroy');}catch(e){}
	}
	
	//增加div
	parent.$('<div id="__myDivDialog__" style="font-size:16px"></div>').appendTo("body");
	
	// 默认值
    var myDefaults = { 	
		resizable: true,
		modal:true, //模态窗口,表示不能操作弹出框以外的内容
		maximizable: true, //显示最大化按钮
		width:550,
		height:320,
		title:myGlobal.title, //弹出框title	
		submitText:'提交', //提交按钮的文字
		submitIcon:'icon-ok', //提交按钮的icon
		submitFn:'', //表单提交前执行的函数,return false,那么表单不会提交
		submitFnArg:[], //表单提交前执行的函数的参数列表
		openFn:'', //打开函数
		openFnArg:[], //打开函数的参数列表
		closeText:'关闭', //关闭按钮的文字
		closeIcon:'icon-cancel', //关闭按钮的icon		
		closeAlwaysExceFn:true, //判断手工关闭弹出框是否执行关闭后的函数,默认总是执行,另外如果是返回type="true",自动关闭的话,该参数不起效,总是执行关闭后的函数
		closeFn:'', //关闭后执行的函数
		closeFnArg:[], //关闭后执行的函数的参数列表,为具体的参数值或参数对象
		beforeCloseFn:'', //关闭前执行的函数,获取提示框中的属性$.currentIframeSuggSpan(divId);
		beforeCloseFnArg:[], //关闭前执行的函数的参数列表,为具体的参数值或参数对象
		type:'post', //ajax的type
		src:'#', //不应该为空
		formId:'', //iframe中表单id,有"提交"按钮的时候不应该为空,为''时就不执行表单提交
		ids:[], //提交表单要验证的字段及规则
		buttons:true //是否有"提交","关闭"按钮
    };
    var options = $.extend(myDefaults, options);
	
	var bt = [{
		text:options.submitText,
		iconCls:options.submitIcon,
		handler:function(){
			
			executeFn(options.submitFn, options.submitFnArg);	
			
			//var _easy = $(parent.$('#__myDivDialog__').dialog("body").children()[0]).children()[0];
			if(options.formId != ''){	
				dialogDivAjaxSubmit(options.ids, options.formId, this);
			}	
		}
	},
	{
		text:options.closeText,
		iconCls:options.closeIcon,
		handler:function(){
			//销毁弹出框
			//setTimeout(function(){parent.$('#__myDivDialog__').dialog('destroy')}, 1000);
			parent.$('#__myDivDialog__').dialog('destroy');
		}
	}];
	
	if(options.buttons == false){
		bt = [];
	}
	
	parent.$("#__myDivDialog__").html(myGlobal.loadIng);
	
	parent.$("#__myDivDialog__").dialog({
									
		resizable: options.resizable,
		modal: options.modal, //模态窗口,表示不能操作弹出框以外的内容
		maximizable: options.maximizable, //显示最大化按钮
		width:options.width,
		height:options.height,
		style:{"overflow":"hidden"},	
		onOpen:function(){
			
			executeFn(options.openFn, options.openFnArg);
		},
		onBeforeDestroy:function(){
			
			var spanModule = $.divSuggSpan(); //获取提示框中的属性
			if(spanModule != undefined && spanModule.attr("type") == true){
				options.closeAlwaysExceFn = true;
			}
			
			executeFn(options.beforeCloseFn, options.beforeCloseFnArg);			
		},
		onClose:function(){
			
			parent.$('#__myDivDialog__').dialog('destroy');
		},
		onDestroy:function(){
			//销毁后执行,相当于iframe中的关闭后
			
			if(options.closeAlwaysExceFn == true){
				executeFn(options.closeFn, options.closeFnArg);			
			}			
		},
		buttons: bt			
		
	});
		
	parent.$('#__myDivDialog__').dialog('setTitle', options.title);
	parent.$('#__myDivDialog__').dialog('open');
	
	$.ajax({
		type: options.type,
		url: options.src,
		dataType: "html",		
		success: function(data){
			
			//加载成功就解析对应的easyui组件
			var dialogBody = parent.$('#__myDivDialog__').dialog("body");		
			var uiModlue = $(dialogBody.children()[0]).children()[0];
			
			$(uiModlue).html(data);			
			parent.$.parser.parse(uiModlue);
		},
		error: function(XMLHttpRequest, textStatus, errorThrown){
			myAlert(myGlobal.ajaxError);
			parent.$('#__myDivDialog__').dialog('destroy');
		}
	});
	
}

//datagrid 有bug,暂不能使用
/**
function MyDataGrid(options){
	
	// 默认值
    var myDefaults = { 	
		id:"", //datagrid的id,不能为空
		addFn:"", //点增加按钮时要执行的函数
		addFnArg:[], //点增加按钮时要执行的函数的参数
		defRow:{}, //新增一行的默认值
		url:"" //初始化时要加载的url,返回的值会自动填充表格		
    };
    var options = $.extend(myDefaults, options);
	
	if(options.id == ""){
		myAlert("datagrid的id不能为空");
		return false;
	}
	
	$(function(){
			
		$('#' + options.id).datagrid({
			singleSelect:true,
			toolbar:[{
				text:'增加',
				iconCls:'icon-add',
				queryParams:{},
				handler:function(){
				
					if(options.addFn != "" && typeof options.addFn == "function"){
				
						var argLength = options.addFn.length;
						if(argLength > 0){
							
							var arr = new Array([argLength]);
							$(options.addFnArg).each(function(index){
								arr[index] = options.addFnArg[index];
							});
							options.addFn.apply(options.addFn, arr);
						}else{
							
							options.addFn();
						}
						
					}
					
					var rows = $('#' + options.id).datagrid('getRows'); //获取所有的行
					var rowsLength = rows.length; //总行数
					
					if(rowsLength > 0){
						
						for(var index=0; index<rowsLength; index++){
							
							$('#' + options.id).datagrid('endEdit', index); //取消对所有行的编辑							
						}
					}
					
					$('#' + options.id).datagrid('appendRow',options.defRow); //新增一行
					
					$('#' + options.id).datagrid('selectRow', rowsLength); //选中新增的行
					$('#' + options.id).datagrid('beginEdit', rowsLength); //编辑新增的行
				}
			},'-',{
				text:'删除',
				iconCls:'icon-remove',
				handler:function(){
					var row = $('#' + options.id).datagrid('getSelected'); //获取选择的行
					if (row){
						
						var index = $('#' + options.id).datagrid('getRowIndex', row); //获取选择的行的索引
						$('#' + options.id).datagrid('deleteRow', index); //删除选择的行			
						
						var rows = $('#' + options.id).datagrid('getRows'); //获取所有的行
						var rowsLength = rows.length; //总行数
						
						if(rowsLength > 0){
							
							for(var index=0; index<rowsLength; index++){
								
								$('#' + options.id).datagrid('endEdit', index); //取消对所有行的编辑							
							}
						}
						
					}else{
						
						myAlert("请选择要删除的行");
					}
				}
			}
			],
			loadMsg:"加载中...",
			url: options.url,
			
			onClickRow:function(rowIndex){
				
				var rows = $('#' + options.id).datagrid('getRows'); //获取所有的行
				var rowsLength = rows.length; //总行数
				
				if(rowsLength > 0){
					
					for(var index=0; index<rowsLength; index++){
						
						$('#' + options.id).datagrid('endEdit', index); //取消对所有行的编辑							
					}
				}
				
				$('#' + options.id).datagrid('beginEdit', rowIndex); //编辑选中的行
				
			}
			
		});
	});
}
*/

//自定义表单组件的验证(这样声明一个原因是为了不跟以前的冲突),调用如:$.isDate(value);
//封装获取parent div dialog下的组件方法,调用如:$.ed(selectType);
//ed:extend的缩写
(function($) {

	$.extend($, {
	//$.fn.extend({ //$().isDate(value);
			 
		//数字的正则判断,利用js本身的isNaN
		
		//金额的正则判断
		isMoney: function(money){
			if(money == "" || !/^\d*\.?\d*$/.test(money)){
				return false;
			}
			return true;
		},
		//电话的正则判断
		isPhone: function(phone){	
			if(phone == "" || !/^\d*$|^\d*-\d*$/.test(phone)){
				return false;
			}
			return true;
		},
		//邮箱的正则判断
		isMail:function(mail){	
			if(mail == "" || !/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/.test(mail)){
				return false;
			}
			return true;
		},
		//日期(只是判断是否为合法的日期格式yyyy-MM-dd,而没有进行相关的值的验证,如2012-02-30一样视为合法)
		isDate:function(date){			
			var d = Date.parse(date);	
			return !isNaN(d);
		},
		
		//获取div弹出框的组件
		ed:function(selectType){
			//return parent.$("#__myDivDialog__").find(selectType);
			return parent.$("#__myDivDialog__ " + selectType);
		},
		
		//获取div弹出框的提示框
		divSuggSpan:function(){
			return parent.$("#__myDivDialog__ #__dialogSugg__"); 
		},
		
		//获取iframe弹出框的提示框
		iframeSuggSpan:function(){
			return parent.$("#myIframeDialog #__dialogSugg__"); 
		},
		
		//获取当前页面弹出框的提示框
		currentIframeSuggSpan:function(iframeDialogId){
			return $("#" + iframeDialogId + " #__dialogSugg__");
		}
	});
	
})(jQuery);

//增加datagrid自适应屏幕的方法,要自己调用,如,$("#" + datagridId).resizeDataGrid();
//不知道为什么我们的项目这样调用不行,$(window).resize(function() {$("#table_id").resizeDataGrid();});
/**
(function($) {

	$.fn.extend({
		
		resizeDataGrid: function(){
			
			$(this).datagrid('resize', {
			   height : $(document.body).height(),
			   width : $(document.body).width()
			 });
		}	
	});
	
})(jQuery);
*/
	
//类easyui验证提示框,要指定对应的body,否则会出现位置不对的情况
function bindValidate(module, sugg, valiBody){
	
	if(module == null || module == undefined)
		return ;
	
	var tip = null;
	
	tip = $("<div class=\"validatebox-tip\"><span class=\"validatebox-tip-content\"></span><span class=\"validatebox-tip-pointer\"></span></div>")
		.appendTo(valiBody);
		
	tip.find(".validatebox-tip-content").html(sugg);		
	
	var isHidden = $(module).is(":hidden");
	var offset = $(module).offset();
	if(isHidden || offset == null){
		
		module = module.parent();		
		tip.css({display:"block",left:$(module).offset().left,top:$(module).offset().top});
	}else{
		
		tip.css({display:"block",left:$(module).offset().left+$(module).outerWidth(),top:$(module).offset().top});
	}
	
	$(module).bind('mouseover',function(){
		if(tip){
			tip.remove();
			tip = null;
		}
	});	
	
	setTimeout(function(){if(tip){tip.remove();tip = null;}}, 2000);
}

//把一个object对象转换成请求参数的形式,参数limit作为key的前面部分,主要用于后台数据的自动绑定
function objectToQuery(obj, limit){

	if(obj == null || obj == undefined)
		return "";
		
	if(limit == null || limit == undefined)
		limit = "";
	
	var valArray = new Array();
		
	for(var key in obj){
		valArray.push(limit + key + "=" + obj[key]);
	}
	
	return valArray.join("&");
}

//把一个select下拉框所有非空的值转成一个请求参数
function selectToQuery(selectId){
	var optionObj = $("#" + selectId + " option");
	if(optionObj == undefined){
		return "";
	}
	
	var retArr = new Array();
	$(optionObj).each(function(){
		
		var val = this.value;
		if(val != ""){
			retArr.push(val);
		}
	});
	
	return retArr.join(",");	
}

//加载绑定easyui日期控件focus及blur事件
$().ready(function() {
	
	bindModuleShowHidePanelByClass(["easyui-combobox"]);
	
});

//根据class绑定对应组件的showPanel及hidePanel
function bindModuleShowHidePanelByClass(classArr){
	
	var length = classArr.length;
	if(length <= 0){
		return;
	}
	
	$(classArr).each(function(index){
		_bindModuleShowHidePanelByClass(classArr[index]);
	});
	
}

function _bindModuleShowHidePanelByClass(_class){
	
	var _index = _class.lastIndexOf("-")
	var type = "__" + _class.substring(_index) + "__";
	
	$("." + _class).each(function(index){
		
		//使用id去绑定可以实现,但是如果没有id只是用class声明,就要手工生成一个id,然后再去绑定
		var id = $(this).attr("id");
		if(id == undefined){
			id = type + index;
			$(this).attr("id", id);
		}
		
		$($("#" + id).combo('textbox')).bind('focus', function(){$("#" + id).combo('showPanel');})
			.bind('blur', function(){
				//不用增加blur事件,使用默认的就可以,否则会出现不能快速选择月份的情况
				//var panel = $("#" + id).combo('panel');
				$("#" + id).combo('hidePanel');
			});
			
		//使用class去绑定,会有问题
		//$($(this).datebox('textbox')).bind('focus', function(){$(this).datebox('showPanel')}).bind('blur', function(){$(this).datebox('hidePanel')});
	});	
}

//根据class绑定对应组件的showPanel及hidePanel
function bindModuleShowHidePanelById(idArr){
	
	var length = idArr.length;
	if(length <= 0){
		return;
	}
	
	$(idArr).each(function(index){
		_bindModuleShowHidePanelById(idArr[index]);
	});
	
}

function _bindModuleShowHidePanelById(id){
	$($("#" + id).combo('textbox')).bind('focus', function(){$("#" + id).combo('showPanel')})
		.bind('blur', function(){$("#" + id).combo('hidePanel')});
}

//绑定easyui日期控件focus及blur事件
function showDatebox(){
	var elements = $.ed(".easyui-datebox");
	for(var i=0;i < elements.length;i++ ){
		var id = $ed(elements[i]).attr("id");
		var module = $("#" + id).datebox('textbox');
		$(module).bind('focus', {id:id}, bindDateboxShowEvent)
				 .bind('blur', {id:id} , bindDateboxHideEvent);	
		}
}	

function bindDateboxShowEvent(event){
	var id = event.data.id;
	$("#"+id).datebox('showPanel');		
}

function bindDateboxHideEvent(event){
	var id = event.data.id;
	$("#"+id).datebox('hidePanel');	
	
}


/**
 * 形成object对象,用于传递
 * inputNames:控件的name数组,例如：["cond.strSearchCompanyProjectIds","cond.date1","cond.date2"]
 * 返回object
 */
function getInputsAsOjbect(inputNames){
	var obj= {};
	
	for(var i = 0; i < inputNames.length; i++){
		var input = $("input[name='"+inputNames[i]+"']");
		
		if(input.length>0){
			if(input.attr("type")=="hidden" || input.attr("type")=="text"){
				//支持本身的hidden，以及datebox
				obj[inputNames[i]] = input.val();
			}
			else if(input.attr("type")=="checkbox"){
				if(input.attr("checked")=="checked"){
					obj[inputNames[i]] = "true";					
				}				
			}
		}
		else{
			input = $("select[name='"+inputNames[i]+"']");
			if(input.length>0){
				obj[inputNames[i]] = input.val();
			}
		}
	}				
	
	return obj;
}	

/**
 * 根据请求的参数,设置控件的值
 * @param inputNames
 */
function setInputsByRequest(inputNames){
	var obj= {};
	
	for(var i = 0; i < inputNames.length; i++){
		var input = $("input[name='"+inputNames[i]+"']");
		if(input!=null){
			if(input.attr("type")=="hidden"){
				//支持本身的hidden，以及datebox
				obj[inputNames[i]] = input.val();
			}
		}
	}				
	
	return obj;
}	

/**
 * 请求地址栏，返回一个对象
 * @returns {paraObj}，可以paraObj[pName]直接取值
 */
function requestParaToObject()
{ 
    var url = location.href; 
    var paraString = url.substring(url.indexOf("?")+1,url.length).split("&"); 
    var paraObj = {} ;
    for (i=0; j=paraString[i]; i++){
    	var pName = j.substring(0,j.indexOf("=")); 
    	var pValue = j.substring(j.indexOf("=")+1,j.length);
    	paraObj[pName] = pValue; 
    } 		
    
    return paraObj;        
}

//防止dialog组件超出浏览器边界,也可以用于panel/window
var easyuiPanelOnMove = function(left, top) {
	var l = left;
	var t = top;
	if (l < 1) {
		l = 1;
	}
	if (t < 1) {
		t = 1;
	}
	var width = parseInt($(this).parent().css('width')) + 14;
	var height = parseInt($(this).parent().css('height')) + 14;
	var right = l + width;
	var buttom = t + height;
	var browserWidth = $(window).width();
	var browserHeight = $(window).height();
	if (right > browserWidth) {
		l = browserWidth - width;
	}
	if (buttom > browserHeight) {
		t = browserHeight - height;
	}
	$(this).parent().css({/* 修正面板位置 */
		left : l,
		top : t
	});
};
$.fn.dialog.defaults.onMove = easyuiPanelOnMove;