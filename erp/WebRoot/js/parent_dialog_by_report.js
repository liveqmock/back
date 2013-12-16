//弹出外面公用IFRAM
	function showCustomerList(groupValue1,groupValue2){
		parent.$("#myIframeDialog").dialog({
		resizable: true,
		modal:true, //模态窗口,表示不能操作弹出框以外的内容
		maximizable: true, //显示最大化按钮
		width:800,
		height:500,
		onClose:function(){
		//refreshFn();
		//gotoRefreshFn("openIframe", "reHiddenId", "isReload");
		parent.$('#openIframe').attr("src", "./saleunit_new/guangzhou/loading.jsp"); //清空内容
		},
		buttons:[
		{
		text:'关闭',
		iconCls:'icon-cancel',
		handler:function(){
		parent.$('#myIframeDialog').dialog('close');
		}
		}]
		});
		parent.$('#myIframeDialog').dialog('open');
		parent.$('#myIframeDialog').dialog('setTitle', '客户明细');
		parent.$('#openIframe')[0].src='./saleunit_new_report/report/guangzhou/showCustomerList.action?groupValue1='+groupValue1+'&groupValue2='+groupValue2 ;
		return false;
} 