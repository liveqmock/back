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
<s:include value="../customer/guangzhou/header.jsp"></s:include>	
<title>Insert title here</title>
<base href="<%=basePath%>">
<link href="<%=basePath%>/css/unit_table.css"  rel="stylesheet" type="text/css" charset="utf-8"/><!-- unit的样式 -->
<link href="<%=basePath%>/css/jquery.autocomplete.css" rel="stylesheet" type="text/css" charset="utf-8"/>
<script type="text/javascript" language="javascript" src="<%=basePath%>/js/jquery-1.6.2.min.js"></script>

<script type="text/javascript" language="javascript" src="<%=basePath%>js/unit_infomation.js"></script>	
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/jquery.form.js"></script>	
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/jquery.autocomplete.js"></script>
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/sale_unit.js"></script>	
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/guangzhou_input_valdate.js"></script>	
<script type="text/javascript" language="javascript" src="./js/unit_table.js"></script>	<!-- unit table -->
	
	<style type="text/css">
		.err_input_class{
			border-color: red;
			border-width: 2px
		}
		.poppng{background:url(<%=basePath%>/images/pop.png) no-repeat}
		.org_box{height:20px; width:250px;background:url(<%=basePath%>/images/pop.png) no-repeat;
			 position:absolute; display: none;font-size: 12px;padding: 3px; overflow: hidden;} 
		
	</style>
	<script type="text/javascript">
		$().ready(function(){
			showDiv("unitno","rere","buildId","proId");

			$("#text_input").inputVal({
				type:'num',
				errClass:'err_input_class',
				errDiv:'org_box',
				minlength:0
			});
			$("#text_input2").inputVal({
				type:'num',
				errClass:'err_input_class',
				errDiv:'org_box',
				minlength:2
			});
			$("#text_input3").inputVal({
				type:'num',
				errClass:'err_input_class',
				errDiv:'org_box',
				minlength:2
			});
	
		});
		</script>

</head>
<body>
proId<input type="text" id="proId" />
buildid<input type="text" id="buildId"/>
	房间列表<input id="unitno" type="text" style=""/>
<input id="rere" type="text">

<div id="select_unit_div" style="width: 500px;height: 300px;background:		#0072E3;display: none;position: absolute">
	<p id="select_unit_div_head" style="width: 98%;height: 30px;background: #0052E3;border:#333333 groove;margin-top: 0px"><font id="select_unit_div_close" style="float: right;color:#ffffff;line-height: 30px;cursor: pointer;font-weight: bold;">关闭&nbsp;&nbsp;</font></p>
	<div id="select_unit_div_body" style="height: 97%;width: 100%px;background: #FFF8D7; border:#555555 solid;overflow: scroll"></div>
</div>

<div style="width: 500px;height: 400px; border: #eee groove;">
	<input id="text_input"/> <br/>
	<input id="text_input2"/> <br/>
	<input id="text_input3"/> 
	<div id="err_massage" style="width: 150px;color: #fff;background: #222;height: 30px;border-width: 2px;border-color: blue;
				position: absolute;display:none;
			">
	</div>
	
	<div id="org_box" class="poppng" style="height:20px; width:250px;
			 position:absolute; display: none;font-size: 12px;padding: 3px; overflow: hidden;"></div>
</div>
<!-- 
<div id="select_unit_div" style="width: 400px;height: 300px;background:		#0072E3;display: none;position: absolute">
	<p id="select_unit_div_head" style="width: 98%;height: 30px;background: #0052E3;border:#333333 groove;margin-top: 0px"><font id="select_unit_div_close" style="float: right;color:#ffffff;line-height: 30px;cursor: pointer;font-weight: bold;">关闭&nbsp;&nbsp;</font></p>
	<div id="select_unit_div_body" style="height: 97%;width: 100%px;background: #FFF8D7; border:#555555 solid;overflow: scroll"></div>
</div>
 -->
	
		
		
		
		</body>


</html>