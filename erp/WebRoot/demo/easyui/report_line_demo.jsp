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
<title></title>
<s:include value="../../header/header_easyui.jsp"></s:include>
<s:include value="coder_header.jsp"></s:include>
</head>

<body  style="padding:10px;">
<b>折线图说明：</b>

<br/>

<p></p>
<b>参考：</b><br/>
<br/>
分类环比走势图<br/>
<a href="./saleunit_new_report/report/guangzhou/categoryNum.action" target="_blank">./saleunit_new_report/report/guangzhou/categoryNum.action</a>
<br/>
<br/>
<p></p>
<b>主要代码说明：</b>
<br/>
<br/>
<b>代码示例：</b>
<textarea rows="10" cols="150">
1，配置文件struts-saleunit-new-report.xml
		<!-- 分类比例分析图(分类环比走势图) -->
		<action name="categoryNum" class="com.ihk.customer.action.ChartCategoryNumAction">
			<result name="success" >/saleunit_new_report/guangzhou/chart_category_num.jsp</result>
		</action>
2，jsp
<script type="text/javascript">
		var chart;
			$(document).ready(function() {
				chart = new Highcharts.Chart({
					chart: {
						renderTo: 'container',
						defaultSeriesType: 'line'
					},
					title: {
						text: '<s:property value="listSelCategory.get(selCategory)"  escape="false"/>'
					},
					xAxis: {
						categories: 
							<s:property value="chartXAxis"  escape="false"/>
					},
					yAxis: 
					{
						allowDecimals: false,min:0,
						title: {
							text: '人次'
						},
						plotLines: [{
							value: 0,
							width: 1,
							color: '#808080'
						}]
					}
						,
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
							var tips = ''+this.x +' ' + this.series.name +' :'+ commafy(this.y);
							if(this.series.name=="来电"){
								tips += '组';
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
				        series: 
							<s:property value="chartSeriesData"  escape="false"/>
				});				
				
			});			
			
			
		</script>
		
</textarea>
<br/>

</body>
</html>

