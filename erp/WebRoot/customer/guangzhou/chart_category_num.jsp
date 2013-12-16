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
		<title>单项环比走势图</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<style>
		* {margin:0;padding:0;}
		</style>
		<s:include value="header.jsp"></s:include>	
		<s:include value="header_left_js.jsp"></s:include>	
		<script type="text/javascript" src="<%=basePath%>js/highcharts.js"></script>
		<script type="text/javascript" src="<%=basePath%>js/ui_fix.js"></script>
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
			
			
			$().ready(function(){				
				$("#saleMonitorCond_companyId").change(function(){
					companyToProject(this.value, "saleMonitorCond_projectId");
				});				
				
				projectListForHiddenId("projectName", "hiddenId"); //项目的联想框,及用隐藏域保存其id
			});
				
		</script>
		
		<script type="text/javascript" language="javascript" src="<%=basePath%>js/customer_guangzhou_project.js"></script>	 

		
	</head>
<body>
<%--固定的上部 --%>
<s:include value="body_up.jsp">
</s:include>	

<%--主体导航页头 --%>
<div class="title02" ><a href="./customer_guangzhou/chart/categoryNum.action" target="_self">单项环比走势图</a></div>
<div class="right99"></div>
<div class="blueline"></div>

<div class="c"></div>
<div class="c"></div>
<%--主体table top --%>
		
  	
	 <table width="100%" border="0" align="left" cellspacing="0">	  
		  
		  <!-- 搜索表单 top -->
       
<form action="./customer_guangzhou/chart/categoryNum.action" method="post">
		  <tr>
     	<td colspan="6">	
     	<label>&nbsp;<span>项目</span></label><input type="text" id="projectName" name="projectName" value="${projectName}"/>
		<input type="hidden" id="hiddenId" name="customerCond.projectId" value="${customerCond.projectId}"/>	
		
		<label>&nbsp;<span>分析类型</span></label><s:select list="listSelCategory" name="selCategory" value="%{selCategory}" />	
				&nbsp;
				日期<input class="Wdate" type="text" id="date1" style="width:90px" name="customerCond.date1" value="${customerCond.date1}"/>
				-
				<input class="Wdate" type="text" id="date2" style="width:90px" name="customerCond.date2" value="${customerCond.date2}"/>
		&nbsp;<s:submit value="  查询  " name="search" />	
		
				<a style="color:#1199FF;" href="<s:property value="urlPie"  escape="false"/>">比例分析</a>&nbsp;
				<a style="color:#1199FF;" href="<s:property value="urlTable"  escape="false"/>">分析表</a>
					 
<div class="blueline"></div>	 
		<div class="gbox1">	
		<div id="container" style="width: 100%; height:500px; margin: 0 auto"></div>
		  		
</div>

</td>
	 </tr>
		</form>
		  
		<!-- 搜索表单 end -->
			
          
 </table>


<%--主体table end --%>



<%--固定的底部 --%>
<s:include value="body_bottom.jsp">
</s:include>
</table>  
   
</body>
</html>

   
   



