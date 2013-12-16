<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="my" uri="/WEB-INF/my.tld" %> 
<%@ taglib prefix="pt" uri="/WEB-INF/projectText.tld" %> 

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<style>
.rmb_format{text-align: right}
.isVoid1{text-decoration:line-through}
.isVoid0{}
</style>

<script type="text/javascript" language="javascript">

	$("#payBillTableId tr").click(function(){
		var billId = $(this).attr("billId");
		
		if(billId == '0' || billId == undefined || billId == ""){
		
			return false;
		}else{
		
			$(".exChangetd").removeClass("exChangetd");				
			$(this).addClass("exChangetd");
		}
		
	});
	
</script>

		<table  border="0" align="center" cellpadding="0" cellspacing="1" class="gbox unit_table" width="100%" id="payBillTableId">
			
			<tr style="line-height: 20px;background:#E9F5FF; text-align:left" > 
				<td colspan="10" style="margin-left:15px">
				<s:if test="#request.isSale == true">
					<a href="javascript:void(0)" style="color:#1199FF; text-decoration:underline;padding: 0px 20px 0px" onclick="unitPayBillFormula(${unitId})">使用公式</a>
					<a href="javascript:void(0)" style="color:#1199FF; text-decoration:underline;padding: 0px 20px 0px" onclick="addUnitPayBill(${unitId})">添加应收款</a>
					<a href="javascript:void(0)" style="color:#1199FF; text-decoration:underline;padding: 0px 20px 0px" onclick="modifyUnitPayBill(${unitId})">修改应收款</a>
					<a href="javascript:void(0)" style="color:#1199FF; text-decoration:underline;padding: 0px 20px 0px" onclick="deleteUnitPayBill(${unitId})">删除应收款</a>
					<%--<a href="javascript:void(0)" style="color:#1199FF; text-decoration:underline;padding: 35px 20px 0px" onclick="modifyBillState('1')">作废应收款</a>
					<a href="javascript:void(0)" style="color:#1199FF; text-decoration:underline;padding: 35px 20px 0px" onclick="modifyBillState('0')">启用应收款</a> --%>
				</s:if>
				<s:else>
					<p style="color:red">未成交单元,没有付款信息</p>
				</s:else>	
				</td>
			</tr>
		
			<tr  style="line-height: 20px;background:#E9F5FF" > 
				<th width="100" align="center">收款类别</th>
				<th width="100" align="center">收款内容</th>
				<th width="100" align="center">应收日期</th>
				<th width="100" align="center">应收金额</th>
				<th width="100" align="center">已收金额</th>
				<th width="100" align="center">未收金额</th>
				<%--<th width="50" align="center">状态</th> --%>
				<%--<th width="100" align="center">房款比例</th>--%>
				<th width="100" align="center">操作</th>
				<th width="100" align="center">对佣日期</th>
			</tr>
			<tr  style="line-height: 20px;background:#ffffff" > 
				<td width="100" align="center">总计 </td>
				<td width="100" align="center"></td>
				<td width="100" align="center"></td>
				<td width="100" align="center" class="rmb_format"><my:format value="${allShouldPay}"/></td>
				<td width="100" align="center" class="rmb_format"><my:format value="${allHadPay}"/></td>
				<td width="100" align="center" class="rmb_format"><my:format value="${allNotPay}"/></td>
				<td width="100" align="center"></td>
				<td align="center"> </td>
			</tr>
			
			<s:iterator value="unitPayBillList" var="c"> 
				 <tr bgcolor="#FFFFFF" style="line-height: 20px;" billId="${c.id}" class="isVoid${c.isVoid}" 
				  title="双击进行查看" ondblclick="showUnitPayBill(${c.id})">  
					<td width="100" align="center" >${c.typeName} </td>
					<td width="100" align="center">${c.feeType}</td>
					<%--<td width="100" align="center">${c.seqNum}</td>--%>
					<td width="100" align="center"> 
						<s:date name="#request.c.payDate" format="yyyy-MM-dd"/>
					  </td>
					<td width="100" align="center" class="rmb_format"><my:format value="${c.shouldPay}"/></td>
					<td width="100" align="center" class="rmb_format"><my:format value="${c.hadPay}"/></td>
					<td width="100" align="center" class="rmb_format"><my:format value="${c.notPay}"/></td>
					<td width="100" align="center">
						<a href="javascript:void(0)" style="color:#1199FF; text-decoration:underline;padding: 0px 5px 0px" onclick="addReceiptByUnitIdAndBillId(${unitId}, ${c.id})">收款</a>
						<a href="javascript:void(0)" style="color:#1199FF; text-decoration:underline;padding: 0px 0px 0px" onclick="showReceiptListByBillId(${c.id})">收款明细</a>
					</td>
					<td align="center">
						<s:date name="#request.c.checkfee.checkfeeDate" format="yyyy-MM-dd"/>
					</td>
				</tr>
			</s:iterator>
			
		</table>
   
				
