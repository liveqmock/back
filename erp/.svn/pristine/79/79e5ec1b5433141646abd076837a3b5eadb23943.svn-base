<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="com.ihk.utils.CacheUtils"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<s:include value="../../../customer/guangzhou/header.jsp"></s:include>	
		<s:include value="../../../customer/guangzhou/header_left_js.jsp"></s:include>	
		<script type="text/javascript" language="javascript" src="<%=basePath%>js/guangzhou_input_valdate.js"></script>
		<title>新增开发商</title>
		<style >
			.tb1 input{width:100%}
			 em{margin-right: 5px;color: red}
			.poppng{background:url(<%=basePath%>/images/pop.png) no-repeat}
			.err_input_class{border-color: red;border-width: 2px}
			.body_div{width: 60%;height: inherit;float: left;vertical-align: top;}
			.input_table{margin-top: 10px;}
			.input_table tr{background: #ffffff}
		</style>
		<script type="text/javascript">
		 $(document).ready(function(){
			 $("#developer_name").inputVal({			
					errClass:'err_input_class',
					errDiv:'org_box',
					minlength:1,
					maxlength:30
			 });
			 $("#submit").click(function(){
					var	$str = $.trim($("#developer_name").val());
					if($str == ""){
						alert("需要开发商名称");
						$("#developer_name").val("");
						$("#developer_name").focus();
						return false;
					}
				});
		
		 });
		</script>
	</head>
	<body>
	
<%--固定的上部 --%>
<s:include value="../../../customer/guangzhou/body_up.jsp">
</s:include>	

<%--主体导航页头 --%>
<div class="title02" ><a href="./property/developer/index.action?ts=<%= CacheUtils.getUrlTimeStamp()%>">开发商</a></div>
<div class="title01" ><a href="./property/project/index.action?ts=<%= CacheUtils.getUrlTimeStamp()%>">楼盘项目</a></div>
<div class="title01" ><a href="./property/area/searchIndex.action?ts=<%= CacheUtils.getUrlTimeStamp()%>" target="_self">分区</a></div>
<div class="title01" ><a href="./property/build/index.action?ts=<%= CacheUtils.getUrlTimeStamp()%>" target="_self">楼栋</a></div>


<table width="100%" border="0" cellspacing="0" class="d_top">
	<tr>
	  <td bgcolor="#edf8fe">
	  
	<div class="d_out">
		<a href="./property/developer/index.action">查询开发商</a>
	</div>		
	<div class="d_over">
		<b><a href="./property/developer/input_index.action">新建开发商</a></b>
	</div>		
	 </td>
	</tr>
</table>
<div class="right99"></div>
<div class="blueline"></div>
<%--主体table --%>
	<div class="body_div">
	<form action="./property/developer/input.action" method="post">
			 <table width="100%" border="0" align="center" cellpadding="0"
			 	id="input_table" cellspacing="1" class="gbox input_table">
				<tr>
					<td width="90px">&nbsp;&nbsp;<em>*</em>开发商名称</td>
					<td>&nbsp;&nbsp;<input id="developer_name" type="text" name="inputDeveloper.developerName" maxlength="30" style="width: 80%"/></td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;备注</td>
					<td>&nbsp;&nbsp;<input type="text" style="width: 80%" maxlength="50" name="inputDeveloper.remark"/></td>
				</tr>
				<tr>
					<td ></td>
					<td> &nbsp;&nbsp;<input type="submit" value="  新建  " id="submit"/>
					<s:actionmessage cssStyle="color:red"/>
					 </td>
				</tr>
		</table>
		</form>
	</div>
<%--固定的底部 --%>
<s:include value="../../../customer/guangzhou/body_bottom.jsp">
</s:include>
<%--POP --%>
<div id="org_box" class="poppng" style="height:20px; width:250px;
	  position:absolute; display: none;font-size: 12px;padding: 3px; overflow: hidden;"></div>
	</body>
</html>
