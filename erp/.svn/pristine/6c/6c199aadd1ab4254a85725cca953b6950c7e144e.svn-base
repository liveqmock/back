/**
 *  选择销售的弹出框
 */

//管理销售,selectType为对应获取项目id的session key,参照PropertyTreeUtils.java的getLeftTreeProjectIdSession()
function modifySale(salesTextId, salesTextName, selectType){
	
	//先判断是否存在id为mySaleIframeDialog的div,如果不存在就先新建,才能生成对应的弹出框
	if($("#mySaleIframeDialog").length <= 0){
		//表示该div不存在,增加		
		var saleDiv = '<div id="mySaleIframeDialog"><iframe scrolling="auto" frameborder="0" style="width:100%;height:100%;" ' + 
			'id="openSaleIframe" src="./saleunit_new/guangzhou/loading.jsp"></iframe></div>';
			
		$(saleDiv).appendTo("body");		
	}
	
	var salesId = $("#" + salesTextId).val(); //之前保存的id值	
	var salesName = $("#" + salesTextName).val();
	
	$("#mySaleIframeDialog").dialog({
		resizable: true,
		modal:true, //模态窗口,表示不能操作弹出框以外的内容
		maximizable: true, //显示最大化按钮
		width:420,
		height:400,
		onClose:function(){

			$('#openSaleIframe').attr("src", "./saleunit_new/guangzhou/loading.jsp"); //清空内容
		},
		buttons:[				 
		{
			text:'提交',
			iconCls:'icon-ok',
			handler:function(){
				
				var idArray = new Array(); //应该把之前的值保存进去,
				var nameArray = new Array();
				
				var contentWindow = $("#openSaleIframe")[0].contentWindow;
				
				var companyId = contentWindow.$("#commpanySaleId").val();
				if(companyId != ""){
					idArray.push(companyId);
					nameArray.push(contentWindow.$("#companySaleName").val());
				}
				
				var projectIds = contentWindow.$("input[name=sale]");
				$(projectIds).each(function(){

					if($(this).attr("checked") == "checked"){
						
						var getId = $(this).attr("value");
						if(!isArrayInclude(idArray, getId)){
							idArray.push(getId);
							nameArray.push($(this).attr("label"));
						}						
					}
				});
				
				var ids = idArray.join(",");
				var names = nameArray.join(",");
				
				$("#" + salesTextName).val(names);
				$("#" + salesTextId).val(ids);

				$('#mySaleIframeDialog').dialog('close');
								
			}
		},
		{
			text:'关闭',
			iconCls:'icon-cancel',
			handler:function(){
				$('#mySaleIframeDialog').dialog('close');
			}
		}]
	});
		
	$('#mySaleIframeDialog').dialog('open');
	$('#mySaleIframeDialog').dialog('setTitle', '选择销售');

	$('#openSaleIframe')[0].src = './saleunit_new/appoint/guangzhou/modifySale.action?salesId=' + salesId + "&salesName=" + salesName + "&selectType=" + selectType;
	
	return false;
}

