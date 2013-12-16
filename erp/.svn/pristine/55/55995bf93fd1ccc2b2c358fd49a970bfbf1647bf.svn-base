<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%
boolean temp=request.getServerName().startsWith("crm");

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>默认404界面</title>
<script type="text/javascript" src="<%=basePath%>js/jquery-1.6.2.min.js"></script>
<link href="<%=basePath%>css/login20111103.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath%>js/DD_belatedPNG_0.0.8a-min.js"></script>   
<script type="text/javascript"> 

    DD_belatedPNG.fix('.logintitle,.loginbox');  
</script> 

 <script type="text/javascript">
  $(document).ready(function(){
	  if(<%=temp%>){
			$("#bggg").removeClass();
			$("#bggg").addClass('loginnavcrm');
			}

  });
  </script>

</head>

<body  class="loginbg">

  <div id="bggg" align="center" class="loginnav">  
	<div class="loginword">
         
         <div class="c"></div>
        
           <div>出现异常,请联系开发人员</div>
		   <div>异常原因:<font color="#FF0000">${exception.message}</font></div>

          <div class="c"></div>
           
          <div class="loginboxicon">
			 <input type="button" value="  返回  " onClick="history.back(-1)">
          </div>
          
  		</div> 		
	</div>
	
</body>
</html>
