/**
 *
 *  easyui tab 一些帮助方法
 *
 */
 
//tabId为tab id,node为要新增的node
function addTab(tabId, node){
		
	var content = "";

	var title = node.text;
	var attr = node.attributes;
	
	var href = attr.url; //
	var iframe = attr.iframe; //如果iframe不为no且存在href,就用iframe来装载
	
	var isUseIframe = true; //是否使用iframe
	
	//默认是用iframe来装载,如果attr.iframe的值为no就不用
	if(href != undefined && href != ""){
		
		if(iframe == "no"){
			isUseIframe = false;
		}else{
			content = '<iframe scrolling="auto" frameborder="0"  src="' + href + '" style="width:100%;height:100%;"></iframe>';
			isUseIframe = true;
		}
		
	}else{
		//没有设置href
		var getContent = attr.content;
		if(getContent != undefined && getContent != ""){
			content = getContent;
		}
		isUseIframe = false;
		
	}			

	//先判断该tab是否存在
	var isExists = $('#' + tabId).tabs('exists', title);
	if(isExists){
		
		$('#' + tabId).tabs('select', title); //选择该tab
		var getTab = $('#' + tabId).tabs('getTab', title);
		//getTab.panel('refresh');
		//refreshTab(getTab);
					
	}else{
		
		if(href != undefined && href != ""){
			if(isUseIframe){
				
				$('#' + tabId).tabs('add',{
					title: title,
					//href: attr.url, //点击跳转的url
					content: content, //点击后显示的内容,(如果有href,那么这个就不起作用)
					closable:true,
					tools:[{
						iconCls:'icon-mini-refresh',
						handler:function(){
							var getTab = $('#' + tabId).tabs('getTab', title);
							refreshTab(getTab);							
						}
					}]
				});
				
			}else{
				
				$('#' + tabId).tabs('add',{
					title: title,
					href: attr.url, //点击跳转的url
					//content: content, //点击后显示的内容,(如果有href,那么这个就不起作用)
					closable:true,
					tools:[{
						iconCls:'icon-mini-refresh',
						handler:function(){
							var getTab = $('#' + tabId).tabs('getTab', title);
							refreshTab(getTab);							
						}
					}]
				});
				
			}
		}else{
			
			$('#' + tabId).tabs('add',{
				title: title,
				//href: attr.url, //点击跳转的url
				content: content, //点击后显示的内容,(如果有href,那么这个就不起作用)
				closable:true,
				tools:[{
					iconCls:'icon-mini-refresh',
					handler:function(){
						var getTab = $('#' + tabId).tabs('getTab', title);
						refreshTab(getTab);							
					}
				}]
			});
		}
	
	}		
	
}

function refreshTab(tab){
	//判断是否有iframe
	var iframe = $(tab).find('iframe')[0];
	if(iframe != undefined){
		
		iframe.src = iframe.src;
	}else{
		tab.panel('refresh');
	}
	
}

