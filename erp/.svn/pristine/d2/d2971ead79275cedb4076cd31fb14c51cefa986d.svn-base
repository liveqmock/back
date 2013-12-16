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
	
  </head>
  
  <body onLoad="clearSuggestion()">
   
   
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
		
        	
	        <div class="title01" ><a href="./sale_hengda!searchSale.action?from=left" target="_self">查询在售数据</a></div>
            <div class="title02"><a href="./sale_hengda!doSomeForAddSale.action?from=hengda" target="_self">新建在售数据</a></div>			
			   <div class="right99"></div>
			<div class="blueline"></div>
		
		
		<!-- right form top -->
	<form class="registerform" action="<%=request.getContextPath() %>/sale_hengda!addSale.action" method="post" >	
			
          <div class="c"></div>
          <div class="c">
		  	  &nbsp;&nbsp;	
			<font color="#FF0000"><span id="suggestion"><s:property value="#session.suggestion"/></span></font>
			
		  </div>
		  
		  	  
		  
           <table width="50%" border="0" align="left" cellpadding="0" cellspacing="1" class="gbox" >
		   
		   	<tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td width="16%" id="t15" align="center">日期</td>
                <td width="32%" id="t16" nowrap="nowrap">
				&nbsp;<input type="text" class="Wdate" onClick="WdatePicker()" id="monitorDate"  name="saleMonitor.monitorDate"
					value="${now}" style="width:90px" />
				<!--
				<input type="hidden" name="saleMonitor.monitorDate" value="${now}"/>
				-->
				</td>
				
				 <td id="t7" align="center">车位</td>
                 <td id="t12">
				 	&nbsp;<input type="text" name="saleMonitor.parkNum" id="parkNum" class="leftcreateinputbox02" style="width:70px"/>
					个
				</td>
                            		
              </tr>
		   
			  
			  
             <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t13" align="center">来电</td>
                <td id="t14">
					&nbsp;<input type="text" name="saleMonitor.phoneNum" id="phoneNum" class="leftcreateinputbox01" style="width:70px"/>
					次				</td>  
					
                <td id="t13" align="center">来访</td>
                <td id="t14">
					&nbsp;<input type="text" name="saleMonitor.visitorNum" id="visitorNum" class="leftcreateinputbox01" style="width:70px"/>
					人				</td>
              </tr>
			  
			  
			  
             <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t11" align="center">住宅</td>
                <td id="t12">
					&nbsp;<input type="text" name="saleMonitor.houseNum" id="houseNum" class="leftcreateinputbox02" style="width:70px"/>
					套				</td>
                <td id="t11" align="center">商铺</td>
                <td id="t12">
					&nbsp;<input type="text" name="saleMonitor.shopNum" id="shopNum" class="leftcreateinputbox02" style="width:70px"/>
					个				</td>
              </tr>
             
			 
              <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td width="18%" id="t15" align="center">挞订</td>
                <td width="34%" id="t16">&nbsp;<input type="text" name="saleMonitor.rescissionNum" id="rescissionNum" class="leftcreateinputbox02" style="width:70px"/>
					套				</td>    
					
                <td id="t9" align="center">临定</td>
                <td id="t10">&nbsp;<input type="text" name="saleMonitor.tempNum" id="tempNum" class="leftcreateinputbox02" style="width:70px"/>
					套				</td>
              </tr>
			  
			   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                 <td id="t7" align="center">齐定面积</td>
                 <td id="t8">
					&nbsp;<input type="text" name="saleMonitor.completeArea" id="completeArea" class="leftcreateinputbox02" style="width:70px" value="0"/>
					m<sup>2</sup>		
				</td>
				<td id="t7" align="center">齐定金额</td>
                <td id="t8">
					 &nbsp;<input type="text" name="saleMonitor.completeMoney" id="completeMoney" class="leftcreateinputbox02" style="width:70px" value="0"/>
					千元				</td>               
              </tr>
			  
			   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                 <td id="t7" align="center">当日认筹</td>
                 <td id="t8">
					&nbsp;<input type="text" name="saleMonitor.intentionNum" id="intentionNum" class="leftcreateinputbox02" style="width:70px"/>个						
				</td>
				<td id="t7" align="center"></td>
                <td id="t8"></td>               
              </tr>
		 
	  
		  <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"; align="center">
			<td colspan="4">
			  <input type="submit" value="  保存  " id="sub"/>
			  <input type="button" value="  取消  " onClick="javascript:window.location.href = './sale_hengda!searchSale.action?from=return'" />			
			 
			  </td>
		  </tr>
	  </table>
	  
	  </form>
	  
	  
			  <div class="c"></div>
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
