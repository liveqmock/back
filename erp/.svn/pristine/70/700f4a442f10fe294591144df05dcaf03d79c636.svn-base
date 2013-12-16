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
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>新建用户</title>
	<s:include value="../sale/include/header.jsp"></s:include>
	 <script type="text/javascript" language="javascript"
			src="<%=path %>/js/jquery-1.3.1.js"></script>
     <script type="text/javascript" language="javascript"
				src="<%=path %>/js/jquery.validate.js"></script>
     <script src="<%=path %>/js/jquery.validate.messages_cn.js" type="text/javascript"></script>  
      <script src="<%=path %>/js/jquery.metadata.js" type="text/javascript"></script>   
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<script language="javascript" type="text/javascript">
			$().ready(function(){
						
				$("#inputUser_companyId").change(function(){
					companyToProject(this.value, "inputUser_projectId");
				});

				$("#inputform").validate({
					rules: {
						'inputUser.realName': {
							required: true,
							minlength: 2
						},
						'inputUser.userName': {
							required: true,
							minlength: 2
						},
						'inputUser.userPwd': {
							required: true,
							minlength: 6
						}
					},
					
					messages: {
						'inputUser.realName': {
							required: '请输入姓名',
							minlength: '请至少输入两个字符'
						},
						'inputUser.userName': {
							required: '请输入账号',
							minlength: '请至少输入两个字符'
						},
						'inputUser.userPwd': {
							required: '请输入密码',
							minlength: '请至少输入六个字符'
						}
					},	
					
					errorElement: "em", //可以用其他标签，记住把样式也对应修改
					success: function(label) {
						//label指向上面那个错误提示信息标签em
						label.text(" ")				//清空错误提示消息
								//加上自定义的success类
					}
				  });
			});
		</script>
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
					<td width="100%" valign="top" >




<DIV style="WIDTH: 98%; HEIGHT: 100%; BACKGROUND-COLOR: #A4C3D7;padding: 1px">
						<%-- 基本table分割 ^^^^^^<td width="100%">^^^^^^^^^^^^^^^^^^^^^^--%>
						<%--main table开始 --%>



						<!--main-->
						<table width="100%" class="mainbg20111112" style="height: 100%; white-space: nowrap;" frame="vsides">
							<tr>

								<td width="100%" valign="top" height="100%" style="overflow: hidden;" nowrap="nowrap">

									<div class="titlel"></div>

									<div class="titlebg" style="height: auto; overflow: hidden;">

 <div class="title01" ><a href="./sale_hengda/userAccount/search.action" target="_self">用户管理</a></div>
            <div class="title02"><a href="./sale_hengda/userAccount/input.action" target="_self" >新建用户</a></div>
										


										<div class="right99"></div>
										<div class="blueline"></div>

										<!-- right form top -->
										<form name="inputform" class="registerform" id="inputform" action="./sale_hengda/userAccount/inputform.action" method="post">

											<div class="c"></div>
											<div class="c">
												&nbsp;&nbsp;
												<font color="#FF0000"><span id="suggestion"><s:property value="#request.suggestion" />
												</span>
												</font>

											</div>



											<table width="470" border="0" align="left" cellpadding="0" cellspacing="1" class="gbox">
												<tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"; height="40px">
													<td width="110" align="center" id="t15" nowrap="nowrap">账号</td>
													<td width="257" nowrap="nowrap" id="t16"  >
													
														*(尽量方便记忆)<input type="text" name="inputUser.userName"  class="box" value="${inputUser.userName }"/>
														<label><em>&nbsp;</em></label>
													</td>
												</tr>
												<tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"; style="box" height="40px">
													
													
													<td width="110" align="center" id="t15" nowrap="nowrap">密码</td>
													<td width="257" nowrap="nowrap" id="t16" >
													
														*(六位以上)<input type="text" name="inputUser.userPwd" value="${inputUser.userPwd }"   class="box"/>
														</td>
												</tr>

											
												<tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"; height="40px">
													
													<td id="t13" align="center">姓名</td>
													<td id="t14" >
													
														*(真实姓名)<input type="text" name="inputUser.realName" value="${inputUser.realName }"  class="box" />
													</td>
												
												</tr>
													<tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"; height="40px">
													
													<td id="t13" align="center">移动电话</td>
													<td id="t14" >
													
														&nbsp;<input type="text" name="inputUser.mobilePhone" value="${inputUser.mobilePhone }"  class="box" />
													</td>
												
												</tr>


												


												<tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"; height="40px">
													
													<td id="t15" align="center">所属公司</td>
													
													<td id="t12">
														<s:select list="selCompany" name="inputUser.companyId" value="#session.companyId" /><br/>
													</td>
												</tr>
												<tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"; height="40px">
													
													<td id="t15" align="center">所属项目</td>
													<td id="t12">
												<s:select list="selProject" name="inputUser.projectId" value="#session.projectId" />
													</td>
												
												</tr>	
												<tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"; height="40px">
													
													<td id="t15" align="center">权限</td>
													<td id="t12">
														<input type="radio" value="y" name="role1"/>录入
														<input type="radio" value="y" name="role2"/>管理
													</td>
												
												</tr>	
													<tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" ; align="center">
														<td colspan="2" style="color: red;size: 4">
															<input type="hidden" name="saleMonitor.id" value="<s:property value='#session.saleMonitor.id'/>" />
															<input type="hidden" name="saleMonitor.projectId" value="<s:property value='#session.saleMonitor.projectId'/>" />
															<input type="hidden" name="saleMonitor.monitorDate" value="<s:date name='#session.saleMonitor.monitorDate' format='yyyy-MM-dd'/> " />
													
															<input type="submit" value="  保存  " name="button" id="button"/>
															<input type="button" value="  取消  " onClick="history.back(-1)"/>
														<s:actionmessage/>
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
						
						<%-- 基本table分割 ^^^^^^^^^^^^^^^^^end^^^</td>^^^^^^^^^^^^^^^^^^^^^--%>
						</DIV>
					</td>
					
				</tr>
			</tbody>

		</table>

	</body>
</html>

