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
	<title>erp手机修改密码</title>
    
    <base href="<%=basePath%>"/>
    
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    
    <link rel="stylesheet" href="./m/js/jquery.mobile-1.3.1.min.css"/>    
    <link rel="stylesheet" href="./m/css/mobiscroll.custom-2.5.0.min.css"/>
    
	<script type="text/javascript" language="javascript" src="./m/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" language="javascript" src="./m/js/jquery.mobile-1.3.1.min.js"></script>
	<script type="text/javascript" language="javascript" src="./m/js/mobiscroll.js"></script> <!-- 日期控件 -->
    
    <script type="text/javascript" language="javascript">
		
		function check(){
			
			var pwd1 = $("#pwd1").val();
			var pwd2 = $("#pwd2").val();
			
			if(pwd1 == ""){
				alert("请输入新密码");
				$("#pwd1").focus();
				return false;
			}
			
			if(pwd2 == ""){
				alert("请确认新密码");
				$("#pwd2").focus();
				return false;
			}
			
			if($.trim(pwd1) != $.trim(pwd2)){
				alert("两个密码不一致");
				return false;
			}
			
			return true;
		}
		
	</script>
    
</head>

<body>

<div data-role="page" id="login_page">

<form id="login_form" action="<%=basePath%>m/modifyPwd.action" method="post" data-ajax="false">

	<div data-role="header" data-theme="b">

		<h1>修改密码</h1>               

	</div><!-- /header -->

	<div data-role="content">
    
    	<h1 style="color:#FF0000"><center>${title}</center></h1>
        
         <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" style="text-align:center">
         	<tr>
            	<td>
                	新密码
                </td>
                
                <td>
                    <input type="password" id="pwd1" name="pwd1"/>
        
                </td>
            </tr>
            
            <tr>
            	<td>
                	确认新密码
                </td>
                
                <td>
                    <input type="password" id="pwd2" name="pwd2"/>
        
                </td>
            </tr>
            
             <tr>
            	<td colspan="2">
					
                    <input type="submit" value="保存" data-inline="true" data-mini="false" onClick="return check();"/>
                    
                </td>
            </tr>
            
             <tr>
            	<td colspan="2">
					
                  <h3 style="color:#FF0000"><center>密码6位以上,必须包含数字和英文</center></h3>
                    
                </td>
            </tr>            
            
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