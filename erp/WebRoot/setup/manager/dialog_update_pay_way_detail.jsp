<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>
	
	<title>付款方式明细</title>
	<style type="text/css">
		*{margin:0;padding:0;}
	</style>
	<script>
	function formsubmit (){
		document.getElementById("question_toc_form").submit();
    }
	</script>
	</head>
<body>
<div class="gbox1" style="">		
<form action="./saleunit_setup/payway/dialogUpdatePayWayDetailForm.action" id="question_toc_form" method="post">	
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1"  style="font-size:12px; line-height:26px;">
		<tr bgcolor="#ffffff">
			<td width="120px" align="right">款项</td>
			<td width="">
				<input type="hidden" name="pwdId" value="${pwdId }"/>
				<input name="payWayDetail.detailName" value="${payWayDetail.detailName }"/>
			</td>
		</tr>
		<tr bgcolor="#ffffff">
			<td  align="right">天数</td>
			<td>
					<input name="payWayDetail.dayNum" value="${payWayDetail.dayNum }"/>
			</td>
		</tr>
		<tr bgcolor="#ffffff">
			<td  align="right">基数金额种类</td>
			<td>
					<input name="payWayDetail.baseMoneyType" value="${payWayDetail.baseMoneyType }"/>
			</td>
		</tr>
		<tr bgcolor="#ffffff">
			<td  align="right">金额</td>
			<td>
					<input name="payWayDetail.payMoney" value="${payWayDetail.payMoney }"/>
			</td>
		</tr>
		<tr bgcolor="#ffffff">
			<td  align="right">比例</td>
			<td>
					<input name="payWayDetail.payPercent" value="${payWayDetail.payPercent }"/>
			</td>
		</tr>
		<tr bgcolor="#ffffff">
			<td  align="right">四舍五入位数</td>
			<td>
					<input name="payWayDetail.modNum" value="${payWayDetail.modNum }"/>
			</td>
		</tr>
		<tr bgcolor="#ffffff">
			<td  align="right">是否包含定金</td>
			<td>
			<s:if test="#request.payWayDetail.isInclude = '1'">
			<input name="payWayDetail.isInclude" type="checkbox" value="1"  checked="checked"/>
			</s:if>
			<s:else>
			<input name="payWayDetail.isInclude" type="checkbox" value="1"  />
			</s:else>
					
			</td>
		</tr>
		<tr bgcolor="#ffffff">
			<td  align="right">备注</td>
			<td>
					<input name="payWayDetail.remark" value="${payWayDetail.remark }" />
			</td>
		</tr>
		<tr bgcolor="#ffffff">
			<td  align="center" colspan="2" style="color: red"> ${mag }</td>
			
		</tr>
	</table>
	</form>
</div>
</body>
</html>