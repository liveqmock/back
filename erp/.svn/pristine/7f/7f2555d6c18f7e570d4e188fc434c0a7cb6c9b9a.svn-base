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
    
    <title>在售数据汇总</title>
	
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
    <div >
    <div class="right04"></div>
    <div class="right05">
      <div class="titlel"></div>
       <div class="titlebg" style=" height:auto;overflow:hidden;">

	        <div class="title02" ><a href="./sale_hengda!searchSaleAll.action?from=left" target="_self">在售数据汇总</a></div>
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
		  
		  
         
          <table style="table-layout: fixed; width: auto; overflow:scroll" align="left" border="0" cellspacing="0" width="98%">		

		  
		  <!-- 搜索表单 top -->
       
       <form action="./sale_hengda!searchSaleAll.action" method="get">
	   		 <tr style="white-space:nowrap">
			  <td width="3%" height="0" align="center"><label> <span>日期&nbsp;</span></label></td>
              <td height="0" nowrap="nowrap" width="auto" colspan="5">
			  	&nbsp;<input class="Wdate" type="text" id="date1" style="width:90px" name="saleCond.date1" value="${saleCond.date1}" onClick="WdatePicker()"/>
				-
				<input class="Wdate" type="text" id="date2" style="width:90px" name="saleCond.date2" value="${saleCond.date2}" onClick="WdatePicker()"/>
				&nbsp;<input type="submit" value="  搜索  " id="searchSubmit" onClick="return check();"/>
				&nbsp;<a href="./sale_hengda!downLoadAll.action">下载数据</a>
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
		
	<div class="gbox1" style="left:0; overflow:scroll;display: inline;width:1050px; float:left;">			  
	<table class="gbox" style="table-layout: fixed; width: 930px; font-size: 12px;white-space:nowrap" align="center" border="0" cellpadding="0" cellspacing="1">	
	
	
  <tr class="gboxbg" nowrap="nowrap">
    <td width="350px" colspan="3"></td>
	  
	<td width="950px" align="center" valign="middle" colspan="10">当天数据</td>

	<td width="900px" align="center" valign="middle" colspan="7">本月数据</td>
		
	<td width="750px" align="center" valign="middle" colspan="7">累计总数据</td>
	
	<td width="20px" align="center" valign="middle"></td>
		
  </tr>
	
  <tr class="gboxbg" align="center" nowrap="nowrap">
    <td width="150">销售公司</td>
    <td width="50">项目序号</td>
    <td width="150">项目名称</td>
	  
	 
	<td width="200" align="center" valign="middle" title="">
		日期	</td>
	<td width="50" align="center" valign="middle" title="">来电(次)</td>
	<td width="50" align="center" valign="middle" title="">
		来访(人)	</td>
	<td width="50" align="center" valign="middle" title="">住宅(套)</td>
	<td width="50" align="center" valign="middle">
		商铺(个)	</td>
	<td width="50" align="center" valign="middle">
		车位(个)	</td>
	<td width="50" align="center" valign="middle">
		临定(套)	</td>
	<td width="150" align="center" valign="middle">
		齐定面积(m<sup>2</sup>)</td>
	<td width="150" align="center" valign="middle">齐定金额(千元)</td>
	<td width="150" align="center" valign="middle">当日认筹(次)</td>
		
		
	<td width="50" align="center" valign="middle">住宅(套)</td>
	<td width="50" align="center" valign="middle" title="">商铺(个)</td>
	<td width="50" align="center" valign="middle" title="">车位(个)</td>
	<td width="50" align="center" valign="middle">临定(套)</td>
	<td width="100" align="center" valign="middle" nowrap="nowrap">本月成交面积(m<sup>2</sup>)</td>
	<td width="150" align="center" valign="middle" nowrap="nowrap">本月成交金额(千元)</td>
	<td width="150" align="center" valign="middle">本月认筹(次)</td>
		
	<td width="50" align="center" valign="middle">住宅(套)</td>
	<td width="50" align="center" valign="middle" title="">商铺(个)</td>
	<td width="50" align="center" valign="middle" title="">车位(个)</td>
	<td width="50" align="center" valign="middle">临定(套)</td>
	<td width="100" align="center" valign="middle" nowrap="nowrap">累计总面积(m<sup>2</sup>)</td>
	<td width="100" align="left" valign="middle" nowrap="nowrap">累计总金额(千元)</td>
	<td width="150" align="center" valign="middle">累计认筹(次)</td>
	
	<td width="20px" align="center" valign="middle"></td>
	  	 
  </tr>
  
   <s:iterator value="#request.showSaleAllList" id="c">
	   <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" nowrap="nowrap"> 
		
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
				<s:property value="#c.phoneNum"/>
			</td>
			<td align="center" valign="middle">
				<s:property value="#c.visitorNum"/>
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
			
			<td align="center" valign="middle">
				<s:property value="#c.houseNum_m"/>
			</td>
			<td align="center" valign="middle">
				<s:property value="#c.shopNum_m"/>
			</td>
			<td align="center" valign="middle">
				<s:property value="#c.parkNum_m"/>
			</td>
			<td align="center" valign="middle">
				<s:property value="#c.tempNum_m"/>
			</td>
			<td align="center" valign="middle">
				<s:property value="#c.completeArea_m"/>
			</td>
			<td align="center" valign="middle">
				<s:property value="#c.completeMoney_m"/>
			</td>
			<td align="center" valign="middle">
				<s:property value="#c.intentionNum_m"/>
			</td>
			
			<td align="center" valign="middle">
				<s:property value="#c.houseNum_a"/>
			</td>
			<td align="center" valign="middle">
				<s:property value="#c.shopNum_a"/>
			</td>
			<td align="center" valign="middle">
				<s:property value="#c.parkNum_a"/>
			</td>
			<td align="center" valign="middle">
				<s:property value="#c.tempNum_a"/>
			</td>
			<td align="center" valign="middle">
				<s:property value="#c.completeArea_a"/>
			</td>				
			<td align="center" valign="middle">
				<s:property value="#c.completeMoney_a"/>
			</td>
			<td align="center" valign="middle">
				<s:property value="#c.intentionNum_a"/>
			</td>
			
			<td width="50px" align="center" valign="middle"></td>
		
	  </tr>
   </s:iterator>
   
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
    <td height="5" colspan="3">
    </td>
  </tr>
  
 
  
</table>

   
   
   
  </body>
</html>
