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
		<title>项目客户比例</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<style>
		* {margin:0;padding:0;}
		</style>
		<s:include value="header.jsp"></s:include>	
		<s:include value="header_left_js.jsp"></s:include>	
		<script type="text/javascript" src="<%=basePath%>js/highcharts.js"></script>
		<script type="text/javascript" src="<%=basePath%>js/ui_fix.js"></script>
		<script type="text/javascript" src="<%=basePath%>js/highcharts.js"></script>
		<script type="text/javascript" src="<%=basePath%>js/ui_fix.js"></script>
		
		<script type="text/javascript" language="javascript" src="<%=basePath%>js/customer_guangzhou_project.js"></script>	
		<script type="text/javascript">
			var chart;
			$(document).ready(function() {
				projectListForHiddenId("projectName", "hiddenId"); //项目的联想框,及用隐藏域保存其id
				chart = new Highcharts.Chart({
					chart: {
						renderTo: 'container1',
						plotBackgroundColor: null,
						plotBorderWidth: null,
						plotShadow: false
					},
					title: {
						text: '人员-客户比例'
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
<body>
<%--固定的上部 --%>
<s:include value="body_up.jsp">
</s:include>	

<%--主体导航页头 --%>
<div class="title02" >项目客户比例</div>
<div class="right99"></div>
<div class="blueline"></div>

<div class="c"></div>
<div class="c"></div>

<%--主体table --%>
<table width="100%" border="0" align="left" cellspacing="0">

	<table width="100%" border="0" align="left" cellspacing="0">
	<form action="./customer_guangzhou/chart/userAndCustNum.action" method="post">
     <tr>
     
     	<td colspan="6">
     	&nbsp;项目<input type="text" id="projectName" name ="projectName"  value="${projectName}"/>
		<input type="hidden" id="hiddenId" name="custcond.projectId" value="${custcond.projectId}"/>
				<input type="hidden" name="proId" value="${proId }"/>
				&nbsp;日期<input class="Wdate" type="text" id="date1" style="width:90px" name="custcond.date1" value="${custcond.date1}"/>
				-
				<input class="Wdate" type="text" id="date2" style="width:90px" name="custcond.date2" value="${custcond.date2}"/>
		&nbsp;<s:submit value="  查询  " name="search" />	
		</form>
				
					
<div class="blueline"></div>	
<div class="gbox1">	
<table style="width:100%"><tr><td width="50%" valign="top">
<div class="gbox1">	
			  <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="text-align: center;">          
		   							   
              <tr class="gboxbg">			  	
				<td style="font-weight:bolder;">销售人员</td>    	
				<td style="font-weight:bolder;">录客数</td>    	
				<td style="font-weight:bolder;">录客比例</td>    	
				<td style="font-weight:bolder;">跟进数</td> 		
				<td style="font-weight:bolder;">跟进比例</td>
              </tr>
              
			<s:iterator value="custList" var="line"> 
              <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
              
              	
              	<td>
              	<s:if test="#line.realName == '合计'">
              		${realName }
              	</s:if><s:else>
              	<a class="ablue" style="color: #1199FF;" href="./customer_guangzhou/search/index.action?searchCond.projectId=${proId }&searchCond.date1=${custcond.date1}&searchCond.date2=${custcond.date2}&searchCond.saleId=${userId}" target="_self" >
             	  ${realName}</a></s:else>
              	 </td>
              	<td>${count }</td>
              	<td>${pei }</td>
            	 <td>${fol }</td>
            	 <td>${peifol }</td>
              </tr>   
              </s:iterator>   
	  </table>
	  
	  </div> 
	  </td>
			<td width="50%" valign="top">
		<div id="container1" style="width:100%;height:400px;"></div>
		</td></tr></table>
		  		
</div>
	  
		



</table>

<%--固定的底部 --%>
<s:include value="body_bottom.jsp">
</s:include>	
	</body>
</html>



   
   



