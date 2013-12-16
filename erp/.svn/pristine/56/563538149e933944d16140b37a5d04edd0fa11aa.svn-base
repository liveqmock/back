<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>  

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
		
		<title>时段累计</title>
		<script language="javascript" type="text/javascript">
			$().ready(function(){
				
				$("#saleTimeCond_companyId").change(function(){
					companyToProject(this.value, "saleTimeCond_projectId");
				});
				
				
			});
		</script>
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
					<td width="100%" valign="top"  >
					<DIV style="WIDTH: 98%; HEIGHT: 100%; BACKGROUND-COLOR: #A4C3D7;padding: 1px">
						<%-- 基本table分割 ^^^^^^<td width="100%">^^^^^^^^^^^^^^^^^^^^^^--%>
						<%--main table开始 --%>
						
					<table width="100%" class="mainbg20111112" style="height: 100%">
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
		
					<div class="title02" ><a href="./sale_hengda/search/time.action?from=left" target="_self">时段累计</a></div>
					   <div class="right99"></div>
					<div class="blueline"></div>
					
				  <div class="c"></div>
				  <div class="c"></div>
				  
				  
         
          <table width="100%" border="0" align="left" cellspacing="0">	
		  
		  <!-- 搜索表单 top -->
       
       <form action="./sale_hengda/search/time.action" method="get">
	   		 <tr style="white-space: nowrap">
			<td height="0" align="left" colspan="6">
				<label>
					<span>日期</span>				</label>
			  	<input class="Wdate" type="text" id="date1" name="saleTimeCond.date1" style="width:90px" value="${saleTimeCond.date1}" onClick="WdatePicker()"/>
				-
			  	<input class="Wdate" type="text" id="date2" name="saleTimeCond.date2" style="width:90px" value="${saleTimeCond.date2}" onClick="WdatePicker()"/>
				<label>
					<span>所属公司</span>				</label>
				<s:select list="selCompany" name="saleTimeCond.companyId" value="#session.companyId" />
				<label>
					<span>所属项目</span>				</label>
				<s:select list="selProject" name="saleTimeCond.projectId" value="#session.projectId" />
				<input type="submit" value="  搜索  " id="searchSubmit" onClick="return check();"/>		
				<a href="./sale_hengda/search/downLoadTime.action" class="ablue" >下载数据</a>			  </td>  			 
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
         <tr class="gboxbg" align="center" style="line-height:20px">
           <td width="150">销售公司</td>
           <td width="150">项目名称</td>
           <td width="100" align="center" valign="middle"> 来电(组) </td>
           <td width="100" align="center" valign="middle"> 来访(个)</td>
           <td width="100" align="center" valign="middle"> 成交套数(套)</td>
           <td width="100" align="center" valign="middle"> 成交面积(㎡)</td>
           <td width="100" align="center" valign="middle"> 成交金额(元) </td>
           <td width="100" align="center" valign="middle"> 退挞定套数(套) </td>
           <td width="100" align="center" valign="middle"> 退挞定面积(㎡)</td>
           <td width="100" align="center" valign="middle" > 退挞定金额(元) </td>
           <td width="100" align="center" valign="middle" > 当日认筹(次) </td>
           <td width="100" align="center" valign="middle" > 详细 </td>
         </tr>
         <s:iterator value="#request.saleTypeList" id="c">
           <tr onmouseover="this.style.backgroundColor='#ffffbf';" onmouseout="this.style.backgroundColor=''" bgcolor="#FFFFFF">
             <td align="center" valign="middle"><s:property value="#c.descCompanyName"/>             </td>
             <td align="center" valign="middle"><s:property value="#c.descProjectName"/>             </td>
             <td align="center" valign="middle"><fmt:formatNumber value="${c.phoneNum}" pattern="#,##0"/>             </td>
             <td align="center" valign="middle"><fmt:formatNumber value="${c.visitorNum}" pattern="#,##0"/>             </td>
             <td align="center" valign="middle"><fmt:formatNumber value="${c.sumNum}" pattern="#,##0"/>             </td>
             <td align="center" valign="middle"><fmt:formatNumber value="${c.sumArea}" pattern="#,##0.00"/>             </td>
             <td align="center" valign="middle"><fmt:formatNumber value="${c.sumMoney}" pattern="#,##0.00"/>             </td>
             <td align="center" valign="middle"><fmt:formatNumber value="${c.undoSumNum}" pattern="#,##0"/>             </td>
             <td align="center" valign="middle"><fmt:formatNumber value="${c.undoSumArea}" pattern="#,##0.00"/>             </td>
             <td align="center" valign="middle"><fmt:formatNumber value="${c.undoSumMoney}" pattern="#,##0.00"/>             </td>
             <td align="center" valign="middle"><fmt:formatNumber value="${c.intentionNum}" pattern="#,##0"/>             </td>
			<td align="center" valign="middle">
				<a href="sale_hengda/search/sale.action?
				saleCond.date1=${saleTimeCond.date1}&saleCond.date2=${saleTimeCond.date2}
				&saleCond.companyId=<s:property value='#c.companyId'/>
				&saleCond.projectId=<s:property value='#c.projectId'/>" class="ablue" target="_self">查看</a>
			</td>
			 
           </tr>
         </s:iterator>
		 
		 
         <tr class="gboxbg" align="center" >
           <td colspan="2">合计</td>
           <td><fmt:formatNumber value="${amount.phoneNum}" pattern="#,##0"/></td>
           <td><fmt:formatNumber value="${amount.visitorNum}" pattern="#,##0"/></td>
           <td><fmt:formatNumber value="${amount.sumNum}" pattern="#,##0"/></td>
           <td><fmt:formatNumber value="${amount.sumArea}" pattern="#,##0.00#"/></td>
           <td><fmt:formatNumber value="${amount.sumMoney}" pattern="#,#00.00#"/></td>
           <td><fmt:formatNumber value="${amount.undoSumNum}" pattern="#,##0"/></td>
           <td><fmt:formatNumber value="${amount.undoSumArea}" pattern="#,#00.00#"/></td>
           <td><fmt:formatNumber value="${amount.undoSumMoney}" pattern="#,#00.00#"/></td>
           <td><fmt:formatNumber value="${amount.intentionNum}" pattern="#,##0"/></td>
		   <td></td>
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
       
	<div class="c"></div>
    <div class="c" ></div>
    </td>
  </tr>
  <!--main.end-->
  <tr>
    <td height="5" colspan="6">
    </td>
  </tr>
  
 
  
</table>
						
						</DIV>
					</td>
					<%-- 基本table分割 ^^^^^^^^^^^^^^^^^end^^^</td>^^^^^^^^^^^^^^^^^^^^^--%>
				</tr>
			</tbody>

		</table>

	</body>
</html>
