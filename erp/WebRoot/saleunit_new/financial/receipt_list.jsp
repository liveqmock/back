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
	
	$("#receiptListTableId tr").bind('click', function(){
		var receiptId = $(this).attr("receiptId");
		
		if(receiptId == '0' || receiptId == undefined || receiptId == ""){
		
			return false;
		}else{
		
			$(".exChangetd").removeClass("exChangetd");				
			$(this).addClass("exChangetd");
		}
		
	});
	
</script>

		<table  border="0" align="center" cellpadding="0" cellspacing="1" class="gbox unit_table" width="100%" id="receiptListTableId">
		
			<tr style="line-height: 20px;background:#E9F5FF; text-align:left" > 
				<td colspan="11" style="margin-left:15px">
					<a href="javascript:void(0)" style="color:#1199FF; text-decoration:underline;padding: 0 20px 0 40px" onclick="checkReceiptBySaleunit()">查看</a>
					<a href="javascript:void(0)" style="color:#1199FF; text-decoration:underline;padding: 0 20px 0px" onclick="addReceiptBySaleunit(${unitId})">收款</a>
					<!--
					<a href="javascript:void(0)" style="color:#1199FF; text-decoration:underline;padding: 0 20px 0px" onclick="">收房款</a>
					<a href="javascript:void(0)" style="color:#1199FF; text-decoration:underline;padding: 0 20px 0px" onclick="">收税费</a>
					
					<a href="javascript:void(0)" style="color:#1199FF; text-decoration:underline;padding: 0 20px 0px" onclick="">作废</a>
					-->
					<!--
					<a href="javascript:void(0)" style="color:#1199FF; text-decoration:underline;padding: 0 20px 0px" onclick="">退款</a>
					-->
					<a href="javascript:void(0)" style="color:#1199FF; text-decoration:underline;padding: 0 20px 0px" onclick="updateReceiptBySaleunit()">修改</a>
					<a href="javascript:void(0)" style="color:#1199FF; text-decoration:underline;padding: 0 20px 0px" onclick="deleteReceiptBySaleunit()">删除</a>
				</td>
			</tr>
		
			<tr  style="line-height: 20px;background:#E9F5FF" > 
				<th width="100" align="center">缴款人</th>
				<th width="100" align="center">单据编号</th>
				<th width="100" align="center">单元编号</th>
				
				<th width="100" align="center">收款类别</th>
				<th width="100" align="center">收款内容</th>
				
				<th width="100" align="center">收款日期</th>
				
				<th width="100" align="center">收款金额</th>
				
				<th width="100" align="center">收款人</th>
			</tr>
			<tr  style="line-height: 20px;background:#ffffff" > 
				<td width="100" align="center">总计 </td>
				
				<td width="100" align="center"></td>
				<td width="100" align="center"></td>
				
				<td width="100" align="center"></td>
				<td width="100" align="center"></td>
				<td width="100" align="center"></td>
				
				<td width="100" class="rmb_format"><my:format value="${allReceiptMoney}"/></td>
				<td width="100" align="center"></td>
			</tr>
			
			<s:iterator value="receiptList" var="c">
				 <tr bgcolor="#FFFFFF" style="line-height: 20px;" receiptId="${c.id}">  
					<td width="100" align="center" >${c.payMan} </td>
					<td width="100" align="center">${c.billNo}</td>
					<td width="100" align="center">${c.unit.allName}</td>
					
					<td width="100" align="center">${c.typeName}</td>
					<td width="100" align="center">${c.feeType}</td>
					
					<td width="100" align="center"> 
						<s:date name="#request.c.receiptDate" format="yyyy-MM-dd"/>
					  </td>
					  
					<td width="100" class="rmb_format"><my:format value="${c.receiptMoney}"/></td>
					
					<td width="100" align="center">${c.inputMan}</td>
				</tr>
			</s:iterator>
			
		</table>
   
				
