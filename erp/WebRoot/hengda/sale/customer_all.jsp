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
		
		<title>客户汇总</title>
		
		<script language="javascript" type="text/javascript">
			$().ready(function(){
			
				$("#showSaleCompanyList").click(function(){
					$("#comHengDaCustomerList").show('normal');
					$("#proHengDaCustomerList").hide('normal');
				});
			
				$("#showSaleProjectList").click(function(){
					$("#comHengDaCustomerList").hide('normal');
					$("#proHengDaCustomerList").show('normal');
				});
				
				$("#customerCond_companyId").change(function(){
					companyToProject(this.value, "customerCond_projectId");
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
											<a href="./sale_hengda/customer/all.action?from=left" target="_self">客户汇总</a>
										</div>
										<div class="right99"></div>
										<div class="blueline"></div>

										<div class="c"></div>
										<div class="c"></div>



										<table width="100%" border="0" align="left" cellspacing="0">

											<!-- 搜索表单 top -->

											<form action="./sale_hengda/customer/all.action?from=left" method="get">
												<tr style="white-space: nowrap">
													<td height="0" align="left" colspan="6">
														<label>
															<span>日期</span>
														</label>
														<input class="Wdate" type="text" id="date2" name="customerCond.date2" 
															style="width: 90px" value="${customerCond.date2}" onClick="WdatePicker()" />
														<label>
															<span>所属公司</span>
														</label>
														<s:select list="selCompany" name="customerCond.companyId" value="#session.companyId" />
														<label>
															<span>所属项目</span>
														</label>
														<s:select list="selProject" name="customerCond.projectId" value="#session.projectId" />
														<input type="submit" value="  搜索  " id="searchSubmit" onClick="return check();" />
													</td>

												</tr>

											</form>

											<!-- 搜索表单 end -->



											<tr>
												<td colspan="6">

													<!--  列表 top -->

													<div class="gbox1">

														<table width="75%" border="0" align="left" cellpadding="0" cellspacing="1" class="gbox">


															<tr class="gboxbg" align="center" style="white-space: nowrap">
																<td align="center" width="467">
																	统计时间段																</td>

																<td width="291" align="center" valign="middle">
																	统计类型																</td>
																<td align="center" valign="middle">
																	数量
																</td>
																


															</tr>

															<tr onMouseOver="this.style.backgroundColor='#ffffbf';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
																<td  align="center" style="white-space: nowrap">
																	<span style="width: 90px">${customerCond.date2}</span>
																</td>

																<td align="center" valign="middle">
																	当日
																</td>
																<td width="236" align="center" valign="middle">
																	${session.customerListSize}
															  </td>
																

															</tr>


															<tr onMouseOver="this.style.backgroundColor='#ffffbf';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
																style="white-space: nowrap">

																<td align="center"  style="white-space: nowrap">
																	&nbsp;
																	<span style="width: 90px">${session.weekFirst}</span>
																	-
																	<span style="width: 90px">${customerCond.date2}</span>
																	&nbsp;
																</td>
																<td align="center" valign="middle">
																	本周
																</td>
																<td width="236" align="center" valign="middle">
																	${session.weekListSize}
															  </td>
																

															</tr>

															<tr onMouseOver="this.style.backgroundColor='#ffffbf';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">

																<td align="center"  style="white-space: nowrap">
																	&nbsp;
																	<span style="width: 90px">${session.monthFirst}</span>
																	-
																	<span style="width: 90px">${customerCond.date2}</span>
																	&nbsp;
																</td>
																<td align="center" valign="middle">
																	本月
																</td>
																<td width="236" align="center" valign="middle">
																	${session.monthListSize}
															  </td>
																

															</tr>

															<tr onMouseOver="this.style.backgroundColor='#ffffbf';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">

																<td align="center"  style="white-space: nowrap">
																	&nbsp;
																	<span style="width: 90px">${session.yearFirst}</span>
																	-
																	<span style="width: 90px">${customerCond.date2}</span>
																	&nbsp;
																</td>
																<td align="center" valign="middle">
																	本年
																</td>
																<td width="236" align="center" valign="middle">
																	${session.yearListSize}
															  </td>
																

															</tr>

															<tr onMouseOver="this.style.backgroundColor='#ffffbf';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" align="center">
																<td ></td>
																<td>
																	累计
																</td>
																<td>
																	${session.allListSize}
																</td>
																

															</tr>
															

															<tr class="gboxbg">
																<td colspan="12" align="center">
																  <s:if test="#session.isCompanyButtomShow == true">
																  	<button id="showSaleCompanyList">公司客户汇总列表</button>
																	<button id="showSaleProjectList">项目客户汇总列表</button>
																	<!--
																	<a class="ablue" id="showSaleCompanyList" href="#" onclick="return false;">公司销售列表</a>
																	<a class="ablue" id="showSaleProjectList" href="#" onclick="return false;">项目销售列表</a>
																	-->
																  </s:if>	
																  <s:else>
																  	<span>项目客户汇总列表</span>
																  </s:else>
																</td>
																
															</tr>

											<tr>
												<td colspan="13">
												
												<!--  列表 top -->
												
												<s:if test="#session.isCompanyShow == true">
													<div class="gbox1" id="comHengDaCustomerList" style="display:block">
												 </s:if>
												 <s:else>
												 	<div class="gbox1" id="comHengDaCustomerList" style="display:none">
												 </s:else>
													  
														<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox">
															<tr class="gboxbg" align="center" valign="middle" style="line-height:16px">

																<td align="center" valign="middle">
																	公司名称
																</td>

																<td align="center" valign="middle" title="当日数量">
																	当日数量
																</td>
																<td align="center" valign="middle" title="本周数量">
																	本周数量
																</td>
																<td align="center" valign="middle" title="本月数量">
																	本月数量
																</td>
																<td align="center" valign="middle" title="本年数量">
																	本年数量
																</td>

															</tr>

													
														<s:iterator value="#session.comHengDaCustomerList" id="c">
															<tr onMouseOver="this.style.backgroundColor='#ffffbf';" onMouseOut="this.style.backgroundColor=''" 
																bgcolor="#FFFFFF" align="center" valign="middle">
																<td align="center" valign="middle">
																	<s:property value="#c.name" />
																</td>
																<td align="center" valign="middle">
																	<s:property value="#c.dayCount" />
																</td>
																<td align="center" valign="middle">
																	<s:property value="#c.weekCount" />
																</td>
																<td align="center" valign="middle">
																	<s:property value="#c.monthCount" />
																</td>
																<td align="center" valign="middle">
																	<s:property value="#c.yearCount" />
																</td>
																

															</tr>
														</s:iterator>
													

													</table>
												</div>
												<!-- 列表 end -->
												
											

													<!--  列表 top -->
													
													<s:if test="#session.isCompanyShow == true">
														<div class="gbox1" id="proHengDaCustomerList" style="display:none">
													 </s:if>
													 <s:else>
														<div class="gbox1" id="proHengDaCustomerList" style="display:block">
													 </s:else>

														<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox">
															<tr class="gboxbg" align="center" valign="middle" style="line-height:16px">

																<td align="center" valign="middle">
																	项目名称
																</td>

																<td align="center" valign="middle" title="当日数量">
																	当日数量
																</td>
																<td align="center" valign="middle" title="本周数量">
																	本周数量
																</td>
																<td align="center" valign="middle" title="本月数量">
																	本月数量
																</td>
																<td align="center" valign="middle" title="本年数量">
																	本年数量
																</td>
																
			

															</tr>


														<s:iterator value="#session.proHengDaCustomerList" id="c">
															<tr onMouseOver="this.style.backgroundColor='#ffffbf';" onMouseOut="this.style.backgroundColor=''" 
																bgcolor="#FFFFFF" align="center" valign="middle">
																<td align="center" valign="middle">
																	<s:property value="#c.name" />
																</td>
																<td align="center" valign="middle">
																	<s:property value="#c.dayCount" />
																</td>
																<td align="center" valign="middle">
																	<s:property value="#c.weekCount" />
																</td>
																<td align="center" valign="middle">
																	<s:property value="#c.monthCount" />
																</td>
																<td align="center" valign="middle">
																	<s:property value="#c.yearCount" />
																</td>
																

															</tr>
														</s:iterator>

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
