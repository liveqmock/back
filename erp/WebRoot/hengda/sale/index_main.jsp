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

	        <div class="title02" ><a href="./sale_hengda!searchSale.action?from=left" target="_self">查询在售数据</a></div>
            <div class="title01"><a href="./sale_hengda!doSomeForAddSale.action?from=hengda" target="_self">新建在售数据</a></div>			
			
			
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
		  
		   <tr>
              <td height="10" colspan="6">
              <div class="blueline"></div>
              </td>
              </tr>			  
		  
		  <!-- 搜索表单 top -->
       
       <form action="sale_hengda!searchSale.action" method="get">
			
            <tr style="white-space:nowrap">
			  <td width="3%" height="0" align="left"><label> <span>日期&nbsp;</span></label></td>
              <td height="0" colspan="2" nowrap="nowrap">
			  	&nbsp;<input class="Wdate" type="text" id="date1" style="width:90px" name="saleCond.date1" value="${saleCond.date1}" onClick="WdatePicker()"/>
				-
				<input class="Wdate" type="text" id="date2" style="width:90px" name="saleCond.date2" value="${saleCond.date2}" onClick="WdatePicker()"/>
			  </td>  
			 			  
			  <td width="82%" height="0">
			  	&nbsp;
			  	<input type="submit" value="  搜索  " id="searchSubmit" onClick="return check();"/>
				&nbsp;<a href="./sale_hengda!searchSale.action?type=week" title="当前日期的前七天数据">周数据</a>
				&nbsp;<a href="./sale_hengda!searchSale.action?type=month" title="当前日期的所属月份数据">月数据</a>
				&nbsp;<a href="./sale_hengda!downLoadSale.action">下载数据</a>
			  </td>
            </tr>
			
			  </form>
		  
		<!-- 搜索表单 end -->
			
            <tr>
              <td height="10" colspan="6">
              <div class="blueline"></div>
              </td>
              </tr>		
		
		<!--
		<s:if test="#session.loginAccount.accountType == 2 ">
	 
            <tr>
              <td height="20" colspan="6">
			  
			  操作
			  <input type="button" id="delete" value="  删除  " onClick="return delSales('sale_hengda')"/>
				
			 
				</td>
            </tr>
			
		</s:if>
		-->
	
		
            <tr>
              <td colspan="6">			  
			  
			  <!--  列表 top -->
			  <div class="gbox1">			  
			  
			  <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" >
  <tr class="gboxbg">
   

    <td width="180">
	<table width="99" height="28"  border="0" align="center" cellspacing="0">
      <tr>
        <td width="80%" align="center" valign="middle">日期</td>
        <td align="center" valign="middle">
		<table width="5" border="0" cellspacing="0">
          <tr>
            <td><a href="sale_hengda!searchSale.action?ob=12"><img src="images/blue/upn.gif" width="9" height="10" border="0" /></a></td>
          </tr>
          <tr>
            <td><a href="sale_hengda!searchSale.action?ob=11"><img src="images/blue/downopen.gif" width="9" height="10" border="0" /></a></a></td>
          </tr>
        </table>
	  </td>
      </tr>
      </table></td>
    <td width="100" align="center" valign="middle">
		来电(次)	</td>
	
    <td width="100" align="center" valign="middle">
	来访(人)</td>
	
	
     <td width="100" align="center" valign="middle">
		住宅(套)</td>
    <td width="100" align="center" valign="middle">
		商铺(个)	</td>
     <td width="100" align="center" valign="middle">
		车位(个)	</td>
	<td width="100" align="center" valign="middle">
		挞定(套)	</td>
	<td width="100" align="center" valign="middle">
		临定(套)	</td>
	<td width="100" align="center" valign="middle" style="white-space:nowrap">
		齐定面积(m<sup>2</sup>)	</td>
	<td width="100" align="center" valign="middle" style="white-space:nowrap">
		齐定金额(千元)	</td>
	<td width="100" align="center" valign="middle" style="white-space:nowrap">
		当日认筹(次)	</td>
   
  </tr>
  
  
   <s:iterator value="#request.saleList" id="c">  
	  <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"> 
		
		<td align="center" valign="middle" class="fontblue">
			<a href="./sale_hengda!querySaleMonitorById.action?id=<s:property value='#c.id'/>" target="_self" ><s:date name="#c.monitorDate" format="yyyy-MM-dd "/></a>
			
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

		<td>合计</td>
		<td>${amount.phoneNum}</td>
		<td>${amount.visitorNum}</td>
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

<!-- 列表 end -->


</td>
        </tr>
            <tr>
              <td colspan="6">
                <div class="manu">
					<s:property value="showPage" escape="false"/>
				</div>                
			</td>
            </tr>
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
