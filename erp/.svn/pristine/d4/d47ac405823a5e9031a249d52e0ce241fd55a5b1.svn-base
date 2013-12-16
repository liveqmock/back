<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
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
		
		<title>录入数据</title>

	<script language="javascript" type="text/javascript">
	
		if(<s:property value="#request.saleMonitorId"/>!=0){
			location.href = "<%=path%>/sale_hengda/update/for_sale.action?id="+<s:property value="#request.saleMonitorId"/>;
		}
	
	</script>	
	<style>
	.leftcreateinputbox01x{
	border:solid 1px red
	}
	</style>	
	</head>
	<body onload="clearSuggestion()">
		<table width="100%" border="0" align="left" cellspacing="0" >
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
				<tr>
					<td valign="top">
						<s:include value="include/left.jsp">
						</s:include>
					</td>
					<td width="100%" valign="top"  >
		 	<DIV style="WIDTH: 98%; HEIGHT: 100%; BACKGROUND-COLOR: #A4C3D7;padding: 1px">
		  	<%-- 基本table分割 ^^^^^^<td width="100%">^^^^^^^^^^^^^^^^^^^^^^--%>
						<%--main table开始 --%>
<!--main-->
<table width="100%" class="mainbg20111112" id="showtable"style="height: 100%; white-space: nowrap;" >

  <tr>
  
    <td width="100%" valign="top" height="100%" style="overflow:hidden;">
   
      <div class="titlel"></div>
	  
        <div class="titlebg" style=" height:auto;overflow:hidden;">	
		
        	
	        <div class="title01" ><a href="./sale_hengda/search/sale.action?from=left" target="_self">明细查询</a></div>
            <div class="title02"><a href="./sale_hengda/input/for_sale.action" target="_self">录入数据</a></div>			
			
		   <div class="right99"></div>
			<div class="blueline"></div>
		
		<!-- right form top -->
		<form class="registerform" id ="registerform" action="./sale_hengda/input/sale.action" method="post" >	
			
          <div class="c"></div>
          <div class="c" >           
		  </div>
		 
           <table width="750" border="0" align="left" cellpadding="0" cellspacing="1" class="gbox"  style="margin-top:10px;_margin-top:0px;*margin-top:0px;">
		   	<tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
			<td width="78" align="center" id="t15"  >日期</td>
	                <td width="152" nowrap="nowrap" id="t16" >&nbsp;<input type="text" class="Wdate" onClick="WdatePicker()"  id="monitorDate"  value="${now}" style="width:90px" disabled="disabled" title="只能录入当天数据"/>
				<input type="hidden" name="saleMonitor.monitorDate" value="${now}"/></td>
				<td id="t7" align="center">当前时间</td>
                <td id="t15" nowrap="nowrap" >&nbsp;<font size="3" color="#FF0000" id="nowTime">${time}</font>
				</td>
			</tr>
		   	<tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
			
				 <td width="78" align="center" id="t15">来电</td>
                <td width="152" nowrap="nowrap" id="t16">&nbsp;<input type="text" value="0" name="saleMonitor.phoneNum" id="phoneNum" class="leftcreateinputbox02" style="width:70px"/>组</td>
                <td width="190" align="center" id="t15">来访</td>
			  <td width="192" nowrap="nowrap" id="t16" >&nbsp;<input type="text" value="0" name="saleMonitor.visitorNum" id="visitorNum" class="leftcreateinputbox02" style="width:70px"  />个</td>
				 </tr>
				 
				<tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
				
				  <td id="t7" align="left" colspan="4"> &nbsp;预售项目填写,今天认筹了
				    <input type="text" value="0" name="saleMonitor.intentionNum" id="intentionNum" class="leftcreateinputbox02" style="width:70px"/>次</td>           
				</tr>
				<!-- <td id="t7" align="center">车位</td>
                 <td id="t12">
				 	&nbsp;<input type="text" value="0" name="saleMonitor.parkNum" id="parkNum" class="leftcreateinputbox02" style="width:70px"/>
					个
				</td>-->
				
			  <tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td></td>
                <td id="t14">成交套数</td>
                <td id="t14">
					成交面积(㎡)</td>  
				<td id="t14">
					成交金额(元)</td> 
					
              	<!-- <td id="t13" align="center">退挞定套数</td>
                <td id="t14">
					退挞定面积</td> -->  
              </tr>
             <tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
			
                <td id="t13" align="center">住宅</td>
                <td id="t14">
					&nbsp;<input type="text" value="0" name="saleMonitor.houseNum" id="houseNum" class="leftcreateinputbox01" style="width:70px"/></td>
                <td id="t14">
					&nbsp;<input type="text" value="0" name="saleMonitor.houseArea" id="houseArea" class="leftcreateinputbox01" style="width:70px"/></td>  
				<td id="t15">&nbsp;<input type="text" value="0" name="saleMonitor.houseMoney" id="houseMoney" class="leftcreateinputbox01" style="width:70px"/>
				<font color="#0000FF"> <span id="MhouseMoney"></span> </font></td>	
               <!-- <td id="t13" align="center"><input type="text" value="0" name="saleMonitor.undoHouseNum" id="undoHouseNum" class="leftcreateinputbox02" style="width:70px"/></td>
                <td id="t14">
					<input type="text" value="0" name="saleMonitor.undoHouseArea" id="undoHouseArea" class="leftcreateinputbox02" style="width:70px"/>			</td>
					--> 
              </tr>
			  
             <tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
			
                <td id="t11" align="center">商铺</td>
                <td id="t12">
					&nbsp;<input type="text" value="0" name="saleMonitor.shopNum" id="shopNum" class="leftcreateinputbox02" style="width:70px"/></td>
                <td id="t12">
                
					&nbsp;<input type="text" value="0" name="saleMonitor.shopArea" id="shopArea" class="leftcreateinputbox02" style="width:70px"/></td>
					<td id="t12">&nbsp;<input type="text" value="0" name="saleMonitor.shopMoney" id="shopMoney" class="leftcreateinputbox02" style="width:70px"/>
					<font color="#0000FF"><span id="MshopMoney"></span></font></td>
              <!--   <td id="t11" align="center"><input type="text" value="0" name="saleMonitor.undoShopNum" id="undoShopNum" class="leftcreateinputbox02" style="width:70px"/></td>
                <td id="t12">
				<input type="text" value="0" name="saleMonitor.undoShopArea" id="undoShopArea" class="leftcreateinputbox02" style="width:70px"/></td>-->
              </tr>
             
			 
              <tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
			   
                <td id="t15" align="center">车位</td>
                <td id="t12">
					&nbsp;<input type="text" value="0" name="saleMonitor.parkNum" id="parkNum" class="leftcreateinputbox02" style="width:70px"/></td>
              	<td id="t16">&nbsp;<input type="text" value="0" name="saleMonitor.parkArea" id="parkArea" class="leftcreateinputbox02" style="width:70px"/></td>                		
				<td>&nbsp;<input type="text" value="0" name="saleMonitor.parkMoney" id="parkMoney" class="leftcreateinputbox02" style="width:70px"/>
				<font color="#0000FF"><span id="MparkMoney"></span></font></td>
                <!--  <td id="t9" align="center"><input type="text" value="0" name="saleMonitor.undoParkNum" id="undoParkNum" class="leftcreateinputbox02" style="width:70px"/></td>
                <td id="t10"><input type="text" value="0" name="saleMonitor.undoParkArea" id="undoParkArea" class="leftcreateinputbox02" style="width:70px"/></td>-->
              </tr>
			  
			   <tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
			   
                 <td id="t7" align="center">合计</td>
                
                  <td id="t12">&nbsp;<span id="sunNum" ></span></td>
                 <td id="t8">&nbsp;<span id="sumArea" ></span></td>
					<td>&nbsp;<span  id="sumMoney" ></span></td>
				<!--  <td id="t7" align="center"><input type="text" value="0" name="unDoHouseSunNum" id="unDoHouseSunNum" class="leftcreateinputbox02" style="width:70px"/></td>
                <td id="t8">
					<input type="text" value="0" name="undoHouseAreaSum" id="undoHouseAreaSum" class="leftcreateinputbox02" style="width:70px"/>		</td>    -->
              </tr>
			  
			  
			   <tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
			   		 <td id="t14" ></td>
                <td id="t14">签约套数</td>
                <td id="t14">
					签约面积(㎡)</td>  
				<td id="t14">
					签约金额(元)</td> 
			   </tr>
			  <tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"; >
			
                <td id="t13" align="center">住宅</td>
          
				<td id="t13" >&nbsp;<input type="text" value="0" name="saleMonitor.contractHouseNum" id="contractHouseNum" class="leftcreateinputbox02" style="width:70px"/></td>
                <td id="t14">&nbsp;<input type="text" value="0" name="saleMonitor.contractHouseArea" id="contractHouseArea" class="leftcreateinputbox02" style="width:70px"/>			</td>
				<td id="t14">&nbsp;<input type="text" value="0" name="saleMonitor.contractHouseMoney" id="contractHouseMoney" class="leftcreateinputbox02" style="width:70px"/>
				<font color="#0000FF"><span id="contractHouseMoneySum"></span></font></td>
				
				  <tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
			
                <td id="t11" align="center">商铺</td>
                <td id="t12">&nbsp;<input type="text" value="0" name="saleMonitor.contractShopNum" id="contractShopNum" class="leftcreateinputbox02" style="width:70px"/></td>
                <td id="t12">&nbsp;<input type="text" value="0" name="saleMonitor.contractShopArea" id="contractShopArea" class="leftcreateinputbox02" style="width:70px"/></td>
					<td id="t12">&nbsp;<input type="text" value="0" name="saleMonitor.contractShopMoney" id="contractShopMoney" class="leftcreateinputbox02" style="width:70px"/>
					<font color="#0000FF"><span id="contractShopMoneySum"></span></font></td>
              <!--   <td id="t11" align="center"><input type="text" value="0" name="saleMonitor.undoShopNum" id="undoShopNum" class="leftcreateinputbox02" style="width:70px"/></td>
                <td id="t12">
				<input type="text" value="0" name="saleMonitor.undoShopArea" id="undoShopArea" class="leftcreateinputbox02" style="width:70px"/></td>-->
              </tr>	
               <tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
			  
                <td id="t15" align="center">车位</td>
                 <td id="t9" >&nbsp;<input type="text" value="0" name="saleMonitor.contractParkNum" id="contractParkNum" class="leftcreateinputbox02" style="width:70px"/></td>
                <td id="t10">&nbsp;<input type="text" value="0" name="saleMonitor.contractParkArea" id="contractParkArea" class="leftcreateinputbox02" style="width:70px"/></td>           		
				<td>&nbsp;<input type="text" value="0" name="saleMonitor.contractParkMoney" id="contractParkMoney" class="leftcreateinputbox02" style="width:70px"/>
				<font color="#0000FF"><span id="contractParkMoneySum"></span></font></td>
                <!--  -->
              </tr>
              <tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
			   
                 <td id="t7" align="center">合计</td>
                
                  	<td id="t7" >&nbsp;<span  id="getContractHouseNum" ></span></td>
                	<td id="t8">&nbsp;<span  id="getContractSumArea" ></span></td>
					<td>&nbsp;<span  id="getContractMoneySum" ></span></td>
				<!--     -->
              </tr>
			  
			  
			  
			   <tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
			   		 <td id="t14" ></td>
                <td id="t14">退挞定套数</td>
                <td id="t14">
					退挞定面积(㎡)</td>  
				<td id="t14">
					退挞定金额(元)</td> 
			   </tr>
			  <tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"; >
			
                <td id="t13" align="center">住宅</td>
          
				<td id="t13" >&nbsp;<input type="text" value="0" name="saleMonitor.undoHouseNum" id="undoHouseNum" class="leftcreateinputbox02" style="width:70px"/></td>
                <td id="t14">&nbsp;<input type="text" value="0" name="saleMonitor.undoHouseArea" id="undoHouseArea" class="leftcreateinputbox02" style="width:70px"/>			</td>
				<td id="t14">&nbsp;<input type="text" value="0" name="saleMonitor.undoHouseMoney" id="undoHouseMoney" class="leftcreateinputbox02" style="width:70px"/>
				<font color="#0000FF"><span id="MundoHouseMoney"></span></font></td>
				
				  <tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
			
                <td id="t11" align="center">商铺</td>
                <td id="t12">&nbsp;<input type="text" value="0" name="saleMonitor.undoShopNum" id="undoShopNum" class="leftcreateinputbox02" style="width:70px"/></td>
                <td id="t12">&nbsp;<input type="text" value="0" name="saleMonitor.undoShopArea" id="undoShopArea" class="leftcreateinputbox02" style="width:70px"/></td>
					<td id="t12">&nbsp;<input type="text" value="0" name="saleMonitor.undoShopMoney" id="undoShopMoney" class="leftcreateinputbox02" style="width:70px"/>
					<font color="#0000FF"><span id="MundoShopMoney"></span></font></td>
              <!--   <td id="t11" align="center"><input type="text" value="0" name="saleMonitor.undoShopNum" id="undoShopNum" class="leftcreateinputbox02" style="width:70px"/></td>
                <td id="t12">
				<input type="text" value="0" name="saleMonitor.undoShopArea" id="undoShopArea" class="leftcreateinputbox02" style="width:70px"/></td>-->
              </tr>	
               <tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
			  
                <td id="t15" align="center">车位</td>
                 <td id="t9" >&nbsp;<input type="text" value="0" name="saleMonitor.undoParkNum" id="undoParkNum" class="leftcreateinputbox02" style="width:70px"/></td>
                <td id="t10">&nbsp;<input type="text" value="0" name="saleMonitor.undoParkArea" id="undoParkArea" class="leftcreateinputbox02" style="width:70px"/></td>           		
				<td>&nbsp;<input type="text" value="0" name="saleMonitor.undoParkMoney" id="undoParkMoney" class="leftcreateinputbox02" style="width:70px"/>
				<font color="#0000FF"><span id="MundoParkMoney"></span></font></td>
                <!--  -->
              </tr>
              <tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
			   
                 <td id="t7" align="center">合计</td>
                
                  	<td id="t7" >&nbsp;<span  id="unDoHouseSunNum" ></span></td>
                	<td id="t8">&nbsp;<span  id="undoHouseAreaSum" ></span></td>
					<td>&nbsp;<span  id="undoSumMoney" ></span></td>
				<!--     -->
              </tr>
			  
			  
			  
	
		  <tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"; align="center">
			<td colspan="4">
			  <input type="submit" value="  保存  " id="sub" />
			  <input type="button" value="  取消  " onClick="javascript:window.location.href = '<%=path %>/sale_hengda/search/sale.action?from=left'" />
			  <div><font color="#FF0000"><span id="suggestion"><s:property value="#request.suggestion"/></span></font></div>
			  </td>
			  
		  </tr>
	  </table>
	  
	  </form>
	  
			  <div class="c"></div>
			</div>
			<div class="titler"></div>
			<div class="c"></div>
		<div class="c" ></div>
		</td>
  </tr>
		</table>
	  <!--main.end-->
		</td>
					<%-- 基本table分割 ^^^^^^^^^^^^^^^^^end^^^</td>^^^^^^^^^^^^^^^^^^^^^--%>
					
				</tr>
			</tbody>

		</table>

	</body>
</html>

