<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv=Content-Type content="text/html; charset=utf-8" /> 
<title>Insert title here</title>
<base href="<%=basePath%>">

<link href="./css/unit_table.css"  rel="stylesheet" type="text/css" charset="utf-8"/><!-- unit的样式 -->
<script type="text/javascript" language="javascript" src="<%=basePath%>js/jquery-1.6.2.min.js"></script>	
<script type="text/javascript" language="javascript" src="<%=basePath%>js/unit_table.js"></script>	<!-- unit table -->
<script type="text/javascript">
		$().ready(function(){
			$("#build").blur(function(){
				showUnit("unitno","unitid","build");//1是buildID
				});
		});
		</script>

</head>
<body>
<div>
buildid<input type="text" id="build"/>&nbsp;</div>
	<div>房间列表<input id="unitno" type="text" style=""/>&nbsp;</div>
	&nbsp;&nbsp;&nbsp;<br>
		<div><input id="unitid" type="hidden" name="" /></div>
</body>


</html>