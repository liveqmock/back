
//项目的选择下拉框function
function change_project(date){
	var rhref = $(date).attr('rhref')
	var locref = rhref+"?selectProId="+$(date).val();
	location.href=locref;
}

//提示框的显示与隐藏
function showSearch(href){
		
	var text = $(href).text();
	if(text == "显示"){
		$(href).text("隐藏");
		$("#__project__").val("");
		$("#__myProjectId__").hide();
		$("#__project__").parent().show();				
		
	}else{
		$(href).text("显示");
		$("#__myProjectId__").show();
		$("#__project__").parent().hide();
	}
	
}

$().ready(function(){
	
	//绑定智能提示框
	try{
		$("#__project__").autocomplete("./customer_guangzhou/search/leftProjects.action", {
			width: 150,  //提示框宽度
			selectFirst: true,
			selectFun:function(selectProId){
			
				location.href = "./saleunit_new/appoint/guangzhou/layout.action?selectProId=" + selectProId;
			},
			selectFunIsArg:true
		});	
		
		//绑定后做一些页面的处理
		$("#__project__").parent().hide();
	}catch(e){
	}
	
	//easyui的方式
	$("#__project__2").combobox({
		url:"./customer_guangzhou/search/leftProjectsEasyui.action",
		valueField:"id",
		textField:"value"
	});
	
	
});