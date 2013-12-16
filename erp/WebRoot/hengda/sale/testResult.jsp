<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>销售数据汇总管理系统</title>

<link href="../css/hengda.css"  rel="stylesheet" type="text/css" charset="utf-8"/>
		<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.1/jquery.min.js"></script>
		<script type="text/javascript" src="/js/highcharts.js"></script>
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
						categories: <s:property value="chartXAxis"/>//['12-01', '11-02', '11-03', '11-04', '11-05', '11-06', 
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
						y: 10,
						borderWidth: 0
					},
					series: <s:property value="chartSeries"  escape="false"/>
					/*[{
						name: '恒大清远',
						data: [7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6,1,1,1,1,1,1,1,1,1,1,1,1,1,11,1,11,1,1,2,2,3]
					}, {
						name: '恒大安徽',
						data: [-0.2, 0.8, 5.7, 11.3, 17.0, 22.0, 24.8, 24.1, 20.1, 14.1, 8.6, 2.5]
					}, {
						name: '恒大广州',
						data: [-0.9, 0.6, 3.5, 8.4, 13.5, 17.0, 18.6, 17.9, 14.3, 9.0, 3.9, 1.0]
					}, {
						name: '恒大',
						data: [3.9, 4.2, 5.7, 8.5, 11.9, 15.2, 17.0, 16.6, 14.2, 10.3, 6.6, 4.8]
					}]
					*/
				});
				
				
			});
			
			function doSearch(pId){				
				window.location.href = "report_sale_hengda!test1.action?projectId="+pId;
			}
				
		</script>
</head>

<body>


<form action="report_sale_hengda!test1.action" method="get">
<!-- top 顶部 -->

<s:include value="../header.jsp"></s:include>
<br>
<label> <span>项目</span></label>
<s:select list="selProject" name="saleMonitorCond.projectId" value="%{saleMonitorCond.projectId}" />
	<label> <span>日期</span></label>
		<input type="hidden" name="type" value="month"/>
			  	<input class="Wdate" type="text" id="date1" name="saleMonitorCond.date1" style="width:90px" value="${saleMonitorCond.date1}" onClick="WdatePicker()"/>
				-
			  	<input class="Wdate" type="text" id="date2" name="saleMonitorCond.date2" style="width:90px" value="${saleMonitorCond.date2}" onClick="WdatePicker()"/>
		
				<input type="submit" value="  搜索  " id="searchSubmit" />
	
<!-- top 尾部 <s:property value="chartXAxis"/>-->
		<div id="container" style="width: 800px; height: 400px; margin: 0 auto"></div>
  
<s:include value="../bottom.jsp"></s:include>

</form>
  

</body>
</html>
