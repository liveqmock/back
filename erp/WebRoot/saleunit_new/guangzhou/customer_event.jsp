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
		$("#add_cus_com_dialog").click(function(){
			$("#myIframeDialog").dialog({
				resizable: true,
				modal:true, 
				maximizable: false, 
				width:500,
				height:400,
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
			$('#myIframeDialog').dialog('setTitle', '新建客户服务事件'); 
			$('#openIframe')[0].src='./saleunit_new/appoint/guangzhou/customerEventDialog.action?unit_id=' + click_unit_id; 
			return false;
		})
		
		//导出客户服务事件
		function exportCustomerEvent(){
			window.open('./saleunit_new/appoint/guangzhou/customerEventExport.action?unit_id=' + click_unit_id); 				
		}
</script>
<div style="float: left;width: 1000px;" >
<input id="add_cus_com_dialog" type="button" class="btn1" value="  新增  " />
<input id="export_customer_event" type="button" class="btn1" onclick="javascript:exportCustomerEvent();return false;" value="  导出  " />
		<table width="100%"  border="0" align="center" cellpadding="0" cellspacing="1" style="background-color: #A9D9FF" >
			<tr  bgcolor="#E9F5FF" style="line-height: 20px;"> 
				<th width="100px" align="center">客户</th>
				<th width="300px" align="center">客户要求</th>
				<th width="80px"  align="center">销售人员</th>
				<th width="80px"  align="center">接待时间</th>
				<th width="300px"  align="center">解决办法</th>
				<th width="80px"  align="center">解决时间</th>
				<th  align="center">备注</th>
			</tr>
			<s:iterator value="customerEventList" var="c">
				<tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="line-height: 20px;"> 
				<td align="center">${c.customer.customerName }</td>
				<td align="center">${c.customerOpinion }</td>
				<td align="center">${c.salesName }</td>
				<td align="center"><s:date name="#request.c.startTime" format="yyyy-MM-dd"/></td>
				<td align="center">${c.finishWay }</td>
				<td align="center"><s:date name="#request.c.finishTime" format="yyyy-MM-dd"/></td>
				<td align="center">${c.remark }</td>
					
				</tr>
			</s:iterator>
		</table>
   
				
		</div>