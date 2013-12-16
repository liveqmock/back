<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html> 
<html>
<head>
	<meta charset="utf-8">
	<title>erp手机登录</title>
    
    <base href="<%=basePath%>"/>
    
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    
    <link rel="stylesheet" href="./m/js/jquery.mobile-1.3.1.min.css"/>    
    <link rel="stylesheet" href="./m/css/mobiscroll.custom-2.5.0.min.css"/>
    
	<script type="text/javascript" language="javascript" src="./m/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" language="javascript" src="./m/js/jquery.mobile-1.3.1.min.js"></script>
	<script type="text/javascript" language="javascript" src="./m/js/mobiscroll.js"></script> <!-- 日期控件 -->
    
    <script type="text/javascript" language="javascript">
		
		function check(){
			
			var userName = $("#userName").val();
			var userPwd = $("#userPwd").val();
			
			if(userName == ""){
				alert("请输入用户名");
				$("#userName").focus();
				return false;
			}
			
			if(userPwd == ""){
				alert("请输入密码");
				$("#userPwd").focus();
				return false;
			}
			
			return true;
		}
		
	</script>
    
</head>

<body>

<div data-role="page" id="login_page">

<form id="login_form" action="<%=basePath%>m/login.action" method="post" data-ajax="false">

	<div data-role="header" data-theme="b">

		<h1>登录</h1>               

	</div><!-- /header -->

	<div data-role="content">
        
        <h1 style="color:#FF0000"><center>${title}</center></h1>
    	
         <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" style="text-align:center">
         	<tr>
            	<td>
                	用户名
                </td>
                
                <td>
                    <input type="text" id="userName" name="userAccount.userName"/>
        
                </td>
            </tr>
            
            <tr>
            	<td>
                	密码
                </td>
                
                <td>
                    <input type="password" id="userPwd" name="userAccount.userPwd"/>
        
                </td>
            </tr>
            
             <tr>
            	<td colspan="2">
					
                    <input type="submit" value="登录" data-inline="true" data-mini="false" onClick="return check();"/>
                    <input type="reset" value="重置" data-inline="true" data-mini="false"/>
                    
                </td>
            </tr>
            
            <!--
             <tr>
            	<td colspan="2">
					
                   <input type="button" value="切换到电脑版" />
                    
                </td>
            </tr>
            -->
            
    	</table>
        
          
        
    </div><!-- /content -->

	<!-- data-position="fixed",把顶部或底部固定; data-fullscreen="true",是否全屏,也是点上去是否隐藏顶部及底部-->
	<div data-role="footer" data-theme="b" data-fullscreen="false" data-position="fixed">
		<h4>Copyright ©2013合富辉煌 版权所有</h4>
	</div><!-- /footer -->
    
</form>           
    
</div><!-- /page -->

	
</body>
</html>