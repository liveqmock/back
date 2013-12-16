<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
			
	response.setHeader("Pragma","No-cache");   
	
	response.setHeader("Cache-Control","no-cache");   
	
	response.setDateHeader("Expires", 0);  
%>

	<base href="<%=basePath%>">
	
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/jquery-1.6.2.min.js"></script>
		<script type="text/javascript" language="javascript" src="<%=basePath%>js/jquery.autocomplete.js"></script>
		<script type="text/javascript" language="javascript" src="<%=basePath%>js/customer_guangzhou_project.js"></script>	
		<!-- date input -->
		<style type="text/css">			
			.Wdate{
				border:#999 1px solid;
				height:20px;
				background:#fff url(css/datePicker.gif) no-repeat right;
			}			
		</style>
		<link href="<%=basePath%>dateinput/date_input.css" rel="stylesheet" type="text/css" charset="utf-8"/>	
		 <script language="javascript" type="text/javascript" src="<%=basePath%>dateinput/jquery.date_input.js"></script>
		 <script language="javascript" type="text/javascript" src="<%=basePath%>js/customer_common.js"></script>
		 <script type="text/javascript" language="javascript">		 
		 jQuery.extend(DateInput.DEFAULT_OPTS, dateInputCN);   
		
		 $(document).ready(function(){
				 $('.Wdate').date_input();			
		 });
			
		</script>
	

	

