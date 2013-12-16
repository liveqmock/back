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
		<style type="text/css">
.textOverFlow {
    width:250px;
 /*  overflow:hidden;
    text-overflow:ellipsis;
    white-space:nowrap;*/

  /*  border:1px solid #ddd;*/
}
</style>
		<script type="text/javascript">		
			var chart;
			var chart1;
			$(document).ready(function() {			
				chart = new Highcharts.Chart({
					chart: {
						renderTo: 'container',
						defaultSeriesType: 'line',
						marginRight: 50,
						marginBottom: 25
					},
				
					title: {
						text: '销售套数金额汇总'
					},
					xAxis: {
						categories: <s:property value="chartXAxis" escape="false"/>				
					},
					yAxis: [{ 
						title: {
						text: '',
						style: {
							color: '#4572A7'
						}
					},
					allowDecimals: false,
					min:0,
					labels: {
						formatter: function() {
							return this.value +'万元';
						},
						style: {
							color: '#4572A7'
						}
					}
					}, { 
						labels: {
							formatter: function() {
								return this.value +'套';
							},
							style: {
								color: '#89A54E'
							}
						},
						allowDecimals: false,
						min:0,
						title: {
							text: '',
							allowDecimals: false,min:0,
							style: {
								color: '#89A54E'
							}
						},
						opposite: true
					}],
					tooltip: {
						formatter: function() {
						var tips = ''+this.x +' ' + this.series.name +' :'+ this.y;
						if(this.series.name=="总金额"){
							tips += '万元';
						}
						else if(this.series.name=="总套数"){
							tips += '套';
						}
						return tips;
					}
					},
					legend: {
						layout: 'horizontal',
						align: 'right',
						verticalAlign: 'top',
						x: -40,
						y: 25,
						borderWidth: 1
					},
					series: <s:property value="chartSeries"  escape="false"/> 								
				});			

				
			});
				
