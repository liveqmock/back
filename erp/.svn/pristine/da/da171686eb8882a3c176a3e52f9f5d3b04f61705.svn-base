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

		<title>项目修改</title>
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
					<td width="100%" valign="top" >
					<DIV style="WIDTH: 98%; HEIGHT: 100%; BACKGROUND-COLOR: #A4C3D7;padding: 1px">
			



						<%-- 基本table分割 ^^^^^^<td width="100%">^^^^^^^^^^^^^^^^^^^^^^--%>
						<%--main table开始 --%>



						<!--main-->
						<table width="100%" class="mainbg20111112" style="height: 100%; white-space: nowrap;">
							<tr>

								<td width="100%" valign="top" height="100%" style="overflow: hidden;" nowrap="nowrap">

									<div class="titlel"></div>

									<div class="titlebg" style="height: auto; overflow: hidden;">


										<div class="title01" ><a href="./sale_hengda/project/search.action" target="_self">查询项目</a></div>


										<div class="right99"></div>
										<div class="blueline"></div>
											
												
										<!-- right form top -->
										<form class="registerform" id="registerform" action="./sale_hengda/project/updateform.action" method="post">

											<div class="c"></div>
											<div class="c">
												&nbsp;&nbsp;
												<font color="#FF0000"><span id="suggestion"><s:property value="#request.suggestion" />
												</span>
												</font>

											</div>



											<table width="750" border="0" align="left" cellpadding="0" cellspacing="1" class="gbox">
												
												<tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
													
													
													<td width="100" align="center" id="t15" nowrap="nowrap">
														项目名称
													</td>
													<td width="148" nowrap="nowrap" id="t16">
														&nbsp;
														${selectPro.projectName }
														
													</td>
													<td width="100" align="center" id="t15" nowrap="nowrap">
														项目ID
													</td>
													<td width="148" nowrap="nowrap" id="t16">
														&nbsp;
														${id }
														个
													</td>
												</tr>

												<tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
													
													
													<td width="100" align="center" id="t15" nowrap="nowrap">
														所属公司
													</td>
													<td width="148" nowrap="nowrap" id="t16">
														&nbsp;
														${selectPro.descCompanyId}
														
													</td>
													<td width="100" align="center" id="t15" nowrap="nowrap">
														项目状态
													</td>
													
													<td width="148" nowrap="nowrap" id="t16">
													
													<input type="radio" name="updatePro.projectState"  value="1" 
														<s:if test="#request.selectPro.projectState == 1">checked="checked" </s:if>
													>活动</input>
													
													<input type="radio" name="updatePro.projectState"  value="2" 
														<s:if test="#request.selectPro.projectState == 2">checked="checked" </s:if>												
													>废止</input>
													
												    </td>
												</tr>
												




												
												
													<tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" ; align="center">
														<td colspan="4">
															<input type="hidden" name="id" value="${id }" />
																<ul style="float: clear;height: 0px;padding: 0;margin: 0"></ul>
													
															<input type="submit" value="  保存  " id="sub" />
															<input type="button" value="  取消  " onClick="javascript:window.location.href = '<%=path %>/sale_hengda/project/search.action'" />
															<s:actionmessage cssStyle="color:red;float: clear;height: 0px;padding: 0;margin: 10" tabindex="p"/>
														</td>
														
													</tr>
													
													<tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" ; align="center">
														<td colspan="4">
														<font color="red">	最后修改人:${selectPro.modId}   &nbsp;&nbsp;&nbsp; 最后修改时间:<s:date name='#request.selectPro.modTime' format='yyyy-MM-dd HH:mm:ss'/></font>
														</td>
													</tr>
													<tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" ; align="center">
														<td>创建人：</td>
														<td>${selectPro.descCreatedId}</td>
														<td>创建时间：</td>
														<td><s:date name='#request.selectPro.createdTime' format='yyyy-MM-dd HH:mm:ss'/></td>
													</tr>
													<tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" ; align="center">
														<td colspan="2">修改人</td>
														
														<td colspan="2">修改时间</td>
														
													</tr>
													<s:iterator value="statelist" id="c">
														<tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" ; align="center">
														
														<td colspan="2">${c.descModId }</td>
														
														<td colspan="2">
															<s:date name='#c.modTime' format='yyyy-MM-dd HH:mm:ss'/>
														</td>
													</tr>
													
													</s:iterator>
													
											</table>

										</form>


										<div class="c"></div>
									</div>



									<div class="titler"></div>
									<div class="c"></div>

									<div class="c"></div>
						</table>
						<!--main.end-->
						</DIV>
					</td>
					<%-- 基本table分割 ^^^^^^^^^^^^^^^^^end^^^</td>^^^^^^^^^^^^^^^^^^^^^--%>
				</tr>
			</tbody>

		</table>

	</body>
</html>

