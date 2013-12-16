<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>




<script type="text/javascript">
	$(document).ready(function(){

		$(".cr_tr").dblclick(function(){
				new_shou_and_up_dialog($(this).attr("cid"));
		});
	});
	
</script>
<style>
.conttrct_table td{padding:0 5px}

</style>
<table   border="0" align="center" cellpadding="0" cellspacing="1" style="background-color: #A9D9FF" class="conttrct_table">
			<tr  style="line-height: 20px;background:#E9F5FF" > 
				<th width="40px" align="center" ><input type="checkbox" id="check_ids"  value="ids"/> </th>
				<th width="100px" align="center" >合同编号</th>
				<th width="100px" align="center">签署日期</th>
				<th width="100px" align="center">客户姓名</th>
				<th width="100px" align="center">成交金额</th>
				<th width="100px" align="center">销售人员</th>
				<th width="100px" align="center">当前状态</th>
				<th width="100px" align="center">当前持有人</th>
				<th width="300px" align="center">备注</th>
			</tr>
			<s:iterator value="contRecTableList" var="c">
				<tr style="background: #ffffff;line-height: 24px" class="cr_tr" cid="${c.id }">
				<td align="center"><input type="checkbox" class="check_id" name="check_name" value="${c.id }"/></td>
				<td>${c.contractNo }</td><td>
				<s:date name="#request.c.contractDate" format="yyyy-MM-dd"/>
				</td>
				<td>${c.customerName }</td><td dir="rtl">${c.contractMoney }</td>
				<td>${c.salesName }</td><td>${c.state }</td>
				<td>${c.handoverUser }</td><td>${c.remark }</td>
			</tr>
			</s:iterator>
</table>

		
		
		
		
		
		
		
		
		
		
		
		
		
		
				
