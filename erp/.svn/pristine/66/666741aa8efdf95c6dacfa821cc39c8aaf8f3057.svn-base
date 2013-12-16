<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>合富辉煌ERP管理系统</title>
<link href="<%=basePath%>css/blue.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath%>js/DD_belatedPNG_0.0.8a-min.js"></script>   
<script type="text/javascript"> 
    DD_belatedPNG.fix('.logintitle,.loginbox');  
</script> 
    
<script type="text/javascript" language="javascript"> 
	function _load(){
		document.getElementById('userName').focus();
		
		<%
		 Object objLoginName = session.getAttribute("loginName");
		 String loginName = "";
		 if(objLoginName != null){
		 	loginName = objLoginName.toString();
		 }
		
		 Object obj = session.getAttribute("tips");
		 if(obj != null){  
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
		var name = document.getElementById("userName").value;
		var password = document.getElementById("pwd").value;
		var code = document.getElementById("code").value;
		
		if(name == ""){
			alert("请输入名字");
			document.getElementById("userName").focus();
			return false;
		}
		
		if(password == ""){
			alert("请输入密码");
			document.getElementById("pwd").focus();
			return false;
		}
		
		
		if(code == "test" ){
			alert("请输入验证码");
			document.getElementById("code").focus();
			return false;
		}
		
		
		return true;
	}
</script> 


</head>

<body class="loginbg" onload="_load()">
	<div class="logintitle"></div>
<form action="user/loginUserAccount.action" method="post" id="login">
<div class="loginbox">
  <div>

  <input name="userAccount.userName" type="text" class="loginboxinput" id="userName"/>
  <input name="userAccount.userPwd" type="password" class="loginboxinput1" id="pwd"/>
  
  </div>
  <div><input name="code" type="text" class="loginboxinput2" id="code" maxlength="4"/>
    <span class="loginboxcode">
		<img src="<%=basePath%>image.jsp" id="img" onClick="reloadImage()" alt="点击刷新"/>
	</span>
    </div>
    <div class="c"></div>
    <div class="loginboxicon">
    <input type="image"  src="<%=basePath%>images/blue/login.gif" alt="login" width="139" height="29" border="0" onclick="return check()"/>
    </div>


</div>
</form>
</body>
</html>

