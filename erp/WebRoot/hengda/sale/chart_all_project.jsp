

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
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
		<s:include value="include/header.jsp"></s:include>
		<script type="text/javascript">
		
			var chart;
			$(document).ready(function() {
				
				chart = new Highcharts.Chart({
					chart: {
						renderTo: 'container',
						defaultSeriesType: 'line',
						marginRight: 130,
						marginBottom: 25
					},
					title: {
						text: '销售数据月统计',
						x: -20 //center
					},
					//subtitle: {
					//	text: 'Source: WorldClimate.com',
					//	x: -20
					//},
					xAxis: {
						//需要补充的x坐标
						categories: <s:property value="chartXAxis" escape="false"/>//['12-01', '11-02', '11-03', '11-04', '11-05', '11-06', 
							//'11-07', '11-07', '11-09', '11-10','11-11','11-12','11-13','11-14','11-15','11-16','11-17','11-18','11-19','11-20','11-21','11-22','11-23','11-24','11-25','11-26','11-27','11-28','11-29','11-30','11-31']
					},
					yAxis: {
						title: {
							text: '销售金额 (千元)'
						},
						plotLines: [{
							value: 0,
							width: 1,
							color: '#808080'
						}]
					},
					tooltip: {
						formatter: function() {
				                return '<b>'+ this.series.name +'</b><br/>'+
								this.x +': '+ this.y +'千元';
						}
					},
					legend: {
						layout: 'vertical',
						align: 'right',
						verticalAlign: 'top',
						x: -10,
						y: 0,
						borderWidth: 0
					},
					series: <s:property value="chartSeries"  escape="false"/> 
					
					
				});
				
				
			});
			
				
		</script>
		<title>各个项目销售金额曲线</title>
	</head>
	<body>
		<table width="100%" border="0" align="left" cellspacing="0">
			<thead>
				<tr>
					<td colspan="2" style="border-collapse: collapse; border: 0px; margin: 0px; padding: 0px;">
						<s:include value="include/top.jsp"></s:include>
						
					</td>
				</tr>
			</thead>
			<tfoot>
				<tr>
					<td colspan="2">
						<s:include value="include/bottom.jsp"></s:include>
					</td>
				</tr>
			</tfoot>
			<tbody>
				<tr style="height: 100%">
					<td valign="top">
						<s:include value="include/left.jsp">
						</s:include>
					</td>
					<td width="100%" valign="top" bgcolor="#A4C3D7" height="500px">
						<%-- 基本table分割 ^^^^^^<td width="100%">^^^^^^^^^^^^^^^^^^^^^^--%>
						<%--main table开始 --%>
						<table width="100%" class="mainbg20111112" style="height: 100%">
							<tr>


								<td width="100%" valign="top" height="100%" style="overflow: hidden;">
									<div class="titlel"></div>
									<div class="titlebg" style="height: auto; overflow: hidden;">

										<div class="title02">
											<a href="./reportlist!reportlist.action" target="_self">查看报表</a>
										</div>
										<div class="right99"></div>
										<div class="blueline"></div>

										<div class="c"></div>
										<div class="c"></div>



										<table width="100%" border="0" align="left" cellspacing="0">

											<!-- 搜索表单 top -->
											<form action="sale_hengda/chart/all_project.action" method="post">
												<table width="100%" border="0" align="left" cellspacing="0">
													<!-- 蓝色边条begin -->
													<tr>
														<td></td>
													</tr>
													<!-- 蓝色边条end -->


													<!-- 搜索表单 end -->



													<!-- 列表 begin -->
													<tr>
														<td colspan="6">
															<label>
																<span>项目</span>
															</label>
															<s:select list="selProject" name="saleMonitorCond.projectId" value="%{saleMonitorCond.projectId}" />
															<label>
																<span>日期</span>
															</label>
															<input type="hidden" name="type" value="month" />
															<input class="Wdate" type="text" id="date1" name="saleMonitorCond.date1" style="width: 90px" value="${saleMonitorCond.date1}" onClick="WdatePicker()" />
															-
															<input class="Wdate" type="text" id="date2" name="saleMonitorCond.date2" style="width: 90px" value="${saleMonitorCond.date2}" onClick="WdatePicker()" />

															<input type="submit" value="  搜索  " id="searchSubmit" />
															<div class="gbox1">
																<div id="container" style="width: 100%; height: 600px; margin: 0 auto"></div>

															</div>

														</td>
													</tr>
													<!-- 列表 end -->

													<tr>
														<td colspan="6">
															<div class="manu">
																<s:property value="showPage" escape="false" />
															</div>
														</td>
													</tr>
												</table>
											</form>

										</table>
								</td>
								<%-- 基本table分割 ^^^^^^^^^^^^^^^^^end^^^</td>^^^^^^^^^^^^^^^^^^^^^--%>
							</tr>
			</tbody>

		</table>

	</body>
</html>



