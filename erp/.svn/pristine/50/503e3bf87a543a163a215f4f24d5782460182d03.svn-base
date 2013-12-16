/**
 *付款方式的折扣
 */
 
//新建付款方式折扣
function createPayWayDiscount(payWayId, payWayName){	

	if(payWayId == "" || payWayId == "0" || payWayId == undefined){
		
		return false;
	}

	parent.$("#myIframeDialog").dialog({
		resizable: true,
		modal:true, //模态窗口,表示不能操作弹出框以外的内容
		maximizable: true, //显示最大化按钮
		width:600,
		height:400,
		onClose:function(){
		
			parent.$('#openIframe').attr("src", "./saleunit_new/guangzhou/loading.jsp"); //清空内容
		},
		buttons:[{
			text:'提交',
			iconCls:'icon-ok',
			handler:function(){
				
				parent.$("#openIframe")[0].contentWindow.formSubmit();
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
		
	parent.$('#myIframeDialog').dialog('open');
	parent.$('#myIframeDialog').dialog('setTitle', '付款方式折扣(' + payWayName + ")");

	parent.$('#openIframe')[0].src='./saleunit_setup/payway/forDiscountModify.action?payWayId=' + payWayId;
	
	return false;
}

//新建付款方式_项目折扣
function createPayWayProjectDiscount(payWayId, payWayName){	

	if(payWayId == "" || payWayId == "0" || payWayId == undefined){
		
		return false;
	}

	parent.$("#myIframeDialog").dialog({
		resizable: true,
		modal:true, //模态窗口,表示不能操作弹出框以外的内容
		maximizable: true, //显示最大化按钮
		width:600,
		height:400,
		onClose:function(){
		
			parent.$('#openIframe').attr("src", "./saleunit_new/guangzhou/loading.jsp"); //清空内容
		},
		buttons:[{
			text:'提交',
			iconCls:'icon-ok',
			handler:function(){
				
				parent.$("#openIframe")[0].contentWindow.formSubmit();
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
		
	parent.$('#myIframeDialog').dialog('open');
	parent.$('#myIframeDialog').dialog('setTitle',  $('#project_manager_name').text() + "(" + payWayName + ")");

	parent.$('#openIframe')[0].src='./saleunit_setup/payway/forProjectDiscountModify.action?payWayId=' + payWayId;
	
	return false;
}
