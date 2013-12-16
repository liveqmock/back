

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
						text: '客户数量'
					},
					xAxis: {
						categories: 
							<s:property value="chartXAxis"  escape="false"/>
					},
					yAxis: 
					{
						allowDecimals: false,min:0,
						title: {
							text: '客户数量'
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
			
			$().ready(function(){				
				$("#customerCond_companyId").change(function(){
					companyToProject(this.value, "customerCond_projectId");
				});				
			});
				
		</script>
		
	<title>客户数量环比图</title>

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

										   <div class="title02" ><a href="./sale_hengda/chart/customerNum.action" target="_self">客户数量环比图</a></div>
										<div class="right99"></div>
										<div class="blueline"></div>

										<div class="c"></div>
										<div class="c"></div>
										
										
										 <table width="100%" border="0" align="left" cellspacing="0">	  
		  
										  <!-- 搜索表单 top -->
									   
						   <form class="registerform" action="<%=request.getContextPath() %>/sale_hengda/chart/customerNum.action" method="post" >
								  <tr>
								<td colspan="6">	
							
							<input class="Wdate" type="text" id="date1" name="customerCond.date1" style="width:90px" value="${customerCond.date1}" onClick="WdatePicker()"/>
							-
							<input class="Wdate" type="text" id="date2" name="customerCond.date2" style="width:90px" value="${customerCond.date2}" onClick="WdatePicker()"/>			
							<label>
								<span>所属公司</span>
							</label>
							<s:select list="selCompany" name="customerCond.companyId" value="#session.companyId" />
							<label>
								<span>所属项目</span>
							</label>
							<s:select list="selProject" name="customerCond.projectId" value="#session.projectId" />
							
							<label> <span>周期</span></label>
							<s:select list="listSelCycel" name="selCycel" value="%{selCycel}" />
							<s:submit value="  查询  " name="search" />	
													 
							<div class="blueline"></div>	 
							<div class="gbox1">	
								<div id="container" style="width: 100%; height:500px; margin: 0 auto"></div>																
							</div>
							
								</td>
							 </tr>
								</form>
								  
								<!-- 搜索表单 end -->
									
								  
						 </table>


										
										
								</td>
								<%-- 基本table分割 ^^^^^^^^^^^^^^^^^end^^^</td>^^^^^^^^^^^^^^^^^^^^^--%>
							</tr>
					  </table>
					 </div>
					</td>
				</tr>
			</tbody>

		</table>

	</body>
</html>



   
   



