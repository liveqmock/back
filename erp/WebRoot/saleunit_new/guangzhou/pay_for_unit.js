
function createPayUnitDialog(payId,unitId){	
	if(unitId == "" || unitId == "0" || unitId == undefined){
		return false;
	}
	$("#myIframeDialog").dialog({
		resizable: true,
		modal:true, 
		maximizable: false, 
		width:500,
		height:300,
		onClose:function(){
		$('#openIframe').attr("src", "./saleunit_new/guangzhou/loading.jsp"); //清空内容
		},
		buttons:[ {
			text:'保存',
			iconCls:'icon-ok',
			handler:function(){
			window.document.getElementById("openIframe").contentWindow.formsubmit();
			}},
			{text:'关闭',
			handler:function(){
				$('#myIframeDialog').dialog('close');
				doUnitPayInfo_flush();
			}}
		]
	});
	$('#myIframeDialog').dialog('open');
	$('#myIframeDialog').dialog('setTitle', '付款'); 
	$('#openIframe')[0].src='./saleunit_new/appoint/guangzhou/payForUnit.action?payId=' + payId; 
	return false;
}