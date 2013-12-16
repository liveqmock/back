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
		
		<title>恒大销售数据管理系统欢迎页面</title>
	</head>
	<body>
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
					<td width="100%" valign="top" bgcolor="#A4C3D7" height="650px">
						<%-- 基本table分割 ^^^^^^<td width="100%">^^^^^^^^^^^^^^^^^^^^^^--%>
						<%--main table开始 --%>
						
				
<!--main-->
<table width="100%" class="mainbg20111112" style="height:100%">
  <tr>  
	
    <td width="100%" valign="top" height="100%" style="overflow:hidden;">
    <%-- 
    <div class="right01"></div>
    <div class="right02"></div>
    <div class="right03"></div>
    <div class="c"></div>
    <div >
    <div class="right04"></div>
    <div class="right05">
    --%>
      <div class="titlel"></div>
       <div class="titlebg" style=" height:auto;overflow:hidden;">

	        <div class="title02" ><a href="./sale_hengda/search/all.action?from=left" target="_self">时段累计</a></div>
			   <div class="right99"></div>
			<div class="blueline"></div>
			
			
			
          <div class="c"></div>
          <div class="c"></div>
		  
		  
         
          <table style="table-layout: fixed; width: auto; overflow:scroll" align="left" border="0" cellspacing="0" width="98%">		

		  
		  <!-- 搜索表单 top -->
       
       <form action="./sale_hengda/search/all.action" method="get">
	   		 <tr style="white-space:nowrap">
			  <td width="3%" height="0" align="center"><label> <span>日期&nbsp;</span></label></td>
              <td height="0" nowrap="nowrap" width="auto" colspan="5">
			  	&nbsp;<input class="Wdate" type="text" id="date1" style="width:90px" name="saleCond.date1" value="${saleCond.date1}" onClick="WdatePicker()"/>
				-
				<input class="Wdate" type="text" id="date2" style="width:90px" name="saleCond.date2" value="${saleCond.date2}" onClick="WdatePicker()"/>
				&nbsp;<input type="submit" value="  搜索  " id="searchSubmit" onClick="return check();"/>
				&nbsp;<a href="./sale_hengda/search/downLoadAll.action">下载数据</a>
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
	   <tr onMouseOver="this.style.backgroundColor='#fffffbf';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" nowrap="nowrap"> 
		
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
        <%-- 
    </div>
    <div class="right06"></div>
    <div class="c"></div>
    </div>
		<div class="right01"></div>
		<div class="right02"></div>
		<div class="right03"></div>
		--%>
		<div class="c"></div>
    </td>
  </tr>
  <!--main.end-->
  <tr>
    <td height="5" colspan="3">
    </td>
  </tr>
  
 
  
</table>
	
						
					</td>
					<%-- 基本table分割 ^^^^^^^^^^^^^^^^^end^^^</td>^^^^^^^^^^^^^^^^^^^^^--%>
				</tr>
			</tbody>

		</table>

	</body>
</html>
