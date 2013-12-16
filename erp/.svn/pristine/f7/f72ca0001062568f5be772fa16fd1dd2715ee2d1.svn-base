<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


   
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head><s:include value="include/header.jsp"/>
<script type="text/javascript">
		
			var chart;
			$(document).ready(function() {
				
				chart = new Highcharts.Chart({
					chart: {
						renderTo: 'container',
						defaultSeriesType: 'line',
						marginRight: 130,
						marginBottom: 25
					},
					title: {
						text: '销售数据月统计',
						x: -20 //center
					},
					//subtitle: {
					//	text: 'Source: WorldClimate.com',
					//	x: -20
					//},
					xAxis: {
						//需要补充的x坐标
						categories: <s:property value="chartXAxis" escape="false"/>//['12-01', '11-02', '11-03', '11-04', '11-05', '11-06', 
							//'11-07', '11-07', '11-09', '11-10','11-11','11-12','11-13','11-14','11-15','11-16','11-17','11-18','11-19','11-20','11-21','11-22','11-23','11-24','11-25','11-26','11-27','11-28','11-29','11-30','11-31']
					},
					yAxis: {
						title: {
							text: '销售金额 (千元)'
						},
						plotLines: [{
							value: 0,
							width: 1,
							color: '#808080'
						}]
					},
					tooltip: {
						formatter: function() {
				                return '<b>'+ this.series.name +'</b><br/>'+
								this.x +': '+ this.y +'千元';
						}
					},
					legend: {
						layout: 'vertical',
						align: 'right',
						verticalAlign: 'top',
						x: -10,
						y: 100,
						borderWidth: 0
					},
					series: <s:property value="chartSeries"  escape="false"/> 
					
					
				});
				function doSearch(pId){				
					window.location.href = "report_hengda!salereportlist.action?projectId="+pId;
				}
				
			});
			
			
				
		</script>
<title>priv_func</title>
</head> 


<body>
<!-- top -->
<s:include value="include/top.jsp"></s:include>
<!-- top end -->

<!--main-->
<table width="100%" border="0" cellspacing="0">
<tr>

  <!--left begin-->
    <td width="213" valign="top">
	<s:include value="include/left.jsp"/>	
  </td>
  
  
<td width="9" valign="middle">
<img src="<%=basePath%>images/tianluan/arrow01.gif" width="9" height="90" border="0" id="img" class="img" title="点击收缩"/>
</td>
 <!--left.end-->
 
 
    <td width="100%" valign="top" height="100%" style="overflow:hidden;">
  	<div class="right01"></div>
    <div class="right02"></div>
    <div class="right03"></div>
    <div class="c"></div>
	
 <div>
    <div class="right04"></div>
    <div class="right05">
    <div class="titlel"></div>
    <!-- 菜单开始 -->
        <div class="titlebg" style=" height:auto;overflow:hidden;">
	    <div class="title02" ><a href="./report_hengda!salereportlist.action" target="_self">查看报表</a></div>
        
			  &nbsp;&nbsp;
		
<!--
            <div class="title02" style="display:none;"><a href="#">录入</a></div>
            <div class="title01"><a href="#">录入2</a></div>
            <div class="title02" style="display:none;"><a href="#">录入</a></div>
            <div class="title01"><a href="#">录入3</a></div>
            <div class="title02" style="display:none;"><a href="#">录入</a></div>
            <div class="title01"><a href="#">录入4</a></div>
            <div class="title02" style="display:none;"><a href="#">录入</a></div>
			-->
		<!-- 留一行 -->
          <div class="c"></div>
         <!-- 菜单结束 -->   
 <!-- 搜索表单 begin -->
  <form action="report_hengda!salereportlist.action" method="post">
	<table width="100%" border="0" align="left" cellspacing="0">
	<!-- 蓝色边条begin -->	
		 <tr>
              <td height="10" colspan="6">
              <div class="blueline"></div>
              </td>
        </tr>
<!-- 蓝色边条end -->			
       
	
		
	<!-- 蓝色边条begin -->	
      <tr>
              <td height="10" colspan="6">
              <div class="blueline"></div>
              </td>
       </tr>		
	<!-- 蓝色边条end -->			
	<!-- 搜索表单 end -->		
	
			
	
<!-- 列表 begin -->		
     <tr>
     	<td colspan="6">	
     	<label> <span>项目</span></label>
		<s:select list="selProject" name="saleMonitorCond.projectId" value="%{saleMonitorCond.projectId}" />
		<label> <span>日期</span></label>
		<input type="hidden" name="type" value="month"/>
		<input class="Wdate" type="text" id="date1" name="saleMonitorCond.date1" style="width:90px" value="${saleMonitorCond.date1}" onClick="WdatePicker()"/>
				-
		<input class="Wdate" type="text" id="date2" name="saleMonitorCond.date2" style="width:90px" value="${saleMonitorCond.date2}" onClick="WdatePicker()"/>
		
		<input type="submit" value="  搜索  " id="searchSubmit" onclick=""/>		  
		<div class="gbox1">	
		<div id="container" style="width: 100%; height:600px; margin: 0 auto"></div>
		  		
</div>

</td>
 </tr>
<!-- 列表 end -->

 <tr>
              <td colspan="6">
                <div class="manu">
					<s:property value="showPage" escape="false"/>
				</div>                
			</td>
            </tr>
 </table>
 </form>
</div>
    <div class="titler"></div>
    <div class="c"></div>
    </div>
    <div class="right06"></div>
    <div class="c"></div>
    </div>
    <div class="right07"></div>
    <div class="right08"></div>
    <div class="right09"></div>
    <div class="c" ></div>
    </td>
  </tr>
  <tr>
    <td height="5" colspan="3">
    </td>
  </tr>
</table>
<s:include value="include/bottom.jsp"></s:include>
</body>
</html>
   
   
   



