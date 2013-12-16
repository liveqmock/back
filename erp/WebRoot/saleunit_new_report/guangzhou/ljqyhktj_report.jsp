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
<title>累计签约回款统计</title>
<s:include value="header_report.jsp"></s:include>
<script type="text/javascript">
	$().ready(function() {
        bindProjectDialogForXKZX("projectName", "hiddenId"); //多个项目的选择
        parent.hideLoading("累计签约回款统计表");
	});

	function submitSearch() {
		$("#thisForm").submit();
	}

	  function exportMessage(){
			location.href='./saleunit_new_report/report/guangzhou/ljqyhktjdownload.action'  
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
					&nbsp;日期
				<input class="easyui-datebox" type="text" id="date1" style="width:90px" name="propertyUnitCond.date1" value="${propertyUnitCond.date1}"/> - 
				<input class="easyui-datebox" type="text" id="date2" style="width:90px" name="propertyUnitCond.date2" value="${propertyUnitCond.date2}"/> &nbsp;<input
					type="button" onclick="return submitSearch()" value=" 查询  " />
					 <input type="button" onclick="return exportMessage('export')" value="导出" />
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
								
							 <s:property value="showTrs"  escape="false"/> 
							 
							</table>
						</div>

					</div></td>
			</tr>

		</table>
	</form>
</body>
</html>

