/**
  *
  * 财务管理底下tabs
  */
  
var click_unit_id = ""; //兼容"销控中心"的页面,等调整过来,该字段可以去掉

//根据传进来的选中的tab title,进行action请求
function selectTabsToAction(selectTabs, selectUnitId){
	
	if(selectUnitId != undefined && selectUnitId != "" && selectUnitId != "0"){
		
		var _tab = $(selectTabs);		
		var href = _tab.attr("toHref");
		if(href != undefined && href != ""){
			
			click_unit_id = selectUnitId;
			href = href + selectUnitId;
			
			//_tab.load(href); //不使用load的方法,是为了显示"加载中..."
			$.ajax({
				type:"get",
				url: href,
				dataType: "html",
				beforeSend: function(){
					moduleMask(selectTabs.panel('options').id);
				},
				success: function(data){
					
					_tab.html(data);
				}		
			});		
			
		}
		
		//var options = selectTabs.panel('options');
		
	}
	
}

//选择单元,加载选中的tab
function reloadSelectTabs(){
	
	var selectTabs = $("#financial_tabs").tabs("getSelected");
	var selectUnitId = $("#hiddenUnitId").attr("value");
	
	selectTabsToAction(selectTabs, selectUnitId);
	
}


