<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<table style="width: 100%;" border="0" align="left" cellpadding="0" cellspacing="1" class="gbox"  id="invoice_table">
<tr style="line-height: 20px;background: #ffffff"  >
	<th colspan="4" align="left">
		<input id="but_add_invoice"  style="color: black;background-color: #ffffff; "  value="添加发票" type="button" readonly="readonly"/>
		<input id="but_update_invoice"  style="color: black;background-color: #ffffff; "  value="修改发票" type="button" readonly="readonly"/>
		<input id="but_dis_invoice"  style="color: black;background-color: #ffffff; "  value="废弃发票" type="button" readonly="readonly"/>
		<input id="but_del_invoice"  style="color: black;background-color: #ffffff; "  value="删除发票" type="button" readonly="readonly"/>
	</th>
</tr>
<tr style="line-height: 20px;"  bgcolor="#eeeeee" >
	<td width="150px">
		发票号码
	</td>
	<td width="150px">
		金额
	</td>
	<td width="150px">
		日期
	</td>
	<td>
		备注
	</td>
</tr>
<s:iterator value="listInvoice" var="c">
	<s:if test="#request.c.isVoid == 1">
		<tr invoId="${c.id}" class="invoice_tr" style="line-height: 20px;"  bgcolor="#FFFFFF" >
	<td>
		<S>${c.invoiceNo}</S>
	</td>
	<td>
		<S>${c.invoiceMoney}</S>
	</td>
	<td>
		<S><s:date  name="#request.c.invoeceDate" format="yyyy-MM-dd"/></S>   
	</td>
	<td>
		<S>${c.remark}</S>
	</td>
</tr>
	</s:if>
	<s:else>
		<tr invoId="${c.id}" class="invoice_tr" style="line-height: 20px;"  bgcolor="#FFFFFF" >
	<td>
		${c.invoiceNo}
	</td>
	<td>
		${c.invoiceMoney}
	</td>
	<td>
		<s:date  name="#request.c.invoeceDate" format="yyyy-MM-dd"/>   
	</td>
	<td>
		${c.remark}
	</td>
</tr>
	</s:else>

</s:iterator>
</table>
<script type="text/javascript">
var select_invoice = '0';
$(".invoice_tr").click(function(){
	$(".invoice_tr").attr('bgcolor','#FFFFFF');
	$(this).attr('bgcolor','#FBEC88');
	select_invoice = $(this).attr('invoId')
})

$(".invoice_tr").dblclick(function(){
	select_invoice = $(this).attr('invoId');
	updateInvoice(select_invoice);
})

function updateInvoice(hhhid){
		$("#myIframeDialog").dialog({
			resizable: true,
			modal:true, 
			maximizable: false, 
			width:600,
			height:300,
			onClose:function(){
			},
			buttons:[ {
				text:'提交',
				iconCls:'icon-ok',
				handler:function(){
				window.document.getElementById("openIframe").contentWindow.formsubmit();
				}},
				{text:'关闭',
				iconCls:'icon-no',
				handler:function(){
					$('#myIframeDialog').dialog('close');
				}}
			]
		});
		$('#myIframeDialog').dialog('open');
		$('#myIframeDialog').dialog('setTitle', '修改发票'); 
		$('#openIframe')[0].src='./saleunit_financial_manager/guangzhou/invoiceUpdateDialog.action?invoiceId='+hhhid; 
}

function delInvoice(hhhid){
	$.post('./saleunit_financial_manager/guangzhou/invoiceDel.action',{invoiceId:hhhid});
}

function disInvoice(hhhid){
	$.post('./saleunit_financial_manager/guangzhou/invoiceDis.action',{invoiceId:hhhid});
}

$("#but_update_invoice").unbind("click"); 
$("#but_update_invoice").click(function(){
	 updateInvoice(select_invoice);
})

$("#but_del_invoice").unbind("click"); 
$("#but_del_invoice").click(function(){
	delInvoice(select_invoice);
})

$("#but_dis_invoice").unbind("click"); 
$("#but_dis_invoice").click(function(){
	disInvoice(select_invoice);
})

$("#but_add_invoice").unbind("click"); 
$("#but_add_invoice").click(function(){//弹出新建发票
	$("#myIframeDialog").dialog({
		resizable: true,
		modal:true, 
		maximizable: false, 
		width:700,
		height:380,
		onClose:function(){
		},
		buttons:[ {
			text:'提交',
			iconCls:'icon-ok',
			handler:function(){
			window.document.getElementById("openIframe").contentWindow.formsubmit();
			}},
			{text:'关闭',
			iconCls:'icon-no',
			handler:function(){
				$('#myIframeDialog').dialog('close');
			}}
		]
	});
	$('#myIframeDialog').dialog('open');
	$('#myIframeDialog').dialog('setTitle', '发票'); 
	$('#openIframe')[0].src='./saleunit_financial_manager/guangzhou/invoiceAddDialog.action?id='+$("#hiddenUnitId").val(); 
});	
</script>
