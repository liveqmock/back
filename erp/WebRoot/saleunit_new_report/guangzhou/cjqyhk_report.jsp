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
<title>成交签约回款情况</title>
<s:include value="header_report.jsp"></s:include>
<script type="text/javascript">
	$().ready(function() {
        bindProjectDialogForXKZX("projectName", "hiddenId"); //多个项目的选择
        parent.hideLoading("成交签约回款情况");
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
					截止日期
				<input class="easyui-datebox" type="text" id="date2" style="width:90px" name="propertyUnitCond.date2" value="${propertyUnitCond.date2}"/>&nbsp;<input
					type="button" onclick="return submitSearch()" value=" 查询  " />
					<div class="right99"></div>
					<div class="blueline"></div>
				</td>
			</tr>
			<!-- 搜索表单 end -->


			<tr>
				<td colspan="6">

					<div class="gbox1">

						<p></p>
						<div>
							<table width="100%" border="0" align="center" cellpadding="0"
								cellspacing="1" class="gbox" style="text-align: center;">
								<tr class="gboxbg">
									<th rowspan="3" width="120px"
										style="background-image: url(/erp/images/tianluan/gboxbg.gif);">项目</th>
									<th colspan="9">成交统计</th>
									<th colspan="4" rowspan="2">签约统计</th>
									<th colspan="6" rowspan="2">回款统计</th>
								</tr>
								<tr class="gboxbg">
									<th colspan="4">可售</th>
									<th colspan="5">齐定</th>
								</tr>
								<tr class="gboxbg">
									<th>套数</th>
									<th>面积</th>
									<th>金额</th>
									<th>均价</th>
									<th>套数</th>
									<th>面积</th>
									<th>金额</th>
									<th>均价</th>
									<th>销售率</th>
									<th>套数</th>
									<th>面积</th>
									<th>金额</th>
									<th>均价</th>
									<th>已收首付款</th>
									<th>贷款到账金额
										</td>
									</th>
									<th>已结算佣金
										</td>
									</th>
									<th>未结算佣金</th>
									<th>不结佣套数</th>
									<th>不结佣金额</th>
								</tr>
								
							 <s:property value="showTrs"  escape="false"/> 
							 
							</table>
						</div>


					</div></td>
			</tr>

		</table>
	</form>
</body>
</html>

