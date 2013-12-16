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
<b>比例图说明：</b>

<br/>

<p></p>
<b>参考：</b><br/>
客户分类比例图<br/>
<a href="./saleunit_new_report/report/guangzhou/customerPie.action" target="_blank">./saleunit_new_report/report/guangzhou/customerPie.action</a>
<br/>
<p></p>
<b>主要代码说明：</b>
<br/>
<br/>
<b>代码示例：</b><br/>
<textarea rows="50" cols="150">
1，配置文件（struts-saleunit-new-report.xml）
		<!-- 客户分类比例图 -->
		<action name="customerPieFirst" class="com.ihk.customer.action.ChartCustomerPieAction" method="customerPieFirst">
			<result name="customerPieFirst" >/saleunit_new_report/guangzhou/chart_customer_pie_first.jsp</result>
		</action>

2,chart_customer_pie.jsp
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
						text: '<s:property value="listSelCategory.get(selCategory)"  escape="false"/>'
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
				
</textarea>
<br/>

</body>
</html>

