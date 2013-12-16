<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>">
    
    <title>修改用户信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<s:include value="../sale/include/header.jsp"></s:include>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body onLoad="clearSuggestion()">
		<table width="100%" border="0" align="left" cellspacing="0">
			<thead>
				<tr>
					<td colspan="2" style="border-collapse: collapse; border: 0px; margin: 0px; padding: 0px;">
						<s:include value="../sale/include/top.jsp"></s:include>
					</td>
				</tr>
			</thead>
			<tfoot>
				<tr>
					<td colspan="2">
						<s:include value="../sale/include/bottom.jsp"></s:include>
					</td>
				</tr>
			</tfoot>
			<tbody>
				<tr>
					<td valign="top">
						<s:include value="../sale/include/left.jsp">
						</s:include>
					</td>
					<td width="100%" valign="top">

				<DIV style="WIDTH: 98%; HEIGHT: 100%; BACKGROUND-COLOR: #A4C3D7;padding: 1px">



						<%-- 基本table分割 ^^^^^^<td width="100%">^^^^^^^^^^^^^^^^^^^^^^--%>
						<%--main table开始 --%>



						<!--main-->
						<table width="100%" class="mainbg20111112" style="height: 100%; white-space: nowrap;">
							<tr>

								<td width="100%" valign="top" height="100%" style="overflow: hidden;" nowrap="nowrap">

									<div class="titlel"></div>

									<div class="titlebg" style="height: auto; overflow: hidden;">


										<div class="title02">
											修改用户信息
										</div>
										
										


										<div class="right99"></div>
										<div class="blueline"></div>

										<!-- right form top -->
										<form class="registerform" id="registerform" action="./sale_hengda/userAccount/updateform.action" method="post">

											<div class="c"></div>
											<div class="c">
												&nbsp;&nbsp;
												<font color="#FF0000"><span id="suggestion"><s:property value="#request.suggestion" />
												</span>
												</font>

											</div>



											<table width="500" border="0" align="left" cellpadding="0" cellspacing="1" class="gbox" >
												<tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"; height="50px">
													<td width="110" align="center" id="t15" nowrap="nowrap">账号</td>
													<td width="257" nowrap="nowrap" id="t16" valign="middle">
														&nbsp;${selectUser.userName }
													</td>
												</tr>
												<tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"; style="box" height="50px">
													
													
													<td width="110" align="center" id="t15" nowrap="nowrap">密码</td>
													<td width="350" nowrap="nowrap" id="t16" valign="middle" align="left">
													<font size="2" >如果留空则不修改密码</font><br/>
														<input type="hidden" name="updatetype" value=""/>
														<input type="hidden" name="id" value="${id }"/>
												
														<input type="text" name="updateUser.userPwd"    class="box"/>
														
											
														<br/><input type= "submit"  value= "  只修改密码  "  onclick= "updatetype.value = 'updatepwd'" >   
													</td>
												</tr>

												<tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"; height="50px">
													
													<td id="t13" align="center">姓名</td>
													<td id="t14" valign="middle">
												
														<input type="text" name="updateUser.realName" value="${selectUser.realName}"   class="box" />
													</td>
													
												</tr>



												


												<tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"; height="70px">
													
													<td id="t15" align="center">修改项目</td>
													<td id="t12" nowrap="nowrap"  valign="middle">
													原项目：${selectUser.descProjectId}
														<br/>
														<s:select list="prolist" listKey="id" listValue="projectName" name="updateUser.projectId" ></s:select>
													</td>
													
												</tr>
												<tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"; height="70px">
													
													<td id="t15" align="center">修改权限</td>
													<td id="t12" nowrap="nowrap"  valign="middle">
														<a href="#" class="ablue">修改该用户权限<a/>
													</td>
													
												</tr>	
													<tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" ; align="center">
														<td colspan="2">
															
													
															<input type="submit" value="  保存  " id="sub" onclick= "updatetype.value = ''"/>
															<input type="button" value="  取消  " onClick="javascript:window.location.href = '<%=path %>/sale_hengda/search/sale.action?from=left'"/>
															<s:actionmessage />
														</td>
</tr>
													<s:iterator value="logMonitorList" id="c">
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

