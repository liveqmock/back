<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<title>left</title>
		<meta http-equiv=Content-Type content="text/html; charset=utf-8" /> 
		<link href="../css/blue_new.css" rel="stylesheet" type="text/css"
				charset="utf-8" />
		<script type="text/javascript" language="javascript">
			$().ready(function(){
				$(".img").click(function(){
					$(".leftnav").toggle();
					
					$.ajax({
						type:"get",
						url: "./customer_tianluan!leftDisplay.action",  //查询一些相关的数据
						dataType: "html"
					});
					
				});
			});
		

		</script>

	</head>

	<body>

		
			<td width="213" valign="top">
				<div class="leftnav" 
				<s:if test="#session.leftDisplay == 0"> 
					style="display:none"
			  	</s:if>		
				<s:if test="#session.leftDisplay == 1"> 
					style="display:block"
			  	</s:if>			
				>
					<div class="lefttop"></div>
					<div class="leftbg">
						<div class="leftlist">
							<div class="leftl"></div>
							<div class="leftm">
								<a href="<%=request.getContextPath() %>/customer_tianluan!doSomeForAddCustomer.action" target="_self">新建客户</a>
							</div>
							<div class="leftr">
							</div>
							<div class="c"></div>	
						</div>

						<div class="leftlist">
							<div class="leftls"></div>
							<div class="leftm">
								<a href="<%=request.getContextPath() %>/customer_tianluan!searchCustomer.action?from=left" target="_self">查询客户</a>
							</div>
							<div class="leftrs"></div>
							<div class="c"></div>							
							
						</div>
						<%-- 
						<s:if test="#session.loginAccount.accountType == 2 ">
						<div>
							<div class="leftl"></div>
							<div class="leftm">
								<a href="./user_tianluan!indexUserAccount.action?tips=reset" target="_self">用户管理</a>
							</div>
							<div class="leftr"></div>
							<div class="c"></div>
						</div>
						
						</s:if>
						--%>
						<div class="leftlist">
							<div class="leftls"></div>
							<div class="leftm">
								<a href="./user_tianluan!updateUserAccountJsp_user.action" target="_self">修改密码</a>
							</div>
							<div class="leftrs"></div>
							<div class="c"></div>							
							
						</div>
						
					</div>


					<div class="leftbottom"></div>
				</div>
			</td>

			<td width="9" valign="middle">
					<img src="images/tianluan/arrow01.gif" width="9" height="90" border="0" id="img" class="img" title="点击收缩"/>
			</td>

	</body>
</html>
