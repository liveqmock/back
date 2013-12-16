

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
						defaultSeriesType: 'line'
					},
					title: {
						text: '<s:property value="chartTitle" escape="false"/>'
					},
					xAxis: {
						categories: <s:property value="chartXAxis" escape="false"/>
					},
					yAxis:
						<s:property value="chartYAxis" escape="false"/>	
						,
					legend: {
						layout: 'vertical',
						backgroundColor: '#FFFFFF',
						align: 'left',
						verticalAlign: 'top',
						x: 80,
						y: 30,
						floating: true,
						shadow: true
					},
					tooltip: {
						formatter: function() {
							var tips = ''+this.x +' ' + this.series.name +' :'+ commafy(this.y);
							if(this.series.name=="来电"){
								tips += '组';
							}
							else if(this.series.name=="来访"){
								tips += '个';
							}
							else if(this.series.name=="销售套数"){
								tips += '套';
							}
							else if(this.series.name=="销售面积"){
								tips += '平米';
							}
							else if(this.series.name=="销售金额"){
								tips += '万元';
							}
							else if(this.series.name=="认筹数量"){
								tips += '次';
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
		<title>公司曲线</title>
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
					<td width="100%" valign="top" >
					<DIV style="WIDTH: 98%; HEIGHT: 100%; BACKGROUND-COLOR: #A4C3D7;padding: 1px">
						<%-- 基本table分割 ^^^^^^<td width="100%">^^^^^^^^^^^^^^^^^^^^^^--%>
						<%--main table开始 --%>
						<table width="100%" class="mainbg20111112" style="height: 100%">
							<tr>


								<td width="100%" valign="top" height="100%" style="overflow: hidden;">
									<div class="titlel"></div>
									<div class="titlebg" style="height: auto; overflow: hidden;">

										 <div class="title02" ><a href="./sale_hengda/chart/project.action" target="_self">查看公司曲线</a></div>
										<div class="right99"></div>
										<div class="blueline"></div>

										<div class="c"></div>
										<div class="c"></div>



										<table width="100%" border="0" align="left" cellspacing="0">

											<!-- 搜索表单 top -->
											 <form action="sale_hengda/chart/company.action" method="post">
	<table width="100%" border="0" align="left" cellspacing="0">

		 <tr>
              <td height="10" colspan="6">
           
              </td>
        </tr>
	
     <tr>
     	<td colspan="6">	
     	<label>&nbsp;<span>公司</span></label>
		<s:select list="listSelCompany" name="saleMonitorCond.companyId" value="%{saleMonitorCond.companyId}" />
			
		<label> <span>日期</span></label>
		<input type="hidden" name="type" value="month"/>
		<input class="Wdate" type="text" id="date1" name="saleMonitorCond.date1" style="width:90px" value="${saleMonitorCond.date1}" onClick="WdatePicker()"/>
				-
		<input class="Wdate" type="text" id="date2" name="saleMonitorCond.date2" style="width:90px" value="${saleMonitorCond.date2}" onClick="WdatePicker()"/>
		
		<label> <span>周期</span></label>
		<s:select list="listSelCycel" name="selCycel" value="%{selCycel}" />
		<label> <span>曲线类型</span></label>
		<s:select list="listSelYType" name="selYType" value="%{selYType}" />
			
		<s:submit value="  查询  " name="search" />		  
			
			
		<a href="<s:property value="detailSearchUrl" escape="false"/>" target="_self" class="ablue">明细查询</a>
		<a href="<s:property value="sumSearchUrl" escape="false"/>" target="_self" class="ablue">汇总查询</a>
		<div class="gbox1">	
		<div id="container" style="width: 100%; height:600px; margin: 0 auto"></div>		  		
</div>
</td>
 </tr>

 <tr>
              <td colspan="6">
                <div class="manu">
				</div>                
			</td>
            </tr>
 </table>
 </form>
										</table>
										</div>
								</td>
								<%-- 基本table分割 ^^^^^^^^^^^^^^^^^end^^^</td>^^^^^^^^^^^^^^^^^^^^^--%>
							</tr>
			</tbody>

		</table>

	</body>
</html>



   



