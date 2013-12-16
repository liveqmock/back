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
		<title>公共的饼图显示</title>

		<s:include value="../../header/header_easyui.jsp"></s:include>
		<script type="text/javascript" src="<%=basePath%>js/highcharts.js"></script>
		<script type="text/javascript" src="<%=basePath%>js/ui_fix.js"></script>
			
		<script type="text/javascript">
			var chart;
			$(document).ready(function() {				
				chart = new Highcharts.Chart({
					chart: {
						renderTo: 'container1',
						plotBackgroundColor: null,
						plotBorderWidth: null,
						plotShadow: false
					},
					title: {
						text: '<s:property value="titleText"  escape="false"/>'
					},
					tooltip: {
						formatter: function() {
							return '<b>'+ this.point.name +'</b>: '+ changeTwoDecimal(this.percentage) +' %';
						}
					},
					plotOptions: {
						pie: {
							allowPointSelect: true,
							cursor: 'pointer',
							dataLabels: {
								enabled: true,
								color: '#000000',
								connectorColor: '#000000',
								formatter: function() {
									return '<b>'+ this.point.name +'</b>: '+ changeTwoDecimal(this.percentage) +' %';
								}
							}
						}
					},
				    series: [{
						type: 'pie',
						data: [
								<s:property value="chartSeriesData"  escape="false"/>
						]
					}]
				});
			});		
			</script>			
	</head>
<body style="padding:0px;background:white;">
<br/>
<br/>
<div id="container1" style="width:98%;height:400px;"></div>

	</body>
</html>



   
   



