

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
				$("#customerCond_companyId").change(function(){
					companyToProject(this.value, "customerCond_projectId");
				});				
			});
				
		</script>
<title>单项数据分析表</title>
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

								<div class="title02" ><a href="./sale_hengda/chart/customerTable.action?from=left" target="_self">单项数据分析表</a></div>

										<div class="right99"></div>
										<div class="blueline"></div>

										<div class="c"></div>
										<div class="c"></div>

			<table width="100%" border="0" align="left" cellspacing="0">

											<!-- 搜索表单 top -->

	 	
				
	
 <form class="registerform" action="<%=request.getContextPath() %>/sale_hengda/chart/customerTable.action" method="post" >
 
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
		
		<label>&nbsp;<span>分析类型</span></label>
		<s:select list="listSelCategory" name="selCategory" value="%{selCategory}" />			
				

		<s:submit value="  查询  " name="search" />	
		
		<a style="color:#1199FF;" href='<s:property value="urlCategoryNum"  escape="false"/>'>环比走势</a>&nbsp;
		<a style="color:#1199FF;" href='<s:property value="urlPie"  escape="false"/>'>比例分析</a>&nbsp;
		<a style="color:#1199FF;" href="./customer_guangzhou/chart/downLoad.action">下载</a>&nbsp;
		
		<div class="blueline"></div>	

</td>
 </tr>
 
 </form>
 	<%-- 搜索表单 end --%>				
 
  			<tr>
              <td colspan="6">			  
			  
			  	<div class="gbox1">	
				<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="text-align: center;">          
		   							   
					  <tr class="gboxbg">			  	
						<td style="font-weight:bolder;">日期</td>     
				<s:iterator value="listDate" var="date">    
					<td title='<s:property value="#date[0]"/>'><s:property value="#date[1]"/></td>        
				</s:iterator>  				
					  </tr>
									   
					  <tr  class="gboxbg">			  	
						<td style="font-weight:bolder;">星期</td>     
				<s:iterator value="listDate" var="date">    
					<td title='<s:property value="#date[0]"/>'><s:property value="#date[2]"/></td>        
				</s:iterator>  				
					  </tr>
								
				 
			<s:iterator value="listMainTable" var="line"> 
				<tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>      
					<s:iterator value="#line" var="lineTd">  
					<td><s:property value="#lineTd"/></td>      
					</s:iterator>  
				</tr>      
			</s:iterator>    
		
				 
			  </table>
			</div>


			</td>
           </tr>
 
 
		<tr>
              <td colspan="6">
			  
			  <div class="gbox1">	
		<table style="width:100%">
			<tr>
				<td width="50%">

				<div class="gbox1">	
				 <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="text-align: center;">          
												   
						  <tr class="gboxbg">			  	
							<td style="font-weight:bolder;">类别</td>    	
							<td style="font-weight:bolder;">小计</td>    	
							<td style="font-weight:bolder;">比例</td>    			
						  </tr>
						  
					<s:iterator value="listSumTable" var="line"> 
						  <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" style="height:28px;" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>  
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
			</td>
		</tr>		
		</table>		  		
		</div>
                          
			</td>
            </tr>

 </table>
								 </table>


										
										
								</td>
								<%-- 基本table分割 ^^^^^^^^^^^^^^^^^end^^^</td>^^^^^^^^^^^^^^^^^^^^^--%>
							</tr>
					  </table>
					</td>
				</tr>
			</tbody>

		</table>

	</body>
</html>



   
   



