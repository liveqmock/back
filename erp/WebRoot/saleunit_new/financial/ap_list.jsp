<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="my" uri="/WEB-INF/my.tld" %> 

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<style>
.rmb_format{text-align: right}
.isVoid1{text-decoration:line-through}
.isVoid0{}
.exChangetd{background-color:#EEAD0E}
</style>

<script type="text/javascript" language="javascript">
	
	$("#contractManagerTableId tr").bind('click', function(){
		var contractManagerId = $(this).attr("contractManagerId");
		
		if(contractManagerId == '0' || contractManagerId == undefined || contractManagerId == ""){
		
			return false;
		}else{
		
			$(".exChangetd").removeClass("exChangetd");				
			$(this).addClass("exChangetd");
		}
		
	});
	
</script>

		<table  border="0" align="center" cellpadding="0" cellspacing="1" class="gbox unit_table" width="100%" id="contractManagerTableId">
		
			<tr  style="line-height: 20px;background:#E9F5FF" > 
				<th width="150" align="center">房间号</th>
				
				<th width="100" align="center">金额</th>
				<th width="100" align="center">应收月份</th>
				<th width="100" align="center">收款日期</th>
				
				<th width="100" align="center">导入日期</th>				
				<th width="100" align="center">备注</th>
			</tr>
			
			
			<s:iterator value="apList" var="c">
				 <tr bgcolor="#FFFFFF" style="line-height: 20px;">  
				 
				 	<td width="150" align="center"> 
						${c.propertyUnit.unitNo}
					</td>
				 
					<td width="100" align="center" >${amount}</td>
					<td width="100" align="center" ><s:date name="#request.c.receiptdate" format="yyyy-MM-dd"/></td>
					<td width="100" align="center"><s:date name="#request.c.arDate" format="yyyy-MM-dd"/></td>
					<td width="100" align="center"><s:date name="#request.c.impdate" format="yyyy-MM-dd"/></td>
					<td width="100" align="center">${c.remark}</td>	
				
				</tr>
			</s:iterator>
			
		</table>
   