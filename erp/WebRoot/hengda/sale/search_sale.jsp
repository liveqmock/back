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
		
		<title>查询明细</title>
		
		<script language="javascript" type="text/javascript">
			$().ready(function(){
				
				$("#saleCond_companyId").change(function(){
					companyToProject(this.value, "saleCond_projectId");
				});
				
				
			});
		</script>
		
	</head>
	<body>
		<table width="100%" border="0" align="left" cellspacing="0">
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
					<td width="1" align="left" valign="top">
					
						<s:include value="include/left.jsp">
						</s:include>
					</td>
						<td width="100%" valign="top">
						<DIV style="WIDTH: 98%; HEIGHT: 100%; BACKGROUND-COLOR: #A4C3D7;padding: 1px">
						<%-- 基本table分割 ^^^^^^<td width="100%">^^^^^^^^^^^^^^^^^^^^^^--%>
						<%--main table开始 --%>
						
					<table width="100%" class="mainbg20111112" style="height: 100%">
		  <tr>
		  
			
			<td width="100%" valign="top" height="100%" style="overflow:hidden;">
			
			  <div class="titlel"></div>
			   <div class="titlebg" style=" height:auto;overflow:hidden;">
		

					 <div class="title02" ><a href="./sale_hengda/search/sale.action?from=left" target="_self">明细查询</a></div>
		            <div class="title01"><a href="./sale_hengda/input/for_sale.action" target="_self">录入数据</a></div>
					
				   <div class="right99"></div>
				<div class="blueline"></div>
					
				  <div class="c"></div>
				  <div class="c"></div>
				  
				  
         
          <table width="100%" border="0" align="left" cellspacing="0">	
		  
		  <!-- 搜索表单 top -->
       
        <form action="sale_hengda/search/sale.action" method="get">
			
            <tr>
			  <td height="0" align="left" colspan="6">
			  	<label>
					<span>日期</span>
				</label>
				<input class="Wdate" type="text" id="date1" style="width:90px" name="saleCond.date1" value="${saleCond.date1}" onClick="WdatePicker()"/>
				-
				<input class="Wdate" type="text" id="date2" style="width:90px" name="saleCond.date2" value="${saleCond.date2}" onClick="WdatePicker()"/>				
				<label>
					<span>所属公司</span>
				</label>
				<s:select list="selCompany" name="saleCond.companyId" value="#session.companyId" />
				<label>
					<span>所属项目</span>
				</label>
				<s:select list="selProject" name="saleCond.projectId" value="#session.projectId" />
			  	<input type="submit" value="  搜索  " id="searchSubmit" onClick="return check();"/>
			  </td>
			 </tr>
			 
			 <tr>
			 	 <td height="0" align="left" colspan="6">
				
				
				<a href="./sale_hengda/search/sale.action?type=lastWeek&saleCond.companyId=${session.companyId}&saleCond.projectId=${session.projectId}"
					title="当前日期所属的周数据"  class="ablue" >上周数据</a>
				<a href="./sale_hengda/search/sale.action?type=week&saleCond.companyId=${session.companyId}&saleCond.projectId=${session.projectId}"
					title="当前日期所属的周数据" class="ablue" >本周数据</a>
				<a href="./sale_hengda/search/sale.action?type=lastMonth&saleCond.companyId=${session.companyId}&saleCond.projectId=${session.projectId}"
					title="当前日期所属的月数据" class="ablue" >上月数据</a>
				<a href="./sale_hengda/search/sale.action?type=month&saleCond.companyId=${session.companyId}&saleCond.projectId=${session.projectId}"
					title="当前日期所属的月数据" class="ablue" >本月数据</a>
				<a href="./sale_hengda/search/downLoadSale.action"  class="ablue" >下载数据</a>
				<a class="ablue" href="./sale_hengda/search/inCount.action" target="_self">录入次数查询</a>
				<s:if test="#session.isRetShow == true">
				<a href= "${session.retUrl}" class="ablue">返回</a>
				</s:if>
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
			  
			  <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" >
  <tr class="gboxbg">
   

    <td width="100">
	<table width="99" height="28"  border="0" align="center" cellspacing="0">
      <tr>
        <td width="80%" align="center" valign="middle">日期</td>
        <td align="center" valign="middle">
		<table width="5" border="0" cellspacing="0">
          <tr>
            <td><a href="./sale_hengda/search/sale.action?ob=12"><img src="images/blue/upn.gif" width="9" height="10" border="0" /></a></td>
          </tr>
          <tr>
            <td><a href="./sale_hengda/search/sale.action?ob=11"><img src="images/blue/downopen.gif" width="9" height="10" border="0" /></a></a></td>
          </tr>
        </table>
	  </td>
      </tr>
      </table></td>
	  <td width="100" align="center" valign="middle">
		销售公司</td>
		<td width="100" align="center" valign="middle">
		项目名称</td>
    <td width="80" align="center" valign="middle">
		来电(组)	</td>
	
    <td width="80" align="center" valign="middle">
	来访(个)</td>
	
     <td width="80" align="center" valign="middle">
		成交套数(套)</td>
    <td width="100" align="center" valign="middle">
		成交面积(㎡)</td>
     <td width="100" align="center" valign="middle">
		成交金额(元)	</td>
	<td width="80" align="center" valign="middle" >
		退挞定套数(套)	</td>
	<td width="100" align="center" valign="middle">
		退挞定面积(㎡)</td>
	<td width="100" align="center" valign="middle">
		退挞定金额(元)</td>	
	<td width="80" align="center" valign="middle">
		当日认筹(次)	</td>
	<td width="80" align="center" valign="middle">
		签约数(套)	</td>
	<td width="80" align="center" valign="middle">
		实收金额(元)	</td>
   
  </tr>
  
  
   <s:iterator value="#request.saleList" id="c">  
	  <tr onMouseOver="this.style.backgroundColor='#ffffbf';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"> 
		
		<td align="center" valign="middle" >
			<s:date name="#c.monitorDate" format="yyyy-MM-dd "/>
		</td>
		
		<td align="center" valign="middle">
			<s:property value="#c.descCompanyName"/>
		</td>
		<td align="center" valign="middle" class="fontblue">
			<a href="./sale_hengda/update/for_sale.action?id=<s:property value='#c.id'/>" target="_self" ><s:property value="#c.descProjectName"/></a>
		</td>
		
		<td align="center" valign="middle">
			<fmt:formatNumber value="${c.phoneNum}" pattern="#,##0"/>
		</td>
		<td align="center" valign="middle">
			<fmt:formatNumber value="${c.visitorNum}" pattern="#,##0"/>
		</td>
		<td align="center" valign="middle">	
			<fmt:formatNumber value="${c.sumNum}" pattern="#,##0"/>
		</td>
		<td align="center" valign="middle">
			<fmt:formatNumber value="${c.sumArea}" pattern="#,##0.00"/>
		</td>
		<td align="center" valign="middle">
			<fmt:formatNumber value="${c.sumMoney}" pattern="#,##0.00"/>
		</td>
		<td align="center" valign="middle">
			<fmt:formatNumber value="${c.undoSumNum}" pattern="#,##0"/>
		</td>
		<td align="center" valign="middle">
			<fmt:formatNumber value="${c.undoSumArea}" pattern="#,##0.00"/>
		</td>
		<td align="center" valign="middle">
			<fmt:formatNumber value="${c.undoSumMoney}" pattern="#,##0.00"/>
		</td>		
		<td align="center" valign="middle">
			<fmt:formatNumber value="${c.intentionNum}" pattern="#,##0"/>
		</td>
		<td align="center" valign="middle">
			<fmt:formatNumber value="${c.contractSumNum}" pattern="#,##0"/>
		</td>
		<td align="center" valign="middle">
			<fmt:formatNumber value="${c.contractSumMoney - c.undoSumMoney}" pattern="#,##0.00"/>
		</td>
	  </tr>
    </s:iterator>
	
	 <tr class="gboxbg" align="center">

		<td colspan="3">本页合计</td>
		<td><fmt:formatNumber value="${amount.phoneNum}" pattern="#,##0"/></td>
		<td><fmt:formatNumber value="${amount.visitorNum}" pattern="#,##0"/></td>
		<td><fmt:formatNumber value="${amount.sumNum}" pattern="#,##0"/></td>
		<td><fmt:formatNumber value="${amount.sumArea}" pattern="#,##0.00"/></td>
		<td><fmt:formatNumber value="${amount.sumMoney}" pattern="#,##0.00"/></td>
		<td><fmt:formatNumber value="${amount.undoSumNum}" pattern="#,##0"/></td>
		<td><fmt:formatNumber value="${amount.undoSumArea}" pattern="#,##0.00"/></td>
		<td><fmt:formatNumber value="${amount.undoSumMoney}" pattern="#,##0.00"/></td>
		<td><fmt:formatNumber value="${amount.intentionNum}" pattern="#,##0"/></td>
		<td><fmt:formatNumber value="${amount.contractSumNum}" pattern="#,##0"/></td>
		<td><fmt:formatNumber value="${amount.realSumMoney}" pattern="#,##0.00"/></td>
	</tr>
	
	 <tr class="gboxbg" align="center">

		<td colspan="3">总合计</td>
		<td><fmt:formatNumber value="${allAmount.phoneNum}" pattern="#,##0"/></td>
		<td><fmt:formatNumber value="${allAmount.visitorNum}" pattern="#,##0"/></td>
		<td><fmt:formatNumber value="${allAmount.sumNum}" pattern="#,##0"/></td>
		<td><fmt:formatNumber value="${allAmount.sumArea}" pattern="#,##0.00"/></td>
		<td><fmt:formatNumber value="${allAmount.sumMoney}" pattern="#,##0.00"/></td>
		<td><fmt:formatNumber value="${allAmount.undoSumNum}" pattern="#,##0"/></td>
		<td><fmt:formatNumber value="${allAmount.undoSumArea}" pattern="#,##0.00"/></td>
		<td><fmt:formatNumber value="${allAmount.undoSumMoney}" pattern="#,##0.00"/></td>
		<td><fmt:formatNumber value="${allAmount.intentionNum}" pattern="#,##0"/></td>
		<td><fmt:formatNumber value="${allAmount.contractSumNum}" pattern="#,##0"/></td>
		<td><fmt:formatNumber value="${allAmount.realSumMoney}" pattern="#,##0.00"/></td>
	</tr>
  
</table>
</div>
<!-- 列表 end --></td>
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
