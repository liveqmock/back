<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>
	
	<base href="<%=basePath%>" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	
	<link href="./css/blue_guangzhou.css" rel="stylesheet" type="text/css" charset="utf-8"/>
	<link href="./css/easyui.css" rel="stylesheet" type="text/css" charset="utf-8"/>
	<link href="./css/icon.css" rel="stylesheet" type="text/css" charset="utf-8"/>
		
	<script type="text/javascript" language="javascript" src="./js/jquery-1.6.2.min.js"></script>
	<script type="text/javascript" language="javascript" src="./js/jquery.easyui.min.js"></script>
	<script type="text/javascript" language="javascript">
	
		function tosubmit(){
			$("#upload").submit();
		};
		
		//${closeBody}
	</script>
</head>

<body>
<form id="upload" action="./saleunit_new_init/appoint/guangzhou/uploadBuildXlsForm.action" method="post" enctype="multipart/form-data"> 
	<table width="100%" border="0" align="left" cellpadding="0" cellspacing="1" class="gbox" >
	   <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="line-height: 20px;"> 
		 <td width="100" align="center" valign="middle">
			文件
		</td>		
		 <td width="100" align="left" valign="middle">
		 	<input type="file" name="xlsFile" id="unitImage" />
		 	<input type="hidden" name="buildId" value="${buildId}"/>
		</td>
	  </tr> 
	</table>
	<p style="color: red">${tips }</p>
</form>
 </body>
 </html>