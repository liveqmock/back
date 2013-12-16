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
<title>累计成交统计表</title>
<s:include value="header_report.jsp"></s:include>
<script type="text/javascript">
	$().ready(function() {
        bindProjectDialogForXKZX("projectName", "hiddenId"); //多个项目的选择
        parent.hideLoading("累计成交统计表");
	});

	function submitSearch() {
        parent.showLoading();
        $("#thisForm").submit();
	}
	
	 function exportMessage(){
		location.href='./saleunit_new_report/report/guangzhou/ljcjtjbdownload.action'  
	}
</script>
</head>
<body  style="padding:0px;background:white;">

	<div class="right99"></div>
	<form class="registerform" id="thisForm"  method="post" action="./saleunit_new_report/report/guangzhou/ljcjtjbReport.action">
		<table width="100%" border="0" align="left" cellspacing="0">

			<tr>
				<td colspan="6"><label>&nbsp;<span>项目</span> </label> <input type="text" id="projectName"  size="40" name="propertyUnitCond.strSearchProjectNames" value="${propertyUnitCond.strSearchProjectNames}"/>
                <input type="hidden" id="hiddenId" name="propertyUnitCond.strSearchProjectIds" value="${propertyUnitCond.strSearchProjectIds}" />
					&nbsp;日期
				<input class="easyui-datebox" type="text" id="date1" style="width:90px" name="propertyUnitCond.date1" value="${propertyUnitCond.date1}"/> -
				<input class="easyui-datebox" type="text" id="date2" style="width:90px" name="propertyUnitCond.date2" value="${propertyUnitCond.date2}"/>&nbsp;<input
					type="button" onclick="return submitSearch()"  value=" 查询  " />
					<input type="button" onclick="return exportMessage()" value="导出" />
					<div class="right99"></div>
					<div class="blueline"></div>
				</td>
			</tr>
			<!-- 搜索表单 end -->


			<tr>
				<td colspan="6">

					<div class="gbox1">
						

						<br />
						<div>
							<table width="100%" border="0" align="center" cellpadding="0"
								cellspacing="1" class="gbox" style="text-align: center;">
								<tr class="gboxbg">
									<th rowspan="2" width="120"
										style="background-image: url(/erp/images/tianluan/gboxbg.gif);">项目</th>
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
									<th>剩余面积</th>
									<th>剩余金额</th>
									<th>剩余均价</th>
									<th>剩余率</th>
								</tr>							
							 
							</table>
						</div>
						<br />

					</div></td>
			</tr>

		</table>
	</form>
</body>
</html>