</script>
		<title>恒大销售数据管理系统欢迎页</title>
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
					
					<td width="100%"  valign="top">
					<DIV style="WIDTH: 98%; HEIGHT: 100%; BACKGROUND-COLOR: #A4C3D7;padding: 1px">
						<%-- 基本table分割 ^^^^^^<td width="100%">^^^^^^^^^^^^^^^^^^^^^^--%>
						<%--main table开始 --%>
				
						<table width="100%" class="mainbg20111112" style="height: 100%">
							<tr >
								<td align="center" class="lable20111112" >
									<label for="topdate">
										<b>日期</b>
									</label>
									<input class="input" id="topdate" name="" type="text" value="${datenow }" disabled="disabled"  />
									<label for="topdate">
										<b>截止时间</b>
									</label>
									<input class="input"  id="topdate" name="" type="text" value="${time }" disabled="disabled" />
									<s:if test="#session.butindex == 'isMultiCompany'">
									<input class="icon" id="topdate" name="" type="button" value="  全国查询 "  onClick="javascript:window.location.href = '<%=basePath %>sale_hengda/search/all.action?from=left'" /> 
									<input class="icon" id="inCount" name="" type="button" value="  录入情况查询 "  onClick="javascript:window.location.href = '<%=basePath %>sale_hengda/search/inCount.action'" /> 
									</s:if>
									<s:if test="#session.butindex == 'isMultiProject'">
									<input  class="icon" id="topdate" name="" type="button" value="  区域查询  " onClick="javascript:window.location.href = '<%=basePath %>sale_hengda/search/time.action?from=left'"/> 
									 </s:if>
									
												
																	
									<input  class="icon" id="topdate" name="" type="button" value="  录入数据  " onClick="javascript:window.location.href = '<%=basePath %>sale_hengda/input/for_sale.action'"/>		
								</td>
						
							</tr>
							<tr valign="top">
								<td>
									<table width="100%" border="0" align="right" cellspacing="0">
										<tr>
											<td width="3" height="3" class="leftbg01"></td>
											<td class="midbg01"></td>
											<td width="2" height="3" background="../../images/righttop.gif"></td>
										</tr>
										<tr>
											<td width="3" class="leftbg02"></td>
											<td bgcolor="#FFFFFF">
												<table width="100%" border="0" align="center" cellspacing="0">
													<tr>
														<td width="30%" valign="top">
															<table width="100%" border="0" align="center" cellspacing="0">
																<tr>
																	<td height="32" colspan="3">
																		<span class="titleblue">最新录入</span>
																		
																	</td>
																</tr>
																<tr>
																	<td colspan="3" background="images/blueline.jpg" class="blueline20111105"></td>
																</tr>
																<s:iterator value="#request.lastMonitorList" id="c">
																	<tr style="padding: 20px;margin: 20px">
																	<td height="18" valign="top">
																		<img src="images/arrow_collapse.gif" width="10" height="10" alt="arrow" />
																	</td>
																	<td height="22" valign="top" style="padding: 3px 0px 3px 0px;">
																		<div class = "textOverFlow"><font color="red"> ${descProjectName }&nbsp;</font>来电<font color="red">${phoneNum }</font>次,来访<font color="red">${visitorNum }</font>人,售出住宅<font color="red">${houseNum }</font>套,
																		车位<font color="red">${parkNum }</font>个,商铺<font color="red">${shopNum }</font>个,成交金额<font color="red">${sumMoney/10000 }</font>万元.
																		<img src="images/new.gif" width="16" height="10" alt="new" />
																		</div>
																		
																	</td>
																	<td width="30" align="right"  valign="top" nowrap="nowrap">
																		${dayString }
																	</td>
																</tr>
																</s:iterator>
																
															
															</table>
															<table width="100%" border="0" align="left" cellspacing="0" >
																<tr>
																	<td height="32" colspan="3">
																		<span class="titleblue">最新通告</span>
																		
																	</td>
																</tr>
																<tr>
																	<td colspan="3" background="images/blueline.jpg" class="blueline20111105"></td>
																</tr>
																<%-- itr Article --%>
																
																<s:iterator value="#request.lastArticleList" id="b">
																	<tr>
																	<td height="18">
																		<img src="images/arrow_collapse.gif" width="10" height="10" alt="arrow" />
																	</td>
																	<td height="22" nowrap="nowrap">
																		<a href="<%=basePath %>sale_hengda/article/show.action?id=${id}" target="_self">${title }：${summary }</a>
																	</td>
																	<td width="10%" nowrap="nowrap">
																		${dayString }
																	</td>
																	</tr>
																</s:iterator>
																
															</table> 
															
														</td>
														<td width="100%" rowspan="2" valign="top">
															<table width="100%" border="0" align="right" cellspacing="0" class="picbox">
																
																<tr>
																	<td colspan="2" rowspan="11" bgcolor="#FFFFFF">
																		<div id="container" style="min-width:500px ;height: 500px; margin: 0 0 0 0;overflow: inherit"></div>
																	</td>
																	
																</tr>
																<%--
      <tr>
        <td bgcolor="#FFFFFF"><input type="checkbox" name="checkbox2" id="checkbox2" /></td>
        <td bgcolor="#FFFFFF" class="bluefont">中山</td>
      </tr>
      <tr>
        <td bgcolor="#FFFFFF"><input type="checkbox" name="checkbox2" id="checkbox2" /></td>
        <td bgcolor="#FFFFFF" class="bluefont">安徽</td>
      </tr>
      <tr>
        <td bgcolor="#FFFFFF"><input type="checkbox" name="checkbox2" id="checkbox2" /></td>
        <td bgcolor="#FFFFFF" class="bluefont">贵州</td>
      </tr>
      <tr>
        <td bgcolor="#FFFFFF"><input type="checkbox" name="checkbox2" id="checkbox2" /></td>
        <td bgcolor="#FFFFFF" class="bluefont">云南</td>
      </tr>
      <tr>
        <td bgcolor="#FFFFFF"><input type="checkbox" name="checkbox2" id="checkbox2" /></td>
        <td bgcolor="#FFFFFF" class="bluefont">江苏</td>
      </tr>
      <tr>
        <td bgcolor="#FFFFFF"><input type="checkbox" name="checkbox2" id="checkbox2" /></td>
        <td bgcolor="#FFFFFF" class="bluefont">河南</td>
      </tr>
      <tr>
        <td bgcolor="#FFFFFF"><input type="checkbox" name="checkbox2" id="checkbox2" /></td>
        <td bgcolor="#FFFFFF" class="bluefont">湖南</td>
      </tr>
      <tr>
        <td bgcolor="#FFFFFF"><input type="checkbox" name="checkbox2" id="checkbox2" /></td>
        <td bgcolor="#FFFFFF" class="bluefont">四川</td>
      </tr>
      <tr>
        <td bgcolor="#FFFFFF"><input type="checkbox" name="checkbox2" id="checkbox2" /></td>
        <td bgcolor="#FFFFFF" class="bluefont">广西</td>
      </tr>
      <tr>
        <td bgcolor="#FFFFFF"><input type="checkbox" name="checkbox2" id="checkbox2" /></td>
        <td bgcolor="#FFFFFF" class="bluefont">湖北</td>
      </tr> --%>
															</table>
															<p>&nbsp;
																
															</p>
															<%--<table width="98%" border="0" align="right" cellspacing="0" class="picbox">
																<tr>
																	<td height="28" align="center" bgcolor="#FFFFFF" class="titleblue">
																		 广东合盈在售项目
																	</td>
																</tr>
																<tr>
																	<td bgcolor="#FFFFFF">
																		<div id="container1" style="width: 100%; height: 210px; margin: 0 auto"></div>
																	</td>
																</tr>
															</table> --%>
														</td>
													</tr>
													<tr>
														<td valign="top">
															<%--
															<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox">
																<tr class="gboxbg">
																	<td valign="top">
																		<strong> 其它更新公告</strong>
																	</td>
																</tr>
																<tr>
																	<td bgcolor="#FFFFFF">
																		<table width="98%" border="0">
																			<tr>
																				<td height="22">
																					2011-11-05更新：新增线形报表功能；
																				</td>
																			</tr>
																			<tr>
																				<td height="22">
																					2011-10-30更新：权限细化；
																				</td>
																			</tr>
																			<tr>
																				<td height="22">
																					2011-10-25更新：录入规则；
																				</td>
																			</tr>
																			<tr>
																				<td height="22">
																					2011-10-05更新：新增权限控制；
																				</td>
																			</tr>
																			<tr>
																				<td height="22">
																					2011-10-01更新：新增汇总功能；
																				</td>
																			</tr>
																		</table>
																	</td>

																</tr>
															</table>
															 --%>
														</td>
													</tr>
												</table>
											</td>
											<td width="3" background="../images/rightbg.gif"></td>
										</tr>
										<tr>
											<td class="leftbg03"></td>
											<td class="midbg02"></td>
											<td class="rightbg03"></td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td>
									<table width="100%" border="0" align="right" cellspacing="0">
										<tr>
											<td width="3" height="3" class="leftbg01"></td>
											<td class="midbg01"></td>
											<td width="2" height="3" background="images/righttop.gif"></td>
										</tr>

										<tr>
											<td class="leftbg03"></td>
											<td class="midbg02"></td>
											<td class="rightbg03"></td>
										</tr>
									</table>
								</td>
							</tr>
							<!--main.end-->
							<tr bgcolor="#A4C3D7">
							 
								<td height="5" colspan="3" align="center" valign="middle" bgcolor="#FFFFFF" class = "mainbg20111112">
								<span class="bluefont">合富辉煌信息技术部　 |  　TEL:</span> 18902210690 18902210688 38881732 38881725    　<span class="bluefont">MAIL: </span>shihao@hope733.com luosheng@hope733.com
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
