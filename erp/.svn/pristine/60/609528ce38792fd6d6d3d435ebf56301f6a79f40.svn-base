<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<style type="text/css">
	.saleinfo td{padding:10px}
</style>
<script type="text/javascript">
	$("#unit_gift_dialog_click").click(function(){
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
					iconCls:'icon-cancel',
				handler:function(){
					$('#myIframeDialog').dialog('close');
				}}
			]
		});
		$('#myIframeDialog').dialog('open');
		$('#myIframeDialog').dialog('setTitle', '新建赠品'); 
		$('#openIframe')[0].src='./saleunit_new/appoint/guangzhou/unitGiftDialog.action?id=' + click_unit_id; 
		return false;
	});
</script>
<div style="float: left;">
<input id="unit_gift_dialog_click" type="button" class="btn1" value="  新增  " style=""/>
		<table  border="0" align="center" cellpadding="0" cellspacing="1" class="gbox unit_table" >
			<tr  bgcolor="#E9F5FF" style="line-height: 20px;"> 
				<th width="150" align="center">时间</th>
				<th width="150" align="center">价格</th>
				<th width="150" align="center">客户</th>
				<th width="150" align="center">操作员</th>
				<th align="center" width="300px">备注</th>
				<th align="center" width="100px"> </th>
			</tr>
			<s:iterator value="unitGiftList" var="c">
				<tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="line-height: 20px;"> 
				<td align="center">
					<s:date name="#request.c.createdTime" format="yyyy-MM-dd"/>
			</td>
				<td class="rmb_format">${c.price }</td>
				<td align="center">${c.customerIdStr }</td>
				<td align="center">${c.userIdStr }</td>
				<td colspan="2" align="left">${c.mark }</td>
				</tr>
			</s:iterator>
		</table>
</div>