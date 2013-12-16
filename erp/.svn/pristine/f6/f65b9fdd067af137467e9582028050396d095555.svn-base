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
		<title>项目客户量比例</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<style>
		* {margin:0;padding:0;}
		</style>
		<s:include value="header.jsp"></s:include>	
		<s:include value="header_left_js.jsp"></s:include>	
		<script type="text/javascript" src="<%=basePath%>js/highcharts.js"></script>
		<script type="text/javascript" src="<%=basePath%>js/ui_fix.js"></script>
		
			<script type="text/javascript" src="<%=basePath%>/js/userAccount-hengda.js" ></script>
		<script type="text/javascript" src="<%=basePath%>js/customer_guangzhou.js"></script>
		
		
		<script type="text/javascript" language="javascript" src="<%=basePath%>js/customer_guangzhou_project.js"></script>	
		<script type="text/javascript">
			var chart;
			$(document).ready(function() {
				projectListForHiddenId("projectName", "hiddenId"); //项目的联想框,及用隐藏域保存其id
				$("#formweek").click(function(){
					$("#datetype").val("week");
					$("form:first").submit(); 
					return false;
					});

				$("#formmonth").click(function(){
					$("#datetype").val("month");
					$("form:first").submit(); 
					return false;
					});
				
				chart = new Highcharts.Chart({
					chart: {
						renderTo: 'container1',
						plotBackgroundColor: null,
						plotBorderWidth: null,
						plotShadow: false
					},
					title: {
						text: '项目-客户比例'
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
<div class="title02" ><a href="./customer_guangzhou/chart/projectAndCustNum.action"  target="_self">项目客户比例</a></div>
<div class="right99"></div>
<div class="blueline"></div>

<div class="c"></div>
<div class="c"></div>

<%--主体table --%>
<table width="100%" border="0" align="left" cellspacing="0">
	
     <tr>
     
     	<td colspan="6">	
     		
		<form action="./customer_guangzhou/chart/projectAndCustNum.action" method="post">
			&nbsp;项目<input type="text" id="projectName" name ="projectName"  value="${projectName}"
			<s:if test="#request.ttt == 'yes'">disabled="disabled"</s:if>
			/>
		
			<input type="hidden" id="hiddenId" name="cond.projectId" value="${cond.projectId }"/>	
			<input type="hidden" id="datetype" name="datetype"/>
			&nbsp;	
			日期<input class="Wdate" type="text" id="date1" style="width:90px" name="cond.date1" value="${cond.date1}"/>
			-
			<input class="Wdate" type="text" id="date2" style="width:90px" name="cond.date2" value="${cond.date2}"/>
			&nbsp;<a id="formweek" href="#" style="color: #1199FF;" class="ablue">本周</a>
			&nbsp;<a id="formmonth" href="#" style="color: #1199FF;" class="ablue">本月</a>
			&nbsp;<s:submit value="  查询  " name="search" />	
		</form>
			<%--
				<a style="color:#1199FF;" href="<s:property value="urlPie"  escape="false"/>">比例分析</a>&nbsp;
				<a style="color:#1199FF;" href="<s:property value="urlTable"  escape="false"/>">分析表</a>
				
			--%>
		<div class="blueline"></div>	
		
		<div class="gbox1">	
		<table style="width:100%">
		
		<tr>
			<td width="50%" valign="top">
		

			<div class="gbox1">	
			  <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="text-align: center;">          
		   							   
              <tr class="gboxbg">			  	
				<td style="font-weight:bolder;">项目</td>    	
				<td style="font-weight:bolder;">客户量</td>    	
				<td style="font-weight:bolder;">比例</td>  
				 <td></td>	
              </tr>
			  
			  <s:iterator value="custList" var="line"> 
              <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>  
              
              	
              	<s:if test="#line.projectName == '合计' || #request.tt == 'yes'">
              		<td>${projectName }</td>
              	</s:if>
              	<s:else>
              	<td>
				<a  href="./customer_guangzhou/chart/userAndCustNum.action?proId=${projectId }&custcond.date1=${cond.date1}&custcond.date2=${cond.date2}" target="_self" class="ablue" style="color: #1199FF;">${projectName }
              	 </a> </td>
              	</s:else>
				
              	<td>${count }</td>
              	<td>${pei }</td>
				
              	<td>
              	
					<s:if test="#line.projectName == '合计'">
					
					</s:if>
					<s:else>
              		<a class="ablue" style="color: #1199FF;" href="./customer_guangzhou/chart/customerNum.action?customerCond.date1=${cond.date1}
              		&customerCond.date2=${cond.date2}&customerCond.projectId=${projectId }" target="_self">客户数量环比</a>
              			</s:else>
              	</td>
            
              </tr>   
              </s:iterator>   
			                
			
	 		 </table>
	    	</div>
			
			</td>
			
			<td width="50%">
				<div id="container1" style="width:100%;height:400px;"></div>
			</td>
			
			</tr>
		
		</table>
		  		
		</div>
		

</td>
 </tr>


</table>

<%--固定的底部 --%>
<s:include value="body_bottom.jsp">
</s:include>	
	</body>
</html>



   
   



