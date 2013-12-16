<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<script type="text/javascript">
function submitUnitDeForm() {
	var unidDeRes = "";
	$(".unitDe_input").each(function() {
		var resname = $(this).attr('name').toString();
		var resval = $(this).val();
		if (resval.length == 0) {
			resval = "";
		}
		unidDeRes = unidDeRes + "\'" + resname + "\'" + ":" + "\'"
				+ resval + "\'" + ",";
	});
	var a = unidDeRes.length - 1;
	unidDeRes = unidDeRes.substring(0, a);

	$.post('./saleunit_new/appoint/guangzhou/propertyUnitDefineTabForm.action',
			$("#my_defind_form").serialize(), function(date) {
				$("#_property_unit_define_info").html(date);
				refreshFn();
			}, 'html');
}
	${script}

	 $(document).ready(function(){

		 $('.Wdate').date_input();
		
	 });
</script>
<form id="my_defind_form">
<table  border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" width="100%">
	<tr  style="line-height: 20px;background:#E9F5FF;font-weight: bold;" > 
				<td colspan="8" >销售状态</td>
			</tr>
			<tr  style="line-height: 20px;background:#ffffff" > 
			
				<td>认筹日期</td><td><input class="Wdate"  style="width:90px" value='<s:date name="#request.unitDe.raiseDate" format="yyyy-MM-dd"/>' name="unitDe.raiseDate" />
				<input name="unitId" value="${unitId}" type="hidden">
				<input name="unitDefId" value="${unitDe.id}" type="hidden">
				 </td>
				<td>认筹编号</td><td><input value="${unitDe.raiseNo}" name="unitDe.raiseNo" class="unitDe_input"/> </td>
				<td>认购经办人</td><td><input value="${unitDe.confirmMan}" name="unitDe.confirmMan" class="unitDe_input"/> </td>
				<td>签约经办人</td><td><input value="${unitDe.signedMan}" name="unitDe.signedMan" class="unitDe_input"/> </td>
			</tr>
			<tr  style="line-height: 20px;background:#E9F5FF;font-weight: bold;" > 
				<td colspan="8" >佣金</td>
			</tr>
			<tr  style="line-height: 20px;background:#ffffff" > 
				<td>对数日期</td><td><input value="<s:date name="#request.unitDe.checkDate" format="yyyy-MM-dd"/>" name="unitDe.checkDate" class="Wdate"  style="width:90px"/>
					<input type="button" value="对数表" onclick="location.href='./saleunit_new/appoint/guangzhou/financialManagerLayout.action'"/>
				 </td>
				<td>结佣日期</td><td><input value="<s:date name="#request.unitDe.commissionDate" format="yyyy-MM-dd"/>" name="unitDe.commissionDate" class="Wdate"  style="width:90px"/> </td>
				<td>已结佣回款</td><td><input value="${unitDe.commissionMoney}" name="unitDe.commissionMoney" class="unitDe_input"/> </td>
				
				<td>不结佣日期</td><td><input value="<s:date name="#request.unitDe.notCommissionDate" format="yyyy-MM-dd"/>" name="unitDe.notCommissionDate" class="Wdate"  style="width:90px"/> </td>
			</tr>
			<tr  style="line-height: 20px;background:#ffffff" > 
				<td>签约日期</td><td><input value="<s:date name="#request.unitDe.commissionDate" format="yyyy-MM-dd"/>" name="unitDe.commissionDate" class="Wdate"  style="width:90px"/> </td>
				<td>结佣说明</td><td colspan="6"><input style="width: 90%" value="${unitDe.commissionRemark}"/> </td>
			</tr>
			<tr  style="line-height: 20px;background:#E9F5FF;font-weight: bold;" > 
				<td colspan="8" >合同</td>
			</tr>
			<tr  style="line-height: 20px;background:#ffffff" > 
				<td>合同备案送件日期</td><td><input value="<s:date name="#request.unitDe.contractSentDate" format="yyyy-MM-dd"/>" name="unitDe.contractSentDate" class="Wdate"  style="width:90px"/> </td>
				<td>合同备案回件日期</td><td><input value="<s:date name="#request.unitDe.contractBackDate" format="yyyy-MM-dd"/>" name="unitDe.contractBackDate" class="Wdate"  style="width:90px"/> </td>
				<td>合同银行领取日期</td><td><input value="<s:date name="#request.unitDe.contractBankDate" format="yyyy-MM-dd"/>" name="unitDe.contractBankDate" class="Wdate"  style="width:90px"/> </td>
				<td>合同客户领取日期</td><td><input value="<s:date name="#request.unitDe.contractCustomerDate" format="yyyy-MM-dd"/>" name="unitDe.contractCustomerDate" class="Wdate"  style="width:90px"/> </td>
			</tr>
			<tr  style="line-height: 20px;background:#ffffff" > 
				<td>合同经办人</td><td><input value="${unitDe.contractMan}" name="unitDe.contractMan" class="unitDe_input"/> </td>
				<td>合同审核人</td><td><input value="${unitDe.contractConfrimMan}" name="unitDe.contractConfrimMan" class="unitDe_input"/> </td>
				<td colspan="4"></td>
			</tr>
			<tr  style="line-height: 20px;background:#E9F5FF;font-weight: bold;" > 
				<td colspan="8" >其他</td>
			</tr>
			<tr  style="line-height: 20px;background:#ffffff" > 
				<td>成交周期</td><td><input value="${unitDe.dealCycle }" name="unitDe.dealCycle" class="unitDe_input"/> </td>
				<td>到访次数</td><td><input value="${unitDe.visitNum}" name="unitDe.visitNum" class="unitDe_input"/> </td>
				<td>实际交楼日期</td><td><input value="<s:date name="#request.unitDe.realHouseDate" format="yyyy-MM-dd"/>" name="unitDe.realHouseDate" class="Wdate"  style="width:90px"/> </td>
				<td>装修</td><td><input value="${unitDe.renovateDesc}" name="unitDe.renovateDesc" class="unitDe_input"/> </td>
			</tr>
			<tr  style="line-height: 20px;background:#ffffff" > 
				<td>地板</td><td><input value="${unitDe.renovateFloor}" name="unitDe.renovateFloor" class="unitDe_input"/> </td>
				<td>淋浴房</td><td><input value="${unitDe.renovateShower}" name="unitDe.renovateShower" class="unitDe_input"/> </td>
				<td>贴瓷砖</td><td><input value="${unitDe.renovateTile}" name="unitDe.renovateTile" class="unitDe_input"/> </td>
				<td>装修建议</td><td><input value="${unitDe.renovateSuggestion}" name="unitDe.renovateSuggestion" class="unitDe_input"/> </td>
			</tr>
			<tr  style="line-height: 20px;background:#ffffff" > 
				<td>条款</td><td colspan="7"><input style="width: 90%" value="${unitDe.renovateRemark}" name="unitDe.renovateRemark" class="unitDe_input"/> </td>
			</tr>
			<tr  style="line-height: 20px;background:#ffffff" > 
				<td>意见反馈1</td><td colspan="3"><input value="${unitDe.feedback1}" name="unitDe.feedback1" class="unitDe_input"/> </td>
				<td>意见反馈2</td><td colspan="3"><input value="${unitDe.feedback2}" name="unitDe.feedback2" class="unitDe_input"/> </td>
			</tr>
			<tr  style="line-height: 20px;background:#ffffff" > 
				<td>意见反馈3</td><td colspan="3"><input value="${unitDe.feedback3}" name="unitDe.feedback3" class="unitDe_input"/> </td>
				<td>备注</td><td colspan="3"><input value="${unitDe.remark}" name="unitDe.remark" class="unitDe_input"/> </td>
			</tr>
			<tr  style="line-height: 20px;background:#ffffff;font-weight: bold;" > 
				<td colspan="8" align="center"><input type="button" value="  保存  " onclick="submitUnitDeForm();"/> </td>
			</tr>
			<tr  style="line-height: 20px;background:#ffffff;font-weight: bold;" > 
				<td colspan="8" >&nbsp;</td>
			</tr>
			<tr  style="line-height: 20px;background:#ffffff;font-weight: bold;" > 
				<td colspan="8" >&nbsp;</td>
			</tr>
</table>
   </form>
				
