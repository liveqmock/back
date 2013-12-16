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
<title>年度销售数据统计</title>
<s:include value="header_report.jsp"></s:include>
<script type="text/javascript">
	$().ready(function() {
		projectListForHiddenId("projectName", "hiddenId"); //项目的联想框,及用隐藏域保存其id
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
					type="text" id="projectName" name="projectName"
					value="${projectName}" /> <input type="hidden" id="hiddenId"
					name="customerCond.projectId" value="${customerCond.projectId}" />
					日期<input class="easyui-datebox" type="text" style="width:90px"
					name="customerCond.date1" value="${customerCond.date1}" /> - <input
					class="easyui-datebox" type="text" style="width:90px"
					name="customerCond.date2" value="${customerCond.date2}" /> &nbsp;<input
					type="button" value=" 查询  " />
					<div class="right99"></div>
					<div class="blueline"></div>
				</td>
			</tr>
			<!-- 搜索表单 end -->


			<tr>
				<td colspan="6">

					<div class="gbox1">
						<div>
							<table width="100%" border="0" align="center" cellpadding="0"
								cellspacing="1" class="gbox" style="text-align: center;">
								<tr>
									<th rowspan="3"
										style="background-image: url(/erp/images/tianluan/gboxbg.gif);"
										width="120px">项目</th>
									<th colspan="4" class="gboxbg">周成交价</th>
									<th colspan="4" rowspan="2" class="gboxbg">周签约统计</th>
									<th colspan="2" rowspan="2" class="gboxbg">周回款情况</th>
								</tr>
								<tr>
									<th colspan="4" class="gboxbg">齐定</th>
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
									<th>已收首付款</th>
									<th>贷款到账金额</th>

								</tr>
								<tr onMouseOver="this.style.backgroundColor='#f1f9fe'"
									onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
									<td width="120px">&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
								</tr>
								<tr onMouseOver="this.style.backgroundColor='#f1f9fe'"
									onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
									<td width="120px">&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
								</tr>
								<tr onMouseOver="this.style.backgroundColor='#f1f9fe'"
									onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
									<th width="120px">合计</th>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
								</tr>
							</table>
						</div>

						<br />
						<p></p>
						<div>
							<table width="100%" border="0" align="center" cellpadding="0"
								cellspacing="1" class="gbox" style="text-align: center;">
								<tr>
									<th rowspan="3"
										style="background-image: url(/erp/images/tianluan/gboxbg.gif);"
										width="120px">项目</th>
									<th colspan="4" class="gboxbg">月成交价</th>
									<th colspan="4" rowspan="2" class="gboxbg">月签约统计</th>
									<th colspan="2" rowspan="2" class="gboxbg">月回款情况</th>
								</tr>
								<tr>
									<th colspan="4" class="gboxbg">齐定</th>
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
									<th>已收首付款</th>
									<th>贷款到账金额</th>

								</tr>
								<tr onMouseOver="this.style.backgroundColor='#f1f9fe'"
									onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
									<td width="120px">&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
								</tr>
								<tr onMouseOver="this.style.backgroundColor='#f1f9fe'"
									onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
									<td width="120px">&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
								</tr>
								<tr onMouseOver="this.style.backgroundColor='#f1f9fe'"
									onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
									<th width="120px">合计</th>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
								</tr>
							</table>
						</div>
						<br />
						<p></p>
						<div>
							<table width="100%" border="0" align="center" cellpadding="0"
								cellspacing="1" class="gbox" style="text-align: center;">
								<tr class="gboxbg">
									<th rowspan="3" width="120px"
										style="background-image: url(/erp/images/tianluan/gboxbg.gif);">项目</th>
									<th colspan="9">年成交统计</th>
									<th colspan="4" rowspan="2">年签约统计</th>
									<th colspan="6" rowspan="2">年回款统计</th>
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
								<tr onMouseOver="this.style.backgroundColor='#f1f9fe'"
									onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
									<td width="120px">&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
								</tr>
								<tr onMouseOver="this.style.backgroundColor='#f1f9fe'"
									onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
									<td width="120px">&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
								</tr>
								<tr onMouseOver="this.style.backgroundColor='#f1f9fe'"
									onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
									<th width="120px">合计</th>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
								</tr>
							</table>
						</div>

						<br />
						<p></p>
						<div>
							<table width="100%" border="0" align="center" cellpadding="0"
								cellspacing="1" class="gbox" style="text-align: center;">
								<tr class="gboxbg">
									<th rowspan="3" width="120"
										style="background-image: url(/erp/images/tianluan/gboxbg.gif);">项目</th>
									<th colspan="18">累计成交统计表</th>
								</tr>
								<tr class="gboxbg">
									<th colspan="4">可售</th>
									<th colspan="5">成交</th>
									<th colspan="4">冻结</th>
									<th colspan="5">剩余</th>
								</tr>
								<tr class="gboxbg">
									<th>套数</th>
									<th>面积</th>
									<th>金额</th>
									<th>均价</th>
									<th>齐定套数</th>
									<th>齐定面积</th>
									<th>齐定金额</th>
									<th>齐定均价</th>
									<th>销售率</th>
									<th>冻结套数</th>
									<th>冻结面积</th>
									<th>冻结总价</th>
									<th>冻结均价</th>
									<th>可售剩余套数</th>
									<th>剩余面积
										</td>
									</th>
									<th>剩余金额</th>
									<th>剩余均价</th>
									<th>剩余率</th>
								</tr>
								<tr onMouseOver="this.style.backgroundColor='#f1f9fe'"
									onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
									<td width="120">&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
								</tr>
								<tr onMouseOver="this.style.backgroundColor='#f1f9fe'"
									onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
									<td width="120">&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
								</tr>
								<tr onMouseOver="this.style.backgroundColor='#f1f9fe'"
									onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
									<th width="120">合计</th>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
								</tr>
							</table>
						</div>
						<br />
						<p></p>
						<div>
							<table width="100%" border="0" align="center" cellpadding="0"
								cellspacing="1" class="gbox" style="text-align: center;">
								<tr class="gboxbg">
									<th rowspan="3" width="120"
										style="background-image: url(/erp/images/tianluan/gboxbg.gif);">项目</th>
									<th colspan="8">累计签约统计</th>
									<th colspan="6" rowspan="2">累计回款统计</th>
								</tr>
								<tr class="gboxbg">
									<th colspan="4">已签合同</th>
									<th colspan="4">待签合同</th>
								</tr>
								<tr class="gboxbg">
									<th>套数</th>
									<th>面积</th>
									<th>签约金额</th>
									<th>均价</th>
									<th>套数</th>
									<th>面积</th>
									<th>金额</th>
									<th>均价</th>
									<th>已收房款</th>
									<th>贷款到账金额</th>

										<th>已结算佣金</th>
											<th>未结算佣金</th>
												<th>不结用套数</th>
													<th>不结佣金额</th>
								</tr>
								<tr onMouseOver="this.style.backgroundColor='#f1f9fe'"
									onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
									<td width="120">&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
								</tr>
								<tr onMouseOver="this.style.backgroundColor='#f1f9fe'"
									onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
									<td width="120">&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
								</tr>
								<tr onMouseOver="this.style.backgroundColor='#f1f9fe'"
									onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
									<th width="120">合计</th>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
								</tr>
							</table>
						</div>

					</div></td>
			</tr>

		</table>
	</form>
</body>
</html>

