
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
				
				window.location.href="<%=basePath%>m/loginUserAccount.action";
			}
		}
		fBrowserRedirect();
	//-->
	</script>
	
    <script type="text/javascript" src="<%=basePath%>js/jquery-1.6.2.min.js"></script>
    <link href="<%=basePath%>css/login20111103.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="<%=basePath%>js/DD_belatedPNG_0.0.8a-min.js"></script>
    <script type="text/javascript">

        DD_belatedPNG.fix('.logintitle,.loginbox');
    </script>

    <script type="text/javascript">
        if (top.location !== self.location) {
            top.location = self.location;
        }
    </script>

    <script type="text/javascript">
        $(document).ready(function(){
            if(<%=temp%>){
                $("#bggg").removeClass();
                $("#bggg").addClass('loginnavcrm');
            }

        });
    </script>

    <script type="text/javascript" language="javascript">
        function _load(){

            $("#userName").focus();

        <%
           Object objLoginName = session.getAttribute("loginName");
           String loginName = "";
           if(objLoginName != null){
               loginName = objLoginName.toString();
           }

           Object obj = session.getAttribute("tips");
           if(obj != null && !"".equals(obj.toString().trim())){
          %>
            alert('<%=obj.toString()%>');
            document.getElementById('userName').value = '<%=loginName%>';
        <%
          }
          %>
        }

        function reloadImage(){
            var par = new Date();
            document.getElementById("img").src = "<%=basePath%>image.jsp?par=" + par;
            return false;
        }
	
        function check(){
			
			var userAgent = navigator.userAgent.toLowerCase();	
			
			if(!(userAgent.indexOf("chrome")>0 || userAgent.indexOf("firefox")>0 || userAgent.indexOf("safari")>0)){
				alert("请使用谷歌浏览器");
				return false;
			}	

            var name = $.trim($("#userName").val());
            var password = $.trim($("#pwd").val());
            var code = $.trim($("#code").val());

            if(name == ""){
                alert("请输入名字");
                $("#userName").focus();
                return false;
            }

            if(password == ""){
                alert("请输入密码");
                $("#pwd").focus();
                return false;
            }


            if(code == "test" ){
                alert("请输入验证码");
                $("#code").focus();
                return false;
            }


            return true;
        }
    </script>
		

</head>

<body  class="loginbg" onload="_load()" >

<form action="user/loginUserAccount.action" method="post" id="login">

  <div id="bggg" align="center" class="loginnav" style="position: relative ">
		<div  style="position: absolute; margin-top: 50px; left: 333px; top: 87px; width: 104px; height: 94px; ">
        	<img src="images/er.png" />           
        </div>
        
        <div  style="position: absolute; margin-top: 50px; left: 333px; top: 160px; width: 104px; height: 94px; font-size:14px; color:#FFFFFF; font-weight:bold">
        	手机录客
        </div>
        
        <div class="loginword">


            <div><span class="loginword01" style=" font-size: 14px;font-weight: bold;">用户名</span><input name="userAccount.userName" type="text" class="logininputbox" id="userName" /><div class="c"></div></div>
            <div><span class="loginword01" style=" font-size: 14px;font-weight: bold;">密　码</span><input name="userAccount.userPwd" type="password" class="logininputbox" id="pwd"/></div>

            <div class="c"></div>

            <div>
                <span class="loginword01" style=" font-size: 14px;font-weight: bold;">验证码</span>
                <input name="code" type="text" class="logininputbox_s" id="code" maxlength="4" style="width:60px;"/>
                <span class="loginword01"><img src="<%=basePath%>image.jsp" id="img" onClick="reloadImage()" alt="点击刷新" width="70" height="22"/></span>
            </div>

            <div class="c"></div>

            <div class="loginboxicon">
                <input type="image"  src="<%=basePath%>images/login.jpg?ts=<%= CacheUtils.getUrlTimeStamp()%>" alt="login" width="113" height="31" border="0" onclick="return check()"/>
            </div>
        </div>        
     
		
		 <div style="padding: 4px; font-size: 12px;color:white">
         	<div id="changeDiv">
               本系统适用浏览器：<a href="./22.0.1229.92_chrome_installer.exe" title="点击下载" style="font-weight: bold;color:#ffec6e; text-decoration:underline">
               谷歌浏览器(点击下载)</a>
            </div>
               技术支持：020-38881703，短号：673800，手机：18902210029 
          </div>
		
    </div>
</form>
</body>
</html>
