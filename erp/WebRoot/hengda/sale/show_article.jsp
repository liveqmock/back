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

		<title>最新通告</title>
	</head>
	<body onload="clearSuggestion()">
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
					<td valign="top">
						<s:include value="include/left.jsp">
						</s:include>
					</td>
					<td width="100%" valign="top">
						<DIV style="WIDTH: 98%; HEIGHT: 100%; BACKGROUND-COLOR: #A4C3D7; padding: 1px">
							<%-- 基本table分割 ^^^^^^<td width="100%">^^^^^^^^^^^^^^^^^^^^^^--%>
							<%--main table开始 --%>
							<!--main-->
							<table width="100%" class="mainbg20111112" style="height: 100%;">

								<tr>


									<td width="100%" valign="top" height="100%" style="overflow: hidden;">
										
										<div class="titlel"></div>
										<div class="titlebg" style="height: auto; overflow: hidden;">

											<div class="title02">
												最新通告
											</div>
											<div class="right99"></div>
											<div class="blueline"></div>

											<div class="c"></div>
											<div class="c"></div>


											<div class="right99"></div>
											<div style="background: #fff">
											<table width="1000" border="0" align="left">
												<tr>
													<td valign="top">
													
													
											<div  >
											<table width="700" border="0" align="left" cellpadding="0" cellspacing="1" class="gbox" style="table-layout:fixed;word-wrap:break-word;">
												<tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#ffffbf";>
													<td style="padding-left: 20px; color: red">
														${showArticle.title }${showArticle.summary }
													</td>
												</tr>

												<tr  onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#ffffbf";>
													<td width="700px" style="padding: 20px" height="450" valign="top">
														&nbsp;&nbsp;${showArticle.content }
													</td>
												</tr>
												<tr bgcolor="#ffffbf";>
													<td style="padding-right: 20px; color: blue" align="right">
														${showArticle.dayString }
													</td>
												</tr>
											</table>
											</div>
											</td>
											<td align="left" valign="top" >
											
											
											<div  style="padding-left: 10;float: left;background: #fff" >
											
												<s:iterator value="lastArticleList" id="arl">
												
														<a href="<%=basePath %>sale_hengda/article/show.action?id=${arl.id}" target="_self"> ${arl.dayString }&nbsp; ${arl.summary }</a>
													<br/>
												</s:iterator>
											
											</div>
											</td>
												</tr>
											</table>
											</div>
								</tr>

							</table>

						</DIV>
						<!--main.end-->
					</td>
					<%-- 基本table分割 ^^^^^^^^^^^^^^^^^end^^^</td>^^^^^^^^^^^^^^^^^^^^^--%>
				</tr>

			</tbody>

		</table>

	</body>
</html>

