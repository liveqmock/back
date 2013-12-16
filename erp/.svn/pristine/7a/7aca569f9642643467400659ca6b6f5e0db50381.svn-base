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
		<s:include value="../sale/include/header.jsp"></s:include>
		
		<title>修改密码</title>

		<style type="text/css">
label {
	width: 10em;
	float: left;
}

em.error {
	float: none;
	color: red;
	padding-left: .5em;
	vertical-align: top;
}

p {
	clear: both;
}

.submit {
	margin-left: 12em;
}

em {
	font-weight: bold;
	padding-right: 1em;
	vertical-align: top;
}

em.error {
	padding-left: 16px;
}

em.success {
	padding-left: 16px;
}
</style>
		<script type="text/javascript">
	$(document).ready(function() {

		$("#pwdform").validate( {
			rules : {
				'userAccount.userPwd' : {
					required : true,
					minlength : 6
				},
				'pwdValidation' : {
					equalTo : "#pwd"
				}
			},

			messages : {
				'userAccount.userPwd' : {
					required : '请输入密码',
					minlength : '请至少输入六个字符'
				},
				'pwdValidation' : {
					equalTo : "两次密码输入不相等"

				}

			},

			errorElement : "em", //可以用其他标签，记住把样式也对应修改
			success : function(label) {
				//label指向上面那个错误提示信息标签em
			label.text(" ") //清空错误提示消息
					.addClass("success"); //加上自定义的success类
		}

		});

	});
</script>

  </head>
  
  <body>
    <table width="100%" border="0" align="center" cellspacing="0">
			<thead>
				<tr>
					<td colspan="2" style="border-collapse: collapse; border: 0px; margin: 0px; padding: 0px;">
					
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
						
					
					</td>
					<td width="100%" valign="top" >
					<DIV style="WIDTH: 100%; HEIGHT: 100%; BACKGROUND-COLOR: #A4C3D7;padding: 1px">
						<%-- 基本table分割 ^^^^^^<td width="100%">^^^^^^^^^^^^^^^^^^^^^^--%>
						<%--main table开始 --%>

						<table width="100%" class="mainbg20111112" style="height: 100%; white-space: nowrap;">
						<tr>
							<td width="100%" valign="top" height="100%" style="overflow: hidden;">

								

										<div class="title01" style="width: auto">
											&nbsp;
										</div>
										<div class="right99"></div>
										<div class="blueline"></div>

										<div class="c"></div>
										<div class="c"></div>
							<form id="pwdform" action="./user_hengda!updatePwd.action" method="post" id="commentForm">
								<table width="98%" border="0" cellspacing="0" class="main" align="center">
										<tr style="height: 35px">
										<td width="50%" align="right">
											旧密码&nbsp;
										</td>
										<td >
											<input name="oldPwd" class="box" type="password" id="oldpwd" /><br/>
										</td>
									</tr>


											<tr style="height: 35px">
									<td width="50%" align="right">
											新密码&nbsp;
										</td>
										<td>
											<input name="userAccount.userPwd" class="box" type="password" id="pwd" /><br/>
										</td>
									</tr>

									<tr style="height: 35px">
									<td width="50%" align="right">
											重复密码&nbsp;
										</td>
										<td>
											<input name="pwdValidation" class="box" type="password" /><br/>
										</td>
									</tr>

									<tr>
										<td align="right"><font color="red">为了安全,</font></td>
										<td><font color="red">请首先修改预定密码之后再使用本系统</font> </td>
									</tr>

									<tr>
										<td></td>
										<td>
											<input type="submit" name="button" id="button" value="  保存  " align="right" /><br/>
										</td>
									</tr>


								</table>
							</form>



						</div>
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




