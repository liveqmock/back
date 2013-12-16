<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>主页</title>
	
	<link href="css/hengda.css"  rel="stylesheet" type="text/css" charset="utf-8"/>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" /> 
	
	<script type="text/javascript">

	
	$(document).ready(function() {
		$("#show").click(function(){ 

		var options = {
			    chart: {
			        renderTo: 'container',
			        defaultSeriesType: 'line'
			    },
			    title: {
			        text: '报表'
			    },
			    xAxis: {
			    	type:"datetime",//时间轴要加上这个type，默认是linear
			        categories: []
			    },
			    yAxis: {
			        title: {
			            text: '数量'
			        }
			    },
			    tooltip: {
					formatter: function() {
			                return '<b>'+ this.series.name +'</b><br/>'+
							this.x +': '+'<br/>数量:' +this.y ;
					}
				},
			    series: []
			};
		alert();
		$.get("report_sale_hengda!loadlist.action",function(data) {
			
		    $.each(data, function(lineNo, line) {
		    	var series = {
		            		data:[]
		            };
  	          		series.name = lineNo;
   					
		                 //字符分隔，变成数组 
		                 linedata= line.split(',');
		                 //遍历
		                 $.each(linedata,function(i,value){
		                	 series.data.push(parseInt(linedata[i]));
		                 });
		               //  options.xAxis.categories={new Date()}
		                  options.series.push(series);
		    });
		   
		    var chart = new Highcharts.Chart(options);
			});
		 });
	});
	 
		
</script>

</head>
	
  
  <body >
   
   
<!--main-->
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1">
  <tr>
  
 	<!--left.top-->
	
	<s:include value="../left.jsp"></s:include>

    <!--left.end-->	
  
    <td width="100%" valign="top" height="100%" style="overflow:hidden;">
    <div class="right01"></div>
    <div class="right02"></div>
    <div class="right03"></div>
    <div class="c"></div>
	
    <div >
    <div class="right04"></div>
    <div class="right05">
      <div class="titlel"></div>
	  
        <div class="titlebg" style=" height:auto;overflow:hidden;">	
		
        	
	        
        			
			
		
		
		<!-- right form top -->
	
			
          <div class="c"></div>
          <div class="c">
		  	  &nbsp;&nbsp;	
	
		  </div>
		  	<div id="container" style="width: 800px; height: 400px; margin: 0 auto"></div>
		  	<input type="button" id="show"  value="show"/>
           </form>
	  
	  
			  <div class="c"></div>
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
	  <!--main.end-->
	  <tr>
		<td height="5" colspan="3">
		</td>
	  </tr>
	</table>
	   
   
  </body>
</html>
