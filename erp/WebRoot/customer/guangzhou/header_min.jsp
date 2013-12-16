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
	
		
	<link href="./css/blue_guangzhou.css"  rel="stylesheet" type="text/css" charset="utf-8"/>
	<!-- 智能提示框 -->
	<link href="./css/jquery.autocomplete.css" rel="stylesheet" type="text/css" charset="utf-8"/>
	
	<meta http-equiv=Content-Type content="text/html; charset=utf-8" /> 
	
	<meta http-equiv="pragma" content="no-cache" /> 
	<meta http-equiv="Cache-Control" content="no-cache, must-revalidate" /> 
	<meta http-equiv="expires" content="0">   
		
	<script type="text/javascript" language="javascript" src="./js/jquery-1.6.2.min.js"></script>	
	<script type="text/javascript" language="javascript" src="./js/customer_common.js"></script>
	<script type="text/javascript" language="javascript" src="./js/common.js"></script>
	<!-- 关于金额的帮助类 -->
	<script type="text/javascript" language="javascript" src="./js/money.utils.js"></script>

	<!-- 智能提示框 -->
	<script type="text/javascript" language="javascript" src="./js/jquery.autocomplete.js"></script>
	<!-- 解决ie6 下拉框穿透div的问题 -->
	<script type="text/javascript" language="javascript" src="./js/jquery.bgiframe.min.js"></script>
	
	<!-- date input -->
	<style type="text/css">
		
		.Wdate{
			border:#999 1px solid;
			height:20px;
			background:#fff url(css/datePicker.gif) no-repeat right;
		}
		
	</style>
	<link href="./dateinput/date_input.css" rel="stylesheet" type="text/css" charset="utf-8"/>	
	 <script language="javascript" type="text/javascript" src="./dateinput/jquery.date_input_no_for_dialog.js"></script>
	 <script type="text/javascript" language="javascript">
	 
	 jQuery.extend(DateInput.DEFAULT_OPTS, dateInputCN);   
	
	 $(document).ready(function(){

		 $('.Wdate').date_input();
		
	 });
		
	</script>