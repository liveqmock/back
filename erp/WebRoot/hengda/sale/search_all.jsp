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
		
		<title>汇总</title>
		
		<script language="javascript" type="text/javascript">
			$().ready(function(){
			
				$("#showSaleCompanyList").click(function(){
					$("#saleCompanyList").show('normal');
					$("#saleProjectList").hide('normal');
				});
			
				$("#showSaleProjectList").click(function(){
					$("#saleCompanyList").hide('normal');
					$("#saleProjectList").show('normal');
				});
				
				$("#saleCond_companyId").change(function(){
					companyToProject(this.value, "saleCond_projectId");
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
					<td width="100%" valign="top">
					<DIV style="WIDTH: 98%; HEIGHT: 100%; BACKGROUND-COLOR: #A4C3D7;padding: 1px">
						<%-- 基本table分割 ^^^^^^<td width="100%">^^^^^^^^^^^^^^^^^^^^^^--%>
						<%--main table开始 --%>
						
					<table width="100%" class="mainbg20111112" style="height: 100%;" >
							<tr>

								<td width="100%" valign="top" height="100%" style="overflow: hidden;">

									<div class="titlel"></div>
									<div class="titlebg" style="height: auto; overflow: hidden;">

										<div class="title02" style="width: auto">
											<a href="./sale_hengda/search/all.action?from=left" target="_self">汇总查询</a>
										</div>
										<div class="right99"></div>
										<div class="blueline"></div>

										<div class="c"></div>
										<div class="c"></div>



										<table width="100%" border="0" align="left" cellspacing="0">

											<!-- 搜索表单 top -->

											<form action="./sale_hengda/search/all.action" method="get">
												<tr style="white-space: nowrap">
													<td height="0" align="left" colspan="6">
														<label>
															<span>日期</span>
														</label>
														<input class="Wdate" type="text" id="monitorDate" name="saleCond.monitorDate" 
															style="width: 90px" value="${saleCond.monitorDate}" onClick="WdatePicker()" />
														<label>
															<span>所属公司</span>
														</label>
														<s:select list="selCompany" name="saleCond.companyId" value="#session.companyId" />
														<label>
															<span>所属项目</span>
														</label>
														<s:select list="selProject" name="saleCond.projectId" value="#session.projectId" />
														<input type="submit" value="  搜索  " id="searchSubmit" onClick="return check();" />
													</td>

												</tr>

											</form>

											<!-- 搜索表单 end -->



											<tr>
												<td colspan="6">

													<!--  列表 top -->

													<div class="gbox1">

														<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox">


															<tr class="gboxbg" align="center" style="white-space: nowrap">
																<td colspan="3" align="center" width="">
																	统计时间段
																</td>

																<td width="170" align="center" valign="middle">
																	统计类型
																</td>
																<td width="100" align="center" valign="middle">
																	来电(组)
																</td>
																<td width="100" align="center" valign="middle">
																	来访(个)
																</td>
																<td width="100" align="center" valign="middle">
																	销售套数(套)
																</td>
																<td width="100" align="center" valign="middle">
																	销售面积(㎡)
																</td>
																<td width="100" align="center" valign="middle" nowrap="nowrap">
																	销售金额(万元)
																</td>
																<td width="100" align="center" valign="middle">
																	认筹数量(次)
																</td>
																<td width="100" align="center" valign="middle">&nbsp;</td>


															</tr>

															<tr onMouseOver="this.style.backgroundColor='#ffffbf';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
																<td colspan="3" align="center" style="white-space: nowrap">
																	<span style="width: 90px">${saleCond.monitorDate}</span>
																</td>

																<td width="170" align="center" valign="middle">
																	当日
																</td>
																<td width="100" align="center" valign="middle">
																	<fmt:formatNumber value="${sale.phoneNum}" pattern="#,##0"/>
																</td>
																<td width="100" align="center" valign="middle">
																	<fmt:formatNumber value="${sale.visitorNum}" pattern="#,##0"/>
																</td>
																<td width="100" align="center" valign="middle">
																	<fmt:formatNumber value="${sale.sumNum}" pattern="#,##0"/>
																</td>
																<td width="100" align="center" valign="middle">
																	<fmt:formatNumber value="${sale.sumArea == null ? 0 : sale.sumArea}" pattern="#,##0.00"/>
																</td>
																<td width="100" align="center" valign="middle">
																	<fmt:formatNumber value="${sale.sumMoney}" pattern="#,##0.00"/>
																</td>
																<td width="100" align="center" valign="middle">
																	<fmt:formatNumber value="${sale.intentionNum}" pattern="#,##0"/>
																</td>
																<td width="100" align="center" valign="middle"></td>


															</tr>


															<tr onMouseOver="this.style.backgroundColor='#ffffbf';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
																style="white-space: nowrap">

																<td align="center" colspan="3" style="white-space: nowrap">
																	&nbsp;
																	<span style="width: 90px">${session.weekFirst}</span>
																	-
																	<span style="width: 90px">${saleCond.monitorDate}</span>
																	&nbsp;
																</td>
																<td align="center" valign="middle">
																	本周
																</td>
																<td width="100" align="center" valign="middle">
																	<fmt:formatNumber value="${weekSale.phoneNum}" pattern="#,##0"/>
																</td>
																<td width="100" align="center" valign="middle">
																	<fmt:formatNumber value="${weekSale.visitorNum}" pattern="#,##0"/>
																</td>
																<td width="100" align="center" valign="middle">
																	<fmt:formatNumber value="${weekSale.sumNum}" pattern="#,##0"/>
																</td>
																<td width="100" align="center" valign="middle">
																	<fmt:formatNumber value="${weekSale.sumArea == null ? 0 : weekSale.sumArea}" pattern="#,##0.00"/>
																</td>
																<td width="100" align="center" valign="middle">
																	<fmt:formatNumber value="${weekSale.sumMoney}" pattern="#,##0.00"/>
																</td>
																<td width="100" align="center" valign="middle">
																	<fmt:formatNumber value="${weekSale.intentionNum}" pattern="#,##0"/>
																</td>
																<td align="center" valign="middle">
																	<a class="ablue"  href= "${session.dayUrl}day" target="_self">日曲线</a>
																</td>

															</tr>

															<tr onMouseOver="this.style.backgroundColor='#ffffbf';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">

																<td align="center" colspan="3" style="white-space: nowrap">
																	&nbsp;
																	<span style="width: 90px">${session.monthFirst}</span>
																	-
																	<span style="width: 90px">${saleCond.monitorDate}</span>
																	&nbsp;
																</td>
																<td align="center" valign="middle">
																	本月
																</td>
																<td width="100" align="center" valign="middle">
																	<fmt:formatNumber value="${monthSale.phoneNum}" pattern="#,##0"/>
																</td>
																<td width="100" align="center" valign="middle">
																	<fmt:formatNumber value="${monthSale.visitorNum}" pattern="#,##0"/>
																</td>
																<td width="100" align="center" valign="middle">
																	<fmt:formatNumber value="${monthSale.sumNum}" pattern="#,##0"/>
																</td>
																<td width="100" align="center" valign="middle">
																	<fmt:formatNumber value="${monthSale.sumArea == null ? 0 : monthSale.sumArea}" pattern="#,##0.00"/>
																</td>
																<td width="100" align="center" valign="middle">
																	<fmt:formatNumber value="${monthSale.sumMoney}" pattern="#,##0.00"/>
																</td>
																<td width="100" align="center" valign="middle">
																	<fmt:formatNumber value="${monthSale.intentionNum}" pattern="#,##0"/>
																</td>
																<td align="center" valign="middle">
																	<a class="ablue"  href= "${session.weekUrl}week" target="_self">周曲线</a>
																</td>

															</tr>

															<tr onMouseOver="this.style.backgroundColor='#ffffbf';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">

																<td align="center" colspan="3" style="white-space: nowrap">
																	&nbsp;
																	<span style="width: 90px">${session.yearFirst}</span>
																	-
																	<span style="width: 90px">${saleCond.monitorDate}</span>
																	&nbsp;
																</td>
																<td align="center" valign="middle">
																	本年
																</td>
																<td width="100" align="center" valign="middle">
																	<fmt:formatNumber value="${yearSale.phoneNum}" pattern="#,##0"/>
																</td>
																<td width="100" align="center" valign="middle">
																	<fmt:formatNumber value="${yearSale.visitorNum}" pattern="#,##0"/>
																</td>
																<td width="100" align="center" valign="middle">
																	<fmt:formatNumber value="${yearSale.sumNum}" pattern="#,##0"/>
																</td>
																<td width="100" align="center" valign="middle">
																	<fmt:formatNumber value="${yearSale.sumArea == null ? 0 : yearSale.sumArea}" pattern="#,##0.00"/>
																</td>
																<td width="100" align="center" valign="middle">
																	<fmt:formatNumber value="${yearSale.sumMoney}" pattern="#,##0.00"/>
																</td>
																<td width="100" align="center" valign="middle">
																	<fmt:formatNumber value="${yearSale.intentionNum}" pattern="#,##0"/>
																</td>
																
																<td align="center" valign="middle">
																	<a class="ablue"  href= "${session.monthUrl}month" target="_self">月曲线</a>
																</td>

															</tr>

														<%--
															<tr onMouseOver="this.style.backgroundColor='#ffffbf';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" align="center">
																<td colspan="3"></td>
																<td>
																	累计
																</td>
																<td>
																	<fmt:formatNumber value="${allSale.phoneNum}" pattern="#,##0"/>
																</td>
																<td>
																	<fmt:formatNumber value="${allSale.visitorNum}" pattern="#,##0"/>
																</td>
																<td>
																	<fmt:formatNumber value="${allSale.sumNum}" pattern="#,##0"/>
																</td>
																<td>
																	<fmt:formatNumber value="${allSale.sumArea}" pattern="#,##0.00"/>
																</td>
																<td>
																	<fmt:formatNumber value="${allSale.sumMoney}" pattern="#,##0.00"/>
																</td>
																<td>
																	<fmt:formatNumber value="${allSale.intentionNum}" pattern="#,##0"/>
																</td>
																<td>&nbsp;</td>

															</tr>
															
															 --%>
															
															<tr onMouseOver="this.style.backgroundColor='#ffffbf';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
																align="center">
																<td colspan="3"></td>
																<td align="center" valign="middle">
																	开盘至今
																</td>
																<td width="100" align="center" valign="middle">
																	<fmt:formatNumber value="${allSale.phoneNum}" pattern="#,##0"/>
																</td>
																<td width="100" align="center" valign="middle">
																	<fmt:formatNumber value="${allSale.visitorNum}" pattern="#,##0"/>
																</td>
																<td width="100" align="center" valign="middle">
																	<fmt:formatNumber value="${allSale.sumNum}" pattern="#,##0"/>
																</td>
																<td width="100" align="center" valign="middle">
																	<fmt:formatNumber value="${allSale.sumArea == null ? 0 : allSale.sumArea}" pattern="#,##0.00"/>
																</td>
																<td width="100" align="center" valign="middle">
																	<fmt:formatNumber value="${allSale.sumMoney}" pattern="#,##0.00"/>
																</td>
																<td width="100" align="center" valign="middle">
																	<fmt:formatNumber value="${allSale.intentionNum}" pattern="#,##0"/>
																</td>
																<td>&nbsp;</td>

															</tr>

															<tr class="gboxbg">
																<td colspan="12" align="center">
																  <s:if test="#session.isCompanyButtomShow == true">
																  	<button id="showSaleCompanyList">公司销售列表</button>
																	<button id="showSaleProjectList">项目销售列表</button>
																	<!--
																	<a class="ablue" id="showSaleCompanyList" href="#" onclick="return false;">公司销售列表</a>
																	<a class="ablue" id="showSaleProjectList" href="#" onclick="return false;">项目销售列表</a>
																	-->
																  </s:if>	
																  <s:else>
																  	<span>项目销售列表</span>
																  </s:else>
																</td>
																
															</tr>

											<tr>
												<td colspan="13">
												
												<!--  列表 top -->
												
												<s:if test="#session.isCompanyShow == true">
													<div class="gbox1" id="saleCompanyList" style="display:block">
												 </s:if>
												 <s:else>
												 	<div class="gbox1" id="saleCompanyList" style="display:none">
												 </s:else>
													  
														<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox">
															<tr class="gboxbg" align="center" valign="middle" style="line-height:16px">

																<td width="100" align="center" valign="middle">
																	公司名称
																</td>

																<td width="50" align="center" valign="middle" title="当天来电(组)" style="background:#CCFFFF">
																	来电(组)
																</td>
																<td width="50" align="center" valign="middle" title="当天来访(个)" style="background:#CCFFFF">
																	来访(个)
																</td>
																
																<td width="50" align="center" valign="middle" style="background:#CCFFFF">
	<table width="100%" border="0" align="center" cellspacing="0">
      <tr>
        <td width="90%" align="center" valign="middle" title="销售套数(套)">套数(套)</td>
        <td align="center" valign="middle">
		<table width="100%" border="0" cellspacing="0">
          <tr>
            <td><a href="${session.retUrl}&comOrderId=221"><img src="images/blue/upn.gif" width="9" height="10" border="0" /></a></td>
          </tr>
          <tr>
            <td><a href="${session.retUrl}&comOrderId=211"><img src="images/blue/downopen.gif" width="9" height="10" border="0" /></a></td>
          </tr>
        </table>
	  </td>
      </tr>
      </table></td>
	  
																<td width="50" align="center" valign="middle" title="销售面积(㎡)" style="background:#CCFFFF">
																	面积(㎡)
																</td>
																<td width="50" align="center" valign="middle" style="background:#CCFFFF">
	<table width="100%" border="0" align="center" cellspacing="0">
      <tr>
        <td width="90%" align="center" valign="middle" title="销售金额(万元)">金额(万元)</td>
        <td align="center" valign="middle">
		<table width="100%" border="0" cellspacing="0">
          <tr>
            <td><a href="${session.retUrl}&comOrderId=22"><img src="images/blue/upn.gif" width="9" height="10" border="0" /></a></td>
          </tr>
          <tr>
            <td><a href="${session.retUrl}&comOrderId=21"><img src="images/blue/downopen.gif" width="9" height="10" border="0" /></a></td>
          </tr>
        </table>
	  </td>
      </tr>
      </table></td>
																<td width="50" align="center" valign="middle" style="background:#CCFFFF">
																	认筹(次) 
																</td>

																<td width="50" align="center" valign="middle" style="background:#66FFFF">
	<table width="100%" border="0" align="center" cellspacing="0">
      <tr>
        <td width="90%" align="center" valign="middle" title="周销售套数(套)">周套数(套)</td>
        <td align="center" valign="middle">
		<table width="100%" border="0" cellspacing="0">
          <tr>
            <td><a href="${session.retUrl}&comOrderId=241"><img src="images/blue/upn.gif" width="9" height="10" border="0" /></a></td>
          </tr>
          <tr>
            <td><a href="${session.retUrl}&comOrderId=231"><img src="images/blue/downopen.gif" width="9" height="10" border="0" /></a></td>
          </tr>
        </table>
	  </td>
      </tr>
      </table></td>
	  
																<td width="50" align="center" valign="middle" title="周销售面积(㎡)" style="background:#66FFFF">
																	周面积(㎡)
																</td>
																
																<td width="50" align="center" valign="middle" style="background:#66FFFF">
	<table width="100%" border="0" align="center" cellspacing="0">
      <tr>
        <td width="90%" align="center" valign="middle" title="周销售金额(万元)">周金额(万元)</td>
        <td align="center" valign="middle">
		<table width="100%" border="0" cellspacing="0">
           <tr>
            <td><a href="${session.retUrl}&comOrderId=24"><img src="images/blue/upn.gif" width="9" height="10" border="0" /></a></td>
          </tr>
          <tr>
            <td><a href="${session.retUrl}&comOrderId=23"><img src="images/blue/downopen.gif" width="9" height="10" border="0" /></a></td>
          </tr>
        </table>
	  </td>
      </tr>
      </table></td>

																<td width="50" align="center" valign="middle" style="background:#aee459">
	<table width="100%" border="0" align="center" cellspacing="0">
      <tr>
        <td width="90%" align="center" valign="middle" title="月销售套数(套)">月套数(套)</td>
        <td align="center" valign="middle">
		<table width="100%" border="0" cellspacing="0">
          <tr>
            <td><a href="${session.retUrl}&comOrderId=261"><img src="images/blue/upn.gif" width="9" height="10" border="0" /></a></td>
          </tr>
          <tr>
            <td><a href="${session.retUrl}&comOrderId=251"><img src="images/blue/downopen.gif" width="9" height="10" border="0" /></a></td>
          </tr>
        </table>
	  </td>
      </tr>
      </table></td>
	  
	  
																<td width="50" align="center" valign="middle" title="月销售面积(㎡)" style="background:#aee459">
																	月面积(㎡)
																</td>
																
																<td width="50" align="center" valign="middle" style="background:#aee459">
	<table width="100%" border="0" align="center" cellspacing="0">
      <tr>
        <td width="90%" align="center" valign="middle" title="月销售金额(万元)">月金额(万元)</td>
        <td align="center" valign="middle">
		<table width="100%" border="0" cellspacing="0">
          <tr>
            <td><a href="${session.retUrl}&comOrderId=26"><img src="images/blue/upn.gif" width="9" height="10" border="0" /></a></td>
          </tr>
          <tr>
            <td><a href="${session.retUrl}&comOrderId=25"><img src="images/blue/downopen.gif" width="9" height="10" border="0" /></a></td>
          </tr>
        </table>
	  </td>
      </tr>
      </table></td>

																<td width="50" align="center" valign="middle" style="background:#ffdc92">
	<table width="100%" border="0" align="center" cellspacing="0">
      <tr>
        <td width="90%" align="center" valign="middle" title="年销售套数(套)">年套数(套)</td>
        <td align="center" valign="middle">
		<table width="100%" border="0" cellspacing="0">
           <tr>
            <td><a href="${session.retUrl}&comOrderId=281"><img src="images/blue/upn.gif" width="9" height="10" border="0" /></a></td>
          </tr>
          <tr>
            <td><a href="${session.retUrl}&comOrderId=271"><img src="images/blue/downopen.gif" width="9" height="10" border="0" /></a></td>
          </tr>
        </table>
	  </td>
      </tr>
      </table></td>
	  
																<td width="50" align="center" valign="middle" title="年销售面积(㎡)" style="background:#ffdc92">
																	年面积(㎡)
																</td>
																
																<td width="50" align="center" valign="middle" style="background:#ffdc92">
	<table width="100%" border="0" align="center" cellspacing="0">
      <tr>
        <td width="90%" align="center" valign="middle" title="年销售金额(万元)">年金额(万元)</td>
        <td align="center" valign="middle">
		<table width="100%" border="0" cellspacing="0">
          <tr>
            <td><a href="${session.retUrl}&comOrderId=28"><img src="images/blue/upn.gif" width="9" height="10" border="0" /></a></td>
          </tr>
          <tr>
            <td><a href="${session.retUrl}&comOrderId=27"><img src="images/blue/downopen.gif" width="9" height="10" border="0" /></a></td>
          </tr>
        </table>
	  </td>
      </tr>
      </table></td>

																															
																<td width="50" align="center" valign="middle">
																	汇总
																</td>

															</tr>


													<s:if test="#session.isCompanyListEmptyShow == true">
														<s:iterator value="#request.searchTimeCompanyList" id="c">
															<tr onMouseOver="this.style.backgroundColor='#ffffbf';" onMouseOut="this.style.backgroundColor=''" 
																bgcolor="#FFFFFF" align="center" valign="middle">
																<td align="center" valign="middle" class="fontblue" title="点击查询周明细">
		<a href="./sale_hengda/search/sale.action?ret=all&saleCond.date1=${session.weekFirst}&saleCond.date2=${session.monitorDate}
&saleCond.companyId=<s:property value='#c.companyId'/>&saleCond.projectId=<s:property value='#c.projectId'/>&fromEmptyCompany=fromEmptyCompany" 
																		target="_self"><s:property value="#c.descCompanyName" />
																	</a>
																</td>
																<td align="center" valign="middle">
																</td>
																<td align="center" valign="middle">
																</td>
																<td align="center" valign="middle">
																</td>
																<td align="center" valign="middle">
																</td>
																<td align="center" valign="middle">
																</td>
																<td align="center" valign="middle">
																</td>

																<td align="center" valign="middle">
																</td>
																<td align="center" valign="middle">
																</td>
																<td align="center" valign="middle">
																</td>

																<td align="center" valign="middle">
																</td>
																<td align="center" valign="middle">
																</td>
																<td align="center" valign="middle">
																</td>

																<td align="center" valign="middle">
																</td>
																<td align="center" valign="middle">
																</td>
																<td align="center" valign="middle">
																</td>
																
																
																<td align="center" valign="middle">
<a href="./sale_hengda/search/all.action?saleCond.monitorDate=<s:property value='#c.monitorDate'/>&saleCond.companyId=<s:property value='#c.companyId'/>" 
	target="_self"  class="ablue" >查看</a>
																</td>

															</tr>
														</s:iterator>
													
													</s:if>
													<s:else>
													
														<s:iterator value="#request.searchTimeCompanyList" id="c">
															<tr onMouseOver="this.style.backgroundColor='#ffffbf';" onMouseOut="this.style.backgroundColor=''" 
																bgcolor="#FFFFFF" align="center" valign="middle">
																<td align="center" valign="middle" class="fontblue" title="点击查询周明细">
		<a href="./sale_hengda/search/sale.action?ret=all&saleCond.date1=${session.weekFirst}&saleCond.date2=${session.monitorDate}
&saleCond.companyId=<s:property value='#c.companyId'/>&saleCond.projectId=<s:property value='#c.projectId'/>" 
																		target="_self"><s:property value="#c.descCompanyName" />
																	</a>
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
																	<fmt:formatNumber value="${c.intentionNum}" pattern="#,##0"/>
																</td>

																<td align="center" valign="middle">
																	<fmt:formatNumber value="${c.sumNum_w}" pattern="#,##0"/>
																</td>
																<td align="center" valign="middle">
																	<fmt:formatNumber value="${c.sumArea_w}" pattern="#,##0.00"/>
																</td>
																<td align="center" valign="middle">
																	<fmt:formatNumber value="${c.sumMoney_w}" pattern="#,##0.00"/>
																</td>

																<td align="center" valign="middle">
																	<fmt:formatNumber value="${c.sumNum_m}" pattern="#,##0"/>
																</td>
																<td align="center" valign="middle">
																	<fmt:formatNumber value="${c.sumArea_m}" pattern="#,##0.00"/>
																</td>
																<td align="center" valign="middle">
																	<fmt:formatNumber value="${c.sumMoney_m}" pattern="#,##0.00"/>
																</td>

																<td align="center" valign="middle">
																	<fmt:formatNumber value="${c.sumNum_y}" pattern="#,##0"/>
																</td>
																<td align="center" valign="middle">
																	<fmt:formatNumber value="${c.sumArea_y}" pattern="#,##0.00"/>
																</td>
																<td align="center" valign="middle">
																	<fmt:formatNumber value="${c.sumMoney_y}" pattern="#,##0.00"/>
																</td>
																
																
																<td align="center" valign="middle">
<a href="./sale_hengda/search/all.action?saleCond.monitorDate=<s:property value='#c.monitorDate'/>&saleCond.companyId=<s:property value='#c.companyId'/>" 
	target="_self"  class="ablue" >查看</a>
																</td>

															</tr>
														</s:iterator>
													
													</s:else>


													</table>
												</div>
												<!-- 列表 end -->
												
											

													<!--  列表 top -->
													
													<s:if test="#session.isCompanyShow == true">
														<div class="gbox1" id="saleProjectList" style="display:none">
													 </s:if>
													 <s:else>
														<div class="gbox1" id="saleProjectList" style="display:block">
													 </s:else>

														<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox">
															<tr class="gboxbg" align="center" valign="middle" style="line-height:16px">

																<td width="100" align="center" valign="middle">
																	项目名称
																</td>

																<td width="50" align="center" valign="middle" title="当天来电(组)" style="background:#CCFFFF">
																	来电(组)
																</td>
																<td width="50" align="center" valign="middle" title="当天来访(个)" style="background:#CCFFFF">
																	来访(个)
																</td>
																
																<td width="50" align="center" valign="middle" style="background:#CCFFFF">
	<table width="100%" border="0" align="center" cellspacing="0">
      <tr>
        <td width="90%" align="center" valign="middle" title="销售套数(套)">套数(套)</td>
        <td align="center" valign="middle">
		<table width="100%" border="0" cellspacing="0">
          <tr>
            <td><a href="${session.retUrl}&orderId=121"><img src="images/blue/upn.gif" width="9" height="10" border="0" /></a></td>
          </tr>
          <tr>
            <td><a href="${session.retUrl}&orderId=111"><img src="images/blue/downopen.gif" width="9" height="10" border="0" /></a></td>
          </tr>
        </table>
	  </td>
      </tr>
      </table></td>
																
																<td width="50" align="center" valign="middle" title="销售面积(㎡)" style="background:#CCFFFF">
																	面积(㎡)
																</td>
																
			<td width="50" align="center" valign="middle" style="background:#CCFFFF">
	<table width="100%" border="0" align="center" cellspacing="0">
      <tr>
        <td width="90%" align="center" valign="middle" title="销售金额(万元)">金额(万元)</td>
        <td align="center" valign="middle">
		<table width="100%" border="0" cellspacing="0">
          <tr>
            <td><a href="${session.retUrl}&orderId=12"><img src="images/blue/upn.gif" width="9" height="10" border="0" /></a></td>
          </tr>
          <tr>
            <td><a href="${session.retUrl}&orderId=11"><img src="images/blue/downopen.gif" width="9" height="10" border="0" /></a></td>
          </tr>
        </table>
	  </td>
      </tr>
      </table></td>
															
																
																<td width="50" align="center" valign="middle" style="background:#CCFFFF">
																	认筹(次)
																</td>

																
																<td width="50" align="center" valign="middle" style="background:#66FFFF">
	<table width="100%" border="0" align="center" cellspacing="0">
      <tr>
        <td width="90%" align="center" valign="middle" title="周销售套数(套)">周套数(套)</td>
        <td align="center" valign="middle">
		<table width="100%" border="0" cellspacing="0">
          <tr>
            <td><a href="${session.retUrl}&orderId=141"><img src="images/blue/upn.gif" width="9" height="10" border="0" /></a></td>
          </tr>
          <tr>
            <td><a href="${session.retUrl}&orderId=131"><img src="images/blue/downopen.gif" width="9" height="10" border="0" /></a></td>
          </tr>
        </table>
	  </td>
      </tr>
      </table></td>
																
																<td width="50" align="center" valign="middle" title="周销售面积(㎡)" style="background:#66FFFF">
																	周面积(㎡)
																</td>
																
																<td width="50" align="center" valign="middle" style="background:#66FFFF">
	<table width="100%" border="0" align="center" cellspacing="0">
      <tr>
        <td width="90%" align="center" valign="middle" title="周销售金额(万元)">周金额(万元)</td>
        <td align="center" valign="middle">
		<table width="100%" border="0" cellspacing="0">
          <tr>
            <td><a href="${session.retUrl}&orderId=14"><img src="images/blue/upn.gif" width="9" height="10" border="0" /></a></td>
          </tr>
          <tr>
            <td><a href="${session.retUrl}&orderId=13"><img src="images/blue/downopen.gif" width="9" height="10" border="0" /></a></td>
          </tr>
        </table>
	  </td>
      </tr>
      </table></td>
																

																<td width="50" align="center" valign="middle" style="background:#aee459">
	<table width="100%" border="0" align="center" cellspacing="0">
      <tr>
        <td width="90%" align="center" valign="middle" title="月销售套数(套)">月套数(套)</td>
        <td align="center" valign="middle">
		<table width="100%" border="0" cellspacing="0">
          <tr>
            <td><a href="${session.retUrl}&orderId=161"><img src="images/blue/upn.gif" width="9" height="10" border="0" /></a></td>
          </tr>
          <tr>
            <td><a href="${session.retUrl}&orderId=151"><img src="images/blue/downopen.gif" width="9" height="10" border="0" /></a></td>
          </tr>
        </table>
	  </td>
      </tr>
      </table></td>
	  
																<td width="50" align="center" valign="middle" title="月销售面积(㎡)" style="background:#aee459">
																	月面积(㎡)
																</td>
																
																<td width="50" align="center" valign="middle" style="background:#aee459">
	<table width="100%" border="0" align="center" cellspacing="0">
      <tr>
        <td width="90%" align="center" valign="middle" title="月销售金额(万元)">月金额(万元)</td>
        <td align="center" valign="middle">
		<table width="100%" border="0" cellspacing="0">
          <tr>
            <td><a href="${session.retUrl}&orderId=16"><img src="images/blue/upn.gif" width="9" height="10" border="0" /></a></td>
          </tr>
          <tr>
            <td><a href="${session.retUrl}&orderId=15"><img src="images/blue/downopen.gif" width="9" height="10" border="0" /></a></td>
          </tr>
        </table>
	  </td>
      </tr>
      </table></td>
																
															


																<td width="50" align="center" valign="middle" style="background:#ffdc92">
	<table width="100%" border="0" align="center" cellspacing="0">
      <tr>
        <td width="90%" align="center" valign="middle" title="年销售套数(套)">年套数(套)</td>
        <td align="center" valign="middle">
		<table width="100%" border="0" cellspacing="0">
           <tr>
            <td><a href="${session.retUrl}&orderId=181"><img src="images/blue/upn.gif" width="9" height="10" border="0" /></a></td>
          </tr>
          <tr>
            <td><a href="${session.retUrl}&orderId=171"><img src="images/blue/downopen.gif" width="9" height="10" border="0" /></a></td>
          </tr>
        </table>
	  </td>
      </tr>
      </table></td>
																
																<td width="50" align="center" valign="middle" title="年销售面积(㎡)" style="background:#ffdc92">
																	年面积(㎡)
																</td>
																
																<td width="50" align="center" valign="middle" style="background:#ffdc92">
	<table width="100%" border="0" align="center" cellspacing="0">
      <tr>
        <td width="90%" align="center" valign="middle" title="年销售金额(万元)">年金额(万元)</td>
        <td align="center" valign="middle">
		<table width="100%" border="0" cellspacing="0">
           <tr>
            <td><a href="${session.retUrl}&orderId=18"><img src="images/blue/upn.gif" width="9" height="10" border="0" /></a></td>
          </tr>
          <tr>
            <td><a href="${session.retUrl}&orderId=17"><img src="images/blue/downopen.gif" width="9" height="10" border="0" /></a></td>
          </tr>
        </table>
	  </td>
      </tr>
      </table></td>

																																
																<td width="50" align="center" valign="middle">
																	最后录入时间
																</td>
																
																<td width="50" align="center" valign="middle">
																	汇总
																</td>

															</tr>


													<s:if test="#session.isProjectListEmptyShow == true">
														<s:iterator value="#request.searchTimeList" id="c">
															<tr onMouseOver="this.style.backgroundColor='#ffffbf';" onMouseOut="this.style.backgroundColor=''" 
																bgcolor="#FFFFFF" align="center" valign="middle">
																<td align="center" valign="middle" class="fontblue" title="点击查询周明细">
		<a href="./sale_hengda/search/sale.action?ret=all&saleCond.date1=${session.weekFirst}&saleCond.date2=${session.monitorDate}
&saleCond.companyId=<s:property value='#c.companyId'/>&saleCond.projectId=<s:property value='#c.projectId'/>" 
																		target="_self"><s:property value="#c.descProjectName" />
																	</a>
																</td>
																<td align="center" valign="middle">
																</td>
																<td align="center" valign="middle">
																</td>
																<td align="center" valign="middle">
																</td>
																<td align="center" valign="middle">
																</td>
																<td align="center" valign="middle">
																</td>
																<td align="center" valign="middle">
																</td>

																<td align="center" valign="middle">
																</td>
																<td align="center" valign="middle">
																</td>
																<td align="center" valign="middle">
																</td>

																<td align="center" valign="middle">
																</td>
																<td align="center" valign="middle">
																</td>
																<td align="center" valign="middle">
																</td>

																<td align="center" valign="middle">
																</td>
																<td align="center" valign="middle">
																</td>
																<td align="center" valign="middle">
																</td>
																
																<td align="center" valign="middle">
																</td>
																
																
																<td align="center" valign="middle">
<a href="./sale_hengda/search/all.action?fromList=fromList&saleCond.monitorDate=<s:property value='#c.monitorDate'/>&saleCond.companyId=<s:property value='#c.companyId'/>&saleCond.projectId=<s:property value='#c.projectId'/>" 
	target="_self"  class="ablue" >查看</a>
																</td>

															</tr>
														</s:iterator>
													</s:if>
													
													<s:else>
														<s:iterator value="#request.searchTimeList" id="c">
															<tr onMouseOver="this.style.backgroundColor='#ffffbf';" onMouseOut="this.style.backgroundColor=''" 
																bgcolor="#FFFFFF" align="center" valign="middle">
																<td align="center" valign="middle" class="fontblue" title="点击查询周明细">
		<a href="./sale_hengda/search/sale.action?ret=all&saleCond.date1=${session.weekFirst}&saleCond.date2=${session.monitorDate}
&saleCond.companyId=<s:property value='#c.companyId'/>&saleCond.projectId=<s:property value='#c.projectId'/>" 
																		target="_self"><s:property value="#c.descProjectName" />
																	</a>
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
																	<fmt:formatNumber value="${c.intentionNum}" pattern="#,##0"/>
																</td>

																<td align="center" valign="middle">
																	<fmt:formatNumber value="${c.sumNum_w}" pattern="#,##0"/>
																</td>
																<td align="center" valign="middle">
																	<fmt:formatNumber value="${c.sumArea_w}" pattern="#,##0.00"/>
																</td>
																<td align="center" valign="middle">
																	<fmt:formatNumber value="${c.sumMoney_w}" pattern="#,##0.00"/>
																</td>

																<td align="center" valign="middle">
																	<fmt:formatNumber value="${c.sumNum_m}" pattern="#,##0"/>
																</td>
																<td align="center" valign="middle">
																	<fmt:formatNumber value="${c.sumArea_m}" pattern="#,##0.00"/>
																</td>
																<td align="center" valign="middle">
																	<fmt:formatNumber value="${c.sumMoney_m}" pattern="#,##0.00"/>
																</td>

																<td align="center" valign="middle">
																	<fmt:formatNumber value="${c.sumNum_y}" pattern="#,##0"/>
																</td>
																<td align="center" valign="middle">
																	<fmt:formatNumber value="${c.sumArea_y}" pattern="#,##0.00"/>
																</td>
																<td align="center" valign="middle">
																	<fmt:formatNumber value="${c.sumMoney_y}" pattern="#,##0.00"/>
																</td>
																
																<td align="center" valign="middle">
																	<s:date name="#c.lastModTime" format="yyyy-MM-dd HH:mm:ss"/> 
																</td>
															
																<td align="center" valign="middle">
<a href="./sale_hengda/search/all.action?fromList=fromList&saleCond.monitorDate=<s:property value='#c.monitorDate'/>&saleCond.companyId=<s:property value='#c.companyId'/>&saleCond.projectId=<s:property value='#c.projectId'/>" 
	target="_self"  class="ablue" >查看</a>
																</td>

															</tr>
														</s:iterator>
													</s:else>

													</table>
												</div>
												<!-- 列表 end -->
											
											
																								

											</td>
										</tr>


									</table>
								</div>

								<!-- 列表 end -->
							</td>
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
