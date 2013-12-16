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
    
    <title>主页</title>
	
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

	        <div class="title02" style="width:auto"><a href="./sale_hengda!searchSaleFromType.action?type=all" target="_self">在售数据累计汇总(暂时没有使用,页面还没有调好)</a></div>
			&nbsp;&nbsp;
			<font color="#FF0000"><span id="suggestion"><s:property value="#request.suggestion"/></span></font>
			<!--
            <div class="title02" style="display:none;"><a href="#">录入</a></div>
            <div class="title01"><a href="#">录入2</a></div>
            <div class="title02" style="display:none;"><a href="#">录入</a></div>
            <div class="title01"><a href="#">录入3</a></div>
            <div class="title02" style="display:none;"><a href="#">录入</a></div>
            <div class="title01"><a href="#">录入4</a></div>
            <div class="title02" style="display:none;"><a href="#">录入</a></div>
			-->
			
			
          <div class="c"></div>
          <div class="c"></div>
		  
		  
         
           <table width="100%" border="0" align="left" cellspacing="0">
		  
		  <!-- 搜索表单 top -->
       
       <form action="./sale_hengda!searchSaleFromType.action" method="get">
	   		 <tr style="white-space:nowrap">
			  <td width="3%" height="0" align="center"><label> <span>日期</span></label></td>
              <td height="0" colspan="2">
			  	<input type="hidden" name="type" value="all"/>
			  	<input class="Wdate" type="text" id="monitorDate" name="saleAllCond.monitorDate" style="width:90px" value="${saleAllCond.monitorDate}" onClick="WdatePicker()"/>
				&nbsp;&nbsp;
				<input type="submit" value="  搜索  " id="searchSubmit" onClick="return checkAll();"/>
				&nbsp;&nbsp;
				(搜索汇总数据,包括今天)			  </td>  			 
            </tr>
		</form>
		  
		<!-- 搜索表单 end -->
		
		 <tr>
              <td height="10" colspan="6">
              <div class="blueline"></div>              </td>
              </tr>					
	
	
   <tr >
         <td colspan="6">			  
			  
	  <!--  列表 top -->	
		
	 <div class="gbox1">
	   <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" >
         <tr class="gboxbg">
           <td colspan="3"></td>
           <td align="center" valign="middle" colspan="8">累计总数据</td>
         </tr>
         <tr class="gboxbg" align="center">
           <td width="150">销售公司</td>
           <td width="70">项目序号</td>
           <td width="150">项目名称</td>
           <td width="100" align="center" valign="middle">日期</td>
           <td width="100" align="center" valign="middle">住宅(套)</td>
           <td width="100" align="center" valign="middle">商铺(个)</td>
           <td width="100" align="center" valign="middle">车位(个)</td>
           <td width="100" align="center" valign="middle">临定(套)</td>
           <td width="100" align="center" valign="middle">累计总面积(m<sup>2</sup>)</td>
           <td width="100" align="center" valign="middle">累计总金额(千元)</td>
           <td width="100" align="center" valign="middle">当日认筹(次)</td>
         </tr>
         <s:iterator value="#request.showSaleAllList" id="c">
           <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
             <td align="center" valign="middle"><s:property value="#c.descCompanyName"/>             </td>
             <td align="center" valign="middle"><s:property value="#c.descProjectOrderIndex"/>             </td>
             <td align="center" valign="middle"><s:property value="#c.descProjectName"/>             </td>
             <td align="center" valign="middle"><s:property value="#c.aHouseNum"/>             </td>
             <td align="center" valign="middle"><s:property value="#c.aShopNum"/>             </td>
             <td align="center" valign="middle"><s:property value="#c.aParkNum"/>             </td>
             <td align="center" valign="middle"><s:property value="#c.aTempNum"/>             </td>
             <td align="center" valign="middle"><s:property value="#c.aCompleteArea"/>             </td>
             <td align="center" valign="middle"><s:property value="#c.aCompleteMoney"/>             </td>
             <td align="center" valign="middle"><s:property value="#c.aCompleteMoney"/>             </td>
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
