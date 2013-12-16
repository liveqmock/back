<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>项目结佣情况一览表</title>
<s:include value="header_report.jsp"></s:include>
<script type="text/javascript">
	$().ready(function() {
        bindProjectDialogForXKZX("projectName", "hiddenId"); //多个项目的选择
        parent.hideLoading("项目结佣情况一览表");
	});

	function submitSearch() {
		$("#thisForm").submit();
	}
</script>
</head>
<body  style="padding:0px;background:white;">

	<div class="right99"></div>
	<form class="registerform" id="thisForm"  method="post">
		<table width="100%" border="0" align="left" cellspacing="0">

			<tr>
				<td colspan="6"><label>&nbsp;<span>项目</span> </label> <input
					type="text" id="projectName" name="propertyUnitCond.strSearchProjectNames" value="${propertyUnitCond.strSearchProjectNames}" /> <input type="hidden" id="hiddenId"
					name="propertyUnitCond.strSearchProjectIds" value="${propertyUnitCond.strSearchProjectIds}" />
					日期
				<input class="easyui-datebox" type="text" id="date1" style="width:90px" name="propertyUnitCond.date1" value="${propertyUnitCond.date1}"/>-
				<input class="easyui-datebox" type="text" id="date2" style="width:90px" name="propertyUnitCond.date2" value="${propertyUnitCond.date2}"/> &nbsp;<input
					type="button" onclick="return submitSearch()" value=" 查询  " />
					<div class="right99"></div>
					<div class="blueline"></div></td>
			</tr>

			<!-- 搜索表单 end -->


			<tr>
				<td colspan="6">

					<div class="gbox1">
						<table width="100%" border="0" align="center" cellpadding="0"
							cellspacing="1" class="gbox" style="text-align: center;">
							<tr class="gboxbg">
								<td colspan="2">&nbsp;</td>
								<td colspan="3">齐定</td>
								<td colspan="3">签约</td>
								<td colspan="3">未签约</td>
								<td colspan="3">已结佣</td>
								<td colspan="3">未结佣</td>
								<td colspan="4">已对数未结佣</td>
								<td colspan="3">未对数未结佣</td>
							</tr>
							<tr class="gboxbg">
								<td>项目</td>
								<td>&nbsp;</td>
								<td height="20">套数</td>
								<td>面积</td>
								<td>金额</td>
								<td height="20">套数</td>
								<td>面积</td>
								<td>金额</td>
								<td height="20">套数</td>
								<td>面积</td>
								<td>金额</td>
								<td height="20">套数</td>
								<td>面积</td>
								<td>金额</td>
								<td height="20">套数</td>
								<td>面积</td>
								<td>金额</td>
								<td height="20">套数</td>
								<td>面积</td>
								<td>金额</td>
								<td>佣金</td>
								<td height="20">套数</td>
								<td>面积</td>
								<td>金额</td>
							</tr>
							 
						</table>

					</div>
				</td>
			</tr>

		</table>
	</form>
</body>
</html>
