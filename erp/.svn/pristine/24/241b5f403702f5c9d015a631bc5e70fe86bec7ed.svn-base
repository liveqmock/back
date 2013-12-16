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
<html>
	<head>
		<title>客户数量环比图（公司）</title>		
		<s:include value="../../header/header_easyui.jsp"></s:include>
		<script language="javascript" type="text/javascript" src="<%=basePath%>js/project.list.utils.js?v=1.2"></script>
		<script type="text/javascript" src="<%=basePath%>js/highcharts.js"></script>
		<script type="text/javascript" src="<%=basePath%>js/ui_fix.js"></script>
		<script type="text/javascript" src="<%=basePath%>js/highcharts_show.js"></script>
		<script type="text/javascript" src="<%=basePath%>js/datetime.utils.js?v=1"></script>
		<script type="text/javascript" src="<%=basePath%>/js/customer_guangzhou_project.js" ></script>
		
		<script type="text/javascript">	
		//初始化图形的option
		function initChartOptions(){				
			var options = {
					chart: {
						renderTo: 'container',
						defaultSeriesType: 'line'
					},
					title: {
						text: '客户数量环比图（公司）'
					},
					xAxis: {
						categories: 
							[]
					},
					yAxis: 
					{
						allowDecimals: false,min:0,
						title: {
							text: '人数'
						},
						plotLines: [{
							value: 0,
							width: 1,
							color: '#808080'
						}]
					}
						,
					plotOptions: {
						line: {
							dataLabels: {
								enabled: true
							},
							enableMouseTracking: false
						}
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
							[]
				};
				
			return options;
		}	

		//查询本月
		function queryFormByMonth(){
			setTwoDatebox("thismonth",$("#date1"),$("#date2"));
			queryForm();
		}	
			
		//查询
		function queryForm(){
			//异步读取数据，再设置hightchart图表
			$.ajax({
				url: './saleunit_new_report/report/guangzhou/customerNumCompanyAjax.action',
				dataType:'json',
				data: getInputsAsOjbect(["cond.strSearchCompanyIds","cond.date1","cond.date2","selCycel"]),
				success: function(data){
					showHighCharts(data.chartdata,initChartOptions());
				},
				error:function(e){
	            	alert(e);
	            }
			});
		}					
					
		$().ready(function(){
			queryFormByMonth();		
			
			$("#saleMonitorCond_companyId").change(function(){
				companyToProject(this.value, "saleMonitorCond_projectId");
			});			
			bindCompanyForXKZX("companyNames", "strSearchCompanyIds"); //多个项目的选择
		});
							
	</script>
		 

	</head>
	
	<body style="padding:0px;background:white;">
		<table width="100%" border="0" align="left" cellspacing="0" bgcolor="#efefef">	
	  <tr>	 
     	<td style="padding:5px;">	
&nbsp;公司<input type="text" id="companyNames" size="40" name="companyNames" />
		  
		   <input type="hidden" id="strSearchCompanyIds" name="cond.strSearchCompanyIds" />
			<input type="hidden" name="cond.sort" value="sumMoney"/>
			<input type="hidden" name="cond.order" value="desc"/>		
	    		&nbsp;日期<input class="easyui-datebox" type="text" id="date1" style="width:90px" name="cond.date1"/>
				-
				<input class="easyui-datebox" type="text" id="date2" style="width:90px" name="cond.date2"/>
			
			周期<s:select list="listSelCycel" name="selCycel" value="%{selCycel}" />
				&nbsp;<input type="button" onclick="queryForm()" value=" 查询 "/>
				<!-- &nbsp;<input type="button" onclick="download()" value=" 导出 "/> -->
		</td>
	 </tr>   
	 <tr><td>
	 
	 
<div class="blueline"></div>
 
		<div class="gbox1">	
		<div id="container" style="width: 100%; height:540px; margin: 0 auto"></div>
		  		
		</div>
	 </td></tr>       
 </table> 
	    
	
	</body>
</html>

