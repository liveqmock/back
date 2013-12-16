
<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="com.ihk.utils.CacheUtils"%>

<%
    boolean temp=request.getServerName().startsWith("crm");

    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

    <title>登录</title>
	
	 <!--手机判断,参照http://smart.mail.126.com/?dv=smart-->
    <script type="text/javascript" language="javascript">
	<!--
		function fBrowserRedirect(){
	
			window.sUserAgent = navigator.userAgent.toLowerCase();
			var bIsIphoneOs = sUserAgent.match(/iphone/i) == "iphone";
			var bIsAndroid = sUserAgent.match(/android/i) == "android";
			var bIsSymbianOS = sUserAgent.match(/symbian/i) == "symbian";
			var bIsIPad = sUserAgent.match(/ipad/i) == "ipad";
			var bIsIPod = sUserAgent.match(/ipod/i) == "ipod";
			var bIsItouch = sUserAgent.match(/itouch/i) == "itouch";
			
			if(bIsAndroid  || bIsIphoneOs || bIsSymbianOS || bIsIPod || bIsItouch){
				
				window.location.href = "<%=basePath%>m/loginUserAccount.action";
			}else if(bIsIPad){
				
				window.location.href = "login_ipad.jsp";				
			}else{
				
				window.location.href = "login_pc.jsp";
			}
		}
		fBrowserRedirect();
	//-->
	</script>
    
</head>

<body class="loginbg">
</body>
</html>
