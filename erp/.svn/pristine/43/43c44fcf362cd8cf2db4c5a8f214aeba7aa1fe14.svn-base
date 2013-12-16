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
						defaultSeriesType: 'column'
					},
					title: {
						text: '单个项目各项数据'
					},
					xAxis: {
						categories: <s:property value="chartXAxis" escape="false"/>
					},
					yAxis: {
						min: 0,
						title: {
							text: '各项数据'
						}
					},
					legend: {
						layout: 'vertical',
						backgroundColor: '#FFFFFF',
						align: 'left',
						verticalAlign: 'top',
						x: 100,
						y: 70,
						floating: true,
						shadow: true
					},
					tooltip: {
						formatter: function() {
							var tips = ''+this.x +' ' + this.series.name +' :'+ this.y;
							if(this.series.name=="电话数"){
								tips += '套';
							}
							else{
								tips += '个';
							}
					
							return tips;
						}
					},
					plotOptions: {
						column: {
							pointPadding: 0.2,
							borderWidth: 0
						}
					},
				        series: <s:property value="chartSeries"  escape="false"/>
				});
				
				
			});
			
			
				
		</script>
		<title>单个项目各项数据曲线</title>
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
											<form action="sale_hengda/chart/one_project.action" method="post">
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










