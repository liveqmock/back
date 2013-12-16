<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<style type="text/css">
	.saleinfo td{padding:10px}
</style>
<script type="text/javascript" language="javascript">
	$("#update_customer_for_confirm").click(function(){
		$("#myIframeDialog").dialog({
			resizable: true,
			modal:true, 
			maximizable: false, 
			width: 500,
			height:200	,
			onClose:function(){
			$('#myIframeDialog').attr("src", "./saleunit_new/guangzhou/loading.jsp"); //清空内容
			},
			buttons:[
				{text:'提交',
				iconCls:'icon-ok',
				handler:function(){
				window.document.getElementById("openIframe").contentWindow.tosubmit();
				}},
				{text:'关闭',
					iconCls:'icon-cancel',
					handler:function(){
						$('#myIframeDialog').dialog('close');
					}}
			]
		});
		$('#myIframeDialog').dialog('open');
		$('#myIframeDialog').dialog('setTitle', '变更客户'); 
		$('#openIframe')[0].src='./saleunit_new/appoint/guangzhou/updateContract.action?id='+click_unit_id; 
	
	})
</script>
<div style="float: left;">
		<table  border="0" align="center" cellpadding="0" cellspacing="1" class="gbox">
			<tr  bgcolor="#ffffff" style="line-height: 20px;"> 
			<td width="80px">客户姓名</td><td width="150px">${showCus.customerName}</td>
				<td width="80px">性别</td><td width="150px">${showCus.genderStr}</td>
			</tr>
			
			 <tr  bgcolor="#ffffff" style="line-height: 20px;"> 
			<td>证件类型</td><td> ${showCus.idcardTypeStr}</td>
				<td>证件号码</td><td> ${showCus.idcardNo}</td>
			</tr>
			<tr bgcolor="#ffffff" style="line-height: 20px;"> 
			<td>联系电话</td><td colspan="3"> ${showCus.phone} </td>
			</tr> 
			<tr bgcolor="#ffffff" style="line-height: 20px;"> 
			<td></td><td colspan="3"> 
			<s:if test="#request.isempty == 0">
				<input type="button" class="btn1" value="  修改用户  " id="update_customer_for_confirm"/>
			</s:if>
			 </td>
			</tr> 
		</table>
		</div>