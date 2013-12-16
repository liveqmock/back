<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>在售数据周查询</title>
	
	<link href="css/hengda.css"  rel="stylesheet" type="text/css" charset="utf-8"/>
	
	<meta http-equiv=Content-Type content="text/html; charset=utf-8" /> 
	
	<style type="text/css">
        .FixedTitleRow
        {
            position: relative;
            top: expression(this.offsetParent.scrollTop);
            z-index: 10;
        }

        .FixedTitleColumn
        {
            position: relative;
            left: expression(this.parentElement.offsetParent.scrollLeft);
        }

        .FixedDataColumn
        {
            position: relative;
            left: expression(this.parentElement.offsetParent.parentElement.scrollLeft);
        }
        .td{width:100px;overflow:hidden}
    </style>


  </head>
  
  <body onLoad="clearSuggestion()">
   
   

<!--main-->
<table width="100%" border="0" cellspacing="0">
  <tr>
  
  	<!--left.top-->
	
	<s:include value="../left.jsp"></s:include>

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
       <div class="titlebg" style=" height:auto;overflow:hidden;">

	        <div class="title02" ><a href="./sale_hengda!searchSaleFromType.action?type=week" target="_self">在售数据周查询</a></div>
	           <div class="right99"></div>
			<div class="blueline"></div>
			
			<%-- 
			&nbsp;&nbsp;
			<font color="#FF0000"><span id="suggestion"><s:property value="#request.suggestion"/></span></font>
            <div class="title02" style="display:none;"><a href="#">录入</a></div>
            <div class="title01"><a href="#">录入2</a></div>
            <div class="title02" style="display:none;"><a href="#">录入</a></div>
            <div class="title01"><a href="#">录入3</a></div>
            <div class="title02" style="display:none;"><a href="#">录入</a></div>
            <div class="title01"><a href="#">录入4</a></div>
            <div class="title02" style="display:none;"><a href="#">录入</a></div>
			--%>
			
			
          <div class="c"></div>
          <div class="c"></div>
		  
		  
         
          <table width="100%" border="0" align="left" cellspacing="0">	
		  
		  <!-- 搜索表单 top -->
       
       <form action="./sale_hengda!searchSaleFromType.action" method="get">
	   		 <tr style="white-space:nowrap" >
			  <td width="3%" height="0" align="left"><label> <span>日期</span></label></td>
              <td height="0" colspan="2">
			  	<input type="hidden" name="type" value="week"/>
			  	<input class="Wdate" type="text" id="date1" name="saleWeekCond.date1" style="width:90px" value="${saleWeekCond.date1}" onClick="WdatePicker()"/>
				-
			  	<input class="Wdate" type="text" id="date2" name="saleWeekCond.date2" style="width:90px" value="${saleWeekCond.date2}" onClick="WdatePicker()"/>
				&nbsp;
				<label> <span>项目</span></label>
				&nbsp;
				<s:select list="selProject" name="saleWeekCond.projectId" value="#session.projectId"/>
				&nbsp;&nbsp;
				<input type="submit" value="  搜索  " id="searchSubmit" onClick="return check();"/>				
				&nbsp;<a href="./sale_hengda!downLoadWeek.action">下载数据</a>
			  </td>  			 
			 
            </tr>
	   
		</form>
		  
		<!-- 搜索表单 end -->
		
		 <tr>
              <td height="10" colspan="6">
              <div class="blueline"></div>
              </td>
         </tr>					
	
	
   		<tr >
         	<td colspan="6">			  
			  
	  <!--  列表 top -->	
		
	 <div class="gbox1">			  
			  
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="white-space:nowrap">
	
	  <tr class="gboxbg">
		<td colspan="3"></td>
		  
		<td align="center" valign="middle" colspan="9">本周数据</td>
			
	
			
	  </tr>
		
  <tr class="gboxbg" align="center" style="white-space:nowrap">
   	<td width="150">销售公司</td>
    <td width="70">项目序号</td>
    <td width="150">项目名称</td>
		
	<td width="100" align="center" valign="middle">日期</td>
	<td width="100" align="center" valign="middle">住宅(套)</td>
	<td width="100" align="center" valign="middle" title="">商铺(个)</td>
	<td width="100" align="center" valign="middle" title="">车位(个)</td>
	<td width="100" align="center" valign="middle">挞定(套)</td>
	<td width="100" align="center" valign="middle">临定(套)</td>
	<td width="100" align="center" valign="middle" nowrap="nowrap">成交面积(m<sup>2</sup>)</td>		
	<td width="100" align="center" valign="middle" nowrap="nowrap">成交金额(千元)</td>
	<td width="100" align="center" valign="middle">当日认筹(次)</td>
		
		  	 
  </tr>
  
   <s:iterator value="#request.saleWeekList" id="c">
	   <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"> 
		
			<td align="center" valign="middle">
				<s:property value="#c.descCompanyName"/>
			</td>
			<td align="center" valign="middle">
				<s:property value="#c.descProjectOrderIndex"/>
			</td>
			<td align="center" valign="middle">
				<s:property value="#c.descProjectName"/>
			</td>
			
			
			<td align="center" valign="middle">
				<s:date name="#c.monitorDate" format="yyyy-MM-dd "/>
			</td>
			<td align="center" valign="middle">
				<s:property value="#c.houseNum"/>
			</td>
			<td align="center" valign="middle">
				<s:property value="#c.shopNum"/>
			</td>
			<td align="center" valign="middle">
				<s:property value="#c.parkNum"/>
			</td>
			<td align="center" valign="middle">
				<s:property value="#c.rescissionNum"/>
			</td>
			<td align="center" valign="middle">
				<s:property value="#c.tempNum"/>
			</td>
			<td align="center" valign="middle">
				<s:property value="#c.completeArea"/>
			</td>
			<td align="center" valign="middle">
				<s:property value="#c.completeMoney"/>
			</td>
			<td align="center" valign="middle">
				<s:property value="#c.intentionNum"/>
			</td>
								
	  </tr>
   </s:iterator>
   
   <tr class="gboxbg" align="center" style="white-space:nowrap">
		<td colspan="3"></td>
		<td>合计</td>
		<td>${amount.houseNum}</td>
		<td>${amount.shopNum}</td>
		<td>${amount.parkNum}</td>
		<td>${amount.rescissionNum}</td>
		<td>${amount.tempNum}</td>
		<td>${amount.completeArea}</td>
		<td>${amount.completeMoney}</td>
		<td>${amount.intentionNum}</td>
	</tr>
   
</table>
</div>

<!-- 列表 end --></td>
            </tr>
			
			<!--
            <tr>
              <td colspan="6">
                <div class="manu">
					<s:property value="showPage" escape="false"/>
				</div>
				</td>
            </tr>
			-->
			
            </table>
        </div>
        <div class="titler"></div>
        <div class="c"></div>
    </div>
    <div class="right06"></div>
    <div class="c"></div>
    </div>
   <div class="right01"></div>
	<div class="right02"></div>
	<div class="right03"></div>
	<div class="c"></div>
    </td>
  </tr>
  <!--main.end-->
  <tr>
    <td height="5" colspan="6">
    </td>
  </tr>
  
 
  
</table>

   
   
   
  </body>
</html>
