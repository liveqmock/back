<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>
	
	<title>模板弹出框</title>

	<s:include value="../../customer/guangzhou/header_min.jsp"></s:include>	  
	
	<link href="./css/unit_table.css"  rel="stylesheet" type="text/css" charset="utf-8"/><!-- unit的样式 -->
	
	
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/unit_table.js"></script>	<!-- unit table -->
	
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>
	<script type="text/javascript" language="javascript" src="<%=basePath%>css/local/easyui-lang-zh_CN.js"></script>
	<link href="./css/easyui.css" rel="stylesheet" type="text/css" charset="utf-8"/>
	<link href="./css/icon.css" rel="stylesheet" type="text/css" charset="utf-8"/>
	<style type="text/css">
		*{margin:0;padding:0;}
	</style>
	</head>
<body>
<div style="float: left;">
		<table  border="0" align="center" cellpadding="0" cellspacing="1" class="gbox unit_table" >
			<tr  bgcolor="#eeeeee" style="line-height: 20px;"> 
				<th width="150" align="left">销售状态</th>
				<th width="150" align="center">套数/比例</th>
				<th width="150" align="center">面积/比例</th>
				<th width="150" align="center">金额/比例</th>
				<th width="150" align="center">户型/比例</th>
			</tr>
			<s:iterator value="unitInfoList" var="c">
				<tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="line-height: 20px;"> 
				<td><div class='sale_state_${c.cls}'></div>${c.name }</td>
				<td align="center">${c.num }/${c.numPer}</td>
				<td align="center">${c.area }/${c.areaPer}</td>
				<td align="center">${c.money }/${c.moneyPer}</td>
				<td align="center" >${c.houseType }/${c.houseTypePer}</td>
				</tr>
			</s:iterator>
		</table>
		</div>
		</body>
		</html>