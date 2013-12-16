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
<html >
	<head>
		<title>分类环比走势图(项目)</title>
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
						text: '客户数量环比图（项目）'
					},
					xAxis: {
						categories: 
							[]
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
		
		$().ready(function(){				
			$("#saleMonitorCond_companyId").change(function(){
				companyToProject(this.value, "saleMonitorCond_projectId");
			});				
			var questionId= $("#selectedQuestionId").val();
			var selectedSelCateGory = $("#selectedSelCateGory").val();

			bindProjectDialogForSQKHOnlyQuestion("projectName", "hiddenId",questionId,selectedSelCateGory); //多个项目的选择
						
			queryFormByMonth();
		});
		
		
		//查询本周
		function queryFormByWeek(){
			setTwoDatebox("thisweek",$("#date1"),$("#date2"));
			queryForm();
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
				url: './saleunit_new_report/report/guangzhou/categoryNumAjax.action',
				dataType:'json',
				data: getInputsAsOjbect(["cond.strSearchCompanyProjectIds","cond.visitDate1","cond.visitDate2","selCategory"]),
				success: function(data){
					showHighCharts(data.chartdata,initChartOptions());
				},
				error:function(e){
	            	alert(e);
	            }
			});
		}		
		
		function submitSearch_CustomerPie(){
			if($("#hiddenId").val()==""){
				myAlert("请选择项目");
				return;
			}
			$(window.parent.document).find("#showTitle").text('单项比例分析图');	
			$("#thisForm").attr("action", "./saleunit_new_report/report/guangzhou/customerPie.action").submit();	
		}
		
		function submitSearch_CustomerTable(){
			if($("#hiddenId").val()==""){
				myAlert("请选择项目");
				return;
			}
			$(window.parent.document).find("#showTitle").text('单项数据分析表');	
			$("#thisForm").attr("action", "./saleunit_new_report/report/guangzhou/customerTable.action").submit();	
		}
		</script>	 
	</head>
<body style="padding:0px;background:white;">

<%--主体导航页头 --%>
<div class="right99"></div>
 <input type="hidden" id="selectedSelCateGory" value="${session.selectedSelCateGory}"/>
<input type="hidden" id="selectedQuestionId" value="${session.questionId}"/>			
<form id="thisForm" method="post">
	 <table width="100%" border="0" align="left" cellspacing="0">	  
		  <tr >	
     	<td colspan="6">	
     	&nbsp;&nbsp;项目<input type="text" id="projectName" size="40" name="projectName" value="${cond.strSearchProjectNames}"/>
		<input type="hidden" id="hiddenId" name="cond.strSearchCompanyProjectIds" value="${cond.strSearchProjectIds}"/>
		
		<label>&nbsp;<span>项目问卷</span></label><s:select list="questionList" name="questionId" id="questionList"  onchange="bindQuestionCategory();" />
		<label>&nbsp;<span>分析类型</span>
			</label><select id="selCategoryList" name="selCategory" style="width:100px"></select>
				&nbsp;
				日期<input class="easyui-datebox" type="text" id="date1" style="width:90px" name="cond.visitDate1" value="${cond.visitDate1}"/>
				-
				<input class="easyui-datebox" type="text" id="date2" style="width:90px" name="cond.visitDate2" value="${cond.visitDate2}"/>
		&nbsp;<input type="button" onclick="return queryForm()" value=" 查询  "/>	
		
			
<div class="right99"></div>		 
<div class="blueline"></div>	 
		<div class="gbox1">	
		<div id="container" style="width: 100%; height:500px; margin: 0 auto"></div>
		  		
</div>

</td>
	 </tr>		  			
          
 </table>
		</form>


   
</body>
</html>

   
   



