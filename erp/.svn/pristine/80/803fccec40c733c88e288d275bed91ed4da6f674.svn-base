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
		<title>单项比例分析图</title>
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
<div class="title02" ><a href="./customer_guangzhou/chart/customerPie.action" target="_self">单项比例分析图</a></div>
<div class="right99"></div>
<div class="blueline"></div>
<div class="c"></div>
<div class="c"></div>

<%--主体table top --%>
		
  	
	 <table width="100%" border="0" align="left" cellspacing="0">	  
		  
		  <!-- 搜索表单 top -->
       
  <form action="./customer_guangzhou/chart/customerPie.action" method="post">
		  <tr>
     	<td colspan="6">	
     	<label>&nbsp;<span>项目</span></label><input type="text" id="projectName" name="projectName" value="${projectName}"/>
		<input type="hidden" id="hiddenId" name="customerCond.projectId" value="${customerCond.projectId}"/>	
		
		<label>&nbsp;<span>分析类型</span></label><s:select list="listSelCategory" name="selCategory" value="%{selCategory}" />			
				&nbsp;日期<input class="Wdate" type="text" id="date1" style="width:90px" name="customerCond.date1" value="${customerCond.date1}"/>
				-
				<input class="Wdate" type="text" id="date2" style="width:90px" name="customerCond.date2" value="${customerCond.date2}"/>
		
		&nbsp;<s:submit value="  查询  " name="search" />	
				<a  style="color:#1199FF;" href="<s:property value="urlCategoryNum"  escape="false"/>">环比走势</a>&nbsp;
				<a style="color:#1199FF;" href="<s:property value="urlTable"  escape="false"/>">分析表</a>
				
<div class="blueline"></div>	 
			
		<div class="gbox1">	
		<table style="width:100%;" ><tr><td width="50%" valign="top">

<div class="gbox1">	
			  <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="text-align: center;">          
		   							   
              <tr class="gboxbg">			  	
				<td style="font-weight:bolder;">类别</td>    	
				<td style="font-weight:bolder;">小计</td>    	
				<td style="font-weight:bolder;">比例</td>    			
              </tr>
              
			<s:iterator value="listMainTable" var="line"> 
              <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>  
              <s:iterator value="#line" var="lineTd">   
				<td><s:property value="#lineTd"/></td>  
			</s:iterator>
              </tr>   
              </s:iterator>   
	  </table>
	  
	  </div>
</td>
			<td width="50%">
		<div id="container1" style="width:100%;height:400px;"></div>
		</td></tr></table>
		  		
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



   
   



