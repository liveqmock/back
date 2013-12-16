<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<form action="./saleunit_financial_manager/guangzhou/saveUnitPayDelay.action" method="post" id="save_unit_pay_del_form">
<table style="width: 650x;" border="0" align="left" cellpadding="0" cellspacing="1" class="gbox"  id="invoice_table">

<tr style="line-height: 20px;"  bgcolor="#ffffff" >
	<td  colspan="4">
		<input id="save_pay_but"  style="color: black;background-color: #ffffff; "  value="保存" type="button" readonly="readonly"/>
	</td>
	
</tr>
<tr style="line-height: 20px;"  bgcolor="#FBEC88" >
	<td  colspan="4">
		  应收日期:<s:date name="#request.selectBill.payDate"/> 应收金额:${selectBill.shouldPay } 已收金额:${selectBill.hadPay } 未收金额:${selectBill.notPay }
	</td>
	
</tr>

<input class="unit_pay_del_input" type="hidden" name="saveUnitPayDelay.id" value="${saveUnitPayDelay.id}"/>
<tr style="line-height: 20px;"  bgcolor="#ffffff" >
	<td width="100px" align="right">
		减免金额
	</td>
	<td width="100px">
		<input class="unit_pay_del_input" name="saveUnitPayDelay.delayMoney" value="${saveUnitPayDelay.delayMoney}"/>
	</td>
	<td width="100px" align="right">
		延期天数
	</td>
	<td>
		<input class="unit_pay_del_input" style="width: 50px" name="saveUnitPayDelay.delayDay" value="${saveUnitPayDelay.delayDay}"/> <input name="saveUnitPayDelay.is_free" type="checkbox" style="vertical-align: bottom"/><sub>免滞纳金</sub>
	</td>
</tr>
<tr style="line-height: 20px;"  bgcolor="#ffffff" >
	<td width="100px" align="right">
		申请日期
	</td>
	<td width="100px">
	
		<input class="unit_pay_del_input" name="saveUnitPayDelay.applyDate" value="<s:date name="#request.saveUnitPayDelay.applyDate" format="yyyy-MM-dd"/>"/>
	</td>
	<td width="100px" align="right">
		批准日期
	</td>
	<td>
		<input class="unit_pay_del_input" name="saveUnitPayDelay.approvalDate" value="<s:date name="#request.saveUnitPayDelay.approvalDate" format="yyyy-MM-dd"/>"/>
	</td>
</tr>
<tr style="line-height: 20px;"  bgcolor="#ffffff" >
	<td width="100px" align="right">
		批准人
	</td>
	<td width="100px">
		<input class="unit_pay_del_input" name="saveUnitPayDelay.approvalMan" value="${saveUnitPayDelay.approvalMan}"/>
	</td>
	<td width="100px" align="right">
		经办人
	</td>
	<td>
		<input class="unit_pay_del_input" name="saveUnitPayDelay.inputMan" value="${saveUnitPayDelay.inputMan}"/>
	</td>
</tr>
<tr style="line-height: 20px;"  bgcolor="#ffffff" >
	<td width="100px" valign="top" align="right">
		备注
	</td>
	<td  colspan="3">
		<textarea class="unit_pay_del_input" rows="" cols="" style="width: 95%;height: 200px" name="saveUnitPayDelay.remark">${saveUnitPayDelay.remark}</textarea>
	</td>
</tr>

</table>
</form>
<script type="text/javascript">
function submitUnitPayDeForm() {
	$.post('./saleunit_financial_manager/guangzhou/saveUnitPayDelay.action',
			$("#save_unit_pay_del_form").serialize(), function(date) {
				$("#_unit_pay_de_tab").html(date);
			}, 'html');
}

$("#save_pay_but").click(function(){
	submitUnitPayDeForm();
})
</script>
